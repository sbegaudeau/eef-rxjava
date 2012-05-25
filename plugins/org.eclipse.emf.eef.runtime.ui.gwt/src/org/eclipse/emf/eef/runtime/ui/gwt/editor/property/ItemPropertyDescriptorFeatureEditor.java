/*******************************************************************************
 * Copyright (c) 2008, 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.ui.gwt.editor.property;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;

public class ItemPropertyDescriptorFeatureEditor extends FeatureEditor {
		protected IItemPropertyDescriptor propertyDescriptor;

		public ItemPropertyDescriptorFeatureEditor(Object object, IItemPropertyDescriptor propertyDescriptor) {
			super(object, false, ((EAttribute) propertyDescriptor.getFeature(object)).getEAttributeType());
			this.propertyDescriptor = propertyDescriptor;
		}

		public ItemPropertyDescriptorFeatureEditor(Object object, boolean isSortChoices, IItemPropertyDescriptor propertyDescriptor) {
			super(object, isSortChoices, null);
			this.propertyDescriptor = propertyDescriptor;
		}

		@Override
		protected IItemLabelProvider getLabelProvider() {
			return propertyDescriptor.getLabelProvider(object);
		}

		@Override
		protected List<?> getValues() {
			Object propertyValue = propertyDescriptor.getPropertyValue(object);
			if (propertyValue instanceof IItemPropertySource) {
				propertyValue = ((IItemPropertySource) propertyValue).getEditableValue(propertyValue);
			}
			return (List<?>) propertyValue;
		}

		@Override
		protected Collection<?> getChoiceOfValues() {
			return propertyDescriptor.getChoiceOfValues(object);
		}

		@Override
		protected boolean isMultiLine() {
			return propertyDescriptor.isMultiLine(object);
		}

		@Override
		protected boolean isUnique() {
			Object feature = propertyDescriptor.getFeature(object);
			return !(feature instanceof EStructuralFeature) || ((EStructuralFeature) feature).isUnique();
		}

		@Override
		protected void setValue(Object value) {
			propertyDescriptor.setPropertyValue(object, value);
		}
	}
