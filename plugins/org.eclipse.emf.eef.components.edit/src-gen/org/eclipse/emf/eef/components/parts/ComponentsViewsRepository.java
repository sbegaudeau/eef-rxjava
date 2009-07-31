/**
 *  Copyright (c) 2008-2009 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Obeo - initial API and implementation
 * 
 *
 * $Id: ComponentsViewsRepository.java,v 1.8 2009/07/31 14:14:18 glefur Exp $
 */
package org.eclipse.emf.eef.components.parts;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class ComponentsViewsRepository {

	public static final int SWT_KIND = 0;
		
	public static final int FORM_KIND = 1;

	
	/**
	 * Documentation view descriptor
	 */
	public static class Documentation {
		public static String documentation = "components::Documentation::documentation";	


	}

	/**
	 * PropertiesEditionContext view descriptor
	 */
	public static class PropertiesEditionContext {
		public static String model = "components::PropertiesEditionContext::model";	


	}

	/**
	 * PropertiesEditionComponent view descriptor
	 */
	public static class PropertiesEditionComponent {
		public static String name = "components::PropertiesEditionComponent::name";	

		public static String helpID = "components::PropertiesEditionComponent::helpID";	

		public static String explicit = "components::PropertiesEditionComponent::explicit";	


		public static String model = "components::PropertiesEditionComponent::model";	

		public static String views = "components::PropertiesEditionComponent::views";	


	}

	/**
	 * PropertiesEditionElement view descriptor
	 */
	public static class PropertiesEditionElement {
		public static String name = "components::PropertiesEditionElement::name";	

		public static String helpID = "components::PropertiesEditionElement::helpID";	


		public static String model = "components::PropertiesEditionElement::model";	

		public static String views = "components::PropertiesEditionElement::views";	


	}

	/**
	 * PropertiesMultiEditionElement view descriptor
	 */
	public static class PropertiesMultiEditionElement {
		public static String name = "components::PropertiesMultiEditionElement::name";	

		public static String helpID = "components::PropertiesMultiEditionElement::helpID";	


		public static String model = "components::PropertiesMultiEditionElement::model";	

		public static String views = "components::PropertiesMultiEditionElement::views";	


	}

}

