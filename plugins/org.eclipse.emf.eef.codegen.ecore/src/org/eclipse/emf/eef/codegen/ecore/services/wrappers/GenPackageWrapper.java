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
package org.eclipse.emf.eef.codegen.ecore.services.wrappers;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.Path;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass.ChildCreationData;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenPackageGeneratorAdapter;
import org.eclipse.emf.codegen.util.GIFEmitter;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.eef.codegen.ecore.EMFCodegenPlugin;

/**
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 */
public class GenPackageWrapper {

	public Set<?> getExtendedChildCreationDataEntrySet(GenPackage genPackage) {
		return genPackage.getExtendedChildCreationData().entrySet();
	}

	public Set<?> getPackageEntryValueEntrySet(Object packageEntry) {
		Map<GenPackage, Map<GenClass, List<ChildCreationData>>> map = (Map<GenPackage, Map<GenClass, List<ChildCreationData>>>)((Map.Entry)packageEntry)
				.getValue();
		return map.entrySet();
	}

	/**
	 * used to wrap icon creation.
	 * 
	 * @see GenPackageGeneratorAdapter#generateCreateChildIcons(GenPackage, Monitor)
	 * @param genPackage
	 */
	public void generateCreateChildIcons(GenPackage genPackage) {
		GenModel genModel = genPackage.getGenModel();
		if (genModel.isCreationCommands() && genModel.isCreationIcons()
				&& genPackage.isChildCreationExtenders()) {
			for (Map.Entry<GenPackage, Map<GenClass, List<GenClass.ChildCreationData>>> packageEntry : genPackage
					.getExtendedChildCreationData().entrySet()) {
				for (Map.Entry<GenClass, List<GenClass.ChildCreationData>> classEntry : packageEntry
						.getValue().entrySet()) {
					GenClass genClass = classEntry.getKey();
					for (GenClass.ChildCreationData childCreationData : classEntry.getValue()) {
						if (childCreationData.createClassifier instanceof GenClass
								&& (childCreationData.delegatedFeature == null || classEntry.getKey()
										.getAllGenFeatures().contains(childCreationData.delegatedFeature))) {
							GenClass childClass = (GenClass)childCreationData.createClassifier;
							GenFeature feature = childCreationData.createFeature;
							String inputFile = getClass().getResource("/templates/edit/CreateChild.gif")
									.toString();
							GIFEmitter gifEmitter = new GIFEmitter(inputFile);
							byte[] contents = gifEmitter
									.generateGIF(genClass.getName(), childClass.getName());
							Path targetPath = new Path(genClass.getCreateChildIconFileName(genModel, feature,
									childClass));
							EMFCodegenPlugin.getDefault().createGIF(contents, targetPath);
						}
					}
				}
			}
		}
	}

}
