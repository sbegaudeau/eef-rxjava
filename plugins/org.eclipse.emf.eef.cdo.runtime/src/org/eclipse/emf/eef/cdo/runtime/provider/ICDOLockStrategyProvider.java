/*******************************************************************************
 * Copyright (c) 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.cdo.runtime.provider;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;

/**
 * Provide a strategy for lock and unlock elements.
 * 
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 *
 */
public interface ICDOLockStrategyProvider {
	
	 /**
     * Lock an instance.
     * 
     * @param instance
     *            any instance.
     */
    void lock(EObject instance);

    /**
     * Unlocked an instance.
     * 
     * @param instance
     *            any instance.
     */
    void release(EObject instance);
    
    /**
     *  Lock several instances.
     * 
     * @param instances
     *             locked instances.
     */
    void lock(Collection<EObject> instances);

    /**
     * Unlock several instances..
     * 
     * @param instances
     *            unlocked instances.
     */
    void release(Collection<EObject> instances);

}
