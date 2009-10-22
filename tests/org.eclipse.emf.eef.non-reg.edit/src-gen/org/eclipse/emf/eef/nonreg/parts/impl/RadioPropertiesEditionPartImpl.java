/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.parts.impl;

// Start of user code for imports

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;
import org.eclipse.emf.eef.nonreg.parts.RadioPropertiesEditionPart;
import org.eclipse.emf.eef.nonreg.providers.NonregMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.RadioViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

// End of user code

/**
 * 
 */
public class RadioPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, RadioPropertiesEditionPart {

	protected RadioViewer radioRadioViewer;
	protected RadioViewer radioRORadioViewer;




	
	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public RadioPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Radio.radio, NonregViewsRepository.SWT_KIND), null);
	}
	protected void createRadioRORadioViewer(Composite parent) {
		radioRORadioViewer = new RadioViewer(parent, SWT.CHECK);
		radioRORadioViewer.setEnabled(false);
		radioRORadioViewer.setToolTipText(NonregMessages.Radio_ReadOnly);
		GridData radioROData = new GridData(GridData.FILL_HORIZONTAL);
		radioROData.horizontalSpan = 2;
		radioRORadioViewer.setLayoutData(radioROData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Radio.radioRO, NonregViewsRepository.SWT_KIND), null);
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

	public void setMessageForRadio(String msg, int msgLevel) {

	}

	public void unsetMessageForRadio() {

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

	public void setMessageForRadioRO(String msg, int msgLevel) {

	}

	public void unsetMessageForRadioRO() {

	}








	// Start of user code additional methods
	
	// End of user code

}
