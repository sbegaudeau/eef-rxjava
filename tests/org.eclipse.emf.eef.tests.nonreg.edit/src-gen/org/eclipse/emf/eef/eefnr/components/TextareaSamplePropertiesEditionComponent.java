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
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.eef.eefnr.EefnrPackage;
import org.eclipse.emf.eef.eefnr.TextareaSample;
import org.eclipse.emf.eef.eefnr.parts.EefnrViewsRepository;
import org.eclipse.emf.eef.eefnr.parts.TextareaSamplePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.notify.PropertiesEditingSemanticLister;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
	

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class TextareaSamplePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	/**
	 * The EObject to edit
	 * 
	 */
	private TextareaSample textareaSample;

	/**
	 * The Base part
	 * 
	 */
	protected TextareaSamplePropertiesEditionPart basePart;
	
	/**
	 * Default constructor
	 * 
	 */
	public TextareaSamplePropertiesEditionComponent(EObject textareaSample, String editing_mode) {
		if (textareaSample instanceof TextareaSample) {
			this.textareaSample = (TextareaSample)textareaSample;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.textareaSample.eAdapters().add(semanticAdapter);
			}
		}
		parts = new String[] { BASE_PART };
		this.editing_mode = editing_mode;
	}

	/**
	 * Initialize the semantic model listener for live editing mode
	 * 
	 * @return the semantic model listener
	 * 
	 */
	private AdapterImpl initializeSemanticAdapter() {
		return new PropertiesEditingSemanticLister(this, (IPropertiesEditionPart)basePart) {
			
			public void runUpdateRunnable(Notification msg) {
						if (EefnrPackage.eINSTANCE.getTextareaSample_TextareaRequiredProperty().equals(msg.getFeature()) && basePart != null){
							if (msg.getNewValue() != null) {
								basePart.setTextareaRequiredProperty(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
							} else {
								basePart.setTextareaRequiredProperty("");
							}
						}
						if (EefnrPackage.eINSTANCE.getTextareaSample_TextareaOptionalProperty().equals(msg.getFeature()) && basePart != null){
							if (msg.getNewValue() != null) {
								basePart.setTextareaOptionalProperty(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
							} else {
								basePart.setTextareaOptionalProperty("");
							}
						}
				
			}
		};
	}
	 
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#translatePart(java.lang.String)
	 * 
	 */
	public java.lang.Class translatePart(String key) {
		if (BASE_PART.equals(key))
			return EefnrViewsRepository.TextareaSample.class;
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
		if (textareaSample != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(EefnrViewsRepository.class);
				if (provider != null) {
					basePart = (TextareaSamplePropertiesEditionPart)provider.getPropertiesEditionPart(EefnrViewsRepository.TextareaSample.class, kind, this);
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
		if (key == EefnrViewsRepository.TextareaSample.class)
			this.basePart = (TextareaSamplePropertiesEditionPart) propertiesEditionPart;
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
		if (basePart != null && key == EefnrViewsRepository.TextareaSample.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			final TextareaSample textareaSample = (TextareaSample)elt;
			// init values
			if (textareaSample.getTextareaRequiredProperty() != null)
				basePart.setTextareaRequiredProperty(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), textareaSample.getTextareaRequiredProperty()));
			if (textareaSample.getTextareaOptionalProperty() != null)
				basePart.setTextareaOptionalProperty(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), textareaSample.getTextareaOptionalProperty()));
			// init filters


		}
		// init values for referenced views

		// init filters for referenced views

		setInitializing(false);
	}





	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 */
	public void updatePart(final IPropertiesEditionEvent event) {
		if (EefnrViewsRepository.TextareaSample.textareaRequiredProperty == event.getAffectedEditor()) {
			textareaSample.setTextareaRequiredProperty((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
		}
		if (EefnrViewsRepository.TextareaSample.textareaOptionalProperty == event.getAffectedEditor()) {
			textareaSample.setTextareaOptionalProperty((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 * 
	 */
	public boolean isRequired(String key, int kind) {
		return key == EefnrViewsRepository.TextareaSample.textareaRequiredProperty;
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
				if (EefnrViewsRepository.TextareaSample.textareaRequiredProperty == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EefnrPackage.eINSTANCE.getTextareaSample_TextareaRequiredProperty().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EefnrPackage.eINSTANCE.getTextareaSample_TextareaRequiredProperty().getEAttributeType(), newValue);
				}
				if (EefnrViewsRepository.TextareaSample.textareaOptionalProperty == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EefnrPackage.eINSTANCE.getTextareaSample_TextareaOptionalProperty().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EefnrPackage.eINSTANCE.getTextareaSample_TextareaOptionalProperty().getEAttributeType(), newValue);
				}
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
		validate = EEFRuntimePlugin.getEEFValidator().validate(textareaSample);
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
			textareaSample.eAdapters().remove(semanticAdapter);
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
