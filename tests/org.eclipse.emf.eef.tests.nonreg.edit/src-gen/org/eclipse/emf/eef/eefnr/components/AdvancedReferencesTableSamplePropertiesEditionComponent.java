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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.eefnr.AdvancedReferencesTableSample;
import org.eclipse.emf.eef.eefnr.EefnrPackage;
import org.eclipse.emf.eef.eefnr.TotalSample;
import org.eclipse.emf.eef.eefnr.parts.AdvancedReferencesTableSamplePropertiesEditionPart;
import org.eclipse.emf.eef.eefnr.parts.EefnrViewsRepository;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
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
public class AdvancedReferencesTableSamplePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	/**
	 * The EObject to edit
	 * 
	 */
	private AdvancedReferencesTableSample advancedReferencesTableSample;

	/**
	 * The Base part
	 * 
	 */
	protected AdvancedReferencesTableSamplePropertiesEditionPart basePart;
	
	/**
	 * Settings for advancedreferencestableRequiredProperty ReferencesTable
	 */
	private	ReferencesTableSettings advancedreferencestableRequiredPropertySettings;
	
	/**
	 * Settings for advancedreferencestableOptionalProperty ReferencesTable
	 */
	private	ReferencesTableSettings advancedreferencestableOptionalPropertySettings;
	
	/**
	 * Default constructor
	 * 
	 */
	public AdvancedReferencesTableSamplePropertiesEditionComponent(EObject advancedReferencesTableSample, String editing_mode) {
		if (advancedReferencesTableSample instanceof AdvancedReferencesTableSample) {
			this.advancedReferencesTableSample = (AdvancedReferencesTableSample)advancedReferencesTableSample;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter((IPropertiesEditionPart)basePart);
				this.advancedReferencesTableSample.eAdapters().add(semanticAdapter);
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
			return EefnrViewsRepository.AdvancedReferencesTableSample.class;
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
		if (advancedReferencesTableSample != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(EefnrViewsRepository.class);
				if (provider != null) {
					basePart = (AdvancedReferencesTableSamplePropertiesEditionPart)provider.getPropertiesEditionPart(EefnrViewsRepository.AdvancedReferencesTableSample.class, kind, this);
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
		if (key == EefnrViewsRepository.AdvancedReferencesTableSample.class)
			this.basePart = (AdvancedReferencesTableSamplePropertiesEditionPart) propertiesEditionPart;
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
		if (basePart != null && key == EefnrViewsRepository.AdvancedReferencesTableSample.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			final AdvancedReferencesTableSample advancedReferencesTableSample = (AdvancedReferencesTableSample)elt;
			// init values
								advancedreferencestableRequiredPropertySettings = new ReferencesTableSettings(advancedReferencesTableSample, EefnrPackage.eINSTANCE.getAdvancedReferencesTableSample_AdvancedreferencestableRequiredProperty());
								basePart.initAdvancedreferencestableRequiredProperty(advancedreferencestableRequiredPropertySettings);
								advancedreferencestableOptionalPropertySettings = new ReferencesTableSettings(advancedReferencesTableSample, EefnrPackage.eINSTANCE.getAdvancedReferencesTableSample_AdvancedreferencestableOptionalProperty());
								basePart.initAdvancedreferencestableOptionalProperty(advancedreferencestableOptionalPropertySettings);
			// init filters
			basePart.addFilterToAdvancedreferencestableRequiredProperty(new ViewerFilter() {

				/**
				 * {@inheritDoc}
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if (element instanceof EObject)
						return (!basePart.isContainedInAdvancedreferencestableRequiredPropertyTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToAdvancedreferencestableRequiredProperty(new EObjectFilter(EefnrPackage.eINSTANCE.getTotalSample()));
			// Start of user code for additional businessfilters for advancedreferencestableRequiredProperty
			
			// End of user code

			basePart.addFilterToAdvancedreferencestableOptionalProperty(new ViewerFilter() {

				/**
				 * {@inheritDoc}
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if (element instanceof EObject)
						return (!basePart.isContainedInAdvancedreferencestableOptionalPropertyTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToAdvancedreferencestableOptionalProperty(new EObjectFilter(EefnrPackage.eINSTANCE.getTotalSample()));
			// Start of user code for additional businessfilters for advancedreferencestableOptionalProperty
			
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
		if (EefnrViewsRepository.AdvancedReferencesTableSample.advancedreferencestableRequiredProperty == event.getAffectedEditor()) {
				if (event.getKind() == PropertiesEditionEvent.ADD)  {
					if (event.getNewValue() instanceof TotalSample) {
						advancedreferencestableRequiredPropertySettings.addToReference((EObject) event.getNewValue());
					}
				} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
						advancedreferencestableRequiredPropertySettings.removeFromReference((EObject) event.getNewValue());
				}
		}
		if (EefnrViewsRepository.AdvancedReferencesTableSample.advancedreferencestableOptionalProperty == event.getAffectedEditor()) {
				if (event.getKind() == PropertiesEditionEvent.ADD)  {
					if (event.getNewValue() instanceof TotalSample) {
						advancedreferencestableOptionalPropertySettings.addToReference((EObject) event.getNewValue());
					}
				} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
						advancedreferencestableOptionalPropertySettings.removeFromReference((EObject) event.getNewValue());
				}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		if (EefnrPackage.eINSTANCE.getAdvancedReferencesTableSample_AdvancedreferencestableRequiredProperty().equals(msg.getFeature()))
			basePart.updateAdvancedreferencestableRequiredProperty(advancedReferencesTableSample);
		if (EefnrPackage.eINSTANCE.getAdvancedReferencesTableSample_AdvancedreferencestableOptionalProperty().equals(msg.getFeature()))
			basePart.updateAdvancedreferencestableOptionalProperty(advancedReferencesTableSample);
		
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 * 
	 */
	public boolean isRequired(String key, int kind) {
		return key == EefnrViewsRepository.AdvancedReferencesTableSample.advancedreferencestableRequiredProperty;
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
		validate = EEFRuntimePlugin.getEEFValidator().validate(advancedReferencesTableSample);
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
			advancedReferencesTableSample.eAdapters().remove(semanticAdapter);
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
