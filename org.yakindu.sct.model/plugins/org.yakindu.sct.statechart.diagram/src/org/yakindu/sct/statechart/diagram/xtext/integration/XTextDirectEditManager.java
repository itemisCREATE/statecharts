package org.yakindu.sct.statechart.diagram.xtext.integration;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
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
	private final GraphicalEditPart editPart;

	private final int style;

	public XTextDirectEditManager(GraphicalEditPart source,
			Injector injector, CellEditorLocator locator, int style) {
		super(source, XTextCellEditor.class, locator);
		this.editPart = source;
		this.injector = injector;
		this.style = style;
	}

	@Override
	protected void initCellEditor() {
		// init with initial edit text
//		ITextAwareEditPart textEP = (ITextAwareEditPart) getEditPart();
//		setEditText(textEP.getEditText());
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
		if (SWT.getPlatform() != "carbon") { //$NON-NLS-1$ 
			// Set the cell editor text to the initial character
			setEditText(initialString.toString());
		}
	}

	public void setEditText(String toEdit) {

		// Get the cell editor
		CellEditor cellEditor = getCellEditor();

//		// IF the cell editor doesn't exist yet...
//		if (cellEditor == null) {
//			// Do nothing
//			return;
//		}
//
//		// Get the Text Compartment Edit Part
//		ITextAwareEditPart textEP = (ITextAwareEditPart) getEditPart();
//
//		// Get the Text control
//		Text textControl = (Text) cellEditor.getControl();
//
//		// Set the Figures text
//		textEP.setLabelText(toEdit);
//
//		cellEditor.setValue(toEdit);
//
//		// Set the controls text and position the caret at the end of the text
//		textControl.setSelection(toEdit.length());
	}

	@Override
	protected void bringDown() {
		initialString = new StringBuffer();
		super.bringDown();
	}

	@Override
	protected CellEditor createCellEditorOn(Composite composite) {
		return new XTextCellEditor(composite, injector, style);
	}

	protected EList<Resource> getResourceInScope() {
		return ((EObject) getModel()).eResource().getResourceSet()
				.getResources();
	}

	private EObject getModel() {
		return editPart.resolveSemanticElement();
	}
}
