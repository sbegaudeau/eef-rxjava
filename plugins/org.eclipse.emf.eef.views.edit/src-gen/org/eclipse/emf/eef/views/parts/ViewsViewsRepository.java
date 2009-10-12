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
 */
package org.eclipse.emf.eef.views.parts;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class ViewsViewsRepository {

	public static final int SWT_KIND = 0;

	public static final int FORM_KIND = 1;


	/**
	 * Documentation view descriptor
	 */
	public static class Documentation {
		public static String documentation = "views::Documentation::documentation";	


	}

	/**
	 * ViewsRepository view descriptor
	 */
	public static class ViewsRepository {
		public static String name = "views::ViewsRepository::name";	

	public static String repositoryKind = "views::ViewsRepository::RepositoryKind";	


	}

	/**
	 * View view descriptor
	 */
	public static class View {
		public static String name = "views::View::name";	

	public static String representation = "views::View::representation";	

	public static String explicit = "views::View::explicit";	


	}

	/**
	 * ElementEditor view descriptor
	 */
	public static class ElementEditor {
		public static String name = "views::ElementEditor::name";	

	public static String representation = "views::ElementEditor::representation";	

	public static String readOnly = "views::ElementEditor::readOnly";	


	}

	/**
	 * Category view descriptor
	 */
	public static class Category {
		public static String name = "views::Category::name";	


	}

	/**
	 * Container view descriptor
	 */
	public static class Container {
		public static String name = "views::Container::name";	

	public static String representation = "views::Container::representation";	


	}

	/**
	 * CustomElementEditor view descriptor
	 */
	public static class CustomElementEditor {
		public static String name = "views::CustomElementEditor::name";	

	public static String representation = "views::CustomElementEditor::representation";	

	public static String readOnly = "views::CustomElementEditor::readOnly";	


	}

	/**
	 * CustomView view descriptor
	 */
	public static class CustomView {
		public static String name = "views::CustomView::name";	


	}

	/**
	 * ViewReference view descriptor
	 */
	public static class ViewReference {
		public static String name = "views::ViewReference::name";	

	public static String referencedView = "views::ViewReference::referencedView";	


	}

}
