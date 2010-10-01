/**
 *  Copyright (c) 2008 - 2010 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Obeo - initial API and implementation
 *
 */
package org.eclipse.emf.eef.mapping.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.mapping.components.DocumentedElementPropertiesEditionComponent;
import org.eclipse.emf.eef.mapping.components.FilterPropertiesPropertiesEditionComponent;
import org.eclipse.emf.eef.mapping.components.JavaExpressionFilterBasePropertiesEditionComponent;
import org.eclipse.emf.eef.mapping.components.JavaExpressionFilterPropertiesEditionComponent;
import org.eclipse.emf.eef.mapping.filters.FiltersPackage;
import org.eclipse.emf.eef.mapping.filters.JavaExpressionFilter;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class JavaExpressionFilterPropertiesEditionProvider implements IPropertiesEditionProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject)
	 * 
	 */
	public boolean provides(EObject eObject) {
		return (eObject instanceof JavaExpressionFilter) && (FiltersPackage.eINSTANCE.getJavaExpressionFilter() == eObject.eClass());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject, java.lang.String)
	 * 
	 */
	public boolean provides(EObject eObject, String part) {
		return (eObject instanceof JavaExpressionFilter) && (JavaExpressionFilterBasePropertiesEditionComponent.BASE_PART.equals(part) || DocumentedElementPropertiesEditionComponent.DOCUMENTATION_PART.equals(part) || FilterPropertiesPropertiesEditionComponent.FILTERPROPERTIES_PART.equals(part));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject, java.lang.Class)
	 * 
	 */
	public boolean provides(EObject eObject, java.lang.Class refinement) {
		return (eObject instanceof JavaExpressionFilter) && (refinement == JavaExpressionFilterBasePropertiesEditionComponent.class || refinement == DocumentedElementPropertiesEditionComponent.class || refinement == FilterPropertiesPropertiesEditionComponent.class);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject, java.lang.String, java.lang.Class)
	 * 
	 */
	public boolean provides(EObject eObject, String part, java.lang.Class refinement) {
		return (eObject instanceof JavaExpressionFilter) && ((JavaExpressionFilterBasePropertiesEditionComponent.BASE_PART.equals(part) && refinement == JavaExpressionFilterBasePropertiesEditionComponent.class) || (DocumentedElementPropertiesEditionComponent.DOCUMENTATION_PART.equals(part) && refinement == DocumentedElementPropertiesEditionComponent.class) || (FilterPropertiesPropertiesEditionComponent.FILTERPROPERTIES_PART.equals(part) && refinement == FilterPropertiesPropertiesEditionComponent.class));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *  java.lang.String)
	 * 
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String editing_mode) {
		if (eObject instanceof JavaExpressionFilter) {
			return new JavaExpressionFilterPropertiesEditionComponent(eObject, editing_mode);
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
		if (eObject instanceof JavaExpressionFilter) {
			if (JavaExpressionFilterBasePropertiesEditionComponent.BASE_PART.equals(part))
				return new JavaExpressionFilterBasePropertiesEditionComponent(eObject, editing_mode);
			if (DocumentedElementPropertiesEditionComponent.DOCUMENTATION_PART.equals(part))
				return new DocumentedElementPropertiesEditionComponent(eObject, editing_mode);
			if (FilterPropertiesPropertiesEditionComponent.FILTERPROPERTIES_PART.equals(part))
				return new FilterPropertiesPropertiesEditionComponent(eObject, editing_mode);
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
		if (eObject instanceof JavaExpressionFilter) {
			if (JavaExpressionFilterBasePropertiesEditionComponent.BASE_PART.equals(part)
				&& refinement == JavaExpressionFilterBasePropertiesEditionComponent.class)
				return new JavaExpressionFilterBasePropertiesEditionComponent(eObject, editing_mode);
			if (DocumentedElementPropertiesEditionComponent.DOCUMENTATION_PART.equals(part)
				&& refinement == DocumentedElementPropertiesEditionComponent.class)
				return new DocumentedElementPropertiesEditionComponent(eObject, editing_mode);
			if (FilterPropertiesPropertiesEditionComponent.FILTERPROPERTIES_PART.equals(part)
				&& refinement == FilterPropertiesPropertiesEditionComponent.class)
				return new FilterPropertiesPropertiesEditionComponent(eObject, editing_mode);
		}
		return null;
	}

}
