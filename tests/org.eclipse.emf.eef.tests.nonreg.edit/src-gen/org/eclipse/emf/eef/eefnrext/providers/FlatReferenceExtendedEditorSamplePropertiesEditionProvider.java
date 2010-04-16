/*******************************************************************************
 * Copyright (c) 2009 - 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.eefnrext.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.eefnrext.EefnrextPackage;
import org.eclipse.emf.eef.eefnrext.FlatReferenceExtendedEditorSample;
import org.eclipse.emf.eef.eefnrext.components.CheckBoxExtendedEditorSampleBasePropertiesEditionComponent;
import org.eclipse.emf.eef.eefnrext.components.CheckBoxExtendedEditorSamplePropertiesEditionComponent;
import org.eclipse.emf.eef.eefnrext.components.FlatReferenceExtendedEditorSampleBasePropertiesEditionComponent;
import org.eclipse.emf.eef.eefnrext.components.FlatReferenceExtendedEditorSamplePropertiesEditionComponent;
import org.eclipse.emf.eef.eefnrext.components.FlatReferenceExtendedEditorSampleSecondFlatReferenceExtendedEditorSamplePropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class FlatReferenceExtendedEditorSamplePropertiesEditionProvider implements IPropertiesEditionProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject)
	 * 
	 */
	public boolean provides(EObject eObject) {
		return (eObject instanceof FlatReferenceExtendedEditorSample) && (EefnrextPackage.eINSTANCE.getFlatReferenceExtendedEditorSample() == eObject.eClass());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject, java.lang.String)
	 * 
	 */
	public boolean provides(EObject eObject, String part) {
		return (eObject instanceof FlatReferenceExtendedEditorSample) && (FlatReferenceExtendedEditorSampleBasePropertiesEditionComponent.BASE_PART.equals(part) || FlatReferenceExtendedEditorSampleSecondFlatReferenceExtendedEditorSamplePropertiesEditionComponent.SECONDFLATREFERENCEEXTENDEDEDITORSAMPLE_PART.equals(part) || CheckBoxExtendedEditorSampleBasePropertiesEditionComponent.BASE_PART.equals(part));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject, java.lang.Class)
	 * 
	 */
	public boolean provides(EObject eObject, java.lang.Class refinement) {
		return (eObject instanceof FlatReferenceExtendedEditorSample) && (refinement == FlatReferenceExtendedEditorSampleBasePropertiesEditionComponent.class || refinement == FlatReferenceExtendedEditorSampleSecondFlatReferenceExtendedEditorSamplePropertiesEditionComponent.class || refinement == CheckBoxExtendedEditorSamplePropertiesEditionComponent.class);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject, java.lang.String, java.lang.Class)
	 * 
	 */
	public boolean provides(EObject eObject, String part, java.lang.Class refinement) {
		return (eObject instanceof FlatReferenceExtendedEditorSample) && ((FlatReferenceExtendedEditorSampleBasePropertiesEditionComponent.BASE_PART.equals(part) && refinement == FlatReferenceExtendedEditorSampleBasePropertiesEditionComponent.class) || (FlatReferenceExtendedEditorSampleSecondFlatReferenceExtendedEditorSamplePropertiesEditionComponent.SECONDFLATREFERENCEEXTENDEDEDITORSAMPLE_PART.equals(part) && refinement == FlatReferenceExtendedEditorSampleSecondFlatReferenceExtendedEditorSamplePropertiesEditionComponent.class) || (CheckBoxExtendedEditorSampleBasePropertiesEditionComponent.BASE_PART.equals(part) && refinement == CheckBoxExtendedEditorSamplePropertiesEditionComponent.class));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *  java.lang.String)
	 * 
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String editing_mode) {
		if (eObject instanceof FlatReferenceExtendedEditorSample) {
			return new FlatReferenceExtendedEditorSamplePropertiesEditionComponent(eObject, editing_mode);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *  java.lang.String, java.lang.String)
	 * 
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String editing_mode, String part) {
		if (eObject instanceof FlatReferenceExtendedEditorSample) {
			if (FlatReferenceExtendedEditorSampleBasePropertiesEditionComponent.BASE_PART.equals(part))
				return new FlatReferenceExtendedEditorSampleBasePropertiesEditionComponent(eObject, editing_mode);
			if (FlatReferenceExtendedEditorSampleSecondFlatReferenceExtendedEditorSamplePropertiesEditionComponent.SECONDFLATREFERENCEEXTENDEDEDITORSAMPLE_PART.equals(part))
				return new FlatReferenceExtendedEditorSampleSecondFlatReferenceExtendedEditorSamplePropertiesEditionComponent(eObject, editing_mode);
			if (CheckBoxExtendedEditorSampleBasePropertiesEditionComponent.BASE_PART.equals(part))
				return new CheckBoxExtendedEditorSamplePropertiesEditionComponent(eObject, editing_mode);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *  java.lang.String, java.lang.String, java.lang.Class)
	 * 
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String editing_mode, String part, java.lang.Class refinement) {
		if (eObject instanceof FlatReferenceExtendedEditorSample) {
			if (FlatReferenceExtendedEditorSampleBasePropertiesEditionComponent.BASE_PART.equals(part)
				&& refinement == FlatReferenceExtendedEditorSampleBasePropertiesEditionComponent.class)
				return new FlatReferenceExtendedEditorSampleBasePropertiesEditionComponent(eObject, editing_mode);
			if (FlatReferenceExtendedEditorSampleSecondFlatReferenceExtendedEditorSamplePropertiesEditionComponent.SECONDFLATREFERENCEEXTENDEDEDITORSAMPLE_PART.equals(part)
				&& refinement == FlatReferenceExtendedEditorSampleSecondFlatReferenceExtendedEditorSamplePropertiesEditionComponent.class)
				return new FlatReferenceExtendedEditorSampleSecondFlatReferenceExtendedEditorSamplePropertiesEditionComponent(eObject, editing_mode);
			if (CheckBoxExtendedEditorSampleBasePropertiesEditionComponent.BASE_PART.equals(part)
				&& refinement == CheckBoxExtendedEditorSamplePropertiesEditionComponent.class)
				return new CheckBoxExtendedEditorSamplePropertiesEditionComponent(eObject, editing_mode);
		}
		return null;
	}

}
