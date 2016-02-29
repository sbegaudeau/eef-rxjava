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

import org.eclipse.eef.core.api.controllers.IEEFTextState;

/**
 * The text state.
 *
 * @author sbegaudeau
 */
public class EEFTextState extends AbstractEEFWidgetState implements IEEFTextState {

	/**
	 * The text.
	 */
	private String text;

	/**
	 * The constructor.
	 *
	 * @param text
	 *            The text
	 * @param label
	 *            The label
	 * @param help
	 *            The help
	 */
	public EEFTextState(String text, String label, String help) {
		super(label, help);
		this.text = text;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.eef.core.api.controllers.IEEFTextState#getText()
	 */
	@Override
	public String getText() {
		return this.text;
	}
}
