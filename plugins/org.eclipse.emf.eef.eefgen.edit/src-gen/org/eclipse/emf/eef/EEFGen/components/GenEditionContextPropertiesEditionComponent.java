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
 * $Id: GenEditionContextPropertiesEditionComponent.java,v 1.4 2009/05/18 16:08:20 sbouchet Exp $
 */
package org.eclipse.emf.eef.EEFGen.components;

// Start of user code for imports

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
import org.eclipse.emf.eef.EEFGen.EEFGenPackage;
import org.eclipse.emf.eef.EEFGen.GenEditionContext;
import org.eclipse.emf.eef.EEFGen.parts.EEFGenViewsRepository;
import org.eclipse.emf.eef.EEFGen.parts.GenEditionContextPropertiesEditionPart;
import org.eclipse.emf.eef.components.PropertiesEditionContext;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

// End of user code
/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class GenEditionContextPropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$
	
	private String[] parts = {BASE_PART};
	
	/**
	 * The EObject to edit
	 */
	private GenEditionContext genEditionContext;
	
	/**
	 * The Base part
	 */
	private GenEditionContextPropertiesEditionPart basePart;
	
	/**
	 * Default constructor
	 */
	public GenEditionContextPropertiesEditionComponent(EObject genEditionContext, String editing_mode) {
		if (genEditionContext instanceof GenEditionContext) {
			this.genEditionContext = (GenEditionContext)genEditionContext;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.genEditionContext.eAdapters().add(semanticAdapter);
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
				if (EEFGenPackage.eINSTANCE.getGenEditionContext_BasePackage().equals(msg.getFeature()) && basePart != null)
					basePart.setBasePackage((String)msg.getNewValue());

				if (EEFGenPackage.eINSTANCE.getGenEditionContext_DescriptorsContributorID().equals(msg.getFeature()) && basePart != null)
					basePart.setDescriptorsContributorID((String)msg.getNewValue());

				if (EEFGenPackage.eINSTANCE.getGenEditionContext_DescriptorsGenericPropertiesViews().equals(msg.getFeature()) && basePart != null)
					basePart.setDescriptorsGenericPropertiesViews((Boolean)msg.getNewValue());

				if (EEFGenPackage.eINSTANCE.getGenEditionContext_GmfPropertiesViews().equals(msg.getFeature()) && basePart != null)
					basePart.setGmfPropertiesViews((Boolean)msg.getNewValue());

				if (EEFGenPackage.eINSTANCE.getGenEditionContext_PropertiesEditionContext().equals(msg.getFeature()) && basePart != null)
					basePart.setPropertiesEditionContext((EObject)msg.getNewValue());


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
			return EEFGenViewsRepository.GenEditionContext.class;
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
		if (genEditionContext != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(EEFGenViewsRepository.class);
				if (provider != null) {
					basePart = (GenEditionContextPropertiesEditionPart)provider.getPropertiesEditionPart(EEFGenViewsRepository.GenEditionContext.class, kind, this);
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
		if (basePart != null && key == EEFGenViewsRepository.GenEditionContext.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			GenEditionContext genEditionContext = (GenEditionContext)elt;
			// init values
			if (genEditionContext.getBasePackage() != null)
				basePart.setBasePackage(genEditionContext.getBasePackage());

			if (genEditionContext.getDescriptorsContributorID() != null)
				basePart.setDescriptorsContributorID(genEditionContext.getDescriptorsContributorID());

			basePart.setDescriptorsGenericPropertiesViews(genEditionContext.isDescriptorsGenericPropertiesViews());

			basePart.setGmfPropertiesViews(genEditionContext.isGmfPropertiesViews());

			basePart.initPropertiesEditionContext(allResource, genEditionContext.getPropertiesEditionContext());
			
			// init filters
			
			
			
			
			basePart.addFilterToPropertiesEditionContext(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof PropertiesEditionContext);
				}

			});
			// Start of user code for additional businessfilters for propertiesEditionContext
			
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
		if (genEditionContext != null) {
			cc.append(SetCommand.create(editingDomain, genEditionContext, EEFGenPackage.eINSTANCE.getGenEditionContext_BasePackage(), basePart.getBasePackage()));

			cc.append(SetCommand.create(editingDomain, genEditionContext, EEFGenPackage.eINSTANCE.getGenEditionContext_DescriptorsContributorID(), basePart.getDescriptorsContributorID()));

			cc.append(SetCommand.create(editingDomain, genEditionContext, EEFGenPackage.eINSTANCE.getGenEditionContext_DescriptorsGenericPropertiesViews(), basePart.getDescriptorsGenericPropertiesViews()));

			cc.append(SetCommand.create(editingDomain, genEditionContext, EEFGenPackage.eINSTANCE.getGenEditionContext_GmfPropertiesViews(), basePart.getGmfPropertiesViews()));

			cc.append(SetCommand.create(editingDomain, genEditionContext, EEFGenPackage.eINSTANCE.getGenEditionContext_PropertiesEditionContext(), basePart.getPropertiesEditionContext()));


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
		if (source instanceof GenEditionContext) {
			GenEditionContext genEditionContextToUpdate = (GenEditionContext)source;
			genEditionContextToUpdate.setBasePackage(basePart.getBasePackage());

			genEditionContextToUpdate.setDescriptorsContributorID(basePart.getDescriptorsContributorID());

			genEditionContextToUpdate.setDescriptorsGenericPropertiesViews(new Boolean(basePart.getDescriptorsGenericPropertiesViews()).booleanValue());

			genEditionContextToUpdate.setGmfPropertiesViews(new Boolean(basePart.getGmfPropertiesViews()).booleanValue());

			genEditionContextToUpdate.setPropertiesEditionContext((PropertiesEditionContext)basePart.getPropertiesEditionContext());


			return genEditionContextToUpdate;
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
			if (EEFGenViewsRepository.GenEditionContext.basePackage == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, genEditionContext, EEFGenPackage.eINSTANCE.getGenEditionContext_BasePackage(), event.getNewValue()));

			if (EEFGenViewsRepository.GenEditionContext.descriptorsContributorID == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, genEditionContext, EEFGenPackage.eINSTANCE.getGenEditionContext_DescriptorsContributorID(), event.getNewValue()));

			if (EEFGenViewsRepository.GenEditionContext.descriptorsGenericPropertiesViews == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, genEditionContext, EEFGenPackage.eINSTANCE.getGenEditionContext_DescriptorsGenericPropertiesViews(), event.getNewValue()));

			if (EEFGenViewsRepository.GenEditionContext.gmfPropertiesViews == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, genEditionContext, EEFGenPackage.eINSTANCE.getGenEditionContext_GmfPropertiesViews(), event.getNewValue()));

			if (EEFGenViewsRepository.GenEditionContext.propertiesEditionContext == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, genEditionContext, EEFGenPackage.eINSTANCE.getGenEditionContext_PropertiesEditionContext(), event.getNewValue()));


			liveEditingDomain.getCommandStack().execute(command);
		} else if (PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {
				if (EEFGenViewsRepository.GenEditionContext.basePackage == event.getAffectedEditor())
					basePart.setMessageForBasePackage(diag.getMessage(), IMessageProvider.ERROR);
				if (EEFGenViewsRepository.GenEditionContext.descriptorsContributorID == event.getAffectedEditor())
					basePart.setMessageForDescriptorsContributorID(diag.getMessage(), IMessageProvider.ERROR);
				
				
				


			} else {
				if (EEFGenViewsRepository.GenEditionContext.basePackage == event.getAffectedEditor())
					basePart.unsetMessageForBasePackage();
				if (EEFGenViewsRepository.GenEditionContext.descriptorsContributorID == event.getAffectedEditor())
					basePart.unsetMessageForDescriptorsContributorID();
				
				
				


			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 */
	public boolean isRequired(String key, int kind) {
		return key == EEFGenViewsRepository.GenEditionContext.propertiesEditionContext;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 */
	public String getHelpContent(String key, int kind) {
		if (key == EEFGenViewsRepository.GenEditionContext.basePackage)
			return "The base package for all the generated code"; //$NON-NLS-1$
		if (key == EEFGenViewsRepository.GenEditionContext.propertiesEditionContext)
			return "The PropertiesEditioContext to describe"; //$NON-NLS-1$
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
			if (EEFGenViewsRepository.GenEditionContext.basePackage == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(EEFGenPackage.eINSTANCE.getGenEditionContext_BasePackage().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(EEFGenPackage.eINSTANCE.getGenEditionContext_BasePackage().getEAttributeType(), newValue);
			}
			if (EEFGenViewsRepository.GenEditionContext.descriptorsContributorID == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(EEFGenPackage.eINSTANCE.getGenEditionContext_DescriptorsContributorID().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(EEFGenPackage.eINSTANCE.getGenEditionContext_DescriptorsContributorID().getEAttributeType(), newValue);
			}
			if (EEFGenViewsRepository.GenEditionContext.descriptorsGenericPropertiesViews == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(EEFGenPackage.eINSTANCE.getGenEditionContext_DescriptorsGenericPropertiesViews().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(EEFGenPackage.eINSTANCE.getGenEditionContext_DescriptorsGenericPropertiesViews().getEAttributeType(), newValue);
			}
			if (EEFGenViewsRepository.GenEditionContext.gmfPropertiesViews == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(EEFGenPackage.eINSTANCE.getGenEditionContext_GmfPropertiesViews().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(EEFGenPackage.eINSTANCE.getGenEditionContext_GmfPropertiesViews().getEAttributeType(), newValue);
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

