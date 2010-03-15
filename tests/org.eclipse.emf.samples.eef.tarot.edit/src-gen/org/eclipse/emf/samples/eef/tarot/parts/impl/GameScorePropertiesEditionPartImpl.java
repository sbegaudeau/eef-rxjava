/**
 * Generated with Acceleo
 */
package org.eclipse.emf.samples.eef.tarot.parts.impl;

// Start of user code for imports

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProvider;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.policies.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.policies.EReferencePropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPolicyProviderService;
import org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil;
import org.eclipse.emf.samples.eef.tarot.TarotPackage;
import org.eclipse.emf.samples.eef.tarot.parts.GameScorePropertiesEditionPart;
import org.eclipse.emf.samples.eef.tarot.parts.TarotViewsRepository;
import org.eclipse.emf.samples.eef.tarot.providers.TarotMessages;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TableColumn;

// End of user code	

/**
 * 
 * 
 */
public class GameScorePropertiesEditionPartImpl extends CompositePropertiesEditionPart implements ISWTPropertiesEditionPart, GameScorePropertiesEditionPart {

	protected EMFListEditUtil entriesEditUtil;
	protected TableViewer entries;
	protected List<ViewerFilter> entriesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> entriesFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public GameScorePropertiesEditionPartImpl(IPropertiesEditionComponent editionComponent) {
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
		createEntriesTableComposition(view);


		// Start of user code for additional ui definition
		
		// End of user code
	}

