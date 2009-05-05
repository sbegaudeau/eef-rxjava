/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.nonreg.Person;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;

// End of user code
/**
 * 
 */
public class PersonPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * Parameterized constructor
	 * 
	 * @param person
	 *            the EObject to edit
	 */
	public PersonPropertiesEditionComponent(EObject person, String editing_mode) {
		super(editing_mode);
		if (person instanceof Person) {
			addSubComponent(new PersonBasePropertiesEditionComponent(person, editing_mode));
			addSubComponent(new PersonPresencePropertiesEditionComponent(person, editing_mode));
		}
	}
}

