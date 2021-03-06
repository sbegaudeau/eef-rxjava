/*******************************************************************************
 * Copyright (c) 2015, 2016 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.eef.ide.ui.internal.properties;

import org.eclipse.eef.core.api.EEFPage;
import org.eclipse.eef.properties.ui.api.AbstractEEFSectionDescriptor;
import org.eclipse.eef.properties.ui.api.IEEFSection;
import org.eclipse.jface.viewers.IFilter;

/**
 * The implementation of the {@link AbstractEEFSectionDescriptor} using the {@link EEFPage}.
 *
 * @author sbegaudeau
 */
public class EEFSectionDescriptor extends AbstractEEFSectionDescriptor {

	/**
	 * The EEFPage.
	 */
	private EEFPage eefPage;

	/**
	 * The constructor.
	 *
	 * @param eefPage
	 *            The EEFPage
	 */
	public EEFSectionDescriptor(EEFPage eefPage) {
		this.eefPage = eefPage;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.eef.properties.ui.api.IEEFSectionDescriptor#getId()
	 */
	@Override
	public String getId() {
		return this.eefPage.getDescription().getIdentifier();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.eef.properties.ui.api.IEEFSectionDescriptor#getSectionClass()
	 */
	@Override
	public IEEFSection getSectionClass() {
		return new EEFSection(this);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.eef.properties.ui.api.IEEFSectionDescriptor#getTargetTab()
	 */
	@Override
	public String getTargetTab() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.eef.properties.ui.api.AbstractEEFSectionDescriptor#getFilter()
	 */
	@Override
	public IFilter getFilter() {
		return new IFilter() {

			@Override
			public boolean select(Object toTest) {
				return true;
			}
		};
	}

	/**
	 * Returns the EEFPage used to managed this section descriptor.
	 *
	 * @return The EEFPage used to managed this section descriptor
	 */
	public EEFPage getEEFPage() {
		return eefPage;
	}
}
