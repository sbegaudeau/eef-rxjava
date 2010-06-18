/*******************************************************************************
 * Copyright (c) 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *       Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.worldcupforecast.parts.forms;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.worldcupforecast.provider.WorldcupforecastEditPlugin;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class TeamPropertiesEditionPartFormCustom extends
		TeamPropertiesEditionPartForm {

	public TeamPropertiesEditionPartFormCustom(
			IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void initPics(String key, String newValue) {
		try {
			URL url = WorldcupforecastEditPlugin.getPlugin().getBundle().getEntry("flags/"+newValue);
			url = FileLocator.toFileURL(url);
			newValue = url.getPath();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		newValue = current.eResource().getURI().trimSegments(1).toFileString()+"/"+newValue;
		super.initPics(key, newValue);
	}

}
