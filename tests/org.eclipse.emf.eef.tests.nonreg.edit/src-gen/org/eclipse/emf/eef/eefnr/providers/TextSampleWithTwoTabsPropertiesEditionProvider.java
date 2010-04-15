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
package org.eclipse.emf.eef.eefnr.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.eefnr.EefnrPackage;
import org.eclipse.emf.eef.eefnr.TextSampleWithTwoTabs;
import org.eclipse.emf.eef.eefnr.components.TextSampleWithTwoTabsPropertiesEditionComponent;
import org.eclipse.emf.eef.eefnr.components.TextSampleWithTwoTabsTextSampleFirstTabPropertiesEditionComponent;
import org.eclipse.emf.eef.eefnr.components.TextSampleWithTwoTabsTextSampleSecondTabPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class TextSampleWithTwoTabsPropertiesEditionProvider implements IPropertiesEditionProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject)
	 * 
	 */
	public boolean provides(EObject eObject) {
		return (eObject instanceof TextSampleWithTwoTabs) && (EefnrPackage.eINSTANCE.getTextSampleWithTwoTabs() == eObject.eClass());
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject, java.lang.String)
	 * 
	 */
	public boolean provides(EObject eObject, String part) {
		return (eObject instanceof TextSampleWithTwoTabs) && (TextSampleWithTwoTabsTextSampleFirstTabPropertiesEditionComponent.TEXTSAMPLEFIRSTTAB_PART.equals(part) || TextSampleWithTwoTabsTextSampleSecondTabPropertiesEditionComponent.TEXTSAMPLESECONDTAB_PART.equals(part));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject, java.lang.Class)
	 * 
	 */
	public boolean provides(EObject eObject, java.lang.Class refinement) {
		return (eObject instanceof TextSampleWithTwoTabs) && (refinement == TextSampleWithTwoTabsTextSampleFirstTabPropertiesEditionComponent.class || refinement == TextSampleWithTwoTabsTextSampleSecondTabPropertiesEditionComponent.class);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject, java.lang.String, java.lang.Class)
	 * 
	 */
	public boolean provides(EObject eObject, String part, java.lang.Class refinement) {
		return (eObject instanceof TextSampleWithTwoTabs) && ((TextSampleWithTwoTabsTextSampleFirstTabPropertiesEditionComponent.TEXTSAMPLEFIRSTTAB_PART.equals(part) && refinement == TextSampleWithTwoTabsTextSampleFirstTabPropertiesEditionComponent.class) || (TextSampleWithTwoTabsTextSampleSecondTabPropertiesEditionComponent.TEXTSAMPLESECONDTAB_PART.equals(part) && refinement == TextSampleWithTwoTabsTextSampleSecondTabPropertiesEditionComponent.class));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *  java.lang.String)
	 * 
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String editing_mode) {
		if (eObject instanceof TextSampleWithTwoTabs) {
			return new TextSampleWithTwoTabsPropertiesEditionComponent(eObject, editing_mode);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *  java.lang.String, java.lang.String)
	 * 
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String editing_mode, String part) {
		if (eObject instanceof TextSampleWithTwoTabs) {
			if (TextSampleWithTwoTabsTextSampleFirstTabPropertiesEditionComponent.TEXTSAMPLEFIRSTTAB_PART.equals(part))
				return new TextSampleWithTwoTabsTextSampleFirstTabPropertiesEditionComponent(eObject, editing_mode);
			if (TextSampleWithTwoTabsTextSampleSecondTabPropertiesEditionComponent.TEXTSAMPLESECONDTAB_PART.equals(part))
				return new TextSampleWithTwoTabsTextSampleSecondTabPropertiesEditionComponent(eObject, editing_mode);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *  java.lang.String, java.lang.String, java.lang.Class)
	 * 
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String editing_mode, String part, java.lang.Class refinement) {
		if (eObject instanceof TextSampleWithTwoTabs) {
			if (TextSampleWithTwoTabsTextSampleFirstTabPropertiesEditionComponent.TEXTSAMPLEFIRSTTAB_PART.equals(part)
				&& refinement == TextSampleWithTwoTabsTextSampleFirstTabPropertiesEditionComponent.class)
				return new TextSampleWithTwoTabsTextSampleFirstTabPropertiesEditionComponent(eObject, editing_mode);
			if (TextSampleWithTwoTabsTextSampleSecondTabPropertiesEditionComponent.TEXTSAMPLESECONDTAB_PART.equals(part)
				&& refinement == TextSampleWithTwoTabsTextSampleSecondTabPropertiesEditionComponent.class)
				return new TextSampleWithTwoTabsTextSampleSecondTabPropertiesEditionComponent(eObject, editing_mode);
		}
		return null;
	}

}
