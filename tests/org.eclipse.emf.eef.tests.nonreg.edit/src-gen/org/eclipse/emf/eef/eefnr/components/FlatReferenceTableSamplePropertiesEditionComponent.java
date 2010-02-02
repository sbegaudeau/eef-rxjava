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
package org.eclipse.emf.eef.eefnr.components;

// Start of user code for imports

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.IdentityCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.eefnr.EefnrPackage;
import org.eclipse.emf.eef.eefnr.FlatReferencesTableSample;
import org.eclipse.emf.eef.eefnr.parts.EefnrViewsRepository;
import org.eclipse.emf.eef.eefnr.parts.FlatReferenceTableSamplePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectStrictFilter;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesValidationEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;


// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class FlatReferenceTableSamplePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	private String[] parts = {BASE_PART};

	/**
	 * The EObject to edit
	 */
	private FlatReferencesTableSample flatReferencesTableSample;

	/**
	 * The Base part
	 */
	protected FlatReferenceTableSamplePropertiesEditionPart basePart;

	/**
	 * Default constructor
	 */
	public FlatReferenceTableSamplePropertiesEditionComponent(EObject flatReferencesTableSample, String editing_mode) {
		if (flatReferencesTableSample instanceof FlatReferencesTableSample) {
			this.flatReferencesTableSample = (FlatReferencesTableSample)flatReferencesTableSample;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.flatReferencesTableSample.eAdapters().add(semanticAdapter);
			}
		}
		this.editing_mode = editing_mode;
	}

	/**
	 * Initialize the semantic model listener for live editing mode
	 * 
	 * @return the semantic model listener
	 */
	private AdapterImpl initializeSemanticAdapter() {
		return new EContentAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
			 */
			public void notifyChanged(final Notification msg) {
				if (basePart == null)
					FlatReferenceTableSamplePropertiesEditionComponent.this.dispose();
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
	 */
	protected void runUpdateRunnable(final Notification msg) {
		if (EefnrPackage.eINSTANCE.getFlatReferencesTableSample_FlatreferencestableRequiredProperty().equals(msg.getFeature()))
			basePart.updateFlatreferencetableRequiredProperty(flatReferencesTableSample);
		if (EefnrPackage.eINSTANCE.getFlatReferencesTableSample_FlatreferencestableOptionalProperty().equals(msg.getFeature()))
			basePart.updateFlatreferencetableOptionalProperty(flatReferencesTableSample);


	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#translatePart(java.lang.String)
	 */
	public java.lang.Class translatePart(String key) {
		if (BASE_PART.equals(key))
			return EefnrViewsRepository.FlatReferenceTableSample.class;
		return super.translatePart(key);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#partsList()
	 */
	public String[] partsList() {
		return parts;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionPart
	 *  (java.lang.String, java.lang.String)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (flatReferencesTableSample != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(EefnrViewsRepository.class);
				if (provider != null) {
					basePart = (FlatReferenceTableSamplePropertiesEditionPart)provider.getPropertiesEditionPart(EefnrViewsRepository.FlatReferenceTableSample.class, kind, this);
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
	 */
	public void setPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionPart propertiesEditionPart) {
		if (key == EefnrViewsRepository.FlatReferenceTableSample.class)
			this.basePart = (FlatReferenceTableSamplePropertiesEditionPart) propertiesEditionPart;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		setInitializing(true);
		if (basePart != null && key == EefnrViewsRepository.FlatReferenceTableSample.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			final FlatReferencesTableSample flatReferencesTableSample = (FlatReferencesTableSample)elt;
			// init values
			basePart.initFlatreferencetableRequiredProperty(flatReferencesTableSample, null, EefnrPackage.eINSTANCE.getFlatReferencesTableSample_FlatreferencestableRequiredProperty());
			basePart.initFlatreferencetableOptionalProperty(flatReferencesTableSample, null, EefnrPackage.eINSTANCE.getFlatReferencesTableSample_FlatreferencestableOptionalProperty());
			// init filters
			basePart.addFilterToFlatreferencetableRequiredProperty(new EObjectStrictFilter(EefnrPackage.eINSTANCE.getTotalSample()));
			// Start of user code for additional businessfilters for flatreferencetableRequiredProperty
			
			// End of user code
			basePart.addFilterToFlatreferencetableOptionalProperty(new EObjectStrictFilter(EefnrPackage.eINSTANCE.getTotalSample()));
			// Start of user code for additional businessfilters for flatreferencetableOptionalProperty
			
			// End of user code
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
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if ((flatReferencesTableSample != null) && (basePart != null)) { 
			List flatreferencestableRequiredPropertyToAddFromFlatreferencetableRequiredProperty = basePart.getFlatreferencetableRequiredPropertyToAdd();
			for (Iterator iter = flatreferencestableRequiredPropertyToAddFromFlatreferencetableRequiredProperty.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, flatReferencesTableSample, EefnrPackage.eINSTANCE.getFlatReferencesTableSample_FlatreferencestableRequiredProperty(), iter.next()));
			List flatreferencestableRequiredPropertyToRemoveFromFlatreferencetableRequiredProperty = basePart.getFlatreferencetableRequiredPropertyToRemove();
			for (Iterator iter = flatreferencestableRequiredPropertyToRemoveFromFlatreferencetableRequiredProperty.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, flatReferencesTableSample, EefnrPackage.eINSTANCE.getFlatReferencesTableSample_FlatreferencestableRequiredProperty(), iter.next()));
			List flatreferencestableOptionalPropertyToAddFromFlatreferencetableOptionalProperty = basePart.getFlatreferencetableOptionalPropertyToAdd();
			for (Iterator iter = flatreferencestableOptionalPropertyToAddFromFlatreferencetableOptionalProperty.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, flatReferencesTableSample, EefnrPackage.eINSTANCE.getFlatReferencesTableSample_FlatreferencestableOptionalProperty(), iter.next()));
			List flatreferencestableOptionalPropertyToRemoveFromFlatreferencetableOptionalProperty = basePart.getFlatreferencetableOptionalPropertyToRemove();
			for (Iterator iter = flatreferencestableOptionalPropertyToRemoveFromFlatreferencetableOptionalProperty.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, flatReferencesTableSample, EefnrPackage.eINSTANCE.getFlatReferencesTableSample_FlatreferencestableOptionalProperty(), iter.next()));


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
	 */
	public EObject getPropertiesEditionObject(EObject source) {
		if (source instanceof FlatReferencesTableSample) {
			FlatReferencesTableSample flatReferencesTableSampleToUpdate = (FlatReferencesTableSample)source;
			flatReferencesTableSampleToUpdate.getFlatreferencestableRequiredProperty().addAll(basePart.getFlatreferencetableRequiredPropertyToAdd());
			flatReferencesTableSampleToUpdate.getFlatreferencestableOptionalProperty().addAll(basePart.getFlatreferencetableOptionalPropertyToAdd());


			return flatReferencesTableSampleToUpdate;
		}
		else
			return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		if (!isInitializing()) {
			Diagnostic valueDiagnostic = validateValue(event);
			if (PropertiesEditionEvent.COMMIT == event.getState() && IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode) && valueDiagnostic.getSeverity() == Diagnostic.OK) {
				CompoundCommand command = new CompoundCommand();
			if (EefnrViewsRepository.FlatReferenceTableSample.flatreferencetableRequiredProperty == event.getAffectedEditor()) {
				EMFListEditUtil elements = (EMFListEditUtil) event.getNewValue();
				if (!elements.getElementsToAdd().isEmpty()) 
					command.append(AddCommand.create(liveEditingDomain, flatReferencesTableSample, EefnrPackage.eINSTANCE.getFlatReferencesTableSample_FlatreferencestableRequiredProperty(), elements.getElementsToAdd()));
				if (!elements.getElementsToRemove().isEmpty()) 
					command.append(RemoveCommand.create(liveEditingDomain, flatReferencesTableSample, EefnrPackage.eINSTANCE.getFlatReferencesTableSample_FlatreferencestableRequiredProperty(), elements.getElementsToRemove()));
			}
			if (EefnrViewsRepository.FlatReferenceTableSample.flatreferencetableOptionalProperty == event.getAffectedEditor()) {
				EMFListEditUtil elements = (EMFListEditUtil) event.getNewValue();
				if (!elements.getElementsToAdd().isEmpty()) 
					command.append(AddCommand.create(liveEditingDomain, flatReferencesTableSample, EefnrPackage.eINSTANCE.getFlatReferencesTableSample_FlatreferencestableOptionalProperty(), elements.getElementsToAdd()));
				if (!elements.getElementsToRemove().isEmpty()) 
					command.append(RemoveCommand.create(liveEditingDomain, flatReferencesTableSample, EefnrPackage.eINSTANCE.getFlatReferencesTableSample_FlatreferencestableOptionalProperty(), elements.getElementsToRemove()));
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
	 */
	public boolean isRequired(String key, int kind) {
		return key == EefnrViewsRepository.FlatReferenceTableSample.flatreferencetableRequiredProperty;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
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
	 */
	public Diagnostic validate() {
		Diagnostic validate = Diagnostic.OK_INSTANCE;
		if (IPropertiesEditionComponent.BATCH_MODE.equals(editing_mode)) {
			EObject copy = EcoreUtil.copy(flatReferencesTableSample);
			copy = getPropertiesEditionObject(copy);
			validate =  EEFRuntimePlugin.getEEFValidator().validate(copy);
		}
		else if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode))
			validate = EEFRuntimePlugin.getEEFValidator().validate(flatReferencesTableSample);
		// Start of user code for custom validation check
		
		// End of user code
		return validate;
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#dispose()
	 */
	public void dispose() {
		if (semanticAdapter != null)
			flatReferencesTableSample.eAdapters().remove(semanticAdapter);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getTabText(java.lang.String)
	 */
	public String getTabText(String p_key) {
		return basePart.getTitle();
	}
}
