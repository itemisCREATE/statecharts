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
package org.yakindu.sct.statechart.diagram.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.SemanticEditPolicy;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.yakindu.sct.statechart.diagram.commands.CreateTransitionCommand;
/**
 * 
 * @author Andreas Muelder <a
 *         href="mailto:andreas.muelder@itemis.de">andreas.muelder@itemis.de</a>
 * 
 */
public class ChoiceSemanticEditPolicy extends SemanticEditPolicy {
	@Override
	protected Command getSemanticCommand(IEditCommandRequest request) {
		if (request instanceof CreateRelationshipRequest) {
			CreateRelationshipRequest relationshipRequest = (CreateRelationshipRequest) request;
			return new ICommandProxy(new CreateTransitionCommand(
					relationshipRequest));
		}
		return super.getSemanticCommand(request);
	}
}
