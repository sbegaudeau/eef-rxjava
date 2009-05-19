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
 * $Id: PropertiesMultiEditionElementBasePropertiesEditionComponent.java,v 1.5 2009/05/19 09:17:00 glefur Exp $
 */
package org.eclipse.emf.eef.components.components;

// Start of user code for imports

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.IdentityCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.components.ComponentsPackage;
import org.eclipse.emf.eef.components.PropertiesMultiEditionElement;
import org.eclipse.emf.eef.components.parts.ComponentsViewsRepository;
import org.eclipse.emf.eef.components.parts.PropertiesMultiEditionElementPropertiesEditionPart;
import org.eclipse.emf.eef.mapping.MappingPackage;
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
public class PropertiesMultiEditionElementBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$
	
	private String[] parts = {BASE_PART};
	
	/**
	 * The EObject to edit
	 */
	private PropertiesMultiEditionElement propertiesMultiEditionElement;
	
	/**
	 * The Base part
	 */
	private PropertiesMultiEditionElementPropertiesEditionPart basePart;
	
	/**
	 * Default constructor
	 */
	public PropertiesMultiEditionElementBasePropertiesEditionComponent(EObject propertiesMultiEditionElement, String editing_mode) {
		if (propertiesMultiEditionElement instanceof PropertiesMultiEditionElement) {
			this.propertiesMultiEditionElement = (PropertiesMultiEditionElement)propertiesMultiEditionElement;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.propertiesMultiEditionElement.eAdapters().add(semanticAdapter);
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
					PropertiesMultiEditionElementBasePropertiesEditionComponent.this.dispose();
				else {
					if (MappingPackage.eINSTANCE.getAbstractPropertyBinding_Name().equals(msg.getFeature()) && basePart != null)
					basePart.setName((String)msg.getNewValue());

					if (MappingPackage.eINSTANCE.getAbstractPropertyBinding_Views().equals(msg.getFeature()))
					basePart.updateViews(propertiesMultiEditionElement);
					if (MappingPackage.eINSTANCE.getEMFMultiPropertiesBinding_Model().equals(msg.getFeature()))
					basePart.updateModel(propertiesMultiEditionElement);
					if (ComponentsPackage.eINSTANCE.getEEFElement_HelpID().equals(msg.getFeature()) && basePart != null)
					basePart.setHelpID((String)msg.getNewValue());



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
			return ComponentsViewsRepository.PropertiesMultiEditionElement.class;
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
		if (propertiesMultiEditionElement != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(ComponentsViewsRepository.class);
				if (provider != null) {
					basePart = (PropertiesMultiEditionElementPropertiesEditionPart)provider.getPropertiesEditionPart(ComponentsViewsRepository.PropertiesMultiEditionElement.class, kind, this);
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
		if (key == ComponentsViewsRepository.PropertiesMultiEditionElement.class)
			this.basePart = (PropertiesMultiEditionElementPropertiesEditionPart) propertiesEditionPart;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		if (basePart != null && key == ComponentsViewsRepository.PropertiesMultiEditionElement.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			PropertiesMultiEditionElement propertiesMultiEditionElement = (PropertiesMultiEditionElement)elt;
			// init values
			if (propertiesMultiEditionElement.getName() != null)
				basePart.setName(propertiesMultiEditionElement.getName());

			basePart.initViews(propertiesMultiEditionElement, null, MappingPackage.eINSTANCE.getAbstractPropertyBinding_Views());
			basePart.initModel(propertiesMultiEditionElement, null, MappingPackage.eINSTANCE.getEMFMultiPropertiesBinding_Model());
			if (propertiesMultiEditionElement.getHelpID() != null)
				basePart.setHelpID(propertiesMultiEditionElement.getHelpID());

			
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
					return element instanceof EStructuralFeature && !basePart.getModelTable().contains(element);
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
		if (propertiesMultiEditionElement != null) {
			cc.append(SetCommand.create(editingDomain, propertiesMultiEditionElement, MappingPackage.eINSTANCE.getAbstractPropertyBinding_Name(), basePart.getName()));

			List viewsToAdd = basePart.getViewsToAdd();
			for (Iterator iter = viewsToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, propertiesMultiEditionElement, MappingPackage.eINSTANCE.getAbstractPropertyBinding_Views(), iter.next()));
			List viewsToRemove = basePart.getViewsToRemove();
			for (Iterator iter = viewsToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, propertiesMultiEditionElement, MappingPackage.eINSTANCE.getAbstractPropertyBinding_Views(), iter.next()));
			//List viewsToMove = basePart.getViewsToMove();
			//for (Iterator iter = viewsToMove.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, propertiesMultiEditionElement, MappingPackage.eINSTANCE.getElementEditor(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List modelToAdd = basePart.getModelToAdd();
			for (Iterator iter = modelToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, propertiesMultiEditionElement, MappingPackage.eINSTANCE.getEMFMultiPropertiesBinding_Model(), iter.next()));
			List modelToRemove = basePart.getModelToRemove();
			for (Iterator iter = modelToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, propertiesMultiEditionElement, MappingPackage.eINSTANCE.getEMFMultiPropertiesBinding_Model(), iter.next()));
			//List modelToMove = basePart.getModelToMove();
			//for (Iterator iter = modelToMove.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, propertiesMultiEditionElement, MappingPackage.eINSTANCE.getEStructuralFeature(), moveElement.getElement(), moveElement.getIndex()));
			//}
			cc.append(SetCommand.create(editingDomain, propertiesMultiEditionElement, ComponentsPackage.eINSTANCE.getEEFElement_HelpID(), basePart.getHelpID()));



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
		if (source instanceof PropertiesMultiEditionElement) {
			PropertiesMultiEditionElement propertiesMultiEditionElementToUpdate = (PropertiesMultiEditionElement)source;
			propertiesMultiEditionElementToUpdate.setName(basePart.getName());

			propertiesMultiEditionElementToUpdate.getViews().addAll(basePart.getViewsToAdd());
			propertiesMultiEditionElementToUpdate.getModel().addAll(basePart.getModelToAdd());
			propertiesMultiEditionElementToUpdate.setHelpID(basePart.getHelpID());



			return propertiesMultiEditionElementToUpdate;
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
			if (ComponentsViewsRepository.PropertiesMultiEditionElement.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, propertiesMultiEditionElement, MappingPackage.eINSTANCE.getAbstractPropertyBinding_Name(), event.getNewValue()));

			if (ComponentsViewsRepository.PropertiesMultiEditionElement.views == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, propertiesMultiEditionElement, MappingPackage.eINSTANCE.getAbstractPropertyBinding_Views(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, propertiesMultiEditionElement, MappingPackage.eINSTANCE.getAbstractPropertyBinding_Views(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, propertiesMultiEditionElement, MappingPackage.eINSTANCE.getAbstractPropertyBinding_Views(), event.getNewValue(), event.getNewIndex()));
			}
			if (ComponentsViewsRepository.PropertiesMultiEditionElement.model == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, propertiesMultiEditionElement, MappingPackage.eINSTANCE.getEMFMultiPropertiesBinding_Model(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, propertiesMultiEditionElement, MappingPackage.eINSTANCE.getEMFMultiPropertiesBinding_Model(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, propertiesMultiEditionElement, MappingPackage.eINSTANCE.getEMFMultiPropertiesBinding_Model(), event.getNewValue(), event.getNewIndex()));
			}
			if (ComponentsViewsRepository.PropertiesMultiEditionElement.helpID == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, propertiesMultiEditionElement, ComponentsPackage.eINSTANCE.getEEFElement_HelpID(), event.getNewValue()));



			liveEditingDomain.getCommandStack().execute(command);
		} else if (PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {
				if (ComponentsViewsRepository.PropertiesMultiEditionElement.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);
				
				
				if (ComponentsViewsRepository.PropertiesMultiEditionElement.helpID == event.getAffectedEditor())
					basePart.setMessageForHelpID(diag.getMessage(), IMessageProvider.ERROR);


			} else {
				if (ComponentsViewsRepository.PropertiesMultiEditionElement.name == event.getAffectedEditor())
					basePart.unsetMessageForName();
				
				
				if (ComponentsViewsRepository.PropertiesMultiEditionElement.helpID == event.getAffectedEditor())
					basePart.unsetMessageForHelpID();


			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 */
	public boolean isRequired(String key, int kind) {
		return key == ComponentsViewsRepository.PropertiesMultiEditionElement.name || key == ComponentsViewsRepository.PropertiesMultiEditionElement.views || key == ComponentsViewsRepository.PropertiesMultiEditionElement.model;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 */
	public String getHelpContent(String key, int kind) {
		if (key == ComponentsViewsRepository.PropertiesMultiEditionElement.name)
			return "The name of this property binding"; //$NON-NLS-1$
		if (key == ComponentsViewsRepository.PropertiesMultiEditionElement.views)
			return "The mapped views"; //$NON-NLS-1$
		if (key == ComponentsViewsRepository.PropertiesMultiEditionElement.model)
			return "The mapped properties"; //$NON-NLS-1$
		if (key == ComponentsViewsRepository.PropertiesMultiEditionElement.helpID)
			return "The ID of the dynamic help associated to this element (not implemented for the moment)"; //$NON-NLS-1$
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
			if (ComponentsViewsRepository.PropertiesMultiEditionElement.name == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(MappingPackage.eINSTANCE.getAbstractPropertyBinding_Name().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(MappingPackage.eINSTANCE.getAbstractPropertyBinding_Name().getEAttributeType(), newValue);
			}
			if (ComponentsViewsRepository.PropertiesMultiEditionElement.helpID == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(ComponentsPackage.eINSTANCE.getEEFElement_HelpID().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(ComponentsPackage.eINSTANCE.getEEFElement_HelpID().getEAttributeType(), newValue);
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
			return Diagnostician.INSTANCE.validate(propertiesMultiEditionElement);
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
			propertiesMultiEditionElement.eAdapters().remove(semanticAdapter);
	}

}

