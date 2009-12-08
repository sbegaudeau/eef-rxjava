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
package org.eclipse.emf.eef.runtime.ui.wizards;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.providers.RegistryPropertiesEditionProvider;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.ui.utils.MessagesTool;
import org.eclipse.emf.eef.runtime.ui.viewers.PropertiesEditionContentProvider;
import org.eclipse.emf.eef.runtime.ui.viewers.PropertiesEditionViewer;
import org.eclipse.emf.eef.runtime.util.EEFUtil;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class PropertiesEditionWizard extends Wizard {

	private EditPropertyWizardPage mainPage;

	private ElementCreationWizardPage elementCreationPage;

	protected EditingDomain editingDomain;

	protected EObject eObject;

	protected EReference eReference;

	protected Command command;

	protected ResourceSet allResources;

	private Diagnostic oldFailedDiagnostic = null;

	private Object oldFailedEvent = null;

	/**
	 * Default constructor - define the eObject to edit.
	 * 
	 * @param editingDomain
	 *            (optional) defines the editingDomain where to perform commands.
	 * @param eObject
	 *            the eObject to edit.
	 * @param allResources
	 *            the resourceSet where the EObject is located.
	 */
	public PropertiesEditionWizard(EditingDomain editingDomain, EObject eObject, ResourceSet allResources) {
		this.editingDomain = editingDomain;
		this.eObject = eObject;
		this.allResources = allResources;
		this.setWindowTitle(eObject.eClass().getName());
	}

	/**
	 * Default constructor - define the eObject to edit.
	 * 
	 * @param editingDomain
	 *            (optional) defines the editingDomain where to perform commands.
	 * @param eReference
	 *            the reference where create the EObject.
	 * @param allResources
	 *            the resourceSet where the EObject is located.
	 */
	public PropertiesEditionWizard(EditingDomain editingDomain, EReference eReference,
			ResourceSet allResources) {
		this.editingDomain = editingDomain;
		this.eReference = eReference;
		this.allResources = allResources;
		this.setWindowTitle(eReference.getName());
	}

	/**
	 * @return the editingDomain where to perform commands.
	 */
	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	/**
	 * @return the updated EObject.
	 */
	public EObject getEObject() {
		return eObject;
	}

	/**
	 * @return the command to update the EObject.
	 */
	public Command getCommand() {
		return command;
	}

	/**
	 * @param listener
	 */
	public void addListener(IPropertiesEditionListener listener) {
		for (int i = 0; i < getPages().length; i++) {
			if (getPages()[i] instanceof EditPropertyWizardPage) {
				((EditPropertyWizardPage)getPages()[i]).viewer.addPropertiesListener(listener);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performCancel()
	 */
	@Override
	public boolean performCancel() {
		PropertiesContextService.getInstance().pop();
		return super.performCancel();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		try {
			if (editingDomain != null) {
				CompoundCommand finishCommand = new CompoundCommand();
				for (int i = 0; i < getPages().length; i++) {
					if (getPages()[i] instanceof EditPropertyWizardPage) {
						finishCommand.append(((EditPropertyWizardPage)getPages()[i]).viewer
								.getPropertiesEditionCommand(editingDomain));
					}
				}
				if (finishCommand.canExecute()) {
					this.command = finishCommand;
					PropertiesContextService.getInstance().pop();
					return true;
				}
				return false;
			} else {
				for (int i = 0; i < getPages().length; i++) {
					if (getPages()[i] instanceof EditPropertyWizardPage) {
						// FIXME: Warning, architecture must be redefined to do
						// an iterative eobject build
						// Finally ... it could work ...
						eObject = ((EditPropertyWizardPage)getPages()[i]).viewer
								.getPropertiesEditionObject(eObject);
					}
				}
				PropertiesContextService.getInstance().pop();
				return true;
			}
		} finally {
			for (int i = 0; i < getPages().length; i++) {
				if (getPages()[i] instanceof EditPropertyWizardPage) {
					PropertiesEditionViewer viewer = ((EditPropertyWizardPage)getPages()[i]).viewer;
					if (viewer != null)
						viewer.getContentProvider().dispose();
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#createPageControls(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPageControls(Composite pageContainer) {
		super.createPageControls(pageContainer);
		mainPage.setInput(eObject);
	}

	@Override
	public void addPages() {
		if (inReferenceMode()) {
			elementCreationPage = new ElementCreationWizardPage();
			addPage(elementCreationPage);
		}
		mainPage = new EditPropertyWizardPage();
		addPage(mainPage);
		super.addPages();
	}

	/**
	 * @return
	 */
	private boolean inReferenceMode() {
		return eReference != null && eReference.isContainment() && eObject == null;
	}

	private class ElementCreationWizardPage extends WizardPage {

		private List<Button> buttons = new ArrayList<Button>();

		protected ElementCreationWizardPage() {
			super("Element creation page page"); //$NON-NLS-1$
			this.setTitle("Element type"); //$NON-NLS-1$
			this.setDescription("Choose the type of element to create");//$NON-NLS-1$
		}

		public void createControl(Composite parent) {
			Composite control = new Composite(parent, SWT.NONE);
			GridData gd = new GridData(GridData.FILL_BOTH);
			control.setLayoutData(gd);
			GridLayout layout = new GridLayout();
			control.setLayout(layout);
			List<EClass> instanciableTypesInHierarchy = EEFUtil.instanciableTypesInHierarchy(eReference
					.getEType());
			for (final EClass eClass : instanciableTypesInHierarchy) {
				Button button = new Button(control, SWT.RADIO);
				button.setText(eClass.getName());
				button.addSelectionListener(new SelectionAdapter() {

					public void widgetSelected(SelectionEvent e) {
						eObject = EcoreUtil.create(eClass);
						mainPage.setInput(eObject);
					}
				});
				buttons.add(button);
			}
			buttons.get(0).setSelection(true);
			eObject = EcoreUtil.create(instanciableTypesInHierarchy.get(0));
			setControl(control);
		}

	}

	private class EditPropertyWizardPage extends WizardPage implements IPropertiesEditionListener {

		private PropertiesEditionViewer viewer;

		protected EditPropertyWizardPage() {
			super("Main page"); //$NON-NLS-1$
		}

		public void createControl(Composite parent) {
			try {
				Composite control = new Composite(parent, SWT.NONE);
				GridData gd = new GridData(GridData.FILL_BOTH);
				control.setLayoutData(gd);
				viewer = new PropertiesEditionViewer(control, PropertiesEditionWizard.this.allResources, 0);
				viewer.setDynamicTabHeader(true);
				viewer.setContentProvider(new PropertiesEditionContentProvider(
						new RegistryPropertiesEditionProvider(), IPropertiesEditionComponent.BATCH_MODE));
				viewer.addPropertiesListener(this);
				setControl(viewer.getControl());
			} catch (InstantiationException e) {
				EEFRuntimePlugin.getDefault().logError("Trying to use PropertiesEditionWizard in LIVE_MODE.",
						e);
			}
		}

		public void setInput(EObject eObject) {
			this.setTitle(eObject.eClass().getName());
			this.setDescription(MessagesTool.getString("EditPropertyWizard.description",
					new Object[] {eObject.eClass().getName()}));
			viewer.setInput(eObject);
		}

		public void firePropertiesChanged(PropertiesEditionEvent event) {
			handleChange(event);
		}

		private void handleChange(PropertiesEditionEvent event) {
			// do not handle changes if you are in initialization.
			if (viewer.isInitializing())
				return;
			Diagnostic diag = viewer.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK) {
				updateStatus(computeMessage(diag));
				oldFailedDiagnostic = diag;
				oldFailedEvent = event.getAffectedEditor();
			} else {
				if (oldFailedDiagnostic != null) {
					if (oldFailedEvent != null
							&& oldFailedEvent.equals(event.getAffectedEditor())) {
						updateStatus(null);
						oldFailedDiagnostic = null;
						oldFailedEvent = null;
					} else {
						updateStatus(computeMessage(oldFailedDiagnostic));
					}

				} else
				updateStatus(null);
		}
		}

		private String computeMessage(Diagnostic diag) {
			for (Diagnostic child : diag.getChildren()) {
				if (child.getSeverity() != Diagnostic.OK) {
					if (child.getChildren().isEmpty()) {
						return child.getMessage();
					} else {
						return computeMessage(child);
					}
				}
			}
			return diag.getMessage();
		}

		private void updateStatus(final String message) {
			setMessage(null);
			setErrorMessage(message);
			setPageComplete(message == null);
		}

	}

}
