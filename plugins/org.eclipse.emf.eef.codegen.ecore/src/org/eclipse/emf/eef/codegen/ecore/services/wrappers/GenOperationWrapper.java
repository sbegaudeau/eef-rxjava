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

import org.eclipse.emf.codegen.ecore.genmodel.GenOperation;

/**
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 * @since 1.1
 */
public class GenOperationWrapper {

	private boolean firstPrefix = true;

	public String prefix(GenOperation genOperation) {
		if (firstPrefix) {
			firstPrefix = false;
			return genOperation.getGenModel().getImportedName("org.eclipse.emf.ecore.EOperation") + " op = ";
		}
		return "op = ";
	}

	public void resetGenOperationPrefix() {
		firstPrefix = true;
	}
}
