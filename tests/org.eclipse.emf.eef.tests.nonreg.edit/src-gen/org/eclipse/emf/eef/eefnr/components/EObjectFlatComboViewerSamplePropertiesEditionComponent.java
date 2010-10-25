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
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.eef.eefnr.EObjectFlatComboViewerSample;
import org.eclipse.emf.eef.eefnr.EefnrPackage;
import org.eclipse.emf.eef.eefnr.TotalSample;
import org.eclipse.emf.eef.eefnr.parts.EObjectFlatComboViewerSamplePropertiesEditionPart;
import org.eclipse.emf.eef.eefnr.parts.EefnrViewsRepository;
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
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
	

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class EObjectFlatComboViewerSamplePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	private String[] parts = {BASE_PART};

	/**
	 * The EObject to edit
	 * 
	 */
	private EObjectFlatComboViewerSample eObjectFlatComboViewerSample;

	/**
	 * The Base part
	 * 
	 */
	protected EObjectFlatComboViewerSamplePropertiesEditionPart basePart;
	
	/**
	 * Settings for eobjectflatcomboviewerRequiredPropery EObjectFlatComboViewer
	 */
	private	EObjectFlatComboSettings eobjectflatcomboviewerRequiredProperySettings;
	
	/**
	 * Settings for eobjectflatcomboviewerOptionalPropery EObjectFlatComboViewer
	 */
	private	EObjectFlatComboSettings eobjectflatcomboviewerOptionalProperySettings;
	
	/**
	 * Default constructor
	 * 
	 */
	public EObjectFlatComboViewerSamplePropertiesEditionComponent(EObject eObjectFlatComboViewerSample, String editing_mode) {
		if (eObjectFlatComboViewerSample instanceof EObjectFlatComboViewerSample) {
			this.eObjectFlatComboViewerSample = (EObjectFlatComboViewerSample)eObjectFlatComboViewerSample;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.eObjectFlatComboViewerSample.eAdapters().add(semanticAdapter);
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
					EObjectFlatComboViewerSamplePropertiesEditionComponent.this.dispose();
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
		if (EefnrPackage.eINSTANCE.getEObjectFlatComboViewerSample_EobjectflatcomboviewerRequiredPropery().equals(msg.getFeature()) && basePart != null)
			basePart.setEobjectflatcomboviewerRequiredPropery((EObject)msg.getNewValue());
		if (EefnrPackage.eINSTANCE.getEObjectFlatComboViewerSample_EobjectflatcomboviewerOptionalPropery().equals(msg.getFeature()) && basePart != null)
			basePart.setEobjectflatcomboviewerOptionalPropery((EObject)msg.getNewValue());

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#translatePart(java.lang.String)
	 * 
	 */
	public java.lang.Class translatePart(String key) {
		if (BASE_PART.equals(key))
			return EefnrViewsRepository.EObjectFlatComboViewerSample.class;
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
		if (eObjectFlatComboViewerSample != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(EefnrViewsRepository.class);
				if (provider != null) {
					basePart = (EObjectFlatComboViewerSamplePropertiesEditionPart)provider.getPropertiesEditionPart(EefnrViewsRepository.EObjectFlatComboViewerSample.class, kind, this);
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
		if (key == EefnrViewsRepository.EObjectFlatComboViewerSample.class)
			this.basePart = (EObjectFlatComboViewerSamplePropertiesEditionPart) propertiesEditionPart;
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
		if (basePart != null && key == EefnrViewsRepository.EObjectFlatComboViewerSample.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			final EObjectFlatComboViewerSample eObjectFlatComboViewerSample = (EObjectFlatComboViewerSample)elt;
			// init values
			// init part
			eobjectflatcomboviewerRequiredProperySettings = new EObjectFlatComboSettings(eObjectFlatComboViewerSample, EefnrPackage.eINSTANCE.getEObjectFlatComboViewerSample_EobjectflatcomboviewerRequiredPropery());
			basePart.initEobjectflatcomboviewerRequiredPropery(eobjectflatcomboviewerRequiredProperySettings);
			// set the button mode
			basePart.setEobjectflatcomboviewerRequiredProperyButtonMode(ButtonsModeEnum.BROWSE);
			// init part
			eobjectflatcomboviewerOptionalProperySettings = new EObjectFlatComboSettings(eObjectFlatComboViewerSample, EefnrPackage.eINSTANCE.getEObjectFlatComboViewerSample_EobjectflatcomboviewerOptionalPropery());
			basePart.initEobjectflatcomboviewerOptionalPropery(eobjectflatcomboviewerOptionalProperySettings);
			// set the button mode
			basePart.setEobjectflatcomboviewerOptionalProperyButtonMode(ButtonsModeEnum.BROWSE);
			// init filters
			basePart.addFilterToEobjectflatcomboviewerRequiredPropery(new ViewerFilter() {

				/**
				 * {@inheritDoc}
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof TotalSample);
				}

			});
			// Start of user code for additional businessfilters for eobjectflatcomboviewerRequiredPropery
			
			// End of user code

			basePart.addFilterToEobjectflatcomboviewerOptionalPropery(new ViewerFilter() {

				/**
				 * {@inheritDoc}
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof TotalSample); //$NON-NLS-1$ 
				}

			});
			// Start of user code for additional businessfilters for eobjectflatcomboviewerOptionalPropery
			
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
				if (EefnrViewsRepository.EObjectFlatComboViewerSample.eobjectflatcomboviewerRequiredPropery == event.getAffectedEditor()) {
					updateEobjectflatcomboviewerRequiredPropery((TotalSample)event.getNewValue());
				}
				if (EefnrViewsRepository.EObjectFlatComboViewerSample.eobjectflatcomboviewerOptionalPropery == event.getAffectedEditor()) {
					updateEobjectflatcomboviewerOptionalPropery((TotalSample)event.getNewValue());
				}
			}
			else if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				liveEditingDomain.getCommandStack().execute(new StandardEditingCommand() {
					
					public void execute() {
						if (EefnrViewsRepository.EObjectFlatComboViewerSample.eobjectflatcomboviewerRequiredPropery == event.getAffectedEditor()) {
							updateEobjectflatcomboviewerRequiredPropery((TotalSample)event.getNewValue());
						}
						if (EefnrViewsRepository.EObjectFlatComboViewerSample.eobjectflatcomboviewerOptionalPropery == event.getAffectedEditor()) {
							updateEobjectflatcomboviewerOptionalPropery((TotalSample)event.getNewValue());
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

	private void updateEobjectflatcomboviewerRequiredPropery(TotalSample newValue) {
		eobjectflatcomboviewerRequiredProperySettings.setToReference(newValue);	
	}

	private void updateEobjectflatcomboviewerOptionalPropery(TotalSample newValue) {
		eobjectflatcomboviewerOptionalProperySettings.setToReference(newValue);	
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 * 
	 */
	public boolean isRequired(String key, int kind) {
		return key == EefnrViewsRepository.EObjectFlatComboViewerSample.eobjectflatcomboviewerRequiredPropery;
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
		validate = EEFRuntimePlugin.getEEFValidator().validate(eObjectFlatComboViewerSample);
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
			eObjectFlatComboViewerSample.eAdapters().remove(semanticAdapter);
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
