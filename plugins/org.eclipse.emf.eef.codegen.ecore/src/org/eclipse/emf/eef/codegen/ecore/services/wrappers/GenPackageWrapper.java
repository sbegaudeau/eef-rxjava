/**
 * 
 */
package org.eclipse.emf.eef.codegen.ecore.services.wrappers;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass.ChildCreationData;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.impl.GenPackageImpl;

/**
 * @author sbouchet
 * 
 */
public class GenPackageWrapper {

	public Set<?> getExtendedChildCreationDataEntrySet(GenPackageImpl genPackage) {
		return genPackage.getExtendedChildCreationData().entrySet();
	}

	public Set<?> getPackageEntryValueEntrySet(Object packageEntry) {
		Map<GenPackage, Map<GenClass, List<ChildCreationData>>> map = (Map<GenPackage, Map<GenClass, List<ChildCreationData>>>) ((Map.Entry)packageEntry).getValue();
		return map.entrySet();
	}
}
