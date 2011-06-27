package org.yakindu.sct.statechart.diagram.propertysheets;

import java.util.List;

import org.yakindu.model.sct.statechart.EntryKind;
import org.yakindu.model.sct.statechart.StatechartPackage;

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
				StatechartPackage.Literals.ENTRY__KIND, "Entry Kind: ",
				EntryKind.values());
		descriptors.add(comboDescriptor);
	}

}
