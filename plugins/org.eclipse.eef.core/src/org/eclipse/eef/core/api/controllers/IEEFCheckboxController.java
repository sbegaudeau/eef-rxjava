/*******************************************************************************
 * Copyright (c) 2015, 2016 Obeo.
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
 * The EEFCheckboxController is responsible of supporting all the interactions with the widgets created for an
 * EEFCheckboxDescription.
 *
 * @author mbats
 */
public interface IEEFCheckboxController extends IEEFWidgetController {

	/**
	 * Update the value of the checkbox.
	 *
	 * @param checkbox
	 *            The new value of the checkbox
	 */
	void updateValue(boolean checkbox);

	/**
	 * Register a consumer which will be called with the new value of the checkbox when it will change.
	 *
	 * @param consumer
	 *            The consumer of the new value of the checkbox
	 */
	void onNewValue(IConsumer<Boolean> consumer);

	/**
	 * Remove the consumer of the new value of the checkbox.
	 */
	void removeNewValueConsumer();
}
