/**
 * 
 */
package org.eclipse.emf.eef.codegen.flow;

import java.io.IOException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.codegen.EEFCodegenPlugin;
import org.eclipse.emf.eef.codegen.core.util.EMFHelper;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class GenmodelHelper {
	
	private static final String PLATFORM_RESOURCE_SCHEME = "platform:/resource";
	private static final String GENMODEL_EXTENSION = "genmodel";
	
	private IFile ecoreModel;
	private IContainer targetFolder;
	private ResourceSet resourceSet;
	private URI ecoreModelURI;
	private GenModel genmodel;
	private URI genmodelURI;
	
	/**
	 * @param ecoreModel
	 * @param targetFolder
	 */
	public GenmodelHelper(ResourceSet resourceSet, IFile ecoreModel, IContainer targetFolder) {
		this.ecoreModel = ecoreModel;
		this.targetFolder = targetFolder;
		this.resourceSet = resourceSet;
	}
	
	/**
	 * @return the ecoreModel
	 */
	public IFile getEcoreModel() {
		return ecoreModel;
	}
	
	/**
	 * @return the IFile containing the GenModel
	 */
	public IFile getGenModelFile() {
		return targetFolder.getFile(new Path(genmodelFileName()));
	}

	/**
	 * @return the targetFolder
	 */
	public IContainer getTargetFolder() {
		return targetFolder;
	}

	/**
	 * @return the ecoremodelURI
	 */
	public URI ecoreModelURI() {
		return computeEcoreModelURI();
	}
	
	/**
	 * @return the generated genmodel URI.
	 */
	public URI genmodelURI() {
		return computeGenmodelURI();
	}
	
	/**
	 * @return the genmodel
	 */
	public GenModel getGenModel() {
		if (genmodel == null) {
			genmodel = loadGenmodel();
		}
		return genmodel;
	}
	
	/**
	 * Compute the Ecore Model URI for the given ecore file
	 * @param ecoreModel the ecore file
	 * @return the ecore model URI
	 */
	private URI computeEcoreModelURI() {
		if (ecoreModelURI == null) {
			ecoreModelURI = URI.createURI(PLATFORM_RESOURCE_SCHEME + ecoreModel.getFullPath());
		}
		return ecoreModelURI;
	}
	
 	/**
	 * Compute the GenModel URI for the given ecore modelURI
	 * @param ecoreModelURI
	 * @return
	 */
	protected URI computeGenmodelURI() {
		if (genmodelURI == null) {
			genmodelURI = URI.createPlatformResourceURI(targetFolder.getFullPath() + "/" + genmodelFileName(), true);
		}
		return genmodelURI;
	}
	
	/**
	 * @param modelURI
	 * @return
	 */
	public String genmodelFileName() {
		return ecoreModelURI().trimFileExtension().appendFileExtension(GENMODEL_EXTENSION).lastSegment();
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
	
}
