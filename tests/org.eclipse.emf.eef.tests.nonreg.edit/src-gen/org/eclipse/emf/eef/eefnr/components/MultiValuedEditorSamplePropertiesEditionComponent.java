/*******************************************************************************
 * Copyright (c) 2009 - 2010 Obeo.
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
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.eef.eefnr.EefnrPackage;
import org.eclipse.emf.eef.eefnr.MultiValuedEditorSample;
import org.eclipse.emf.eef.eefnr.parts.EefnrViewsRepository;
import org.eclipse.emf.eef.eefnr.parts.MultiValuedEditorSamplePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
	

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class MultiValuedEditorSamplePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Default constructor
	 * 
	 */
	public MultiValuedEditorSamplePropertiesEditionComponent(EObject multiValuedEditorSample, String editing_mode) {
		super(multiValuedEditorSample, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EefnrViewsRepository.class;
		partKey = EefnrViewsRepository.MultiValuedEditorSample.class;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		setInitializing(true);
		if (editingPart != null && key == partKey) {
			editingPart.setContext(elt, allResource);
			final MultiValuedEditorSample multiValuedEditorSample = (MultiValuedEditorSample)elt;
			final MultiValuedEditorSamplePropertiesEditionPart basePart = (MultiValuedEditorSamplePropertiesEditionPart)editingPart;
			// init values
			if (multiValuedEditorSample.getMultivaluededitorRequiredProperty() != null)
				basePart.setMultivaluededitorRequiredProperty(multiValuedEditorSample.getMultivaluededitorRequiredProperty());
			
			if (multiValuedEditorSample.getMultivaluededitorOptionalProperty() != null)
				basePart.setMultivaluededitorOptionalProperty(multiValuedEditorSample.getMultivaluededitorOptionalProperty());
			
			// init filters
			
			
		}
		// init values for referenced views
		
		// init filters for referenced views
		
		setInitializing(false);
	}





	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		MultiValuedEditorSample multiValuedEditorSample = (MultiValuedEditorSample)semanticObject;
		if (EefnrViewsRepository.MultiValuedEditorSample.multivaluededitorRequiredProperty == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				multiValuedEditorSample.getMultivaluededitorRequiredProperty().clear();
				multiValuedEditorSample.getMultivaluededitorRequiredProperty().addAll(((List) event.getNewValue()));
			}
		}
		if (EefnrViewsRepository.MultiValuedEditorSample.multivaluededitorOptionalProperty == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				multiValuedEditorSample.getMultivaluededitorOptionalProperty().clear();
				multiValuedEditorSample.getMultivaluededitorOptionalProperty().addAll(((List) event.getNewValue()));
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		MultiValuedEditorSamplePropertiesEditionPart basePart = (MultiValuedEditorSamplePropertiesEditionPart)editingPart;
		if (EefnrPackage.eINSTANCE.getMultiValuedEditorSample_MultivaluededitorRequiredProperty().equals(msg.getFeature()) && basePart != null) {
			if (msg.getEventType() == Notification.ADD) 
				basePart.addToMultivaluededitorRequiredProperty((java.lang.String) msg.getNewValue());
			else if (msg.getEventType() == Notification.REMOVE) 
				basePart.removeToMultivaluededitorRequiredProperty((java.lang.String) msg.getNewValue());
		}
		
		if (EefnrPackage.eINSTANCE.getMultiValuedEditorSample_MultivaluededitorOptionalProperty().equals(msg.getFeature()) && basePart != null) {
			if (msg.getEventType() == Notification.ADD) 
				basePart.addToMultivaluededitorOptionalProperty((java.lang.String) msg.getNewValue());
			else if (msg.getEventType() == Notification.REMOVE) 
				basePart.removeToMultivaluededitorOptionalProperty((java.lang.String) msg.getNewValue());
		}
		
		
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 * 
	 */
	public boolean isRequired(String key, int kind) {
		return key == EefnrViewsRepository.MultiValuedEditorSample.multivaluededitorRequiredProperty;
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
			String newStringValue = event.getNewValue().toString();
			try {
				if (EefnrViewsRepository.MultiValuedEditorSample.multivaluededitorRequiredProperty == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EefnrPackage.eINSTANCE.getMultiValuedEditorSample_MultivaluededitorRequiredProperty().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EefnrPackage.eINSTANCE.getMultiValuedEditorSample_MultivaluededitorRequiredProperty().getEAttributeType(), newValue);
				}
				if (EefnrViewsRepository.MultiValuedEditorSample.multivaluededitorOptionalProperty == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EefnrPackage.eINSTANCE.getMultiValuedEditorSample_MultivaluededitorOptionalProperty().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EefnrPackage.eINSTANCE.getMultiValuedEditorSample_MultivaluededitorOptionalProperty().getEAttributeType(), newValue);
				}
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}

}
