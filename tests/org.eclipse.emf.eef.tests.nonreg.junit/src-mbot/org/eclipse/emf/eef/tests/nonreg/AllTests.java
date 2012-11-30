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
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotAddAdvTableCompoOnAbstractRef;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotAddTableCompo;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotCancelAddTableCompo;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotCancelSetReferenceAEOFCV;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotCancelSetReferenceFlatRefTable;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotCancelSetReferenceRefTable;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotRedoAddTableCompo;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotRedoSetAttributeRadio;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotRedoSetReferenceAEOFCV;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotRedoSetReferenceFlatRefTable;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotRedoSetReferenceRefTable;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotRemoveTableCompo;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotSetAttributeRadio;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotSetReferenceAEOFCV;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotSetReferenceFlatRefTable;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotSetReferenceRefTable;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotUndoAddTableCompo;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotUndoSetAttributeRadio;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotUndoSetReferenceAEOFCV;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotUndoSetReferenceFlatRefTable;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotUndoSetReferenceRefTable;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotUnsetAEOFCV;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotUnsetEOFCV;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotUnsetFlatRefTable;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotUnsetRefTable;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotUnsetReferenceAEOFCV;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotUnsetReferenceEOFCV;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotUnsetReferenceFlatRefTable;
import org.eclipse.emf.eef.tests.nonreg.detailsview.MBotUnsetReferenceRefTable;

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
		
		// Details
		suite.addTestSuite(MBotAddAdvTableCompoOnAbstractRef.class);
		suite.addTestSuite(MBotAddTableCompo.class);
		suite.addTestSuite(MBotCancelAddTableCompo.class);
		suite.addTestSuite(MBotCancelSetReferenceAEOFCV.class);
		suite.addTestSuite(MBotCancelSetReferenceFlatRefTable.class);
		suite.addTestSuite(MBotCancelSetReferenceRefTable.class);
		suite.addTestSuite(MBotRedoAddTableCompo.class);
		suite.addTestSuite(MBotRedoSetAttributeRadio.class);
		suite.addTestSuite(MBotRedoSetReferenceAEOFCV.class);
		suite.addTestSuite(MBotRedoSetReferenceFlatRefTable.class);
		suite.addTestSuite(MBotRedoSetReferenceRefTable.class);
		suite.addTestSuite(MBotRemoveTableCompo.class);
		suite.addTestSuite(MBotSetAttributeRadio.class);
		suite.addTestSuite(MBotSetReferenceAEOFCV.class);
		suite.addTestSuite(MBotSetReferenceFlatRefTable.class);
		suite.addTestSuite(MBotSetReferenceRefTable.class);
		suite.addTestSuite(MBotUndoAddTableCompo.class);
		suite.addTestSuite(MBotUndoSetAttributeRadio.class);
		suite.addTestSuite(MBotUndoSetReferenceAEOFCV.class);
		suite.addTestSuite(MBotUndoSetReferenceFlatRefTable.class);
		suite.addTestSuite(MBotUndoSetReferenceRefTable.class);
		suite.addTestSuite(MBotUnsetAEOFCV.class);
		suite.addTestSuite(MBotUnsetEOFCV.class);
		suite.addTestSuite(MBotUnsetFlatRefTable.class);
		suite.addTestSuite(MBotUnsetReferenceAEOFCV.class);
		suite.addTestSuite(MBotUnsetReferenceEOFCV.class);
//		suite.addTestSuite(MBotUnsetReferenceFlatRefTable.class);
//		suite.addTestSuite(MBotUnsetReferenceRefTable.class);
//		suite.addTestSuite(MBotUnsetRefTable.class);
		//$JUnit-END$
		return suite;
	}

}
