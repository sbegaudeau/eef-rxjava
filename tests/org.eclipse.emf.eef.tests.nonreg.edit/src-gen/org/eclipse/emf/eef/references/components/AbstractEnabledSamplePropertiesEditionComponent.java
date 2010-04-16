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
package org.eclipse.emf.eef.references.components;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.eefnr.references.AbstractEnabledSample;
import org.eclipse.emf.eef.eefnr.references.parts.AbstractEnabledSamplePropertiesEditionPart;
import org.eclipse.emf.eef.eefnr.references.parts.ReferencesViewsRepository;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionComponentService;


// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class AbstractEnabledSamplePropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The Base part
	 * 
	 */
	private AbstractEnabledSamplePropertiesEditionPart basePart;

	/**
	 * The AbstractEnabledSampleBasePropertiesEditionComponent sub component
	 * 
	 */
	protected AbstractEnabledSampleBasePropertiesEditionComponent abstractEnabledSampleBasePropertiesEditionComponent;
	/**
	 * The AbstractSamplePropertiesEditionComponent sub component
	 * 
	 */
	protected AbstractSamplePropertiesEditionComponent abstractSamplePropertiesEditionComponent;

	/**
	 * Parameterized constructor
	 * 
	 * @param abstractEnabledSample the EObject to edit
	 * 
	 */
	public AbstractEnabledSamplePropertiesEditionComponent(EObject abstractEnabledSample, String editing_mode) {
		super(editing_mode);
		if (abstractEnabledSample instanceof AbstractEnabledSample) {
			IPropertiesEditionProvider provider = null;
			provider = PropertiesEditionComponentService.getInstance().getProvider(abstractEnabledSample, AbstractEnabledSampleBasePropertiesEditionComponent.class);
			abstractEnabledSampleBasePropertiesEditionComponent = (AbstractEnabledSampleBasePropertiesEditionComponent)provider.getPropertiesEditionComponent(abstractEnabledSample, editing_mode, AbstractEnabledSampleBasePropertiesEditionComponent.BASE_PART, AbstractEnabledSampleBasePropertiesEditionComponent.class);
			addSubComponent(abstractEnabledSampleBasePropertiesEditionComponent);
			provider = PropertiesEditionComponentService.getInstance().getProvider(abstractEnabledSample, AbstractSamplePropertiesEditionComponent.class);
			abstractSamplePropertiesEditionComponent = (AbstractSamplePropertiesEditionComponent)provider.getPropertiesEditionComponent(abstractEnabledSample, editing_mode, AbstractSamplePropertiesEditionComponent.BASE_PART, AbstractSamplePropertiesEditionComponent.class);
			addSubComponent(abstractSamplePropertiesEditionComponent);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      getPropertiesEditionPart(int, java.lang.String)
	 * 
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (AbstractEnabledSampleBasePropertiesEditionComponent.BASE_PART.equals(key)) {
			basePart = (AbstractEnabledSamplePropertiesEditionPart)abstractEnabledSampleBasePropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)basePart;
		}
		return super.getPropertiesEditionPart(kind, key);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      setPropertiesEditionPart(java.lang.Class, int,
	 *      org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart)
	 * 
	 */
	public void setPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionPart propertiesEditionPart) {
		if (ReferencesViewsRepository.AbstractEnabledSample.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			basePart = (AbstractEnabledSamplePropertiesEditionPart)propertiesEditionPart;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(java.lang.Class key, int kind, EObject element, ResourceSet allResource) {
		if (key == ReferencesViewsRepository.AbstractEnabledSample.class) {
			super.initPart(key, kind, element, allResource);
			abstractSamplePropertiesEditionComponent.setPropertiesEditionPart(ReferencesViewsRepository.AbstractSample.class, kind, basePart.getAbstractSampleReferencedView());
			abstractSamplePropertiesEditionComponent.initPart(ReferencesViewsRepository.AbstractSample.class, kind, element, allResource);
		}
		if (key == ReferencesViewsRepository.AbstractSample.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}
