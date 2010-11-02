/**
 * 
 */
package org.eclipse.emf.eef.runtime.policies.impl;

import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicyProvider;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public abstract class StandardPropertiesEditingPolicyProvider implements PropertiesEditingPolicyProvider {

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicyProvider#getPolicy(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext)
	 */
	public PropertiesEditingPolicy getPolicy(PropertiesEditingContext context) {
		if (context instanceof EReferencePropertiesEditionContext) {
			return new CreateEditingPolicy((EReferencePropertiesEditionContext) context);
		}
		if (context instanceof EObjectPropertiesEditionContext) {
			return new StandardEditingPolicy((EObjectPropertiesEditionContext) context);
		}
		return null;
	}

}
