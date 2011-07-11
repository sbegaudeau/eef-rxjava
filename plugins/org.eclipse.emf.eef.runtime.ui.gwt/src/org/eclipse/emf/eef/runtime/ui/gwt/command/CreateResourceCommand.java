/**
 * 
 */
package org.eclipse.emf.eef.runtime.ui.gwt.command;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;

/**
 * @author glefur
 *
 */
public class CreateResourceCommand extends AbstractCommand{

	private Collection<?> affectedObjects;
	private Resource resource;
	private EditingDomain editingDomain;
	private String value;

	/**
	 * @param editingDomain
	 */
	public CreateResourceCommand(EditingDomain editingDomain, String value) {
		super();
		this.editingDomain = editingDomain;
		this.value = value;
	}

	@Override
	protected boolean prepare() {
		return true;
	}

	public void redo() {
		editingDomain.getResourceSet().getResources().add(resource);
		affectedObjects = Collections.singleton(resource);
	}

	@Override
	public void undo() {
		editingDomain.getResourceSet().getResources().remove(resource);
		affectedObjects = Collections.singleton(editingDomain.getResourceSet());
	}

	public void execute() {
		resource = editingDomain.getResourceSet().createResource(URI.createURI(value));
		resource.getContents().clear();
		affectedObjects = Collections.singleton(resource);
	}

	@Override
	public Collection<?> getAffectedObjects() {
		return affectedObjects;
	}	
}
