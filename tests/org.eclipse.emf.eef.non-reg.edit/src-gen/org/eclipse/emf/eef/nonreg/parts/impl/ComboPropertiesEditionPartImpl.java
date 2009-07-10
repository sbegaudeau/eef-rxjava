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
import org.eclipse.emf.eef.nonreg.parts.ComboPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.providers.EMFListContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;

// End of user code
/**
 * 
 */
public class ComboPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, ComboPropertiesEditionPart {

	protected EMFComboViewer combo;
	protected EMFComboViewer comboRO;




	
	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public ComboPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		createComboEMFComboViewer(view);
		createComboROEMFComboViewer(view);

		// Start of user code for additional ui definition
		
		// End of user code
	}

	protected void createComboEMFComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, NonregMessages.ComboPropertiesEditionPart_ComboLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.Combo.combo, NonregViewsRepository.SWT_KIND));
		combo = new EMFComboViewer(parent);
		GridData comboData = new GridData(GridData.FILL_HORIZONTAL);
		combo.getCombo().setLayoutData(comboData);
		combo.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		combo.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComboPropertiesEditionPartImpl.this, NonregViewsRepository.Combo.combo, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getCombo()));
			}
			
		});
		combo.setContentProvider(new EMFListContentProvider());
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Combo.combo, NonregViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}
	protected void createComboROEMFComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, NonregMessages.ComboPropertiesEditionPart_ComboROLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.Combo.comboRO, NonregViewsRepository.SWT_KIND));
		comboRO = new EMFComboViewer(parent);
		comboRO.setEnabled(false);
		comboRO.setToolTipText(NonregMessages.Combo_ReadOnly);
		GridData comboROData = new GridData(GridData.FILL_HORIZONTAL);
		comboRO.getCombo().setLayoutData(comboROData);
		comboRO.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		comboRO.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ComboPropertiesEditionPartImpl.this, NonregViewsRepository.Combo.comboRO, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getComboRO()));
			}
			
		});
		comboRO.setContentProvider(new EMFListContentProvider());
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(NonregViewsRepository.Combo.comboRO, NonregViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}


	public void firePropertiesChanged(PropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.ComboPropertiesEditionPart#getCombo()
	 */
	public Object getCombo() {
		if (combo.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) combo.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return "";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.ComboPropertiesEditionPart#initCombo(ResourceSet allResources, EObject current)
	 */
	public void initCombo(ResourceSet allResources, EObject current) {
		combo.setInput(allResources);
		if (current != null) {
			combo.setSelection(new StructuredSelection(current));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.ComboPropertiesEditionPart#setCombo(Object newValue)
	 */
	public void setCombo(Object newValue) {
		if (newValue != null) {
			combo.modelUpdating(new StructuredSelection(newValue));
		} else {
			combo.modelUpdating(new StructuredSelection("")); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.ComboPropertiesEditionPart#addFilterCombo(ViewerFilter filter)
	 */
	public void addFilterToCombo(ViewerFilter filter) {
		combo.addFilter(filter);
	}

	public void setMessageForCombo(String msg, int msgLevel) {

	}

	public void unsetMessageForCombo() {

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.ComboPropertiesEditionPart#getComboRO()
	 */
	public Object getComboRO() {
		if (comboRO.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) comboRO.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return "";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.ComboPropertiesEditionPart#initComboRO(ResourceSet allResources, EObject current)
	 */
	public void initComboRO(ResourceSet allResources, EObject current) {
		comboRO.setInput(allResources);
		if (current != null) {
			comboRO.setSelection(new StructuredSelection(current));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.ComboPropertiesEditionPart#setComboRO(Object newValue)
	 */
	public void setComboRO(Object newValue) {
		if (newValue != null) {
			comboRO.modelUpdating(new StructuredSelection(newValue));
		} else {
			comboRO.modelUpdating(new StructuredSelection("")); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.ComboPropertiesEditionPart#addFilterComboRO(ViewerFilter filter)
	 */
	public void addFilterToComboRO(ViewerFilter filter) {
		comboRO.addFilter(filter);
	}

	public void setMessageForComboRO(String msg, int msgLevel) {

	}

	public void unsetMessageForComboRO() {

	}








	// Start of user code additional methods
	
	// End of user code
}
