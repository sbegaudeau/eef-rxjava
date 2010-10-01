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
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.eef.EEFGen.EEFGenPackage;
import org.eclipse.emf.eef.EEFGen.GenViewsRepository;
import org.eclipse.emf.eef.EEFGen.HELP_STRATEGY;
import org.eclipse.emf.eef.EEFGen.parts.EEFGenViewsRepository;
import org.eclipse.emf.eef.EEFGen.parts.GenViewsRepositoryPropertiesEditionPart;
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
import org.eclipse.emf.eef.views.ViewsRepository;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class GenViewsRepositoryPropertiesEditionComponent extends StandardPropertiesEditionComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	private String[] parts = {BASE_PART};

	/**
	 * The EObject to edit
	 * 
	 */
	private GenViewsRepository genViewsRepository;

	/**
	 * The Base part
	 * 
	 */
	protected GenViewsRepositoryPropertiesEditionPart basePart;
	
	/**
	 * Default constructor
	 * 
	 */
	public GenViewsRepositoryPropertiesEditionComponent(EObject genViewsRepository, String editing_mode) {
		if (genViewsRepository instanceof GenViewsRepository) {
			this.genViewsRepository = (GenViewsRepository)genViewsRepository;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.genViewsRepository.eAdapters().add(semanticAdapter);
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
					GenViewsRepositoryPropertiesEditionComponent.this.dispose();
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
		if (EEFGenPackage.eINSTANCE.getGenViewsRepository_BasePackage().equals(msg.getFeature()) && basePart != null){
			if (msg.getNewValue() != null) {
				basePart.setBasePackage(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
			} else {
				basePart.setBasePackage("");
			}
		}
		if (EEFGenPackage.eINSTANCE.getGenViewsRepository_SwtViews().equals(msg.getFeature()) && basePart != null)
			basePart.setSWTViews((Boolean)msg.getNewValue());

		if (EEFGenPackage.eINSTANCE.getGenViewsRepository_FormViews().equals(msg.getFeature()) && basePart != null)
			basePart.setFormsViews((Boolean)msg.getNewValue());

		if (EEFGenPackage.eINSTANCE.getGenViewsRepository_HelpStrategy().equals(msg.getFeature()) && basePart != null)
			basePart.setHelpStrategy((Enumerator)msg.getNewValue());

		if (EEFGenPackage.eINSTANCE.getGenViewsRepository_ViewsRepository().equals(msg.getFeature()) && basePart != null)
			basePart.setViewsRepository((EObject)msg.getNewValue());

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#translatePart(java.lang.String)
	 * 
	 */
	public java.lang.Class translatePart(String key) {
		if (BASE_PART.equals(key))
			return EEFGenViewsRepository.GenViewsRepository.class;
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
		if (genViewsRepository != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(EEFGenViewsRepository.class);
				if (provider != null) {
					basePart = (GenViewsRepositoryPropertiesEditionPart)provider.getPropertiesEditionPart(EEFGenViewsRepository.GenViewsRepository.class, kind, this);
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
		if (key == EEFGenViewsRepository.GenViewsRepository.class)
			this.basePart = (GenViewsRepositoryPropertiesEditionPart) propertiesEditionPart;
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
		if (basePart != null && key == EEFGenViewsRepository.GenViewsRepository.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			final GenViewsRepository genViewsRepository = (GenViewsRepository)elt;
			// init values
			if (genViewsRepository.getBasePackage() != null)
				basePart.setBasePackage(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), genViewsRepository.getBasePackage()));

			basePart.setSWTViews(genViewsRepository.isSwtViews());

			basePart.setFormsViews(genViewsRepository.isFormViews());

			basePart.initHelpStrategy((EEnum) EEFGenPackage.eINSTANCE.getGenViewsRepository_HelpStrategy().getEType(), genViewsRepository.getHelpStrategy());
			// init part
			basePart.initViewsRepository(allResource, genViewsRepository.getViewsRepository());
			// set the button mode
			basePart.setViewsRepositoryButtonMode(ButtonsModeEnum.BROWSE);
			// init filters




			basePart.addFilterToViewsRepository(new ViewerFilter() {

				/**
				 * {@inheritDoc}
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof ViewsRepository);
				}

			});
			// Start of user code for additional businessfilters for viewsRepository
			
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
				if (EEFGenViewsRepository.GenViewsRepository.basePackage == event.getAffectedEditor()) {
					updateBasePackage((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
				}
				if (EEFGenViewsRepository.GenViewsRepository.sWTViews == event.getAffectedEditor()) {
					updateSwtViews((Boolean)event.getNewValue());
				}
				if (EEFGenViewsRepository.GenViewsRepository.formsViews == event.getAffectedEditor()) {
					updateFormViews((Boolean)event.getNewValue());
				}
				if (EEFGenViewsRepository.GenViewsRepository.helpStrategy == event.getAffectedEditor()) {
					updateHelpStrategy((HELP_STRATEGY)event.getNewValue());
				}
				if (EEFGenViewsRepository.GenViewsRepository.viewsRepository == event.getAffectedEditor()) {
					updateViewsRepository((ViewsRepository)event.getNewValue());
				}
			}
			else if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				liveEditingDomain.getCommandStack().execute(new StandardEditingCommand() {
					
					public void execute() {
						if (EEFGenViewsRepository.GenViewsRepository.basePackage == event.getAffectedEditor()) {
							updateBasePackage((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
						}
						if (EEFGenViewsRepository.GenViewsRepository.sWTViews == event.getAffectedEditor()) {
							updateSwtViews((Boolean)event.getNewValue());
						}
						if (EEFGenViewsRepository.GenViewsRepository.formsViews == event.getAffectedEditor()) {
							updateFormViews((Boolean)event.getNewValue());
						}
						if (EEFGenViewsRepository.GenViewsRepository.helpStrategy == event.getAffectedEditor()) {
							updateHelpStrategy((HELP_STRATEGY)event.getNewValue());
						}
						if (EEFGenViewsRepository.GenViewsRepository.viewsRepository == event.getAffectedEditor()) {
							updateViewsRepository((ViewsRepository)event.getNewValue());
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
		genViewsRepository.setBasePackage(newValue);	
	}

	private void updateSwtViews(Boolean newValue) {
		genViewsRepository.setSwtViews(newValue);	
	}

	private void updateFormViews(Boolean newValue) {
		genViewsRepository.setFormViews(newValue);	
	}

	private void updateHelpStrategy(HELP_STRATEGY newValue) {
		genViewsRepository.setHelpStrategy(newValue);	
	}

	private void updateViewsRepository(ViewsRepository newValue) {
		genViewsRepository.setViewsRepository(newValue);	
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 * 
	 */
	public boolean isRequired(String key, int kind) {
		return key == EEFGenViewsRepository.GenViewsRepository.helpStrategy || key == EEFGenViewsRepository.GenViewsRepository.viewsRepository;
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
				if (EEFGenViewsRepository.GenViewsRepository.basePackage == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EEFGenPackage.eINSTANCE.getGenViewsRepository_BasePackage().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EEFGenPackage.eINSTANCE.getGenViewsRepository_BasePackage().getEAttributeType(), newValue);
				}
				if (EEFGenViewsRepository.GenViewsRepository.sWTViews == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EEFGenPackage.eINSTANCE.getGenViewsRepository_SwtViews().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EEFGenPackage.eINSTANCE.getGenViewsRepository_SwtViews().getEAttributeType(), newValue);
				}
				if (EEFGenViewsRepository.GenViewsRepository.formsViews == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EEFGenPackage.eINSTANCE.getGenViewsRepository_FormViews().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EEFGenPackage.eINSTANCE.getGenViewsRepository_FormViews().getEAttributeType(), newValue);
				}
				if (EEFGenViewsRepository.GenViewsRepository.helpStrategy == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EEFGenPackage.eINSTANCE.getGenViewsRepository_HelpStrategy().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EEFGenPackage.eINSTANCE.getGenViewsRepository_HelpStrategy().getEAttributeType(), newValue);
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
		validate = EEFRuntimePlugin.getEEFValidator().validate(genViewsRepository);
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
			genViewsRepository.eAdapters().remove(semanticAdapter);
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