	/**
	 * @param container
	 * 
	 */
	protected void createEntriesTableComposition(Composite container) {
		Composite tableContainer = new Composite(container, SWT.NONE);
		GridLayout tableContainerLayout = new GridLayout();
		GridData tableContainerData = new GridData(GridData.FILL_BOTH);
		tableContainerData.horizontalSpan = 3;
		tableContainer.setLayoutData(tableContainerData);
		tableContainerLayout.numColumns = 2;
		tableContainer.setLayout(tableContainerLayout);
		org.eclipse.swt.widgets.Table tableEntries = new org.eclipse.swt.widgets.Table(tableContainer, SWT.FULL_SELECTION);
		tableEntries.setHeaderVisible(true);
		GridData gdEntries = new GridData();
		gdEntries.grabExcessHorizontalSpace = true;
		gdEntries.horizontalAlignment = GridData.FILL;
		gdEntries.grabExcessVerticalSpace = true;
		gdEntries.verticalAlignment = GridData.FILL;
		tableEntries.setLayoutData(gdEntries);
		tableEntries.setLinesVisible(true);
		
		// Start of user code for columns definition for Entries
		TableColumn name = new TableColumn(tableEntries, SWT.NONE);
		name.setWidth(80);
		name.setText("Label"); //$NON-NLS-1$
		// End of user code

		entries = new TableViewer(tableEntries);
		entries.setContentProvider(new ArrayContentProvider());
		entries.setLabelProvider(new ITableLabelProvider() {
			//Start of user code for label provider definition for Entries
			public String getColumnText(Object object, int columnIndex) {
				AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
				if (object instanceof EObject) {
					switch (columnIndex) {
					case 0:
						return labelProvider.getText(object);
					}
				}
				return ""; //$NON-NLS-1$
			}

			public Image getColumnImage(Object element, int columnIndex) {
				return null;
			}
			//End of user code

			public void addListener(ILabelProviderListener listener) {
			}

			public void dispose() {
			}

			public boolean isLabelProperty(Object element, String property) {
				return false;
			}

			public void removeListener(ILabelProviderListener listener) {
			}

		});
		entries.getTable().addListener(SWT.MouseDoubleClick, new Listener(){

			public void handleEvent(Event event) {
				editEntries();
			}
	
		});
		GridData entriesData = new GridData(GridData.FILL_HORIZONTAL);
		entriesData.minimumHeight = 120;
		entriesData.heightHint = 120;
		entries.getTable().setLayoutData(entriesData);
		createEntriesPanel(tableContainer);
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createEntriesPanel(Composite container) {
		Composite entriesPanel = new Composite(container, SWT.NONE);
		GridLayout entriesPanelLayout = new GridLayout();
		entriesPanelLayout.numColumns = 1;
		entriesPanel.setLayout(entriesPanelLayout);
		Button addEntries = new Button(entriesPanel, SWT.NONE);
		addEntries.setText(TarotMessages.PropertiesEditionPart_AddTableViewerLabel);
		GridData addEntriesData = new GridData(GridData.FILL_HORIZONTAL);
		addEntries.setLayoutData(addEntriesData);
		addEntries.addSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				addToEntries();
			}
		});
		Button removeEntries = new Button(entriesPanel, SWT.NONE);
		removeEntries.setText(TarotMessages.PropertiesEditionPart_RemoveTableViewerLabel);
		GridData removeEntriesData = new GridData(GridData.FILL_HORIZONTAL);
		removeEntries.setLayoutData(removeEntriesData);
		removeEntries.addSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 
			 */
			public void widgetSelected(SelectionEvent e) {
				removeFromEntries();
			}

		});
		Button editEntries = new Button(entriesPanel, SWT.NONE);
		editEntries.setText(TarotMessages.PropertiesEditionPart_EditTableViewerLabel);
		GridData editEntriesData = new GridData(GridData.FILL_HORIZONTAL);
		editEntries.setLayoutData(editEntriesData);
		editEntries.addSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 
			 */
			public void widgetSelected(SelectionEvent e) {
				editEntries();
			}

		});
		return entriesPanel;
	}

	/**
	 *  
	 */
	protected void addToEntries() {
		// Start of user code addToEntries() method body
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(current);
		IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(current);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EReferencePropertiesEditionContext(propertiesEditionComponent, TarotPackage.eINSTANCE.getGame_Entries(), resourceSet));
			if (propertiesEditionObject != null) {
				entriesEditUtil.addElement(propertiesEditionObject);
				entries.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GameScorePropertiesEditionPartImpl.this, TarotViewsRepository.GameScore.entries, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}

		// End of user code

	}

	/**
	 *  
	 */
	protected void removeFromEntries() {
		// Start of user code removeFromEntries() method body
		if (entries.getSelection() instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection) entries.getSelection();
			if (selection.getFirstElement() instanceof EObject) {
				EObject selectedElement = (EObject) selection.getFirstElement();
				EObject editedElement = entriesEditUtil.foundCorrespondingEObject(selectedElement);
				entriesEditUtil.removeElement(selectedElement);
				entries.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GameScorePropertiesEditionPartImpl.this, TarotViewsRepository.GameScore.entries, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.REMOVE, null, editedElement));
			}
		}
		// End of user code

	}

	/**
	 *  
	 */
	protected void editEntries() {
		// Start of user code editEntries() method body
		if (entries.getSelection() instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection) entries.getSelection();
			if (selection.getFirstElement() instanceof EObject) {
				EObject selectedElement = (EObject) selection.getFirstElement();
				EObject editedElement = entriesEditUtil.foundCorrespondingEObject(selectedElement);
				IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(editedElement);
				IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
				if (editionPolicy != null) {
					EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, selectedElement,resourceSet));
					if (propertiesEditionObject != null) {
						entriesEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
						entries.refresh();
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GameScorePropertiesEditionPartImpl.this, TarotViewsRepository.GameScore.entries, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
					}
				}
			}
		}
		// End of user code

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
	 * @see org.eclipse.emf.samples.eef.tarot.parts.GameScorePropertiesEditionPart#getEntriesToAdd()
	 * 
	 */
	public List getEntriesToAdd() {
		return entriesEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.GameScorePropertiesEditionPart#getEntriesToRemove()
	 * 
	 */
	public List getEntriesToRemove() {
		return entriesEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.GameScorePropertiesEditionPart#getEntriesToEdit()
	 * 
	 */
	public Map getEntriesToEdit() {
		return entriesEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.GameScorePropertiesEditionPart#getEntriesToMove()
	 * 
	 */
	public List getEntriesToMove() {
		return entriesEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.GameScorePropertiesEditionPart#getEntriesTable()
	 * 
	 */
	public List getEntriesTable() {
		return entriesEditUtil.getVirtualList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.GameScorePropertiesEditionPart#initEntries(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initEntries(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			entriesEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			entriesEditUtil = new EMFListEditUtil(current, feature);
		this.entries.setInput(entriesEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.GameScorePropertiesEditionPart#updateEntries(EObject newValue)
	 * 
	 */
	public void updateEntries(EObject newValue) {
		if(entriesEditUtil != null){
			entriesEditUtil.reinit(newValue);
			entries.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.GameScorePropertiesEditionPart#addFilterEntries(ViewerFilter filter)
	 * 
	 */
	public void addFilterToEntries(ViewerFilter filter) {
		entriesFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.GameScorePropertiesEditionPart#addBusinessFilterEntries(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToEntries(ViewerFilter filter) {
		entriesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.GameScorePropertiesEditionPart#isContainedInEntriesTable(EObject element)
	 * 
	 */
	public boolean isContainedInEntriesTable(EObject element) {
		return entriesEditUtil.contains(element);
	}

	public void setMessageForEntries(String msg, int msgLevel) {

	}

	public void unsetMessageForEntries() {

	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return TarotMessages.GameScore_Part_Title;
	}

	// Start of user code additional methods
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.samples.eef.tarot.parts.GameScorePropertiesEditionPart#updatePlayerColumns(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePlayerColumns(Notification msg) {
		// Nothing to do
		
	}	
	
	// End of user code


}
