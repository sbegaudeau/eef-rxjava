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

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.eef.modelingBot.IModelingBot;
import org.eclipse.emf.eef.modelingBot.batch.BatchModelingBot;
import org.eclipse.emf.eef.modelingBot.helper.SWTBotHelper;
import org.eclipse.emf.eef.modelingBot.swtbot.ComposedEEFBot;
import org.eclipse.emf.eef.modelingBot.swtbot.SWTEEFBot;
import org.eclipse.swtbot.eclipse.finder.SWTBotEclipseTestCase;
import org.eclipse.ui.PlatformUI;

/**
 * SwtBot modeling test case with SWTEEFBot.
 * 
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public abstract class AbstractComposedModelingBotTestCase extends SWTBotEclipseTestCase {

	/**
	 * An instance of composed bot.
	 */
	protected ComposedEEFBot bot;

	/**
	 * An instance of swt eef bot.
	 */
	private SWTEEFBot swtEEFBot;

	/**
	 * {@inheritDoc}
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	public void setUp() throws Exception {
		super.setUp();
		
		// remove existants projects
		clearWorkspaceProjects();
		File file = ResourcesPlugin.getWorkspace().getRoot().getLocation().toFile();
		if (file.isDirectory()) {
			deleteFolder(file);
		}
		
		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {

			public void run() {
				PlatformUI.getWorkbench().getWorkbenchWindows()[0].getShell().setFullScreen(true);
			}
		});

		final List<IModelingBot> bots = new ArrayList<IModelingBot>(2);
		swtEEFBot = new SWTEEFBot();
		swtEEFBot.closeWelcomePage();
		swtEEFBot.openJavaPerspective();
		swtEEFBot.openPropertiesView();
		final BatchModelingBot batchModeling = new BatchModelingBot();
		bots.add(swtEEFBot);
		bots.add(batchModeling);
		bot = new ComposedEEFBot(bots);
	}

	private void clearWorkspaceProjects() throws CoreException {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		NullProgressMonitor monitor = new NullProgressMonitor();
		root.refreshLocal(IResource.DEPTH_INFINITE, monitor);
		IProject[] projects = root.getProjects();
		for (int i = 0; i < projects.length; i++) {
			projects[i].delete(true, monitor);
		}
	}

	public static void deleteFolder(File folder) {
		File[] files = folder.listFiles();
		if (files != null) { // some JVMs return null for empty dirs
			for (File f : files) {
				if (f.isDirectory()) {
					if (f.getName() != null && f.getName().length() > 0) {
						if (!f.getName().startsWith(".")) {
							deleteFolder(f);
						}
					}
				} else {
					f.delete();
				}
			}
		}
		folder.delete();
	}
	@Override
	protected void tearDown() throws Exception {
		// Close an eventual popup if the test failed and a popup remain opened
		swtEEFBot.closeAllShells();
		SWTBotHelper.waitAllUiEvents();

		swtEEFBot.closeAllEditors();
		swtEEFBot.dispose();
		SWTBotHelper.waitAllUiEvents();

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject[] projects = root.getProjects();
		for (int i = 0; i < projects.length; i++) {
			projects[i].delete(true, new NullProgressMonitor());
		}
		super.tearDown();
	}

	/**
	 * Test method. call <code>bot.runModelingBot("project/path.to/model.modelingbot");</code>
	 * 
	 * @throws Exception if any exception is thrown
	 */
	public abstract void testModelingBot() throws Exception;
}
