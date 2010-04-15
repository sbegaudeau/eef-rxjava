/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.eefnr.references.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.eefnr.references.ReferenceEnabledSample;
import org.eclipse.emf.eef.eefnr.references.ReferencesPackage;
import org.eclipse.emf.eef.eefnr.references.components.AbstractEnabledSampleBasePropertiesEditionComponent;
import org.eclipse.emf.eef.eefnr.references.components.AbstractEnabledSamplePropertiesEditionComponent;
import org.eclipse.emf.eef.eefnr.references.components.ReferenceEnabledSampleBasePropertiesEditionComponent;
import org.eclipse.emf.eef.eefnr.references.components.ReferenceEnabledSamplePropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class ReferenceEnabledSamplePropertiesEditionProvider implements IPropertiesEditionProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject)
	 * 
	 */
	public boolean provides(EObject eObject) {
		return (eObject instanceof ReferenceEnabledSample) && (ReferencesPackage.eINSTANCE.getReferenceEnabledSample() == eObject.eClass());
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject, java.lang.String)
	 * 
	 */
	public boolean provides(EObject eObject, String part) {
		return (eObject instanceof ReferenceEnabledSample) && (ReferenceEnabledSampleBasePropertiesEditionComponent.BASE_PART.equals(part) || AbstractEnabledSampleBasePropertiesEditionComponent.BASE_PART.equals(part));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject, java.lang.Class)
	 * 
	 */
	public boolean provides(EObject eObject, java.lang.Class refinement) {
		return (eObject instanceof ReferenceEnabledSample) && (refinement == ReferenceEnabledSampleBasePropertiesEditionComponent.class || refinement == AbstractEnabledSamplePropertiesEditionComponent.class);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject, java.lang.String, java.lang.Class)
	 * 
	 */
	public boolean provides(EObject eObject, String part, java.lang.Class refinement) {
		return (eObject instanceof ReferenceEnabledSample) && ((ReferenceEnabledSampleBasePropertiesEditionComponent.BASE_PART.equals(part) && refinement == ReferenceEnabledSampleBasePropertiesEditionComponent.class) || (AbstractEnabledSampleBasePropertiesEditionComponent.BASE_PART.equals(part) && refinement == AbstractEnabledSamplePropertiesEditionComponent.class));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *  java.lang.String)
	 * 
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String editing_mode) {
		if (eObject instanceof ReferenceEnabledSample) {
			return new ReferenceEnabledSamplePropertiesEditionComponent(eObject, editing_mode);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *  java.lang.String, java.lang.String)
	 * 
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String editing_mode, String part) {
		if (eObject instanceof ReferenceEnabledSample) {
			if (ReferenceEnabledSampleBasePropertiesEditionComponent.BASE_PART.equals(part))
				return new ReferenceEnabledSampleBasePropertiesEditionComponent(eObject, editing_mode);
			if (AbstractEnabledSampleBasePropertiesEditionComponent.BASE_PART.equals(part))
				return new AbstractEnabledSamplePropertiesEditionComponent(eObject, editing_mode);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *  java.lang.String, java.lang.String, java.lang.Class)
	 * 
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String editing_mode, String part, java.lang.Class refinement) {
		if (eObject instanceof ReferenceEnabledSample) {
			if (ReferenceEnabledSampleBasePropertiesEditionComponent.BASE_PART.equals(part)
				&& refinement == ReferenceEnabledSampleBasePropertiesEditionComponent.class)
				return new ReferenceEnabledSampleBasePropertiesEditionComponent(eObject, editing_mode);
			if (AbstractEnabledSampleBasePropertiesEditionComponent.BASE_PART.equals(part)
				&& refinement == AbstractEnabledSamplePropertiesEditionComponent.class)
				return new AbstractEnabledSamplePropertiesEditionComponent(eObject, editing_mode);
		}
		return null;
	}

}
