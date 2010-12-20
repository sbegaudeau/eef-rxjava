/**
 * 
 */
package org.eclipse.emf.eef.codegen.ui.generators.callback;

import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public interface EEFGenerationCallback {

	/**
	 * Execute the callback.
	 * @param target list of directory where EEF generates code.
	 * @param monitor Eclipse ProgressMonitor
	 */
	void execute(Set<IContainer> target, IProgressMonitor monitor);
	
}
