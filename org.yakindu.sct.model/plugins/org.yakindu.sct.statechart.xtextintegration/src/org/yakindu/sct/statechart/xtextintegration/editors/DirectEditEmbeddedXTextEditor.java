package org.yakindu.sct.statechart.xtextintegration.editors;

import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.swt.widgets.Composite;
import org.eclipselabs.xtfo.demo.rcp.partialEditing.EmbeddedXtextEditor;

import com.google.inject.Injector;

public class DirectEditEmbeddedXTextEditor extends EmbeddedXtextEditor {

	public DirectEditEmbeddedXTextEditor(Composite control, Injector injector, int style) {
		super(control, injector, style);
	}

//	@Override
//	protected IVerticalRuler createVerticalRuler() {
//		return null;
//	}
	
}
