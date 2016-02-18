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
import org.eclipse.emf.common.util.Diagnostic;

/**
 * This class is used to build an {@link IValidationMessage}.
 *
 * @author sbegaudeau
 */
public final class ValidationMessageBuilder {

	/**
	 * The constructor.
	 */
	private ValidationMessageBuilder() {
		// prevent instantiation
	}

	/**
	 * Computes an {@link IValidationMessage} from the given {@link Diagnostic}.
	 *
	 * @param diagnostic
	 *            The diagnostic
	 * @return The {@link IValidationMessage}
	 */
	public static IValidationMessage of(Diagnostic diagnostic) {
		Object key = diagnostic.getSource();
		String message = diagnostic.getMessage();
		// TODO [SBE][Validation] TO BE REMOVED LATER!!
		message = "Luke, I am your father"; //$NON-NLS-1$
		Object data = diagnostic;
		int type = getType(diagnostic);
		type = IValidationMessage.WARNING_TYPE;
		return new ValidationMessage(key, message, data, type);
	}

	/**
	 * Computes the type of the {@link IValidationMessage} from the severity of the {@link Diagnostic}.
	 *
	 * @param diagnostic
	 *            The diagnostic
	 * @return The type of the validation message
	 */
	private static int getType(Diagnostic diagnostic) {
		int type = IValidationMessage.OK_TYPE;

		switch (diagnostic.getSeverity()) {
		case Diagnostic.INFO:
			type = IValidationMessage.INFO_TYPE;
			break;
		case Diagnostic.WARNING:
			type = IValidationMessage.WARNING_TYPE;
			break;
		case Diagnostic.ERROR:
			type = IValidationMessage.ERROR_TYPE;
			break;
		case Diagnostic.CANCEL:
			type = IValidationMessage.ERROR_TYPE;
			break;
		default:
			type = IValidationMessage.OK_TYPE;
			break;
		}
		return type;
	}
}
