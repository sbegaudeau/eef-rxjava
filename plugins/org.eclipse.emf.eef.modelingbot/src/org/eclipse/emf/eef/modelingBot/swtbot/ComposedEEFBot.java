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
package org.eclipse.emf.eef.modelingBot.swtbot;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.EMFCompare.Builder;
import org.eclipse.emf.compare.match.IMatchEngine;
import org.eclipse.emf.compare.match.IMatchEngine.Factory.Registry;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryImpl;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryRegistryImpl;
import org.eclipse.emf.compare.utils.UseIdentifiers;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.components.PropertiesEditionElement;
import org.eclipse.emf.eef.extended.editor.ReferenceableObject;
import org.eclipse.emf.eef.modelingBot.Action;
import org.eclipse.emf.eef.modelingBot.IModelingBot;
import org.eclipse.emf.eef.modelingBot.Processing;
import org.eclipse.emf.eef.modelingBot.SequenceType;
import org.eclipse.emf.eef.modelingBot.Wizard;
import org.eclipse.emf.eef.modelingBot.interpreter.ComposedEEFInterpreter;
import org.eclipse.emf.eef.modelingBot.interpreter.IModelingBotInterpreter;
import org.eclipse.emf.eef.modelingBot.uri.EEFURIConverter;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;

