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
 * $Id: SimpleModelNavigationPropertiesEditionPartImpl.java,v 1.2 2009/05/05 12:07:30 sbouchet Exp $
 */
package org.eclipse.emf.eef.mapping.parts.impl;

// Start of user code for imports

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.mapping.navigation.NavigationPackage;
import org.eclipse.emf.eef.mapping.navigation.SimpleModelNavigation;
import org.eclipse.emf.eef.mapping.parts.MappingViewsRepository;
import org.eclipse.emf.eef.mapping.parts.SimpleModelNavigationPropertiesEditionPart;
import org.eclipse.emf.eef.mapping.providers.MappingMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

// End of user code
/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class SimpleModelNavigationPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, SimpleModelNavigationPropertiesEditionPart {

	private Text index;
	protected EObjectFlatComboViewer feature;
	protected EObjectFlatComboViewer discriminatorType;




	
	public SimpleModelNavigationPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		propertiesGroup.setText(MappingMessages.SimpleModelNavigationPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createIndexText(propertiesGroup);
		createFeatureFlatComboViewer(propertiesGroup);
		createDiscriminatorTypeFlatComboViewer(propertiesGroup);
	}
	protected void createIndexText(Composite parent) {
		SWTUtils.createPartLabel(parent, MappingMessages.SimpleModelNavigationPropertiesEditionPart_IndexLabel, propertiesEditionComponent.isRequired(MappingViewsRepository.SimpleModelNavigation.index, MappingViewsRepository.SWT_KIND));
		index = new Text(parent, SWT.BORDER);
		GridData indexData = new GridData(GridData.FILL_HORIZONTAL);
		index.setLayoutData(indexData);
		index.addModifyListener(new ModifyListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SimpleModelNavigationPropertiesEditionPartImpl.this, MappingViewsRepository.SimpleModelNavigation.index, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, index.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MappingViewsRepository.SimpleModelNavigation.index, MappingViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	/**
	 * @param propertiesGroup
	 */
	protected void createFeatureFlatComboViewer(Composite parent) {

		SWTUtils.createPartLabel(parent, MappingMessages.SimpleModelNavigationPropertiesEditionPart_FeatureLabel, propertiesEditionComponent.isRequired(MappingViewsRepository.SimpleModelNavigation.feature, MappingViewsRepository.SWT_KIND));
		feature = new EObjectFlatComboViewer(parent, false);
		feature.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		
		// Start of user code for feature filters initialisation

 		// End of user code		
		feature.addFilter(new ViewerFilter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
			 */
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				return (element instanceof EReference);
			}

		});
		feature.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SimpleModelNavigationPropertiesEditionPartImpl.this, MappingViewsRepository.SimpleModelNavigation.feature, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getFeature()));
			}

		});
		GridData featureData = new GridData(GridData.FILL_HORIZONTAL);
		feature.setLayoutData(featureData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MappingViewsRepository.SimpleModelNavigation.feature, MappingViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	/**
	 * @param propertiesGroup
	 */
	protected void createDiscriminatorTypeFlatComboViewer(Composite parent) {

		SWTUtils.createPartLabel(parent, MappingMessages.SimpleModelNavigationPropertiesEditionPart_DiscriminatorTypeLabel, propertiesEditionComponent.isRequired(MappingViewsRepository.SimpleModelNavigation.discriminatorType, MappingViewsRepository.SWT_KIND));
		discriminatorType = new EObjectFlatComboViewer(parent, true);
		discriminatorType.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		
		// Start of user code for discriminatorType filters initialisation

 		// End of user code		
		discriminatorType.addFilter(new ViewerFilter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
			 */
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				return (element instanceof String && element.equals("")) || (element instanceof EClassifier); //$NON-NLS-1$ 
			}

		});
		discriminatorType.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SimpleModelNavigationPropertiesEditionPartImpl.this, MappingViewsRepository.SimpleModelNavigation.discriminatorType, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getDiscriminatorType()));
			}

		});
		GridData discriminatorTypeData = new GridData(GridData.FILL_HORIZONTAL);
		discriminatorType.setLayoutData(discriminatorTypeData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(MappingViewsRepository.SimpleModelNavigation.discriminatorType, MappingViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	
	public void firePropertiesChanged(PropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.SimpleModelNavigationPropertiesEditionPart#getIndex()
	 */
	public String getIndex() {
		return index.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.SimpleModelNavigationPropertiesEditionPart#setIndex(String newValue)
	 */
	public void setIndex(String newValue) {
		index.setText(newValue);
	}

	public void setMessageForIndex(String msg, int msgLevel) {

	}

	public void unsetMessageForIndex() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.SimpleModelNavigationPropertiesEditionPart#getFeature()
	 */
	public EObject getFeature() {
		if (feature.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) feature.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.SimpleModelNavigationPropertiesEditionPart#initFeature(ResourceSet allResources, EObject current)
	 */
	public void initFeature(ResourceSet allResources, EObject current) {
		feature.setInput(allResources);
		if (current != null)
			feature.setSelection(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.SimpleModelNavigationPropertiesEditionPart#setFeature(EObject newValue)
	 */
	public void setFeature(EObject newValue) {
		if (newValue != null)
			feature.setSelection(new StructuredSelection(newValue));
		else
			feature.setSelection(new StructuredSelection("")); //$NON-NLS-1$
	}

	public void setMessageForFeature(String msg, int msgLevel) {

	}

	public void unsetMessageForFeature() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.SimpleModelNavigationPropertiesEditionPart#getDiscriminatorType()
	 */
	public EObject getDiscriminatorType() {
		if (discriminatorType.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) discriminatorType.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.SimpleModelNavigationPropertiesEditionPart#initDiscriminatorType(ResourceSet allResources, EObject current)
	 */
	public void initDiscriminatorType(ResourceSet allResources, EObject current) {
		discriminatorType.setInput(allResources);
		if (current != null)
			discriminatorType.setSelection(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.SimpleModelNavigationPropertiesEditionPart#setDiscriminatorType(EObject newValue)
	 */
	public void setDiscriminatorType(EObject newValue) {
		if (newValue != null)
			discriminatorType.setSelection(new StructuredSelection(newValue));
		else
			discriminatorType.setSelection(new StructuredSelection("")); //$NON-NLS-1$
	}

	public void setMessageForDiscriminatorType(String msg, int msgLevel) {

	}

	public void unsetMessageForDiscriminatorType() {

	}








	// Start of user code additional methods
 	public void setDiscriminatorInput(SimpleModelNavigation simpleModelNavigation, ResourceSet allResources){
		discriminatorType.setInput(EEFUtils.choiceOfValues(adapterFactory, simpleModelNavigation, NavigationPackage.eINSTANCE.getSimpleModelNavigation_DiscriminatorType(), allResources));
		if (simpleModelNavigation.getDiscriminatorType() != null){
			discriminatorType.setSelection(new StructuredSelection(simpleModelNavigation.getDiscriminatorType()));
		}
 	}
	// End of user code
}
