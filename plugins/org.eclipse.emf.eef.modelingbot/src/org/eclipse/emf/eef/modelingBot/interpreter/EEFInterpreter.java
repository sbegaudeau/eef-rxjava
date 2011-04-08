/**
 * 
 */
package org.eclipse.emf.eef.modelingBot.interpreter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.extended.editor.ReferenceableObject;
import org.eclipse.emf.eef.modelingBot.Action;
import org.eclipse.emf.eef.modelingBot.DetailsPage;
import org.eclipse.emf.eef.modelingBot.IModelingBot;
import org.eclipse.emf.eef.modelingBot.ModelingBot;
import org.eclipse.emf.eef.modelingBot.Processing;
import org.eclipse.emf.eef.modelingBot.PropertiesView;
import org.eclipse.emf.eef.modelingBot.Scenario;
import org.eclipse.emf.eef.modelingBot.Sequence;
import org.eclipse.emf.eef.modelingBot.SequenceType;
import org.eclipse.emf.eef.modelingBot.Wizard;
import org.eclipse.emf.eef.modelingBot.EEFActions.Add;
import org.eclipse.emf.eef.modelingBot.EEFActions.Remove;
import org.eclipse.emf.eef.modelingBot.EEFActions.Unset;
import org.eclipse.emf.eef.modelingBot.EEFActions.EditAction;
import org.eclipse.emf.eef.modelingBot.EEFActions.OpenEEFEditor;
import org.eclipse.emf.eef.modelingBot.EEFActions.SetAttribute;
import org.eclipse.emf.eef.modelingBot.EclipseActions.CreateModel;
import org.eclipse.emf.eef.modelingBot.EclipseActions.Save;
import org.eclipse.emf.eef.modelingBot.EclipseActions.CreateProject;
import org.eclipse.emf.eef.modelingBot.swtbot.SWTEEFBot;

/**
 * @author nlepine
 * 
 */
public class EEFInterpreter implements ModelingBotInterpreter{

	private EditingDomain editingDomain;
	
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

	public EEFInterpreter(EditingDomain editingDomain) {
		super();
		this.editingDomain = editingDomain;
	}

	public Resource loadModel(String path) throws IOException, CoreException {
		URI fileURI = URI.createPlatformPluginURI(path, true);
		Resource resource = editingDomain.getResourceSet().getResource(fileURI,
				true);
		assertNotNull("The modeling bot resource can not be loaded.", resource);
		return resource;
	}

	public void runModelingBot(String path, IModelingBot bot) throws CoreException, IOException {
		Resource modelingBotResource = loadModel(path);
		EcoreUtil.resolveAll(modelingBotResource.getResourceSet());
		assertFalse("The modeling bot resource is empty.", modelingBotResource.getContents().isEmpty());
		ModelingBot mbot = (ModelingBot) modelingBotResource
				.getContents().get(0);
		assertNotNull("The modeling bot resource is empty.", mbot);
		assertTrue("The modeling bot is not a SWTEEFBot.", bot instanceof SWTEEFBot);
		for (Sequence sequence : mbot.getSequences()) {
			if (sequence instanceof Scenario) {
				Scenario scenario = (Scenario) sequence;
				runSequence(bot, scenario);
			}
		}
	}

	private void runSequence(IModelingBot bot, Sequence sequence) {
		for (Processing processing : sequence.getProcessings()) {
			if (processing instanceof Action) {
				runAction((Action) processing, bot);
			} else if (processing instanceof DetailsPage) {
				((SWTEEFBot)bot).setSequenceType(SequenceType.DETAILS_PAGE);
				runSequence(bot, (DetailsPage) processing);
			} else if (processing instanceof PropertiesView) {
				((SWTEEFBot)bot).setSequenceType(SequenceType.PROPERTIES_VIEW);
				runSequence(bot, (PropertiesView) processing);
			} else if (processing instanceof Wizard) {
				((SWTEEFBot)bot).setSequenceType(SequenceType.WIZARD);
				runSequence(bot, (Wizard) processing);
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
		} else if (action instanceof Save) {
			bot.save();
		} else if (action instanceof Unset) {
			bot.unset(((Unset) action).getPropertiesEditionElement(), ((Unset) action).getReferenceableObject(), ((Unset) action).getFeature());
		} else if (action instanceof Remove) {
			bot.remove(((Remove) action).getPropertiesEditionElement(), ((Remove) action).getReferenceableObject());
			refObjectToEObject.remove(((Remove) action).getReferenceableObject());
		} 
	}

	private void addActionMap(ReferenceableObject action, EObject obj) {
		refObjectToEObject.put(action, obj);
	}

	private void addModelMap(CreateModel action,  EObject obj) {
		refObjectToEObject.put(action, obj);
	}

}
