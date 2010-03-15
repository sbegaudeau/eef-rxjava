/**
 * Generated with Acceleo
 */
package org.eclipse.emf.samples.eef.tarot.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.impl.providers.StandardPropertiesEditionPolicyProvider;
import org.eclipse.emf.samples.eef.tarot.TarotPackage;

/**
 * 
 * 
 */
public class TarotPackagePropertiesEditionPolicyProvider extends StandardPropertiesEditionPolicyProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProvider#provides(org.eclipse.emf.ecore.EObject)
	 * 
	 */
	public boolean provides(EObject eObject) {
		return TarotPackage.eINSTANCE.equals(eObject.eClass().getEPackage()) || TarotPackage.eINSTANCE.getESubpackages().contains(eObject.eClass().getEPackage());
	}

}
