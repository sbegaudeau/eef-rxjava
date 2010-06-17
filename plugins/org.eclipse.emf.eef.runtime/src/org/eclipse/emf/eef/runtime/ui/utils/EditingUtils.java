/*******************************************************************************
 * Copyright (c) 2008, 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.ui.utils;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class EditingUtils {
	
	/**
	 * @param part the workbench part managing the editing domain
	 * @return if provided the editingDomain of the given workbench part
	 */
	public static EditingDomain getResourceSetFromEditor(IWorkbenchPart part) {
		EditingDomain editingDomain = null;
			if (part instanceof IEditingDomainProvider)
				editingDomain = ((IEditingDomainProvider)part).getEditingDomain();
			if (part instanceof IEditorPart) {
				if ((((IEditorPart)part).getAdapter(IEditingDomainProvider.class)) != null)
					editingDomain = ((IEditingDomainProvider)((IEditorPart)part)
							.getAdapter(IEditingDomainProvider.class)).getEditingDomain();
				else if ((((IEditorPart)part).getAdapter(EditingDomain.class)) != null)
					editingDomain = (EditingDomain)((IEditorPart)part).getAdapter(EditingDomain.class);
			}
		return editingDomain; 
	}

}
