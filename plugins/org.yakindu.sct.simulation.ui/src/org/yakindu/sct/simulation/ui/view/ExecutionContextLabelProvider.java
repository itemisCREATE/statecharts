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
package org.yakindu.sct.simulation.ui.view;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.custom.StyleRange;
import org.yakindu.sct.simulation.core.runtime.impl.AbstractSlot;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionEvent;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionVariable;
import org.yakindu.sct.simulation.ui.DeclarationImages;
import org.yakindu.sct.simulation.ui.view.ExecutionContextContentProvider.Container;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ExecutionContextLabelProvider extends StyledCellLabelProvider {

	private final int index;

	public ExecutionContextLabelProvider(int index) {
		this.index = index;
	}

	public void update(ViewerCell cell) {
		switch (index) {
		case 0:
			updateNameCell(cell);
			break;
		case 1:
			updateValueCell(cell);
			break;
		}
		super.update(cell);
	}

	private void updateValueCell(ViewerCell cell) {
		Object element = cell.getElement();
		if (element instanceof AbstractSlot) {
			Object value = ((AbstractSlot) element).getValue();
			if (value != null)
				cell.setText(value.toString());
		}

	}

	private void updateNameCell(ViewerCell cell) {
		Object element = cell.getElement();
		if (element instanceof ExecutionEvent) {
			ExecutionEvent event = (ExecutionEvent) element;
			cell.setText(event.getName());
			StyleRange style1 = new StyleRange();
			style1.start = 0;
			style1.length = event.getName().length();
			style1.underline = true;
			style1.foreground = ColorConstants.lightBlue;
			cell.setText(event.getSimpleName());
			cell.setStyleRanges(new StyleRange[] { style1 });
			if (event.getName().contains("time_event")) {
				cell.setImage(DeclarationImages.TIMEEVENT.image());
			} else {
				cell.setImage(DeclarationImages.EVENT.image());
			}
		} else if (element instanceof ExecutionVariable) {
			ExecutionVariable variable = (ExecutionVariable) element;
			cell.setText(variable.getSimpleName());
			cell.setImage(DeclarationImages.VARIABLE.image());
		} else if (element instanceof Container) {
			cell.setText(((Container) element).name);
			cell.setImage(DeclarationImages.SCOPE.image());
		}
	}

}
