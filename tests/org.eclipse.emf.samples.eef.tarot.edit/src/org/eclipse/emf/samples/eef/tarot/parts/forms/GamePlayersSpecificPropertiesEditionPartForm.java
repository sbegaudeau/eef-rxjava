/**
 * 
 */
package org.eclipse.emf.samples.eef.tarot.parts.forms;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.samples.eef.tarot.parts.TarotViewsRepository;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * @author glefur
 *
 */
public class GamePlayersSpecificPropertiesEditionPartForm extends GamePlayersPropertiesEditionPartForm {

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public GamePlayersSpecificPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.samples.eef.tarot.parts.forms.GamePlayersPropertiesEditionPartForm#createPlayersTableComposition(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
	 */
	protected void createPlayersTableComposition(FormToolkit widgetFactory, Composite parent) {
		super.createPlayersTableComposition(widgetFactory, parent);
		this.players.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GamePlayersSpecificPropertiesEditionPartForm.this, TarotViewsRepository.GamePlayers.players, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, playersEditUtil.foundCorrespondingEObject((EObject)e.item.getData()), -1));
			}
			
		});
	}

	
	
}
