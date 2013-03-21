package org.eclipse.emf.eef.naming;

import org.eclipse.emf.eef.extended.editor.ReferenceableObject;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;

public class ModelingBotQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {

	protected QualifiedName qualifiedName(ReferenceableObject ele) {
		return getConverter().toQualifiedName(ele.getReferenceName());
	}
	
	

}
