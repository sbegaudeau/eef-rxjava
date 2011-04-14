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
package org.eclipse.emf.eef.modelingBot.testcase;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.eef.modelingBot.IModelingBot;
import org.eclipse.emf.eef.modelingBot.batch.BatchModelingBot;
import org.eclipse.emf.eef.modelingBot.swtbot.ComposedEEFBot;
import org.eclipse.emf.eef.modelingBot.swtbot.SWTEEFBot;
import org.eclipse.emf.eef.modelingBot.utils.SWTBotUtils;
import org.eclipse.swtbot.eclipse.finder.SWTBotEclipseTestCase;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.ui.PlatformUI;
import org.junit.Before;

/**
 * SwtBot modeling test case with SWTEEFBot.
 * 
 * @author nlepine
 *
 */
public abstract class ComposedEEFBotModelingTestCase extends SWTBotEclipseTestCase {
	
	/**
	 * An instance of composed bot.
	 * 
	 */
	protected ComposedEEFBot composedBot;
	/**
	 * An instance of swt eef not.
	 */
	private SWTEEFBot swtEEFBot;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {

            public void run() {
            	PlatformUI.getWorkbench().getWorkbenchWindows()[0].getShell().setFullScreen(true);
            }
        });

		List<IModelingBot> bots = new ArrayList<IModelingBot>(2);
		swtEEFBot = new SWTEEFBot();
		swtEEFBot.closeWelcomePage();
		swtEEFBot.openJavaPerspective();
		swtEEFBot.openPropertiesView();
		BatchModelingBot batchModeling = new BatchModelingBot();
		bots.add(swtEEFBot);
		bots.add(batchModeling);
		composedBot = new ComposedEEFBot(bots);
	}
	
	@Override
	protected void tearDown() throws Exception {
        // Close an eventual popup if the test failed and a popup remain opened
        final SWTBotShell[] foundShells = bot.shells();
        for (final SWTBotShell swtBotShell : foundShells) {
            // Close all opened windows except Eclipse
            if (swtBotShell.isOpen() && !swtBotShell.getText().endsWith("Eclipse SDK") && !swtBotShell.getText().endsWith("Eclipse Platform")) {
                swtBotShell.close();
            }
        }

        SWTBotUtils.waitAllUiEvents();

        swtEEFBot.closeAllEditors();
        swtEEFBot.dispose();

        SWTBotUtils.waitAllUiEvents();

		super.tearDown();
	}
	
	
	/**
	 * Test method : call bot.runModelingBot("test/model/My.modelingbot");
	 * @throws Exception
	 */
	public abstract void testModelingBot() throws Exception;
}
