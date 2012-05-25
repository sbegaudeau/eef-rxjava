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

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * @author glefur
 *
 */
public class CreateObjectCommand extends AbstractCommand {

	EObject eObject;
	Collection<?> affectedObjects;
	private EditingDomain editingDomain;
	private Resource resource;
	private String selection;

	/**
	 * @param editingDomain
	 * @param resource
	 * @param selection
	 */
	public CreateObjectCommand( EditingDomain editingDomain, Resource resource, String selection) {
		super("Create Object");
		this.editingDomain = editingDomain;
		this.resource = resource;
		this.selection = selection;
	}

	@Override
	protected boolean prepare() {
		return true;
	}

	public void redo() {
		resource.getContents().add(eObject);
		affectedObjects = Collections.singleton(eObject);
	}

	@Override
	public void undo() {
		resource.getContents().remove(eObject);
		affectedObjects = Collections.singleton(resource);
	}

	public void execute() {
		eObject = EcoreUtil.create((EClass) editingDomain.getResourceSet().getEObject(URI.createURI(selection), false));
		resource.getContents().add(eObject);
		affectedObjects = Collections.singleton(eObject);
	}

	@Override
	public Collection<?> getAffectedObjects() {
		return affectedObjects;
	}
}
