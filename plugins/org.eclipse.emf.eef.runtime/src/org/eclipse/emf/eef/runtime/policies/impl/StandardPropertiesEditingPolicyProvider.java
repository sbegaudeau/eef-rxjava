/**
 * 
 */
package org.eclipse.emf.eef.runtime.policies.impl;

import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.policies.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.policies.EReferencePropertiesEditionContext;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicyProvider;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public abstract class StandardPropertiesEditingPolicyProvider implements PropertiesEditingPolicyProvider {

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicyProvider#getPolicy(org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionContext)
	 */
	@Override
	public PropertiesEditingPolicy getPolicy(IPropertiesEditionContext context) {
		if (context instanceof EObjectPropertiesEditionContext) {
			return new StandardEditingPolicy((EObjectPropertiesEditionContext) context);
		}
		if (context instanceof EReferencePropertiesEditionContext) {
			return new CreateEditingPolicy((EReferencePropertiesEditionContext) context);
		}
		return null;
	}

}
