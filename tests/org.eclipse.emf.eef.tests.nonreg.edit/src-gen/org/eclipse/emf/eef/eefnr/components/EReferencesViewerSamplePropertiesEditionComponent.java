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
import org.eclipse.emf.eef.eefnr.EReferencesViewerSample;
import org.eclipse.emf.eef.eefnr.EefnrPackage;
import org.eclipse.emf.eef.eefnr.TotalSample;
import org.eclipse.emf.eef.eefnr.parts.EReferencesViewerSamplePropertiesEditionPart;
import org.eclipse.emf.eef.eefnr.parts.EefnrViewsRepository;
import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;


// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class EReferencesViewerSamplePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for ereferencesviewerRequiredProperty EReferencesViewer
	 */
	private ReferencesTableSettings ereferencesviewerRequiredPropertySettings;
	
	/**
	 * Settings for advancedreferencestableOptionalProperty EReferencesViewer
	 */
	private ReferencesTableSettings advancedreferencestableOptionalPropertySettings;
	
	/**
	 * Settings for ereferencesviewerROProperty EReferencesViewer
	 */
	private ReferencesTableSettings ereferencesviewerROPropertySettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public EReferencesViewerSamplePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject eReferencesViewerSample, String editing_mode) {
		super(editingContext, eReferencesViewerSample, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EefnrViewsRepository.class;
		partKey = EefnrViewsRepository.EReferencesViewerSample.class;
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
			
			final EReferencesViewerSample eReferencesViewerSample = (EReferencesViewerSample)elt;
			final EReferencesViewerSamplePropertiesEditionPart basePart = (EReferencesViewerSamplePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerRequiredProperty)) {
				ereferencesviewerRequiredPropertySettings = new ReferencesTableSettings(eReferencesViewerSample, EefnrPackage.eINSTANCE.getEReferencesViewerSample_EreferencesviewerRequiredProperty());
				basePart.initEreferencesviewerRequiredProperty(ereferencesviewerRequiredPropertySettings);
			}
			if (isAccessible(EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerOptionalProperty)) {
				advancedreferencestableOptionalPropertySettings = new ReferencesTableSettings(eReferencesViewerSample, EefnrPackage.eINSTANCE.getEReferencesViewerSample_EreferencesviewerOptionalProperty());
				basePart.initEreferencesviewerOptionalProperty(advancedreferencestableOptionalPropertySettings);
			}
			if (isAccessible(EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerROProperty)) {
				ereferencesviewerROPropertySettings = new ReferencesTableSettings(eReferencesViewerSample, EefnrPackage.eINSTANCE.getEReferencesViewerSample_EreferencesviewerROProperty());
				basePart.initEreferencesviewerROProperty(ereferencesviewerROPropertySettings);
			}
			// init filters
			if (isAccessible(EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerRequiredProperty)) {
				basePart.addFilterToEreferencesviewerRequiredProperty(new EObjectFilter(EefnrPackage.Literals.TOTAL_SAMPLE));
				// Start of user code for additional businessfilters for ereferencesviewerRequiredProperty
				// End of user code
			}
			if (isAccessible(EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerOptionalProperty)) {
				basePart.addFilterToEreferencesviewerOptionalProperty(new EObjectFilter(EefnrPackage.Literals.TOTAL_SAMPLE));
				// Start of user code for additional businessfilters for advancedreferencestableOptionalProperty
				// End of user code
			}
			if (isAccessible(EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerROProperty)) {
				basePart.addFilterToEreferencesviewerROProperty(new EObjectFilter(EefnrPackage.Literals.TOTAL_SAMPLE));
				// Start of user code for additional businessfilters for ereferencesviewerROProperty
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
		if (editorKey == EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerRequiredProperty) {
			return EefnrPackage.eINSTANCE.getEReferencesViewerSample_EreferencesviewerRequiredProperty();
		}
		if (editorKey == EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerOptionalProperty) {
			return EefnrPackage.eINSTANCE.getEReferencesViewerSample_EreferencesviewerOptionalProperty();
		}
		if (editorKey == EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerROProperty) {
			return EefnrPackage.eINSTANCE.getEReferencesViewerSample_EreferencesviewerROProperty();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		EReferencesViewerSample eReferencesViewerSample = (EReferencesViewerSample)semanticObject;
		if (EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerRequiredProperty == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof TotalSample) {
					ereferencesviewerRequiredPropertySettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				ereferencesviewerRequiredPropertySettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				ereferencesviewerRequiredPropertySettings.move(event.getNewIndex(), (TotalSample) event.getNewValue());
			}
		}
		if (EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerOptionalProperty == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof TotalSample) {
					advancedreferencestableOptionalPropertySettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				advancedreferencestableOptionalPropertySettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				advancedreferencestableOptionalPropertySettings.move(event.getNewIndex(), (TotalSample) event.getNewValue());
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
			EReferencesViewerSamplePropertiesEditionPart basePart = (EReferencesViewerSamplePropertiesEditionPart)editingPart;
			if (EefnrPackage.eINSTANCE.getEReferencesViewerSample_EreferencesviewerRequiredProperty().equals(msg.getFeature())  && isAccessible(EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerRequiredProperty))
				basePart.updateEreferencesviewerRequiredProperty();
			if (EefnrPackage.eINSTANCE.getEReferencesViewerSample_EreferencesviewerOptionalProperty().equals(msg.getFeature())  && isAccessible(EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerOptionalProperty))
				basePart.updateEreferencesviewerOptionalProperty();
			if (EefnrPackage.eINSTANCE.getEReferencesViewerSample_EreferencesviewerROProperty().equals(msg.getFeature())  && isAccessible(EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerROProperty))
				basePart.updateEreferencesviewerROProperty();
			
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
			EefnrPackage.eINSTANCE.getEReferencesViewerSample_EreferencesviewerRequiredProperty(),
			EefnrPackage.eINSTANCE.getEReferencesViewerSample_EreferencesviewerOptionalProperty(),
			EefnrPackage.eINSTANCE.getEReferencesViewerSample_EreferencesviewerROProperty()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == EefnrViewsRepository.EReferencesViewerSample.Properties.ereferencesviewerRequiredProperty;
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
