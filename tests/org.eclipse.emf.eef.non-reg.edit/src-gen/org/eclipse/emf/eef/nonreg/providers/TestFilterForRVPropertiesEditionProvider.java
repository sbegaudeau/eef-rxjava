/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.nonreg.subPackageNonRegForFilters.ForFilters;
import org.eclipse.emf.eef.nonreg.subPackageNonRegForFilters.SubPackageNonRegForFiltersPackage;
import org.eclipse.emf.eef.nonreg.subPackageNonRegForFilters.components.TestFilterForRVPropertiesEditionComponent;
import org.eclipse.emf.eef.nonreg.subPackageNonRegForFilters.components.TestFilterForRVTestFilterPropertiesEditionComponent;
import org.eclipse.emf.eef.nonreg.subPackageNonRegForFilters.components.TestFilterForRVTestVRFilterPropertiesEditionComponent;
import org.eclipse.emf.eef.nonreg.subPackageNonRegForFilters.components.TestFilterForReferenceTablesPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;

/**
 * 
 */
public class TestFilterForRVPropertiesEditionProvider implements IPropertiesEditionProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject)
	 */
	public boolean provides(EObject eObject) {
		return (eObject instanceof ForFilters) && (SubPackageNonRegForFiltersPackage.eINSTANCE.getForFilters() == eObject.eClass());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *  java.lang.String)
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String editing_mode) {
		if (eObject instanceof ForFilters) {
			return new TestFilterForRVPropertiesEditionComponent(eObject, editing_mode);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *  java.lang.String, java.lang.String)
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String editing_mode, String part) {
		if (eObject instanceof ForFilters) {
			if (TestFilterForRVTestFilterPropertiesEditionComponent.TESTFILTER_PART.equals(part))
				return new TestFilterForRVTestFilterPropertiesEditionComponent(eObject, editing_mode);
			if (TestFilterForRVTestVRFilterPropertiesEditionComponent.TESTVRFILTER_PART.equals(part))
				return new TestFilterForRVTestVRFilterPropertiesEditionComponent(eObject, editing_mode);
			if (TestFilterForReferenceTablesPropertiesEditionComponent.TESTFILTER_PART.equals(part))
				return new TestFilterForReferenceTablesPropertiesEditionComponent(eObject, editing_mode);
		}
		return null;
	}

}
