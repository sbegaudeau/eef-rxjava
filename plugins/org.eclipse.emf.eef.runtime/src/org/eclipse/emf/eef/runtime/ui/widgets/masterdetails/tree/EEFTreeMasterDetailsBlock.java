/*******************************************************************************
 * Copyright (c) 2008-2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.ui.widgets.masterdetails.tree;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.runtime.ui.widgets.masterdetails.AbstractEEFMasterDetailsBlock;
import org.eclipse.emf.eef.runtime.ui.widgets.masterdetails.AbstractEEFMasterPart;
import org.eclipse.swt.widgets.Composite;
/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class EEFTreeMasterDetailsBlock extends AbstractEEFMasterDetailsBlock {

	/**
	 * @param editingDomain the editingDomain where to perform model edition
	 * @param adapterFactory the adapterFactory to use with the model
	 */
	public EEFTreeMasterDetailsBlock(EditingDomain editingDomain, AdapterFactory adapterFactory) {
		super(editingDomain, adapterFactory);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.ui.widgets.masterdetails.AbstractEEFMasterDetailsBlock#createEEFMasterPart(org.eclipse.swt.widgets.Composite)
	 */
	protected AbstractEEFMasterPart createEEFMasterPart(Composite masterContainer) {
		return new EEFTreeMasterPart(toolkit, masterContainer, editingDomain, adapterFactory);
	}

}
