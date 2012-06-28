/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipse.emf.samples.conference.presentation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.eef.runtime.query.QueryResult;
import org.eclipse.emf.eef.runtime.query.QueryWrapper;

import org.eclipse.emf.eef.runtime.query.ocl.OCLQuery;

import org.eclipse.emf.eef.runtime.ui.EEFExtendedRuntime;

import org.eclipse.emf.eef.runtime.ui.editor.InteractiveEEFEditor;

import org.eclipse.emf.eef.runtime.ui.editors.pages.EEFStandardFormPage;

import org.eclipse.emf.eef.runtime.ui.editors.pages.eefviewer.EEFPropertiesViewerMDFormPage;

import org.eclipse.emf.eef.runtime.ui.editors.pages.tree.EEFTreeMDFormPage;

import org.eclipse.emf.eef.runtime.ui.viewers.filters.PropertiesEditionPartFilter;

import org.eclipse.emf.samples.conference.ConferencePackage;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.swt.widgets.Composite;

import org.eclipse.ui.PartInitException;
/**
 * This is an example of a conference model editor.
 * 
 */
public class ConferenceEditor extends InteractiveEEFEditor {


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.ui.editor.InteractiveEEFEditor#contributePages()
	 */
	protected void contributePages() {
		try {
			{
				Object input = null;
				if (getEditingDomain().getResourceSet() != null && getEditingDomain().getResourceSet().getResources().size() > 0) {
					Resource resource = getEditingDomain().getResourceSet().getResources().get(0);
					if (resource.getContents() != null && resource.getContents().size() > 0) {
						EObject element = resource.getContents().get(0);
						OCLQuery query = new OCLQuery(ConferencePackage.Literals.CONFERENCE, "self");
						if (EEFExtendedRuntime.INSTANCE.getProcessor().canEvaluate(query)) {
							QueryResult result = EEFExtendedRuntime.INSTANCE.getProcessor().evaluate(element, query);
							if (result.evaluationStatus.isOK()) {
								input = result.evaluationResult;
							}
						}
					}
				}
				
				List<ViewerFilter> filters = new ArrayList<ViewerFilter>(1);
				filters.add(new PropertiesEditionPartFilter("Base"));
				{
					final EEFStandardFormPage page = new EEFStandardFormPage(ConferenceEditor.this, "main");
					page.setAdapterFactory(adapterFactory);
					page.setEditingDomain(editingDomain);
					for (ViewerFilter viewerFilter : filters) {
						page.addFilter(viewerFilter);
					}
					page.setInput(input);
					addPage(page);
				}
			}
			{
				Object input = null;
				if (getEditingDomain().getResourceSet() != null && getEditingDomain().getResourceSet().getResources().size() > 0) {
					Resource resource = getEditingDomain().getResourceSet().getResources().get(0);
					if (resource.getContents() != null && resource.getContents().size() > 0) {
						EObject element = resource.getContents().get(0);
						OCLQuery query = new OCLQuery(ConferencePackage.Literals.CONFERENCE, "self");
						if (EEFExtendedRuntime.INSTANCE.getProcessor().canEvaluate(query)) {
							QueryResult result = EEFExtendedRuntime.INSTANCE.getProcessor().evaluate(element, query);
							if (result.evaluationStatus.isOK()) {
								input = result.evaluationResult;
							}
						}
					}
				}
				
				List<ViewerFilter> filters = new ArrayList<ViewerFilter>(1);
				filters.add(new ViewerFilter() {
						public boolean select(Viewer viewer, Object parentElement, Object element) {
							if (element instanceof EObject) {
								final QueryWrapper query = new OCLQuery(EcorePackage.eINSTANCE.getEObject(), "self.oclIsKindOf(conference::Person)");
								if (EEFExtendedRuntime.INSTANCE.getProcessor().canEvaluate(query)) {
									final QueryResult evaluate = EEFExtendedRuntime.INSTANCE.getProcessor().evaluate((EObject) element, query);
									if (evaluate.evaluationStatus.isOK()) {
										return (Boolean)evaluate.evaluationResult;
									}
								}
							}
							return true;
						}
					});
				{
					final EEFTreeMDFormPage page = new EEFTreeMDFormPage(ConferenceEditor.this, "participants") {
					
						/**
						 * {@inheritDoc}
						 * @see org.eclipse.ui.forms.editor.FormPage#createPartControl(org.eclipse.swt.widgets.Composite)
						 */
						public void createPartControl(Composite parent) {
							super.createPartControl(parent);
							getModelViewer().addSelectionChangedListener(new ISelectionChangedListener() {
								// This just notifies those things that are affected by the section.
								//
								public void selectionChanged(SelectionChangedEvent selectionChangedEvent) {
									ConferenceEditor.this.setSelection(selectionChangedEvent.getSelection());
								}
							}
						
							);
						}
						
					};
					page.setInitialMasterPartToolBarVisibility(true);
					page.setAdapterFactory(adapterFactory);
					page.setEditingDomain(editingDomain);
					for (ViewerFilter viewerFilter : filters) {
						page.addFilter(viewerFilter);
					}
					page.setInput(input);
					addPage(page);
				}
			}
			{
				Object input = null;
				if (getEditingDomain().getResourceSet() != null && getEditingDomain().getResourceSet().getResources().size() > 0) {
					Resource resource = getEditingDomain().getResourceSet().getResources().get(0);
					if (resource.getContents() != null && resource.getContents().size() > 0) {
						EObject element = resource.getContents().get(0);
						OCLQuery query = new OCLQuery(ConferencePackage.Literals.CONFERENCE, "self");
						if (EEFExtendedRuntime.INSTANCE.getProcessor().canEvaluate(query)) {
							QueryResult result = EEFExtendedRuntime.INSTANCE.getProcessor().evaluate(element, query);
							if (result.evaluationStatus.isOK()) {
								input = result.evaluationResult;
							}
						}
					}
				}
				
				List<ViewerFilter> filters = new ArrayList<ViewerFilter>(1);
				filters.add(new PropertiesEditionPartFilter("Talks and Topics"));
				{
					final EEFPropertiesViewerMDFormPage page = new EEFPropertiesViewerMDFormPage(ConferenceEditor.this, "talks topics", true, true);
					page.setAdapterFactory(adapterFactory);
					page.setEditingDomain(editingDomain);
					
					for (ViewerFilter viewerFilter : filters) {
						page.addFilter(viewerFilter);
					}
					page.setInput(input);
					addPage(page);
				}
			}
			{
				Object input = null;
				if (getEditingDomain().getResourceSet() != null && getEditingDomain().getResourceSet().getResources().size() > 0) {
					Resource resource = getEditingDomain().getResourceSet().getResources().get(0);
					if (resource.getContents() != null && resource.getContents().size() > 0) {
						EObject element = resource.getContents().get(0);
						OCLQuery query = new OCLQuery(ConferencePackage.Literals.CONFERENCE, "self");
						if (EEFExtendedRuntime.INSTANCE.getProcessor().canEvaluate(query)) {
							QueryResult result = EEFExtendedRuntime.INSTANCE.getProcessor().evaluate(element, query);
							if (result.evaluationStatus.isOK()) {
								input = result.evaluationResult;
							}
						}
					}
				}
				
				List<ViewerFilter> filters = new ArrayList<ViewerFilter>(1);
				filters.add(new PropertiesEditionPartFilter("Localisation"));
				{
					final EEFPropertiesViewerMDFormPage page = new EEFPropertiesViewerMDFormPage(ConferenceEditor.this, "localisation", true, true);
					page.setAdapterFactory(adapterFactory);
					page.setEditingDomain(editingDomain);
					
					for (ViewerFilter viewerFilter : filters) {
						page.addFilter(viewerFilter);
					}
					page.setInput(input);
					addPage(page);
				}
			}
			{
				Object input = getEditingDomain().getResourceSet();
				
				{
					final EEFTreeMDFormPage page = new EEFTreeMDFormPage(ConferenceEditor.this, "extended") {
					
						/**
						 * {@inheritDoc}
						 * @see org.eclipse.ui.forms.editor.FormPage#createPartControl(org.eclipse.swt.widgets.Composite)
						 */
						public void createPartControl(Composite parent) {
							super.createPartControl(parent);
							getModelViewer().addSelectionChangedListener(new ISelectionChangedListener() {
								// This just notifies those things that are affected by the section.
								//
								public void selectionChanged(SelectionChangedEvent selectionChangedEvent) {
									ConferenceEditor.this.setSelection(selectionChangedEvent.getSelection());
								}
							}
						
							);
						}
						
					};
					page.setInitialMasterPartToolBarVisibility(false);
					page.setAdapterFactory(adapterFactory);
					page.setEditingDomain(editingDomain);
					page.setInput(input);
					addPage(page);
				}
			}
		} catch (PartInitException e) {
			EEFExtendedRuntime.getPlugin().log(e);
		}
	}
	
	

}
	
