/**
 * Generated with Acceleo
 */
package org.eclipse.emf.samples.conference.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;
import org.eclipse.emf.samples.conference.ConferencePackage;
import org.eclipse.emf.samples.conference.Person;
import org.eclipse.emf.samples.conference.components.PersonBasePropertiesEditionComponent;
import org.eclipse.emf.samples.conference.components.PersonPresencePropertiesEditionComponent;
import org.eclipse.emf.samples.conference.components.PersonPropertiesEditionComponent;

/**
 * @author
 */
public class PersonPropertiesEditionProvider implements IPropertiesEditionProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject)
	 */
	public boolean provides(EObject eObject) {
		return (eObject instanceof Person) && (ConferencePackage.eINSTANCE.getPerson() == eObject.eClass());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *  java.lang.String)
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String editing_mode) {
		if (eObject instanceof Person) {
			return new PersonPropertiesEditionComponent(eObject, editing_mode);
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
		if (eObject instanceof Person) {
			if (PersonBasePropertiesEditionComponent.BASE_PART.equals(part))
				return new PersonBasePropertiesEditionComponent(eObject, editing_mode);
			if (PersonPresencePropertiesEditionComponent.PRESENCE_PART.equals(part))
				return new PersonPresencePropertiesEditionComponent(eObject, editing_mode);
		}
		return null;
	}

}
