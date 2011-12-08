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
import org.yakindu.sct.ui.editor.editparts.StateEditPart;
import org.yakindu.sct.ui.editor.extensions.ExpressionLanguageProviderExtensions.SemanticTarget;
import org.yakindu.sct.ui.editor.utils.IYakinduSctHelpContextIds;

import com.google.inject.Injector;

import de.itemis.gmf.runtime.commons.properties.descriptors.IFormPropertyDescriptor;
import de.itemis.gmf.runtime.commons.properties.descriptors.TextAreaPropertyDescriptor;
import de.itemis.gmf.runtime.commons.properties.descriptors.TextPropertyDescriptor;
import de.itemis.gmf.runtime.commons.properties.descriptors.XtextPropertyDescriptor;
import de.itemis.xtext.utils.jface.viewers.context.CloningBasedFakeContextResourcesProvider;

/**
 * Property Section for {@link StateEditPart}s. Consists of a
 * {@link TextPropertyDescriptor} for the name field and an
 * {@link XtextPropertyDescriptor} for the expression.
 * 
 * @author andreas muelder
 * 
 */
public class StatePropertySection extends NamePropertySection {

	@Override
	protected void createPropertyDescriptors(
			List<IFormPropertyDescriptor> descriptors) {
		super.createPropertyDescriptors(descriptors);

		Injector injector = getInjector(SemanticTarget.StateSpecification);
		if (injector != null) {
			XtextPropertyDescriptor descriptor = new XtextPropertyDescriptor(
					SGraphPackage.Literals.EXPRESSION_ELEMENT__EXPRESSION,
					"Expression: ",
					IYakinduSctHelpContextIds.SC_PROPERTIES_STATE_EXPRESSION,
					injector, new CloningBasedFakeContextResourcesProvider(
							Collections
									.singletonList(getActiveEditorResource())));
			descriptors.add(descriptor);
		} else {
			TextAreaPropertyDescriptor descriptor = new TextAreaPropertyDescriptor(
					SGraphPackage.Literals.EXPRESSION_ELEMENT__EXPRESSION,
					"Expression: ");
			descriptors.add(descriptor);
		}

		// Submachine reference
		SubmachineSelectionDialogPropertyDescriptor submachineDescriptor = new SubmachineSelectionDialogPropertyDescriptor();
		descriptors.add(submachineDescriptor);
	}
}
