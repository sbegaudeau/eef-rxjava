/*******************************************************************************
 * Copyright (c) 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.api.notify;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class EClassifierNotificationFilter extends NotificationFilter {

	private List<EClassifier> eClassifiers;

	public EClassifierNotificationFilter(EClassifier... eClassifiers) {
		super();
		this.eClassifiers = new ArrayList<EClassifier>();
		for (EClassifier eClassifier : eClassifiers) {
			this.eClassifiers.add(eClassifier);
		}
	}

	public List<EClassifier> getEClassifiers() {
		return eClassifiers;
	}
}
