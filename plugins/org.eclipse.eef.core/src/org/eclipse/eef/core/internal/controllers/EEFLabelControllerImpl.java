/*******************************************************************************
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.eef.core.internal.controllers;

import org.eclipse.eef.EEFLabelDescription;
import org.eclipse.eef.core.api.controllers.EEFLabelController;
import org.eclipse.eef.core.api.controllers.IConsumer;
import org.eclipse.sirius.common.interpreter.api.IEvaluationResult;
import org.eclipse.sirius.common.interpreter.api.IInterpreter;
import org.eclipse.sirius.common.interpreter.api.IVariableManager;

/**
 * This class will be used in order to manage the behavior of the label.
 *
 * @author mbats
 */
public class EEFLabelControllerImpl implements EEFLabelController {
	/**
	 * The description.
	 */
	private EEFLabelDescription description;

	/**
	 * The variable manager.
	 */
	private IVariableManager variableManager;

	/**
	 * The interpreter.
	 */
	private IInterpreter interpreter;

	/**
	 * The consumer of a new value of the label.
	 */
	private IConsumer<String> newLabelConsumer;

	/**
	 * The constructor.
	 *
	 * @param description
	 *            The description
	 * @param variableManager
	 *            The variable manager
	 * @param interpreter
	 *            The interpreter
	 */
	public EEFLabelControllerImpl(EEFLabelDescription description, IVariableManager variableManager, IInterpreter interpreter) {
		this.description = description;
		this.variableManager = variableManager;
		this.interpreter = interpreter;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.eef.core.api.controllers.EEFLabelController#refresh()
	 */
	@Override
	public void refresh() {
		String labelExpression = this.description.getLabelExpression();
		if (labelExpression != null) {
			IEvaluationResult evaluationResult = this.interpreter.evaluateExpression(this.variableManager.getVariables(), labelExpression);
			Object value = evaluationResult.getValue();
			if (value instanceof String && this.newLabelConsumer != null) {
				this.newLabelConsumer.apply((String) value);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.eef.core.api.controllers.EEFLabelController#onNewLabel(org.eclipse.eef.core.api.controllers.IConsumer)
	 */
	@Override
	public void onNewLabel(IConsumer<String> consumer) {
		this.newLabelConsumer = consumer;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.eef.core.api.controllers.EEFLabelController#removeNewLabelConsumer()
	 */
	@Override
	public void removeNewLabelConsumer() {
		this.newLabelConsumer = null;
	}

}
