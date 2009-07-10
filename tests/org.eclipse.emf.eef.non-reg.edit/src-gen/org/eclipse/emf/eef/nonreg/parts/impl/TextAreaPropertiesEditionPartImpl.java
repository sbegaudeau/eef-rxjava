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
import org.eclipse.emf.eef.nonreg.parts.TextAreaPropertiesEditionPart;

import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;

// End of user code
/**
 * 
 */
public class TextAreaPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, TextAreaPropertiesEditionPart {

	protected Text textarea;
	protected Text textareaRO;




	
	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public TextAreaPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		createTextareaTextarea(view);
		createTextareaROTextarea(view);

		// Start of user code for additional ui definition
		
		// End of user code
	}

	protected void createTextareaTextarea(Composite parent) {
		Label textareaLabel = SWTUtils.createPartLabel(parent, NonregMessages.TextAreaPropertiesEditionPart_TextareaLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.TextArea.textarea, NonregViewsRepository.SWT_KIND));
		GridData textareaLabelData = new GridData(GridData.FILL_HORIZONTAL);
		textareaLabelData.horizontalSpan = 3;
		textareaLabel.setLayoutData(textareaLabelData);
		textarea = new Text(parent, SWT.BORDER | SWT.WRAP | SWT.MULTI);
		GridData textareaData = new GridData(GridData.FILL_HORIZONTAL);
		textareaData.horizontalSpan = 2;
		textareaData.heightHint = 80;
		textarea.setLayoutData(textareaData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.TextArea.textarea, NonregViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createTextareaROTextarea(Composite parent) {
		Label textareaROLabel = SWTUtils.createPartLabel(parent, NonregMessages.TextAreaPropertiesEditionPart_TextareaROLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.TextArea.textareaRO, NonregViewsRepository.SWT_KIND));
		GridData textareaROLabelData = new GridData(GridData.FILL_HORIZONTAL);
		textareaROLabelData.horizontalSpan = 3;
		textareaROLabel.setLayoutData(textareaROLabelData);
		textareaRO = new Text(parent, SWT.BORDER | SWT.WRAP | SWT.MULTI);
		textareaRO.setEnabled(false);
		textareaRO.setToolTipText(NonregMessages.TextArea_ReadOnly);
		GridData textareaROData = new GridData(GridData.FILL_HORIZONTAL);
		textareaROData.horizontalSpan = 2;
		textareaROData.heightHint = 80;
		textareaRO.setLayoutData(textareaROData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.TextArea.textareaRO, NonregViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}


	public void firePropertiesChanged(PropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.TextAreaPropertiesEditionPart#getTextarea()
	 */
	public String getTextarea() {
		return textarea.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.TextAreaPropertiesEditionPart#setTextarea(String newValue)
	 */
	public void setTextarea(String newValue) {
		if (newValue != null) {
			textarea.setText(newValue);
		} else {
			textarea.setText("");  //$NON-NLS-1$
		}
	}

	public void setMessageForTextarea(String msg, int msgLevel) {

	}

	public void unsetMessageForTextarea() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.TextAreaPropertiesEditionPart#getTextareaRO()
	 */
	public String getTextareaRO() {
		return textareaRO.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.TextAreaPropertiesEditionPart#setTextareaRO(String newValue)
	 */
	public void setTextareaRO(String newValue) {
		if (newValue != null) {
			textareaRO.setText(newValue);
		} else {
			textareaRO.setText("");  //$NON-NLS-1$
		}
	}

	public void setMessageForTextareaRO(String msg, int msgLevel) {

	}

	public void unsetMessageForTextareaRO() {

	}








	// Start of user code additional methods
	
	// End of user code
}
