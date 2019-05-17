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
