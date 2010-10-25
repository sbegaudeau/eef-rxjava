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
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.eef.eefnr.EefnrPackage;
import org.eclipse.emf.eef.eefnr.TextSampleWithTwoTabs;
import org.eclipse.emf.eef.eefnr.parts.EefnrViewsRepository;
import org.eclipse.emf.eef.eefnr.parts.TextSampleFirstTabPropertiesEditionPart;
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
public class TextSampleWithTwoTabsTextSampleFirstTabPropertiesEditionComponent extends StandardPropertiesEditionComponent {

	
	public static String TEXTSAMPLEFIRSTTAB_PART = "TextSampleFirstTab"; //$NON-NLS-1$

	
	private String[] parts = {TEXTSAMPLEFIRSTTAB_PART};

	/**
	 * The EObject to edit
	 * 
	 */
	private TextSampleWithTwoTabs textSampleWithTwoTabs;

	/**
	 * The TextSampleFirstTab part
	 * 
	 */
	protected TextSampleFirstTabPropertiesEditionPart textSampleFirstTabPart;
	
	/**
	 * Default constructor
	 * 
	 */
	public TextSampleWithTwoTabsTextSampleFirstTabPropertiesEditionComponent(EObject textSampleWithTwoTabs, String editing_mode) {
		if (textSampleWithTwoTabs instanceof TextSampleWithTwoTabs) {
			this.textSampleWithTwoTabs = (TextSampleWithTwoTabs)textSampleWithTwoTabs;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.textSampleWithTwoTabs.eAdapters().add(semanticAdapter);
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
				if (textSampleFirstTabPart == null)
					TextSampleWithTwoTabsTextSampleFirstTabPropertiesEditionComponent.this.dispose();
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
		if (EefnrPackage.eINSTANCE.getTextSampleWithTwoTabs_TextOptionalPropertyInFirstTab().equals(msg.getFeature()) && textSampleFirstTabPart != null){
			if (msg.getNewValue() != null) {
				textSampleFirstTabPart.setTextOptionalPropertyInFirstTab(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
			} else {
				textSampleFirstTabPart.setTextOptionalPropertyInFirstTab("");
			}
		}
		if (EefnrPackage.eINSTANCE.getTextSampleWithTwoTabs_TextRequiredPropertyInFirstTab().equals(msg.getFeature()) && textSampleFirstTabPart != null){
			if (msg.getNewValue() != null) {
				textSampleFirstTabPart.setTextRequiredPropertyInFirstTab(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
			} else {
				textSampleFirstTabPart.setTextRequiredPropertyInFirstTab("");
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
		if (TEXTSAMPLEFIRSTTAB_PART.equals(key))
			return EefnrViewsRepository.TextSampleFirstTab.class;
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
		if (textSampleWithTwoTabs != null && TEXTSAMPLEFIRSTTAB_PART.equals(key)) {
			if (textSampleFirstTabPart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(EefnrViewsRepository.class);
				if (provider != null) {
					textSampleFirstTabPart = (TextSampleFirstTabPropertiesEditionPart)provider.getPropertiesEditionPart(EefnrViewsRepository.TextSampleFirstTab.class, kind, this);
					addListener((IPropertiesEditionListener)textSampleFirstTabPart);
				}
			}
			return (IPropertiesEditionPart)textSampleFirstTabPart;
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
		if (key == EefnrViewsRepository.TextSampleFirstTab.class)
			this.textSampleFirstTabPart = (TextSampleFirstTabPropertiesEditionPart) propertiesEditionPart;
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
		if (textSampleFirstTabPart != null && key == EefnrViewsRepository.TextSampleFirstTab.class) {
			((IPropertiesEditionPart)textSampleFirstTabPart).setContext(elt, allResource);
			final TextSampleWithTwoTabs textSampleWithTwoTabs = (TextSampleWithTwoTabs)elt;
			// init values
			if (textSampleWithTwoTabs.getTextOptionalPropertyInFirstTab() != null)
				textSampleFirstTabPart.setTextOptionalPropertyInFirstTab(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), textSampleWithTwoTabs.getTextOptionalPropertyInFirstTab()));

			if (textSampleWithTwoTabs.getTextRequiredPropertyInFirstTab() != null)
				textSampleFirstTabPart.setTextRequiredPropertyInFirstTab(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), textSampleWithTwoTabs.getTextRequiredPropertyInFirstTab()));

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
				if (EefnrViewsRepository.TextSampleFirstTab.textOptionalPropertyInFirstTab == event.getAffectedEditor()) {
					updateTextOptionalPropertyInFirstTab((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
				}
				if (EefnrViewsRepository.TextSampleFirstTab.textRequiredPropertyInFirstTab == event.getAffectedEditor()) {
					updateTextRequiredPropertyInFirstTab((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
				}
			}
			else if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				liveEditingDomain.getCommandStack().execute(new StandardEditingCommand() {
					
					public void execute() {
						if (EefnrViewsRepository.TextSampleFirstTab.textOptionalPropertyInFirstTab == event.getAffectedEditor()) {
							updateTextOptionalPropertyInFirstTab((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
						}
						if (EefnrViewsRepository.TextSampleFirstTab.textRequiredPropertyInFirstTab == event.getAffectedEditor()) {
							updateTextRequiredPropertyInFirstTab((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
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

	private void updateTextOptionalPropertyInFirstTab(java.lang.String newValue) {
		textSampleWithTwoTabs.setTextOptionalPropertyInFirstTab(newValue);	
	}

	private void updateTextRequiredPropertyInFirstTab(java.lang.String newValue) {
		textSampleWithTwoTabs.setTextRequiredPropertyInFirstTab(newValue);	
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 * 
	 */
	public boolean isRequired(String key, int kind) {
		return key == EefnrViewsRepository.TextSampleFirstTab.textRequiredPropertyInFirstTab || key == EefnrViewsRepository.TextSampleSecondTab.textRequiredPropertyInSecondTab;
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
				if (EefnrViewsRepository.TextSampleFirstTab.textOptionalPropertyInFirstTab == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EefnrPackage.eINSTANCE.getTextSampleWithTwoTabs_TextOptionalPropertyInFirstTab().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EefnrPackage.eINSTANCE.getTextSampleWithTwoTabs_TextOptionalPropertyInFirstTab().getEAttributeType(), newValue);
				}
				if (EefnrViewsRepository.TextSampleFirstTab.textRequiredPropertyInFirstTab == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EefnrPackage.eINSTANCE.getTextSampleWithTwoTabs_TextRequiredPropertyInFirstTab().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EefnrPackage.eINSTANCE.getTextSampleWithTwoTabs_TextRequiredPropertyInFirstTab().getEAttributeType(), newValue);
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
		validate = EEFRuntimePlugin.getEEFValidator().validate(textSampleWithTwoTabs);
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
			textSampleWithTwoTabs.eAdapters().remove(semanticAdapter);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getTabText(java.lang.String)
	 * 
	 */
	public String getTabText(String p_key) {
		return textSampleFirstTabPart.getTitle();
	}
}
