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
 * $Id$
 */
package org.eclipse.emf.eef.mapping.parts.impl;

// Start of user code for imports

import org.eclipse.emf.eef.mapping.parts.FilterPropertiesPropertiesEditionPart;
import org.eclipse.emf.eef.mapping.parts.MappingViewsRepository;
import org.eclipse.emf.eef.mapping.parts.OCLFilterPropertiesEditionPart;
import org.eclipse.emf.eef.mapping.providers.MappingMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class OCLFilterPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, OCLFilterPropertiesEditionPart {

	protected Text oCLExpressionBody;

	private FilterPropertiesPropertiesEditionPart filterPropertiesPropertiesEditionPart;




	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public OCLFilterPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite)
	 */
	public Composite createFigure(final Composite parent) {
		view = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		
		createControls(view);
		return view;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createControls(org.eclipse.swt.widgets.Composite)
	 */
	public void createControls(Composite view) { 
		createFilterExpressionGroup(view);
		createFilterProperties(view);

		// Start of user code for additional ui definition
		
		// End of user code

	}

	protected void createFilterExpressionGroup(Composite parent) {
		Group filterExpressionGroup = new Group(parent, SWT.NONE);
		filterExpressionGroup.setText(MappingMessages.OCLFilterPropertiesEditionPart_FilterExpressionGroupLabel);
		GridData filterExpressionGroupData = new GridData(GridData.FILL_HORIZONTAL);
		filterExpressionGroupData.horizontalSpan = 3;
		filterExpressionGroup.setLayoutData(filterExpressionGroupData);
		GridLayout filterExpressionGroupLayout = new GridLayout();
		filterExpressionGroupLayout.numColumns = 3;
		filterExpressionGroup.setLayout(filterExpressionGroupLayout);
		createOCLExpressionBodyTextarea(filterExpressionGroup);
	}
	protected void createOCLExpressionBodyTextarea(Composite parent) {
		Label oCLExpressionBodyLabel = SWTUtils.createPartLabel(parent, MappingMessages.OCLFilterPropertiesEditionPart_OCLExpressionBodyLabel, propertiesEditionComponent.isRequired(MappingViewsRepository.OCLFilter.oCLExpressionBody, MappingViewsRepository.SWT_KIND));
		GridData oCLExpressionBodyLabelData = new GridData(GridData.FILL_HORIZONTAL);
		oCLExpressionBodyLabelData.horizontalSpan = 3;
		oCLExpressionBodyLabel.setLayoutData(oCLExpressionBodyLabelData);
		oCLExpressionBody = new Text(parent, SWT.BORDER | SWT.WRAP | SWT.MULTI);
		GridData oCLExpressionBodyData = new GridData(GridData.FILL_HORIZONTAL);
		oCLExpressionBodyData.horizontalSpan = 2;
		oCLExpressionBodyData.heightHint = 80;
		oCLExpressionBody.setLayoutData(oCLExpressionBodyData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MappingViewsRepository.OCLFilter.oCLExpressionBody, MappingViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createFilterProperties(Composite container) {
		IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(MappingViewsRepository.class);
		filterPropertiesPropertiesEditionPart = (FilterPropertiesPropertiesEditionPart)provider.getPropertiesEditionPart(MappingViewsRepository.FilterProperties.class, MappingViewsRepository.SWT_KIND, propertiesEditionComponent);
		((ISWTPropertiesEditionPart)filterPropertiesPropertiesEditionPart).createControls(container);
	}



	public void firePropertiesChanged(PropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.OCLFilterPropertiesEditionPart#getOCLExpressionBody()
	 */
	public String getOCLExpressionBody() {
		return oCLExpressionBody.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.OCLFilterPropertiesEditionPart#setOCLExpressionBody(String newValue)
	 */
	public void setOCLExpressionBody(String newValue) {
		if (newValue != null) {
			oCLExpressionBody.setText(newValue);
		} else {
			oCLExpressionBody.setText("");  //$NON-NLS-1$
		}
	}

	public void setMessageForOCLExpressionBody(String msg, int msgLevel) {

	}

	public void unsetMessageForOCLExpressionBody() {

	}


/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.OCLFilterPropertiesEditionPart#getFilterPropertiesReferencedView()
	 */
		public IPropertiesEditionPart getFilterPropertiesReferencedView() {
			return (IPropertiesEditionPart) filterPropertiesPropertiesEditionPart;
		}
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.OCLFilterPropertiesEditionPart#getName()
	 */
	public String getName() {
		return filterPropertiesPropertiesEditionPart.getName();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.OCLFilterPropertiesEditionPart#setName(String newValue)
	 */
	public void setName(String newValue) {
		filterPropertiesPropertiesEditionPart.setName(newValue);
	}

	public void setMessageForName(String msg, int msgLevel) {
		filterPropertiesPropertiesEditionPart.setMessageForName(msg, msgLevel);
	}

	public void unsetMessageForName() {
		filterPropertiesPropertiesEditionPart.unsetMessageForName();
	}
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.OCLFilterPropertiesEditionPart#getMandatory()
	 */
	public Boolean getMandatory() {
		return filterPropertiesPropertiesEditionPart.getMandatory();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.OCLFilterPropertiesEditionPart#setMandatory(Boolean newValue)
	 */
	public void setMandatory(Boolean newValue) {
		filterPropertiesPropertiesEditionPart.setMandatory(newValue);
	}











	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 */
	public String getTitle() {
		return MappingMessages.OCLFilter_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code

}
