package org.yakindu.sct.model.sexec.naming

import javax.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.yakindu.base.base.NamedElement
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionNode
import org.yakindu.sct.model.sexec.ExecutionScope
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.Vertex
import org.yakindu.sct.model.stext.naming.StextNameProvider
import org.eclipse.xtext.naming.QualifiedName
import org.yakindu.sct.model.sexec.Reaction

class ElementNameProvider {
	@Inject private StextNameProvider provider
	
	def protected dispatch QualifiedName elementName(ExecutionFlow it) {
		return null;
	}
	
	def protected dispatch QualifiedName elementName(ExecutionScope it) {
		return sourceElement.elementName()
	}

	def protected dispatch QualifiedName elementName(ExecutionState it) {
		return sourceElement.elementName()
	}
	
	def protected dispatch QualifiedName elementName(EObject it) {
		eContainer?.elementName()
	}

	def protected dispatch QualifiedName elementName(ExecutionNode it) {
		return provider.getFullyQualifiedName(it).skipFirst(2)
	}

	// TODO: we should merge the region/vertex case into this base implementation; we should check whether it is used in any case at all (otherwise it could be replaced with the body of vertexOrRegionName)
	def protected dispatch QualifiedName elementName(NamedElement it) {
		return provider.getFullyQualifiedName(it).skipFirst(2)
	}
	
	def protected dispatch QualifiedName elementName(Reaction it) {
		return provider.getFullyQualifiedName(it).skipFirst(2)
	}
	
	def protected dispatch QualifiedName elementName(Region it) {
		return provider.getFullyQualifiedName(it).skipFirst(1)
	}
	
	def protected dispatch QualifiedName elementName(Step it) {
		return eContainer.elementName()
	}

	def protected dispatch QualifiedName elementName(Vertex it) {
		return provider.getFullyQualifiedName(it).skipFirst(1)
	}
}