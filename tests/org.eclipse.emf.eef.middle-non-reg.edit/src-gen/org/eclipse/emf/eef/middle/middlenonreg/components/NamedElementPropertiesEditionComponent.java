/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.middle.middlenonreg.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.middle.middlenonreg.NamedElement;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.emf.eef.ab.abstractnonreg.components.DocumentedElementPropertiesEditionComponent;

// End of user code
/**
 * 
 */
public class NamedElementPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * Parameterized constructor
	 * 
	 * @param namedElement
	 *            the EObject to edit
	 */
	public NamedElementPropertiesEditionComponent(EObject namedElement, String editing_mode) {
		super(editing_mode);
		if (namedElement instanceof NamedElement) {
			addSubComponent(new NamedElementBasePropertiesEditionComponent(namedElement, editing_mode));
			addSubComponent(new DocumentedElementPropertiesEditionComponent(namedElement, editing_mode));
		}
	}
}

