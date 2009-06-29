/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.modelNavigation.providers;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;

import org.eclipse.emf.eef.nonreg.modelNavigation.ModelNavigationPackage;
import org.eclipse.emf.eef.nonreg.modelNavigation.Source;
import org.eclipse.emf.eef.nonreg.modelNavigation.components.SimpleSourcePropertiesEditionComponent;

/**
 * 
 */
public class SimpleSourcePropertiesEditionProvider implements IPropertiesEditionProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject)
	 */
	public boolean provides(EObject eObject) {
		return (eObject instanceof Source) && (ModelNavigationPackage.eINSTANCE.getSource() == eObject.eClass());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *      java.lang.String)
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String editing_mode) {
		if (eObject instanceof Source) {
			return new SimpleSourcePropertiesEditionComponent(eObject, editing_mode);
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
		if (eObject instanceof Source) {
			if (SimpleSourcePropertiesEditionComponent.SOURCE_PART.equals(part))
				return new SimpleSourcePropertiesEditionComponent(eObject, editing_mode);
		}
		return null;
	}

}

