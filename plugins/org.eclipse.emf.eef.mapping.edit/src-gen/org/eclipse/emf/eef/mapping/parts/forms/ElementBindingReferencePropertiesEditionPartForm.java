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
 * $Id: ElementBindingReferencePropertiesEditionPartForm.java,v 1.13 2009/07/31 14:10:32 glefur Exp $
 */
package org.eclipse.emf.eef.mapping.parts.forms;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.mapping.parts.ElementBindingReferencePropertiesEditionPart;
import org.eclipse.emf.eef.mapping.parts.MappingViewsRepository;
import org.eclipse.emf.eef.mapping.providers.MappingMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.EEFMessageManager;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IMessageManager;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class ElementBindingReferencePropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, ElementBindingReferencePropertiesEditionPart {

	protected EObjectFlatComboViewer binding;




	
	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public ElementBindingReferencePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 */
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
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 * 			createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.IMessageManager)
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view, IMessageManager messageManager) {
		this.messageManager = messageManager;
		createReferenceGroup(widgetFactory, view);
		// Start of user code for additional ui definition
		
		// End of user code
		
	}

	protected void createReferenceGroup(FormToolkit widgetFactory, final Composite view) {
		Section referenceSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		referenceSection.setText(MappingMessages.ElementBindingReferencePropertiesEditionPart_ReferenceGroupLabel);
		GridData referenceSectionData = new GridData(GridData.FILL_HORIZONTAL);
		referenceSectionData.horizontalSpan = 3;
		referenceSection.setLayoutData(referenceSectionData);
		Composite referenceGroup = widgetFactory.createComposite(referenceSection);
		GridLayout referenceGroupLayout = new GridLayout();
		referenceGroupLayout.numColumns = 3;
		referenceGroup.setLayout(referenceGroupLayout);
		createBindingFlatComboViewer(referenceGroup, widgetFactory);
		referenceSection.setClient(referenceGroup);
	}
	/**
	 * @param referenceGroup
	 */
	protected void createBindingFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		FormUtils.createPartLabel(widgetFactory, parent, MappingMessages.ElementBindingReferencePropertiesEditionPart_BindingLabel, propertiesEditionComponent.isRequired(MappingViewsRepository.ElementBindingReference.binding, MappingViewsRepository.FORM_KIND));
		binding = new EObjectFlatComboViewer(parent, false);
		binding.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData bindingData = new GridData(GridData.FILL_HORIZONTAL);
		binding.setLayoutData(bindingData);
		binding.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ElementBindingReferencePropertiesEditionPartForm.this, MappingViewsRepository.ElementBindingReference.binding, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getBinding()));
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MappingViewsRepository.ElementBindingReference.binding, MappingViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	
	public void firePropertiesChanged(PropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// Nothing to do
		// End of user code
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.ElementBindingReferencePropertiesEditionPart#getBinding()
	 */
	public EObject getBinding() {
		if (binding.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) binding.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.ElementBindingReferencePropertiesEditionPart#initBinding(ResourceSet allResources, EObject current)
	 */
	public void initBinding(ResourceSet allResources, EObject current) {
		binding.setInput(allResources);
		if (current != null) {
			binding.setSelection(new StructuredSelection(current));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.ElementBindingReferencePropertiesEditionPart#setBinding(EObject newValue)
	 */
	public void setBinding(EObject newValue) {
		if (newValue != null) {
			binding.setSelection(new StructuredSelection(newValue));
		} else {
			binding.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.ElementBindingReferencePropertiesEditionPart#setBindingButtonMode(ButtonsModeEnum newValue)
	 */
	public void setBindingButtonMode(ButtonsModeEnum newValue) {
		binding.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.ElementBindingReferencePropertiesEditionPart#addFilterBinding(ViewerFilter filter)
	 */
	public void addFilterToBinding(ViewerFilter filter) {
		binding.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.ElementBindingReferencePropertiesEditionPart#addBusinessFilterBinding(ViewerFilter filter)
	 */
	public void addBusinessFilterToBinding(ViewerFilter filter) {
		binding.addBusinessRuleFilter(filter);
	}











	
	// Start of user code additional methods
 	
	// End of user code

}	
