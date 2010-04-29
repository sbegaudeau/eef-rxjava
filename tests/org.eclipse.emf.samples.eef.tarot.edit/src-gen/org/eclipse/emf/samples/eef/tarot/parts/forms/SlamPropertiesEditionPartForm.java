/**
 * Generated with Acceleo
 */
package org.eclipse.emf.samples.eef.tarot.parts.forms;

// Start of user code for imports

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.util.EcoreAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.samples.eef.tarot.parts.SlamPropertiesEditionPart;
import org.eclipse.emf.samples.eef.tarot.parts.TarotViewsRepository;
import org.eclipse.emf.samples.eef.tarot.providers.TarotMessages;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;


// End of user code

/**
 * 
 * 
 */
public class SlamPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, SlamPropertiesEditionPart {

	protected EMFComboViewer side;
	protected Button announced;
	protected Button achieved;



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public SlamPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 * 
	 */
	public Composite createFigure(final Composite parent, final FormToolkit widgetFactory) {
		ScrolledForm scrolledForm = widgetFactory.createScrolledForm(parent);
		Form form = scrolledForm.getForm();
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(widgetFactory, view);
		return scrolledForm;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		createPropertiesGroup(widgetFactory, view);

		// Start of user code for additional ui definition
		
		// End of user code
	}
	/**
	 * 
	 */
	protected void createPropertiesGroup(FormToolkit widgetFactory, final Composite view) {
		Section propertiesSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(TarotMessages.SlamPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createSideEMFComboViewer(widgetFactory, propertiesGroup);
		createAnnouncedCheckbox(widgetFactory, propertiesGroup);
		createAchievedCheckbox(widgetFactory, propertiesGroup);
		propertiesSection.setClient(propertiesGroup);
	}

	
	protected void createSideEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, TarotMessages.SlamPropertiesEditionPart_SideLabel, propertiesEditionComponent.isRequired(TarotViewsRepository.Slam.side, TarotViewsRepository.FORM_KIND));
		side = new EMFComboViewer(parent);
		side.setContentProvider(new ArrayContentProvider());
		side.setLabelProvider(new AdapterFactoryLabelProvider(new EcoreAdapterFactory()));
		GridData sideData = new GridData(GridData.FILL_HORIZONTAL);
		side.getCombo().setLayoutData(sideData);
		side.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SlamPropertiesEditionPartForm.this, TarotViewsRepository.Slam.side, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSide()));
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(TarotViewsRepository.Slam.side, TarotViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	
	protected void createAnnouncedCheckbox(FormToolkit widgetFactory, Composite parent) {
		announced = widgetFactory.createButton(parent, TarotMessages.SlamPropertiesEditionPart_AnnouncedLabel, SWT.CHECK);
		announced.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SlamPropertiesEditionPartForm.this, TarotViewsRepository.Slam.announced, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(announced.getSelection())));
			}

		});
		GridData announcedData = new GridData(GridData.FILL_HORIZONTAL);
		announcedData.horizontalSpan = 2;
		announced.setLayoutData(announcedData);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(TarotViewsRepository.Slam.announced, TarotViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	
	protected void createAchievedCheckbox(FormToolkit widgetFactory, Composite parent) {
		achieved = widgetFactory.createButton(parent, TarotMessages.SlamPropertiesEditionPart_AchievedLabel, SWT.CHECK);
		achieved.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(SlamPropertiesEditionPartForm.this, TarotViewsRepository.Slam.achieved, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(achieved.getSelection())));
			}

		});
		GridData achievedData = new GridData(GridData.FILL_HORIZONTAL);
		achievedData.horizontalSpan = 2;
		achieved.setLayoutData(achievedData);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(TarotViewsRepository.Slam.achieved, TarotViewsRepository.FORM_KIND), null); //$NON-NLS-1$
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
	 * @see org.eclipse.emf.samples.eef.tarot.parts.SlamPropertiesEditionPart#getSide()
	 * 
	 */
	public Enumerator getSide() {
		EEnumLiteral selection = (EEnumLiteral) ((StructuredSelection) side.getSelection()).getFirstElement();
		return selection.getInstance();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.SlamPropertiesEditionPart#initSide(EEnum eenum, Enumerator current)
	 */
	public void initSide(EEnum eenum, Enumerator current) {
		side.setInput(eenum.getELiterals());
		side.modelUpdating(new StructuredSelection(current));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.SlamPropertiesEditionPart#setSide(Enumerator newValue)
	 * 
	 */
	public void setSide(Enumerator newValue) {
		side.modelUpdating(new StructuredSelection(newValue));
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.SlamPropertiesEditionPart#getAnnounced()
	 * 
	 */
	public Boolean getAnnounced() {
		return Boolean.valueOf(announced.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.SlamPropertiesEditionPart#setAnnounced(Boolean newValue)
	 * 
	 */
	public void setAnnounced(Boolean newValue) {
		if (newValue != null) {
			announced.setSelection(newValue.booleanValue());
		} else {
			announced.setSelection(false);
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.SlamPropertiesEditionPart#getAchieved()
	 * 
	 */
	public Boolean getAchieved() {
		return Boolean.valueOf(achieved.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.SlamPropertiesEditionPart#setAchieved(Boolean newValue)
	 * 
	 */
	public void setAchieved(Boolean newValue) {
		if (newValue != null) {
			achieved.setSelection(newValue.booleanValue());
		} else {
			achieved.setSelection(false);
		}
	}




	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return TarotMessages.Slam_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
