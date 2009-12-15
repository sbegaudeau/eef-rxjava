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
import org.eclipse.emf.eef.mapping.parts.JavaExpressionFilterPropertiesEditionPart;
import org.eclipse.emf.eef.mapping.parts.MappingViewsRepository;
import org.eclipse.emf.eef.mapping.providers.MappingMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
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
public class JavaExpressionFilterPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, JavaExpressionFilterPropertiesEditionPart {

	protected Text javaExpressionBody;

	private FilterPropertiesPropertiesEditionPart filterPropertiesPropertiesEditionPart;




	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public JavaExpressionFilterPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
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
	 * 
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
		filterExpressionGroup.setText(MappingMessages.JavaExpressionFilterPropertiesEditionPart_FilterExpressionGroupLabel);
		GridData filterExpressionGroupData = new GridData(GridData.FILL_HORIZONTAL);
		filterExpressionGroupData.horizontalSpan = 3;
		filterExpressionGroup.setLayoutData(filterExpressionGroupData);
		GridLayout filterExpressionGroupLayout = new GridLayout();
		filterExpressionGroupLayout.numColumns = 3;
		filterExpressionGroup.setLayout(filterExpressionGroupLayout);
		createJavaExpressionBodyTextarea(filterExpressionGroup);
	}

	protected void createJavaExpressionBodyTextarea(Composite parent) {
		Label javaExpressionBodyLabel = SWTUtils.createPartLabel(parent, MappingMessages.JavaExpressionFilterPropertiesEditionPart_JavaExpressionBodyLabel, propertiesEditionComponent.isRequired(MappingViewsRepository.JavaExpressionFilter.javaExpressionBody, MappingViewsRepository.SWT_KIND));
		GridData javaExpressionBodyLabelData = new GridData(GridData.FILL_HORIZONTAL);
		javaExpressionBodyLabelData.horizontalSpan = 3;
		javaExpressionBodyLabel.setLayoutData(javaExpressionBodyLabelData);
		javaExpressionBody = new Text(parent, SWT.BORDER | SWT.WRAP | SWT.MULTI | SWT.V_SCROLL);
		GridData javaExpressionBodyData = new GridData(GridData.FILL_HORIZONTAL);
		javaExpressionBodyData.horizontalSpan = 2;
		javaExpressionBodyData.heightHint = 80;
		javaExpressionBody.setLayoutData(javaExpressionBodyData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MappingViewsRepository.JavaExpressionFilter.javaExpressionBody, MappingViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	protected void createFilterProperties(Composite container) {
		IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(MappingViewsRepository.class);
		filterPropertiesPropertiesEditionPart = (FilterPropertiesPropertiesEditionPart)provider.getPropertiesEditionPart(MappingViewsRepository.FilterProperties.class, MappingViewsRepository.SWT_KIND, propertiesEditionComponent);
		((ISWTPropertiesEditionPart)filterPropertiesPropertiesEditionPart).createControls(container);
	}




	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.JavaExpressionFilterPropertiesEditionPart#getJavaExpressionBody()
	 */
	public String getJavaExpressionBody() {
		return javaExpressionBody.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.JavaExpressionFilterPropertiesEditionPart#setJavaExpressionBody(String newValue)
	 */
	public void setJavaExpressionBody(String newValue) {
		if (newValue != null) {
			javaExpressionBody.setText(newValue);
		} else {
			javaExpressionBody.setText("");  //$NON-NLS-1$
		}
	}

	public void setMessageForJavaExpressionBody(String msg, int msgLevel) {

	}

	public void unsetMessageForJavaExpressionBody() {

	}


/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.JavaExpressionFilterPropertiesEditionPart#getFilterPropertiesReferencedView()
	 */
		public IPropertiesEditionPart getFilterPropertiesReferencedView() {
			return (IPropertiesEditionPart) filterPropertiesPropertiesEditionPart;
		}
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.JavaExpressionFilterPropertiesEditionPart#getName()
	 */
	public String getName() {
		return filterPropertiesPropertiesEditionPart.getName();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.JavaExpressionFilterPropertiesEditionPart#setName(String newValue)
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
	 * @see org.eclipse.emf.eef.filters.parts.JavaExpressionFilterPropertiesEditionPart#getMandatory()
	 */
	public Boolean getMandatory() {
		return filterPropertiesPropertiesEditionPart.getMandatory();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.JavaExpressionFilterPropertiesEditionPart#setMandatory(Boolean newValue)
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
		return MappingMessages.JavaExpressionFilter_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code

}
