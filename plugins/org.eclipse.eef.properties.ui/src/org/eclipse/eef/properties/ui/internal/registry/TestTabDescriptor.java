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
package org.eclipse.eef.properties.ui.internal.registry;

import java.util.Collections;

import org.eclipse.eef.properties.ui.api.AbstractEEFTabDescriptor;
import org.eclipse.eef.properties.ui.api.IEEFSectionDescriptor;

/**
 * Test tab descriptor.
 *
 * @author sbegaudeau
 */
public class TestTabDescriptor extends AbstractEEFTabDescriptor {

	/**
	 * The constructor.
	 */
	public TestTabDescriptor() {
		setSectionDescriptors(Collections.singletonList((IEEFSectionDescriptor) new TestSectionDescriptor()));
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.eef.properties.ui.api.IEEFTabDescriptor#getCategory()
	 */
	@Override
	public String getCategory() {
		return "org.eclipse.eef.category"; //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.eef.properties.ui.api.IEEFTabDescriptor#getId()
	 */
	@Override
	public String getId() {
		return "org.eclipse.eef"; //$NON-NLS-1$
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.eef.properties.ui.api.IEEFTabDescriptor#getLabel()
	 */
	@Override
	public String getLabel() {
		return "General"; //$NON-NLS-1$
	}

}
