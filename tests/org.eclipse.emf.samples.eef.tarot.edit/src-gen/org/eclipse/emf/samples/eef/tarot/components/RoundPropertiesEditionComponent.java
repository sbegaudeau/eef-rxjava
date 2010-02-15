/**
 * Generated with Acceleo
 */
package org.eclipse.emf.samples.eef.tarot.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionComponentService;
import org.eclipse.emf.samples.eef.tarot.Round;
import org.eclipse.emf.samples.eef.tarot.parts.RoundBonusesPropertiesEditionPart;
import org.eclipse.emf.samples.eef.tarot.parts.RoundScorePropertiesEditionPart;
import org.eclipse.emf.samples.eef.tarot.parts.RoundSettingsPropertiesEditionPart;
import org.eclipse.emf.samples.eef.tarot.parts.TarotViewsRepository;


// End of user code

/**
 * 
 */
public class RoundPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The Round settings part
	 */
	private RoundSettingsPropertiesEditionPart roundSettingsPart;

	/**
	 * The RoundRoundSettingsPropertiesEditionComponent sub component
	 */
	protected RoundRoundSettingsPropertiesEditionComponent roundRoundSettingsPropertiesEditionComponent;

	/**
	 * The Round bonuses part
	 */
	private RoundBonusesPropertiesEditionPart roundBonusesPart;

	/**
	 * The RoundRoundBonusesPropertiesEditionComponent sub component
	 */
	protected RoundRoundBonusesPropertiesEditionComponent roundRoundBonusesPropertiesEditionComponent;

	/**
	 * The Round score part
	 */
	private RoundScorePropertiesEditionPart roundScorePart;

	/**
	 * The RoundRoundScorePropertiesEditionComponent sub component
	 */
	protected RoundRoundScorePropertiesEditionComponent roundRoundScorePropertiesEditionComponent;

	/**
	 * Parameterized constructor
	 * 
	 * @param round
	 *            the EObject to edit
	 */
	public RoundPropertiesEditionComponent(EObject round, String editing_mode) {
		super(editing_mode);
		if (round instanceof Round) {
			IPropertiesEditionProvider provider = PropertiesEditionComponentService.getInstance().getProvider(round);
			roundRoundSettingsPropertiesEditionComponent = (RoundRoundSettingsPropertiesEditionComponent)provider.getPropertiesEditionComponent(round, editing_mode, RoundRoundSettingsPropertiesEditionComponent.ROUNDSETTINGS_PART);
			addSubComponent(roundRoundSettingsPropertiesEditionComponent);
			roundRoundBonusesPropertiesEditionComponent = (RoundRoundBonusesPropertiesEditionComponent)provider.getPropertiesEditionComponent(round, editing_mode, RoundRoundBonusesPropertiesEditionComponent.ROUNDBONUSES_PART);
			addSubComponent(roundRoundBonusesPropertiesEditionComponent);
			roundRoundScorePropertiesEditionComponent = (RoundRoundScorePropertiesEditionComponent)provider.getPropertiesEditionComponent(round, editing_mode, RoundRoundScorePropertiesEditionComponent.ROUNDSCORE_PART);
			addSubComponent(roundRoundScorePropertiesEditionComponent);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      getPropertiesEditionPart(int, java.lang.String)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (RoundRoundSettingsPropertiesEditionComponent.ROUNDSETTINGS_PART.equals(key)) {
			roundSettingsPart = (RoundSettingsPropertiesEditionPart)roundRoundSettingsPropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)roundSettingsPart;
		}
		if (RoundRoundBonusesPropertiesEditionComponent.ROUNDBONUSES_PART.equals(key)) {
			roundBonusesPart = (RoundBonusesPropertiesEditionPart)roundRoundBonusesPropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)roundBonusesPart;
		}
		if (RoundRoundScorePropertiesEditionComponent.ROUNDSCORE_PART.equals(key)) {
			roundScorePart = (RoundScorePropertiesEditionPart)roundRoundScorePropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)roundScorePart;
		}
		return super.getPropertiesEditionPart(kind, key);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      setPropertiesEditionPart(java.lang.Class, int,
	 *      org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart)
	 */
	public void setPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionPart propertiesEditionPart) {
		if (TarotViewsRepository.RoundSettings.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			roundSettingsPart = (RoundSettingsPropertiesEditionPart)propertiesEditionPart;
		}
		if (TarotViewsRepository.RoundBonuses.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			roundBonusesPart = (RoundBonusesPropertiesEditionPart)propertiesEditionPart;
		}
		if (TarotViewsRepository.RoundScore.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			roundScorePart = (RoundScorePropertiesEditionPart)propertiesEditionPart;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject element, ResourceSet allResource) {
		if (key == TarotViewsRepository.RoundSettings.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == TarotViewsRepository.RoundBonuses.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == TarotViewsRepository.RoundScore.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}
