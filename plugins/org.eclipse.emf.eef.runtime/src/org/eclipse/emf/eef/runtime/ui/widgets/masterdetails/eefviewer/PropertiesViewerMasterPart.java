/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.ui.widgets.masterdetails.eefviewer;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.ui.viewers.PropertiesEditionViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.masterdetails.AbstractEEFMasterPart;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class PropertiesViewerMasterPart extends AbstractEEFMasterPart {

	/**
	 * @param toolkit the toolkit to use to create part widgets
	 * @param container the composite where to create the part
	 */
	public PropertiesViewerMasterPart(FormToolkit toolkit, Composite container) {
		super(toolkit, container);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.ui.widgets.masterdetails.AbstractEEFMasterPart#createSectionClientContents(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 */
	protected StructuredViewer createSectionClientContents(Composite sectionContainer, FormToolkit toolkit) {
		PropertiesEditionViewer viewer = new PropertiesEditionViewer(sectionContainer, null, SWT.NONE, 1);
		viewer.setLabelProvider(new AdapterFactoryLabelProvider(getAdapterFactory()));
		return viewer;
	}

}
