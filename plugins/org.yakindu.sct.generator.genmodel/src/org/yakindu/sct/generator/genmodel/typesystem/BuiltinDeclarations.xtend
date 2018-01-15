/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	rbeckmann - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.genmodel.typesystem

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl
import org.eclipse.xtend.lib.annotations.Accessors
import org.yakindu.base.types.Property
import org.yakindu.base.types.Type
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.sgen.util.BuiltinDeclarationNames

/**
 * @author rbeckmann
 * 
 */
@Accessors(PUBLIC_GETTER)
@Singleton
class BuiltinDeclarations implements BuiltinDeclarationNames {
	protected TypesFactory typesFactory
	protected ITypeSystem typeSystem

	protected Property sct_version
	protected Property timestamp
	protected Property hostname
	protected Property username

	protected Resource builtinResource

	@Inject
	new(ITypeSystem typeSystem) {
		this.typesFactory = TypesFactory.eINSTANCE
		this.typeSystem = typeSystem
		builtinResource = new XMIResourceImpl
		val stringtype = typeSystem.getType(ITypeSystem.STRING)
		sct_version = createProperty(SCT_VERSION_VAR, stringtype)
		timestamp = createProperty(TIMESTAMP_VAR, stringtype)
		hostname = createProperty(HOSTNAME_VAR, stringtype)
		username = createProperty(USER_VAR, stringtype)
	}

	def protected Property createProperty(String name, Type type) {
		typesFactory.createProperty => [ prop |
			builtinResource.contents += prop

			prop.name = name
			prop.typeSpecifier = typesFactory.createTypeSpecifier => [
				it.type = type
			]
			prop.const = false
			prop.readonly = false
		]
	}

	def getDeclarations() {
		#[
			sct_version,
			timestamp,
			hostname,
			username
		]
	}

}
