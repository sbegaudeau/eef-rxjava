/*******************************************************************************
 * Copyright (c) 2008, 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.context;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.ResourceSetAdapter;
import org.eclipse.emf.eef.runtime.ui.parts.ViewHelper;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 * @since 1.1
 */
public interface ExtendedPropertiesEditingContext extends PropertiesEditingContext {

	
	/**
	 * Returns a new {@link IPropertiesEditionComponent} in the given mode.
	 * @param mode mode for the {@link IPropertiesEditionComponent}
	 * @return the created {@link IPropertiesEditionComponent}
	 */
	public IPropertiesEditionComponent createPropertiesEditingComponent(String mode);

	/**
	 * Returns a new {@link IPropertiesEditionComponent} in the given mode.
	 * @param mode mode for the {@link IPropertiesEditionComponent}
	 * @param part part of the {@link IPropertiesEditionComponent}
	 * @return the created {@link IPropertiesEditionComponent}
	 */
	public IPropertiesEditionComponent createPropertiesEditingComponent(String mode, String part);

	/**
	 * Returns a new {@link IPropertiesEditionComponent} in the given mode.
	 * @param mode mode for the {@link IPropertiesEditionComponent}
	 * @param part part of the {@link IPropertiesEditionComponent}
	 * @param refinement specialization of the part for {@link IPropertiesEditionComponent}
	 * @return the created {@link IPropertiesEditionComponent}
	 */
	public IPropertiesEditionComponent createPropertiesEditingComponent(String mode, String part, Class<?> refinement);

	/**
	 * @return the {@link IPropertiesEditionComponent} of the context.
	 */
	public abstract IPropertiesEditionComponent getPropertiesEditingComponent();
	
	/**
	 * @return the {@link ViewHelper} of the context.
	 */
	public ViewHelper getHelper();
	
	/**
	 * @param helper {@link ViewHelper} to use.
	 */
	public void setHelper(ViewHelper helper);
	
	/**
	 * @return
	 */
	public ResourceSetAdapter getResourceSetAdapter();
	
	/**
	 * @return 
	 */
	public boolean canReachResourceSetAdapter();
}
