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
package org.eclipse.emf.eef.eefnr.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.eefnr.TextSampleWithTwoTabs;
import org.eclipse.emf.eef.eefnr.parts.EefnrViewsRepository;
import org.eclipse.emf.eef.eefnr.parts.TextSampleFirstTabPropertiesEditionPart;
import org.eclipse.emf.eef.eefnr.parts.TextSampleSecondTabPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionComponentService;


// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class TextSampleWithTwoTabsPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The TextSampleFirstTab part
	 */
	private TextSampleFirstTabPropertiesEditionPart textSampleFirstTabPart;

	/**
	 * The TextSampleWithTwoTabsTextSampleFirstTabPropertiesEditionComponent sub component
	 */
	protected TextSampleWithTwoTabsTextSampleFirstTabPropertiesEditionComponent textSampleWithTwoTabsTextSampleFirstTabPropertiesEditionComponent;

	/**
	 * The TextSampleSecondTab part
	 */
	private TextSampleSecondTabPropertiesEditionPart textSampleSecondTabPart;

	/**
	 * The TextSampleWithTwoTabsTextSampleSecondTabPropertiesEditionComponent sub component
	 */
	protected TextSampleWithTwoTabsTextSampleSecondTabPropertiesEditionComponent textSampleWithTwoTabsTextSampleSecondTabPropertiesEditionComponent;

	/**
	 * Parameterized constructor
	 * 
	 * @param textSampleWithTwoTabs
	 *            the EObject to edit
	 */
	public TextSampleWithTwoTabsPropertiesEditionComponent(EObject textSampleWithTwoTabs, String editing_mode) {
		super(editing_mode);
		if (textSampleWithTwoTabs instanceof TextSampleWithTwoTabs) {
			IPropertiesEditionProvider provider = PropertiesEditionComponentService.getInstance().getProvider(textSampleWithTwoTabs);
			textSampleWithTwoTabsTextSampleFirstTabPropertiesEditionComponent = (TextSampleWithTwoTabsTextSampleFirstTabPropertiesEditionComponent)provider.getPropertiesEditionComponent(textSampleWithTwoTabs, editing_mode, TextSampleWithTwoTabsTextSampleFirstTabPropertiesEditionComponent.TEXTSAMPLEFIRSTTAB_PART);
			addSubComponent(textSampleWithTwoTabsTextSampleFirstTabPropertiesEditionComponent);
			textSampleWithTwoTabsTextSampleSecondTabPropertiesEditionComponent = (TextSampleWithTwoTabsTextSampleSecondTabPropertiesEditionComponent)provider.getPropertiesEditionComponent(textSampleWithTwoTabs, editing_mode, TextSampleWithTwoTabsTextSampleSecondTabPropertiesEditionComponent.TEXTSAMPLESECONDTAB_PART);
			addSubComponent(textSampleWithTwoTabsTextSampleSecondTabPropertiesEditionComponent);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      getPropertiesEditionPart(int, java.lang.String)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (TextSampleWithTwoTabsTextSampleFirstTabPropertiesEditionComponent.TEXTSAMPLEFIRSTTAB_PART.equals(key)) {
			textSampleFirstTabPart = (TextSampleFirstTabPropertiesEditionPart)textSampleWithTwoTabsTextSampleFirstTabPropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)textSampleFirstTabPart;
		}
		if (TextSampleWithTwoTabsTextSampleSecondTabPropertiesEditionComponent.TEXTSAMPLESECONDTAB_PART.equals(key)) {
			textSampleSecondTabPart = (TextSampleSecondTabPropertiesEditionPart)textSampleWithTwoTabsTextSampleSecondTabPropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)textSampleSecondTabPart;
		}
		return super.getPropertiesEditionPart(kind, key);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      setPropertiesEditionPart(java.lang.Class, int,
	 *      org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart)
	 */
	public void setPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionPart propertiesEditionPart) {
		if (EefnrViewsRepository.TextSampleFirstTab.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			textSampleFirstTabPart = (TextSampleFirstTabPropertiesEditionPart)propertiesEditionPart;
		}
		if (EefnrViewsRepository.TextSampleSecondTab.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			textSampleSecondTabPart = (TextSampleSecondTabPropertiesEditionPart)propertiesEditionPart;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject element, ResourceSet allResource) {
		if (key == EefnrViewsRepository.TextSampleFirstTab.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == EefnrViewsRepository.TextSampleSecondTab.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}