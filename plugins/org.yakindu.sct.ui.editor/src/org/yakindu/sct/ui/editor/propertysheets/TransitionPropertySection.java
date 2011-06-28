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

import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.ui.editor.editparts.TransitionEditPart;
import org.yakindu.sct.ui.editor.extensions.Extensions;
import org.yakindu.sct.ui.editor.extensions.IExpressionsProvider;

import com.google.inject.Injector;

import de.itemis.gmf.runtime.commons.properties.GenericFormBasedPropertySection;
import de.itemis.gmf.runtime.commons.properties.descriptors.IFormPropertyDescriptor;

/**
 * Property Section for {@link TransitionEditPart}s. Consists of a
 * {@link XtextPropertyDescriptor} for the expression.
 * 
 * @author andreas muelder
 * 
 */
public class TransitionPropertySection extends GenericFormBasedPropertySection {

	@Override
	protected void createPropertyDescriptors(
			List<IFormPropertyDescriptor> descriptors) {
		XtextPropertyDescriptor expressionsDescriptor = new XtextPropertyDescriptor(
				SGraphPackage.Literals.EXPRESSION_ELEMENT__EXPRESSION,
				"Expression: ", getInjector());
		descriptors.add(expressionsDescriptor);
	}

	protected Injector getInjector() {
		Extensions<IExpressionsProvider> extensions = new Extensions<IExpressionsProvider>(
				IExpressionsProvider.EXPRESSIONS_EXTENSION);
		IExpressionsProvider registeredProvider = extensions
				.getRegisteredProvider(SGraphFactory.eINSTANCE
						.createTransition());
		return registeredProvider.getInjector();
	}

}
