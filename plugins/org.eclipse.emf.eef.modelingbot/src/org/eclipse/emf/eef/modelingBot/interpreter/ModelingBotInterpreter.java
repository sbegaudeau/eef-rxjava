/*******************************************************************************
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.modelingBot.interpreter;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.eef.modelingBot.IModelingBot;

public interface ModelingBotInterpreter {
	
	/**
	 * Run the modeling bot : interprete the sequence and actions of the model.
	 * @param path
	 * @param swteefBot 
	 * @throws CoreException
	 * @throws IOException
	 */
	void runModelingBot(String path, IModelingBot modelingBot) throws CoreException, IOException;

}
