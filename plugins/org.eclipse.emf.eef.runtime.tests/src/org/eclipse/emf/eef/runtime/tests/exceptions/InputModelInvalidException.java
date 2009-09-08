/**
 * 
 */
package org.eclipse.emf.eef.runtime.tests.exceptions;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
  *
 */
public class InputModelInvalidException extends Exception {

	/**
	 * Serialization
	 */
	private static final long serialVersionUID = 5938605662196039272L;
	
	private String messageInfo;
	
	/**
	 * default constructor 
	 */
	public InputModelInvalidException() {
		super();
	}

	/**
	 * constructor with info
	 * @param info the info
	 */
	public InputModelInvalidException(String info) {
		super();
		this.messageInfo = info;
	}

	/**
	 * {@inheritDoc}
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		String message = "The input model is invalid for test";
		if (messageInfo != null) {
			StringBuilder builder = new StringBuilder(message);
			builder.append(" : ");
			builder.append(messageInfo);
			return builder.toString();
		}
		return message;
	}
	
	

}
