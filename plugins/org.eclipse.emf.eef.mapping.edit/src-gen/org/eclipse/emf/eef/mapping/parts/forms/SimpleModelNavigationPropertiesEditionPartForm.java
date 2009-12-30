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
 * $Id: SimpleModelNavigationPropertiesEditionPartForm.java,v 1.17 2009/12/30 16:41:02 nlepine Exp $
 */
package org.eclipse.emf.eef.mapping.parts.forms;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.mapping.navigation.NavigationPackage;
import org.eclipse.emf.eef.mapping.navigation.SimpleModelNavigation;
import org.eclipse.emf.eef.mapping.parts.MappingViewsRepository;
import org.eclipse.emf.eef.mapping.parts.SimpleModelNavigationPropertiesEditionPart;
import org.eclipse.emf.eef.mapping.providers.MappingMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class SimpleModelNavigationPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, SimpleModelNavigationPropertiesEditionPart {

	protected Text index;
	protected EObjectFlatComboViewer feature;
	protected EObjectFlatComboViewer discriminatorType;





	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public SimpleModelNavigationPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 */
	public Composite createFigure(final Composite parent, final FormToolkit widgetFactory) {
		ScrolledForm scrolledForm = widgetFactory.createScrolledForm(parent);
		Form form = scrolledForm.getForm();
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(widgetFactory, view);
		return scrolledForm;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		this.messageManager = messageManager;
		createPropertiesGroup(widgetFactory, view);

		// Start of user code for additional ui definition
		
		// End of user code
	}
	protected void createPropertiesGroup(FormToolkit widgetFactory, final Composite view) {
		Section propertiesSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(MappingMessages.SimpleModelNavigationPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createIndexText(widgetFactory, propertiesGroup);
		createFeatureFlatComboViewer(propertiesGroup, widgetFactory);
		createDiscriminatorTypeFlatComboViewer(propertiesGroup, widgetFactory);
		propertiesSection.setClient(propertiesGroup);
	}

	protected void createIndexText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, MappingMessages.SimpleModelNavigationPropertiesEditionPart_IndexLabel, propertiesEditionComponent.isRequired(MappingViewsRepository.SimpleModelNavigation.index, MappingViewsRepository.FORM_KIND));
		index = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		index.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData indexData = new GridData(GridData.FILL_HORIZONTAL);
		index.setLayoutData(indexData);
		index.addModifyListener(new ModifyListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SimpleModelNavigationPropertiesEditionPartForm.this, MappingViewsRepository.SimpleModelNavigation.index, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, index.getText()));
			}

		});
		index.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SimpleModelNavigationPropertiesEditionPartForm.this, MappingViewsRepository.SimpleModelNavigation.index, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, index.getText()));
			}

		});
		index.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 */
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SimpleModelNavigationPropertiesEditionPartForm.this, MappingViewsRepository.SimpleModelNavigation.index, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, index.getText()));
				}
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MappingViewsRepository.SimpleModelNavigation.index, MappingViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	/**
	 * @param propertiesGroup
	 */
	protected void createFeatureFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		FormUtils.createPartLabel(widgetFactory, parent, MappingMessages.SimpleModelNavigationPropertiesEditionPart_FeatureLabel, propertiesEditionComponent.isRequired(MappingViewsRepository.SimpleModelNavigation.feature, MappingViewsRepository.FORM_KIND));
		feature = new EObjectFlatComboViewer(parent, false);
		feature.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData featureData = new GridData(GridData.FILL_HORIZONTAL);
		feature.setLayoutData(featureData);
		feature.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SimpleModelNavigationPropertiesEditionPartForm.this, MappingViewsRepository.SimpleModelNavigation.feature, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getFeature()));
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MappingViewsRepository.SimpleModelNavigation.feature, MappingViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	/**
	 * @param propertiesGroup
	 */
	protected void createDiscriminatorTypeFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		FormUtils.createPartLabel(widgetFactory, parent, MappingMessages.SimpleModelNavigationPropertiesEditionPart_DiscriminatorTypeLabel, propertiesEditionComponent.isRequired(MappingViewsRepository.SimpleModelNavigation.discriminatorType, MappingViewsRepository.FORM_KIND));
		discriminatorType = new EObjectFlatComboViewer(parent, true);
		discriminatorType.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData discriminatorTypeData = new GridData(GridData.FILL_HORIZONTAL);
		discriminatorType.setLayoutData(discriminatorTypeData);
		discriminatorType.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SimpleModelNavigationPropertiesEditionPartForm.this, MappingViewsRepository.SimpleModelNavigation.discriminatorType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getDiscriminatorType()));
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MappingViewsRepository.SimpleModelNavigation.discriminatorType, MappingViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
		if (newValue != null) {
			index.setText(newValue);
		} else {
			index.setText(""); //$NON-NLS-1$
		}
	}

	public void setMessageForIndex(String msg, int msgLevel) {
		messageManager.addMessage("Index_key", msg, null, msgLevel, index);
	}

	public void unsetMessageForIndex() {
		messageManager.removeMessage("Index_key", index);
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
		if (current != null) {
			feature.setSelection(new StructuredSelection(current));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.SimpleModelNavigationPropertiesEditionPart#setFeature(EObject newValue)
	 */
	public void setFeature(EObject newValue) {
		if (newValue != null) {
			feature.setSelection(new StructuredSelection(newValue));
		} else {
			feature.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.SimpleModelNavigationPropertiesEditionPart#setFeatureButtonMode(ButtonsModeEnum newValue)
	 */
	public void setFeatureButtonMode(ButtonsModeEnum newValue) {
		feature.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.SimpleModelNavigationPropertiesEditionPart#addFilterFeature(ViewerFilter filter)
	 */
	public void addFilterToFeature(ViewerFilter filter) {
		feature.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.SimpleModelNavigationPropertiesEditionPart#addBusinessFilterFeature(ViewerFilter filter)
	 */
	public void addBusinessFilterToFeature(ViewerFilter filter) {
		feature.addBusinessRuleFilter(filter);
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
		if (current != null) {
			discriminatorType.setSelection(new StructuredSelection(current));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.SimpleModelNavigationPropertiesEditionPart#setDiscriminatorType(EObject newValue)
	 */
	public void setDiscriminatorType(EObject newValue) {
		if (newValue != null) {
			discriminatorType.setSelection(new StructuredSelection(newValue));
		} else {
			discriminatorType.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.SimpleModelNavigationPropertiesEditionPart#setDiscriminatorTypeButtonMode(ButtonsModeEnum newValue)
	 */
	public void setDiscriminatorTypeButtonMode(ButtonsModeEnum newValue) {
		discriminatorType.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.SimpleModelNavigationPropertiesEditionPart#addFilterDiscriminatorType(ViewerFilter filter)
	 */
	public void addFilterToDiscriminatorType(ViewerFilter filter) {
		discriminatorType.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.SimpleModelNavigationPropertiesEditionPart#addBusinessFilterDiscriminatorType(ViewerFilter filter)
	 */
	public void addBusinessFilterToDiscriminatorType(ViewerFilter filter) {
		discriminatorType.addBusinessRuleFilter(filter);
	}










	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 */
	public String getTitle() {
		return MappingMessages.SimpleModelNavigation_Part_Title;
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
