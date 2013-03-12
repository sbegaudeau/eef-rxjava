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

import org.eclipse.mylyn.docs.intent.client.ui.editor.IntentEditorDocument;
import org.eclipse.mylyn.docs.intent.client.ui.editor.annotation.IntentAnnotation;
import org.eclipse.mylyn.docs.intent.client.ui.editor.quickfix.AbstractIntentFix;
import org.eclipse.mylyn.docs.intent.collab.handlers.adapters.RepositoryAdapter;
import org.eclipse.swt.graphics.Image;

/**
 * @author <a href="mailto:alex.lagarde@obeo.fr">Alex Lagarde</a>
 */
public class CreateJavaTestFromModelingBotQuickFix extends AbstractIntentFix {

	/**
	 * Default constructor.
	 * 
	 * @param annotation
	 */
	public CreateJavaTestFromModelingBotQuickFix(IntentAnnotation annotation) {
		super(annotation);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.mylyn.docs.intent.client.ui.editor.quickfix.AbstractIntentFix#applyFix(org.eclipse.mylyn.docs.intent.collab.handlers.adapters.RepositoryAdapter,
	 *      org.eclipse.mylyn.docs.intent.client.ui.editor.IntentEditorDocument)
	 */
	@Override
	protected void applyFix(RepositoryAdapter repositoryAdapter, IntentEditorDocument document) {
		System.err.println("APPPPPPLIIIIIIED");
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposal#getDisplayString()
	 */
	public String getDisplayString() {
		return "Generate java test from this ModelingBot scenario";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.mylyn.docs.intent.client.ui.editor.quickfix.AbstractIntentFix#getImage()
	 */
	@Override
	public Image getImage() {
		// Could be overidden
		return super.getImage();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.mylyn.docs.intent.client.ui.editor.quickfix.AbstractIntentFix#getAdditionalProposalInfo()
	 */
	@Override
	public String getAdditionalProposalInfo() {
		return "additional infos";
	}

}
