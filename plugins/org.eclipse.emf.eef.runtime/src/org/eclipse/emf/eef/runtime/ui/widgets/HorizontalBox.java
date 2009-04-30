/*******************************************************************************
 * Copyright (c) 2008-2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.ui.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

/**
 * Horizontal box are regular boxes that stack items horizontally.
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class HorizontalBox extends Composite {

	public HorizontalBox(Composite parent) {
		super(parent, SWT.NONE);

		GridLayout layout = new GridLayout();
		layout.marginHeight=2;
		layout.marginWidth=2;
		layout.numColumns = 10;
		layout.makeColumnsEqualWidth=true;
		GridData constraint = new GridData(GridData.FILL_HORIZONTAL);	
		this.setLayout(layout);
		this.setLayoutData(constraint);			
	}
	
}
