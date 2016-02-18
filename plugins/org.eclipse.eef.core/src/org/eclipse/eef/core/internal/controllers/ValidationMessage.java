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
package org.eclipse.eef.core.internal.controllers;

import org.eclipse.eef.core.api.controllers.IValidationMessage;

/**
 * A validation message.
 *
 * @author sbegaudeau
 */
public class ValidationMessage implements IValidationMessage {

	/**
	 * The key.
	 */
	private Object key;

	/**
	 * The message.
	 */
	private String message;

	/**
	 * The data.
	 */
	private Object data;

	/**
	 * The type.
	 */
	private int type;

	/**
	 * The constructor.
	 * 
	 * @param key
	 *            The key
	 * @param message
	 *            The message
	 * @param data
	 *            The data
	 * @param type
	 *            The type
	 */
	public ValidationMessage(Object key, String message, Object data, int type) {
		this.key = key;
		this.message = message;
		this.data = data;
		this.type = type;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.eef.core.api.controllers.IValidationMessage#getKey()
	 */
	@Override
	public Object getKey() {
		return this.key;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.eef.core.api.controllers.IValidationMessage#getMessage()
	 */
	@Override
	public String getMessage() {
		return this.message;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.eef.core.api.controllers.IValidationMessage#getData()
	 */
	@Override
	public Object getData() {
		return this.data;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.eef.core.api.controllers.IValidationMessage#getType()
	 */
	@Override
	public int getType() {
		return this.type;
	}

}