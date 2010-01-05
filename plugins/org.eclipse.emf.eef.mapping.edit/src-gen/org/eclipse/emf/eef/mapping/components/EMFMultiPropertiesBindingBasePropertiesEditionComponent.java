/**
 *  Copyright (c) 2008-2010 Obeo.
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
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.mapping.EMFMultiPropertiesBinding;
import org.eclipse.emf.eef.mapping.MappingPackage;
import org.eclipse.emf.eef.mapping.parts.EMFMultiPropertiesBindingPropertiesEditionPart;
import org.eclipse.emf.eef.mapping.parts.MappingViewsRepository;
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
import org.eclipse.emf.eef.runtime.util.EEFConverterUtil;
import org.eclipse.emf.eef.views.ViewsPackage;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class EMFMultiPropertiesBindingBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	private String[] parts = {BASE_PART};

	/**
	 * The EObject to edit
	 */
	private EMFMultiPropertiesBinding eMFMultiPropertiesBinding;

	/**
	 * The Base part
	 */
	protected EMFMultiPropertiesBindingPropertiesEditionPart basePart;

	/**
	 * Default constructor
	 */
	public EMFMultiPropertiesBindingBasePropertiesEditionComponent(EObject eMFMultiPropertiesBinding, String editing_mode) {
		if (eMFMultiPropertiesBinding instanceof EMFMultiPropertiesBinding) {
			this.eMFMultiPropertiesBinding = (EMFMultiPropertiesBinding)eMFMultiPropertiesBinding;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.eMFMultiPropertiesBinding.eAdapters().add(semanticAdapter);
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
					EMFMultiPropertiesBindingBasePropertiesEditionComponent.this.dispose();
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
		if (MappingPackage.eINSTANCE.getAbstractPropertyBinding_Name().equals(msg.getFeature()) && basePart != null){
			if (msg.getNewValue() != null) {
				basePart.setName(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
			} else {
				basePart.setName("");
			}
		}
		if (MappingPackage.eINSTANCE.getAbstractPropertyBinding_Views().equals(msg.getFeature()))
			basePart.updateViews(eMFMultiPropertiesBinding);
		if (MappingPackage.eINSTANCE.getEMFMultiPropertiesBinding_Model().equals(msg.getFeature()))
			basePart.updateModel(eMFMultiPropertiesBinding);


	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#translatePart(java.lang.String)
	 */
	public java.lang.Class translatePart(String key) {
		if (BASE_PART.equals(key))
			return MappingViewsRepository.EMFMultiPropertiesBinding.class;
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
		if (eMFMultiPropertiesBinding != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(MappingViewsRepository.class);
				if (provider != null) {
					basePart = (EMFMultiPropertiesBindingPropertiesEditionPart)provider.getPropertiesEditionPart(MappingViewsRepository.EMFMultiPropertiesBinding.class, kind, this);
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
		if (key == MappingViewsRepository.EMFMultiPropertiesBinding.class)
			this.basePart = (EMFMultiPropertiesBindingPropertiesEditionPart) propertiesEditionPart;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		setInitializing(true);
		if (basePart != null && key == MappingViewsRepository.EMFMultiPropertiesBinding.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			final EMFMultiPropertiesBinding eMFMultiPropertiesBinding = (EMFMultiPropertiesBinding)elt;
			// init values
			if (eMFMultiPropertiesBinding.getName() != null)
				basePart.setName(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), eMFMultiPropertiesBinding.getName()));

			basePart.initViews(eMFMultiPropertiesBinding, null, MappingPackage.eINSTANCE.getAbstractPropertyBinding_Views());
			basePart.initModel(eMFMultiPropertiesBinding, null, MappingPackage.eINSTANCE.getEMFMultiPropertiesBinding_Model());
			// init filters

			basePart.addFilterToViews(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if (element instanceof EObject)
						return (!basePart.isContainedInViewsTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToViews(new EObjectFilter(ViewsPackage.eINSTANCE.getElementEditor()));
			// Start of user code for additional businessfilters for views
			
			// End of user code
			basePart.addFilterToModel(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if (element instanceof EObject)
						return (!basePart.isContainedInModelTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToModel(new EObjectFilter(EcorePackage.eINSTANCE.getEStructuralFeature()));
			// Start of user code for additional businessfilters for model
			
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
		if ((eMFMultiPropertiesBinding != null) && (basePart != null)) { 
			cc.append(SetCommand.create(editingDomain, eMFMultiPropertiesBinding, MappingPackage.eINSTANCE.getAbstractPropertyBinding_Name(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), basePart.getName())));
			List viewsToAddFromViews = basePart.getViewsToAdd();
			for (Iterator iter = viewsToAddFromViews.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, eMFMultiPropertiesBinding, MappingPackage.eINSTANCE.getAbstractPropertyBinding_Views(), iter.next()));
			List viewsToRemoveFromViews = basePart.getViewsToRemove();
			for (Iterator iter = viewsToRemoveFromViews.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, eMFMultiPropertiesBinding, MappingPackage.eINSTANCE.getAbstractPropertyBinding_Views(), iter.next()));
			//List viewsToMoveFromViews = basePart.getViewsToMove();
			//for (Iterator iter = viewsToMoveFromViews.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, eMFMultiPropertiesBinding, MappingPackage.eINSTANCE.getElementEditor(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List modelToAddFromModel = basePart.getModelToAdd();
			for (Iterator iter = modelToAddFromModel.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, eMFMultiPropertiesBinding, MappingPackage.eINSTANCE.getEMFMultiPropertiesBinding_Model(), iter.next()));
			List modelToRemoveFromModel = basePart.getModelToRemove();
			for (Iterator iter = modelToRemoveFromModel.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, eMFMultiPropertiesBinding, MappingPackage.eINSTANCE.getEMFMultiPropertiesBinding_Model(), iter.next()));
			//List modelToMoveFromModel = basePart.getModelToMove();
			//for (Iterator iter = modelToMoveFromModel.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, eMFMultiPropertiesBinding, MappingPackage.eINSTANCE.getEStructuralFeature(), moveElement.getElement(), moveElement.getIndex()));
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
	 */
	public EObject getPropertiesEditionObject(EObject source) {
		if (source instanceof EMFMultiPropertiesBinding) {
			EMFMultiPropertiesBinding eMFMultiPropertiesBindingToUpdate = (EMFMultiPropertiesBinding)source;
			eMFMultiPropertiesBindingToUpdate.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), basePart.getName()));

			eMFMultiPropertiesBindingToUpdate.getViews().addAll(basePart.getViewsToAdd());
			eMFMultiPropertiesBindingToUpdate.getModel().addAll(basePart.getModelToAdd());


			return eMFMultiPropertiesBindingToUpdate;
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
			if (MappingViewsRepository.EMFMultiPropertiesBinding.name == event.getAffectedEditor()) {
				command.append(SetCommand.create(liveEditingDomain, eMFMultiPropertiesBinding, MappingPackage.eINSTANCE.getAbstractPropertyBinding_Name(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue())));
			}
			if (MappingViewsRepository.EMFMultiPropertiesBinding.views == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, eMFMultiPropertiesBinding, MappingPackage.eINSTANCE.getAbstractPropertyBinding_Views(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, eMFMultiPropertiesBinding, MappingPackage.eINSTANCE.getAbstractPropertyBinding_Views(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, eMFMultiPropertiesBinding, MappingPackage.eINSTANCE.getAbstractPropertyBinding_Views(), event.getNewValue(), event.getNewIndex()));
			}
			if (MappingViewsRepository.EMFMultiPropertiesBinding.model == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, eMFMultiPropertiesBinding, MappingPackage.eINSTANCE.getEMFMultiPropertiesBinding_Model(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, eMFMultiPropertiesBinding, MappingPackage.eINSTANCE.getEMFMultiPropertiesBinding_Model(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, eMFMultiPropertiesBinding, MappingPackage.eINSTANCE.getEMFMultiPropertiesBinding_Model(), event.getNewValue(), event.getNewIndex()));
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
		return key == MappingViewsRepository.EMFMultiPropertiesBinding.name || key == MappingViewsRepository.EMFMultiPropertiesBinding.views || key == MappingViewsRepository.EMFMultiPropertiesBinding.model;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 */
	public String getHelpContent(String key, int kind) {
		if (key == MappingViewsRepository.EMFMultiPropertiesBinding.name)
			return "The name of this property binding"; //$NON-NLS-1$
		if (key == MappingViewsRepository.EMFMultiPropertiesBinding.views)
			return "The mapped views"; //$NON-NLS-1$
		if (key == MappingViewsRepository.EMFMultiPropertiesBinding.model)
			return "The mapped properties"; //$NON-NLS-1$
		return super.getHelpContent(key, kind);
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
				if (MappingViewsRepository.EMFMultiPropertiesBinding.name == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(MappingPackage.eINSTANCE.getAbstractPropertyBinding_Name().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(MappingPackage.eINSTANCE.getAbstractPropertyBinding_Name().getEAttributeType(), newValue);
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
	 */
	public Diagnostic validate() {
		Diagnostic validate = Diagnostic.OK_INSTANCE;
		if (IPropertiesEditionComponent.BATCH_MODE.equals(editing_mode)) {
			EObject copy = EcoreUtil.copy(eMFMultiPropertiesBinding);
			copy = getPropertiesEditionObject(copy);
			validate =  EEFRuntimePlugin.getEEFValidator().validate(copy);
		}
		else if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode))
			validate = EEFRuntimePlugin.getEEFValidator().validate(eMFMultiPropertiesBinding);
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
			eMFMultiPropertiesBinding.eAdapters().remove(semanticAdapter);
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
