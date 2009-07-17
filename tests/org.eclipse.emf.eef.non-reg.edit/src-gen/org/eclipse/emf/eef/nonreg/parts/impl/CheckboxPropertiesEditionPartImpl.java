/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.parts.impl;

// Start of user code for imports

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import org.eclipse.emf.eef.nonreg.NonregPackage;
import org.eclipse.emf.eef.nonreg.providers.NonregMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.nonreg.parts.CheckboxPropertiesEditionPart;

import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;

// End of user code

/**
 * 
 */
public class CheckboxPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, CheckboxPropertiesEditionPart {

	protected Button checkbox;
	protected Button checkboxRO;




	
	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public CheckboxPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite)
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
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createControls(org.eclipse.swt.widgets.Composite)
	 */
	public void createControls(Composite view) { 
		createCheckboxCheckbox(view);
		createCheckboxROCheckbox(view);

		// Start of user code for additional ui definition
		
		// End of user code

	}

	protected void createCheckboxCheckbox(Composite parent) {
		checkbox = new Button(parent, SWT.CHECK);
		checkbox.setText(NonregMessages.CheckboxPropertiesEditionPart_CheckboxLabel);
		GridData checkboxData = new GridData(GridData.FILL_HORIZONTAL);
		checkboxData.horizontalSpan = 2;
		checkbox.setLayoutData(checkboxData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Checkbox.checkbox, NonregViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createCheckboxROCheckbox(Composite parent) {
		checkboxRO = new Button(parent, SWT.CHECK);
		checkboxRO.setText(NonregMessages.CheckboxPropertiesEditionPart_CheckboxROLabel);
		checkboxRO.setEnabled(false);
		checkboxRO.setToolTipText(NonregMessages.Checkbox_ReadOnly);
		GridData checkboxROData = new GridData(GridData.FILL_HORIZONTAL);
		checkboxROData.horizontalSpan = 2;
		checkboxRO.setLayoutData(checkboxROData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Checkbox.checkboxRO, NonregViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}


	public void firePropertiesChanged(PropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.CheckboxPropertiesEditionPart#getCheckbox()
	 */
	public Boolean getCheckbox() {
		return Boolean.valueOf(checkbox.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.CheckboxPropertiesEditionPart#setCheckbox(Boolean newValue)
	 */
	public void setCheckbox(Boolean newValue) {
		if (newValue != null) {
			checkbox.setSelection(newValue.booleanValue());
		} else {
			checkbox.setSelection(false);
		}
	}

	public void setMessageForCheckbox(String msg, int msgLevel) {

	}

	public void unsetMessageForCheckbox() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.CheckboxPropertiesEditionPart#getCheckboxRO()
	 */
	public Boolean getCheckboxRO() {
		return Boolean.valueOf(checkboxRO.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.CheckboxPropertiesEditionPart#setCheckboxRO(Boolean newValue)
	 */
	public void setCheckboxRO(Boolean newValue) {
		if (newValue != null) {
			checkboxRO.setSelection(newValue.booleanValue());
		} else {
			checkboxRO.setSelection(false);
		}
	}

	public void setMessageForCheckboxRO(String msg, int msgLevel) {

	}

	public void unsetMessageForCheckboxRO() {

	}








	// Start of user code additional methods
	
	// End of user code

}
