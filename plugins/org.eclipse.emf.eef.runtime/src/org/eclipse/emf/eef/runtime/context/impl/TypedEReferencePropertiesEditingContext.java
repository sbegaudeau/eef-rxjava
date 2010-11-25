/**
 * 
 */
package org.eclipse.emf.eef.runtime.context.impl;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class TypedEReferencePropertiesEditingContext extends EReferencePropertiesEditionContext {

	private EClass expectedType;
	
	/**
	 * @param parentContext
	 * @param propertiesEditionComponent
	 * @param eObject
	 * @param eReference
	 * @param expectedType
	 * @param adapterFactory
	 */
	public TypedEReferencePropertiesEditingContext(PropertiesEditingContext parentContext, IPropertiesEditionComponent propertiesEditionComponent, EObject eObject, EReference eReference, EClass expectedType, AdapterFactory adapterFactory) {
		super(parentContext, propertiesEditionComponent, eObject, eReference, adapterFactory);
		this.expectedType = expectedType;
	}

	/**
	 * @return the expectedType
	 */
	public EClass getExpectedType() {
		return expectedType;
	}

}
