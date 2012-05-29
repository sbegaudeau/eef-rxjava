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
package org.eclipse.emf.eef.modelingBot.testcase;

import org.eclipse.emf.eef.modelingBot.helper.SWTBotHelper;
import org.eclipse.emf.eef.modelingBot.swtbot.SWTEEFBot;
import org.eclipse.swtbot.eclipse.finder.SWTBotEclipseTestCase;
import org.eclipse.ui.PlatformUI;

/**
 * SwtBot modeling test case with SWTEEFBot.
 * 
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public abstract class AbstractSWTBotModelingBotTestCase extends SWTBotEclipseTestCase {

	/**
	 * An instance of SWTEclipseBot.
	 */
	protected SWTEEFBot bot = new SWTEEFBot();

	/**
	 * {@inheritDoc}
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	public void setUp() throws Exception {
		super.setUp();
		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {

			public void run() {
				PlatformUI.getWorkbench().getWorkbenchWindows()[0].getShell().setFullScreen(true);
			}
		});
		bot.closeWelcomePage();
		bot.openJavaPerspective();
		bot.openPropertiesView();
	}

	@Override
	protected void tearDown() throws Exception {
		// Close an eventual popup if the test failed and a popup remain opened
		bot.closeAllShells();
		SWTBotHelper.waitAllUiEvents();

		bot.closeAllEditors();
		bot.dispose();
		SWTBotHelper.waitAllUiEvents();

		super.tearDown();
	}

	/**
	 * Test method. call <code>bot.runModelingBot("project/path.to/model.modelingbot");</code>
	 * 
	 * @throws Exception
	 *             if any exception is thrown
	 */
	public abstract void testModelingBot() throws Exception;
}
