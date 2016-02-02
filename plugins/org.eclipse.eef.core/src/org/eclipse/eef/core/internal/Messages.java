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
package org.eclipse.eef.core.internal;

import org.eclipse.eef.core.api.utils.I18N;
import org.eclipse.eef.core.api.utils.I18N.TranslatableMessage;

/**
 * Utility class used for the internationalization.
 *
 * @author sbegaudeau
 */
public final class Messages {

	static {
		I18N.initializeMessages(Messages.class, EEFCorePlugin.INSTANCE);
	}

	// CHECKSTYLE:OFF
	@TranslatableMessage
	public static String AbstractEEFWidgetController_InvalidValueForExpression;

	@TranslatableMessage
	public static String EEFTextControllerImpl_BlankEditExpression;

	@TranslatableMessage
	public static String EEFTextControllerImpl_BlankValueExpression;

	@TranslatableMessage
	public static String EEFTextControllerImpl_BlankLabelExpression;

	@TranslatableMessage
	public static String EEFLabelControllerImpl_BlankLabelExpression;

	@TranslatableMessage
	public static String EEFCheckboxControllerImpl_BlankValueExpression;

	@TranslatableMessage
	public static String EEFCheckboxControllerImpl_BlankLabelExpression;

	@TranslatableMessage
	public static String EEFSelectControllerImpl_BlankValueExpression;

	@TranslatableMessage
	public static String EEFSelectControllerImpl_BlankLabelExpression;

	@TranslatableMessage
	public static String EEFSelectControllerImpl_BlankCandidatesExpression;

	// CHECKSTYLE:ON

	/**
	 * The constructor.
	 */
	private Messages() {
		// Prevents instanciation.
	}
}
