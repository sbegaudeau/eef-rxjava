/**
 * 
 */
package org.eclipse.emf.samples.eef.tarot.providers;

/**
 * @author glefur
 *
 */
public class TarotPackageCustomPropertiesEditionProvider extends TarotPackagePropertiesEditionProvider {
	
	/**
	 * This creates an PropertiesEditionProvider for a Game
	 */
	public GamePropertiesEditionProvider createGamePropertiesEditionProvider() {
		if (gamePropertiesEditionProvider == null)
			gamePropertiesEditionProvider = new GameCustomPropertiesEditionProvider();
		return gamePropertiesEditionProvider;
	}



}
