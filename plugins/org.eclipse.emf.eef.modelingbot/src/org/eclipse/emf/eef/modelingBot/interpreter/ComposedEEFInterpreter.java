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
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.components.PropertiesEditionContext;
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
import org.eclipse.emf.eef.modelingBot.EEFActions.Check;
import org.eclipse.emf.eef.modelingBot.swtbot.ComposedEEFBot;

/**
 * Interpreter for a list of modeling bots.
 * 
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class ComposedEEFInterpreter implements IModelingBotInterpreter {

	/**
	 * Editing domain.
	 */
	private EditingDomain editingDomain;

	/**
	 * List of modeling bots.
	 */
	private Collection<IModelingBot> modelingBots = new ArrayList<IModelingBot>();

	/**
	 * Map Bot <-> interpreter.
	 */
	// private Map<IModelingBot, IModelingBotInterpreter>
	// mapModelingBotInterpreter = new HashMap<IModelingBot,
	// IModelingBotInterpreter>();
	/**
	 * ComposedEEFBot.
	 */
	private IModelingBot composedEEFBot;

	/**
	 * Create the interpreter.
	 * 
	 * @param editingDomain
	 *            editing domain
	 */
	public ComposedEEFInterpreter(Collection<IModelingBot> modelingBots, EditingDomain editingDomain) {
		super();
		this.editingDomain = editingDomain;
		initInterpreter(modelingBots);
	}

	private void initInterpreter(Collection<IModelingBot> collection) {
		for (IModelingBot iModelingBot : collection) {
			if (iModelingBot instanceof ComposedEEFBot) {
				this.composedEEFBot = iModelingBot;
			} else {
				this.modelingBots.add(iModelingBot);
			}
		}
	}

	public void dispose() {

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
				setSequenceType(SequenceType.DETAILS_PAGE);
				runSequence((DetailsPage)processing);
			} else if (processing instanceof PropertiesView) {
				setSequenceType(SequenceType.PROPERTIES_VIEW);
				runSequence((PropertiesView)processing);
			} else if (processing instanceof Wizard) {
				setSequenceType(SequenceType.WIZARD);
				runSequence((Wizard)processing);
			}
		}
		postProcessing(sequence);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelingBot.interpreter.IModelingBotInterpreter#preProcessing(org.eclipse.emf.eef.modelingBot.Sequence)
	 */
	public void preProcessing(Sequence sequence) {
		for (IModelingBot iModelingBot : modelingBots) {
			iModelingBot.getModelingBotInterpreter().preProcessing(sequence);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelingBot.interpreter.IModelingBotInterpreter#postProcessing(org.eclipse.emf.eef.modelingBot.Sequence)
	 */
	public void postProcessing(Sequence sequence) {
		for (IModelingBot iModelingBot : modelingBots) {
			iModelingBot.getModelingBotInterpreter().postProcessing(sequence);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.modelingBot.interpreter.IModelingBotInterpreter#runAction(org.eclipse.emf.eef.modelingBot.Action)
	 */
	public void runAction(Action action) {
		for (IModelingBot iModelingBot : modelingBots) {
			if (action instanceof Check) {
				composedEEFBot.check();
			} else {
				iModelingBot.getModelingBotInterpreter().runAction(action);
			}
		}
	}

	private void setSequenceType(SequenceType sequenceType) {
		for (IModelingBot iModelingBot : modelingBots) {
			iModelingBot.setSequenceType(sequenceType);
		}
	}

	/**
	 * Loads the model located at the given uri.
	 * 
	 * @param uri
	 *            the URI of the model to load. By convention, if giving a path (i.e. an URI with no scheme),
	 *            then a platform:/plugins URI will be created
	 * @return a resource containing the loaded model
	 * @throws IOException
	 * @throws CoreException
	 */
	public Resource loadModel(String uri) throws IOException, CoreException {
		URI fileURI = URI.createURI(uri);
		// If the URI does not contains any scheme
		// Then by convention we consider it referecences a model located in platform:/plugins
		if (fileURI.scheme() == null || fileURI.scheme().length() == 0) {
			fileURI = URI.createPlatformPluginURI(uri, true);
		}
		final Resource resource = editingDomain.getResourceSet().getResource(fileURI, true);
		assertNotNull("The modeling bot resource can not be loaded.", resource);
		return resource;
	}

}
