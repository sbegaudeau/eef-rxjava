/*******************************************************************************
 * Copyright (c) 2009 Obeo.
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
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.IdentityCommand;
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
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.eefnrext.EefnrextPackage;
import org.eclipse.emf.eef.eefnrext.FlatReferenceExtendedEditorSample;
import org.eclipse.emf.eef.eefnrext.parts.EefnrextViewsRepository;
import org.eclipse.emf.eef.eefnrext.parts.SecondFlatReferenceExtendedEditorSamplePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
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
public class FlatReferenceExtendedEditorSampleSecondFlatReferenceExtendedEditorSamplePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	
	public static String SECONDFLATREFERENCEEXTENDEDEDITORSAMPLE_PART = "SecondFlatReferenceExtendedEditorSample"; //$NON-NLS-1$

	
	private String[] parts = {SECONDFLATREFERENCEEXTENDEDEDITORSAMPLE_PART};

	/**
	 * The EObject to edit
	 * 
	 */
	private FlatReferenceExtendedEditorSample flatReferenceExtendedEditorSample;

	/**
	 * The SecondFlatReferenceExtendedEditorSample part
	 * 
	 */
	protected SecondFlatReferenceExtendedEditorSamplePropertiesEditionPart secondFlatReferenceExtendedEditorSamplePart;

	/**
	 * Default constructor
	 * 
	 */
	public FlatReferenceExtendedEditorSampleSecondFlatReferenceExtendedEditorSamplePropertiesEditionComponent(EObject flatReferenceExtendedEditorSample, String editing_mode) {
		if (flatReferenceExtendedEditorSample instanceof FlatReferenceExtendedEditorSample) {
			this.flatReferenceExtendedEditorSample = (FlatReferenceExtendedEditorSample)flatReferenceExtendedEditorSample;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.flatReferenceExtendedEditorSample.eAdapters().add(semanticAdapter);
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
				if (secondFlatReferenceExtendedEditorSamplePart == null)
					FlatReferenceExtendedEditorSampleSecondFlatReferenceExtendedEditorSamplePropertiesEditionComponent.this.dispose();
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
		if (EefnrextPackage.eINSTANCE.getFlatReferenceExtendedEditorSample_Demo().equals(msg.getFeature()) && secondFlatReferenceExtendedEditorSamplePart != null){
			if (msg.getNewValue() != null) {
				secondFlatReferenceExtendedEditorSamplePart.setDemo(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
			} else {
				secondFlatReferenceExtendedEditorSamplePart.setDemo("");
			}
		}
		if (EefnrextPackage.eINSTANCE.getFlatReferenceExtendedEditorSample_Size().equals(msg.getFeature()) && secondFlatReferenceExtendedEditorSamplePart != null){
			if (msg.getNewValue() != null) {
				secondFlatReferenceExtendedEditorSamplePart.setSize(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), msg.getNewValue()));
			} else {
				secondFlatReferenceExtendedEditorSamplePart.setSize("");
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
		if (SECONDFLATREFERENCEEXTENDEDEDITORSAMPLE_PART.equals(key))
			return EefnrextViewsRepository.SecondFlatReferenceExtendedEditorSample.class;
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
		if (flatReferenceExtendedEditorSample != null && SECONDFLATREFERENCEEXTENDEDEDITORSAMPLE_PART.equals(key)) {
			if (secondFlatReferenceExtendedEditorSamplePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(EefnrextViewsRepository.class);
				if (provider != null) {
					secondFlatReferenceExtendedEditorSamplePart = (SecondFlatReferenceExtendedEditorSamplePropertiesEditionPart)provider.getPropertiesEditionPart(EefnrextViewsRepository.SecondFlatReferenceExtendedEditorSample.class, kind, this);
					addListener((IPropertiesEditionListener)secondFlatReferenceExtendedEditorSamplePart);
				}
			}
			return (IPropertiesEditionPart)secondFlatReferenceExtendedEditorSamplePart;
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
		if (key == EefnrextViewsRepository.SecondFlatReferenceExtendedEditorSample.class)
			this.secondFlatReferenceExtendedEditorSamplePart = (SecondFlatReferenceExtendedEditorSamplePropertiesEditionPart) propertiesEditionPart;
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
		if (secondFlatReferenceExtendedEditorSamplePart != null && key == EefnrextViewsRepository.SecondFlatReferenceExtendedEditorSample.class) {
			((IPropertiesEditionPart)secondFlatReferenceExtendedEditorSamplePart).setContext(elt, allResource);
			final FlatReferenceExtendedEditorSample flatReferenceExtendedEditorSample = (FlatReferenceExtendedEditorSample)elt;
			// init values
			if (flatReferenceExtendedEditorSample.getDemo() != null)
				secondFlatReferenceExtendedEditorSamplePart.setDemo(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), flatReferenceExtendedEditorSample.getDemo()));

			secondFlatReferenceExtendedEditorSamplePart.setSize(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEInt(), flatReferenceExtendedEditorSample.getSize()));

			// init filters


		}
		// init values for referenced views

		// init filters for referenced views

		setInitializing(false);
	}





	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand
	 *     (org.eclipse.emf.edit.domain.EditingDomain)
	 * 
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if ((flatReferenceExtendedEditorSample != null) && (secondFlatReferenceExtendedEditorSamplePart != null)) { 
			cc.append(SetCommand.create(editingDomain, flatReferenceExtendedEditorSample, EefnrextPackage.eINSTANCE.getFlatReferenceExtendedEditorSample_Demo(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), secondFlatReferenceExtendedEditorSamplePart.getDemo())));
			cc.append(SetCommand.create(editingDomain, flatReferenceExtendedEditorSample, EefnrextPackage.eINSTANCE.getFlatReferenceExtendedEditorSample_Size(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), secondFlatReferenceExtendedEditorSamplePart.getSize())));

		}
		if (!cc.isEmpty())
			return cc;
		cc.append(IdentityCommand.INSTANCE);
		return cc;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionObject()
	 * 
	 */
	public EObject getPropertiesEditionObject(EObject source) {
		if (source instanceof FlatReferenceExtendedEditorSample) {
			FlatReferenceExtendedEditorSample flatReferenceExtendedEditorSampleToUpdate = (FlatReferenceExtendedEditorSample)source;
			flatReferenceExtendedEditorSampleToUpdate.setDemo((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), secondFlatReferenceExtendedEditorSamplePart.getDemo()));

			flatReferenceExtendedEditorSampleToUpdate.setSize(EEFConverterUtil.createIntFromString(EcorePackage.eINSTANCE.getEInt(), secondFlatReferenceExtendedEditorSamplePart.getSize()));


			return flatReferenceExtendedEditorSampleToUpdate;
		}
		else
			return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		if (!isInitializing()) {
			Diagnostic valueDiagnostic = validateValue(event);
			if (PropertiesEditionEvent.COMMIT == event.getState() && IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode) && valueDiagnostic.getSeverity() == Diagnostic.OK) {
				CompoundCommand command = new CompoundCommand();
			if (EefnrextViewsRepository.SecondFlatReferenceExtendedEditorSample.demo == event.getAffectedEditor()) {
				command.append(SetCommand.create(liveEditingDomain, flatReferenceExtendedEditorSample, EefnrextPackage.eINSTANCE.getFlatReferenceExtendedEditorSample_Demo(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue())));
			}
			if (EefnrextViewsRepository.SecondFlatReferenceExtendedEditorSample.size == event.getAffectedEditor()) {
				command.append(SetCommand.create(liveEditingDomain, flatReferenceExtendedEditorSample, EefnrextPackage.eINSTANCE.getFlatReferenceExtendedEditorSample_Size(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEInt(), (String)event.getNewValue())));
			}

				if (!command.isEmpty() && !command.canExecute()) {
					EEFRuntimePlugin.getDefault().logError("Cannot perform model change command.", null);
				} else {
					liveEditingDomain.getCommandStack().execute(command);
				}
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
				if (EefnrextViewsRepository.SecondFlatReferenceExtendedEditorSample.demo == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EefnrextPackage.eINSTANCE.getFlatReferenceExtendedEditorSample_Demo().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EefnrextPackage.eINSTANCE.getFlatReferenceExtendedEditorSample_Demo().getEAttributeType(), newValue);
				}
				if (EefnrextViewsRepository.SecondFlatReferenceExtendedEditorSample.size == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EefnrextPackage.eINSTANCE.getFlatReferenceExtendedEditorSample_Size().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EefnrextPackage.eINSTANCE.getFlatReferenceExtendedEditorSample_Size().getEAttributeType(), newValue);
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
		if (IPropertiesEditionComponent.BATCH_MODE.equals(editing_mode)) {
			EObject copy = EcoreUtil.copy(flatReferenceExtendedEditorSample);
			copy = getPropertiesEditionObject(copy);
			validate =  EEFRuntimePlugin.getEEFValidator().validate(copy);
		}
		else if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode))
			validate = EEFRuntimePlugin.getEEFValidator().validate(flatReferenceExtendedEditorSample);
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
			flatReferenceExtendedEditorSample.eAdapters().remove(semanticAdapter);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getTabText(java.lang.String)
	 * 
	 */
	public String getTabText(String p_key) {
		return secondFlatReferenceExtendedEditorSamplePart.getTitle();
	}
}
