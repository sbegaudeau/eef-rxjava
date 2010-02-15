/**
 * Generated with Acceleo
 */
package org.eclipse.emf.samples.eef.tarot.parts.forms;

// Start of user code for imports

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProvider;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.policies.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.policies.EReferencePropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPolicyProviderService;
import org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil;
import org.eclipse.emf.samples.eef.tarot.Game;
import org.eclipse.emf.samples.eef.tarot.Player;
import org.eclipse.emf.samples.eef.tarot.ScoreEntry;
import org.eclipse.emf.samples.eef.tarot.TarotPackage;
import org.eclipse.emf.samples.eef.tarot.parts.GameScorePropertiesEditionPart;
import org.eclipse.emf.samples.eef.tarot.parts.TarotViewsRepository;
import org.eclipse.emf.samples.eef.tarot.providers.TarotMessages;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;


// End of user code

/**
 * 
 */
public class GameScorePropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, GameScorePropertiesEditionPart {

	protected EMFListEditUtil entriesEditUtil;
	protected TableViewer entries;
	protected List<ViewerFilter> entriesBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> entriesFilters = new ArrayList<ViewerFilter>();





	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public GameScorePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
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
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		this.messageManager = messageManager;
		createEntriesTableComposition(widgetFactory, view);

		// Start of user code for additional ui definition
		
