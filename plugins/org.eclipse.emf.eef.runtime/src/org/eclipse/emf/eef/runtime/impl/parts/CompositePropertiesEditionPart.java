/*******************************************************************************
 * Copyright (c) 2008, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.impl.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IReadOnlyPolicy;
import org.eclipse.emf.eef.runtime.context.ExtendedPropertiesEditingContext;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.widgets.SWTUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.settings.EEFEditorSettings;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;

/**
 * A standard implementation of the {@link IPropertiesEditionPart} by a SWT {@link Composite}.
 * 
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public abstract class CompositePropertiesEditionPart implements IPropertiesEditionPart {

	/**
	 * The component that manage this part.
	 */
	protected IPropertiesEditionComponent propertiesEditionComponent;

	/**
	 * The part view.
	 */
	protected Composite view;

	/**
	 * Helper to use to create the part.
	 */
	protected PartComposer composer;

	/**
	 * The adapter factory.
	 */
	protected AdapterFactory adapterFactory;

	/**
	 * The edited element
	 */
	protected EObject current;

	/**
	 * the current ResourceSet
	 */
	protected ResourceSet resourceSet;

	/**
	 * Defines if part has changed
	 */
	protected boolean partHasChanged = false;

	/**
	 * Defines the part visibility.
	 */
	protected boolean visibility = true;
	
	/**
	 * EEF editor settings to use.
	 */
	private List<EEFEditorSettings> settings;

	/**
	 * For {@link AbstractPropertySection} use only. Do not use with PropertiesEditingViewer.
	 */
	protected CompositePropertiesEditionPart() {
		super();
		this.settings = new ArrayList<EEFEditorSettings>();
	}

	/**
	 * Parameterized constructeur.
	 * 
	 * @param editionComponent
	 *            the component that manage this part
	 */
	public CompositePropertiesEditionPart(IPropertiesEditionComponent editionComponent) {
		this.propertiesEditionComponent = editionComponent;
		this.adapterFactory = propertiesEditionComponent.getEditingContext().getAdapterFactory();
		this.settings = new ArrayList<EEFEditorSettings>();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#setContext(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void setContext(EObject eObject, ResourceSet allResources) {
		this.current = eObject;
		this.resourceSet = allResources;
	}

	/**
	 * Getter for the view
	 * 
	 * @return the part view
	 */
	public Composite getFigure() {
		return view;
	}

	/**
	 * @return the composer
	 */
	public PartComposer getComposer() {
		return composer;
	}

	/**
	 * @param event
	 */
	public void handleNotificationEvent(Notification event) {
		partHasChanged = true;
	}

	/**
	 * Return <code>true</code> if part has changed
	 * 
	 * @return the hasChanged
	 */
	public boolean hasChanged() {
		return partHasChanged;
	}

	/**
	 * @param partHasChanged
	 *            the partHasChanged to set
	 */
	protected void setHasChanged(boolean partHasChanged) {
		this.partHasChanged = partHasChanged;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getObserver(java.lang.String)
	 */
	public ISWTObservableValue getObserver(String key) {
		return null;
	}

	/**
	 * Refresh the part
	 */
	public void refresh() {
		if (!view.isDisposed()) {
			clear();
			composer.compose(view);
			view.layout();
		}
	}

	/**
	 * Clear all the graphical elements of the view
	 */
	protected void clear() {
		if (!view.isDisposed()) {
				while (view.getChildren().length > 0) {
					Control next = view.getChildren()[0];
					next.dispose();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#isVisible()
	 */
	public boolean isVisible() {
		return visibility;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#setVisible(boolean)
	 */
	public void setVisible(boolean visibility) {
		this.visibility = visibility;
	}

	/**
	 * @param parent
	 *            label container
	 * @param editor
	 *            key of the editor
	 * @param alternate
	 *            text to display if no information can be found
	 * @return created label.
	 */
	protected String getDescription(Object editor, String alternate) {
		if (propertiesEditionComponent.getEditingContext() instanceof ExtendedPropertiesEditingContext) {
			return ((ExtendedPropertiesEditingContext)propertiesEditionComponent.getEditingContext())
					.getHelper().getDescription(editor, alternate);
		} else {
			return alternate;
		}
	}

	/**
	 * @param parent
	 *            label container
	 * @param editor
	 *            key of the editor
	 * @param alternate
	 *            text to display if no information can be found
	 * @return created label.
	 */
	protected Label createDescription(Composite parent, Object editor, String alternate) {
		if (propertiesEditionComponent.getEditingContext() instanceof ExtendedPropertiesEditingContext) {
			return ((ExtendedPropertiesEditingContext)propertiesEditionComponent.getEditingContext())
					.getHelper().createLabel(parent, editor, alternate);
		} else {
			return SWTUtils.createPartLabel(parent, alternate,
					propertiesEditionComponent.isRequired(editor, 0));
		}
	}

	/**
	 * @param control
	 *            Widget
	 * 
	 * @return if the widget is read only
	 */
	public boolean isReadOnly(Object control, EObject context) {
		EObject eObject = context;
		if (eObject == null) {
			eObject = propertiesEditionComponent.getEditingContext().getEObject();
		}
		
		if (eObject != null) {
			List<IReadOnlyPolicy> policies = EEFRuntimePlugin.getDefault().getReadOnlyPolicies();
			for (IReadOnlyPolicy iReadOnlyPolicy : policies) {
				if (iReadOnlyPolicy.isReadOnly(eObject, control)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * @param control
	 *            Widget
	 * 
	 * @return if the widget is read only
	 */
	public boolean isReadOnly(Object control) {
		return isReadOnly(control, null);
	}

	/**
	 * @return the settings to use.
	 */
	public List<EEFEditorSettings> getSettings() {
		return settings;
	}
}
