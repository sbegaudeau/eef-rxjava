/**
 * 
 */
package org.eclipse.emf.eef.runtime.ui.editor.messages;

import org.eclipse.ui.forms.events.HyperlinkEvent;

/**
 * @author glefur
 *
 */
public abstract class MessageHandler {
	
	protected MessageProcessor processor;
	
	/**
	 * @param event the event to handle
	 * @return <code>true</code> if the handle have to be processed.
	 */
	public abstract boolean handle(HyperlinkEvent event);
	
	/**
	 * Process the given message.
	 * @param event the event to handle.
	 */
	public abstract void process(HyperlinkEvent event);

	/**
	 * @param superHandler the superHandler to set
	 */
	public void setProcessor(MessageProcessor superHandler) {
		this.processor = superHandler;
	}
	
}
