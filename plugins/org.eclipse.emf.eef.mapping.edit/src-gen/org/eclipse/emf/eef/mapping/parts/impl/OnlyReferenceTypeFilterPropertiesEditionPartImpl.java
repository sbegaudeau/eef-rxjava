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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import org.eclipse.emf.eef.mapping.filters.FiltersPackage;
import org.eclipse.emf.eef.mapping.MappingPackage;
import org.eclipse.emf.eef.mapping.providers.MappingMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.mapping.parts.OnlyReferenceTypeFilterPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.emf.ecore.EReference;


import org.eclipse.emf.eef.mapping.parts.MappingViewsRepository;

// End of user code
/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class OnlyReferenceTypeFilterPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, OnlyReferenceTypeFilterPropertiesEditionPart {

	protected EObjectFlatComboViewer referencedFeature;




	
	public OnlyReferenceTypeFilterPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	public Composite createFigure(final Composite parent) {
		view = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		
		createControls(view);
		return view;
	}

	public void createControls(Composite view) { 
		createPropertiesGroup(view);

		// Start of user code for additional ui definition
		
		// End of user code
	}

	protected void createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(MappingMessages.OnlyReferenceTypeFilterPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createReferencedFeatureFlatComboViewer(propertiesGroup);
	}
	/**
	 * @param propertiesGroup
	 */
	protected void createReferencedFeatureFlatComboViewer(Composite parent) {

		SWTUtils.createPartLabel(parent, MappingMessages.OnlyReferenceTypeFilterPropertiesEditionPart_ReferencedFeatureLabel, propertiesEditionComponent.isRequired(MappingViewsRepository.OnlyReferenceTypeFilter.referencedFeature, MappingViewsRepository.SWT_KIND));
		referencedFeature = new EObjectFlatComboViewer(parent, true);
		referencedFeature.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		referencedFeature.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(OnlyReferenceTypeFilterPropertiesEditionPartImpl.this, MappingViewsRepository.OnlyReferenceTypeFilter.referencedFeature, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getReferencedFeature()));
			}

		});
		GridData referencedFeatureData = new GridData(GridData.FILL_HORIZONTAL);
		referencedFeature.setLayoutData(referencedFeatureData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MappingViewsRepository.OnlyReferenceTypeFilter.referencedFeature, MappingViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}


	public void firePropertiesChanged(PropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.OnlyReferenceTypeFilterPropertiesEditionPart#getReferencedFeature()
	 */
	public EObject getReferencedFeature() {
		if (referencedFeature.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) referencedFeature.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.OnlyReferenceTypeFilterPropertiesEditionPart#initReferencedFeature(ResourceSet allResources, EObject current)
	 */
	public void initReferencedFeature(ResourceSet allResources, EObject current) {
		referencedFeature.setInput(allResources);
		if (current != null)
			referencedFeature.setSelection(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.OnlyReferenceTypeFilterPropertiesEditionPart#setReferencedFeature(EObject newValue)
	 */
	public void setReferencedFeature(EObject newValue) {
		if (newValue != null)
			referencedFeature.setSelection(new StructuredSelection(newValue));
		else
			referencedFeature.setSelection(new StructuredSelection("")); //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.OnlyReferenceTypeFilterPropertiesEditionPart#addFilterReferencedFeature(ViewerFilter filter)
	 */
	public void addFilterToReferencedFeature(ViewerFilter filter) {
		referencedFeature.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.filters.parts.OnlyReferenceTypeFilterPropertiesEditionPart#addBusinessFilterReferencedFeature(ViewerFilter filter)
	 */
	public void addBusinessFilterToReferencedFeature(ViewerFilter filter) {
		referencedFeature.addBusinessRuleFilter(filter);
	}

	public void setMessageForReferencedFeature(String msg, int msgLevel) {

	}

	public void unsetMessageForReferencedFeature() {

	}








	// Start of user code additional methods
	
	// End of user code
}
