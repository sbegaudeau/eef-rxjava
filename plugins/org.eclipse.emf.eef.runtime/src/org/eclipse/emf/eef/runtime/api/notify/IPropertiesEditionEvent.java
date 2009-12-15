/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.api.notify;

import java.util.List;

/**
 * @author <a href="mailto:sbouchet@obeo.fr">sbouchet</a>
 */
public interface IPropertiesEditionEvent {
	/**
	 * @param newHolder
	 */
	public void addHolder(IPropertiesEditionListener newHolder);

	/**
	 * @return the changedEditor
	 */
	public String getAffectedEditor();

	/**
	 * @return the holders
	 */
	public List<IPropertiesEditionListener> getHolders();

	/**
	 * @return the kind
	 */
	public int getKind();

	/**
	 * @return the newIndex
	 */
	public int getNewIndex();

	/**
	 * @return the newValue
	 */
	public Object getNewValue();

	/**
	 * @return the oldValue
	 */
	public Object getOldValue();

	/**
	 * @return the state
	 */
	public int getState();

	/**
	 * @param toTest
	 * @return
	 */
	public boolean hold(IPropertiesEditionListener toTest);
}
