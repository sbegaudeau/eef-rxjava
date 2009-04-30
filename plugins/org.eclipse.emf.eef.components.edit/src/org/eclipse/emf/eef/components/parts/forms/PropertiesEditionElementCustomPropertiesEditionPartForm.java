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
package org.eclipse.emf.eef.components.parts.forms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.eef.components.parts.ComponentsViewsRepository;
import org.eclipse.emf.eef.mapping.MappingPackage;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PathedPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFModelViewerDialog;
import org.eclipse.emf.eef.views.ElementEditor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class PropertiesEditionElementCustomPropertiesEditionPartForm extends PropertiesEditionElementPropertiesEditionPartForm {

	public PropertiesEditionElementCustomPropertiesEditionPartForm(
			IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	@Override
	protected void addViews() {
		ViewerFilter viewerFilter = new ViewerFilter() {
			
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				return element instanceof ElementEditor  && !viewsEditUtil.getVirtualList().contains(element);
			}
	
		};
		
		List filters = new ArrayList();
	
		// Start of user code for filters initialisation for ElementEditor
		
		// End of user code
	
		EMFModelViewerDialog dialog = new EMFModelViewerDialog(view.getShell(), new AdapterFactoryLabelProvider(adapterFactory), EEFUtils.choiceOfValues(adapterFactory, current, MappingPackage.eINSTANCE.getAbstractPropertyBinding_Views(), resourceSet), viewerFilter, filters, false, true) {
			public void process(IStructuredSelection selection) {
				for (Iterator iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					if (!viewsEditUtil.getVirtualList().contains(elem)) {
						viewsEditUtil.addElement(elem);
						propertiesEditionComponent.firePropertiesChanged(new PathedPropertiesEditionEvent(PropertiesEditionElementCustomPropertiesEditionPartForm.this, ComponentsViewsRepository.PropertiesEditionElement.views, PathedPropertiesEditionEvent.COMMIT, PathedPropertiesEditionEvent.ADD, null, viewsEditUtil.foundCorrespondingEObject(elem)));
					}
				}
			}
	
		};
		dialog.open();
	}
	
}
