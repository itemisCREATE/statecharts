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
package org.yakindu.sct.types.generator.statechart.java

import org.yakindu.sct.types.generator.java.JavaTypesGeneratorModule
import org.yakindu.sct.types.generator.statechart.SCTGeneratorModule
import org.yakindu.sct.types.generator.statechart.java.artifacts.JavaGeneratorArtifactConfigurator
import org.yakindu.sct.types.generator.statechart.java.modification.DefaultInterfacePropertyAccessModification
import org.yakindu.sct.types.generator.statechart.java.modification.InitializeInterfacePropertiesModification
import org.yakindu.sct.types.generator.statechart.java.modification.InterfaceLiftingModification
import org.yakindu.sct.types.generator.statechart.java.modification.OperationCallbackModification
import org.yakindu.sct.types.generator.statechart.java.modification.ReplaceIntegerWithLongModification
import org.yakindu.sct.types.generator.statechart.java.modification.UnwrapInternalInterfaceModification
import org.yakindu.sct.types.generator.statechart.java.naming.JavaNamingService
import org.yakindu.sct.types.generator.statechart.java.naming.JavaPropertyAccessNaming
import org.yakindu.sct.types.generator.statechart.modification.library.PropertyAccessModification
import org.yakindu.sct.types.generator.statechart.modification.library.PropertyReferenceModification

class JavaSCTGeneratorModule extends SCTGeneratorModule {
	
	override bindNamingService() {
		JavaNamingService
	}
	
	override bindOutputConfigurator() {
		JavaGeneratorArtifactConfigurator
	}
	
	override bindPropertyAccessNaming() {
		JavaPropertyAccessNaming
	}
	
	override getCoreGeneratorModule() {
		JavaTypesGeneratorModule
	}
	
	override getModifications() {
		#[
			PropertyAccessModification, 
			PropertyReferenceModification,
			
			ReplaceIntegerWithLongModification,
			UnwrapInternalInterfaceModification,
			DefaultInterfacePropertyAccessModification,
			InitializeInterfacePropertiesModification,
			InterfaceLiftingModification,
			OperationCallbackModification
		]
	}
	
}
