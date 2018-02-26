package org.yakindu.sct.ui.editor.definitionsection;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

/**
 * 
 * @author robert rudi - Initial contribution and API
 *
 */
public class EmbeddedEditorKeyListener extends KeyAdapter {

	private StyledText embeddedEditorWidget;

	public EmbeddedEditorKeyListener(StyledText embeddedEditorWidget) {
		this.embeddedEditorWidget = embeddedEditorWidget;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.stateMask == SWT.CTRL && e.keyCode == 'a') {
			embeddedEditorWidget.selectAll();
		}
	}
}