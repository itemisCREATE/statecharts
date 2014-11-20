package org.yakindu.sct.model.sexec.transformation

import com.google.inject.Inject
import com.google.inject.name.Named
import java.util.ArrayList
import org.yakindu.base.expressions.expressions.AssignmentOperator
import org.yakindu.base.expressions.expressions.BoolLiteral
import org.yakindu.base.expressions.expressions.Expression
import org.yakindu.base.expressions.expressions.ExpressionsFactory
import org.yakindu.base.expressions.expressions.IntLiteral
import org.yakindu.base.expressions.expressions.MultiplicativeOperator
import org.yakindu.base.expressions.expressions.NumericalMultiplyDivideExpression
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.base.expressions.expressions.RealLiteral
import org.yakindu.base.expressions.expressions.StringLiteral
import org.yakindu.base.types.ITypeSystem
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionRegion
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sexec.StateSwitch
import org.yakindu.sct.model.sgraph.FinalState
import org.yakindu.sct.model.sgraph.ImportDeclaration
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sgraph.Vertex
import org.yakindu.sct.model.stext.stext.TimeEventSpec
import org.yakindu.sct.model.stext.stext.TimeUnit
import org.yakindu.sct.model.stext.stext.VariableDefinition

import static extension org.eclipse.emf.ecore.util.EcoreUtil.*

class SequenceBuilder {

	@Inject extension StatechartExtensions sc
	@Inject extension SgraphExtensions sgraph
	@Inject extension SexecExtensions sexec
	@Inject extension SexecElementMapping mapping
	@Inject extension TraceExtensions trace

	@Inject extension ITypeSystem ts

	@Inject @Named("ADD_TRACES")
	boolean _addTraceSteps

	static String DEFAULT_SEQUENCE_NAME = "default"

	def void defineDeepEnterSequences(ExecutionFlow flow, Statechart sc) {
		for (r : sc.regions) {
			r.defineDeepEnterSequence
		}
	}

	def void defineDeepEnterSequence(State s) {
		for (r : s.regions) {
			r.defineDeepEnterSequence
		}
	}

	def void defineDeepEnterSequence(Region r) {
		for (s : r.vertices.filter(typeof(State))) {
			s.defineDeepEnterSequence
		}
		if (!r.requireDeepHistory) {
			return
		}
		val execRegion = r.create
		val seq = sexec.factory.createSequence
		seq.name = "deepEnterSequence"
		seq.comment = "deep enterSequence with history in child " + r.name

		seq.steps += r.defineDeepHistorySwitch
		execRegion.deepEnterSequence = seq
	}

	def StateSwitch defineDeepHistorySwitch(Region r) {
		val execRegion = r.create

		val StateSwitch sSwitch = sexec.factory.createStateSwitch
		sSwitch.stateConfigurationIdx = execRegion.stateVector.offset
		sSwitch.comment = "Handle deep history entry of " + r.name
		sSwitch.historyRegion = execRegion

		for (child : r.vertices.filter(typeof(State))) {

			//TODO consider direct children
			for (childLeaf : child.collectLeafStates(newArrayList).filter(
				c|c.create.stateVector.offset == sSwitch.stateConfigurationIdx)) {
				val execChild = child.create
				val seq = sexec.factory.createSequence
				seq.name = DEFAULT_SEQUENCE_NAME
				seq.comment = "enterSequence with history in child " + child.name + " for leaf " + childLeaf.name
				if (execChild.leaf) {
					seq.steps += execChild.enterSequences.defaultSequence.newCall
				} else {
					if(execChild.entryAction != null) seq.steps += execChild.entryAction.newCall
					if(trace.addTraceSteps) seq.steps += execChild.newTraceStateEntered
					for (childRegion : child.regions) {
						seq.steps += childRegion.create.deepEnterSequence.newCall
					}
				}
				sSwitch.cases += childLeaf.create.newCase(seq)
			}
		}

		return sSwitch
	}

	def void defineShallowEnterSequences(ExecutionFlow flow, Statechart sc) {
		val contents = sc.eAllContents
		for (r : contents.filter(typeof(Region)).toIterable) {
			if (r.requireShallowHistory) {
				val execRegion = r.create
				val seq = sexec.factory.createSequence
				seq.name = "shallowEnterSequence"
				seq.comment = "shallow enterSequence with history in child " + r.name

				seq.steps += r.defineShallowHistorySwitch
				execRegion.shallowEnterSequence = seq
			}
		}
	}

