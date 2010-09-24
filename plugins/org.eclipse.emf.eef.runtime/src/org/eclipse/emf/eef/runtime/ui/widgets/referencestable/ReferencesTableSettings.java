/**
 * 
 */
package org.eclipse.emf.eef.runtime.ui.widgets.referencestable;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author glefur
 *
 */
public class ReferencesTableSettings {

	private EObject source;
	private EReference[] features;

	/**
	 * @param source
	 * @param path
	 */
	public ReferencesTableSettings(EObject source, EReference... features) {
		super();
		this.source = source;
		this.features = features;
	}

	/**
	 * @return the source
	 */
	public EObject getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(EObject source) {
		this.source = source;
	}

	/**
	 * @return the list of elements following the path.
	 */
	public Object[] getElements() {
		if (((EClass)features[0].eContainer()).isInstance(source)) {
			Object value1 = ((EObject)source).eGet(features[0]);
			if (value1 != null) {
				if (features.length == 1) {
					return features[0].isMany()?((List<EObject>)value1).toArray():new Object[] { value1 };
				}
				else {
					if (features[0].isMany()) {
						List<Object> result = new ArrayList<Object>();
						for (EObject elem : ((List<EObject>)value1)) {
							if (features[1].isMany())
								result.addAll((List<EObject>)elem.eGet(features[1]));
							else
								result.add((EObject)elem.eGet(features[1]));
						}
						return result.toArray();
					} else {
						if (features[1].isMany()) {
							return ((List)((EObject)value1).eGet(features[1])).toArray();
						}
						else {
							return new Object[] { ((EObject)value1).eGet(features[1]) };
						}
					}
				}
			}
		}
		return new Object[0];
	}

	/**
	 * Add a new value following a list of StructualFeatures to a given EObject
	 * @param newValue the value to add
	 */
	public void addToReference(EObject newValue) {
		EReference ref = features[0];
		Object value1 = source.eGet(ref);
		if (ref.isMany()) {
			if (features.length > 1) {
				EObject intermediate  = EcoreUtil.create(ref.getEReferenceType());
				EReference ref2 = features[1];
				if (ref2.isMany()) {
					Object value2 = ((EObject)intermediate).eGet(ref2);
					((List<EObject>) value2).add(newValue);
				}
				else {
					((EObject)intermediate).eSet(ref2, newValue);
				}
				((List<EObject>)value1).add(intermediate);
			}
			else {
				((List<EObject>)value1).add(newValue);
			}
		} else /* ref is Single */  {
			if (features.length > 1) {
				if (value1 == null)  {
					value1 = EcoreUtil.create(ref.getEReferenceType());
					// WARNING: Cannot be an abstract class
					source.eSet(ref, value1);
				}
				EReference ref2 = features[1];
				Object value2 = ((EObject)value1).eGet(ref2);
				if (ref2.isMany()) {
					((List<EObject>) value2).add(newValue);
				}
				else {
					((EObject)value2).eSet(ref2, newValue);
				}
			}
			else {
				source.eSet(ref, newValue);
			}
		}
	}

	/**
	 * Remove a value following a list of StructualFeatures to a given EObject
	 * @param valueToRemove the value to remove
	 */
	public void removeFromReference(EObject valueToRemove) {
		EReference ref = features[0];
		Object value1 = source.eGet(ref);
		if (ref.isMany()) {
			if (features.length > 1) {
				EReference ref2 = features[1];
				if (ref2.isMany()) {
					for (EObject elem : (List<EObject>)value1) {
						List<EObject> value2 = (List<EObject>) ((EObject)elem).eGet(ref2);
						if (value2.contains(valueToRemove))
							value2.remove(valueToRemove);
					}
				}
				else { /* ref2 is Single */
					EObject elemToRemove = null;
					for (EObject elem : (List<EObject>)value1) {
						EObject elem2 = (EObject) ((EObject)elem).eGet(ref2);
						if (elem2 != null && elem2.equals(valueToRemove)) {
							elemToRemove = elem;
						}
					}
					((List<EObject>)value1).remove(elemToRemove);
				}
			}
			else {
				((List<EObject>)value1).remove(valueToRemove);
			}
		} else /* ref is Single */  {
			if (features.length > 1) {
				EReference ref2 = features[1];
				Object value2 = ((EObject)value1).eGet(ref2);
				if (ref2.isMany()) {
					((List<EObject>) value2).remove(valueToRemove);
				}
				else { /* ref2 is Single */
					EcoreUtil.remove((EObject) source.eGet(ref));
				}
			}
			else {
				EcoreUtil.remove((EObject) source.eGet(ref));
			}
		}
	}

	/**
	 * Defines if the given value is already contained in the given path	
	 * @param toCheck the element to check
	 */
	public boolean contains(EObject toCheck) {
		EReference ref = features[0];
		Object value1 = source.eGet(ref);
		if (ref.isMany()) {
			if (features.length > 1) {
				EReference ref2 = features[1];
				if (ref2.isMany()) {
					for (EObject elem : (List<EObject>)value1) {
						List<EObject> value2 = (List<EObject>) ((EObject)elem).eGet(ref2);
						if (value2.contains(toCheck))
							return true;
					}
					return false;
				}
				else { /* ref2 is Single */
					EObject elemToRemove = null;
					for (EObject elem : (List<EObject>)value1) {
						EObject elem2 = (EObject) ((EObject)elem).eGet(ref2);
						if (elem2 != null && elem2.equals(toCheck)) {
							return true;
						}
					}
					return false;
				}
			}
			else {
				return ((List<EObject>)value1).contains(toCheck);
			}
		} else /* ref is Single */  {
			if (features.length > 1) {
				EReference ref2 = features[1];
				Object value2 = ((EObject)value1).eGet(ref2);
				if (ref2.isMany()) {
					return ((List<EObject>)value2).contains(toCheck);
				}
				else { /* ref2 is Single */
					return value2.equals(toCheck);
				}
			} 
			else {
				return value1.equals(toCheck);
			}
		}
	}

}
