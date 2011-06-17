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
package org.yakindu.sct.statechart.diagram.propertysheets;

import java.util.List;

import org.yakindu.model.sct.statechart.StatechartFactory;
import org.yakindu.model.sct.statechart.StatechartPackage;
import org.yakindu.sct.statechart.diagram.editparts.TransitionEditPart;
import org.yakindu.sct.statechart.diagram.extensions.Extensions;
import org.yakindu.sct.statechart.diagram.extensions.IExpressionsProvider;

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
				StatechartPackage.Literals.EXPRESSION_ELEMENT__EXPRESSION,
				"Expression: ", getInjector());
		descriptors.add(expressionsDescriptor);
	}

	protected Injector getInjector() {
		Extensions<IExpressionsProvider> extensions = new Extensions<IExpressionsProvider>(
				IExpressionsProvider.EXPRESSIONS_EXTENSION);
		IExpressionsProvider registeredProvider = extensions
				.getRegisteredProvider(StatechartFactory.eINSTANCE
						.createTransition());
		return registeredProvider.getInjector();
	}

}
