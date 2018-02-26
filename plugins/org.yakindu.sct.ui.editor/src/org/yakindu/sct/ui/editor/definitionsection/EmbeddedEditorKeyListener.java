/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
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