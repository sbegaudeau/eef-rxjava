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
package org.eclipse.emf.samples.conference.components;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.samples.conference.Conference;
import org.eclipse.emf.samples.conference.parts.ConferenceLocalisationPropertiesEditionPart;
import org.eclipse.emf.samples.conference.parts.ConferencePropertiesEditionPart;
import org.eclipse.emf.samples.conference.parts.ConferenceViewsRepository;


// End of user code

/**
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 * 
 */
public class ConferencePropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The Base part
	 * 
	 */
	private ConferencePropertiesEditionPart basePart;

	/**
	 * The ConferenceBasePropertiesEditionComponent sub component
	 * 
	 */
	protected ConferenceBasePropertiesEditionComponent conferenceBasePropertiesEditionComponent;

	/**
	 * The Conference localisation part
	 * 
	 */
	private ConferenceLocalisationPropertiesEditionPart conferenceLocalisationPart;

	/**
	 * The ConferenceConferenceLocalisationPropertiesEditionComponent sub component
	 * 
	 */
	protected ConferenceConferenceLocalisationPropertiesEditionComponent conferenceConferenceLocalisationPropertiesEditionComponent;
	/**
	 * Parameterized constructor
	 * 
	 * @param conference the EObject to edit
	 * 
	 */
	public ConferencePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject conference, String editing_mode) {
		super(editingContext, editing_mode);
		if (conference instanceof Conference) {
			PropertiesEditingProvider provider = null;
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(conference, PropertiesEditingProvider.class);
			conferenceBasePropertiesEditionComponent = (ConferenceBasePropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, ConferenceBasePropertiesEditionComponent.BASE_PART, ConferenceBasePropertiesEditionComponent.class);
			addSubComponent(conferenceBasePropertiesEditionComponent);
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(conference, PropertiesEditingProvider.class);
			conferenceConferenceLocalisationPropertiesEditionComponent = (ConferenceConferenceLocalisationPropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, ConferenceConferenceLocalisationPropertiesEditionComponent.CONFERENCELOCALISATION_PART, ConferenceConferenceLocalisationPropertiesEditionComponent.class);
			addSubComponent(conferenceConferenceLocalisationPropertiesEditionComponent);
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
		if (ConferenceBasePropertiesEditionComponent.BASE_PART.equals(key)) {
			basePart = (ConferencePropertiesEditionPart)conferenceBasePropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)basePart;
		}
		if (ConferenceConferenceLocalisationPropertiesEditionComponent.CONFERENCELOCALISATION_PART.equals(key)) {
			conferenceLocalisationPart = (ConferenceLocalisationPropertiesEditionPart)conferenceConferenceLocalisationPropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)conferenceLocalisationPart;
		}
		return super.getPropertiesEditionPart(kind, key);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      setPropertiesEditionPart(java.lang.Object, int,
	 *      org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart)
	 * 
	 */
	public void setPropertiesEditionPart(java.lang.Object key, int kind, IPropertiesEditionPart propertiesEditionPart) {
		if (ConferenceViewsRepository.Conference_.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			basePart = (ConferencePropertiesEditionPart)propertiesEditionPart;
		}
		if (ConferenceViewsRepository.ConferenceLocalisation.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			conferenceLocalisationPart = (ConferenceLocalisationPropertiesEditionPart)propertiesEditionPart;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      initPart(java.lang.Object, int, org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(java.lang.Object key, int kind, EObject element, ResourceSet allResource) {
		if (key == ConferenceViewsRepository.Conference_.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == ConferenceViewsRepository.ConferenceLocalisation.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}
