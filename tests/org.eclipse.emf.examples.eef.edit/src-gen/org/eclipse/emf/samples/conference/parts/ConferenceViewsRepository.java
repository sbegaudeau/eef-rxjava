/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.samples.conference.parts;

/**
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 * 
 */
public class ConferenceViewsRepository {

	public static final int SWT_KIND = 0;

	public static final int FORM_KIND = 1;


	/**
	 * Conference view descriptor
	 * 
	 */
	public static class Conference_ {
		public static class Properties {
	
			
			public static String name = "conference::Conference_::Properties::name";
			
			
			public static String overview = "conference::Conference_::Properties::overview";
			
	
		}
	
	}

	/**
	 * Conference localisation view descriptor
	 * 
	 */
	public static class ConferenceLocalisation {
	
	public static String place = "conference::Conference localisation::place";
	
	
	public static String sites = "conference::Conference localisation::sites";
	
	}

	/**
	 * Person view descriptor
	 * 
	 */
	public static class Person {
		public static class Identity {
	
			
			public static String firstname = "conference::Person::Identity::firstname";
			
			
			public static String lastname = "conference::Person::Identity::lastname";
			
			
			public static String age = "conference::Person::Identity::age";
			
			
			public static String gender = "conference::Person::Identity::gender";
			
	
		}
	
		public static class EclipseStatus {
	
			
			public static String eclipseCommiter = "conference::Person::Eclipse Status::eclipseCommiter";
			
			
			public static String isRegistered = "conference::Person::Eclipse Status::isRegistered";
			
	
		}
	
	}

	/**
	 * Presence view descriptor
	 * 
	 */
	public static class Presence {
		public static class Talks {
	
			
			public static String assists = "conference::Presence::Talks::assists";
			
	
		}
	
	}

	/**
	 * Talk view descriptor
	 * 
	 */
	public static class Talk {
		public static class Properties {
	
			
			public static String title_ = "conference::Talk::properties::title";
			
			
			public static String topic = "conference::Talk::properties::topic";
			
			
			public static String type = "conference::Talk::properties::type";
			
			
			public static String presenter = "conference::Talk::properties::presenter";
			
			
			public static String creator = "conference::Talk::properties::creator";
			
			
			public static String documentation = "conference::Talk::properties::documentation";
			
	
		}
	
	}

	/**
	 * Topic view descriptor
	 * 
	 */
	public static class Topic {
		public static class Properties {
	
			
			public static String description = "conference::Topic::properties::description";
			
			
			public static String references = "conference::Topic::properties::references";
			
			
			public static String documentation = "conference::Topic::properties::documentation";
			
	
		}
	
	}

	/**
	 * Site view descriptor
	 * 
	 */
	public static class Site {
		public static class Properties {
	
			
			public static String name = "conference::Site::properties::name";
			
			
			public static String documentation = "conference::Site::properties::documentation";
			
	
		}
	
	}

}
