/**
 * Generated with Acceleo
 */
package org.eclipse.emf.samples.conference.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.impl.providers.StandardPropertiesEditionPolicyProvider;
import org.eclipse.emf.samples.conference.ConferencePackage;

/**
 * @author
 */
public class ConferencePackagePropertiesEditionPolicyProvider extends StandardPropertiesEditionPolicyProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProvider#provides(org.eclipse.emf.ecore.EObject)
	 */
	public boolean provides(EObject eObject) {
		return ConferencePackage.eINSTANCE.equals(eObject.eClass().getEPackage()) || ConferencePackage.eINSTANCE.getESubpackages().contains(eObject.eClass().getEPackage());
	}

}
