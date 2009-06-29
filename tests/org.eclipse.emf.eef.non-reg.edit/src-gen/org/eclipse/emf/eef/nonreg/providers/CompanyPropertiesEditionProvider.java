/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.providers;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;

import org.eclipse.emf.eef.nonreg.NonregPackage;
import org.eclipse.emf.eef.nonreg.Company;
import org.eclipse.emf.eef.nonreg.components.CompanyPropertiesEditionComponent;
import org.eclipse.emf.eef.nonreg.components.CompanyBasePropertiesEditionComponent;
import org.eclipse.emf.eef.middle.middlenonreg.components.NamedElementBasePropertiesEditionComponent;

/**
 * 
 */
public class CompanyPropertiesEditionProvider implements IPropertiesEditionProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject)
	 */
	public boolean provides(EObject eObject) {
		return (eObject instanceof Company) && (NonregPackage.eINSTANCE.getCompany() == eObject.eClass());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *      java.lang.String)
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String editing_mode) {
		if (eObject instanceof Company) {
			return new CompanyPropertiesEditionComponent(eObject, editing_mode);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *      java.lang.String, java.lang.String)
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String editing_mode, String part) {
		if (eObject instanceof Company) {
			if (CompanyBasePropertiesEditionComponent.BASE_PART.equals(part))
				return new CompanyBasePropertiesEditionComponent(eObject, editing_mode);
			if (NamedElementBasePropertiesEditionComponent.BASE_PART.equals(part))
				return new NamedElementBasePropertiesEditionComponent(eObject, editing_mode);
		}
		return null;
	}

}

