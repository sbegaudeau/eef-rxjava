/**
 * 
 */
package org.eclipse.emf.eef.codegen.ecore.services;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.codegen.ecore.genmodel.impl.GenModelImpl;
import org.eclipse.emf.codegen.util.CodeGenUtil;

/**
 * this class is used to initialize the proper projects before generating
 * contents on it. Acceleo need to have a destination folder to generates in.
 * 
 * @author sbouchet
 * 
 */
public class Initializer {

	public void initModel(GenModelImpl genModel) throws CoreException, IOException {
		String modelDirectory = genModel.getModelDirectory();
		genModel.setModelDirectory(findOrCreateContainerHelper(modelDirectory));
	}

	public void initEdit(GenModelImpl genModel) throws CoreException, IOException {
		String editDirectory = genModel.getEditDirectory();
		genModel.setEditDirectory(findOrCreateContainerHelper(editDirectory));
	}

	public void initEditor(GenModelImpl genModel) throws CoreException, IOException {
		String editorDirectory = genModel.getEditorDirectory();
		genModel.setEditorDirectory(findOrCreateContainerHelper(editorDirectory));
	}

	public void initTests(GenModelImpl genModel) throws CoreException, IOException {
		String testsDirectory = genModel.getTestsDirectory();
		genModel.setTestsDirectory(findOrCreateContainerHelper(testsDirectory));
	}

	public static String findOrCreateContainerHelper(String encodedPath)
			throws CoreException, IOException {
		IPath path = new Path(encodedPath);
		IPath targetRootDirectory = new Path(path.segment(0));
		targetRootDirectory = new Path(targetRootDirectory.toFile()
				.getAbsoluteFile().getCanonicalPath());

		CodeGenUtil.EclipseUtil.findOrCreateContainer(path,
				true, targetRootDirectory, new NullProgressMonitor());

		return targetRootDirectory.makeAbsolute().toString();

	}
}