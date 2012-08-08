package org.yakindu.sct.generator.java.extensions;

import java.util.ArrayList;
import java.util.List;

import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionNode;
import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.ExecutionScope;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sgraph.Scope;

public class ExecutionModelExtensions {

	public static final int getOffset(Scope scope) {
//		int offset = 0;
		ExecutionFlow exFlow = (ExecutionFlow) scope.eContainer();
		int scopeIndex = exFlow.getScopes().indexOf(scope);
//		if (scopeIndex > 0) {
//			for (int i = 0; i < scopeIndex; i++) {
//				Scope iterScope = exFlow.getScopes().get(i);
//				offset += iterScope.getEvents().size();
//			}
//		}
		return scopeIndex;
	}
	
	public static List<ExecutionState> getSubStates(ExecutionState state) {
		List<ExecutionState> list = new ArrayList<ExecutionState>();
		for (ExecutionScope subScope: state.getSubScopes()) {
			if (subScope instanceof ExecutionState) {
				list.add((ExecutionState) subScope);
			}
			else if (subScope instanceof ExecutionRegion) {
				for (ExecutionNode node: ((ExecutionRegion)subScope).getNodes()) {
					if (node instanceof ExecutionState) {
						list.add((ExecutionState) node);
						list.addAll(getSubStates((ExecutionState) node));
					}
				}
			}
		}
		return list;
	}
}