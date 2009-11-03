/**
 * 
 */
package org.eclipse.emf.eef.runtime.ui.filters;

import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

/**
 * @author glefur
 *
 */
public class PropertiesEditionPartFilter extends ViewerFilter {

	private String key;
	
	/**
	 * Default constructor.
	 * @param key the key of the part to select
	 */
	public PropertiesEditionPartFilter(String key) {
		super();
		this.key = key;
	}



	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (parentElement instanceof String && element instanceof IPropertiesEditionPart)
			return parentElement.equals(key);
		return true;
	}

}
