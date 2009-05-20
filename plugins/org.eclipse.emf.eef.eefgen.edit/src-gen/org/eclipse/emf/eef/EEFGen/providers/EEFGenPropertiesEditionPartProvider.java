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
 * $Id: EEFGenPropertiesEditionPartProvider.java,v 1.4 2009/05/20 15:51:51 sbouchet Exp $
 */
package org.eclipse.emf.eef.EEFGen.providers;

import org.eclipse.emf.eef.EEFGen.parts.EEFGenViewsRepository;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.EEFGen.parts.forms.GenEditionContextPropertiesEditionPartForm;
import org.eclipse.emf.eef.EEFGen.parts.impl.GenEditionContextPropertiesEditionPartImpl;
import org.eclipse.emf.eef.EEFGen.parts.forms.EEFGenModelReferencePropertiesEditionPartForm;
import org.eclipse.emf.eef.EEFGen.parts.impl.EEFGenModelReferencePropertiesEditionPartImpl;
import org.eclipse.emf.eef.EEFGen.parts.forms.EEFGenModelPropertiesEditionPartForm;
import org.eclipse.emf.eef.EEFGen.parts.impl.EEFGenModelPropertiesEditionPartImpl;
import org.eclipse.emf.eef.EEFGen.parts.forms.GenViewsRepositoryPropertiesEditionPartForm;
import org.eclipse.emf.eef.EEFGen.parts.impl.GenViewsRepositoryPropertiesEditionPartImpl;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 *
 */
public class EEFGenPropertiesEditionPartProvider implements IPropertiesEditionPartProvider {
	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#provides(java.lang.Class)
	 */
	public boolean provides(java.lang.Class key) {
		return key == EEFGenViewsRepository.class;
	}

	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#getPropertiesEditionPart(java.lang.Class, int, org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionComponent component) {
		if (key == EEFGenViewsRepository.GenEditionContext.class) {
			if (kind == EEFGenViewsRepository.SWT_KIND)
				return new GenEditionContextPropertiesEditionPartImpl(component);
			if (kind == EEFGenViewsRepository.FORM_KIND)
				return new GenEditionContextPropertiesEditionPartForm(component);
		}
		if (key == EEFGenViewsRepository.EEFGenModelReference.class) {
			if (kind == EEFGenViewsRepository.SWT_KIND)
				return new EEFGenModelReferencePropertiesEditionPartImpl(component);
			if (kind == EEFGenViewsRepository.FORM_KIND)
				return new EEFGenModelReferencePropertiesEditionPartForm(component);
		}
		if (key == EEFGenViewsRepository.EEFGenModel.class) {
			if (kind == EEFGenViewsRepository.SWT_KIND)
				return new EEFGenModelPropertiesEditionPartImpl(component);
			if (kind == EEFGenViewsRepository.FORM_KIND)
				return new EEFGenModelPropertiesEditionPartForm(component);
		}
		if (key == EEFGenViewsRepository.GenViewsRepository.class) {
			if (kind == EEFGenViewsRepository.SWT_KIND)
				return new GenViewsRepositoryPropertiesEditionPartImpl(component);
			if (kind == EEFGenViewsRepository.FORM_KIND)
				return new GenViewsRepositoryPropertiesEditionPartForm(component);
		}
		return null;
	}

}

