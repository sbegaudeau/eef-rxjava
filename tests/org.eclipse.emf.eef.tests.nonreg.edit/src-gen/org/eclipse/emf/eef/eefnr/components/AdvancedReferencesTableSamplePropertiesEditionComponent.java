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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.eefnr.AdvancedReferencesTableSample;
import org.eclipse.emf.eef.eefnr.EefnrPackage;
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
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesValidationEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
	

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class AdvancedReferencesTableSamplePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	private String[] parts = {BASE_PART};

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
	 * Default constructor
	 * 
	 */
	public AdvancedReferencesTableSamplePropertiesEditionComponent(EObject advancedReferencesTableSample, String editing_mode) {
		if (advancedReferencesTableSample instanceof AdvancedReferencesTableSample) {
			this.advancedReferencesTableSample = (AdvancedReferencesTableSample)advancedReferencesTableSample;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.advancedReferencesTableSample.eAdapters().add(semanticAdapter);
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
					AdvancedReferencesTableSamplePropertiesEditionComponent.this.dispose();
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
		if (EefnrPackage.eINSTANCE.getAdvancedReferencesTableSample_AdvancedreferencestableRequiredProperty().equals(msg.getFeature()))
			basePart.updateAdvancedreferencestableRequiredProperty(advancedReferencesTableSample);
		if (EefnrPackage.eINSTANCE.getAdvancedReferencesTableSample_AdvancedreferencestableOptionalProperty().equals(msg.getFeature()))
			basePart.updateAdvancedreferencestableOptionalProperty(advancedReferencesTableSample);

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
			basePart.initAdvancedreferencestableRequiredProperty(advancedReferencesTableSample, null, EefnrPackage.eINSTANCE.getAdvancedReferencesTableSample_AdvancedreferencestableRequiredProperty());
			basePart.initAdvancedreferencestableOptionalProperty(advancedReferencesTableSample, null, EefnrPackage.eINSTANCE.getAdvancedReferencesTableSample_AdvancedreferencestableOptionalProperty());
			// init filters
			basePart.addFilterToAdvancedreferencestableRequiredProperty(new ViewerFilter() {

				/*
				 * (non-Javadoc)
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

			basePart.addFilterToAdvancedreferencestableOptionalProperty(new ViewerFilter() {

				/*
				 * (non-Javadoc)
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
		if ((advancedReferencesTableSample != null) && (basePart != null)) { 
			List advancedreferencestableRequiredPropertyToAddFromAdvancedreferencestableRequiredProperty = basePart.getAdvancedreferencestableRequiredPropertyToAdd();
			for (Iterator iter = advancedreferencestableRequiredPropertyToAddFromAdvancedreferencestableRequiredProperty.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, advancedReferencesTableSample, EefnrPackage.eINSTANCE.getAdvancedReferencesTableSample_AdvancedreferencestableRequiredProperty(), iter.next()));
			List advancedreferencestableRequiredPropertyToRemoveFromAdvancedreferencestableRequiredProperty = basePart.getAdvancedreferencestableRequiredPropertyToRemove();
			for (Iterator iter = advancedreferencestableRequiredPropertyToRemoveFromAdvancedreferencestableRequiredProperty.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, advancedReferencesTableSample, EefnrPackage.eINSTANCE.getAdvancedReferencesTableSample_AdvancedreferencestableRequiredProperty(), iter.next()));
			//List advancedreferencestableRequiredPropertyToMoveFromAdvancedreferencestableRequiredProperty = basePart.getAdvancedreferencestableRequiredPropertyToMove();
			//for (Iterator iter = advancedreferencestableRequiredPropertyToMoveFromAdvancedreferencestableRequiredProperty.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, advancedReferencesTableSample, EefnrPackage.eINSTANCE.getTotalSample(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List advancedreferencestableOptionalPropertyToAddFromAdvancedreferencestableOptionalProperty = basePart.getAdvancedreferencestableOptionalPropertyToAdd();
			for (Iterator iter = advancedreferencestableOptionalPropertyToAddFromAdvancedreferencestableOptionalProperty.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, advancedReferencesTableSample, EefnrPackage.eINSTANCE.getAdvancedReferencesTableSample_AdvancedreferencestableOptionalProperty(), iter.next()));
			List advancedreferencestableOptionalPropertyToRemoveFromAdvancedreferencestableOptionalProperty = basePart.getAdvancedreferencestableOptionalPropertyToRemove();
			for (Iterator iter = advancedreferencestableOptionalPropertyToRemoveFromAdvancedreferencestableOptionalProperty.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, advancedReferencesTableSample, EefnrPackage.eINSTANCE.getAdvancedReferencesTableSample_AdvancedreferencestableOptionalProperty(), iter.next()));
			//List advancedreferencestableOptionalPropertyToMoveFromAdvancedreferencestableOptionalProperty = basePart.getAdvancedreferencestableOptionalPropertyToMove();
			//for (Iterator iter = advancedreferencestableOptionalPropertyToMoveFromAdvancedreferencestableOptionalProperty.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, advancedReferencesTableSample, EefnrPackage.eINSTANCE.getTotalSample(), moveElement.getElement(), moveElement.getIndex()));
			//}

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
		if (source instanceof AdvancedReferencesTableSample) {
			AdvancedReferencesTableSample advancedReferencesTableSampleToUpdate = (AdvancedReferencesTableSample)source;
			advancedReferencesTableSampleToUpdate.getAdvancedreferencestableRequiredProperty().addAll(basePart.getAdvancedreferencestableRequiredPropertyToAdd());
			advancedReferencesTableSampleToUpdate.getAdvancedreferencestableOptionalProperty().addAll(basePart.getAdvancedreferencestableOptionalPropertyToAdd());

			return advancedReferencesTableSampleToUpdate;
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
			if (EefnrViewsRepository.AdvancedReferencesTableSample.advancedreferencestableRequiredProperty == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, advancedReferencesTableSample, EefnrPackage.eINSTANCE.getAdvancedReferencesTableSample_AdvancedreferencestableRequiredProperty(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, advancedReferencesTableSample, EefnrPackage.eINSTANCE.getAdvancedReferencesTableSample_AdvancedreferencestableRequiredProperty(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, advancedReferencesTableSample, EefnrPackage.eINSTANCE.getAdvancedReferencesTableSample_AdvancedreferencestableRequiredProperty(), event.getNewValue(), event.getNewIndex()));
			}
			if (EefnrViewsRepository.AdvancedReferencesTableSample.advancedreferencestableOptionalProperty == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, advancedReferencesTableSample, EefnrPackage.eINSTANCE.getAdvancedReferencesTableSample_AdvancedreferencestableOptionalProperty(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, advancedReferencesTableSample, EefnrPackage.eINSTANCE.getAdvancedReferencesTableSample_AdvancedreferencestableOptionalProperty(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, advancedReferencesTableSample, EefnrPackage.eINSTANCE.getAdvancedReferencesTableSample_AdvancedreferencestableOptionalProperty(), event.getNewValue(), event.getNewIndex()));
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
		if (IPropertiesEditionComponent.BATCH_MODE.equals(editing_mode)) {
			EObject copy = EcoreUtil.copy(advancedReferencesTableSample);
			copy = getPropertiesEditionObject(copy);
			validate =  EEFRuntimePlugin.getEEFValidator().validate(copy);
		}
		else if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode))
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
