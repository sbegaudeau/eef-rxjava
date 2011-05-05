/*******************************************************************************
 * Copyright (c) 2002, 2011 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Obeo - Migrate to Acceleo generators
 *******************************************************************************/
package org.eclipse.emf.eef.codegen.ecore.services;

import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * This class emulates an inner class used by EMF for the generation of Package classes.
 * 
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 */
public class InformationIterator {
	Iterator<?> iterator;

	GenModel genModel;

	GenPackage genPackage;

	InformationIterator(EGenericType eGenericType, GenModel genModel, GenPackage genPackage) {
		this.genModel = genModel;
		this.genPackage = genPackage;
		iterator = EcoreUtil.getAllContents(Collections.singleton(eGenericType));
	}

	boolean hasNext() {
		return iterator.hasNext();
	}

	Information next() {
		Information information = new Information();
		EGenericType eGenericType = information.eGenericType = (EGenericType)iterator.next();
		for (EObject container = eGenericType.eContainer(); container instanceof EGenericType; container = container
				.eContainer()) {
			++information.depth;
		}
		if (eGenericType.getEClassifier() != null) {
			GenClassifier genClassifier = genModel.findGenClassifier(eGenericType.getEClassifier());
			information.type = genPackage.getPackageInstanceVariable(genClassifier.getGenPackage()) + ".get"
					+ genClassifier.getClassifierAccessorName() + "()";
		} else if (eGenericType.getETypeParameter() != null) {
			ETypeParameter eTypeParameter = eGenericType.getETypeParameter();
			if (eTypeParameter.eContainer() instanceof EClass) {
				information.type = genModel.findGenClassifier((EClass)eTypeParameter.eContainer())
						.getClassifierInstanceName() + "_" + eGenericType.getETypeParameter().getName();
			} else {
				information.type = "t"
						+ (((EOperation)eTypeParameter.eContainer()).getETypeParameters().indexOf(
								eTypeParameter) + 1);
			}
		} else {
			information.type = "";
		}
		if (information.depth > 0) {
			if (eGenericType.eContainmentFeature().isMany()) {
				information.accessor = "getE" + eGenericType.eContainmentFeature().getName().substring(1)
						+ "().add";
			} else {
				information.accessor = "setE" + eGenericType.eContainmentFeature().getName().substring(1);
			}
		}
		return information;
	}

}
