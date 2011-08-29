package org.yakindu.sct.ui.editor.propertysheets;

import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Shell;

import de.itemis.gmf.runtime.commons.properties.descriptors.IFormPropertyDescriptor;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SubchartStatePropertySection extends NamePropertySection {

	@Override
	protected void createPropertyDescriptors(
			List<IFormPropertyDescriptor> descriptors) {
		super.createPropertyDescriptors(descriptors);
//		TextDialogPropertyDescriptor descriptor = new TextDialogPropertyDescriptor(
//				null, "Substatechart:");
//		descriptors.add(descriptor);
	}


	protected static class OpenDialogSelectionListener implements SelectionListener {

		public void widgetSelected(SelectionEvent e) {
			MessageDialog.openQuestion(new Shell(), "BLA", "BLUB");
		}

		public void widgetDefaultSelected(SelectionEvent e) {
		}

	}
}
