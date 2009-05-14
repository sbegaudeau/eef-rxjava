/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.ab.abstractnonreg.components.DocumentedElementPropertiesEditionComponent;
import org.eclipse.emf.eef.nonreg.Topic;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;

// End of user code
/**
 * 
 */
public class TopicPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * Parameterized constructor
	 * 
	 * @param topic
	 *            the EObject to edit
	 */
	public TopicPropertiesEditionComponent(EObject topic, String editing_mode) {
		super(editing_mode);
		if (topic instanceof Topic) {
			addSubComponent(new TopicBasePropertiesEditionComponent(topic, editing_mode));
			addSubComponent(new DocumentedElementPropertiesEditionComponent(topic, editing_mode));
		}
	}
}

