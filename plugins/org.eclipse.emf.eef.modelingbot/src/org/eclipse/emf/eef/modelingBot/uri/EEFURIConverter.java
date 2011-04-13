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
package org.eclipse.emf.eef.modelingBot.uri;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class EEFURIConverter extends ExtensibleURIConverterImpl {
	
	private ResourceSet myResourceSet;
	
	public EEFURIConverter() {
		super();
		myResourceSet = new ResourceSetImpl();
		myResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put
		(Resource.Factory.Registry.DEFAULT_EXTENSION, 
		 new XMIResourceFactoryImpl());
	}



	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl#normalize(org.eclipse.emf.common.util.URI)
	 */
	public URI normalize(URI uri) {
		URI result = super.normalize(uri);
		if (result.isPlatformResource()) {
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(result.toPlatformString(true)));
			if (!file.isAccessible()) {
				URI pluginURI = URI.createPlatformPluginURI(uri.toPlatformString(true), true);
				try {
					Resource resource = myResourceSet.getResource(pluginURI, true);
					resource.load(Collections.EMPTY_MAP);
					if (resource.getContents() != null && !resource.getContents().isEmpty()) {
						result = pluginURI;
					}
				} catch (IOException e) {
					// silent catch
				}
			}
		}
		return result;
	}
	
	

}
