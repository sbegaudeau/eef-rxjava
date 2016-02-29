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
package org.eclipse.eef.core.internal.controllers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.eef.common.api.utils.Util;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.sirius.common.interpreter.api.IEvaluationResult;
import org.eclipse.sirius.common.interpreter.api.IInterpreter;
import org.eclipse.sirius.common.interpreter.api.IVariableManager;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

/**
 * Alternate version of Eval.
 *
 * @author sbegaudeau
 */
public final class Eval2 {
	/**
	 * The interpreter.
	 */
	private IInterpreter interpreter;

	/**
	 * The variables.
	 */
	private Map<String, Object> variables = new HashMap<String, Object>();

	/**
	 * The constructor.
	 *
	 * @param interpreter
	 *            The interpreter
	 * @param variableManager
	 *            The variable manager
	 */
	private Eval2(IInterpreter interpreter, IVariableManager variableManager) {
		this.interpreter = interpreter;
		this.variables = variableManager.getVariables();
	}

	/**
	 * Creates an Eval2.
	 *
	 * @param interpreter
	 *            The interpreter
	 * @param variableManager
	 *            The variable manager
	 * @return The Eval2
	 */
	public static Eval2 of(IInterpreter interpreter, IVariableManager variableManager) {
		return new Eval2(interpreter, variableManager);
	}

	/**
	 * Returns an observable of the result for the given expression.
	 *
	 * @param eAttribute
	 *            The EAttribute used to capture the expression
	 * @param expression
	 *            The expression
	 * @param expectedType
	 *            The return type expected
	 * @param <T>
	 *            The return type
	 * @return The value
	 */
	public <T> Observable<T> get(final EAttribute eAttribute, final String expression, final Class<T> expectedType) {
		return Observable.create(new OnSubscribe<T>() {
			@Override
			public void call(Subscriber<? super T> subscriber) {
				if (!Util.isBlank(expression)) {
					IEvaluationResult evaluationResult = interpreter.evaluateExpression(variables, expression);
					if (evaluationResult.success()) {
						Object value = evaluationResult.getValue();
						if (expectedType.isInstance(value)) {
							T castValue = expectedType.cast(value);
							subscriber.onNext(castValue);
							subscriber.onCompleted();
						}
					} else {
						subscriber.onError(new IllegalArgumentException("Invalid result")); //$NON-NLS-1$
					}
				} else {
					subscriber.onError(new IllegalArgumentException("Blank expression")); //$NON-NLS-1$
				}
			}
		});
	}
}