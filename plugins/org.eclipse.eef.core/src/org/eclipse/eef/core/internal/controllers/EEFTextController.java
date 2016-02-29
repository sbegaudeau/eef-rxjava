/*******************************************************************************
 * Copyright (c) 2015, 2016 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.eef.core.internal.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.eclipse.eef.EEFTextDescription;
import org.eclipse.eef.EEFWidgetDescription;
import org.eclipse.eef.EefPackage;
import org.eclipse.eef.core.api.EEFExpressionUtils;
import org.eclipse.eef.core.api.controllers.IConsumer;
import org.eclipse.eef.core.api.controllers.IEEFTextController;
import org.eclipse.eef.core.api.controllers.IEEFTextState;
import org.eclipse.eef.core.api.utils.Eval;
import org.eclipse.eef.core.api.utils.ISuccessfulResultConsumer;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.common.interpreter.api.IInterpreter;
import org.eclipse.sirius.common.interpreter.api.IVariableManager;

import rx.Observable;
import rx.functions.Func3;

/**
 * This class will be used in order to manage the behavior of the text.
 *
 * @author sbegaudeau
 */
public class EEFTextController extends AbstractEEFWidgetController implements IEEFTextController {
	/**
	 * The description.
	 */
	private EEFTextDescription description;

	/**
	 * The editing domain.
	 */
	private TransactionalEditingDomain editingDomain;

	/**
	 * The consumer of a new value of the text.
	 */
	private IConsumer<String> newValueConsumer;

	/**
	 * Executor service used to run the update of the text field.
	 */
	private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

	/**
	 * This future contains the update to be performed.
	 */
	private ScheduledFuture<?> currentUpdatedValueFuture;

	/**
	 * The constructor.
	 *
	 * @param description
	 *            The description
	 * @param variableManager
	 *            The variable manager
	 * @param interpreter
	 *            The interpreter
	 * @param editingDomain
	 *            The editing domain
	 */
	public EEFTextController(EEFTextDescription description, IVariableManager variableManager, IInterpreter interpreter,
			TransactionalEditingDomain editingDomain) {
		super(variableManager, interpreter);
		this.description = description;
		this.editingDomain = editingDomain;
	}

	@Override
	public void updateValue(final String text) {
		if (this.currentUpdatedValueFuture != null && !this.currentUpdatedValueFuture.isDone()) {
			this.currentUpdatedValueFuture.cancel(true);
		}

		final Command command = new RecordingCommand(this.editingDomain) {
			@Override
			protected void doExecute() {
				String editExpression = EEFTextController.this.description.getEditExpression();
				EAttribute eAttribute = EefPackage.Literals.EEF_TEXT_DESCRIPTION__EDIT_EXPRESSION;

				Map<String, Object> variables = new HashMap<String, Object>();
				variables.putAll(EEFTextController.this.variableManager.getVariables());
				variables.put(EEFExpressionUtils.EEFText.NEW_VALUE, text);

				new Eval(EEFTextController.this.interpreter, variables).call(eAttribute, editExpression);
			}

			@Override
			public boolean canExecute() {
				return true;
			}
		};

		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				CommandStack commandStack = EEFTextController.this.editingDomain.getCommandStack();
				commandStack.execute(command);
			}
		};
		final long scheduleTime = 500L;
		this.currentUpdatedValueFuture = this.executor.schedule(runnable, scheduleTime, TimeUnit.MILLISECONDS);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.eef.core.internal.controllers.AbstractEEFWidgetController#refresh()
	 */
	@Override
	public void refresh() {
		super.refresh();

		String valueExpression = this.description.getValueExpression();
		EAttribute eAttribute = EefPackage.Literals.EEF_TEXT_DESCRIPTION__VALUE_EXPRESSION;

		this.newEval().call(eAttribute, valueExpression, String.class, new ISuccessfulResultConsumer<String>() {
			@Override
			public void apply(String value) {
				EEFTextController.this.newValueConsumer.apply(value);
			}
		});
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.eef.core.api.controllers.IEEFTextController#onNewValue(org.eclipse.eef.core.api.controllers.IConsumer)
	 */
	@Override
	public void onNewValue(IConsumer<String> consumer) {
		this.newValueConsumer = consumer;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.eef.core.api.controllers.IEEFTextController#removeNewValueConsumer()
	 */
	@Override
	public void removeNewValueConsumer() {
		this.newValueConsumer = null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.eef.core.internal.controllers.AbstractEEFWidgetController#getDescription()
	 */
	@Override
	protected EEFWidgetDescription getDescription() {
		return this.description;
	}

	// CHECKSTYLE:OFF

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.eef.core.api.controllers.IEEFTextController#getState()
	 */
	@Override
	public Observable<IEEFTextState> getState() {
		return Observable.zip(text(), label(), help(), createTextState());
	}

	private Observable<String> text() {
		EAttribute eAttribute = EefPackage.Literals.EEF_TEXT_DESCRIPTION__VALUE_EXPRESSION;
		return this.newEval2().get(eAttribute, this.description.getValueExpression(), String.class);
	}

	private Func3<String, String, String, IEEFTextState> createTextState() {
		return new Func3<String, String, String, IEEFTextState>() {
			@Override
			public IEEFTextState call(String text, String label, String help) {
				return new EEFTextState(text, label, help);
			}
		};
	}
}
