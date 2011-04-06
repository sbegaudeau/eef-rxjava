package org.eclipse.emf.eef.modelingBot.interpreter;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.eef.modelingBot.IModelingBot;

public interface ModelingBotInterpreter {
	
	/**
	 * @param path
	 * @param swteefBot 
	 * @throws CoreException
	 * @throws IOException
	 */
	void runModelingBot(String path, IModelingBot modelingBot) throws CoreException, IOException;

}
