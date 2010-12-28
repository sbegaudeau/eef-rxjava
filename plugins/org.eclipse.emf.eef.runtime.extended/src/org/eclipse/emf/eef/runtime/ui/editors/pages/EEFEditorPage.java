/**
 * 
 */
package org.eclipse.emf.eef.runtime.ui.editors.pages;

import org.eclipse.emf.eef.runtime.ui.viewers.PropertiesEditionViewer;
import org.eclipse.jface.viewers.ViewerFilter;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public interface EEFEditorPage {

	/**
	 * Defines the page input.
	 * @param input page input
	 */
	void setInput(Object input);
	
	/**
	 * Add a filter to the most appropriated {@link PropertiesEditionViewer}.
	 * @param filter the filter to add
	 */
	void addFilter(ViewerFilter filter);
	
	/**
	 * Defines the page title.
	 * @param pageTitle page title
	 */
	void setPageTitle(String pageTitle);
	
}
