/*******************************************************************************
 * Copyright (c) 2008, 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.worldcupforecast.parts.forms;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;

import org.eclipse.worldcupforecast.parts.WorldcupforecastViewsRepository;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class WorldCupForecastPLayerSpecificPropertiesEditionPartForm extends
		WorldCupForecastPLayerPropertiesEditionPartForm {

	/**
	 * default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public WorldCupForecastPLayerSpecificPropertiesEditionPartForm(
			IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	protected void createPlayerTableComposition(FormToolkit widgetFactory,
			Composite parent) {
		super.createPlayerTableComposition(widgetFactory, parent);
		
		this.player.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(WorldCupForecastPLayerSpecificPropertiesEditionPartForm.this, WorldcupforecastViewsRepository.WorldCupForecastPLayer.player, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, playerEditUtil.foundCorrespondingEObject((EObject)e.item.getData()), -1));
			}
			
		});
	}

}
