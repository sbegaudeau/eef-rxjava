/*******************************************************************************
 * Copyright (c) 2008, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.navigation.components;

// Start of user code for imports
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.eef.eefnr.EefnrPackage;

import org.eclipse.emf.eef.eefnr.navigation.FirstModelNavigation;
import org.eclipse.emf.eef.eefnr.navigation.NavigationFactory;
import org.eclipse.emf.eef.eefnr.navigation.NavigationPackage;
import org.eclipse.emf.eef.eefnr.navigation.SecondModelNavigation;
import org.eclipse.emf.eef.eefnr.navigation.SmartModelNavigationSample;

import org.eclipse.emf.eef.eefnr.navigation.parts.NavigationViewsRepository;
import org.eclipse.emf.eef.eefnr.navigation.parts.SmartNavigationSamplePropertiesEditionPart;

import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;

import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.parts.CompositePropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;

import org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFEditorSettingsBuilder;

import org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFEditorSettingsBuilder.EEFEditorSettingsImpl;

import org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFFilter;
import org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFInitializer;
import org.eclipse.emf.eef.runtime.ui.widgets.settings.NavigationStepBuilder;


// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class SmartModelNavigationSamplePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String SMARTNAVIGATIONSAMPLE_PART = "SmartNavigationSample"; //$NON-NLS-1$

	
	
	/**
	 * Settings for firstModelNavigationSingleValue editor
	 */
	protected EEFEditorSettingsImpl firstModelNavigationSingleValueSettings = (EEFEditorSettingsImpl) EEFEditorSettingsBuilder.create(semanticObject, EefnrPackage.eINSTANCE.getAbstractSample_Name())
	.nextStep(NavigationStepBuilder.create(NavigationPackage.eINSTANCE.getSmartModelNavigationSample_FirstModelNavigation2())
	.index(0)
	.init(new EEFInitializer() {
	
		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFInit#init(org.eclipse.emf.ecore.EObject)
		*/
		@Override
		protected EObject init(EObject semanticObject) {
			return new org.eclipse.emf.eef.eefnr.utils.Utils().initFirstModelNavigationSingleValue2(semanticObject);
		}
	
	}).build())
	.build();
	
	/**
	 * Settings for firstModelNavigationMultiValue editor
	 */
	protected EEFEditorSettingsImpl firstModelNavigationMultiValueSettings = (EEFEditorSettingsImpl) EEFEditorSettingsBuilder.create(semanticObject, EefnrPackage.eINSTANCE.getAbstractSample_Name())
	.nextStep(NavigationStepBuilder.create(NavigationPackage.eINSTANCE.getSmartModelNavigationSample_SeveralFirstModelNavigation2())
	.index(0)
	.init(new EEFInitializer() {
	
		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFInit#init(org.eclipse.emf.ecore.EObject)
		*/
		@Override
		protected EObject init(EObject semanticObject) {
			return org.eclipse.emf.eef.eefnr.utils.Utils.initFirstModelNavigationMultiValue2(semanticObject);
		}
	
	}).build())
	.build();
	
	/**
	 * Settings for secondMNSingleValueWithFirstMNSingleValue editor
	 */
	protected EEFEditorSettingsImpl secondMNSingleValueWithFirstMNSingleValueSettings = (EEFEditorSettingsImpl) EEFEditorSettingsBuilder.create(semanticObject, EefnrPackage.eINSTANCE.getAbstractSample_Name())
	.nextStep(NavigationStepBuilder.create(NavigationPackage.eINSTANCE.getSmartModelNavigationSample_FirstModelNavigation())
	.index(0)
	.init(new EEFInitializer() {
	
		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFInit#init(org.eclipse.emf.ecore.EObject)
		*/
		@Override
		protected EObject init(EObject semanticObject) {
			return new org.eclipse.emf.eef.eefnr.utils.Utils().initFirstModelNavigationSingleValue(semanticObject);
		}
	
	}).build())
	.nextStep(NavigationStepBuilder.create(NavigationPackage.eINSTANCE.getFirstModelNavigation_SecondModelNavigation())
	.index(0)
	.init(new EEFInitializer() {
	
		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFInit#init(org.eclipse.emf.ecore.EObject)
		*/
		@Override
		protected EObject init(EObject semanticObject) {
	if (semanticObject instanceof FirstModelNavigation) {
	SecondModelNavigation result = NavigationFactory.eINSTANCE.createSecondModelNavigation();
	((FirstModelNavigation) semanticObject).setSecondModelNavigation(result);
	result.setName("FSM single");
	return result;
	}
	return null;
		}
	
	}).build())
	.build();
	
	/**
	 * Settings for secondMNSingleValueWithFirstMNMultiValue editor
	 */
	protected EEFEditorSettingsImpl secondMNSingleValueWithFirstMNMultiValueSettings = (EEFEditorSettingsImpl) EEFEditorSettingsBuilder.create(semanticObject, EefnrPackage.eINSTANCE.getAbstractSample_Name())
	.nextStep(NavigationStepBuilder.create(NavigationPackage.eINSTANCE.getSmartModelNavigationSample_FirstModelNavigation())
	.index(0)
	.init(new EEFInitializer() {
	
		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFInit#init(org.eclipse.emf.ecore.EObject)
		*/
		@Override
		protected EObject init(EObject semanticObject) {
			return new org.eclipse.emf.eef.eefnr.utils.Utils().initFirstModelNavigationSingleValue(semanticObject);
		}
	
	}).build())
	.nextStep(NavigationStepBuilder.create(NavigationPackage.eINSTANCE.getFirstModelNavigation_SeveralSecondModelNavigation())
	.index(0)
	.init(new EEFInitializer() {
	
		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFInit#init(org.eclipse.emf.ecore.EObject)
		*/
		@Override
		protected EObject init(EObject semanticObject) {
	if (semanticObject instanceof FirstModelNavigation) {
	SecondModelNavigation result = NavigationFactory.eINSTANCE.createSecondModelNavigation();
	((FirstModelNavigation) semanticObject).getSeveralSecondModelNavigation().add((SecondModelNavigation) result);
	result.setName("SSM multi");
	return result;
	}
	return null;
		}
	
	}).build())
	.build();
	
	/**
	 * Settings for secondMNMultiValueWithFirstMNSingleValue editor
	 */
	protected EEFEditorSettingsImpl secondMNMultiValueWithFirstMNSingleValueSettings = (EEFEditorSettingsImpl) EEFEditorSettingsBuilder.create(semanticObject, EefnrPackage.eINSTANCE.getAbstractSample_Name())
	.nextStep(NavigationStepBuilder.create(NavigationPackage.eINSTANCE.getSmartModelNavigationSample_SeveralFirstModelNavigation())
	.index(0)
	.init(new EEFInitializer() {
	
		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFInit#init(org.eclipse.emf.ecore.EObject)
		*/
		@Override
		protected EObject init(EObject semanticObject) {
			return org.eclipse.emf.eef.eefnr.utils.Utils.initFirstModelNavigationMultiValue(semanticObject);
		}
	
	}).build())
	.nextStep(NavigationStepBuilder.create(NavigationPackage.eINSTANCE.getFirstModelNavigation_SecondModelNavigation())
	.index(0)
	.init(new EEFInitializer() {
	
		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFInit#init(org.eclipse.emf.ecore.EObject)
		*/
		@Override
		protected EObject init(EObject semanticObject) {
	if (semanticObject instanceof FirstModelNavigation) {
	SecondModelNavigation result = NavigationFactory.eINSTANCE.createSecondModelNavigation();
	((FirstModelNavigation) semanticObject).setSecondModelNavigation(result);
	result.setName("SSM single");
	return result;
	}
	return null;
		}
	
	}).build())
	.build();
	
	/**
	 * Settings for secondMNMultiValueWithFirstMNMultiValue editor
	 */
	protected EEFEditorSettingsImpl secondMNMultiValueWithFirstMNMultiValueSettings = (EEFEditorSettingsImpl) EEFEditorSettingsBuilder.create(semanticObject, EefnrPackage.eINSTANCE.getAbstractSample_Name())
	.nextStep(NavigationStepBuilder.create(NavigationPackage.eINSTANCE.getSmartModelNavigationSample_SeveralFirstModelNavigation())
	.index(0)
	.init(new EEFInitializer() {
	
		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFInit#init(org.eclipse.emf.ecore.EObject)
		*/
		@Override
		protected EObject init(EObject semanticObject) {
			return org.eclipse.emf.eef.eefnr.utils.Utils.initFirstModelNavigationMultiValue(semanticObject);
		}
	
	}).build())
	.nextStep(NavigationStepBuilder.create(NavigationPackage.eINSTANCE.getFirstModelNavigation_SeveralSecondModelNavigation())
	.index(0)
	.init(new EEFInitializer() {
	
		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFInit#init(org.eclipse.emf.ecore.EObject)
		*/
		@Override
		protected EObject init(EObject semanticObject) {
	if (semanticObject instanceof FirstModelNavigation) {
	SecondModelNavigation result = NavigationFactory.eINSTANCE.createSecondModelNavigation();
	((FirstModelNavigation) semanticObject).getSeveralSecondModelNavigation().add((SecondModelNavigation) result);
	result.setName("SSM multi");
	return result;
	}
	return null;
		}
	
	}).build())
	.build();
	
	/**
	 * Settings for secondMNMultiValueWithFirstMNMultiValueWithFilter editor
	 */
	protected EEFEditorSettingsImpl secondMNMultiValueWithFirstMNMultiValueWithFilterSettings = (EEFEditorSettingsImpl) EEFEditorSettingsBuilder.create(semanticObject, EefnrPackage.eINSTANCE.getAbstractSample_Name())
	.nextStep(NavigationStepBuilder.create(NavigationPackage.eINSTANCE.getSmartModelNavigationSample_SeveralFirstModelNavigation())
	.index(0)
	.init(new EEFInitializer() {
	
		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFInit#init(org.eclipse.emf.ecore.EObject)
		*/
		@Override
		protected EObject init(EObject semanticObject) {
			return org.eclipse.emf.eef.eefnr.utils.Utils.initFirstModelNavigationMultiValueWithFilters(semanticObject);
		}
	
	})
	.filter(new EEFFilter() {
		
		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFFilter#select(org.eclipse.emf.ecore.EObject)
		*/
		@Override
		protected boolean select(EObject semanticObject) {
			return new org.eclipse.emf.eef.eefnr.utils.Utils().filter1FirstModelNavigation(semanticObject);
		}
	
	})
	.filter(new EEFFilter() {
		
		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFFilter#select(org.eclipse.emf.ecore.EObject)
		*/
		@Override
		protected boolean select(EObject semanticObject) {
	return semanticObject instanceof FirstModelNavigation && ((FirstModelNavigation) semanticObject).isFilter2();
		}
	
	})
	.build())
	.nextStep(NavigationStepBuilder.create(NavigationPackage.eINSTANCE.getFirstModelNavigation_SeveralSecondModelNavigation())
	.index(0)
	.init(new EEFInitializer() {
	
		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFInit#init(org.eclipse.emf.ecore.EObject)
		*/
		@Override
		protected EObject init(EObject semanticObject) {
	if (semanticObject instanceof FirstModelNavigation) {
	SecondModelNavigation result = NavigationFactory.eINSTANCE.createSecondModelNavigation();
	((FirstModelNavigation) semanticObject).getSeveralSecondModelNavigation().add((SecondModelNavigation) result);
	result.setFilter3(true);
	result.setFilter4(true);
	result.setName("SSM multi with filters");
	return result;
	}
	return null;
		}
	
	})
	.filter(new EEFFilter() {
		
		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFFilter#select(org.eclipse.emf.ecore.EObject)
		*/
		@Override
		protected boolean select(EObject semanticObject) {
			return org.eclipse.emf.eef.eefnr.utils.Utils.filter3FirstModelNavigation(semanticObject);
		}
	
	})
	.filter(new EEFFilter() {
		
		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFFilter#select(org.eclipse.emf.ecore.EObject)
		*/
		@Override
		protected boolean select(EObject semanticObject) {
	return semanticObject instanceof SecondModelNavigation && ((SecondModelNavigation) semanticObject).isFilter4();
		}
	
	})
	.build())
	.build();
	
	/**
	 * Default constructor
	 * 
	 */
	public SmartModelNavigationSamplePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject smartModelNavigationSample, String editing_mode) {
		super(editingContext, smartModelNavigationSample, editing_mode);
		parts = new String[] { SMARTNAVIGATIONSAMPLE_PART };
		repositoryKey = NavigationViewsRepository.class;
		partKey = NavigationViewsRepository.SmartNavigationSample.class;
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
			if (editingPart instanceof CompositePropertiesEditionPart) {
		((CompositePropertiesEditionPart) editingPart).getSettings().add(firstModelNavigationSingleValueSettings);
		((CompositePropertiesEditionPart) editingPart).getSettings().add(firstModelNavigationMultiValueSettings);
		((CompositePropertiesEditionPart) editingPart).getSettings().add(secondMNSingleValueWithFirstMNSingleValueSettings);
		((CompositePropertiesEditionPart) editingPart).getSettings().add(secondMNSingleValueWithFirstMNMultiValueSettings);
		((CompositePropertiesEditionPart) editingPart).getSettings().add(secondMNMultiValueWithFirstMNSingleValueSettings);
		((CompositePropertiesEditionPart) editingPart).getSettings().add(secondMNMultiValueWithFirstMNMultiValueSettings);
		((CompositePropertiesEditionPart) editingPart).getSettings().add(secondMNMultiValueWithFirstMNMultiValueWithFilterSettings);
		editingContext.setAllSettings(((CompositePropertiesEditionPart) editingPart).getSettings());
	}
			final SmartModelNavigationSample smartModelNavigationSample = (SmartModelNavigationSample)elt;
			final SmartNavigationSamplePropertiesEditionPart smartNavigationSamplePart = (SmartNavigationSamplePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(NavigationViewsRepository.SmartNavigationSample.Properties.name))
		smartNavigationSamplePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, smartModelNavigationSample.getName()));
	
			if (firstModelNavigationSingleValueSettings.getValue() != null && isAccessible(NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationSingleValue))
		smartNavigationSamplePart.setFirstModelNavigationSingleValue(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, firstModelNavigationSingleValueSettings.getValue()));
	
			if (firstModelNavigationMultiValueSettings.getValue() != null && isAccessible(NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationMultiValue))
		smartNavigationSamplePart.setFirstModelNavigationMultiValue(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, firstModelNavigationMultiValueSettings.getValue()));
	
			if (secondMNSingleValueWithFirstMNSingleValueSettings.getValue() != null && isAccessible(NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue))
		smartNavigationSamplePart.setSecondModelNavigationSingleValue(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, secondMNSingleValueWithFirstMNSingleValueSettings.getValue()));
	
			if (secondMNSingleValueWithFirstMNMultiValueSettings.getValue() != null && isAccessible(NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue))
		smartNavigationSamplePart.setSecondModelNavigationMultiValue(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, secondMNSingleValueWithFirstMNMultiValueSettings.getValue()));
	
			if (secondMNMultiValueWithFirstMNSingleValueSettings.getValue() != null && isAccessible(NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue2))
		smartNavigationSamplePart.setSecondModelNavigationSingleValue2(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, secondMNMultiValueWithFirstMNSingleValueSettings.getValue()));
	
			if (secondMNMultiValueWithFirstMNMultiValueSettings.getValue() != null && isAccessible(NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue2))
		smartNavigationSamplePart.setSecondModelNavigationMultiValue2(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, secondMNMultiValueWithFirstMNMultiValueSettings.getValue()));
	
			if (secondMNMultiValueWithFirstMNMultiValueWithFilterSettings.getValue() != null && isAccessible(NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValueFilter))
		smartNavigationSamplePart.setSecondModelNavigationMultiValueFilter(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, secondMNMultiValueWithFirstMNMultiValueWithFilterSettings.getValue()));
	
			// init filters
			
			
			
			
			
			
			
			
			// init values for referenced views
			
			// init filters for referenced views
			
		}
		setInitializing(false);
	}










	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent#shouldProcess(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 */
	protected boolean shouldProcess(IPropertiesEditionEvent event) {
		if (event.getAffectedEditor() == NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationSingleValue) {
			return (firstModelNavigationSingleValueSettings.getValue() == null) ? (event.getNewValue() != null) : (!firstModelNavigationSingleValueSettings.getValue().equals(event.getNewValue()));
		}
		if (event.getAffectedEditor() == NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationMultiValue) {
			return (firstModelNavigationMultiValueSettings.getValue() == null) ? (event.getNewValue() != null) : (!firstModelNavigationMultiValueSettings.getValue().equals(event.getNewValue()));
		}
		if (event.getAffectedEditor() == NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue) {
			return (secondMNSingleValueWithFirstMNSingleValueSettings.getValue() == null) ? (event.getNewValue() != null) : (!secondMNSingleValueWithFirstMNSingleValueSettings.getValue().equals(event.getNewValue()));
		}
		if (event.getAffectedEditor() == NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue) {
			return (secondMNSingleValueWithFirstMNMultiValueSettings.getValue() == null) ? (event.getNewValue() != null) : (!secondMNSingleValueWithFirstMNMultiValueSettings.getValue().equals(event.getNewValue()));
		}
		if (event.getAffectedEditor() == NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue2) {
			return (secondMNMultiValueWithFirstMNSingleValueSettings.getValue() == null) ? (event.getNewValue() != null) : (!secondMNMultiValueWithFirstMNSingleValueSettings.getValue().equals(event.getNewValue()));
		}
		if (event.getAffectedEditor() == NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue2) {
			return (secondMNMultiValueWithFirstMNMultiValueSettings.getValue() == null) ? (event.getNewValue() != null) : (!secondMNMultiValueWithFirstMNMultiValueSettings.getValue().equals(event.getNewValue()));
		}
		if (event.getAffectedEditor() == NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValueFilter) {
			return (secondMNMultiValueWithFirstMNMultiValueWithFilterSettings.getValue() == null) ? (event.getNewValue() != null) : (!secondMNMultiValueWithFirstMNMultiValueWithFilterSettings.getValue().equals(event.getNewValue()));
		}
		return super.shouldProcess(event);
	}	

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
	 */
	public EStructuralFeature associatedFeature(Object editorKey) {
		if (editorKey == NavigationViewsRepository.SmartNavigationSample.Properties.name) {
			return EefnrPackage.eINSTANCE.getAbstractSample_Name();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		SmartModelNavigationSample smartModelNavigationSample = (SmartModelNavigationSample)semanticObject;
		if (NavigationViewsRepository.SmartNavigationSample.Properties.name == event.getAffectedEditor()) {
			smartModelNavigationSample.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationSingleValue == event.getAffectedEditor()) {
			firstModelNavigationSingleValueSettings.setValue((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationMultiValue == event.getAffectedEditor()) {
			firstModelNavigationMultiValueSettings.setValue((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue == event.getAffectedEditor()) {
			secondMNSingleValueWithFirstMNSingleValueSettings.setValue((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue == event.getAffectedEditor()) {
			secondMNSingleValueWithFirstMNMultiValueSettings.setValue((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue2 == event.getAffectedEditor()) {
			secondMNMultiValueWithFirstMNSingleValueSettings.setValue((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue2 == event.getAffectedEditor()) {
			secondMNMultiValueWithFirstMNMultiValueSettings.setValue((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValueFilter == event.getAffectedEditor()) {
			secondMNMultiValueWithFirstMNMultiValueWithFilterSettings.setValue((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			SmartNavigationSamplePropertiesEditionPart smartNavigationSamplePart = (SmartNavigationSamplePropertiesEditionPart)editingPart;
			if (EefnrPackage.eINSTANCE.getAbstractSample_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && smartNavigationSamplePart != null && isAccessible(NavigationViewsRepository.SmartNavigationSample.Properties.name)) {
		if (msg.getNewValue() != null) {
			smartNavigationSamplePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
		} else {
			smartNavigationSamplePart.setName("");
		}
	}
			if (!(msg.getNewValue() instanceof EObject) && firstModelNavigationSingleValueSettings.isAffectingEvent(msg) && smartNavigationSamplePart != null && isAccessible(NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationSingleValue)) {
		if (msg.getNewValue() != null) {
			smartNavigationSamplePart.setFirstModelNavigationSingleValue(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
		} else {
			smartNavigationSamplePart.setFirstModelNavigationSingleValue("");
		}
	}
			if (!(msg.getNewValue() instanceof EObject) && firstModelNavigationMultiValueSettings.isAffectingEvent(msg) && smartNavigationSamplePart != null && isAccessible(NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationMultiValue)) {
		if (msg.getNewValue() != null) {
			smartNavigationSamplePart.setFirstModelNavigationMultiValue(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
		} else {
			smartNavigationSamplePart.setFirstModelNavigationMultiValue("");
		}
	}
			if (!(msg.getNewValue() instanceof EObject) && secondMNSingleValueWithFirstMNSingleValueSettings.isAffectingEvent(msg) && smartNavigationSamplePart != null && isAccessible(NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue)) {
		if (msg.getNewValue() != null) {
			smartNavigationSamplePart.setSecondModelNavigationSingleValue(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
		} else {
			smartNavigationSamplePart.setSecondModelNavigationSingleValue("");
		}
	}
			if (!(msg.getNewValue() instanceof EObject) && secondMNSingleValueWithFirstMNMultiValueSettings.isAffectingEvent(msg) && smartNavigationSamplePart != null && isAccessible(NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue)) {
		if (msg.getNewValue() != null) {
			smartNavigationSamplePart.setSecondModelNavigationMultiValue(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
		} else {
			smartNavigationSamplePart.setSecondModelNavigationMultiValue("");
		}
	}
			if (!(msg.getNewValue() instanceof EObject) && secondMNMultiValueWithFirstMNSingleValueSettings.isAffectingEvent(msg) && smartNavigationSamplePart != null && isAccessible(NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue2)) {
		if (msg.getNewValue() != null) {
			smartNavigationSamplePart.setSecondModelNavigationSingleValue2(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
		} else {
			smartNavigationSamplePart.setSecondModelNavigationSingleValue2("");
		}
	}
			if (!(msg.getNewValue() instanceof EObject) && secondMNMultiValueWithFirstMNMultiValueSettings.isAffectingEvent(msg) && smartNavigationSamplePart != null && isAccessible(NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue2)) {
		if (msg.getNewValue() != null) {
			smartNavigationSamplePart.setSecondModelNavigationMultiValue2(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
		} else {
			smartNavigationSamplePart.setSecondModelNavigationMultiValue2("");
		}
	}
			if (!(msg.getNewValue() instanceof EObject) && secondMNMultiValueWithFirstMNMultiValueWithFilterSettings.isAffectingEvent(msg) && smartNavigationSamplePart != null && isAccessible(NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValueFilter)) {
		if (msg.getNewValue() != null) {
			smartNavigationSamplePart.setSecondModelNavigationMultiValueFilter(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
		} else {
			smartNavigationSamplePart.setSecondModelNavigationMultiValueFilter("");
		}
	}
			
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getNotificationFilters()
	 */
	@Override
	protected NotificationFilter[] getNotificationFilters() {
		NotificationFilter filter = new EStructuralFeatureNotificationFilter(
			EefnrPackage.eINSTANCE.getAbstractSample_Name(),
			EefnrPackage.eINSTANCE.getAbstractSample_Name(),
			NavigationPackage.eINSTANCE.getSmartModelNavigationSample_FirstModelNavigation2(),
			EefnrPackage.eINSTANCE.getAbstractSample_Name(),
			NavigationPackage.eINSTANCE.getSmartModelNavigationSample_SeveralFirstModelNavigation2(),
			EefnrPackage.eINSTANCE.getAbstractSample_Name(),
			NavigationPackage.eINSTANCE.getSmartModelNavigationSample_FirstModelNavigation(),
			NavigationPackage.eINSTANCE.getFirstModelNavigation_SecondModelNavigation(),
			EefnrPackage.eINSTANCE.getAbstractSample_Name(),
			NavigationPackage.eINSTANCE.getSmartModelNavigationSample_FirstModelNavigation(),
			NavigationPackage.eINSTANCE.getFirstModelNavigation_SeveralSecondModelNavigation(),
			EefnrPackage.eINSTANCE.getAbstractSample_Name(),
			NavigationPackage.eINSTANCE.getSmartModelNavigationSample_SeveralFirstModelNavigation(),
			NavigationPackage.eINSTANCE.getFirstModelNavigation_SecondModelNavigation(),
			EefnrPackage.eINSTANCE.getAbstractSample_Name(),
			NavigationPackage.eINSTANCE.getSmartModelNavigationSample_SeveralFirstModelNavigation(),
			NavigationPackage.eINSTANCE.getFirstModelNavigation_SeveralSecondModelNavigation(),
			EefnrPackage.eINSTANCE.getAbstractSample_Name(),
			NavigationPackage.eINSTANCE.getSmartModelNavigationSample_SeveralFirstModelNavigation(),
			NavigationPackage.eINSTANCE.getFirstModelNavigation_SeveralSecondModelNavigation()		);
		return new NotificationFilter[] {filter,};
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
					if (NavigationViewsRepository.SmartNavigationSample.Properties.name == event.getAffectedEditor()) {
						Object newValue = event.getNewValue();
						if (newValue instanceof String) {
							newValue = EEFConverterUtil.createFromString(EefnrPackage.eINSTANCE.getAbstractSample_Name().getEAttributeType(), (String)newValue);
						}
						ret = Diagnostician.INSTANCE.validate(EefnrPackage.eINSTANCE.getAbstractSample_Name().getEAttributeType(), newValue);
					}
					if (NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationSingleValue == event.getAffectedEditor()) {
						Object newValue = event.getNewValue();
						if (newValue instanceof String) {
							newValue = EEFConverterUtil.createFromString(EefnrPackage.eINSTANCE.getAbstractSample_Name().getEAttributeType(), (String)newValue);
						}
						ret = Diagnostician.INSTANCE.validate(EefnrPackage.eINSTANCE.getAbstractSample_Name().getEAttributeType(), newValue);
					}
					if (NavigationViewsRepository.SmartNavigationSample.Properties.firstModelNavigationMultiValue == event.getAffectedEditor()) {
						Object newValue = event.getNewValue();
						if (newValue instanceof String) {
							newValue = EEFConverterUtil.createFromString(EefnrPackage.eINSTANCE.getAbstractSample_Name().getEAttributeType(), (String)newValue);
						}
						ret = Diagnostician.INSTANCE.validate(EefnrPackage.eINSTANCE.getAbstractSample_Name().getEAttributeType(), newValue);
					}
					if (NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue == event.getAffectedEditor()) {
						Object newValue = event.getNewValue();
						if (newValue instanceof String) {
							newValue = EEFConverterUtil.createFromString(EefnrPackage.eINSTANCE.getAbstractSample_Name().getEAttributeType(), (String)newValue);
						}
						ret = Diagnostician.INSTANCE.validate(EefnrPackage.eINSTANCE.getAbstractSample_Name().getEAttributeType(), newValue);
					}
					if (NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue == event.getAffectedEditor()) {
						Object newValue = event.getNewValue();
						if (newValue instanceof String) {
							newValue = EEFConverterUtil.createFromString(EefnrPackage.eINSTANCE.getAbstractSample_Name().getEAttributeType(), (String)newValue);
						}
						ret = Diagnostician.INSTANCE.validate(EefnrPackage.eINSTANCE.getAbstractSample_Name().getEAttributeType(), newValue);
					}
					if (NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationSingleValue2 == event.getAffectedEditor()) {
						Object newValue = event.getNewValue();
						if (newValue instanceof String) {
							newValue = EEFConverterUtil.createFromString(EefnrPackage.eINSTANCE.getAbstractSample_Name().getEAttributeType(), (String)newValue);
						}
						ret = Diagnostician.INSTANCE.validate(EefnrPackage.eINSTANCE.getAbstractSample_Name().getEAttributeType(), newValue);
					}
					if (NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValue2 == event.getAffectedEditor()) {
						Object newValue = event.getNewValue();
						if (newValue instanceof String) {
							newValue = EEFConverterUtil.createFromString(EefnrPackage.eINSTANCE.getAbstractSample_Name().getEAttributeType(), (String)newValue);
						}
						ret = Diagnostician.INSTANCE.validate(EefnrPackage.eINSTANCE.getAbstractSample_Name().getEAttributeType(), newValue);
					}
					if (NavigationViewsRepository.SmartNavigationSample.Properties.secondModelNavigationMultiValueFilter == event.getAffectedEditor()) {
						Object newValue = event.getNewValue();
						if (newValue instanceof String) {
							newValue = EEFConverterUtil.createFromString(EefnrPackage.eINSTANCE.getAbstractSample_Name().getEAttributeType(), (String)newValue);
						}
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
	 * @ return settings for firstModelNavigationSingleValue editor
	 */
	public EEFEditorSettingsImpl getFirstModelNavigationSingleValueSettings() {
			return firstModelNavigationSingleValueSettings;
	}
	/**
	 * @ return settings for firstModelNavigationMultiValue editor
	 */
	public EEFEditorSettingsImpl getFirstModelNavigationMultiValueSettings() {
			return firstModelNavigationMultiValueSettings;
	}
	/**
	 * @ return settings for secondMNSingleValueWithFirstMNSingleValue editor
	 */
	public EEFEditorSettingsImpl getSecondMNSingleValueWithFirstMNSingleValueSettings() {
			return secondMNSingleValueWithFirstMNSingleValueSettings;
	}
	/**
	 * @ return settings for secondMNSingleValueWithFirstMNMultiValue editor
	 */
	public EEFEditorSettingsImpl getSecondMNSingleValueWithFirstMNMultiValueSettings() {
			return secondMNSingleValueWithFirstMNMultiValueSettings;
	}
	/**
	 * @ return settings for secondMNMultiValueWithFirstMNSingleValue editor
	 */
	public EEFEditorSettingsImpl getSecondMNMultiValueWithFirstMNSingleValueSettings() {
			return secondMNMultiValueWithFirstMNSingleValueSettings;
	}
	/**
	 * @ return settings for secondMNMultiValueWithFirstMNMultiValue editor
	 */
	public EEFEditorSettingsImpl getSecondMNMultiValueWithFirstMNMultiValueSettings() {
			return secondMNMultiValueWithFirstMNMultiValueSettings;
	}
	/**
	 * @ return settings for secondMNMultiValueWithFirstMNMultiValueWithFilter editor
	 */
	public EEFEditorSettingsImpl getSecondMNMultiValueWithFirstMNMultiValueWithFilterSettings() {
			return secondMNMultiValueWithFirstMNMultiValueWithFilterSettings;
	}

}
