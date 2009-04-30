/**
 *  Copyright (c) 2008 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Obeo - initial API and implementation
 * 
 *
 * $Id: ComponentsResource.java,v 1.1 2009/04/30 17:09:48 glefur Exp $
 */
package org.eclipse.emf.eef.components.resources;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.impl.XMIHelperImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class ComponentsResource extends XMIResourceImpl {

	/**
	 * 
	 */
	public ComponentsResource() {
	}

	/**
	 * @param uri
	 */
	public ComponentsResource(URI uri) {
		super(uri);
	}

	@Override
	protected boolean useUUIDs() {
		return true;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl#createXMLHelper()
	 */
	@Override
	protected XMLHelper createXMLHelper() {
	    return new XMIHelperImpl(this) {

			/**
			 * {@inheritDoc}
			 * @see org.eclipse.emf.ecore.xmi.impl.XMLHelperImpl#deresolve(org.eclipse.emf.common.util.URI)
			 */
			@Override
			public URI deresolve(URI uri) {
				return uri;
			}
	    	
	    };
	}
	
	
	
	
}
