/*******************************************************************************
 * Copyright (c) 2008, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.navigation.components;

// Start of user code for imports
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.eef.eefnr.EefnrPackage;

import org.eclipse.emf.eef.eefnr.navigation.FirstModelNavigation;
import org.eclipse.emf.eef.eefnr.navigation.NavigationFactory;
import org.eclipse.emf.eef.eefnr.navigation.NavigationPackage;
import org.eclipse.emf.eef.eefnr.navigation.SmartModelNavigationSample;

import org.eclipse.emf.eef.eefnr.navigation.parts.NavigationViewsRepository;
import org.eclipse.emf.eef.eefnr.navigation.parts.SmartNavigationSampleOnglet2PropertiesEditionPart;
import org.eclipse.emf.eef.eefnr.navigation.parts.SmartNavigationSamplePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFEditorSettingsBuilder;

import org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFEditorSettingsBuilder.EEFEditorSettingsImpl;

import org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFFilter;
import org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFInitializer;
import org.eclipse.emf.eef.runtime.ui.widgets.settings.NavigationStepBuilder;


// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class SmartModelNavigationSamplePropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The SmartNavigationSample part
	 * 
	 */
	private SmartNavigationSamplePropertiesEditionPart smartNavigationSamplePart;

	/**
	 * The SmartModelNavigationSampleSmartNavigationSamplePropertiesEditionComponent sub component
	 * 
	 */
	protected SmartModelNavigationSampleSmartNavigationSamplePropertiesEditionComponent smartModelNavigationSampleSmartNavigationSamplePropertiesEditionComponent;

	/**
	 * The SmartNavigationSampleOnglet2 part
	 * 
	 */
	private SmartNavigationSampleOnglet2PropertiesEditionPart smartNavigationSampleOnglet2Part;

	/**
	 * The SmartModelNavigationSampleSmartNavigationSampleOnglet2PropertiesEditionComponent sub component
	 * 
	 */
	protected SmartModelNavigationSampleSmartNavigationSampleOnglet2PropertiesEditionComponent smartModelNavigationSampleSmartNavigationSampleOnglet2PropertiesEditionComponent;

	/**
	 * Parameterized constructor
	 * 
	 * @param smartModelNavigationSample the EObject to edit
	 * 
	 */
	public SmartModelNavigationSamplePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject smartModelNavigationSample, String editing_mode) {
		super(editingContext, editing_mode);
		if (smartModelNavigationSample instanceof SmartModelNavigationSample) {
			PropertiesEditingProvider provider = null;
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(smartModelNavigationSample, PropertiesEditingProvider.class);
			smartModelNavigationSampleSmartNavigationSamplePropertiesEditionComponent = (SmartModelNavigationSampleSmartNavigationSamplePropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, SmartModelNavigationSampleSmartNavigationSamplePropertiesEditionComponent.SMARTNAVIGATIONSAMPLE_PART, SmartModelNavigationSampleSmartNavigationSamplePropertiesEditionComponent.class);
			addSubComponent(smartModelNavigationSampleSmartNavigationSamplePropertiesEditionComponent);
			provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(smartModelNavigationSample, PropertiesEditingProvider.class);
			smartModelNavigationSampleSmartNavigationSampleOnglet2PropertiesEditionComponent = (SmartModelNavigationSampleSmartNavigationSampleOnglet2PropertiesEditionComponent)provider.getPropertiesEditingComponent(editingContext, editing_mode, SmartModelNavigationSampleSmartNavigationSampleOnglet2PropertiesEditionComponent.SMARTNAVIGATIONSAMPLEONGLET2_PART, SmartModelNavigationSampleSmartNavigationSampleOnglet2PropertiesEditionComponent.class);
			addSubComponent(smartModelNavigationSampleSmartNavigationSampleOnglet2PropertiesEditionComponent);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      getPropertiesEditionPart(int, java.lang.String)
	 * 
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (SmartModelNavigationSampleSmartNavigationSamplePropertiesEditionComponent.SMARTNAVIGATIONSAMPLE_PART.equals(key)) {
			smartNavigationSamplePart = (SmartNavigationSamplePropertiesEditionPart)smartModelNavigationSampleSmartNavigationSamplePropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)smartNavigationSamplePart;
		}
		if (SmartModelNavigationSampleSmartNavigationSampleOnglet2PropertiesEditionComponent.SMARTNAVIGATIONSAMPLEONGLET2_PART.equals(key)) {
			smartNavigationSampleOnglet2Part = (SmartNavigationSampleOnglet2PropertiesEditionPart)smartModelNavigationSampleSmartNavigationSampleOnglet2PropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)smartNavigationSampleOnglet2Part;
		}
		return super.getPropertiesEditionPart(kind, key);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      setPropertiesEditionPart(java.lang.Object, int,
	 *      org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart)
	 * 
	 */
	public void setPropertiesEditionPart(java.lang.Object key, int kind, IPropertiesEditionPart propertiesEditionPart) {
		if (NavigationViewsRepository.SmartNavigationSample.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			smartNavigationSamplePart = (SmartNavigationSamplePropertiesEditionPart)propertiesEditionPart;
		}
		if (NavigationViewsRepository.SmartNavigationSampleOnglet2.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			smartNavigationSampleOnglet2Part = (SmartNavigationSampleOnglet2PropertiesEditionPart)propertiesEditionPart;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      initPart(java.lang.Object, int, org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(java.lang.Object key, int kind, EObject element, ResourceSet allResource) {
		if (key == NavigationViewsRepository.SmartNavigationSample.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == NavigationViewsRepository.SmartNavigationSampleOnglet2.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}
