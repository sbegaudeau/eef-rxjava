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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Path;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass.ChildCreationData;
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenOperation;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenClassGeneratorAdapter;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.codegen.util.GIFEmitter;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.eef.codegen.ecore.EMFCodegenPlugin;

/**
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 */
public class GenClassWrapper {

	public String getInternalQualifiedInterfaceName(GenClass genClass,
			Boolean includeTemplateArguments) {
		if (genClass.isDynamic()) {
			GenClass baseGenClass = genClass.getBaseGenClass();
			return baseGenClass == null ? "org.eclipse.emf.ecore.EObject"
					: getInternalQualifiedInterfaceName((GenClass) baseGenClass);
		}

		return genClass.getEcoreClass().getInstanceClassName() != null ? includeTemplateArguments ? genClass
				.getEcoreClass().getInstanceTypeName() : genClass
				.getEcoreClass().getInstanceClassName()
				: genClass.getGenPackage().getInterfacePackageName() + "."
						+ genClass.getInterfaceName();
	}

	public String getInternalQualifiedInterfaceName(GenClass genClass) {
		return getInternalQualifiedInterfaceName(
				genClass,
				getEffectiveComplianceLevel(genClass).getValue() >= GenJDKLevel.JDK50);
	}

	protected GenJDKLevel getEffectiveComplianceLevel(GenClass genClass) {
		return genClass.getGenModel().getComplianceLevel();
	}

	public List<?> getChildCreationData(GenClass genClass) {
		return genClass.getChildCreationData();
	}

	public GenFeature getCreateFeature(Object childCreationData) {
		return ((ChildCreationData) childCreationData).createFeature;
	}

	public GenFeature getDelegatedFeature(Object childCreationData) {
		return ((ChildCreationData) childCreationData).delegatedFeature;
	}

	public GenClassifier getCreateClassifier(Object childCreationData) {
		return ((ChildCreationData) childCreationData).createClassifier;
	}

	public String getDefaultOffsetCorrectionField(GenClass genClass) {
		return genClass.getOffsetCorrectionField(null);
	}

	public List<String> getEVirtualIndexBitFields(GenClass genClass) {
		return genClass.getEVirtualIndexBitFields(new ArrayList<String>());
	}

	public List<String> getAllEVirtualIndexBitFields(GenClass genClass) {
		return genClass.getAllEVirtualIndexBitFields(new ArrayList<String>());
	}

	public boolean implementsAnyEInverseAddGenFeatures(GenClass genClass) {
		return genClass.implementsAny(genClass.getEInverseAddGenFeatures());
	}

	public boolean implementsAnyEInverseRemoveGenFeatures(GenClass genClass) {
		return genClass.implementsAny(genClass.getEInverseRemoveGenFeatures());
	}

	public boolean implementsAnyEBasicRemoveFromContainerGenFeatures(
			GenClass genClass) {
		return genClass.implementsAny(genClass
				.getEBasicRemoveFromContainerGenFeatures());
	}

	public boolean implementsAnyEGetGenFeatures(GenClass genClass) {
		return genClass.implementsAny(genClass.getEGetGenFeatures());
	}

	public boolean implementsAnyESetGenFeatures(GenClass genClass) {
		return genClass.implementsAny(genClass.getESetGenFeatures());
	}

	public boolean implementsAnyEUnsetGenFeatures(GenClass genClass) {
		return genClass.implementsAny(genClass.getEUnsetGenFeatures());
	}

	public boolean implementsAnyEIsSetGenFeatures(GenClass genClass) {
		return genClass.implementsAny(genClass.getEIsSetGenFeatures());
	}

	/**
	 * 
	 * @param genClass
	 * @param extendedGenClass
	 * @return
	 */
	public boolean overridesExtendedGenOperations(GenClass genClass,
			GenClass extendedGenClass) {
		return !genClass.getOverrideGenOperations(
				extendedGenClass.getImplementedGenOperations(),
				genClass.getImplementedGenOperations()).isEmpty();
	}

	/**
	 * 
	 * @param genClass
	 * @param extendedGenClass
	 * @return
	 */
	public boolean overridesGenOperations(GenClass genClass) {
		return !genClass.getOverrideGenOperations(
				genClass.getExtendedGenOperations(),
				genClass.getImplementedGenOperations()).isEmpty();
	}

	/**
	 * Remplace l'invocation de
	 * <code>CodeGenUtil.upperName(genClass.getUniqueName(genOperation), genModel.getLocale())</code>
	 * .
	 * 
	 * @param genClass
	 * @param genOperation
	 * @return
	 */
	public String getUniqueNameUppercase(GenClass genClass,
			GenOperation genOperation) {
		return CodeGenUtil.upperName(genClass.getUniqueName(genOperation),
				genClass.getGenModel().getLocale());
	}

	/**
	 * used to wrap icon creation.
	 * 
	 * @see GenClassGeneratorAdapter#generateItemIcon(GenClass, Monitor)
	 * @param genClass
	 */
	public void generateItemIcon(GenClass genClass) {
		if (genClass.isImage()) {
			String inputFile = getClass().getResource("/templates/edit/Item.gif").toString();
			GIFEmitter gifEmitter = new GIFEmitter(inputFile);
			byte[] contents = gifEmitter.generateGIF(genClass.getName(), null);
			Path targetPath = new Path(genClass.getItemIconFileName());
			EMFCodegenPlugin.getDefault().createGIF(contents, targetPath);
		}
	}

	/**
	 * used to wrap icon creation.
	 * 
	 * @see GenClassGeneratorAdapter#generateCreateChildIcons(GenClass, Monitor)
	 * @param genClass
	 */
	public void generateCreateChildIcons(GenClass genClass) {
		GenModel genModel = genClass.getGenModel();
		if (genModel.isCreationCommands() && genModel.isCreationIcons()) {
			for (GenFeature feature : genClass.getCreateChildFeaturesIncludingDelegation()) {
				for (GenClass childClass : genClass.getChildrenClasses(feature)) {
					String inputFile = getClass().getResource("/templates/edit/CreateChild.gif").toString();
					GIFEmitter gifEmitter = new GIFEmitter(inputFile);
					byte[] contents = gifEmitter.generateGIF(genClass.getName(), childClass.getName());
					Path targetPath = new Path(genClass.getCreateChildIconFileName(feature, childClass));
					EMFCodegenPlugin.getDefault().createGIF(contents, targetPath);
				}
			}
		}
	}
}
