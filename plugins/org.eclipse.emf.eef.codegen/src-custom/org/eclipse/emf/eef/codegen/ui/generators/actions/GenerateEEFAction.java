/*******************************************************************************
 * Copyright (c) 2008, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.codegen.ui.generators.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.eef.EEFGen.EEFGenModel;
import org.eclipse.emf.eef.EEFGen.EEFGenModelReference;
import org.eclipse.emf.eef.EEFGen.GenEditionContext;
import org.eclipse.emf.eef.EEFGen.GenViewsRepository;
import org.eclipse.emf.eef.codegen.EEFCodegenPlugin;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class GenerateEEFAction extends AbstractGenerateEEFAction {

	/**
	 * Constructor for Action1.
	 */
	public GenerateEEFAction() {
		super();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.codegen.ui.generators.actions.AbstractGenerateEEFAction#initEEFGenModel()
	 */
	protected List<EEFGenModel> initEEFGenModel() throws IOException {
		List<EEFGenModel> eefgenmodels = new ArrayList<EEFGenModel>(selectedFiles.size());
		if (!selectedFiles.isEmpty()) {
			for (IFile selectedFile : selectedFiles) {
				ResourceSet resourceSet = new ResourceSetImpl();
				URI modelURI = URI.createPlatformResourceURI(selectedFile.getFullPath().toString(), true);
				String fileExtension = modelURI.fileExtension();
				if (fileExtension == null || fileExtension.length() == 0) {
					fileExtension = Resource.Factory.Registry.DEFAULT_EXTENSION;
				}
				final Resource.Factory.Registry registry = Resource.Factory.Registry.INSTANCE;
				final Object resourceFactory = registry.getExtensionToFactoryMap().get(fileExtension);
				if (resourceFactory != null) {
					resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
							.put(fileExtension, resourceFactory);
				} else {
					resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
							.put(fileExtension, new XMIResourceFactoryImpl());
				}
				Resource res = resourceSet.createResource(modelURI);
				res.load(Collections.EMPTY_MAP);
				EcoreUtil.resolveAll(resourceSet);
				if (res.getContents().size() > 0) {
					EObject object = res.getContents().get(0);
					if (object instanceof EEFGenModel) {
						eefgenmodels.add((EEFGenModel)object);
					}
				}
			}
		}
		// validate eefgenmodels and components recursively
		return validateEEFGenmodels(eefgenmodels);
	}

	/**
	 * @param eefgenmodels
	 * @return
	 * @since 2.0
	 */
	private List<EEFGenModel> validateEEFGenmodels(List<EEFGenModel> eefgenmodels) {
		List<EEFGenModel> eefModels = new ArrayList<EEFGenModel>(eefgenmodels.size());
		eefModels.addAll(eefgenmodels);
		for (EEFGenModel eefGenModel : eefgenmodels) {
			if (!validateOneEEFGenModel(eefGenModel))
				eefModels.remove(eefGenModel);
			// validate also referenced EEFGenModels
			if (!validateReferencedEEFGenModels(eefGenModel))
				eefModels.remove(eefGenModel);
		}
		return eefModels;
	}

	/**
	 * @param eefGenModel
	 */
	private boolean validateReferencedEEFGenModels(EEFGenModel eefGenModel) {
		for (EEFGenModelReference eefGenModelReference : eefGenModel.getReferences()) {
			EEFGenModel referencedEEFGenModel = eefGenModelReference.getReferencedContext();
			if (!validateOneEEFGenModel(referencedEEFGenModel))
				return false;
			return validateReferencedEEFGenModels(referencedEEFGenModel);
		}
		return true;
	}

	/**
	 * @param eefGenModel
	 * @return
	 * @since 2.0
	 */
	private boolean validateOneEEFGenModel(EEFGenModel eefGenModel) {
		// validate eefgenmodels
		final Diagnostic diag = Diagnostician.INSTANCE.validate(eefGenModel);
		if (diag.getSeverity() != Diagnostic.OK) {
			Status status = new Status(diag.getSeverity(), EEFCodegenPlugin.PLUGIN_ID, "EEFGenmodel '"
					+ eefGenModel.eResource().getURI() + "' contains errors.");
			EEFCodegenPlugin.getDefault().getLog().log(status);
			return false;
		}
		// validate PropertiesEditionContext
		for (GenEditionContext genEditionContext : eefGenModel.getEditionContexts()) {
			final Diagnostic diag2 = Diagnostician.INSTANCE.validate(genEditionContext
					.getPropertiesEditionContext());
			if (diag2.getSeverity() != Diagnostic.OK) {
				Status status = new Status(diag2.getSeverity(), EEFCodegenPlugin.PLUGIN_ID,
						"PropertiesEditionContext '"
								+ genEditionContext.getPropertiesEditionContext().eResource().getURI()
								+ "' contains errors.");
				EEFCodegenPlugin.getDefault().getLog().log(status);
				return false;
			}
		}
		// validate ViewsRepository
		for (GenViewsRepository genViewsRepository : eefGenModel.getViewsRepositories()) {
			final Diagnostic diag2 = Diagnostician.INSTANCE.validate(genViewsRepository.getViewsRepository());
			if (diag2.getSeverity() != Diagnostic.OK) {
				Status status = new Status(diag2.getSeverity(), EEFCodegenPlugin.PLUGIN_ID,
						"ViewsRepository '" + genViewsRepository.getViewsRepository().eResource().getURI()
								+ "' contains errors.");
				EEFCodegenPlugin.getDefault().getLog().log(status);
				return false;
			}
		}
		return true;
	}
}
