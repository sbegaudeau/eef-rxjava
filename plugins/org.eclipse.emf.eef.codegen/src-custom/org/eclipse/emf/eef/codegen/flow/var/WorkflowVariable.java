/**
 * 
 */
package org.eclipse.emf.eef.codegen.flow.var;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class WorkflowVariable {
	
	private final String name;
	private Object value;
	
	/**
	 * @param name of the variable
	 */
	public WorkflowVariable(String name) {
		super();
		this.name = name;
		this.value = null;
	}

	/**
	 * @param name of the variable
	 * @param value of the variable
	 */
	public WorkflowVariable(String name, Object value) {
		super();
		this.name = name;
		this.value = value;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Object value) {
		this.value = value;
	}
	
	

}
