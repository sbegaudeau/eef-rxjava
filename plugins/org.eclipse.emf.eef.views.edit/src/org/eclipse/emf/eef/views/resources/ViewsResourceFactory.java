/**
 * 
 */
package org.eclipse.emf.eef.views.resources;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

/**
 * @author glefur
 *
 */
public class ViewsResourceFactory extends XMIResourceFactoryImpl {

	@Override
	public Resource createResource(URI uri) {
		return new ViewsResource(uri);
	}

	
	
}
