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

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenRuntimeVersion;
import org.eclipse.emf.codegen.ecore.genmodel.impl.Literals;
import org.eclipse.emf.codegen.util.ImportManager;

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
	 * Initialise l'importManager utilisé par EMF pour générer les noms des classes, variables, etc en gérant
	 * les imports.
	 * 
	 * @param genClass
	 * @param extendedGenClass
	 * @return
	 */
	public String initializeImportManager(GenModel genModel, String packageName, String className) {
		ImportManager importManager = new ImportManager(packageName, className);
		genModel.setImportManager(importManager);
		return "";
	}

	public String addImport(GenModel genModel, String qualifiedName) {
		genModel.addImport(qualifiedName);
		return "";
	}

	public String addPseudoImport(GenModel genModel, String qualifiedName) {
		genModel.addPseudoImport(qualifiedName);
		return "";
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
}
