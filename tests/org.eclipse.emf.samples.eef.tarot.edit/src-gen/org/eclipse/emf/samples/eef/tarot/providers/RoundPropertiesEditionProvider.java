/**
 * Generated with Acceleo
 */
package org.eclipse.emf.samples.eef.tarot.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;
import org.eclipse.emf.samples.eef.tarot.Round;
import org.eclipse.emf.samples.eef.tarot.TarotPackage;
import org.eclipse.emf.samples.eef.tarot.components.RoundPropertiesEditionComponent;
import org.eclipse.emf.samples.eef.tarot.components.RoundRoundBonusesPropertiesEditionComponent;
import org.eclipse.emf.samples.eef.tarot.components.RoundRoundScorePropertiesEditionComponent;
import org.eclipse.emf.samples.eef.tarot.components.RoundRoundSettingsPropertiesEditionComponent;

/**
 * 
 */
public class RoundPropertiesEditionProvider implements IPropertiesEditionProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject)
	 */
	public boolean provides(EObject eObject) {
		return (eObject instanceof Round) && (TarotPackage.eINSTANCE.getRound() == eObject.eClass());
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject, java.lang.String)
	 */
	public boolean provides(EObject eObject, String part) {
		return provides(eObject)&& (RoundRoundSettingsPropertiesEditionComponent.ROUNDSETTINGS_PART.equals(part) || RoundRoundBonusesPropertiesEditionComponent.ROUNDBONUSES_PART.equals(part) || RoundRoundScorePropertiesEditionComponent.ROUNDSCORE_PART.equals(part));
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *  java.lang.String)
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String editing_mode) {
		if (eObject instanceof Round) {
			return new RoundPropertiesEditionComponent(eObject, editing_mode);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *  java.lang.String, java.lang.String)
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String editing_mode, String part) {
		if (eObject instanceof Round) {
			if (RoundRoundSettingsPropertiesEditionComponent.ROUNDSETTINGS_PART.equals(part))
				return new RoundRoundSettingsPropertiesEditionComponent(eObject, editing_mode);
			if (RoundRoundBonusesPropertiesEditionComponent.ROUNDBONUSES_PART.equals(part))
				return new RoundRoundBonusesPropertiesEditionComponent(eObject, editing_mode);
			if (RoundRoundScorePropertiesEditionComponent.ROUNDSCORE_PART.equals(part))
				return new RoundRoundScorePropertiesEditionComponent(eObject, editing_mode);
		}
		return null;
	}

}
