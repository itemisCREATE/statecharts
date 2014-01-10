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
package org.yakindu.sct.ui.navigator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.yakindu.base.expressions.expressions.Expression;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.Trigger;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.ReactionEffect;

/**
 * 
 * @author m.muehlbrandt
 *
 */
public class StatechartObjectViewerFilter extends ViewerFilter {

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (element instanceof DomainNavigatorItem) {
			DomainNavigatorItem navigatorItem = (DomainNavigatorItem) element;
			EObject modelElement = navigatorItem.getEObject();
			if (modelElement instanceof Diagram) {
				return false;
			}
			if (modelElement instanceof Trigger) {
				return false;
			}
			if (modelElement instanceof InternalScope
					|| modelElement instanceof InterfaceScope) {
				return true;
			}
			if (modelElement instanceof Scope) {
				return false;
			}
			if (modelElement instanceof LocalReaction) {
				return false;
			}
			if (modelElement instanceof ReactionEffect) {
				return false;
			}
			if (modelElement instanceof Expression) {
				return false;
			}
		}
		return true;
	}
}
