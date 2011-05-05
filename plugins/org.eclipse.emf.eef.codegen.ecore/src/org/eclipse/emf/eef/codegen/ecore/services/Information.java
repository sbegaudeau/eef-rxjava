/*******************************************************************************
 * Copyright (c) 2002, 2011 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Obeo - Migrate to Acceleo generators
 *******************************************************************************/
package org.eclipse.emf.eef.codegen.ecore.services;

import org.eclipse.emf.ecore.EGenericType;

/**
 * This class emulates an inner class used by EMF for the generation of Package classes.
 * 
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 */
public class Information {
	EGenericType eGenericType;

	int depth;

	String type;

	String accessor;
}
