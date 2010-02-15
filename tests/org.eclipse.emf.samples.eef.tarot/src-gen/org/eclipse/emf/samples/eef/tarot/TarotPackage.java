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
 * $Id: TarotPackage.java,v 1.1 2010/02/15 14:00:38 glefur Exp $
 */
package org.eclipse.emf.samples.eef.tarot;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.samples.eef.tarot.TarotFactory
 * @model kind="package"
 * @generated
 */
public interface TarotPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "tarot";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/emf/samples/tarot/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tarot";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TarotPackage eINSTANCE = org.eclipse.emf.samples.eef.tarot.impl.TarotPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.samples.eef.tarot.impl.GameImpl <em>Game</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.samples.eef.tarot.impl.GameImpl
	 * @see org.eclipse.emf.samples.eef.tarot.impl.TarotPackageImpl#getGame()
	 * @generated
	 */
	int GAME = 0;

	/**
	 * The feature id for the '<em><b>Players</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME__PLAYERS = 0;

	/**
	 * The feature id for the '<em><b>Entries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME__ENTRIES = 1;

	/**
	 * The number of structural features of the '<em>Game</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAME_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.samples.eef.tarot.impl.PlayerImpl <em>Player</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.samples.eef.tarot.impl.PlayerImpl
	 * @see org.eclipse.emf.samples.eef.tarot.impl.TarotPackageImpl#getPlayer()
	 * @generated
	 */
	int PLAYER = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Pics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER__PICS = 1;

	/**
	 * The number of structural features of the '<em>Player</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.samples.eef.tarot.impl.ScoreEntryImpl <em>Score Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.samples.eef.tarot.impl.ScoreEntryImpl
	 * @see org.eclipse.emf.samples.eef.tarot.impl.TarotPackageImpl#getScoreEntry()
	 * @generated
	 */
	int SCORE_ENTRY = 7;

	/**
	 * The feature id for the '<em><b>Game</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORE_ENTRY__GAME = 0;

	/**
	 * The number of structural features of the '<em>Score Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORE_ENTRY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.samples.eef.tarot.impl.RoundImpl <em>Round</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.samples.eef.tarot.impl.RoundImpl
	 * @see org.eclipse.emf.samples.eef.tarot.impl.TarotPackageImpl#getRound()
	 * @generated
	 */
	int ROUND = 2;

	/**
	 * The feature id for the '<em><b>Game</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND__GAME = SCORE_ENTRY__GAME;

	/**
	 * The feature id for the '<em><b>Bid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND__BID = SCORE_ENTRY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Taker</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND__TAKER = SCORE_ENTRY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Partner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND__PARTNER = SCORE_ENTRY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Bonuses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND__BONUSES = SCORE_ENTRY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Extra Points</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND__EXTRA_POINTS = SCORE_ENTRY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND__SCORE = SCORE_ENTRY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Won</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND__WON = SCORE_ENTRY_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Round</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND_FEATURE_COUNT = SCORE_ENTRY_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.samples.eef.tarot.impl.BonusImpl <em>Bonus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.samples.eef.tarot.impl.BonusImpl
	 * @see org.eclipse.emf.samples.eef.tarot.impl.TarotPackageImpl#getBonus()
	 * @generated
	 */
	int BONUS = 3;

	/**
	 * The feature id for the '<em><b>Side</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BONUS__SIDE = 0;

	/**
	 * The number of structural features of the '<em>Bonus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BONUS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.samples.eef.tarot.impl.MisereImpl <em>Misere</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.samples.eef.tarot.impl.MisereImpl
	 * @see org.eclipse.emf.samples.eef.tarot.impl.TarotPackageImpl#getMisere()
	 * @generated
	 */
	int MISERE = 4;

	/**
	 * The feature id for the '<em><b>Game</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISERE__GAME = SCORE_ENTRY__GAME;

	/**
	 * The feature id for the '<em><b>Declarer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISERE__DECLARER = SCORE_ENTRY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Misere</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISERE_FEATURE_COUNT = SCORE_ENTRY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.samples.eef.tarot.impl.HandfulImpl <em>Handful</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.samples.eef.tarot.impl.HandfulImpl
	 * @see org.eclipse.emf.samples.eef.tarot.impl.TarotPackageImpl#getHandful()
	 * @generated
	 */
	int HANDFUL = 5;

	/**
	 * The feature id for the '<em><b>Side</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANDFUL__SIDE = BONUS__SIDE;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANDFUL__SIZE = BONUS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Handful</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HANDFUL_FEATURE_COUNT = BONUS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.samples.eef.tarot.impl.LeastAtLastImpl <em>Least At Last</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.samples.eef.tarot.impl.LeastAtLastImpl
	 * @see org.eclipse.emf.samples.eef.tarot.impl.TarotPackageImpl#getLeastAtLast()
	 * @generated
	 */
	int LEAST_AT_LAST = 6;

	/**
	 * The feature id for the '<em><b>Side</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAST_AT_LAST__SIDE = BONUS__SIDE;

	/**
	 * The number of structural features of the '<em>Least At Last</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEAST_AT_LAST_FEATURE_COUNT = BONUS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.samples.eef.tarot.impl.SlamImpl <em>Slam</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.samples.eef.tarot.impl.SlamImpl
	 * @see org.eclipse.emf.samples.eef.tarot.impl.TarotPackageImpl#getSlam()
	 * @generated
	 */
	int SLAM = 8;

	/**
	 * The feature id for the '<em><b>Side</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAM__SIDE = BONUS__SIDE;

	/**
	 * The feature id for the '<em><b>Announced</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAM__ANNOUNCED = BONUS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Achieved</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAM__ACHIEVED = BONUS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Slam</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAM_FEATURE_COUNT = BONUS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.samples.eef.tarot.BID <em>BID</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.samples.eef.tarot.BID
	 * @see org.eclipse.emf.samples.eef.tarot.impl.TarotPackageImpl#getBID()
	 * @generated
	 */
	int BID = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.samples.eef.tarot.HANDFUL_SIZE <em>HANDFUL SIZE</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.samples.eef.tarot.HANDFUL_SIZE
	 * @see org.eclipse.emf.samples.eef.tarot.impl.TarotPackageImpl#getHANDFUL_SIZE()
	 * @generated
	 */
	int HANDFUL_SIZE = 10;


	/**
	 * The meta object id for the '{@link org.eclipse.emf.samples.eef.tarot.PLAYER_SIDE <em>PLAYER SIDE</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.samples.eef.tarot.PLAYER_SIDE
	 * @see org.eclipse.emf.samples.eef.tarot.impl.TarotPackageImpl#getPLAYER_SIDE()
	 * @generated
	 */
	int PLAYER_SIDE = 11;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.samples.eef.tarot.Game <em>Game</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Game</em>'.
	 * @see org.eclipse.emf.samples.eef.tarot.Game
	 * @generated
	 */
	EClass getGame();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.samples.eef.tarot.Game#getPlayers <em>Players</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Players</em>'.
	 * @see org.eclipse.emf.samples.eef.tarot.Game#getPlayers()
	 * @see #getGame()
	 * @generated
	 */
	EReference getGame_Players();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.samples.eef.tarot.Game#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entries</em>'.
	 * @see org.eclipse.emf.samples.eef.tarot.Game#getEntries()
	 * @see #getGame()
	 * @generated
	 */
	EReference getGame_Entries();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.samples.eef.tarot.Player <em>Player</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Player</em>'.
	 * @see org.eclipse.emf.samples.eef.tarot.Player
	 * @generated
	 */
	EClass getPlayer();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.samples.eef.tarot.Player#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.samples.eef.tarot.Player#getName()
	 * @see #getPlayer()
	 * @generated
	 */
	EAttribute getPlayer_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.samples.eef.tarot.Player#getPics <em>Pics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pics</em>'.
	 * @see org.eclipse.emf.samples.eef.tarot.Player#getPics()
	 * @see #getPlayer()
	 * @generated
	 */
	EAttribute getPlayer_Pics();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.samples.eef.tarot.Round <em>Round</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Round</em>'.
	 * @see org.eclipse.emf.samples.eef.tarot.Round
	 * @generated
	 */
	EClass getRound();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.samples.eef.tarot.Round#getBid <em>Bid</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bid</em>'.
	 * @see org.eclipse.emf.samples.eef.tarot.Round#getBid()
	 * @see #getRound()
	 * @generated
	 */
	EAttribute getRound_Bid();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.samples.eef.tarot.Round#getTaker <em>Taker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Taker</em>'.
	 * @see org.eclipse.emf.samples.eef.tarot.Round#getTaker()
	 * @see #getRound()
	 * @generated
	 */
	EReference getRound_Taker();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.samples.eef.tarot.Round#getPartner <em>Partner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Partner</em>'.
	 * @see org.eclipse.emf.samples.eef.tarot.Round#getPartner()
	 * @see #getRound()
	 * @generated
	 */
	EReference getRound_Partner();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.samples.eef.tarot.Round#getBonuses <em>Bonuses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bonuses</em>'.
	 * @see org.eclipse.emf.samples.eef.tarot.Round#getBonuses()
	 * @see #getRound()
	 * @generated
	 */
	EReference getRound_Bonuses();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.samples.eef.tarot.Round#getExtraPoints <em>Extra Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extra Points</em>'.
	 * @see org.eclipse.emf.samples.eef.tarot.Round#getExtraPoints()
	 * @see #getRound()
	 * @generated
	 */
	EAttribute getRound_ExtraPoints();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.samples.eef.tarot.Round#getScore <em>Score</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Score</em>'.
	 * @see org.eclipse.emf.samples.eef.tarot.Round#getScore()
	 * @see #getRound()
	 * @generated
	 */
	EAttribute getRound_Score();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.samples.eef.tarot.Round#isWon <em>Won</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Won</em>'.
	 * @see org.eclipse.emf.samples.eef.tarot.Round#isWon()
	 * @see #getRound()
	 * @generated
	 */
	EAttribute getRound_Won();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.samples.eef.tarot.Bonus <em>Bonus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bonus</em>'.
	 * @see org.eclipse.emf.samples.eef.tarot.Bonus
	 * @generated
	 */
	EClass getBonus();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.samples.eef.tarot.Bonus#getSide <em>Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Side</em>'.
	 * @see org.eclipse.emf.samples.eef.tarot.Bonus#getSide()
	 * @see #getBonus()
	 * @generated
	 */
	EAttribute getBonus_Side();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.samples.eef.tarot.Misere <em>Misere</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Misere</em>'.
	 * @see org.eclipse.emf.samples.eef.tarot.Misere
	 * @generated
	 */
	EClass getMisere();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.samples.eef.tarot.Misere#getDeclarer <em>Declarer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Declarer</em>'.
	 * @see org.eclipse.emf.samples.eef.tarot.Misere#getDeclarer()
	 * @see #getMisere()
	 * @generated
	 */
	EReference getMisere_Declarer();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.samples.eef.tarot.Handful <em>Handful</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Handful</em>'.
	 * @see org.eclipse.emf.samples.eef.tarot.Handful
	 * @generated
	 */
	EClass getHandful();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.samples.eef.tarot.Handful#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.eclipse.emf.samples.eef.tarot.Handful#getSize()
	 * @see #getHandful()
	 * @generated
	 */
	EAttribute getHandful_Size();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.samples.eef.tarot.LeastAtLast <em>Least At Last</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Least At Last</em>'.
	 * @see org.eclipse.emf.samples.eef.tarot.LeastAtLast
	 * @generated
	 */
	EClass getLeastAtLast();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.samples.eef.tarot.ScoreEntry <em>Score Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Score Entry</em>'.
	 * @see org.eclipse.emf.samples.eef.tarot.ScoreEntry
	 * @generated
	 */
	EClass getScoreEntry();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.emf.samples.eef.tarot.ScoreEntry#getGame <em>Game</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Game</em>'.
	 * @see org.eclipse.emf.samples.eef.tarot.ScoreEntry#getGame()
	 * @see #getScoreEntry()
	 * @generated
	 */
	EReference getScoreEntry_Game();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.samples.eef.tarot.Slam <em>Slam</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Slam</em>'.
	 * @see org.eclipse.emf.samples.eef.tarot.Slam
	 * @generated
	 */
	EClass getSlam();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.samples.eef.tarot.Slam#isAnnounced <em>Announced</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Announced</em>'.
	 * @see org.eclipse.emf.samples.eef.tarot.Slam#isAnnounced()
	 * @see #getSlam()
	 * @generated
	 */
	EAttribute getSlam_Announced();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.samples.eef.tarot.Slam#isAchieved <em>Achieved</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Achieved</em>'.
	 * @see org.eclipse.emf.samples.eef.tarot.Slam#isAchieved()
	 * @see #getSlam()
	 * @generated
	 */
	EAttribute getSlam_Achieved();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.emf.samples.eef.tarot.BID <em>BID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>BID</em>'.
	 * @see org.eclipse.emf.samples.eef.tarot.BID
	 * @generated
	 */
	EEnum getBID();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.emf.samples.eef.tarot.HANDFUL_SIZE <em>HANDFUL SIZE</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>HANDFUL SIZE</em>'.
	 * @see org.eclipse.emf.samples.eef.tarot.HANDFUL_SIZE
	 * @generated
	 */
	EEnum getHANDFUL_SIZE();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.emf.samples.eef.tarot.PLAYER_SIDE <em>PLAYER SIDE</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>PLAYER SIDE</em>'.
	 * @see org.eclipse.emf.samples.eef.tarot.PLAYER_SIDE
	 * @generated
	 */
	EEnum getPLAYER_SIDE();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TarotFactory getTarotFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.emf.samples.eef.tarot.impl.GameImpl <em>Game</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.samples.eef.tarot.impl.GameImpl
		 * @see org.eclipse.emf.samples.eef.tarot.impl.TarotPackageImpl#getGame()
		 * @generated
		 */
		EClass GAME = eINSTANCE.getGame();

		/**
		 * The meta object literal for the '<em><b>Players</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GAME__PLAYERS = eINSTANCE.getGame_Players();

		/**
		 * The meta object literal for the '<em><b>Entries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GAME__ENTRIES = eINSTANCE.getGame_Entries();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.samples.eef.tarot.impl.PlayerImpl <em>Player</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.samples.eef.tarot.impl.PlayerImpl
		 * @see org.eclipse.emf.samples.eef.tarot.impl.TarotPackageImpl#getPlayer()
		 * @generated
		 */
		EClass PLAYER = eINSTANCE.getPlayer();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLAYER__NAME = eINSTANCE.getPlayer_Name();

		/**
		 * The meta object literal for the '<em><b>Pics</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLAYER__PICS = eINSTANCE.getPlayer_Pics();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.samples.eef.tarot.impl.RoundImpl <em>Round</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.samples.eef.tarot.impl.RoundImpl
		 * @see org.eclipse.emf.samples.eef.tarot.impl.TarotPackageImpl#getRound()
		 * @generated
		 */
		EClass ROUND = eINSTANCE.getRound();

		/**
		 * The meta object literal for the '<em><b>Bid</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROUND__BID = eINSTANCE.getRound_Bid();

		/**
		 * The meta object literal for the '<em><b>Taker</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROUND__TAKER = eINSTANCE.getRound_Taker();

		/**
		 * The meta object literal for the '<em><b>Partner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROUND__PARTNER = eINSTANCE.getRound_Partner();

		/**
		 * The meta object literal for the '<em><b>Bonuses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROUND__BONUSES = eINSTANCE.getRound_Bonuses();

		/**
		 * The meta object literal for the '<em><b>Extra Points</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROUND__EXTRA_POINTS = eINSTANCE.getRound_ExtraPoints();

		/**
		 * The meta object literal for the '<em><b>Score</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROUND__SCORE = eINSTANCE.getRound_Score();

		/**
		 * The meta object literal for the '<em><b>Won</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROUND__WON = eINSTANCE.getRound_Won();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.samples.eef.tarot.impl.BonusImpl <em>Bonus</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.samples.eef.tarot.impl.BonusImpl
		 * @see org.eclipse.emf.samples.eef.tarot.impl.TarotPackageImpl#getBonus()
		 * @generated
		 */
		EClass BONUS = eINSTANCE.getBonus();

		/**
		 * The meta object literal for the '<em><b>Side</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BONUS__SIDE = eINSTANCE.getBonus_Side();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.samples.eef.tarot.impl.MisereImpl <em>Misere</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.samples.eef.tarot.impl.MisereImpl
		 * @see org.eclipse.emf.samples.eef.tarot.impl.TarotPackageImpl#getMisere()
		 * @generated
		 */
		EClass MISERE = eINSTANCE.getMisere();

		/**
		 * The meta object literal for the '<em><b>Declarer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MISERE__DECLARER = eINSTANCE.getMisere_Declarer();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.samples.eef.tarot.impl.HandfulImpl <em>Handful</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.samples.eef.tarot.impl.HandfulImpl
		 * @see org.eclipse.emf.samples.eef.tarot.impl.TarotPackageImpl#getHandful()
		 * @generated
		 */
		EClass HANDFUL = eINSTANCE.getHandful();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HANDFUL__SIZE = eINSTANCE.getHandful_Size();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.samples.eef.tarot.impl.LeastAtLastImpl <em>Least At Last</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.samples.eef.tarot.impl.LeastAtLastImpl
		 * @see org.eclipse.emf.samples.eef.tarot.impl.TarotPackageImpl#getLeastAtLast()
		 * @generated
		 */
		EClass LEAST_AT_LAST = eINSTANCE.getLeastAtLast();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.samples.eef.tarot.impl.ScoreEntryImpl <em>Score Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.samples.eef.tarot.impl.ScoreEntryImpl
		 * @see org.eclipse.emf.samples.eef.tarot.impl.TarotPackageImpl#getScoreEntry()
		 * @generated
		 */
		EClass SCORE_ENTRY = eINSTANCE.getScoreEntry();

		/**
		 * The meta object literal for the '<em><b>Game</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCORE_ENTRY__GAME = eINSTANCE.getScoreEntry_Game();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.samples.eef.tarot.impl.SlamImpl <em>Slam</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.samples.eef.tarot.impl.SlamImpl
		 * @see org.eclipse.emf.samples.eef.tarot.impl.TarotPackageImpl#getSlam()
		 * @generated
		 */
		EClass SLAM = eINSTANCE.getSlam();

		/**
		 * The meta object literal for the '<em><b>Announced</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SLAM__ANNOUNCED = eINSTANCE.getSlam_Announced();

		/**
		 * The meta object literal for the '<em><b>Achieved</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SLAM__ACHIEVED = eINSTANCE.getSlam_Achieved();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.samples.eef.tarot.BID <em>BID</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.samples.eef.tarot.BID
		 * @see org.eclipse.emf.samples.eef.tarot.impl.TarotPackageImpl#getBID()
		 * @generated
		 */
		EEnum BID = eINSTANCE.getBID();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.samples.eef.tarot.HANDFUL_SIZE <em>HANDFUL SIZE</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.samples.eef.tarot.HANDFUL_SIZE
		 * @see org.eclipse.emf.samples.eef.tarot.impl.TarotPackageImpl#getHANDFUL_SIZE()
		 * @generated
		 */
		EEnum HANDFUL_SIZE = eINSTANCE.getHANDFUL_SIZE();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.samples.eef.tarot.PLAYER_SIDE <em>PLAYER SIDE</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.samples.eef.tarot.PLAYER_SIDE
		 * @see org.eclipse.emf.samples.eef.tarot.impl.TarotPackageImpl#getPLAYER_SIDE()
		 * @generated
		 */
		EEnum PLAYER_SIDE = eINSTANCE.getPLAYER_SIDE();

	}

} //TarotPackage
