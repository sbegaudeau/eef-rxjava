/*******************************************************************************
 * Copyright (c) 2008-2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.impl.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class EMFListEditUtil {

	private List<EObject> copy;

	private List<EObject> elementsToAdd;

	private List<EObject> elementsToRemove;

	private Map<EObject, MoveElement> elementsToMove;

	public class MoveElement {
		int index;

		EObject element;

		public int getIndex() {
			return index;
		}

		public EObject getElement() {
			return element;
		}

	}

	private Map elementsToRefresh;

	private Map copyToModelMap;

	private EReference feature;

	private EReference containingFeature;

	/**
	 * Default Constructor.
	 * 
	 * @param eObject
	 *            the eObject to mimic
	 * @param feature
	 *            the feature to manage
	 */
	public EMFListEditUtil(EObject eObject, EReference feature) {
		this.feature = feature;
		init(eObject);
	}

	/**
	 * Constructor to use with model navigation
	 * 
	 * @param eObject
	 *            the eObject to mimic
	 * @param containingFeature
	 *            the feature to navigate inside
	 * @param feature
	 *            the feature to manage
	 */
	public EMFListEditUtil(EObject eObject, EReference containingFeature, EReference feature) {
		this.feature = feature;
		this.containingFeature = containingFeature;
		init(eObject);
	}

	/**
	 * Reinit the structure with the new eObject
	 * 
	 * @param eObject
	 *            the updated eObject
	 */
	public void reinit(EObject eObject) {
		// Warn !! this clear all the recorded modification
		if (feature.isMany() && containingFeature == null) {
			// default init case
			this.copy.clear();
			for (Iterator<EObject> iterator = clone(eObject.eGet(feature)).iterator(); iterator.hasNext();) {
				EObject next = iterator.next();
				this.copy.add(next);
			}
		} else if (containingFeature != null && containingFeature.isMany()) {
			// model navigation
			this.copy.clear();
			for (Iterator<EObject> iterator = clone(eObject.eGet(containingFeature)).iterator(); iterator
					.hasNext();) {
				EObject next = iterator.next();
				this.copy.add(next);
			}
		} else
			copy.clear();
		elementsToAdd.clear();
		elementsToRemove.clear();
		elementsToRefresh.clear();
		elementsToMove.clear();
	}

	/**
	 * initialize the structure
	 * 
	 * @param eObject
	 *            the eObject to mimic
	 * @param feature
	 *            the feature to manage
	 */
	private void init(EObject eObject) {
		if (feature.isMany() && containingFeature == null) {
			// default init case
			this.copy = clone(eObject.eGet(feature));
		} else if (containingFeature != null && containingFeature.isMany()) {
			// model navigation
			this.copy = clone(eObject.eGet(containingFeature));
		} else
			copy = new ArrayList<EObject>();
		elementsToAdd = new ArrayList<EObject>();
		elementsToRemove = new ArrayList<EObject>();
		elementsToRefresh = new HashMap();
		elementsToMove = new HashMap();
	}

	public List getVirtualList() {
		return copy;
	}

	public void addElement(EObject selectedElement) {
		if (elementsToRemove.contains(selectedElement))
			elementsToRemove.remove(selectedElement);
		else
			elementsToAdd.add(selectedElement);
		copy.add(selectedElement);
	}

	public void moveElement(EObject selectedElement, int oldIndex, int newIndex) {
		EObject foundedCorrespondingEObject = foundCorrespondingEObject(selectedElement);
		if (foundedCorrespondingEObject != null) {
			if (elementsToMove.containsKey(foundedCorrespondingEObject)) {
				MoveElement moveElement = elementsToMove.get(foundedCorrespondingEObject);
				moveElement.index = newIndex;
			} else {
				MoveElement moveElement = new MoveElement();
				moveElement.element = foundedCorrespondingEObject;
				moveElement.index = newIndex;
				elementsToMove.put(foundedCorrespondingEObject, moveElement);
			}
			EObject oldElement = (EObject)copy.get(newIndex);
			if (oldElement != null) {
				copy.set(newIndex, selectedElement);
				copy.set(oldIndex, oldElement);
			}
		}
	}

	public void removeElement(EObject selectedElement) {
		if (elementsToAdd.contains(selectedElement))
			elementsToAdd.remove(selectedElement);
		else {
			EObject foundedCorrespondingEObject = foundCorrespondingEObject(selectedElement);
			if (foundedCorrespondingEObject != null) {
				if (elementsToRefresh.keySet().contains(selectedElement))
					elementsToRefresh.remove(selectedElement);
				elementsToRemove.add(foundedCorrespondingEObject);
			}
		}
		copy.remove(selectedElement);
	}

	public void putElementToRefresh(EObject e1, EObject e2) {
		if (elementsToAdd.contains(e1)) {
			elementsToAdd.remove(e1);
			elementsToAdd.add(e2);
		} else
			elementsToRefresh.put(e1, e2);
	}

	/**
	 * @return the elementsToAdd
	 */
	public List getElementsToAdd() {
		return elementsToAdd;
	}

	/**
	 * @return the elementsToRemove
	 */
	public List getElementsToRemove() {
		return elementsToRemove;
	}

	/**
	 * @return the elementsToMove
	 */
	public List<MoveElement> getElementsToMove() {
		return new ArrayList<MoveElement>(elementsToMove.values());
	}

	private List<EObject> clone(Object list) {
		List<EObject> result = new ArrayList<EObject>();
		if (list instanceof EList) {
			EList<EObject> theList = (EList)list;
			copyToModelMap = new HashMap(theList.size());
			for (Iterator<EObject> iter = theList.iterator(); iter.hasNext();) {
				EObject next = iter.next();
				EObject copy = null;
				if (containingFeature != null) {
					// model navigation
					EObject obj = (EObject)next.eGet(feature);
					if (obj != null)
						copy = EcoreUtil.copy(obj);
				} else {
					// default case
					copy = EcoreUtil.copy(next);
				}
				if (copy != null) {
					result.add(copy);
					copyToModelMap.put(copy, next);
				}
			}
		}
		return result;
	}

	public EObject foundCorrespondingEObject(EObject searchedObject) {
		// search in model
		if (copyToModelMap.containsKey(searchedObject)) {
			return (EObject)copyToModelMap.get(searchedObject);
		}
		// search in newly created elements
		for (Iterator<EObject> iter = elementsToAdd.iterator(); iter.hasNext();) {
			EObject next = iter.next();
			if (EcoreUtil.equals(searchedObject, next) && searchedObject.equals(next))
				return next;
		}
		return null;
	}

	/**
	 * @return the elementsToRefresh
	 */
	public Map getElementsToRefresh() {
		return elementsToRefresh;
	}

	public void clearCopy() {
		copy.clear();
		copyToModelMap.clear();
	}

	public boolean contains(EObject toTest) {
		if (containingFeature == null) {
			// default case
			boolean containedInCopy = copyToModelMap.values().contains(toTest);
			boolean isToBeRemoved = elementsToRemove.contains(foundCorrespondingEObject(toTest));
			boolean isToBeAdded = elementsToAdd.contains(foundCorrespondingEObject(toTest));
			return containedInCopy ? !isToBeRemoved : isToBeAdded;
		} else {
			// model navigation
			for (Iterator iterator = copyToModelMap.values().iterator(); iterator.hasNext();) {
				EObject value = (EObject)iterator.next();
				if ((value.eGet(feature).equals(toTest) && !elementsToRemove
						.contains(foundCorrespondingEObject(toTest)))
						|| elementsToAdd.contains(toTest)) {
					return true;
				}
			}
			return false;
		}

	}

}
