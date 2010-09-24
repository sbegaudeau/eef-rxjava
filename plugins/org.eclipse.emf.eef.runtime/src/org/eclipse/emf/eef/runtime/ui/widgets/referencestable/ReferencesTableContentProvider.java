/**
 * 
 */
package org.eclipse.emf.eef.runtime.ui.widgets.referencestable;

import org.eclipse.jface.viewers.ArrayContentProvider;

/**
 * @author glefur
 *
 */
public class ReferencesTableContentProvider extends ArrayContentProvider {

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.viewers.ArrayContentProvider#getElements(java.lang.Object)
	 */
	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof ReferencesTableSettings) {
			return ((ReferencesTableSettings)inputElement).getElements();
		}
		return super.getElements(inputElement);
	}

	
	
}
