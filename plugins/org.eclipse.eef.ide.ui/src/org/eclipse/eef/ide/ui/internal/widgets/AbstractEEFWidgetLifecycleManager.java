/*******************************************************************************
 * Copyright (c) 2016 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.eef.ide.ui.internal.widgets;

import java.util.List;

import org.eclipse.eef.EEFWidgetDescription;
import org.eclipse.eef.common.api.utils.Util;
import org.eclipse.eef.core.api.controllers.IConsumer;
import org.eclipse.eef.core.api.controllers.IEEFWidgetController;
import org.eclipse.eef.core.api.controllers.IValidationMessage;
import org.eclipse.eef.ide.ui.internal.EEFIdeUiPlugin;
import org.eclipse.eef.ide.ui.internal.Icons;
import org.eclipse.eef.properties.ui.api.EEFTabbedPropertySheetPage;
import org.eclipse.eef.properties.ui.api.EEFTabbedPropertySheetWidgetFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.common.interpreter.api.IInterpreter;
import org.eclipse.sirius.common.interpreter.api.IVariableManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.IMessageManager;

/**
 * Parent of all the lifecycle managers.
 *
 * @author sbegaudeau
 */
public abstract class AbstractEEFWidgetLifecycleManager implements ILifecycleManager {

	/**
	 * Horizontal space to leave between related widgets. Each section should use these values for spacing its widgets.
	 * For example, you can use +/- HSPACE as the offset of a left or right FlatFormAttachment.
	 *
	 * The tabbed property composite also inserts VSPACE pixels between section composites if more than one section is
	 * displayed.
	 */
	public static final int HSPACE = 5;

	/**
	 * The label width that will be used for section names.
	 **/
	public static final int LABEL_WIDTH = 232;

	/**
	 * The gap between the label and the widget with the help icon.
	 */
	public static final int GAP_WITH_HELP = 25;

	/**
	 * The gap between the label and the widget without the help icon.
	 */
	public static final int GAP_WITHOUT_HELP = 20;

	/**
	 * The variable manager.
	 */
	protected IVariableManager variableManager;

	/**
	 * The interpreter.
	 */
	protected IInterpreter interpreter;

	/**
	 * The editing domain.
	 */
	protected TransactionalEditingDomain editingDomain;

	/**
	 * The label.
	 */
	protected CLabel label;

	/**
	 * The help label.
	 */
	protected CLabel help;

	/**
	 * The tabbed property sheet page.
	 */
	private EEFTabbedPropertySheetPage page;

	/**
	 * The constructor.
	 *
	 * @param variableManager
	 *            The variable manager
	 * @param interpreter
	 *            The interpreter
	 * @param editingDomain
	 *            The editing domain
	 */
	public AbstractEEFWidgetLifecycleManager(IVariableManager variableManager, IInterpreter interpreter, TransactionalEditingDomain editingDomain) {
		this.variableManager = variableManager;
		this.interpreter = interpreter;
		this.editingDomain = editingDomain;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.eef.ide.ui.internal.widgets.ILifecycleManager#createControl(org.eclipse.swt.widgets.Composite,
	 *      org.eclipse.eef.properties.ui.api.EEFTabbedPropertySheetPage)
	 */
	@Override
	public void createControl(Composite parent, EEFTabbedPropertySheetPage tabbedPropertySheetPage) {
		this.page = tabbedPropertySheetPage;
		EEFTabbedPropertySheetWidgetFactory widgetFactory = tabbedPropertySheetPage.getWidgetFactory();

		Composite composite = widgetFactory.createFlatFormComposite(parent);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		composite.setLayoutData(gridData);

		this.createMainControl(composite, tabbedPropertySheetPage);

		Control control = this.getValidationControl();

		boolean hasHelp = !Util.isBlank(this.getWidgetDescription().getHelpExpression());

		int gap = GAP_WITHOUT_HELP;
		if (hasHelp) {
			gap = GAP_WITH_HELP;
		}

		this.label = widgetFactory.createCLabel(composite, ""); //$NON-NLS-1$
		FormData labelFormData = new FormData();
		labelFormData.left = new FormAttachment(0, 0);
		labelFormData.right = new FormAttachment(control, -HSPACE - gap);
		labelFormData.top = new FormAttachment(control, 0, SWT.TOP);
		this.label.setLayoutData(labelFormData);

		if (hasHelp) {
			this.help = widgetFactory.createCLabel(composite, ""); //$NON-NLS-1$
			FormData helpFormData = new FormData();
			helpFormData.top = new FormAttachment(control, 0, SWT.TOP);
			helpFormData.left = new FormAttachment(this.label);
			this.help.setLayoutData(helpFormData);
			this.help.setImage(EEFIdeUiPlugin.getPlugin().getImageRegistry().get(Icons.HELP));
			this.help.setToolTipText(""); //$NON-NLS-1$
		}
	}

	/**
	 * Returns the description of the widget.
	 *
	 * @return The description of the widget
	 */
	protected abstract EEFWidgetDescription getWidgetDescription();

	/**
	 * Create the main control.
	 *
	 * @param parent
	 *            The composite parent
	 * @param tabbedPropertySheetPage
	 *            The tabbed property sheet page
	 */
	protected abstract void createMainControl(Composite parent, EEFTabbedPropertySheetPage tabbedPropertySheetPage);

	/**
	 * Returns the controller.
	 *
	 * @return The controller
	 */
	protected abstract IEEFWidgetController getController();

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.eef.ide.ui.internal.widgets.ILifecycleManager#aboutToBeShown()
	 */
	@Override
	public void aboutToBeShown() {
		this.getController().onNewLabel(new IConsumer<String>() {
			@Override
			public void apply(String value) {
				if (!label.isDisposed() && !(label.getText() != null && label.getText().equals(value))) {
					label.setText(value);
				}
			}
		});

		this.getController().onNewHelp(new IConsumer<String>() {
			@Override
			public void apply(String value) {
				if (help != null && !help.isDisposed() && !(help.getText() != null && help.getText().equals(value))) {
					help.setToolTipText(value);
				}
			}
		});

		this.getController().onValidation(new IConsumer<List<IValidationMessage>>() {
			@Override
			public void apply(List<IValidationMessage> messages) {
				IMessageManager messageManager = page.getForm().getMessageManager();
				messageManager.removeMessages(getValidationControl());

				for (IValidationMessage message : messages) {
					messageManager.addMessage(message.getKey(), message.getMessage(), message.getData(), message.getType(), getValidationControl());
				}
			}
		});
	}

	/**
	 * Returns the control on which the validation marker will appear.
	 *
	 * @return The control used to display the validation marker
	 */
	protected abstract Control getValidationControl();

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.eef.ide.ui.internal.widgets.ILifecycleManager#refresh()
	 */
	@Override
	public void refresh() {
		this.getController().refresh();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.eef.ide.ui.internal.widgets.ILifecycleManager#aboutToBeHidden()
	 */
	@Override
	public void aboutToBeHidden() {
		this.getController().removeNewLabelConsumer();
		this.getController().removeValidationConsumer();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.eef.ide.ui.internal.widgets.ILifecycleManager#dispose()
	 */
	@Override
	public void dispose() {
		// do nothing
	}
}
