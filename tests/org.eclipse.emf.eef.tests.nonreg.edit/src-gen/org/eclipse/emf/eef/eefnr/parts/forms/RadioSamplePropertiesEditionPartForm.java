/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.eefnr.parts.forms;

// Start of user code for imports
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.eef.eefnr.parts.EefnrViewsRepository;
import org.eclipse.emf.eef.eefnr.parts.RadioSamplePropertiesEditionPart;
import org.eclipse.emf.eef.eefnr.providers.EefnrMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.RadioViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;


// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class RadioSamplePropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, RadioSamplePropertiesEditionPart {

	protected RadioViewer radioRequiredPropertyRadioViewer;
	protected RadioViewer radioOptionalPropertyRadioViewer;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public RadioSamplePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		createPropertiesGroup(widgetFactory, view);

		// Start of user code for additional ui definition
		
		// End of user code
	}
	/**
	 * 
	 */
	protected void createPropertiesGroup(FormToolkit widgetFactory, final Composite view) {
		Section propertiesSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(EefnrMessages.RadioSamplePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createRadioRequiredPropertyRadioViewer(propertiesGroup);
		createRadioOptionalPropertyRadioViewer(propertiesGroup);
		propertiesSection.setClient(propertiesGroup);
	}

	/**
	 * 
	 */
	protected void createRadioRequiredPropertyRadioViewer(Composite parent) {
		radioRequiredPropertyRadioViewer = new RadioViewer(parent, SWT.CHECK);
		GridData radioRequiredPropertyData = new GridData(GridData.FILL_HORIZONTAL);
		radioRequiredPropertyData.horizontalSpan = 2;
		radioRequiredPropertyRadioViewer.setLayoutData(radioRequiredPropertyData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EefnrViewsRepository.RadioSample.radioRequiredProperty, EefnrViewsRepository.FORM_KIND), null);
	}

	/**
	 * 
	 */
	protected void createRadioOptionalPropertyRadioViewer(Composite parent) {
		radioOptionalPropertyRadioViewer = new RadioViewer(parent, SWT.CHECK);
		GridData radioOptionalPropertyData = new GridData(GridData.FILL_HORIZONTAL);
		radioOptionalPropertyData.horizontalSpan = 2;
		radioOptionalPropertyRadioViewer.setLayoutData(radioOptionalPropertyData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(EefnrViewsRepository.RadioSample.radioOptionalProperty, EefnrViewsRepository.FORM_KIND), null);
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
	 * @see org.eclipse.emf.eef.eefnr.parts.RadioSamplePropertiesEditionPart#getRadioRequiredProperty()
	 * 
	 */
	public Object getRadioRequiredProperty() {
		return radioRequiredPropertyRadioViewer.getSelection();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.RadioSamplePropertiesEditionPart#initRadioRequiredProperty(EEnum eenum, Enumerator current)
	 */
	public void initRadioRequiredProperty(EEnum eenum, Enumerator current) {
		radioRequiredPropertyRadioViewer.setInput(eenum.getELiterals());
		radioRequiredPropertyRadioViewer.setSelection(current);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.RadioSamplePropertiesEditionPart#setRadioRequiredProperty(Object newValue)
	 * 
	 */
	public void setRadioRequiredProperty(Object newValue) {
		radioRequiredPropertyRadioViewer.setSelection(newValue);
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.RadioSamplePropertiesEditionPart#getRadioOptionalProperty()
	 * 
	 */
	public Object getRadioOptionalProperty() {
		return radioOptionalPropertyRadioViewer.getSelection();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.RadioSamplePropertiesEditionPart#initRadioOptionalProperty(EEnum eenum, Enumerator current)
	 */
	public void initRadioOptionalProperty(EEnum eenum, Enumerator current) {
		radioOptionalPropertyRadioViewer.setInput(eenum.getELiterals());
		radioOptionalPropertyRadioViewer.setSelection(current);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.RadioSamplePropertiesEditionPart#setRadioOptionalProperty(Object newValue)
	 * 
	 */
	public void setRadioOptionalProperty(Object newValue) {
		radioOptionalPropertyRadioViewer.setSelection(newValue);
	}




	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EefnrMessages.RadioSample_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
