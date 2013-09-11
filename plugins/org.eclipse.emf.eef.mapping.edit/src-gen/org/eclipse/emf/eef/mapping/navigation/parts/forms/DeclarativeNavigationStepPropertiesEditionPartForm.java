/*******************************************************************************
 * Copyright (c) 2008, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.mapping.navigation.parts.forms;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.mapping.navigation.DeclarativeNavigationStep;
import org.eclipse.emf.eef.mapping.navigation.NavigationPackage;
import org.eclipse.emf.eef.mapping.navigation.parts.DeclarativeNavigationStepPropertiesEditionPart;
import org.eclipse.emf.eef.mapping.navigation.parts.NavigationViewsRepository;
import org.eclipse.emf.eef.mapping.navigation.providers.NavigationMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;
import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ISection;

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class DeclarativeNavigationStepPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, DeclarativeNavigationStepPropertiesEditionPart {

	protected Text index;
	protected EObjectFlatComboViewer feature;
	protected EObjectFlatComboViewer discriminatorType;



	/**
	 * For {@link ISection} use only.
	 */
	public DeclarativeNavigationStepPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public DeclarativeNavigationStepPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 * 
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
	 * 
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		CompositionSequence declarativeNavigationStepStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = declarativeNavigationStepStep.addStep(NavigationViewsRepository.DeclarativeNavigationStep.Properties.class);
		propertiesStep.addStep(NavigationViewsRepository.DeclarativeNavigationStep.Properties.index);
		propertiesStep.addStep(NavigationViewsRepository.DeclarativeNavigationStep.Properties.feature);
		propertiesStep.addStep(NavigationViewsRepository.DeclarativeNavigationStep.Properties.discriminatorType);
		
		
		composer = new PartComposer(declarativeNavigationStepStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == NavigationViewsRepository.DeclarativeNavigationStep.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == NavigationViewsRepository.DeclarativeNavigationStep.Properties.index) {
					return createIndexText(widgetFactory, parent);
				}
				if (key == NavigationViewsRepository.DeclarativeNavigationStep.Properties.feature) {
					return createFeatureFlatComboViewer(parent, widgetFactory);
				}
				if (key == NavigationViewsRepository.DeclarativeNavigationStep.Properties.discriminatorType) {
					return createDiscriminatorTypeFlatComboViewer(parent, widgetFactory);
				}
				return parent;
			}
		};
		composer.compose(view);
	}
	/**
	 * 
	 */
	protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
		Section propertiesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(NavigationMessages.DeclarativeNavigationStepPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		propertiesSection.setClient(propertiesGroup);
		return propertiesGroup;
	}

	
	protected Composite createIndexText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, NavigationViewsRepository.DeclarativeNavigationStep.Properties.index, NavigationMessages.DeclarativeNavigationStepPropertiesEditionPart_IndexLabel);
		index = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		index.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData indexData = new GridData(GridData.FILL_HORIZONTAL);
		index.setLayoutData(indexData);
		index.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							DeclarativeNavigationStepPropertiesEditionPartForm.this,
							NavigationViewsRepository.DeclarativeNavigationStep.Properties.index,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, index.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									DeclarativeNavigationStepPropertiesEditionPartForm.this,
									NavigationViewsRepository.DeclarativeNavigationStep.Properties.index,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, index.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									DeclarativeNavigationStepPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		index.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DeclarativeNavigationStepPropertiesEditionPartForm.this, NavigationViewsRepository.DeclarativeNavigationStep.Properties.index, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, index.getText()));
				}
			}
		});
		EditingUtils.setID(index, NavigationViewsRepository.DeclarativeNavigationStep.Properties.index);
		EditingUtils.setEEFtype(index, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(NavigationViewsRepository.DeclarativeNavigationStep.Properties.index, NavigationViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createIndexText

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createFeatureFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, NavigationViewsRepository.DeclarativeNavigationStep.Properties.feature, NavigationMessages.DeclarativeNavigationStepPropertiesEditionPart_FeatureLabel);
		feature = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(NavigationViewsRepository.DeclarativeNavigationStep.Properties.feature, NavigationViewsRepository.FORM_KIND));
		widgetFactory.adapt(feature);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DeclarativeNavigationStepPropertiesEditionPartForm.this, NavigationViewsRepository.DeclarativeNavigationStep.Properties.feature, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getFeature()));
			}

		});
		feature.setID(NavigationViewsRepository.DeclarativeNavigationStep.Properties.feature);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(NavigationViewsRepository.DeclarativeNavigationStep.Properties.feature, NavigationViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createFeatureFlatComboViewer

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createDiscriminatorTypeFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, NavigationViewsRepository.DeclarativeNavigationStep.Properties.discriminatorType, NavigationMessages.DeclarativeNavigationStepPropertiesEditionPart_DiscriminatorTypeLabel);
		discriminatorType = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(NavigationViewsRepository.DeclarativeNavigationStep.Properties.discriminatorType, NavigationViewsRepository.FORM_KIND));
		widgetFactory.adapt(discriminatorType);
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
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DeclarativeNavigationStepPropertiesEditionPartForm.this, NavigationViewsRepository.DeclarativeNavigationStep.Properties.discriminatorType, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getDiscriminatorType()));
			}

		});
		discriminatorType.setID(NavigationViewsRepository.DeclarativeNavigationStep.Properties.discriminatorType);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(NavigationViewsRepository.DeclarativeNavigationStep.Properties.discriminatorType, NavigationViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createDiscriminatorTypeFlatComboViewer

		// End of user code
		return parent;
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.DeclarativeNavigationStepPropertiesEditionPart#getIndex()
	 * 
	 */
	public String getIndex() {
		return index.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.DeclarativeNavigationStepPropertiesEditionPart#setIndex(String newValue)
	 * 
	 */
	public void setIndex(String newValue) {
		if (newValue != null) {
			index.setText(newValue);
		} else {
			index.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(NavigationViewsRepository.DeclarativeNavigationStep.Properties.index);
		if (eefElementEditorReadOnlyState && index.isEnabled()) {
			index.setEnabled(false);
			index.setToolTipText(NavigationMessages.DeclarativeNavigationStep_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !index.isEnabled()) {
			index.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.DeclarativeNavigationStepPropertiesEditionPart#getFeature()
	 * 
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
	 * @see org.eclipse.emf.eef.navigation.parts.DeclarativeNavigationStepPropertiesEditionPart#initFeature(EObjectFlatComboSettings)
	 */
	public void initFeature(EObjectFlatComboSettings settings) {
		feature.setInput(settings);
		if (current != null) {
			feature.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(NavigationViewsRepository.DeclarativeNavigationStep.Properties.feature);
		if (eefElementEditorReadOnlyState && feature.isEnabled()) {
			feature.setEnabled(false);
			feature.setToolTipText(NavigationMessages.DeclarativeNavigationStep_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !feature.isEnabled()) {
			feature.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.DeclarativeNavigationStepPropertiesEditionPart#setFeature(EObject newValue)
	 * 
	 */
	public void setFeature(EObject newValue) {
		if (newValue != null) {
			feature.setSelection(new StructuredSelection(newValue));
		} else {
			feature.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(NavigationViewsRepository.DeclarativeNavigationStep.Properties.feature);
		if (eefElementEditorReadOnlyState && feature.isEnabled()) {
			feature.setEnabled(false);
			feature.setToolTipText(NavigationMessages.DeclarativeNavigationStep_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !feature.isEnabled()) {
			feature.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.DeclarativeNavigationStepPropertiesEditionPart#setFeatureButtonMode(ButtonsModeEnum newValue)
	 */
	public void setFeatureButtonMode(ButtonsModeEnum newValue) {
		feature.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.DeclarativeNavigationStepPropertiesEditionPart#addFilterFeature(ViewerFilter filter)
	 * 
	 */
	public void addFilterToFeature(ViewerFilter filter) {
		feature.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.DeclarativeNavigationStepPropertiesEditionPart#addBusinessFilterFeature(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToFeature(ViewerFilter filter) {
		feature.addBusinessRuleFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.DeclarativeNavigationStepPropertiesEditionPart#getDiscriminatorType()
	 * 
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
	 * @see org.eclipse.emf.eef.navigation.parts.DeclarativeNavigationStepPropertiesEditionPart#initDiscriminatorType(EObjectFlatComboSettings)
	 */
	public void initDiscriminatorType(EObjectFlatComboSettings settings) {
		discriminatorType.setInput(settings);
		if (current != null) {
			discriminatorType.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(NavigationViewsRepository.DeclarativeNavigationStep.Properties.discriminatorType);
		if (eefElementEditorReadOnlyState && discriminatorType.isEnabled()) {
			discriminatorType.setEnabled(false);
			discriminatorType.setToolTipText(NavigationMessages.DeclarativeNavigationStep_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !discriminatorType.isEnabled()) {
			discriminatorType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.DeclarativeNavigationStepPropertiesEditionPart#setDiscriminatorType(EObject newValue)
	 * 
	 */
	public void setDiscriminatorType(EObject newValue) {
		if (newValue != null) {
			discriminatorType.setSelection(new StructuredSelection(newValue));
		} else {
			discriminatorType.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(NavigationViewsRepository.DeclarativeNavigationStep.Properties.discriminatorType);
		if (eefElementEditorReadOnlyState && discriminatorType.isEnabled()) {
			discriminatorType.setEnabled(false);
			discriminatorType.setToolTipText(NavigationMessages.DeclarativeNavigationStep_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !discriminatorType.isEnabled()) {
			discriminatorType.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.DeclarativeNavigationStepPropertiesEditionPart#setDiscriminatorTypeButtonMode(ButtonsModeEnum newValue)
	 */
	public void setDiscriminatorTypeButtonMode(ButtonsModeEnum newValue) {
		discriminatorType.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.DeclarativeNavigationStepPropertiesEditionPart#addFilterDiscriminatorType(ViewerFilter filter)
	 * 
	 */
	public void addFilterToDiscriminatorType(ViewerFilter filter) {
		discriminatorType.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.navigation.parts.DeclarativeNavigationStepPropertiesEditionPart#addBusinessFilterDiscriminatorType(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToDiscriminatorType(ViewerFilter filter) {
		discriminatorType.addBusinessRuleFilter(filter);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return NavigationMessages.DeclarativeNavigationStep_Part_Title;
	}

	// Start of user code additional methods
	public void setDiscriminatorInput(DeclarativeNavigationStep declarativeNavigationStep, ResourceSet allResources){
		discriminatorType.setInput(EEFUtils.choiceOfValues(adapterFactory, declarativeNavigationStep, NavigationPackage.eINSTANCE.getDeclarativeNavigationStep_DiscriminatorType()));
		if (declarativeNavigationStep.getDiscriminatorType() != null){
			discriminatorType.setSelection(new StructuredSelection(declarativeNavigationStep.getDiscriminatorType()));
		}
	}
	// End of user code


}
