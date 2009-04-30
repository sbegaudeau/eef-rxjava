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
 * $Id: SpecificElementEditorBasePropertiesEditionComponent.java,v 1.2 2009/04/30 17:49:38 nlepine Exp $
 */
package org.eclipse.emf.eef.views.components;

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
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.emf.eef.toolkits.Widget;
import org.eclipse.emf.eef.views.SpecificElementEditor;
import org.eclipse.emf.eef.views.ViewsPackage;
import org.eclipse.emf.eef.views.parts.SpecificElementEditorPropertiesEditionPart;
import org.eclipse.emf.eef.views.parts.ViewsViewsRepository;
import org.eclipse.jface.dialogs.IMessageProvider;

// End of user code
/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class SpecificElementEditorBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$
	
	private String[] parts = {BASE_PART};
	
	/**
	 * The EObject to edit
	 */
	private SpecificElementEditor specificElementEditor;
	
	/**
	 * The Base part
	 */
	private SpecificElementEditorPropertiesEditionPart basePart;
	
	/**
	 * Default constructor
	 */
	public SpecificElementEditorBasePropertiesEditionComponent(EObject specificElementEditor, String editing_mode) {
		if (specificElementEditor instanceof SpecificElementEditor) {
			this.specificElementEditor = (SpecificElementEditor)specificElementEditor;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.specificElementEditor.eAdapters().add(semanticAdapter);
			}
		}
		listeners = new ArrayList();
		this.editing_mode = editing_mode;
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
				if (ViewsPackage.eINSTANCE.getViewElement_Representation().equals(msg.getFeature()) && basePart != null)
					basePart.setRepresentation((EObject)msg.getNewValue());
				if (ViewsPackage.eINSTANCE.getViewElement_Name().equals(msg.getFeature()) && basePart != null)
					basePart.setName((String)msg.getNewValue());

				if (ViewsPackage.eINSTANCE.getElementEditor_ReadOnly().equals(msg.getFeature()) && basePart != null)
					basePart.setReadOnly((Boolean)msg.getNewValue());



			}

		};
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#translatePart(java.lang.String)
	 */
	public java.lang.Class translatePart(String key) {
		if (BASE_PART.equals(key))
			return ViewsViewsRepository.SpecificElementEditor.class;
		return super.translatePart(key);
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
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (specificElementEditor != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(ViewsViewsRepository.class);
				if (provider != null) {
					basePart = (SpecificElementEditorPropertiesEditionPart)provider.getPropertiesEditionPart(ViewsViewsRepository.SpecificElementEditor.class, kind, this);
					listeners.add(basePart);
				}
			}
			return (IPropertiesEditionPart)basePart;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent
	 * 		#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, 
	 * 						org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		if (basePart != null && key == ViewsViewsRepository.SpecificElementEditor.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			SpecificElementEditor specificElementEditor = (SpecificElementEditor)elt;
			basePart.initRepresentation(allResource, specificElementEditor.getRepresentation());
			if (specificElementEditor.getName() != null)
				basePart.setName(specificElementEditor.getName());

			basePart.setReadOnly(specificElementEditor.isReadOnly());

		}

	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand
	 * (org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if (specificElementEditor != null) {
			cc.append(SetCommand.create(editingDomain, specificElementEditor, ViewsPackage.eINSTANCE.getViewElement_Representation(), basePart.getRepresentation()));
			cc.append(SetCommand.create(editingDomain, specificElementEditor, ViewsPackage.eINSTANCE.getViewElement_Name(), basePart.getName()));

			cc.append(SetCommand.create(editingDomain, specificElementEditor, ViewsPackage.eINSTANCE.getElementEditor_ReadOnly(), basePart.getReadOnly()));



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
		if (source instanceof SpecificElementEditor) {
			SpecificElementEditor specificElementEditorToUpdate = (SpecificElementEditor)source;
			specificElementEditorToUpdate.setRepresentation((Widget)basePart.getRepresentation());
			specificElementEditorToUpdate.setName(basePart.getName());

			specificElementEditorToUpdate.setReadOnly(new Boolean(basePart.getReadOnly()).booleanValue());



			return specificElementEditorToUpdate;
		}
		else
			return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.common.notify.Notification)
	 */
	public void firePropertiesChanged(PropertiesEditionEvent event) {
		super.firePropertiesChanged(event);
		if (PropertiesEditionEvent.COMMIT == event.getState() && IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
			CompoundCommand command = new CompoundCommand();
			if (ViewsViewsRepository.SpecificElementEditor.representation == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, specificElementEditor, ViewsPackage.eINSTANCE.getViewElement_Representation(), event.getNewValue()));
			if (ViewsViewsRepository.SpecificElementEditor.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, specificElementEditor, ViewsPackage.eINSTANCE.getViewElement_Name(), event.getNewValue()));

			if (ViewsViewsRepository.SpecificElementEditor.readOnly == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, specificElementEditor, ViewsPackage.eINSTANCE.getElementEditor_ReadOnly(), event.getNewValue()));



			if (command != null)
				liveEditingDomain.getCommandStack().execute(command);
		} else if (PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {
				
				if (ViewsViewsRepository.SpecificElementEditor.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);
				


			} else {
				
				if (ViewsViewsRepository.SpecificElementEditor.name == event.getAffectedEditor())
					basePart.unsetMessageForName();
				


			}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 */
	public boolean isRequired(String key, int kind) {
		return key == ViewsViewsRepository.SpecificElementEditor.name || key == ViewsViewsRepository.SpecificElementEditor.readOnly;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 */
	public String getHelpContent(String key, int kind) {
			if (key == ViewsViewsRepository.SpecificElementEditor.representation)
				return "The representation of this part of view"; //$NON-NLS-1$
			if (key == ViewsViewsRepository.SpecificElementEditor.name)
				return "The element name"; //$NON-NLS-1$
			if (key == ViewsViewsRepository.SpecificElementEditor.readOnly)
				return "Defines that this editor is in read only mode"; //$NON-NLS-1$
		return super.getHelpContent(key, kind);
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.common.notify.Notification)
	 */
	public Diagnostic validateValue(PropertiesEditionEvent event) {
		String newStringValue = event.getNewValue().toString();
		Diagnostic ret = null;
		try {
			if (ViewsViewsRepository.SpecificElementEditor.name == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(ViewsPackage.eINSTANCE.getViewElement_Name().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(ViewsPackage.eINSTANCE.getViewElement_Name().getEAttributeType(), newValue);
			}
			if (ViewsViewsRepository.SpecificElementEditor.readOnly == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(ViewsPackage.eINSTANCE.getElementEditor_ReadOnly().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(ViewsPackage.eINSTANCE.getElementEditor_ReadOnly().getEAttributeType(), newValue);
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
			return Diagnostician.INSTANCE.validate(specificElementEditor);
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
			specificElementEditor.eAdapters().remove(semanticAdapter);
	}

}

