/**
 * 
 */
package org.eclipse.emf.eef.runtime.ui.widgets.settings;

import org.eclipse.emf.ecore.EObject;

/**
 * @author NLEPINE
 *
 */
public abstract class EEFInitializer {
		
	protected abstract EObject init(EObject semanticObject);
}