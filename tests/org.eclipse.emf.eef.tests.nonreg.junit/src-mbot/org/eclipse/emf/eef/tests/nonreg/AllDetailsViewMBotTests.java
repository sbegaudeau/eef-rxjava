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

import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotAddAdvTableCompoOnAbstractRef;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotAddTableCompo;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotCancelAddTableCompo;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotCancelSetReferenceAEOFCV;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotCancelSetReferenceFlatRefTable;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotCancelSetReferenceRefTable;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotRedoAddTableCompo;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotRedoSetAttributeRadio;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotRedoSetReferenceAEOFCV;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotRedoSetReferenceCombo;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotRedoSetReferenceFlatRefTable;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotRedoSetReferenceRefTable;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotRemoveTableCompo;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotSetAttributeRadio;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotSetReferenceAEOFCV;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotSetReferenceCombo;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotSetReferenceFlatRefTable;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotSetReferenceRefTable;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotUndoAddTableCompo;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotUndoSetAttributeRadio;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotUndoSetReferenceAEOFCV;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotUndoSetReferenceCombo;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotUndoSetReferenceFlatRefTable;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotUndoSetReferenceRefTable;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotUnsetAEOFCV;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotUnsetCombo;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotUnsetEOFCV;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotUnsetFlatRefTable;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotUnsetRefTable;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotUnsetReferenceAEOFCV;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotUnsetReferenceCombo;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotUnsetReferenceEOFCV;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotUnsetReferenceFlatRefTable;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotUnsetReferenceRefTable;

public class AllDetailsViewMBotTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("org.eclipse.emf.eef.tests.nonreg.junit");
		// $JUnit-BEGIN$

		// Set Attribute
		suite.addTestSuite(MBotSetAttributeRadio.class);

		// Set Reference
		suite.addTestSuite(MBotSetReferenceAEOFCV.class);
		suite.addTestSuite(MBotSetReferenceCombo.class);
		suite.addTestSuite(MBotSetReferenceFlatRefTable.class);
		suite.addTestSuite(MBotSetReferenceRefTable.class);

		// Unset
		suite.addTestSuite(MBotUnsetAEOFCV.class);
		suite.addTestSuite(MBotUnsetCombo.class);
		suite.addTestSuite(MBotUnsetEOFCV.class);
		suite.addTestSuite(MBotUnsetFlatRefTable.class);
		suite.addTestSuite(MBotUnsetRefTable.class);

		// Unset Reference
		suite.addTestSuite(MBotUnsetReferenceAEOFCV.class);
		suite.addTestSuite(MBotUnsetReferenceCombo.class);
		suite.addTestSuite(MBotUnsetReferenceEOFCV.class);
		suite.addTestSuite(MBotUnsetReferenceFlatRefTable.class);
		suite.addTestSuite(MBotUnsetReferenceRefTable.class);

		// Add
		suite.addTestSuite(MBotAddAdvTableCompoOnAbstractRef.class);
		suite.addTestSuite(MBotAddTableCompo.class);

		// Remove
		suite.addTestSuite(MBotRemoveTableCompo.class);

		// Undo
		suite.addTestSuite(MBotUndoAddTableCompo.class);
		suite.addTestSuite(MBotUndoSetAttributeRadio.class);
		suite.addTestSuite(MBotUndoSetReferenceAEOFCV.class);
		suite.addTestSuite(MBotUndoSetReferenceCombo.class);
		suite.addTestSuite(MBotUndoSetReferenceFlatRefTable.class);
		suite.addTestSuite(MBotUndoSetReferenceRefTable.class);

		// Redo
		suite.addTestSuite(MBotRedoAddTableCompo.class);
		suite.addTestSuite(MBotRedoSetAttributeRadio.class);
		suite.addTestSuite(MBotRedoSetReferenceAEOFCV.class);
		suite.addTestSuite(MBotRedoSetReferenceCombo.class);
		suite.addTestSuite(MBotRedoSetReferenceFlatRefTable.class);
		suite.addTestSuite(MBotRedoSetReferenceRefTable.class);

		// Cancel
		suite.addTestSuite(MBotCancelAddTableCompo.class);
		suite.addTestSuite(MBotCancelSetReferenceAEOFCV.class);
		suite.addTestSuite(MBotCancelSetReferenceFlatRefTable.class);
		suite.addTestSuite(MBotCancelSetReferenceRefTable.class);

		// Edit

		// $JUnit-END$
		return suite;
	}

}
