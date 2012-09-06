/**
 * 
 */
package org.eclipse.emf.eef.runtime.ui.widgets.settings;

import org.eclipse.emf.ecore.EObject;


public abstract class EEFFilter {
	
	protected abstract boolean select(EObject semanticObject);
}
