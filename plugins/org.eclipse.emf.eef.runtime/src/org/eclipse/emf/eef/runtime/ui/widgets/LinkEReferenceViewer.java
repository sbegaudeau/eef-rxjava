/*******************************************************************************
 * Copyright (c) 2008, 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.ui.widgets;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.ui.utils.EEFRuntimeUIMessages;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;


/**
 * LinkEObjectFlatComboViewer with possibility to create the referenced element.
 * 
 */
public class LinkEReferenceViewer extends LinkEObjectFlatComboViewer {
	
	/**
	 * Create referenced element button.
	 */
	private Button createButton;
	
	/** Image for the create button */
	protected final org.eclipse.swt.graphics.Image createImage = EEFRuntimePlugin
			.getImage(EEFRuntimePlugin.ICONS_16x16 + "Create_16x16.gif"); //$NON-NLS-1$
	
	
	/**
	 * Constructor from superclass
	 * 
	 * @param dialogTitle
	 * @param input Object
	 * @param filter ViewerFilter
	 * @param adapterFactory AdapterFactory
	 * @param callback EObjectFlatComboViewerListener
	 */
	public LinkEReferenceViewer(String dialogTitle, Object input,
			ViewerFilter filter, AdapterFactory adapterFactory,
			EObjectFlatComboViewerListener callback) {
		super(dialogTitle, input, filter, adapterFactory, callback);
	}
	
	
	/** (non-Javadoc)
	 * @see org.eclipse.emf.eef.runtime.ui.widgets.AbstractAdvancedEObjectFlatComboViewer#createControls(org.eclipse.swt.widgets.Composite)
	 */
	public void createControls(Composite parent) {
		super.createControls(parent);
		
		// add create button
		createButton();
	}


	/**
	 * Add the create button
	 */
	protected void createButton() {
		browseButton.setImage(createImage);
		createButton = super.createButton(composite, "", SWT.PUSH); //$NON-NLS-1$
		createButton.setImage(addImage);
		FormData data = new FormData();
		data.right = new FormAttachment(browseButton, 2);
		data.top = new FormAttachment(0, -2);
		createButton.setLayoutData(data);
		createButton.setToolTipText(EEFRuntimeUIMessages.LinkEReferenceViewer_add_tooltip);
		EditingUtils.setEEFtype(createButton, "eef::LinkEReferenceViewer::createbutton");
		data  = (FormData)valueLink.getLayoutData();
		data.right = new FormAttachment(createButton, 0);
		
		// listeners setting
		createButton.addMouseListener(new MouseAdapter() {
			
			/** (non-Javadoc)
			 * @see org.eclipse.swt.events.MouseAdapter#mouseUp(org.eclipse.swt.events.MouseEvent)
			 */
			public void mouseUp(MouseEvent e) {
				handleCreate();
			}
		});
	}
	
	/** (non-Javadoc)
	 * @see org.eclipse.emf.eef.runtime.ui.widgets.LinkEObjectFlatComboViewer#setID(java.lang.Object)
	 */
	public void setID(Object id) {
		super.setID(id);
		EditingUtils.setID(createButton, id);
	}

	/** (non-Javadoc)
	 * @see org.eclipse.emf.eef.runtime.ui.widgets.LinkEObjectFlatComboViewer#setEnabled(boolean)
	 */
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		createButton.setEnabled(enabled);
	}
	
	/** (non-Javadoc)
	 * @see org.eclipse.emf.eef.runtime.ui.widgets.LinkEObjectFlatComboViewer#isEnabled()
	 */
	public boolean isEnabled() {
		return super.isEnabled() && createButton.isEnabled();
	}

	/** (non-Javadoc)
	 * @see org.eclipse.emf.eef.runtime.ui.widgets.LinkEObjectFlatComboViewer#setToolTipText(java.lang.String)
	 */
	public void setToolTipText(String tooltip) {
		super.setToolTipText(tooltip);
		createButton.setToolTipText(tooltip);
	}


}
