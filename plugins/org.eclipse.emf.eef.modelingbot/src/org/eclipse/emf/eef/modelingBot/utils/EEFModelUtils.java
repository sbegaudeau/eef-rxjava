package org.eclipse.emf.eef.modelingBot.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class EEFModelUtils {
	
	public static Object eGet(EObject container, EStructuralFeature eContainingFeature) {
		Object eGet = container.eGet(container.eClass().getEStructuralFeature(eContainingFeature.getName()));
		if (eGet instanceof EList) {
			return (EObject) ((EList) eGet).get(((EList) eGet).size()-1);
		}
		return (EObject)eGet;
	}
	
	/**
	 * @param modelElement
	 *            the element to process
	 * @return a list containing the element to expand
	 */
	public static List<Object> getExpansionPath(EObject modelElement) {
		List<Object> result = new ArrayList<Object>();
		result.add(modelElement);
		EObject container = modelElement.eContainer();
		while (container != null) {
			result.add(0, container);
			container = container.eContainer();
		}
		return result;
	}

}
