/**
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 * 
 * $Id: TarotHelper.java,v 1.1 2010/02/15 14:00:39 glefur Exp $
 */
package org.eclipse.emf.samples.eef.tarot.util;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.samples.eef.tarot.BID;
import org.eclipse.emf.samples.eef.tarot.Game;
import org.eclipse.emf.samples.eef.tarot.HANDFUL_SIZE;
import org.eclipse.emf.samples.eef.tarot.PLAYER_SIDE;
import org.eclipse.emf.samples.eef.tarot.Player;
import org.eclipse.emf.samples.eef.tarot.Round;
import org.eclipse.emf.samples.eef.tarot.Slam;

/**
 * 
 * @author <a href="mailto:goulwen.lefur@obeo.fr>Goulwen Le Fur</a>
 */
public class TarotHelper {
	
	/**
	 * The base score for a tarot round is 25. 
	 */
	public static final int ROUND_BASE_SCORE = 25;
	
	/**
	 * The base score for a misere is 10
	 */
	public static final int MISERE_BASE_SCORE = 10;

	/**
	 * Binding between tarot bidding and the associated multiplier.
	 * @param bid the round bid
	 * @return the multiplier
	 */
	public static int bidMultiplier(BID bid) {
		int multiplier = 1;
		switch (bid) {
		case GUARD:
			multiplier = 2;
			break;
		case GUARD_WITHOUT:
			multiplier = 4;
			break;
		case GUARD_AGAINST:
			multiplier = 6;
			break;
		}
		return multiplier;
	}
	
	/**
	 * Binding between handful size and the associated score.
	 * @param size the handful size
	 * @return the score
	 */
	public static int handfulScore(HANDFUL_SIZE size) {
		int score = 20;
		switch (size) {
		case DOUBLE:
			score = 30;
			break;
		case TRIPLE:
			score = 40;
			break;
		}
		return score;
	}
	
	/**
	 * Defines the score of a slam.
	 * @param slam the interesting slam
	 * @return the score of the slam
	 */
	public static int slamScore(Slam slam) {
		int score = 0;
		if (slam.isAnnounced()) {
			if (slam.isAchieved())
				score = 400;
			else
				score = -200;
		}
		else {
			if (slam.isAchieved())
				score = 200;
		}
		return score;
	}

	
	/**
	 * Defines the side of a player for a round.
	 * @param round the interesting round
	 * @param toTest the player to test
	 * @return a <code>PLAYER_SIDE</code> defining the side of the player
	 */
	public static PLAYER_SIDE playerSide(Round round, Player toTest) {
		if (toTest.equals(round.getTaker()) || (round.getPartner() != null && toTest.equals(round.getPartner())))
			return PLAYER_SIDE.ATTACK;
		else
			return PLAYER_SIDE.DEFENSE;

	}
	
	/**
	 * Find the first Tarot {@link Game} in the {@link ResourceSet}.
	 * @param rset the resource set to process
	 * @return the Game to process
	 */
	public static Game findFirstGameInstance(ResourceSet rset) {
		TreeIterator<Notifier> allContents = rset.getAllContents();
		while (allContents.hasNext()) {
			Notifier next = allContents.next();
			if (next instanceof Game)
				return (Game)next;
		}
		return null;
	}

}
