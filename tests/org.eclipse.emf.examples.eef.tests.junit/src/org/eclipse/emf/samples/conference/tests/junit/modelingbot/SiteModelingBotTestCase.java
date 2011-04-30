/**
 * 
 */
package org.eclipse.emf.samples.conference.tests.junit.modelingbot;

import org.eclipse.emf.eef.modelingBot.testcase.ComposedEEFBotModelingTestCase;

/**
 * @author <a href="goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class SiteModelingBotTestCase extends ComposedEEFBotModelingTestCase {

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.modelingBot.testcase.SWTBotModelingBotTestCase#testModelingBot()
	 */
	public void testModelingBot() throws Exception {
		composedBot.runModelingBot("org.eclipse.emf.examples.eef.tests.junit/models/conference_Site.modelingbot");
	}

}
