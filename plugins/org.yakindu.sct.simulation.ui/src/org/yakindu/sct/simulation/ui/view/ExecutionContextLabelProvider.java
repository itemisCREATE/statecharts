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

import java.util.HashMap;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TreeItem;
import org.yakindu.base.types.EnumerationType;
import org.yakindu.base.types.PrimitiveType;
import org.yakindu.sct.model.sruntime.CompositeSlot;
import org.yakindu.sct.model.sruntime.ExecutionEvent;
import org.yakindu.sct.model.sruntime.ExecutionOperation;
import org.yakindu.sct.model.sruntime.ExecutionSlot;
import org.yakindu.sct.model.sruntime.ExecutionVariable;
import org.yakindu.sct.model.sruntime.ReferenceSlot;
import org.yakindu.sct.simulation.ui.SimulationImages;

import com.google.common.collect.Maps;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ExecutionContextLabelProvider extends StyledCellLabelProvider {

	private final int index;
	private static HashMap<TreeItem, TreeEditor> viewerCells = Maps.newHashMap();

	public ExecutionContextLabelProvider(int index) {
		this.index = index;
	}

	public void update(ViewerCell cell) {
		switch (index) {
			case 0 :
				updateNameCell(cell);
				break;
			case 1 :
				updateValueCell(cell);
				break;
		}
		super.update(cell);
	}

	private void updateValueCell(ViewerCell cell) {
		Object element = cell.getElement();
		if (element instanceof ReferenceSlot) {
			ReferenceSlot refSlot = (ReferenceSlot) element;
			String label = "";
			if (refSlot.getReference() != null) {
				String refFqn = refSlot.getReference().getFqName();
				Object refValue = refSlot.getReference().getValue();
				label = refValue != null ? refFqn + " = " + refValue : refFqn;
			}
			cell.setText(label);
		} else if (element instanceof ExecutionSlot) {
			Object value = ((ExecutionSlot) element).getValue();
			if (value != null) {
				if (((ExecutionSlot) element).getType().getOriginType() instanceof EnumerationType) {
					EnumerationType enumType = (EnumerationType) ((ExecutionSlot) element).getType().getOriginType();
					String text = enumType.getEnumerator().get(((Long) value).intValue()).getName();
					cell.setText(text);
				}
				if (((ExecutionSlot) element).getType().getOriginType() instanceof PrimitiveType) {
					PrimitiveType primitiveType = (PrimitiveType) ((ExecutionSlot) element).getType().getOriginType();
					if (primitiveType != null
							&& Boolean.class.getSimpleName().equalsIgnoreCase(primitiveType.getName())) {
						NativeCellWidgetUtil.addNativeCheckbox(cell, element, value,
								new TreeEditorDisposeListener((TreeItem) cell.getItem()));
					} else {
						cell.setText(value.toString());
					}
				} else {
					cell.setText(value.toString());
				}
			} else {
				cell.setText("");
			}
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
			cell.setText(event.getName());
			cell.setStyleRanges(new StyleRange[]{style1});
			if (event.getName().contains("time_event")) {
				cell.setImage(SimulationImages.TIMEEVENT.image());
			} else {
				if (event.isRaised()) {
					cell.setImage(SimulationImages.EVENT_ENABLED.image());
				} else {
					cell.setImage(SimulationImages.EVENT_DISABLED.image());
				}
			}
		} else if (element instanceof ExecutionOperation) {
			ExecutionVariable variable = (ExecutionVariable) element;
			cell.setText(variable.getName());
			cell.setImage(SimulationImages.OPERATION.image());
		} else if (element instanceof ExecutionVariable) {
			ExecutionVariable variable = (ExecutionVariable) element;
			cell.setText(variable.getName());
			if (((ExecutionVariable) element).isWritable())
				cell.setImage(SimulationImages.VARIABLE.image());
			else
				cell.setImage(SimulationImages.VARIABLE_LOCK.image());
		} else if (element instanceof CompositeSlot) {
			cell.setText(((CompositeSlot) element).getName());
			cell.setImage(SimulationImages.SCOPE.image());
		}
	}

	/**
	 * 
	 * @author robert rudi - Initial contribution and API
	 * 
	 */
	protected final class TreeEditorDisposeListener implements DisposeListener {
		
		private static final String LISTENER_DATA = "DISPOSELISTENER";
		private static final String EDITOR_DATA = "EDITOR";
		private final TreeItem currentItem;
		
		protected TreeEditorDisposeListener(TreeItem currentItem) {
			this.currentItem = currentItem;

		}
		public void widgetDisposed(DisposeEvent e) {
			if (currentItem.getData(EDITOR_DATA) != null) {
				TreeEditor editor = (TreeEditor) currentItem.getData(EDITOR_DATA);
				editor.getEditor().dispose();
				editor.dispose();
			}
		}

		protected void disposeTreeEditor() {
			if (currentItem.getData(EDITOR_DATA) != null) {
				TreeEditor editor = (TreeEditor) currentItem.getData(EDITOR_DATA);
				editor.getEditor().dispose();
				editor.dispose();
			}
		}
		protected void removeDisposeListener() {
			if (currentItem.getData(LISTENER_DATA) != null) {
				currentItem.removeDisposeListener((DisposeListener) currentItem.getData(LISTENER_DATA));
			}
		}
	}

	/**
	 * 
	 * @author robert rudi - Initial contribution and API
	 * 
	 */
	protected final static class NativeCellWidgetUtil {
		protected static void addNativeCheckbox(ViewerCell cell, Object element, Object value,
				TreeEditorDisposeListener listener) {
			Display.getDefault().syncExec(new Runnable() {

				@Override
				public void run() {
					TreeItem currentItem = (TreeItem) cell.getItem();
					if (!viewerCells.containsKey(currentItem)) {
						manageEditorDisposal(currentItem, listener);
						TreeEditor editor = createEditor(currentItem);
						Composite comp = createEditorComposite(currentItem);
						Button button = createNativeCheckboxCellWidget(element, comp);
						restoreSelection(value, button);
						editor.setEditor(comp, currentItem, cell.getColumnIndex()); // update editor content
						viewerCells.put(currentItem, editor);
					}
				}
			});
		}

		private static Button createNativeCheckboxCellWidget(Object element, Composite comp) {
			Button button = new Button(comp, SWT.CHECK);
			button.addSelectionListener(new SelectionListener() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					((ExecutionSlot) element).setValue(button.getSelection());
				}

				@Override
				public void widgetDefaultSelected(SelectionEvent e) {

				}
			});
			return button;
		}

		private static Composite createEditorComposite(TreeItem currentItem) {
			Composite comp = new Composite(currentItem.getParent(), SWT.INHERIT_DEFAULT);
			comp.setBackground(currentItem.getBackground());
			comp.setBackgroundMode(SWT.INHERIT_DEFAULT);
			FillLayout layout = new FillLayout(SWT.FILL);
			layout.marginHeight = 0;
			layout.marginWidth = 3;
			comp.setLayout(layout);
			return comp;
		}

		private static TreeEditor createEditor(TreeItem currentItem) {
			TreeEditor editor = new TreeEditor(currentItem.getParent());
			editor.grabVertical = true;
			editor.grabHorizontal = true;
			currentItem.setData(TreeEditorDisposeListener.EDITOR_DATA, editor);
			return editor;
		}

		private static void manageEditorDisposal(TreeItem currentItem, TreeEditorDisposeListener listener) {
			listener.disposeTreeEditor();
			listener.removeDisposeListener();
			currentItem.addDisposeListener(listener);
			currentItem.setData(TreeEditorDisposeListener.LISTENER_DATA, listener);
		}

		private static void restoreSelection(Object value, Button button) {
			if (((Boolean) value).booleanValue() != button.getSelection())
				button.setSelection(((Boolean) value).booleanValue());
		}
	}
}
