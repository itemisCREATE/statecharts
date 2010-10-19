/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.mscript.language.interpreter;

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.mscript.language.internal.LanguagePlugin;

public class InterpreterStatus extends Status {

	private EObject source;
	private Integer featureId;

	/**
	 * @param severity
	 * @param pluginId
	 * @param code
	 * @param message
	 * @param exception
	 */
	public InterpreterStatus(int severity, String message, EObject source, Integer featureId) {
		super(severity, LanguagePlugin.PLUGIN_ID, 0, message, null);
		this.source = source;
		this.featureId = featureId;
	}
	
	/**
	 * @return the source
	 */
	public EObject getSource() {
		return source;
	}
	
	/**
	 * @return the featureId
	 */
	public Integer getFeatureId() {
		return featureId;
	}

}
