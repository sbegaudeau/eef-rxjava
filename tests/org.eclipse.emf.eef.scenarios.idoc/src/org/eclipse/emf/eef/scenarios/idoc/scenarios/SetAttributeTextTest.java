package org.eclipse.emf.eef.scenarios.idoc.scenarios;
/**
* Tests the 'setAttributeText' Scenario.
*/
public class SetAttributeTextTest extends org.eclipse.emf.eef.modelingBot.testcase.AbstractComposedModelingBotTestCase {
	public void testModelingBot() throws Exception {
		bot.runModelingBot("intent:/org.eclipse.emf.eef.scenarios.idoc/setAttributeText.modelingbot");
	}
}