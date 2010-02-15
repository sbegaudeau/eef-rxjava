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
 * $Id: TarotPackageImpl.java,v 1.1 2010/02/15 14:00:38 glefur Exp $
 */
package org.eclipse.emf.samples.eef.tarot.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.samples.eef.tarot.Bonus;
import org.eclipse.emf.samples.eef.tarot.Game;
import org.eclipse.emf.samples.eef.tarot.Handful;
import org.eclipse.emf.samples.eef.tarot.LeastAtLast;
import org.eclipse.emf.samples.eef.tarot.Misere;
import org.eclipse.emf.samples.eef.tarot.Player;
import org.eclipse.emf.samples.eef.tarot.Round;
import org.eclipse.emf.samples.eef.tarot.ScoreEntry;
import org.eclipse.emf.samples.eef.tarot.Slam;
import org.eclipse.emf.samples.eef.tarot.TarotFactory;
import org.eclipse.emf.samples.eef.tarot.TarotPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TarotPackageImpl extends EPackageImpl implements TarotPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass playerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roundEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bonusEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass misereEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass handfulEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass leastAtLastEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scoreEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass slamEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum bidEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum handfuL_SIZEEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum playeR_SIDEEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.emf.samples.eef.tarot.TarotPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TarotPackageImpl() {
		super(eNS_URI, TarotFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link TarotPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TarotPackage init() {
		if (isInited) return (TarotPackage)EPackage.Registry.INSTANCE.getEPackage(TarotPackage.eNS_URI);

		// Obtain or create and register package
		TarotPackageImpl theTarotPackage = (TarotPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TarotPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TarotPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theTarotPackage.createPackageContents();

		// Initialize created meta-data
		theTarotPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTarotPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TarotPackage.eNS_URI, theTarotPackage);
		return theTarotPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGame() {
		return gameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGame_Players() {
		return (EReference)gameEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGame_Entries() {
		return (EReference)gameEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlayer() {
		return playerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlayer_Name() {
		return (EAttribute)playerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlayer_Pics() {
		return (EAttribute)playerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRound() {
		return roundEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRound_Bid() {
		return (EAttribute)roundEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRound_Taker() {
		return (EReference)roundEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRound_Partner() {
		return (EReference)roundEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRound_Bonuses() {
		return (EReference)roundEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRound_ExtraPoints() {
		return (EAttribute)roundEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRound_Score() {
		return (EAttribute)roundEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRound_Won() {
		return (EAttribute)roundEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBonus() {
		return bonusEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBonus_Side() {
		return (EAttribute)bonusEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMisere() {
		return misereEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMisere_Declarer() {
		return (EReference)misereEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHandful() {
		return handfulEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHandful_Size() {
		return (EAttribute)handfulEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLeastAtLast() {
		return leastAtLastEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScoreEntry() {
		return scoreEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScoreEntry_Game() {
		return (EReference)scoreEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSlam() {
		return slamEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSlam_Announced() {
		return (EAttribute)slamEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSlam_Achieved() {
		return (EAttribute)slamEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBID() {
		return bidEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getHANDFUL_SIZE() {
		return handfuL_SIZEEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPLAYER_SIDE() {
		return playeR_SIDEEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TarotFactory getTarotFactory() {
		return (TarotFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		gameEClass = createEClass(GAME);
		createEReference(gameEClass, GAME__PLAYERS);
		createEReference(gameEClass, GAME__ENTRIES);

		playerEClass = createEClass(PLAYER);
		createEAttribute(playerEClass, PLAYER__NAME);
		createEAttribute(playerEClass, PLAYER__PICS);

		roundEClass = createEClass(ROUND);
		createEAttribute(roundEClass, ROUND__BID);
		createEReference(roundEClass, ROUND__TAKER);
		createEReference(roundEClass, ROUND__PARTNER);
		createEReference(roundEClass, ROUND__BONUSES);
		createEAttribute(roundEClass, ROUND__EXTRA_POINTS);
		createEAttribute(roundEClass, ROUND__SCORE);
		createEAttribute(roundEClass, ROUND__WON);

		bonusEClass = createEClass(BONUS);
		createEAttribute(bonusEClass, BONUS__SIDE);

		misereEClass = createEClass(MISERE);
		createEReference(misereEClass, MISERE__DECLARER);

		handfulEClass = createEClass(HANDFUL);
		createEAttribute(handfulEClass, HANDFUL__SIZE);

		leastAtLastEClass = createEClass(LEAST_AT_LAST);

		scoreEntryEClass = createEClass(SCORE_ENTRY);
		createEReference(scoreEntryEClass, SCORE_ENTRY__GAME);

		slamEClass = createEClass(SLAM);
		createEAttribute(slamEClass, SLAM__ANNOUNCED);
		createEAttribute(slamEClass, SLAM__ACHIEVED);

		// Create enums
		bidEEnum = createEEnum(BID);
		handfuL_SIZEEEnum = createEEnum(HANDFUL_SIZE);
		playeR_SIDEEEnum = createEEnum(PLAYER_SIDE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		roundEClass.getESuperTypes().add(this.getScoreEntry());
		misereEClass.getESuperTypes().add(this.getScoreEntry());
		handfulEClass.getESuperTypes().add(this.getBonus());
		leastAtLastEClass.getESuperTypes().add(this.getBonus());
		slamEClass.getESuperTypes().add(this.getBonus());

		// Initialize classes and features; add operations and parameters
		initEClass(gameEClass, Game.class, "Game", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGame_Players(), this.getPlayer(), null, "players", null, 3, 5, Game.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGame_Entries(), this.getScoreEntry(), this.getScoreEntry_Game(), "entries", null, 0, -1, Game.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(playerEClass, Player.class, "Player", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPlayer_Name(), ecorePackage.getEString(), "name", null, 1, 1, Player.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlayer_Pics(), ecorePackage.getEString(), "pics", null, 0, 1, Player.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roundEClass, Round.class, "Round", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRound_Bid(), this.getBID(), "bid", null, 1, 1, Round.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRound_Taker(), this.getPlayer(), null, "taker", null, 1, 1, Round.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRound_Partner(), this.getPlayer(), null, "partner", null, 0, 1, Round.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRound_Bonuses(), this.getBonus(), null, "bonuses", null, 0, -1, Round.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRound_ExtraPoints(), ecorePackage.getEInt(), "extraPoints", null, 1, 1, Round.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRound_Score(), ecorePackage.getEInt(), "score", null, 1, 1, Round.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getRound_Won(), ecorePackage.getEBoolean(), "won", "true", 1, 1, Round.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bonusEClass, Bonus.class, "Bonus", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBonus_Side(), this.getPLAYER_SIDE(), "side", null, 1, 1, Bonus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(misereEClass, Misere.class, "Misere", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMisere_Declarer(), this.getPlayer(), null, "declarer", null, 1, 1, Misere.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(handfulEClass, Handful.class, "Handful", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHandful_Size(), this.getHANDFUL_SIZE(), "size", null, 1, 1, Handful.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(leastAtLastEClass, LeastAtLast.class, "LeastAtLast", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(scoreEntryEClass, ScoreEntry.class, "ScoreEntry", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScoreEntry_Game(), this.getGame(), this.getGame_Entries(), "game", null, 0, 1, ScoreEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(scoreEntryEClass, ecorePackage.getEInt(), "score", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPlayer(), "player", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(scoreEntryEClass, ecorePackage.getEInt(), "cumulativeScore", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPlayer(), "player", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(slamEClass, Slam.class, "Slam", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSlam_Announced(), ecorePackage.getEBoolean(), "announced", null, 1, 1, Slam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSlam_Achieved(), ecorePackage.getEBoolean(), "achieved", null, 1, 1, Slam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(bidEEnum, org.eclipse.emf.samples.eef.tarot.BID.class, "BID");
		addEEnumLiteral(bidEEnum, org.eclipse.emf.samples.eef.tarot.BID.SMALL);
		addEEnumLiteral(bidEEnum, org.eclipse.emf.samples.eef.tarot.BID.GUARD);
		addEEnumLiteral(bidEEnum, org.eclipse.emf.samples.eef.tarot.BID.GUARD_WITHOUT);
		addEEnumLiteral(bidEEnum, org.eclipse.emf.samples.eef.tarot.BID.GUARD_AGAINST);

		initEEnum(handfuL_SIZEEEnum, org.eclipse.emf.samples.eef.tarot.HANDFUL_SIZE.class, "HANDFUL_SIZE");
		addEEnumLiteral(handfuL_SIZEEEnum, org.eclipse.emf.samples.eef.tarot.HANDFUL_SIZE.SINGLE);
		addEEnumLiteral(handfuL_SIZEEEnum, org.eclipse.emf.samples.eef.tarot.HANDFUL_SIZE.DOUBLE);
		addEEnumLiteral(handfuL_SIZEEEnum, org.eclipse.emf.samples.eef.tarot.HANDFUL_SIZE.TRIPLE);

		initEEnum(playeR_SIDEEEnum, org.eclipse.emf.samples.eef.tarot.PLAYER_SIDE.class, "PLAYER_SIDE");
		addEEnumLiteral(playeR_SIDEEEnum, org.eclipse.emf.samples.eef.tarot.PLAYER_SIDE.ATTACK);
		addEEnumLiteral(playeR_SIDEEEnum, org.eclipse.emf.samples.eef.tarot.PLAYER_SIDE.DEFENSE);

		// Create resource
		createResource(eNS_URI);
	}

} //TarotPackageImpl
