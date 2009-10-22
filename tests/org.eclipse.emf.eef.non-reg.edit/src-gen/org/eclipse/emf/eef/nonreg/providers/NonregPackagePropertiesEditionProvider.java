/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.providers;

import org.eclipse.emf.eef.nonreg.modelNavigation.providers.CiblePropertiesEditionProvider;
import org.eclipse.emf.eef.nonreg.modelNavigation.providers.SimpleSourcePropertiesEditionProvider;
import org.eclipse.emf.eef.nonreg.subPackageNonRegForFilters.providers.TestFilterFlatComboPropertiesEditionProvider;
import org.eclipse.emf.eef.nonreg.subPackageNonRegForFilters.providers.TestFilterForRVPropertiesEditionProvider;
import org.eclipse.emf.eef.nonreg.subPackageNonRegForFilters.providers.TestFilterForReferenceTablesPropertiesEditionProvider;
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
		append(createCompanyPropertiesEditionProvider());
		append(createAdressPropertiesEditionProvider());
		append(createAccreditationsPropertiesEditionProvider());
		append(createTestFilterFlatComboPropertiesEditionProvider());
		append(createTestFilterForReferenceTablesPropertiesEditionProvider());
		append(createTestFilterForRVPropertiesEditionProvider());
		append(createSimpleSourcePropertiesEditionProvider());
		append(createCiblePropertiesEditionProvider());
		append(createTextPropertiesEditionProvider());
		append(createTextAreaPropertiesEditionProvider());
		append(createCheckboxPropertiesEditionProvider());
		append(createRadioPropertiesEditionProvider());
		append(createComboPropertiesEditionProvider());
		append(createEObjectFlatComboViewerPropertiesEditionProvider());
		append(createReferencesTablePropertiesEditionProvider());
		append(createEMFComboViewerPropertiesEditionProvider());
		append(createMultiValuedEditorPropertiesEditionProvider());
		append(createTableCompositionPropertiesEditionProvider());
		append(createAdvancedTableCompositionPropertiesEditionProvider());
		append(createAdvancedReferencesTablePropertiesEditionProvider());
		append(createAdvancedEObjectFlatComboViewerPropertiesEditionProvider());
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
	 * Adress instances.
	 */
	protected AdressPropertiesEditionProvider adressPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Adress
	 */
	public AdressPropertiesEditionProvider createAdressPropertiesEditionProvider() {
		if (adressPropertiesEditionProvider == null)
			adressPropertiesEditionProvider = new AdressPropertiesEditionProvider();
		return adressPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Person instances.
	 */
	protected AccreditationsPropertiesEditionProvider accreditationsPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Person
	 */
	public AccreditationsPropertiesEditionProvider createAccreditationsPropertiesEditionProvider() {
		if (accreditationsPropertiesEditionProvider == null)
			accreditationsPropertiesEditionProvider = new AccreditationsPropertiesEditionProvider();
		return accreditationsPropertiesEditionProvider;
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

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ConcreteCible instances.
	 */
	protected CiblePropertiesEditionProvider ciblePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ConcreteCible
	 */
	public CiblePropertiesEditionProvider createCiblePropertiesEditionProvider() {
		if (ciblePropertiesEditionProvider == null)
			ciblePropertiesEditionProvider = new CiblePropertiesEditionProvider();
		return ciblePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Adress instances.
	 */
	protected TextPropertiesEditionProvider textPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Adress
	 */
	public TextPropertiesEditionProvider createTextPropertiesEditionProvider() {
		if (textPropertiesEditionProvider == null)
			textPropertiesEditionProvider = new TextPropertiesEditionProvider();
		return textPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Person instances.
	 */
	protected TextAreaPropertiesEditionProvider textAreaPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Person
	 */
	public TextAreaPropertiesEditionProvider createTextAreaPropertiesEditionProvider() {
		if (textAreaPropertiesEditionProvider == null)
			textAreaPropertiesEditionProvider = new TextAreaPropertiesEditionProvider();
		return textAreaPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Person instances.
	 */
	protected CheckboxPropertiesEditionProvider checkboxPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Person
	 */
	public CheckboxPropertiesEditionProvider createCheckboxPropertiesEditionProvider() {
		if (checkboxPropertiesEditionProvider == null)
			checkboxPropertiesEditionProvider = new CheckboxPropertiesEditionProvider();
		return checkboxPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Person instances.
	 */
	protected RadioPropertiesEditionProvider radioPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Person
	 */
	public RadioPropertiesEditionProvider createRadioPropertiesEditionProvider() {
		if (radioPropertiesEditionProvider == null)
			radioPropertiesEditionProvider = new RadioPropertiesEditionProvider();
		return radioPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Talk instances.
	 */
	protected ComboPropertiesEditionProvider comboPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Talk
	 */
	public ComboPropertiesEditionProvider createComboPropertiesEditionProvider() {
		if (comboPropertiesEditionProvider == null)
			comboPropertiesEditionProvider = new ComboPropertiesEditionProvider();
		return comboPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Person instances.
	 */
	protected EObjectFlatComboViewerPropertiesEditionProvider eObjectFlatComboViewerPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Person
	 */
	public EObjectFlatComboViewerPropertiesEditionProvider createEObjectFlatComboViewerPropertiesEditionProvider() {
		if (eObjectFlatComboViewerPropertiesEditionProvider == null)
			eObjectFlatComboViewerPropertiesEditionProvider = new EObjectFlatComboViewerPropertiesEditionProvider();
		return eObjectFlatComboViewerPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Person instances.
	 */
	protected ReferencesTablePropertiesEditionProvider referencesTablePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Person
	 */
	public ReferencesTablePropertiesEditionProvider createReferencesTablePropertiesEditionProvider() {
		if (referencesTablePropertiesEditionProvider == null)
			referencesTablePropertiesEditionProvider = new ReferencesTablePropertiesEditionProvider();
		return referencesTablePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Talk instances.
	 */
	protected EMFComboViewerPropertiesEditionProvider eMFComboViewerPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Talk
	 */
	public EMFComboViewerPropertiesEditionProvider createEMFComboViewerPropertiesEditionProvider() {
		if (eMFComboViewerPropertiesEditionProvider == null)
			eMFComboViewerPropertiesEditionProvider = new EMFComboViewerPropertiesEditionProvider();
		return eMFComboViewerPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Person instances.
	 */
	protected MultiValuedEditorPropertiesEditionProvider multiValuedEditorPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Person
	 */
	public MultiValuedEditorPropertiesEditionProvider createMultiValuedEditorPropertiesEditionProvider() {
		if (multiValuedEditorPropertiesEditionProvider == null)
			multiValuedEditorPropertiesEditionProvider = new MultiValuedEditorPropertiesEditionProvider();
		return multiValuedEditorPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * EclipseSummit instances.
	 */
	protected TableCompositionPropertiesEditionProvider tableCompositionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a EclipseSummit
	 */
	public TableCompositionPropertiesEditionProvider createTableCompositionPropertiesEditionProvider() {
		if (tableCompositionPropertiesEditionProvider == null)
			tableCompositionPropertiesEditionProvider = new TableCompositionPropertiesEditionProvider();
		return tableCompositionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * EclipseSummit instances.
	 */
	protected AdvancedTableCompositionPropertiesEditionProvider advancedTableCompositionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a EclipseSummit
	 */
	public AdvancedTableCompositionPropertiesEditionProvider createAdvancedTableCompositionPropertiesEditionProvider() {
		if (advancedTableCompositionPropertiesEditionProvider == null)
			advancedTableCompositionPropertiesEditionProvider = new AdvancedTableCompositionPropertiesEditionProvider();
		return advancedTableCompositionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Person instances.
	 */
	protected AdvancedReferencesTablePropertiesEditionProvider advancedReferencesTablePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Person
	 */
	public AdvancedReferencesTablePropertiesEditionProvider createAdvancedReferencesTablePropertiesEditionProvider() {
		if (advancedReferencesTablePropertiesEditionProvider == null)
			advancedReferencesTablePropertiesEditionProvider = new AdvancedReferencesTablePropertiesEditionProvider();
		return advancedReferencesTablePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Person instances.
	 */
	protected AdvancedEObjectFlatComboViewerPropertiesEditionProvider advancedEObjectFlatComboViewerPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Person
	 */
	public AdvancedEObjectFlatComboViewerPropertiesEditionProvider createAdvancedEObjectFlatComboViewerPropertiesEditionProvider() {
		if (advancedEObjectFlatComboViewerPropertiesEditionProvider == null)
			advancedEObjectFlatComboViewerPropertiesEditionProvider = new AdvancedEObjectFlatComboViewerPropertiesEditionProvider();
		return advancedEObjectFlatComboViewerPropertiesEditionProvider;
	}

}
