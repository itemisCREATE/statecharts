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

import java.util.Map;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TreeItem;
import org.yakindu.base.types.EnumerationType;
import org.yakindu.base.types.PrimitiveType;
import org.yakindu.base.types.Type;
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
	private static Map<String, Button> viewerCells = Maps.newHashMap();
	private boolean isReadOnly;

	public ExecutionContextLabelProvider(int index, boolean isReadOnly) {
		this.index = index;
		this.isReadOnly = isReadOnly;
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
				if (!((ExecutionSlot) element).isWritable() || isReadOnly) {
					cell.setText(getCellTextValue(element, value));
				} else if (isPrimitiveType(element)) {
					PrimitiveType primitiveType = (PrimitiveType) ((ExecutionSlot) element).getType().getOriginType();
					if (isBooleanType(value, primitiveType)) {
						TreeItem currentItem = (TreeItem) cell.getItem();
						NativeCellWidgetUtil.addNativeCheckbox(cell, element, value,
								new TreeEditorDisposeListener(currentItem));
					} else {
						cell.setText(getCellTextValue(element, value));
					}
				}
			} else {
				cell.setText("");
			}
		}
	}

	protected String getCellTextValue(Object element, Object value) {
		if (isEnumType(element)) {
			return getEnumName(element, value);
		}
		return value.toString();
	}

	protected boolean isBooleanType(Object value, PrimitiveType primitiveType) {
		return primitiveType != null && value instanceof Boolean;
	}

	protected boolean isPrimitiveType(Object element) {
		return ((ExecutionSlot) element).getType().getOriginType() instanceof PrimitiveType;
	}

	protected String getEnumName(Object element, Object value) {
		EnumerationType enumType = (EnumerationType) ((ExecutionSlot) element).getType().getOriginType();
		String text = enumType.getEnumerator().get(((Long) value).intValue()).getName();
		return text;
	}

	protected boolean isEnumType(Object element) {
		Type type = ((ExecutionSlot) element).getType();
		if (type == null) {
			return false;
		}
		return type.getOriginType() instanceof EnumerationType;
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
			cell.setStyleRanges(new StyleRange[] { style1 });
			if (event.isRaised()) {
				cell.setImage(SimulationImages.EVENT_ENABLED.image());
			} else if (event.getName().contains("time_event")) {
				cell.setImage(SimulationImages.TIMEEVENT.image());
			} else {
				cell.setImage(SimulationImages.EVENT_DISABLED.image());
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
	protected class TreeEditorDisposeListener implements DisposeListener {

		private static final String LISTENER_DATA = "DISPOSELISTENER";
		private static final String EDITOR_DATA = "EDITOR";
		private final TreeItem currentItem;

		protected TreeEditorDisposeListener(TreeItem currentItem) {
			this.currentItem = currentItem;

		}

		public void widgetDisposed(DisposeEvent e) {
			disposeTreeEditor();
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
	protected static class NativeCellWidgetUtil {

		protected static void addNativeCheckbox(ViewerCell cell, Object element, Object value,
				TreeEditorDisposeListener listener) {

			TreeItem currentItem = (TreeItem) cell.getItem();
			ExecutionSlot execSlot = (ExecutionSlot) element;
			String cellKey = ((CompositeSlot) execSlot.eContainer()).getName() + "." + execSlot.getName();
			if (viewerCells.get(cellKey) == null || viewerCells.get(cellKey).isDisposed()
					|| (viewerCells.get(cellKey).getSelection() != ((Boolean) value).booleanValue())) {
				manageEditorDisposal(currentItem, listener);
				TreeEditor editor = createEditor(currentItem);
				Composite comp = createEditorComposite(currentItem);
				final Button button = createNativeCheckboxCellWidget(element, comp);
				editor.setEditor(comp, currentItem, cell.getColumnIndex()); // update editor content
				viewerCells.put(cellKey, button);
			}
		}

		protected static Button createNativeCheckboxCellWidget(Object element, Composite comp) {
			Cursor cursor = new Cursor(Display.getDefault(), SWT.CURSOR_HAND);
			Button button = new Button(comp, SWT.CHECK);
			button.setCursor(cursor);
			button.setLayoutData(new GridData(SWT.BEGINNING, SWT.FILL, false, true));
			Label label = new Label(comp, SWT.BOLD);
			label.setCursor(cursor);
			label.setForeground(ColorConstants.gray);
			label.setText(((ExecutionSlot) element).getValue().toString());
			label.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
			label.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseUp(MouseEvent e) {
					changeLabelText(element, label);
				}
			});
			button.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					changeLabelText(element, label);
				}
			});
			restoreSelection(((ExecutionSlot) element).getValue(), button);
			return button;
		}

		protected static void changeLabelText(Object element, Label label) {
			((ExecutionSlot) element).setValue(!(Boolean) ((ExecutionSlot) element).getValue());
			label.setText(((ExecutionSlot) element).getValue().toString());
		}

		protected static Composite createEditorComposite(TreeItem currentItem) {
			Composite comp = new Composite(currentItem.getParent(), SWT.INHERIT_DEFAULT);
			comp.setBackground(currentItem.getBackground());
			comp.setBackgroundMode(SWT.INHERIT_DEFAULT);
			GridLayout layout = new GridLayout(2, false);
			layout.marginHeight = 0;
			layout.marginWidth = 3;
			comp.setLayout(layout);
			return comp;
		}

		protected static TreeEditor createEditor(TreeItem currentItem) {
			TreeEditor editor = new TreeEditor(currentItem.getParent());
			editor.grabVertical = true;
			editor.grabHorizontal = true;
			currentItem.setData(TreeEditorDisposeListener.EDITOR_DATA, editor);
			return editor;
		}

		protected static void manageEditorDisposal(TreeItem currentItem, TreeEditorDisposeListener listener) {
			listener.disposeTreeEditor();
			listener.removeDisposeListener();
			currentItem.addDisposeListener(listener);
			currentItem.setData(TreeEditorDisposeListener.LISTENER_DATA, listener);
		}

		protected static void restoreSelection(Object value, Button button) {
			if (((Boolean) value).booleanValue() != button.getSelection())
				button.setSelection(((Boolean) value).booleanValue());
		}
	}
}
