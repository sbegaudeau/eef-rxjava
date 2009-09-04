/**
 * Generated with Acceleo
 */
package org.eclipse.emf.samples.conference.parts;

/**
 * @author
 */
public class ConferenceViewsRepository {

	public static final int SWT_KIND = 0;
		
	public static final int FORM_KIND = 1;

	
	/**
	 * Conference view descriptor
	 */
	public static class Conference {
		public static String place = "conference::Conference::place";	

		public static String sites = "conference::Conference::sites";	


	}

	/**
	 * Person view descriptor
	 */
	public static class Person {
		public static String firstname = "conference::Person::firstname";	

		public static String lastname = "conference::Person::lastname";	

		public static String age = "conference::Person::age";	

		public static String gender = "conference::Person::gender";	


		public static String eclipseCommiter = "conference::Person::eclipseCommiter";	

		public static String isRegistered = "conference::Person::isRegistered";	


	}

	/**
	 * Presence view descriptor
	 */
	public static class Presence {
		public static String assists = "conference::Presence::assists";	


	}

	/**
	 * Talk view descriptor
	 */
	public static class Talk {
		public static String title = "conference::Talk::title";	

		public static String topic = "conference::Talk::topic";	

		public static String type = "conference::Talk::type";	

		public static String presenter = "conference::Talk::presenter";	

		public static String creator = "conference::Talk::creator";	

		public static String documentation = "conference::Talk::documentation";	


	}

	/**
	 * Topic view descriptor
	 */
	public static class Topic {
		public static String description = "conference::Topic::description";	

		public static String references = "conference::Topic::references";	

		public static String documentation = "conference::Topic::documentation";	


	}

	/**
	 * Site view descriptor
	 */
	public static class Site {
		public static String name = "conference::Site::name";	

		public static String documentation = "conference::Site::documentation";	


	}

}
