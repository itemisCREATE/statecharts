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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.mscript.language.ast.AssertionStatusKind;

/**
 * @author Andreas Unger
 *
 */
public class AssertionStatus extends InterpreterStatus {

	/**
	 * @param severity
	 * @param message
	 * @param source
	 * @param featureId
	 */
	public AssertionStatus(int severity, String message, EObject source, Integer featureId) {
		super(severity, message, source, featureId);
	}

	public static int assertionStatusKindToSeverity(AssertionStatusKind kind) {
		switch (kind) {
		case INFO:
			return IStatus.INFO;
		case WARNING:
			return IStatus.WARNING;
		case ERROR:
		case FATAL:
			return IStatus.ERROR;
		}
		return IStatus.ERROR;
	}

}
