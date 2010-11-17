/**
 * 
 */
package org.eclipse.emf.eef.runtime.ui.widgets.settings;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

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
	
	/**
	 * @param feature to check
	 * @return <code>true</code> if the given feature is processed by these settings
	 */
	boolean isAffectingFeature(EStructuralFeature feature);

	/**
	 * @return the edited object
	 */
	EObject getSource();
}
