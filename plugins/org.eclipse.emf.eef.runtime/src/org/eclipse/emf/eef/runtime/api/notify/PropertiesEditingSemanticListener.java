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
package org.eclipse.emf.eef.runtime.api.notify;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public abstract class PropertiesEditingSemanticListener {

	private IPropertiesEditionComponent component;

	private IPropertiesEditionPart part;
	
	private NotificationFilter[] filters;

	/**
	 * @param component
	 */
	public PropertiesEditingSemanticListener(IPropertiesEditionComponent component, NotificationFilter... filters) {
		this.component = component;
		this.filters = filters;
	}

	/**
	 * @return the part
	 */
	public IPropertiesEditionPart getPart() {
		return part;
	}

	/**
	 * @param part
	 *            the part to set
	 */
	public void setPart(IPropertiesEditionPart part) {
		this.part = part;
	}

	/**
	 * @return
	 */
	public NotificationFilter[] getFilters() {
		return filters;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.util.EContentAdapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	public void notifyChanged(final Notification notification) {
		if (part == null)
			component.dispose();
		else {
			Runnable updateRunnable = new Runnable() {
				public void run() {
					runUpdateRunnable(notification);
				}
			};
			if (null == Display.getCurrent()) {
				PlatformUI.getWorkbench().getDisplay().asyncExec(updateRunnable);
			} else {
				updateRunnable.run();
			}
		}
	}

	/**
	 * Performs update in the views
	 * 
	 * @param notification
	 *            the model notification
	 */
	public abstract void runUpdateRunnable(Notification notification);

}
