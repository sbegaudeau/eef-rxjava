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

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenRuntimeVersion;
import org.eclipse.emf.codegen.ecore.genmodel.impl.Literals;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.emf.codegen.util.ImportManager;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * This class is used to implement some behaviors regarding GenModels that cannot be properly implemented with
 * acceleo alone.
 * 
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 */
public class GenModelWrapper {

	/**
	 * Indicates whether the compliance level of a given GenModel is greater than or equal to JDK 1.5.
	 * 
	 * @param genModel
	 * @return Returns <strong>true</strong> if and only if the compliance level set on the given GenModel is
	 *         >= GenJDKLevel.JDK50.
	 */
	public boolean isJDK50(GenModel genModel) {
		if (genModel != null && genModel.getComplianceLevel() != null)
			return genModel.getComplianceLevel().getValue() >= GenJDKLevel.JDK50;
		return false;
	}

	/**
	 * Indicates whether the runtime version of a given GenModel is greater than or equal to EMF 2.6.
	 * 
	 * @param genModel
	 * @return Returns <strong>true</strong> if and only if the runtime version set on the given GenModel is
	 *         >= GenRuntimeVersion.EMF26_VALUE.
	 */
	public boolean isEMF26(GenModel genModel) {
		if (genModel != null && genModel.getRuntimeVersion() != null)
			return genModel.getRuntimeVersion().getValue() >= GenRuntimeVersion.EMF26_VALUE;
		return false;
	}

	/**
	 * Indicates whether the runtime version of a given GenModel is greater than or equal to EMF 2.5.
	 * 
	 * @param genModel
	 * @return Returns <strong>true</strong> if and only if the runtime version set on the given GenModel is
	 *         >= GenRuntimeVersion.EMF26_VALUE.
	 * @since 1.1
	 */
	public boolean isEMF25(GenModel genModel) {
		if (genModel != null && genModel.getRuntimeVersion() != null)
			return genModel.getRuntimeVersion().getValue() >= GenRuntimeVersion.EMF25_VALUE;
		return false;
	}

	/**
	 * Indicates whether the runtime version of a given GenModel is greater than or equal to EMF 2.4.
	 * 
	 * @param genModel
	 * @return Returns <strong>true</strong> if and only if the runtime version set on the given GenModel is
	 *         >= GenRuntimeVersion.EMF26_VALUE.
	 * @since 1.1
	 */
	public boolean isEMF24(GenModel genModel) {
		if (genModel != null && genModel.getRuntimeVersion() != null)
			return genModel.getRuntimeVersion().getValue() >= GenRuntimeVersion.EMF24_VALUE;
		return false;
	}

	public String getIndentation(GenModel genModel) {
		return genModel.getIndentation(new StringBuffer());
	}

	public String genSortedImports(GenModel genModel) {
		return genModel.getImportManager().computeSortedImports();
	}

	public String genSortedImports(GenClass genClass) {
		return genClass.getGenModel().getImportManager().computeSortedImports();
	}

	/**
	 * Initializing EMF importManager.
	 */
	public void initializeImportManager(GenModel genModel, String packageName, String className) {
		createImportManagerAndSetItTo(genModel, packageName, className);
	}

	private ImportManager createImportManagerAndSetItTo(GenModel genModel, String packageName,
			String className) {
		ImportManager importManager = new ImportManager(packageName, className);
		genModel.setImportManager(importManager);
		return importManager;
	}

	/**
	 * Initializing EMF importManager for a given package, managing java.lang conflicts. Classes whose names
	 * conflict with java.lang classes will be qualified explicitly and not imported.
	 * 
	 * @since 1.1
	 */
	public void initializeImportManager(GenModel genModel, GenPackage genPackage, String packageName,
			String className) {
		ImportManager importManager = createImportManagerAndSetItTo(genModel, packageName, className);
		importManager.addJavaLangImports(genPackage.getJavaLangConflicts());
	}

	public void addImport(GenModel genModel, String qualifiedName) {
		genModel.addImport(qualifiedName);
	}

	public void addPseudoImport(GenModel genModel, String qualifiedName) {
		genModel.addPseudoImport(qualifiedName);
	}

	/**
	 * Wraps method "toStringLiteral" of utility class "Literals".
	 * 
	 * @param genModel
	 * @param literal
	 */
	public String toStringLiteral(GenModel genModel, String literal) {
		return Literals.toStringLiteral(literal, genModel);
	}

	/**
	 * @since 1.1
	 */
	public List<EStructuralFeature> getAllExtendedMetaDataAttributes(GenModel genModel, EClass eClass) {
		return genModel.getExtendedMetaData().getAllAttributes(eClass);
	}

	/**
	 * @since 1.1
	 */
	public List<EStructuralFeature> getAllExtendedMetaDataElements(GenModel genModel, EClass eClass) {
		return genModel.getExtendedMetaData().getAllElements(eClass);
	}

	/**
	 * @since 1.1
	 */
	public String getExtendedMetaDataName(GenModel genModel, EStructuralFeature eFeature) {
		return genModel.getExtendedMetaData().getName(eFeature);
	}

	/**
	 * @since 1.1
	 */
	public String getExtendedMetaDataNamespace(GenModel genModel, EStructuralFeature eFeature) {
		return genModel.getExtendedMetaData().getNamespace(eFeature);
	}

	/**
	 * @since 1.1
	 */
	public String getExtendedMetaDataNamespaceAsLiteral(GenModel genModel, EStructuralFeature eFeature) {
		String result = Literals.toStringLiteral(genModel.getExtendedMetaData().getNamespace(eFeature),
				genModel);
		if ("null".equals(result)) {
			result = "\"\"";
		}
		return result;
	}

	/**
	 * @since 1.1
	 */
	public boolean supportsComposition(GenModel genModel) {
		return genModel.getRuntimeVersion().getValue() >= GenRuntimeVersion.EMF27_VALUE;
	}

	/**
	 * Replaces the invocation of
	 * <code>CodeGenUtil.format(constraint, '_', null, false, false).toUpperCase(genClassifier.getGenModel().getLocale())</code>
	 * 
	 * @param genModel
	 *            The current GenModel, the Locale of which will be used.
	 * @param constraint
	 *            The constraint to format.
	 * @return Returns the formatted constraint suitable for output in EMF code.
	 * @since 1.1
	 */
	public String formatConstraint(GenModel genModel, String constraint) {
		if (constraint != null) {
			return CodeGenUtil.format(constraint, '_', null, false, false).toUpperCase(genModel.getLocale());
		}
		return "";
	}

	/**
	 * Replaces the invocation of <code>CodeGenUtil.upperName(constraint)</code>
	 * 
	 * @param constraint
	 *            The constraint to format.
	 * @return Returns the formatted constraint suitable for output in EMF code.
	 * @since 1.1
	 */
	public String upperNameConstraint(String constraint) {
		return CodeGenUtil.upperName(constraint);
	}
}
