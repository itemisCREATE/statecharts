package org.yakindu.sct.types.generator.modification.library

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Property
import org.yakindu.sct.model.sequencer.ModelSequencerNaming

class ModificationHelper {

	@Inject extension ModelSequencerNaming

	def getOwnerInstance(EObject obj) {
		val ct = obj.eContainer
		if (ct instanceof ComplexType) {
			val outerClass = ct.eContainer
			if (outerClass instanceof ComplexType) {
				return outerClass.features.filter(Property).findFirst[type === ct]
			}
		}
	}

	def statemachineInterfaceName(ComplexType ct) {
		if(ct.name !== defaultInterfaceTypeName) return "SCI" + ct.name else return ct.name
	}

}
