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
package org.eclipse.emf.samples.conference.providers;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.samples.conference.parts.ConferenceViewsRepository;
import org.eclipse.emf.samples.conference.parts.forms.ConferencePropertiesEditionPartForm;
import org.eclipse.emf.samples.conference.parts.forms.PersonPropertiesEditionPartForm;
import org.eclipse.emf.samples.conference.parts.forms.PresencePropertiesEditionPartForm;
import org.eclipse.emf.samples.conference.parts.forms.SitePropertiesEditionPartForm;
import org.eclipse.emf.samples.conference.parts.forms.TalkPropertiesEditionPartForm;
import org.eclipse.emf.samples.conference.parts.forms.TopicPropertiesEditionPartForm;
import org.eclipse.emf.samples.conference.parts.impl.ConferencePropertiesEditionPartImpl;
import org.eclipse.emf.samples.conference.parts.impl.PersonPropertiesEditionPartImpl;
import org.eclipse.emf.samples.conference.parts.impl.PresencePropertiesEditionPartImpl;
import org.eclipse.emf.samples.conference.parts.impl.SitePropertiesEditionPartImpl;
import org.eclipse.emf.samples.conference.parts.impl.TalkPropertiesEditionPartImpl;
import org.eclipse.emf.samples.conference.parts.impl.TopicPropertiesEditionPartImpl;

/**
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 * 
 */
public class ConferencePropertiesEditionPartProvider implements IPropertiesEditionPartProvider {

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#provides(java.lang.Class)
	 * 
	 */
	public boolean provides(java.lang.Class key) {
		return key == ConferenceViewsRepository.class;
	}

	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#getPropertiesEditionPart(java.lang.Class, int, org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent)
	 * 
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionComponent component) {
		if (key == ConferenceViewsRepository.Conference.class) {
			if (kind == ConferenceViewsRepository.SWT_KIND)
				return new ConferencePropertiesEditionPartImpl(component);
			if (kind == ConferenceViewsRepository.FORM_KIND)
				return new ConferencePropertiesEditionPartForm(component);
		}
		if (key == ConferenceViewsRepository.Person.class) {
			if (kind == ConferenceViewsRepository.SWT_KIND)
				return new PersonPropertiesEditionPartImpl(component);
			if (kind == ConferenceViewsRepository.FORM_KIND)
				return new PersonPropertiesEditionPartForm(component);
		}
		if (key == ConferenceViewsRepository.Presence.class) {
			if (kind == ConferenceViewsRepository.SWT_KIND)
				return new PresencePropertiesEditionPartImpl(component);
			if (kind == ConferenceViewsRepository.FORM_KIND)
				return new PresencePropertiesEditionPartForm(component);
		}
		if (key == ConferenceViewsRepository.Talk.class) {
			if (kind == ConferenceViewsRepository.SWT_KIND)
				return new TalkPropertiesEditionPartImpl(component);
			if (kind == ConferenceViewsRepository.FORM_KIND)
				return new TalkPropertiesEditionPartForm(component);
		}
		if (key == ConferenceViewsRepository.Topic.class) {
			if (kind == ConferenceViewsRepository.SWT_KIND)
				return new TopicPropertiesEditionPartImpl(component);
			if (kind == ConferenceViewsRepository.FORM_KIND)
				return new TopicPropertiesEditionPartForm(component);
		}
		if (key == ConferenceViewsRepository.Site.class) {
			if (kind == ConferenceViewsRepository.SWT_KIND)
				return new SitePropertiesEditionPartImpl(component);
			if (kind == ConferenceViewsRepository.FORM_KIND)
				return new SitePropertiesEditionPartForm(component);
		}
		return null;
	}

}
