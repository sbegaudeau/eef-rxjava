/*******************************************************************************
 * Copyright (c) 2009 - 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.references.providers;

import org.eclipse.emf.eef.eefnr.references.ReferenceEnabledSample;
import org.eclipse.emf.eef.eefnr.references.ReferencesPackage;
import org.eclipse.emf.eef.references.components.AbstractSamplePropertiesEditionComponent;
import org.eclipse.emf.eef.references.components.ReferenceEnabledSampleBasePropertiesEditionComponent;
import org.eclipse.emf.eef.references.components.ReferenceEnabledSamplePropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.providers.impl.PropertiesEditingProviderImpl;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class ReferenceEnabledSamplePropertiesEditionProvider extends PropertiesEditingProviderImpl {

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#provides(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext)
	 * 
	 */
	public boolean provides(PropertiesEditingContext editingContext) {
		return (editingContext.getEObject() instanceof ReferenceEnabledSample) 
					&& (ReferencesPackage.eINSTANCE.getReferenceEnabledSample() == editingContext.getEObject().eClass());
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#provides(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext, java.lang.String)
	 * 
	 */
	public boolean provides(PropertiesEditingContext editingContext, String part) {
		return (editingContext.getEObject() instanceof ReferenceEnabledSample) && (ReferenceEnabledSampleBasePropertiesEditionComponent.BASE_PART.equals(part) || AbstractSamplePropertiesEditionComponent.BASE_PART.equals(part));
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#provides(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext, java.lang.Class)
	 * 
	 */
	public boolean provides(PropertiesEditingContext editingContext, Class refinement) {
		return (editingContext.getEObject() instanceof ReferenceEnabledSample) && (refinement == ReferenceEnabledSampleBasePropertiesEditionComponent.class || refinement == AbstractSamplePropertiesEditionComponent.class);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#provides(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext, java.lang.String, java.lang.Class)
	 * 
	 */
	public boolean provides(PropertiesEditingContext editingContext, String part, Class refinement) {
		return (editingContext.getEObject() instanceof ReferenceEnabledSample) && ((ReferenceEnabledSampleBasePropertiesEditionComponent.BASE_PART.equals(part) && refinement == ReferenceEnabledSampleBasePropertiesEditionComponent.class) || (AbstractSamplePropertiesEditionComponent.BASE_PART.equals(part) && refinement == AbstractSamplePropertiesEditionComponent.class));
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#getPropertiesEditingComponent(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext, java.lang.String)
	 * 
	 */
	public IPropertiesEditionComponent getPropertiesEditingComponent(PropertiesEditingContext editingContext, String mode) {
		if (editingContext.getEObject() instanceof ReferenceEnabledSample) {
			return new ReferenceEnabledSamplePropertiesEditionComponent(editingContext, editingContext.getEObject(), mode);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#getPropertiesEditingComponent(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext, java.lang.String, java.lang.String)
	 * 
	 */
	public IPropertiesEditionComponent getPropertiesEditingComponent(PropertiesEditingContext editingContext, String mode, String part) {
		if (editingContext.getEObject() instanceof ReferenceEnabledSample) {
			if (ReferenceEnabledSampleBasePropertiesEditionComponent.BASE_PART.equals(part))
				return new ReferenceEnabledSampleBasePropertiesEditionComponent(editingContext, editingContext.getEObject(), mode);
			if (AbstractSamplePropertiesEditionComponent.BASE_PART.equals(part))
				return new AbstractSamplePropertiesEditionComponent(editingContext, editingContext.getEObject(), mode);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider#getPropertiesEditingComponent(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext, java.lang.String, java.lang.String, java.lang.Class)
	 */
	public IPropertiesEditionComponent getPropertiesEditingComponent(PropertiesEditingContext editingContext, String mode, String part, Class refinement) {
		if (editingContext.getEObject() instanceof ReferenceEnabledSample) {
			if (ReferenceEnabledSampleBasePropertiesEditionComponent.BASE_PART.equals(part)
				&& refinement == ReferenceEnabledSampleBasePropertiesEditionComponent.class)
				return new ReferenceEnabledSampleBasePropertiesEditionComponent(editingContext, editingContext.getEObject(), mode);
			if (AbstractSamplePropertiesEditionComponent.BASE_PART.equals(part)
				&& refinement == AbstractSamplePropertiesEditionComponent.class)
				return new AbstractSamplePropertiesEditionComponent(editingContext, editingContext.getEObject(), mode);
		}
		return null;
	}

}
