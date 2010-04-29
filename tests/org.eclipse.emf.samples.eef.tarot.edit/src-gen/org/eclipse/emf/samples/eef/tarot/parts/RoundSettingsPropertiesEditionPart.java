/**
 * Generated with Acceleo
 */
package org.eclipse.emf.samples.eef.tarot.parts;

// Start of user code for imports

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.jface.viewers.ViewerFilter;



// End of user code

/**
 * 
 * 
 */
public interface RoundSettingsPropertiesEditionPart {

	/**
	 * @return the taker
	 * 
	 */
	public EObject getTaker();

	/**
	 * Init the taker
	 * @param allResources the ResourceSet where the widget have to process
	 * @param current the current value
	 */
	public void initTaker(ResourceSet allResources, EObject current);

	/**
	 * Defines a new taker
	 * @param newValue the new taker to set
	 * 
	 */
	public void setTaker(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setTakerButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the taker edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToTaker(ViewerFilter filter);

	/**
	 * Adds the given filter to the taker edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToTaker(ViewerFilter filter);


	/**
	 * @return the partner
	 * 
	 */
	public EObject getPartner();

	/**
	 * Init the partner
	 * @param allResources the ResourceSet where the widget have to process
	 * @param current the current value
	 */
	public void initPartner(ResourceSet allResources, EObject current);

	/**
	 * Defines a new partner
	 * @param newValue the new partner to set
	 * 
	 */
	public void setPartner(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setPartnerButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the partner edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToPartner(ViewerFilter filter);

	/**
	 * Adds the given filter to the partner edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToPartner(ViewerFilter filter);


	/**
	 * @return the bid
	 * 
	 */
	public Enumerator getBid();

	/**
	 * Init the bid
	 * @param eenum the enum to manage
	 * @param current the current value
	 */
	public void initBid(EEnum eenum, Enumerator current);

	/**
	 * Defines a new bid
	 * @param newValue the new bid to set
	 * 
	 */
	public void setBid(Enumerator newValue);


	/**
	 * @return the extraPoints
	 * 
	 */
	public String getExtraPoints();

	/**
	 * Defines a new extraPoints
	 * @param newValue the new extraPoints to set
	 * 
	 */
	public void setExtraPoints(String newValue);


	/**
	 * @return the won
	 * 
	 */
	public Boolean getWon();

	/**
	 * Defines a new won
	 * @param newValue the new won to set
	 * 
	 */
	public void setWon(Boolean newValue);





	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 * 
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
