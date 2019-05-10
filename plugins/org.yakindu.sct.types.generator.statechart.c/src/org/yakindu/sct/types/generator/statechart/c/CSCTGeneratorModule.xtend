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
package org.yakindu.sct.types.generator.statechart.c

import org.yakindu.sct.types.generator.c.CTypesGeneratorModule
import org.yakindu.sct.types.generator.statechart.SCTGeneratorModule
import org.yakindu.sct.types.generator.statechart.c.artifacts.CGeneratorArtifactConfigurator
import org.yakindu.sct.types.generator.statechart.c.modification.RenameInterfacesModification
import org.yakindu.sct.types.generator.statechart.c.naming.CEventNaming
import org.yakindu.sct.types.generator.statechart.c.naming.CNamingService
import org.yakindu.sct.types.generator.statechart.c.naming.CPropertyAccessNaming
import org.yakindu.sct.types.generator.statechart.modification.library.PropertyAccessModification
import org.yakindu.sct.types.generator.statechart.modification.library.event.InEventModification
import org.yakindu.sct.types.generator.statechart.modification.library.event.LocalEventModification
import org.yakindu.sct.types.generator.statechart.modification.library.event.OutEventModification

class CSCTGeneratorModule extends SCTGeneratorModule {
	
	override bindEventNaming() {
		CEventNaming
	}
	
	override bindPropertyAccessNaming() {
		CPropertyAccessNaming
	}
	
	override getModifications() {
		return #[
			// base modifications
			PropertyAccessModification, 
			InEventModification,
			OutEventModification,
			LocalEventModification,
			
			// c specific modifcations
			RenameInterfacesModification		
		]
	}
	
	override bindOutputConfigurator() {
		CGeneratorArtifactConfigurator
	}
	
	override bindNamingService() {
		CNamingService
	}
	
	override getCoreGeneratorModule() {
		new CTypesGeneratorModule
	}
	
}