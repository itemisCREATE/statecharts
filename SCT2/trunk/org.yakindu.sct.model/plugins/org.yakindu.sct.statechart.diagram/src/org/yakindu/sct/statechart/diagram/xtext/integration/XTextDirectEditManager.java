package org.yakindu.sct.statechart.diagram.xtext.integration;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.TextUtilities;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
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

	/** String buffer to hold initial characters * */
	private StringBuffer initialString = new StringBuffer();

	private final Injector injector;

	private final int style;

	/**
	 * This code is initially copied from {@link TextDirectEditManager}
	 * 
	 */
	private static class XTextCellEditorLocator implements CellEditorLocator {

		private final IXTextAwareEditPart editPart;

		public XTextCellEditorLocator(IXTextAwareEditPart editPart) {
			this.editPart = editPart;
		}

		@Override
		public void relocate(CellEditor celleditor) {
			StyledText text = (StyledText) celleditor.getControl();
			WrappingLabel label = editPart.getWrappingLabel();
			Rectangle rect = label.getTextBounds().getCopy();

			if (label.getText().length() <= 0) {
				// if there is no text, let's assume a default size
				// of one character because it looks silly when the cell
				// editor is tiny.
				rect.setSize(TextUtilities.INSTANCE.getTextExtents(
						"a", text.getFont())); //$NON-NLS-1$

				if (label.isTextWrapOn()) {
					// adjust the location of the cell editor based on text
					// justification (i.e. where the cursor will be
					if (label.getTextJustification() == PositionConstants.RIGHT) {
						rect.translate(-rect.width, 0);
					} else if (label.getTextJustification() == PositionConstants.CENTER) {
						rect.translate(-rect.width / 2, 0);
					}
				}
			}

			if (!text.getFont().isDisposed()) {
				// Font may be disposed if the locator is called while
				// this manager is being brought down in which case the
				// calls below that use the font will result in an
				// exception.
				if (label.isTextWrapOn()) {
					// When zoomed in, the height of this rectangle is not
					// sufficient because the text is shifted downwards a
					// little bit. Add some to the height to compensate for
					// this. I'm not sure why this is happening, but I can
					// see the text shifting down even in a label on a GEF
					// logic diagram when zoomed into 400%.
					int charHeight = FigureUtilities.getFontMetrics(
							text.getFont()).getHeight();
					rect.resize(0, charHeight / 2);
				} else {

					rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT,
							SWT.DEFAULT)));

					// If SWT.WRAP is not passed in as a style of the
					// TextCellEditor, then for some reason the first
					// character disappears upon entering the second
					// character. This should be investigated and an
					// SWT bug logged.
					int avr = FigureUtilities.getFontMetrics(text.getFont())
							.getAverageCharWidth();
					rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT,
							SWT.DEFAULT)).expand(avr * 2, 0));
				}
			}

			org.eclipse.swt.graphics.Rectangle newRect = text.computeTrim(
					rect.x, rect.y, rect.width, rect.height);
			if (!newRect.equals(text.getBounds())) {
				text.setBounds(newRect.x, newRect.y, newRect.width,
						newRect.height);
			}

		}

	}

	public XTextDirectEditManager(GraphicalEditPart source, Injector injector,
			int style) {
		super(source, XTextCellEditor.class, new XTextCellEditorLocator(
				(IXTextAwareEditPart) source));
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
