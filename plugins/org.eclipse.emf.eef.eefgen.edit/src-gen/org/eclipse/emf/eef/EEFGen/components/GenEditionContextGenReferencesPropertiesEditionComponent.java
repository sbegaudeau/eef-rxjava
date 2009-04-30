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
 * $Id: GenEditionContextGenReferencesPropertiesEditionComponent.java,v 1.1 2009/04/30 17:12:36 glefur Exp $
 */
package org.eclipse.emf.eef.EEFGen.components;

// Start of user code for imports

import java.util.ArrayList;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.EEFGen.EEFGenPackage;
import org.eclipse.emf.eef.EEFGen.GenEditionContext;
import org.eclipse.emf.eef.EEFGen.parts.EEFGenViewsRepository;
import org.eclipse.emf.eef.EEFGen.parts.GenReferencesPropertiesEditionPart;
import org.eclipse.emf.eef.components.PropertiesEditionContext;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PathedPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionComponentService;

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class GenEditionContextGenReferencesPropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String GEN_REFERENCES_PART = "Gen References"; //$NON-NLS-1$

	private String[] parts = {GEN_REFERENCES_PART};

	/**
	 * The EObject to edit
	 */
	private GenEditionContext genEditionContext;

	/**
	 * The Gen References part
	 */
	private GenReferencesPropertiesEditionPart genReferencesPart;

	

	/**
	 * Default constructor
	 */
	public GenEditionContextGenReferencesPropertiesEditionComponent(EObject genEditionContext, String mode) {
		if (genEditionContext instanceof GenEditionContext) {
			this.genEditionContext = (GenEditionContext)genEditionContext;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.genEditionContext.eAdapters().add(semanticAdapter);
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
				if (EEFGenPackage.eINSTANCE.getGenEditionContext_PropertiesEditionContext().equals(msg.getFeature()) && genReferencesPart != null)
					genReferencesPart.setPropertiesEditionContext((EObject)msg.getNewValue());


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
		if (genEditionContext != null && GEN_REFERENCES_PART.equals(key)) {
				if (genReferencesPart == null) {
					IPropertiesEditionProvider provider = PropertiesEditionComponentService.getInstance().getProvider(genEditionContext);
					if (provider != null) {
						genReferencesPart = (GenReferencesPropertiesEditionPart)provider.getPropertiesEditionPart(genEditionContext, this, key, kind);
						listeners.add(genReferencesPart);
					}
				}
				return (IPropertiesEditionPart)genReferencesPart;
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
		if (genEditionContext != null) {
			cc.append(SetCommand.create(editingDomain, genEditionContext, EEFGenPackage.eINSTANCE.getGenEditionContext_PropertiesEditionContext(), genReferencesPart.getPropertiesEditionContext()));


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
		if (source instanceof GenEditionContext) {
			GenEditionContext genEditionContextToUpdate = (GenEditionContext)source;
			genEditionContextToUpdate.setPropertiesEditionContext((PropertiesEditionContext)genReferencesPart.getPropertiesEditionContext());


			return genEditionContextToUpdate;
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
			if (EEFGenViewsRepository.GenReferences.propertiesEditionContext == event.getAffectedEditor())
				command = SetCommand.create(liveEditingDomain, genEditionContext, EEFGenPackage.eINSTANCE.getGenEditionContext_PropertiesEditionContext(), event.getNewValue());


			if (command != null)
				liveEditingDomain.getCommandStack().execute(command);
		} else if (PathedPropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {
				


			} else {
				


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
			return Diagnostician.INSTANCE.validate(genEditionContext);
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
			genEditionContext.eAdapters().remove(semanticAdapter);
	}

}


