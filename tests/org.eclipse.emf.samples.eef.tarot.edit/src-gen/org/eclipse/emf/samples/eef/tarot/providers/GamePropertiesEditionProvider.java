/**
 * Generated with Acceleo
 */
package org.eclipse.emf.samples.eef.tarot.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;
import org.eclipse.emf.samples.eef.tarot.Game;
import org.eclipse.emf.samples.eef.tarot.TarotPackage;
import org.eclipse.emf.samples.eef.tarot.components.GameGamePlayersPropertiesEditionComponent;
import org.eclipse.emf.samples.eef.tarot.components.GameGameScorePropertiesEditionComponent;
import org.eclipse.emf.samples.eef.tarot.components.GamePropertiesEditionComponent;

/**
 * 
 * 
 */
public class GamePropertiesEditionProvider implements IPropertiesEditionProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject)
	 * 
	 */
	public boolean provides(EObject eObject) {
		return (eObject instanceof Game) && (TarotPackage.eINSTANCE.getGame() == eObject.eClass());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject, java.lang.String)
	 * 
	 */
	public boolean provides(EObject eObject, String part) {
		return (eObject instanceof Game) && (GameGamePlayersPropertiesEditionComponent.GAMEPLAYERS_PART.equals(part) || GameGameScorePropertiesEditionComponent.GAMESCORE_PART.equals(part));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject, java.lang.Class)
	 * 
	 */
	public boolean provides(EObject eObject, java.lang.Class refinement) {
		return (eObject instanceof Game) && (refinement == GameGamePlayersPropertiesEditionComponent.class || refinement == GameGameScorePropertiesEditionComponent.class);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject, java.lang.String, java.lang.Class)
	 * 
	 */
	public boolean provides(EObject eObject, String part, java.lang.Class refinement) {
		return (eObject instanceof Game) && ((GameGamePlayersPropertiesEditionComponent.GAMEPLAYERS_PART.equals(part) && refinement == GameGamePlayersPropertiesEditionComponent.class) || (GameGameScorePropertiesEditionComponent.GAMESCORE_PART.equals(part) && refinement == GameGameScorePropertiesEditionComponent.class));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *  java.lang.String)
	 * 
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String editing_mode) {
		if (eObject instanceof Game) {
			return new GamePropertiesEditionComponent(eObject, editing_mode);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *  java.lang.String, java.lang.String)
	 * 
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String editing_mode, String part) {
		if (eObject instanceof Game) {
			if (GameGamePlayersPropertiesEditionComponent.GAMEPLAYERS_PART.equals(part))
				return new GameGamePlayersPropertiesEditionComponent(eObject, editing_mode);
			if (GameGameScorePropertiesEditionComponent.GAMESCORE_PART.equals(part))
				return new GameGameScorePropertiesEditionComponent(eObject, editing_mode);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *  java.lang.String, java.lang.String, java.lang.Class)
	 * 
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String editing_mode, String part, java.lang.Class refinement) {
		if (eObject instanceof Game) {
			if (GameGamePlayersPropertiesEditionComponent.GAMEPLAYERS_PART.equals(part)
				&& refinement == GameGamePlayersPropertiesEditionComponent.class)
				return new GameGamePlayersPropertiesEditionComponent(eObject, editing_mode);
			if (GameGameScorePropertiesEditionComponent.GAMESCORE_PART.equals(part)
				&& refinement == GameGameScorePropertiesEditionComponent.class)
				return new GameGameScorePropertiesEditionComponent(eObject, editing_mode);
		}
		return null;
	}

}
