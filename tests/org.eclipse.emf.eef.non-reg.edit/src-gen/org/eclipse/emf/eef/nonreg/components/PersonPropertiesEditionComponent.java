/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.nonreg.Person;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.nonreg.parts.PersonPropertiesEditionPart;
import org.eclipse.emf.eef.nonreg.parts.PresencePropertiesEditionPart;
import org.eclipse.emf.eef.nonreg.parts.NonregViewsRepository;

// End of user code
/**
 * 
 */
public class PersonPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The Base part
	 */
	private PersonPropertiesEditionPart basePart;

	/**
	 * The PersonBasePropertiesEditionComponent sub component
	 */
	protected PersonBasePropertiesEditionComponent personBasePropertiesEditionComponent;

	/**
	 * The Presence part
	 */
	private PresencePropertiesEditionPart presencePart;

	/**
	 * The PersonPresencePropertiesEditionComponent sub component
	 */
	protected PersonPresencePropertiesEditionComponent personPresencePropertiesEditionComponent;

	/**
	 * Parameterized constructor
	 * 
	 * @param person
	 *            the EObject to edit
	 */
	public PersonPropertiesEditionComponent(EObject person, String editing_mode) {
		super(editing_mode);
		if (person instanceof Person) {
			personBasePropertiesEditionComponent = new PersonBasePropertiesEditionComponent(person, editing_mode); 
			addSubComponent(personBasePropertiesEditionComponent);
			personPresencePropertiesEditionComponent = new PersonPresencePropertiesEditionComponent(person, editing_mode); 
			addSubComponent(personPresencePropertiesEditionComponent);
		}
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 * 		getPropertiesEditionPart(int, java.lang.String)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if ("Base".equals(key)) {
			basePart = (PersonPropertiesEditionPart)personBasePropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)basePart;
		}
		if ("Presence".equals(key)) {
			presencePart = (PresencePropertiesEditionPart)personPresencePropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)presencePart;
		}
		return super.getPropertiesEditionPart(kind, key);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 * setPropertiesEditionPart(java.lang.Class, int, org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart)
	 */
	public void setPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionPart propertiesEditionPart) {
		if (NonregViewsRepository.Person.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			basePart = (PersonPropertiesEditionPart)propertiesEditionPart;
		}
		if (NonregViewsRepository.Presence.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			presencePart = (PresencePropertiesEditionPart)propertiesEditionPart;
		}
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent
	 *	#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject element, ResourceSet allResource) {
		if (key == NonregViewsRepository.Person.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == NonregViewsRepository.Presence.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}

