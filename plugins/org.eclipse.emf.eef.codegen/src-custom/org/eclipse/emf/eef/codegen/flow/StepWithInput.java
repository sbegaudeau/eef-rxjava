/**
 * 
 */
package org.eclipse.emf.eef.codegen.flow;

import java.util.List;

import org.eclipse.jface.wizard.WizardPage;


/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public abstract class StepWithInput extends Step {

	/**
	 * @param name of the task
	 */
	public StepWithInput(String name) {
		super(name);
	}
	
	/**
	 * @return a wizard page to get the step inputs
	 */
	public abstract List<WizardPage> getInputPages();

}
