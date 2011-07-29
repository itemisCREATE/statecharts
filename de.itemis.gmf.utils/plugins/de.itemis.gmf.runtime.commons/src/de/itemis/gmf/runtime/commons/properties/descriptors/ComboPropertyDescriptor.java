package de.itemis.gmf.runtime.commons.properties.descriptors;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * Combo viewer for EMF based type safe enumerations
 * 
 * @author andreas muelder
 * 
 */
public class ComboPropertyDescriptor extends AbstractPropertyDescriptor {

	private final Enumerator[] items;
	private ComboViewer comboViewer;

	public ComboPropertyDescriptor(EAttribute feature, String labelName,
			Enumerator[] items) {
		super(feature, labelName);
		this.items = items;
	}
	
	public ComboPropertyDescriptor(EAttribute feature, String labelName,
			Enumerator[] items, String helpContextId) {
		this(feature, labelName, items);
		this.helpContextId = helpContextId;
	}

	public Object getControlValue() {
		IStructuredSelection selection = (IStructuredSelection) comboViewer
				.getSelection();
		return selection.getFirstElement();

	}

	public void setControlValue(Object value) {
		Assert.isTrue(value instanceof Enumerator);
		comboViewer.setSelection(new StructuredSelection(value));
	}

	@Override
	protected Control createControl(Composite parent) {
		comboViewer = new ComboViewer(parent, SWT.READ_ONLY | SWT.SINGLE);
		comboViewer.setContentProvider(new ArrayContentProvider());
		comboViewer.setLabelProvider(new LabelProvider());
		comboViewer.setInput(items);
		applyLayout(comboViewer.getControl());
		return comboViewer.getControl();
	}

	@Override
	public Combo getControl() {
		return (Combo) super.getControl();
	}

}
