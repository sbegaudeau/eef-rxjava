/**
 * 
 */
package org.eclipse.emf.samples.eef.tarot.providers;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.samples.eef.tarot.parts.TarotViewsRepository;
import org.eclipse.emf.samples.eef.tarot.parts.forms.GamePlayersSpecificPropertiesEditionPartForm;
import org.eclipse.emf.samples.eef.tarot.parts.forms.GameScoreSpecificPropertiesEditionPartForm;

/**
 * @author glefur
 *
 */
public class TarotSpecificPropertiesEditionPartProvider extends TarotPropertiesEditionPartProvider {

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.samples.eef.tarot.providers.TarotPropertiesEditionPartProvider#getPropertiesEditionPart(java.lang.Class, int, org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent)
	 */
	@Override
	public IPropertiesEditionPart getPropertiesEditionPart(Class key, int kind,	IPropertiesEditionComponent component) {
		if (key == TarotViewsRepository.GamePlayers.class) {
			if (kind == TarotViewsRepository.FORM_KIND)
				return new GamePlayersSpecificPropertiesEditionPartForm(component);
		}
		if (key == TarotViewsRepository.GameScore.class) {
			if (kind == TarotViewsRepository.FORM_KIND)
				return new GameScoreSpecificPropertiesEditionPartForm(component);
		}
		return super.getPropertiesEditionPart(key, kind, component);
	}

	
	
}
