package org.yakindu.sct.refactoring.refactor.util;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.EqualityHelper;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;

public class SctEqualityHelper extends EqualityHelper{

	@Override
	public boolean equals(EObject eObject1, EObject eObject2) {
		
		if (eObject1!=null && eObject1.eIsProxy()) {
			EcoreUtil.resolve(eObject1, eObject2.eResource());
		}
		if (eObject2!=null && eObject2.eIsProxy()) {
			EcoreUtil.resolve(eObject2, eObject1.eResource());
		}
		
		return super.equals(eObject1, eObject2);
	}
	
	@Override
	protected boolean haveEqualAttribute(EObject eObject1, EObject eObject2,
			EAttribute attribute) {
		
		Object value1 = eObject1.eGet(attribute);
		Object value2 = eObject2.eGet(attribute);

		// If the first value is null, the second value must be null.
		//
		if (value1 == null) {
			return value2 == null;
		}
		
		// Since the first value isn't null, if the second one is, they aren't equal.
		//
		if (value2 == null) {
			return false;
		}

		// If this is a feature map...
		//
		if (FeatureMapUtil.isFeatureMap(attribute)) {
			// The feature maps must be equal.
			//
			FeatureMap featureMap1 = (FeatureMap)value1;
			FeatureMap featureMap2 = (FeatureMap)value2;
			return equalFeatureMaps(featureMap1, featureMap2);
		}
		else {
			if (value1 instanceof String && value2 instanceof String) {
				String wsFreeValue1 = removeWhitespaces((String)value1);
				String wsFreeValue2 = removeWhitespaces((String)value2);
				return wsFreeValue1.equals(wsFreeValue2);
			}
			
			return value1.equals(value2);
		}
	}

	private String removeWhitespaces(String input) {
		return input.replaceAll(" ", "");
	}
}
