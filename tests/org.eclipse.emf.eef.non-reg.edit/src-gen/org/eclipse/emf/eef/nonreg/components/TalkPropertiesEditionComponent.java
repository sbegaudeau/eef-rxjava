/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.nonreg.Talk;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.emf.eef.ab.abstractnonreg.components.DocumentedElementPropertiesEditionComponent;

// End of user code
/**
 * 
 */
public class TalkPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * Parameterized constructor
	 * 
	 * @param talk
	 *            the EObject to edit
	 */
	public TalkPropertiesEditionComponent(EObject talk, String editing_mode) {
		super(editing_mode);
		if (talk instanceof Talk) {
			addSubComponent(new TalkBasePropertiesEditionComponent(talk, editing_mode));
			addSubComponent(new DocumentedElementPropertiesEditionComponent(talk, editing_mode));
		}
	}
}

