/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.propertysheets.appearance;

import java.util.List;

import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.properties.sections.appearance.ConnectionAppearancePropertySection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPart;
import org.yakindu.sct.ui.editor.editparts.TransitionEditPart;
import org.yakindu.sct.ui.editor.editparts.TransitionExpressionEditPart;
import org.yakindu.sct.ui.editor.propertysheets.util.SelectionUnwrapperUtil;

import com.google.common.collect.Lists;

/**
 * 
 * @author robert rudi - Initial contribution and API
 * 
 */
public class TransitionAppearancePropertySection extends ConnectionAppearancePropertySection {

	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, SelectionUnwrapperUtil.unwrapSelectionForType(selection, TransitionEditPart.class));
	}
	
	@Override
	public List<ConnectionEditPart> getInput() {
		List<?> elements = super.getInput();
		List<ConnectionEditPart> connectionEditParts = Lists.newArrayList();
		if(elements != null)
			elements.forEach(e -> {
				if (e instanceof TransitionExpressionEditPart) {
					connectionEditParts.add((TransitionEditPart) ((TransitionExpressionEditPart) e).getParent());
				}else if(e instanceof TransitionEditPart) {
					connectionEditParts.add((TransitionEditPart) e);
				}
			});
		return connectionEditParts;
	}

}
