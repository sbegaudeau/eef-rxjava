/**
 *  Copyright (c) 2008 - 2010 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Obeo - initial API and implementation
 *
 */
package org.eclipse.emf.eef.mapping.parts.forms;

// Start of user code for imports

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.mapping.parts.EMFPropertyBindingPropertiesEditionPart;
import org.eclipse.emf.eef.mapping.parts.MappingViewsRepository;
import org.eclipse.emf.eef.mapping.providers.MappingMessages;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProvider;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.policies.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPolicyProviderService;
import org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;
import org.eclipse.emf.eef.views.ElementEditor;
import org.eclipse.emf.eef.views.ViewsPackage;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class EMFPropertyBindingPropertiesEditionPartForm extends CompositePropertiesEditionPart implements IFormPropertiesEditionPart, EMFPropertyBindingPropertiesEditionPart {

	protected Text name;
	protected EObjectFlatComboViewer model;
	private EMFListEditUtil viewsEditUtil;
		protected ReferencesTable<? extends EObject> views;
		protected List<ViewerFilter> viewsBusinessFilters = new ArrayList<ViewerFilter>();
		protected List<ViewerFilter> viewsFilters = new ArrayList<ViewerFilter>();



	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public EMFPropertyBindingPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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

		createBindingGroup(widgetFactory, view);

		// Start of user code for additional ui definition
		
		// End of user code
	}
	/**
	 * 
	 */
	protected void createPropertiesGroup(FormToolkit widgetFactory, final Composite view) {
		Section propertiesSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(MappingMessages.EMFPropertyBindingPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		createNameText(widgetFactory, propertiesGroup);
		propertiesSection.setClient(propertiesGroup);
	}

	
	protected void createNameText(FormToolkit widgetFactory, Composite parent) {
		FormUtils.createPartLabel(widgetFactory, parent, MappingMessages.EMFPropertyBindingPropertiesEditionPart_NameLabel, propertiesEditionComponent.isRequired(MappingViewsRepository.EMFPropertyBinding.name, MappingViewsRepository.FORM_KIND));
		name = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		name.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EMFPropertyBindingPropertiesEditionPartForm.this, MappingViewsRepository.EMFPropertyBinding.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
			}
		});
		name.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EMFPropertyBindingPropertiesEditionPartForm.this, MappingViewsRepository.EMFPropertyBinding.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MappingViewsRepository.EMFPropertyBinding.name, MappingViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	/**
	 * 
	 */
	protected void createBindingGroup(FormToolkit widgetFactory, final Composite view) {
		Section bindingSection = widgetFactory.createSection(view, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		bindingSection.setText(MappingMessages.EMFPropertyBindingPropertiesEditionPart_BindingGroupLabel);
		GridData bindingSectionData = new GridData(GridData.FILL_HORIZONTAL);
		bindingSectionData.horizontalSpan = 3;
		bindingSection.setLayoutData(bindingSectionData);
		Composite bindingGroup = widgetFactory.createComposite(bindingSection);
		GridLayout bindingGroupLayout = new GridLayout();
		bindingGroupLayout.numColumns = 3;
		bindingGroup.setLayout(bindingGroupLayout);
		createModelFlatComboViewer(bindingGroup, widgetFactory);
		createViewsReferencesTable(widgetFactory, bindingGroup);
		bindingSection.setClient(bindingGroup);
	}

	/**
	 * @param bindingGroup
	 * 
	 */
	protected void createModelFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		FormUtils.createPartLabel(widgetFactory, parent, MappingMessages.EMFPropertyBindingPropertiesEditionPart_ModelLabel, propertiesEditionComponent.isRequired(MappingViewsRepository.EMFPropertyBinding.model, MappingViewsRepository.FORM_KIND));
		model = new EObjectFlatComboViewer(parent, false);
		model.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData modelData = new GridData(GridData.FILL_HORIZONTAL);
		model.setLayoutData(modelData);
		model.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EMFPropertyBindingPropertiesEditionPartForm.this, MappingViewsRepository.EMFPropertyBinding.model, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getModel()));
			}

		});
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(MappingViewsRepository.EMFPropertyBinding.model, MappingViewsRepository.FORM_KIND), null); //$NON-NLS-1$
	}

	/**
	 * 
	 */
	protected void createViewsReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.views = new ReferencesTable<ElementEditor>(MappingMessages.EMFPropertyBindingPropertiesEditionPart_ViewsLabel, new ReferencesTableListener<ElementEditor>() {
			public void handleAdd() {
				TabElementTreeSelectionDialog<ElementEditor> dialog = new TabElementTreeSelectionDialog<ElementEditor>(resourceSet, viewsFilters, viewsBusinessFilters,
				"ElementEditor", ViewsPackage.eINSTANCE.getElementEditor(), current.eResource()) {
					@Override
					public void process(IStructuredSelection selection) {
						for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
							EObject elem = (EObject) iter.next();
							if (!viewsEditUtil.getVirtualList().contains(elem))
								viewsEditUtil.addElement(elem);
							propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EMFPropertyBindingPropertiesEditionPartForm.this, MappingViewsRepository.EMFPropertyBinding.views,
								PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
						}
						views.refresh();
					}
				};
				dialog.open();
			}
			public void handleEdit(ElementEditor element) { editViews(element); }
			public void handleMove(ElementEditor element, int oldIndex, int newIndex) { moveViews(element, oldIndex, newIndex); }
			public void handleRemove(ElementEditor element) { removeFromViews(element); }
			public void navigateTo(ElementEditor element) { }
		});
		this.views.setHelpText(propertiesEditionComponent.getHelpContent(MappingViewsRepository.EMFPropertyBinding.views, MappingViewsRepository.FORM_KIND));
		this.views.createControls(parent, widgetFactory);
		GridData viewsData = new GridData(GridData.FILL_HORIZONTAL);
		viewsData.horizontalSpan = 3;
		this.views.setLayoutData(viewsData);
		this.views.disableMove();
	}

	/**
	 * 
	 */
	protected void moveViews(ElementEditor element, int oldIndex, int newIndex) {
		EObject editedElement = viewsEditUtil.foundCorrespondingEObject(element);
		viewsEditUtil.moveElement(element, oldIndex, newIndex);
		views.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EMFPropertyBindingPropertiesEditionPartForm.this, MappingViewsRepository.EMFPropertyBinding.views, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, editedElement, newIndex));
	}

	/**
	 * 
	 */
	protected void removeFromViews(ElementEditor element) {
		// Start of user code for the removeFromViews() method body
		EObject editedElement = viewsEditUtil.foundCorrespondingEObject(element);
		viewsEditUtil.removeElement(element);
		views.refresh();
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EMFPropertyBindingPropertiesEditionPartForm.this, MappingViewsRepository.EMFPropertyBinding.views, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, editedElement));
		// End of user code
	}

	/**
	 * 
	 */
	protected void editViews(ElementEditor element) {
		// Start of user code editViews() method body
		
		EObject editedElement = viewsEditUtil.foundCorrespondingEObject(element);
		IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService.getInstance().getProvider(element);
		IPropertiesEditionPolicy editionPolicy = policyProvider	.getEditionPolicy(editedElement);
		if (editionPolicy != null) {
			EObject propertiesEditionObject = editionPolicy.getPropertiesEditionObject(new EObjectPropertiesEditionContext(null, element,resourceSet));
			if (propertiesEditionObject != null) {
				viewsEditUtil.putElementToRefresh(editedElement, propertiesEditionObject);
				views.refresh();
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(EMFPropertyBindingPropertiesEditionPartForm.this, MappingViewsRepository.EMFPropertyBinding.views, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, editedElement, propertiesEditionObject));
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
		
		// Nothing to do
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.EMFPropertyBindingPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.EMFPropertyBindingPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.EMFPropertyBindingPropertiesEditionPart#getModel()
	 * 
	 */
	public EObject getModel() {
		if (model.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) model.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.EMFPropertyBindingPropertiesEditionPart#initModel(ResourceSet allResources, EObject current)
	 */
	public void initModel(ResourceSet allResources, EObject current) {
		model.setInput(allResources);
		if (current != null) {
			model.setSelection(new StructuredSelection(current));
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.EMFPropertyBindingPropertiesEditionPart#setModel(EObject newValue)
	 * 
	 */
	public void setModel(EObject newValue) {
		if (newValue != null) {
			model.setSelection(new StructuredSelection(newValue));
		} else {
			model.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.EMFPropertyBindingPropertiesEditionPart#setModelButtonMode(ButtonsModeEnum newValue)
	 */
	public void setModelButtonMode(ButtonsModeEnum newValue) {
		model.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.EMFPropertyBindingPropertiesEditionPart#addFilterModel(ViewerFilter filter)
	 * 
	 */
	public void addFilterToModel(ViewerFilter filter) {
		model.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.EMFPropertyBindingPropertiesEditionPart#addBusinessFilterModel(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToModel(ViewerFilter filter) {
		model.addBusinessRuleFilter(filter);
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.EMFPropertyBindingPropertiesEditionPart#getViewsToAdd()
	 * 
	 */
	public List getViewsToAdd() {
		return viewsEditUtil.getElementsToAdd();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.EMFPropertyBindingPropertiesEditionPart#getViewsToRemove()
	 * 
	 */
	public List getViewsToRemove() {
		return viewsEditUtil.getElementsToRemove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.EMFPropertyBindingPropertiesEditionPart#getViewsTable()
	 * 
	 */
	public List getViewsTable() {
		return viewsEditUtil.getVirtualList();
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.EMFPropertyBindingPropertiesEditionPart#initViews(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initViews(EObject current, EReference containingFeature, EReference feature) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		if (containingFeature != null)
			viewsEditUtil = new EMFListEditUtil(current, containingFeature, feature);
		else
			viewsEditUtil = new EMFListEditUtil(current, feature);
		this.views.setInput(viewsEditUtil.getVirtualList());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.EMFPropertyBindingPropertiesEditionPart#updateViews(EObject newValue)
	 * 
	 */
	public void updateViews(EObject newValue) {
		if(viewsEditUtil != null){
			viewsEditUtil.reinit(newValue);
			views.refresh();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.EMFPropertyBindingPropertiesEditionPart#addFilterViews(ViewerFilter filter)
	 * 
	 */
	public void addFilterToViews(ViewerFilter filter) {
		viewsFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.EMFPropertyBindingPropertiesEditionPart#addBusinessFilterViews(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToViews(ViewerFilter filter) {
		viewsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.mapping.parts.EMFPropertyBindingPropertiesEditionPart#isContainedInViewsTable(EObject element)
	 * 
	 */
	public boolean isContainedInViewsTable(EObject element) {
		return viewsEditUtil.contains(element);
	}




	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return MappingMessages.EMFPropertyBinding_Part_Title;
	}

	// Start of user code additional methods
 	
	// End of user code


}
