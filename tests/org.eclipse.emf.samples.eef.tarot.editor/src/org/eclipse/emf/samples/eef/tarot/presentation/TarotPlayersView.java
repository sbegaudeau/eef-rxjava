/**
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 * 
 *
 */
package org.eclipse.emf.samples.eef.tarot.presentation;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.providers.RegistryPropertiesEditionProvider;
import org.eclipse.emf.eef.runtime.ui.viewers.PropertiesEditionContentProvider;
import org.eclipse.emf.eef.runtime.ui.viewers.PropertiesEditionViewer;
import org.eclipse.emf.eef.runtime.ui.viewers.filters.PropertiesEditionPartFilter;
import org.eclipse.emf.eef.runtime.ui.views.EEFView;
import org.eclipse.emf.eef.runtime.ui.widgets.masterdetails.eefviewer.PropertiesViewerMasterDetailsBlock;
import org.eclipse.emf.samples.eef.tarot.Game;
import org.eclipse.emf.samples.eef.tarot.components.GameGamePlayersPropertiesEditionComponent;
import org.eclipse.emf.samples.eef.tarot.parts.TarotViewsRepository;
import org.eclipse.emf.samples.eef.tarot.util.TarotHelper;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.ManagedForm;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class TarotPlayersView extends EEFView {

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.ui.views.EEFView#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		form = new ManagedForm(parent);
		block = new PropertiesViewerMasterDetailsBlock(false, false);
		block.createContent(form);
		((PropertiesEditionViewer)block.getMasterPart().getModelViewer()).setToolkit(getToolkit());
		createContextMenuFor(block.getMasterPart().getModelViewer());
		// Initialize part listener and register it
		getSite().getPage().addPartListener(getPartListener());
		block.setOrientation(SWT.VERTICAL);
		block.getMasterPart().setTitle("Player");
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.ui.views.EEFView#editingDomainChanged(org.eclipse.emf.edit.domain.EditingDomain)
	 */
	protected void editingDomainChanged(EditingDomain editingDomain) {
		Game game = TarotHelper.findFirstGameInstance(editingDomain.getResourceSet());
		if (game != null) {
			PropertiesEditionContentProvider contentProvider = new PropertiesEditionContentProvider(new RegistryPropertiesEditionProvider(), IPropertiesEditionComponent.LIVE_MODE, editingDomain);
			block.getMasterPart().getModelViewer().setContentProvider(contentProvider);
			block.getMasterPart().getModelViewer().addFilter(new PropertiesEditionPartFilter(GameGamePlayersPropertiesEditionComponent.GAMEPLAYERS_PART));
			block.setInput(game);
			contentProvider.addPropertiesListener(new IPropertiesEditionListener() {
				
				public void firePropertiesChanged(IPropertiesEditionEvent event) {
					if (event.getState() == PropertiesEditionEvent.CHANGE && event.getKind() == PropertiesEditionEvent.SELECTION_CHANGED && event.getAffectedEditor() == TarotViewsRepository.GamePlayers.players)	
						form.fireSelectionChanged(block.getMasterPart(), new StructuredSelection(event.getNewValue()));
				}
			});
		}
	}	
}
