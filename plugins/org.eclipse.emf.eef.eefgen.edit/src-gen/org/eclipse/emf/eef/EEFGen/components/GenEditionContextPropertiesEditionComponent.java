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
package org.eclipse.emf.eef.EEFGen.components;

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
import org.eclipse.emf.eef.EEFGen.EEFGenPackage;
import org.eclipse.emf.eef.EEFGen.GenEditionContext;
import org.eclipse.emf.eef.EEFGen.parts.EEFGenViewsRepository;
import org.eclipse.emf.eef.EEFGen.parts.GenEditionContextPropertiesEditionPart;
import org.eclipse.emf.eef.components.PropertiesEditionContext;
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
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class GenEditionContextPropertiesEditionComponent extends StandardPropertiesEditionComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	private String[] parts = {BASE_PART};

	/**
	 * The EObject to edit
	 * 
	 */
	private GenEditionContext genEditionContext;

	/**
	 * The Base part
	 * 
	 */
	protected GenEditionContextPropertiesEditionPart basePart;
	
	/**
	 * Default constructor
	 * 
	 */
	public GenEditionContextPropertiesEditionComponent(EObject genEditionContext, String editing_mode) {
		if (genEditionContext instanceof GenEditionContext) {
			this.genEditionContext = (GenEditionContext)genEditionContext;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.genEditionContext.eAdapters().add(semanticAdapter);
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
					GenEditionContextPropertiesEditionComponent.this.dispose();
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
		if (EEFGenPackage.eINSTANCE.getGenEditionContext_BasePackage().equals(msg.getFeature()) && basePart != null){
			if (msg.getNewValue() != null) {
				basePart.setBasePackage(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
			} else {
				basePart.setBasePackage("");
			}
		}
		if (EEFGenPackage.eINSTANCE.getGenEditionContext_DescriptorsContributorID().equals(msg.getFeature()) && basePart != null){
			if (msg.getNewValue() != null) {
				basePart.setDescriptorsContributorID(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
			} else {
				basePart.setDescriptorsContributorID("");
			}
		}
		if (EEFGenPackage.eINSTANCE.getGenEditionContext_DescriptorsGenericPropertiesViews().equals(msg.getFeature()) && basePart != null)
			basePart.setGenericPropertiesViewsDescriptors((Boolean)msg.getNewValue());

		if (EEFGenPackage.eINSTANCE.getGenEditionContext_GmfPropertiesViews().equals(msg.getFeature()) && basePart != null)
			basePart.setGMFSpecificPropertiesViews((Boolean)msg.getNewValue());

		if (EEFGenPackage.eINSTANCE.getGenEditionContext_PropertiesEditionContext().equals(msg.getFeature()) && basePart != null)
			basePart.setPropertiesEditionContext((EObject)msg.getNewValue());
		if (EEFGenPackage.eINSTANCE.getGenEditionContext_GenerateJunitTestCases().equals(msg.getFeature()) && basePart != null)
			basePart.setJUnitTestCases((Boolean)msg.getNewValue());


	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#translatePart(java.lang.String)
	 * 
	 */
	public java.lang.Class translatePart(String key) {
		if (BASE_PART.equals(key))
			return EEFGenViewsRepository.GenEditionContext.class;
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
		if (genEditionContext != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(EEFGenViewsRepository.class);
				if (provider != null) {
					basePart = (GenEditionContextPropertiesEditionPart)provider.getPropertiesEditionPart(EEFGenViewsRepository.GenEditionContext.class, kind, this);
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
		if (key == EEFGenViewsRepository.GenEditionContext.class)
			this.basePart = (GenEditionContextPropertiesEditionPart) propertiesEditionPart;
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
		if (basePart != null && key == EEFGenViewsRepository.GenEditionContext.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			final GenEditionContext genEditionContext = (GenEditionContext)elt;
			// init values
			if (genEditionContext.getBasePackage() != null)
				basePart.setBasePackage(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), genEditionContext.getBasePackage()));

			if (genEditionContext.getDescriptorsContributorID() != null)
				basePart.setDescriptorsContributorID(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), genEditionContext.getDescriptorsContributorID()));

			basePart.setGenericPropertiesViewsDescriptors(genEditionContext.isDescriptorsGenericPropertiesViews());

			basePart.setGMFSpecificPropertiesViews(genEditionContext.isGmfPropertiesViews());

			// init part
			basePart.initPropertiesEditionContext(allResource, genEditionContext.getPropertiesEditionContext());
			// set the button mode
			basePart.setPropertiesEditionContextButtonMode(ButtonsModeEnum.BROWSE);
			basePart.setJUnitTestCases(genEditionContext.isGenerateJunitTestCases());

			// init filters




			basePart.addFilterToPropertiesEditionContext(new ViewerFilter() {

				/**
				 * {@inheritDoc}
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof PropertiesEditionContext);
				}

			});
			// Start of user code for additional businessfilters for propertiesEditionContext
			
			// End of user code


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
				if (EEFGenViewsRepository.GenEditionContext.basePackage == event.getAffectedEditor()) {
					updateBasePackage((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
				}
				if (EEFGenViewsRepository.GenEditionContext.descriptorsContributorID == event.getAffectedEditor()) {
					updateDescriptorsContributorID((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
				}
				if (EEFGenViewsRepository.GenEditionContext.genericPropertiesViewsDescriptors == event.getAffectedEditor()) {
					updateDescriptorsGenericPropertiesViews((Boolean)event.getNewValue());
				}
				if (EEFGenViewsRepository.GenEditionContext.gMFSpecificPropertiesViews == event.getAffectedEditor()) {
					updateGmfPropertiesViews((Boolean)event.getNewValue());
				}
				if (EEFGenViewsRepository.GenEditionContext.propertiesEditionContext == event.getAffectedEditor()) {
					updatePropertiesEditionContext((PropertiesEditionContext)event.getNewValue());
				}
				if (EEFGenViewsRepository.GenEditionContext.jUnitTestCases == event.getAffectedEditor()) {
					updateJunitTestCases((Boolean)event.getNewValue());
				}
			}
			else if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				liveEditingDomain.getCommandStack().execute(new StandardEditingCommand() {
					
					public void execute() {
						if (EEFGenViewsRepository.GenEditionContext.basePackage == event.getAffectedEditor()) {
							updateBasePackage((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
						}
						if (EEFGenViewsRepository.GenEditionContext.descriptorsContributorID == event.getAffectedEditor()) {
							updateDescriptorsContributorID((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
						}
						if (EEFGenViewsRepository.GenEditionContext.genericPropertiesViewsDescriptors == event.getAffectedEditor()) {
							updateDescriptorsGenericPropertiesViews((Boolean)event.getNewValue());
						}
						if (EEFGenViewsRepository.GenEditionContext.gMFSpecificPropertiesViews == event.getAffectedEditor()) {
							updateGmfPropertiesViews((Boolean)event.getNewValue());
						}
						if (EEFGenViewsRepository.GenEditionContext.propertiesEditionContext == event.getAffectedEditor()) {
							updatePropertiesEditionContext((PropertiesEditionContext)event.getNewValue());
						}
						if (EEFGenViewsRepository.GenEditionContext.jUnitTestCases == event.getAffectedEditor()) {
							updateJunitTestCases((Boolean)event.getNewValue());
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

	private void updateBasePackage(java.lang.String newValue) {
		genEditionContext.setBasePackage(newValue);	
	}

	private void updateDescriptorsContributorID(java.lang.String newValue) {
		genEditionContext.setDescriptorsContributorID(newValue);	
	}

	private void updateDescriptorsGenericPropertiesViews(Boolean newValue) {
		genEditionContext.setDescriptorsGenericPropertiesViews(newValue);	
	}

	private void updateGmfPropertiesViews(Boolean newValue) {
		genEditionContext.setGmfPropertiesViews(newValue);	
	}

	private void updatePropertiesEditionContext(PropertiesEditionContext newValue) {
		genEditionContext.setPropertiesEditionContext(newValue);	
	}

	private void updateJunitTestCases(Boolean newValue) {
		genEditionContext.setGenerateJunitTestCases(newValue);	
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 * 
	 */
	public boolean isRequired(String key, int kind) {
		return key == EEFGenViewsRepository.GenEditionContext.propertiesEditionContext;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 * 
	 */
	public String getHelpContent(String key, int kind) {
		if (key == EEFGenViewsRepository.GenEditionContext.basePackage)
			return "The base package for all the generated code"; //$NON-NLS-1$
		if (key == EEFGenViewsRepository.GenEditionContext.propertiesEditionContext)
			return "The PropertiesEditioContext to describe"; //$NON-NLS-1$
		return super.getHelpContent(key, kind);
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
				if (EEFGenViewsRepository.GenEditionContext.basePackage == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EEFGenPackage.eINSTANCE.getGenEditionContext_BasePackage().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EEFGenPackage.eINSTANCE.getGenEditionContext_BasePackage().getEAttributeType(), newValue);
				}
				if (EEFGenViewsRepository.GenEditionContext.descriptorsContributorID == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EEFGenPackage.eINSTANCE.getGenEditionContext_DescriptorsContributorID().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EEFGenPackage.eINSTANCE.getGenEditionContext_DescriptorsContributorID().getEAttributeType(), newValue);
				}
				if (EEFGenViewsRepository.GenEditionContext.genericPropertiesViewsDescriptors == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EEFGenPackage.eINSTANCE.getGenEditionContext_DescriptorsGenericPropertiesViews().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EEFGenPackage.eINSTANCE.getGenEditionContext_DescriptorsGenericPropertiesViews().getEAttributeType(), newValue);
				}
				if (EEFGenViewsRepository.GenEditionContext.gMFSpecificPropertiesViews == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EEFGenPackage.eINSTANCE.getGenEditionContext_GmfPropertiesViews().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EEFGenPackage.eINSTANCE.getGenEditionContext_GmfPropertiesViews().getEAttributeType(), newValue);
				}
				if (EEFGenViewsRepository.GenEditionContext.jUnitTestCases == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EEFGenPackage.eINSTANCE.getGenEditionContext_GenerateJunitTestCases().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EEFGenPackage.eINSTANCE.getGenEditionContext_GenerateJunitTestCases().getEAttributeType(), newValue);
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
		validate = EEFRuntimePlugin.getEEFValidator().validate(genEditionContext);
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
			genEditionContext.eAdapters().remove(semanticAdapter);
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
