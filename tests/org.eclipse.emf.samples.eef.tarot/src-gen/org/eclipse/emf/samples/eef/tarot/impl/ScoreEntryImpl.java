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
 * $Id: ScoreEntryImpl.java,v 1.1 2010/02/15 14:00:38 glefur Exp $
 */
package org.eclipse.emf.samples.eef.tarot.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.samples.eef.tarot.Game;
import org.eclipse.emf.samples.eef.tarot.Player;
import org.eclipse.emf.samples.eef.tarot.ScoreEntry;
import org.eclipse.emf.samples.eef.tarot.TarotPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Score Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.samples.eef.tarot.impl.ScoreEntryImpl#getGame <em>Game</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ScoreEntryImpl extends EObjectImpl implements ScoreEntry {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScoreEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TarotPackage.Literals.SCORE_ENTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Game getGame() {
		if (eContainerFeatureID() != TarotPackage.SCORE_ENTRY__GAME) return null;
		return (Game)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGame(Game newGame, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newGame, TarotPackage.SCORE_ENTRY__GAME, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGame(Game newGame) {
		if (newGame != eInternalContainer() || (eContainerFeatureID() != TarotPackage.SCORE_ENTRY__GAME && newGame != null)) {
			if (EcoreUtil.isAncestor(this, newGame))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newGame != null)
				msgs = ((InternalEObject)newGame).eInverseAdd(this, TarotPackage.GAME__ENTRIES, Game.class, msgs);
			msgs = basicSetGame(newGame, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TarotPackage.SCORE_ENTRY__GAME, newGame, newGame));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract int score(Player player);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int cumulativeScore(Player player) {
		EList<ScoreEntry> entries = getGame().getEntries();
		if (entries.indexOf(this) == 0)
			return score(player);
		else 
			return entries.get(entries.indexOf(this) - 1).cumulativeScore(player) + score(player);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TarotPackage.SCORE_ENTRY__GAME:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetGame((Game)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TarotPackage.SCORE_ENTRY__GAME:
				return basicSetGame(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case TarotPackage.SCORE_ENTRY__GAME:
				return eInternalContainer().eInverseRemove(this, TarotPackage.GAME__ENTRIES, Game.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TarotPackage.SCORE_ENTRY__GAME:
				return getGame();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TarotPackage.SCORE_ENTRY__GAME:
				setGame((Game)newValue);
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
			case TarotPackage.SCORE_ENTRY__GAME:
				setGame((Game)null);
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
			case TarotPackage.SCORE_ENTRY__GAME:
				return getGame() != null;
		}
		return super.eIsSet(featureID);
	}

} //ScoreEntryImpl
