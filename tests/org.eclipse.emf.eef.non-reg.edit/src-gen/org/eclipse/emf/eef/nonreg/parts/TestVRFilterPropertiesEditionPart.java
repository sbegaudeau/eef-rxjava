/**
 * Generated with Acceleo
 */
package org.eclipse.emf.eef.nonreg.parts;

// Start of user code for imports

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.jface.viewers.ViewerFilter;


// End of user code
/**
 * 
 */
public interface TestVRFilterPropertiesEditionPart {




	/**
	 * @return the testFilter referenced view
	 */
	public IPropertiesEditionPart getTestFilterReferencedView();
	/**
	 * @return the testEOFCV
	 */
	public EObject getTestEOFCV();

	/**
	 * Init the testEOFCV
	 * @param allResources the ResourceSet where the widget have to process
	 * @param current the current value
	 */
	public void initTestEOFCV(ResourceSet allResources, EObject current);

	/**
	 * Defines a new testEOFCV
	 * @param newValue the new testEOFCV to set
	 */
	public void setTestEOFCV(EObject newValue);

	/**
	 * Adds the given filter to the testEOFCV edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToTestEOFCV(ViewerFilter filter);

	/**
	 * Adds the given filter to the testEOFCV edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToTestEOFCV(ViewerFilter filter);





	/**
	 * @return the testART to add
	 */
	public List getTestARTToAdd();

	/**
	 * @return the testART to remove
	 */
	public List getTestARTToRemove();

	/**
	 * @return the current testART table
	 */
	public List getTestARTTable();

	/**
	 * Init the testART
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initTestART(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the testART
	 * @param newValue the testART to update
	 */
	public void updateTestART(EObject newValue);

	/**
	 * Adds the given filter to the testART edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToTestART(ViewerFilter filter);

	/**
	 * Adds the given filter to the testART edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToTestART(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the testART table
	 */
	public boolean isContainedInTestARTTable(EObject element);





	/**
	 * @return the testAEOFCV
	 */
	public EObject getTestAEOFCV();

	/**
	 * Init the testAEOFCV
	 * @param allResources the ResourceSet where the widget have to process
	 * @param current the current value
	 */
	public void initTestAEOFCV(ResourceSet allResources, EObject current);

	/**
	 * Defines a new testAEOFCV
	 * @param newValue the new testAEOFCV to set
	 */
	public void setTestAEOFCV(EObject newValue);

	/**
	 * Adds the given filter to the testAEOFCV edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToTestAEOFCV(ViewerFilter filter);

	/**
	 * Adds the given filter to the testAEOFCV edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToTestAEOFCV(ViewerFilter filter);





	/**
	 * @return the testRT to add
	 */
	public List getTestRTToAdd();

	/**
	 * @return the testRT to remove
	 */
	public List getTestRTToRemove();

	/**
	 * @return the current testRT table
	 */
	public List getTestRTTable();

	/**
	 * Init the testRT
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initTestRT(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the testRT
	 * @param newValue the testRT to update
	 */
	public void updateTestRT(EObject newValue);

	/**
	 * Adds the given filter to the testRT edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToTestRT(ViewerFilter filter);

	/**
	 * Adds the given filter to the testRT edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToTestRT(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the testRT table
	 */
	public boolean isContainedInTestRTTable(EObject element);







	// Start of user code for additional methods
	
	// End of user code
}

