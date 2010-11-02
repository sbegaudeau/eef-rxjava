/**
 * 
 */
package org.eclipse.emf.eef.runtime.policies;

import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public interface PropertiesEditingPolicyProvider {
	
	/**
	 * @param context the context to process
	 * @return <code>true</code> if this provider can provide a policy in this context
	 */
	boolean provides(PropertiesEditingContext context);
	
	/**
	 * @param context the context to process
	 * @return the policy to perform
	 */
	PropertiesEditingPolicy getPolicy(PropertiesEditingContext context);
	
}
