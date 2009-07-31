/**
 *  Copyright (c) 2008-2009 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Obeo - initial API and implementation
 * 
 *
 * $Id: ToolkitsViewsRepository.java,v 1.6 2009/07/31 12:42:23 glefur Exp $
 */
package org.eclipse.emf.eef.toolkits.parts;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class ToolkitsViewsRepository {

	public static final int SWT_KIND = 0;
		
	public static final int FORM_KIND = 1;

	
	/**
	 * Toolkit view descriptor
	 */
	public static class Toolkit {
		public static String name = "toolkits::Toolkit::Name";	


	}

	/**
	 * Widget view descriptor
	 */
	public static class Widget {
		public static String name = "toolkits::Widget::Name";	


	}

}

