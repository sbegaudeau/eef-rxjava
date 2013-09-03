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
package org.eclipse.emf.eef.settings.components;

// Start of user code for imports
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;

import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.eef.mapping.settings.EReferenceViewerSettings;
import org.eclipse.emf.eef.mapping.settings.SettingsPackage;

import org.eclipse.emf.eef.mapping.settings.parts.SettingsPropertiesEditionPart;
import org.eclipse.emf.eef.mapping.settings.parts.SettingsViewsRepository;

import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;

import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class EReferenceViewerSettingsPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String SETTINGS_PART = "Settings"; //$NON-NLS-1$

	
	/**
	 * Settings for model EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings modelSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public EReferenceViewerSettingsPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject eReferenceViewerSettings, String editing_mode) {
		super(editingContext, eReferenceViewerSettings, editing_mode);
		parts = new String[] { SETTINGS_PART };
		repositoryKey = SettingsViewsRepository.class;
		partKey = SettingsViewsRepository.Settings_.class;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Object, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(Object key, int kind, EObject elt, ResourceSet allResource) {
		setInitializing(true);
		if (editingPart != null && key == partKey) {
			editingPart.setContext(elt, allResource);
			
			final EReferenceViewerSettings eReferenceViewerSettings = (EReferenceViewerSettings)elt;
			final SettingsPropertiesEditionPart settingsPart = (SettingsPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(SettingsViewsRepository.Settings_.model)) {
				// init part
				modelSettings = new EObjectFlatComboSettings(eReferenceViewerSettings, SettingsPackage.eINSTANCE.getEReferenceViewerSettings_Model());
				settingsPart.initModel(modelSettings);
				// set the button mode
				settingsPart.setModelButtonMode(ButtonsModeEnum.BROWSE);
			}
			// init filters
			if (isAccessible(SettingsViewsRepository.Settings_.model)) {
				settingsPart.addFilterToModel(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof EReference);
					}
					
				});
				// Start of user code for additional businessfilters for model
				// End of user code
			}
			// init values for referenced views
			
			// init filters for referenced views
			
		}
		setInitializing(false);
	}




	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
	 */
	public EStructuralFeature associatedFeature(Object editorKey) {
		if (editorKey == SettingsViewsRepository.Settings_.model) {
			return SettingsPackage.eINSTANCE.getEReferenceViewerSettings_Model();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		EReferenceViewerSettings eReferenceViewerSettings = (EReferenceViewerSettings)semanticObject;
		if (SettingsViewsRepository.Settings_.model == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				modelSettings.setToReference((EReference)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReference eObject = EcoreFactory.eINSTANCE.createEReference();
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				modelSettings.setToReference(eObject);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			SettingsPropertiesEditionPart settingsPart = (SettingsPropertiesEditionPart)editingPart;
			if (SettingsPackage.eINSTANCE.getEReferenceViewerSettings_Model().equals(msg.getFeature()) && settingsPart != null && isAccessible(SettingsViewsRepository.Settings_.model))
				settingsPart.setModel((EObject)msg.getNewValue());
			
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getNotificationFilters()
	 */
	@Override
	protected NotificationFilter[] getNotificationFilters() {
		NotificationFilter filter = new EStructuralFeatureNotificationFilter(
			SettingsPackage.eINSTANCE.getEReferenceViewerSettings_Model()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == SettingsViewsRepository.Settings_.model;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public Diagnostic validateValue(IPropertiesEditionEvent event) {
		Diagnostic ret = Diagnostic.OK_INSTANCE;
		if (event.getNewValue() != null) {
			try {
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}


	

	

}
