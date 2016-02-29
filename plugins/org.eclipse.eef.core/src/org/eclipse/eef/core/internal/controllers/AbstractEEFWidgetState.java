/*******************************************************************************
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.eef.core.internal.controllers;

import org.eclipse.eef.core.api.controllers.IEEFWidgetState;

/**
 * The common superclass of the state of all widgets.
 *
 * @author sbegaudeau
 */
public abstract class AbstractEEFWidgetState implements IEEFWidgetState {
	/**
	 * The label.
	 */
	private String label;

	/**
	 * The help.
	 */
	private String help;

	/**
	 * The constructor.
	 *
	 * @param label
	 *            The label
	 * @param help
	 *            The help
	 */
	public AbstractEEFWidgetState(String label, String help) {
		this.label = label;
		this.help = help;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.eef.core.api.controllers.IEEFWidgetState#getLabel()
	 */
	@Override
	public String getLabel() {
		return this.label;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.eef.core.api.controllers.IEEFWidgetState#getHelp()
	 */
	@Override
	public String getHelp() {
		return this.help;
	}

}
