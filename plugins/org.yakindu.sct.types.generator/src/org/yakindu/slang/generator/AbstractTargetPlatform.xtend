/**
* Copyright (c) 2019 itemis AG - All rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* 
* Contributors:
* 	itemis AG
*
*/
package org.yakindu.slang.generator

import com.google.inject.Inject
import java.util.Map
import org.yakindu.base.types.Type
import org.yakindu.base.types.TypesFactory
import org.yakindu.sct.generator.core.library.ICoreLibraryHelper
import org.yakindu.slang.generator.typesystem.SlangTypeSystem

abstract class AbstractTargetPlatform implements ITargetPlatform {
	@Inject protected SlangTypeSystem slangTs
	@Inject protected ICoreLibraryHelper libraryHelper
	
	protected TypesFactory factory = TypesFactory.eINSTANCE
	
	protected Map<Type, Type> replacementTypes
	
	def protected void createTypes();
	
	override getReplacementType(Type type) {
		if(replacementTypes === null) {
			createTypes
		}
		replacementTypes.get(type)
	}
	
	def protected getSlangType(String name) {
		slangTs.getType(name)
	}
	
}
