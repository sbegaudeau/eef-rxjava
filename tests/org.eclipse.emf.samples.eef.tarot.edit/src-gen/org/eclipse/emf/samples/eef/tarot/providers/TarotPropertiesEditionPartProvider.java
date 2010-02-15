/**
 * Generated with Acceleo
 */
package org.eclipse.emf.samples.eef.tarot.providers;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.samples.eef.tarot.parts.TarotViewsRepository;
import org.eclipse.emf.samples.eef.tarot.parts.forms.GamePlayersPropertiesEditionPartForm;
import org.eclipse.emf.samples.eef.tarot.parts.forms.GameScorePropertiesEditionPartForm;
import org.eclipse.emf.samples.eef.tarot.parts.forms.HandfulPropertiesEditionPartForm;
import org.eclipse.emf.samples.eef.tarot.parts.forms.LeastAtLastPropertiesEditionPartForm;
import org.eclipse.emf.samples.eef.tarot.parts.forms.MiserePropertiesEditionPartForm;
import org.eclipse.emf.samples.eef.tarot.parts.forms.PlayerPropertiesEditionPartForm;
import org.eclipse.emf.samples.eef.tarot.parts.forms.RoundBonusesPropertiesEditionPartForm;
import org.eclipse.emf.samples.eef.tarot.parts.forms.RoundScorePropertiesEditionPartForm;
import org.eclipse.emf.samples.eef.tarot.parts.forms.RoundSettingsPropertiesEditionPartForm;
import org.eclipse.emf.samples.eef.tarot.parts.forms.SlamPropertiesEditionPartForm;
import org.eclipse.emf.samples.eef.tarot.parts.impl.GamePlayersPropertiesEditionPartImpl;
import org.eclipse.emf.samples.eef.tarot.parts.impl.GameScorePropertiesEditionPartImpl;
import org.eclipse.emf.samples.eef.tarot.parts.impl.HandfulPropertiesEditionPartImpl;
import org.eclipse.emf.samples.eef.tarot.parts.impl.LeastAtLastPropertiesEditionPartImpl;
import org.eclipse.emf.samples.eef.tarot.parts.impl.MiserePropertiesEditionPartImpl;
import org.eclipse.emf.samples.eef.tarot.parts.impl.PlayerPropertiesEditionPartImpl;
import org.eclipse.emf.samples.eef.tarot.parts.impl.RoundBonusesPropertiesEditionPartImpl;
import org.eclipse.emf.samples.eef.tarot.parts.impl.RoundScorePropertiesEditionPartImpl;
import org.eclipse.emf.samples.eef.tarot.parts.impl.RoundSettingsPropertiesEditionPartImpl;
import org.eclipse.emf.samples.eef.tarot.parts.impl.SlamPropertiesEditionPartImpl;

/**
 * 
 *
 */
public class TarotPropertiesEditionPartProvider implements IPropertiesEditionPartProvider {

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#provides(java.lang.Class)
	 */
	public boolean provides(java.lang.Class key) {
		return key == TarotViewsRepository.class;
	}

	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#getPropertiesEditionPart(java.lang.Class, int, org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionComponent component) {
		if (key == TarotViewsRepository.GamePlayers.class) {
			if (kind == TarotViewsRepository.SWT_KIND)
				return new GamePlayersPropertiesEditionPartImpl(component);
			if (kind == TarotViewsRepository.FORM_KIND)
				return new GamePlayersPropertiesEditionPartForm(component);
		}
		if (key == TarotViewsRepository.GameScore.class) {
			if (kind == TarotViewsRepository.SWT_KIND)
				return new GameScorePropertiesEditionPartImpl(component);
			if (kind == TarotViewsRepository.FORM_KIND)
				return new GameScorePropertiesEditionPartForm(component);
		}
		if (key == TarotViewsRepository.Player.class) {
			if (kind == TarotViewsRepository.SWT_KIND)
				return new PlayerPropertiesEditionPartImpl(component);
			if (kind == TarotViewsRepository.FORM_KIND)
				return new PlayerPropertiesEditionPartForm(component);
		}
		if (key == TarotViewsRepository.RoundSettings.class) {
			if (kind == TarotViewsRepository.SWT_KIND)
				return new RoundSettingsPropertiesEditionPartImpl(component);
			if (kind == TarotViewsRepository.FORM_KIND)
				return new RoundSettingsPropertiesEditionPartForm(component);
		}
		if (key == TarotViewsRepository.RoundBonuses.class) {
			if (kind == TarotViewsRepository.SWT_KIND)
				return new RoundBonusesPropertiesEditionPartImpl(component);
			if (kind == TarotViewsRepository.FORM_KIND)
				return new RoundBonusesPropertiesEditionPartForm(component);
		}
		if (key == TarotViewsRepository.RoundScore.class) {
			if (kind == TarotViewsRepository.SWT_KIND)
				return new RoundScorePropertiesEditionPartImpl(component);
			if (kind == TarotViewsRepository.FORM_KIND)
				return new RoundScorePropertiesEditionPartForm(component);
		}
		if (key == TarotViewsRepository.Misere.class) {
			if (kind == TarotViewsRepository.SWT_KIND)
				return new MiserePropertiesEditionPartImpl(component);
			if (kind == TarotViewsRepository.FORM_KIND)
				return new MiserePropertiesEditionPartForm(component);
		}
		if (key == TarotViewsRepository.Handful.class) {
			if (kind == TarotViewsRepository.SWT_KIND)
				return new HandfulPropertiesEditionPartImpl(component);
			if (kind == TarotViewsRepository.FORM_KIND)
				return new HandfulPropertiesEditionPartForm(component);
		}
		if (key == TarotViewsRepository.LeastAtLast.class) {
			if (kind == TarotViewsRepository.SWT_KIND)
				return new LeastAtLastPropertiesEditionPartImpl(component);
			if (kind == TarotViewsRepository.FORM_KIND)
				return new LeastAtLastPropertiesEditionPartForm(component);
		}
		if (key == TarotViewsRepository.Slam.class) {
			if (kind == TarotViewsRepository.SWT_KIND)
				return new SlamPropertiesEditionPartImpl(component);
			if (kind == TarotViewsRepository.FORM_KIND)
				return new SlamPropertiesEditionPartForm(component);
		}
		return null;
	}

}
