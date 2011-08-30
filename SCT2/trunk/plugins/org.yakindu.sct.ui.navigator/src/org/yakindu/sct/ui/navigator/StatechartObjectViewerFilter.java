package org.yakindu.sct.ui.navigator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.Trigger;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;

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
		}
		return true;
	}
}
