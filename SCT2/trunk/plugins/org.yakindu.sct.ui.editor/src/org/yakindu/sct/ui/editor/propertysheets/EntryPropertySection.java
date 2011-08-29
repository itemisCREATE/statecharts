package org.yakindu.sct.ui.editor.propertysheets;

import java.util.List;

import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.ui.editor.utils.IYakinduSctHelpContextIds;

import de.itemis.gmf.runtime.commons.properties.descriptors.ComboPropertyDescriptor;
import de.itemis.gmf.runtime.commons.properties.descriptors.IFormPropertyDescriptor;

/**
 * 
 * @author andreas muelder
 * 
 */
public class EntryPropertySection extends NamePropertySection {

	@Override
	protected void createPropertyDescriptors(
			List<IFormPropertyDescriptor> descriptors) {
		super.createPropertyDescriptors(descriptors);
		// Combo Property Descriptor for Entry Kind
		ComboPropertyDescriptor comboDescriptor = new ComboPropertyDescriptor(
				SGraphPackage.Literals.ENTRY__KIND, "Entry Kind: ",
				EntryKind.values(),
				IYakinduSctHelpContextIds.SC_PROPERTIES_ENTRY_ENTRYKIND);
		descriptors.add(comboDescriptor);
	}

}
