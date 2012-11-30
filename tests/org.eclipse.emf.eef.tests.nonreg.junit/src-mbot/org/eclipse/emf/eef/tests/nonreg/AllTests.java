package org.eclipse.emf.eef.tests.nonreg;

import junit.framework.Test;
import junit.framework.TestCase;
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
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotRedoSetReferenceFlatRefTable;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotRedoSetReferenceRefTable;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotRemoveTableCompo;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotSetAttributeRadio;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotSetReferenceAEOFCV;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotSetReferenceFlatRefTable;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotSetReferenceRefTable;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotUndoAddTableCompo;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotUndoSetAttributeRadio;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotUndoSetReferenceAEOFCV;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotUndoSetReferenceFlatRefTable;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotUndoSetReferenceRefTable;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotUnsetAEOFCV;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotUnsetEOFCV;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotUnsetFlatRefTable;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotUnsetRefTable;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotUnsetReferenceAEOFCV;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotUnsetReferenceEOFCV;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotUnsetReferenceFlatRefTable;
import org.eclipse.emf.eef.tests.nonreg.batch.detailsview.BatchMBotUnsetReferenceRefTable;

public class AllTests extends TestCase {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(BatchMBotAddAdvTableCompoOnAbstractRef.class);
		suite.addTestSuite(BatchMBotAddTableCompo.class);
		suite.addTestSuite(BatchMBotCancelAddTableCompo.class);
		suite.addTestSuite(BatchMBotCancelSetReferenceAEOFCV.class);
		suite.addTestSuite(BatchMBotCancelSetReferenceFlatRefTable.class);
		suite.addTestSuite(BatchMBotCancelSetReferenceRefTable.class);
		suite.addTestSuite(BatchMBotRedoAddTableCompo.class);
		suite.addTestSuite(BatchMBotRedoSetAttributeRadio.class);
		suite.addTestSuite(BatchMBotRedoSetReferenceAEOFCV.class);
		suite.addTestSuite(BatchMBotRedoSetReferenceFlatRefTable.class);
		suite.addTestSuite(BatchMBotRedoSetReferenceRefTable.class);
		suite.addTestSuite(BatchMBotRemoveTableCompo.class);
		suite.addTestSuite(BatchMBotSetAttributeRadio.class);
		suite.addTestSuite(BatchMBotSetReferenceAEOFCV.class);
		suite.addTestSuite(BatchMBotSetReferenceFlatRefTable.class);
		suite.addTestSuite(BatchMBotSetReferenceRefTable.class);
		suite.addTestSuite(BatchMBotUndoAddTableCompo.class);
		suite.addTestSuite(BatchMBotUndoSetAttributeRadio.class);
		suite.addTestSuite(BatchMBotUndoSetReferenceAEOFCV.class);
		suite.addTestSuite(BatchMBotUndoSetReferenceFlatRefTable.class);
		suite.addTestSuite(BatchMBotUndoSetReferenceRefTable.class);
		suite.addTestSuite(BatchMBotUnsetAEOFCV.class);
		suite.addTestSuite(BatchMBotUnsetEOFCV.class);
		suite.addTestSuite(BatchMBotUnsetFlatRefTable.class);
		suite.addTestSuite(BatchMBotUnsetReferenceAEOFCV.class);
		suite.addTestSuite(BatchMBotUnsetReferenceEOFCV.class);
		suite.addTestSuite(BatchMBotUnsetReferenceFlatRefTable.class);
		suite.addTestSuite(BatchMBotUnsetReferenceRefTable.class);
		suite.addTestSuite(BatchMBotUnsetRefTable.class);
		//$JUnit-END$
		return suite;
	}

}
