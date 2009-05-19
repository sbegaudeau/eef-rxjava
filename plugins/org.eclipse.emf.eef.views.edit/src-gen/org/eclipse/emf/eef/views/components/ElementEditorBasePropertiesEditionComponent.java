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
 * $Id: ElementEditorBasePropertiesEditionComponent.java,v 1.4 2009/05/19 08:57:28 sbouchet Exp $
 */
package org.eclipse.emf.eef.views.components;

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
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.emf.eef.toolkits.Widget;
import org.eclipse.emf.eef.views.ElementEditor;
import org.eclipse.emf.eef.views.ViewsPackage;
import org.eclipse.emf.eef.views.parts.ElementEditorPropertiesEditionPart;
import org.eclipse.emf.eef.views.parts.ViewsViewsRepository;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

// End of user code
/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class ElementEditorBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$
	
	private String[] parts = {BASE_PART};
	
	/**
	 * The EObject to edit
	 */
	private ElementEditor elementEditor;
	
	/**
	 * The Base part
	 */
	private ElementEditorPropertiesEditionPart basePart;
	
	/**
	 * Default constructor
	 */
	public ElementEditorBasePropertiesEditionComponent(EObject elementEditor, String editing_mode) {
		if (elementEditor instanceof ElementEditor) {
			this.elementEditor = (ElementEditor)elementEditor;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.elementEditor.eAdapters().add(semanticAdapter);
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
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#translatePart(java.lang.String)
	 */
	public java.lang.Class translatePart(String key) {
		if (BASE_PART.equals(key))
			return ViewsViewsRepository.ElementEditor.class;
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
		if (elementEditor != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(ViewsViewsRepository.class);
				if (provider != null) {
					basePart = (ElementEditorPropertiesEditionPart)provider.getPropertiesEditionPart(ViewsViewsRepository.ElementEditor.class, kind, this);
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
		if (basePart != null && key == ViewsViewsRepository.ElementEditor.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			ElementEditor elementEditor = (ElementEditor)elt;
			// init values
			basePart.initRepresentation(allResource, elementEditor.getRepresentation());
			if (elementEditor.getName() != null)
				basePart.setName(elementEditor.getName());

			basePart.setReadOnly(elementEditor.isReadOnly());

			
			// init filters
			basePart.addFilterToRepresentation(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof Widget); //$NON-NLS-1$ 
				}

			});
			// Start of user code for additional businessfilters for representation
			
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
		if (elementEditor != null) {
			cc.append(SetCommand.create(editingDomain, elementEditor, ViewsPackage.eINSTANCE.getViewElement_Representation(), basePart.getRepresentation()));
			cc.append(SetCommand.create(editingDomain, elementEditor, ViewsPackage.eINSTANCE.getViewElement_Name(), basePart.getName()));

			cc.append(SetCommand.create(editingDomain, elementEditor, ViewsPackage.eINSTANCE.getElementEditor_ReadOnly(), basePart.getReadOnly()));



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
		if (source instanceof ElementEditor) {
			ElementEditor elementEditorToUpdate = (ElementEditor)source;
			elementEditorToUpdate.setRepresentation((Widget)basePart.getRepresentation());
			elementEditorToUpdate.setName(basePart.getName());

			elementEditorToUpdate.setReadOnly(new Boolean(basePart.getReadOnly()).booleanValue());



			return elementEditorToUpdate;
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
			if (ViewsViewsRepository.ElementEditor.representation == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, elementEditor, ViewsPackage.eINSTANCE.getViewElement_Representation(), event.getNewValue()));
			if (ViewsViewsRepository.ElementEditor.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, elementEditor, ViewsPackage.eINSTANCE.getViewElement_Name(), event.getNewValue()));

			if (ViewsViewsRepository.ElementEditor.readOnly == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, elementEditor, ViewsPackage.eINSTANCE.getElementEditor_ReadOnly(), event.getNewValue()));



			liveEditingDomain.getCommandStack().execute(command);
		} else if (PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {
				
				if (ViewsViewsRepository.ElementEditor.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);
				


			} else {
				
				if (ViewsViewsRepository.ElementEditor.name == event.getAffectedEditor())
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
		return key == ViewsViewsRepository.ElementEditor.name || key == ViewsViewsRepository.ElementEditor.readOnly;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 */
	public String getHelpContent(String key, int kind) {
		if (key == ViewsViewsRepository.ElementEditor.representation)
			return "The representation of this part of view"; //$NON-NLS-1$
		if (key == ViewsViewsRepository.ElementEditor.name)
			return "The element name"; //$NON-NLS-1$
		if (key == ViewsViewsRepository.ElementEditor.readOnly)
			return "Defines that this editor is in read only mode"; //$NON-NLS-1$
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
			if (ViewsViewsRepository.ElementEditor.name == event.getAffectedEditor()) {
				Object newValue = EcoreUtil.createFromString(ViewsPackage.eINSTANCE.getViewElement_Name().getEAttributeType(), newStringValue);
				ret = Diagnostician.INSTANCE.validate(ViewsPackage.eINSTANCE.getViewElement_Name().getEAttributeType(), newValue);
			}
			if (ViewsViewsRepository.ElementEditor.readOnly == event.getAffectedEditor()) {
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
			return Diagnostician.INSTANCE.validate(elementEditor);
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
			elementEditor.eAdapters().remove(semanticAdapter);
	}

}

