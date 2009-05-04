/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.ui.utils;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class EcoreTool {

	/**
	 * @param eObject
	 *            the element to check
	 * @return true if the given element match or contains a matching element
	 */
	public static boolean containsInstanceOfEClass(EObject element, EClass eClassToCheck) {
		// Check type and super type matching
		if (isInstanceOfEClass(element, eClassToCheck)) {
			return true;
		}
		// Check containment
		for (EObject container : element.eContents()) {
			if (containsInstanceOfEClass(container, eClassToCheck)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param eObject
	 *            the element to check
	 * @return true if the given element match or contains a matching element
	 */
	public static boolean isInstanceOfEClass(EObject element, EClass eClassToCheck) {
		// Check type and super type matching
		EClass eClass = element.eClass();
		if (eClass.equals(eClassToCheck)) {
			return true;
		} else {
			for (EClass eSuperClass : eClass.getEAllSuperTypes()) {
				if (eSuperClass.equals(eClassToCheck)) {
					return true;
				}
			}
		}
		return false;
	}

}
