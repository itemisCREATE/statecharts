package org.yakindu.sct.ui.editor;

import org.eclipse.jface.viewers.IFilter;
import org.yakindu.sct.ui.editor.editparts.AbstractStateEditPart;
import org.yakindu.sct.ui.editor.editparts.StateEditPart;
import org.yakindu.sct.ui.editor.editparts.StateNameEditPart;

public class StatePropertySectionFilter implements IFilter {

	public boolean select(Object toTest) {
		return (toTest instanceof AbstractStateEditPart
				|| toTest instanceof StateEditPart || toTest instanceof StateNameEditPart);
	}

}
