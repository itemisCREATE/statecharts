/**
* Copyright (c) 2019 itemis AG - All rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* 
* Contributors:
* 	itemis AG
*
*/
package org.yakindu.sct.types.generator.typesystem

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Delegate
import org.yakindu.base.types.typesystem.GenericTypeSystem
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.types.generator.typesystem.TargetPlatformProvider

class DelegatingTypeSystem implements ITypeSystem {

	@Delegate
	ITypeSystem delegate = GenericTypeSystem.instance
	@Inject
	TargetPlatformProvider provider

	def setContext(EObject object) {
		delegate = provider.getTypeSystem(object)
	}

}
