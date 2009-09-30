/**
 * 
 */
package org.eclipse.emf.eef.codegen.ui.generators.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.ui.actions.OrganizeImportsAction;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchSite;

/**
 * @author glefur
 *
 */
public class ImportOrganizer {
	
	public void organizeImports(IWorkbenchSite site, Set<IContainer> folders) {
		List<ICompilationUnit> units = new ArrayList<ICompilationUnit>();
		for (IContainer container : folders) {
			IJavaElement element = JavaCore.create(container);
			IPackageFragmentRoot[] allPackageFragmentRoots;
			try {
				if (element instanceof IPackageFragmentRoot) {
					IJavaElement[] children = ((IPackageFragmentRoot)element).getChildren();
					for (int i = 0; i < children.length; i++) {
						IJavaElement javaElement = children[i];
						if (javaElement instanceof IPackageFragment) {
							IPackageFragment fragment = (IPackageFragment)javaElement;
							units.addAll(Arrays.asList(fragment.getCompilationUnits()));
						}
					}
				}
			} catch (JavaModelException e) {
			}
		}
		OrganizeImportsAction organizeImportsAction = new OrganizeImportsAction(site);
		organizeImportsAction.run(new StructuredSelection(units));
	}

}
