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
 * $Id: StandardElementBindingBasePropertiesEditionComponent.java,v 1.4 2009/05/19 08:39:47 sbouchet Exp $
 */
package org.eclipse.emf.eef.mapping.components;

// Start of user code for imports

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
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
import org.eclipse.emf.eef.mapping.MappingPackage;
import org.eclipse.emf.eef.mapping.ModelElement;
import org.eclipse.emf.eef.mapping.StandardElementBinding;
import org.eclipse.emf.eef.mapping.parts.MappingViewsRepository;
import org.eclipse.emf.eef.mapping.parts.StandardElementBindingPropertiesEditionPart;
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
public class StandardElementBindingBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$
	
	private String[] parts = {BASE_PART};
	
	/**
	 * The EObject to edit
	 */
	private StandardElementBinding standardElementBinding;
	
	/**
	 * The Base part
	 */
	private StandardElementBindingPropertiesEditionPart basePart;
	
	/**
	 * Default constructor
	 */
	public StandardElementBindingBasePropertiesEditionComponent(EObject standardElementBinding, String editing_mode) {
		if (standardElementBinding instanceof StandardElementBinding) {
			this.standardElementBinding = (StandardElementBinding)standardElementBinding;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.standardElementBinding.eAdapters().add(semanticAdapter);
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
				if (MappingPackage.eINSTANCE.getAbstractElementBinding_Name().equals(msg.getFeature()) && basePart != null)
					basePart.setName((String)msg.getNewValue());

				if (MappingPackage.eINSTANCE.getAbstractElementBinding_Views().equals(msg.getFeature()))
					basePart.updateViews(standardElementBinding);
				if (MappingPackage.eINSTANCE.getStandardElementBinding_Model().equals(msg.getFeature()) && basePart != null)
					basePart.setModel((EObject)msg.getNewValue());


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
			return MappingViewsRepository.StandardElementBinding.class;
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
		if (standardElementBinding != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(MappingViewsRepository.class);
				if (provider != null) {
					basePart = (StandardElementBindingPropertiesEditionPart)provider.getPropertiesEditionPart(MappingViewsRepository.StandardElementBinding.class, kind, this);
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
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		if (basePart != null && key == MappingViewsRepository.StandardElementBinding.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			StandardElementBinding standardElementBinding = (StandardElementBinding)elt;
			// init values
			if (standardElementBinding.getName() != null)
				basePart.setName(standardElementBinding.getName());

			basePart.initViews(standardElementBinding, null, MappingPackage.eINSTANCE.getAbstractElementBinding_Views());
			basePart.initModel(allResource, standardElementBinding.getModel());
			
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
					return (element instanceof ModelElement);
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
		if (standardElementBinding != null) {
			cc.append(SetCommand.create(editingDomain, standardElementBinding, MappingPackage.eINSTANCE.getAbstractElementBinding_Name(), basePart.getName()));

			List viewsToAdd = basePart.getViewsToAdd();
			for (Iterator iter = viewsToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, standardElementBinding, MappingPackage.eINSTANCE.getAbstractElementBinding_Views(), iter.next()));
			List viewsToRemove = basePart.getViewsToRemove();
			for (Iterator iter = viewsToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, standardElementBinding, MappingPackage.eINSTANCE.getAbstractElementBinding_Views(), iter.next()));
			//List viewsToMove = basePart.getViewsToMove();
			//for (Iterator iter = viewsToMove.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, standardElementBinding, MappingPackage.eINSTANCE.getView(), moveElement.getElement(), moveElement.getIndex()));
			//}
			cc.append(SetCommand.create(editingDomain, standardElementBinding, MappingPackage.eINSTANCE.getStandardElementBinding_Model(), basePart.getModel()));


		}
		if (!cc.isEmpty())
			return cc;
		cc.append(UnexecutableCommand.INSTANCE);
		return cc;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionObject()
	 */
	public EObject getPropertiesEditionObject(EObject source) {
		if (source instanceof StandardElementBinding) {
			StandardElementBinding standardElementBindingToUpdate = (StandardElementBinding)source;
			standardElementBindingToUpdate.setName(basePart.getName());

			standardElementBindingToUpdate.getViews().addAll(basePart.getViewsToAdd());
			standardElementBindingToUpdate.setModel((ModelElement)basePart.getModel());


			return standardElementBindingToUpdate;
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
			if (MappingViewsRepository.StandardElementBinding.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, standardElementBinding, MappingPackage.eINSTANCE.getAbstractElementBinding_Name(), event.getNewValue()));

			if (MappingViewsRepository.StandardElementBinding.views == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, standardElementBinding, MappingPackage.eINSTANCE.getAbstractElementBinding_Views(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, standardElementBinding, MappingPackage.eINSTANCE.getAbstractElementBinding_Views(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, standardElementBinding, MappingPackage.eINSTANCE.getAbstractElementBinding_Views(), event.getNewValue(), event.getNewIndex()));
			}
			if (MappingViewsRepository.StandardElementBinding.model == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, standardElementBinding, MappingPackage.eINSTANCE.getStandardElementBinding_Model(), event.getNewValue()));


			liveEditingDomain.getCommandStack().execute(command);
		} else if (PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {
				if (MappingViewsRepository.StandardElementBinding.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);
				
				


			} else {
				if (MappingViewsRepository.StandardElementBinding.name == event.getAffectedEditor())
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
		return key == MappingViewsRepository.StandardElementBinding.name || key == MappingViewsRepository.StandardElementBinding.views || key == MappingViewsRepository.StandardElementBinding.model;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 */
	public String getHelpContent(String key, int kind) {
		if (key == MappingViewsRepository.StandardElementBinding.name)
			return "The name of this element binding"; //$NON-NLS-1$
		if (key == MappingViewsRepository.StandardElementBinding.views)
			return "The mapped views"; //$NON-NLS-1$
		if (key == MappingViewsRepository.StandardElementBinding.model)
			return "The mapped model element"; //$NON-NLS-1$
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
			if (MappingViewsRepository.StandardElementBinding.name == event.getAffectedEditor()) {
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
			return Diagnostician.INSTANCE.validate(standardElementBinding);
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
			standardElementBinding.eAdapters().remove(semanticAdapter);
	}

}

