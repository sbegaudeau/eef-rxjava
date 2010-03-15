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
import org.eclipse.emf.samples.eef.tarot.Game;
import org.eclipse.emf.samples.eef.tarot.parts.GamePlayersPropertiesEditionPart;
import org.eclipse.emf.samples.eef.tarot.parts.GameScorePropertiesEditionPart;
import org.eclipse.emf.samples.eef.tarot.parts.TarotViewsRepository;


// End of user code

/**
 * 
 * 
 */
public class GamePropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The GamePlayers part
	 * 
	 */
	private GamePlayersPropertiesEditionPart gamePlayersPart;

	/**
	 * The GameGamePlayersPropertiesEditionComponent sub component
	 * 
	 */
	protected GameGamePlayersPropertiesEditionComponent gameGamePlayersPropertiesEditionComponent;

	/**
	 * The GameScore part
	 * 
	 */
	private GameScorePropertiesEditionPart gameScorePart;

	/**
	 * The GameGameScorePropertiesEditionComponent sub component
	 * 
	 */
	protected GameGameScorePropertiesEditionComponent gameGameScorePropertiesEditionComponent;

	/**
	 * Parameterized constructor
	 * 
	 * @param game the EObject to edit
	 * 
	 */
	public GamePropertiesEditionComponent(EObject game, String editing_mode) {
		super(editing_mode);
		if (game instanceof Game) {
			IPropertiesEditionProvider provider = PropertiesEditionComponentService.getInstance().getProvider(game);
			gameGamePlayersPropertiesEditionComponent = (GameGamePlayersPropertiesEditionComponent)provider.getPropertiesEditionComponent(game, editing_mode, GameGamePlayersPropertiesEditionComponent.GAMEPLAYERS_PART);
			addSubComponent(gameGamePlayersPropertiesEditionComponent);
			gameGameScorePropertiesEditionComponent = (GameGameScorePropertiesEditionComponent)provider.getPropertiesEditionComponent(game, editing_mode, GameGameScorePropertiesEditionComponent.GAMESCORE_PART);
			addSubComponent(gameGameScorePropertiesEditionComponent);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      getPropertiesEditionPart(int, java.lang.String)
	 * 
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (GameGamePlayersPropertiesEditionComponent.GAMEPLAYERS_PART.equals(key)) {
			gamePlayersPart = (GamePlayersPropertiesEditionPart)gameGamePlayersPropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)gamePlayersPart;
		}
		if (GameGameScorePropertiesEditionComponent.GAMESCORE_PART.equals(key)) {
			gameScorePart = (GameScorePropertiesEditionPart)gameGameScorePropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)gameScorePart;
		}
		return super.getPropertiesEditionPart(kind, key);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      setPropertiesEditionPart(java.lang.Class, int,
	 *      org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart)
	 * 
	 */
	public void setPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionPart propertiesEditionPart) {
		if (TarotViewsRepository.GamePlayers.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			gamePlayersPart = (GamePlayersPropertiesEditionPart)propertiesEditionPart;
		}
		if (TarotViewsRepository.GameScore.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			gameScorePart = (GameScorePropertiesEditionPart)propertiesEditionPart;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(java.lang.Class key, int kind, EObject element, ResourceSet allResource) {
		if (key == TarotViewsRepository.GamePlayers.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == TarotViewsRepository.GameScore.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}
