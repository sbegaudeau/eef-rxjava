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
 *
 * $Id: RoundImpl.java,v 1.1 2010/02/15 14:00:38 glefur Exp $
 */
package org.eclipse.emf.samples.eef.tarot.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.samples.eef.tarot.BID;
import org.eclipse.emf.samples.eef.tarot.Bonus;
import org.eclipse.emf.samples.eef.tarot.Handful;
import org.eclipse.emf.samples.eef.tarot.LeastAtLast;
import org.eclipse.emf.samples.eef.tarot.PLAYER_SIDE;
import org.eclipse.emf.samples.eef.tarot.Player;
import org.eclipse.emf.samples.eef.tarot.Round;
import org.eclipse.emf.samples.eef.tarot.Slam;
import org.eclipse.emf.samples.eef.tarot.TarotPackage;
import org.eclipse.emf.samples.eef.tarot.util.TarotHelper;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Round</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.samples.eef.tarot.impl.RoundImpl#getBid <em>Bid</em>}</li>
 *   <li>{@link org.eclipse.emf.samples.eef.tarot.impl.RoundImpl#getTaker <em>Taker</em>}</li>
 *   <li>{@link org.eclipse.emf.samples.eef.tarot.impl.RoundImpl#getPartner <em>Partner</em>}</li>
 *   <li>{@link org.eclipse.emf.samples.eef.tarot.impl.RoundImpl#getBonuses <em>Bonuses</em>}</li>
 *   <li>{@link org.eclipse.emf.samples.eef.tarot.impl.RoundImpl#getExtraPoints <em>Extra Points</em>}</li>
 *   <li>{@link org.eclipse.emf.samples.eef.tarot.impl.RoundImpl#getScore <em>Score</em>}</li>
 *   <li>{@link org.eclipse.emf.samples.eef.tarot.impl.RoundImpl#isWon <em>Won</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RoundImpl extends ScoreEntryImpl implements Round {
	/**
	 * The default value of the '{@link #getBid() <em>Bid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBid()
	 * @generated
	 * @ordered
	 */
	protected static final BID BID_EDEFAULT = BID.SMALL;

	/**
	 * The cached value of the '{@link #getBid() <em>Bid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBid()
	 * @generated
	 * @ordered
	 */
	protected BID bid = BID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTaker() <em>Taker</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaker()
	 * @generated
	 * @ordered
	 */
	protected Player taker;

	/**
	 * The cached value of the '{@link #getPartner() <em>Partner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartner()
	 * @generated
	 * @ordered
	 */
	protected Player partner;

	/**
	 * The cached value of the '{@link #getBonuses() <em>Bonuses</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBonuses()
	 * @generated
	 * @ordered
	 */
	protected EList<Bonus> bonuses;

	/**
	 * The default value of the '{@link #getExtraPoints() <em>Extra Points</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtraPoints()
	 * @generated
	 * @ordered
	 */
	protected static final int EXTRA_POINTS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getExtraPoints() <em>Extra Points</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtraPoints()
	 * @generated
	 * @ordered
	 */
	protected int extraPoints = EXTRA_POINTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getScore() <em>Score</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScore()
	 * @generated
	 * @ordered
	 */
	protected static final int SCORE_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #isWon() <em>Won</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWon()
	 * @generated
	 * @ordered
	 */
	protected static final boolean WON_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isWon() <em>Won</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWon()
	 * @generated
	 * @ordered
	 */
	protected boolean won = WON_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoundImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TarotPackage.Literals.ROUND;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BID getBid() {
		return bid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBid(BID newBid) {
		BID oldBid = bid;
		bid = newBid == null ? BID_EDEFAULT : newBid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TarotPackage.ROUND__BID, oldBid, bid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Player getTaker() {
		if (taker != null && taker.eIsProxy()) {
			InternalEObject oldTaker = (InternalEObject)taker;
			taker = (Player)eResolveProxy(oldTaker);
			if (taker != oldTaker) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TarotPackage.ROUND__TAKER, oldTaker, taker));
			}
		}
		return taker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Player basicGetTaker() {
		return taker;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTaker(Player newTaker) {
		Player oldTaker = taker;
		taker = newTaker;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TarotPackage.ROUND__TAKER, oldTaker, taker));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Player getPartner() {
		if (partner != null && partner.eIsProxy()) {
			InternalEObject oldPartner = (InternalEObject)partner;
			partner = (Player)eResolveProxy(oldPartner);
			if (partner != oldPartner) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TarotPackage.ROUND__PARTNER, oldPartner, partner));
			}
		}
		return partner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Player basicGetPartner() {
		return partner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPartner(Player newPartner) {
		Player oldPartner = partner;
		partner = newPartner;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TarotPackage.ROUND__PARTNER, oldPartner, partner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Bonus> getBonuses() {
		if (bonuses == null) {
			bonuses = new EObjectContainmentEList<Bonus>(Bonus.class, this, TarotPackage.ROUND__BONUSES);
		}
		return bonuses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getExtraPoints() {
		return extraPoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtraPoints(int newExtraPoints) {
		int oldExtraPoints = extraPoints;
		extraPoints = newExtraPoints;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TarotPackage.ROUND__EXTRA_POINTS, oldExtraPoints, extraPoints));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getScore() {
		int score = 0;
		score = (TarotHelper.ROUND_BASE_SCORE + getExtraPoints() + leastAtLastScore()) * TarotHelper.bidMultiplier(getBid());
		for (Bonus bonus : getBonuses()) {
			if (bonus instanceof Handful) {
				Handful handful = (Handful) bonus;
				if (handful.getSide() == PLAYER_SIDE.ATTACK)
					score += TarotHelper.handfulScore(handful.getSize());
				else
					score -= TarotHelper.handfulScore(handful.getSize());
			}
			else if (bonus instanceof Slam) {
				Slam slam = (Slam)bonus;
				score += TarotHelper.slamScore(slam);
			}
		}
		return score;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isWon() {
		return won;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWon(boolean newWon) {
		boolean oldWon = won;
		won = newWon;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TarotPackage.ROUND__WON, oldWon, won));
	}

	private int leastAtLastScore() {
		for (Bonus bonus : getBonuses()) {
			if (bonus instanceof LeastAtLast) {
				if (((LeastAtLast)bonus).getSide() == PLAYER_SIDE.ATTACK)
					return 10;
				else
					return -10;
			}
		}
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TarotPackage.ROUND__BONUSES:
				return ((InternalEList<?>)getBonuses()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TarotPackage.ROUND__BID:
				return getBid();
			case TarotPackage.ROUND__TAKER:
				if (resolve) return getTaker();
				return basicGetTaker();
			case TarotPackage.ROUND__PARTNER:
				if (resolve) return getPartner();
				return basicGetPartner();
			case TarotPackage.ROUND__BONUSES:
				return getBonuses();
			case TarotPackage.ROUND__EXTRA_POINTS:
				return getExtraPoints();
			case TarotPackage.ROUND__SCORE:
				return getScore();
			case TarotPackage.ROUND__WON:
				return isWon();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TarotPackage.ROUND__BID:
				setBid((BID)newValue);
				return;
			case TarotPackage.ROUND__TAKER:
				setTaker((Player)newValue);
				return;
			case TarotPackage.ROUND__PARTNER:
				setPartner((Player)newValue);
				return;
			case TarotPackage.ROUND__BONUSES:
				getBonuses().clear();
				getBonuses().addAll((Collection<? extends Bonus>)newValue);
				return;
			case TarotPackage.ROUND__EXTRA_POINTS:
				setExtraPoints((Integer)newValue);
				return;
			case TarotPackage.ROUND__WON:
				setWon((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TarotPackage.ROUND__BID:
				setBid(BID_EDEFAULT);
				return;
			case TarotPackage.ROUND__TAKER:
				setTaker((Player)null);
				return;
			case TarotPackage.ROUND__PARTNER:
				setPartner((Player)null);
				return;
			case TarotPackage.ROUND__BONUSES:
				getBonuses().clear();
				return;
			case TarotPackage.ROUND__EXTRA_POINTS:
				setExtraPoints(EXTRA_POINTS_EDEFAULT);
				return;
			case TarotPackage.ROUND__WON:
				setWon(WON_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TarotPackage.ROUND__BID:
				return bid != BID_EDEFAULT;
			case TarotPackage.ROUND__TAKER:
				return taker != null;
			case TarotPackage.ROUND__PARTNER:
				return partner != null;
			case TarotPackage.ROUND__BONUSES:
				return bonuses != null && !bonuses.isEmpty();
			case TarotPackage.ROUND__EXTRA_POINTS:
				return extraPoints != EXTRA_POINTS_EDEFAULT;
			case TarotPackage.ROUND__SCORE:
				return getScore() != SCORE_EDEFAULT;
			case TarotPackage.ROUND__WON:
				return won != WON_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (bid: ");
		result.append(bid);
		result.append(", extraPoints: ");
		result.append(extraPoints);
		result.append(", won: ");
		result.append(won);
		result.append(')');
		return result.toString();
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.samples.eef.tarot.impl.ScoreEntryImpl#score(org.eclipse.emf.samples.eef.tarot.Player)
	 */
	public int score(Player player) {
		int score = 0;
		int playersCount = getGame().getPlayers().size();
		if (playersCount == 3) {
			if (player.equals(getTaker()))
				score = isWon()?getScore() * 2:-getScore() * 2;
			else
				score = isWon()?-getScore():getScore();
		}
		else if (playersCount == 4) {
			if (player.equals(getTaker()))
				score = isWon()?getScore() * 3:-getScore() * 3;
			else
				score = isWon()?-getScore():getScore();
		}
		else if (playersCount == 5) {
			if (player.equals(getTaker())) {
				if (getPartner() == null)
					score = isWon()?getScore() * 4:-getScore() * 4;
				else 
					score = isWon()?getScore() * 2:-getScore() * 2;
			}
			else if (player.equals(getPartner()))
				score = isWon()?getScore():-getScore();
			else
				score = isWon()?-getScore():getScore();
		}
		return score;
	}
	
} //RoundImpl
