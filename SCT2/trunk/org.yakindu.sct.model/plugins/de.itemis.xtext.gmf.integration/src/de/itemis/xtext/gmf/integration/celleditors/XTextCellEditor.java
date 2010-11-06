package de.itemis.xtext.gmf.integration.celleditors;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.bindings.keys.ParseException;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * A {@link CellEditor} for tight integration of xText based DSLs with default
 * jface based viewers like {@link TableViewer} or {@link TreeViewer}.
 * 
 * This implementation provides validation and code completion.
 * 
 * @author andreas.muelder@itemis.de
 * @author alexander.nyssen@itemis.de
 * 
 */
public class XTextCellEditor extends TextCellEditor {

	private final Iterable<Resource> scope;

	/**
	 * C'tor to create a new Instance.
	 * 
	 * @param parent
	 *            the parent Composite
	 * @param injector
	 */
	public XTextCellEditor(Composite parent, Module xtextModule, Iterable<Resource> scope) {
		super(parent);
		this.scope = scope;
		Injector injector = Guice.createInjector(xtextModule);
		hookProposalAdapter(injector);
		hookValidator(injector);
	}

	protected Iterable<Resource> getScope() {
		return scope;
	}

	@Override
	public void dispose() {
		super.dispose();
		if (getValidator() != null && getValidator() instanceof XTextCellEditorValidator) {
			((XTextCellEditorValidator) getValidator()).dispose();
		}
	}

	protected void hookValidator(Injector injector) {
		setValidator(new XTextCellEditorValidator(getControl(), injector));
	}

	@Override
	protected void doSetValue(final Object value) {
		super.doSetValue(value == null ? "" : value);
	}

	protected char[] getAutoActivationCharacters() {
		return new char[] { '.' };
	}

	protected KeyStroke getKeyStroke() {
		KeyStroke keyStroke = null;
		try {
			keyStroke = KeyStroke.getInstance("Ctrl+Space");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return keyStroke;
	}

	protected void hookProposalAdapter(Injector injector) {
		new XtextContentProposalAdapter(getControl(), injector, getKeyStroke(), getAutoActivationCharacters());
	}
}
