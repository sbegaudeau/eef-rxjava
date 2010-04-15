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
import org.eclipse.emf.eef.eefnr.references.AbstractEnabledSample;
import org.eclipse.emf.eef.eefnr.references.ReferencesPackage;
import org.eclipse.emf.eef.eefnr.references.components.AbstractEnabledSampleBasePropertiesEditionComponent;
import org.eclipse.emf.eef.eefnr.references.components.AbstractEnabledSamplePropertiesEditionComponent;
import org.eclipse.emf.eef.eefnr.references.components.AbstractSamplePropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class AbstractEnabledSamplePropertiesEditionProvider implements IPropertiesEditionProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject)
	 * 
	 */
	public boolean provides(EObject eObject) {
		return (eObject instanceof AbstractEnabledSample) && (ReferencesPackage.eINSTANCE.getAbstractEnabledSample() == eObject.eClass());
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject, java.lang.String)
	 * 
	 */
	public boolean provides(EObject eObject, String part) {
		return (eObject instanceof AbstractEnabledSample) && (AbstractEnabledSampleBasePropertiesEditionComponent.BASE_PART.equals(part) || AbstractSamplePropertiesEditionComponent.BASE_PART.equals(part));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject, java.lang.Class)
	 * 
	 */
	public boolean provides(EObject eObject, java.lang.Class refinement) {
		return (eObject instanceof AbstractEnabledSample) && (refinement == AbstractEnabledSampleBasePropertiesEditionComponent.class || refinement == AbstractSamplePropertiesEditionComponent.class);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject, java.lang.String, java.lang.Class)
	 * 
	 */
	public boolean provides(EObject eObject, String part, java.lang.Class refinement) {
		return (eObject instanceof AbstractEnabledSample) && ((AbstractEnabledSampleBasePropertiesEditionComponent.BASE_PART.equals(part) && refinement == AbstractEnabledSampleBasePropertiesEditionComponent.class) || (AbstractSamplePropertiesEditionComponent.BASE_PART.equals(part) && refinement == AbstractSamplePropertiesEditionComponent.class));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *  java.lang.String)
	 * 
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String editing_mode) {
		if (eObject instanceof AbstractEnabledSample) {
			return new AbstractEnabledSamplePropertiesEditionComponent(eObject, editing_mode);
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
		if (eObject instanceof AbstractEnabledSample) {
			if (AbstractEnabledSampleBasePropertiesEditionComponent.BASE_PART.equals(part))
				return new AbstractEnabledSampleBasePropertiesEditionComponent(eObject, editing_mode);
			if (AbstractSamplePropertiesEditionComponent.BASE_PART.equals(part))
				return new AbstractSamplePropertiesEditionComponent(eObject, editing_mode);
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
		if (eObject instanceof AbstractEnabledSample) {
			if (AbstractEnabledSampleBasePropertiesEditionComponent.BASE_PART.equals(part)
				&& refinement == AbstractEnabledSampleBasePropertiesEditionComponent.class)
				return new AbstractEnabledSampleBasePropertiesEditionComponent(eObject, editing_mode);
			if (AbstractSamplePropertiesEditionComponent.BASE_PART.equals(part)
				&& refinement == AbstractSamplePropertiesEditionComponent.class)
				return new AbstractSamplePropertiesEditionComponent(eObject, editing_mode);
		}
		return null;
	}

}
