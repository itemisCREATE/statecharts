/** 
 * Copyright (c) 2019 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.types.generator.statechart.java.modification

import com.google.inject.Inject
import java.util.Collection
import org.yakindu.base.expressions.util.ExpressionBuilder
import org.yakindu.base.expressions.util.PackageNavigationExtensions
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Package
import org.yakindu.base.types.Property
import org.yakindu.base.types.Type
import org.yakindu.base.types.TypeBuilder
import org.yakindu.sct.types.generator.java.modifications.ConstructorBuilder
import org.yakindu.sct.types.generator.modification.library.ComplexTypeNavigationExtensions
import org.yakindu.sct.types.modification.IModification

/**
 * Creates a default constructor for the state machine which initializes all interface properties
 */
class InitializeInterfacePropertiesModification implements IModification {
	
	@Inject protected extension PackageNavigationExtensions
	@Inject protected extension ComplexTypeNavigationExtensions
	@Inject protected extension ExpressionBuilder
	@Inject protected extension TypeBuilder
	@Inject protected extension ConstructorBuilder
	
	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package p) {
		p.allTopLevelComplexTypes.forEach[ct |
			ct.defaultConstructor => [
				body = _block(
					ct.interfaceProperties.map[prop |
						prop.initialize
					]
				)
			]
		]
		p
	}
	
	protected def getInterfaceProperties(ComplexType ct) {
		ct.features.filter(Property).filter[type.isInterfaceType].toList
	}
	
	protected def isInterfaceType(Type t) {
		t.getAnnotationOfType("InterfaceGroup") !== null
	}
	
	protected def initialize(Property p) {
		val ct = p.type as ComplexType
		p._ref._assign(ct._ref._fc(ct.defaultConstructor))
	}
	
}
