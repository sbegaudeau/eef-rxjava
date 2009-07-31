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
 * $Id: FilterPropertiesPropertiesEditionComponent.java,v 1.1 2009/07/31 14:07:31 glefur Exp $
 */
package org.eclipse.emf.eef.mapping.filters.components;

// Start of user code for imports

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.IdentityCommand;
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
import org.eclipse.emf.eef.mapping.filters.BindingFilter;
import org.eclipse.emf.eef.mapping.filters.FiltersPackage;
import org.eclipse.emf.eef.mapping.parts.FilterPropertiesPropertiesEditionPart;
import org.eclipse.emf.eef.mapping.parts.MappingViewsRepository;
import org.eclipse.emf.eef.runtime.EMFPropertiesRuntime;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.jface.dialogs.IMessageProvider;

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class FilterPropertiesPropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String FILTERPROPERTIES_PART = "Filter properties"; //$NON-NLS-1$

	private String[] parts = {FILTERPROPERTIES_PART};

	/**
	 * The EObject to edit
	 */
	private BindingFilter bindingFilter;

	/**
	 * The Filter properties part
	 */
	private FilterPropertiesPropertiesEditionPart filterPropertiesPart;

	/**
	 * Default constructor
	 */
	public FilterPropertiesPropertiesEditionComponent(EObject bindingFilter, String editing_mode) {
		if (bindingFilter instanceof BindingFilter) {
			this.bindingFilter = (BindingFilter)bindingFilter;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.bindingFilter.eAdapters().add(semanticAdapter);
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
				if (filterPropertiesPart == null)
					FilterPropertiesPropertiesEditionComponent.this.dispose();
				else {
					if (FiltersPackage.eINSTANCE.getBindingFilter_Name().equals(msg.getFeature()) && filterPropertiesPart != null)
						filterPropertiesPart.setName((String)msg.getNewValue());

					if (FiltersPackage.eINSTANCE.getBindingFilter_Mandatory().equals(msg.getFeature()) && filterPropertiesPart != null)
						filterPropertiesPart.setMandatory((Boolean)msg.getNewValue());



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
		if (FILTERPROPERTIES_PART.equals(key))
			return MappingViewsRepository.FilterProperties.class;
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
		if (bindingFilter != null && FILTERPROPERTIES_PART.equals(key)) {
			if (filterPropertiesPart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(MappingViewsRepository.class);
				if (provider != null) {
					filterPropertiesPart = (FilterPropertiesPropertiesEditionPart)provider.getPropertiesEditionPart(MappingViewsRepository.FilterProperties.class, kind, this);
					addListener((IPropertiesEditionListener)filterPropertiesPart);
				}
			}
			return (IPropertiesEditionPart)filterPropertiesPart;
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
		if (key == MappingViewsRepository.FilterProperties.class)
			this.filterPropertiesPart = (FilterPropertiesPropertiesEditionPart) propertiesEditionPart;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		if (filterPropertiesPart != null && key == MappingViewsRepository.FilterProperties.class) {
			((IPropertiesEditionPart)filterPropertiesPart).setContext(elt, allResource);
			final BindingFilter bindingFilter = (BindingFilter)elt;
			// init values
			if (bindingFilter.getName() != null)
				filterPropertiesPart.setName(bindingFilter.getName());

			filterPropertiesPart.setMandatory(bindingFilter.isMandatory());

			
			// init filters


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
		if (bindingFilter != null) {
			cc.append(SetCommand.create(editingDomain, bindingFilter, FiltersPackage.eINSTANCE.getBindingFilter_Name(), filterPropertiesPart.getName()));

			cc.append(SetCommand.create(editingDomain, bindingFilter, FiltersPackage.eINSTANCE.getBindingFilter_Mandatory(), filterPropertiesPart.getMandatory()));



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
		if (source instanceof BindingFilter) {
			BindingFilter bindingFilterToUpdate = (BindingFilter)source;
			bindingFilterToUpdate.setName(filterPropertiesPart.getName());

			bindingFilterToUpdate.setMandatory(new Boolean(filterPropertiesPart.getMandatory()).booleanValue());



			return bindingFilterToUpdate;
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
			if (MappingViewsRepository.FilterProperties.name == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, bindingFilter, FiltersPackage.eINSTANCE.getBindingFilter_Name(), event.getNewValue()));

			if (MappingViewsRepository.FilterProperties.mandatory == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, bindingFilter, FiltersPackage.eINSTANCE.getBindingFilter_Mandatory(), event.getNewValue()));



			if (!command.isEmpty() && !command.canExecute()) {
				EMFPropertiesRuntime.getDefault().logError("Cannot perform model change command.", null);
			} else {
				liveEditingDomain.getCommandStack().execute(command);
			}
		} else if (PropertiesEditionEvent.CHANGE == event.getState()) {
			Diagnostic diag = this.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {
				if (MappingViewsRepository.FilterProperties.name == event.getAffectedEditor())
					filterPropertiesPart.setMessageForName(diag.getMessage(), IMessageProvider.ERROR);



			} else {
				if (MappingViewsRepository.FilterProperties.name == event.getAffectedEditor())
					filterPropertiesPart.unsetMessageForName();



			}
		}
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
				if (MappingViewsRepository.FilterProperties.name == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(FiltersPackage.eINSTANCE.getBindingFilter_Name().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(FiltersPackage.eINSTANCE.getBindingFilter_Name().getEAttributeType(), newValue);
				}
				if (MappingViewsRepository.FilterProperties.mandatory == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(FiltersPackage.eINSTANCE.getBindingFilter_Mandatory().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(FiltersPackage.eINSTANCE.getBindingFilter_Mandatory().getEAttributeType(), newValue);
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
			validate = Diagnostician.INSTANCE.validate(bindingFilter);
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
			bindingFilter.eAdapters().remove(semanticAdapter);
	}

}

