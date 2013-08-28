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
import org.eclipse.emf.eef.eefnr.LinkEReferenceViewerSample;
import org.eclipse.emf.eef.eefnr.TextSample;
import org.eclipse.emf.eef.eefnr.TotalSample;

import org.eclipse.emf.eef.eefnr.parts.EefnrViewsRepository;
import org.eclipse.emf.eef.eefnr.parts.LinkEReferenceViewerSamplePropertiesEditionPart;
import org.eclipse.emf.eef.eefnr.parts.impl.LinkEReferenceViewerSamplePropertiesEditionPartImpl;

import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;

import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.context.impl.TypedEReferencePropertiesEditingContext;

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;


// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class LinkEReferenceViewerSamplePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for linkereferenceviewerRequiredProperty LinkEReferenceViewer
	 */
	private EObjectFlatComboSettings linkereferenceviewerRequiredPropertySettings;
	
	/**
	 * Creation Settings for linkereferenceviewerRequiredProperty LinkEReferenceViewer
	 */
	private ReferencesTableSettings linkereferenceviewerRequiredPropertyCreateSettings;
	
	/**
	 * Settings for linkereferenceviewerOptionalProperty LinkEReferenceViewer
	 */
	private EObjectFlatComboSettings linkereferenceviewerOptionalPropertySettings;
	
	/**
	 * Creation Settings for linkereferenceviewerOptionalProperty LinkEReferenceViewer
	 */
	private ReferencesTableSettings linkereferenceviewerOptionalPropertyCreateSettings;
	
	/**
	 * Settings for linkereferenceviewerROProperty LinkEReferenceViewer
	 */
	private EObjectFlatComboSettings linkereferenceviewerROPropertySettings;
	
	/**
	 * Creation Settings for linkereferenceviewerROProperty LinkEReferenceViewer
	 */
	private ReferencesTableSettings linkereferenceviewerROPropertyCreateSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public LinkEReferenceViewerSamplePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject linkEReferenceViewerSample, String editing_mode) {
		super(editingContext, linkEReferenceViewerSample, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EefnrViewsRepository.class;
		partKey = EefnrViewsRepository.LinkEReferenceViewerSample.class;
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
			
			final LinkEReferenceViewerSample linkEReferenceViewerSample = (LinkEReferenceViewerSample)elt;
			final LinkEReferenceViewerSamplePropertiesEditionPart basePart = (LinkEReferenceViewerSamplePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerRequiredPropery)) {
				// init part
				linkereferenceviewerRequiredPropertySettings = new EObjectFlatComboSettings(linkEReferenceViewerSample, EefnrPackage.eINSTANCE.getLinkEReferenceViewerSample_LinkereferenceviewerRequiredProperty());
				linkereferenceviewerRequiredPropertyCreateSettings = new ReferencesTableSettings(getlinkereferenceviewerRequiredPropertyCreateSettingsSource(), EefnrPackage.eINSTANCE.getRoot_Samples());
				basePart.initLinkereferenceviewerRequiredPropery(linkereferenceviewerRequiredPropertySettings);
				// set the button mode
				basePart.setLinkereferenceviewerRequiredProperyButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerOptionalPropery)) {
				// init part
				linkereferenceviewerOptionalPropertySettings = new EObjectFlatComboSettings(linkEReferenceViewerSample, EefnrPackage.eINSTANCE.getLinkEReferenceViewerSample_LinkereferenceviewerOptionalProperty());
				linkereferenceviewerOptionalPropertyCreateSettings = new ReferencesTableSettings(getlinkereferenceviewerOptionalPropertyCreateSettingsSource(), EefnrPackage.eINSTANCE.getRoot_Samples());
				basePart.initLinkereferenceviewerOptionalPropery(linkereferenceviewerOptionalPropertySettings);
				// set the button mode
				basePart.setLinkereferenceviewerOptionalProperyButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerROPropery)) {
				// init part
				linkereferenceviewerROPropertySettings = new EObjectFlatComboSettings(linkEReferenceViewerSample, EefnrPackage.eINSTANCE.getLinkEReferenceViewerSample_LinkereferenceviewerROPropery());
				linkereferenceviewerROPropertyCreateSettings = new ReferencesTableSettings(getlinkereferenceviewerROPropertyCreateSettingsSource(), EefnrPackage.eINSTANCE.getRoot_Samples());
				basePart.initLinkereferenceviewerROPropery(linkereferenceviewerROPropertySettings);
				// set the button mode
				basePart.setLinkereferenceviewerROProperyButtonMode(ButtonsModeEnum.BROWSE);
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
		if (editorKey == EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerRequiredPropery) {
			return EefnrPackage.eINSTANCE.getLinkEReferenceViewerSample_LinkereferenceviewerRequiredProperty();
		}
		if (editorKey == EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerOptionalPropery) {
			return EefnrPackage.eINSTANCE.getLinkEReferenceViewerSample_LinkereferenceviewerOptionalProperty();
		}
		if (editorKey == EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerROPropery) {
			return EefnrPackage.eINSTANCE.getLinkEReferenceViewerSample_LinkereferenceviewerROPropery();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		LinkEReferenceViewerSample linkEReferenceViewerSample = (LinkEReferenceViewerSample)semanticObject;
		if (EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerRequiredPropery == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				linkereferenceviewerRequiredPropertySettings.setToReference((TextSample)event.getNewValue());
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
				TypedEReferencePropertiesEditingContext context = new TypedEReferencePropertiesEditingContext(editingContext, this, linkereferenceviewerRequiredPropertyCreateSettings, EefnrPackage.Literals.TEXT_SAMPLE, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				linkereferenceviewerRequiredPropertySettings.setToReference(context.getEObject());
				((LinkEReferenceViewerSamplePropertiesEditionPart)editingPart).setLinkereferenceviewerRequiredPropery(context.getEObject());
			}
		}
		if (EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerOptionalPropery == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				linkereferenceviewerOptionalPropertySettings.setToReference((TextSample)event.getNewValue());
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
				TypedEReferencePropertiesEditingContext context = new TypedEReferencePropertiesEditingContext(editingContext, this, linkereferenceviewerOptionalPropertyCreateSettings, EefnrPackage.Literals.TEXT_SAMPLE, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				linkereferenceviewerOptionalPropertySettings.setToReference(context.getEObject());
				((LinkEReferenceViewerSamplePropertiesEditionPart)editingPart).setLinkereferenceviewerOptionalPropery(context.getEObject());
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
			LinkEReferenceViewerSamplePropertiesEditionPart basePart = (LinkEReferenceViewerSamplePropertiesEditionPart)editingPart;
			if (EefnrPackage.eINSTANCE.getLinkEReferenceViewerSample_LinkereferenceviewerRequiredProperty().equals(msg.getFeature()) && basePart != null && isAccessible(EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerRequiredPropery))
				basePart.setLinkereferenceviewerRequiredPropery((EObject)msg.getNewValue());
			if (EefnrPackage.eINSTANCE.getLinkEReferenceViewerSample_LinkereferenceviewerOptionalProperty().equals(msg.getFeature()) && basePart != null && isAccessible(EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerOptionalPropery))
				basePart.setLinkereferenceviewerOptionalPropery((EObject)msg.getNewValue());
			if (EefnrPackage.eINSTANCE.getLinkEReferenceViewerSample_LinkereferenceviewerROPropery().equals(msg.getFeature()) && basePart != null && isAccessible(EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerROPropery))
				basePart.setLinkereferenceviewerROPropery((EObject)msg.getNewValue());
			
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
			EefnrPackage.eINSTANCE.getLinkEReferenceViewerSample_LinkereferenceviewerRequiredProperty(),
			EefnrPackage.eINSTANCE.getLinkEReferenceViewerSample_LinkereferenceviewerOptionalProperty(),
			EefnrPackage.eINSTANCE.getLinkEReferenceViewerSample_LinkereferenceviewerROPropery()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == EefnrViewsRepository.LinkEReferenceViewerSample.Properties.linkereferenceviewerRequiredPropery;
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


	

	
	/**
	 * @ return source setting for linkereferenceviewerRequiredPropertyCreateSettings
	 */
	public EObject getlinkereferenceviewerRequiredPropertyCreateSettingsSource() {
		return semanticObject.eContainer();
	}	
	
	/**
	 * @ return source setting for linkereferenceviewerOptionalPropertyCreateSettings
	 */
	public EObject getlinkereferenceviewerOptionalPropertyCreateSettingsSource() {
		return semanticObject.eContainer();
	}	
	
	/**
	 * @ return source setting for linkereferenceviewerROPropertyCreateSettings
	 */
	public EObject getlinkereferenceviewerROPropertyCreateSettingsSource() {
		return semanticObject.eContainer();
	}	
	

}
