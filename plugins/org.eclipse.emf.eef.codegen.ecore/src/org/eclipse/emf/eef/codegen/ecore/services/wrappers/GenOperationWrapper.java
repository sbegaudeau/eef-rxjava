package org.eclipse.emf.eef.codegen.ecore.services.wrappers;

import org.eclipse.emf.codegen.ecore.genmodel.GenOperation;

/**
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 * @since 1.1
 */
public class GenOperationWrapper {

	private boolean firstPrefix = true;

	public String prefix(GenOperation genOperation) {
		if (firstPrefix) {
			firstPrefix = false;
			return genOperation.getGenModel().getImportedName("org.eclipse.emf.ecore.EOperation") + " op = ";
		}
		return "op = ";
	}

	public void resetGenOperationPrefix() {
		firstPrefix = true;
	}
}
