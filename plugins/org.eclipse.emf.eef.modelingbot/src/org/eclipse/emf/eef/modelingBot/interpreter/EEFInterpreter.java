/*******************************************************************************
 * Copyright (c) 2008, 2011 Obeo.
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.components.PropertiesEditionElement;
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
import org.eclipse.emf.eef.modelingBot.EEFActions.EditAction;
import org.eclipse.emf.eef.modelingBot.EEFActions.MoveDown;
import org.eclipse.emf.eef.modelingBot.EEFActions.MoveUp;
import org.eclipse.emf.eef.modelingBot.EEFActions.OpenEEFEditor;
import org.eclipse.emf.eef.modelingBot.EEFActions.Remove;
import org.eclipse.emf.eef.modelingBot.EEFActions.SetAttribute;
import org.eclipse.emf.eef.modelingBot.EEFActions.SetReference;
import org.eclipse.emf.eef.modelingBot.EEFActions.Unset;
import org.eclipse.emf.eef.modelingBot.EEFActions.UnsetAttribute;
import org.eclipse.emf.eef.modelingBot.EEFActions.UnsetReference;
import org.eclipse.emf.eef.modelingBot.EclipseActions.CloseEditor;
import org.eclipse.emf.eef.modelingBot.EclipseActions.CloseProject;
import org.eclipse.emf.eef.modelingBot.EclipseActions.CreateModel;
import org.eclipse.emf.eef.modelingBot.EclipseActions.CreateProject;
import org.eclipse.emf.eef.modelingBot.EclipseActions.OpenEditor;
import org.eclipse.emf.eef.modelingBot.EclipseActions.Redo;
import org.eclipse.emf.eef.modelingBot.EclipseActions.RemoveProject;
import org.eclipse.emf.eef.modelingBot.EclipseActions.Save;
import org.eclipse.emf.eef.modelingBot.EclipseActions.Undo;
import org.eclipse.emf.eef.modelingBot.helper.EEFModelingBotHelper;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;

/**
 * Interpreter for SWTEEFBot or BatchModelingBot.
 * 
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class EEFInterpreter implements IModelingBotInterpreter {

	/**
	 * Editing domain.
	 */
	private EditingDomain editingDomain;

	/**
	 * Map ReFerenceableObject -> EObject created.
	 */
	private Map<ReferenceableObject, EObject> refObjectToEObjectMap = new HashMap<ReferenceableObject, EObject>();

	/**
	 * Map Sequence -> boolean to know if the sequence has been canceled.
	 */
	private Map<Sequence, Boolean> mapSequenceToCancel = new HashMap<Sequence, Boolean>();

	/**
	 * Set Action to know if the action has to be canceled.
	 */
	private Set<PropertiesEditionElement> actionsToCancel = new HashSet<PropertiesEditionElement>();

	/**
	 * Modeling bot.
	 */
	private IModelingBot bot;

	/**
	 * Collection of Actions already processed.
	 */
	private Collection<Action> processedActions = new HashSet<Action>();

	/**
	 * Create the interpreter.
	 * 
	 * @param editingDomain
	 *            editing domain
	 * @param bot
	 *            the modelingbot
	 */
	public EEFInterpreter(IModelingBot bot, EditingDomain editingDomain) {
		super();
		this.editingDomain = editingDomain;
		this.bot = bot;
	}

	/**
	 * @return the map of ReferenceableObject
	 */
	public Map<ReferenceableObject, EObject> getRefObjectToEObject() {
		return refObjectToEObjectMap;
	}

	/**
	 * Set the object corresponding to the referenceable object.
	 * 
	 * @param refObjectToEObject
	 *            ReferenceableObject
	 */
	public void setRefObjectToEObject(Map<ReferenceableObject, EObject> refObjectToEObject) {
		this.refObjectToEObjectMap = refObjectToEObject;
	}

	/**
	 * Returns the referenced object.
	 * 
	 * @param ref
	 *            ReferenceableObject
	 * @return the object corresponding to the referenceable object
	 */
	public EObject getEObjectFromReferenceableEObject(ReferenceableObject ref) {
		return refObjectToEObjectMap.get(ref);
	}

	/**
	 * @return
	 */
	public Set<PropertiesEditionElement> getActionsToCancel() {
		return actionsToCancel;
	}

	public Map<Sequence, Boolean> getMapSequenceToCancel() {
		return mapSequenceToCancel;
	}

	/**
	 * Dispose the maps of the interpreter.
	 */
	public void dispose() {
		refObjectToEObjectMap.clear();
		mapSequenceToCancel.clear();
		refObjectToEObjectMap = null;
		mapSequenceToCancel = null;
	}

	/**
	 * Get the loaded resource.
	 * 
	 * @param path
	 *            path of the model
	 * @return the resource loaded
	 */
	public Resource loadModel(String path) {
		final URI fileURI = URI.createPlatformPluginURI(path, true);
		final Resource resource = editingDomain.getResourceSet().getResource(fileURI, true);
		assertNotNull("The modeling bot resource can not be loaded.", resource);
		return resource;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelingBot.interpreter.IModelingBotInterpreter#runModelingBot(java.lang.String,
	 *      org.eclipse.emf.eef.modelingBot.IModelingBot)
	 */
	public void runModelingBot(String path) throws CoreException, IOException {
		final Resource modelingBotResource = loadModel(path);
		EcoreUtil.resolveAll(modelingBotResource.getResourceSet());
		assertFalse("The modeling bot resource is empty.", modelingBotResource.getContents().isEmpty());
		assertTrue("The modeling bot model contains errors, correct them first", modelingBotResource
				.getErrors().isEmpty());
		List<Scenario> scenarii = new ArrayList<Scenario>();
		EObject root = modelingBotResource.getContents().get(0);
		if (root instanceof ModelingBot) {
			for (Sequence sequence : ((ModelingBot) root).getSequences()) {
				if (sequence instanceof Scenario) {
					scenarii.add((Scenario)sequence);
				}
			}
		} else {
			if (root instanceof Scenario) {
				scenarii.add((Scenario) root);
			}
		}
		final Diagnostic diag = Diagnostician.INSTANCE.validate(root);
		if (diag.getSeverity() != Diagnostic.OK) {
			displayDiag(diag);
		}
		assertTrue("The modeling bot model contains errors, correct them first",
				diag.getSeverity() == Diagnostic.OK);
		for (Scenario sequence : scenarii) {
			final Scenario scenario = (Scenario)sequence;
			runSequence(scenario);
		}
	}

	private void displayDiag(final Diagnostic diag) {
		System.out.println("Source: " + diag.getSource() + " - Message: " + diag.getMessage() + " - Ex:" + diag.getException());
		for (Diagnostic subDiag : diag.getChildren()) {
			displayDiag(subDiag);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelingBot.interpreter.IModelingBotInterpreter#runSequence(org.eclipse.emf.eef.modelingBot.Sequence)
	 */
	public void runSequence(Sequence sequence) {
		preProcessing(sequence);
		for (Processing processing : sequence.getProcessings()) {
			if (processing instanceof Action) {
				runAction((Action)processing);
			} else if (processing instanceof DetailsPage) {
				bot.setSequenceType(SequenceType.DETAILS_PAGE);
				runSequence((DetailsPage)processing);
			} else if (processing instanceof PropertiesView) {
				bot.setSequenceType(SequenceType.PROPERTIES_VIEW);
				runSequence((PropertiesView)processing);
			} else if (processing instanceof Wizard) {
				bot.setSequenceType(SequenceType.WIZARD);
				runSequence((Wizard)processing);
			}

		}
		postProcessing(sequence);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.modelingBot.interpreter.IModelingBotInterpreter#preProcessing(org.eclipse.emf.eef.modelingBot.Sequence)
	 */
	public void preProcessing(Sequence sequence) {
		if (sequence instanceof Wizard) {
			bot.initWizard((Wizard)sequence);			
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.modelingBot.interpreter.IModelingBotInterpreter#postProcessing(org.eclipse.emf.eef.modelingBot.Sequence)
	 */
	public void postProcessing(Sequence sequence) {
		if (sequence instanceof Wizard) {
			final Boolean hasCanceled = mapSequenceToCancel.get(sequence);
			if (hasCanceled == null || !hasCanceled) {
				try {
					bot.validateBatchEditing();
				} catch (WidgetNotFoundException e) {
					// Cancel has been done
				}
			}
			mapSequenceToCancel.remove(sequence);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelingBot.interpreter.IModelingBotInterpreter#runAction(org.eclipse.emf.eef.modelingBot.Action)
	 */
	public void runAction(Action action) {
		if (!processedActions.contains(action)) {

			if (action instanceof EditAction && EEFModelingBotHelper.isFollowingByCancel(action)) {
				actionsToCancel.add(((EditAction)action).getComputedPropertiesEditionElement());
//				if (bot instanceof SWTEEFBot) {
//					processedActions.add(EEFModelingBotHelper.getFollowingCancelAction(action));
//				}
			}
			if (action instanceof CreateProject) {
				bot.createProject(((CreateProject)action).getProjectName());
			} else if (action instanceof OpenEEFEditor) {
				bot.openEEFEditor(((OpenEEFEditor)action).getEditorName());
			} else if (action instanceof OpenEditor) {
				final EObject root = bot.openEditor(((OpenEditor)action).getEditorName());
				for (ReferenceableObject refObj : refObjectToEObjectMap.keySet()) {
					if (refObj instanceof CreateModel) {
						refObjectToEObjectMap.put(refObj, root);
					}
				}
			} else if (action instanceof CreateModel) {
				final EObject addedObject = bot.createModel(((CreateModel)action).getPath(),
						((CreateModel)action).getModelName(), ((CreateModel)action).getComputedRoot());
				addModelMap((CreateModel)action, addedObject);
			} else if (action instanceof Add) {
				PropertiesEditionElement propertiesEditionElement = ((Add)action)
						.getComputedPropertiesEditionElement();
				if (propertiesEditionElement != null) {
					final EObject addedObject = bot.add(propertiesEditionElement,
							((Add)action).getReferenceableObject(), (ReferenceableObject)action,
							((Add)action).getComputedEContainingFeature(), ((Add)action).getComputedType());
					if (addedObject != null) {
						addActionMap((Add)action, addedObject);
					}
				} else {
					final EObject addedObject = bot.add(propertiesEditionElement, null,
							((Add)action).getReferenceableObject(), ((Add)action).getComputedEContainingFeature(),
							((Add)action).getComputedType());
					if (addedObject != null) {
						addActionMap((Add)action, addedObject);
					}
				}
			} else if (action instanceof MoveDown) {
				bot.moveDown(((MoveDown)action).getComputedPropertiesEditionElement(),
						((MoveDown)action).getReferenceableObject());
			} else if (action instanceof MoveUp) {
				bot.moveUp(((MoveUp)action).getComputedPropertiesEditionElement(),
						((MoveUp)action).getReferenceableObject());
			} else if (action instanceof SetAttribute) {
				bot.setAttribute(((SetAttribute)action).getComputedPropertiesEditionElement(),
						((SetAttribute)action).getReferenceableObject(),
						((SetAttribute)action).getComputedEContainingFeature(), ((SetAttribute)action).getValues());
			} else if (action instanceof SetReference) {
				bot.setReference(((SetReference)action).getComputedPropertiesEditionElement(),
						((SetReference)action).getReferenceableObject(),
						((SetReference)action).getEContainingFeature(), ((SetReference)action).getValues());
			} else if (action instanceof Save) {
				bot.save();
			} else if (action instanceof CloseEditor) {
				bot.closeEditor(((CloseEditor)action).getPath());
			} else if (action instanceof CloseProject) {
				bot.closeProject(((CloseProject)action).getProjectName());
			} else if (action instanceof RemoveProject) {
				bot.removeProject(((RemoveProject)action).getProjectName());
			} else if (action instanceof Cancel) {
				Sequence eContainerSequence = (Sequence)action.eContainer();
				mapSequenceToCancel.put(eContainerSequence, true);
				if (eContainerSequence instanceof Wizard || 
						((eContainerSequence instanceof DetailsPage 
								|| eContainerSequence instanceof PropertiesView) && !actionsToCancel.isEmpty())) {					
					bot.cancel(((Cancel)action).getProcessing());
				}
			} else if (action instanceof Unset) {
				bot.unset(((Unset)action).getComputedPropertiesEditionElement(),
						((Unset)action).getReferenceableObject(), ((Unset)action).getFeature());
			} else if (action instanceof UnsetAttribute) {
				bot.unsetAttribute(((UnsetAttribute)action).getComputedPropertiesEditionElement(),
						((UnsetAttribute)action).getReferenceableObject(),
						((UnsetAttribute)action).getEContainingFeature(),
						((UnsetAttribute)action).getValues());
			} else if (action instanceof UnsetReference) {
				bot.unsetReference(((UnsetReference)action).getComputedPropertiesEditionElement(),
						((UnsetReference)action).getReferenceableObject(),
						((UnsetReference)action).getFeature(), ((UnsetReference)action).getValues());
			} else if (action instanceof Remove) {
				bot.remove(((Remove)action).getComputedPropertiesEditionElement(),
						((Remove)action).getReferenceableObject());
				refObjectToEObjectMap.remove(((Remove)action).getReferenceableObject());
			} else if (action instanceof Undo) {
				bot.undo(action);
			} else if (action instanceof Redo) {
				bot.redo(action);
			}
			processedActions.add(action);
		}
	}

	private void addActionMap(ReferenceableObject action, EObject obj) {
		refObjectToEObjectMap.put(action, obj);
	}

	private void addModelMap(CreateModel action, EObject obj) {
		refObjectToEObjectMap.put(action, obj);
	}

}
