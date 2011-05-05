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

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass.ChildCreationData;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;

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

}
