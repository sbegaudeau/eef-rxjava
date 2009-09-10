/**
 * 
 */
package org.eclipse.emf.eef.runtime.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.MatchOptions;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;
import org.eclipse.emf.eef.runtime.tests.swtbot.finder.SWTEEFBot;
import org.eclipse.swtbot.eclipse.finder.SWTBotEclipseTestCase;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.junit.Before;

/**
 * @author glefur
 * 
 */
public abstract class SWTBotEEFTestCase extends SWTBotEclipseTestCase {

	/**
	 * An instance of SWTEclipseBot.
	 *
	 * @since 1.1
	 */
	protected SWTEEFBot	bot = new SWTEEFBot();

	/*****************************************************************************
	 *																			 *
	 * Test members																 *
	 * 																			 *
	 *****************************************************************************/

	/**
	 * the model editor
	 */
	protected SWTBotEditor editor;

	/*****************************************************************************
	 *																			 *
	 * Tests specialization														 *
	 * 																			 *
	 *****************************************************************************/

	/**
	 * Process to initialize the workspace for the tests
	 * @throws CoreException an error occured during the tests initialization
	 * @throws IOException an error occured during the tests initialization
	 */
	protected abstract void initWorkspaceForTests() throws CoreException, IOException;

	/*****************************************************************************
	 *																			 *
	 * Test lifecycle															 *
	 * 																			 *
	 *****************************************************************************/

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		super.setUp();
		closeWelcomePage();
		initWorkspaceForTests();
	}

	/*****************************************************************************
	 *																			 *
	 * Utils methods															 *
	 * 																			 *
	 *****************************************************************************/

	/**
	 * This method close the welcome page if we use the workspace of
	 * test for the first time 
	 */
	protected void closeWelcomePage() {
		try {
			bot.viewByTitle("Welcome").close();
		} catch (WidgetNotFoundException e) {
			// do nothing
		}
	}

	/**
	 * @param the model to compare to the bot active model
	 * @return the comparison model
	 * @throws Exception something wrong during comparison
	 */
	private DiffModel compareToActiveModel(Resource expectedModel) throws Exception {
		bot.reloadActiveModel();
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(MatchOptions.OPTION_IGNORE_XMI_ID, true);
		MatchModel match = MatchService.doResourceMatch(bot.getActiveResource(), expectedModel, options);
		DiffModel diff = DiffService.doDiff(match);
		return diff;
	}

	/**
	 * Check if the bot's active model is the same that the given model
	 * @param expectedModel the model to compare
	 */
	public void assertExpectedModelReached(Resource expectedModel) {
		try {
			DiffModel compareToActiveModel = compareToActiveModel(expectedModel);
			List<EObject> diffList = EEFUtils.asEObjectList(compareToActiveModel.eAllContents());
			List<EObject> result = filterAbnormalDiffElement(diffList);
			assertEquals("The active model isn't the same that the expected model", result.size(), 0);
		} catch (Exception e) {
			// How to do that ???
			assertTrue("Error during model comparison", false);
		}
	}

	/**
	 * TODO: check this with the EMF Compare team
	 * @param diffList the list to filter
	 * @return the list of "good" diff
	 */
	private List<EObject> filterAbnormalDiffElement(List<EObject> diffList) {
		List<EObject> result = new ArrayList<EObject>();
		for (EObject object : diffList) {
			if (!(object instanceof DiffGroup) || (((DiffGroup)object).eContents().size() > 0))
				result.add(object);
		}
		return result;
	}

}
