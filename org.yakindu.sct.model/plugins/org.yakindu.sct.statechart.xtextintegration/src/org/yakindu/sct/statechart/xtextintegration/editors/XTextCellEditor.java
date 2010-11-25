package org.yakindu.sct.statechart.xtextintegration.editors;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipselabs.xtfo.demo.rcp.partialEditing.EmbeddedXtextEditor;

import com.google.inject.Injector;

/**
 * 
 * @author Andreas Muelder <a
 * 
 *         href="mailto:andreas.muelder@itemis.de">andreas.muelder@itemis.de</a>
 * 
 */
public class XTextCellEditor extends TextCellEditor {

	public static Injector injector;
	private final int style;

	public XTextCellEditor(Composite parent, int style) {
		super(parent);
		this.style = style;
	}

	protected StyledText text;
	private EmbeddedXtextEditor editor;

	@Override
	protected Control createControl(Composite parent) {
		editor = new DirectEditEmbeddedXTextEditor(parent, injector, style);
		text = editor.getViewer().getTextWidget();
		text.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				XTextCellEditor.this.focusLost();
			}
		});
		return editor.getViewer().getControl();
	}

	@Override
	protected Object doGetValue() {
		return text.getText();
	}

	@Override
	protected void doSetFocus() {
		text.setFocus();
	}

	@Override
	public void dispose() {
		text.dispose();
		super.dispose();
	}

	@Override
	protected void doSetValue(Object value) {
		if (value == null)
			return;
		Assert.isTrue(value instanceof String);
		text.setText((String) value);
		editor.getViewer().getTextWidget().setCaretOffset(text.getText().length());
	}

}
