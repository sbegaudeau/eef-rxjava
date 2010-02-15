/**
 * 
 */
package org.eclipse.emf.samples.eef.tarot.parts.components;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.samples.eef.tarot.TarotPackage;
import org.eclipse.emf.samples.eef.tarot.components.GameGameScorePropertiesEditionComponent;

/**
 * @author glefur
 *
 */
public class GameGameScoreCustomPropertiesEditionComponent extends	GameGameScorePropertiesEditionComponent {

	/**
	 * @param game
	 * @param editingMode
	 */
	public GameGameScoreCustomPropertiesEditionComponent(EObject game, String editingMode) {
		super(game, editingMode);
	}
	
	/**
	 * Used to update the views
	 */
	protected void runUpdateRunnable(final Notification msg) {
		if (msg.getFeature() != null && 
				(((EStructuralFeature)msg.getFeature()) == TarotPackage.eINSTANCE.getGame_Players()
					||((EStructuralFeature)msg.getFeature()) == TarotPackage.eINSTANCE.getPlayer_Name())) {
			gameScorePart.updatePlayerColumns(msg);
		}
		super.runUpdateRunnable(msg);

	}

}
