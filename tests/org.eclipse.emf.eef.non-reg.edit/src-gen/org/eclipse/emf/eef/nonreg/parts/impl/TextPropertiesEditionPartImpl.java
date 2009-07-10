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
import org.eclipse.emf.eef.nonreg.parts.TextPropertiesEditionPart;

import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;

// End of user code
/**
 * 
 */
public class TextPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, TextPropertiesEditionPart {

	protected Text text;
	protected Text textRO;




	
	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public TextPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		createTextText(view);
		createTextROText(view);

		// Start of user code for additional ui definition
		
		// End of user code
	}

	protected void createTextText(Composite parent) {
		SWTUtils.createPartLabel(parent, NonregMessages.TextPropertiesEditionPart_TextLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.Text.text, NonregViewsRepository.SWT_KIND));
		text = new Text(parent, SWT.BORDER);
		GridData textData = new GridData(GridData.FILL_HORIZONTAL);
		text.setLayoutData(textData);
		text.addModifyListener(new ModifyListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TextPropertiesEditionPartImpl.this, NonregViewsRepository.Text.text, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, text.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Text.text, NonregViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createTextROText(Composite parent) {
		SWTUtils.createPartLabel(parent, NonregMessages.TextPropertiesEditionPart_TextROLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.Text.textRO, NonregViewsRepository.SWT_KIND));
		textRO = new Text(parent, SWT.BORDER);
		textRO.setEnabled(false);
		textRO.setToolTipText(NonregMessages.Text_ReadOnly);
		GridData textROData = new GridData(GridData.FILL_HORIZONTAL);
		textRO.setLayoutData(textROData);
		textRO.addModifyListener(new ModifyListener() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TextPropertiesEditionPartImpl.this, NonregViewsRepository.Text.textRO, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, textRO.getText()));
			}
			
		});

		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Text.textRO, NonregViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}


	public void firePropertiesChanged(PropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.TextPropertiesEditionPart#getText()
	 */
	public String getText() {
		return text.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.TextPropertiesEditionPart#setText(String newValue)
	 */
	public void setText(String newValue) {
		if (newValue != null) {
			text.setText(newValue);
		} else {
			text.setText("");  //$NON-NLS-1$
		}
	}

	public void setMessageForText(String msg, int msgLevel) {

	}

	public void unsetMessageForText() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.TextPropertiesEditionPart#getTextRO()
	 */
	public String getTextRO() {
		return textRO.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.TextPropertiesEditionPart#setTextRO(String newValue)
	 */
	public void setTextRO(String newValue) {
		if (newValue != null) {
			textRO.setText(newValue);
		} else {
			textRO.setText("");  //$NON-NLS-1$
		}
	}

	public void setMessageForTextRO(String msg, int msgLevel) {

	}

	public void unsetMessageForTextRO() {

	}








	// Start of user code additional methods
	
	// End of user code
}
