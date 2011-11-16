/**
 *  Copyright (c) 2008 - 2010 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Obeo - initial API and implementation
 *
 */
package org.eclipse.emf.eef.mapping.filters.parts;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class FiltersViewsRepository {

	public static final int SWT_KIND = 0;

	public static final int FORM_KIND = 1;


	/**
	 * OnlyReferenceTypeFilter view descriptor
	 * 
	 */
	public static class OnlyReferenceTypeFilter {
		public static class ReferencedFeature {
	
			
			public static String referencedFeature_ = "filters::OnlyReferenceTypeFilter::Referenced feature::referencedFeature_";
			
	
		}
	
	
	public static String filterProperties = "filters::OnlyReferenceTypeFilter::filter properties";
	
	}

	/**
	 * OCLFilter view descriptor
	 * 
	 */
	public static class OCLFilter {
		public static class FilterExpression {
	
			
			public static String oCLExpressionBody = "filters::OCLFilter::Filter expression::OCLExpressionBody";
			
	
		}
	
	
	public static String filterProperties = "filters::OCLFilter::filter properties";
	
	}

	/**
	 * JavaExpressionFilter view descriptor
	 * 
	 */
	public static class JavaExpressionFilter {
		public static class FilterExpression {
	
			
			public static String javaExpressionBody = "filters::JavaExpressionFilter::Filter expression::javaExpressionBody";
			
	
		}
	
	
	public static String filterProperties = "filters::JavaExpressionFilter::filter properties";
	
	}

	/**
	 * JavaDeclarationFilter view descriptor
	 * 
	 */
	public static class JavaDeclarationFilter {
		public static class FilterExpression {
	
			
			public static String methodName = "filters::JavaDeclarationFilter::Filter expression::methodName";
			
	
		}
	
	
	public static String filterProperties = "filters::JavaDeclarationFilter::filter properties";
	
	}

	/**
	 * StrictTypingFilter view descriptor
	 * 
	 */
	public static class StrictTypingFilter {
		public static class Type {
	
			
			public static String restriction = "filters::StrictTypingFilter::Type::Restriction";
			
	
		}
	
	
	public static String filterProperties = "filters::StrictTypingFilter::filter properties";
	
	}

	/**
	 * Filter properties view descriptor
	 * 
	 */
	public static class FilterProperties {
		public static class FilterProperties_ {
	
			
			public static String name = "filters::Filter properties::Filter Properties_::Name";
			
			
			public static String mandatory = "filters::Filter properties::Filter Properties_::Mandatory";
			
	
		}
	
	}

}
