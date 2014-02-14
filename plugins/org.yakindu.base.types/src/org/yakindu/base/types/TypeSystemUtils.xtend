/**
 * Copyright (c) 2014 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 * 
 */
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