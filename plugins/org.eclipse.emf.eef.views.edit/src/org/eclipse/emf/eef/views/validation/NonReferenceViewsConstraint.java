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
package org.eclipse.emf.eef.views.validation;

import java.util.Collection;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil.CrossReferencer;
import org.eclipse.emf.eef.views.ElementEditor;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class NonReferenceViewsConstraint extends AbstractModelConstraint {

	private CrossReferencer crossReferencer;

	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();
		crossReferencer = new CrossReferencer(eObj.eResource().getResourceSet()) {
			/** Default SUID. */
			private static final long serialVersionUID = 1L;

			// static initializer
			{
				crossReference();
			}

		};
		// In the case of batch mode.
		if (eType == EMFEventType.NULL) {
			boolean name = true;
			if (eObj instanceof ElementEditor) {
				Collection<Setting> collection = crossReferencer.get(eObj);
				name = collection != null && collection.size() > 0;
			}
			if (!name) {
				return ctx.createFailureStatus(new Object[] {((ElementEditor)eObj).getQualifiedIdentifier()});
			}
		}

		return ctx.createSuccessStatus();
	}

}
