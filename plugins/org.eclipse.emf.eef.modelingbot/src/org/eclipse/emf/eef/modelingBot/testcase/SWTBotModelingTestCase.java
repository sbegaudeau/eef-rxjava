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

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.eef.modelingBot.swtbot.SWTEEFBot;
import org.eclipse.emf.eef.modelingBot.utils.SWTBotUtils;
import org.eclipse.swtbot.eclipse.finder.SWTBotEclipseTestCase;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.ui.PlatformUI;
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
        final SWTBotShell[] foundShells = bot.shells();
        for (final SWTBotShell swtBotShell : foundShells) {
            // Close all opened windows except Eclipse
            if (swtBotShell.isOpen() && !swtBotShell.getText().endsWith("Eclipse SDK") && !swtBotShell.getText().endsWith("Eclipse Platform")) {
                swtBotShell.close();
            }
        }

        SWTBotUtils.waitAllUiEvents();

        bot.closeAllEditors();
        bot.dispose();

        SWTBotUtils.waitAllUiEvents();

		super.tearDown();
	}
	
	/**
     * Delete the project.
     * 
     * @param projectName
     *            name of the project to delete.
     */
    public void deleteProject(final String projectName) {
        final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject();
        try {
            if (project.exists())
                project.delete(true, new NullProgressMonitor());
        } catch (final CoreException e) {
            // Propagate as runtime exception
            throw new RuntimeException(e);
        }
    }
	
	public abstract void testModelingBot() throws Exception;
}
