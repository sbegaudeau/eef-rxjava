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
 * $Id: StandardPropertyBindingBasePropertiesEditionComponent.java,v 1.1 2009/04/30 17:14:42 glefur Exp $
 */
package org.eclipse.emf.eef.mapping.components;

// Start of user code for imports

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.command.MoveCommand;

import org.eclipse.emf.eef.mapping.StandardPropertyBinding	;


import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.eef.views.ElementEditor;
import org.eclipse.emf.eef.mapping.ModelProperty;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.mapping.MappingPackage;
import org.eclipse.emf.eef.mapping.StandardPropertyBinding	;
import org.eclipse.emf.eef.mapping.parts.StandardPropertyBindingPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PathedPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionComponentService;
import org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement;
import org.eclipse.emf.eef.mapping.ModelProperty	;
import org.eclipse.emf.eef.mapping.parts.MappingViewsRepository;
import org.eclipse.jface.dialogs.IMessageProvider;

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class StandardPropertyBindingBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	private String[] parts = {BASE_PART};

	/**
	 * The EObject to edit
	 */
	private StandardPropertyBinding standardPropertyBinding;

	/**
	 * The Base part
	 */
	private StandardPropertyBindingPropertiesEditionPart basePart;

	

	/**
	 * Default constructor
	 */
	public StandardPropertyBindingBasePropertiesEditionComponent(EObject standardPropertyBinding, String mode) {
		if (standardPropertyBinding instanceof StandardPropertyBinding) {
			this.standardPropertyBinding = (StandardPropertyBinding)standardPropertyBinding;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.standardPropertyBinding.eAdapters().add(semanticAdapter);
			}
		}
		listeners = new ArrayList();
		this.mode = mode;
	}

	/**
	 * Initialize the semantic model listener for live editing mode
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
				if (MappingPackage.eINSTANCE.getAbstractPropertyBinding_Name().equals(msg.getFeature()) && basePart != null)
					basePart.setName((String)msg.getNewValue());
				if (MappingPackage.eINSTANCE.getAbstractPropertyBinding_Views().equals(msg.getFeature())) {
					basePart.updateViews(standardPropertyBinding);
				}
				if (MappingPackage.eINSTANCE.getStandardPropertyBinding_Model().equals(msg.getFeature()) && basePart != null)
					basePart.setModel((EObject)msg.getNewValue());


			}

		};
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#partsList()
	 */
	public String[] partsList() {
		return parts;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionPart
	 * (java.lang.String, java.lang.String)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(String kind, String key) {
		if (standardPropertyBinding != null && BASE_PART.equals(key)) {
				if (basePart == null) {
					IPropertiesEditionProvider provider = PropertiesEditionComponentService.getInstance().getProvider(standardPropertyBinding);
					if (provider != null) {
						basePart = (StandardPropertyBindingPropertiesEditionPart)provider.getPropertiesEditionPart(standardPropertyBinding, this, key, kind);
						listeners.add(basePart);
					}
				}
				return (IPropertiesEditionPart)basePart;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand
	 * (org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if (standardPropertyBinding != null) {
			cc.append(SetCommand.create(editingDomain, standardPropertyBinding, MappingPackage.eINSTANCE.getAbstractPropertyBinding_Name(), basePart.getName()));
			List viewsToAdd = basePart.getViewsToAdd();
			for (Iterator iter = viewsToAdd.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, standardPropertyBinding, MappingPackage.eINSTANCE.getAbstractPropertyBinding_Views(), iter.next()));
			List viewsToRemove = basePart.getViewsToRemove();
			for (Iterator iter = viewsToRemove.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, standardPropertyBinding, MappingPackage.eINSTANCE.getAbstractPropertyBinding_Views(), iter.next()));
			//List viewsToMove = basePart.getViewsToMove();
			//for (Iterator iter = viewsToMove.iterator(); iter.hasNext();){
			//	MoveElement moveElement = (MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, standardPropertyBinding, MappingPackage.eINSTANCE.getElementEditor(), moveElement.getElement(), moveElement.getIndex()));
			//}
			cc.append(SetCommand.create(editingDomain, standardPropertyBinding, MappingPackage.eINSTANCE.getStandardPropertyBinding_Model(), basePart.getModel()));


		}
		if (!cc.isEmpty())
			return cc;
		cc.append(UnexecutableCommand.INSTANCE);
		return cc;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionObject
	 * ()
	 */
	public EObject getPropertiesEditionObject(EObject source) {
		if (source instanceof StandardPropertyBinding) {
			StandardPropertyBinding standardPropertyBindingToUpdate = (StandardPropertyBinding)source;
			standardPropertyBindingToUpdate.setName(basePart.getName());
			standardPropertyBindingToUpdate.getViews().addAll(basePart.getViewsToAdd());
			standardPropertyBindingToUpdate.setModel((ModelProperty)basePart.getModel());


			return standardPropertyBindingToUpdate;
		}
		else
			return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.common.notify.Notification)
	 */
	public void firePropertiesChanged(PathedPropertiesEditionEvent event) {
		super.firePropertiesChanged(event);
		if (PathedPropertiesEditionEvent.COMMIT == event.getState() && IPropertiesEditionComponent.LIVE_MODE.equals(mode)) {
			Command command = null;
			if (MappingViewsRepository.StandardPropertyBinding.name == event.getAffectedEditor())
				command = SetCommand.create(liveEditingDomain, standardPropertyBinding, MappingPackage.eINSTANCE.getAbstractPropertyBinding_Name(), event.getNewValue());
			if (MappingViewsRepository.StandardPropertyBinding.views == event.getAffectedEditor()) {
				if (PathedPropertiesEditionEvent.ADD == event.getKind())
					command = AddCommand.create(liveEditingDomain, standardPropertyBinding, MappingPackage.eINSTANCE.getAbstractPropertyBinding_Views(), event.getNewValue());
				if (PathedPropertiesEditionEvent.REMOVE == event.getKind())
					command = RemoveCommand.create(liveEditingDomain, standardPropertyBinding, MappingPackage.eINSTANCE.getAbstractPropertyBinding_Views(), event.getNewValue());
				if (PathedPropertiesEditionEvent.MOVE == event.getKind())
					command = MoveCommand.create(liveEditingDomain, standardPropertyBinding, MappingPackage.eINSTANCE.getAbstractPropertyBinding_Views(), event.getNewValue(), event.getNewIndex());
			}
			if (MappingViewsRepository.StandardPropertyBinding.model == event.getAffectedEditor())
				command = SetCommand.create(liveEditingDomain, standardPropertyBinding, MappingPackage.eINSTANCE.getStandardPropertyBinding_Model(), event.getNewValue());


			if (command != null)
				liveEditingDomain.getCommandStack().execute(command);
		} else if (PathedPropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {
				if (MappingViewsRepository.StandardPropertyBinding.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);
				
				


			} else {
				if (MappingViewsRepository.StandardPropertyBinding.name == event.getAffectedEditor())
					basePart.unsetMessageForName();
				
				


			}
		}
	}	
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.common.notify.Notification)
	 */
	public Diagnostic validateValue(PathedPropertiesEditionEvent event) {
		String newStringValue = event.getNewValue().toString();
		
		Diagnostic ret = null;
		
		try {
			if (MappingViewsRepository.StandardPropertyBinding.name == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(MappingPackage.eINSTANCE.getAbstractPropertyBinding_Name().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(MappingPackage.eINSTANCE.getAbstractPropertyBinding_Name().getEAttributeType(), newValue);
			}


		} catch (IllegalArgumentException iae) {
			ret = BasicDiagnostic.toDiagnostic(iae);
		}
		
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validate()
	 */
	public Diagnostic validate() {
		if (IPropertiesEditionComponent.BATCH_MODE.equals(mode)) {
			EObject copy = EcoreUtil.copy(PropertiesContextService.getInstance().entryPointElement());
			copy = PropertiesContextService.getInstance().entryPointComponent().getPropertiesEditionObject(copy);
			return Diagnostician.INSTANCE.validate(copy);
		}
		else if (IPropertiesEditionComponent.LIVE_MODE.equals(mode))
			return Diagnostician.INSTANCE.validate(standardPropertyBinding);
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
			standardPropertyBinding.eAdapters().remove(semanticAdapter);
	}

}


