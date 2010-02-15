/**
 * Generated with Acceleo
 */
package org.eclipse.emf.samples.eef.tarot.providers;

import org.eclipse.emf.eef.runtime.impl.providers.ComposedPropertiesEditionProvider;

/**
 * 
 */
public class TarotPackagePropertiesEditionProvider extends ComposedPropertiesEditionProvider {

	/**
	 * Default Constructor
	 */
	public TarotPackagePropertiesEditionProvider() {
		super();
		append(createGamePropertiesEditionProvider());
		append(createPlayerPropertiesEditionProvider());
		append(createRoundPropertiesEditionProvider());
		append(createMiserePropertiesEditionProvider());
		append(createHandfulPropertiesEditionProvider());
		append(createLeastAtLastPropertiesEditionProvider());
		append(createSlamPropertiesEditionProvider());
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Game instances.
	 */
	protected GamePropertiesEditionProvider gamePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Game
	 */
	public GamePropertiesEditionProvider createGamePropertiesEditionProvider() {
		if (gamePropertiesEditionProvider == null)
			gamePropertiesEditionProvider = new GamePropertiesEditionProvider();
		return gamePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Player instances.
	 */
	protected PlayerPropertiesEditionProvider playerPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Player
	 */
	public PlayerPropertiesEditionProvider createPlayerPropertiesEditionProvider() {
		if (playerPropertiesEditionProvider == null)
			playerPropertiesEditionProvider = new PlayerPropertiesEditionProvider();
		return playerPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Round instances.
	 */
	protected RoundPropertiesEditionProvider roundPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Round
	 */
	public RoundPropertiesEditionProvider createRoundPropertiesEditionProvider() {
		if (roundPropertiesEditionProvider == null)
			roundPropertiesEditionProvider = new RoundPropertiesEditionProvider();
		return roundPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Misere instances.
	 */
	protected MiserePropertiesEditionProvider miserePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Misere
	 */
	public MiserePropertiesEditionProvider createMiserePropertiesEditionProvider() {
		if (miserePropertiesEditionProvider == null)
			miserePropertiesEditionProvider = new MiserePropertiesEditionProvider();
		return miserePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Handful instances.
	 */
	protected HandfulPropertiesEditionProvider handfulPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Handful
	 */
	public HandfulPropertiesEditionProvider createHandfulPropertiesEditionProvider() {
		if (handfulPropertiesEditionProvider == null)
			handfulPropertiesEditionProvider = new HandfulPropertiesEditionProvider();
		return handfulPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * LeastAtLast instances.
	 */
	protected LeastAtLastPropertiesEditionProvider leastAtLastPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a LeastAtLast
	 */
	public LeastAtLastPropertiesEditionProvider createLeastAtLastPropertiesEditionProvider() {
		if (leastAtLastPropertiesEditionProvider == null)
			leastAtLastPropertiesEditionProvider = new LeastAtLastPropertiesEditionProvider();
		return leastAtLastPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Slam instances.
	 */
	protected SlamPropertiesEditionProvider slamPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Slam
	 */
	public SlamPropertiesEditionProvider createSlamPropertiesEditionProvider() {
		if (slamPropertiesEditionProvider == null)
			slamPropertiesEditionProvider = new SlamPropertiesEditionProvider();
		return slamPropertiesEditionProvider;
	}

}
