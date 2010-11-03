/**
 *  Copyright (c) 2008 - 2010 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Obeo - initial API and implementation
 *
 */
package org.eclipse.emf.eef.components.components;

// Start of user code for imports

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.eef.components.ComponentsPackage;
import org.eclipse.emf.eef.components.PropertiesEditionComponent;
import org.eclipse.emf.eef.components.parts.ComponentsViewsRepository;
import org.eclipse.emf.eef.components.parts.PropertiesEditionComponentPropertiesEditionPart;
import org.eclipse.emf.eef.mapping.MappingPackage;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.emf.eef.views.View;
import org.eclipse.emf.eef.views.ViewsPackage;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class PropertiesEditionComponentBasePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for views ReferencesTable
	 */
	private	ReferencesTableSettings viewsSettings;
	
	/**
	 * Settings for model EObjectFlatComboViewer
	 */
	private	EObjectFlatComboSettings modelSettings;
	
	/**
	 * Default constructor
	 * 
	 */
	public PropertiesEditionComponentBasePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject propertiesEditionComponent, String editing_mode) {
		super(editingContext, propertiesEditionComponent, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = ComponentsViewsRepository.class;
		partKey = ComponentsViewsRepository.PropertiesEditionComponent.class;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		setInitializing(true);
		if (editingPart != null && key == partKey) {
			editingPart.setContext(elt, allResource);
			final PropertiesEditionComponent propertiesEditionComponent = (PropertiesEditionComponent)elt;
			final PropertiesEditionComponentPropertiesEditionPart basePart = (PropertiesEditionComponentPropertiesEditionPart)editingPart;
			// init values
			if (propertiesEditionComponent.getName() != null)
				basePart.setName(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), propertiesEditionComponent.getName()));
			
			viewsSettings = new ReferencesTableSettings(propertiesEditionComponent, MappingPackage.eINSTANCE.getAbstractElementBinding_Views());
			basePart.initViews(viewsSettings);
			// init part
			modelSettings = new EObjectFlatComboSettings(propertiesEditionComponent, MappingPackage.eINSTANCE.getEMFElementBinding_Model());
			basePart.initModel(modelSettings);
			// set the button mode
			basePart.setModelButtonMode(ButtonsModeEnum.BROWSE);
			if (propertiesEditionComponent.getHelpID() != null)
				basePart.setHelpID(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), propertiesEditionComponent.getHelpID()));
			
			basePart.setExplicit(propertiesEditionComponent.isExplicit());
			
			// init filters
			
			basePart.addFilterToViews(new ViewerFilter() {
			
				/**
				 * {@inheritDoc}
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
			
			/**
			 * {@inheritDoc}
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
		
		setInitializing(false);
	}








	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		PropertiesEditionComponent propertiesEditionComponent = (PropertiesEditionComponent)semanticObject;
		if (ComponentsViewsRepository.PropertiesEditionComponent.name == event.getAffectedEditor()) {
			propertiesEditionComponent.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
		}
		if (ComponentsViewsRepository.PropertiesEditionComponent.views == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD)  {
				if (event.getNewValue() instanceof View) {
					viewsSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
					viewsSettings.removeFromReference((EObject) event.getNewValue());
			}
		}
		if (ComponentsViewsRepository.PropertiesEditionComponent.model == event.getAffectedEditor()) {
			modelSettings.setToReference((EClassifier)event.getNewValue());
		}
		if (ComponentsViewsRepository.PropertiesEditionComponent.helpID == event.getAffectedEditor()) {
			propertiesEditionComponent.setHelpID((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
		}
		if (ComponentsViewsRepository.PropertiesEditionComponent.explicit == event.getAffectedEditor()) {
			propertiesEditionComponent.setExplicit((Boolean)event.getNewValue());	
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		PropertiesEditionComponentPropertiesEditionPart basePart = (PropertiesEditionComponentPropertiesEditionPart)editingPart;
		if (MappingPackage.eINSTANCE.getAbstractElementBinding_Name().equals(msg.getFeature()) && basePart != null){
			if (msg.getNewValue() != null) {
				basePart.setName(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
			} else {
				basePart.setName("");
			}
		}
		if (MappingPackage.eINSTANCE.getAbstractElementBinding_Views().equals(msg.getFeature()))
			basePart.updateViews();
		if (MappingPackage.eINSTANCE.getEMFElementBinding_Model().equals(msg.getFeature()) && basePart != null)
			basePart.setModel((EObject)msg.getNewValue());
		if (ComponentsPackage.eINSTANCE.getEEFElement_HelpID().equals(msg.getFeature()) && basePart != null){
			if (msg.getNewValue() != null) {
				basePart.setHelpID(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
			} else {
				basePart.setHelpID("");
			}
		}
		if (ComponentsPackage.eINSTANCE.getPropertiesEditionComponent_Explicit().equals(msg.getFeature()) && basePart != null)
			basePart.setExplicit((Boolean)msg.getNewValue());
		
		
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 * 
	 */
	public boolean isRequired(String key, int kind) {
		return key == ComponentsViewsRepository.PropertiesEditionComponent.name || key == ComponentsViewsRepository.PropertiesEditionComponent.views || key == ComponentsViewsRepository.PropertiesEditionComponent.model;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.String, int)
	 * 
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
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public Diagnostic validateValue(IPropertiesEditionEvent event) {
		Diagnostic ret = Diagnostic.OK_INSTANCE;
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
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}

}
