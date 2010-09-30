/**
 * 
 */
package org.eclipse.emf.eef.runtime.ui.widgets.referencestable;

import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class ReferencesTableContentProvider extends AdapterFactoryContentProvider {
	
	public static final int CURRENT_VALUES_KIND = 0;
	public static final int MATCHING_VALUES_KIND = 1;
	
	public int kind = CURRENT_VALUES_KIND;

	/**
	 * @param adapterFactory the adapterFactory to use
	 */
	public ReferencesTableContentProvider() {
		super(EEFRuntimePlugin.getDefault().getAdapterFactory());
	}
	
	/**
	 * @param adapterFactory the adapterFactory to use
	 */
	public ReferencesTableContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.jface.viewers.ArrayContentProvider#getElements(java.lang.Object)
	 */
	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof ReferencesTableSettings) {
			if (kind == CURRENT_VALUES_KIND)
				return ((ReferencesTableSettings)inputElement).getElements();
			else if (kind == MATCHING_VALUES_KIND) {
				Object choiceOfValues = ((ReferencesTableSettings)inputElement).choiceOfValues(adapterFactory);
				return choiceOfValues instanceof List?((List)choiceOfValues).toArray():new Object[] { choiceOfValues};
			}
		}
		return super.getElements(inputElement);
	}
	
}
