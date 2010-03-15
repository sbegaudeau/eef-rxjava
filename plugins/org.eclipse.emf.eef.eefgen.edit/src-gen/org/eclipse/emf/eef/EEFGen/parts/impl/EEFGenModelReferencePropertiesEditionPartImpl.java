/**
 *  Copyright (c) 2008-2010 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Obeo - initial API and implementation
 *
 */
package org.eclipse.emf.eef.EEFGen.parts.impl;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.EEFGen.parts.EEFGenModelReferencePropertiesEditionPart;
import org.eclipse.emf.eef.EEFGen.parts.EEFGenViewsRepository;
import org.eclipse.emf.eef.EEFGen.providers.EEFGenMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
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
public class EEFGenModelReferencePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, EEFGenModelReferencePropertiesEditionPart {

	protected EObjectFlatComboViewer referencedEEFGenModel;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public EEFGenModelReferencePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		createReferenceGroup(view);


		// Start of user code for additional ui definition
		
		// End of user code
	}

	/**
	 * 
	 */
	protected void createReferenceGroup(Composite parent) {
		Group referenceGroup = new Group(parent, SWT.NONE);
		referenceGroup.setText(EEFGenMessages.EEFGenModelReferencePropertiesEditionPart_ReferenceGroupLabel);
		GridData referenceGroupData = new GridData(GridData.FILL_HORIZONTAL);
		referenceGroupData.horizontalSpan = 3;
		referenceGroup.setLayoutData(referenceGroupData);
		GridLayout referenceGroupLayout = new GridLayout();
		referenceGroupLayout.numColumns = 3;
		referenceGroup.setLayout(referenceGroupLayout);
		createReferencedEEFGenModelFlatComboViewer(referenceGroup);
	}

	/**
	 * @param referenceGroup
	 * 
	 */
	protected void createReferencedEEFGenModelFlatComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, EEFGenMessages.EEFGenModelReferencePropertiesEditionPart_ReferencedEEFGenModelLabel, propertiesEditionComponent.isRequired(EEFGenViewsRepository.EEFGenModelReference.referencedEEFGenModel, EEFGenViewsRepository.SWT_KIND));
		referencedEEFGenModel = new EObjectFlatComboViewer(parent, false);
		referencedEEFGenModel.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		referencedEEFGenModel.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EEFGenModelReferencePropertiesEditionPartImpl.this, EEFGenViewsRepository.EEFGenModelReference.referencedEEFGenModel, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getReferencedEEFGenModel()));
			}

		});
		GridData referencedEEFGenModelData = new GridData(GridData.FILL_HORIZONTAL);
		referencedEEFGenModel.setLayoutData(referencedEEFGenModelData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EEFGenViewsRepository.EEFGenModelReference.referencedEEFGenModel, EEFGenViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 * @see org.eclipse.emf.eef.EEFGen.parts.EEFGenModelReferencePropertiesEditionPart#getReferencedEEFGenModel()
	 * 
	 */
	public EObject getReferencedEEFGenModel() {
		if (referencedEEFGenModel.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) referencedEEFGenModel.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.EEFGenModelReferencePropertiesEditionPart#initReferencedEEFGenModel(ResourceSet allResources, EObject current)
	 */
	public void initReferencedEEFGenModel(ResourceSet allResources, EObject current) {
		referencedEEFGenModel.setInput(allResources);
		if (current != null) {
			referencedEEFGenModel.setSelection(new StructuredSelection(current));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.EEFGenModelReferencePropertiesEditionPart#setReferencedEEFGenModel(EObject newValue)
	 * 
	 */
	public void setReferencedEEFGenModel(EObject newValue) {
		if (newValue != null) {
			referencedEEFGenModel.setSelection(new StructuredSelection(newValue));
		} else {
			referencedEEFGenModel.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.EEFGenModelReferencePropertiesEditionPart#setReferencedEEFGenModelButtonMode(ButtonsModeEnum newValue)
	 */
	public void setReferencedEEFGenModelButtonMode(ButtonsModeEnum newValue) {
		referencedEEFGenModel.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.EEFGenModelReferencePropertiesEditionPart#addFilterReferencedEEFGenModel(ViewerFilter filter)
	 * 
	 */
	public void addFilterToReferencedEEFGenModel(ViewerFilter filter) {
		referencedEEFGenModel.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.EEFGenModelReferencePropertiesEditionPart#addBusinessFilterReferencedEEFGenModel(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToReferencedEEFGenModel(ViewerFilter filter) {
		referencedEEFGenModel.addBusinessRuleFilter(filter);
	}

	public void setMessageForReferencedEEFGenModel(String msg, int msgLevel) {

	}

	public void unsetMessageForReferencedEEFGenModel() {

	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EEFGenMessages.EEFGenModelReference_Part_Title;
	}

	// Start of user code additional methods
 	
	// End of user code


}
