package org.yakindu.sct.simulation.ui.view;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.yakindu.sct.simulation.core.runtime.impl.AbstractSlot;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionEvent;

public class ExecutionContextLabelProvider extends ColumnLabelProvider {

	private final int index;

	public ExecutionContextLabelProvider(int index) {
		this.index = index;
	}

	@Override
	public String getText(Object element) {
		AbstractSlot abstractSlot = (AbstractSlot) element;
		switch (index) {
		case 0:
			return abstractSlot.getName();
		case 1:
			if (abstractSlot.getValue() != null)
				return abstractSlot.getValue().toString();
		default:
			return "";
		}
	}

	@Override
	public Image getImage(Object element) {
		return super.getImage(element);
	}
	
	@Override
	public Font getFont(Object element) {
		if(element instanceof ExecutionEvent){
			
		}
		return super.getFont(element);
	}

}
