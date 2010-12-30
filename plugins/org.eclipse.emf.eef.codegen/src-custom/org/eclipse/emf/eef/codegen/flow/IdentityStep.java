/**
 * 
 */
package org.eclipse.emf.eef.codegen.flow;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class IdentityStep extends Step {

	private static final String IDENTITY_STEP_NAME = "Identity";

	/**
	 * @param name
	 */
	public IdentityStep() {
		super(IDENTITY_STEP_NAME);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.codegen.flow.Step#execute(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public IStatus execute(IProgressMonitor monitor) {
		// TO Nothing
		return Status.OK_STATUS;
	}

}
