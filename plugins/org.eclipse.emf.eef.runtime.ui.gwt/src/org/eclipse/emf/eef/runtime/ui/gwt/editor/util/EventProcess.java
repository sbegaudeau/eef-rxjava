package org.eclipse.emf.eef.runtime.ui.gwt.editor.util;

import org.eclipse.emf.common.command.Command;


public class EventProcess {
	
	public Command command;
	public CallBack callback;
	/**
	 * @param command
	 * @param callback
	 */
	public EventProcess(Command command, CallBack callback) {
		super();
		this.command = command;
		this.callback = callback;
	}
	
	/**
	 * @return
	 */
	public boolean canExecute() {
		boolean result = false;
		if (command != null) {
			result = command.canExecute();
		}
		if (callback != null) {
			result &= true;
		}
		return result;
	}
	
	public interface CallBack {
		
		void process();
		
	}	

}

