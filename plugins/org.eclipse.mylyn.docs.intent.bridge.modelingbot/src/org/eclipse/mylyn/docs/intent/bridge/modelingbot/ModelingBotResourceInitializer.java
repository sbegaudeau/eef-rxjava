/*******************************************************************************
 * Copyright (c) 2010, 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.mylyn.docs.intent.bridge.modelingbot;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.modelingBot.ModelingBotFactory;
import org.eclipse.emf.eef.modelingBot.Scenario;
import org.eclipse.mylyn.docs.intent.collab.common.uri.IIntentResourceInitializer;

/**
 * An {@link IIntentResourceInitializer} that create an empty {@link Scenario} for empty modelingbot
 * resources.
 * 
 * @author <a href="mailto:alex.lagarde@obeo.fr">Alex Lagarde</a>
 */
public class ModelingBotResourceInitializer implements IIntentResourceInitializer {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.mylyn.docs.intent.collab.common.uri.IIntentResourceInitializer#getInitialContent(org.eclipse.emf.common.util.URI)
	 */
	public EObject getInitialContent(URI emptyResourceURI) {
		// Create a ModelingBot
		// ModelingBot mBot = ModelingBotFactory.eINSTANCE.createModelingBot();

		// Containing a Scenario
		Scenario scenario = ModelingBotFactory.eINSTANCE.createScenario();
		scenario.setName(emptyResourceURI.trimFileExtension().lastSegment());
		// mBot.getSequences().add(scenario);

		return scenario;
	}
}
