/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.subPackageNonRegForFilters.components;

// Start of user code for imports

import java.util.Collection;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.IdentityCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.middle.middlenonreg.MiddlenonregPackage;
import org.eclipse.emf.eef.middle.middlenonreg.NamedElement;
import org.eclipse.emf.eef.nonreg.NonregPackage;
import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;
import org.eclipse.emf.eef.nonreg.parts.TestFilterPropertiesEditionPart;
import org.eclipse.emf.eef.nonreg.subPackageNonRegForFilters.ForFilters;
import org.eclipse.emf.eef.nonreg.subPackageNonRegForFilters.SubPackageNonRegForFiltersPackage;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

// End of user code
/**
 * 
 */
public class TestFilterFlatComboPropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String TESTFILTER_PART = "testFilter"; //$NON-NLS-1$

	private String[] parts = {TESTFILTER_PART};

	/**
	 * The EObject to edit
	 */
	private ForFilters forFilters;

	/**
	 * The testFilter part
	 */
	private TestFilterPropertiesEditionPart testFilterPart;

	/**
	 * Default constructor
	 */
	public TestFilterFlatComboPropertiesEditionComponent(EObject forFilters, String editing_mode) {
		if (forFilters instanceof ForFilters) {
			this.forFilters = (ForFilters)forFilters;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.forFilters.eAdapters().add(semanticAdapter);
			}
		}
		this.editing_mode = editing_mode;
	}

	/**
	 * Initialize the semantic model listener for live editing mode
	 * 
	 * @return the semantic model listener
	 */
	private AdapterImpl initializeSemanticAdapter() {
		return new EContentAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
			 */
			public void notifyChanged(Notification msg) {
				if (testFilterPart == null)
					TestFilterFlatComboPropertiesEditionComponent.this.dispose();
				else {
					if (SubPackageNonRegForFiltersPackage.eINSTANCE.getForFilters_EOFCV().equals(msg.getFeature()) && testFilterPart != null)
						testFilterPart.setTestEOFCV((EObject)msg.getNewValue());
					if (SubPackageNonRegForFiltersPackage.eINSTANCE.getForFilters_EOFCV().equals(msg.getFeature()) && testFilterPart != null)
						testFilterPart.setTestAEOFCV((EObject)msg.getNewValue());


				}
			}

		};
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#translatePart(java.lang.String)
	 */
	public java.lang.Class translatePart(String key) {
		if (TESTFILTER_PART.equals(key))
			return NonregViewsRepository.TestFilter.class;
		return super.translatePart(key);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#partsList()
	 */
	public String[] partsList() {
		return parts;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionPart
	 * (java.lang.String, java.lang.String)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (forFilters != null && TESTFILTER_PART.equals(key)) {
			if (testFilterPart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(NonregViewsRepository.class);
				if (provider != null) {
					testFilterPart = (TestFilterPropertiesEditionPart)provider.getPropertiesEditionPart(NonregViewsRepository.TestFilter.class, kind, this);
					addListener((IPropertiesEditionListener)testFilterPart);
				}
			}
			return (IPropertiesEditionPart)testFilterPart;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#
	 *      setPropertiesEditionPart(java.lang.Class, int, org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart)
	 */
	public void setPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionPart propertiesEditionPart) {
		if (key == NonregViewsRepository.TestFilter.class)
			this.testFilterPart = (TestFilterPropertiesEditionPart) propertiesEditionPart;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		if (testFilterPart != null && key == NonregViewsRepository.TestFilter.class) {
			((IPropertiesEditionPart)testFilterPart).setContext(elt, allResource);
			ForFilters forFilters = (ForFilters)elt;
			// init values
			testFilterPart.initTestEOFCV(allResource, forFilters.getEOFCV());
			testFilterPart.initTestAEOFCV(allResource, forFilters.getEOFCV());
			
			// init filters
			testFilterPart.addFilterToTestEOFCV(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof NamedElement); //$NON-NLS-1$ 
				}

			});
			testFilterPart.addFilterToTestEOFCV(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return true;
				}

			});
			testFilterPart.addFilterToTestEOFCV(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return methodFilterEOFCV(viewer, parentElement, element);
				}

			});
			// OCLFilter not implemented yet
			testFilterPart.addFilterToTestEOFCV(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					Object result = EEFUtils.choiceOfValues(TestFilterFlatComboPropertiesEditionComponent.this.forFilters, NonregPackage.eINSTANCE.getPerson_Assists());
					if (result instanceof Collection) {
						return ((Collection)result).contains(element);
					} else if (result instanceof ResourceSet && element instanceof EObject) {
						return ((EObject)element).eResource() != null && ((EObject)element).eResource().getResourceSet() != null && ((EObject)element).eResource().getResourceSet().equals(result);
					}
					return element instanceof Resource;
				}
			});
			// Start of user code for additional businessfilters for testFilterForEOFCV
			
			// End of user code
			testFilterPart.addFilterToTestAEOFCV(new EObjectFilter(MiddlenonregPackage.eINSTANCE.getNamedElement()));
		}
		// init values for referenced views

		// init filters for referenced views

	}

	/**
	 * 
	 */
	private boolean methodFilterEOFCV(Viewer viewer, Object parentElement, Object element){
		// Start of user code for user filter methodFilterEOFCV
		return false;
		// End of user code
	}

	/**
	 * 
	 */
	private boolean methodFilterAEOFCV(Viewer viewer, Object parentElement, Object element){
		// Start of user code for user filter methodFilterAEOFCV
		return false;
		// End of user code
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand
	 *     (org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if (forFilters != null) {
			if (forFilters.eGet(SubPackageNonRegForFiltersPackage.eINSTANCE.getForFilters_EOFCV()) == null || !forFilters.eGet(SubPackageNonRegForFiltersPackage.eINSTANCE.getForFilters_EOFCV()).equals(testFilterPart.getTestEOFCV())) {
				cc.append(SetCommand.create(editingDomain, forFilters, SubPackageNonRegForFiltersPackage.eINSTANCE.getForFilters_EOFCV(), testFilterPart.getTestEOFCV()));
			}
			if (forFilters.eGet(SubPackageNonRegForFiltersPackage.eINSTANCE.getForFilters_EOFCV()) == null || !forFilters.eGet(SubPackageNonRegForFiltersPackage.eINSTANCE.getForFilters_EOFCV()).equals(testFilterPart.getTestAEOFCV())) {
				cc.append(SetCommand.create(editingDomain, forFilters, SubPackageNonRegForFiltersPackage.eINSTANCE.getForFilters_EOFCV(), testFilterPart.getTestAEOFCV()));
			}


		}
		if (!cc.isEmpty())
			return cc;
		cc.append(IdentityCommand.INSTANCE);
		return cc;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionObject()
	 */
	public EObject getPropertiesEditionObject(EObject source) {
		if (source instanceof ForFilters) {
			ForFilters forFiltersToUpdate = (ForFilters)source;
			forFiltersToUpdate.setEOFCV((NamedElement)testFilterPart.getTestEOFCV());
			forFiltersToUpdate.setEOFCV((NamedElement)testFilterPart.getTestAEOFCV());


			return forFiltersToUpdate;
		}
		else
			return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.common.notify.Notification)
	 */
	public void firePropertiesChanged(PropertiesEditionEvent event) {
		super.firePropertiesChanged(event);
		if (PropertiesEditionEvent.COMMIT == event.getState() && IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
			CompoundCommand command = new CompoundCommand();
			if (NonregViewsRepository.TestFilter.testEOFCV == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, forFilters, SubPackageNonRegForFiltersPackage.eINSTANCE.getForFilters_EOFCV(), event.getNewValue()));
			if (NonregViewsRepository.TestFilter.testAEOFCV == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, forFilters, SubPackageNonRegForFiltersPackage.eINSTANCE.getForFilters_EOFCV(), event.getNewValue()));


			liveEditingDomain.getCommandStack().execute(command);
		} else if (PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {




			} else {




			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.common.notify.Notification)
	 */
	public Diagnostic validateValue(PropertiesEditionEvent event) {
		Diagnostic ret = null;
		if (event.getNewValue() != null) {
			String newStringValue = event.getNewValue().toString();
			try {

			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			}
		}
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validate()
	 */
	public Diagnostic validate() {
		Diagnostic validate = null;
		if (IPropertiesEditionComponent.BATCH_MODE.equals(editing_mode)) {
			EObject copy = EcoreUtil.copy(PropertiesContextService.getInstance().entryPointElement());
			copy = PropertiesContextService.getInstance().entryPointComponent().getPropertiesEditionObject(copy);
			validate =  Diagnostician.INSTANCE.validate(copy);
		}
		else if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode))
			validate = Diagnostician.INSTANCE.validate(forFilters);
		// Start of user code for custom validation check
		
		// End of user code
		return validate;
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#dispose()
	 */
	public void dispose() {
		if (semanticAdapter != null)
			forFilters.eAdapters().remove(semanticAdapter);
	}

}

