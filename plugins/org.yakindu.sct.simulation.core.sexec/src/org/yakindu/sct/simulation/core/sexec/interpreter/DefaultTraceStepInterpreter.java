/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.simulation.core.sexec.interpreter;

import org.eclipse.emf.ecore.EObject;
import org.yakindu.sct.model.sexec.ReactionFired;
import org.yakindu.sct.model.sexec.Trace;
import org.yakindu.sct.model.sruntime.ExecutionContext;

public class DefaultTraceStepInterpreter implements ITraceStepInterpreter {

	@Override
	public void evaluate(Trace trace, ExecutionContext context) {
		if (trace instanceof ReactionFired) {
			EObject sourceElement = ((ReactionFired) trace).getReaction().getSourceElement();
			if (sourceElement != null)
				context.getExecutedElements().add(sourceElement);
		}
	}
}
