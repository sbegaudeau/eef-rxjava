/**
 *  Copyright (c) 2008 - 2010 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Obeo - initial API and implementation
 *
 */
package org.eclipse.emf.eef.mapping.components;

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
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.eef.mapping.filters.FiltersPackage;
import org.eclipse.emf.eef.mapping.filters.OCLFilter;
import org.eclipse.emf.eef.mapping.parts.MappingViewsRepository;
import org.eclipse.emf.eef.mapping.parts.OCLFilterPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.command.StandardEditingCommand;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesValidationEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class OCLFilterBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	private String[] parts = {BASE_PART};

	/**
	 * The EObject to edit
	 * 
	 */
	private OCLFilter oCLFilter;

	/**
	 * The Base part
	 * 
	 */
	protected OCLFilterPropertiesEditionPart basePart;
	
	/**
	 * Default constructor
	 * 
	 */
	public OCLFilterBasePropertiesEditionComponent(EObject oCLFilter, String editing_mode) {
		if (oCLFilter instanceof OCLFilter) {
			this.oCLFilter = (OCLFilter)oCLFilter;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.oCLFilter.eAdapters().add(semanticAdapter);
			}
		}
		this.editing_mode = editing_mode;
	}

	/**
	 * Initialize the semantic model listener for live editing mode
	 * 
	 * @return the semantic model listener
	 * 
	 */
	private AdapterImpl initializeSemanticAdapter() {
		return new EContentAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
			 * 
			 */
			public void notifyChanged(final Notification msg) {
				if (basePart == null)
					OCLFilterBasePropertiesEditionComponent.this.dispose();
				else {
					Runnable updateRunnable = new Runnable() {
						public void run() {
							runUpdateRunnable(msg);
						}
					};
					if (null == Display.getCurrent()) {
						PlatformUI.getWorkbench().getDisplay().syncExec(updateRunnable);
					} else {
						updateRunnable.run();
					}
				}
			}

		};
	}

	/**
	 * Used to update the views
	 * 
	 */
	protected void runUpdateRunnable(final Notification msg) {
		if (FiltersPackage.eINSTANCE.getOCLFilter_OCLBody().equals(msg.getFeature()) && basePart != null){
			if (msg.getNewValue() != null) {
				basePart.setOCLExpressionBody(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
			} else {
				basePart.setOCLExpressionBody("");
			}
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#translatePart(java.lang.String)
	 * 
	 */
	public java.lang.Class translatePart(String key) {
		if (BASE_PART.equals(key))
			return MappingViewsRepository.OCLFilter.class;
		return super.translatePart(key);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#partsList()
	 * 
	 */
	public String[] partsList() {
		return parts;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionPart
	 *  (java.lang.String, java.lang.String)
	 * 
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (oCLFilter != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(MappingViewsRepository.class);
				if (provider != null) {
					basePart = (OCLFilterPropertiesEditionPart)provider.getPropertiesEditionPart(MappingViewsRepository.OCLFilter.class, kind, this);
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
		if (key == MappingViewsRepository.OCLFilter.class)
			this.basePart = (OCLFilterPropertiesEditionPart) propertiesEditionPart;
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
		if (basePart != null && key == MappingViewsRepository.OCLFilter.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			final OCLFilter oCLFilter = (OCLFilter)elt;
			// init values
			if (oCLFilter.getOCLBody() != null)
				basePart.setOCLExpressionBody(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), oCLFilter.getOCLBody()));
			// init filters

		}
		// init values for referenced views

		// init filters for referenced views



		setInitializing(false);
	}






	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void firePropertiesChanged(final IPropertiesEditionEvent event) {
		if (!isInitializing()) {
			Diagnostic valueDiagnostic = validateValue(event);
			if (IPropertiesEditionComponent.BATCH_MODE.equals(editing_mode)) {			
				if (MappingViewsRepository.OCLFilter.oCLExpressionBody == event.getAffectedEditor()) {
					updateOCLExpressionBody((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
				}
			}
			else if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				liveEditingDomain.getCommandStack().execute(new StandardEditingCommand() {
					
					public void execute() {
						if (MappingViewsRepository.OCLFilter.oCLExpressionBody == event.getAffectedEditor()) {
							updateOCLExpressionBody((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
						}
					}
				});			
			}
			if (valueDiagnostic.getSeverity() != Diagnostic.OK && valueDiagnostic instanceof BasicDiagnostic)
				super.firePropertiesChanged(new PropertiesValidationEditionEvent(event, valueDiagnostic));
			else {
				Diagnostic validate = validate();
				super.firePropertiesChanged(new PropertiesValidationEditionEvent(event, validate));
			}
			super.firePropertiesChanged(event);
		}
	}

	private void updateOCLExpressionBody(java.lang.String newValue) {
		oCLFilter.setOCLBody(newValue);	
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
				if (MappingViewsRepository.OCLFilter.oCLExpressionBody == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(FiltersPackage.eINSTANCE.getOCLFilter_OCLBody().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(FiltersPackage.eINSTANCE.getOCLFilter_OCLBody().getEAttributeType(), newValue);
				}
				if (MappingViewsRepository.FilterProperties.name == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(FiltersPackage.eINSTANCE.getBindingFilter_Name().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(FiltersPackage.eINSTANCE.getBindingFilter_Name().getEAttributeType(), newValue);
				}
				if (MappingViewsRepository.FilterProperties.mandatory == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(FiltersPackage.eINSTANCE.getBindingFilter_Mandatory().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(FiltersPackage.eINSTANCE.getBindingFilter_Mandatory().getEAttributeType(), newValue);
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
		validate = EEFRuntimePlugin.getEEFValidator().validate(oCLFilter);
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
			oCLFilter.eAdapters().remove(semanticAdapter);
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
