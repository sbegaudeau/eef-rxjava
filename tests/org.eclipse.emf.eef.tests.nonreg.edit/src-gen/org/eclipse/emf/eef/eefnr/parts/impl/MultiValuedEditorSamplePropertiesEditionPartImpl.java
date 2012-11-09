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
package org.eclipse.emf.eef.eefnr.parts.impl;

// Start of user code for imports
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.eefnr.EefnrPackage;
import org.eclipse.emf.eef.eefnr.parts.EefnrViewsRepository;
import org.eclipse.emf.eef.eefnr.parts.MultiValuedEditorSamplePropertiesEditionPart;
import org.eclipse.emf.eef.eefnr.providers.EefnrMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.EEFFeatureEditorDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;


// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class MultiValuedEditorSamplePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, MultiValuedEditorSamplePropertiesEditionPart {

	protected Text multivaluededitorRequiredProperty;
	protected Button editMultivaluededitorRequiredProperty;
	private EList multivaluededitorRequiredPropertyList;
	protected Text multivaluededitorOptionalProperty;
	protected Button editMultivaluededitorOptionalProperty;
	private EList multivaluededitorOptionalPropertyList;
	protected Text multivaluededitorROProperty;
	protected Button editMultivaluededitorROProperty;
	private EList multivaluededitorROPropertyList;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public MultiValuedEditorSamplePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite)
	 * 
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
	 * 
	 */
	public void createControls(Composite view) { 
		CompositionSequence multiValuedEditorSampleStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = multiValuedEditorSampleStep.addStep(EefnrViewsRepository.MultiValuedEditorSample.Properties.class);
		propertiesStep.addStep(EefnrViewsRepository.MultiValuedEditorSample.Properties.multivaluededitorRequiredProperty);
		propertiesStep.addStep(EefnrViewsRepository.MultiValuedEditorSample.Properties.multivaluededitorOptionalProperty);
		propertiesStep.addStep(EefnrViewsRepository.MultiValuedEditorSample.Properties.multivaluededitorROProperty);
		
		
		composer = new PartComposer(multiValuedEditorSampleStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EefnrViewsRepository.MultiValuedEditorSample.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EefnrViewsRepository.MultiValuedEditorSample.Properties.multivaluededitorRequiredProperty) {
					return createMultivaluededitorRequiredPropertyMultiValuedEditor(parent);
				}
				if (key == EefnrViewsRepository.MultiValuedEditorSample.Properties.multivaluededitorOptionalProperty) {
					return createMultivaluededitorOptionalPropertyMultiValuedEditor(parent);
				}
				if (key == EefnrViewsRepository.MultiValuedEditorSample.Properties.multivaluededitorROProperty) {
					return createMultivaluededitorROPropertyMultiValuedEditor(parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}

	/**
	 * 
	 */
	protected Composite createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(EefnrMessages.MultiValuedEditorSamplePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	protected Composite createMultivaluededitorRequiredPropertyMultiValuedEditor(Composite parent) {
		multivaluededitorRequiredProperty = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData multivaluededitorRequiredPropertyData = new GridData(GridData.FILL_HORIZONTAL);
		multivaluededitorRequiredPropertyData.horizontalSpan = 2;
		multivaluededitorRequiredProperty.setLayoutData(multivaluededitorRequiredPropertyData);
		EditingUtils.setID(multivaluededitorRequiredProperty, EefnrViewsRepository.MultiValuedEditorSample.Properties.multivaluededitorRequiredProperty);
		EditingUtils.setEEFtype(multivaluededitorRequiredProperty, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editMultivaluededitorRequiredProperty = new Button(parent, SWT.NONE);
		editMultivaluededitorRequiredProperty.setText(getDescription(EefnrViewsRepository.MultiValuedEditorSample.Properties.multivaluededitorRequiredProperty, EefnrMessages.MultiValuedEditorSamplePropertiesEditionPart_MultivaluededitorRequiredPropertyLabel));
		GridData editMultivaluededitorRequiredPropertyData = new GridData();
		editMultivaluededitorRequiredProperty.setLayoutData(editMultivaluededitorRequiredPropertyData);
		editMultivaluededitorRequiredProperty.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				EEFFeatureEditorDialog dialog = new EEFFeatureEditorDialog(
						multivaluededitorRequiredProperty.getShell(), "MultiValuedEditorSample", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						multivaluededitorRequiredPropertyList, EefnrPackage.eINSTANCE.getMultiValuedEditorSample_MultivaluededitorRequiredProperty().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					multivaluededitorRequiredPropertyList = dialog.getResult();
					if (multivaluededitorRequiredPropertyList == null) {
						multivaluededitorRequiredPropertyList = new BasicEList();
					}
					multivaluededitorRequiredProperty.setText(multivaluededitorRequiredPropertyList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MultiValuedEditorSamplePropertiesEditionPartImpl.this, EefnrViewsRepository.MultiValuedEditorSample.Properties.multivaluededitorRequiredProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(multivaluededitorRequiredPropertyList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editMultivaluededitorRequiredProperty, EefnrViewsRepository.MultiValuedEditorSample.Properties.multivaluededitorRequiredProperty);
		EditingUtils.setEEFtype(editMultivaluededitorRequiredProperty, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		return parent;
	}

	protected Composite createMultivaluededitorOptionalPropertyMultiValuedEditor(Composite parent) {
		multivaluededitorOptionalProperty = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData multivaluededitorOptionalPropertyData = new GridData(GridData.FILL_HORIZONTAL);
		multivaluededitorOptionalPropertyData.horizontalSpan = 2;
		multivaluededitorOptionalProperty.setLayoutData(multivaluededitorOptionalPropertyData);
		EditingUtils.setID(multivaluededitorOptionalProperty, EefnrViewsRepository.MultiValuedEditorSample.Properties.multivaluededitorOptionalProperty);
		EditingUtils.setEEFtype(multivaluededitorOptionalProperty, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editMultivaluededitorOptionalProperty = new Button(parent, SWT.NONE);
		editMultivaluededitorOptionalProperty.setText(getDescription(EefnrViewsRepository.MultiValuedEditorSample.Properties.multivaluededitorOptionalProperty, EefnrMessages.MultiValuedEditorSamplePropertiesEditionPart_MultivaluededitorOptionalPropertyLabel));
		GridData editMultivaluededitorOptionalPropertyData = new GridData();
		editMultivaluededitorOptionalProperty.setLayoutData(editMultivaluededitorOptionalPropertyData);
		editMultivaluededitorOptionalProperty.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				EEFFeatureEditorDialog dialog = new EEFFeatureEditorDialog(
						multivaluededitorOptionalProperty.getShell(), "MultiValuedEditorSample", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						multivaluededitorOptionalPropertyList, EefnrPackage.eINSTANCE.getMultiValuedEditorSample_MultivaluededitorOptionalProperty().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					multivaluededitorOptionalPropertyList = dialog.getResult();
					if (multivaluededitorOptionalPropertyList == null) {
						multivaluededitorOptionalPropertyList = new BasicEList();
					}
					multivaluededitorOptionalProperty.setText(multivaluededitorOptionalPropertyList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MultiValuedEditorSamplePropertiesEditionPartImpl.this, EefnrViewsRepository.MultiValuedEditorSample.Properties.multivaluededitorOptionalProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(multivaluededitorOptionalPropertyList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editMultivaluededitorOptionalProperty, EefnrViewsRepository.MultiValuedEditorSample.Properties.multivaluededitorOptionalProperty);
		EditingUtils.setEEFtype(editMultivaluededitorOptionalProperty, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
		return parent;
	}

	protected Composite createMultivaluededitorROPropertyMultiValuedEditor(Composite parent) {
		multivaluededitorROProperty = SWTUtils.createScrollableText(parent, SWT.BORDER | SWT.READ_ONLY);
		GridData multivaluededitorROPropertyData = new GridData(GridData.FILL_HORIZONTAL);
		multivaluededitorROPropertyData.horizontalSpan = 2;
		multivaluededitorROProperty.setLayoutData(multivaluededitorROPropertyData);
		EditingUtils.setID(multivaluededitorROProperty, EefnrViewsRepository.MultiValuedEditorSample.Properties.multivaluededitorROProperty);
		EditingUtils.setEEFtype(multivaluededitorROProperty, "eef::MultiValuedEditor::field"); //$NON-NLS-1$
		editMultivaluededitorROProperty = new Button(parent, SWT.NONE);
		editMultivaluededitorROProperty.setEnabled(false);
		editMultivaluededitorROProperty.setText(getDescription(EefnrViewsRepository.MultiValuedEditorSample.Properties.multivaluededitorROProperty, EefnrMessages.MultiValuedEditorSamplePropertiesEditionPart_MultivaluededitorROPropertyLabel));
		GridData editMultivaluededitorROPropertyData = new GridData();
		editMultivaluededitorROProperty.setLayoutData(editMultivaluededitorROPropertyData);
		editMultivaluededitorROProperty.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				EEFFeatureEditorDialog dialog = new EEFFeatureEditorDialog(
						multivaluededitorROProperty.getShell(), "MultiValuedEditorSample", new AdapterFactoryLabelProvider(adapterFactory), //$NON-NLS-1$
						multivaluededitorROPropertyList, EefnrPackage.eINSTANCE.getMultiValuedEditorSample_MultivaluededitorROProperty().getEType(), null,
						false, true, 
						null, null);
				if (dialog.open() == Window.OK) {
					multivaluededitorROPropertyList = dialog.getResult();
					if (multivaluededitorROPropertyList == null) {
						multivaluededitorROPropertyList = new BasicEList();
					}
					multivaluededitorROProperty.setText(multivaluededitorROPropertyList.toString());
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MultiValuedEditorSamplePropertiesEditionPartImpl.this, EefnrViewsRepository.MultiValuedEditorSample.Properties.multivaluededitorROProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new BasicEList(multivaluededitorROPropertyList)));
					setHasChanged(true);
				}
			}
		});
		EditingUtils.setID(editMultivaluededitorROProperty, EefnrViewsRepository.MultiValuedEditorSample.Properties.multivaluededitorROProperty);
		EditingUtils.setEEFtype(editMultivaluededitorROProperty, "eef::MultiValuedEditor::browsebutton"); //$NON-NLS-1$
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
	 * @see org.eclipse.emf.eef.eefnr.parts.MultiValuedEditorSamplePropertiesEditionPart#getMultivaluededitorRequiredProperty()
	 * 
	 */
	public EList getMultivaluededitorRequiredProperty() {
		return multivaluededitorRequiredPropertyList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.MultiValuedEditorSamplePropertiesEditionPart#setMultivaluededitorRequiredProperty(EList newValue)
	 * 
	 */
	public void setMultivaluededitorRequiredProperty(EList newValue) {
		multivaluededitorRequiredPropertyList = newValue;
		if (newValue != null) {
			multivaluededitorRequiredProperty.setText(multivaluededitorRequiredPropertyList.toString());
		} else {
			multivaluededitorRequiredProperty.setText(""); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(EefnrViewsRepository.MultiValuedEditorSample.Properties.multivaluededitorRequiredProperty);
		if (readOnly && multivaluededitorRequiredProperty.isEnabled()) {
			multivaluededitorRequiredProperty.setEnabled(false);
			multivaluededitorRequiredProperty.setToolTipText(EefnrMessages.MultiValuedEditorSample_ReadOnly);
		} else if (!readOnly && !multivaluededitorRequiredProperty.isEnabled()) {
			multivaluededitorRequiredProperty.setEnabled(true);
		}	
		
	}

	public void addToMultivaluededitorRequiredProperty(Object newValue) {
		multivaluededitorRequiredPropertyList.add(newValue);
		if (newValue != null) {
			multivaluededitorRequiredProperty.setText(multivaluededitorRequiredPropertyList.toString());
		} else {
			multivaluededitorRequiredProperty.setText(""); //$NON-NLS-1$
		}
	}

	public void removeToMultivaluededitorRequiredProperty(Object newValue) {
		multivaluededitorRequiredPropertyList.remove(newValue);
		if (newValue != null) {
			multivaluededitorRequiredProperty.setText(multivaluededitorRequiredPropertyList.toString());
		} else {
			multivaluededitorRequiredProperty.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.MultiValuedEditorSamplePropertiesEditionPart#getMultivaluededitorOptionalProperty()
	 * 
	 */
	public EList getMultivaluededitorOptionalProperty() {
		return multivaluededitorOptionalPropertyList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.MultiValuedEditorSamplePropertiesEditionPart#setMultivaluededitorOptionalProperty(EList newValue)
	 * 
	 */
	public void setMultivaluededitorOptionalProperty(EList newValue) {
		multivaluededitorOptionalPropertyList = newValue;
		if (newValue != null) {
			multivaluededitorOptionalProperty.setText(multivaluededitorOptionalPropertyList.toString());
		} else {
			multivaluededitorOptionalProperty.setText(""); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(EefnrViewsRepository.MultiValuedEditorSample.Properties.multivaluededitorOptionalProperty);
		if (readOnly && multivaluededitorOptionalProperty.isEnabled()) {
			multivaluededitorOptionalProperty.setEnabled(false);
			multivaluededitorOptionalProperty.setToolTipText(EefnrMessages.MultiValuedEditorSample_ReadOnly);
		} else if (!readOnly && !multivaluededitorOptionalProperty.isEnabled()) {
			multivaluededitorOptionalProperty.setEnabled(true);
		}	
		
	}

	public void addToMultivaluededitorOptionalProperty(Object newValue) {
		multivaluededitorOptionalPropertyList.add(newValue);
		if (newValue != null) {
			multivaluededitorOptionalProperty.setText(multivaluededitorOptionalPropertyList.toString());
		} else {
			multivaluededitorOptionalProperty.setText(""); //$NON-NLS-1$
		}
	}

	public void removeToMultivaluededitorOptionalProperty(Object newValue) {
		multivaluededitorOptionalPropertyList.remove(newValue);
		if (newValue != null) {
			multivaluededitorOptionalProperty.setText(multivaluededitorOptionalPropertyList.toString());
		} else {
			multivaluededitorOptionalProperty.setText(""); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.MultiValuedEditorSamplePropertiesEditionPart#getMultivaluededitorROProperty()
	 * 
	 */
	public EList getMultivaluededitorROProperty() {
		return multivaluededitorROPropertyList;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.MultiValuedEditorSamplePropertiesEditionPart#setMultivaluededitorROProperty(EList newValue)
	 * 
	 */
	public void setMultivaluededitorROProperty(EList newValue) {
		multivaluededitorROPropertyList = newValue;
		if (newValue != null) {
			multivaluededitorROProperty.setText(multivaluededitorROPropertyList.toString());
		} else {
			multivaluededitorROProperty.setText(""); //$NON-NLS-1$
		}
		multivaluededitorROProperty.setEnabled(false);
		multivaluededitorROProperty.setToolTipText(EefnrMessages.MultiValuedEditorSample_ReadOnly);
		
	}

	public void addToMultivaluededitorROProperty(Object newValue) {
		multivaluededitorROPropertyList.add(newValue);
		if (newValue != null) {
			multivaluededitorROProperty.setText(multivaluededitorROPropertyList.toString());
		} else {
			multivaluededitorROProperty.setText(""); //$NON-NLS-1$
		}
	}

	public void removeToMultivaluededitorROProperty(Object newValue) {
		multivaluededitorROPropertyList.remove(newValue);
		if (newValue != null) {
			multivaluededitorROProperty.setText(multivaluededitorROPropertyList.toString());
		} else {
			multivaluededitorROProperty.setText(""); //$NON-NLS-1$
		}
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EefnrMessages.MultiValuedEditorSample_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
