/**
 * Copyright (c) 2018 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	Andreas Muelder - itemis AG
 * 
 */
package org.yakindu.sct.model.sruntime;

import org.eclipse.emf.ecore.EDataType;
import org.yakindu.sct.model.sruntime.impl.SRuntimeFactoryImpl;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SRuntimeFactoryImplOverride extends SRuntimeFactoryImpl implements SRuntimeFactory {

	@Override
	public Object createJavaObjectFromString(EDataType eDataType, String initialValue) {
		int indexOf = initialValue.indexOf(":");
		String className = initialValue.substring(0, indexOf);
		String value = initialValue.substring(indexOf + 1);
		if (Boolean.class.getName().equals(className))
			return Boolean.parseBoolean(value);
		if (String.class.getName().equals(className))
			return value;
		if (Long.class.getName().equals(className))
			return Long.parseLong(value);
		if (Double.class.getName().equals(className))
			return Double.parseDouble(value);
		if (Integer.class.getName().equals(className))
			return Integer.parseInt(value);
		return super.createFromString(eDataType, initialValue);
	}

	@Override
	public String convertJavaObjectToString(EDataType eDataType, Object instanceValue) {
		StringBuilder builder = new StringBuilder();
		builder.append(instanceValue.getClass().getName());
		builder.append(":");
		builder.append(instanceValue);
		return builder.toString();
	}
}