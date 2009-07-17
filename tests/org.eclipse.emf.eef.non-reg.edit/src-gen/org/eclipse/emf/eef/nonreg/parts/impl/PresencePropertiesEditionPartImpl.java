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
import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProvider;
import org.eclipse.emf.eef.runtime.impl.policies.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPolicyProviderService;

import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.nonreg.parts.PresencePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.jface.viewers.StructuredSelection;
import java.util.Iterator;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFModelViewerDialog;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.nonreg.Talk;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;

import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;

// End of user code

/**
 * 
 */
public class PresencePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, PresencePropertiesEditionPart {

	protected EMFListEditUtil assistsEditUtil;
	protected ReferencesTable<? extends EObject> assists;
	protected List<ViewerFilter> assistsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> assistsFilters = new ArrayList<ViewerFilter>();




	
	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public PresencePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		createPresenceGroup(view);

		// Start of user code for additional ui definition
		
		// End of user code

	}

	protected void createPresenceGroup(Composite parent) {
		Group presenceGroup = new Group(parent, SWT.NONE);
		presenceGroup.setText(NonregMessages.PresencePropertiesEditionPart_PresenceGroupLabel);
		GridData presenceGroupData = new GridData(GridData.FILL_HORIZONTAL);
		presenceGroupData.horizontalSpan = 3;
		presenceGroup.setLayoutData(presenceGroupData);
		GridLayout presenceGroupLayout = new GridLayout();
		presenceGroupLayout.numColumns = 3;
		presenceGroup.setLayout(presenceGroupLayout);
		createAssistsAdvancedReferencesTable(presenceGroup);
	}
	protected void createAssistsAdvancedReferencesTable(Composite parent) {
		this.assists = new ReferencesTable<Talk>(NonregMessages.PresencePropertiesEditionPart_AssistsLabel, new ReferencesTableListener<Talk>() {
			public void handleAdd() {
				TabElementTreeSelectionDialog<Talk> dialog = new TabElementTreeSelectionDialog<Talk>(resourceSet, assistsFilters, assistsBusinessFilters,
				"Talk", NonregPackage.eINSTANCE.getTalk(), current.eResource()) {

					public void process(IStructuredSelection selection) {
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!assistsEditUtil.getVirtualList().contains(elem))
								assistsEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PresencePropertiesEditionPartImpl.this, NonregViewsRepository.Presence.assists,
								PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						assists.refresh();
					}

				};
				dialog.open();
			}
			public void handleEdit(Talk element) { editAssists(element); }
			public void handleMove(Talk element, int oldIndex, int newIndex) { moveAssists(element, oldIndex, newIndex); }
			public void handleRemove(Talk element) { removeFromAssists(element); }
			public void navigateTo(Talk element) { }
		});
		this.assists.setHelpText(propertiesEditionComponent.getHelpContent(NonregViewsRepository.Presence.assists, NonregViewsRepository.SWT_KIND));
		this.assists.createControls(parent);
		GridData assistsData = new GridData(GridData.FILL_HORIZONTAL);
		assistsData.horizontalSpan = 3;
		this.assists.setLayoutData(assistsData);
		this.assists.disableMove();
	}

	/**
	 * 
	 */
	private void moveAssists(Talk element, int oldIndex, int newIndex) {
		EObject editedElement = assistsEditUtil.foundCorrespondingEObject(element);
		assistsEditUtil.moveElement(element, oldIndex, newIndex);
		assists.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PresencePropertiesEditionPartImpl.this, NonregViewsRepository.Presence.assists, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	private void removeFromAssists(Talk element) {

		// Start of user code removeFromAssists() method body
		EObject editedElement = assistsEditUtil.foundCorrespondingEObject(element);
		assistsEditUtil.removeElement(element);
		assists.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PresencePropertiesEditionPartImpl.this, NonregViewsRepository.Presence.assists, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code

	}

	/**
	 * 
	 */
	private void editAssists(Talk element) {

		// Start of user code editAssists() method body
		EObject editedElement = assistsEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				assistsEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				assists.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(PresencePropertiesEditionPartImpl.this, NonregViewsRepository.Presence.assists, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
			}
		}
		// End of user code

	}


	public void firePropertiesChanged(PropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PresencePropertiesEditionPart#getAssistsToAdd()
	 */
	public List getAssistsToAdd() {
		return assistsEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PresencePropertiesEditionPart#getAssistsToRemove()
	 */
	public List getAssistsToRemove() {
		return assistsEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PresencePropertiesEditionPart#getAssistsTable()
	 */
	public List getAssistsTable() {
		return assistsEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PresencePropertiesEditionPart#initAssists(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initAssists(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			assistsEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			assistsEditUtil = new EMFListEditUtil(current, feature);
		this.assists.setInput(assistsEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PresencePropertiesEditionPart#updateAssists(EObject newValue)
	 */
	public void updateAssists(EObject newValue) {
		if(assistsEditUtil != null){
			assistsEditUtil.reinit(newValue);
			assists.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PresencePropertiesEditionPart#addFilterAssists(ViewerFilter filter)
	 */
	public void addFilterToAssists(ViewerFilter filter) {
		assistsFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PresencePropertiesEditionPart#addBusinessFilterAssists(ViewerFilter filter)
	 */
	public void addBusinessFilterToAssists(ViewerFilter filter) {
		assistsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.PresencePropertiesEditionPart#isContainedInAssistsTable(EObject element)
	 */
	public boolean isContainedInAssistsTable(EObject element) {
		return assistsEditUtil.contains(element);
	}

	public void setMessageForAssists(String msg, int msgLevel) {

	}

	public void unsetMessageForAssists() {

	}








	// Start of user code additional methods
	
	// End of user code

}
