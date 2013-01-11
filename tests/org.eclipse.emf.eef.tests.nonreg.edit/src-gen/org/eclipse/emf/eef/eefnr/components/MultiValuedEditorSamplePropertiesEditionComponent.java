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
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.eef.eefnr.EefnrPackage;
import org.eclipse.emf.eef.eefnr.MultiValuedEditorSample;
import org.eclipse.emf.eef.eefnr.parts.EefnrViewsRepository;
import org.eclipse.emf.eef.eefnr.parts.MultiValuedEditorSamplePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
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
	public MultiValuedEditorSamplePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject multiValuedEditorSample, String editing_mode) {
		super(editingContext, multiValuedEditorSample, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EefnrViewsRepository.class;
		partKey = EefnrViewsRepository.MultiValuedEditorSample.class;
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
			
			final MultiValuedEditorSample multiValuedEditorSample = (MultiValuedEditorSample)elt;
			final MultiValuedEditorSamplePropertiesEditionPart basePart = (MultiValuedEditorSamplePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EefnrViewsRepository.MultiValuedEditorSample.Properties.multivaluededitorRequiredProperty))
				basePart.setMultivaluededitorRequiredProperty(multiValuedEditorSample.getMultivaluededitorRequiredProperty());
			
			if (isAccessible(EefnrViewsRepository.MultiValuedEditorSample.Properties.multivaluededitorOptionalProperty))
				basePart.setMultivaluededitorOptionalProperty(multiValuedEditorSample.getMultivaluededitorOptionalProperty());
			
			if (isAccessible(EefnrViewsRepository.MultiValuedEditorSample.Properties.multivaluededitorROProperty))
				basePart.setMultivaluededitorROProperty(multiValuedEditorSample.getMultivaluededitorROProperty());
			
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
		if (editorKey == EefnrViewsRepository.MultiValuedEditorSample.Properties.multivaluededitorRequiredProperty) {
			return EefnrPackage.eINSTANCE.getMultiValuedEditorSample_MultivaluededitorRequiredProperty();
		}
		if (editorKey == EefnrViewsRepository.MultiValuedEditorSample.Properties.multivaluededitorOptionalProperty) {
			return EefnrPackage.eINSTANCE.getMultiValuedEditorSample_MultivaluededitorOptionalProperty();
		}
		if (editorKey == EefnrViewsRepository.MultiValuedEditorSample.Properties.multivaluededitorROProperty) {
			return EefnrPackage.eINSTANCE.getMultiValuedEditorSample_MultivaluededitorROProperty();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		MultiValuedEditorSample multiValuedEditorSample = (MultiValuedEditorSample)semanticObject;
		if (EefnrViewsRepository.MultiValuedEditorSample.Properties.multivaluededitorRequiredProperty == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				multiValuedEditorSample.getMultivaluededitorRequiredProperty().clear();
				multiValuedEditorSample.getMultivaluededitorRequiredProperty().addAll(((EList) event.getNewValue()));
			}
		}
		if (EefnrViewsRepository.MultiValuedEditorSample.Properties.multivaluededitorOptionalProperty == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				multiValuedEditorSample.getMultivaluededitorOptionalProperty().clear();
				multiValuedEditorSample.getMultivaluededitorOptionalProperty().addAll(((EList) event.getNewValue()));
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
			MultiValuedEditorSamplePropertiesEditionPart basePart = (MultiValuedEditorSamplePropertiesEditionPart)editingPart;
			if (EefnrPackage.eINSTANCE.getMultiValuedEditorSample_MultivaluededitorRequiredProperty().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EefnrViewsRepository.MultiValuedEditorSample.Properties.multivaluededitorRequiredProperty)) {
				if (msg.getNewValue() instanceof EList<?>) {
					basePart.setMultivaluededitorRequiredProperty((EList<?>)msg.getNewValue());
				} else if (msg.getNewValue() == null) {
					basePart.setMultivaluededitorRequiredProperty(new BasicEList<Object>());
				} else {
					BasicEList<Object> newValueAsList = new BasicEList<Object>();
					newValueAsList.add(msg.getNewValue());
					basePart.setMultivaluededitorRequiredProperty(newValueAsList);
				}
			}
			
			if (EefnrPackage.eINSTANCE.getMultiValuedEditorSample_MultivaluededitorOptionalProperty().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EefnrViewsRepository.MultiValuedEditorSample.Properties.multivaluededitorOptionalProperty)) {
				if (msg.getNewValue() instanceof EList<?>) {
					basePart.setMultivaluededitorOptionalProperty((EList<?>)msg.getNewValue());
				} else if (msg.getNewValue() == null) {
					basePart.setMultivaluededitorOptionalProperty(new BasicEList<Object>());
				} else {
					BasicEList<Object> newValueAsList = new BasicEList<Object>();
					newValueAsList.add(msg.getNewValue());
					basePart.setMultivaluededitorOptionalProperty(newValueAsList);
				}
			}
			
			if (EefnrPackage.eINSTANCE.getMultiValuedEditorSample_MultivaluededitorROProperty().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(EefnrViewsRepository.MultiValuedEditorSample.Properties.multivaluededitorROProperty)) {
				if (msg.getNewValue() instanceof EList<?>) {
					basePart.setMultivaluededitorROProperty((EList<?>)msg.getNewValue());
				} else if (msg.getNewValue() == null) {
					basePart.setMultivaluededitorROProperty(new BasicEList<Object>());
				} else {
					BasicEList<Object> newValueAsList = new BasicEList<Object>();
					newValueAsList.add(msg.getNewValue());
					basePart.setMultivaluededitorROProperty(newValueAsList);
				}
			}
			
			
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
			EefnrPackage.eINSTANCE.getMultiValuedEditorSample_MultivaluededitorRequiredProperty(),
			EefnrPackage.eINSTANCE.getMultiValuedEditorSample_MultivaluededitorOptionalProperty(),
			EefnrPackage.eINSTANCE.getMultiValuedEditorSample_MultivaluededitorROProperty()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == EefnrViewsRepository.MultiValuedEditorSample.Properties.multivaluededitorRequiredProperty;
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
				if (EefnrViewsRepository.MultiValuedEditorSample.Properties.multivaluededitorRequiredProperty == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EefnrPackage.eINSTANCE.getMultiValuedEditorSample_MultivaluededitorRequiredProperty().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EefnrViewsRepository.MultiValuedEditorSample.Properties.multivaluededitorOptionalProperty == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EefnrPackage.eINSTANCE.getMultiValuedEditorSample_MultivaluededitorOptionalProperty().getEAttributeType(), iterator.next()));
					}
					ret = chain;
				}
				if (EefnrViewsRepository.MultiValuedEditorSample.Properties.multivaluededitorROProperty == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(EefnrPackage.eINSTANCE.getMultiValuedEditorSample_MultivaluededitorROProperty().getEAttributeType(), iterator.next()));
					}
					ret = chain;
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
