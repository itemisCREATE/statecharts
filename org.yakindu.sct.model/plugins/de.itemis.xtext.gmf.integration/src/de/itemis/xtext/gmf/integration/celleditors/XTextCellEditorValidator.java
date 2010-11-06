package de.itemis.xtext.gmf.integration.celleditors;

import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.xtext.ui.editor.model.XtextDocument;

import com.google.inject.Injector;

import de.itemis.xtext.gmf.integration.utils.XtextUtils;

/**
 * Implementation of {@link ICellEditorValidator} that parses the given cell
 * value with the XText Parser and shows any errors as a
 * {@link ControlDecoration}
 * 
 * @author andreas.muelder@itemis.de
 * 
 */
public class XTextCellEditorValidator implements ICellEditorValidator {

	private final ControlDecoration decorator;
	private final XtextDocument document;

	public XTextCellEditorValidator(Control control, Injector injector) {
		decorator = new ControlDecoration(control, SWT.LEFT | SWT.TOP);
		this.document = XtextUtils.createDummyDocument(injector, null);
	}

	public String isValid(Object value) {
		decorator.hide();
		if (value == null || "".equals(value))
			return null;
		Assert.isLegal(value instanceof String);
		XtextUtils.updateDocument(document, (String) value);
		List<Resource.Diagnostic> errors = XtextUtils.getErrors(document);
		if (errors.size() == 0) {
			return null;
		}
		String message = errors.get(0).getMessage();
		showError(message);
		return message;
	}

	protected void showError(String message) {
		decorator.setDescriptionText(message);
		decorator.setImage(FieldDecorationRegistry.getDefault()
				.getFieldDecoration(FieldDecorationRegistry.DEC_ERROR)
				.getImage());
		decorator.setMarginWidth(5);
		decorator.show();
	}

	public void dispose() {
		decorator.dispose();
	}
}
