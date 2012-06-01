package org.yakindu.sct.generator.java.extensions;

import org.yakindu.sct.model.sexec.ExecutionFlow;
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
}