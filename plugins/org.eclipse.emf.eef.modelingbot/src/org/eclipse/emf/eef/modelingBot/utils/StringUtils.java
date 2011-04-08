package org.eclipse.emf.eef.modelingBot.utils;

public class StringUtils {
	
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
