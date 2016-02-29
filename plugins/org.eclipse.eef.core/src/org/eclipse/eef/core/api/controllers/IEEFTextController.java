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

import rx.Observable;

/**
 * The EEFTextController is responsible of supporting all the interactions with the widgets created for an
 * EEFTextDescription.
 *
 * @author sbegaudeau
 */
public interface IEEFTextController extends IEEFWidgetController {

	/**
	 * Update the value of the text.
	 *
	 * @param text
	 *            The new value of the text
	 */
	void updateValue(String text);

	/**
	 * Register a consumer which will be called with the new value of the text when it will change.
	 *
	 * @param consumer
	 *            The consumer of the new value of the text
	 */
	void onNewValue(IConsumer<String> consumer);

	/**
	 * Remove the consumer of the new value of the text.
	 */
	void removeNewValueConsumer();

	/**
	 * Returns the new state of the text widget.
	 * 
	 * @return The new state of the text widget
	 */
	Observable<IEEFTextState> getState();

}
