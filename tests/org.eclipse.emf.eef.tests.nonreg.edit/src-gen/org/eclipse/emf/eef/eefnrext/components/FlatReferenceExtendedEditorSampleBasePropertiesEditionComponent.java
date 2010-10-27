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
package org.eclipse.emf.eef.eefnrext.components;

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
import org.eclipse.emf.eef.eefnrext.EefnrextPackage;
import org.eclipse.emf.eef.eefnrext.FlatReferenceExtendedEditorSample;
import org.eclipse.emf.eef.eefnrext.parts.EefnrextViewsRepository;
import org.eclipse.emf.eef.eefnrext.parts.FlatReferenceExtendedEditorSamplePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectStrictFilter;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
	

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class FlatReferenceExtendedEditorSampleBasePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for flatReferenceEditorSample ReferencesTable
	 */
	private	ReferencesTableSettings flatReferenceEditorSampleSettings;
	
	/**
	 * Default constructor
	 * 
	 */
	public FlatReferenceExtendedEditorSampleBasePropertiesEditionComponent(EObject flatReferenceExtendedEditorSample, String editing_mode) {
		super(flatReferenceExtendedEditorSample, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EefnrextViewsRepository.class;
		partKey = EefnrextViewsRepository.FlatReferenceExtendedEditorSample.class;
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
			final FlatReferenceExtendedEditorSample flatReferenceExtendedEditorSample = (FlatReferenceExtendedEditorSample)elt;
			final FlatReferenceExtendedEditorSamplePropertiesEditionPart basePart = (FlatReferenceExtendedEditorSamplePropertiesEditionPart)editingPart;
			// init values
			flatReferenceEditorSampleSettings = new ReferencesTableSettings(flatReferenceExtendedEditorSample, EefnrextPackage.eINSTANCE.getFlatReferenceExtendedEditorSample_FlatReferenceEditorSample());
			basePart.initFlatReferenceEditorSample(flatReferenceEditorSampleSettings);
			// init filters
			basePart.addFilterToFlatReferenceEditorSample(new ViewerFilter() {
			
				/**
				 * {@inheritDoc}
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if (element instanceof EObject)
						return (!basePart.isContainedInFlatReferenceEditorSampleTable((EObject)element));
					return element instanceof String && element.equals("");
				}
			
			});
			basePart.addFilterToFlatReferenceEditorSample(new EObjectStrictFilter(EefnrPackage.eINSTANCE.getAbstractSample()));
			// Start of user code for additional businessfilters for flatReferenceEditorSample
												
												// End of user code
			
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
		FlatReferenceExtendedEditorSample flatReferenceExtendedEditorSample = (FlatReferenceExtendedEditorSample)semanticObject;
		if (EefnrextViewsRepository.FlatReferenceExtendedEditorSample.flatReferenceEditorSample == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET)
				flatReferenceEditorSampleSettings.setToReference((List<EObject>) event.getNewValue());
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		FlatReferenceExtendedEditorSamplePropertiesEditionPart basePart = (FlatReferenceExtendedEditorSamplePropertiesEditionPart)editingPart;
		if (EefnrextPackage.eINSTANCE.getFlatReferenceExtendedEditorSample_FlatReferenceEditorSample().equals(msg.getFeature()))
			basePart.updateFlatReferenceEditorSample();
		
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 * 
	 */
	public boolean isRequired(String key, int kind) {
		return key == EefnrextViewsRepository.SecondFlatReferenceExtendedEditorSample.demo;
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
				if (EefnrextViewsRepository.CheckBoxExtendedEditorSample.checkboxEditorSample == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EefnrextPackage.eINSTANCE.getCheckBoxExtendedEditorSample_CheckboxEditorSample().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EefnrextPackage.eINSTANCE.getCheckBoxExtendedEditorSample_CheckboxEditorSample().getEAttributeType(), newValue);
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
