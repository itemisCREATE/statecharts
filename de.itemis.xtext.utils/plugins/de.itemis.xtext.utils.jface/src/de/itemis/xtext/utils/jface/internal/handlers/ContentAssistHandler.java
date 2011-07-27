package de.itemis.xtext.utils.jface.internal.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

import de.itemis.xtext.utils.jface.viewers.XtextStyledText;

public class ContentAssistHandler extends AbstractHandler {
	
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Control control = Display.getCurrent().getFocusControl();
		if (control != null) {
			final XtextStyledText xtextStyledText = (XtextStyledText) control.getData(XtextStyledText.class.getCanonicalName());
			if (xtextStyledText != null) {
				xtextStyledText.getSourceviewer().doOperation(ISourceViewer.CONTENTASSIST_PROPOSALS);
			}
		}
		return null;
	}

}
