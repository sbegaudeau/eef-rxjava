/*******************************************************************************
 * Copyright (c) 2008, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.ui.viewers;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesValidationEditionEvent;
import org.eclipse.swt.widgets.Display;

/**
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 * @author <a href="mailto:mikael.barbero@obeo.fr">Mikaël Barbero</a>
 */
public abstract class PropertiesEditionMessageManager {

	public void processMessage(IPropertiesEditionEvent event) {
		if (event instanceof PropertiesValidationEditionEvent) {
			final Diagnostic diag = ((PropertiesValidationEditionEvent)event).getDiagnostic();
			if (diag != null) {
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						String message = computeMessage(diag);
						if (diag.getSeverity() == Diagnostic.ERROR) {
							updateError(message);
						} else if (diag.getSeverity() == Diagnostic.WARNING) {
							updateWarning(message);
						} else {
							updateStatus(message);
						}
					}
				});
			} else {
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						updateStatus(null);
					}
				});
			}
		}
	}

	protected abstract void updateStatus(final String message);

	protected void updateError(final String message) {
		updateStatus(message);
	}

	protected void updateWarning(final String message) {
		updateStatus(message);
	}

	private String computeMessage(Diagnostic diag) {
		if (diag.getSeverity() == Diagnostic.OK) {
			return "";
		} else {
			for (Diagnostic child : diag.getChildren()) {
				if (child.getSeverity() != Diagnostic.OK) {
					if (child.getChildren().isEmpty()) {
						return child.getMessage();
					}
					return computeMessage(child);
				}
			}
		}
		return diag.getMessage();
	}

}
