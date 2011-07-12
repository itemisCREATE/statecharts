package de.itemis.gmf.runtime.commons.properties.descriptors;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;

public class TextAreaPropertyDescriptor extends TextPropertyDescriptor {

	public TextAreaPropertyDescriptor(EAttribute feature, String labelName) {
		super(feature, labelName);
	}

	public Text createControl(Composite parent) {
		FormToolkit toolkit = new FormToolkit(parent.getDisplay());
		Text control = toolkit.createText(parent, "", SWT.MULTI);
		applyLayout(control);
		return control;
	}

	protected void applyLayout(Text control) {
		GridDataFactory.fillDefaults().grab(true, true).applyTo(control);
	}

}
