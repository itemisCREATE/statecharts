package de.itemis.xtext.utils.gmf.directedit;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;

import com.google.inject.Injector;

/**
 * direct Edit Manager for xText aware Edit Parts. Clients that use this edit
 * manager, must implement {@link IXTextAwareEditPart}.
 * 
 * Some code is initially copied from {@link TextDirectEditManager}.
 * 
 * @author andreas.muelder@itemis.de
 */
public class XTextDirectEditManager extends DirectEditManager {

	private static final int MIN_WIDTH = 100;

	/** String buffer to hold initial characters * */
	private StringBuffer initialString = new StringBuffer();

	private final Injector injector;

	private final int style;

	public static CellEditorLocator getTextCellEditorLocator(
			final IXTextAwareEditPart source) {

		// return a default figure locator
		return new CellEditorLocator() {
			public void relocate(CellEditor celleditor) {
				StyledText text = (StyledText) celleditor.getControl();
				Rectangle rect = source.getFigure().getBounds().getCopy();
				source.getFigure().translateToAbsolute(rect);
				if (!rect.equals(new Rectangle(text.getBounds()))) {
					text.setBounds(rect.x, rect.y,
							Math.max(rect.width, MIN_WIDTH), rect.height);
				}
			}
		};
	}

	public XTextDirectEditManager(IXTextAwareEditPart source, Injector injector,
			int style) {
		super(source, XTextCellEditor.class,
				getTextCellEditorLocator((IXTextAwareEditPart) source));
		this.injector = injector;
		this.style = style;
	}

	@Override
	protected void initCellEditor() {
		// init with initial edit text
		IXTextAwareEditPart textEP = (IXTextAwareEditPart) getEditPart();
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
		if (SWT.getPlatform() != "carbon") { //$NON-NLS-1$ 
			// Set the cell editor text to the initial character
			setEditText(initialString.toString());
		}
	}


	public void setEditText(String toEdit) {

		// Get the cell editor
		CellEditor cellEditor = getCellEditor();

		// IF the cell editor doesn't exist yet...
		if (cellEditor == null) {
			// Do nothing
			return;
		}
		// Get the Text control
		StyledText textControl = (StyledText) cellEditor.getControl();
		cellEditor.setValue(toEdit);

		// Set the controls text and position the caret at the end of the
		textControl.setSelection(toEdit.length());
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


}
