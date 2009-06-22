/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.ab.abstractnonreg.parts.forms;

// Start of user code for imports

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IMessageManager;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.emf.eef.ab.abstractnonreg.providers.AbstractnonregMessages;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.api.parts.EEFMessageManager;
import org.eclipse.emf.eef.ab.abstractnonreg.parts.DocumentedElementPropertiesEditionPart;


import org.eclipse.emf.eef.ab.abstractnonreg.parts.AbstractnonregViewsRepository;

// End of user code
/**
 * 
 */
public class DocumentedElementPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, DocumentedElementPropertiesEditionPart {

	protected Text documentation;




	
	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public DocumentedElementPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		createDocumentationGroup(widgetFactory, view);
		// Start of user code for additional ui definition
		
		// End of user code		
	}

	protected void createDocumentationGroup(FormToolkit widgetFactory, final Composite view) {
		Section documentationSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		documentationSection.setText(AbstractnonregMessages.DocumentedElementPropertiesEditionPart_DocumentationGroupLabel);
		GridData documentationSectionData = new GridData(GridData.FILL_HORIZONTAL);
		documentationSectionData.horizontalSpan = 3;
		documentationSection.setLayoutData(documentationSectionData);
		Composite documentationGroup = widgetFactory.createComposite(documentationSection);
		GridLayout documentationGroupLayout = new GridLayout();
		documentationGroupLayout.numColumns = 3;
		documentationGroup.setLayout(documentationGroupLayout);
		createDocumentationTextarea(widgetFactory, documentationGroup);
		documentationSection.setClient(documentationGroup);
	}
	protected void createDocumentationTextarea(FormToolkit widgetFactory, Composite parent) {
		Label documentationLabel = FormUtils.createPartLabel(widgetFactory, parent, AbstractnonregMessages.DocumentedElementPropertiesEditionPart_DocumentationLabel, propertiesEditionComponent.isRequired(AbstractnonregViewsRepository.DocumentedElement.documentation, AbstractnonregViewsRepository.FORM_KIND));
		GridData documentationLabelData = new GridData(GridData.FILL_HORIZONTAL);
		documentationLabelData.horizontalSpan = 3;
		documentationLabel.setLayoutData(documentationLabelData);
		documentation = widgetFactory.createText(parent, "", SWT.BORDER | SWT.WRAP | SWT.MULTI); //$NON-NLS-1$
		GridData documentationData = new GridData(GridData.FILL_HORIZONTAL);
		documentationData.horizontalSpan = 2;
		documentationData.heightHint = 80;
		documentation.setLayoutData(documentationData);
		documentation.addFocusListener(new FocusAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 */
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DocumentedElementPropertiesEditionPartForm.this, AbstractnonregViewsRepository.DocumentedElement.documentation, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, documentation.getText()));
			}

		});
		documentation.addKeyListener(new KeyAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 */
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(DocumentedElementPropertiesEditionPartForm.this, AbstractnonregViewsRepository.DocumentedElement.documentation, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, documentation.getText()));
				}
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(AbstractnonregViewsRepository.DocumentedElement.documentation, AbstractnonregViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		
	}

	
	public void firePropertiesChanged(PropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.ab.abstractnonreg.parts.DocumentedElementPropertiesEditionPart#getDocumentation()
	 */
	public String getDocumentation() {
		return documentation.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.ab.abstractnonreg.parts.DocumentedElementPropertiesEditionPart#setDocumentation(String newValue)
	 */
	public void setDocumentation(String newValue) {
		if (newValue != null) {
			documentation.setText(newValue);
		} else {
			documentation.setText("");  //$NON-NLS-1$
		}
	}

	public void setMessageForDocumentation(String msg, int msgLevel) {
		messageManager.addMessage("Documentation_key", msg, null, msgLevel, documentation);
	}

	public void unsetMessageForDocumentation() {
		messageManager.removeMessage("Documentation_key", documentation);
	}







	
	// Start of user code additional methods
	
	// End of user code
}	
