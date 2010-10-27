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
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.eefnr.AdvancedTableCompositionEditorSample;
import org.eclipse.emf.eef.eefnr.EefnrPackage;
import org.eclipse.emf.eef.eefnr.Sample;
import org.eclipse.emf.eef.eefnr.parts.AdvancedTableCompositionEditorSamplePropertiesEditionPart;
import org.eclipse.emf.eef.eefnr.parts.EefnrViewsRepository;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
	

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class AdvancedTableCompositionEditorSamplePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	/**
	 * The EObject to edit
	 * 
	 */
	private AdvancedTableCompositionEditorSample advancedTableCompositionEditorSample;

	/**
	 * The Base part
	 * 
	 */
	protected AdvancedTableCompositionEditorSamplePropertiesEditionPart basePart;
	
	/**
	 * Settings for advancedtablecompositionRequiredProperty ReferencesTable
	 */
	private	ReferencesTableSettings advancedtablecompositionRequiredPropertySettings;
	
	/**
	 * Settings for advancedtablecompositionOptionalProperty ReferencesTable
	 */
	private	ReferencesTableSettings advancedtablecompositionOptionalPropertySettings;
	
	/**
	 * Default constructor
	 * 
	 */
	public AdvancedTableCompositionEditorSamplePropertiesEditionComponent(EObject advancedTableCompositionEditorSample, String editing_mode) {
		if (advancedTableCompositionEditorSample instanceof AdvancedTableCompositionEditorSample) {
			this.advancedTableCompositionEditorSample = (AdvancedTableCompositionEditorSample)advancedTableCompositionEditorSample;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter((IPropertiesEditionPart)basePart);
				this.advancedTableCompositionEditorSample.eAdapters().add(semanticAdapter);
			}
		}
		parts = new String[] { BASE_PART };
		this.editing_mode = editing_mode;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#translatePart(java.lang.String)
	 * 
	 */
	public java.lang.Class translatePart(String key) {
		if (BASE_PART.equals(key))
			return EefnrViewsRepository.AdvancedTableCompositionEditorSample.class;
		return super.translatePart(key);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionPart
	 *  (java.lang.String, java.lang.String)
	 * 
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (advancedTableCompositionEditorSample != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(EefnrViewsRepository.class);
				if (provider != null) {
					basePart = (AdvancedTableCompositionEditorSamplePropertiesEditionPart)provider.getPropertiesEditionPart(EefnrViewsRepository.AdvancedTableCompositionEditorSample.class, kind, this);
					addListener((IPropertiesEditionListener)basePart);
				}
			}
			return (IPropertiesEditionPart)basePart;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#
	 *      setPropertiesEditionPart(java.lang.Class, int, org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart)
	 * 
	 */
	public void setPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionPart propertiesEditionPart) {
		if (key == EefnrViewsRepository.AdvancedTableCompositionEditorSample.class)
			this.basePart = (AdvancedTableCompositionEditorSamplePropertiesEditionPart) propertiesEditionPart;
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
		if (basePart != null && key == EefnrViewsRepository.AdvancedTableCompositionEditorSample.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			final AdvancedTableCompositionEditorSample advancedTableCompositionEditorSample = (AdvancedTableCompositionEditorSample)elt;
			// init values
								advancedtablecompositionRequiredPropertySettings = new ReferencesTableSettings(advancedTableCompositionEditorSample, EefnrPackage.eINSTANCE.getAdvancedTableCompositionEditorSample_AdvancedtablecompositionRequiredProperty());
								basePart.initAdvancedtablecompositionRequiredProperty(advancedtablecompositionRequiredPropertySettings);
								advancedtablecompositionOptionalPropertySettings = new ReferencesTableSettings(advancedTableCompositionEditorSample, EefnrPackage.eINSTANCE.getAdvancedTableCompositionEditorSample_AdvancedtablecompositionOptionalProperty());
								basePart.initAdvancedtablecompositionOptionalProperty(advancedtablecompositionOptionalPropertySettings);
			// init filters
			basePart.addFilterToAdvancedtablecompositionRequiredProperty(new ViewerFilter() {

					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof Sample);
				}

			});
			// Start of user code for additional businessfilters for advancedtablecompositionRequiredProperty
			
			// End of user code

			basePart.addFilterToAdvancedtablecompositionOptionalProperty(new ViewerFilter() {

					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Sample); //$NON-NLS-1$ 
				}

			});
			// Start of user code for additional businessfilters for advancedtablecompositionOptionalProperty
			
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
		if (EefnrViewsRepository.AdvancedTableCompositionEditorSample.advancedtablecompositionRequiredProperty == event.getAffectedEditor()) {
				if (event.getKind() == PropertiesEditionEvent.ADD)  {
					if (event.getNewValue() instanceof Sample) {
						advancedtablecompositionRequiredPropertySettings.addToReference((EObject) event.getNewValue());
					}
				} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
						advancedtablecompositionRequiredPropertySettings.removeFromReference((EObject) event.getNewValue());
				}
		}
		if (EefnrViewsRepository.AdvancedTableCompositionEditorSample.advancedtablecompositionOptionalProperty == event.getAffectedEditor()) {
				if (event.getKind() == PropertiesEditionEvent.ADD)  {
					if (event.getNewValue() instanceof Sample) {
						advancedtablecompositionOptionalPropertySettings.addToReference((EObject) event.getNewValue());
					}
				} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
						advancedtablecompositionOptionalPropertySettings.removeFromReference((EObject) event.getNewValue());
				}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		if (EefnrPackage.eINSTANCE.getAdvancedTableCompositionEditorSample_AdvancedtablecompositionRequiredProperty().equals(msg.getFeature()))
			basePart.updateAdvancedtablecompositionRequiredProperty(advancedTableCompositionEditorSample);
		if (EefnrPackage.eINSTANCE.getAdvancedTableCompositionEditorSample_AdvancedtablecompositionOptionalProperty().equals(msg.getFeature()))
			basePart.updateAdvancedtablecompositionOptionalProperty(advancedTableCompositionEditorSample);
		
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 * 
	 */
	public boolean isRequired(String key, int kind) {
		return key == EefnrViewsRepository.AdvancedTableCompositionEditorSample.advancedtablecompositionRequiredProperty;
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
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validate()
	 * 
	 */
	public Diagnostic validate() {
		Diagnostic validate = Diagnostic.OK_INSTANCE;
		validate = EEFRuntimePlugin.getEEFValidator().validate(advancedTableCompositionEditorSample);
		// Start of user code for custom validation check
		
		// End of user code
		return validate;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#dispose()
	 * 
	 */
	public void dispose() {
		if (semanticAdapter != null)
			advancedTableCompositionEditorSample.eAdapters().remove(semanticAdapter);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getTabText(java.lang.String)
	 * 
	 */
	public String getTabText(String p_key) {
		return basePart.getTitle();
	}
}
