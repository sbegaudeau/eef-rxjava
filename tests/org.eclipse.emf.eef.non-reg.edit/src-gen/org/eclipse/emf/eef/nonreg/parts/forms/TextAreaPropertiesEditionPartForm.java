/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.parts.forms;

// Start of user code for imports

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
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

import org.eclipse.emf.eef.nonreg.NonregPackage;
import org.eclipse.emf.eef.nonreg.providers.NonregMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.api.parts.EEFMessageManager;
import org.eclipse.emf.eef.nonreg.parts.TextAreaPropertiesEditionPart;

import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;

// End of user code

/**
 * 
 */
public class TextAreaPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, TextAreaPropertiesEditionPart {

	protected Text textarea;
	protected Text textareaRO;




	
	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public TextAreaPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 */
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
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 * 			createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.IMessageManager)
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view, IMessageManager messageManager) {
		this.messageManager = messageManager;
		createTextareaTextarea(widgetFactory, view);
		createTextareaROTextarea(widgetFactory, view);
		// Start of user code for additional ui definition
		
		// End of user code
		
	}

	protected void createTextareaTextarea(FormToolkit widgetFactory, Composite parent) {
		Label textareaLabel = FormUtils.createPartLabel(widgetFactory, parent, NonregMessages.TextAreaPropertiesEditionPart_TextareaLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.TextArea.textarea, NonregViewsRepository.FORM_KIND));
		GridData textareaLabelData = new GridData(GridData.FILL_HORIZONTAL);
		textareaLabelData.horizontalSpan = 3;
		textareaLabel.setLayoutData(textareaLabelData);
		textarea = widgetFactory.createText(parent, "", SWT.BORDER | SWT.WRAP | SWT.MULTI); //$NON-NLS-1$
		GridData textareaData = new GridData(GridData.FILL_HORIZONTAL);
		textareaData.horizontalSpan = 2;
		textareaData.heightHint = 80;
		textarea.setLayoutData(textareaData);
		textarea.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TextAreaPropertiesEditionPartForm.this, NonregViewsRepository.TextArea.textarea, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, textarea.getText()));
			}

		});
		textarea.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 */
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TextAreaPropertiesEditionPartForm.this, NonregViewsRepository.TextArea.textarea, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, textarea.getText()));
				}
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.TextArea.textarea, NonregViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}
	protected void createTextareaROTextarea(FormToolkit widgetFactory, Composite parent) {
		Label textareaROLabel = FormUtils.createPartLabel(widgetFactory, parent, NonregMessages.TextAreaPropertiesEditionPart_TextareaROLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.TextArea.textareaRO, NonregViewsRepository.FORM_KIND));
		GridData textareaROLabelData = new GridData(GridData.FILL_HORIZONTAL);
		textareaROLabelData.horizontalSpan = 3;
		textareaROLabel.setLayoutData(textareaROLabelData);
		textareaRO = widgetFactory.createText(parent, "", SWT.BORDER | SWT.WRAP | SWT.MULTI); //$NON-NLS-1$
		textareaRO.setEnabled(false);
		textareaRO.setToolTipText(NonregMessages.TextArea_ReadOnly);
		GridData textareaROData = new GridData(GridData.FILL_HORIZONTAL);
		textareaROData.horizontalSpan = 2;
		textareaROData.heightHint = 80;
		textareaRO.setLayoutData(textareaROData);
		textareaRO.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TextAreaPropertiesEditionPartForm.this, NonregViewsRepository.TextArea.textareaRO, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, textareaRO.getText()));
			}

		});
		textareaRO.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 */
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TextAreaPropertiesEditionPartForm.this, NonregViewsRepository.TextArea.textareaRO, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, textareaRO.getText()));
				}
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.TextArea.textareaRO, NonregViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
		messageManager.addMessage("Textarea_key", msg, null, msgLevel, textarea);
	}

	public void unsetMessageForTextarea() {
		messageManager.removeMessage("Textarea_key", textarea);
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
		messageManager.addMessage("TextareaRO_key", msg, null, msgLevel, textareaRO);
	}

	public void unsetMessageForTextareaRO() {
		messageManager.removeMessage("TextareaRO_key", textareaRO);
	}







	
	// Start of user code additional methods
	
	// End of user code

}	
