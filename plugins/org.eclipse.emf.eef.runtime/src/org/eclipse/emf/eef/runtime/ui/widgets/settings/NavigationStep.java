/*******************************************************************************
 * Copyright (c) 2008, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.ui.widgets.settings;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;

/**
 * @author glefur
 * @since 1.0
 *
 */
public interface NavigationStep {
	
	/**
	 * Constant defining an uninitialized step index.
	 */
	public final static int NOT_INITIALIZED = -1;
	
	/**
	 * @return the step reference.
	 */
	public EReference getReference();
	
	/**
	 * @return the step index.
	 */
	public int getIndex();
	
	/**
	 * @return a type discrimination for the step.
	 */
	public EClassifier getDiscriminator();
	
}
