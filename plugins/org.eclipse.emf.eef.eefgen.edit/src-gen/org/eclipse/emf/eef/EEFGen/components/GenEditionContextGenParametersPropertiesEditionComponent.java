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
 * $Id: GenEditionContextGenParametersPropertiesEditionComponent.java,v 1.1 2009/04/30 17:12:36 glefur Exp $
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
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.EEFGen.EEFGenPackage;
import org.eclipse.emf.eef.EEFGen.GenEditionContext;
import org.eclipse.emf.eef.EEFGen.HELP_STRATEGY;
import org.eclipse.emf.eef.EEFGen.parts.EEFGenViewsRepository;
import org.eclipse.emf.eef.EEFGen.parts.GenParametersPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PathedPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionComponentService;
import org.eclipse.jface.dialogs.IMessageProvider;

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class GenEditionContextGenParametersPropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String GEN_PARAMETERS_PART = "Gen Parameters"; //$NON-NLS-1$

	private String[] parts = {GEN_PARAMETERS_PART};

	/**
	 * The EObject to edit
	 */
	private GenEditionContext genEditionContext;

	/**
	 * The Gen Parameters part
	 */
	private GenParametersPropertiesEditionPart genParametersPart;

	

	/**
	 * Default constructor
	 */
	public GenEditionContextGenParametersPropertiesEditionComponent(EObject genEditionContext, String mode) {
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
				if (EEFGenPackage.eINSTANCE.getGenEditionContext_BasePackage().equals(msg.getFeature()) && genParametersPart != null)
					genParametersPart.setBasePackage((String)msg.getNewValue());
				if (EEFGenPackage.eINSTANCE.getGenEditionContext_GenDirectory().equals(msg.getFeature()) && genParametersPart != null)
					genParametersPart.setGenDirectory((String)msg.getNewValue());
				if (EEFGenPackage.eINSTANCE.getGenEditionContext_DescriptorsContributorID().equals(msg.getFeature()) && genParametersPart != null)
					genParametersPart.setDescriptorsContributorID((String)msg.getNewValue());
				if (EEFGenPackage.eINSTANCE.getGenEditionContext_HelpStrategy().equals(msg.getFeature()) && genParametersPart != null)
					genParametersPart.setHelpStrategy((Enumerator)msg.getNewValue());
				if (EEFGenPackage.eINSTANCE.getGenEditionContext_Author().equals(msg.getFeature()) && genParametersPart != null)
					genParametersPart.setAuthor((String)msg.getNewValue());
				if (EEFGenPackage.eINSTANCE.getGenEditionContext_License().equals(msg.getFeature()) && genParametersPart != null)
					genParametersPart.setLicense((String)msg.getNewValue());


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
		if (genEditionContext != null && GEN_PARAMETERS_PART.equals(key)) {
				if (genParametersPart == null) {
					IPropertiesEditionProvider provider = PropertiesEditionComponentService.getInstance().getProvider(genEditionContext);
					if (provider != null) {
						genParametersPart = (GenParametersPropertiesEditionPart)provider.getPropertiesEditionPart(genEditionContext, this, key, kind);
						listeners.add(genParametersPart);
					}
				}
				return (IPropertiesEditionPart)genParametersPart;
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
			cc.append(SetCommand.create(editingDomain, genEditionContext, EEFGenPackage.eINSTANCE.getGenEditionContext_BasePackage(), genParametersPart.getBasePackage()));
			cc.append(SetCommand.create(editingDomain, genEditionContext, EEFGenPackage.eINSTANCE.getGenEditionContext_GenDirectory(), genParametersPart.getGenDirectory()));
			cc.append(SetCommand.create(editingDomain, genEditionContext, EEFGenPackage.eINSTANCE.getGenEditionContext_DescriptorsContributorID(), genParametersPart.getDescriptorsContributorID()));
			cc.append(SetCommand.create(editingDomain, genEditionContext, EEFGenPackage.eINSTANCE.getGenEditionContext_HelpStrategy(), genParametersPart.getHelpStrategy()));
			cc.append(SetCommand.create(editingDomain, genEditionContext, EEFGenPackage.eINSTANCE.getGenEditionContext_Author(), genParametersPart.getAuthor()));
			cc.append(SetCommand.create(editingDomain, genEditionContext, EEFGenPackage.eINSTANCE.getGenEditionContext_License(), genParametersPart.getLicense()));


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
			genEditionContextToUpdate.setBasePackage(genParametersPart.getBasePackage());
			genEditionContextToUpdate.setGenDirectory(genParametersPart.getGenDirectory());
			genEditionContextToUpdate.setDescriptorsContributorID(genParametersPart.getDescriptorsContributorID());
			genEditionContextToUpdate.setHelpStrategy((HELP_STRATEGY)genParametersPart.getHelpStrategy());
			genEditionContextToUpdate.setAuthor(genParametersPart.getAuthor());
			genEditionContextToUpdate.setLicense(genParametersPart.getLicense());


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
			if (EEFGenViewsRepository.GenParameters.basePackage == event.getAffectedEditor())
				command = SetCommand.create(liveEditingDomain, genEditionContext, EEFGenPackage.eINSTANCE.getGenEditionContext_BasePackage(), event.getNewValue());
			if (EEFGenViewsRepository.GenParameters.genDirectory == event.getAffectedEditor())
				command = SetCommand.create(liveEditingDomain, genEditionContext, EEFGenPackage.eINSTANCE.getGenEditionContext_GenDirectory(), event.getNewValue());
			if (EEFGenViewsRepository.GenParameters.descriptorsContributorID == event.getAffectedEditor())
				command = SetCommand.create(liveEditingDomain, genEditionContext, EEFGenPackage.eINSTANCE.getGenEditionContext_DescriptorsContributorID(), event.getNewValue());
			if (EEFGenViewsRepository.GenParameters.helpStrategy == event.getAffectedEditor())
				command = SetCommand.create(liveEditingDomain, genEditionContext, EEFGenPackage.eINSTANCE.getGenEditionContext_HelpStrategy(), event.getNewValue());
			if (EEFGenViewsRepository.GenParameters.author == event.getAffectedEditor())
				command = SetCommand.create(liveEditingDomain, genEditionContext, EEFGenPackage.eINSTANCE.getGenEditionContext_Author(), event.getNewValue());
			if (EEFGenViewsRepository.GenParameters.license == event.getAffectedEditor())
				command = SetCommand.create(liveEditingDomain, genEditionContext, EEFGenPackage.eINSTANCE.getGenEditionContext_License(), event.getNewValue());


			if (command != null)
				liveEditingDomain.getCommandStack().execute(command);
		} else if (PathedPropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {
				if (EEFGenViewsRepository.GenParameters.basePackage == event.getAffectedEditor())
					genParametersPart.setMessageForBasePackage(diag.getMessage(), IMessageProvider.ERROR);
				if (EEFGenViewsRepository.GenParameters.genDirectory == event.getAffectedEditor())
					genParametersPart.setMessageForGenDirectory(diag.getMessage(), IMessageProvider.ERROR);
				if (EEFGenViewsRepository.GenParameters.descriptorsContributorID == event.getAffectedEditor())
					genParametersPart.setMessageForDescriptorsContributorID(diag.getMessage(), IMessageProvider.ERROR);
				
				if (EEFGenViewsRepository.GenParameters.author == event.getAffectedEditor())
					genParametersPart.setMessageForAuthor(diag.getMessage(), IMessageProvider.ERROR);
				if (EEFGenViewsRepository.GenParameters.license == event.getAffectedEditor())
					genParametersPart.setMessageForLicense(diag.getMessage(), IMessageProvider.ERROR);


			} else {
				if (EEFGenViewsRepository.GenParameters.basePackage == event.getAffectedEditor())
					genParametersPart.unsetMessageForBasePackage();
				if (EEFGenViewsRepository.GenParameters.genDirectory == event.getAffectedEditor())
					genParametersPart.unsetMessageForGenDirectory();
				if (EEFGenViewsRepository.GenParameters.descriptorsContributorID == event.getAffectedEditor())
					genParametersPart.unsetMessageForDescriptorsContributorID();
				
				if (EEFGenViewsRepository.GenParameters.author == event.getAffectedEditor())
					genParametersPart.unsetMessageForAuthor();
				if (EEFGenViewsRepository.GenParameters.license == event.getAffectedEditor())
					genParametersPart.unsetMessageForLicense();


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
			if (EEFGenViewsRepository.GenParameters.basePackage == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(EEFGenPackage.eINSTANCE.getGenEditionContext_BasePackage().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(EEFGenPackage.eINSTANCE.getGenEditionContext_BasePackage().getEAttributeType(), newValue);
			}
			if (EEFGenViewsRepository.GenParameters.genDirectory == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(EEFGenPackage.eINSTANCE.getGenEditionContext_GenDirectory().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(EEFGenPackage.eINSTANCE.getGenEditionContext_GenDirectory().getEAttributeType(), newValue);
			}
			if (EEFGenViewsRepository.GenParameters.descriptorsContributorID == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(EEFGenPackage.eINSTANCE.getGenEditionContext_DescriptorsContributorID().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(EEFGenPackage.eINSTANCE.getGenEditionContext_DescriptorsContributorID().getEAttributeType(), newValue);
			}
			if (EEFGenViewsRepository.GenParameters.helpStrategy == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(EEFGenPackage.eINSTANCE.getGenEditionContext_HelpStrategy().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(EEFGenPackage.eINSTANCE.getGenEditionContext_HelpStrategy().getEAttributeType(), newValue);
			}
			if (EEFGenViewsRepository.GenParameters.author == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(EEFGenPackage.eINSTANCE.getGenEditionContext_Author().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(EEFGenPackage.eINSTANCE.getGenEditionContext_Author().getEAttributeType(), newValue);
			}
			if (EEFGenViewsRepository.GenParameters.license == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(EEFGenPackage.eINSTANCE.getGenEditionContext_License().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(EEFGenPackage.eINSTANCE.getGenEditionContext_License().getEAttributeType(), newValue);
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


