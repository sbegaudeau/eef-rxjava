/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.parts.forms;

// Start of user code for imports

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IMessageManager;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.events.IExpansionListener;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.events.IExpansionListener;

import org.eclipse.emf.eef.nonreg.NonregPackage;
import org.eclipse.emf.eef.nonreg.providers.NonregMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProvider;
import org.eclipse.emf.eef.runtime.impl.policies.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPolicyProviderService;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.api.parts.EEFMessageManager;
import org.eclipse.emf.eef.nonreg.parts.ReferencesTablePropertiesEditionPart;
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
import org.eclipse.swt.graphics.Image;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFModelViewerDialog;
import org.eclipse.emf.eef.nonreg.Talk;
import org.eclipse.emf.eef.nonreg.Talk;

import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;

// End of user code

/**
 * 
 */
public class ReferencesTablePropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, ReferencesTablePropertiesEditionPart {

	protected EMFListEditUtil referencestableEditUtil;
	protected TableViewer referencestable;
	protected Button addReferencestable;
	protected Button removeReferencestable;
	protected List<ViewerFilter> referencestableBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> referencestableFilters = new ArrayList<ViewerFilter>();
	protected EMFListEditUtil referencestableROEditUtil;
	protected TableViewer referencestableRO;
	protected Button addReferencestableRO;
	protected Button removeReferencestableRO;
	protected List<ViewerFilter> referencestableROBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> referencestableROFilters = new ArrayList<ViewerFilter>();




	
	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public ReferencesTablePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 * 			createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 */
	public Composite createFigure(final Composite parent, final FormToolkit widgetFactory) {
		ScrolledForm scrolledForm = widgetFactory.createScrolledForm(parent);
		Form form = scrolledForm.getForm();
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(widgetFactory, view, new EEFMessageManager(scrolledForm, widgetFactory));
		return scrolledForm;
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 * 			createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.IMessageManager)
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view, IMessageManager messageManager) {
		this.messageManager = messageManager;
		createReferencestableReferencesTable(widgetFactory, view);
		createReferencestableROReferencesTable(widgetFactory, view);
		// Start of user code for additional ui definition
		
		// End of user code
		
	}

	protected void createReferencestableReferencesTable(FormToolkit widgetFactory, Composite parent) {
		Label referencestableLabel = FormUtils.createPartLabel(widgetFactory, parent, NonregMessages.ReferencesTablePropertiesEditionPart_ReferencestableLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.ReferencesTable.referencestable, NonregViewsRepository.FORM_KIND));
		GridData referencestableLabelData = new GridData();
		referencestableLabelData.horizontalSpan = 3;
		referencestableLabel.setLayoutData(referencestableLabelData);
		referencestable = createReferencestableViewer(parent, widgetFactory, adapterFactory);
		GridData referencestableData = new GridData(GridData.FILL_HORIZONTAL);
		referencestableData.horizontalSpan = 2;
		referencestableData.minimumHeight = 120;
		referencestableData.heightHint = 120;
		referencestable.getTable().setLayoutData(referencestableData);
		createReferencestableControlPanel(parent, widgetFactory);
	}

	protected TableViewer createReferencestableViewer(Composite container, FormToolkit widgetFactory, AdapterFactory adapter) {
		org.eclipse.swt.widgets.Table table = widgetFactory.createTable(container, SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = GridData.FILL;
		gd.grabExcessVerticalSpace = true;
		gd.verticalAlignment = GridData.FILL;
		table.setLayoutData(gd);
		table.setLinesVisible(true);
		// Start of user code for table referencestable s columns definition
		TableColumn name = new TableColumn(table, SWT.NONE);
		name.setWidth(80);
		name.setText("Label"); //$NON-NLS-1$
		// End of user code
		
		TableViewer result = new TableViewer(table);
		result.setContentProvider(new ArrayContentProvider());
		result.setLabelProvider(new ITableLabelProvider() {
	
			// Start of user code for table referencestable label provider
			
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
			// End of user code

			public Image getColumnImage(Object element, int columnIndex) {
				return null;
			}

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
		return result;
	}

	protected void createReferencestableControlPanel(Composite container, FormToolkit widgetFactory) {
		Composite result = widgetFactory.createComposite(container, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		result.setLayout(layout);
		addReferencestable = widgetFactory.createButton(result, NonregMessages.PropertiesEditionPart_AddListViewerLabel, SWT.NONE);
		GridData addData = new GridData(GridData.FILL_HORIZONTAL);
		addReferencestable.setLayoutData(addData);
		addReferencestable.addSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				addReferencestable();
				referencestable.refresh();
			}

		});
		removeReferencestable = widgetFactory.createButton(result, NonregMessages.PropertiesEditionPart_RemoveListViewerLabel, SWT.NONE);
		GridData removeData = new GridData(GridData.FILL_HORIZONTAL);
		removeReferencestable.setLayoutData(removeData);
		removeReferencestable.addSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				if (referencestable.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection selection = (IStructuredSelection) referencestable.getSelection();
					removeReferencestable(selection);
					referencestable.refresh();
				}
			}

		});
	}
	
	/**
	 *
	 */
	protected void addReferencestable() {

		EMFModelViewerDialog dialog = new EMFModelViewerDialog(new AdapterFactoryLabelProvider(adapterFactory), resourceSet, referencestableFilters, referencestableBusinessFilters, false, true) {
			public void process(IStructuredSelection selection) {
				for (Iterator iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					if (!referencestableEditUtil.getVirtualList().contains(elem)) {
						referencestableEditUtil.addElement(elem);
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ReferencesTablePropertiesEditionPartForm.this, NonregViewsRepository.ReferencesTable.referencestable, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, referencestableEditUtil.foundCorrespondingEObject(elem)));
					}
				}
			}

		};
		dialog.open();
	}
	
	/**
	 * @param selection the referencestable to remove
	 */
	protected void removeReferencestable(IStructuredSelection selection) {
		if (selection.getFirstElement() instanceof EObject) {
			EObject selectedElement = (EObject) selection.getFirstElement();
			referencestableEditUtil.removeElement(selectedElement);
			propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ReferencesTablePropertiesEditionPartForm.this, NonregViewsRepository.ReferencesTable.referencestable, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, referencestableEditUtil.foundCorrespondingEObject(selectedElement)));
		}
	}
	protected void createReferencestableROReferencesTable(FormToolkit widgetFactory, Composite parent) {
		Label referencestableROLabel = FormUtils.createPartLabel(widgetFactory, parent, NonregMessages.ReferencesTablePropertiesEditionPart_ReferencestableROLabel, propertiesEditionComponent.isRequired(NonregViewsRepository.ReferencesTable.referencestableRO, NonregViewsRepository.FORM_KIND));
		GridData referencestableROLabelData = new GridData();
		referencestableROLabelData.horizontalSpan = 3;
		referencestableROLabel.setLayoutData(referencestableROLabelData);
		referencestableRO = createReferencestableROViewer(parent, widgetFactory, adapterFactory);
		GridData referencestableROData = new GridData(GridData.FILL_HORIZONTAL);
		referencestableROData.horizontalSpan = 2;
		referencestableROData.minimumHeight = 120;
		referencestableROData.heightHint = 120;
		referencestableRO.getTable().setLayoutData(referencestableROData);
		createReferencestableROControlPanel(parent, widgetFactory);
	}

	protected TableViewer createReferencestableROViewer(Composite container, FormToolkit widgetFactory, AdapterFactory adapter) {
		org.eclipse.swt.widgets.Table table = widgetFactory.createTable(container, SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setEnabled(false);
		table.setToolTipText(NonregMessages.ReferencesTable_ReadOnly);
		GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = GridData.FILL;
		gd.grabExcessVerticalSpace = true;
		gd.verticalAlignment = GridData.FILL;
		table.setLayoutData(gd);
		table.setLinesVisible(true);
		// Start of user code for table referencestableRO s columns definition
		TableColumn name = new TableColumn(table, SWT.NONE);
		name.setWidth(80);
		name.setText("Label"); //$NON-NLS-1$
		// End of user code
		
		TableViewer result = new TableViewer(table);
		result.setContentProvider(new ArrayContentProvider());
		result.setLabelProvider(new ITableLabelProvider() {
	
			// Start of user code for table referencestableRO label provider
			
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
			// End of user code

			public Image getColumnImage(Object element, int columnIndex) {
				return null;
			}

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
		return result;
	}

	protected void createReferencestableROControlPanel(Composite container, FormToolkit widgetFactory) {
		Composite result = widgetFactory.createComposite(container, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		result.setLayout(layout);
		addReferencestableRO = widgetFactory.createButton(result, NonregMessages.PropertiesEditionPart_AddListViewerLabel, SWT.NONE);
		addReferencestableRO.setEnabled(false);
		addReferencestableRO.setToolTipText(NonregMessages.ReferencesTable_ReadOnly);
		GridData addData = new GridData(GridData.FILL_HORIZONTAL);
		addReferencestableRO.setLayoutData(addData);
		addReferencestableRO.addSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				addReferencestableRO();
				referencestableRO.refresh();
			}

		});
		removeReferencestableRO = widgetFactory.createButton(result, NonregMessages.PropertiesEditionPart_RemoveListViewerLabel, SWT.NONE);
		removeReferencestableRO.setEnabled(false);
		removeReferencestableRO.setToolTipText(NonregMessages.ReferencesTable_ReadOnly);
		GridData removeData = new GridData(GridData.FILL_HORIZONTAL);
		removeReferencestableRO.setLayoutData(removeData);
		removeReferencestableRO.addSelectionListener(new SelectionAdapter() {

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			public void widgetSelected(SelectionEvent e) {
				if (referencestableRO.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection selection = (IStructuredSelection) referencestableRO.getSelection();
					removeReferencestableRO(selection);
					referencestableRO.refresh();
				}
			}

		});
	}
	
	/**
	 *
	 */
	protected void addReferencestableRO() {

		EMFModelViewerDialog dialog = new EMFModelViewerDialog(new AdapterFactoryLabelProvider(adapterFactory), resourceSet, referencestableROFilters, referencestableROBusinessFilters, false, true) {
			public void process(IStructuredSelection selection) {
				for (Iterator iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					if (!referencestableROEditUtil.getVirtualList().contains(elem)) {
						referencestableROEditUtil.addElement(elem);
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ReferencesTablePropertiesEditionPartForm.this, NonregViewsRepository.ReferencesTable.referencestableRO, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, referencestableROEditUtil.foundCorrespondingEObject(elem)));
					}
				}
			}

		};
		dialog.open();
	}
	
	/**
	 * @param selection the referencestableRO to remove
	 */
	protected void removeReferencestableRO(IStructuredSelection selection) {
		if (selection.getFirstElement() instanceof EObject) {
			EObject selectedElement = (EObject) selection.getFirstElement();
			referencestableROEditUtil.removeElement(selectedElement);
			propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ReferencesTablePropertiesEditionPartForm.this, NonregViewsRepository.ReferencesTable.referencestableRO, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, referencestableROEditUtil.foundCorrespondingEObject(selectedElement)));
		}
	}

	
	public void firePropertiesChanged(PropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.ReferencesTablePropertiesEditionPart#getReferencestableToAdd()
	 */
	public List getReferencestableToAdd() {
		return referencestableEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.ReferencesTablePropertiesEditionPart#getReferencestableToRemove()
	 */
	public List getReferencestableToRemove() {
		return referencestableEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.ReferencesTablePropertiesEditionPart#getReferencestableTable()
	 */
	public List getReferencestableTable() {
		return referencestableEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.ReferencesTablePropertiesEditionPart#initReferencestable(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initReferencestable(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			referencestableEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			referencestableEditUtil = new EMFListEditUtil(current, feature);
		this.referencestable.setInput(referencestableEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.ReferencesTablePropertiesEditionPart#updateReferencestable(EObject newValue)
	 */
	public void updateReferencestable(EObject newValue) {
		if(referencestableEditUtil != null){
			referencestableEditUtil.reinit(newValue);
			referencestable.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.ReferencesTablePropertiesEditionPart#addFilterReferencestable(ViewerFilter filter)
	 */
	public void addFilterToReferencestable(ViewerFilter filter) {
		referencestableFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.ReferencesTablePropertiesEditionPart#addBusinessFilterReferencestable(ViewerFilter filter)
	 */
	public void addBusinessFilterToReferencestable(ViewerFilter filter) {
		referencestableBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.ReferencesTablePropertiesEditionPart#isContainedInReferencestableTable(EObject element)
	 */
	public boolean isContainedInReferencestableTable(EObject element) {
		return referencestableEditUtil.contains(element);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.ReferencesTablePropertiesEditionPart#getReferencestableROToAdd()
	 */
	public List getReferencestableROToAdd() {
		return referencestableROEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.ReferencesTablePropertiesEditionPart#getReferencestableROToRemove()
	 */
	public List getReferencestableROToRemove() {
		return referencestableROEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.ReferencesTablePropertiesEditionPart#getReferencestableROTable()
	 */
	public List getReferencestableROTable() {
		return referencestableROEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.ReferencesTablePropertiesEditionPart#initReferencestableRO(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initReferencestableRO(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			referencestableROEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			referencestableROEditUtil = new EMFListEditUtil(current, feature);
		this.referencestableRO.setInput(referencestableROEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.ReferencesTablePropertiesEditionPart#updateReferencestableRO(EObject newValue)
	 */
	public void updateReferencestableRO(EObject newValue) {
		if(referencestableROEditUtil != null){
			referencestableROEditUtil.reinit(newValue);
			referencestableRO.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.ReferencesTablePropertiesEditionPart#addFilterReferencestableRO(ViewerFilter filter)
	 */
	public void addFilterToReferencestableRO(ViewerFilter filter) {
		referencestableROFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.ReferencesTablePropertiesEditionPart#addBusinessFilterReferencestableRO(ViewerFilter filter)
	 */
	public void addBusinessFilterToReferencestableRO(ViewerFilter filter) {
		referencestableROBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.nonreg.parts.ReferencesTablePropertiesEditionPart#isContainedInReferencestableROTable(EObject element)
	 */
	public boolean isContainedInReferencestableROTable(EObject element) {
		return referencestableROEditUtil.contains(element);
	}











	
	// Start of user code additional methods
	
	// End of user code

}	
