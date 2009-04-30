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
package org.eclipse.emf.eef.runtime.ui.properties.sections;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionComponentService;
import org.eclipse.emf.eef.runtime.ui.properties.TabbedPropertiesEditionSheetPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;
import org.eclipse.ui.views.properties.tabbed.TabContents;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class PropertiesEditionSection extends AbstractPropertySection {

	/**
	 * the property sheet page for this section.
	 */
	private TabbedPropertiesEditionSheetPage propertySheetPage;

	/**
	 * the section's parent
	 */
	protected Composite parent;

	/**
	 * The current selected object or the first object in the selection when multiple objects are selected.
	 */
	protected EObject eObject;

	/**
	 * The list of current selected objects.
	 */
	protected List eObjectList;

	/**
	 * The component that have to managed the edition
	 */
	private IPropertiesEditionComponent propertiesEditionComponent = null;

	/**
	 * The view manager
	 */
	private IPropertiesEditionPart editionPart = null;

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#createControls(org.eclipse.swt.widgets.Composite,
	 *      org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		this.propertySheetPage = (TabbedPropertiesEditionSheetPage)aTabbedPropertySheetPage;
		this.parent = parent;
	}

	/**
	 * @see org.eclipse.ui.views.properties.tabbed.ISection#setInput(org.eclipse.ui.IWorkbenchPart,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		if (!(selection instanceof IStructuredSelection)) {
			return;
		}
		if (((IStructuredSelection)selection).getFirstElement() instanceof EObject) {
			EObject newEObject = (EObject)((IStructuredSelection)selection).getFirstElement();
			if (newEObject != eObject) {
				eObject = newEObject;
				if (eObject != null) {
					IPropertiesEditionProvider provider = PropertiesEditionComponentService.getInstance()
							.getProvider(eObject);
					if (this.propertiesEditionComponent != null)
						this.propertiesEditionComponent.dispose();
					this.propertiesEditionComponent = provider.getPropertiesEditionComponent(eObject,
							IPropertiesEditionComponent.LIVE_MODE, getDescriptor());
					if (this.propertiesEditionComponent != null) {
						this.propertiesEditionComponent.setLiveEditingDomain(propertySheetPage
								.getEditingDomain());
						this.editionPart = propertiesEditionComponent.getPropertiesEditionPart("Form",	getDescriptor());
						if (editionPart instanceof IFormPropertiesEditionPart) {
							for (int i = 0; i < parent.getChildren().length; i++) {
								Composite child = (Composite)parent.getChildren()[i];
								child.dispose();
							}
							((IFormPropertiesEditionPart)this.editionPart).createFigure(parent,
									getWidgetFactory());
							parent.layout();
							this.editionPart.initComponent(eObject);
						}
					}
				}
			}
		}
		eObjectList = ((IStructuredSelection)selection).toList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.views.properties.tabbed.AbstractPropertySection#dispose()
	 */
	public void dispose() {
		super.dispose();
		if (this.propertiesEditionComponent != null) {
			this.propertiesEditionComponent.dispose();
			this.propertiesEditionComponent = null;
			this.editionPart = null;
		}

	}

	/**
	 * For eclipse 3.4
	 * 
	 * @return
	 */
	protected String getDescriptor() {
		Map descriptor = propertySheetPage.getDescriptor();
		for (Iterator iterator = descriptor.keySet().iterator(); iterator.hasNext();) {
			ITabDescriptor key = (ITabDescriptor)iterator.next();
			TabContents tab = (TabContents)descriptor.get(key);
			if (tab.getSectionAtIndex(0) == this)
				return key.getId();

		}
		return null;
	}

	/**
	 * For eclipse 3.2
	 * 
	 * @return
	 */
//	protected String getDescriptor() {
//		Map descriptor = propertySheetPage.getDescriptor();
//		for (Iterator iterator = descriptor.keySet().iterator(); iterator.hasNext();) {
//			TabDescriptor key = (TabDescriptor)iterator.next();
//			if (((Tab)descriptor.get(key)).getSectionAtIndex(0) == this)
//				return key.getId();
//
//		}
//		return "";
//	}

}
