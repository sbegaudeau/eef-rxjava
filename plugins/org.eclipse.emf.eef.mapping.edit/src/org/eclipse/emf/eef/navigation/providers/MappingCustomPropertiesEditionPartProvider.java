/**
 * 
 */
package org.eclipse.emf.eef.navigation.providers;

import org.eclipse.emf.eef.mapping.parts.MappingViewsRepository;
import org.eclipse.emf.eef.mapping.providers.MappingPropertiesEditionPartProvider;
import org.eclipse.emf.eef.navigation.parts.forms.SimpleModelNavigationCustomPropertiesEditionPartForm;
import org.eclipse.emf.eef.navigation.parts.impl.SimpleModelNavigationCustomPropertiesEditionPartImpl;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;

/**
 * @author glefur
 *
 */
public class MappingCustomPropertiesEditionPartProvider extends
		MappingPropertiesEditionPartProvider {

	@Override
	public IPropertiesEditionPart getPropertiesEditionPart(Class key, int kind,
			IPropertiesEditionComponent component) {
		if (key == MappingViewsRepository.SimpleModelNavigation.class) {
			if (kind == MappingViewsRepository.SWT_KIND)
				return new SimpleModelNavigationCustomPropertiesEditionPartImpl(component);
			if (kind == MappingViewsRepository.FORM_KIND)
				return new SimpleModelNavigationCustomPropertiesEditionPartForm(component);
		}
		return super.getPropertiesEditionPart(key, kind, component);
	}
	
	

}
