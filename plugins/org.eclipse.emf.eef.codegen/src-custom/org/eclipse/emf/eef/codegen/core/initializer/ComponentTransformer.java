/*******************************************************************************
 * Copyright (c) 2008-2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.codegen.core.initializer;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.eef.components.ComponentsFactory;
import org.eclipse.emf.eef.components.PropertiesEditionComponent;
import org.eclipse.emf.eef.components.PropertiesEditionContext;
import org.eclipse.emf.eef.components.PropertiesEditionElement;
import org.eclipse.emf.eef.mapping.Category;
import org.eclipse.emf.eef.mapping.ElementBindingReference;
import org.eclipse.emf.eef.mapping.MappingFactory;
import org.eclipse.emf.eef.views.Container;
import org.eclipse.emf.eef.views.ElementEditor;
import org.eclipse.emf.eef.views.View;
import org.eclipse.emf.eef.views.ViewElement;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class ComponentTransformer extends AbstractTransformer {

	private Map<EObject, List<ViewElement>> workingResolvTemp;
	
	private PropertiesEditionComponent proprietes;
	
	private PropertiesEditionComponent stereotypes;

	/* ===== Constructor ===== */

	public ComponentTransformer(Map<EObject, List<ViewElement>> workingResolvTemp) {
		this.workingResolvTemp = workingResolvTemp;	
	}

	/* ===== Transformation ===== */

	public PropertiesEditionContext genPackage2Context(GenPackage genPackage) {
		PropertiesEditionContext context = ComponentsFactory.eINSTANCE.createPropertiesEditionContext();
		context.setModel(genPackage);
		context.setDocumentation("Edition Context for " + genPackage.getEcorePackage().getName() + " GenPackage");
		Category common = MappingFactory.eINSTANCE.createCategory();
		common.setName("common");
//		initCommonCategory(common,genPackage);
		context.getCategories().add(common);
		Category components = MappingFactory.eINSTANCE.createCategory();
		components.setName(genPackage.getEcorePackage().getName());
		context.getCategories().add(components);
		for (GenClass genClass : genPackage.getGenClasses()) {
			if (!genClass.getEcoreClass().isAbstract()) {
				components.getBindings().add(genClass2Component(genClass, genPackage));
			}
		}
		return context;
	}

	private void initCommonCategory(Category common, GenPackage genPackage) {
		EPackage metamodel = genPackage.getEcorePackage();
		EClass elementModele = findEClass(metamodel, "ElementModele");

		proprietes = ComponentsFactory.eINSTANCE.createPropertiesEditionComponent();
		proprietes.setName("Proprietes");
		proprietes.setModel(elementModele);
		proprietes.setExplicit(false);
		ViewElement propertiesView = findCommonView(metamodel, "Propriete");
		if (propertiesView != null)
			proprietes.getViews().add((View) propertiesView);
		PropertiesEditionElement elementProprietes = ComponentsFactory.eINSTANCE.createPropertiesEditionElement();
		elementProprietes.setName("listeProprietes");
		elementProprietes.setModel(findEStructuralFeature(metamodel, "listeProprietes"));
		List<ViewElement> listesProprieteViews = workingResolvTemp.get(findEStructuralFeature(metamodel, "listeProprietes"));
		if (listesProprieteViews != null && listesProprieteViews.size() == 1)
			elementProprietes.getViews().add((ElementEditor) listesProprieteViews.get(0));
		proprietes.getProperties().add(elementProprietes);
		common.getBindings().add(proprietes);
		
		stereotypes = ComponentsFactory.eINSTANCE.createPropertiesEditionComponent();
		stereotypes.setName("Stereotypes");
		stereotypes.setModel(elementModele);
		stereotypes.setExplicit(false);
		ViewElement stereotypeView = findCommonView(metamodel, "Stereotype");
		if (stereotypeView != null)
			stereotypes.getViews().add((View) stereotypeView);
		PropertiesEditionElement elementStereotypes = ComponentsFactory.eINSTANCE.createPropertiesEditionElement();
		elementStereotypes.setName("listeStereotypes");
		elementStereotypes.setModel(findEStructuralFeature(metamodel, "listeStereotypes"));
		List<ViewElement> listesStereotypeViews = workingResolvTemp.get(findEStructuralFeature(metamodel, "listeStereotypes"));
		if (listesStereotypeViews != null && listesStereotypeViews.size() == 1)
			elementStereotypes.getViews().add((ElementEditor) listesStereotypeViews.get(0));
		stereotypes.getProperties().add(elementStereotypes);
		common.getBindings().add(stereotypes);
	}

	public PropertiesEditionComponent genClass2Component(GenClass genClass, GenPackage genPackage) {
		PropertiesEditionComponent component = ComponentsFactory.eINSTANCE.createPropertiesEditionComponent();
		component.setName(genClass.getEcoreClass().getName());
		component.setModel(genClass.getEcoreClass());
		List<ViewElement> list = workingResolvTemp.get(genClass.getEcoreClass());
		for (ViewElement viewElement : list) {
			component.getViews().add((View)viewElement);
		}
		for (EStructuralFeature feature : genClass.getEcoreClass().getEAllStructuralFeatures()) {
			if (isSignificant(feature) && !feature.isDerived() && !inheritedMember(feature, genClass.getEcoreClass())) {
				PropertiesEditionElement structuralFeature2EditionElement = eStructuralFeature2EditionElement(list, feature);
				if (structuralFeature2EditionElement != null) component.getProperties().add(structuralFeature2EditionElement);
			}
		}
//		if (findEClass(genPackage.getEcorePackage(), "ElementModele").isSuperTypeOf((EClass)component.getModel())) {
//			ElementBindingReference propertiesBindingReference = MappingFactory.eINSTANCE.createElementBindingReference();
//			propertiesBindingReference.setBinding(proprietes);
//			component.getReferencedBinding().add(propertiesBindingReference);
//			ElementBindingReference stereotypesBindingReference = MappingFactory.eINSTANCE.createElementBindingReference();
//			stereotypesBindingReference.setBinding(stereotypes);
//			component.getReferencedBinding().add(stereotypesBindingReference);
//		}
		return component;

	}

	public PropertiesEditionElement eStructuralFeature2EditionElement(List<ViewElement> concerningViews, EStructuralFeature feature) {
		PropertiesEditionElement element = ComponentsFactory.eINSTANCE.createPropertiesEditionElement();
		element.setName(feature.getName());
		element.setModel(feature);
		List<ViewElement> list = workingResolvTemp.get(feature);
		if (list != null) {
			for (ViewElement viewElement : list) {
				if (inConcerningViews(concerningViews, viewElement))
					element.getViews().add((ElementEditor) viewElement);
			}
		}
		else {
			System.err.println("No view found for : " + feature.toString());
			return null;
		}
		return element;

	}
	
	
	/* ===== Misc utilities ===== */
	private boolean inConcerningViews(List<ViewElement> concerningViews, ViewElement toCheck) {
		for (ViewElement viewElement : concerningViews) {
			if (viewElement instanceof View) {
				if (inConcerningView((View)viewElement, toCheck))
					return true;
			}
		}
		return false;
	}

	private boolean inConcerningView(View concerningView, ViewElement toCheck) {
		if (toCheck instanceof View && EcoreUtil.equals(concerningView, toCheck))
			return true;
		else {
			Container next = toCheck.getContainer();
			if (next != null)
				return inConcerningView(concerningView, next);
			else 
				return false;
		}
	}
	
	private ViewElement findCommonView(EPackage metamodel, String name) {
		List<ViewElement> proprieteViews = workingResolvTemp.get(findEClass(metamodel, name));
		if (proprieteViews != null && proprieteViews.size() > 0) {
			for (ViewElement viewElement : proprieteViews) {
				if (viewElement.eContainer() instanceof org.eclipse.emf.eef.views.Category && "common".equals(((org.eclipse.emf.eef.views.Category)viewElement.eContainer()).getName()))
					return viewElement;
			}
		}
		return null;
	}

	
}
