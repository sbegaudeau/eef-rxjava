/*******************************************************************************
 * Copyright (c) 2008, 2009 Obeo.
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

/**
 * @author <a href="mailto:sbouchet@obeo.fr">sbouchet</a>
 *
 */
public abstract class PropertiesEditionMessageManager {
	
	private Diagnostic oldFailedDiagnostic = null;

	private Object oldFailedEvent = null;

	public void processMessage(IPropertiesEditionEvent event) {
		if (event instanceof PropertiesValidationEditionEvent) {
			Diagnostic diag = ((PropertiesValidationEditionEvent)event).getDiagnostic();
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {
				updateStatus(computeMessage(diag));
			} else {
					updateStatus(null);
			}
		}
	}

	protected abstract void updateStatus(final String message);
	
	private String computeMessage(Diagnostic diag) {
		for (Diagnostic child : diag.getChildren()) {
			if (child.getSeverity() != Diagnostic.OK) {
				if (child.getChildren().isEmpty()) {
					return child.getMessage();
				}
				return computeMessage(child);
			}
		}
		return diag.getMessage();
	}


}
