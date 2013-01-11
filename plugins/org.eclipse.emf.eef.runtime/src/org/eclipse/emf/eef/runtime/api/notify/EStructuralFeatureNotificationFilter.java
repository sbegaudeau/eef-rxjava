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

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class EStructuralFeatureNotificationFilter extends NotificationFilter {

	private List<EStructuralFeature> features;

	public EStructuralFeatureNotificationFilter(EStructuralFeature... features) {
		super();
		this.features = new ArrayList<EStructuralFeature>();
		for (EStructuralFeature feature : features) {
			this.features.add(feature);
		}
	}

	public List<EStructuralFeature> getFeatures() {
		return features;
	}

}
