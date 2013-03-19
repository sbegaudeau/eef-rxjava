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
package org.eclipse.emf.eef.modelingBot.validation;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.eef.modelingBot.Scenario;

/**
 * Utility class providing facilities for validating ModelingBot elements.
 * 
 * @author <a href="mailto:alex.lagarde@obeo.fr">Alex Lagarde</a>
 */
public class ModelingBotValidationUtils {

	/**
	 * Indicates whether a junit test corresponding to the given element exists.
	 * 
	 * @param element
	 *            the element to test (a Scenario or a ModelingBot)
	 * @return true if a junit tests corresponding to the given element exists, false otherwise
	 */
	public static boolean isAssociatedToTest(EObject element) {
		boolean isAssociatedToTest = true;
		URI uri = EcoreUtil.getURI(element);
		if (element instanceof Scenario) {
			isAssociatedToTest = false;
			String projectName = getProjectName(uri);
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
			String expectedPath = getExpectedPath(project, (Scenario)element);
			return project.getFile(expectedPath).exists();
		}
		return isAssociatedToTest;
	}

	/**
	 * Returns the relative path (from the project) that indicates where should be located the junit test of
	 * the given scenario.
	 * 
	 * @param project
	 *            the project helding the scenario
	 * @param scenario
	 *            the scenario to query
	 * @return the relative path (from the project) that indicates where should be located the junit test of
	 *         the given scenario
	 */
	public static String getExpectedPath(IProject project, Scenario scenario) {
		if (project.exists()) {
			String className = scenario.getName().replace(" ", "");
			className = className.substring(0, 1).toUpperCase() + className.substring(1);
			return "src/" + project.getName().replace(".", "/") + "/scenarios/" + className + "Test.java";
		}
		return null;
	}

	/**
	 * Extracts the project name from the given element {@link URI}.
	 * 
	 * @param elementURI
	 *            the element {@link URI}
	 * @return the project name from the given element {@link URI}
	 */
	public static String getProjectName(URI elementURI) {
		return elementURI.toString().replace("platform:/resource/", "").replace("intent:/", "").split("/")[0];
	}
}
