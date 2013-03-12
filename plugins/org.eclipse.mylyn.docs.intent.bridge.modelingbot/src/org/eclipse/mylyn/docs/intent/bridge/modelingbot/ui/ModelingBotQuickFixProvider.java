/*******************************************************************************
 * Copyright (c) 2010, 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.mylyn.docs.intent.bridge.modelingbot.ui;

import org.eclipse.emf.eef.modelingBot.ModelingBot;
import org.eclipse.mylyn.docs.intent.client.ui.editor.annotation.IntentAnnotation;
import org.eclipse.mylyn.docs.intent.client.ui.editor.quickfix.AbstractIntentFix;
import org.eclipse.mylyn.docs.intent.client.ui.editor.quickfix.provider.IntentQuickFixProvider;
import org.eclipse.mylyn.docs.intent.core.modelingunit.ExternalContentReference;

public class ModelingBotQuickFixProvider implements IntentQuickFixProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.mylyn.docs.intent.client.ui.editor.quickfix.provider.IntentQuickFixProvider#canCreateQuickFix(org.eclipse.mylyn.docs.intent.client.ui.editor.annotation.IntentAnnotation)
	 */
	public boolean canCreateQuickFix(IntentAnnotation annotation) {
		return (annotation.getCompilationStatus().getTarget() instanceof ExternalContentReference)
				&& ((ExternalContentReference)annotation.getCompilationStatus().getTarget())
						.getExternalContent() instanceof ModelingBot;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.mylyn.docs.intent.client.ui.editor.quickfix.provider.IntentQuickFixProvider#createQuickFix(org.eclipse.mylyn.docs.intent.client.ui.editor.annotation.IntentAnnotation)
	 */
	public AbstractIntentFix createQuickFix(IntentAnnotation annotation) {
		return new CreateJavaTestFromModelingBotQuickFix(annotation);
	}

}
