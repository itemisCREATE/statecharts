/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.statechart.diagram.validation.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.yakindu.sct.model.statechart.statechart.FinalState;
import org.yakindu.sct.model.statechart.statechart.Vertex;

public class NoOutgoingTransitions extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx) {
		Vertex vertex = (Vertex) ctx.getTarget();
		if (!(vertex instanceof FinalState)) {
			if (vertex.getOutgoingTransitions().size() == 0) {
				return ctx.createFailureStatus(vertex);
			}
		}
		return ctx.createSuccessStatus();
	}
}
