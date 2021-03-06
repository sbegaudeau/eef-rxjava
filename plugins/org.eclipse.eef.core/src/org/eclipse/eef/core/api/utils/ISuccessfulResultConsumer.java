/*******************************************************************************
 * Copyright (c) 2016 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.eef.core.api.utils;

/**
 * This interface will be used to process the result of a successful evaluation of an expression.
 *
 * @param <T>
 *            The type of the result
 *
 * @author sbegaudeau
 */
public interface ISuccessfulResultConsumer<T> {
	/**
	 * Process the value of the result.
	 * 
	 * @param value
	 *            The value
	 */
	void apply(T value);
}
