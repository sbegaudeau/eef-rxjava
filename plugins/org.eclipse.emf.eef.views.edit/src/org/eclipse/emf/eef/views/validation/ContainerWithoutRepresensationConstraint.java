/**
 *  Copyright (c) 2008-2009 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Obeo - initial API and implementation
 * 
 *
 * $Id: ContainerWithoutRepresensationConstraint.java,v 1.1 2009/04/30 17:49:39 nlepine Exp $
 */
package org.eclipse.emf.eef.views.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.views.Container;
import org.eclipse.emf.eef.views.IdentifiedElement;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;


/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class ContainerWithoutRepresensationConstraint extends AbstractModelConstraint {

	public IStatus validate(IValidationContext ctx) {
		EObject eObj = ctx.getTarget();
		EMFEventType eType = ctx.getEventType();
		// In the case of batch mode.
		if (eType == EMFEventType.NULL) {
			if (eObj instanceof Container && eObj.eClass().getName().equals("Container") && ((Container)eObj).getRepresentation() == null) {
				return ctx.createFailureStatus(new Object[] {((Container)eObj).getName(), nearestID(((Container)eObj))});
			}
		}
		
		return ctx.createSuccessStatus();
	}
	
	private String nearestID(Container self) {
		EObject container = self.eContainer();
		while (container != null) {
			if (container instanceof IdentifiedElement)
				return ((IdentifiedElement)container).getQualifiedIdentifier();
		}
		return "";
	}

}
