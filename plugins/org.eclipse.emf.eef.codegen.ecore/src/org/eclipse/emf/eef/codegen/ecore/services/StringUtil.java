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
		if (locale instanceof Locale){
			return string.toUpperCase((Locale) locale);
		}
		return string;
		
	}
}