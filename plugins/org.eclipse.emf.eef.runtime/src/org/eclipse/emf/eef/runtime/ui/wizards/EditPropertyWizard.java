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
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.parts.ISWTPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesContextService;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionComponentService;
import org.eclipse.emf.eef.runtime.ui.utils.MessagesTool;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 * @deprecated Use {@link PropertiesEditionWizard} instead of this class
 */
public class EditPropertyWizard extends Wizard {

	private boolean initState;

	private WizardPage mainPage;

	protected EditingDomain editingDomain;

	protected EObject eObject;

	protected Command command;

	protected IPropertiesEditionComponent propertiesEditionComponent;

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
	public EditPropertyWizard(EditingDomain editingDomain, EObject eObject, ResourceSet allResources) {
		this.editingDomain = editingDomain;
		this.eObject = eObject;
		this.allResources = allResources;

		IPropertiesEditionProvider provider = PropertiesEditionComponentService.getInstance().getProvider(
				eObject);
		this.propertiesEditionComponent = provider.getPropertiesEditionComponent(eObject,
				IPropertiesEditionComponent.BATCH_MODE);
		PropertiesContextService.getInstance().push(eObject, propertiesEditionComponent);
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
		propertiesEditionComponent.addListener(listener);
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
		if (editingDomain != null) {
			CompoundCommand finishCommand = propertiesEditionComponent
					.getPropertiesEditionCommand(editingDomain);
			if (finishCommand.canExecute()) {
				this.command = finishCommand;
				PropertiesContextService.getInstance().pop();
				return true;
			}
			return false;
		} else {
			eObject = propertiesEditionComponent.getPropertiesEditionObject(eObject);
			PropertiesContextService.getInstance().pop();
			return true;
		}
	}

	@Override
	public void addPages() {
		mainPage = new EditPropertyWizardPage();
		addPage(mainPage);
		propertiesEditionComponent.addListener((EditPropertyWizardPage)mainPage);
	}

	private class EditPropertyWizardPage extends WizardPage implements IPropertiesEditionListener {

		protected EditPropertyWizardPage() {
			super("Main page"); //$NON-NLS-1$
			this.setTitle(eObject.eClass().getName());
			this.setDescription(MessagesTool.getString("EditPropertyWizard.description",
					new Object[] {eObject.eClass().getName()}));
		}

		public void createControl(Composite parent) {
			FillLayout parentLayout = new FillLayout();
			parent.setLayout(parentLayout);
			ScrolledComposite scrolledContainer = new ScrolledComposite(parent, SWT.H_SCROLL | SWT.V_SCROLL);
			Composite container = new Composite(scrolledContainer, SWT.BORDER);
			FillLayout containerLayout = new FillLayout();
			container.setLayout(containerLayout);
			CTabFolder folder = new CTabFolder(container, SWT.BORDER);
			initializeTabs(folder);
			setControl(scrolledContainer);
			scrolledContainer.setExpandHorizontal(true);
			scrolledContainer.setExpandVertical(true);
			scrolledContainer.setContent(container);
			scrolledContainer.setMinSize(folder.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		}

		private void initializeTabs(CTabFolder folder) {
			// first set initState to true to not handle changes yet
			initState = true;
			String[] partsList = propertiesEditionComponent.partsList();
			for (int i = 0; i < partsList.length; i++) {
				String nextComponentKey = partsList[i];
				Composite editComposite = null;
				IPropertiesEditionPart part;
				if (editingDomain != null)
					// FIXME: find a better way to define the SWT constant
					part = propertiesEditionComponent.getPropertiesEditionPart(0, nextComponentKey);
				else
					// FIXME: find a better way to define the SWT constant
					part = propertiesEditionComponent.getPropertiesEditionPart(0, nextComponentKey);
				if (part instanceof ISWTPropertiesEditionPart) {
					editComposite = ((ISWTPropertiesEditionPart)part).createFigure(folder);
					if (allResources == null)
						propertiesEditionComponent.initPart(propertiesEditionComponent
								.translatePart(nextComponentKey), 0, eObject);
					else
						propertiesEditionComponent.initPart(propertiesEditionComponent
								.translatePart(nextComponentKey), 0, eObject, allResources);

				}
				if (null == editComposite)
					editComposite = new Composite(folder, SWT.NONE);
				CTabItem tab = new CTabItem(folder, SWT.NONE);
				tab.setControl(editComposite);
				tab.setText(propertiesEditionComponent.getTabText(nextComponentKey));
			}
			initState = false;
		}

		public void firePropertiesChanged(IPropertiesEditionEvent event) {
			handleChange(event);
		}

		private void handleChange(IPropertiesEditionEvent event) {
			// do not handle changes if you are in initialization.
			if (initState)
				return;
			Diagnostic diag = propertiesEditionComponent.validateValue(event);
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

		@Override
		public void setVisible(boolean visible) {
			super.setVisible(visible);
			// TODO uncomment when eclipse bug#212446 fixed
			// Composite ep = getFirstEditionPart();
			// if (visible && ep != null) {
			// // set focus on first editable control
			// setFocus(ep.getChildren());
			// }
		}

		private Composite getFirstEditionPart() {
			Control[] controls = ((ScrolledComposite)getControl()).getChildren();
			if (controls.length > 0) {
				controls = ((Composite)controls[0]).getChildren();
				if (controls.length > 0 && controls[0] instanceof CTabFolder) {
					Control[] tabs = ((CTabFolder)controls[0]).getChildren();
					return (Composite)tabs[0];
				}
			}
			return null;
		}

		private boolean setFocus(Control[] controls) {
			for (int i = 0; i < controls.length; i++) {
				if (controls[i] instanceof Group) {
					if (setFocus(((Group)controls[i]).getChildren()))
						return true;
				}
				if (controls[i] instanceof Text) {
					Text txt = (Text)controls[i];
					if (txt.getEditable()) {
						txt.setFocus();
						return true;
					}
				}
			}
			return false;
		}
	}

}
