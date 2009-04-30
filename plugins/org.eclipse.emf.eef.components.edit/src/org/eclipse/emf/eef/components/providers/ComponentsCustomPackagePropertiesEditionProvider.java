/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.components.providers;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class ComponentsCustomPackagePropertiesEditionProvider extends ComponentsPackagePropertiesEditionProvider {

	@Override
	public PropertiesEditionElementPropertiesEditionProvider createPropertiesEditionElementPropertiesEditionProvider() {
		if (propertiesEditionElementPropertiesEditionProvider == null)
			propertiesEditionElementPropertiesEditionProvider = new PropertiesEditionElementCustomPropertiesEditionProvider();
		return propertiesEditionElementPropertiesEditionProvider;
	}

	
	
}
