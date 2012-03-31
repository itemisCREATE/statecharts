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
package org.yakindu.sct.ui.editor.policies;

import java.util.List;

import org.eclipse.gmf.runtime.diagram.core.util.ViewType;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.ui.editor.providers.SemanticHints;

/**
 * 
 * @author andreas muelder
 * 
 */
public class StatechartCanonicalEditPolicy extends CanonicalEditPolicy {

	@Override
	protected List<Region> getSemanticChildrenList() {
		return getSemanticHost().getRegions();
	}

	@Override
	public Statechart getSemanticHost() {
		return (Statechart) super.getSemanticHost();
	}

	@Override
	public IGraphicalEditPart getHost() {
		return (IGraphicalEditPart) super.getHost
		();
	}

	@Override
	protected boolean shouldDeleteView(View view) {
		//#Bug 349119 
		if (ViewType.NOTE.equals(view.getType())
				|| ViewType.NOTEATTACHMENT.equals(view.getType())
				|| ViewType.TEXT.equals(view.getType())) {
			return false;
		}
		// We do not want to delete the fixed Text compartment view
		if (SemanticHints.STATECHART_TEXT.equals(view.getType())) {
			return false;
		}
		return true;
	}

}
