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
 * $Id: EEFGenModelReferencePropertiesEditionComponent.java,v 1.2 2009/05/05 12:06:10 sbouchet Exp $
 */
package org.eclipse.emf.eef.EEFGen.components;

// Start of user code for imports

import java.util.ArrayList;

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
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.EEFGen.EEFGenModel;
import org.eclipse.emf.eef.EEFGen.EEFGenModelReference;
import org.eclipse.emf.eef.EEFGen.EEFGenPackage;
import org.eclipse.emf.eef.EEFGen.parts.EEFGenModelReferencePropertiesEditionPart;
import org.eclipse.emf.eef.EEFGen.parts.EEFGenViewsRepository;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;

// End of user code
/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class EEFGenModelReferencePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$
	
	private String[] parts = {BASE_PART};
	
	/**
	 * The EObject to edit
	 */
	private EEFGenModelReference eEFGenModelReference;
	
	/**
	 * The Base part
	 */
	private EEFGenModelReferencePropertiesEditionPart basePart;
	
	/**
	 * Default constructor
	 */
	public EEFGenModelReferencePropertiesEditionComponent(EObject eEFGenModelReference, String editing_mode) {
		if (eEFGenModelReference instanceof EEFGenModelReference) {
			this.eEFGenModelReference = (EEFGenModelReference)eEFGenModelReference;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.eEFGenModelReference.eAdapters().add(semanticAdapter);
			}
		}
		listeners = new ArrayList();
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
				if (EEFGenPackage.eINSTANCE.getEEFGenModelReference_ReferencedContext().equals(msg.getFeature()) && basePart != null)
					basePart.setReferencedEEFGenModel((EObject)msg.getNewValue());


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
			return EEFGenViewsRepository.EEFGenModelReference.class;
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
		if (eEFGenModelReference != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(EEFGenViewsRepository.class);
				if (provider != null) {
					basePart = (EEFGenModelReferencePropertiesEditionPart)provider.getPropertiesEditionPart(EEFGenViewsRepository.EEFGenModelReference.class, kind, this);
					listeners.add(basePart);
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
		if (basePart != null && key == EEFGenViewsRepository.EEFGenModelReference.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			EEFGenModelReference eEFGenModelReference = (EEFGenModelReference)elt;
			basePart.initReferencedEEFGenModel(allResource, eEFGenModelReference.getReferencedContext());
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand
	 *     (org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if (eEFGenModelReference != null) {
			cc.append(SetCommand.create(editingDomain, eEFGenModelReference, EEFGenPackage.eINSTANCE.getEEFGenModelReference_ReferencedContext(), basePart.getReferencedEEFGenModel()));


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
		if (source instanceof EEFGenModelReference) {
			EEFGenModelReference eEFGenModelReferenceToUpdate = (EEFGenModelReference)source;
			eEFGenModelReferenceToUpdate.setReferencedContext((EEFGenModel)basePart.getReferencedEEFGenModel());


			return eEFGenModelReferenceToUpdate;
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
			if (EEFGenViewsRepository.EEFGenModelReference.referencedEEFGenModel == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, eEFGenModelReference, EEFGenPackage.eINSTANCE.getEEFGenModelReference_ReferencedContext(), event.getNewValue()));


			if (command != null)
				liveEditingDomain.getCommandStack().execute(command);
		} else if (PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {
				


			} else {
				


			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 */
	public boolean isRequired(String key, int kind) {
		return key == EEFGenViewsRepository.EEFGenModelReference.referencedEEFGenModel;
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
			return Diagnostician.INSTANCE.validate(eEFGenModelReference);
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
			eEFGenModelReference.eAdapters().remove(semanticAdapter);
	}

}

