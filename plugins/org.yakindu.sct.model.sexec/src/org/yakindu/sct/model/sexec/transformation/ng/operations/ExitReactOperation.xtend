package org.yakindu.sct.model.sexec.transformation.ng.operations

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.List
import org.yakindu.base.expressions.util.ExpressionBuilder
import org.yakindu.base.types.Expression
import org.yakindu.base.types.TypeBuilder
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions
import org.yakindu.sct.model.sexec.transformation.ng.RegionType
import org.yakindu.sct.model.sexec.transformation.ng.expressions.EffectToExpression
import org.yakindu.sct.model.sgraph.Exit
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sgraph.Synchronization
import org.yakindu.sct.model.sgraph.Transition
import org.yakindu.sct.model.sgraph.Vertex

@Singleton
class ExitReactOperation {

	@Inject extension SgraphExtensions
	@Inject extension RegionType
	@Inject extension TypeBuilder
	@Inject extension ExpressionBuilder
	@Inject extension EffectToExpression

	def declareExitReactOperations(Statechart sc) {
		sc.eAllContents.filter(Region).forEach [ r |
			r.vertices.filter(Exit).forEach [ e |
				e.exitReactOperation
			]
		]
	}

	def defineExitReactOperations(Statechart sc) {
		sc.eAllContents.filter(Region).forEach [ r |
			r.vertices.filter(Exit).forEach [ e |
				e.defineExitReactOperation
			]
		]
	}

	def create _op exitReactOperation(Exit exit) {
		name = exit.reactionName
		exit.parentRegion.type.features += it
	}

	def protected defineExitReactOperation(Exit exit) {
		exit.exitReactOperation => [
			body = _block(exit.reactions)
		]
	}

	def reactionName(Exit exit) {
		"exitreact_" + if(exit.name.isNullOrEmpty) "default" else exit.name
	}

	def reactions(Exit exit) {
		val List<Expression> reactions = newArrayList

		// find the transition that relates to the matching exit point
		val exitName = if(exit.name.empty) 'default' else exit.name
		val outTransitions = (exit.parentRegion.composite as Vertex).outgoingTransitions
		
		var exitTrans = outTransitions.filter(t|t.hasNoTrigger && t.exitPointName.equals(exitName)).head
		if (exitTrans === null) {
			exitTrans = outTransitions.filter(t|t.hasNoTrigger && t.exitPointName.equals('default')).head
		}

		if (exitTrans !== null) {
			reactions += #[exitTrans].toEffectExpressions
		}
//		if ( trace.addTraceSteps ) execExit.reactSequence.steps.add(0,it.create.newTraceNodeExecuted)
		reactions
	}

	def protected hasNoTrigger(Transition t) {
		return t.trigger === null && !(t.target instanceof Synchronization)
	}
}
