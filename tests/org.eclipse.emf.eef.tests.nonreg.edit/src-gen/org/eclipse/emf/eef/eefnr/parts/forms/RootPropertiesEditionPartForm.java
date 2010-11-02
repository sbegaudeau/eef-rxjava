/*******************************************************************************
 * Copyright (c) 2009 - 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.eefnr.parts.forms;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.eef.eefnr.AbstractSample;
import org.eclipse.emf.eef.eefnr.EefnrPackage;
import org.eclipse.emf.eef.eefnr.parts.EefnrViewsRepository;
import org.eclipse.emf.eef.eefnr.parts.RootPropertiesEditionPart;
import org.eclipse.emf.eef.eefnr.providers.EefnrMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPolicyProviderService;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicyProvider;
import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;


// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class RootPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, RootPropertiesEditionPart {

	protected ReferencesTable<? extends EObject> samples;
	protected List<ViewerFilter> samplesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> samplesFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public RootPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
		propertiesSection.setText(EefnrMessages.RootPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createSamplesTableComposition(widgetFactory, propertiesGroup);
		propertiesSection.setClient(propertiesGroup);
	}

	/**
	 * @param container
	 * 
	 */
	protected void createSamplesTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.samples = new ReferencesTable<AbstractSample>(EefnrMessages.RootPropertiesEditionPart_SamplesLabel, new ReferencesTableListener<AbstractSample>() {			
			public void handleAdd() { addToSamples();}
			public void handleEdit(AbstractSample element) { editSamples(element); }
			public void handleMove(AbstractSample element, int oldIndex, int newIndex) { moveSamples(element, oldIndex, newIndex); }
			public void handleRemove(AbstractSample element) { removeFromSamples(element); }
			public void navigateTo(AbstractSample element) { }
		});
		this.samples.setHelpText(propertiesEditionComponent.getHelpContent(EefnrViewsRepository.Root.samples, EefnrViewsRepository.FORM_KIND));
		this.samples.createControls(parent, widgetFactory);
		GridData samplesData = new GridData(GridData.FILL_HORIZONTAL);
		samplesData.horizontalSpan = 3;
		this.samples.setLayoutData(samplesData);
		this.samples.setLowerBound(0);
		this.samples.setUpperBound(-1);
		samples.setID(EefnrViewsRepository.Root.samples);
		samples.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
	}

	/**
	 * 
	 */
	protected void moveSamples(AbstractSample element, int oldIndex, int newIndex) {
	}

	/**
	 * 
	 */
	protected void addToSamples() {
		EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, current, EefnrPackage.eINSTANCE.getRoot_Samples(), adapterFactory);
		PropertiesEditingPolicyProvider provider = PropertiesEditionPolicyProviderService.getInstance().getProvider(context);
		PropertiesEditingPolicy policy = provider.getPolicy(context);
		if (policy instanceof CreateEditingPolicy) {
			policy.execute();
			EObject resultEObject = (EObject) ((CreateEditingPolicy) policy).getResult();
			if (resultEObject != null) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RootPropertiesEditionPartForm.this, EefnrViewsRepository.Root.samples, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, resultEObject));
				samples.refresh();
			}
		}
		
	}

	/**
	 * 
	 */
	protected void removeFromSamples(AbstractSample element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(RootPropertiesEditionPartForm.this, EefnrViewsRepository.Root.samples, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				samples.refresh();
		
	}

	/**
	 * 
	 */
	protected void editSamples(AbstractSample element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(context);
		PropertiesEditingPolicy editionPolicy = policyProvider.getPolicy(context);
		if (editionPolicy != null) {
			editionPolicy.execute();
			samples.refresh();
		}
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
	 * @see org.eclipse.emf.eef.eefnr.parts.RootPropertiesEditionPart#initSamples(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initSamples(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		samples.setContentProvider(contentProvider);
		samples.setInput(settings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.RootPropertiesEditionPart#updateSamples()
	 * 
	 */
	public void updateSamples() {
	samples.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.RootPropertiesEditionPart#addFilterSamples(ViewerFilter filter)
	 * 
	 */
	public void addFilterToSamples(ViewerFilter filter) {
		samplesFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.RootPropertiesEditionPart#addBusinessFilterSamples(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToSamples(ViewerFilter filter) {
		samplesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.RootPropertiesEditionPart#isContainedInSamplesTable(EObject element)
	 * 
	 */
	public boolean isContainedInSamplesTable(EObject element) {
		return ((ReferencesTableSettings)samples.getInput()).contains(element);
	}




	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EefnrMessages.Root_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
