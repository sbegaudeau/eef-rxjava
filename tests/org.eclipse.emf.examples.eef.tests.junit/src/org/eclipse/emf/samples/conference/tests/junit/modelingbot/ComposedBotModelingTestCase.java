package org.eclipse.emf.samples.conference.tests.junit.modelingbot;
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


/**
 * @author nlepine
 *
 */
public class ComposedBotModelingTestCase extends org.eclipse.emf.eef.modelingBot.testcase.ComposedEEFBotModelingTestCase {
	public void testModelingBot() throws Exception {
		composedBot.runModelingBot("test/model/check.modelingbot");
	}
	
}
