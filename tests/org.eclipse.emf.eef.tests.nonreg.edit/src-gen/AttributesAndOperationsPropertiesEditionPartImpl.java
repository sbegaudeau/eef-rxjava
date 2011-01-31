/**
 * Generated with Acceleo
 */
package com.thalesgroup.mde.ccm.metamodel.baseidl.parts.impl;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;
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
 * 
 * 
 */
public class AttributesAndOperationsPropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, AttributesAndOperationsPropertiesEditionPart {

protected ReferencesTable attributes;
protected List<ViewerFilter> attributesBusinessFilters = new ArrayList<ViewerFilter>();
protected List<ViewerFilter> attributesFilters = new ArrayList<ViewerFilter>();
protected ReferencesTable operations;
protected List<ViewerFilter> operationsBusinessFilters = new ArrayList<ViewerFilter>();
protected List<ViewerFilter> operationsFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public AttributesAndOperationsPropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		CompositionSequence attributesAndOperationsStep = new CompositionSequence();
		CompositionStep attributesAndOperations_Step = attributesAndOperationsStep.addStep(BaseidlViewsRepository.AttributesAndOperations.AttributesAndOperations_.class);
		attributesAndOperations_Step.addStep(BaseidlViewsRepository.AttributesAndOperations.AttributesAndOperations_.attributes);
		attributesAndOperations_Step.addStep(BaseidlViewsRepository.AttributesAndOperations.AttributesAndOperations_.operations);
		
		
		composer = new PartComposer(attributesAndOperationsStep) {
			
			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == BaseidlViewsRepository.AttributesAndOperations.AttributesAndOperations_.class) {
					return createAttributesAndOperationsGroup(parent);
				}
				if (key == BaseidlViewsRepository.AttributesAndOperations.AttributesAndOperations_.attributes) {
					return createAttributesAdvancedTableComposition(parent);
				}
				if (key == BaseidlViewsRepository.AttributesAndOperations.AttributesAndOperations_.operations) {
					return createOperationsAdvancedTableComposition(parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}

	/**
	 * 
	 */
	protected Composite createAttributesAndOperationsGroup(Composite parent) {
		Group attributesAndOperationsGroup = new Group(parent, SWT.NONE);
		attributesAndOperationsGroup.setText(BaseidlMessages.AttributesAndOperationsPropertiesEditionPart_AttributesAndOperationsGroupLabel);
		GridData attributesAndOperationsGroupData = new GridData(GridData.FILL_HORIZONTAL);
		attributesAndOperationsGroupData.horizontalSpan = 3;
		attributesAndOperationsGroup.setLayoutData(attributesAndOperationsGroupData);
		GridLayout attributesAndOperationsGroupLayout = new GridLayout();
		attributesAndOperationsGroupLayout.numColumns = 3;
		attributesAndOperationsGroup.setLayout(attributesAndOperationsGroupLayout);
		return attributesAndOperationsGroup;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createAttributesAdvancedTableComposition(Composite parent) {
		this.attributes = new ReferencesTable(BaseidlMessages.AttributesAndOperationsPropertiesEditionPart_AttributesLabel, new ReferencesTableListener() {			
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AttributesAndOperationsPropertiesEditionPartImpl.this, BaseidlViewsRepository.AttributesAndOperations.AttributesAndOperations_.attributes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				attributes.refresh();			
			}
			public void handleEdit(EObject element) {  
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AttributesAndOperationsPropertiesEditionPartImpl.this, BaseidlViewsRepository.AttributesAndOperations.AttributesAndOperations_.attributes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				attributes.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AttributesAndOperationsPropertiesEditionPartImpl.this, BaseidlViewsRepository.AttributesAndOperations.AttributesAndOperations_.attributes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));	
				attributes.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AttributesAndOperationsPropertiesEditionPartImpl.this, BaseidlViewsRepository.AttributesAndOperations.AttributesAndOperations_.attributes, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				attributes.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		this.attributes.setHelpText(propertiesEditionComponent.getHelpContent(BaseidlViewsRepository.AttributesAndOperations.AttributesAndOperations_.attributes, BaseidlViewsRepository.SWT_KIND));
		this.attributes.createControls(parent);
		GridData attributesData = new GridData(GridData.FILL_HORIZONTAL);
		attributesData.horizontalSpan = 3;
		this.attributes.setLayoutData(attributesData);
		this.attributes.setLowerBound(0);
		this.attributes.setUpperBound(-1);
		attributes.setID(BaseidlViewsRepository.AttributesAndOperations.AttributesAndOperations_.attributes);
		attributes.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createOperationsAdvancedTableComposition(Composite parent) {
		this.operations = new ReferencesTable(BaseidlMessages.AttributesAndOperationsPropertiesEditionPart_OperationsLabel, new ReferencesTableListener() {			
			public void handleAdd() { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AttributesAndOperationsPropertiesEditionPartImpl.this, BaseidlViewsRepository.AttributesAndOperations.AttributesAndOperations_.operations, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				operations.refresh();			
			}
			public void handleEdit(EObject element) {  
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AttributesAndOperationsPropertiesEditionPartImpl.this, BaseidlViewsRepository.AttributesAndOperations.AttributesAndOperations_.operations, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				operations.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AttributesAndOperationsPropertiesEditionPartImpl.this, BaseidlViewsRepository.AttributesAndOperations.AttributesAndOperations_.operations, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));	
				operations.refresh();
			}
			public void handleRemove(EObject element) { 
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(AttributesAndOperationsPropertiesEditionPartImpl.this, BaseidlViewsRepository.AttributesAndOperations.AttributesAndOperations_.operations, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				operations.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		this.operations.setHelpText(propertiesEditionComponent.getHelpContent(BaseidlViewsRepository.AttributesAndOperations.AttributesAndOperations_.operations, BaseidlViewsRepository.SWT_KIND));
		this.operations.createControls(parent);
		GridData operationsData = new GridData(GridData.FILL_HORIZONTAL);
		operationsData.horizontalSpan = 3;
		this.operations.setLayoutData(operationsData);
		this.operations.setLowerBound(0);
		this.operations.setUpperBound(-1);
		operations.setID(BaseidlViewsRepository.AttributesAndOperations.AttributesAndOperations_.operations);
		operations.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		return parent;
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
	 * @see com.thalesgroup.mde.ccm.metamodel.baseidl.parts.AttributesAndOperationsPropertiesEditionPart#initAttributes(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initAttributes(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		attributes.setContentProvider(contentProvider);
		attributes.setInput(settings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.thalesgroup.mde.ccm.metamodel.baseidl.parts.AttributesAndOperationsPropertiesEditionPart#updateAttributes()
	 * 
	 */
	public void updateAttributes() {
	attributes.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.thalesgroup.mde.ccm.metamodel.baseidl.parts.AttributesAndOperationsPropertiesEditionPart#addFilterAttributes(ViewerFilter filter)
	 * 
	 */
	public void addFilterToAttributes(ViewerFilter filter) {
		attributesFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.thalesgroup.mde.ccm.metamodel.baseidl.parts.AttributesAndOperationsPropertiesEditionPart#addBusinessFilterAttributes(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToAttributes(ViewerFilter filter) {
		attributesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.thalesgroup.mde.ccm.metamodel.baseidl.parts.AttributesAndOperationsPropertiesEditionPart#isContainedInAttributesTable(EObject element)
	 * 
	 */
	public boolean isContainedInAttributesTable(EObject element) {
		return ((ReferencesTableSettings)attributes.getInput()).contains(element);
	}




	/**
	 * {@inheritDoc}
	 * 
	 * @see com.thalesgroup.mde.ccm.metamodel.baseidl.parts.AttributesAndOperationsPropertiesEditionPart#initOperations(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initOperations(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		operations.setContentProvider(contentProvider);
		operations.setInput(settings);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.thalesgroup.mde.ccm.metamodel.baseidl.parts.AttributesAndOperationsPropertiesEditionPart#updateOperations()
	 * 
	 */
	public void updateOperations() {
	operations.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.thalesgroup.mde.ccm.metamodel.baseidl.parts.AttributesAndOperationsPropertiesEditionPart#addFilterOperations(ViewerFilter filter)
	 * 
	 */
	public void addFilterToOperations(ViewerFilter filter) {
		operationsFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.thalesgroup.mde.ccm.metamodel.baseidl.parts.AttributesAndOperationsPropertiesEditionPart#addBusinessFilterOperations(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToOperations(ViewerFilter filter) {
		operationsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.thalesgroup.mde.ccm.metamodel.baseidl.parts.AttributesAndOperationsPropertiesEditionPart#isContainedInOperationsTable(EObject element)
	 * 
	 */
	public boolean isContainedInOperationsTable(EObject element) {
		return ((ReferencesTableSettings)operations.getInput()).contains(element);
	}







	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return BaseidlMessages.AttributesAndOperations_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
