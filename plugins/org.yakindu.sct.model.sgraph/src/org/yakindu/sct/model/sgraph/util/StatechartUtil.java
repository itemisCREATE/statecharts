package org.yakindu.sct.model.sgraph.util;

import org.yakindu.base.types.ComplexType;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypeSpecifier;

public class StatechartUtil {
	public boolean isStatemachineType(Type type) {
		if (type instanceof ComplexType) {
			for(TypeSpecifier t : type.getSuperTypes()) {
				return t.getType().getName().equals("Statemachine");
			}
		}
		return false;
	}
}
