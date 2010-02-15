/**
 * 
 */
package org.eclipse.emf.samples.eef.tarot.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.samples.eef.tarot.Game;
import org.eclipse.emf.samples.eef.tarot.components.GameGameScorePropertiesEditionComponent;
import org.eclipse.emf.samples.eef.tarot.parts.components.GameGameScoreCustomPropertiesEditionComponent;

/**
 * @author glefur
 *
 */
public class GameCustomPropertiesEditionProvider extends GamePropertiesEditionProvider {

	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *  java.lang.String, java.lang.String)
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String editing_mode, String part) {
		if (eObject instanceof Game) {
			if (GameGameScorePropertiesEditionComponent.GAMESCORE_PART.equals(part))
				return new GameGameScoreCustomPropertiesEditionComponent(eObject, editing_mode);
		}
		return super.getPropertiesEditionComponent(eObject, editing_mode, part);
	}


}
