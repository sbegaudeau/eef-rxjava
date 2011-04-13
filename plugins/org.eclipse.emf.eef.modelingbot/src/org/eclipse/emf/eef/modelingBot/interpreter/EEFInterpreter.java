/*******************************************************************************
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
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
import org.eclipse.emf.eef.modelingBot.EEFActions.Cancel;
import org.eclipse.emf.eef.modelingBot.EEFActions.OpenEEFEditor;
import org.eclipse.emf.eef.modelingBot.EEFActions.Remove;
import org.eclipse.emf.eef.modelingBot.EEFActions.SetAttribute;
import org.eclipse.emf.eef.modelingBot.EEFActions.SetReference;
import org.eclipse.emf.eef.modelingBot.EEFActions.Unset;
import org.eclipse.emf.eef.modelingBot.EclipseActions.CloseEditor;
import org.eclipse.emf.eef.modelingBot.EclipseActions.CloseProject;
import org.eclipse.emf.eef.modelingBot.EclipseActions.CreateModel;
import org.eclipse.emf.eef.modelingBot.EclipseActions.CreateProject;
import org.eclipse.emf.eef.modelingBot.EclipseActions.RemoveProject;
import org.eclipse.emf.eef.modelingBot.EclipseActions.Save;
import org.eclipse.emf.eef.modelingBot.swtbot.SWTEEFBot;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;

/**
 * Interpreter for SWTEEFBot and BatchModelingBot.
 * 
 * @author nlepine
 * 
 */
public class EEFInterpreter implements ModelingBotInterpreter{

	/**
	 * Editing domain
	 */
	private EditingDomain editingDomain;
	
	/**
	 * Map ReFerenceableObject -> EObject created
	 */
	private Map<ReferenceableObject, EObject> refObjectToEObject = new HashMap<ReferenceableObject, EObject>();

	/**
	 * Map Sequence -> boolean to know of the sequence has been canceled
	 */
	private Map<Sequence, Boolean> mapSequenceToCancel = new HashMap<Sequence, Boolean>();

	/**
	 * Create the interpreter.
	 * @param editingDomain editing domain
	 */
	public EEFInterpreter(EditingDomain editingDomain) {
		super();
		this.editingDomain = editingDomain;
	}
	
	/**
	 * @return  the map of ReferenceableObject
	 */
	public Map<ReferenceableObject, EObject> getRefObjectToEObject() {
		return refObjectToEObject;
	}

	/**
	 * Set the object corresponding to the referenceable object.
	 * @param refObjectToEObject ReferenceableObject
	 */
	public void setRefObjectToEObject(
			Map<ReferenceableObject, EObject> refObjectToEObject) {
		this.refObjectToEObject = refObjectToEObject;
	}
	
	/**
	 * @param ref ReferenceableObject
	 * @return the object corresponding to the referenceable object
	 */
	public EObject getEObjectFromReferenceableEObject(ReferenceableObject ref) {
		return refObjectToEObject.get(ref);
	}


	/**
	 * Dispose the maps of the interpreter.
	 */
	public void dispose() {
		refObjectToEObject.clear();
		mapSequenceToCancel.clear();
		refObjectToEObject = null;
		mapSequenceToCancel = null;
	}
	
	/**
	 * Get the loaded resource.
	 * @param path path of the model
	 * @return the resource loaded
	 * @throws IOException
	 * @throws CoreException
	 */
	public Resource loadModel(String path) throws IOException, CoreException {
		URI fileURI = URI.createPlatformPluginURI(path, true);
		Resource resource = editingDomain.getResourceSet().getResource(fileURI,
				true);
		assertNotNull("The modeling bot resource can not be loaded.", resource);
		return resource;
	}

	/** 
	 * {@inheritDoc)
	 * @see org.eclipse.emf.eef.modelingBot.interpreter.ModelingBotInterpreter#runModelingBot(java.lang.String, org.eclipse.emf.eef.modelingBot.IModelingBot)
	 */
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

	/**
	 * Interprete a sequence.
	 * @param bot IModelingBot
	 * @param sequence Sequence
	 */
	private void runSequence(IModelingBot bot, Sequence sequence) {
		for (Processing processing : sequence.getProcessings()) {
			if (processing instanceof Action) {
				runAction((Action) processing, bot);
			} else if (processing instanceof DetailsPage) {
				bot.setSequenceType(SequenceType.DETAILS_PAGE);
				runSequence(bot, (DetailsPage) processing);
			} else if (processing instanceof PropertiesView) {
				bot.setSequenceType(SequenceType.PROPERTIES_VIEW);
				runSequence(bot, (PropertiesView) processing);
			} else if (processing instanceof Wizard) {
				bot.setSequenceType(SequenceType.WIZARD);
				runSequence(bot, (Wizard) processing);
				finishBatchEditing(bot, processing);
			}
		}
	}

	/**
	 * Finish batch editinh : ok or cancel.
	 * @param bot
	 * @param processing
	 */
	private void finishBatchEditing(IModelingBot bot, Processing processing) {
		Boolean hasCanceled = mapSequenceToCancel.get(processing);
		if (hasCanceled==null || !hasCanceled) {
			try{
				bot.validateBatchEditing();
			}catch (WidgetNotFoundException e) {
				// Cancel has been done
			}
		}
		mapSequenceToCancel.remove(processing);
	}
	
	/**
	 * Run the modeling bot actions.
	 * @param action Action
	 * @param bot IModelingBot
	 */
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
		} else if (action instanceof SetReference) {
			bot.set(((SetReference) action).getPropertiesEditionElement(), ((SetReference) action).getReferenceableObject(), ((SetReference) action).getEContainingFeature(), ((SetReference) action).getValue());
		} else if (action instanceof Save) {
			bot.save();
		} else if (action instanceof CloseEditor) {
			bot.closeEditor(((CloseEditor) action).getPath());
		} else if (action instanceof CloseProject) {
			bot.closeProject(((CloseProject) action).getProjectName());
		} else if (action instanceof RemoveProject) {
			bot.removeProject(((RemoveProject) action).getProjectName());
		} else if (action instanceof Cancel) {
			mapSequenceToCancel.put((Sequence) action.eContainer(), true);
			bot.cancel();
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
