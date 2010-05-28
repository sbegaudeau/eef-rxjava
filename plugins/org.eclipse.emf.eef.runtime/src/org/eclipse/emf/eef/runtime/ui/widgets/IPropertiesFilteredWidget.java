/*******************************************************************************
 * Copyright (c) 2008, 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.ui.widgets;

import org.eclipse.jface.viewers.ViewerFilter;

/**
 * Interface used by dialogs to shows possible elements to be selected. The filters are used to select or not
 * elements from the models.
 * 
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 */
public interface IPropertiesFilteredWidget {
	/**
	 * Add a static filter. (without enablement/disablement system)
	 * 
	 * @param filter
	 *            the filter to add
	 */
	public void addFilter(ViewerFilter filter);

	/**
	 * Remove a static filter.
	 * 
	 * @param filter
	 *            the filter to remove
	 */
	public void removeFilter(ViewerFilter filter);

	/**
	 * Add a business filter. (with enablement/disablement system)
	 * 
	 * @param filter
	 *            the filter to add
	 */
	public void addBusinessRuleFilter(ViewerFilter filter);

	/**
	 * Remove a business filter.
	 * 
	 * @param filter
	 *            the filter to remove
	 */
	public void removeBusinessRuleFilter(ViewerFilter filter);

}
