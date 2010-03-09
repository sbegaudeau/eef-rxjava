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

import org.eclipse.emf.eef.runtime.impl.providers.ComposedPropertiesEditionProvider;

/**
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 * 
 */
public class ConferencePackagePropertiesEditionProvider extends ComposedPropertiesEditionProvider {

	/**
	 * Default Constructor
	 * 
	 */
	public ConferencePackagePropertiesEditionProvider() {
		super();
		append(createConferencePropertiesEditionProvider());
		append(createPersonPropertiesEditionProvider());
		append(createTalkPropertiesEditionProvider());
		append(createTopicPropertiesEditionProvider());
		append(createSitePropertiesEditionProvider());
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Conference instances.
	 * 
	 */
	protected ConferencePropertiesEditionProvider conferencePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Conference
	 * 
	 */
	public ConferencePropertiesEditionProvider createConferencePropertiesEditionProvider() {
		if (conferencePropertiesEditionProvider == null)
			conferencePropertiesEditionProvider = new ConferencePropertiesEditionProvider();
		return conferencePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Person instances.
	 * 
	 */
	protected PersonPropertiesEditionProvider personPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Person
	 * 
	 */
	public PersonPropertiesEditionProvider createPersonPropertiesEditionProvider() {
		if (personPropertiesEditionProvider == null)
			personPropertiesEditionProvider = new PersonPropertiesEditionProvider();
		return personPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Talk instances.
	 * 
	 */
	protected TalkPropertiesEditionProvider talkPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Talk
	 * 
	 */
	public TalkPropertiesEditionProvider createTalkPropertiesEditionProvider() {
		if (talkPropertiesEditionProvider == null)
			talkPropertiesEditionProvider = new TalkPropertiesEditionProvider();
		return talkPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Topic instances.
	 * 
	 */
	protected TopicPropertiesEditionProvider topicPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Topic
	 * 
	 */
	public TopicPropertiesEditionProvider createTopicPropertiesEditionProvider() {
		if (topicPropertiesEditionProvider == null)
			topicPropertiesEditionProvider = new TopicPropertiesEditionProvider();
		return topicPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Site instances.
	 * 
	 */
	protected SitePropertiesEditionProvider sitePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Site
	 * 
	 */
	public SitePropertiesEditionProvider createSitePropertiesEditionProvider() {
		if (sitePropertiesEditionProvider == null)
			sitePropertiesEditionProvider = new SitePropertiesEditionProvider();
		return sitePropertiesEditionProvider;
	}

}
