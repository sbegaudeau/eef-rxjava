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
 * $Id: MappingViewsRepository.java,v 1.4 2009/05/19 08:00:11 sbouchet Exp $
 */
package org.eclipse.emf.eef.mapping.parts;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class MappingViewsRepository {

	public static final int SWT_KIND = 0;
		
	public static final int FORM_KIND = 1;

	
	/**
	 * Documentation view descriptor
	 */
	public static class Documentation {

		public static String documentation = "mapping::Documentation::documentation";



	}

	/**
	 * EMFElementBinding view descriptor
	 */
	public static class EMFElementBinding {

		public static String name = "mapping::EMFElementBinding::name";



		public static String model = "mapping::EMFElementBinding::model";


		public static String views = "mapping::EMFElementBinding::views";



	}

	/**
	 * EMFPropertyBinding view descriptor
	 */
	public static class EMFPropertyBinding {

		public static String name = "mapping::EMFPropertyBinding::name";



		public static String model = "mapping::EMFPropertyBinding::model";


		public static String views = "mapping::EMFPropertyBinding::views";



	}

	/**
	 * StandardElementBinding view descriptor
	 */
	public static class StandardElementBinding {

		public static String name = "mapping::StandardElementBinding::name";



		public static String model = "mapping::StandardElementBinding::model";


		public static String views = "mapping::StandardElementBinding::views";



	}

	/**
	 * StandardPropertyBinding view descriptor
	 */
	public static class StandardPropertyBinding {

		public static String name = "mapping::StandardPropertyBinding::name";



		public static String model = "mapping::StandardPropertyBinding::model";


		public static String views = "mapping::StandardPropertyBinding::views";



	}

	/**
	 * Category view descriptor
	 */
	public static class Category {

		public static String name = "mapping::Category::name";



	}

	/**
	 * ElementBindingReference view descriptor
	 */
	public static class ElementBindingReference {

		public static String binding = "mapping::ElementBindingReference::binding";



	}

	/**
	 * EMFMultiPropertiesBinding view descriptor
	 */
	public static class EMFMultiPropertiesBinding {

		public static String name = "mapping::EMFMultiPropertiesBinding::name";



		public static String model = "mapping::EMFMultiPropertiesBinding::model";


		public static String views = "mapping::EMFMultiPropertiesBinding::views";



	}

	/**
	 * ModelNavigation view descriptor
	 */
	public static class ModelNavigation {


	}

	/**
	 * SimpleModelNavigation view descriptor
	 */
	public static class SimpleModelNavigation {

		public static String index = "mapping::SimpleModelNavigation::index";


		public static String feature = "mapping::SimpleModelNavigation::feature";


		public static String discriminatorType = "mapping::SimpleModelNavigation::discriminatorType";



	}

}

