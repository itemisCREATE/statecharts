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
import org.yakindu.sct.ui.editor.editparts.TransitionEditPart;
import org.yakindu.sct.ui.editor.extensions.ExpressionLanguageProviderExtensions.SemanticTarget;
import org.yakindu.sct.ui.editor.utils.IYakinduSctHelpContextIds;

import com.google.inject.Injector;

import de.itemis.gmf.runtime.commons.properties.descriptors.IFormPropertyDescriptor;
import de.itemis.gmf.runtime.commons.properties.descriptors.TextAreaPropertyDescriptor;
import de.itemis.gmf.runtime.commons.properties.descriptors.XtextPropertyDescriptor;
import de.itemis.xtext.utils.jface.viewers.context.CloningBasedFakeContextResourcesProvider;

/**
 * Property Section for {@link TransitionEditPart}s. Consists of a
 * {@link XtextPropertyDescriptor} for the expression.
 * 
 * @author andreas muelder
 * 
 */
public class TransitionPropertySection extends AbstractEditorPropertySection {

	@Override
	protected void createPropertyDescriptors(
			List<IFormPropertyDescriptor> descriptors) {
		Injector injector = getInjector(SemanticTarget.TransitionSpecification);
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
