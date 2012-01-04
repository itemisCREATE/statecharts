/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.edithelper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.yakindu.sct.model.sgraph.SGraphPackage;
/**
 * 
 * @author andreas muelder
 *
 */
public class TransitionEditHelper extends AbstractEditHelper {
	@Override
	protected ICommand getReorientRelationshipCommand(
			ReorientRelationshipRequest req) {
		switch (req.getDirection()) {
		case ReorientRelationshipRequest.REORIENT_SOURCE:
			return new SetValueCommand(new SetRequest(req.getRelationship(),
					SGraphPackage.Literals.TRANSITION__SOURCE,
					req.getNewRelationshipEnd()));
		case ReorientRelationshipRequest.REORIENT_TARGET:
			return new SetValueCommand(new SetRequest(req.getRelationship(),
					SGraphPackage.Literals.TRANSITION__TARGET,
					req.getNewRelationshipEnd()));
		}
		return super.getReorientRelationshipCommand(req);
	}
}
