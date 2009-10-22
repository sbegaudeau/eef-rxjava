/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.subPackageNonRegForFilters.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;
import org.eclipse.emf.eef.nonreg.parts.TestFilterPropertiesEditionPart;
import org.eclipse.emf.eef.nonreg.parts.TestVRFilterPropertiesEditionPart;
import org.eclipse.emf.eef.nonreg.subPackageNonRegForFilters.ForFilters;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;

// End of user code

/**
 * 
 */
public class TestFilterForRVPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The testFilter part
	 */
	private TestFilterPropertiesEditionPart testFilterPart;

	/**
	 * The TestFilterForRVTestFilterPropertiesEditionComponent sub component
	 */
	protected TestFilterForRVTestFilterPropertiesEditionComponent testFilterForRVTestFilterPropertiesEditionComponent;

	/**
	 * The testVRFilter part
	 */
	private TestVRFilterPropertiesEditionPart testVRFilterPart;

	/**
	 * The TestFilterForRVTestVRFilterPropertiesEditionComponent sub component
	 */
	protected TestFilterForRVTestVRFilterPropertiesEditionComponent testFilterForRVTestVRFilterPropertiesEditionComponent;

	/**
	 * The TestFilterForReferenceTablesPropertiesEditionComponent sub component
	 */
	protected TestFilterForReferenceTablesPropertiesEditionComponent testFilterForReferenceTablesPropertiesEditionComponent;
	/**
	 * Parameterized constructor
	 * 
	 * @param forFilters
	 *            the EObject to edit
	 */
	public TestFilterForRVPropertiesEditionComponent(EObject forFilters, String editing_mode) {
		super(editing_mode);
		if (forFilters instanceof ForFilters) {
			testFilterForRVTestFilterPropertiesEditionComponent = new TestFilterForRVTestFilterPropertiesEditionComponent(forFilters, editing_mode); 
			addSubComponent(testFilterForRVTestFilterPropertiesEditionComponent);
			testFilterForRVTestVRFilterPropertiesEditionComponent = new TestFilterForRVTestVRFilterPropertiesEditionComponent(forFilters, editing_mode); 
			addSubComponent(testFilterForRVTestVRFilterPropertiesEditionComponent);
			testFilterForReferenceTablesPropertiesEditionComponent = new TestFilterForReferenceTablesPropertiesEditionComponent(forFilters, editing_mode);
			addSubComponent(testFilterForReferenceTablesPropertiesEditionComponent);
		}
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 * 		getPropertiesEditionPart(int, java.lang.String)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if ("testFilter".equals(key)) {
			testFilterPart = (TestFilterPropertiesEditionPart)testFilterForRVTestFilterPropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)testFilterPart;
		}
		if ("testVRFilter".equals(key)) {
			testVRFilterPart = (TestVRFilterPropertiesEditionPart)testFilterForRVTestVRFilterPropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)testVRFilterPart;
		}
		return super.getPropertiesEditionPart(kind, key);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 * setPropertiesEditionPart(java.lang.Class, int, org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart)
	 */
	public void setPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionPart propertiesEditionPart) {
		if (NonregViewsRepository.TestFilter.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			testFilterPart = (TestFilterPropertiesEditionPart)propertiesEditionPart;
		}
		if (NonregViewsRepository.TestVRFilter.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			testVRFilterPart = (TestVRFilterPropertiesEditionPart)propertiesEditionPart;
		}
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent
	 *	#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject element, ResourceSet allResource) {
		if (key == NonregViewsRepository.TestFilter.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == NonregViewsRepository.TestVRFilter.class) {
			super.initPart(key, kind, element, allResource);
			testFilterForReferenceTablesPropertiesEditionComponent.setPropertiesEditionPart(NonregViewsRepository.TestFilter.class, kind, testVRFilterPart.getTestFilterReferencedView());
			testFilterForReferenceTablesPropertiesEditionComponent.initPart(NonregViewsRepository.TestFilter.class, kind, element, allResource);
		}
			if (key == NonregViewsRepository.TestFilter.class) {
				super.initPart(key, kind, element, allResource);
			
			
			}
	}
}

