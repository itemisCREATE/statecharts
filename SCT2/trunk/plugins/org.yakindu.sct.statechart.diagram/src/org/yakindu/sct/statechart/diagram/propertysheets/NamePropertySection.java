package org.yakindu.sct.statechart.diagram.propertysheets;

import java.util.List;

import org.yakindu.model.sct.statechart.NamedElement;
import org.yakindu.model.sct.statechart.StatechartPackage;

import de.itemis.gmf.runtime.commons.properties.GenericFormBasedPropertySection;
import de.itemis.gmf.runtime.commons.properties.descriptors.IFormPropertyDescriptor;
import de.itemis.gmf.runtime.commons.properties.descriptors.TextPropertyDescriptor;
/**
 * Base property section for all model elements that inherit from {@link NamedElement}
 * @author andreas muelder
 *
 */
public abstract class NamePropertySection extends GenericFormBasedPropertySection{

	@Override
	protected void createPropertyDescriptors(
			List<IFormPropertyDescriptor> descriptors) {
		// Text Property Descriptor for the name
		TextPropertyDescriptor nameDescriptor = new TextPropertyDescriptor(
				StatechartPackage.Literals.NAMED_ELEMENT__NAME, "Name: ");
		descriptors.add(nameDescriptor);
	}
}
