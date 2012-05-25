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

