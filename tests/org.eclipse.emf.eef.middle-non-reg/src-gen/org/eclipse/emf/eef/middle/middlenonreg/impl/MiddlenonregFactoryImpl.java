/**
 * <copyright>
 * </copyright>
 *
 * $Id: MiddlenonregFactoryImpl.java,v 1.2 2010/03/15 13:59:55 sbouchet Exp $
 */
package org.eclipse.emf.eef.middle.middlenonreg.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.eef.middle.middlenonreg.MiddlenonregFactory;
import org.eclipse.emf.eef.middle.middlenonreg.MiddlenonregPackage;
import org.eclipse.emf.eef.middle.middlenonreg.NamedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MiddlenonregFactoryImpl extends EFactoryImpl implements MiddlenonregFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MiddlenonregFactory init() {
		try {
			MiddlenonregFactory theMiddlenonregFactory = (MiddlenonregFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/emf/properties/1.0.0/MiddleNonReg"); 
			if (theMiddlenonregFactory != null) {
				return theMiddlenonregFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MiddlenonregFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MiddlenonregFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case MiddlenonregPackage.NAMED_ELEMENT: return createNamedElement();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamedElement createNamedElement() {
		NamedElementImpl namedElement = new NamedElementImpl();
		return namedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MiddlenonregPackage getMiddlenonregPackage() {
		return (MiddlenonregPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MiddlenonregPackage getPackage() {
		return MiddlenonregPackage.eINSTANCE;
	}

} //MiddlenonregFactoryImpl