/**
 * Composed eef bot : SWTEEFbot and BatchModeling bot.
 * 
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class ComposedEEFBot implements IModelingBot {

	/**
	 * The ResourceSet where to operate.
	 */
	protected EditingDomain editingDomain = new AdapterFactoryEditingDomain(EEFRuntimePlugin.getDefault()
			.getAdapterFactory(), new BasicCommandStack());

	/**
	 * Composed eef interpreter.
	 */
	private ComposedEEFInterpreter interpreter;

	/**
	 * Bots Collection.
	 */
	private Collection<IModelingBot> bots;

	public ComposedEEFBot(Collection<IModelingBot> bots) {
		super();
		this.bots = bots;
		editingDomain.getResourceSet().setURIConverter(new EEFURIConverter());
		final List<IModelingBot> list = new ArrayList<IModelingBot>();
		list.addAll(bots);
		list.add(this);
		interpreter = new ComposedEEFInterpreter(list, editingDomain);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#runModelingBot(java.lang.String)
	 */
	public void runModelingBot(String path) throws CoreException, IOException {
		interpreter.runModelingBot(path);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#createProject(java.lang.String)
	 */
	public void createProject(String projectName) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#openProject(java.lang.String)
	 */
	public void openProject(String projectName) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#closeProject(java.lang.String)
	 */
	public void closeProject(String projectName) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#removeProject(java.lang.String)
	 */
	public void removeProject(String projectName) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#openPerspective(java.lang.String)
	 */
	public void openPerspective(String name) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#openEEFEditor(java.lang.String)
	 */
	public void openEEFEditor(String path) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#closeEditor(java.lang.String)
	 */
	public void closeEditor(String path) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#save()
	 */
	public void save() {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#add(org.eclipse.emf.eef.components.PropertiesEditionElement,
	 *      org.eclipse.emf.eef.extended.editor.ReferenceableObject, org.eclipse.emf.ecore.EStructuralFeature,
	 *      org.eclipse.emf.ecore.EClass)
	 */
	public EObject add(PropertiesEditionElement propertiesEditionElement,
			ReferenceableObject referenceableObject, EStructuralFeature eContainingFeature, EClass type) {
		// do nothing
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#remove(org.eclipse.emf.eef.components.PropertiesEditionElement,
	 *      org.eclipse.emf.eef.extended.editor.ReferenceableObject)
	 */
	public void remove(PropertiesEditionElement propertiesEditionElement,
			ReferenceableObject referenceableObject) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#setAttribute(org.eclipse.emf.eef.components.PropertiesEditionElement,
	 *      org.eclipse.emf.eef.extended.editor.ReferenceableObject, org.eclipse.emf.ecore.EStructuralFeature,
	 *      java.util.Collection)
	 */
	public void setAttribute(PropertiesEditionElement propertiesEditionElement,
			ReferenceableObject referenceableObject, EStructuralFeature eContainingFeature,
			Collection<String> values) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#setReference(org.eclipse.emf.eef.components.PropertiesEditionElement,
	 *      org.eclipse.emf.eef.extended.editor.ReferenceableObject, org.eclipse.emf.ecore.EStructuralFeature,
	 *      java.util.Collection)
	 */
	public void setReference(PropertiesEditionElement propertiesEditionElement,
			ReferenceableObject referenceableObject, EStructuralFeature eContainingFeature,
			Collection<ReferenceableObject> values) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#unset(org.eclipse.emf.eef.components.PropertiesEditionElement,
	 *      org.eclipse.emf.eef.extended.editor.ReferenceableObject, org.eclipse.emf.ecore.EStructuralFeature)
	 */
	public void unset(PropertiesEditionElement propertiesEditionElement,
			ReferenceableObject referenceableObject, EStructuralFeature eContainingFeature) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#createModel(java.lang.String, java.lang.String,
	 *      org.eclipse.emf.ecore.EClass)
	 */
	public EObject createModel(String path, String modelName, EClass eClass) {
		// do nothing
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#cancel()
	 */
	public void cancel(Processing processing) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#setSequenceType(org.eclipse.emf.eef.modelingBot.SequenceType)
	 */
	public void setSequenceType(SequenceType sequenceType) {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#validateBatchEditing()
	 */
	public void validateBatchEditing() {
		// do nothing
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#check()
	 */
	public void check() {
		for (IModelingBot bot : bots) {
			bot.check();
		}
		for (int i = 0; i < bots.size(); i++) {
			for (int j = i + 1; j < bots.size(); j++) {
				try {
					assertExpectedModelReached(((IModelingBot)bots.toArray()[i]).getActiveResource(),
							((IModelingBot)bots.toArray()[j]).getActiveResource());
				} catch (InterruptedException e) {
					fail("Error during model comparison.");
				}
			}
		}
	}

	public void assertExpectedModelReached(Resource expectedModel, Resource batchModel)
			throws InterruptedException {
		Builder builder = EMFCompare.builder();
		IMatchEngine.Factory matchEngineFactory = new MatchEngineFactoryImpl(UseIdentifiers.NEVER);
		Registry matchEngineFactoryRegistry = MatchEngineFactoryRegistryImpl.createStandaloneInstance();
		matchEngineFactoryRegistry.add(matchEngineFactory);
		builder.setMatchEngineFactoryRegistry(matchEngineFactoryRegistry);
		Comparison compare = builder.build()
				.compare(EMFCompare.createDefaultScope(expectedModel, batchModel));
		EList<Diff> differences = compare.getDifferences();
		if (!differences.isEmpty()) {
			System.out.println(differences);
		}
		assertTrue("The active model isn't the same that the expected model.", differences.isEmpty());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#getActiveResource()
	 */
	public Resource getActiveResource() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#getModelingBotInterpreter()
	 */
	public IModelingBotInterpreter getModelingBotInterpreter() {
		return interpreter;
	}

	public EObject add(PropertiesEditionElement propertiesEditionElement,
			ReferenceableObject referenceableObjectContainer, ReferenceableObject referenceableObject,
			EStructuralFeature eContainingFeature, EClass type) {
		// do nothing
		return null;
	}

	public void unsetAttribute(PropertiesEditionElement propertiesEditionElement,
			ReferenceableObject referenceableObject, EStructuralFeature eContainingFeature,
			Collection<String> values) {
		// do nothing

	}

	public void unsetReference(PropertiesEditionElement propertiesEditionElement,
			ReferenceableObject referenceableObject, EStructuralFeature eContainingFeature,
			Collection<ReferenceableObject> values) {
		// do nothing

	}

	public EObject openEditor(String path) {
		// nothing to do
		return null;
	}

	public void undo(Action action) {
		// do nothing

	}

	public void redo(Action action) {
		// do nothing

	}

	public void initWizard(Wizard wizard) {
		// do nothing

	}

	public void closeWizard(Wizard wizard) {
		// do nothing

	}

	public void moveUp(PropertiesEditionElement propertiesEditionElement,
			ReferenceableObject referenceableObject) {
		// do nothing
	}

	public void moveDown(PropertiesEditionElement propertiesEditionElement,
			ReferenceableObject referenceableObject) {
		// do nothing
	}

}
