/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.providers;

import org.eclipse.emf.eef.runtime.impl.providers.ComposedPropertiesEditionProvider;
import org.eclipse.emf.eef.nonreg.subPackageNonRegForFilters.providers.TestFilterFlatComboPropertiesEditionProvider;
import org.eclipse.emf.eef.nonreg.subPackageNonRegForFilters.providers.TestFilterForReferenceTablesPropertiesEditionProvider;
import org.eclipse.emf.eef.nonreg.subPackageNonRegForFilters.providers.TestFilterForRVPropertiesEditionProvider;
import org.eclipse.emf.eef.nonreg.modelNavigation.providers.SimpleSourcePropertiesEditionProvider;

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
		append(createCompanyPropertiesEditionProvider());
		append(createTestFilterFlatComboPropertiesEditionProvider());
		append(createTestFilterForReferenceTablesPropertiesEditionProvider());
		append(createTestFilterForRVPropertiesEditionProvider());
		append(createSimpleSourcePropertiesEditionProvider());
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
	
	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Company instances.
	 */
	protected CompanyPropertiesEditionProvider companyPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Company
	 */
	public CompanyPropertiesEditionProvider createCompanyPropertiesEditionProvider() {
		if (companyPropertiesEditionProvider == null)
			companyPropertiesEditionProvider = new CompanyPropertiesEditionProvider();
		return companyPropertiesEditionProvider;
	}
	
	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ForFilters instances.
	 */
	protected TestFilterFlatComboPropertiesEditionProvider testFilterFlatComboPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ForFilters
	 */
	public TestFilterFlatComboPropertiesEditionProvider createTestFilterFlatComboPropertiesEditionProvider() {
		if (testFilterFlatComboPropertiesEditionProvider == null)
			testFilterFlatComboPropertiesEditionProvider = new TestFilterFlatComboPropertiesEditionProvider();
		return testFilterFlatComboPropertiesEditionProvider;
	}
	
	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ForFilters instances.
	 */
	protected TestFilterForReferenceTablesPropertiesEditionProvider testFilterForReferenceTablesPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ForFilters
	 */
	public TestFilterForReferenceTablesPropertiesEditionProvider createTestFilterForReferenceTablesPropertiesEditionProvider() {
		if (testFilterForReferenceTablesPropertiesEditionProvider == null)
			testFilterForReferenceTablesPropertiesEditionProvider = new TestFilterForReferenceTablesPropertiesEditionProvider();
		return testFilterForReferenceTablesPropertiesEditionProvider;
	}
	
	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ForFilters instances.
	 */
	protected TestFilterForRVPropertiesEditionProvider testFilterForRVPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ForFilters
	 */
	public TestFilterForRVPropertiesEditionProvider createTestFilterForRVPropertiesEditionProvider() {
		if (testFilterForRVPropertiesEditionProvider == null)
			testFilterForRVPropertiesEditionProvider = new TestFilterForRVPropertiesEditionProvider();
		return testFilterForRVPropertiesEditionProvider;
	}
	
	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Source instances.
	 */
	protected SimpleSourcePropertiesEditionProvider simpleSourcePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Source
	 */
	public SimpleSourcePropertiesEditionProvider createSimpleSourcePropertiesEditionProvider() {
		if (simpleSourcePropertiesEditionProvider == null)
			simpleSourcePropertiesEditionProvider = new SimpleSourcePropertiesEditionProvider();
		return simpleSourcePropertiesEditionProvider;
	}
	
}	
