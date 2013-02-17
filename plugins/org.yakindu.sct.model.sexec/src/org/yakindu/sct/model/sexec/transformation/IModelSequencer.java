package org.yakindu.sct.model.sexec.transformation;

import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sgraph.Statechart;

public interface IModelSequencer {

	public ExecutionFlow transform(Statechart statechart);
}
