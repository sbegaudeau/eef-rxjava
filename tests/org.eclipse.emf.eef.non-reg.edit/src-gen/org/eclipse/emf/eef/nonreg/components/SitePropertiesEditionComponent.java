/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.nonreg.Site;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.emf.eef.middle.middlenonreg.components.NamedElementBasePropertiesEditionComponent;

// End of user code
/**
 * 
 */
public class SitePropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * Parameterized constructor
	 * 
	 * @param site
	 *            the EObject to edit
	 */
	public SitePropertiesEditionComponent(EObject site, String editing_mode) {
		super(editing_mode);
		if (site instanceof Site) {
			addSubComponent(new SiteBasePropertiesEditionComponent(site, editing_mode));
			addSubComponent(new NamedElementBasePropertiesEditionComponent(site, editing_mode));
		}
	}
}

