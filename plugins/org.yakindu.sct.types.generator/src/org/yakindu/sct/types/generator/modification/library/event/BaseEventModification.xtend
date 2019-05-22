/**
* Copyright (c) 2019 itemis AG - All rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* 
* Contributors:
* 	itemis AG
*
*/
package org.yakindu.sct.types.generator.modification.library.event

import com.google.inject.Inject
import java.util.Collection
import org.yakindu.base.expressions.expressions.ExpressionsFactory
import org.yakindu.base.expressions.util.ExpressionsHelper
import org.yakindu.base.types.Direction
import org.yakindu.base.types.Event
import org.yakindu.base.types.Package
import org.yakindu.base.types.Property
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.Visibility
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.types.generator.naming.IEventNaming
import org.yakindu.sct.types.modification.IModification

abstract class BaseEventModification implements IModification {
	@Inject
	protected extension ITypeSystem ts
	@Inject
	protected extension ExpressionsHelper
	@Inject 
	protected extension IEventNaming

	protected TypesFactory typesFactory = TypesFactory.eINSTANCE
	protected ExpressionsFactory expFactory = ExpressionsFactory.eINSTANCE
	
	override modify(Collection<Package> packages) {
		packages.forEach[modify]
		packages
	}

	def modify(Package p) {
		p.eAllContents.filter(Event).toList.forEach [ e |
			switch (e.direction) {
				case Direction.IN: {
					e.modifyInEvent
				}
				case Direction.OUT: {
					e.modifyOutEvent
				}
				case Direction.LOCAL: {
					e.modifyLocalEvent
				}
			}
		]
		p
	}

	def void modifyInEvent(Event e) {}

	def void modifyOutEvent(Event e) {}

	def void modifyLocalEvent(Event e) {}
	
	protected def Property createEventFlag(Event e) {
		typesFactory.createProperty => [ prop |
			prop.name = nameEventRaised(e.name)
			prop.typeSpecifier = typesFactory.createTypeSpecifier => [
				type = ts.getType(ITypeSystem.BOOLEAN)
				prop.visibility = Visibility.PROTECTED
			]
		]
	}
	
	protected def Property createEventValueProp(Event e) {
		typesFactory.createProperty => [ prop |
			prop.name = nameEventValue(e.name)
			prop.typeSpecifier = typesFactory.createTypeSpecifier => [
				type = e.type
				prop.visibility = Visibility.PROTECTED
			]
		]
	}
	
	protected def boolean hasPayload(Event e) {
		e.type !== null && e.type !== ts.getType(ITypeSystem.VOID)
	}

}
