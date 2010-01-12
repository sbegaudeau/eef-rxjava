/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.middle.middlenonreg.components.NamedElementBasePropertiesEditionComponent;
import org.eclipse.emf.eef.nonreg.components.CiblePropertiesEditionComponent;
import org.eclipse.emf.eef.nonreg.components.CibleSuperCiblePropertiesEditionComponent;
import org.eclipse.emf.eef.nonreg.modelNavigation.ConcreteCible;
import org.eclipse.emf.eef.nonreg.modelNavigation.ModelNavigationPackage;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;

/**
 * 
 */
public class CiblePropertiesEditionProvider implements IPropertiesEditionProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject)
	 */
	public boolean provides(EObject eObject) {
		return (eObject instanceof ConcreteCible) && (ModelNavigationPackage.eINSTANCE.getConcreteCible() == eObject.eClass());
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject, java.lang.String)
	 */
	public boolean provides(EObject eObject, String part) {
		return provides(eObject)&& (CibleSuperCiblePropertiesEditionComponent.SUPERCIBLE_PART.equals(part) || NamedElementBasePropertiesEditionComponent.BASE_PART.equals(part));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *  java.lang.String)
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String editing_mode) {
		if (eObject instanceof ConcreteCible) {
			return new CiblePropertiesEditionComponent(eObject, editing_mode);
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
		if (eObject instanceof ConcreteCible) {
			if (CibleSuperCiblePropertiesEditionComponent.SUPERCIBLE_PART.equals(part))
				return new CibleSuperCiblePropertiesEditionComponent(eObject, editing_mode);
			if (NamedElementBasePropertiesEditionComponent.BASE_PART.equals(part))
				return new NamedElementBasePropertiesEditionComponent(eObject, editing_mode);
		}
		return null;
	}

}
