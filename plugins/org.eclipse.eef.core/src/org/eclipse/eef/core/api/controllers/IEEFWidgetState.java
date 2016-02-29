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
 * The state of the widget.
 *
 * @author sbegaudeau
 */
public interface IEEFWidgetState {
	/**
	 * The label.
	 *
	 * @return the label
	 */
	String getLabel();

	/**
	 * The help.
	 *
	 * @return the help
	 */
	String getHelp();

}
