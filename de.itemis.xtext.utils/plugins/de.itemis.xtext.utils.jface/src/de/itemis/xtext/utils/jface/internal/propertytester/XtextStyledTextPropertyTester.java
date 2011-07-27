package de.itemis.xtext.utils.jface.internal.propertytester;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

import de.itemis.xtext.utils.jface.viewers.XtextStyledText;

public class XtextStyledTextPropertyTester extends PropertyTester {

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		Control control = Display.getCurrent().getFocusControl();
		return control != null && control.getData(XtextStyledText.class.getCanonicalName()) != null;
	}

}
