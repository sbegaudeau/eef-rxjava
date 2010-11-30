/**
 * 
 */
package org.eclipse.emf.eef.tests.nonreg.junit.compositionsequence;

import junit.framework.TestCase;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;


/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class TestCompositionSequence extends TestCase {
	
	/**
	 * Test the composition process
	 */
	public void testSimpleCompositionSequence() {
		CompositionSequence sequence = new CompositionSequence();
		sequence.addStep("G1").addStep("E1");
		CompositionStep group2 = sequence.addStep("G2");
		group2.addStep("E2");
		group2.addStep("E3");
		
		String toString = toString(sequence);
		assert toString.equals("G1E1G2E2E3");
	}

	/**
	 * Test an advanced composition process
	 */
	public void testAdvancedCompositionSequence() {
		CompositionSequence sequence1 = createAdvancedSequence();
		CompositionStep currentStep = sequence1.next();
		StringBuffer track = new StringBuffer();
		do {
			track.append(currentStep.key);
			currentStep = currentStep.next();
		} while (currentStep != null);
		
		assert track.toString().equals("123456789101112");
	}
	
	
	/**
	 * Test the before method
	 */
	public void testBefore() {
		CompositionSequence sequence1 = createAdvancedSequence();
		CompositionStep currentStep = sequence1;
		CompositionStep next = currentStep.next();
		while (next != null) {
			currentStep = next;
			next = currentStep.next();
		}
		CompositionStep before = currentStep.before();
		StringBuffer track = new StringBuffer();
		while (before != null) {
			track.append(before.key);
			before = before.before();
		}
		assert track.toString().equals("121110987654321");
		
	}

	/**
	 * Test the before method
	 */
	public void testUp() {
		CompositionSequence sequence1 = new CompositionSequence();
		CompositionStep group1 = sequence1.addStep("G1");
		CompositionStep e1 = group1.addStep("E1");
		CompositionStep e2 = group1.addStep("E2");
		CompositionStep group2 = sequence1.addStep("G2");
		CompositionStep e3 = group2.addStep("E3");
		CompositionStep e4 = group2.addStep("E4");
		assert toString(sequence1).equals("G1E1E2G2E3E4");		
		e2.up();
		assert toString(sequence1).equals("G1E2E1G2E3E4");		
		group2.up();
		assert toString(sequence1).equals("G2E3E4G1E2E1");		
	}
	
	/**
	 * Test the before method
	 */
	public void testDown() {
		CompositionSequence sequence1 = new CompositionSequence();
		CompositionStep group1 = sequence1.addStep("G1");
		CompositionStep e1 = group1.addStep("E1");
		CompositionStep e2 = group1.addStep("E2");
		CompositionStep group2 = sequence1.addStep("G2");
		CompositionStep e3 = group2.addStep("E3");
		CompositionStep e4 = group2.addStep("E4");
		assert toString(sequence1).equals("G1E1E2G2E3E4");		
		e3.down();
		assert toString(sequence1).equals("G1E1E2G2E4E3");		
		group1.down();
		assert toString(sequence1).equals("G2E4E3G1E1E2");		
	}
	
	/**
	 * Test the before method
	 */
	public void testMove() {
		CompositionSequence sequence1 = new CompositionSequence();
		CompositionStep group1 = sequence1.addStep("G1");
		CompositionStep e1 = group1.addStep("E1");
		CompositionStep e2 = group1.addStep("E2");
		CompositionStep group2 = sequence1.addStep("G2");
		CompositionStep e3 = group2.addStep("E3");
		CompositionStep e4 = group2.addStep("E4");
		assert toString(sequence1).equals("G1E1E2G2E3E4");		
		e3.moveTo(group1);
		assert toString(sequence1).equals("G1E1E2E3G2E4");		
		group1.moveTo(group2);
		group2.addStep("E5");
		assert toString(sequence1).equals("G2E4G1E1E2E3E5");		
	}
	
	/**
	 * @param sequence
	 * @return
	 */
	private String toString(CompositionSequence sequence) {
		CompositionStep currentStep = sequence.next();
		StringBuffer track = new StringBuffer();
		do {
			track.append(currentStep.key);
			currentStep = currentStep.next();
		} while (currentStep != null);
		
		String toString = track.toString();
		return toString;
	}

	/**
	 * @return an complex sequence
	 */
	private CompositionSequence createAdvancedSequence() {
		CompositionSequence sequence1 = new CompositionSequence();
		sequence1.addStep("1").addStep("2");
		CompositionStep group2 = sequence1.addStep("3");
		group2.addStep("4");
		group2.addStep("5");
		group2.addStep("6").addStep("7");
		CompositionSequence sequence2 = new CompositionSequence(sequence1, "Sub-sequence 1");
		CompositionStep group3 = sequence2.addStep("8");
		group3.addStep("9");
		group3.addStep("10");
		sequence2.addStep("11");
		group2.addStep(sequence2);
		sequence1.addStep("12");
		return sequence1;
	}

	
	
}
