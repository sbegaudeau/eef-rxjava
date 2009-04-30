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
 * $Id: GenEditionContextPropertiesEditionProvider.java,v 1.1 2009/04/30 17:12:36 glefur Exp $
 */
package org.eclipse.emf.eef.EEFGen.providers;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;

import org.eclipse.emf.eef.EEFGen.EEFGenPackage;
import org.eclipse.emf.eef.EEFGen.GenEditionContext;
import org.eclipse.emf.eef.EEFGen.components.GenEditionContextPropertiesEditionComponent;
import org.eclipse.emf.eef.EEFGen.components.GenEditionContextGenActivationPropertiesEditionComponent;
import org.eclipse.emf.eef.EEFGen.parts.impl.GenActivationPropertiesEditionPartImpl;
import org.eclipse.emf.eef.EEFGen.parts.forms.GenActivationPropertiesEditionPartForm;
import org.eclipse.emf.eef.EEFGen.components.GenEditionContextGenParametersPropertiesEditionComponent;
import org.eclipse.emf.eef.EEFGen.parts.impl.GenParametersPropertiesEditionPartImpl;
import org.eclipse.emf.eef.EEFGen.parts.forms.GenParametersPropertiesEditionPartForm;
import org.eclipse.emf.eef.EEFGen.components.GenEditionContextGenReferencesPropertiesEditionComponent;
import org.eclipse.emf.eef.EEFGen.parts.impl.GenReferencesPropertiesEditionPartImpl;
import org.eclipse.emf.eef.EEFGen.parts.forms.GenReferencesPropertiesEditionPartForm;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class GenEditionContextPropertiesEditionProvider implements IPropertiesEditionProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject)
	 */
	public boolean provides(EObject eObject) {
		return (eObject instanceof GenEditionContext) && (EEFGenPackage.eINSTANCE.getGenEditionContext() == eObject.eClass());
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *      java.lang.String)
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String mode) {
		if (eObject instanceof GenEditionContext) {
			return new GenEditionContextPropertiesEditionComponent(eObject, mode);
		}
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *      java.lang.String, java.lang.String)
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String mode, String part) {
		if (eObject instanceof GenEditionContext) {
			if (GenEditionContextGenActivationPropertiesEditionComponent.GEN_ACTIVATION_PART.equals(part))
				return new GenEditionContextGenActivationPropertiesEditionComponent(eObject, mode);
			if (GenEditionContextGenParametersPropertiesEditionComponent.GEN_PARAMETERS_PART.equals(part))
				return new GenEditionContextGenParametersPropertiesEditionComponent(eObject, mode);
			if (GenEditionContextGenReferencesPropertiesEditionComponent.GEN_REFERENCES_PART.equals(part))
				return new GenEditionContextGenReferencesPropertiesEditionComponent(eObject, mode);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionPart(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent, java.lang.String,
	 *      java.lang.String)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(EObject eObject,
			IPropertiesEditionComponent editionComponent, String part, String kind) {
		if (eObject instanceof GenEditionContext) {
			if (GenEditionContextPropertiesEditionComponent.SWT_KIND.equals(kind)) {
				if (GenEditionContextGenActivationPropertiesEditionComponent.GEN_ACTIVATION_PART.equals(part))
					return new GenActivationPropertiesEditionPartImpl(editionComponent);
				if (GenEditionContextGenParametersPropertiesEditionComponent.GEN_PARAMETERS_PART.equals(part))
					return new GenParametersPropertiesEditionPartImpl(editionComponent);
				if (GenEditionContextGenReferencesPropertiesEditionComponent.GEN_REFERENCES_PART.equals(part))
					return new GenReferencesPropertiesEditionPartImpl(editionComponent);
			}
		}
		if (GenEditionContextPropertiesEditionComponent.FORM_KIND.equals(kind)) {
				if (GenEditionContextGenActivationPropertiesEditionComponent.GEN_ACTIVATION_PART.equals(part))
					return new GenActivationPropertiesEditionPartForm(editionComponent);
				if (GenEditionContextGenParametersPropertiesEditionComponent.GEN_PARAMETERS_PART.equals(part))
					return new GenParametersPropertiesEditionPartForm(editionComponent);
				if (GenEditionContextGenReferencesPropertiesEditionComponent.GEN_REFERENCES_PART.equals(part))
					return new GenReferencesPropertiesEditionPartForm(editionComponent);
		}
		return null;
	}
	
}	
