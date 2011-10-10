/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.propertysheets;

import java.util.List;

import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.ui.editor.editparts.StatechartTextEditPart;
import org.yakindu.sct.ui.editor.utils.IYakinduSctHelpContextIds;

import de.itemis.gmf.runtime.commons.properties.descriptors.IFormPropertyDescriptor;
import de.itemis.gmf.runtime.commons.properties.descriptors.TextPropertyDescriptor;
import de.itemis.gmf.runtime.commons.properties.descriptors.XtextPropertyDescriptor;
import de.itemis.xtext.utils.jface.viewers.context.IXtextContextFakeResourcesProvider;

/**
 * Property Section for {@link StatechartTextEditPart}s. Consists of a
 * {@link TextPropertyDescriptor} for the name field and an
 * {@link XtextPropertyDescriptor} for the expression.
 * 
 * @author andreas muelder
 * 
 */
public class StatechartPropertySection extends AbstractEditorPropertySection {

	@Override
	protected void createPropertyDescriptors(
			List<IFormPropertyDescriptor> descriptors) {
		// Text Property Descriptor for the name
		TextPropertyDescriptor nameDescriptor = new TextPropertyDescriptor(
				SGraphPackage.Literals.NAMED_ELEMENT__NAME, "Name: ");
		descriptors.add(nameDescriptor);
		
		// Xtext property descriptor for the expression
		XtextPropertyDescriptor expressionsDescriptor = new XtextPropertyDescriptor(
				SGraphPackage.Literals.EXPRESSION_ELEMENT__EXPRESSION,
				"Expression: ",
				IYakinduSctHelpContextIds.SC_PROPERTIES_STATECHART_EXPRESSION,
				getInjector(SGraphPackage.Literals.STATECHART),
				IXtextContextFakeResourcesProvider.NULL_CONTEXT_PROVIDER);
		descriptors.add(expressionsDescriptor);
	}

}
