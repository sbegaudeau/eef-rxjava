/**
 *  Copyright (c) 2008-2009 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Obeo - initial API and implementation
 * 
 *
 * $Id: SpecificElementEditorPropertiesEditionComponent.java,v 1.5 2009/05/20 15:52:01 sbouchet Exp $
 */
package org.eclipse.emf.eef.views.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.emf.eef.views.SpecificElementEditor;
import org.eclipse.emf.eef.views.parts.SpecificElementEditorPropertiesEditionPart;
import org.eclipse.emf.eef.views.parts.ViewsViewsRepository;

// End of user code
/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class SpecificElementEditorPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The Base part
	 */
	private SpecificElementEditorPropertiesEditionPart basePart;

	/**
	 * The SpecificElementEditorBasePropertiesEditionComponent sub component
	 */
	protected SpecificElementEditorBasePropertiesEditionComponent specificElementEditorBasePropertiesEditionComponent;

	/**
	 * The DocumentedElementPropertiesEditionComponent sub component
	 */
	protected DocumentedElementPropertiesEditionComponent documentedElementPropertiesEditionComponent;
	/**
	 * Parameterized constructor
	 * 
	 * @param specificElementEditor
	 *            the EObject to edit
	 */
	public SpecificElementEditorPropertiesEditionComponent(EObject specificElementEditor, String editing_mode) {
		super(editing_mode);
		if (specificElementEditor instanceof SpecificElementEditor) {
			specificElementEditorBasePropertiesEditionComponent = new SpecificElementEditorBasePropertiesEditionComponent(specificElementEditor, editing_mode); 
			addSubComponent(specificElementEditorBasePropertiesEditionComponent);
			documentedElementPropertiesEditionComponent = new DocumentedElementPropertiesEditionComponent(specificElementEditor, editing_mode); 	
			addSubComponent(documentedElementPropertiesEditionComponent);
		}
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 * 		getPropertiesEditionPart(int, java.lang.String)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if ("Base".equals(key)) {
			basePart = (SpecificElementEditorPropertiesEditionPart)specificElementEditorBasePropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)basePart;
		}
		return super.getPropertiesEditionPart(kind, key);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 * setPropertiesEditionPart(java.lang.Class, int, org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart)
	 */
	public void setPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionPart propertiesEditionPart) {
		if (ViewsViewsRepository.SpecificElementEditor.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			basePart = (SpecificElementEditorPropertiesEditionPart)propertiesEditionPart;
		}
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent
	 *	#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject element, ResourceSet allResource) {
		if (key == ViewsViewsRepository.SpecificElementEditor.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}

