/**
 * 
 */
package org.eclipse.emf.eef.codegen.flow.impl;

import java.io.IOException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.codegen.EEFCodegenPlugin;
import org.eclipse.emf.eef.codegen.core.util.EMFHelper;
import org.eclipse.emf.eef.codegen.flow.Step;
import org.eclipse.emf.eef.codegen.flow.var.WorkflowVariable;
import org.eclipse.emf.importer.ModelImporter;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class InitializeGenModel extends Step {
	
	/**
	 * The Ecore model file
	 */
	private IFile modelFile;

	/**
	 * Folder where to generate the GenModel
	 */
	private IContainer targetFolder;

	/**
	 * the ecore model uri 
	 */
	private URI ecoreModelURI;
	
	/**
	 * GenModel variable
	 */
	private WorkflowVariable genmodelVar;
	
	/**
	 * GenModel variable
	 */
	private WorkflowVariable genmodelURIVar;
	
	/**
	 * @param name of the step
	 * @param modelURI Ecore model file 
	 * @param targetFolder Folder where to generate the GenModel
	 */
	public InitializeGenModel(String name, IFile modelFile, IContainer targetFolder) {
		super(name);
		this.modelFile = modelFile;
		this.targetFolder = targetFolder;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.codegen.flow.Step#execute(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus execute(IProgressMonitor monitor) {
		try {
			String genmodelFileName = genmodelFileName(computeEcoreModelURI(modelFile));
			BasicMonitor emfMonitor = new BasicMonitor();
			ModelImporter importer = initializeConverter(genmodelFileName, emfMonitor);
			initializeGenModel(importer, emfMonitor);
			((WorkflowVariable)genmodel()).setValue(loadGenmodel());
			((WorkflowVariable)getGenModelURI()).setValue(genmodelURI());
			return Status.OK_STATUS;
		} catch (Exception e) {
			return new Status(IStatus.ERROR, EEFCodegenPlugin.PLUGIN_ID, "An error occured during genmodel initialization", e);
		}
	}


	private final String genmodelVarName() {
		return "INIT_GENMODEL_" + name + "_GENMODEL";
	}
	
	private final String genmodelURIVarName() {
		return "INIT_GENMODEL_" + name + "_GENMODEL_URI";
	}
	
	public Object genmodel() {
		if (genmodelVar == null) {
			genmodelVar = new WorkflowVariable(genmodelVarName());
			getContext().add(genmodelVar);
		}
		return genmodelVar;
	}
	
	/**
	 * @return the created genmodel
	 */
	private GenModel loadGenmodel() {
		try {
			URI genmodelURI = genmodelURI();
			EObject model = EMFHelper.load(genmodelURI, resourceSet);
			if (model instanceof GenModel) {
				return (GenModel) model;
			}
		} catch (IOException e) {
			EEFCodegenPlugin.getDefault().logError(e);
		}
		return null;
	}
	
	/**
	 * @return the ecoremodelURI
	 */
	public URI ecoreModelURI() {
		return computeEcoreModelURI(modelFile);
	}
	
	/**
	 * @return the generated genmodel URI.
	 */
	public Object getGenModelURI() {
		if (genmodelURIVar == null) {
			genmodelURIVar = new WorkflowVariable(genmodelURIVarName());
		}
		return genmodelURIVar;
	}

	/**
	 * @return the generated genmodel URI.
	 */
	public URI genmodelURI() {
		return computeGenmodelURI(computeEcoreModelURI(modelFile));
	}
	
	/**
	/**
	 * Compute the Ecore Model URI for the given ecore file
	 * @param ecoreModel the ecore file
	 * @return the ecore model URI
	 */
	private URI computeEcoreModelURI(IFile ecoreModel) {
		if (ecoreModelURI == null) {
			ecoreModelURI = URI.createURI("platform:/resource" + ecoreModel.getFullPath());
		}
		return ecoreModelURI;
	}
	
 	/**
	 * Compute the GenModel URI for the given ecore modelURI
	 * @param ecoreModelURI
	 * @return
	 */
	protected URI computeGenmodelURI(URI ecoreModelURI) {
		return ecoreModelURI.trimFileExtension().appendFileExtension("genmodel");
	}
	
	/**
	 * @param modelURI
	 * @return
	 */
	private String genmodelFileName(URI modelURI) {
		return computeGenmodelURI(modelURI).lastSegment();
	}

	private ModelImporter initializeConverter(String genmodelFileName, Monitor monitor) throws Exception {
		ModelImporter converter = new org.eclipse.emf.importer.ecore.EcoreImporter();
		converter.setGenModelContainerPath(targetFolder.getFullPath());
		converter.setGenModelFileName(genmodelFileName);
		converter.setModelFile(modelFile);
		converter.computeEPackages(monitor);
		converter.adjustEPackages(monitor);
		return converter;
	}

	protected void initializeGenModel(ModelImporter importer, Monitor monitor) throws Exception {
		importer.prepareGenModelAndEPackages(monitor);
		configureGenModel(importer.getGenModel());
		importer.saveGenModelAndEPackages(monitor);
	}


	protected void configureGenModel(GenModel genModel) { }

}
