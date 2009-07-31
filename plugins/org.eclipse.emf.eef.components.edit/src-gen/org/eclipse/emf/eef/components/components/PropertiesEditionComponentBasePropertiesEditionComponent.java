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
 * $Id: PropertiesEditionComponentBasePropertiesEditionComponent.java,v 1.8 2009/07/31 14:12:53 glefur Exp $
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
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
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
import org.eclipse.emf.eef.components.PropertiesEditionComponent;
import org.eclipse.emf.eef.components.parts.ComponentsViewsRepository;
import org.eclipse.emf.eef.components.parts.PropertiesEditionComponentPropertiesEditionPart;
import org.eclipse.emf.eef.mapping.MappingPackage;
import org.eclipse.emf.eef.runtime.EMFPropertiesRuntime;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.views.ViewsPackage;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class PropertiesEditionComponentBasePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	private String[] parts = {BASE_PART};

	/**
	 * The EObject to edit
	 */
	private PropertiesEditionComponent propertiesEditionComponent;

	/**
	 * The Base part
	 */
	private PropertiesEditionComponentPropertiesEditionPart basePart;

	/**
	 * Default constructor
	 */
	public PropertiesEditionComponentBasePropertiesEditionComponent(EObject propertiesEditionComponent, String editing_mode) {
		if (propertiesEditionComponent instanceof PropertiesEditionComponent) {
			this.propertiesEditionComponent = (PropertiesEditionComponent)propertiesEditionComponent;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.propertiesEditionComponent.eAdapters().add(semanticAdapter);
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
					PropertiesEditionComponentBasePropertiesEditionComponent.this.dispose();
				else {
					if (MappingPackage.eINSTANCE.getAbstractElementBinding_Name().equals(msg.getFeature()) && basePart != null)
						basePart.setName((String)msg.getNewValue());

					if (MappingPackage.eINSTANCE.getAbstractElementBinding_Views().equals(msg.getFeature()))
						basePart.updateViews(propertiesEditionComponent);
					if (MappingPackage.eINSTANCE.getEMFElementBinding_Model().equals(msg.getFeature()) && basePart != null)
						basePart.setModel((EObject)msg.getNewValue());
					if (ComponentsPackage.eINSTANCE.getEEFElement_HelpID().equals(msg.getFeature()) && basePart != null)
						basePart.setHelpID((String)msg.getNewValue());

					if (ComponentsPackage.eINSTANCE.getPropertiesEditionComponent_Explicit().equals(msg.getFeature()) && basePart != null)
						basePart.setExplicit((Boolean)msg.getNewValue());



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
			return ComponentsViewsRepository.PropertiesEditionComponent.class;
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
		if (propertiesEditionComponent != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(ComponentsViewsRepository.class);
				if (provider != null) {
					basePart = (PropertiesEditionComponentPropertiesEditionPart)provider.getPropertiesEditionPart(ComponentsViewsRepository.PropertiesEditionComponent.class, kind, this);
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
		if (key == ComponentsViewsRepository.PropertiesEditionComponent.class)
			this.basePart = (PropertiesEditionComponentPropertiesEditionPart) propertiesEditionPart;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		if (basePart != null && key == ComponentsViewsRepository.PropertiesEditionComponent.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			final PropertiesEditionComponent propertiesEditionComponent = (PropertiesEditionComponent)elt;
			// init values
			if (propertiesEditionComponent.getName() != null)
				basePart.setName(propertiesEditionComponent.getName());

			basePart.initViews(propertiesEditionComponent, null, MappingPackage.eINSTANCE.getAbstractElementBinding_Views());
			basePart.initModel(allResource, propertiesEditionComponent.getModel());
			// set the button mode
			basePart.setModelButtonMode(ButtonsModeEnum.BROWSE);
			if (propertiesEditionComponent.getHelpID() != null)
				basePart.setHelpID(propertiesEditionComponent.getHelpID());

			basePart.setExplicit(propertiesEditionComponent.isExplicit());

			
			// init filters

			basePart.addFilterToViews(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if (element instanceof EObject)
						return (!basePart.isContainedInViewsTable((EObject)element));
					return element instanceof Resource;
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
		if (propertiesEditionComponent != null) {
			cc.append(SetCommand.create(editingDomain, propertiesEditionComponent, MappingPackage.eINSTANCE.getAbstractElementBinding_Name(), basePart.getName()));

			List viewsToAddFromViews = basePart.getViewsToAdd();
			for (Iterator iter = viewsToAddFromViews.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, propertiesEditionComponent, MappingPackage.eINSTANCE.getAbstractElementBinding_Views(), iter.next()));
			List viewsToRemoveFromViews = basePart.getViewsToRemove();
			for (Iterator iter = viewsToRemoveFromViews.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, propertiesEditionComponent, MappingPackage.eINSTANCE.getAbstractElementBinding_Views(), iter.next()));
			//List viewsToMoveFromViews = basePart.getViewsToMove();
			//for (Iterator iter = viewsToMoveFromViews.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, propertiesEditionComponent, MappingPackage.eINSTANCE.getView(), moveElement.getElement(), moveElement.getIndex()));
			//}
			if (propertiesEditionComponent.eGet(MappingPackage.eINSTANCE.getEMFElementBinding_Model()) == null || !propertiesEditionComponent.eGet(MappingPackage.eINSTANCE.getEMFElementBinding_Model()).equals(basePart.getModel())) {
				cc.append(SetCommand.create(editingDomain, propertiesEditionComponent, MappingPackage.eINSTANCE.getEMFElementBinding_Model(), basePart.getModel()));
			}
			cc.append(SetCommand.create(editingDomain, propertiesEditionComponent, ComponentsPackage.eINSTANCE.getEEFElement_HelpID(), basePart.getHelpID()));

			cc.append(SetCommand.create(editingDomain, propertiesEditionComponent, ComponentsPackage.eINSTANCE.getPropertiesEditionComponent_Explicit(), basePart.getExplicit()));



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
		if (source instanceof PropertiesEditionComponent) {
			PropertiesEditionComponent propertiesEditionComponentToUpdate = (PropertiesEditionComponent)source;
			propertiesEditionComponentToUpdate.setName(basePart.getName());

			propertiesEditionComponentToUpdate.getViews().addAll(basePart.getViewsToAdd());
			propertiesEditionComponentToUpdate.setModel((EClassifier)basePart.getModel());
			propertiesEditionComponentToUpdate.setHelpID(basePart.getHelpID());

			propertiesEditionComponentToUpdate.setExplicit(new Boolean(basePart.getExplicit()).booleanValue());



			return propertiesEditionComponentToUpdate;
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
			if (ComponentsViewsRepository.PropertiesEditionComponent.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, propertiesEditionComponent, MappingPackage.eINSTANCE.getAbstractElementBinding_Name(), event.getNewValue()));

			if (ComponentsViewsRepository.PropertiesEditionComponent.views == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, propertiesEditionComponent, MappingPackage.eINSTANCE.getAbstractElementBinding_Views(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, propertiesEditionComponent, MappingPackage.eINSTANCE.getAbstractElementBinding_Views(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, propertiesEditionComponent, MappingPackage.eINSTANCE.getAbstractElementBinding_Views(), event.getNewValue(), event.getNewIndex()));
			}
			if (ComponentsViewsRepository.PropertiesEditionComponent.model == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, propertiesEditionComponent, MappingPackage.eINSTANCE.getEMFElementBinding_Model(), event.getNewValue()));
			if (ComponentsViewsRepository.PropertiesEditionComponent.helpID == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, propertiesEditionComponent, ComponentsPackage.eINSTANCE.getEEFElement_HelpID(), event.getNewValue()));

			if (ComponentsViewsRepository.PropertiesEditionComponent.explicit == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, propertiesEditionComponent, ComponentsPackage.eINSTANCE.getPropertiesEditionComponent_Explicit(), event.getNewValue()));



			if (!command.isEmpty() && !command.canExecute()) {
				EMFPropertiesRuntime.getDefault().logError("Cannot perform model change command.", null);
			} else {
				liveEditingDomain.getCommandStack().execute(command);
			}
		} else if (PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {
				if (ComponentsViewsRepository.PropertiesEditionComponent.name == event.getAffectedEditor())
					basePart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);


				if (ComponentsViewsRepository.PropertiesEditionComponent.helpID == event.getAffectedEditor())
					basePart.setMessageForHelpID(diag.getMessage(), IMessageProvider.ERROR);



			} else {
				if (ComponentsViewsRepository.PropertiesEditionComponent.name == event.getAffectedEditor())
					basePart.unsetMessageForName();


				if (ComponentsViewsRepository.PropertiesEditionComponent.helpID == event.getAffectedEditor())
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
		return key == ComponentsViewsRepository.PropertiesEditionComponent.name || key == ComponentsViewsRepository.PropertiesEditionComponent.views || key == ComponentsViewsRepository.PropertiesEditionComponent.model;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 */
	public String getHelpContent(String key, int kind) {
		if (key == ComponentsViewsRepository.PropertiesEditionComponent.name)
			return "The name of this element binding"; //$NON-NLS-1$
		if (key == ComponentsViewsRepository.PropertiesEditionComponent.views)
			return "The mapped views"; //$NON-NLS-1$
		if (key == ComponentsViewsRepository.PropertiesEditionComponent.model)
			return "The mapped classifier"; //$NON-NLS-1$
		if (key == ComponentsViewsRepository.PropertiesEditionComponent.helpID)
			return "The ID of the dynamic help associated to this element (not implemented for the moment)"; //$NON-NLS-1$
		if (key == ComponentsViewsRepository.PropertiesEditionComponent.explicit)
			return "Whether the component can be directly used"; //$NON-NLS-1$
		return super.getHelpContent(key, kind);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.common.notify.Notification)
	 */
	public Diagnostic validateValue(PropertiesEditionEvent event) {
		Diagnostic ret = null;
		if (event.getNewValue() != null) {
			String newStringValue = event.getNewValue().toString();
			try {
				if (ComponentsViewsRepository.PropertiesEditionComponent.name == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(MappingPackage.eINSTANCE.getAbstractElementBinding_Name().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(MappingPackage.eINSTANCE.getAbstractElementBinding_Name().getEAttributeType(), newValue);
				}
				if (ComponentsViewsRepository.PropertiesEditionComponent.helpID == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(ComponentsPackage.eINSTANCE.getEEFElement_HelpID().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(ComponentsPackage.eINSTANCE.getEEFElement_HelpID().getEAttributeType(), newValue);
				}
				if (ComponentsViewsRepository.PropertiesEditionComponent.explicit == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(ComponentsPackage.eINSTANCE.getPropertiesEditionComponent_Explicit().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(ComponentsPackage.eINSTANCE.getPropertiesEditionComponent_Explicit().getEAttributeType(), newValue);
				}

			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			}
		}
		return ret;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validate()
	 */
	public Diagnostic validate() {
		Diagnostic validate = null;
		if (IPropertiesEditionComponent.BATCH_MODE.equals(editing_mode)) {
			EObject copy = EcoreUtil.copy(PropertiesContextService.getInstance().entryPointElement());
			copy = PropertiesContextService.getInstance().entryPointComponent().getPropertiesEditionObject(copy);
			validate =  Diagnostician.INSTANCE.validate(copy);
		}
		else if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode))
			validate = Diagnostician.INSTANCE.validate(propertiesEditionComponent);
		// Start of user code for custom validation check
		
		// End of user code

		return validate;
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#dispose()
	 */
	public void dispose() {
		if (semanticAdapter != null)
			propertiesEditionComponent.eAdapters().remove(semanticAdapter);
	}

}

