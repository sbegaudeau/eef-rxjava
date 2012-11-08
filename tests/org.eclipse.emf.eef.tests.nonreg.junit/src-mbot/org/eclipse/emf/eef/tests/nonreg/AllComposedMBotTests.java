/*******************************************************************************
 * Copyright (c) 2008, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.tests.nonreg;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.eef.tests.nonreg.composed.detailsview.ComposedMBotAddAdvTableCompoOnAbstractRef;
import org.eclipse.emf.eef.tests.nonreg.composed.detailsview.ComposedMBotAddTableCompo;
import org.eclipse.emf.eef.tests.nonreg.composed.detailsview.ComposedMBotCancelAddTableCompo;
import org.eclipse.emf.eef.tests.nonreg.composed.detailsview.ComposedMBotCancelSetReferenceAEOFCV;
import org.eclipse.emf.eef.tests.nonreg.composed.detailsview.ComposedMBotCancelSetReferenceFlatRefTable;
import org.eclipse.emf.eef.tests.nonreg.composed.detailsview.ComposedMBotCancelSetReferenceRefTable;
import org.eclipse.emf.eef.tests.nonreg.composed.detailsview.ComposedMBotRedoAddTableCompo;
import org.eclipse.emf.eef.tests.nonreg.composed.detailsview.ComposedMBotRedoSetAttributeRadio;
import org.eclipse.emf.eef.tests.nonreg.composed.detailsview.ComposedMBotRedoSetReferenceAEOFCV;
import org.eclipse.emf.eef.tests.nonreg.composed.detailsview.ComposedMBotRedoSetReferenceCombo;
import org.eclipse.emf.eef.tests.nonreg.composed.detailsview.ComposedMBotRedoSetReferenceFlatRefTable;
import org.eclipse.emf.eef.tests.nonreg.composed.detailsview.ComposedMBotRedoSetReferenceRefTable;
import org.eclipse.emf.eef.tests.nonreg.composed.detailsview.ComposedMBotRemoveTableCompo;
import org.eclipse.emf.eef.tests.nonreg.composed.detailsview.ComposedMBotSetAttributeRadio;
import org.eclipse.emf.eef.tests.nonreg.composed.detailsview.ComposedMBotSetReferenceAEOFCV;
import org.eclipse.emf.eef.tests.nonreg.composed.detailsview.ComposedMBotSetReferenceCombo;
import org.eclipse.emf.eef.tests.nonreg.composed.detailsview.ComposedMBotSetReferenceFlatRefTable;
import org.eclipse.emf.eef.tests.nonreg.composed.detailsview.ComposedMBotSetReferenceRefTable;
import org.eclipse.emf.eef.tests.nonreg.composed.detailsview.ComposedMBotUndoAddTableCompo;
import org.eclipse.emf.eef.tests.nonreg.composed.detailsview.ComposedMBotUndoSetAttributeRadio;
import org.eclipse.emf.eef.tests.nonreg.composed.detailsview.ComposedMBotUndoSetReferenceAEOFCV;
import org.eclipse.emf.eef.tests.nonreg.composed.detailsview.ComposedMBotUndoSetReferenceCombo;
import org.eclipse.emf.eef.tests.nonreg.composed.detailsview.ComposedMBotUndoSetReferenceFlatRefTable;
import org.eclipse.emf.eef.tests.nonreg.composed.detailsview.ComposedMBotUndoSetReferenceRefTable;
import org.eclipse.emf.eef.tests.nonreg.composed.detailsview.ComposedMBotUnsetAEOFCV;
import org.eclipse.emf.eef.tests.nonreg.composed.detailsview.ComposedMBotUnsetCombo;
import org.eclipse.emf.eef.tests.nonreg.composed.detailsview.ComposedMBotUnsetEOFCV;
import org.eclipse.emf.eef.tests.nonreg.composed.detailsview.ComposedMBotUnsetFlatRefTable;
import org.eclipse.emf.eef.tests.nonreg.composed.detailsview.ComposedMBotUnsetRefTable;
import org.eclipse.emf.eef.tests.nonreg.composed.detailsview.ComposedMBotUnsetReferenceAEOFCV;
import org.eclipse.emf.eef.tests.nonreg.composed.detailsview.ComposedMBotUnsetReferenceCombo;
import org.eclipse.emf.eef.tests.nonreg.composed.detailsview.ComposedMBotUnsetReferenceEOFCV;
import org.eclipse.emf.eef.tests.nonreg.composed.detailsview.ComposedMBotUnsetReferenceFlatRefTable;
import org.eclipse.emf.eef.tests.nonreg.composed.detailsview.ComposedMBotUnsetReferenceRefTable;

public class AllComposedMBotTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("org.eclipse.emf.eef.tests.nonreg.junit");

		// Set Attribute
		suite.addTestSuite(ComposedMBotSetAttributeRadio.class);

		// Set Reference
		suite.addTestSuite(ComposedMBotSetReferenceAEOFCV.class);
		suite.addTestSuite(ComposedMBotSetReferenceCombo.class);
		suite.addTestSuite(ComposedMBotSetReferenceFlatRefTable.class);
		suite.addTestSuite(ComposedMBotSetReferenceRefTable.class);

		// Unset
		suite.addTestSuite(ComposedMBotUnsetAEOFCV.class);
		suite.addTestSuite(ComposedMBotUnsetCombo.class);
		suite.addTestSuite(ComposedMBotUnsetEOFCV.class);
		suite.addTestSuite(ComposedMBotUnsetFlatRefTable.class);
		suite.addTestSuite(ComposedMBotUnsetRefTable.class);

		// Unset Reference
		suite.addTestSuite(ComposedMBotUnsetReferenceAEOFCV.class);
		suite.addTestSuite(ComposedMBotUnsetReferenceCombo.class);
		suite.addTestSuite(ComposedMBotUnsetReferenceEOFCV.class);
		suite.addTestSuite(ComposedMBotUnsetReferenceFlatRefTable.class);
		suite.addTestSuite(ComposedMBotUnsetReferenceRefTable.class);

		// Add
		suite.addTestSuite(ComposedMBotAddAdvTableCompoOnAbstractRef.class);
		suite.addTestSuite(ComposedMBotAddTableCompo.class);

		// Remove
		suite.addTestSuite(ComposedMBotRemoveTableCompo.class);

		// Undo
		suite.addTestSuite(ComposedMBotUndoAddTableCompo.class);
		suite.addTestSuite(ComposedMBotUndoSetAttributeRadio.class);
		suite.addTestSuite(ComposedMBotUndoSetReferenceAEOFCV.class);
		suite.addTestSuite(ComposedMBotUndoSetReferenceCombo.class);
		suite.addTestSuite(ComposedMBotUndoSetReferenceFlatRefTable.class);
		suite.addTestSuite(ComposedMBotUndoSetReferenceRefTable.class);

		// Redo
		suite.addTestSuite(ComposedMBotRedoAddTableCompo.class);
		suite.addTestSuite(ComposedMBotRedoSetAttributeRadio.class);
		suite.addTestSuite(ComposedMBotRedoSetReferenceAEOFCV.class);
		suite.addTestSuite(ComposedMBotRedoSetReferenceCombo.class);
		suite.addTestSuite(ComposedMBotRedoSetReferenceFlatRefTable.class);
		suite.addTestSuite(ComposedMBotRedoSetReferenceRefTable.class);

		// Cancel
		suite.addTestSuite(ComposedMBotCancelAddTableCompo.class);
		suite.addTestSuite(ComposedMBotCancelSetReferenceAEOFCV.class);
		suite.addTestSuite(ComposedMBotCancelSetReferenceFlatRefTable.class);
		suite.addTestSuite(ComposedMBotCancelSetReferenceRefTable.class);

		// Edit

		// $JUnit-END$
		return suite;
	}

}
