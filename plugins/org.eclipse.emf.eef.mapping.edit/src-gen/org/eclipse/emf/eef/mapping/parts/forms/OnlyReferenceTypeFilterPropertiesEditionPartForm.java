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
package org.eclipse.emf.eef.mapping.parts.forms;

// Start of user code for imports

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IMessageManager;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.events.IExpansionListener;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.events.IExpansionListener;

import org.eclipse.emf.eef.mapping.filters.FiltersPackage;
import org.eclipse.emf.eef.mapping.MappingPackage;
import org.eclipse.emf.eef.mapping.providers.MappingMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.api.parts.EEFMessageManager;
import org.eclipse.emf.eef.mapping.parts.OnlyReferenceTypeFilterPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.emf.ecore.EReference;


import org.eclipse.emf.eef.mapping.parts.MappingViewsRepository;

// End of user code
/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class OnlyReferenceTypeFilterPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, OnlyReferenceTypeFilterPropertiesEditionPart {

	protected EObjectFlatComboViewer referencedFeature;




	
	public OnlyReferenceTypeFilterPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}
	
	public Composite createFigure(final Composite parent, final FormToolkit widgetFactory) {
		ScrolledForm scrolledForm = widgetFactory.createScrolledForm(parent);
		Form form = scrolledForm.getForm();
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(widgetFactory, view, new EEFMessageManager(scrolledForm, widgetFactory));
		return scrolledForm;
	}
	
	public void createControls(final FormToolkit widgetFactory, Composite view, IMessageManager messageManager) {
		this.messageManager = messageManager;
		createPropertiesGroup(widgetFactory, view);
		// Start of user code for additional ui definition
		
		// End of user code		
	}

	protected void createPropertiesGroup(FormToolkit widgetFactory, final Composite view) {
		Section propertiesSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(MappingMessages.OnlyReferenceTypeFilterPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createReferencedFeatureFlatComboViewer(propertiesGroup, widgetFactory);
		propertiesSection.setClient(propertiesGroup);
	}
	/**
	 * @param propertiesGroup
	 */
	protected void createReferencedFeatureFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
	
		FormUtils.createPartLabel(widgetFactory, parent, MappingMessages.OnlyReferenceTypeFilterPropertiesEditionPart_ReferencedFeatureLabel, propertiesEditionComponent.isRequired(MappingViewsRepository.OnlyReferenceTypeFilter.referencedFeature, MappingViewsRepository.FORM_KIND));
		referencedFeature = new EObjectFlatComboViewer(parent, true);
		referencedFeature.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		GridData referencedFeatureData = new GridData(GridData.FILL_HORIZONTAL);
		referencedFeature.setLayoutData(referencedFeatureData);
		referencedFeature.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(OnlyReferenceTypeFilterPropertiesEditionPartForm.this, MappingViewsRepository.OnlyReferenceTypeFilter.referencedFeature, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getReferencedFeature()));
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MappingViewsRepository.OnlyReferenceTypeFilter.referencedFeature, MappingViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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











	
	// Start of user code additional methods
	
	// End of user code
}	
