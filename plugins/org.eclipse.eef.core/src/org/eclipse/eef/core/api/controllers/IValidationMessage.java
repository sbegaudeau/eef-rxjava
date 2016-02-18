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
package org.eclipse.eef.core.api.controllers;

/**
 * The validation messages that can be returned by a controller.
 *
 * @author sbegaudeau
 */
public interface IValidationMessage {
	/**
	 * OK.
	 */
	int OK_TYPE = 0;

	/**
	 * INFO.
	 */
	int INFO_TYPE = 1;

	/**
	 * WARNING.
	 */
	int WARNING_TYPE = 2;

	/**
	 * ERROR.
	 */
	int ERROR_TYPE = 3;

	/**
	 * The key of the message.
	 * 
	 * @return The key of the message
	 */
	Object getKey();

	/**
	 * The text to be displayed to the user.
	 * 
	 * @return The text to be displayed to the user
	 */
	String getMessage();

	/**
	 * The data related to the message.
	 * 
	 * @return The data related to the message or <code>null</code> if not relevant
	 */
	Object getData();

	/**
	 * The type of the message.
	 * 
	 * @return The type of the message
	 */
	int getType();
}
