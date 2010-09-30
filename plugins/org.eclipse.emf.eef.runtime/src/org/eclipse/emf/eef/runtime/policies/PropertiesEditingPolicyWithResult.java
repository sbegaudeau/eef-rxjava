/**
 * 
 */
package org.eclipse.emf.eef.runtime.policies;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public interface PropertiesEditingPolicyWithResult extends PropertiesEditingPolicy {
	
	/**
	 * @return the result of the policy execution
	 */
	Object getResult();

}