	def StateSwitch defineShallowHistorySwitch(Region r) {
		val execRegion = r.create

		val StateSwitch sSwitch = sexec.factory.createStateSwitch
		sSwitch.stateConfigurationIdx = execRegion.stateVector.offset
		sSwitch.comment = "Handle shallow history entry of " + r.name
		sSwitch.historyRegion = r.create

		for (child : r.vertices.filter(typeof(State))) {
			val execChild = child.create

			//TODO consider direct children
			for (childLeaf : child.collectLeafStates(newArrayList).filter(
				c|c.create.stateVector.offset == sSwitch.stateConfigurationIdx)) {
				sSwitch.cases += childLeaf.create.newCase(execChild.enterSequences.defaultSequence.newCall)
			}
		}

		return sSwitch
	}

	/**
	 * Defines the enter sequences of all states
	 */
	def void defineEnterSequences(ExecutionFlow flow, Statechart sc) {

		// iterate over all regions
		for (r : sc.regions)
			defineScopeEnterSequences(r)
	}

	def dispatch void defineScopeEnterSequences(Region r) {
		val execRegion = r.create

		// process all vertices of a region
		for (s : r.vertices)
			defineScopeEnterSequences(s)

		// create an enter sequence for each contained entry
		for (e : r.collectEntries) {
			val seq = sexec.factory.createSequence
			seq.name = if (e.name == null || e.name.trim == "")
				DEFAULT_SEQUENCE_NAME
			else
				e.name
			seq.comment = "'" + seq.name + "' enter sequence for region " + r.name

			val entryNode = e.create
			if (entryNode != null && entryNode.reactSequence != null) {
				seq.steps.add(entryNode.reactSequence.newCall);
			}

			execRegion.enterSequences += seq
		}
	}

	def dispatch void defineScopeEnterSequences(Vertex v) {
	}

	def dispatch void defineScopeEnterSequences(FinalState state) {
		val execState = state.create
		val seq = sexec.factory.createSequence
		seq.name = DEFAULT_SEQUENCE_NAME
		seq.comment = "Default enter sequence for state " + state.name
		if(execState.entryAction != null) seq.steps.add(execState.entryAction.newCall)

		if(_addTraceSteps) seq.steps += execState.newTraceStateEntered

		seq.steps += execState.newEnterStateStep
		execState.enterSequences += seq
	}

	def dispatch void defineScopeEnterSequences(State state) {

		val execState = state.create

		// first creates enter sequences for all contained regions
		state.regions.forEach(r|r.defineScopeEnterSequences)

		// get all entry point names used by incoming transitions
		val entryPointNames = state.incomingTransitions.map(t|t.entryPointName).toSet.toList

		// also include implicit entries by histories
		if (state.parentRegion.requireHistory) {
			if(!entryPointNames.contains('default')) entryPointNames.add('default')
		}

		// sort entry points by name ...
		entryPointNames.sortInplace

		// create an entry sequence for each entry point
		for (epName : entryPointNames) {
			val seq = sexec.factory.createSequence
			seq.name = epName
			seq.comment = "'" + epName + "' enter sequence for state " + state.name
			if(execState.entryAction != null) seq.steps.add(execState.entryAction.newCall)

			if(_addTraceSteps) seq.steps += execState.newTraceStateEntered

			if (execState.leaf) {

				seq.steps += execState.newEnterStateStep

			} else {

				for (r : state.regions) {
					val execRegion = r.create
					var regionEnterSeq = execRegion.enterSequences.byName(epName)

					if (regionEnterSeq == null) {
						regionEnterSeq = execRegion.enterSequences.defaultSequence
					}

					if (regionEnterSeq != null) {
						seq.steps += regionEnterSeq.newCall
					}
				}
			}
			
			// save the history on entering a state 
			val execRegion = state.parentRegion.create
			if (execRegion.historyVector != null) {
				seq.steps += execRegion.newSaveHistory()
			}
			

			execState.enterSequences += seq
		}

	}

	/**
	 * Defines the exit sequences of all states
	 */
	def void defineStateExitSequences(ExecutionFlow flow, Statechart sc) {

		// iterate over all regions
		for (r : sc.regions)
			defineStateExitSequence(r)
	}

	def dispatch void defineStateExitSequence(Region r) {
		val execRegion = r.create
		val seq = sexec.factory.createSequence
		seq.name = "exitSequence"
		seq.comment = "Default exit sequence for region " + r.name

		// process all states of a region
		for (s : r.vertices)
			defineStateExitSequence(s)

		// collect leaf states
		val Iterable<ExecutionState> leafStates = r.collectLeafStates(new ArrayList<RegularState>()).map(rs|rs.create)
		val sVector = execRegion.stateVector

		for (i : sVector.offset .. sVector.offset + sVector.size - 1) {

			// create a state switch for each state configuration vector position
			val StateSwitch sSwitch = execRegion.defineExitSwitch(leafStates, i)
			seq.steps.add(sSwitch);
		}

		execRegion.exitSequence = seq

	}

	def dispatch void defineStateExitSequence(Vertex v) {
	}

