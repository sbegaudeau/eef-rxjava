/**
 * 
 */
package org.eclipse.emf.samples.eef.tarot.utils;

import org.eclipse.emf.samples.eef.tarot.BID;
import org.eclipse.emf.samples.eef.tarot.Round;

/**
 * @author glefur
 * 
 */
public class TarotUIHelper {

	public static String roundLabel(Round round) {
		String label = bidLabel(round.getBid()) + " (";
		if (round.getTaker() != null)
			label += round.getTaker().getName();
		else 
			label += "???";
		if (round.getPartner() != null)
			label += '/' + round.getPartner().getName();
		label += ") : " + String.valueOf(round.getScore());
		return label;
	}
	
    private static String bidLabel(BID bid) {
    	return bid.toString().charAt(0) + bid.toString().substring(1).replaceAll("_", " ").toLowerCase();
    }

}
