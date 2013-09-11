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
package org.eclipse.emf.eef.eefnr.components;

// Start of user code for imports
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.eef.eefnr.EefnrFactory;
import org.eclipse.emf.eef.eefnr.EefnrPackage;
import org.eclipse.emf.eef.eefnr.LinkEObjectFlatComboViewerSample;
import org.eclipse.emf.eef.eefnr.TextSample;
import org.eclipse.emf.eef.eefnr.TotalSample;

import org.eclipse.emf.eef.eefnr.parts.EefnrViewsRepository;
import org.eclipse.emf.eef.eefnr.parts.LinkEObjectFlatComboViewerSamplePropertiesEditionPart;

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


// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class LinkEObjectFlatComboViewerSamplePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for linkeobjectflatcomboviewerRequiredProperty LinkEObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings linkeobjectflatcomboviewerRequiredPropertySettings;
	
	/**
	 * Settings for linkeobjectflatcomboviewerOptionalProperty LinkEObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings linkeobjectflatcomboviewerOptionalPropertySettings;
	
	/**
	 * Settings for linkeobjectflatcomboviewerROProperty LinkEObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings linkeobjectflatcomboviewerROPropertySettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public LinkEObjectFlatComboViewerSamplePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject linkEObjectFlatComboViewerSample, String editing_mode) {
		super(editingContext, linkEObjectFlatComboViewerSample, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EefnrViewsRepository.class;
		partKey = EefnrViewsRepository.LinkEObjectFlatComboViewerSample.class;
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
			
			final LinkEObjectFlatComboViewerSample linkEObjectFlatComboViewerSample = (LinkEObjectFlatComboViewerSample)elt;
			final LinkEObjectFlatComboViewerSamplePropertiesEditionPart basePart = (LinkEObjectFlatComboViewerSamplePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerRequiredPropery)) {
				// init part
				linkeobjectflatcomboviewerRequiredPropertySettings = new EObjectFlatComboSettings(linkEObjectFlatComboViewerSample, EefnrPackage.eINSTANCE.getLinkEObjectFlatComboViewerSample_LinkeobjectflatcomboviewerRequiredProperty());
				basePart.initLinkeobjectflatcomboviewerRequiredPropery(linkeobjectflatcomboviewerRequiredPropertySettings);
				// set the button mode
				basePart.setLinkeobjectflatcomboviewerRequiredProperyButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerOptionalPropery)) {
				// init part
				linkeobjectflatcomboviewerOptionalPropertySettings = new EObjectFlatComboSettings(linkEObjectFlatComboViewerSample, EefnrPackage.eINSTANCE.getLinkEObjectFlatComboViewerSample_LinkeobjectflatcomboviewerOptionalProperty());
				basePart.initLinkeobjectflatcomboviewerOptionalPropery(linkeobjectflatcomboviewerOptionalPropertySettings);
				// set the button mode
				basePart.setLinkeobjectflatcomboviewerOptionalProperyButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerROPropery)) {
				// init part
				linkeobjectflatcomboviewerROPropertySettings = new EObjectFlatComboSettings(linkEObjectFlatComboViewerSample, EefnrPackage.eINSTANCE.getLinkEObjectFlatComboViewerSample_LinkeobjectflatcomboviewerROPropery());
				basePart.initLinkeobjectflatcomboviewerROPropery(linkeobjectflatcomboviewerROPropertySettings);
				// set the button mode
				basePart.setLinkeobjectflatcomboviewerROProperyButtonMode(ButtonsModeEnum.BROWSE);
			}
			// init filters
			
			
			
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
		if (editorKey == EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerRequiredPropery) {
			return EefnrPackage.eINSTANCE.getLinkEObjectFlatComboViewerSample_LinkeobjectflatcomboviewerRequiredProperty();
		}
		if (editorKey == EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerOptionalPropery) {
			return EefnrPackage.eINSTANCE.getLinkEObjectFlatComboViewerSample_LinkeobjectflatcomboviewerOptionalProperty();
		}
		if (editorKey == EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerROPropery) {
			return EefnrPackage.eINSTANCE.getLinkEObjectFlatComboViewerSample_LinkeobjectflatcomboviewerROPropery();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		LinkEObjectFlatComboViewerSample linkEObjectFlatComboViewerSample = (LinkEObjectFlatComboViewerSample)semanticObject;
		if (EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerRequiredPropery == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				linkeobjectflatcomboviewerRequiredPropertySettings.setToReference((TextSample)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.EDIT) {
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, (EObject) event.getNewValue(), editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt((EObject) event.getNewValue(), PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy editionPolicy = provider.getPolicy(context);
					if (editionPolicy != null) {
						editionPolicy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				TextSample eObject = EefnrFactory.eINSTANCE.createTextSample();
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				linkeobjectflatcomboviewerRequiredPropertySettings.setToReference(eObject);
			}
		}
		if (EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerOptionalPropery == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				linkeobjectflatcomboviewerOptionalPropertySettings.setToReference((TextSample)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.EDIT) {
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, (EObject) event.getNewValue(), editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt((EObject) event.getNewValue(), PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy editionPolicy = provider.getPolicy(context);
					if (editionPolicy != null) {
						editionPolicy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				TextSample eObject = EefnrFactory.eINSTANCE.createTextSample();
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				linkeobjectflatcomboviewerOptionalPropertySettings.setToReference(eObject);
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
			LinkEObjectFlatComboViewerSamplePropertiesEditionPart basePart = (LinkEObjectFlatComboViewerSamplePropertiesEditionPart)editingPart;
			if (EefnrPackage.eINSTANCE.getLinkEObjectFlatComboViewerSample_LinkeobjectflatcomboviewerRequiredProperty().equals(msg.getFeature()) && basePart != null && isAccessible(EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerRequiredPropery))
				basePart.setLinkeobjectflatcomboviewerRequiredPropery((EObject)msg.getNewValue());
			if (EefnrPackage.eINSTANCE.getLinkEObjectFlatComboViewerSample_LinkeobjectflatcomboviewerOptionalProperty().equals(msg.getFeature()) && basePart != null && isAccessible(EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerOptionalPropery))
				basePart.setLinkeobjectflatcomboviewerOptionalPropery((EObject)msg.getNewValue());
			if (EefnrPackage.eINSTANCE.getLinkEObjectFlatComboViewerSample_LinkeobjectflatcomboviewerROPropery().equals(msg.getFeature()) && basePart != null && isAccessible(EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerROPropery))
				basePart.setLinkeobjectflatcomboviewerROPropery((EObject)msg.getNewValue());
			
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
			EefnrPackage.eINSTANCE.getLinkEObjectFlatComboViewerSample_LinkeobjectflatcomboviewerRequiredProperty(),
			EefnrPackage.eINSTANCE.getLinkEObjectFlatComboViewerSample_LinkeobjectflatcomboviewerOptionalProperty(),
			EefnrPackage.eINSTANCE.getLinkEObjectFlatComboViewerSample_LinkeobjectflatcomboviewerROPropery()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == EefnrViewsRepository.LinkEObjectFlatComboViewerSample.Properties.linkeobjectflatcomboviewerRequiredPropery;
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
