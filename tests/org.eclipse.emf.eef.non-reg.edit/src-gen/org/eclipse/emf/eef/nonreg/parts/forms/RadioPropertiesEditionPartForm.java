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
import org.eclipse.emf.eef.nonreg.parts.RadioPropertiesEditionPart;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.RadioViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;

// End of user code
/**
 * 
 */
public class RadioPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, RadioPropertiesEditionPart {

	protected RadioViewer radioRadioViewer;
	protected RadioViewer radioRORadioViewer;




	
	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public RadioPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		createRadioRadioViewer(view);
		createRadioRORadioViewer(view);
		// Start of user code for additional ui definition
		
		// End of user code		
	}

	protected void createRadioRadioViewer(Composite parent) {
		radioRadioViewer = new RadioViewer(parent, SWT.CHECK);
		GridData radioData = new GridData(GridData.FILL_HORIZONTAL);
		radioData.horizontalSpan = 2;
		radioRadioViewer.setLayoutData(radioData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Radio.radio, NonregViewsRepository.FORM_KIND), null);
	}
	protected void createRadioRORadioViewer(Composite parent) {
		radioRORadioViewer = new RadioViewer(parent, SWT.CHECK);
		radioRORadioViewer.setEnabled(false);
		radioRORadioViewer.setToolTipText(NonregMessages.Radio_ReadOnly);
		GridData radioROData = new GridData(GridData.FILL_HORIZONTAL);
		radioROData.horizontalSpan = 2;
		radioRORadioViewer.setLayoutData(radioROData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Radio.radioRO, NonregViewsRepository.FORM_KIND), null);
	}

	
	public void firePropertiesChanged(PropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.RadioPropertiesEditionPart#getRadio()
	 */
	public Object getRadio() {
		return radioRadioViewer.getSelection();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.RadioPropertiesEditionPart#initRadio(EEnum eenum, Enumerator current)
	 */
	public void initRadio(EEnum eenum, Enumerator current) {
		radioRadioViewer.setInput(eenum.getELiterals());
		radioRadioViewer.setSelection(current);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.RadioPropertiesEditionPart#setRadio(Object newValue)
	 */
	public void setRadio(Object newValue) {
		radioRadioViewer.setSelection(newValue);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.RadioPropertiesEditionPart#getRadioRO()
	 */
	public Object getRadioRO() {
		return radioRORadioViewer.getSelection();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.RadioPropertiesEditionPart#initRadioRO(EEnum eenum, Enumerator current)
	 */
	public void initRadioRO(EEnum eenum, Enumerator current) {
		radioRORadioViewer.setInput(eenum.getELiterals());
		radioRORadioViewer.setSelection(current);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.RadioPropertiesEditionPart#setRadioRO(Object newValue)
	 */
	public void setRadioRO(Object newValue) {
		radioRORadioViewer.setSelection(newValue);
	}











	
	// Start of user code additional methods
	
	// End of user code
}	
