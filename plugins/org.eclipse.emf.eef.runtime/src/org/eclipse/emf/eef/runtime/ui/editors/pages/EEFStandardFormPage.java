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
package org.eclipse.emf.eef.runtime.ui.editors.pages;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionComponentService;
import org.eclipse.emf.eef.runtime.ui.layout.EEFFormLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IFormColors;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class EEFStandardFormPage extends FormPage {

	/**
	 * The page ID
	 */
	public static final String PAGE_ID = "EEF-std-form-page"; //$NON-NLS-1$

	// /**
	// * The form editor in which this page will be included
	// */
	// private FormEditor editor;
	//	
	/**
	 * This keeps track of the editing domain that is used to track all changes to the model.
	 */
	protected AdapterFactoryEditingDomain editingDomain;

	/**
	 * This is the one adapter factory used for providing views of the model.
	 */
	protected ComposedAdapterFactory adapterFactory;

	/**
	 * The edited eObject
	 */
	protected EObject eObject;

	/**
	 * The associated controler
	 */
	protected IPropertiesEditionComponent propertiesEditionComponent;

	/**
	 * The resource set where to edit the eObject
	 */
	protected ResourceSet allResources;

	/**
	 * The form containing this page
	 */
	private ScrolledForm form;

	/**
	 * The form toolkit to use
	 */
	private FormToolkit toolkit;

	/**
	 * The folder for the tab
	 */
	private CTabFolder folder;

	/**
	 * @param editor
	 *            the form editor in which this page will be included
	 */
	public EEFStandardFormPage(FormEditor editor, String pageTitle,
			AdapterFactoryEditingDomain editingDomain, ComposedAdapterFactory adapterFactory) {
		super(editor, PAGE_ID, pageTitle); //$NON-NLS-1$
		// this.editor = editor;
		this.editingDomain = editingDomain;
		this.adapterFactory = adapterFactory;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.forms.editor.FormPage#createFormContent(org.eclipse.ui.forms.IManagedForm)
	 */
	protected void createFormContent(IManagedForm managedForm) {
		super.createFormContent(managedForm);
		form = managedForm.getForm();
		toolkit = managedForm.getToolkit();
		toolkit.decorateFormHeading(form.getForm());
		form.setLayout(EEFFormLayoutFactory.createDetailsGridLayout(false, 1));
		form.setLayoutData(new GridData(GridData.FILL_BOTH));

	}

	/**
	 * Defines the title of the page
	 * 
	 * @param title
	 *            the title to define
	 */
	public void setPageTitle(String title) {
		if (title != null && form != null)
			form.setText(title);
	}

	/**
	 * @param input
	 *            the input of the page
	 */
	public void setInput(EObject newEObject) {
		// setPageTitle(resource.getURI().toString());
		// form.setImage((new AdapterFactoryLabelProvider(adapterFactory)).getImage(resource));
		eObject = newEObject;
		if (eObject != null) {
			IPropertiesEditionProvider provider = PropertiesEditionComponentService.getInstance()
					.getProvider(eObject);
			if (provider != null) {
				if (this.propertiesEditionComponent != null)
					this.propertiesEditionComponent.dispose();
				this.propertiesEditionComponent = provider.getPropertiesEditionComponent(eObject,
						IPropertiesEditionComponent.LIVE_MODE);
				if (this.propertiesEditionComponent != null) {
					this.propertiesEditionComponent.setLiveEditingDomain(editingDomain);
					if (this.propertiesEditionComponent.partsList().length > 1)
						initializeTabs(folder);
					else if (this.propertiesEditionComponent.partsList().length == 1)
						initializeContents();
				}
			}
		}
	}

	private void initializeContents() {
		Composite container = toolkit.createComposite(form, SWT.FLAT);
		FillLayout containerLayout = new FillLayout();
		container.setLayout(containerLayout);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		String[] partsList = propertiesEditionComponent.partsList();
		String nextComponentKey = partsList[0];
		Composite editComposite = null;
		IPropertiesEditionPart part;
		if (editingDomain != null)
			part = propertiesEditionComponent.getPropertiesEditionPart(1, nextComponentKey);
		else
			part = propertiesEditionComponent.getPropertiesEditionPart(1, nextComponentKey);
		if (part instanceof IFormPropertiesEditionPart) {
			editComposite = ((IFormPropertiesEditionPart)part).createFigure(toolkit
					.createScrolledForm(folder), toolkit);
			if (allResources == null)
				propertiesEditionComponent.initPart(propertiesEditionComponent
						.translatePart(nextComponentKey), 1, eObject);
			else
				propertiesEditionComponent.initPart(propertiesEditionComponent
						.translatePart(nextComponentKey), 1, eObject, allResources);

		}
		if (null == editComposite)
			editComposite = new Composite(folder, SWT.NONE);
	}

	private void initializeTabs(CTabFolder folder) {
		Composite container = toolkit.createComposite(form, SWT.FLAT);
		FillLayout containerLayout = new FillLayout();
		container.setLayout(containerLayout);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		folder = new CTabFolder(container, SWT.FLAT | SWT.TOP);
		toolkit.adapt(folder, true, true);
		toolkit.getColors().initializeSectionToolBarColors();
		Color selectedColor = toolkit.getColors().getColor(IFormColors.TB_BG);
		folder.setSelectionBackground(new Color[] {selectedColor, toolkit.getColors().getBackground()},
				new int[] {100}, true);
		if (folder.getItemCount() > 0) {
			int itemCount = folder.getItemCount();
			for (int i = 0; i < itemCount; i++) {
				CTabItem item = folder.getItems()[0];
				item.dispose();
			}
		}

		// first set initState to true to not handle changes yet
		String[] partsList = propertiesEditionComponent.partsList();
		for (int i = 0; i < partsList.length; i++) {
			String nextComponentKey = partsList[i];
			Composite editComposite = null;
			IPropertiesEditionPart part;
			if (editingDomain != null)
				part = propertiesEditionComponent.getPropertiesEditionPart(1, nextComponentKey);
			else
				part = propertiesEditionComponent.getPropertiesEditionPart(1, nextComponentKey);
			if (part instanceof IFormPropertiesEditionPart) {
				editComposite = ((IFormPropertiesEditionPart)part).createFigure(toolkit
						.createScrolledForm(folder), toolkit);
				if (allResources == null)
					propertiesEditionComponent.initPart(propertiesEditionComponent
							.translatePart(nextComponentKey), 1, eObject);
				else
					propertiesEditionComponent.initPart(propertiesEditionComponent
							.translatePart(nextComponentKey), 1, eObject, allResources);

			}
			if (null == editComposite)
				editComposite = new Composite(folder, SWT.NONE);
			CTabItem tab = new CTabItem(folder, SWT.NULL);
			tab.setControl(editComposite);
			tab.setText(nextComponentKey);
		}
		if (folder.getItemCount() > 0)
			folder.setSelection(folder.getItem(0));
	}

}
