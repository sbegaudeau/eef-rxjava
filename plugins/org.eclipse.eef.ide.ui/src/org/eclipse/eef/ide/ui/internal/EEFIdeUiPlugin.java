/*******************************************************************************
 * Copyright (c) 2015, 2016 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.eef.ide.ui.internal;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;

/**
 * The plugin class of the bundle.
 *
 * @author sbegaudeau
 */
public class EEFIdeUiPlugin extends EMFPlugin {

	/**
	 * The identifier of the plugin.
	 */
	public static final String PLUGIN_ID = "org.eclipse.eef.ide.ui"; //$NON-NLS-1$

	/**
	 * The sole instance of the plugin.
	 */
	public static final EEFIdeUiPlugin INSTANCE = new EEFIdeUiPlugin();

	/**
	 * The OSGi related implementation of the plugin.
	 */
	private static Implementation plugin;

	/**
	 * The constructor.
	 */
	public EEFIdeUiPlugin() {
		super(new ResourceLocator[0]);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.common.EMFPlugin#getPluginResourceLocator()
	 */
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}

	public static Implementation getPlugin() {
		return plugin;
	}

	/**
	 * This class is used as the bundle activator of the plugin.
	 *
	 * @author sbegaudeau
	 */
	public static class Implementation extends EclipsePlugin {
		/**
		 * The constructor.
		 */
		public Implementation() {
			super();

			EEFIdeUiPlugin.plugin = this;
		}

		/**
		 * Logs the status.
		 * 
		 * @param severity
		 *            The severity of the status
		 * @param message
		 *            The message to log or <code>null</code>. If the message is <code>null</code>, the message of the
		 *            exception will be used instead
		 * @param exception
		 *            The exception to log
		 */
		private void doLog(int severity, String message, Exception exception) {
			String messageToLog = message;
			if (messageToLog == null && exception != null) {
				messageToLog = exception.getMessage();
			}
			IStatus status = new Status(severity, PLUGIN_ID, messageToLog, exception);
			this.getLog().log(status);
		}

		/**
		 * Logs an error with the exception and the given message.
		 *
		 * @param message
		 *            The message
		 * @param exception
		 *            The exception
		 */
		public void error(String message, Exception exception) {
			if (exception instanceof CoreException) {
				this.getLog().log(((CoreException) exception).getStatus());
			} else {
				this.doLog(IStatus.ERROR, message, exception);
			}
		}

		/**
		 * Logs a warning with the exception and the given message.
		 *
		 * @param message
		 *            The message
		 * @param exception
		 *            The exception
		 */
		public void warning(String message, Exception exception) {
			if (exception instanceof CoreException) {
				this.getLog().log(((CoreException) exception).getStatus());
			} else {
				this.doLog(IStatus.WARNING, message, exception);
			}
		}

		/**
		 * Logs an info with the exception and the given message.
		 *
		 * @param message
		 *            The message
		 * @param exception
		 *            The exception
		 */
		public void info(String message, Exception exception) {
			if (exception instanceof CoreException) {
				this.getLog().log(((CoreException) exception).getStatus());
			} else {
				this.doLog(IStatus.INFO, message, exception);
			}
		}
	}
}
