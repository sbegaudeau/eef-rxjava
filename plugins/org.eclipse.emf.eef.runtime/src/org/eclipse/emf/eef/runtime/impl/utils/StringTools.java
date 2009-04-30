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
package org.eclipse.emf.eef.runtime.impl.utils;

import java.util.StringTokenizer;

import org.eclipse.swt.graphics.RGB;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class StringTools {

	public static final String EMPTY_STRING = ""; //$NON-NLS-1$

	public static RGB toRGB(String s) {
		if (s != null) {
			StringTokenizer st = new StringTokenizer(s, ","); //$NON-NLS-1$
			if (st.countTokens() == 3) {
				try {
					int red = Integer.parseInt(st.nextToken());
					int green = Integer.parseInt(st.nextToken());
					int blue = Integer.parseInt(st.nextToken());
					return new RGB(red, green, blue);
				} catch (NumberFormatException e) {
					return null;
				}
			}
		}
		return null;
	}

	public static boolean isInt(String text) {
		try {
			Integer.parseInt(text);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean isWellFormatedConstanteName(String text) {
		return text.matches("[A-Z][A-Z0-9]*(_[A-Z0-9]+)*$"); //$NON-NLS-1$
	}

	public static boolean isWellFormatedTypeName(String text) {
		return text.matches("[A-Z][a-zA-Z0-9_\\-]*$"); //$NON-NLS-1$
	}

	public static boolean isWellFormatedMemberName(String text) {
		return text.matches("[a-z][a-zA-Z0-9_\\-]*$"); //$NON-NLS-1$
	}

	public static boolean isWellFormatedMemberNameForOP(String text) {
		if (text.startsWith("{")) //$NON-NLS-1$
			return true;
		return text.matches("[a-z][a-zA-Z0-9_\\-]*$"); //$NON-NLS-1$
	}

	public static boolean isWellFormatedMethodName(String text) {
		return text.matches("[a-z][a-zA-Z0-9]*$"); //$NON-NLS-1$
	}

	public static boolean isFloat(String text) {
		try {
			Float.parseFloat(text);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean isByte(String text) {
		try {
			Byte.parseByte(text);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean isDouble(String text) {
		try {
			Double.parseDouble(text);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean isLong(String text) {
		try {
			Long.parseLong(text);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean isShort(String text) {
		try {
			Short.parseShort(text);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static String toL1Case(String nom) {
		StringBuffer buf = new StringBuffer();
		buf.append(nom.substring(0, 1).toLowerCase());
		buf.append(nom.substring(1));
		return buf.toString();
	}

	public static String toU1Case(String nom) {
		StringBuffer buf = new StringBuffer();
		buf.append(nom.substring(0, 1).toUpperCase());
		buf.append(nom.substring(1));
		return buf.toString();
	}
}
