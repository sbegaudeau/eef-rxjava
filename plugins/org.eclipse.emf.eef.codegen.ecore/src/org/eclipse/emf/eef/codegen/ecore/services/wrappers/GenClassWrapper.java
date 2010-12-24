/**
 * 
 */
package org.eclipse.emf.eef.codegen.ecore.services.wrappers;

import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass.ChildCreationData;
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel;
import org.eclipse.emf.codegen.ecore.genmodel.impl.GenClassImpl;

/**
 * @author sbouchet
 * 
 */
public class GenClassWrapper {

	public String getInternalQualifiedInterfaceName(GenClassImpl genClass,
			Boolean includeTemplateArguments) {
		if (genClass.isDynamic()) {
			GenClass baseGenClass = genClass.getBaseGenClass();
			return baseGenClass == null ? "org.eclipse.emf.ecore.EObject"
					: getInternalQualifiedInterfaceName((GenClassImpl) baseGenClass);
		}

		return genClass.getEcoreClass().getInstanceClassName() != null ? includeTemplateArguments ? genClass
				.getEcoreClass().getInstanceTypeName() : genClass
				.getEcoreClass().getInstanceClassName()
				: genClass.getGenPackage().getInterfacePackageName() + "."
						+ genClass.getInterfaceName();
	}

	public String getInternalQualifiedInterfaceName(GenClassImpl genClass) {
		return getInternalQualifiedInterfaceName(
				genClass,
				getEffectiveComplianceLevel(genClass).getValue() >= GenJDKLevel.JDK50);
	}

	protected GenJDKLevel getEffectiveComplianceLevel(GenClass genClass) {
		return genClass.getGenModel().getComplianceLevel();
	}

	public List<?> getChildCreationData(GenClassImpl genClass) {
		return genClass.getChildCreationData();
	}

	public GenFeature getCreateFeature(Object childCreationData) {
		return ((ChildCreationData) childCreationData).createFeature;
	}

	public GenFeature getDelegatedFeature(Object childCreationData) {
		return ((ChildCreationData) childCreationData).delegatedFeature;
	}

	public GenClassifier getCreateClassifier(Object childCreationData) {
		return ((ChildCreationData) childCreationData).createClassifier;
	}
}
