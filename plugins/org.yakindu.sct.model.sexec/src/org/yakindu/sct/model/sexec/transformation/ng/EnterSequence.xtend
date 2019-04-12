/**
 * Copyright (c) 2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 *  axel terfloth - itemis AG
 */
package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.emf.ecore.EObject
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Operation
import org.yakindu.sct.model.sexec.transformation.SexecExtensions
import org.yakindu.sct.model.sexec.transformation.TypeBuilder
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.RegularState

@Singleton class EnterSequence {

	@Inject extension TypeBuilder tBuilder
	
	@Inject protected extension StateType
	@Inject protected extension RegionType
	
	def create op : _op enterSequence(ComplexType it, String entryName){
		features += op
		op.name = enterSequenceOperationName(entryName)
	}
	
	def resolveEnterSequence(ComplexType it, String entryName) {
		val op = enterSequenceByName(entryName)
		
		return 
			if (op !== null) op 
			else defaultEnterSequence
	}
	
	def resolveEnterSequence(TargetEntrySpec it) {
		target.toType?.resolveEnterSequence(entryPointName)
	}
	
	def dispatch toType(EObject it) { null }
	def dispatch toType(RegularState it) { type }
	def dispatch toType(Region it) { type }
	
	def defaultEnterSequence(ComplexType it) {
		enterSequenceByName(SexecExtensions.DEFAULT_SEQUENCE_NAME)
	}

	def enterSequenceByName(ComplexType it, String entryName) {
		features.filter(Operation).findFirst[name == enterSequenceOperationName(entryName)]
	}

	def enterSequenceOperationName(String entryName) {
		"enter_" + entryName
	}
}