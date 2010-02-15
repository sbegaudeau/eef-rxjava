/**
 * 
 */
package org.eclipse.emf.samples.eef.tarot.parts.forms;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.samples.eef.tarot.parts.TarotViewsRepository;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * @author glefur
 *
 */
public class GameScoreSpecificPropertiesEditionPartForm extends	GameScorePropertiesEditionPartForm {

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 */
	public GameScoreSpecificPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.samples.eef.tarot.parts.forms.GameScorePropertiesEditionPartForm#createEntriesTableComposition(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
	 */
	protected void createEntriesTableComposition(FormToolkit widgetFactory,	Composite parent) {
		super.createEntriesTableComposition(widgetFactory, parent);
		this.entries.addSelectionChangedListener(new ISelectionChangedListener() {
			
			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection() != null && event.getSelection() instanceof StructuredSelection && ((StructuredSelection)event.getSelection()).getFirstElement() instanceof EObject)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(GameScoreSpecificPropertiesEditionPartForm.this, TarotViewsRepository.GameScore.entries, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, entriesEditUtil.foundCorrespondingEObject((EObject)((StructuredSelection)event.getSelection()).getFirstElement()), -1));
			}
		});
	}
	
}
