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
package org.eclipse.emf.eef.codegen.ecore.services.wrappers;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.Path;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass.ChildCreationData;
import org.eclipse.emf.codegen.ecore.genmodel.GenEnum;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenOperation;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenTypeParameter;
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
	 * @since 1.1
	 */
	public String getDefaultClassUniqueName(GenPackage genPackage) {
		return genPackage.getClassUniqueName(null);
	}

	public List<?> getClassEntryChildCreationData(Object classEntry) {
		if (classEntry instanceof Map.Entry<?, ?>) {
			return (List<?>)((Map.Entry)classEntry).getValue();
		}
		return null;
	}

	public GenPackage getPackageEntryKey(Object packageEntry) {
		if (packageEntry instanceof Map.Entry<?, ?>) {
			return (GenPackage)((Map.Entry)packageEntry).getKey();
		}
		return null;
	}

	public GenClass getClassEntryKey(Object classEntry) {
		if (classEntry instanceof Map.Entry<?, ?>) {
			return (GenClass)((Map.Entry)classEntry).getKey();
		}
		return null;
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

	/**
	 * used to wrap icon creation.
	 * 
	 * @see GenPackageGeneratorAdapter#generateModelIcon(GenPackage, Monitor)
	 * @param genPackage
	 */
	public void generateModelIcon(GenPackage genPackage) {
		if (genPackage.hasConcreteClasses()) {
			String inputFile = getClass().getResource("/templates/editor/ModelFile.gif").toString();
			GIFEmitter gifEmitter = new GIFEmitter(inputFile);
			byte[] contents = gifEmitter.generateGIF(genPackage.getPrefix(), null);
			Path targetPath = new Path(genPackage.getModelIconFileName());
			EMFCodegenPlugin.getDefault().createGIF(contents, targetPath);
		}
	}

	/**
	 * used to wrap icon creation.
	 * 
	 * @see GenPackageGeneratorAdapter#generateModelWizardIcon(GenPackage, Monitor)
	 * @param genPackage
	 */
	public void generateModelWizardIcon(GenPackage genPackage) {
		if (genPackage.hasConcreteClasses() && genPackage.isGenerateModelWizard()) {
			String inputFile = getClass().getResource("/templates/editor/NewModel.gif").toString();
			GIFEmitter gifEmitter = new GIFEmitter(inputFile);
			byte[] contents = gifEmitter.generateGIF(genPackage.getPrefix(), null);
			Path targetPath = new Path(genPackage.getModelWizardIconFileName());
			EMFCodegenPlugin.getDefault().createGIF(contents, targetPath);
		}
	}

	/**
	 * Indicates whether the given GenPackage represents the XMLTypePackage.
	 * 
	 * @param genPackage
	 * @return
	 * @since 1.1
	 */
	public boolean isXMLTypePackage(GenPackage genPackage) {
		return org.eclipse.emf.ecore.xml.type.XMLTypePackage.eNS_URI.equals(genPackage.getNSURI());
	}

	private boolean needsAddEOperation = false;

	private boolean needsAddEParameter = false;

	/**
	 * @since 1.1
	 */
	public void requireAddEOperation(GenPackage genPackage) {
		needsAddEOperation = true;
	}

	/**
	 * @since 1.1
	 */
	public void requireAddEParameter(GenPackage genPackage) {
		needsAddEParameter = true;
	}

	/**
	 * @since 1.1
	 */
	public boolean needsAddEOperation(GenPackage genPackage) {
		return needsAddEOperation;
	}

	/**
	 * @since 1.1
	 */
	public boolean needsAddEParameter(GenPackage genPackage) {
		return needsAddEParameter;
	}

	/**
	 * Counter to reproduce the way EMF manages generic types.
	 */
	private int maxGenericTypeAssignment = 0;

	/**
	 * @since 1.1
	 */
	public void resetMaxGenericTypeAssignment() {
		maxGenericTypeAssignment = 0;
	}

	/**
	 * @since 1.1
	 */
	public String prefix(GenPackage genPackage, int depth) {
		String prefix = "";
		if (maxGenericTypeAssignment <= depth) {
			++maxGenericTypeAssignment;
			prefix = genPackage.getGenModel().getImportedName("org.eclipse.emf.ecore.EGenericType") + " ";
		}
		return prefix;
	}

	private boolean firstPrefix = true;

	/**
	 * @since 1.1
	 */
	public String prefix(GenOperation genOperation) {
		if (firstPrefix) {
			firstPrefix = false;
			return genOperation.getGenModel().getImportedName("org.eclipse.emf.ecore.EOperation") + " op = ";
		}
		return "op = ";
	}

	/**
	 * @since 1.1
	 */
	public void resetGenOperationPrefix() {
		firstPrefix = true;
	}

	/**
	 * @since 1.1
	 */
	public String typePrefix(GenPackage genPackage, int depth) {
		String typePrefix = "";
		if (maxGenericTypeAssignment <= depth) {
			++maxGenericTypeAssignment;
			typePrefix = genPackage.getGenModel().getImportedName("org.eclipse.emf.ecore.EGenericType") + " ";
		}
		return typePrefix;
	}

	/**
	 * @since 1.1
	 */
	public String computeSwitchGenericTypeName(GenPackage genPackage) {
		Set<String> usedNames = new HashSet<String>();
		for (GenEnum genEnum : genPackage.getGenEnums()) {
			usedNames.add(genEnum.getName());
		}
		for (GenClass genClass : genPackage.getAllSwitchGenClasses()) {
			if (!genClass.isDynamic() && !genClass.isExternalInterface()) {
				usedNames.add(genClass.getName());
			}
			for (GenTypeParameter genTypeParameter : genClass.getGenTypeParameters()) {
				usedNames.add(genTypeParameter.getName());
			}
		}
		String templateParameterName = "T";
		for (int i = 1; usedNames.contains(templateParameterName); ++i) {
			templateParameterName = "T" + i;
		}
		return templateParameterName;
	}
}
