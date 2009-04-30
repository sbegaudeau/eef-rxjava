/*******************************************************************************
 * Copyright (c) 2008-2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.ui.utils;

import java.awt.Toolkit;

/**
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 */
public class ScreenTool {

	public static final double HEIGHT = 0.66;

	public static final double WIDTH = 0.66;

	public static int getHeight() {
		return (int)(HEIGHT * Toolkit.getDefaultToolkit().getScreenSize().height) + 1;
	}

	public static int getWidth() {
		return (int)(WIDTH * Toolkit.getDefaultToolkit().getScreenSize().width) + 1;
	}

	public static int getEntireWidth() {
		return Toolkit.getDefaultToolkit().getScreenSize().width;
	}
}
