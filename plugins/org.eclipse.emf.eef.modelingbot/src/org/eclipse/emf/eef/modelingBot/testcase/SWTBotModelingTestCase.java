package org.eclipse.emf.eef.modelingBot.testcase;
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

import org.eclipse.emf.eef.modelingBot.swtbot.SWTEEFBot;
import org.eclipse.swtbot.eclipse.finder.SWTBotEclipseTestCase;
import org.junit.Before;

/**
 * @author nlepine
 *
 */
public abstract class SWTBotModelingTestCase extends SWTBotEclipseTestCase {
	
	/**
	 * An instance of SWTEclipseBot.
	 * 
	 */
	protected SWTEEFBot bot = new SWTEEFBot();

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
		bot.closeWelcomePage();
		bot.openJavaPerspective();
		bot.openPropertiesView();
	}
	
	@Override
	protected void tearDown() throws Exception {
//		bot.closeAllShells();
		super.tearDown();
	}
	
	public abstract void testModelingBot() throws Exception;
}
