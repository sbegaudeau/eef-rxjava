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
package org.eclipse.emf.eef.eefnr.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.eef.eefnr.EefnrFactory;
import org.eclipse.emf.eef.eefnr.Sample;
import org.eclipse.emf.eef.eefnr.parts.AdvancedTableCompositionEditorSamplePropertiesEditionPart;
import org.eclipse.emf.eef.eefnr.parts.EefnrViewsRepository;
import org.eclipse.emf.eef.eefnr.providers.EefnrMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPolicyProviderService;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicyProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;



// End of user code	

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class AdvancedTableCompositionEditorSamplePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, AdvancedTableCompositionEditorSamplePropertiesEditionPart {

protected ReferencesTable<? extends EObject> advancedtablecompositionRequiredProperty;
protected List<ViewerFilter> advancedtablecompositionRequiredPropertyBusinessFilters = new ArrayList<ViewerFilter>();
protected List<ViewerFilter> advancedtablecompositionRequiredPropertyFilters = new ArrayList<ViewerFilter>();
protected ReferencesTable<? extends EObject> advancedtablecompositionOptionalProperty;
protected List<ViewerFilter> advancedtablecompositionOptionalPropertyBusinessFilters = new ArrayList<ViewerFilter>();
protected List<ViewerFilter> advancedtablecompositionOptionalPropertyFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public AdvancedTableCompositionEditorSamplePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		propertiesGroup.setText(EefnrMessages.AdvancedTableCompositionEditorSamplePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesGroupData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesGroupData.horizontalSpan = 3;
		propertiesGroup.setLayoutData(propertiesGroupData);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
createAdvancedtablecompositionRequiredPropertyAdvancedTableComposition(propertiesGroup);
createAdvancedtablecompositionOptionalPropertyAdvancedTableComposition(propertiesGroup);
	}

	/**
	 * @param container
	 * 
	 */
	protected void createAdvancedtablecompositionRequiredPropertyAdvancedTableComposition(Composite parent) {
		this.advancedtablecompositionRequiredProperty = new ReferencesTable<Sample>(EefnrMessages.AdvancedTableCompositionEditorSamplePropertiesEditionPart_AdvancedtablecompositionRequiredPropertyLabel, new ReferencesTableListener<Sample>() {			
			public void handleAdd() { addToAdvancedtablecompositionRequiredProperty();}
			public void handleEdit(Sample element) { editAdvancedtablecompositionRequiredProperty(element); }
			public void handleMove(Sample element, int oldIndex, int newIndex) { moveAdvancedtablecompositionRequiredProperty(element, oldIndex, newIndex); }
			public void handleRemove(Sample element) { removeFromAdvancedtablecompositionRequiredProperty(element); }
			public void navigateTo(Sample element) { }
		});
		this.advancedtablecompositionRequiredProperty.setHelpText(propertiesEditionComponent.getHelpContent(EefnrViewsRepository.AdvancedTableCompositionEditorSample.advancedtablecompositionRequiredProperty, EefnrViewsRepository.SWT_KIND));
		this.advancedtablecompositionRequiredProperty.createControls(parent);
		GridData advancedtablecompositionRequiredPropertyData = new GridData(GridData.FILL_HORIZONTAL);
		advancedtablecompositionRequiredPropertyData.horizontalSpan = 3;
		this.advancedtablecompositionRequiredProperty.setLayoutData(advancedtablecompositionRequiredPropertyData);
		this.advancedtablecompositionRequiredProperty.setLowerBound(1);
		this.advancedtablecompositionRequiredProperty.setUpperBound(-1);
		advancedtablecompositionRequiredProperty.setID(EefnrViewsRepository.AdvancedTableCompositionEditorSample.advancedtablecompositionRequiredProperty);
		advancedtablecompositionRequiredProperty.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
	}

	/**
	 *  
	 */
	protected void moveAdvancedtablecompositionRequiredProperty(Sample element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedTableCompositionEditorSamplePropertiesEditionPartImpl.this, EefnrViewsRepository.AdvancedTableCompositionEditorSample.advancedtablecompositionRequiredProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));	
		advancedtablecompositionRequiredProperty.refresh();
	}

	/**
	 *  
	 */
	protected void addToAdvancedtablecompositionRequiredProperty() {
		Sample eObject = EefnrFactory.eINSTANCE.createSample();
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, eObject, adapterFactory);
		PropertiesEditingPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(context);
		PropertiesEditingPolicy policy = policyProvider.getPolicy(context);
		if (policy != null) {
			policy.execute();
		}
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedTableCompositionEditorSamplePropertiesEditionPartImpl.this, EefnrViewsRepository.AdvancedTableCompositionEditorSample.advancedtablecompositionRequiredProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, eObject));
		advancedtablecompositionRequiredProperty.refresh();
		
	}

	/**
	 *  
	 */
	protected void removeFromAdvancedtablecompositionRequiredProperty(Sample element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedTableCompositionEditorSamplePropertiesEditionPartImpl.this, EefnrViewsRepository.AdvancedTableCompositionEditorSample.advancedtablecompositionRequiredProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				advancedtablecompositionRequiredProperty.refresh();
		
	}

	/**
	 *  
	 */
	protected void editAdvancedtablecompositionRequiredProperty(Sample element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(context);
		PropertiesEditingPolicy editionPolicy = policyProvider.getPolicy(context);
		if (editionPolicy != null) {
			editionPolicy.execute();
			advancedtablecompositionRequiredProperty.refresh();
		}
	}

	/**
	 * @param container
	 * 
	 */
	protected void createAdvancedtablecompositionOptionalPropertyAdvancedTableComposition(Composite parent) {
		this.advancedtablecompositionOptionalProperty = new ReferencesTable<Sample>(EefnrMessages.AdvancedTableCompositionEditorSamplePropertiesEditionPart_AdvancedtablecompositionOptionalPropertyLabel, new ReferencesTableListener<Sample>() {			
			public void handleAdd() { addToAdvancedtablecompositionOptionalProperty();}
			public void handleEdit(Sample element) { editAdvancedtablecompositionOptionalProperty(element); }
			public void handleMove(Sample element, int oldIndex, int newIndex) { moveAdvancedtablecompositionOptionalProperty(element, oldIndex, newIndex); }
			public void handleRemove(Sample element) { removeFromAdvancedtablecompositionOptionalProperty(element); }
			public void navigateTo(Sample element) { }
		});
		this.advancedtablecompositionOptionalProperty.setHelpText(propertiesEditionComponent.getHelpContent(EefnrViewsRepository.AdvancedTableCompositionEditorSample.advancedtablecompositionOptionalProperty, EefnrViewsRepository.SWT_KIND));
		this.advancedtablecompositionOptionalProperty.createControls(parent);
		GridData advancedtablecompositionOptionalPropertyData = new GridData(GridData.FILL_HORIZONTAL);
		advancedtablecompositionOptionalPropertyData.horizontalSpan = 3;
		this.advancedtablecompositionOptionalProperty.setLayoutData(advancedtablecompositionOptionalPropertyData);
		this.advancedtablecompositionOptionalProperty.setLowerBound(0);
		this.advancedtablecompositionOptionalProperty.setUpperBound(-1);
		advancedtablecompositionOptionalProperty.setID(EefnrViewsRepository.AdvancedTableCompositionEditorSample.advancedtablecompositionOptionalProperty);
		advancedtablecompositionOptionalProperty.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
	}

	/**
	 *  
	 */
	protected void moveAdvancedtablecompositionOptionalProperty(Sample element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedTableCompositionEditorSamplePropertiesEditionPartImpl.this, EefnrViewsRepository.AdvancedTableCompositionEditorSample.advancedtablecompositionOptionalProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));	
		advancedtablecompositionOptionalProperty.refresh();
	}

	/**
	 *  
	 */
	protected void addToAdvancedtablecompositionOptionalProperty() {
		Sample eObject = EefnrFactory.eINSTANCE.createSample();
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, eObject, adapterFactory);
		PropertiesEditingPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(context);
		PropertiesEditingPolicy policy = policyProvider.getPolicy(context);
		if (policy != null) {
			policy.execute();
		}
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedTableCompositionEditorSamplePropertiesEditionPartImpl.this, EefnrViewsRepository.AdvancedTableCompositionEditorSample.advancedtablecompositionOptionalProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, eObject));
		advancedtablecompositionOptionalProperty.refresh();
		
	}

	/**
	 *  
	 */
	protected void removeFromAdvancedtablecompositionOptionalProperty(Sample element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AdvancedTableCompositionEditorSamplePropertiesEditionPartImpl.this, EefnrViewsRepository.AdvancedTableCompositionEditorSample.advancedtablecompositionOptionalProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				advancedtablecompositionOptionalProperty.refresh();
		
	}

	/**
	 *  
	 */
	protected void editAdvancedtablecompositionOptionalProperty(Sample element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(context);
		PropertiesEditingPolicy editionPolicy = policyProvider.getPolicy(context);
		if (editionPolicy != null) {
			editionPolicy.execute();
			advancedtablecompositionOptionalProperty.refresh();
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
	 * @see org.eclipse.emf.eef.eefnr.parts.AdvancedTableCompositionEditorSamplePropertiesEditionPart#initAdvancedtablecompositionRequiredProperty(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initAdvancedtablecompositionRequiredProperty(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		advancedtablecompositionRequiredProperty.setContentProvider(contentProvider);
		advancedtablecompositionRequiredProperty.setInput(settings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.AdvancedTableCompositionEditorSamplePropertiesEditionPart#updateAdvancedtablecompositionRequiredProperty()
	 * 
	 */
	public void updateAdvancedtablecompositionRequiredProperty() {
	advancedtablecompositionRequiredProperty.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.AdvancedTableCompositionEditorSamplePropertiesEditionPart#addFilterAdvancedtablecompositionRequiredProperty(ViewerFilter filter)
	 * 
	 */
	public void addFilterToAdvancedtablecompositionRequiredProperty(ViewerFilter filter) {
		advancedtablecompositionRequiredPropertyFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.AdvancedTableCompositionEditorSamplePropertiesEditionPart#addBusinessFilterAdvancedtablecompositionRequiredProperty(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToAdvancedtablecompositionRequiredProperty(ViewerFilter filter) {
		advancedtablecompositionRequiredPropertyBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.AdvancedTableCompositionEditorSamplePropertiesEditionPart#isContainedInAdvancedtablecompositionRequiredPropertyTable(EObject element)
	 * 
	 */
	public boolean isContainedInAdvancedtablecompositionRequiredPropertyTable(EObject element) {
		return ((ReferencesTableSettings)advancedtablecompositionRequiredProperty.getInput()).contains(element);
	}




	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.AdvancedTableCompositionEditorSamplePropertiesEditionPart#initAdvancedtablecompositionOptionalProperty(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initAdvancedtablecompositionOptionalProperty(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		advancedtablecompositionOptionalProperty.setContentProvider(contentProvider);
		advancedtablecompositionOptionalProperty.setInput(settings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.AdvancedTableCompositionEditorSamplePropertiesEditionPart#updateAdvancedtablecompositionOptionalProperty()
	 * 
	 */
	public void updateAdvancedtablecompositionOptionalProperty() {
	advancedtablecompositionOptionalProperty.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.AdvancedTableCompositionEditorSamplePropertiesEditionPart#addFilterAdvancedtablecompositionOptionalProperty(ViewerFilter filter)
	 * 
	 */
	public void addFilterToAdvancedtablecompositionOptionalProperty(ViewerFilter filter) {
		advancedtablecompositionOptionalPropertyFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.AdvancedTableCompositionEditorSamplePropertiesEditionPart#addBusinessFilterAdvancedtablecompositionOptionalProperty(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToAdvancedtablecompositionOptionalProperty(ViewerFilter filter) {
		advancedtablecompositionOptionalPropertyBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.eefnr.parts.AdvancedTableCompositionEditorSamplePropertiesEditionPart#isContainedInAdvancedtablecompositionOptionalPropertyTable(EObject element)
	 * 
	 */
	public boolean isContainedInAdvancedtablecompositionOptionalPropertyTable(EObject element) {
		return ((ReferencesTableSettings)advancedtablecompositionOptionalProperty.getInput()).contains(element);
	}







	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EefnrMessages.AdvancedTableCompositionEditorSample_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
