package org.eclipse.emf.samples.conference.tests.junit;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.emf.samples.conference.tests.junit.modelingbot.functional.ComposedBotModelingTestCase;
import org.eclipse.emf.samples.conference.tests.junit.modelingbot.functional.SWTBotModelingTestCase;
import org.eclipse.emf.samples.conference.tests.junit.modelingbot.functional.SWTBotModelingTestCase2;
import org.eclipse.emf.samples.conference.tests.junit.modelingbot.functional.SWTBotModelingTestCase3;

public class AllModelingBotTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Test for modeling bot on Conference");
		//$JUnit-BEGIN$
		suite.addTestSuite(SWTBotModelingTestCase2.class);
		suite.addTestSuite(SWTBotModelingTestCase3.class);
		suite.addTestSuite(SWTBotModelingTestCase.class);
		suite.addTestSuite(ComposedBotModelingTestCase.class);
		//$JUnit-END$
		return suite;
	}

}
