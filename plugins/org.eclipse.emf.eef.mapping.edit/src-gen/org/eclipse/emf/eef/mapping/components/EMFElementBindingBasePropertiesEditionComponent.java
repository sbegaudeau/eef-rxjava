/**
 *  Copyright (c) 2008-2009 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Obeo - initial API and implementation
 * 
 *
 * $Id: EMFElementBindingBasePropertiesEditionComponent.java,v 1.7 2009/05/20 14:32:05 sbouchet Exp $
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
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.mapping.EMFElementBinding;
import org.eclipse.emf.eef.mapping.MappingPackage;
import org.eclipse.emf.eef.mapping.parts.EMFElementBindingPropertiesEditionPart;
import org.eclipse.emf.eef.mapping.parts.MappingViewsRepository;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.emf.eef.views.ViewsPackage;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

// End of user code
/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class EMFElementBindingBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	private String[] parts = {BASE_PART};

	/**
	 * The EObject to edit
	 */
	private EMFElementBinding eMFElementBinding;

	/**
	 * The Base part
	 */
	private EMFElementBindingPropertiesEditionPart basePart;

	/**
	 * Default constructor
	 */
	public EMFElementBindingBasePropertiesEditionComponent(EObject eMFElementBinding, String editing_mode) {
		if (eMFElementBinding instanceof EMFElementBinding) {
			this.eMFElementBinding = (EMFElementBinding)eMFElementBinding;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.eMFElementBinding.eAdapters().add(semanticAdapter);
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
			public void notifyChanged(Notification msg) {
				if (basePart == null)
					EMFElementBindingBasePropertiesEditionComponent.this.dispose();
				else {
					if (MappingPackage.eINSTANCE.getAbstractElementBinding_Name().equals(msg.getFeature()) && basePart != null)
						basePart.setName((String)msg.getNewValue());

					if (MappingPackage.eINSTANCE.getAbstractElementBinding_Views().equals(msg.getFeature()))
						basePart.updateViews(eMFElementBinding);
					if (MappingPackage.eINSTANCE.getEMFElementBinding_Model().equals(msg.getFeature()) && basePart != null)
						basePart.setModel((EObject)msg.getNewValue());


				}
			}

		};
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#translatePart(java.lang.String)
	 */
	public java.lang.Class translatePart(String key) {
		if (BASE_PART.equals(key))
			return MappingViewsRepository.EMFElementBinding.class;
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
	 * (java.lang.String, java.lang.String)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (eMFElementBinding != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(MappingViewsRepository.class);
				if (provider != null) {
					basePart = (EMFElementBindingPropertiesEditionPart)provider.getPropertiesEditionPart(MappingViewsRepository.EMFElementBinding.class, kind, this);
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
		if (key == MappingViewsRepository.EMFElementBinding.class)
			this.basePart = (EMFElementBindingPropertiesEditionPart) propertiesEditionPart;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		if (basePart != null && key == MappingViewsRepository.EMFElementBinding.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			EMFElementBinding eMFElementBinding = (EMFElementBinding)elt;
			// init values
			if (eMFElementBinding.getName() != null)
				basePart.setName(eMFElementBinding.getName());

			basePart.initViews(eMFElementBinding, null, MappingPackage.eINSTANCE.getAbstractElementBinding_Views());
			basePart.initModel(allResource, eMFElementBinding.getModel());
			
			// init filters

			basePart.addFilterToViews(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if (element instanceof EObject)
						return (!basePart.getViewsTable().contains(element));
					return false;
				}

			});
			basePart.addFilterToViews(new EObjectFilter(ViewsPackage.eINSTANCE.getView()));
			// Start of user code for additional businessfilters for views
			
			// End of user code
			basePart.addFilterToModel(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof EClassifier);
				}

			});
			// Start of user code for additional businessfilters for model
			
			// End of user code
		}
		// init values for referenced views

		// init filters for referenced views

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand
	 *     (org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if (eMFElementBinding != null) {
			cc.append(SetCommand.create(editingDomain, eMFElementBinding, MappingPackage.eINSTANCE.getAbstractElementBinding_Name(), basePart.getName()));

			List viewsToAdd = basePart.getViewsToAdd();
			for (Iterator iter = viewsToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, eMFElementBinding, MappingPackage.eINSTANCE.getAbstractElementBinding_Views(), iter.next()));
			List viewsToRemove = basePart.getViewsToRemove();
			for (Iterator iter = viewsToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, eMFElementBinding, MappingPackage.eINSTANCE.getAbstractElementBinding_Views(), iter.next()));
			//List viewsToMove = basePart.getViewsToMove();
			//for (Iterator iter = viewsToMove.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, eMFElementBinding, MappingPackage.eINSTANCE.getView(), moveElement.getElement(), moveElement.getIndex()));
			//}
			cc.append(SetCommand.create(editingDomain, eMFElementBinding, MappingPackage.eINSTANCE.getEMFElementBinding_Model(), basePart.getModel()));


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
		if (source instanceof EMFElementBinding) {
			EMFElementBinding eMFElementBindingToUpdate = (EMFElementBinding)source;
			eMFElementBindingToUpdate.setName(basePart.getName());

			eMFElementBindingToUpdate.getViews().addAll(basePart.getViewsToAdd());
			eMFElementBindingToUpdate.setModel((EClassifier)basePart.getModel());


			return eMFElementBindingToUpdate;
		}
		else
			return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.common.notify.Notification)
	 */
	public void firePropertiesChanged(PropertiesEditionEvent event) {
		super.firePropertiesChanged(event);
		if (PropertiesEditionEvent.COMMIT == event.getState() && IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
			CompoundCommand command = new CompoundCommand();
			if (MappingViewsRepository.EMFElementBinding.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, eMFElementBinding, MappingPackage.eINSTANCE.getAbstractElementBinding_Name(), event.getNewValue()));

			if (MappingViewsRepository.EMFElementBinding.views == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, eMFElementBinding, MappingPackage.eINSTANCE.getAbstractElementBinding_Views(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, eMFElementBinding, MappingPackage.eINSTANCE.getAbstractElementBinding_Views(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, eMFElementBinding, MappingPackage.eINSTANCE.getAbstractElementBinding_Views(), event.getNewValue(), event.getNewIndex()));
			}
			if (MappingViewsRepository.EMFElementBinding.model == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, eMFElementBinding, MappingPackage.eINSTANCE.getEMFElementBinding_Model(), event.getNewValue()));


			liveEditingDomain.getCommandStack().execute(command);
		} else if (PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {
				if (MappingViewsRepository.EMFElementBinding.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);




			} else {
				if (MappingViewsRepository.EMFElementBinding.name == event.getAffectedEditor())
					basePart.unsetMessageForName();




			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 */
	public boolean isRequired(String key, int kind) {
		return key == MappingViewsRepository.EMFElementBinding.name || key == MappingViewsRepository.EMFElementBinding.views || key == MappingViewsRepository.EMFElementBinding.model;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 */
	public String getHelpContent(String key, int kind) {
		if (key == MappingViewsRepository.EMFElementBinding.name)
			return "The name of this element binding"; //$NON-NLS-1$
		if (key == MappingViewsRepository.EMFElementBinding.views)
			return "The mapped views"; //$NON-NLS-1$
		if (key == MappingViewsRepository.EMFElementBinding.model)
			return "The mapped classifier"; //$NON-NLS-1$
		return super.getHelpContent(key, kind);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.common.notify.Notification)
	 */
	public Diagnostic validateValue(PropertiesEditionEvent event) {
		String newStringValue = event.getNewValue().toString();
		Diagnostic ret = null;
		try {
			if (MappingViewsRepository.EMFElementBinding.name == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(MappingPackage.eINSTANCE.getAbstractElementBinding_Name().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(MappingPackage.eINSTANCE.getAbstractElementBinding_Name().getEAttributeType(), newValue);
			}

		} catch (IllegalArgumentException iae) {
			ret = BasicDiagnostic.toDiagnostic(iae);
		}
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validate()
	 */
	public Diagnostic validate() {
		if (IPropertiesEditionComponent.BATCH_MODE.equals(editing_mode)) {
			EObject copy = EcoreUtil.copy(PropertiesContextService.getInstance().entryPointElement());
			copy = PropertiesContextService.getInstance().entryPointComponent().getPropertiesEditionObject(copy);
			return Diagnostician.INSTANCE.validate(copy);
		}
		else if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode))
			return Diagnostician.INSTANCE.validate(eMFElementBinding);
		else
			return null;
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#dispose()
	 */
	public void dispose() {
		if (semanticAdapter != null)
			eMFElementBinding.eAdapters().remove(semanticAdapter);
	}

}

