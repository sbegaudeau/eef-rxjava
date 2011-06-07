/*******************************************************************************
 * Copyright (c) 2008, 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - Initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.codegen.ecore.services;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;

/**
 * This class is used to manipulate files.
 * 
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 */
public class FileUtil {

	private static final String MODEL = "model";

	private static final String EDIT = "edit";

	private static final String EDITOR = "editor";

	private static final String TESTS = "tests";

	/**
	 * Indicates if the file matching the given path exists.
	 * 
	 * @param genModel
	 *            The genmodel.
	 * @param filePath
	 *            The file path.
	 * @param generationKind
	 *            The kind of generation (model, edit, editor or test)
	 * @return <code>true</code> if the file exists, <code>false</code> otherwise.
	 */
	public boolean fileExists(GenModel genModel, String filePath, String generationKind) {
		boolean result = false;

		String outputFolder = null;

		if (EDIT.equals(generationKind)) {
			outputFolder = genModel.getEditDirectory();
		} else if (EDITOR.equals(generationKind)) {
			outputFolder = genModel.getEditorDirectory();
		} else if (MODEL.equals(generationKind)) {
			outputFolder = genModel.getModelDirectory();
		} else if (TESTS.equals(generationKind)) {
			outputFolder = genModel.getTestsDirectory();
		}

		if (outputFolder != null) {
			IPath location = ResourcesPlugin.getWorkspace().getRoot().getLocation()
					.append(new Path(outputFolder));
			IContainer iContainer = ResourcesPlugin.getWorkspace().getRoot()
					.getContainerForLocation(location);
			if (iContainer != null && iContainer.exists()) {
				if (iContainer instanceof IProject) {
					result = iContainer.getFile(new Path(filePath)).exists();
				} else {
					result = iContainer.getProject().getFile(new Path(filePath)).exists();
				}
			}
		}

		return result;
	}
}
