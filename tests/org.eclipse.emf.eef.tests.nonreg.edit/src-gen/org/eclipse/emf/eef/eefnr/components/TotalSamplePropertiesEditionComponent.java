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
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
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
import org.eclipse.emf.eef.runtime.impl.command.StandardEditingCommand;
import org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesValidationEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPartProviderService;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
	

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class TotalSamplePropertiesEditionComponent extends StandardPropertiesEditionComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	private String[] parts = {BASE_PART};

	/**
	 * The EObject to edit
	 * 
	 */
	private TotalSample totalSample;

	/**
	 * The Base part
	 * 
	 */
	protected TotalSamplePropertiesEditionPart basePart;

	/**
	 * Default constructor
	 * 
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
	 * 
	 */
	private AdapterImpl initializeSemanticAdapter() {
		return new EContentAdapter() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
			 * 
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
	 * 
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

		if (EefnrPackage.eINSTANCE.getTotalSample_MultivaluededitorRequiredProperty().equals(msg.getFeature()) && basePart != null) {
			if (msg.getEventType() == Notification.ADD) 
				basePart.addToMultivaluededitorRequiredProperty((java.lang.String) msg.getNewValue());
			else if (msg.getEventType() == Notification.REMOVE) 
				basePart.removeToMultivaluededitorRequiredProperty((java.lang.String) msg.getNewValue());
		}

		if (EefnrPackage.eINSTANCE.getTotalSample_MultivaluededitorOptionalProperty().equals(msg.getFeature()) && basePart != null) {
			if (msg.getEventType() == Notification.ADD) 
				basePart.addToMultivaluededitorOptionalProperty((java.lang.String) msg.getNewValue());
			else if (msg.getEventType() == Notification.REMOVE) 
				basePart.removeToMultivaluededitorOptionalProperty((java.lang.String) msg.getNewValue());
		}

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
		if (EefnrPackage.eINSTANCE.getAbstractSample_Name().equals(msg.getFeature()) && basePart != null){
			if (msg.getNewValue() != null) {
				basePart.setName(EcoreUtil.convertToString(EcorePackage.eINSTANCE.getEString(), msg.getNewValue()));
			} else {
				basePart.setName("");
			}
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#translatePart(java.lang.String)
	 * 
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
	 * 
	 */
	public String[] partsList() {
		return parts;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getPropertiesEditionPart
	 *  (java.lang.String, java.lang.String)
	 * 
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
	 * 
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
	 * 
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
				basePart.setMultivaluededitorRequiredProperty(new BasicEList(totalSample.getMultivaluededitorRequiredProperty()));

			if (totalSample.getMultivaluededitorOptionalProperty() != null)
				basePart.setMultivaluededitorOptionalProperty(new BasicEList(totalSample.getMultivaluededitorOptionalProperty()));

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
			if (totalSample.getName() != null)
				basePart.setName(EEFConverterUtil.convertToString(EcorePackage.eINSTANCE.getEString(), totalSample.getName()));

			// init filters








			basePart.addFilterToEobjectflatcomboviewerRequiredProperty(new ViewerFilter() {

				/**
				 * {@inheritDoc}
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

				/**
				 * {@inheritDoc}
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

				/**
				 * {@inheritDoc}
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

				/**
				 * {@inheritDoc}
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

					/**
					 * {@inheritDoc}
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

					/**
					 * {@inheritDoc}
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

				/**
				 * {@inheritDoc}
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

				/**
				 * {@inheritDoc}
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

				/**
				 * {@inheritDoc}
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

				/**
				 * {@inheritDoc}
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

					/**
					 * {@inheritDoc}
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

					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Sample); //$NON-NLS-1$ 
				}

			});
			// Start of user code for additional businessfilters for advancedtablecompositionOptionalProperty
			
			// End of user code


		}
		// init values for referenced views

		// init filters for referenced views

		setInitializing(false);
	}




























	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void firePropertiesChanged(final IPropertiesEditionEvent event) {
		if (!isInitializing()) {
			Diagnostic valueDiagnostic = validateValue(event);
			if (IPropertiesEditionComponent.BATCH_MODE.equals(editing_mode)) {			
				if (EefnrViewsRepository.TotalSample.textRequiredProperty == event.getAffectedEditor()) {
					updateTextRequiredProperty((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
				}
				if (EefnrViewsRepository.TotalSample.textOptionalProperty == event.getAffectedEditor()) {
					updateTextOptionalProperty((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
				}
				if (EefnrViewsRepository.TotalSample.checkboxRequiredProperty == event.getAffectedEditor()) {
					updateCheckboxRequiredProperty((Boolean)event.getNewValue());
				}
				if (EefnrViewsRepository.TotalSample.checkboxOptionalProperty == event.getAffectedEditor()) {
					updateCheckboxOptionalProperty((Boolean)event.getNewValue());
				}
				if (EefnrViewsRepository.TotalSample.textareaRequiredProperty == event.getAffectedEditor()) {
					updateTextareaRequiredProperty((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
				}
				if (EefnrViewsRepository.TotalSample.textareaOptionalProperty == event.getAffectedEditor()) {
					updateTextareaOptionalProperty((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
				}
				if (EefnrViewsRepository.TotalSample.radioRequiredProperty == event.getAffectedEditor()) {
					updateRadioRequiredProperty((ENUM_SAMPLE)event.getNewValue());
				}
				if (EefnrViewsRepository.TotalSample.radioOptionalProperty == event.getAffectedEditor()) {
					updateRadioOptionalProperty((ENUM_SAMPLE)event.getNewValue());
				}
				if (EefnrViewsRepository.TotalSample.eobjectflatcomboviewerRequiredProperty == event.getAffectedEditor()) {
					updateEobjectflatcomboviewerRequiredProperty((TotalSample)event.getNewValue());
				}
				if (EefnrViewsRepository.TotalSample.eobjectflatcomboviewerOptionalProperty == event.getAffectedEditor()) {
					updateEobjectflatcomboviewerOptionalProperty((TotalSample)event.getNewValue());
				}
				if (EefnrViewsRepository.TotalSample.referencestableRequiredProperty == event.getAffectedEditor()) {
					// FIXME INVALID CASE you must override the template 'invokeEObjectUpdater' for the case : referencestableRequiredProperty, TotalSample, TotalSample.
				}
				if (EefnrViewsRepository.TotalSample.referencestableOptionalProperty == event.getAffectedEditor()) {
					// FIXME INVALID CASE you must override the template 'invokeEObjectUpdater' for the case : referencestableOptionalProperty, TotalSample, TotalSample.
				}
				if (EefnrViewsRepository.TotalSample.emfcomboviewerRequiredProperty == event.getAffectedEditor()) {
					updateEmfcomboviewerRequiredProperty((ENUM_SAMPLE)event.getNewValue());
				}
				if (EefnrViewsRepository.TotalSample.emfcomboviewerOptionalProperty == event.getAffectedEditor()) {
					updateEmfcomboviewerOptionalProperty((ENUM_SAMPLE)event.getNewValue());
				}
				if (EefnrViewsRepository.TotalSample.multivaluededitorRequiredProperty == event.getAffectedEditor()) {
					// FIXME INVALID CASE you must override the template 'invokeEObjectUpdater' for the case : multivaluededitorRequiredProperty, TotalSample, TotalSample.
				}
				if (EefnrViewsRepository.TotalSample.multivaluededitorOptionalProperty == event.getAffectedEditor()) {
					// FIXME INVALID CASE you must override the template 'invokeEObjectUpdater' for the case : multivaluededitorOptionalProperty, TotalSample, TotalSample.
				}
				if (EefnrViewsRepository.TotalSample.tablecompositionRequiredProperty == event.getAffectedEditor()) {
					// FIXME INVALID CASE you must override the template 'invokeEObjectUpdater' for the case : tablecompositionRequiredProperty, TotalSample, TotalSample.
				}
				if (EefnrViewsRepository.TotalSample.tablecompositionOptionalProperty == event.getAffectedEditor()) {
					// FIXME INVALID CASE you must override the template 'invokeEObjectUpdater' for the case : tablecompositionOptionalProperty, TotalSample, TotalSample.
				}
				if (EefnrViewsRepository.TotalSample.advancedreferencestableRequiredProperty == event.getAffectedEditor()) {
					// FIXME INVALID CASE you must override the template 'invokeEObjectUpdater' for the case : advancedreferencestableRequiredProperty, TotalSample, TotalSample.
				}
				if (EefnrViewsRepository.TotalSample.advancedreferencestableOptionalProperty == event.getAffectedEditor()) {
					// FIXME INVALID CASE you must override the template 'invokeEObjectUpdater' for the case : advancedreferencestableOptionalProperty, TotalSample, TotalSample.
				}
				if (EefnrViewsRepository.TotalSample.advancedeobjectflatcomboviewerRequiredPropery == event.getAffectedEditor()) {
					updateAdvancedeobjectflatcomboviewerRequiredPropery((TotalSample)event.getNewValue());
				}
				if (EefnrViewsRepository.TotalSample.advancedeobjectflatcomboviewerOptionalPropery == event.getAffectedEditor()) {
					updateAdvancedeobjectflatcomboviewerOptionalPropery((TotalSample)event.getNewValue());
				}
				if (EefnrViewsRepository.TotalSample.advancedtablecompositionRequiredProperty == event.getAffectedEditor()) {
					// FIXME INVALID CASE you must override the template 'invokeEObjectUpdater' for the case : advancedtablecompositionRequiredProperty, TotalSample, TotalSample.
				}
				if (EefnrViewsRepository.TotalSample.advancedtablecompositionOptionalProperty == event.getAffectedEditor()) {
					// FIXME INVALID CASE you must override the template 'invokeEObjectUpdater' for the case : advancedtablecompositionOptionalProperty, TotalSample, TotalSample.
				}
				if (EefnrViewsRepository.TotalSample.name == event.getAffectedEditor()) {
					updateName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
				}
			}
			else if (IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode)) {
				liveEditingDomain.getCommandStack().execute(new StandardEditingCommand() {
					
					public void execute() {
						if (EefnrViewsRepository.TotalSample.textRequiredProperty == event.getAffectedEditor()) {
							updateTextRequiredProperty((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
						}
						if (EefnrViewsRepository.TotalSample.textOptionalProperty == event.getAffectedEditor()) {
							updateTextOptionalProperty((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
						}
						if (EefnrViewsRepository.TotalSample.checkboxRequiredProperty == event.getAffectedEditor()) {
							updateCheckboxRequiredProperty((Boolean)event.getNewValue());
						}
						if (EefnrViewsRepository.TotalSample.checkboxOptionalProperty == event.getAffectedEditor()) {
							updateCheckboxOptionalProperty((Boolean)event.getNewValue());
						}
						if (EefnrViewsRepository.TotalSample.textareaRequiredProperty == event.getAffectedEditor()) {
							updateTextareaRequiredProperty((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
						}
						if (EefnrViewsRepository.TotalSample.textareaOptionalProperty == event.getAffectedEditor()) {
							updateTextareaOptionalProperty((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
						}
						if (EefnrViewsRepository.TotalSample.radioRequiredProperty == event.getAffectedEditor()) {
							updateRadioRequiredProperty((ENUM_SAMPLE)event.getNewValue());
						}
						if (EefnrViewsRepository.TotalSample.radioOptionalProperty == event.getAffectedEditor()) {
							updateRadioOptionalProperty((ENUM_SAMPLE)event.getNewValue());
						}
						if (EefnrViewsRepository.TotalSample.eobjectflatcomboviewerRequiredProperty == event.getAffectedEditor()) {
							updateEobjectflatcomboviewerRequiredProperty((TotalSample)event.getNewValue());
						}
						if (EefnrViewsRepository.TotalSample.eobjectflatcomboviewerOptionalProperty == event.getAffectedEditor()) {
							updateEobjectflatcomboviewerOptionalProperty((TotalSample)event.getNewValue());
						}
						if (EefnrViewsRepository.TotalSample.referencestableRequiredProperty == event.getAffectedEditor()) {
							// FIXME INVALID CASE you must override the template 'invokeEObjectUpdater' for the case : referencestableRequiredProperty, TotalSample, TotalSample.
						}
						if (EefnrViewsRepository.TotalSample.referencestableOptionalProperty == event.getAffectedEditor()) {
							// FIXME INVALID CASE you must override the template 'invokeEObjectUpdater' for the case : referencestableOptionalProperty, TotalSample, TotalSample.
						}
						if (EefnrViewsRepository.TotalSample.emfcomboviewerRequiredProperty == event.getAffectedEditor()) {
							updateEmfcomboviewerRequiredProperty((ENUM_SAMPLE)event.getNewValue());
						}
						if (EefnrViewsRepository.TotalSample.emfcomboviewerOptionalProperty == event.getAffectedEditor()) {
							updateEmfcomboviewerOptionalProperty((ENUM_SAMPLE)event.getNewValue());
						}
						if (EefnrViewsRepository.TotalSample.multivaluededitorRequiredProperty == event.getAffectedEditor()) {
							// FIXME INVALID CASE you must override the template 'invokeEObjectUpdater' for the case : multivaluededitorRequiredProperty, TotalSample, TotalSample.
						}
						if (EefnrViewsRepository.TotalSample.multivaluededitorOptionalProperty == event.getAffectedEditor()) {
							// FIXME INVALID CASE you must override the template 'invokeEObjectUpdater' for the case : multivaluededitorOptionalProperty, TotalSample, TotalSample.
						}
						if (EefnrViewsRepository.TotalSample.tablecompositionRequiredProperty == event.getAffectedEditor()) {
							// FIXME INVALID CASE you must override the template 'invokeEObjectUpdater' for the case : tablecompositionRequiredProperty, TotalSample, TotalSample.
						}
						if (EefnrViewsRepository.TotalSample.tablecompositionOptionalProperty == event.getAffectedEditor()) {
							// FIXME INVALID CASE you must override the template 'invokeEObjectUpdater' for the case : tablecompositionOptionalProperty, TotalSample, TotalSample.
						}
						if (EefnrViewsRepository.TotalSample.advancedreferencestableRequiredProperty == event.getAffectedEditor()) {
							// FIXME INVALID CASE you must override the template 'invokeEObjectUpdater' for the case : advancedreferencestableRequiredProperty, TotalSample, TotalSample.
						}
						if (EefnrViewsRepository.TotalSample.advancedreferencestableOptionalProperty == event.getAffectedEditor()) {
							// FIXME INVALID CASE you must override the template 'invokeEObjectUpdater' for the case : advancedreferencestableOptionalProperty, TotalSample, TotalSample.
						}
						if (EefnrViewsRepository.TotalSample.advancedeobjectflatcomboviewerRequiredPropery == event.getAffectedEditor()) {
							updateAdvancedeobjectflatcomboviewerRequiredPropery((TotalSample)event.getNewValue());
						}
						if (EefnrViewsRepository.TotalSample.advancedeobjectflatcomboviewerOptionalPropery == event.getAffectedEditor()) {
							updateAdvancedeobjectflatcomboviewerOptionalPropery((TotalSample)event.getNewValue());
						}
						if (EefnrViewsRepository.TotalSample.advancedtablecompositionRequiredProperty == event.getAffectedEditor()) {
							// FIXME INVALID CASE you must override the template 'invokeEObjectUpdater' for the case : advancedtablecompositionRequiredProperty, TotalSample, TotalSample.
						}
						if (EefnrViewsRepository.TotalSample.advancedtablecompositionOptionalProperty == event.getAffectedEditor()) {
							// FIXME INVALID CASE you must override the template 'invokeEObjectUpdater' for the case : advancedtablecompositionOptionalProperty, TotalSample, TotalSample.
						}
						if (EefnrViewsRepository.TotalSample.name == event.getAffectedEditor()) {
							updateName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEString(), (String)event.getNewValue()));
						}
					}
				});			
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

	private void updateTextRequiredProperty(java.lang.String newValue) {
		totalSample.setTextRequiredProperty(newValue);	
	}

	private void updateTextOptionalProperty(java.lang.String newValue) {
		totalSample.setTextOptionalProperty(newValue);	
	}

	private void updateCheckboxRequiredProperty(Boolean newValue) {
		totalSample.setCheckboxRequiredProperty(newValue);	
	}

	private void updateCheckboxOptionalProperty(Boolean newValue) {
		totalSample.setCheckboxOptionalProperty(newValue);	
	}

	private void updateTextareaRequiredProperty(java.lang.String newValue) {
		totalSample.setTextareaRequiredProperty(newValue);	
	}

	private void updateTextareaOptionalProperty(java.lang.String newValue) {
		totalSample.setTextareaOptionalProperty(newValue);	
	}

	private void updateRadioRequiredProperty(ENUM_SAMPLE newValue) {
		totalSample.setRadioRequiredProperty(newValue);	
	}

	private void updateRadioOptionalProperty(ENUM_SAMPLE newValue) {
		totalSample.setRadioOptionalProperty(newValue);	
	}

	private void updateEobjectflatcomboviewerRequiredProperty(TotalSample newValue) {
		totalSample.setEobjectflatcomboviewerRequiredProperty(newValue);	
	}

	private void updateEobjectflatcomboviewerOptionalProperty(TotalSample newValue) {
		totalSample.setEobjectflatcomboviewerOptionalProperty(newValue);	
	}

	// FIXME INVALID CASE you must override the template 'declareEObjectUpdater' for the case : referencestableRequiredProperty, TotalSample, TotalSample.

	// FIXME INVALID CASE you must override the template 'declareEObjectUpdater' for the case : referencestableOptionalProperty, TotalSample, TotalSample.

	private void updateEmfcomboviewerRequiredProperty(ENUM_SAMPLE newValue) {
		totalSample.setEmfcomboviewerRequiredProperty(newValue);	
	}

	private void updateEmfcomboviewerOptionalProperty(ENUM_SAMPLE newValue) {
		totalSample.setEmfcomboviewerOptionalProperty(newValue);	
	}

	// FIXME INVALID CASE you must override the template 'declareEObjectUpdater' for the case : multivaluededitorRequiredProperty, TotalSample, TotalSample.

	// FIXME INVALID CASE you must override the template 'declareEObjectUpdater' for the case : multivaluededitorOptionalProperty, TotalSample, TotalSample.

	// FIXME INVALID CASE you must override the template 'declareEObjectUpdater' for the case : tablecompositionRequiredProperty, TotalSample, TotalSample.

	// FIXME INVALID CASE you must override the template 'declareEObjectUpdater' for the case : tablecompositionOptionalProperty, TotalSample, TotalSample.

	// FIXME INVALID CASE you must override the template 'declareEObjectUpdater' for the case : advancedreferencestableRequiredProperty, TotalSample, TotalSample.

	// FIXME INVALID CASE you must override the template 'declareEObjectUpdater' for the case : advancedreferencestableOptionalProperty, TotalSample, TotalSample.

	private void updateAdvancedeobjectflatcomboviewerRequiredPropery(TotalSample newValue) {
		totalSample.setAdvancedeobjectflatcomboviewerRequiredPropery(newValue);	
	}

	private void updateAdvancedeobjectflatcomboviewerOptionalPropery(TotalSample newValue) {
		totalSample.setAdvancedeobjectflatcomboviewerOptionalPropery(newValue);	
	}

	// FIXME INVALID CASE you must override the template 'declareEObjectUpdater' for the case : advancedtablecompositionRequiredProperty, TotalSample, TotalSample.

	// FIXME INVALID CASE you must override the template 'declareEObjectUpdater' for the case : advancedtablecompositionOptionalProperty, TotalSample, TotalSample.

	private void updateName(java.lang.String newValue) {
		totalSample.setName(newValue);	
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.String, int)
	 * 
	 */
	public boolean isRequired(String key, int kind) {
		return key == EefnrViewsRepository.TotalSample.textRequiredProperty || key == EefnrViewsRepository.TotalSample.checkboxRequiredProperty || key == EefnrViewsRepository.TotalSample.textareaRequiredProperty || key == EefnrViewsRepository.TotalSample.radioRequiredProperty || key == EefnrViewsRepository.TotalSample.eobjectflatcomboviewerRequiredProperty || key == EefnrViewsRepository.TotalSample.referencestableRequiredProperty || key == EefnrViewsRepository.TotalSample.emfcomboviewerRequiredProperty || key == EefnrViewsRepository.TotalSample.multivaluededitorRequiredProperty || key == EefnrViewsRepository.TotalSample.tablecompositionRequiredProperty || key == EefnrViewsRepository.TotalSample.advancedreferencestableRequiredProperty || key == EefnrViewsRepository.TotalSample.advancedeobjectflatcomboviewerRequiredPropery || key == EefnrViewsRepository.TotalSample.advancedtablecompositionRequiredProperty;
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
				if (EefnrViewsRepository.TotalSample.name == event.getAffectedEditor()) {
					Object newValue = EcoreUtil.createFromString(EefnrPackage.eINSTANCE.getAbstractSample_Name().getEAttributeType(), newStringValue);
					ret = Diagnostician.INSTANCE.validate(EefnrPackage.eINSTANCE.getAbstractSample_Name().getEAttributeType(), newValue);
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
	 * 
	 */
	public Diagnostic validate() {
		Diagnostic validate = Diagnostic.OK_INSTANCE;
		validate = EEFRuntimePlugin.getEEFValidator().validate(totalSample);
		// Start of user code for custom validation check
		
		// End of user code
		return validate;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#dispose()
	 * 
	 */
	public void dispose() {
		if (semanticAdapter != null)
			totalSample.eAdapters().remove(semanticAdapter);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#getTabText(java.lang.String)
	 * 
	 */
	public String getTabText(String p_key) {
		return basePart.getTitle();
	}
}
