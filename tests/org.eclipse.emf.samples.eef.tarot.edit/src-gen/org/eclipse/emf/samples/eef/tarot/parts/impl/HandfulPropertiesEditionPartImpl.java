/**
 * Generated with Acceleo
 */
package org.eclipse.emf.samples.eef.tarot.parts.impl;

// Start of user code for imports

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.util.EcoreAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.samples.eef.tarot.parts.HandfulPropertiesEditionPart;
import org.eclipse.emf.samples.eef.tarot.parts.TarotViewsRepository;
import org.eclipse.emf.samples.eef.tarot.providers.TarotMessages;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

// End of user code	

/**
 * 
 * 
 */
public class HandfulPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, HandfulPropertiesEditionPart {

	protected EMFComboViewer side;
	protected EMFComboViewer size;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public HandfulPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite)
	 * 
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
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createControls(org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(Composite view) { 
		createPropertiesGroup(view);


		// Start of user code for additional ui definition
		
		// End of user code
	}

	/**
	 * 
	 */
	protected void createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(TarotMessages.HandfulPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createSideEMFComboViewer(propertiesGroup);
		createSizeEMFComboViewer(propertiesGroup);
	}

	
	protected void createSideEMFComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, TarotMessages.HandfulPropertiesEditionPart_SideLabel, propertiesEditionComponent.isRequired(TarotViewsRepository.Handful.side, TarotViewsRepository.SWT_KIND));
		side = new EMFComboViewer(parent);
		side.setContentProvider(new ArrayContentProvider());
		side.setLabelProvider(new AdapterFactoryLabelProvider(new EcoreAdapterFactory()));
		GridData sideData = new GridData(GridData.FILL_HORIZONTAL);
		side.getCombo().setLayoutData(sideData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(TarotViewsRepository.Handful.side, TarotViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}

	
	protected void createSizeEMFComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, TarotMessages.HandfulPropertiesEditionPart_SizeLabel, propertiesEditionComponent.isRequired(TarotViewsRepository.Handful.size, TarotViewsRepository.SWT_KIND));
		size = new EMFComboViewer(parent);
		size.setContentProvider(new ArrayContentProvider());
		size.setLabelProvider(new AdapterFactoryLabelProvider(new EcoreAdapterFactory()));
		GridData sizeData = new GridData(GridData.FILL_HORIZONTAL);
		size.getCombo().setLayoutData(sizeData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(TarotViewsRepository.Handful.size, TarotViewsRepository.SWT_KIND), null); //$NON-NLS-1$
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
	 * @see org.eclipse.emf.samples.eef.tarot.parts.HandfulPropertiesEditionPart#getSide()
	 * 
	 */
	public Enumerator getSide() {
		EEnumLiteral selection = (EEnumLiteral) ((StructuredSelection) side.getSelection()).getFirstElement();
		return selection.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.HandfulPropertiesEditionPart#initSide(EEnum eenum, Enumerator current)
	 */
	public void initSide(EEnum eenum, Enumerator current) {
		side.setInput(eenum.getELiterals());
		side.modelUpdating(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.HandfulPropertiesEditionPart#setSide(Enumerator newValue)
	 * 
	 */
	public void setSide(Enumerator newValue) {
		side.modelUpdating(new StructuredSelection(newValue));
	}

	public void setMessageForSide(String msg, int msgLevel) {

	}

	public void unsetMessageForSide() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.HandfulPropertiesEditionPart#getSize()
	 * 
	 */
	public Enumerator getSize() {
		EEnumLiteral selection = (EEnumLiteral) ((StructuredSelection) size.getSelection()).getFirstElement();
		return selection.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.HandfulPropertiesEditionPart#initSize(EEnum eenum, Enumerator current)
	 */
	public void initSize(EEnum eenum, Enumerator current) {
		size.setInput(eenum.getELiterals());
		size.modelUpdating(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.HandfulPropertiesEditionPart#setSize(Enumerator newValue)
	 * 
	 */
	public void setSize(Enumerator newValue) {
		size.modelUpdating(new StructuredSelection(newValue));
	}

	public void setMessageForSize(String msg, int msgLevel) {

	}

	public void unsetMessageForSize() {

	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return TarotMessages.Handful_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
