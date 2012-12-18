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
import org.eclipse.emf.eef.eefnr.parts.EefnrViewsRepository;
import org.eclipse.emf.eef.eefnr.parts.ImageViewerSamplePropertiesEditionPart;

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

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.imageviewer.EEFImageViewer;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;

import org.eclipse.swt.SWT;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class ImageViewerSamplePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ImageViewerSamplePropertiesEditionPart {

	protected EEFImageViewer imageviewerRequiredProperty;
	protected EEFImageViewer imageviewerOptionalProperty;
	protected EEFImageViewer imageviewerROProperty;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ImageViewerSamplePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence imageViewerSampleStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = imageViewerSampleStep.addStep(EefnrViewsRepository.ImageViewerSample.Properties.class);
		propertiesStep.addStep(EefnrViewsRepository.ImageViewerSample.Properties.imageviewerRequiredProperty);
		propertiesStep.addStep(EefnrViewsRepository.ImageViewerSample.Properties.imageviewerOptionalProperty);
		propertiesStep.addStep(EefnrViewsRepository.ImageViewerSample.Properties.imageviewerROProperty);
		
		
		composer = new PartComposer(imageViewerSampleStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EefnrViewsRepository.ImageViewerSample.Properties.class) {
					return createPropertiesGroup(parent);
				}
				if (key == EefnrViewsRepository.ImageViewerSample.Properties.imageviewerRequiredProperty) {
					return createImageviewerRequiredPropertyImageViewer(parent);
				}
				if (key == EefnrViewsRepository.ImageViewerSample.Properties.imageviewerOptionalProperty) {
					return createImageviewerOptionalPropertyImageViewer(parent);
				}
				if (key == EefnrViewsRepository.ImageViewerSample.Properties.imageviewerROProperty) {
					return createImageviewerROPropertyImageViewer(parent);
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
		propertiesGroup.setText(EefnrMessages.ImageViewerSamplePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		return propertiesGroup;
	}

	/**
	 * 
	 */
	protected Composite createImageviewerRequiredPropertyImageViewer(Composite parent) {
		createDescription(parent, EefnrViewsRepository.ImageViewerSample.Properties.imageviewerRequiredProperty, EefnrMessages.ImageViewerSamplePropertiesEditionPart_ImageviewerRequiredPropertyLabel);
		imageviewerRequiredProperty = new EEFImageViewer(parent, SWT.BORDER);
		GridData imageviewerRequiredPropertyData = new GridData();
		// Start of user code  for imageviewerRequiredProperty layout data customization
				imageviewerRequiredPropertyData.widthHint = 200;
				imageviewerRequiredPropertyData.heightHint = 200;
				imageviewerRequiredPropertyData.horizontalAlignment = SWT.CENTER;
				imageviewerRequiredPropertyData.verticalAlignment = SWT.CENTER;
		
		// End of user code
		imageviewerRequiredProperty.setLayoutData(imageviewerRequiredPropertyData);
		imageviewerRequiredProperty.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ImageViewerSamplePropertiesEditionPartImpl.this, EefnrViewsRepository.ImageViewerSample.Properties.imageviewerRequiredProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getImageviewerRequiredProperty()));
			}
		});
		imageviewerRequiredProperty.setID(EefnrViewsRepository.ImageViewerSample.Properties.imageviewerRequiredProperty);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EefnrViewsRepository.ImageViewerSample.Properties.imageviewerRequiredProperty, EefnrViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createImageviewerRequiredPropertyImageViewer

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createImageviewerOptionalPropertyImageViewer(Composite parent) {
		createDescription(parent, EefnrViewsRepository.ImageViewerSample.Properties.imageviewerOptionalProperty, EefnrMessages.ImageViewerSamplePropertiesEditionPart_ImageviewerOptionalPropertyLabel);
		imageviewerOptionalProperty = new EEFImageViewer(parent, SWT.BORDER);
		GridData imageviewerOptionalPropertyData = new GridData();
		// Start of user code  for imageviewerOptionalProperty layout data customization
				imageviewerOptionalPropertyData.widthHint = 200;
				imageviewerOptionalPropertyData.heightHint = 200;
				imageviewerOptionalPropertyData.horizontalAlignment = SWT.CENTER;
				imageviewerOptionalPropertyData.verticalAlignment = SWT.CENTER;
		
		// End of user code
		imageviewerOptionalProperty.setLayoutData(imageviewerOptionalPropertyData);
		imageviewerOptionalProperty.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ImageViewerSamplePropertiesEditionPartImpl.this, EefnrViewsRepository.ImageViewerSample.Properties.imageviewerOptionalProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getImageviewerOptionalProperty()));
			}
		});
		imageviewerOptionalProperty.setID(EefnrViewsRepository.ImageViewerSample.Properties.imageviewerOptionalProperty);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EefnrViewsRepository.ImageViewerSample.Properties.imageviewerOptionalProperty, EefnrViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createImageviewerOptionalPropertyImageViewer

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createImageviewerROPropertyImageViewer(Composite parent) {
		createDescription(parent, EefnrViewsRepository.ImageViewerSample.Properties.imageviewerROProperty, EefnrMessages.ImageViewerSamplePropertiesEditionPart_ImageviewerROPropertyLabel);
		imageviewerROProperty = new EEFImageViewer(parent, SWT.BORDER);
		GridData imageviewerROPropertyData = new GridData();
		// Start of user code  for imageviewerROProperty layout data customization
				imageviewerROPropertyData.widthHint = 200;
				imageviewerROPropertyData.heightHint = 200;
				imageviewerROPropertyData.horizontalAlignment = SWT.CENTER;
				imageviewerROPropertyData.verticalAlignment = SWT.CENTER;
		
		// End of user code
		imageviewerROProperty.setLayoutData(imageviewerROPropertyData);
		imageviewerROProperty.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ImageViewerSamplePropertiesEditionPartImpl.this, EefnrViewsRepository.ImageViewerSample.Properties.imageviewerROProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getImageviewerROProperty()));
			}
		});
		imageviewerROProperty.setID(EefnrViewsRepository.ImageViewerSample.Properties.imageviewerROProperty);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EefnrViewsRepository.ImageViewerSample.Properties.imageviewerROProperty, EefnrViewsRepository.SWT_KIND), null); //$NON-NLS-1$
		// Start of user code for createImageviewerROPropertyImageViewer

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
	 * @see org.eclipse.emf.eef.eefnr.parts.ImageViewerSamplePropertiesEditionPart#getImageviewerRequiredProperty()
	 * 
	 */
	public String getImageviewerRequiredProperty() {
		ISelection selection = imageviewerRequiredProperty.getSelection();
		if (selection instanceof StructuredSelection && ((StructuredSelection)selection).getFirstElement() instanceof String) {
			return (String)((StructuredSelection)selection).getFirstElement();
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.ImageViewerSamplePropertiesEditionPart#initImageviewerRequiredProperty(String key, String newValue)
	 */
	public void initImageviewerRequiredProperty(String key, String newValue) {
		if (newValue != null) {
			imageviewerRequiredProperty.initViewer(key, newValue);
		} else {
			imageviewerRequiredProperty.initViewer(key, ""); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(EefnrViewsRepository.ImageViewerSample.Properties.imageviewerRequiredProperty);
		if (readOnly && imageviewerRequiredProperty.isEnabled()) {
			imageviewerRequiredProperty.setEnabled(false);
			imageviewerRequiredProperty.setToolTipText(EefnrMessages.ImageViewerSample_ReadOnly);
		} else if (!readOnly && !imageviewerRequiredProperty.isEnabled()) {
			imageviewerRequiredProperty.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.ImageViewerSamplePropertiesEditionPart#setImageviewerRequiredProperty(String newValue)
	 * 
	 */
	public void setImageviewerRequiredProperty(String newValue) {
		if (newValue != null) {
			imageviewerRequiredProperty.setSelection(new StructuredSelection(newValue));
		} else {
			imageviewerRequiredProperty.setSelection(new StructuredSelection("")); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(EefnrViewsRepository.ImageViewerSample.Properties.imageviewerRequiredProperty);
		if (readOnly && imageviewerRequiredProperty.isEnabled()) {
			imageviewerRequiredProperty.setEnabled(false);
			imageviewerRequiredProperty.setToolTipText(EefnrMessages.ImageViewerSample_ReadOnly);
		} else if (!readOnly && !imageviewerRequiredProperty.isEnabled()) {
			imageviewerRequiredProperty.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.ImageViewerSamplePropertiesEditionPart#getImageviewerOptionalProperty()
	 * 
	 */
	public String getImageviewerOptionalProperty() {
		ISelection selection = imageviewerOptionalProperty.getSelection();
		if (selection instanceof StructuredSelection && ((StructuredSelection)selection).getFirstElement() instanceof String) {
			return (String)((StructuredSelection)selection).getFirstElement();
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.ImageViewerSamplePropertiesEditionPart#initImageviewerOptionalProperty(String key, String newValue)
	 */
	public void initImageviewerOptionalProperty(String key, String newValue) {
		if (newValue != null) {
			imageviewerOptionalProperty.initViewer(key, newValue);
		} else {
			imageviewerOptionalProperty.initViewer(key, ""); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(EefnrViewsRepository.ImageViewerSample.Properties.imageviewerOptionalProperty);
		if (readOnly && imageviewerOptionalProperty.isEnabled()) {
			imageviewerOptionalProperty.setEnabled(false);
			imageviewerOptionalProperty.setToolTipText(EefnrMessages.ImageViewerSample_ReadOnly);
		} else if (!readOnly && !imageviewerOptionalProperty.isEnabled()) {
			imageviewerOptionalProperty.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.ImageViewerSamplePropertiesEditionPart#setImageviewerOptionalProperty(String newValue)
	 * 
	 */
	public void setImageviewerOptionalProperty(String newValue) {
		if (newValue != null) {
			imageviewerOptionalProperty.setSelection(new StructuredSelection(newValue));
		} else {
			imageviewerOptionalProperty.setSelection(new StructuredSelection("")); //$NON-NLS-1$
		}
		boolean readOnly = isReadOnly(EefnrViewsRepository.ImageViewerSample.Properties.imageviewerOptionalProperty);
		if (readOnly && imageviewerOptionalProperty.isEnabled()) {
			imageviewerOptionalProperty.setEnabled(false);
			imageviewerOptionalProperty.setToolTipText(EefnrMessages.ImageViewerSample_ReadOnly);
		} else if (!readOnly && !imageviewerOptionalProperty.isEnabled()) {
			imageviewerOptionalProperty.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.ImageViewerSamplePropertiesEditionPart#getImageviewerROProperty()
	 * 
	 */
	public String getImageviewerROProperty() {
		ISelection selection = imageviewerROProperty.getSelection();
		if (selection instanceof StructuredSelection && ((StructuredSelection)selection).getFirstElement() instanceof String) {
			return (String)((StructuredSelection)selection).getFirstElement();
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.ImageViewerSamplePropertiesEditionPart#initImageviewerROProperty(String key, String newValue)
	 */
	public void initImageviewerROProperty(String key, String newValue) {
		if (newValue != null) {
			imageviewerROProperty.initViewer(key, newValue);
		} else {
			imageviewerROProperty.initViewer(key, ""); //$NON-NLS-1$
		}
		imageviewerROProperty.setEnabled(false);
		imageviewerROProperty.setToolTipText(EefnrMessages.ImageViewerSample_ReadOnly);
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.ImageViewerSamplePropertiesEditionPart#setImageviewerROProperty(String newValue)
	 * 
	 */
	public void setImageviewerROProperty(String newValue) {
		if (newValue != null) {
			imageviewerROProperty.setSelection(new StructuredSelection(newValue));
		} else {
			imageviewerROProperty.setSelection(new StructuredSelection("")); //$NON-NLS-1$
		}
		imageviewerROProperty.setEnabled(false);
		imageviewerROProperty.setToolTipText(EefnrMessages.ImageViewerSample_ReadOnly);
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EefnrMessages.ImageViewerSample_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
