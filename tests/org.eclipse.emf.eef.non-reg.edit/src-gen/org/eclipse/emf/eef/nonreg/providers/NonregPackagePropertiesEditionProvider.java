/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.providers;

import org.eclipse.emf.eef.runtime.impl.providers.ComposedPropertiesEditionProvider;

/**
 * 
 */
public class NonregPackagePropertiesEditionProvider extends ComposedPropertiesEditionProvider {

	/**
	 * Default Constructor
	 */
	public NonregPackagePropertiesEditionProvider() {
		super();
		append(createEclipseSummitPropertiesEditionProvider());
		append(createPersonPropertiesEditionProvider());
		append(createTalkPropertiesEditionProvider());
		append(createTopicPropertiesEditionProvider());
		append(createSitePropertiesEditionProvider());
		append(createAccessPropertiesEditionProvider());
	}
	
	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * EclipseSummit instances.
	 */
	protected EclipseSummitPropertiesEditionProvider eclipseSummitPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a EclipseSummit
	 */
	public EclipseSummitPropertiesEditionProvider createEclipseSummitPropertiesEditionProvider() {
		if (eclipseSummitPropertiesEditionProvider == null)
			eclipseSummitPropertiesEditionProvider = new EclipseSummitPropertiesEditionProvider();
		return eclipseSummitPropertiesEditionProvider;
	}
	
	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Person instances.
	 */
	protected PersonPropertiesEditionProvider personPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Person
	 */
	public PersonPropertiesEditionProvider createPersonPropertiesEditionProvider() {
		if (personPropertiesEditionProvider == null)
			personPropertiesEditionProvider = new PersonPropertiesEditionProvider();
		return personPropertiesEditionProvider;
	}
	
	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Talk instances.
	 */
	protected TalkPropertiesEditionProvider talkPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Talk
	 */
	public TalkPropertiesEditionProvider createTalkPropertiesEditionProvider() {
		if (talkPropertiesEditionProvider == null)
			talkPropertiesEditionProvider = new TalkPropertiesEditionProvider();
		return talkPropertiesEditionProvider;
	}
	
	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Topic instances.
	 */
	protected TopicPropertiesEditionProvider topicPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Topic
	 */
	public TopicPropertiesEditionProvider createTopicPropertiesEditionProvider() {
		if (topicPropertiesEditionProvider == null)
			topicPropertiesEditionProvider = new TopicPropertiesEditionProvider();
		return topicPropertiesEditionProvider;
	}
	
	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Site instances.
	 */
	protected SitePropertiesEditionProvider sitePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Site
	 */
	public SitePropertiesEditionProvider createSitePropertiesEditionProvider() {
		if (sitePropertiesEditionProvider == null)
			sitePropertiesEditionProvider = new SitePropertiesEditionProvider();
		return sitePropertiesEditionProvider;
	}
	
	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Access instances.
	 */
	protected AccessPropertiesEditionProvider accessPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Access
	 */
	public AccessPropertiesEditionProvider createAccessPropertiesEditionProvider() {
		if (accessPropertiesEditionProvider == null)
			accessPropertiesEditionProvider = new AccessPropertiesEditionProvider();
		return accessPropertiesEditionProvider;
	}
	
}	
