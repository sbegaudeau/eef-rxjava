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

import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;

/**
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 * @since 1.1
 */
public class GenClassifierWrapper {

	public int getIndexOfFirstConstraintDifferentFromNoCircular(GenClassifier genClassifier) {
		int index = 0;
		List<String> constraints = genClassifier.getAllGenConstraints();
		if (constraints != null) {
			for (int i = 0; i < constraints.size(); i++) {
				String constraint = constraints.get(i);
				if (!"NoCircularContainment".equals(constraint)) {
					index = ++i; // OCL indexes start at 1 instead of 0
					break;
				}
			}
		}
		return index;
	}
}
