/**
 * Copyright (c) 2014 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.base.types.interpreter;

import java.util.Arrays;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.yakindu.base.types.typesystem.ITypeSystem;

import com.google.inject.Inject;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractTypeSystemInterpreter implements ITypeSystemInterpreter {

	private static final String METHOD_NAME = "interpret";

	private PolymorphicDispatcher<Object> dispatcher;

	public AbstractTypeSystemInterpreter() {
		initDispatcher();
	}

	public final Object interpretExpression(EObject object) {
		return dispatcher.invoke(object);
	}

	protected void initDispatcher() {
		dispatcher = new PolymorphicDispatcher<Object>(METHOD_NAME, 1, 1, Collections.singletonList(this),
				new PolymorphicDispatcher.ErrorHandler<Object>() {
					@Override
					public Object handle(Object[] params, Throwable throwable) {
						if (throwable instanceof NoSuchMethodError) {
							warning("No infer method for type " + Arrays.toString(params));
						} else {
							error(throwable.getMessage());
						}
						return null;
					}
				});
	}

	protected void warning(String msg) {
		// Howto report?
	}

	protected void error(String msg) {
		// Howto report?
	}

}
