/**
 * 
 */
package org.eclipse.emf.eef.views.resources;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.impl.XMIHelperImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

/**
 * @author glefur
 *
 */
public class ViewsResource extends XMIResourceImpl {

	public ViewsResource() {
		super();
	}

	public ViewsResource(URI uri) {
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
