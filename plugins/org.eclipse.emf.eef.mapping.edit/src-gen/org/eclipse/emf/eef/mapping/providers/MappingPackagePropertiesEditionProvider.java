/**
 *  Copyright (c) 2008-2009 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Obeo - initial API and implementation
 * 
 *
 * $Id: MappingPackagePropertiesEditionProvider.java,v 1.14 2009/12/23 15:59:52 nlepine Exp $
 */
package org.eclipse.emf.eef.mapping.providers;

import org.eclipse.emf.eef.runtime.impl.providers.ComposedPropertiesEditionProvider;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class MappingPackagePropertiesEditionProvider extends ComposedPropertiesEditionProvider {

	/**
	 * Default Constructor
	 */
	public MappingPackagePropertiesEditionProvider() {
		super();
		append(createDocumentedElementPropertiesEditionProvider());
		append(createFilterPropertiesPropertiesEditionProvider());
		append(createDatabindingPropertiesEditionProvider());
		append(createEMFElementBindingPropertiesEditionProvider());
		append(createEMFPropertyBindingPropertiesEditionProvider());
		append(createStandardElementBindingPropertiesEditionProvider());
		append(createStandardPropertyBindingPropertiesEditionProvider());
		append(createCategoryPropertiesEditionProvider());
		append(createElementBindingReferencePropertiesEditionProvider());
		append(createEMFMultiPropertiesBindingPropertiesEditionProvider());
		append(createSimpleModelNavigationPropertiesEditionProvider());
		append(createOnlyReferenceTypeFilterPropertiesEditionProvider());
		append(createOCLFilterPropertiesEditionProvider());
		append(createJavaExpressionFilterPropertiesEditionProvider());
		append(createJavaDeclarationFilterPropertiesEditionProvider());
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * DocumentedElement instances.
	 */
	protected DocumentedElementPropertiesEditionProvider documentedElementPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a DocumentedElement
	 */
	public DocumentedElementPropertiesEditionProvider createDocumentedElementPropertiesEditionProvider() {
		if (documentedElementPropertiesEditionProvider == null)
			documentedElementPropertiesEditionProvider = new DocumentedElementPropertiesEditionProvider();
		return documentedElementPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * BindingFilter instances.
	 */
	protected FilterPropertiesPropertiesEditionProvider filterPropertiesPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a BindingFilter
	 */
	public FilterPropertiesPropertiesEditionProvider createFilterPropertiesPropertiesEditionProvider() {
		if (filterPropertiesPropertiesEditionProvider == null)
			filterPropertiesPropertiesEditionProvider = new FilterPropertiesPropertiesEditionProvider();
		return filterPropertiesPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Databinding instances.
	 */
	protected DatabindingPropertiesEditionProvider databindingPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Databinding
	 */
	public DatabindingPropertiesEditionProvider createDatabindingPropertiesEditionProvider() {
		if (databindingPropertiesEditionProvider == null)
			databindingPropertiesEditionProvider = new DatabindingPropertiesEditionProvider();
		return databindingPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * EMFElementBinding instances.
	 */
	protected EMFElementBindingPropertiesEditionProvider eMFElementBindingPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a EMFElementBinding
	 */
	public EMFElementBindingPropertiesEditionProvider createEMFElementBindingPropertiesEditionProvider() {
		if (eMFElementBindingPropertiesEditionProvider == null)
			eMFElementBindingPropertiesEditionProvider = new EMFElementBindingPropertiesEditionProvider();
		return eMFElementBindingPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * EMFPropertyBinding instances.
	 */
	protected EMFPropertyBindingPropertiesEditionProvider eMFPropertyBindingPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a EMFPropertyBinding
	 */
	public EMFPropertyBindingPropertiesEditionProvider createEMFPropertyBindingPropertiesEditionProvider() {
		if (eMFPropertyBindingPropertiesEditionProvider == null)
			eMFPropertyBindingPropertiesEditionProvider = new EMFPropertyBindingPropertiesEditionProvider();
		return eMFPropertyBindingPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * StandardElementBinding instances.
	 */
	protected StandardElementBindingPropertiesEditionProvider standardElementBindingPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a StandardElementBinding
	 */
	public StandardElementBindingPropertiesEditionProvider createStandardElementBindingPropertiesEditionProvider() {
		if (standardElementBindingPropertiesEditionProvider == null)
			standardElementBindingPropertiesEditionProvider = new StandardElementBindingPropertiesEditionProvider();
		return standardElementBindingPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * StandardPropertyBinding instances.
	 */
	protected StandardPropertyBindingPropertiesEditionProvider standardPropertyBindingPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a StandardPropertyBinding
	 */
	public StandardPropertyBindingPropertiesEditionProvider createStandardPropertyBindingPropertiesEditionProvider() {
		if (standardPropertyBindingPropertiesEditionProvider == null)
			standardPropertyBindingPropertiesEditionProvider = new StandardPropertyBindingPropertiesEditionProvider();
		return standardPropertyBindingPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Category instances.
	 */
	protected CategoryPropertiesEditionProvider categoryPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Category
	 */
	public CategoryPropertiesEditionProvider createCategoryPropertiesEditionProvider() {
		if (categoryPropertiesEditionProvider == null)
			categoryPropertiesEditionProvider = new CategoryPropertiesEditionProvider();
		return categoryPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ElementBindingReference instances.
	 */
	protected ElementBindingReferencePropertiesEditionProvider elementBindingReferencePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ElementBindingReference
	 */
	public ElementBindingReferencePropertiesEditionProvider createElementBindingReferencePropertiesEditionProvider() {
		if (elementBindingReferencePropertiesEditionProvider == null)
			elementBindingReferencePropertiesEditionProvider = new ElementBindingReferencePropertiesEditionProvider();
		return elementBindingReferencePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * EMFMultiPropertiesBinding instances.
	 */
	protected EMFMultiPropertiesBindingPropertiesEditionProvider eMFMultiPropertiesBindingPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a EMFMultiPropertiesBinding
	 */
	public EMFMultiPropertiesBindingPropertiesEditionProvider createEMFMultiPropertiesBindingPropertiesEditionProvider() {
		if (eMFMultiPropertiesBindingPropertiesEditionProvider == null)
			eMFMultiPropertiesBindingPropertiesEditionProvider = new EMFMultiPropertiesBindingPropertiesEditionProvider();
		return eMFMultiPropertiesBindingPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * SimpleModelNavigation instances.
	 */
	protected SimpleModelNavigationPropertiesEditionProvider simpleModelNavigationPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a SimpleModelNavigation
	 */
	public SimpleModelNavigationPropertiesEditionProvider createSimpleModelNavigationPropertiesEditionProvider() {
		if (simpleModelNavigationPropertiesEditionProvider == null)
			simpleModelNavigationPropertiesEditionProvider = new SimpleModelNavigationPropertiesEditionProvider();
		return simpleModelNavigationPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * OnlyReferenceTypeFilter instances.
	 */
	protected OnlyReferenceTypeFilterPropertiesEditionProvider onlyReferenceTypeFilterPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a OnlyReferenceTypeFilter
	 */
	public OnlyReferenceTypeFilterPropertiesEditionProvider createOnlyReferenceTypeFilterPropertiesEditionProvider() {
		if (onlyReferenceTypeFilterPropertiesEditionProvider == null)
			onlyReferenceTypeFilterPropertiesEditionProvider = new OnlyReferenceTypeFilterPropertiesEditionProvider();
		return onlyReferenceTypeFilterPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * OCLFilter instances.
	 */
	protected OCLFilterPropertiesEditionProvider oCLFilterPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a OCLFilter
	 */
	public OCLFilterPropertiesEditionProvider createOCLFilterPropertiesEditionProvider() {
		if (oCLFilterPropertiesEditionProvider == null)
			oCLFilterPropertiesEditionProvider = new OCLFilterPropertiesEditionProvider();
		return oCLFilterPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * JavaExpressionFilter instances.
	 */
	protected JavaExpressionFilterPropertiesEditionProvider javaExpressionFilterPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a JavaExpressionFilter
	 */
	public JavaExpressionFilterPropertiesEditionProvider createJavaExpressionFilterPropertiesEditionProvider() {
		if (javaExpressionFilterPropertiesEditionProvider == null)
			javaExpressionFilterPropertiesEditionProvider = new JavaExpressionFilterPropertiesEditionProvider();
		return javaExpressionFilterPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * JavaDeclarationFilter instances.
	 */
	protected JavaDeclarationFilterPropertiesEditionProvider javaDeclarationFilterPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a JavaDeclarationFilter
	 */
	public JavaDeclarationFilterPropertiesEditionProvider createJavaDeclarationFilterPropertiesEditionProvider() {
		if (javaDeclarationFilterPropertiesEditionProvider == null)
			javaDeclarationFilterPropertiesEditionProvider = new JavaDeclarationFilterPropertiesEditionProvider();
		return javaDeclarationFilterPropertiesEditionProvider;
	}

}
