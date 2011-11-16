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

import org.eclipse.emf.codegen.ecore.genmodel.GenDataType;

/**
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 * @since 1.1
 */
public class GenDataTypeWrapper {

	protected String getValueForDigits(GenDataType genDataType) {
		String value = "1";
		for (int digitCount = genDataType.getTotalDigits(); digitCount > 0; --digitCount)
			value += "0";
		return value;
	}

	public String getStaticPositiveValue(GenDataType genDataType) {
		return genDataType.getStaticValue(getValueForDigits(genDataType));
	}

	public String getStaticNegativeValue(GenDataType genDataType) {
		return genDataType.getStaticValue("-" + getValueForDigits(genDataType));
	}
}
