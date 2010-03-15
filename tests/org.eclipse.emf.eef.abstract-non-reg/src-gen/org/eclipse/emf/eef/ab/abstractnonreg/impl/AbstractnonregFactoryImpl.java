/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractnonregFactoryImpl.java,v 1.2 2010/03/15 13:56:24 sbouchet Exp $
 */
package org.eclipse.emf.eef.ab.abstractnonreg.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.eef.ab.abstractnonreg.AbstractnonregFactory;
import org.eclipse.emf.eef.ab.abstractnonreg.AbstractnonregPackage;
import org.eclipse.emf.eef.ab.abstractnonreg.DocumentedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AbstractnonregFactoryImpl extends EFactoryImpl implements AbstractnonregFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AbstractnonregFactory init() {
		try {
			AbstractnonregFactory theAbstractnonregFactory = (AbstractnonregFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/emf/properties/1.0.0/AbstractNonReg"); 
			if (theAbstractnonregFactory != null) {
				return theAbstractnonregFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AbstractnonregFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractnonregFactoryImpl() {
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
			case AbstractnonregPackage.DOCUMENTED_ELEMENT: return createDocumentedElement();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentedElement createDocumentedElement() {
		DocumentedElementImpl documentedElement = new DocumentedElementImpl();
		return documentedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractnonregPackage getAbstractnonregPackage() {
		return (AbstractnonregPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AbstractnonregPackage getPackage() {
		return AbstractnonregPackage.eINSTANCE;
	}

} //AbstractnonregFactoryImpl
