package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Inject
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionScope
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.transformation.SexecElementMapping
import org.yakindu.sct.model.sexec.transformation.SexecExtensions
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions
import org.yakindu.sct.model.sgraph.Region

class BehaviorMapping extends org.yakindu.sct.model.sexec.transformation.BehaviorMapping {

	@Inject extension SexecElementMapping mapping
	@Inject extension StatechartExtensions sc
	@Inject extension SgraphExtensions sgraph
	@Inject extension SexecExtensions sexec
	@Inject extension ReactMethod rm

	protected override Step lcaDoSequence(Region region, ExecutionFlow flow) {
		
		if ( region === null ) return null

		val execRegion = region.create
		
		val shouldExecuteParent = 
			if (! region.statechart.childFirstExecution) 
				[ExecutionScope parentScope, ExecutionScope execScope | false ]
			else
				[ExecutionScope parentScope, ExecutionScope execScope | 
					parentScope === execScope || parentScope.impactVector.last == execScope.impactVector.last
				]
		
		val parent = if (region.parentStates.head !== null) {
						region.parentStates.head.create
					} else {
						flow
					}


		if (shouldExecuteParent.apply(parent, execRegion)) {
			parent.callReact(_false)._statement
		}
	}
	
}