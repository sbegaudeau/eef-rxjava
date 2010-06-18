/*******************************************************************************
 * Copyright (c) 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *       Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.worldcupforecast.utils;

import org.eclipse.osgi.util.NLS;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class Urls extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.worldcupforecast.utils.urls"; //$NON-NLS-1$
	public static String URL_CommitPage;
	public static String URL_Model;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Urls.class);
	}

	private Urls() {
	}
}
