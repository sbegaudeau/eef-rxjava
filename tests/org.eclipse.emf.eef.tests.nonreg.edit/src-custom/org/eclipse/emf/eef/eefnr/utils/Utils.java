/**
 * 
 */
package org.eclipse.emf.eef.eefnr.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.eefnr.navigation.FirstModelNavigation;
import org.eclipse.emf.eef.eefnr.navigation.NavigationFactory;
import org.eclipse.emf.eef.eefnr.navigation.SecondModelNavigation;
import org.eclipse.emf.eef.eefnr.navigation.SmartModelNavigationSample;


/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 *
 */
public class Utils {
	
	public FirstModelNavigation initFirstModelNavigationSingleValue2(EObject semanticObject) {
		if (semanticObject instanceof SmartModelNavigationSample) {
			FirstModelNavigation result = NavigationFactory.eINSTANCE.createFirstModelNavigation();
			result.setName("FSM single");
			((SmartModelNavigationSample) semanticObject).setFirstModelNavigation2(result);
			return result;
		}
		return null;
	}
	
	public static FirstModelNavigation initFirstModelNavigationMultiValue2(EObject semanticObject) {
		if (semanticObject instanceof SmartModelNavigationSample) {
			FirstModelNavigation result = NavigationFactory.eINSTANCE.createFirstModelNavigation();
			((SmartModelNavigationSample) semanticObject).getSeveralFirstModelNavigation2().add(result);
			result.setName("FSM multi");
			return result;
		}
		return null;
	}
	
	public FirstModelNavigation initFirstModelNavigationSingleValue(EObject semanticObject) {
		if (semanticObject instanceof SmartModelNavigationSample) {
			FirstModelNavigation result = NavigationFactory.eINSTANCE.createFirstModelNavigation();
			result.setName("FSM single");
			((SmartModelNavigationSample) semanticObject).setFirstModelNavigation(result);
			return result;
		}
		return null;
	}
	
	public static FirstModelNavigation initFirstModelNavigationMultiValue(EObject semanticObject) {
		if (semanticObject instanceof SmartModelNavigationSample) {
			FirstModelNavigation result = NavigationFactory.eINSTANCE.createFirstModelNavigation();
			((SmartModelNavigationSample) semanticObject).getSeveralFirstModelNavigation().add(result);
			result.setName("FSM multi");
			return result;
		}
		return null;
	}
	
	public static FirstModelNavigation initFirstModelNavigationMultiValueWithFilters(EObject semanticObject) {
		if (semanticObject instanceof SmartModelNavigationSample) {
			FirstModelNavigation result = NavigationFactory.eINSTANCE.createFirstModelNavigation();
			((SmartModelNavigationSample) semanticObject).getSeveralFirstModelNavigation().add(result);
			result.setName("FSM multi with filters");
			result.setFilter1(true);
			result.setFilter2(true);
			return result;
		}
		return null;
	}
	
	public SecondModelNavigation initSecondModelNavigationSingleValue(EObject semanticObject) {
		if (semanticObject instanceof FirstModelNavigation) {
			SecondModelNavigation result = NavigationFactory.eINSTANCE.createSecondModelNavigation();
			((FirstModelNavigation) semanticObject).setSecondModelNavigation(result);
			result.setName("SSM single");
			return result;
		}
		return null;
	}
	
	public SecondModelNavigation initSecondModelNavigationMultiValue(EObject semanticObject) {
		if (semanticObject instanceof FirstModelNavigation) {
			SecondModelNavigation result = NavigationFactory.eINSTANCE.createSecondModelNavigation();
			((FirstModelNavigation) semanticObject).getSeveralSecondModelNavigation().add((SecondModelNavigation) result);
			result.setName("SSM single");
			return result;
		}
		return null;
	}
	
	public boolean filter1FirstModelNavigation(EObject semanticElement) {
		return semanticElement instanceof FirstModelNavigation && ((FirstModelNavigation) semanticElement).isFilter1();
	}
	
	public static boolean filter2FirstModelNavigation(EObject semanticElement) {
		return semanticElement instanceof FirstModelNavigation && ((FirstModelNavigation) semanticElement).isFilter2();
	}
	
	public static boolean filter3FirstModelNavigation(EObject semanticElement) {
		return semanticElement instanceof SecondModelNavigation && ((SecondModelNavigation) semanticElement).isFilter3();
	}
	
	public boolean filter4FirstModelNavigation(EObject semanticElement) {
		return semanticElement instanceof SecondModelNavigation && ((SecondModelNavigation) semanticElement).isFilter4();
	}

}