	def dispatch void defineStateExitSequence(FinalState s) {
		val execState = s.create
		val seq = sexec.factory.createSequence
		seq.name = "exitSequence"
		seq.comment = "Default exit sequence for final state."
		seq.steps += execState.newExitStateStep

		if(_addTraceSteps) seq.steps += execState.newTraceStateExited

		execState.exitSequence = seq
	}

	// TODO : refactor
	def dispatch void defineStateExitSequence(State state) {

		val execState = state.create
		val seq = sexec.factory.createSequence
		seq.name = "exitSequence"
		seq.comment = "Default exit sequence for state " + state.name

		if (execState.leaf) {

			seq.steps += execState.newExitStateStep

		} else {

			for (r : state.regions) {

				// first enforce calculation of all child exit sequences
				r.defineStateExitSequence

				val execRegion = r.create
				if (execRegion.exitSequence != null) {
					seq.steps.add(execRegion.exitSequence.newCall)
				}
			}
		}

		if(execState.exitAction != null) seq.steps.add(execState.exitAction.newCall)

		if(_addTraceSteps) seq.steps += execState.newTraceStateExited

		execState.exitSequence = seq
	}

	def StateSwitch defineExitSwitch(ExecutionRegion region, Iterable<ExecutionState> leafStates, int pos) {

		// create a state switch
		var StateSwitch sSwitch = sexec.factory.createStateSwitch
		sSwitch.stateConfigurationIdx = pos
		sSwitch.comment = "Handle exit of all possible states (of " + region.name + ") at position " +
			sSwitch.stateConfigurationIdx + "..."

		val Iterable<ExecutionState> posStates = leafStates.filter(
			rs|rs.stateVector.size == 1 && rs.stateVector.offset == pos)

		// create a case for each leaf state
		for (s : posStates) {

			val caseSeq = sexec.factory.createSequence

			//Save regions if necessary
			val exitScopes = s.parentScopes
			exitScopes.removeAll(region.parentScopes)
			exitScopes.remove(s)
			exitScopes.fold(caseSeq,
				[cs, exitScope|
					{
						if (exitScope instanceof ExecutionRegion && (exitScope as ExecutionRegion).historyVector != null) {
							// val execRegion = exitScope as ExecutionRegion
							// cs.steps += execRegion.newSaveHistory
						}
						cs
					}])

			//Leave leaf
			if (s.exitSequence != null) {
				caseSeq.steps += s.exitSequence.newCall
			}

			// include exitAction calls up to the direct child level.
			exitScopes.fold(caseSeq,
				[cs, exitScope|
					{
						if (exitScope instanceof ExecutionState && s.stateVector.last == exitScope.stateVector.last) {
							val execState = exitScope as ExecutionState
							if(execState.exitAction != null) cs.steps.add(execState.exitAction.newCall)
							if(_addTraceSteps) cs.steps.add(execState.newTraceStateExited)
						}
						cs
					}])

			if(!caseSeq.steps.empty) sSwitch.cases.add(s.newCase(caseSeq))

		}

		return sSwitch
	}

	def defineStatechartExitSequence(ExecutionFlow flow, Statechart sc) {
		val exitSequence = sexec.factory.createSequence
		exitSequence.name = "exit"
		exitSequence.comment = "Default exit sequence for statechart " + sc.name

		for (r : sc.regions) {
			val execRegion = r.create
			if (execRegion.exitSequence != null) {
				exitSequence.steps.add(execRegion.exitSequence.newCall)
			}
		}

		if(flow.exitAction != null) exitSequence.steps.add(flow.exitAction.newCall)

		flow.exitSequence = exitSequence
		return exitSequence
	}

	/** 
	 * Defines the execution sequence that will be performed when the statechart will be entered.
	 */
	def defineStatechartEnterSequence(ExecutionFlow flow, Statechart sc) {

		val enterSequence = sexec.factory.createSequence
		enterSequence.name = DEFAULT_SEQUENCE_NAME
		enterSequence.comment = "Default enter sequence for statechart " + sc.name

		for (tes : sc.timeEventSpecs) {
			val timeEvent = tes.createDerivedEvent
			val scheduleStep = timeEvent.newScheduleTimeEvent(tes.buildValueExpression)
			enterSequence.steps.add(scheduleStep)
		}

		if(flow.entryAction != null) enterSequence.steps.add(flow.entryAction.newCall)

		for (r : sc.regions) {
			val execRegion = r.create
			if (execRegion.enterSequences.defaultSequence != null) {
				enterSequence.steps.add(execRegion.enterSequences.defaultSequence.newCall)
			}
		}

		flow.enterSequences += enterSequence
		return enterSequence
	}