		// End of user code
	}
	/**
	 * @param container
	 */
	protected void createEntriesTableComposition(FormToolkit widgetFactory, Composite container) {
		Composite tableContainer = widgetFactory.createComposite(container, SWT.NONE);
		GridLayout tableContainerLayout = new GridLayout();
		GridData tableContainerData = new GridData(GridData.FILL_BOTH);
		tableContainerData.horizontalSpan = 3;
		tableContainer.setLayoutData(tableContainerData);
		tableContainerLayout.numColumns = 2;
		tableContainer.setLayout(tableContainerLayout);
		org.eclipse.swt.widgets.Table tableEntries = widgetFactory.createTable(tableContainer, SWT.FULL_SELECTION | SWT.BORDER);
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
		entries.setContentProvider(new AdapterFactoryContentProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()) {

			/**
			 * {@inheritDoc}
			 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#getElements(java.lang.Object)
			 */
			@Override
			public Object[] getElements(Object object) {
				if (object instanceof Collection)
					return ((Collection) object).toArray();
				else
					return super.getElements(object);
			}
			
		});
		entries.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()) {

			//Start of user code for label provider definition for Entries
			public String getColumnText(Object object, int columnIndex) {
				AdapterFactoryLabelProvider labelProvider = new AdapterFactoryLabelProvider(adapterFactory);
				if (object instanceof ScoreEntry) {
					ScoreEntry scoreEntry = (ScoreEntry)entriesEditUtil.foundCorrespondingEObject((EObject) object);
					if (columnIndex == 0 && scoreEntry.getGame() != null)
						return String.valueOf(scoreEntry.getGame().getEntries().indexOf(scoreEntry));
					else if (columnIndex == 1)
						return labelProvider.getText(scoreEntry);
					else {
						if ((scoreEntry.getGame() != null) && (columnIndex - 2 < scoreEntry.getGame().getPlayers().size())) 
							return String.valueOf(scoreEntry.cumulativeScore(scoreEntry.getGame().getPlayers().get(columnIndex - 2)));
					}
				}
				return ""; //$NON-NLS-1$
			}

			public Image getColumnImage(Object element, int columnIndex) {
				return null;
			}
			//End of user code

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
		createEntriesPanel(widgetFactory, tableContainer);
	}

	/**
	 * @param container
	 */
	protected Composite createEntriesPanel(FormToolkit widgetFactory, Composite container) {
		Composite entriesPanel = widgetFactory.createComposite(container, SWT.NONE);
		GridLayout entriesPanelLayout = new GridLayout();
		entriesPanelLayout.numColumns = 1;
		entriesPanel.setLayout(entriesPanelLayout);
		Button addEntries = widgetFactory.createButton(entriesPanel, TarotMessages.PropertiesEditionPart_AddTableViewerLabel, SWT.NONE);
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
		Button removeEntries = widgetFactory.createButton(entriesPanel, TarotMessages.PropertiesEditionPart_RemoveTableViewerLabel, SWT.NONE);
		GridData removeEntriesData = new GridData(GridData.FILL_HORIZONTAL);
		removeEntries.setLayoutData(removeEntriesData);
		removeEntries.addSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				removeFromEntries();
			}

		});
		Button editEntries = widgetFactory.createButton(entriesPanel, TarotMessages.PropertiesEditionPart_EditTableViewerLabel, SWT.NONE);
		GridData editEntriesData = new GridData(GridData.FILL_HORIZONTAL);
		editEntries.setLayoutData(editEntriesData);
		editEntries.addSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
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
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GameScorePropertiesEditionPartForm.this, TarotViewsRepository.GameScore.entries, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, propertiesEditionObject));
			}
		}
		// End of user code

	}

	/**
	 * 
	 */
	protected void removeFromEntries() {
		// Start of user code for the removeFromEntries() method body
		if (entries.getSelection() instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection) entries.getSelection();
			EObject editedElement = null;
			if (selection.getFirstElement() instanceof EObject) {
				EObject selectedElement = (EObject) selection.getFirstElement();
				editedElement = entriesEditUtil.foundCorrespondingEObject(selectedElement);
				entriesEditUtil.removeElement(selectedElement);
			}
			entries.refresh();
			propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GameScorePropertiesEditionPartForm.this, TarotViewsRepository.GameScore.entries, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
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
				IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(selectedElement);
				IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
				if (editionPolicy != null) {
					EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, selectedElement,resourceSet));
					if (propertiesEditionObject != null) {
						entriesEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
						entries.refresh();
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GameScorePropertiesEditionPartForm.this, TarotViewsRepository.GameScore.entries, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
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
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.GameScorePropertiesEditionPart#getEntriesToAdd()
	 */
	public List getEntriesToAdd() {
		return entriesEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.GameScorePropertiesEditionPart#getEntriesToRemove()
	 */
	public List getEntriesToRemove() {
		return entriesEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.GameScorePropertiesEditionPart#getEntriesToEdit()
	 */
	public Map getEntriesToEdit() {
		return entriesEditUtil.getElementsToRefresh();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.GameScorePropertiesEditionPart#getEntriesToMove()
	 */
	public List getEntriesToMove() {
		return entriesEditUtil.getElementsToMove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.GameScorePropertiesEditionPart#getEntriesTable()
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
	 */
	public void addFilterToEntries(ViewerFilter filter) {
		entriesFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.GameScorePropertiesEditionPart#addBusinessFilterEntries(ViewerFilter filter)
	 */
	public void addBusinessFilterToEntries(ViewerFilter filter) {
		entriesBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.samples.eef.tarot.parts.GameScorePropertiesEditionPart#isContainedInEntriesTable(EObject element)
	 */
	public boolean isContainedInEntriesTable(EObject element) {
		return entriesEditUtil.contains(element);
	}










	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 */
	public String getTitle() {
		return TarotMessages.GameScore_Part_Title;
	}

	// Start of user code additional methods
	private EntriesComparator entryComparator = new EntriesComparator();
	
	private final class EntriesComparator extends ViewerComparator {
		
		private boolean ascending = false;
		
		public void reverse() {
			ascending = !ascending;
		}
		
		/**
		 * {@inheritDoc}
		 * @see org.eclipse.jface.viewers.ViewerComparator#compare(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
		 */
		public int compare(Viewer viewer, Object e1, Object e2) {
			if (e1 instanceof ScoreEntry && e2 instanceof ScoreEntry) {
				ScoreEntry se1 = (ScoreEntry)entriesEditUtil.foundCorrespondingEObject((EObject) e1);
				ScoreEntry se2 = (ScoreEntry)entriesEditUtil.foundCorrespondingEObject((EObject) e2);
				if (se1.getGame() == se2.getGame()) {
					Game game = se1.getGame();
					int compareTo = Integer.valueOf(game.getEntries().indexOf(se1)).compareTo(Integer.valueOf(game.getEntries().indexOf(se2)));
					return ascending?compareTo:-compareTo;
				}
			}
			return 0;
		}
	}
	
	

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.samples.eef.tarot.parts.GameScorePropertiesEditionPart#updatePlayerColumns(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePlayerColumns(Notification msg) {
		if (entries != null) {
			if (msg.getEventType() == Notification.ADD && msg.getNewValue() instanceof Player)
				addColumnPlayer(entries.getTable(), (Player) msg.getNewValue());
			else if (msg.getEventType() == Notification.REMOVE && msg.getOldValue() instanceof Player)
				removeColumnPlayer(entries.getTable(), (Player) msg.getOldValue());
			else if (msg.getEventType() == Notification.SET && msg.getFeature() == TarotPackage.eINSTANCE.getPlayer_Name())
				updateColumnPlayer(entries.getTable(), (Player)msg.getNotifier(), msg.getNewStringValue());
			entries.refresh();
		}			
	}

	/*
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart#setContext(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void setContext(EObject eObject, ResourceSet allResources) {
		super.setContext(eObject, allResources);
		Table tableEntries = entries.getTable();
		TableColumn number = new TableColumn(tableEntries, SWT.NONE);
		number.setWidth(30);
		number.setText("#"); //$NON-NLS-1$
		number.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				entryComparator.reverse();
				entries.refresh();
			}
			
		});
		TableColumn round = new TableColumn(tableEntries, SWT.NONE);
		round.setWidth(200);
		round.setText("Round"); //$NON-NLS-1$
		Game game = (Game)current;
		for (Player player : game.getPlayers()) {
			addColumnPlayer(tableEntries, player);
		}
		entries.setComparator(entryComparator);
	}	

	/**
	 * @param tableEntries
	 * @param player
	 */
	private void addColumnPlayer(Table tableEntries, Player player) {
		TableColumn column = new TableColumn(tableEntries, SWT.NONE);
		column.setWidth(80);
		column.setText(player.getName());
		column.setData(player);
	}
	
	/**
	 * @param tableEntries
	 * @param player
	 */
	private void removeColumnPlayer(Table tableEntries, Player player) {
		TableColumn[] columns = tableEntries.getColumns();
		for (int i = 0; i < columns.length; i++) {
			if (player.equals(columns[i].getData())) {
				columns[i].dispose();
				break;
			}
		}
	}
	
	/**
	 * @param tableEntries
	 * @param player
	 * @param newPlayerName
	 */
	private void updateColumnPlayer(Table tableEntries, Player player, String newPlayerName) {
		TableColumn[] columns = tableEntries.getColumns();
		for (int i = 0; i < columns.length; i++) {
			if (player.equals(columns[i].getData())) {
				columns[i].setText(newPlayerName);
				break;
			}
		}
	}
	
	// End of user code

}
