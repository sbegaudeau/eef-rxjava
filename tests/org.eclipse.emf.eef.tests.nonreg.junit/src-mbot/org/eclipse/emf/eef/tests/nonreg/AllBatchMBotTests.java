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

import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotAddAdvTableCompoOnAbstractRef;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotAddTableCompo;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotCancelAddTableCompo;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotCancelSetReferenceAEOFCV;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotCancelSetReferenceFlatRefTable;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotCancelSetReferenceRefTable;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotRedoAddTableCompo;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotRedoSetAttributeRadio;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotRedoSetReferenceAEOFCV;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotRedoSetReferenceCombo;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotRedoSetReferenceFlatRefTable;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotRedoSetReferenceRefTable;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotRemoveTableCompo;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotSetAttributeRadio;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotSetReferenceAEOFCV;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotSetReferenceCombo;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotSetReferenceFlatRefTable;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotSetReferenceRefTable;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotUndoAddTableCompo;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotUndoSetAttributeRadio;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotUndoSetReferenceAEOFCV;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotUndoSetReferenceCombo;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotUndoSetReferenceFlatRefTable;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotUndoSetReferenceRefTable;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotUnsetAEOFCV;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotUnsetCombo;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotUnsetEOFCV;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotUnsetFlatRefTable;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotUnsetRefTable;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotUnsetReferenceAEOFCV;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotUnsetReferenceCombo;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotUnsetReferenceEOFCV;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotUnsetReferenceFlatRefTable;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotUnsetReferenceRefTable;

public class AllBatchMBotTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("org.eclipse.emf.eef.tests.nonreg.junit");
		// $JUnit-BEGIN$

		// Set Attribute
		suite.addTestSuite(BatchMBotSetAttributeRadio.class);

		// Set Reference
		suite.addTestSuite(BatchMBotSetReferenceAEOFCV.class);
		suite.addTestSuite(BatchMBotSetReferenceCombo.class);
		suite.addTestSuite(BatchMBotSetReferenceFlatRefTable.class);
		suite.addTestSuite(BatchMBotSetReferenceRefTable.class);

		// Unset
		suite.addTestSuite(BatchMBotUnsetAEOFCV.class);
		suite.addTestSuite(BatchMBotUnsetCombo.class);
		suite.addTestSuite(BatchMBotUnsetEOFCV.class);
		suite.addTestSuite(BatchMBotUnsetFlatRefTable.class);
		suite.addTestSuite(BatchMBotUnsetRefTable.class);

		// Unset Reference
		suite.addTestSuite(BatchMBotUnsetReferenceAEOFCV.class);
		suite.addTestSuite(BatchMBotUnsetReferenceCombo.class);
		suite.addTestSuite(BatchMBotUnsetReferenceEOFCV.class);
		suite.addTestSuite(BatchMBotUnsetReferenceFlatRefTable.class);
		suite.addTestSuite(BatchMBotUnsetReferenceRefTable.class);

		// Add
		suite.addTestSuite(BatchMBotAddAdvTableCompoOnAbstractRef.class);
		suite.addTestSuite(BatchMBotAddTableCompo.class);

		// Remove
		suite.addTestSuite(BatchMBotRemoveTableCompo.class);

		// Undo
		suite.addTestSuite(BatchMBotUndoAddTableCompo.class);
		suite.addTestSuite(BatchMBotUndoSetAttributeRadio.class);
		suite.addTestSuite(BatchMBotUndoSetReferenceAEOFCV.class);
		suite.addTestSuite(BatchMBotUndoSetReferenceCombo.class);
		suite.addTestSuite(BatchMBotUndoSetReferenceFlatRefTable.class);
		suite.addTestSuite(BatchMBotUndoSetReferenceRefTable.class);

		// Redo
		suite.addTestSuite(BatchMBotRedoAddTableCompo.class);
		suite.addTestSuite(BatchMBotRedoSetAttributeRadio.class);
		suite.addTestSuite(BatchMBotRedoSetReferenceAEOFCV.class);
		suite.addTestSuite(BatchMBotRedoSetReferenceCombo.class);
		suite.addTestSuite(BatchMBotRedoSetReferenceFlatRefTable.class);
		suite.addTestSuite(BatchMBotRedoSetReferenceRefTable.class);

		// Cancel
		suite.addTestSuite(BatchMBotCancelAddTableCompo.class);
		suite.addTestSuite(BatchMBotCancelSetReferenceAEOFCV.class);
		suite.addTestSuite(BatchMBotCancelSetReferenceFlatRefTable.class);
		suite.addTestSuite(BatchMBotCancelSetReferenceRefTable.class);

		// Edit

		// $JUnit-END$
		return suite;
	}

}
