/**
 * 
 */
package org.eclipse.emf.eef.cdo.runtime.provider;

import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;
import org.eclipse.emf.eef.runtime.policies.impl.StandardEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.impl.PropertiesEditingProviderImpl;

/**
 * @author glefur
 *
 */
public abstract class CDOAwarePropertiesEditingProvider extends PropertiesEditingProviderImpl {
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.eef.runtime.providers.impl.PropertiesEditingProviderImpl#getPolicy(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext)
	 */
	public PropertiesEditingPolicy getPolicy(PropertiesEditingContext context) {
		if (context instanceof EReferencePropertiesEditionContext) {
			if (monDomain instanceof CDODomain)
			return new CreateEditingPolicy((EReferencePropertiesEditionContext)context);
		}
		if (context instanceof EObjectPropertiesEditionContext) {
			return new StandardEditingPolicy((PropertiesEditingContext)context);
		}
		return null;
	}

}
