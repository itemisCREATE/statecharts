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

import java.util.Collections;
import java.util.List;

import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.ui.editor.editparts.StatechartTextEditPart;
import org.yakindu.sct.ui.editor.extensions.ExpressionLanguageProviderExtensions.SemanticTarget;
import org.yakindu.sct.ui.editor.utils.IYakinduSctHelpContextIds;

import com.google.inject.Injector;

import de.itemis.gmf.runtime.commons.properties.descriptors.IFormPropertyDescriptor;
import de.itemis.gmf.runtime.commons.properties.descriptors.TextAreaPropertyDescriptor;
import de.itemis.gmf.runtime.commons.properties.descriptors.TextPropertyDescriptor;
import de.itemis.gmf.runtime.commons.properties.descriptors.XtextPropertyDescriptor;
import de.itemis.xtext.utils.jface.viewers.context.CloningBasedFakeContextResourcesProvider;

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
		
		Injector injector = getInjector(SemanticTarget.StatechartSpecification);
		
		if (injector != null) {
			XtextPropertyDescriptor descriptor = new XtextPropertyDescriptor(
					SGraphPackage.Literals.SPECIFICATION_ELEMENT__SPECIFICATION,
					"Expression: ",
					IYakinduSctHelpContextIds.SC_PROPERTIES_STATECHART_EXPRESSION,
					injector, new CloningBasedFakeContextResourcesProvider(
							Collections
									.singletonList(getActiveEditorResource())));
			descriptors.add(descriptor);
		} else {
			TextAreaPropertyDescriptor descriptor = new TextAreaPropertyDescriptor(
					SGraphPackage.Literals.SPECIFICATION_ELEMENT__SPECIFICATION,
					"Expression: ");
			descriptors.add(descriptor);
		}
	}

}
