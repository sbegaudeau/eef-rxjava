/*******************************************************************************
 * Copyright (c) 2009 Obeo.
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

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.IdentityCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.MoveCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.eefnr.ENUM_SAMPLE;
import org.eclipse.emf.eef.eefnr.EefnrPackage;
import org.eclipse.emf.eef.eefnr.Sample;
import org.eclipse.emf.eef.eefnr.TotalSample;
import org.eclipse.emf.eef.eefnr.parts.EefnrViewsRepository;
import org.eclipse.emf.eef.eefnr.parts.TotalSamplePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesValidationEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.util.EEFConverterUtil;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;


// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class TotalSamplePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	public static String BASE_PART = "Base"; //$NON-NLS-1$

	private String[] parts = {BASE_PART};

	/**
	 * The EObject to edit
	 */
	private TotalSample totalSample;

	/**
	 * The Base part
	 */
	protected TotalSamplePropertiesEditionPart basePart;

	/**
	 * Default constructor
	 */
	public TotalSamplePropertiesEditionComponent(EObject totalSample, String editing_mode) {
		if (totalSample instanceof TotalSample) {
			this.totalSample = (TotalSample)totalSample;
			if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				semanticAdapter = initializeSemanticAdapter();
				this.totalSample.eAdapters().add(semanticAdapter);
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
			public void notifyChanged(final Notification msg) {
				if (basePart == null)
					TotalSamplePropertiesEditionComponent.this.dispose();
				else {
					Runnable updateRunnable = new Runnable() {
						public void run() {
							runUpdateRunnable(msg);
						}
					};
					if (null == Display.getCurrent()) {
						PlatformUI.getWorkbench().getDisplay().syncExec(updateRunnable);
					} else {
						updateRunnable.run();
					}
				}
			}

		};
	}

	/**
	 * Used to update the views
	 */
	protected void runUpdateRunnable(final Notification msg) {
		if (EefnrPackage.eINSTANCE.getTotalSample_TextRequiredProperty().equals(msg.getFeature()) && basePart != null){
			if (msg.getNewValue() != null) {
				basePart.setTextRequiredProperty(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
			} else {
				basePart.setTextRequiredProperty("");
			}
		}
		if (EefnrPackage.eINSTANCE.getTotalSample_TextOptionalProperty().equals(msg.getFeature()) && basePart != null){
			if (msg.getNewValue() != null) {
				basePart.setTextOptionalProperty(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
			} else {
				basePart.setTextOptionalProperty("");
			}
		}
		if (EefnrPackage.eINSTANCE.getTotalSample_CheckboxRequiredProperty().equals(msg.getFeature()) && basePart != null)
			basePart.setCheckboxRequiredProperty((Boolean)msg.getNewValue());

		if (EefnrPackage.eINSTANCE.getTotalSample_CheckboxOptionalProperty().equals(msg.getFeature()) && basePart != null)
			basePart.setCheckboxOptionalProperty((Boolean)msg.getNewValue());

		if (EefnrPackage.eINSTANCE.getTotalSample_TextareaRequiredProperty().equals(msg.getFeature()) && basePart != null){
			if (msg.getNewValue() != null) {
				basePart.setTextareaRequiredProperty(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
			} else {
				basePart.setTextareaRequiredProperty("");
			}
		}
		if (EefnrPackage.eINSTANCE.getTotalSample_TextareaOptionalProperty().equals(msg.getFeature()) && basePart != null){
			if (msg.getNewValue() != null) {
				basePart.setTextareaOptionalProperty(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
			} else {
				basePart.setTextareaOptionalProperty("");
			}
		}
		if (EefnrPackage.eINSTANCE.getTotalSample_RadioRequiredProperty().equals(msg.getFeature()) && basePart != null)
			basePart.setRadioRequiredProperty((Enumerator)msg.getNewValue());

		if (EefnrPackage.eINSTANCE.getTotalSample_RadioOptionalProperty().equals(msg.getFeature()) && basePart != null)
			basePart.setRadioOptionalProperty((Enumerator)msg.getNewValue());

		if (EefnrPackage.eINSTANCE.getTotalSample_EobjectflatcomboviewerRequiredProperty().equals(msg.getFeature()) && basePart != null)
			basePart.setEobjectflatcomboviewerRequiredProperty((EObject)msg.getNewValue());
		if (EefnrPackage.eINSTANCE.getTotalSample_EobjectflatcomboviewerOptionalProperty().equals(msg.getFeature()) && basePart != null)
			basePart.setEobjectflatcomboviewerOptionalProperty((EObject)msg.getNewValue());
		if (EefnrPackage.eINSTANCE.getTotalSample_ReferencestableRequiredProperty().equals(msg.getFeature()))
			basePart.updateReferencestableRequiredProperty(totalSample);
		if (EefnrPackage.eINSTANCE.getTotalSample_ReferencestableOptionalProperty().equals(msg.getFeature()))
			basePart.updateReferencestableOptionalProperty(totalSample);
		if (EefnrPackage.eINSTANCE.getTotalSample_EmfcomboviewerRequiredProperty().equals(msg.getFeature()) && basePart != null)
			basePart.setEmfcomboviewerRequiredProperty((Enumerator)msg.getNewValue());

		if (EefnrPackage.eINSTANCE.getTotalSample_EmfcomboviewerOptionalProperty().equals(msg.getFeature()) && basePart != null)
			basePart.setEmfcomboviewerOptionalProperty((Enumerator)msg.getNewValue());

		if (EefnrPackage.eINSTANCE.getTotalSample_MultivaluededitorRequiredProperty().equals(msg.getFeature()) && basePart != null)
			basePart.setMultivaluededitorRequiredProperty((EList)msg.getNewValue());

		if (EefnrPackage.eINSTANCE.getTotalSample_MultivaluededitorOptionalProperty().equals(msg.getFeature()) && basePart != null)
			basePart.setMultivaluededitorOptionalProperty((EList)msg.getNewValue());

		if (msg.getFeature() != null && ((EStructuralFeature)msg.getFeature() == EefnrPackage.eINSTANCE.getTotalSample_TablecompositionRequiredProperty())) {

			basePart.updateTablecompositionRequiredProperty(totalSample);
		}
		if (msg.getFeature() != null && ((EStructuralFeature)msg.getFeature() == EefnrPackage.eINSTANCE.getTotalSample_TablecompositionOptionalProperty())) {

			basePart.updateTablecompositionOptionalProperty(totalSample);
		}
		if (EefnrPackage.eINSTANCE.getTotalSample_AdvancedreferencestableRequiredProperty().equals(msg.getFeature()))
			basePart.updateAdvancedreferencestableRequiredProperty(totalSample);
		if (EefnrPackage.eINSTANCE.getTotalSample_AdvancedreferencestableOptionalProperty().equals(msg.getFeature()))
			basePart.updateAdvancedreferencestableOptionalProperty(totalSample);
		if (EefnrPackage.eINSTANCE.getTotalSample_AdvancedeobjectflatcomboviewerRequiredPropery().equals(msg.getFeature()) && basePart != null)
			basePart.setAdvancedeobjectflatcomboviewerRequiredPropery((EObject)msg.getNewValue());
		if (EefnrPackage.eINSTANCE.getTotalSample_AdvancedeobjectflatcomboviewerOptionalPropery().equals(msg.getFeature()) && basePart != null)
			basePart.setAdvancedeobjectflatcomboviewerOptionalPropery((EObject)msg.getNewValue());
		if (msg.getFeature() != null && ((EStructuralFeature)msg.getFeature() == EefnrPackage.eINSTANCE.getTotalSample_AdvancedtablecompositionRequiredProperty())) {

			basePart.updateAdvancedtablecompositionRequiredProperty(totalSample);
		}
		if (msg.getFeature() != null && ((EStructuralFeature)msg.getFeature() == EefnrPackage.eINSTANCE.getTotalSample_AdvancedtablecompositionOptionalProperty())) {

			basePart.updateAdvancedtablecompositionOptionalProperty(totalSample);
		}
		if (msg.getFeature() != null && ((EStructuralFeature)msg.getFeature() == EefnrPackage.eINSTANCE.getTotalSample_TablecompositionOnSameTypeRequiredProperty())) {

			basePart.updateTablecompositionWithSameTypeRequiredProperty(totalSample);
		}
		if (msg.getFeature() != null && ((EStructuralFeature)msg.getFeature() == EefnrPackage.eINSTANCE.getTotalSample_TablecompositionOnSameTypeOptionalProperty())) {

			basePart.updateTablecompositionWithSameTypeOptionalProperty(totalSample);
		}
		if (msg.getFeature() != null && ((EStructuralFeature)msg.getFeature() == EefnrPackage.eINSTANCE.getTotalSample_AdvancedtablecompositionOnSameTypeRequiredProperty())) {

			basePart.updateAdvancedtablecompositionWithSameTypeRequiredProperty(totalSample);
		}
		if (msg.getFeature() != null && ((EStructuralFeature)msg.getFeature() == EefnrPackage.eINSTANCE.getTotalSample_AdvancedtablecompositionOnSametypeOptionalProperty())) {

			basePart.updateAdvancedtablecompositionWithSameTypeOptionalProperty(totalSample);
		}


	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#translatePart(java.lang.String)
	 */
	public java.lang.Class translatePart(String key) {
		if (BASE_PART.equals(key))
			return EefnrViewsRepository.TotalSample.class;
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
	 *  (java.lang.String, java.lang.String)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (totalSample != null && BASE_PART.equals(key)) {
			if (basePart == null) {
				IPropertiesEditionPartProvider provider = PropertiesEditionPartProviderService.getInstance().getProvider(EefnrViewsRepository.class);
				if (provider != null) {
					basePart = (TotalSamplePropertiesEditionPart)provider.getPropertiesEditionPart(EefnrViewsRepository.TotalSample.class, kind, this);
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
		if (key == EefnrViewsRepository.TotalSample.class)
			this.basePart = (TotalSamplePropertiesEditionPart) propertiesEditionPart;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject elt, ResourceSet allResource) {
		setInitializing(true);
		if (basePart != null && key == EefnrViewsRepository.TotalSample.class) {
			((IPropertiesEditionPart)basePart).setContext(elt, allResource);
			final TotalSample totalSample = (TotalSample)elt;
			// init values
			if (totalSample.getTextRequiredProperty() != null)
				basePart.setTextRequiredProperty(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), totalSample.getTextRequiredProperty()));

			if (totalSample.getTextOptionalProperty() != null)
				basePart.setTextOptionalProperty(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), totalSample.getTextOptionalProperty()));

			basePart.setCheckboxRequiredProperty(totalSample.isCheckboxRequiredProperty());

			basePart.setCheckboxOptionalProperty(totalSample.isCheckboxOptionalProperty());

			if (totalSample.getTextareaRequiredProperty() != null)
				basePart.setTextareaRequiredProperty(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), totalSample.getTextareaRequiredProperty()));

			if (totalSample.getTextareaOptionalProperty() != null)
				basePart.setTextareaOptionalProperty(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), totalSample.getTextareaOptionalProperty()));

			basePart.initRadioRequiredProperty((EEnum) EefnrPackage.eINSTANCE.getTotalSample_RadioRequiredProperty().getEType(), totalSample.getRadioRequiredProperty());
			basePart.initRadioOptionalProperty((EEnum) EefnrPackage.eINSTANCE.getTotalSample_RadioOptionalProperty().getEType(), totalSample.getRadioOptionalProperty());
			// init part
			basePart.initEobjectflatcomboviewerRequiredProperty(allResource, totalSample.getEobjectflatcomboviewerRequiredProperty());
			// set the button mode
			basePart.setEobjectflatcomboviewerRequiredPropertyButtonMode(ButtonsModeEnum.BROWSE);
			// init part
			basePart.initEobjectflatcomboviewerOptionalProperty(allResource, totalSample.getEobjectflatcomboviewerOptionalProperty());
			// set the button mode
			basePart.setEobjectflatcomboviewerOptionalPropertyButtonMode(ButtonsModeEnum.BROWSE);
			basePart.initReferencestableRequiredProperty(totalSample, null, EefnrPackage.eINSTANCE.getTotalSample_ReferencestableRequiredProperty());
			basePart.initReferencestableOptionalProperty(totalSample, null, EefnrPackage.eINSTANCE.getTotalSample_ReferencestableOptionalProperty());
			basePart.initEmfcomboviewerRequiredProperty((EEnum) EefnrPackage.eINSTANCE.getTotalSample_EmfcomboviewerRequiredProperty().getEType(), totalSample.getEmfcomboviewerRequiredProperty());
			basePart.initEmfcomboviewerOptionalProperty((EEnum) EefnrPackage.eINSTANCE.getTotalSample_EmfcomboviewerOptionalProperty().getEType(), totalSample.getEmfcomboviewerOptionalProperty());
			if (totalSample.getMultivaluededitorRequiredProperty() != null)
				basePart.setMultivaluededitorRequiredProperty(totalSample.getMultivaluededitorRequiredProperty());

			if (totalSample.getMultivaluededitorOptionalProperty() != null)
				basePart.setMultivaluededitorOptionalProperty(totalSample.getMultivaluededitorOptionalProperty());

			basePart.initTablecompositionRequiredProperty(totalSample, null, EefnrPackage.eINSTANCE.getTotalSample_TablecompositionRequiredProperty());
			basePart.initTablecompositionOptionalProperty(totalSample, null, EefnrPackage.eINSTANCE.getTotalSample_TablecompositionOptionalProperty());
			basePart.initAdvancedreferencestableRequiredProperty(totalSample, null, EefnrPackage.eINSTANCE.getTotalSample_AdvancedreferencestableRequiredProperty());
			basePart.initAdvancedreferencestableOptionalProperty(totalSample, null, EefnrPackage.eINSTANCE.getTotalSample_AdvancedreferencestableOptionalProperty());
			// init part
			basePart.initAdvancedeobjectflatcomboviewerRequiredPropery(allResource, totalSample.getAdvancedeobjectflatcomboviewerRequiredPropery());
			// set the button mode
			basePart.setAdvancedeobjectflatcomboviewerRequiredProperyButtonMode(ButtonsModeEnum.BROWSE);
			// init part
			basePart.initAdvancedeobjectflatcomboviewerOptionalPropery(allResource, totalSample.getAdvancedeobjectflatcomboviewerOptionalPropery());
			// set the button mode
			basePart.setAdvancedeobjectflatcomboviewerOptionalProperyButtonMode(ButtonsModeEnum.BROWSE);
			basePart.initAdvancedtablecompositionRequiredProperty(totalSample, null, EefnrPackage.eINSTANCE.getTotalSample_AdvancedtablecompositionRequiredProperty());
			basePart.initAdvancedtablecompositionOptionalProperty(totalSample, null, EefnrPackage.eINSTANCE.getTotalSample_AdvancedtablecompositionOptionalProperty());
			basePart.initTablecompositionWithSameTypeRequiredProperty(totalSample, null, EefnrPackage.eINSTANCE.getTotalSample_TablecompositionOnSameTypeRequiredProperty());
			basePart.initTablecompositionWithSameTypeOptionalProperty(totalSample, null, EefnrPackage.eINSTANCE.getTotalSample_TablecompositionOnSameTypeOptionalProperty());
			basePart.initAdvancedtablecompositionWithSameTypeRequiredProperty(totalSample, null, EefnrPackage.eINSTANCE.getTotalSample_AdvancedtablecompositionOnSameTypeRequiredProperty());
			basePart.initAdvancedtablecompositionWithSameTypeOptionalProperty(totalSample, null, EefnrPackage.eINSTANCE.getTotalSample_AdvancedtablecompositionOnSametypeOptionalProperty());
			// init filters








			basePart.addFilterToEobjectflatcomboviewerRequiredProperty(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof TotalSample);
				}

			});
			// Start of user code for additional businessfilters for eobjectflatcomboviewerRequiredProperty
			
			// End of user code
			basePart.addFilterToEobjectflatcomboviewerOptionalProperty(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof TotalSample); //$NON-NLS-1$ 
				}

			});
			// Start of user code for additional businessfilters for eobjectflatcomboviewerOptionalProperty
			
			// End of user code
			basePart.addFilterToReferencestableRequiredProperty(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if (element instanceof EObject)
						return (!basePart.isContainedInReferencestableRequiredPropertyTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToReferencestableRequiredProperty(new EObjectFilter(EefnrPackage.eINSTANCE.getTotalSample()));
			// Start of user code for additional businessfilters for referencestableRequiredProperty
			
			// End of user code
			basePart.addFilterToReferencestableOptionalProperty(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if (element instanceof EObject)
						return (!basePart.isContainedInReferencestableOptionalPropertyTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToReferencestableOptionalProperty(new EObjectFilter(EefnrPackage.eINSTANCE.getTotalSample()));
			// Start of user code for additional businessfilters for referencestableOptionalProperty
			
			// End of user code




			basePart.addFilterToTablecompositionRequiredProperty(new ViewerFilter() {

					/*
					 * (non-Javadoc)
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof Sample);

				}

			});
			// Start of user code for additional businessfilters for tablecompositionRequiredProperty
			
			// End of user code
			basePart.addFilterToTablecompositionOptionalProperty(new ViewerFilter() {

					/*
					 * (non-Javadoc)
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Sample); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for tablecompositionOptionalProperty
			
			// End of user code
			basePart.addFilterToAdvancedreferencestableRequiredProperty(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if (element instanceof EObject)
						return (!basePart.isContainedInAdvancedreferencestableRequiredPropertyTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToAdvancedreferencestableRequiredProperty(new EObjectFilter(EefnrPackage.eINSTANCE.getTotalSample()));
			// Start of user code for additional businessfilters for advancedreferencestableRequiredProperty
			
			// End of user code
			basePart.addFilterToAdvancedreferencestableOptionalProperty(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					if (element instanceof EObject)
						return (!basePart.isContainedInAdvancedreferencestableOptionalPropertyTable((EObject)element));
					return element instanceof Resource;
				}

			});
			basePart.addFilterToAdvancedreferencestableOptionalProperty(new EObjectFilter(EefnrPackage.eINSTANCE.getTotalSample()));
			// Start of user code for additional businessfilters for advancedreferencestableOptionalProperty
			
			// End of user code
			basePart.addFilterToAdvancedeobjectflatcomboviewerRequiredPropery(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof TotalSample);
				}

			});
			// Start of user code for additional businessfilters for advancedeobjectflatcomboviewerRequiredPropery
			
			// End of user code
			basePart.addFilterToAdvancedeobjectflatcomboviewerOptionalPropery(new ViewerFilter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
				 */
				public boolean select(Viewer viewer, Object parentElement, Object element) {
					return (element instanceof String && element.equals("")) || (element instanceof TotalSample); //$NON-NLS-1$ 
				}

			});
			// Start of user code for additional businessfilters for advancedeobjectflatcomboviewerOptionalPropery
			
			// End of user code
			basePart.addFilterToAdvancedtablecompositionRequiredProperty(new ViewerFilter() {

					/*
					 * (non-Javadoc)
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof Sample);

				}

			});
			// Start of user code for additional businessfilters for advancedtablecompositionRequiredProperty
			
			// End of user code
			basePart.addFilterToAdvancedtablecompositionOptionalProperty(new ViewerFilter() {

					/*
					 * (non-Javadoc)
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Sample); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for advancedtablecompositionOptionalProperty
			
			// End of user code
			basePart.addFilterToTablecompositionWithSameTypeRequiredProperty(new ViewerFilter() {

					/*
					 * (non-Javadoc)
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof TotalSample);

				}

			});
			// Start of user code for additional businessfilters for tablecompositionWithSameTypeRequiredProperty
			
			// End of user code
			basePart.addFilterToTablecompositionWithSameTypeOptionalProperty(new ViewerFilter() {

					/*
					 * (non-Javadoc)
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof TotalSample); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for tablecompositionWithSameTypeOptionalProperty
			
			// End of user code
			basePart.addFilterToAdvancedtablecompositionWithSameTypeRequiredProperty(new ViewerFilter() {

					/*
					 * (non-Javadoc)
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof TotalSample);

				}

			});
			// Start of user code for additional businessfilters for advancedtablecompositionWithSameTypeRequiredProperty
			
			// End of user code
			basePart.addFilterToAdvancedtablecompositionWithSameTypeOptionalProperty(new ViewerFilter() {

					/*
					 * (non-Javadoc)
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof TotalSample); //$NON-NLS-1$ 

				}

			});
			// Start of user code for additional businessfilters for advancedtablecompositionWithSameTypeOptionalProperty
			
			// End of user code
		}
		// init values for referenced views

		// init filters for referenced views

		setInitializing(false);
	}
































	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionCommand
	 *     (org.eclipse.emf.edit.domain.EditingDomain)
	 */
	public CompoundCommand getPropertiesEditionCommand(EditingDomain editingDomain) {
		CompoundCommand cc = new CompoundCommand();
		if ((totalSample != null) && (basePart != null)) { 
			cc.append(SetCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_TextRequiredProperty(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), basePart.getTextRequiredProperty())));
			cc.append(SetCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_TextOptionalProperty(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), basePart.getTextOptionalProperty())));
			cc.append(SetCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_CheckboxRequiredProperty(), basePart.getCheckboxRequiredProperty()));

			cc.append(SetCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_CheckboxOptionalProperty(), basePart.getCheckboxOptionalProperty()));

			cc.append(SetCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_TextareaRequiredProperty(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), basePart.getTextareaRequiredProperty())));
			cc.append(SetCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_TextareaOptionalProperty(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), basePart.getTextareaOptionalProperty())));
			cc.append(SetCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_RadioRequiredProperty(), basePart.getRadioRequiredProperty()));

			cc.append(SetCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_RadioOptionalProperty(), basePart.getRadioOptionalProperty()));

			if (totalSample.eGet(EefnrPackage.eINSTANCE.getTotalSample_EobjectflatcomboviewerRequiredProperty()) == null || !totalSample.eGet(EefnrPackage.eINSTANCE.getTotalSample_EobjectflatcomboviewerRequiredProperty()).equals(basePart.getEobjectflatcomboviewerRequiredProperty())) {
				cc.append(SetCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_EobjectflatcomboviewerRequiredProperty(), basePart.getEobjectflatcomboviewerRequiredProperty()));
			}
			if (totalSample.eGet(EefnrPackage.eINSTANCE.getTotalSample_EobjectflatcomboviewerOptionalProperty()) == null || !totalSample.eGet(EefnrPackage.eINSTANCE.getTotalSample_EobjectflatcomboviewerOptionalProperty()).equals(basePart.getEobjectflatcomboviewerOptionalProperty())) {
				cc.append(SetCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_EobjectflatcomboviewerOptionalProperty(), basePart.getEobjectflatcomboviewerOptionalProperty()));
			}
			List referencestableRequiredPropertyToAddFromReferencestableRequiredProperty = basePart.getReferencestableRequiredPropertyToAdd();
			for (Iterator iter = referencestableRequiredPropertyToAddFromReferencestableRequiredProperty.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_ReferencestableRequiredProperty(), iter.next()));
			List referencestableRequiredPropertyToRemoveFromReferencestableRequiredProperty = basePart.getReferencestableRequiredPropertyToRemove();
			for (Iterator iter = referencestableRequiredPropertyToRemoveFromReferencestableRequiredProperty.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_ReferencestableRequiredProperty(), iter.next()));
			//List referencestableRequiredPropertyToMoveFromReferencestableRequiredProperty = basePart.getReferencestableRequiredPropertyToMove();
			//for (Iterator iter = referencestableRequiredPropertyToMoveFromReferencestableRequiredProperty.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List referencestableOptionalPropertyToAddFromReferencestableOptionalProperty = basePart.getReferencestableOptionalPropertyToAdd();
			for (Iterator iter = referencestableOptionalPropertyToAddFromReferencestableOptionalProperty.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_ReferencestableOptionalProperty(), iter.next()));
			List referencestableOptionalPropertyToRemoveFromReferencestableOptionalProperty = basePart.getReferencestableOptionalPropertyToRemove();
			for (Iterator iter = referencestableOptionalPropertyToRemoveFromReferencestableOptionalProperty.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_ReferencestableOptionalProperty(), iter.next()));
			//List referencestableOptionalPropertyToMoveFromReferencestableOptionalProperty = basePart.getReferencestableOptionalPropertyToMove();
			//for (Iterator iter = referencestableOptionalPropertyToMoveFromReferencestableOptionalProperty.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample(), moveElement.getElement(), moveElement.getIndex()));
			//}
			cc.append(SetCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_EmfcomboviewerRequiredProperty(), basePart.getEmfcomboviewerRequiredProperty()));

			cc.append(SetCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_EmfcomboviewerOptionalProperty(), basePart.getEmfcomboviewerOptionalProperty()));

			cc.append(SetCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_MultivaluededitorRequiredProperty(), basePart.getMultivaluededitorRequiredProperty()));

			cc.append(SetCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_MultivaluededitorOptionalProperty(), basePart.getMultivaluededitorOptionalProperty()));

			List tablecompositionRequiredPropertyToAddFromTablecompositionRequiredProperty = basePart.getTablecompositionRequiredPropertyToAdd();
			for (Iterator iter = tablecompositionRequiredPropertyToAddFromTablecompositionRequiredProperty.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_TablecompositionRequiredProperty(), iter.next()));
			Map tablecompositionRequiredPropertyToRefreshFromTablecompositionRequiredProperty = basePart.getTablecompositionRequiredPropertyToEdit();
			for (Iterator iter = tablecompositionRequiredPropertyToRefreshFromTablecompositionRequiredProperty.keySet().iterator(); iter.hasNext();) {
				
				Sample nextElement = (Sample) iter.next();
				Sample tablecompositionRequiredProperty = (Sample) tablecompositionRequiredPropertyToRefreshFromTablecompositionRequiredProperty.get(nextElement);
				for (EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if (feature.isChangeable() && !(feature instanceof EReference && ((EReference) feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, tablecompositionRequiredProperty.eGet(feature)));
					}
				}
				
			}
			List tablecompositionRequiredPropertyToRemoveFromTablecompositionRequiredProperty = basePart.getTablecompositionRequiredPropertyToRemove();
			for (Iterator iter = tablecompositionRequiredPropertyToRemoveFromTablecompositionRequiredProperty.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List tablecompositionRequiredPropertyToMoveFromTablecompositionRequiredProperty = basePart.getTablecompositionRequiredPropertyToMove();
			for (Iterator iter = tablecompositionRequiredPropertyToMoveFromTablecompositionRequiredProperty.iterator(); iter.hasNext();){
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getSample(), moveElement.getElement(), moveElement.getIndex()));
			}
			List tablecompositionOptionalPropertyToAddFromTablecompositionOptionalProperty = basePart.getTablecompositionOptionalPropertyToAdd();
			for (Iterator iter = tablecompositionOptionalPropertyToAddFromTablecompositionOptionalProperty.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_TablecompositionOptionalProperty(), iter.next()));
			Map tablecompositionOptionalPropertyToRefreshFromTablecompositionOptionalProperty = basePart.getTablecompositionOptionalPropertyToEdit();
			for (Iterator iter = tablecompositionOptionalPropertyToRefreshFromTablecompositionOptionalProperty.keySet().iterator(); iter.hasNext();) {
				
				Sample nextElement = (Sample) iter.next();
				Sample tablecompositionOptionalProperty = (Sample) tablecompositionOptionalPropertyToRefreshFromTablecompositionOptionalProperty.get(nextElement);
				for (EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if (feature.isChangeable() && !(feature instanceof EReference && ((EReference) feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, tablecompositionOptionalProperty.eGet(feature)));
					}
				}
				
			}
			List tablecompositionOptionalPropertyToRemoveFromTablecompositionOptionalProperty = basePart.getTablecompositionOptionalPropertyToRemove();
			for (Iterator iter = tablecompositionOptionalPropertyToRemoveFromTablecompositionOptionalProperty.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List tablecompositionOptionalPropertyToMoveFromTablecompositionOptionalProperty = basePart.getTablecompositionOptionalPropertyToMove();
			for (Iterator iter = tablecompositionOptionalPropertyToMoveFromTablecompositionOptionalProperty.iterator(); iter.hasNext();){
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getSample(), moveElement.getElement(), moveElement.getIndex()));
			}
			List advancedreferencestableRequiredPropertyToAddFromAdvancedreferencestableRequiredProperty = basePart.getAdvancedreferencestableRequiredPropertyToAdd();
			for (Iterator iter = advancedreferencestableRequiredPropertyToAddFromAdvancedreferencestableRequiredProperty.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_AdvancedreferencestableRequiredProperty(), iter.next()));
			List advancedreferencestableRequiredPropertyToRemoveFromAdvancedreferencestableRequiredProperty = basePart.getAdvancedreferencestableRequiredPropertyToRemove();
			for (Iterator iter = advancedreferencestableRequiredPropertyToRemoveFromAdvancedreferencestableRequiredProperty.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_AdvancedreferencestableRequiredProperty(), iter.next()));
			//List advancedreferencestableRequiredPropertyToMoveFromAdvancedreferencestableRequiredProperty = basePart.getAdvancedreferencestableRequiredPropertyToMove();
			//for (Iterator iter = advancedreferencestableRequiredPropertyToMoveFromAdvancedreferencestableRequiredProperty.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample(), moveElement.getElement(), moveElement.getIndex()));
			//}
			List advancedreferencestableOptionalPropertyToAddFromAdvancedreferencestableOptionalProperty = basePart.getAdvancedreferencestableOptionalPropertyToAdd();
			for (Iterator iter = advancedreferencestableOptionalPropertyToAddFromAdvancedreferencestableOptionalProperty.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_AdvancedreferencestableOptionalProperty(), iter.next()));
			List advancedreferencestableOptionalPropertyToRemoveFromAdvancedreferencestableOptionalProperty = basePart.getAdvancedreferencestableOptionalPropertyToRemove();
			for (Iterator iter = advancedreferencestableOptionalPropertyToRemoveFromAdvancedreferencestableOptionalProperty.iterator(); iter.hasNext();)
				cc.append(RemoveCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_AdvancedreferencestableOptionalProperty(), iter.next()));
			//List advancedreferencestableOptionalPropertyToMoveFromAdvancedreferencestableOptionalProperty = basePart.getAdvancedreferencestableOptionalPropertyToMove();
			//for (Iterator iter = advancedreferencestableOptionalPropertyToMoveFromAdvancedreferencestableOptionalProperty.iterator(); iter.hasNext();){
			//	org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
			//	cc.append(MoveCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample(), moveElement.getElement(), moveElement.getIndex()));
			//}
			if (totalSample.eGet(EefnrPackage.eINSTANCE.getTotalSample_AdvancedeobjectflatcomboviewerRequiredPropery()) == null || !totalSample.eGet(EefnrPackage.eINSTANCE.getTotalSample_AdvancedeobjectflatcomboviewerRequiredPropery()).equals(basePart.getAdvancedeobjectflatcomboviewerRequiredPropery())) {
				cc.append(SetCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_AdvancedeobjectflatcomboviewerRequiredPropery(), basePart.getAdvancedeobjectflatcomboviewerRequiredPropery()));
			}
			if (totalSample.eGet(EefnrPackage.eINSTANCE.getTotalSample_AdvancedeobjectflatcomboviewerOptionalPropery()) == null || !totalSample.eGet(EefnrPackage.eINSTANCE.getTotalSample_AdvancedeobjectflatcomboviewerOptionalPropery()).equals(basePart.getAdvancedeobjectflatcomboviewerOptionalPropery())) {
				cc.append(SetCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_AdvancedeobjectflatcomboviewerOptionalPropery(), basePart.getAdvancedeobjectflatcomboviewerOptionalPropery()));
			}
			List advancedtablecompositionRequiredPropertyToAddFromAdvancedtablecompositionRequiredProperty = basePart.getAdvancedtablecompositionRequiredPropertyToAdd();
			for (Iterator iter = advancedtablecompositionRequiredPropertyToAddFromAdvancedtablecompositionRequiredProperty.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_AdvancedtablecompositionRequiredProperty(), iter.next()));
			Map advancedtablecompositionRequiredPropertyToRefreshFromAdvancedtablecompositionRequiredProperty = basePart.getAdvancedtablecompositionRequiredPropertyToEdit();
			for (Iterator iter = advancedtablecompositionRequiredPropertyToRefreshFromAdvancedtablecompositionRequiredProperty.keySet().iterator(); iter.hasNext();) {
				
				Sample nextElement = (Sample) iter.next();
				Sample advancedtablecompositionRequiredProperty = (Sample) advancedtablecompositionRequiredPropertyToRefreshFromAdvancedtablecompositionRequiredProperty.get(nextElement);
				for (EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if (feature.isChangeable() && !(feature instanceof EReference && ((EReference) feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, advancedtablecompositionRequiredProperty.eGet(feature)));
					}
				}
				
			}
			List advancedtablecompositionRequiredPropertyToRemoveFromAdvancedtablecompositionRequiredProperty = basePart.getAdvancedtablecompositionRequiredPropertyToRemove();
			for (Iterator iter = advancedtablecompositionRequiredPropertyToRemoveFromAdvancedtablecompositionRequiredProperty.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List advancedtablecompositionRequiredPropertyToMoveFromAdvancedtablecompositionRequiredProperty = basePart.getAdvancedtablecompositionRequiredPropertyToMove();
			for (Iterator iter = advancedtablecompositionRequiredPropertyToMoveFromAdvancedtablecompositionRequiredProperty.iterator(); iter.hasNext();){
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getSample(), moveElement.getElement(), moveElement.getIndex()));
			}
			List advancedtablecompositionOptionalPropertyToAddFromAdvancedtablecompositionOptionalProperty = basePart.getAdvancedtablecompositionOptionalPropertyToAdd();
			for (Iterator iter = advancedtablecompositionOptionalPropertyToAddFromAdvancedtablecompositionOptionalProperty.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_AdvancedtablecompositionOptionalProperty(), iter.next()));
			Map advancedtablecompositionOptionalPropertyToRefreshFromAdvancedtablecompositionOptionalProperty = basePart.getAdvancedtablecompositionOptionalPropertyToEdit();
			for (Iterator iter = advancedtablecompositionOptionalPropertyToRefreshFromAdvancedtablecompositionOptionalProperty.keySet().iterator(); iter.hasNext();) {
				
				Sample nextElement = (Sample) iter.next();
				Sample advancedtablecompositionOptionalProperty = (Sample) advancedtablecompositionOptionalPropertyToRefreshFromAdvancedtablecompositionOptionalProperty.get(nextElement);
				for (EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if (feature.isChangeable() && !(feature instanceof EReference && ((EReference) feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, advancedtablecompositionOptionalProperty.eGet(feature)));
					}
				}
				
			}
			List advancedtablecompositionOptionalPropertyToRemoveFromAdvancedtablecompositionOptionalProperty = basePart.getAdvancedtablecompositionOptionalPropertyToRemove();
			for (Iterator iter = advancedtablecompositionOptionalPropertyToRemoveFromAdvancedtablecompositionOptionalProperty.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List advancedtablecompositionOptionalPropertyToMoveFromAdvancedtablecompositionOptionalProperty = basePart.getAdvancedtablecompositionOptionalPropertyToMove();
			for (Iterator iter = advancedtablecompositionOptionalPropertyToMoveFromAdvancedtablecompositionOptionalProperty.iterator(); iter.hasNext();){
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getSample(), moveElement.getElement(), moveElement.getIndex()));
			}
			List tablecompositionOnSameTypeRequiredPropertyToAddFromTablecompositionWithSameTypeRequiredProperty = basePart.getTablecompositionWithSameTypeRequiredPropertyToAdd();
			for (Iterator iter = tablecompositionOnSameTypeRequiredPropertyToAddFromTablecompositionWithSameTypeRequiredProperty.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_TablecompositionOnSameTypeRequiredProperty(), iter.next()));
			Map tablecompositionOnSameTypeRequiredPropertyToRefreshFromTablecompositionWithSameTypeRequiredProperty = basePart.getTablecompositionWithSameTypeRequiredPropertyToEdit();
			for (Iterator iter = tablecompositionOnSameTypeRequiredPropertyToRefreshFromTablecompositionWithSameTypeRequiredProperty.keySet().iterator(); iter.hasNext();) {
				
				TotalSample nextElement = (TotalSample) iter.next();
				TotalSample tablecompositionOnSameTypeRequiredProperty = (TotalSample) tablecompositionOnSameTypeRequiredPropertyToRefreshFromTablecompositionWithSameTypeRequiredProperty.get(nextElement);
				for (EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if (feature.isChangeable() && !(feature instanceof EReference && ((EReference) feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, tablecompositionOnSameTypeRequiredProperty.eGet(feature)));
					}
				}
				
			}
			List tablecompositionOnSameTypeRequiredPropertyToRemoveFromTablecompositionWithSameTypeRequiredProperty = basePart.getTablecompositionWithSameTypeRequiredPropertyToRemove();
			for (Iterator iter = tablecompositionOnSameTypeRequiredPropertyToRemoveFromTablecompositionWithSameTypeRequiredProperty.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List tablecompositionOnSameTypeRequiredPropertyToMoveFromTablecompositionWithSameTypeRequiredProperty = basePart.getTablecompositionWithSameTypeRequiredPropertyToMove();
			for (Iterator iter = tablecompositionOnSameTypeRequiredPropertyToMoveFromTablecompositionWithSameTypeRequiredProperty.iterator(); iter.hasNext();){
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample(), moveElement.getElement(), moveElement.getIndex()));
			}
			List tablecompositionOnSameTypeOptionalPropertyToAddFromTablecompositionWithSameTypeOptionalProperty = basePart.getTablecompositionWithSameTypeOptionalPropertyToAdd();
			for (Iterator iter = tablecompositionOnSameTypeOptionalPropertyToAddFromTablecompositionWithSameTypeOptionalProperty.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_TablecompositionOnSameTypeOptionalProperty(), iter.next()));
			Map tablecompositionOnSameTypeOptionalPropertyToRefreshFromTablecompositionWithSameTypeOptionalProperty = basePart.getTablecompositionWithSameTypeOptionalPropertyToEdit();
			for (Iterator iter = tablecompositionOnSameTypeOptionalPropertyToRefreshFromTablecompositionWithSameTypeOptionalProperty.keySet().iterator(); iter.hasNext();) {
				
				TotalSample nextElement = (TotalSample) iter.next();
				TotalSample tablecompositionOnSameTypeOptionalProperty = (TotalSample) tablecompositionOnSameTypeOptionalPropertyToRefreshFromTablecompositionWithSameTypeOptionalProperty.get(nextElement);
				for (EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if (feature.isChangeable() && !(feature instanceof EReference && ((EReference) feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, tablecompositionOnSameTypeOptionalProperty.eGet(feature)));
					}
				}
				
			}
			List tablecompositionOnSameTypeOptionalPropertyToRemoveFromTablecompositionWithSameTypeOptionalProperty = basePart.getTablecompositionWithSameTypeOptionalPropertyToRemove();
			for (Iterator iter = tablecompositionOnSameTypeOptionalPropertyToRemoveFromTablecompositionWithSameTypeOptionalProperty.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List tablecompositionOnSameTypeOptionalPropertyToMoveFromTablecompositionWithSameTypeOptionalProperty = basePart.getTablecompositionWithSameTypeOptionalPropertyToMove();
			for (Iterator iter = tablecompositionOnSameTypeOptionalPropertyToMoveFromTablecompositionWithSameTypeOptionalProperty.iterator(); iter.hasNext();){
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample(), moveElement.getElement(), moveElement.getIndex()));
			}
			List advancedtablecompositionOnSameTypeRequiredPropertyToAddFromAdvancedtablecompositionWithSameTypeRequiredProperty = basePart.getAdvancedtablecompositionWithSameTypeRequiredPropertyToAdd();
			for (Iterator iter = advancedtablecompositionOnSameTypeRequiredPropertyToAddFromAdvancedtablecompositionWithSameTypeRequiredProperty.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_AdvancedtablecompositionOnSameTypeRequiredProperty(), iter.next()));
			Map advancedtablecompositionOnSameTypeRequiredPropertyToRefreshFromAdvancedtablecompositionWithSameTypeRequiredProperty = basePart.getAdvancedtablecompositionWithSameTypeRequiredPropertyToEdit();
			for (Iterator iter = advancedtablecompositionOnSameTypeRequiredPropertyToRefreshFromAdvancedtablecompositionWithSameTypeRequiredProperty.keySet().iterator(); iter.hasNext();) {
				
				TotalSample nextElement = (TotalSample) iter.next();
				TotalSample advancedtablecompositionOnSameTypeRequiredProperty = (TotalSample) advancedtablecompositionOnSameTypeRequiredPropertyToRefreshFromAdvancedtablecompositionWithSameTypeRequiredProperty.get(nextElement);
				for (EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if (feature.isChangeable() && !(feature instanceof EReference && ((EReference) feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, advancedtablecompositionOnSameTypeRequiredProperty.eGet(feature)));
					}
				}
				
			}
			List advancedtablecompositionOnSameTypeRequiredPropertyToRemoveFromAdvancedtablecompositionWithSameTypeRequiredProperty = basePart.getAdvancedtablecompositionWithSameTypeRequiredPropertyToRemove();
			for (Iterator iter = advancedtablecompositionOnSameTypeRequiredPropertyToRemoveFromAdvancedtablecompositionWithSameTypeRequiredProperty.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List advancedtablecompositionOnSameTypeRequiredPropertyToMoveFromAdvancedtablecompositionWithSameTypeRequiredProperty = basePart.getAdvancedtablecompositionWithSameTypeRequiredPropertyToMove();
			for (Iterator iter = advancedtablecompositionOnSameTypeRequiredPropertyToMoveFromAdvancedtablecompositionWithSameTypeRequiredProperty.iterator(); iter.hasNext();){
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample(), moveElement.getElement(), moveElement.getIndex()));
			}
			List advancedtablecompositionOnSametypeOptionalPropertyToAddFromAdvancedtablecompositionWithSameTypeOptionalProperty = basePart.getAdvancedtablecompositionWithSameTypeOptionalPropertyToAdd();
			for (Iterator iter = advancedtablecompositionOnSametypeOptionalPropertyToAddFromAdvancedtablecompositionWithSameTypeOptionalProperty.iterator(); iter.hasNext();)
				cc.append(AddCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_AdvancedtablecompositionOnSametypeOptionalProperty(), iter.next()));
			Map advancedtablecompositionOnSametypeOptionalPropertyToRefreshFromAdvancedtablecompositionWithSameTypeOptionalProperty = basePart.getAdvancedtablecompositionWithSameTypeOptionalPropertyToEdit();
			for (Iterator iter = advancedtablecompositionOnSametypeOptionalPropertyToRefreshFromAdvancedtablecompositionWithSameTypeOptionalProperty.keySet().iterator(); iter.hasNext();) {
				
				TotalSample nextElement = (TotalSample) iter.next();
				TotalSample advancedtablecompositionOnSametypeOptionalProperty = (TotalSample) advancedtablecompositionOnSametypeOptionalPropertyToRefreshFromAdvancedtablecompositionWithSameTypeOptionalProperty.get(nextElement);
				for (EStructuralFeature feature : nextElement.eClass().getEAllStructuralFeatures()) {
					if (feature.isChangeable() && !(feature instanceof EReference && ((EReference) feature).isContainer())) {
						cc.append(SetCommand.create(editingDomain, nextElement, feature, advancedtablecompositionOnSametypeOptionalProperty.eGet(feature)));
					}
				}
				
			}
			List advancedtablecompositionOnSametypeOptionalPropertyToRemoveFromAdvancedtablecompositionWithSameTypeOptionalProperty = basePart.getAdvancedtablecompositionWithSameTypeOptionalPropertyToRemove();
			for (Iterator iter = advancedtablecompositionOnSametypeOptionalPropertyToRemoveFromAdvancedtablecompositionWithSameTypeOptionalProperty.iterator(); iter.hasNext();)
				cc.append(DeleteCommand.create(editingDomain, iter.next()));
			List advancedtablecompositionOnSametypeOptionalPropertyToMoveFromAdvancedtablecompositionWithSameTypeOptionalProperty = basePart.getAdvancedtablecompositionWithSameTypeOptionalPropertyToMove();
			for (Iterator iter = advancedtablecompositionOnSametypeOptionalPropertyToMoveFromAdvancedtablecompositionWithSameTypeOptionalProperty.iterator(); iter.hasNext();){
				org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement moveElement = (org.eclipse.emf.eef.runtime.impl.utils.EMFListEditUtil.MoveElement)iter.next();
				cc.append(MoveCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample(), moveElement.getElement(), moveElement.getIndex()));
			}


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
		if (source instanceof TotalSample) {
			TotalSample totalSampleToUpdate = (TotalSample)source;
			totalSampleToUpdate.setTextRequiredProperty((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), basePart.getTextRequiredProperty()));

			totalSampleToUpdate.setTextOptionalProperty((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), basePart.getTextOptionalProperty()));

			totalSampleToUpdate.setCheckboxRequiredProperty(new Boolean(basePart.getCheckboxRequiredProperty()).booleanValue());

			totalSampleToUpdate.setCheckboxOptionalProperty(new Boolean(basePart.getCheckboxOptionalProperty()).booleanValue());

			totalSampleToUpdate.setTextareaRequiredProperty((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), basePart.getTextareaRequiredProperty()));

			totalSampleToUpdate.setTextareaOptionalProperty((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), basePart.getTextareaOptionalProperty()));

			totalSampleToUpdate.setRadioRequiredProperty((ENUM_SAMPLE)basePart.getRadioRequiredProperty());

			totalSampleToUpdate.setRadioOptionalProperty((ENUM_SAMPLE)basePart.getRadioOptionalProperty());

			totalSampleToUpdate.setEobjectflatcomboviewerRequiredProperty((TotalSample)basePart.getEobjectflatcomboviewerRequiredProperty());
			totalSampleToUpdate.setEobjectflatcomboviewerOptionalProperty((TotalSample)basePart.getEobjectflatcomboviewerOptionalProperty());
			totalSampleToUpdate.getReferencestableRequiredProperty().addAll(basePart.getReferencestableRequiredPropertyToAdd());
			totalSampleToUpdate.getReferencestableOptionalProperty().addAll(basePart.getReferencestableOptionalPropertyToAdd());
			totalSampleToUpdate.setEmfcomboviewerRequiredProperty((ENUM_SAMPLE)basePart.getEmfcomboviewerRequiredProperty());

			totalSampleToUpdate.setEmfcomboviewerOptionalProperty((ENUM_SAMPLE)basePart.getEmfcomboviewerOptionalProperty());

			totalSampleToUpdate.getMultivaluededitorRequiredProperty().addAll(basePart.getMultivaluededitorRequiredProperty());

			totalSampleToUpdate.getMultivaluededitorOptionalProperty().addAll(basePart.getMultivaluededitorOptionalProperty());

			totalSampleToUpdate.getTablecompositionRequiredProperty().addAll(basePart.getTablecompositionRequiredPropertyToAdd());
			totalSampleToUpdate.getTablecompositionOptionalProperty().addAll(basePart.getTablecompositionOptionalPropertyToAdd());
			totalSampleToUpdate.getAdvancedreferencestableRequiredProperty().addAll(basePart.getAdvancedreferencestableRequiredPropertyToAdd());
			totalSampleToUpdate.getAdvancedreferencestableOptionalProperty().addAll(basePart.getAdvancedreferencestableOptionalPropertyToAdd());
			totalSampleToUpdate.setAdvancedeobjectflatcomboviewerRequiredPropery((TotalSample)basePart.getAdvancedeobjectflatcomboviewerRequiredPropery());
			totalSampleToUpdate.setAdvancedeobjectflatcomboviewerOptionalPropery((TotalSample)basePart.getAdvancedeobjectflatcomboviewerOptionalPropery());
			totalSampleToUpdate.getAdvancedtablecompositionRequiredProperty().addAll(basePart.getAdvancedtablecompositionRequiredPropertyToAdd());
			totalSampleToUpdate.getAdvancedtablecompositionOptionalProperty().addAll(basePart.getAdvancedtablecompositionOptionalPropertyToAdd());
			totalSampleToUpdate.getTablecompositionOnSameTypeRequiredProperty().addAll(basePart.getTablecompositionWithSameTypeRequiredPropertyToAdd());
			totalSampleToUpdate.getTablecompositionOnSameTypeOptionalProperty().addAll(basePart.getTablecompositionWithSameTypeOptionalPropertyToAdd());
			totalSampleToUpdate.getAdvancedtablecompositionOnSameTypeRequiredProperty().addAll(basePart.getAdvancedtablecompositionWithSameTypeRequiredPropertyToAdd());
			totalSampleToUpdate.getAdvancedtablecompositionOnSametypeOptionalProperty().addAll(basePart.getAdvancedtablecompositionWithSameTypeOptionalPropertyToAdd());


			return totalSampleToUpdate;
		}
		else
			return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		if (!isInitializing()) {
			Diagnostic valueDiagnostic = validateValue(event);
			if (PropertiesEditionEvent.COMMIT == event.getState() && IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode) && valueDiagnostic.getSeverity() == Diagnostic.OK) {
				CompoundCommand command = new CompoundCommand();
			if (EefnrViewsRepository.TotalSample.textRequiredProperty == event.getAffectedEditor()) {
				command.append(SetCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_TextRequiredProperty(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue())));
			}
			if (EefnrViewsRepository.TotalSample.textOptionalProperty == event.getAffectedEditor()) {
				command.append(SetCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_TextOptionalProperty(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue())));
			}
			if (EefnrViewsRepository.TotalSample.checkboxRequiredProperty == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_CheckboxRequiredProperty(), event.getNewValue()));

			if (EefnrViewsRepository.TotalSample.checkboxOptionalProperty == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_CheckboxOptionalProperty(), event.getNewValue()));

			if (EefnrViewsRepository.TotalSample.textareaRequiredProperty == event.getAffectedEditor()) {
				command.append(SetCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_TextareaRequiredProperty(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue())));
			}
			if (EefnrViewsRepository.TotalSample.textareaOptionalProperty == event.getAffectedEditor()) {
				command.append(SetCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_TextareaOptionalProperty(), EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue())));
			}
			if (EefnrViewsRepository.TotalSample.radioRequiredProperty == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_RadioRequiredProperty(), event.getNewValue()));

			if (EefnrViewsRepository.TotalSample.radioOptionalProperty == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_RadioOptionalProperty(), event.getNewValue()));

			if (EefnrViewsRepository.TotalSample.eobjectflatcomboviewerRequiredProperty == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_EobjectflatcomboviewerRequiredProperty(), event.getNewValue()));
			if (EefnrViewsRepository.TotalSample.eobjectflatcomboviewerOptionalProperty == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_EobjectflatcomboviewerOptionalProperty(), event.getNewValue()));
			if (EefnrViewsRepository.TotalSample.referencestableRequiredProperty == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_ReferencestableRequiredProperty(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_ReferencestableRequiredProperty(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_ReferencestableRequiredProperty(), event.getNewValue(), event.getNewIndex()));
			}
			if (EefnrViewsRepository.TotalSample.referencestableOptionalProperty == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_ReferencestableOptionalProperty(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_ReferencestableOptionalProperty(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_ReferencestableOptionalProperty(), event.getNewValue(), event.getNewIndex()));
			}
			if (EefnrViewsRepository.TotalSample.emfcomboviewerRequiredProperty == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_EmfcomboviewerRequiredProperty(), event.getNewValue()));

			if (EefnrViewsRepository.TotalSample.emfcomboviewerOptionalProperty == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_EmfcomboviewerOptionalProperty(), event.getNewValue()));

					if (EefnrViewsRepository.TotalSample.multivaluededitorRequiredProperty == event.getAffectedEditor())
						command.append(SetCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_MultivaluededitorRequiredProperty(), event.getNewValue()));

					if (EefnrViewsRepository.TotalSample.multivaluededitorOptionalProperty == event.getAffectedEditor())
						command.append(SetCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_MultivaluededitorOptionalProperty(), event.getNewValue()));

			if (EefnrViewsRepository.TotalSample.tablecompositionRequiredProperty == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Sample oldValue = (Sample)event.getOldValue();
					Sample newValue = (Sample)event.getNewValue();
					
					// TODO: Complete the totalSample update command
					for (EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if (feature.isChangeable() && !(feature instanceof EReference && ((EReference) feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}
					
				}
				else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_TablecompositionRequiredProperty(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getSample(), event.getNewValue(), event.getNewIndex()));
			}
			if (EefnrViewsRepository.TotalSample.tablecompositionOptionalProperty == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Sample oldValue = (Sample)event.getOldValue();
					Sample newValue = (Sample)event.getNewValue();
					
					// TODO: Complete the totalSample update command
					for (EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if (feature.isChangeable() && !(feature instanceof EReference && ((EReference) feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}
					
				}
				else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_TablecompositionOptionalProperty(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getSample(), event.getNewValue(), event.getNewIndex()));
			}
			if (EefnrViewsRepository.TotalSample.advancedreferencestableRequiredProperty == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_AdvancedreferencestableRequiredProperty(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_AdvancedreferencestableRequiredProperty(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_AdvancedreferencestableRequiredProperty(), event.getNewValue(), event.getNewIndex()));
			}
			if (EefnrViewsRepository.TotalSample.advancedreferencestableOptionalProperty == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_AdvancedreferencestableOptionalProperty(), event.getNewValue()));
				if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(RemoveCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_AdvancedreferencestableOptionalProperty(), event.getNewValue()));
				if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_AdvancedreferencestableOptionalProperty(), event.getNewValue(), event.getNewIndex()));
			}
			if (EefnrViewsRepository.TotalSample.advancedeobjectflatcomboviewerRequiredPropery == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_AdvancedeobjectflatcomboviewerRequiredPropery(), event.getNewValue()));
			if (EefnrViewsRepository.TotalSample.advancedeobjectflatcomboviewerOptionalPropery == event.getAffectedEditor())
				command.append(SetCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_AdvancedeobjectflatcomboviewerOptionalPropery(), event.getNewValue()));
			if (EefnrViewsRepository.TotalSample.advancedtablecompositionRequiredProperty == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Sample oldValue = (Sample)event.getOldValue();
					Sample newValue = (Sample)event.getNewValue();
					
					// TODO: Complete the totalSample update command
					for (EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if (feature.isChangeable() && !(feature instanceof EReference && ((EReference) feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}
					
				}
				else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_AdvancedtablecompositionRequiredProperty(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getSample(), event.getNewValue(), event.getNewIndex()));
			}
			if (EefnrViewsRepository.TotalSample.advancedtablecompositionOptionalProperty == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					Sample oldValue = (Sample)event.getOldValue();
					Sample newValue = (Sample)event.getNewValue();
					
					// TODO: Complete the totalSample update command
					for (EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if (feature.isChangeable() && !(feature instanceof EReference && ((EReference) feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}
					
				}
				else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_AdvancedtablecompositionOptionalProperty(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getSample(), event.getNewValue(), event.getNewIndex()));
			}
			if (EefnrViewsRepository.TotalSample.tablecompositionWithSameTypeRequiredProperty == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					TotalSample oldValue = (TotalSample)event.getOldValue();
					TotalSample newValue = (TotalSample)event.getNewValue();
					
					// TODO: Complete the totalSample update command
					for (EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if (feature.isChangeable() && !(feature instanceof EReference && ((EReference) feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}
					
				}
				else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_TablecompositionOnSameTypeRequiredProperty(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample(), event.getNewValue(), event.getNewIndex()));
			}
			if (EefnrViewsRepository.TotalSample.tablecompositionWithSameTypeOptionalProperty == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					TotalSample oldValue = (TotalSample)event.getOldValue();
					TotalSample newValue = (TotalSample)event.getNewValue();
					
					// TODO: Complete the totalSample update command
					for (EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if (feature.isChangeable() && !(feature instanceof EReference && ((EReference) feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}
					
				}
				else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_TablecompositionOnSameTypeOptionalProperty(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample(), event.getNewValue(), event.getNewIndex()));
			}
			if (EefnrViewsRepository.TotalSample.advancedtablecompositionWithSameTypeRequiredProperty == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					TotalSample oldValue = (TotalSample)event.getOldValue();
					TotalSample newValue = (TotalSample)event.getNewValue();
					
					// TODO: Complete the totalSample update command
					for (EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if (feature.isChangeable() && !(feature instanceof EReference && ((EReference) feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}
					
				}
				else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_AdvancedtablecompositionOnSameTypeRequiredProperty(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample(), event.getNewValue(), event.getNewIndex()));
			}
			if (EefnrViewsRepository.TotalSample.advancedtablecompositionWithSameTypeOptionalProperty == event.getAffectedEditor()) {
				if (PropertiesEditionEvent.SET == event.getKind()) {
					TotalSample oldValue = (TotalSample)event.getOldValue();
					TotalSample newValue = (TotalSample)event.getNewValue();
					
					// TODO: Complete the totalSample update command
					for (EStructuralFeature feature : newValue.eClass().getEAllStructuralFeatures()) {
						if (feature.isChangeable() && !(feature instanceof EReference && ((EReference) feature).isContainer())) {
							command.append(SetCommand.create(liveEditingDomain, oldValue, feature, newValue.eGet(feature)));
						}
					}
					
				}
				else if (PropertiesEditionEvent.ADD == event.getKind())
					command.append(AddCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_AdvancedtablecompositionOnSametypeOptionalProperty(), event.getNewValue()));
				else if (PropertiesEditionEvent.REMOVE == event.getKind())
					command.append(DeleteCommand.create(liveEditingDomain, event.getNewValue()));
				else if (PropertiesEditionEvent.MOVE == event.getKind())
					command.append(MoveCommand.create(liveEditingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample(), event.getNewValue(), event.getNewIndex()));
			}


				if (!command.isEmpty() && !command.canExecute()) {
					EEFRuntimePlugin.getDefault().logError("Cannot perform model change command.", null);
				} else {
					liveEditingDomain.getCommandStack().execute(command);
				}
			}
			if (valueDiagnostic.getSeverity() != Diagnostic.OK && valueDiagnostic instanceof BasicDiagnostic)
				super.firePropertiesChanged(new PropertiesValidationEditionEvent(event, valueDiagnostic));
			else {
				Diagnostic validate = validate();
				super.firePropertiesChanged(new PropertiesValidationEditionEvent(event, validate));
			}
			super.firePropertiesChanged(event);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 */
	public boolean isRequired(String key, int kind) {
		return key == EefnrViewsRepository.TotalSample.textRequiredProperty || key == EefnrViewsRepository.TotalSample.checkboxRequiredProperty || key == EefnrViewsRepository.TotalSample.textareaRequiredProperty || key == EefnrViewsRepository.TotalSample.radioRequiredProperty || key == EefnrViewsRepository.TotalSample.eobjectflatcomboviewerRequiredProperty || key == EefnrViewsRepository.TotalSample.referencestableRequiredProperty || key == EefnrViewsRepository.TotalSample.emfcomboviewerRequiredProperty || key == EefnrViewsRepository.TotalSample.multivaluededitorRequiredProperty || key == EefnrViewsRepository.TotalSample.tablecompositionRequiredProperty || key == EefnrViewsRepository.TotalSample.advancedreferencestableRequiredProperty || key == EefnrViewsRepository.TotalSample.advancedeobjectflatcomboviewerRequiredPropery || key == EefnrViewsRepository.TotalSample.advancedtablecompositionRequiredProperty || key == EefnrViewsRepository.TotalSample.tablecompositionWithSameTypeRequiredProperty || key == EefnrViewsRepository.TotalSample.advancedtablecompositionWithSameTypeRequiredProperty;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 */
	public Diagnostic validateValue(IPropertiesEditionEvent event) {
		Diagnostic ret = Diagnostic.OK_INSTANCE;
		if (event.getNewValue() != null) {
			String newStringValue = event.getNewValue().toString();
			try {
				if (EefnrViewsRepository.TotalSample.textRequiredProperty == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EefnrPackage.eINSTANCE.getTotalSample_TextRequiredProperty().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EefnrPackage.eINSTANCE.getTotalSample_TextRequiredProperty().getEAttributeType(), newValue);
				}
				if (EefnrViewsRepository.TotalSample.textOptionalProperty == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EefnrPackage.eINSTANCE.getTotalSample_TextOptionalProperty().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EefnrPackage.eINSTANCE.getTotalSample_TextOptionalProperty().getEAttributeType(), newValue);
				}
				if (EefnrViewsRepository.TotalSample.checkboxRequiredProperty == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EefnrPackage.eINSTANCE.getTotalSample_CheckboxRequiredProperty().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EefnrPackage.eINSTANCE.getTotalSample_CheckboxRequiredProperty().getEAttributeType(), newValue);
				}
				if (EefnrViewsRepository.TotalSample.checkboxOptionalProperty == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EefnrPackage.eINSTANCE.getTotalSample_CheckboxOptionalProperty().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EefnrPackage.eINSTANCE.getTotalSample_CheckboxOptionalProperty().getEAttributeType(), newValue);
				}
				if (EefnrViewsRepository.TotalSample.textareaRequiredProperty == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EefnrPackage.eINSTANCE.getTotalSample_TextareaRequiredProperty().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EefnrPackage.eINSTANCE.getTotalSample_TextareaRequiredProperty().getEAttributeType(), newValue);
				}
				if (EefnrViewsRepository.TotalSample.textareaOptionalProperty == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EefnrPackage.eINSTANCE.getTotalSample_TextareaOptionalProperty().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EefnrPackage.eINSTANCE.getTotalSample_TextareaOptionalProperty().getEAttributeType(), newValue);
				}
				if (EefnrViewsRepository.TotalSample.radioRequiredProperty == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EefnrPackage.eINSTANCE.getTotalSample_RadioRequiredProperty().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EefnrPackage.eINSTANCE.getTotalSample_RadioRequiredProperty().getEAttributeType(), newValue);
				}
				if (EefnrViewsRepository.TotalSample.radioOptionalProperty == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EefnrPackage.eINSTANCE.getTotalSample_RadioOptionalProperty().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EefnrPackage.eINSTANCE.getTotalSample_RadioOptionalProperty().getEAttributeType(), newValue);
				}
				if (EefnrViewsRepository.TotalSample.emfcomboviewerRequiredProperty == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EefnrPackage.eINSTANCE.getTotalSample_EmfcomboviewerRequiredProperty().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EefnrPackage.eINSTANCE.getTotalSample_EmfcomboviewerRequiredProperty().getEAttributeType(), newValue);
				}
				if (EefnrViewsRepository.TotalSample.emfcomboviewerOptionalProperty == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EefnrPackage.eINSTANCE.getTotalSample_EmfcomboviewerOptionalProperty().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EefnrPackage.eINSTANCE.getTotalSample_EmfcomboviewerOptionalProperty().getEAttributeType(), newValue);
				}
				if (EefnrViewsRepository.TotalSample.multivaluededitorRequiredProperty == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EefnrPackage.eINSTANCE.getTotalSample_MultivaluededitorRequiredProperty().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EefnrPackage.eINSTANCE.getTotalSample_MultivaluededitorRequiredProperty().getEAttributeType(), newValue);
				}
				if (EefnrViewsRepository.TotalSample.multivaluededitorOptionalProperty == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EefnrPackage.eINSTANCE.getTotalSample_MultivaluededitorOptionalProperty().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EefnrPackage.eINSTANCE.getTotalSample_MultivaluededitorOptionalProperty().getEAttributeType(), newValue);
				}

			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
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
		Diagnostic validate = Diagnostic.OK_INSTANCE;
		if (IPropertiesEditionComponent.BATCH_MODE.equals(editing_mode)) {
			EObject copy = EcoreUtil.copy(totalSample);
			copy = getPropertiesEditionObject(copy);
			validate =  EEFRuntimePlugin.getEEFValidator().validate(copy);
		}
		else if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode))
			validate = EEFRuntimePlugin.getEEFValidator().validate(totalSample);
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
			totalSample.eAdapters().remove(semanticAdapter);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getTabText(java.lang.String)
	 */
	public String getTabText(String p_key) {
		return basePart.getTitle();
	}
}
