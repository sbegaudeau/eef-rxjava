/**
 * Generated with Acceleo
 */
package org.eclipse.emf.samples.eef.tarot.parts.impl;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.samples.eef.tarot.parts.MiserePropertiesEditionPart;
import org.eclipse.emf.samples.eef.tarot.parts.TarotViewsRepository;
import org.eclipse.emf.samples.eef.tarot.providers.TarotMessages;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

// End of user code

/**
 * 
 */
public class MiserePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, MiserePropertiesEditionPart {

	protected EObjectFlatComboViewer declarer;





	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public MiserePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
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
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart#
	 * 			createControls(org.eclipse.swt.widgets.Composite)
	 */
	public void createControls(Composite view) { 
		createPropertiesGroup(view);


		// Start of user code for additional ui definition
		
		// End of user code

	}

	protected void createPropertiesGroup(Composite parent) {
		Group propertiesGroup = new Group(parent, SWT.NONE);
		propertiesGroup.setText(TarotMessages.MiserePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createDeclarerFlatComboViewer(propertiesGroup);
	}

	/**
	 * @param propertiesGroup
	 */
	protected void createDeclarerFlatComboViewer(Composite parent) {
		SWTUtils.createPartLabel(parent, TarotMessages.MiserePropertiesEditionPart_DeclarerLabel, propertiesEditionComponent.isRequired(TarotViewsRepository.Misere.declarer, TarotViewsRepository.SWT_KIND));
		declarer = new EObjectFlatComboViewer(parent, false);
		declarer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

		declarer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(MiserePropertiesEditionPartImpl.this, TarotViewsRepository.Misere.declarer, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, null, getDeclarer()));
			}

		});
		GridData declarerData = new GridData(GridData.FILL_HORIZONTAL);
		declarer.setLayoutData(declarerData);
		SWTUtils.createHelpButton(parent, propertiesEditionComponent.getHelpContent(TarotViewsRepository.Misere.declarer, TarotViewsRepository.SWT_KIND), null); //$NON-NLS-1$
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.MiserePropertiesEditionPart#getDeclarer()
	 */
	public EObject getDeclarer() {
		if (declarer.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) declarer.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.MiserePropertiesEditionPart#initDeclarer(ResourceSet allResources, EObject current)
	 */
	public void initDeclarer(ResourceSet allResources, EObject current) {
		declarer.setInput(allResources);
		if (current != null) {
			declarer.setSelection(new StructuredSelection(current));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.MiserePropertiesEditionPart#setDeclarer(EObject newValue)
	 */
	public void setDeclarer(EObject newValue) {
		if (newValue != null) {
			declarer.setSelection(new StructuredSelection(newValue));
		} else {
			declarer.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.MiserePropertiesEditionPart#setDeclarerButtonMode(ButtonsModeEnum newValue)
	 */
	public void setDeclarerButtonMode(ButtonsModeEnum newValue) {
		declarer.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.MiserePropertiesEditionPart#addFilterDeclarer(ViewerFilter filter)
	 */
	public void addFilterToDeclarer(ViewerFilter filter) {
		declarer.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.MiserePropertiesEditionPart#addBusinessFilterDeclarer(ViewerFilter filter)
	 */
	public void addBusinessFilterToDeclarer(ViewerFilter filter) {
		declarer.addBusinessRuleFilter(filter);
	}

	public void setMessageForDeclarer(String msg, int msgLevel) {

	}

	public void unsetMessageForDeclarer() {

	}








	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 */
	public String getTitle() {
		return TarotMessages.Misere_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code

}