	/**
	 * Defines the sequence of static initialization steps for constant values. 
	 * 
	 * These steps basically include the initialization of constants.
	 */
	def defineStatechartStaticInitSequence(ExecutionFlow flow, Statechart sc) {

		val initSequence = sexec.factory.createSequence
		initSequence.name = "staticInit"
		initSequence.comment = "The statecharts init sequence for constants." + sc.name
	
		for (VariableDefinition vd : flow.getVariablesForInitSequence(true)) {
			initSequence.addVariableInitializationStep(vd)
		}

		flow.staticInitSequence = initSequence
		return initSequence
	}
	
	/**
	 * Defines the sequence of initialization steps. 
	 * 
	 * These steps basically include the initialization of variables.
	 */
	def defineStatechartInitSequence(ExecutionFlow flow, Statechart sc) {

		val initSequence = sexec.factory.createSequence
		initSequence.name = "init"
		initSequence.comment = "Default init sequence for statechart " + sc.name
	
		for (VariableDefinition vd : flow.getVariablesForInitSequence(false)) {
			initSequence.addVariableInitializationStep(vd)
		}

		flow.initSequence = initSequence
		return initSequence
	}
	
	protected def getVariablesForInitSequence(ExecutionFlow flow, boolean const) {
		val statechartVariables = flow.scopes.map(s|s.variables).flatten.filter(typeof(VariableDefinition)).filter(v | v.const == const)
		val importedVariables = flow.scopes.map(s|s.declarations).flatten.filter(typeof(ImportDeclaration)).map(d|d.declaration).filter(typeof(VariableDefinition))
		return statechartVariables + importedVariables
	}
	
	def addVariableInitializationStep(Sequence initSequence, VariableDefinition vd) {
		if (vd.effectiveInitialValue != null) {
			initSequence.steps.add(vd.createInitialization)
		}
	}
	
	//TODO: Move to type system
	def effectiveInitialValue(VariableDefinition vd) {
		if (vd.initialValue != null) {
			return vd.initialValue
		} else {
			switch (vd) {
				case isBooleanType(vd.type): false.buildValue
				case isIntegerType(vd.type): 0.buildValue
				case isRealType(vd.type): buildValue(0.0d as double)
				case isStringType(vd.type): "".buildValue
				default: null
			}
		}
	}

	var factory = ExpressionsFactory.eINSTANCE

	def createInitialization(VariableDefinition vd) {
		val execution = sexec.factory.createExecution
		val assignment = factory.createAssignmentExpression
		val reference = factory.createElementReferenceExpression
		reference.reference = vd
		assignment.varRef = reference
		assignment.operator = AssignmentOperator::ASSIGN
		assignment.expression = vd.effectiveInitialValue.copy
		execution.statement = assignment
		return execution
	}

	def Expression buildValueExpression(TimeEventSpec tes) {
		val pve = tes.value.copy

		switch (tes.unit) {
			case TimeUnit::MILLISECOND: pve
			case TimeUnit::MICROSECOND: pve.divide(1000)
			case TimeUnit::NANOSECOND: pve.divide(1000000)
			case TimeUnit::SECOND: pve.multiply(1000)
			default: pve
		}
	}

	def Expression divide(Expression stmnt, long divisor) {
		val NumericalMultiplyDivideExpression div = factory.createNumericalMultiplyDivideExpression
		val PrimitiveValueExpression pve = factory.createPrimitiveValueExpression
		val IntLiteral intLit = factory.createIntLiteral
		intLit.value = divisor.intValue
		pve.value = intLit

		div.operator = MultiplicativeOperator::DIV
		div.leftOperand = stmnt
		div.rightOperand = pve

		div
	}

	def Expression multiply(Expression stmnt, long factor) {
		val NumericalMultiplyDivideExpression div = factory.createNumericalMultiplyDivideExpression
		val PrimitiveValueExpression pve = factory.createPrimitiveValueExpression
		val IntLiteral intLit = factory.createIntLiteral
		intLit.value = factor.intValue
		pve.value = intLit

		div.operator = MultiplicativeOperator::MUL
		div.leftOperand = stmnt
		div.rightOperand = pve

		div
	}

	def Expression buildValue(boolean b) {
		val PrimitiveValueExpression pve = factory.createPrimitiveValueExpression
		val BoolLiteral lit = factory.createBoolLiteral
		lit.value = b
		pve.value = lit

		pve
	}

	def Expression buildValue(int i) {
		val PrimitiveValueExpression pve = factory.createPrimitiveValueExpression
		val IntLiteral lit = factory.createIntLiteral
		lit.value = i
		pve.value = lit

		pve
	}

	def Expression buildValue(double d) {
		val PrimitiveValueExpression pve = factory.createPrimitiveValueExpression
		val RealLiteral lit = factory.createRealLiteral
		lit.value = d
		pve.value = lit

		pve
	}

	def Expression buildValue(String i) {
		val PrimitiveValueExpression pve = factory.createPrimitiveValueExpression
		val StringLiteral lit = factory.createStringLiteral
		lit.value = i
		pve.value = lit

		pve
	}

}
