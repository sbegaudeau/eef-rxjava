/**
 * 
 */
package org.eclipse.emf.eef.runtime.ui.widgets.settings;

import org.eclipse.emf.common.notify.AdapterFactory;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public interface EEFEditorSettings {
	
	/**
	 * @return the current value(s) of edited feature
	 */
	Object getValue();

	/**
	 * @param adapterFactory adapterFactory to use
	 * @return the possible value for the edited features
	 */
	Object choiceOfValues(AdapterFactory adapterFactory);
	
}
