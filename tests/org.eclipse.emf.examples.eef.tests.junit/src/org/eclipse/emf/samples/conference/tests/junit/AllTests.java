package org.eclipse.emf.samples.conference.tests.junit;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Test for org.eclipse.emf.samples.conference.tests.junit");
		//$JUnit-BEGIN$
		suite.addTestSuite(TalkTestCase.class);
		suite.addTestSuite(ConferenceTestCase.class);
		suite.addTestSuite(SiteTestCase.class);
		suite.addTestSuite(TopicTestCase.class);
		suite.addTestSuite(PersonTestCase.class);
		//$JUnit-END$
		return suite;
	}

}
