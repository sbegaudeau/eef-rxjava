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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.runtime.EMFPropertiesRuntime;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionComponentService;
import org.eclipse.emf.eef.runtime.ui.utils.MessagesTool;
import org.eclipse.emf.eef.runtime.ui.viewers.PropertiesEditionContentProvider;
import org.eclipse.emf.eef.runtime.ui.viewers.PropertiesEditionViewer;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class PropertiesEditionWizard extends Wizard {

	private EditPropertyWizardPage mainPage;

	protected EditingDomain editingDomain;
	
	protected EObject eObject;

	protected Command command;
	
	protected ResourceSet allResources;

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
						finishCommand.append(((EditPropertyWizardPage)getPages()[i]).viewer.getPropertiesEditionCommand(editingDomain));
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
						//FIXME: Warning, architecture must be redefined to do an iterative eobject build
						// Finally ... it could work ...
						eObject = ((EditPropertyWizardPage)getPages()[i]).viewer.getPropertiesEditionObject(eObject);
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
	 * @see org.eclipse.jface.wizard.Wizard#createPageControls(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPageControls(Composite pageContainer) {
		super.createPageControls(pageContainer);
		mainPage.setInput(eObject);
	}

	@Override
	public void addPages() {
		mainPage = new EditPropertyWizardPage();
		addPage(mainPage);
	}

	private class EditPropertyWizardPage extends WizardPage implements IPropertiesEditionListener {

		private PropertiesEditionViewer viewer;
		
		protected EditPropertyWizardPage() {
			super("Main page"); //$NON-NLS-1$
			this.setTitle(eObject.eClass().getName());
			this.setDescription(MessagesTool.getString("EditPropertyWizard.description", new Object[] {eObject.eClass().getName()}));
		}

		public void createControl(Composite parent) {
			 viewer = new PropertiesEditionViewer(parent, PropertiesEditionWizard.this.allResources, 0);
			 viewer.setDynamicTabHeader(true);
			 setControl(viewer.getControl());
		}
		
		public void setInput(EObject eObject) {
			try {
				viewer.setContentProvider(new PropertiesEditionContentProvider(PropertiesEditionComponentService.getInstance().getProvider((EObject)eObject), IPropertiesEditionComponent.BATCH_MODE));
				viewer.setInput(eObject);
				viewer.addPropertiesListener(this);
			} catch (InstantiationException e) {
				EMFPropertiesRuntime.getDefault().logError("Trying to use PropertiesEditionWizard in LIVE_MODE.", e);
			}
		}

		public void firePropertiesChanged(PropertiesEditionEvent event) {
			handleChange(event);
		}

		private void handleChange(PropertiesEditionEvent event) {
			// do not handle changes if you are in initialization.
			if (viewer.isInitializing())
				return;
			
			Diagnostic diag = viewer.validateValue(event);
			if (diag != null && diag.getSeverity() != Diagnostic.OK)
				updateStatus(diag.getMessage());
			else
				updateStatus(null);
		}

		private void updateStatus(final String message) {
			setMessage(null);
			setErrorMessage(message);
			setPageComplete(message == null);
		}

	}

}
