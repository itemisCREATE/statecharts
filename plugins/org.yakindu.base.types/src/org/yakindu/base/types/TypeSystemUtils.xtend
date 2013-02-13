package org.yakindu.base.types

import java.util.Collection
import org.yakindu.base.types.EnumerationType

class TypeSystemUtils {
	
	def Collection<EnumerationType> getEnumerationTypes(ITypeSystem ts){
		return ts.types.filter(typeof (EnumerationType)).toList
	}
	
	def Collection<PrimitiveType> getPrimitiveTypes(ITypeSystem ts){
		return ts.types.filter(typeof (PrimitiveType)).toList
	}
	
	def Collection<ComplexType> getComplexTypes(ITypeSystem ts){
		return ts.types.filter(typeof (ComplexType)).toList
	}
}