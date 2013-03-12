package org.yakindu.sct.model.sexec.transformation

import org.yakindu.sct.model.sexec.ExecutionNode

@Data class TargetEntrySpec {
	
	ExecutionNode target
	String entryPointName
	
}