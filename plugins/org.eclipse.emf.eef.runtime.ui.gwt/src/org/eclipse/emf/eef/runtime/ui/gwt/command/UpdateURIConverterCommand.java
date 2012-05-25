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

import java.util.Map;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.util.Callback;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.eef.runtime.ui.gwt.dialog.ErrorDialog;

/**
 * @author glefur
 *
 */
public class UpdateURIConverterCommand extends AbstractCommand {

	private URIConverter uriConverter;
	private URI uri;
	private Map<?, ?> options;
	
	/**
	 * @param uriConverter
	 * @param uri
	 * @param options
	 */
	public UpdateURIConverterCommand(URIConverter uriConverter, URI uri, Map<?, ?> options) {
		super("Update URI Converter");
		this.uriConverter = uriConverter;
		this.uri = uri;
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
		uriConverter.delete(uri, options, new Callback<Map<?, ?>>() {
			public void onFailure(Throwable caught) {
				final ErrorDialog dialogBox = new ErrorDialog("Delete conflict", caught);
				dialogBox.open();
			}

			public void onSuccess(Map<?, ?> result) {
				// TODO Auto-generated method stub
			}
		});
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.command.Command#redo()
	 */
	@Override
	public void redo() {
		// TODO Auto-generated method stub

	}

}
