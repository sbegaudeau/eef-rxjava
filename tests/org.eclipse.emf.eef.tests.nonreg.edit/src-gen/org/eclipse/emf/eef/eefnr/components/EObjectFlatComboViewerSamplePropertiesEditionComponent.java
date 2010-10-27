/*******************************************************************************
 * Copyright (c) 2009 - 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.eefnr.components;

// Start of user code for imports
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.eefnr.EObjectFlatComboViewerSample;
import org.eclipse.emf.eef.eefnr.EefnrPackage;
import org.eclipse.emf.eef.eefnr.TotalSample;
import org.eclipse.emf.eef.eefnr.parts.EObjectFlatComboViewerSamplePropertiesEditionPart;
import org.eclipse.emf.eef.eefnr.parts.EefnrViewsRepository;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
	

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class EObjectFlatComboViewerSamplePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for eobjectflatcomboviewerRequiredPropery EObjectFlatComboViewer
	 */
	private	EObjectFlatComboSettings eobjectflatcomboviewerRequiredProperySettings;
	
	/**
	 * Settings for eobjectflatcomboviewerOptionalPropery EObjectFlatComboViewer
	 */
	private	EObjectFlatComboSettings eobjectflatcomboviewerOptionalProperySettings;
	
	/**
	 * Default constructor
	 * 
	 */
	public EObjectFlatComboViewerSamplePropertiesEditionComponent(EObject eObjectFlatComboViewerSample, String editing_mode) {
		super(eObjectFlatComboViewerSample, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EefnrViewsRepository.class;
		partKey = EefnrViewsRepository.EObjectFlatComboViewerSample.class;
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
			final EObjectFlatComboViewerSample eObjectFlatComboViewerSample = (EObjectFlatComboViewerSample)elt;
			final EObjectFlatComboViewerSamplePropertiesEditionPart basePart = (EObjectFlatComboViewerSamplePropertiesEditionPart)editingPart;
			// init values
			// init part
			eobjectflatcomboviewerRequiredProperySettings = new EObjectFlatComboSettings(eObjectFlatComboViewerSample, EefnrPackage.eINSTANCE.getEObjectFlatComboViewerSample_EobjectflatcomboviewerRequiredPropery());
			basePart.initEobjectflatcomboviewerRequiredPropery(eobjectflatcomboviewerRequiredProperySettings);
			// set the button mode
			basePart.setEobjectflatcomboviewerRequiredProperyButtonMode(ButtonsModeEnum.BROWSE);
			// init part
			eobjectflatcomboviewerOptionalProperySettings = new EObjectFlatComboSettings(eObjectFlatComboViewerSample, EefnrPackage.eINSTANCE.getEObjectFlatComboViewerSample_EobjectflatcomboviewerOptionalPropery());
			basePart.initEobjectflatcomboviewerOptionalPropery(eobjectflatcomboviewerOptionalProperySettings);
			// set the button mode
			basePart.setEobjectflatcomboviewerOptionalProperyButtonMode(ButtonsModeEnum.BROWSE);
			// init filters
			basePart.addFilterToEobjectflatcomboviewerRequiredPropery(new ViewerFilter() {
			
			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
			 */
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				return (element instanceof TotalSample);
				}
			
			});
			// Start of user code for additional businessfilters for eobjectflatcomboviewerRequiredPropery
															
															// End of user code
			
			basePart.addFilterToEobjectflatcomboviewerOptionalPropery(new ViewerFilter() {
			
			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
			 */
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				return (element instanceof String && element.equals("")) || (element instanceof TotalSample); //$NON-NLS-1$ 
				}
			
			});
			// Start of user code for additional businessfilters for eobjectflatcomboviewerOptionalPropery
															
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
		EObjectFlatComboViewerSample eObjectFlatComboViewerSample = (EObjectFlatComboViewerSample)semanticObject;
		if (EefnrViewsRepository.EObjectFlatComboViewerSample.eobjectflatcomboviewerRequiredPropery == event.getAffectedEditor()) {
			eobjectflatcomboviewerRequiredProperySettings.setToReference((TotalSample)event.getNewValue());
		}
		if (EefnrViewsRepository.EObjectFlatComboViewerSample.eobjectflatcomboviewerOptionalPropery == event.getAffectedEditor()) {
			eobjectflatcomboviewerOptionalProperySettings.setToReference((TotalSample)event.getNewValue());
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		EObjectFlatComboViewerSamplePropertiesEditionPart basePart = (EObjectFlatComboViewerSamplePropertiesEditionPart)editingPart;
		if (EefnrPackage.eINSTANCE.getEObjectFlatComboViewerSample_EobjectflatcomboviewerRequiredPropery().equals(msg.getFeature()) && basePart != null)
			basePart.setEobjectflatcomboviewerRequiredPropery((EObject)msg.getNewValue());
		if (EefnrPackage.eINSTANCE.getEObjectFlatComboViewerSample_EobjectflatcomboviewerOptionalPropery().equals(msg.getFeature()) && basePart != null)
			basePart.setEobjectflatcomboviewerOptionalPropery((EObject)msg.getNewValue());
		
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 * 
	 */
	public boolean isRequired(String key, int kind) {
		return key == EefnrViewsRepository.EObjectFlatComboViewerSample.eobjectflatcomboviewerRequiredPropery;
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
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}

}
