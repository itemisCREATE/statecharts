/**
 * Copyright (c) 2012-2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.sgraph.validation;

import org.eclipse.xtext.validation.ComposedChecks;
import org.yakindu.sct.model.sgraph.SGraphPackage;

/**
 * Root validator for all elements contained in {@link SGraphPackage}
 * 
 * This validator is intended to be used by a compositeValidator (See
 * {@link org.eclipse.xtext.validation.ComposedChecks}) of another language
 * specific validator. It does not register itself as an EValidator.
 *
 *
 */
@ComposedChecks(validators = { ResourceValidator.class, StatechartValidator.class, StateValidator.class,
		ChoiceValidator.class, EntryExitValidator.class, FinalStateValidator.class, SynchronizationValidator.class,
		TransitionValidator.class, VertexValidator.class })
public class SGraphJavaValidator extends AbstractSGraphValidator {

}
