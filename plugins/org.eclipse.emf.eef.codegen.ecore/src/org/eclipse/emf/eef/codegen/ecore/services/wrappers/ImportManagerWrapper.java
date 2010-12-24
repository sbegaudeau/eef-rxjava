/**
 * 
 */
package org.eclipse.emf.eef.codegen.ecore.services.wrappers;

import org.eclipse.emf.codegen.util.ImportManager;

/**
 * @author sbouchet
 * 
 */
public class ImportManagerWrapper {
	public String getImportedName(String qualifiedName) {
		return new ImportManager("org.eclipse.emf.codegen.ecore.templates.edit").getImportedName(qualifiedName);
	}
}
