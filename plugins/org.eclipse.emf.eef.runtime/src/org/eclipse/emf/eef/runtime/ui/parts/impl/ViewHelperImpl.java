/*******************************************************************************
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/

package org.eclipse.emf.eef.runtime.ui.parts.impl;

import org.eclipse.emf.eef.runtime.ui.parts.ViewHelper;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class ViewHelperImpl implements ViewHelper {

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.ui.parts.ViewHelper#createLabel(org.eclipse.swt.widgets.Composite, java.lang.Object, java.lang.String)
	 */
	public Label createLabel(Composite parent, Object feature, String alternate) {
		return SWTUtils.createPartLabel(parent, getDescription(feature, alternate), false);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.ui.parts.ViewHelper#createHelpButton(org.eclipse.swt.widgets.Composite, java.lang.Object)
	 */
	public Control createHelpButton(Composite parent, Object feature) {
		return SWTUtils.createHelpButton(parent, "", null);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.ui.parts.ViewHelper#getDescription(java.lang.Object, java.lang.String)
	 */
	public String getDescription(Object editor, String alternate) {
		return alternate;
	}

}
