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
 * $Id: GenActivationPropertiesEditionPartForm.java,v 1.1 2009/04/30 17:12:37 glefur Exp $
 */
package org.eclipse.emf.eef.EEFGen.parts.forms;

// Start of user code for imports

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PathedPropertiesEditionEvent;
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

import org.eclipse.emf.eef.EEFGen.GenEditionContext;
import org.eclipse.emf.eef.EEFGen.EEFGenPackage;
import org.eclipse.emf.eef.EEFGen.parts.EEFGenViewsRepository;
import org.eclipse.emf.eef.EEFGen.providers.EEFGenMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.api.parts.EEFMessageManager;
import org.eclipse.emf.eef.EEFGen.parts.GenActivationPropertiesEditionPart;




// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class GenActivationPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, GenActivationPropertiesEditionPart {

	private Button descriptorsGenericPropertiesViews;
	private Button formViews;
	private Button gmfPropertiesViews;
	private Button swtViews;
		
	public GenActivationPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		createActivationGroup(widgetFactory, view);

		// Start of user code for additional ui definition
		
		// End of user code
		
	}

	private void createActivationGroup(FormToolkit widgetFactory, final Composite view) {
		Section activationSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		activationSection.setText(EEFGenMessages.GenActivationPropertiesEditionPart_ActivationGroupLabel);
		GridData activationSectionData = new GridData(GridData.FILL_HORIZONTAL);
		activationSectionData.horizontalSpan = 3;
		activationSection.setLayoutData(activationSectionData);
		Composite activationGroup = widgetFactory.createComposite(activationSection);
		GridLayout activationGroupLayout = new GridLayout();
		activationGroupLayout.numColumns = 3;
		activationGroup.setLayout(activationGroupLayout);
		createDescriptorsGenericPropertiesViewsCheckbox(widgetFactory, activationGroup);
		createFormViewsCheckbox(widgetFactory, activationGroup);
		createGmfPropertiesViewsCheckbox(widgetFactory, activationGroup);
		createSwtViewsCheckbox(widgetFactory, activationGroup);
		activationSection.setClient(activationGroup);
	}   		

	private void createDescriptorsGenericPropertiesViewsCheckbox(FormToolkit widgetFactory, Composite parent) {
		descriptorsGenericPropertiesViews = widgetFactory.createButton(parent, EEFGenMessages.GenActivationPropertiesEditionPart_DescriptorsGenericPropertiesViewsLabel, SWT.CHECK);
   		descriptorsGenericPropertiesViews.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(GenActivationPropertiesEditionPartForm.this, EEFGenViewsRepository.GenActivation.descriptorsGenericPropertiesViews, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, null, new Boolean(descriptorsGenericPropertiesViews.getSelection())));
			}
   			
   			
   		});
		GridData descriptorsGenericPropertiesViewsData = new GridData(GridData.FILL_HORIZONTAL);
		descriptorsGenericPropertiesViewsData.horizontalSpan = 2;
		descriptorsGenericPropertiesViews.setLayoutData(descriptorsGenericPropertiesViewsData);
		FormUtils.createHelpButton(widgetFactory, parent, "Whether to include a sample configuration for plugin.xml to use a generic EEF properties view", null); //$NON-NLS-1$
	}

	private void createFormViewsCheckbox(FormToolkit widgetFactory, Composite parent) {
		formViews = widgetFactory.createButton(parent, EEFGenMessages.GenActivationPropertiesEditionPart_FormViewsLabel, SWT.CHECK);
   		formViews.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(GenActivationPropertiesEditionPartForm.this, EEFGenViewsRepository.GenActivation.formViews, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, null, new Boolean(formViews.getSelection())));
			}
   			
   			
   		});
		GridData formViewsData = new GridData(GridData.FILL_HORIZONTAL);
		formViewsData.horizontalSpan = 2;
		formViews.setLayoutData(formViewsData);
		FormUtils.createHelpButton(widgetFactory, parent, "Whether to include the Eclipse Forms implementation of views", null); //$NON-NLS-1$
	}

	private void createGmfPropertiesViewsCheckbox(FormToolkit widgetFactory, Composite parent) {
		gmfPropertiesViews = widgetFactory.createButton(parent, EEFGenMessages.GenActivationPropertiesEditionPart_GmfPropertiesViewsLabel, SWT.CHECK);
   		gmfPropertiesViews.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(GenActivationPropertiesEditionPartForm.this, EEFGenViewsRepository.GenActivation.gmfPropertiesViews, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, null, new Boolean(gmfPropertiesViews.getSelection())));
			}
   			
   			
   		});
		GridData gmfPropertiesViewsData = new GridData(GridData.FILL_HORIZONTAL);
		gmfPropertiesViewsData.horizontalSpan = 2;
		gmfPropertiesViews.setLayoutData(gmfPropertiesViewsData);
		FormUtils.createHelpButton(widgetFactory, parent, "Whether to include a views implementation and a sample configuration for plugin.xml to use EEF on a GMF modeler", null); //$NON-NLS-1$
	}

	private void createSwtViewsCheckbox(FormToolkit widgetFactory, Composite parent) {
		swtViews = widgetFactory.createButton(parent, EEFGenMessages.GenActivationPropertiesEditionPart_SwtViewsLabel, SWT.CHECK);
   		swtViews.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(GenActivationPropertiesEditionPartForm.this, EEFGenViewsRepository.GenActivation.swtViews, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.SET, null, new Boolean(swtViews.getSelection())));
			}
   			
   			
   		});
		GridData swtViewsData = new GridData(GridData.FILL_HORIZONTAL);
		swtViewsData.horizontalSpan = 2;
		swtViews.setLayoutData(swtViewsData);
		FormUtils.createHelpButton(widgetFactory, parent, "Whether to include the SWT implementation of views", null); //$NON-NLS-1$
	}

	public void initComponent(EObject eObject, ResourceSet allResources) {
		GenEditionContext genEditionContext = (GenEditionContext)eObject;
		swtViews.setSelection(genEditionContext.isSwtViews());	
		formViews.setSelection(genEditionContext.isFormViews());	
		descriptorsGenericPropertiesViews.setSelection(genEditionContext.isDescriptorsGenericPropertiesViews());	
		gmfPropertiesViews.setSelection(genEditionContext.isGmfPropertiesViews());	
	}
	
	public void firePropertiesChanged(PathedPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// Nothing to do
		// End of user code
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenActivationPropertiesEditionPart#getDescriptorsGenericPropertiesViews()
	 */
	public Boolean getDescriptorsGenericPropertiesViews() {
		return Boolean.valueOf(descriptorsGenericPropertiesViews.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenActivationPropertiesEditionPart#setDescriptorsGenericPropertiesViews(Boolean newValue)
	 */
	public void setDescriptorsGenericPropertiesViews(Boolean newValue) {
		descriptorsGenericPropertiesViews.setSelection(newValue.booleanValue());
	}
	
	
	
	

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenActivationPropertiesEditionPart#getFormViews()
	 */
	public Boolean getFormViews() {
		return Boolean.valueOf(formViews.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenActivationPropertiesEditionPart#setFormViews(Boolean newValue)
	 */
	public void setFormViews(Boolean newValue) {
		formViews.setSelection(newValue.booleanValue());
	}
	
	
	
	

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenActivationPropertiesEditionPart#getGmfPropertiesViews()
	 */
	public Boolean getGmfPropertiesViews() {
		return Boolean.valueOf(gmfPropertiesViews.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenActivationPropertiesEditionPart#setGmfPropertiesViews(Boolean newValue)
	 */
	public void setGmfPropertiesViews(Boolean newValue) {
		gmfPropertiesViews.setSelection(newValue.booleanValue());
	}
	
	
	
	

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenActivationPropertiesEditionPart#getSwtViews()
	 */
	public Boolean getSwtViews() {
		return Boolean.valueOf(swtViews.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.EEFGen.parts.GenActivationPropertiesEditionPart#setSwtViews(Boolean newValue)
	 */
	public void setSwtViews(Boolean newValue) {
		swtViews.setSelection(newValue.booleanValue());
	}
	
	
	
	



	
	// Start of user code additional methods
 	
	// End of user code

}	
