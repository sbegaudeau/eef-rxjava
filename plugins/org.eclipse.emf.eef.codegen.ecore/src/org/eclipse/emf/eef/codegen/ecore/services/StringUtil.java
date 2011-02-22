/**
 * 
 */
package org.eclipse.emf.eef.codegen.ecore.services;

import java.util.Locale;

/**
 * this class is used to manipulate strings.
 * 
 * @author sbouchet
 * 
 */
public class StringUtil {

	public String toLowerCase(String string, Object locale) {
		if (locale instanceof Locale) {
			return string.toLowerCase((Locale) locale);
		}
		return string;
	}

	public String genSquareBrackets(String string) {
		StringBuffer buf = new StringBuffer(string.length() + 2);
		buf.append("[");
		buf.append(string);
		buf.append("]");
		return buf.toString();
	}
}