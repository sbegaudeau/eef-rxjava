/**
 * 
 */
package org.eclipse.emf.eef.modelingBot.interpreter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.extended.editor.ReferenceableObject;
import org.eclipse.emf.eef.modelingBot.Action;
import org.eclipse.emf.eef.modelingBot.IModelingBot;
import org.eclipse.emf.eef.modelingBot.ModelingBot;
import org.eclipse.emf.eef.modelingBot.Processing;
import org.eclipse.emf.eef.modelingBot.Scenario;
import org.eclipse.emf.eef.modelingBot.Sequence;
import org.eclipse.emf.eef.modelingBot.EclipseActions.CreateProject;
import org.eclipse.emf.eef.modelingBot.EclipseActions.CreateModel;
import org.eclipse.emf.eef.modelingBot.EEFActions.EditAction;
import org.eclipse.emf.eef.modelingBot.EEFActions.OpenEEFEditor;
import org.eclipse.emf.eef.modelingBot.EEFActions.Add;
import org.eclipse.emf.eef.modelingBot.EEFActions.SetAttribute;
import org.eclipse.emf.eef.modelingBot.swtbot.SWTEEFBot;
import org.eclipse.emf.eef.modelingBot.utils.EEFTestsResourceUtils;

/**
 * @author nlepine
 * 
 */
public class EEFInterpreter implements ModelingBotInterpreter{

	private AdapterFactoryEditingDomain editingDomain;
	
	private Map<ReferenceableObject, EObject> refObjectToEObject = new HashMap<ReferenceableObject, EObject>();

	public Map<ReferenceableObject, EObject> getRefObjectToEObject() {
		return refObjectToEObject;
	}

	public void setRefObjectToEObject(
			Map<ReferenceableObject, EObject> refObjectToEObject) {
		this.refObjectToEObject = refObjectToEObject;
	}
	
	public EObject getEObjectFromReferenceableEObject(ReferenceableObject ref) {
		return refObjectToEObject.get(ref);
	}

	public EEFInterpreter(AdapterFactoryEditingDomain editingDomain) {
		super();
		this.editingDomain = editingDomain;
	}

	private IProject testProject;
	private IFolder modelFolder;

	
	public Resource loadModel(String path) throws IOException, CoreException {
		EEFTestsResourceUtils.importModel("test", path, modelFolder);
		URI fileURI = URI.createPlatformResourceURI("test"+path, true);
		Resource resource = editingDomain.getResourceSet().getResource(fileURI,
				true);
		return resource;
	}

	public void runModelingBot(String path, IModelingBot bot) throws CoreException, IOException {
		ArrayList arrayList = new ArrayList();
		arrayList.add("model");
		testProject = EEFTestsResourceUtils.createTestProject("test", arrayList);
		modelFolder = testProject.getFolder("model");
		Resource modelingBotResource = loadModel(path);
		EcoreUtil.resolveAll(modelingBotResource.getResourceSet());
		for (Resource resource : modelingBotResource.getResourceSet().getResources()) {
			resource.load(null);
		}
		// TODO NLE : check contents of the resource
		ModelingBot mbot = (ModelingBot) modelingBotResource
				.getContents().get(0);
		// load EEFGGen si besoin
		for (Sequence sequence : mbot.getSequences()) {
			if (sequence instanceof Scenario) {
				Scenario scenario = (Scenario) sequence;
				for (Processing processing : scenario.getProcessings()) {
					if (processing instanceof Action) {
						runAction((Action) processing, bot);
					} else if (processing instanceof Sequence) {
						
					}
				}
			}
		}
	}
	
	private void runAction(Action action, IModelingBot bot) {
		if (action instanceof CreateProject) {
			bot.createProject(((CreateProject) action).getProjectName());
		} else if (action instanceof OpenEEFEditor) {
			bot.openEEFEditor(((OpenEEFEditor) action).getEditorName());
		} else if (action instanceof CreateModel) {
			EObject addedObject = bot.createModel(((CreateModel) action).getPath(), ((CreateModel) action).getModelName(), ((CreateModel) action).getRoot());
			addModelMap((CreateModel)action, addedObject);
		} else if (action instanceof Add) {
			EObject addedObject = bot.add(((Add) action).getPropertiesEditionElement(), ((Add) action).getReferenceableObject(), ((Add) action).getEContainingFeature(), ((Add) action).getType());
			addActionMap((Add) action, addedObject);
		} else if (action instanceof SetAttribute) {
			bot.set(((SetAttribute) action).getPropertiesEditionElement(), ((SetAttribute) action).getReferenceableObject(), ((SetAttribute) action).getEContainingFeature(), ((SetAttribute) action).getValue());
		}
	}

	private void addActionMap(EditAction action, EObject obj) {
		refObjectToEObject.put(action, obj);
	}

	private void addModelMap(CreateModel action,  EObject obj) {
		refObjectToEObject.put(action, obj);
//			URI fileURI = URI.createPlatformResourceURI(action.getPath()+"/"+action.getModelName(), true);
//			Resource resource = editingDomain.getResourceSet().getResource(fileURI,
//					true);
//			bot.setTestModelResource(resource);
//			if (!resource.getContents().isEmpty()) {
//				refObjectToEObject.put(action, resource.getContents().get(0));
//			}	
	}

}
