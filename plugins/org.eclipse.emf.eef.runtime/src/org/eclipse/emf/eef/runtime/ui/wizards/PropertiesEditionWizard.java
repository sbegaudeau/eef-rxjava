/*******************************************************************************
 * Copyright (c) 2008, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.ui.wizards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.context.impl.DomainPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext.InstanciableTypeFilter;
import org.eclipse.emf.eef.runtime.impl.services.LockPolicyProviderService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;
import org.eclipse.emf.eef.runtime.policies.ILockPolicy;
import org.eclipse.emf.eef.runtime.ui.utils.EEFRuntimeUIMessages;
import org.eclipse.emf.eef.runtime.ui.viewers.PropertiesEditionContentProvider;
import org.eclipse.emf.eef.runtime.ui.viewers.PropertiesEditionMessageManager;
import org.eclipse.emf.eef.runtime.ui.viewers.PropertiesEditionViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFEditorSettings;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class PropertiesEditionWizard extends Wizard {

	protected EditPropertyWizardPage mainPage;

	protected ElementCreationWizardPage elementCreationPage;

	protected PropertiesEditingContext editingContext;

	protected EObject eObject;

	protected EReference eReference;

	protected Command command;

	// protected ResourceSet allResources;

	private PropertiesEditionMessageManager messageManager;

	protected AdapterFactory adapterFactory;

	/**
	 * @param editionContext
	 *            defines the editing context.
	 * @param adapterFactory
	 *            the adapterFactory to use to get the editing component
	 * @param eObject
	 *            the eObject to edit
	 */
	public PropertiesEditionWizard(PropertiesEditingContext editionContext, AdapterFactory adapterFactory,
			EObject eObject) {
		this.editingContext = editionContext;
		this.eObject = eObject;
		this.adapterFactory = adapterFactory;
		this.setWindowTitle(eObject.eClass().getName());
		initMessageManager();
	}

	/**
	 * @param editingContext
	 *            defines the editing context.
	 * @param adapterFactory
	 *            the adapterFactory to use to get the editing component
	 * @param eReference
	 *            the eReference to edit
	 */
	public PropertiesEditionWizard(PropertiesEditingContext editingContext, AdapterFactory adapterFactory,
			EReference eReference) {
		this.editingContext = editingContext;
		this.eReference = eReference;
		this.adapterFactory = adapterFactory;
		this.setWindowTitle(eReference.getName());
		initMessageManager();
	}

	private void initMessageManager() {
		messageManager = new PropertiesEditionMessageManager() {

			@Override
			protected void updateStatus(String message) {
				if (mainPage != null) {
					if (message == null || "".equals(message)) {
						mainPage.setErrorMessage(null);
						mainPage.setPageComplete(true);
					} else {
						mainPage.setErrorMessage(message);
						mainPage.setPageComplete(false);
					}
				}
			}
		};
	}

	/**
	 * @return the editingDomain where to perform commands.
	 */
	public EditingDomain getEditingDomain() {
		return editingContext instanceof DomainPropertiesEditionContext ? ((DomainPropertiesEditionContext)editingContext)
				.getEditingDomain() : null;
	}

	/**
	 * @return the updated EObject.
	 */
	public EObject getEObject() {
		return eObject != null ? eObject : editingContext.getEObject();
	}

	/**
	 * @return the command to update the EObject.
	 */
	public Command getCommand() {
		return command;
	}

	/**
	 * @param listener
	 */
	public void addListener(IPropertiesEditionListener listener) {
		for (int i = 0; i < getPages().length; i++) {
			if (getPages()[i] instanceof EditPropertyWizardPage) {
				((EditPropertyWizardPage)getPages()[i]).viewer.addPropertiesListener(listener);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performCancel()
	 */
	@Override
	public boolean performCancel() {
		release();
		PropertiesContextService.getInstance().pop();
		return super.performCancel();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
//		release();
		return true;
	}
	
	private void release() {
		Object input = mainPage.viewer.getInput();
		if (input instanceof EObjectPropertiesEditionContext) {
			IPropertiesEditionComponent propertiesEditingComponent = ((EObjectPropertiesEditionContext)input).getPropertiesEditingComponent();
			if (propertiesEditingComponent != null) {
				for (ILockPolicy lockPolicies : LockPolicyProviderService.getInstance().getPolicies()) {
					lockPolicies.release(propertiesEditingComponent);
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#createPageControls(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPageControls(Composite pageContainer) {
		super.createPageControls(pageContainer);
		mainPage.setInput(eObject);
		lock();
	}

	private void lock() {
		Object input = mainPage.viewer.getInput();
		if (input instanceof EObjectPropertiesEditionContext) {
			IPropertiesEditionComponent propertiesEditingComponent = ((EObjectPropertiesEditionContext)input).getPropertiesEditingComponent();
			if (propertiesEditingComponent != null) {
				for (ILockPolicy lockPolicies : LockPolicyProviderService.getInstance().getPolicies()) {
					lockPolicies.lock(propertiesEditingComponent);
				}
			}
		}
	}

	@Override
	public void addPages() {
		if (inReferenceMode()) {
			List<EClass> instanciableTypes = getInstanciableTypes();
			if (instanciableTypes.size() == 1) {
				// We can directly instantiate the EObject
				// so the ElementCreationWizardPage is useless
				EObject create = EcoreUtil.create(instanciableTypes.get(0));
				editingContext.seteObject(create);
				eObject = create;
				if (editingContext instanceof EReferencePropertiesEditionContext) {
					if (((EReferencePropertiesEditionContext)editingContext).getSettings() != null) {
						EEFUtils.putToReference(((EReferencePropertiesEditionContext)editingContext).getSettings(), create);
					}
					this.setWindowTitle(eObject.eClass().getName());
				}
			} else {
				elementCreationPage = new ElementCreationWizardPage();
				elementCreationPage.setInstanciableTypes(instanciableTypes);
				addPage(elementCreationPage);
			}
		}
		mainPage = new EditPropertyWizardPage();
		addPage(mainPage);
		super.addPages();
	}

	/**
	 * @return
	 */
	protected boolean inReferenceMode() {
		return eReference != null && eReference.isContainment() && eObject == null;
	}
	
	protected List<EClass> getInstanciableTypes() {
		// Get types from the hierarchy
		List<EClass> instanciableTypesInHierarchy = getInstanciableTypesInHierarchy();
		
		// This types list may need to be filtered
		List<EClass> filteredInstanciableTypesInHierarchy = new ArrayList<EClass>();
		if (editingContext instanceof EReferencePropertiesEditionContext) {
			// Get filters defined on the PropertiesEditionContext
			Collection<InstanciableTypeFilter> instanciableTypeFilters = ((EReferencePropertiesEditionContext) editingContext)
																												.getInstanciableTypeFilters();
			// If there is no filter we keep all types
			if (instanciableTypeFilters.isEmpty()) {
				filteredInstanciableTypesInHierarchy = instanciableTypesInHierarchy;
			} else {
				// Let's use the filters to restrict the list
				for (EClass instanciableType : instanciableTypesInHierarchy) {
					for (InstanciableTypeFilter instanciableTypeFilter : instanciableTypeFilters) {
						if (instanciableTypeFilter.select(instanciableType)) {
							filteredInstanciableTypesInHierarchy.add(instanciableType);
							break;
						}
					}
				}
			}
		} else {
			// No need to filter the list
			filteredInstanciableTypesInHierarchy = instanciableTypesInHierarchy;
		}
		return filteredInstanciableTypesInHierarchy;
	}

	public Collection<EClass> listOfInstanciableType(AdapterFactory adapterFactory, EObject editedObject, EReference eReference) {
		Collection<EClass> result = new LinkedHashSet<EClass>();
		if (adapterFactory != null) {
			IEditingDomainItemProvider adapt = (IEditingDomainItemProvider) adapterFactory.adapt(editedObject, IEditingDomainItemProvider.class);
			Collection<?> newChildDescriptors = adapt.getNewChildDescriptors(editedObject, null, null);
			for (Object object : newChildDescriptors) {
				if (object instanceof CommandParameter) {
					CommandParameter commandParameter = (CommandParameter) object;
					if (equals((EStructuralFeature)commandParameter.feature, eReference) && commandParameter.value instanceof EObject) {
						result.add(((EObject) commandParameter.value).eClass());
					}
				}
			}
		} else {
			EClass eReferenceType = eReference.getEReferenceType();
			EObject container = eReferenceType;
			while (container.eContainer() != null) {
				container = container.eContainer();
			}
			TreeIterator<EObject> eAllContents = container.eAllContents();
			while (eAllContents.hasNext()) {
				EObject next = eAllContents.next();
				if (next instanceof EClass) {
					EClass eClass = (EClass) next;
					if (!(eClass.isAbstract()) && eReferenceType.isSuperTypeOf(eClass)) {
						result.add(eClass);
					}
				}
			}
		}
		return result;
	}
	
	public boolean equals(final EClass eClass1, final EClass eClass2) {
		if (eClass1.equals(eClass2)) {
			return true;
		}
		if (eClass1.eResource().getURI().isPlatform() && !eClass2.eResource().getURI().isPlatform()) {
			EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(eClass1.getEPackage().getNsURI());
			if (ePackage != null) {
				EClassifier mappedEClass1 = ePackage.getEClassifier(eClass1.getName());
				if (eClass2.equals(mappedEClass1)) {
					return true;
				}
			}
		}
		if (!eClass1.eResource().getURI().isPlatform() && eClass2.eResource().getURI().isPlatform()) {
			EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(eClass2.getEPackage().getNsURI());
			if (ePackage != null) {
				EClassifier mappedEClass2 = ePackage.getEClassifier(eClass2.getName());
				if (eClass1.equals(mappedEClass2)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.util.EMFService#equals(org.eclipse.emf.ecore.EStructuralFeature, org.eclipse.emf.ecore.EStructuralFeature)
	 */
	public boolean equals(EStructuralFeature esf1, EStructuralFeature esf2) {
		return equals(esf1.eClass(), esf2.eClass()) && esf1.getName().equals(esf2.getName());
	}
	
	protected List<EClass> getInstanciableTypesInHierarchy() {
		List<EClass> instanciableTypesInHierarchy;
		if (editingContext instanceof DomainPropertiesEditionContext) {
			instanciableTypesInHierarchy = EEFUtils.allTypeFor(eReference,
					((DomainPropertiesEditionContext)editingContext).getEditingDomain());
			editingContext = null;
		} else {
			Collection<EClass> listOfInstanciableType = listOfInstanciableType(editingContext.getAdapterFactory(), editingContext.getEObject(), eReference);
			instanciableTypesInHierarchy = new ArrayList<EClass>(listOfInstanciableType);
		}
		return instanciableTypesInHierarchy;
	}

	protected class ElementCreationWizardPage extends WizardPage {

		private List<Button> buttons = new ArrayList<Button>();
		private List<EClass> instanciableTypes = null;

		protected ElementCreationWizardPage() {
			super(EEFRuntimeUIMessages.PropertiesEditionWizard_creation_page_key);
			this.setTitle(EEFRuntimeUIMessages.PropertiesEditionWizard_creation_page_title);
			this.setDescription(EEFRuntimeUIMessages.PropertiesEditionWizard_creation_page_description);
		}
		
		protected void setInstanciableTypes(List<EClass> instanciableTypes) {
			this.instanciableTypes = instanciableTypes;
		}

		public void createControl(Composite parent) {
			Composite control = new Composite(parent, SWT.NONE);
			GridData gd = new GridData(GridData.FILL_BOTH);
			control.setLayoutData(gd);
			GridLayout layout = new GridLayout();
			control.setLayout(layout);
			
			// For compatibility, previous version could not be passed the instanciable types list
			// and had to calculate the list
			if (instanciableTypes == null) {
				instanciableTypes = getInstanciableTypesInHierarchy();
			}
			
			for (final EClass eClass : instanciableTypes) {
				Button button = new Button(control, SWT.RADIO);
				button.setText(eClass.getName());
				button.addSelectionListener(new SelectionAdapter() {

					public void widgetSelected(SelectionEvent e) {
						if (editingContext instanceof EReferencePropertiesEditionContext
								&& ((EReferencePropertiesEditionContext)editingContext).getSettings() != null) {
							EEFEditorSettings settings = ((EReferencePropertiesEditionContext)editingContext)
									.getSettings();
							if (settings instanceof ReferencesTableSettings) {
								((ReferencesTableSettings)((EReferencePropertiesEditionContext)editingContext)
										.getSettings()).removeFromReference(eObject);
							}
							eObject = EcoreUtil.create(eClass);
							EEFUtils.putToReference(settings, eObject);
						} else {
							eObject = EcoreUtil.create(eClass);
						}
						mainPage.setInput(eObject);
					}
				});
				buttons.add(button);
			}
			if (buttons.size() > 0) {
				buttons.get(0).setSelection(true);
				eObject = EcoreUtil.create(instanciableTypes.get(0));
				if (editingContext instanceof EReferencePropertiesEditionContext
						&& ((EReferencePropertiesEditionContext)editingContext).getSettings() != null) {
					EEFUtils.putToReference(
							((EReferencePropertiesEditionContext)editingContext).getSettings(), eObject);
				}
			} else {
				Label errorLabel = new Label(control, SWT.NONE);
				errorLabel.setText("Error non instanciable type found");
			}
			setControl(control);
		}

	}

	protected class EditPropertyWizardPage extends WizardPage implements IPropertiesEditionListener {

		protected PropertiesEditionViewer viewer;

		protected EditPropertyWizardPage() {
			super(EEFRuntimeUIMessages.PropertiesEditionWizard_main_page_key);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
		 */
		public void createControl(Composite parent) {
			try {
				Composite parentComposite = new Composite(parent, SWT.NONE);
				FillLayout layout = new FillLayout();
				layout.marginHeight = -5;
				layout.marginWidth = -5;
				parentComposite.setLayout(layout);
				ScrolledComposite scrolledContainer = new ScrolledComposite(parentComposite, SWT.H_SCROLL
						| SWT.V_SCROLL);
				scrolledContainer.setExpandHorizontal(true);
				scrolledContainer.setExpandVertical(true);
				Composite container = new Composite(scrolledContainer, SWT.FLAT);
				GridLayout containerLayout = new GridLayout();
				container.setLayout(containerLayout);
				ResourceSet resourceSet;
				if (editingContext != null)
					resourceSet = editingContext.getResourceSet();
				else
					resourceSet = eObject.eResource().getResourceSet();
				viewer = new PropertiesEditionViewer(container, resourceSet, 0);
				viewer.setDynamicTabHeader(true);
				viewer.setContentProvider(new PropertiesEditionContentProvider(adapterFactory,
						IPropertiesEditionComponent.BATCH_MODE));
				scrolledContainer.setContent(container);
				setControl(parentComposite);
			} catch (InstantiationException e) {
				EEFRuntimePlugin.getDefault().logError(
						EEFRuntimeUIMessages.PropertiesEditionWizard_error_wizard_live_mode, e);
			}
		}

		public void setInput(EObject eObject) {
			this.setTitle(eObject.eClass().getName());
			this.setDescription(EEFRuntimeUIMessages.PropertiesEditionWizard_main_page_description
					+ eObject.eClass().getName());
			EObjectPropertiesEditionContext subContext = new EObjectPropertiesEditionContext(editingContext, null, eObject, editingContext.getAdapterFactory());
			viewer.setInput(subContext);
			viewer.addPropertiesListener(this);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
		 */
		public void firePropertiesChanged(IPropertiesEditionEvent event) {
			handleChange(event);
		}

		private void handleChange(IPropertiesEditionEvent event) {
			// do not handle changes if you are in initialization.
			if (viewer.isInitializing())
				return;
			messageManager.processMessage(event);
		}

		private void updateStatus(final String message) {
			setMessage(null);
			setErrorMessage(message);
			setPageComplete(message == null);
		}

	}

}
