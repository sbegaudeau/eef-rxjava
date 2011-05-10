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
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.eef.eefnr.AbstractSample;
import org.eclipse.emf.eef.eefnr.EefnrPackage;
import org.eclipse.emf.eef.eefnr.Sample;
import org.eclipse.emf.eef.eefnr.SingleCompositionViewerSample;
import org.eclipse.emf.eef.eefnr.parts.EefnrViewsRepository;
import org.eclipse.emf.eef.eefnr.parts.SingleCompositionViewerSamplePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.SingleCompositionViewer;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;


// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class SingleCompositionViewerSamplePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Default constructor
	 * 
	 */
	public SingleCompositionViewerSamplePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject singleCompositionViewerSample, String editing_mode) {
		super(editingContext, singleCompositionViewerSample, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = EefnrViewsRepository.class;
		partKey = EefnrViewsRepository.SingleCompositionViewerSample.class;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Object, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(Object key, int kind, EObject elt, ResourceSet allResource) {
		setInitializing(true);
		if (editingPart != null && key == partKey) {
			editingPart.setContext(elt, allResource);
			final SingleCompositionViewerSample singleCompositionViewerSample = (SingleCompositionViewerSample)elt;
			final SingleCompositionViewerSamplePropertiesEditionPart basePart = (SingleCompositionViewerSamplePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EefnrViewsRepository.SingleCompositionViewerSample.Properties.singlecompositionviewerSingleRequiredProperty)) {
				if(EefnrPackage.eINSTANCE.getSingleCompositionViewerSample_SinglecompositionviewSingleRequiredProperty().getLowerBound() == 1 && elt.eGet(EefnrPackage.eINSTANCE.getSingleCompositionViewerSample_SinglecompositionviewSingleRequiredProperty()) == null) {
					final List<EClass> instanciableTypesInHierarchy = EEFUtils.instanciableTypesInHierarchy(EefnrPackage.eINSTANCE.getSingleCompositionViewerSample_SinglecompositionviewSingleRequiredProperty().getEType(), allResource);
					if(instanciableTypesInHierarchy.size() == 1) {
						ControlListener listener = new ControlListener() {
			
							public void controlResized(ControlEvent e) {
								if(e.getSource() instanceof SingleCompositionViewer<?>) {
									((SingleCompositionViewer<?>)e.getSource()).removeControlListener(this);
								}
								EObject element = EcoreUtil.create(instanciableTypesInHierarchy.get(0));
								if(IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode))
									setInitializing(false);
								firePropertiesChanged(new PropertiesEditionEvent((IPropertiesEditionListener) basePart, EefnrViewsRepository.SingleCompositionViewerSample.Properties.singlecompositionviewerSingleRequiredProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, element));
								setInitializing(true);
								if(IPropertiesEditionComponent.BATCH_MODE.equals(editing_mode))
									basePart.setSinglecompositionviewerSingleRequiredProperty(element);
							}
			
							public void controlMoved(ControlEvent e) {
							}
						};
					basePart.addSinglecompositionviewerSingleRequiredPropertyControlListener(listener);
					}
				}
			
				basePart.initSinglecompositionviewerSingleRequiredProperty(singleCompositionViewerSample, null, EefnrPackage.eINSTANCE.getSingleCompositionViewerSample_SinglecompositionviewSingleRequiredProperty(), liveEditingDomain);
			}
			if (isAccessible(EefnrViewsRepository.SingleCompositionViewerSample.Properties.singlecompositionviewerSingleOptionalProperty)) {
				if(EefnrPackage.eINSTANCE.getSingleCompositionViewerSample_SinglecompositionviewSingleOptionalProperty().getLowerBound() == 1 && elt.eGet(EefnrPackage.eINSTANCE.getSingleCompositionViewerSample_SinglecompositionviewSingleOptionalProperty()) == null) {
					final List<EClass> instanciableTypesInHierarchy = EEFUtils.instanciableTypesInHierarchy(EefnrPackage.eINSTANCE.getSingleCompositionViewerSample_SinglecompositionviewSingleOptionalProperty().getEType(), allResource);
					if(instanciableTypesInHierarchy.size() == 1) {
						ControlListener listener = new ControlListener() {
			
							public void controlResized(ControlEvent e) {
								if(e.getSource() instanceof SingleCompositionViewer<?>) {
									((SingleCompositionViewer<?>)e.getSource()).removeControlListener(this);
								}
								EObject element = EcoreUtil.create(instanciableTypesInHierarchy.get(0));
								if(IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode))
									setInitializing(false);
								firePropertiesChanged(new PropertiesEditionEvent((IPropertiesEditionListener) basePart, EefnrViewsRepository.SingleCompositionViewerSample.Properties.singlecompositionviewerSingleOptionalProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, element));
								setInitializing(true);
								if(IPropertiesEditionComponent.BATCH_MODE.equals(editing_mode))
									basePart.setSinglecompositionviewerSingleOptionalProperty(element);
							}
			
							public void controlMoved(ControlEvent e) {
							}
						};
					basePart.addSinglecompositionviewerSingleOptionalPropertyControlListener(listener);
					}
				}
			
				basePart.initSinglecompositionviewerSingleOptionalProperty(singleCompositionViewerSample, null, EefnrPackage.eINSTANCE.getSingleCompositionViewerSample_SinglecompositionviewSingleOptionalProperty(), liveEditingDomain);
			}
			if (isAccessible(EefnrViewsRepository.SingleCompositionViewerSample.Properties.singlecompositionviewerMultiRequiredProperty)) {
				if(EefnrPackage.eINSTANCE.getSingleCompositionViewerSample_SinglecompositionviewMultiRequiredProperty().getLowerBound() == 1 && elt.eGet(EefnrPackage.eINSTANCE.getSingleCompositionViewerSample_SinglecompositionviewMultiRequiredProperty()) == null) {
					final List<EClass> instanciableTypesInHierarchy = EEFUtils.instanciableTypesInHierarchy(EefnrPackage.eINSTANCE.getSingleCompositionViewerSample_SinglecompositionviewMultiRequiredProperty().getEType(), allResource);
					if(instanciableTypesInHierarchy.size() == 1) {
						ControlListener listener = new ControlListener() {
			
							public void controlResized(ControlEvent e) {
								if(e.getSource() instanceof SingleCompositionViewer<?>) {
									((SingleCompositionViewer<?>)e.getSource()).removeControlListener(this);
								}
								EObject element = EcoreUtil.create(instanciableTypesInHierarchy.get(0));
								if(IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode))
									setInitializing(false);
								firePropertiesChanged(new PropertiesEditionEvent((IPropertiesEditionListener) basePart, EefnrViewsRepository.SingleCompositionViewerSample.Properties.singlecompositionviewerMultiRequiredProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, element));
								setInitializing(true);
								if(IPropertiesEditionComponent.BATCH_MODE.equals(editing_mode))
									basePart.setSinglecompositionviewerMultiRequiredProperty(element);
							}
			
							public void controlMoved(ControlEvent e) {
							}
						};
					basePart.addSinglecompositionviewerMultiRequiredPropertyControlListener(listener);
					}
				}
			
				basePart.initSinglecompositionviewerMultiRequiredProperty(singleCompositionViewerSample, null, EefnrPackage.eINSTANCE.getSingleCompositionViewerSample_SinglecompositionviewMultiRequiredProperty(), liveEditingDomain);
			}
			if (isAccessible(EefnrViewsRepository.SingleCompositionViewerSample.Properties.singlecompositionviewerMultiOptionalProperty)) {
				if(EefnrPackage.eINSTANCE.getSingleCompositionViewerSample_SinglecompositionviewMultiOptionalProperty().getLowerBound() == 1 && elt.eGet(EefnrPackage.eINSTANCE.getSingleCompositionViewerSample_SinglecompositionviewMultiOptionalProperty()) == null) {
					final List<EClass> instanciableTypesInHierarchy = EEFUtils.instanciableTypesInHierarchy(EefnrPackage.eINSTANCE.getSingleCompositionViewerSample_SinglecompositionviewMultiOptionalProperty().getEType(), allResource);
					if(instanciableTypesInHierarchy.size() == 1) {
						ControlListener listener = new ControlListener() {
			
							public void controlResized(ControlEvent e) {
								if(e.getSource() instanceof SingleCompositionViewer<?>) {
									((SingleCompositionViewer<?>)e.getSource()).removeControlListener(this);
								}
								EObject element = EcoreUtil.create(instanciableTypesInHierarchy.get(0));
								if(IPropertiesEditionComponent.LIVE_MODE.equals(editing_mode))
									setInitializing(false);
								firePropertiesChanged(new PropertiesEditionEvent((IPropertiesEditionListener) basePart, EefnrViewsRepository.SingleCompositionViewerSample.Properties.singlecompositionviewerMultiOptionalProperty, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, element));
								setInitializing(true);
								if(IPropertiesEditionComponent.BATCH_MODE.equals(editing_mode))
									basePart.setSinglecompositionviewerMultiOptionalProperty(element);
							}
			
							public void controlMoved(ControlEvent e) {
							}
						};
					basePart.addSinglecompositionviewerMultiOptionalPropertyControlListener(listener);
					}
				}
			
				basePart.initSinglecompositionviewerMultiOptionalProperty(singleCompositionViewerSample, null, EefnrPackage.eINSTANCE.getSingleCompositionViewerSample_SinglecompositionviewMultiOptionalProperty(), liveEditingDomain);
			}
			// init filters
			
			
			
			
			// init values for referenced views
			
			// init filters for referenced views
			
		}
		setInitializing(false);
	}







	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		SingleCompositionViewerSample singleCompositionViewerSample = (SingleCompositionViewerSample)semanticObject;
		if (EefnrViewsRepository.SingleCompositionViewerSample.Properties.singlecompositionviewerSingleRequiredProperty == event.getAffectedEditor()) {
			// FIXME INVALID CASE you must override the template 'declareEObjectUpdater' for the case : singlecompositionviewSingleRequiredProperty, SingleCompositionViewerSample, SingleCompositionViewerSample.
		}
		if (EefnrViewsRepository.SingleCompositionViewerSample.Properties.singlecompositionviewerSingleOptionalProperty == event.getAffectedEditor()) {
			// FIXME INVALID CASE you must override the template 'declareEObjectUpdater' for the case : singlecompositionviewSingleOptionalProperty, SingleCompositionViewerSample, SingleCompositionViewerSample.
		}
		if (EefnrViewsRepository.SingleCompositionViewerSample.Properties.singlecompositionviewerMultiRequiredProperty == event.getAffectedEditor()) {
			// FIXME INVALID CASE you must override the template 'declareEObjectUpdater' for the case : singlecompositionviewMultiRequiredProperty, SingleCompositionViewerSample, SingleCompositionViewerSample.
		}
		if (EefnrViewsRepository.SingleCompositionViewerSample.Properties.singlecompositionviewerMultiOptionalProperty == event.getAffectedEditor()) {
			// FIXME INVALID CASE you must override the template 'declareEObjectUpdater' for the case : singlecompositionviewMultiOptionalProperty, SingleCompositionViewerSample, SingleCompositionViewerSample.
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		if (editingPart.isVisible()) {	
			SingleCompositionViewerSamplePropertiesEditionPart basePart = (SingleCompositionViewerSamplePropertiesEditionPart)editingPart;
					if (msg.getFeature() != null && (((EStructuralFeature)msg.getFeature()) == EefnrPackage.eINSTANCE.getSingleCompositionViewerSample_SinglecompositionviewSingleRequiredProperty()) && isAccessible(EefnrViewsRepository.SingleCompositionViewerSample.Properties.singlecompositionviewerSingleRequiredProperty))
						basePart.setSinglecompositionviewerSingleRequiredProperty((Sample)msg.getNewValue());
					if (msg.getFeature() != null && (((EStructuralFeature)msg.getFeature()) == EefnrPackage.eINSTANCE.getSingleCompositionViewerSample_SinglecompositionviewSingleOptionalProperty()) && isAccessible(EefnrViewsRepository.SingleCompositionViewerSample.Properties.singlecompositionviewerSingleOptionalProperty))
						basePart.setSinglecompositionviewerSingleOptionalProperty((Sample)msg.getNewValue());
					if (msg.getFeature() != null && (((EStructuralFeature)msg.getFeature()) == EefnrPackage.eINSTANCE.getSingleCompositionViewerSample_SinglecompositionviewMultiRequiredProperty()) && isAccessible(EefnrViewsRepository.SingleCompositionViewerSample.Properties.singlecompositionviewerMultiRequiredProperty))
						basePart.setSinglecompositionviewerMultiRequiredProperty((AbstractSample)msg.getNewValue());
					if (msg.getFeature() != null && (((EStructuralFeature)msg.getFeature()) == EefnrPackage.eINSTANCE.getSingleCompositionViewerSample_SinglecompositionviewMultiOptionalProperty()) && isAccessible(EefnrViewsRepository.SingleCompositionViewerSample.Properties.singlecompositionviewerMultiOptionalProperty))
						basePart.setSinglecompositionviewerMultiOptionalProperty((AbstractSample)msg.getNewValue());
			
		}
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == EefnrViewsRepository.SingleCompositionViewerSample.Properties.singlecompositionviewerSingleRequiredProperty || key == EefnrViewsRepository.SingleCompositionViewerSample.Properties.singlecompositionviewerMultiRequiredProperty;
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
