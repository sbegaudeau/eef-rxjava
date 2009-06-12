/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.eef.nonreg.subPackageNonRegForFilters;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.eef.nonreg.subPackageNonRegForFilters.SubPackageNonRegForFiltersFactory
 * @model kind="package"
 * @generated
 */
public interface SubPackageNonRegForFiltersPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "subPackageNonRegForFilters";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/emf/properties/1.0.0/SubPackageNonReg";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "eef-subpackage-nonreg";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SubPackageNonRegForFiltersPackage eINSTANCE = org.eclipse.emf.eef.nonreg.subPackageNonRegForFilters.impl.SubPackageNonRegForFiltersPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.nonreg.subPackageNonRegForFilters.impl.ForFiltersImpl <em>For Filters</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.nonreg.subPackageNonRegForFilters.impl.ForFiltersImpl
	 * @see org.eclipse.emf.eef.nonreg.subPackageNonRegForFilters.impl.SubPackageNonRegForFiltersPackageImpl#getForFilters()
	 * @generated
	 */
	int FOR_FILTERS = 0;

	/**
	 * The feature id for the '<em><b>EOFCV</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_FILTERS__EOFCV = 0;

	/**
	 * The feature id for the '<em><b>RT</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_FILTERS__RT = 1;

	/**
	 * The number of structural features of the '<em>For Filters</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_FILTERS_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.nonreg.subPackageNonRegForFilters.ForFilters <em>For Filters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>For Filters</em>'.
	 * @see org.eclipse.emf.eef.nonreg.subPackageNonRegForFilters.ForFilters
	 * @generated
	 */
	EClass getForFilters();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.eef.nonreg.subPackageNonRegForFilters.ForFilters#getEOFCV <em>EOFCV</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EOFCV</em>'.
	 * @see org.eclipse.emf.eef.nonreg.subPackageNonRegForFilters.ForFilters#getEOFCV()
	 * @see #getForFilters()
	 * @generated
	 */
	EReference getForFilters_EOFCV();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.eef.nonreg.subPackageNonRegForFilters.ForFilters#getRT <em>RT</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>RT</em>'.
	 * @see org.eclipse.emf.eef.nonreg.subPackageNonRegForFilters.ForFilters#getRT()
	 * @see #getForFilters()
	 * @generated
	 */
	EReference getForFilters_RT();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SubPackageNonRegForFiltersFactory getSubPackageNonRegForFiltersFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.nonreg.subPackageNonRegForFilters.impl.ForFiltersImpl <em>For Filters</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.nonreg.subPackageNonRegForFilters.impl.ForFiltersImpl
		 * @see org.eclipse.emf.eef.nonreg.subPackageNonRegForFilters.impl.SubPackageNonRegForFiltersPackageImpl#getForFilters()
		 * @generated
		 */
		EClass FOR_FILTERS = eINSTANCE.getForFilters();

		/**
		 * The meta object literal for the '<em><b>EOFCV</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_FILTERS__EOFCV = eINSTANCE.getForFilters_EOFCV();

		/**
		 * The meta object literal for the '<em><b>RT</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_FILTERS__RT = eINSTANCE.getForFilters_RT();

	}

} //SubPackageNonRegForFiltersPackage
