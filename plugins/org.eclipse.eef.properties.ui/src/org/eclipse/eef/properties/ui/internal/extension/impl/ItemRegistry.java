/*******************************************************************************
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.eef.properties.ui.internal.extension.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.eef.properties.ui.internal.extension.IItemDescriptor;
import org.eclipse.eef.properties.ui.internal.extension.IItemRegistry;

/**
 * The implementation of the {@link IItemRegistry}.
 *
 * @author sbegaudeau
 *
 * @param <T>
 *            The type of the object described
 */
public class ItemRegistry<T> implements IItemRegistry<T> {

	/**
	 * The map of the identifier of the description to the {@link IItemDescriptor}.
	 */
	private Map<String, IItemDescriptor<T>> id2descriptors = new HashMap<String, IItemDescriptor<T>>();

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.eef.ide.internal.extensions.IItemRegistry#getItemDescriptors()
	 */
	@Override
	public List<IItemDescriptor<T>> getItemDescriptors() {
		List<IItemDescriptor<T>> descriptors = new ArrayList<IItemDescriptor<T>>();
		Collection<IItemDescriptor<T>> values = this.id2descriptors.values();
		for (IItemDescriptor<T> iItemDescriptor : values) {
			descriptors.add(iItemDescriptor);
		}
		return descriptors;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.eef.ide.internal.extensions.IItemRegistry#getItemDescriptor(java.lang.String)
	 */
	@Override
	public IItemDescriptor<T> getItemDescriptor(String id) {
		return this.id2descriptors.get(id);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.eef.ide.internal.extensions.IItemRegistry#add(org.eclipse.eef.ide.internal.extensions.IItemDescriptor)
	 */
	@Override
	public IItemDescriptor<T> add(IItemDescriptor<T> descriptor) {
		return this.id2descriptors.put(descriptor.getID(), descriptor);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.eef.ide.internal.extensions.IItemRegistry#remove(java.lang.String)
	 */
	@Override
	public IItemDescriptor<T> remove(String id) {
		return this.id2descriptors.remove(id);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.eef.ide.internal.extensions.IItemRegistry#clear()
	 */
	@Override
	public void clear() {
		this.id2descriptors.clear();
	}

}
