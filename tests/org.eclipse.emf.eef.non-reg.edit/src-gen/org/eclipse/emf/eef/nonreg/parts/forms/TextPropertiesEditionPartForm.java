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
import org.eclipse.emf.eef.nonreg.parts.TextPropertiesEditionPart;

import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;

// End of user code
/**
 * 
 */
public class TextPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, TextPropertiesEditionPart {

	protected Text text;
	protected Text textRO;




	
	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public TextPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		createTextText(widgetFactory, view);
		createTextROText(widgetFactory, view);
		// Start of user code for additional ui definition
		
		// End of user code		
	}

	protected void createTextText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, NonregMessages.TextPropertiesEditionPart_TextLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.Text.text, NonregViewsRepository.FORM_KIND));
		text = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		text.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData textData = new GridData(GridData.FILL_HORIZONTAL);
		text.setLayoutData(textData);
		text.addModifyListener(new ModifyListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TextPropertiesEditionPartForm.this, NonregViewsRepository.Text.text, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, text.getText()));
			}

		});
		text.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TextPropertiesEditionPartForm.this, NonregViewsRepository.Text.text, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, text.getText()));
			}

		});
		text.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 */
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TextPropertiesEditionPartForm.this, NonregViewsRepository.Text.text, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, text.getText()));
				}
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Text.text, NonregViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}
	protected void createTextROText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, NonregMessages.TextPropertiesEditionPart_TextROLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.Text.textRO, NonregViewsRepository.FORM_KIND));
		textRO = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		textRO.setEnabled(false);
		textRO.setToolTipText(NonregMessages.Text_ReadOnly);
		textRO.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData textROData = new GridData(GridData.FILL_HORIZONTAL);
		textRO.setLayoutData(textROData);
		textRO.addModifyListener(new ModifyListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.ModifyListener#modifyText(org.eclipse.swt.events.ModifyEvent)
			 */
			public void modifyText(ModifyEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TextPropertiesEditionPartForm.this, NonregViewsRepository.Text.textRO, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, textRO.getText()));
			}

		});
		textRO.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TextPropertiesEditionPartForm.this, NonregViewsRepository.Text.textRO, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, textRO.getText()));
			}

		});
		textRO.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 */
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(TextPropertiesEditionPartForm.this, NonregViewsRepository.Text.textRO, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, textRO.getText()));
				}
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Text.textRO, NonregViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
		messageManager.addMessage("Text_key", msg, null, msgLevel, text);
	}

	public void unsetMessageForText() {
		messageManager.removeMessage("Text_key", text);
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
		messageManager.addMessage("TextRO_key", msg, null, msgLevel, textRO);
	}

	public void unsetMessageForTextRO() {
		messageManager.removeMessage("TextRO_key", textRO);
	}







	
	// Start of user code additional methods
	
	// End of user code
}	
