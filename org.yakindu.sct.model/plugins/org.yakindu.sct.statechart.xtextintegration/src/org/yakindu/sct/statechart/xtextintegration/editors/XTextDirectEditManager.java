package org.yakindu.sct.statechart.xtextintegration.editors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.google.inject.Injector;

/**
 * @author andreas.muelder@itemis.de
 */
public class XTextDirectEditManager extends DirectEditManager {

	/** String buffer to hold initial characters * */
	private StringBuffer initialString = new StringBuffer();

	private final Injector injector;

	private final int style;

	public XTextDirectEditManager(GraphicalEditPart source, Injector injector,
			CellEditorLocator locator, int style) {
		super(source, DirectEditEmbeddedXTextEditor.class, locator);
		this.injector = injector;
		this.style = style;
	}

	@Override
	protected void initCellEditor() {
		ITextAwareEditPart textEP = (ITextAwareEditPart) getEditPart();
		setEditText(textEP.getEditText());
	}

	/**
	 * Performs show and sets the edit string to be the initial character or
	 * string
	 * 
	 * @param initialChar
	 */
	public void show(char initialChar) {
		initialString = initialString.append(initialChar);
		show();
		if (SWT.getPlatform() != "carbon") {
			// Set the cell editor text to the initial character
			setEditText(initialString.toString());
		}
	}

	public void setEditText(String toEdit) {

		CellEditor cellEditor = getCellEditor();
		if (cellEditor == null) {
			return;
		}
		ITextAwareEditPart textEP = (ITextAwareEditPart) getEditPart();
		textEP.setLabelText(toEdit);
		cellEditor.setValue(toEdit);
	}

	@Override
	protected void bringDown() {
		super.bringDown();
		initialString = new StringBuffer();
	}

	@Override
	protected CellEditor createCellEditorOn(Composite composite) {
		XTextCellEditor.injector = injector;
		XTextCellEditor editor = new XTextCellEditor(
				composite,style);
		return editor;
	}
}
