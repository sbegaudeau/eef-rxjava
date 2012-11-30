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

import org.eclipse.emf.eef.eefnr.EefnrPackage;
import org.eclipse.emf.eef.eefnr.SingleCompositionEditorSample;

import org.eclipse.emf.eef.eefnr.parts.EefnrViewsRepository;
import org.eclipse.emf.eef.eefnr.parts.SingleCompositionEditorSamplePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;

import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;


// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class SingleCompositionEditorSamplePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for singlecompositioneditorRequiredProperty SingleCompositionEditor
	 */
	private EObjectFlatComboSettings singlecompositioneditorRequiredPropertySettings;
	
	/**
	 * Settings for singlecompositioneditorOptionalProperty SingleCompositionEditor
	 */
	private EObjectFlatComboSettings singlecompositioneditorOptionalPropertySettings;
	
	/**
	 * Settings for singlecompositioneditorROProperty SingleCompositionEditor
	 */
	private EObjectFlatComboSettings singlecompositioneditorROPropertySettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public SingleCompositionEditorSamplePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject singleCompositionEditorSample, String editing_mode) {
		super(editingContext, singleCompositionEditorSample, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EefnrViewsRepository.class;
		partKey = EefnrViewsRepository.SingleCompositionEditorSample.class;
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
			
			final SingleCompositionEditorSample singleCompositionEditorSample = (SingleCompositionEditorSample)elt;
			final SingleCompositionEditorSamplePropertiesEditionPart basePart = (SingleCompositionEditorSamplePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EefnrViewsRepository.SingleCompositionEditorSample.Properties.singlecompositionviewerRequiredProperty)) {
				// init part
				singlecompositioneditorRequiredPropertySettings = new EObjectFlatComboSettings(singleCompositionEditorSample, EefnrPackage.eINSTANCE.getSingleCompositionEditorSample_SinglecompositioneditorRequiredProperty());
				basePart.initSinglecompositionviewerRequiredProperty(singlecompositioneditorRequiredPropertySettings);
			}
			if (isAccessible(EefnrViewsRepository.SingleCompositionEditorSample.Properties.singlecompositionviewerOptionalProperty)) {
				// init part
				singlecompositioneditorOptionalPropertySettings = new EObjectFlatComboSettings(singleCompositionEditorSample, EefnrPackage.eINSTANCE.getSingleCompositionEditorSample_SinglecompositioneditorOptionalProperty());
				basePart.initSinglecompositionviewerOptionalProperty(singlecompositioneditorOptionalPropertySettings);
			}
			if (isAccessible(EefnrViewsRepository.SingleCompositionEditorSample.Properties.singlecompositionviewerROProperty)) {
				// init part
				singlecompositioneditorROPropertySettings = new EObjectFlatComboSettings(singleCompositionEditorSample, EefnrPackage.eINSTANCE.getSingleCompositionEditorSample_SinglecompositioneditorROPropery());
				basePart.initSinglecompositionviewerROProperty(singlecompositioneditorROPropertySettings);
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
		if (editorKey == EefnrViewsRepository.SingleCompositionEditorSample.Properties.singlecompositionviewerRequiredProperty) {
			return EefnrPackage.eINSTANCE.getSingleCompositionEditorSample_SinglecompositioneditorRequiredProperty();
		}
		if (editorKey == EefnrViewsRepository.SingleCompositionEditorSample.Properties.singlecompositionviewerOptionalProperty) {
			return EefnrPackage.eINSTANCE.getSingleCompositionEditorSample_SinglecompositioneditorOptionalProperty();
		}
		if (editorKey == EefnrViewsRepository.SingleCompositionEditorSample.Properties.singlecompositionviewerROProperty) {
			return EefnrPackage.eINSTANCE.getSingleCompositionEditorSample_SinglecompositioneditorROPropery();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		SingleCompositionEditorSample singleCompositionEditorSample = (SingleCompositionEditorSample)semanticObject;
		if (EefnrViewsRepository.SingleCompositionEditorSample.Properties.singlecompositionviewerRequiredProperty == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.EDIT) {
				if (singlecompositioneditorRequiredPropertySettings.getValue() == "") {
					EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, singlecompositioneditorRequiredPropertySettings, editingContext.getAdapterFactory());
					PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(editingContext.getEObject(), PropertiesEditingProvider.class);
					Object result = null;
					if (provider != null) {
						PropertiesEditingPolicy policy = provider.getPolicy(context);
						if (policy instanceof CreateEditingPolicy) {
							policy.execute();
							result = ((CreateEditingPolicy) policy).getResult();
						}
					}
					if (result != null) {
						singlecompositioneditorRequiredPropertySettings.setToReference(result);
					}
				} else {
					EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, (EObject) singlecompositioneditorRequiredPropertySettings.getValue(), editingContext.getAdapterFactory());
					PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(singlecompositioneditorRequiredPropertySettings.getValue(), PropertiesEditingProvider.class);
					if (provider != null) {
						PropertiesEditingPolicy policy = provider.getPolicy(context);
						if (policy != null) {
							policy.execute();
						}
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.UNSET) {
				singlecompositioneditorRequiredPropertySettings.setToReference(null);
			}
			
		}
		if (EefnrViewsRepository.SingleCompositionEditorSample.Properties.singlecompositionviewerOptionalProperty == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.EDIT) {
				if (singlecompositioneditorOptionalPropertySettings.getValue() == "") {
					EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, singlecompositioneditorOptionalPropertySettings, editingContext.getAdapterFactory());
					PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(editingContext.getEObject(), PropertiesEditingProvider.class);
					Object result = null;
					if (provider != null) {
						PropertiesEditingPolicy policy = provider.getPolicy(context);
						if (policy instanceof CreateEditingPolicy) {
							policy.execute();
							result = ((CreateEditingPolicy) policy).getResult();
						}
					}
					if (result != null) {
						singlecompositioneditorOptionalPropertySettings.setToReference(result);
					}
				} else {
					EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, (EObject) singlecompositioneditorOptionalPropertySettings.getValue(), editingContext.getAdapterFactory());
					PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(singlecompositioneditorOptionalPropertySettings.getValue(), PropertiesEditingProvider.class);
					if (provider != null) {
						PropertiesEditingPolicy policy = provider.getPolicy(context);
						if (policy != null) {
							policy.execute();
						}
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.UNSET) {
				singlecompositioneditorOptionalPropertySettings.setToReference(null);
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
			SingleCompositionEditorSamplePropertiesEditionPart basePart = (SingleCompositionEditorSamplePropertiesEditionPart)editingPart;
			if (EefnrPackage.eINSTANCE.getSingleCompositionEditorSample_SinglecompositioneditorRequiredProperty().equals(msg.getFeature()) && basePart != null && isAccessible(EefnrViewsRepository.SingleCompositionEditorSample.Properties.singlecompositionviewerRequiredProperty))
				basePart.setSinglecompositionviewerRequiredProperty((EObject)msg.getNewValue());
			if (EefnrPackage.eINSTANCE.getSingleCompositionEditorSample_SinglecompositioneditorOptionalProperty().equals(msg.getFeature()) && basePart != null && isAccessible(EefnrViewsRepository.SingleCompositionEditorSample.Properties.singlecompositionviewerOptionalProperty))
				basePart.setSinglecompositionviewerOptionalProperty((EObject)msg.getNewValue());
			if (EefnrPackage.eINSTANCE.getSingleCompositionEditorSample_SinglecompositioneditorROPropery().equals(msg.getFeature()) && basePart != null && isAccessible(EefnrViewsRepository.SingleCompositionEditorSample.Properties.singlecompositionviewerROProperty))
				basePart.setSinglecompositionviewerROProperty((EObject)msg.getNewValue());
			
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
			EefnrPackage.eINSTANCE.getSingleCompositionEditorSample_SinglecompositioneditorRequiredProperty(),
			EefnrPackage.eINSTANCE.getSingleCompositionEditorSample_SinglecompositioneditorOptionalProperty(),
			EefnrPackage.eINSTANCE.getSingleCompositionEditorSample_SinglecompositioneditorROPropery()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == EefnrViewsRepository.SingleCompositionEditorSample.Properties.singlecompositionviewerRequiredProperty;
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
