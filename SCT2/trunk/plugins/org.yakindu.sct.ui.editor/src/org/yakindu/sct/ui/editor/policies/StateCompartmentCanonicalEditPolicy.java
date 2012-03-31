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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewType;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.ui.editor.utils.SemanticHintUtil;

/**
 * @author andreas muelder
 */
public class StateCompartmentCanonicalEditPolicy extends CanonicalEditPolicy {

	@SuppressWarnings("rawtypes")
	@Override
	protected List getSemanticChildrenList() {
		return getSemanticHost().getRegions();
	}

	@Override
	public State getSemanticHost() {
		return (State) super.getSemanticHost();
	}

	@Override
	public IGraphicalEditPart getHost() {
		return (IGraphicalEditPart) super.getHost();
	}

	@Override
	protected String getFactoryHint(IAdaptable elementAdapter) {
		EObject modelElement = (EObject) elementAdapter
				.getAdapter(EObject.class);
		String factoryHint = SemanticHintUtil.getSemanticHint(modelElement);
		return factoryHint;
	}

	protected boolean shouldDeleteView(View view) {
		if (ViewType.NOTE.equals(view.getType())
				|| ViewType.NOTEATTACHMENT.equals(view.getType())
				|| ViewType.TEXT.equals(view.getType())) {
			return false;
		}
		return true;
	}
}
