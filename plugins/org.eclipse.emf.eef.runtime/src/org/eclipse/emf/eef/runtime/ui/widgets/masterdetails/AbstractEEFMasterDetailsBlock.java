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
package org.eclipse.emf.eef.runtime.ui.widgets.masterdetails;

import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.action.ValidateAction;
import org.eclipse.emf.eef.runtime.EMFPropertiesRuntime;
import org.eclipse.emf.eef.runtime.ui.editors.pages.EEFDetailsPage;
import org.eclipse.emf.eef.runtime.ui.layout.EEFFormLayoutFactory;
import org.eclipse.emf.eef.runtime.ui.utils.MessagesTool;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.DetailsPart;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IDetailsPageProvider;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.MasterDetailsBlock;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public abstract class AbstractEEFMasterDetailsBlock extends MasterDetailsBlock {

	protected FormToolkit toolkit;
	protected AbstractEEFMasterPart masterPart;
	protected EditingDomain editingDomain;
	protected AdapterFactory adapterFactory;
	
	protected ValidateAction valAction;
	
	/**
	 * @param page the page where MasterDetailsBlock is used
	 * @param editingDomain the editingDomain where to perform model edition
	 * @param adapterFactory the adapterFactory to use with the model
	 */
	public AbstractEEFMasterDetailsBlock(EditingDomain editingDomain, AdapterFactory adapterFactory) {
		super();
		this.editingDomain = editingDomain;
		this.adapterFactory = adapterFactory;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.ui.forms.MasterDetailsBlock#createMasterPart(org.eclipse.ui.forms.IManagedForm, org.eclipse.swt.widgets.Composite)
	 */
	protected final void createMasterPart(IManagedForm managedForm, Composite parent) {
		this.toolkit = managedForm.getToolkit();
		Composite masterContainer = managedForm.getToolkit().createComposite(parent);
		masterContainer.setLayout(EEFFormLayoutFactory.createMasterGridLayout(false, 1));
		masterContainer.setLayoutData(new GridData(GridData.FILL_BOTH));
		masterPart = createEEFMasterPart(masterContainer);
		managedForm.addPart(masterPart);
		Section section = masterPart.getSection();
		section.setLayout(EEFFormLayoutFactory.createClearGridLayout(false, 1));
		section.setLayoutData(new GridData(GridData.FILL_BOTH));
		masterPart.addSelectionChangeListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = event.getSelection();
				if (selection instanceof IStructuredSelection)
					valAction.updateSelection((IStructuredSelection) selection);
			}
			
		});
	}

	/**
	 * Create contents of the Master part
	 * @param masterContainer the container of this contents
	 * @return an EEFMasterPart defining the contents of the MasterPart 
	 */
	protected abstract AbstractEEFMasterPart createEEFMasterPart(Composite masterContainer);

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.ui.forms.MasterDetailsBlock#createToolBarActions(org.eclipse.ui.forms.IManagedForm)
	 */
	protected void createToolBarActions(IManagedForm managedForm) {
		final ScrolledForm form = managedForm.getForm();

		valAction = new ValidateAction();
		valAction.setToolTipText("Validate the current selection");
		valAction.setImageDescriptor(EMFPropertiesRuntime.getImageDescriptor(EMFPropertiesRuntime.ICONS_16x16 + "validate.gif"));
		
		Action haction = new Action("hor", IAction.AS_RADIO_BUTTON) { //$NON-NLS-1$
			public void run() {
				sashForm.setOrientation(SWT.HORIZONTAL);
				form.reflow(true);
			}
		};
		haction.setChecked(true);
		haction.setToolTipText(
					MessagesTool.getString("AbstractEEFMasterDetailsBlock.horizontal_layout")
					); //$NON-NLS-1$
		haction.setImageDescriptor(EMFPropertiesRuntime.getImageDescriptor(EMFPropertiesRuntime.ICONS_16x16 + "th_horizontal.gif"));
		haction.setDisabledImageDescriptor(EMFPropertiesRuntime.getImageDescriptor(EMFPropertiesRuntime.ICONS_16x16 + "disabled/th_horizontal.gif"));

		Action vaction = new Action("ver", IAction.AS_RADIO_BUTTON) { //$NON-NLS-1$
			public void run() {
				sashForm.setOrientation(SWT.VERTICAL);
				form.reflow(true);
			}
		};
		vaction.setChecked(false);
		vaction.setToolTipText(MessagesTool.getString("AbstractEEFMasterDetailsBlock.vertical_layout")); //$NON-NLS-1$
		vaction.setImageDescriptor(EMFPropertiesRuntime.getImageDescriptor(EMFPropertiesRuntime.ICONS_16x16 + "th_vertical.gif"));
		vaction.setDisabledImageDescriptor(EMFPropertiesRuntime.getImageDescriptor(EMFPropertiesRuntime.ICONS_16x16 + "disabled/th_vertical.gif"));
		form.getToolBarManager().add(valAction);
		form.getToolBarManager().add(haction);
		form.getToolBarManager().add(vaction);
		if (additionalPageActions() != null) {
			for (Action additionalAction : additionalPageActions()) {
				form.getToolBarManager().add(additionalAction);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.ui.forms.MasterDetailsBlock#registerPages(org.eclipse.ui.forms.DetailsPart)
	 */
	protected void registerPages(DetailsPart detailsPart) {
		detailsPart.setPageProvider(new IDetailsPageProvider() {
			public Object getPageKey(Object object) {
				if (object instanceof EObject)
					return EObject.class;
				return object.getClass();
			}

			public IDetailsPage getPage(Object key) {
				if (key.equals(EObject.class))
					return new EEFDetailsPage(toolkit, editingDomain, adapterFactory);
				return null;
			}
		});
	}

	/**
	 * @return the master part of the block
	 */
	public AbstractEEFMasterPart getMasterPart() {
		return masterPart;
	}
	
	/**
	 * @param input the input of the model viewer
	 */
	public void setInput(Object input) {
		masterPart.setInput(input);
	}

	/**
	 * @param filter add a filter to the model viewer
	 */
	public void addFilter(ViewerFilter filter) {
		masterPart.addFilter(filter);
	}
	
	/**
	 * @return the list of actions to add to the form toolbar
	 */
	protected List<Action> additionalPageActions() {
		// nothing to add
		return null;
	}

}
