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
package org.eclipse.worldcupforecast.utils;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class XMIResourceImplCustom extends XMIResourceImpl {

        public XMIResourceImplCustom() {
                super();
        }

        public XMIResourceImplCustom(URI uri) {
                super(uri);
        }

        /* (non-Javadoc)
         * @see org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl#useUUIDs()
         */
        protected boolean useUUIDs() {
                return true;
        }
}