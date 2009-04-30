/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/

package org.eclipse.emf.eef.components.parts.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.components.parts.ComponentsViewsRepository;
import org.eclipse.emf.eef.mapping.MappingPackage;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFModelViewerDialog;
import org.eclipse.emf.eef.views.ElementEditor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class PropertiesEditionElementCustomPropertiesEditionPartImpl extends PropertiesEditionElementPropertiesEditionPartImpl {

	/**
	 * @param editionComponent
	 */
	public PropertiesEditionElementCustomPropertiesEditionPartImpl(
			IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	@Override
	protected void addViews() {
		ViewerFilter viewerFilter = new ViewerFilter() {

			public boolean select(Viewer viewer, Object parentElement, Object element) {
				return element instanceof ElementEditor && !viewsEditUtil.getVirtualList().contains(element);
			}

		};

		List filters = new ArrayList();
		EMFModelViewerDialog dialog = new EMFModelViewerDialog(
				new AdapterFactoryLabelProvider(adapterFactory), EEFUtils.choiceOfValues(adapterFactory,
						current, MappingPackage.eINSTANCE.getAbstractPropertyBinding_Views(), resourceSet),
				viewerFilter, filters, false, true) {
			public void process(IStructuredSelection selection) {
				for (Iterator iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject)iter.next();
					if (!viewsEditUtil.getVirtualList().contains(elem)) {
						viewsEditUtil.addElement(elem);
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
								PropertiesEditionElementCustomPropertiesEditionPartImpl.this,
								ComponentsViewsRepository.PropertiesEditionElement.views,
								PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null,
								viewsEditUtil.foundCorrespondingEObject(elem)));
					}
				}
			}

		};
		dialog.open();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.components.parts.forms.PropertiesEditionElementPropertiesEditionPartForm#initModel(org.eclipse.emf.ecore.resource.ResourceSet,
	 *      org.eclipse.emf.ecore.EObject)
	 */
	public void initModel(ResourceSet allResources, EObject current) {
		model.setInput(EEFUtils.choiceOfValues(adapterFactory, this.current, MappingPackage.eINSTANCE
				.getEMFPropertyBinding_Model(), allResources));
		if (current != null) {
			model.setSelection(new StructuredSelection(current));
		}
	}

}
