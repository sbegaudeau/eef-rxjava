/*******************************************************************************
 * Copyright (c) 2008, 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - Initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.codegen.ecore.services.wrappers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage.AnnotationReferenceData;
import org.eclipse.emf.codegen.ecore.genmodel.impl.Literals;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
/**
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 * @since 1.1
 */
public class EAnnotationWrapper {

	public String writeKeyValuePairs(EAnnotation eAnnotation, GenModel genModel) {
		StringBuilder b = new StringBuilder();
		for (Iterator<Map.Entry<String, String>> l = eAnnotation.getDetails()
				.iterator(); l.hasNext();) {
			Map.Entry<String, String> detail = l.next();
			String key = Literals.toStringLiteral(detail.getKey(), genModel);
			String value = Literals
					.toStringLiteral(detail.getValue(), genModel);
			b.append(key).append(", ").append(value)
					.append(l.hasNext() ? "," : "")
					.append(genModel.getNonNLS(key + value));
			if (l.hasNext())
				b.append("\t\t\t ");
		}
		return b.toString();
	}

	public boolean hasReferenceData(EAnnotation eAnnotation,
			GenPackage genPackage) {
		List<GenPackage.AnnotationReferenceData> refData = getRefData(
				eAnnotation, genPackage);
		return refData == null || refData.isEmpty();
	}

	public int referenceDataSize(EAnnotation eAnnotation,
			GenPackage genPackage) {
		List<GenPackage.AnnotationReferenceData> refData = getRefData(
				eAnnotation, genPackage);
		return refData == null ? 0 : refData.size();
	}
	
	public int depth(EAnnotation eAnnotation) {
		int depth = 0;
		EObject eCont = eAnnotation.eContainer();
		if (eCont instanceof EAnnotation) {
			depth = depth((EAnnotation) eCont) + 1; 
		}
		return depth;
	}
	
	public List<List<Object>> getReferenceData(EAnnotation eAnnotation, GenPackage genPackage) {
		List<AnnotationReferenceData> refData = genPackage.getReferenceData(eAnnotation);
		List<List<Object>> result = new ArrayList<List<Object>>();
		for (AnnotationReferenceData annotationReferenceData : refData) {
			result.add(Arrays.asList(annotationReferenceData.containingGenPackage, annotationReferenceData.uriFragment));
		}
		return result;
	}

	private List<GenPackage.AnnotationReferenceData> getRefData(
			EAnnotation nestedEAnnotation, GenPackage genPackage) {
		return genPackage.getReferenceData(nestedEAnnotation);
	}
}
