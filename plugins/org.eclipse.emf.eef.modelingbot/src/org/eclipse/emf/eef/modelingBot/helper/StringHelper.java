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

package org.eclipse.emf.eef.modelingBot.helper;

/**
 * 
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class StringHelper {

	public static String toU1Case(String from) {
		String ret = ""; //$NON-NLS-1$
		if (from.length() > 0) {
			StringBuilder sb = new StringBuilder(from.length());
			sb.append(Character.toUpperCase(from.charAt(0))).append(from.substring(1));
			ret = sb.toString();
		}
		return ret;
	}

}
