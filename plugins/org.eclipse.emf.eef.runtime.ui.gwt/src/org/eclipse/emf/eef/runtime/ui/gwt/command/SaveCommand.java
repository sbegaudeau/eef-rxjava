/*******************************************************************************
 * Copyright (c) 2008, 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.ui.gwt.command;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.util.Callback;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.eef.runtime.ui.gwt.dialog.ErrorDialog;

/**
 * @author glefur
 *
 */
public class SaveCommand extends AbstractCommand {

	private Resource resourceToSave;
	private Map<?, ?> options;

	/**
	 * 
	 */
	public SaveCommand(Resource resourceToSave, Map<?, ?> options) {
		super("Save Command");
		this.resourceToSave = resourceToSave;
		this.options = options;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.command.AbstractCommand#prepare()
	 */
	@Override
	protected boolean prepare() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.command.Command#execute()
	 */
	@Override
	public void execute() {
		try {
			resourceToSave.save(options, new Callback<Resource>() {
				public void onFailure(Throwable caught) {
					final ErrorDialog dialogBox = new ErrorDialog("Save conflict", caught);
					dialogBox.open();
				}

				public void onSuccess(Resource result) {
				}
			});
		} catch (IOException exception) {
			System.err.println(exception);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.command.Command#redo()
	 */
	@Override
	public void redo() {
		// TODO Auto-generated method stub

	}

}
