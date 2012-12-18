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

import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.eef.eefnr.navigation.NavigationFactory;
import org.eclipse.emf.eef.eefnr.navigation.NavigationPackage;
import org.eclipse.emf.eef.eefnr.navigation.SecondModelNavigation;
import org.eclipse.emf.eef.eefnr.navigation.SmartModelNavigationSample;

import org.eclipse.emf.eef.eefnr.navigation.parts.NavigationViewsRepository;
import org.eclipse.emf.eef.eefnr.navigation.parts.SmartNavigationSampleOnglet2PropertiesEditionPart;

import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;

import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;


// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class SmartModelNavigationSampleSmartNavigationSampleOnglet2PropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String SMARTNAVIGATIONSAMPLEONGLET2_PART = "SmartNavigationSampleOnglet2"; //$NON-NLS-1$

	
	/**
	 * Settings for secondMNSingleValueOnglet2 EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings secondMNSingleValueOnglet2Settings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public SmartModelNavigationSampleSmartNavigationSampleOnglet2PropertiesEditionComponent(PropertiesEditingContext editingContext, EObject smartModelNavigationSample, String editing_mode) {
		super(editingContext, smartModelNavigationSample, editing_mode);
		parts = new String[] { SMARTNAVIGATIONSAMPLEONGLET2_PART };
		repositoryKey = NavigationViewsRepository.class;
		partKey = NavigationViewsRepository.SmartNavigationSampleOnglet2.class;
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
			if (editingPart instanceof CompositePropertiesEditionPart) {
				((CompositePropertiesEditionPart) editingPart).getSettings().add(secondMNSingleValueOnglet2Settings);
			}
			final SmartModelNavigationSample smartModelNavigationSample = (SmartModelNavigationSample)elt;
			final SmartNavigationSampleOnglet2PropertiesEditionPart smartNavigationSampleOnglet2Part = (SmartNavigationSampleOnglet2PropertiesEditionPart)editingPart;
			// init values
			// FIXME NO VALID CASE INTO template public updater(editionElement : PropertiesEditionElement, view : View, pec : PropertiesEditionComponent) in widgetControl.mtl module, with the values : secondMNSingleValueOnglet2, SmartNavigationSampleOnglet2, SmartModelNavigationSample.
			// init filters
			
			// init values for referenced views
			
			// init filters for referenced views
			
		}
		setInitializing(false);
	}



	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent#shouldProcess(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 */
	protected boolean shouldProcess(IPropertiesEditionEvent event) {
		if (event.getAffectedEditor() == NavigationViewsRepository.SmartNavigationSampleOnglet2.Properties.secondModelNavigationSingleValueOnglet2) {
			return (secondMNSingleValueOnglet2Settings.getValue() == null) ? (event.getNewValue() != null) : (!secondMNSingleValueOnglet2Settings.getValue().equals(event.getNewValue()));
		}
		return super.shouldProcess(event);
	}	

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
	 */
	public EStructuralFeature associatedFeature(Object editorKey) {
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		SmartModelNavigationSample smartModelNavigationSample = (SmartModelNavigationSample)semanticObject;
		if (NavigationViewsRepository.SmartNavigationSampleOnglet2.Properties.secondModelNavigationSingleValueOnglet2 == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				secondMNSingleValueOnglet2Settings.setToReference((SecondModelNavigation)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				SecondModelNavigation eObject = NavigationFactory.eINSTANCE.createSecondModelNavigation();
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				secondMNSingleValueOnglet2Settings.setToReference(eObject);
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
			SmartNavigationSampleOnglet2PropertiesEditionPart smartNavigationSampleOnglet2Part = (SmartNavigationSampleOnglet2PropertiesEditionPart)editingPart;
			if (NavigationPackage.eINSTANCE.getFirstModelNavigation_SecondModelNavigation().equals(msg.getFeature()) && smartNavigationSampleOnglet2Part != null && isAccessible(NavigationViewsRepository.SmartNavigationSampleOnglet2.Properties.secondModelNavigationSingleValueOnglet2))
				smartNavigationSampleOnglet2Part.setSecondModelNavigationSingleValueOnglet2((EObject)msg.getNewValue());
			
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
			NavigationPackage.eINSTANCE.getFirstModelNavigation_SecondModelNavigation()		);
		return new NotificationFilter[] {filter,};
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
