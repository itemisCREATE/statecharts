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

package org.eclipselabs.mscript.language.internal.util;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.mscript.language.internal.LanguagePlugin;

public class EObjectDiagnostic extends BasicDiagnostic {

	public EObjectDiagnostic(int severity, String message, EObject source) {
		super(severity, LanguagePlugin.PLUGIN_ID, 0, message, new Object[] { source });
	}

	public EObjectDiagnostic(int severity, String message, EObject source, int featureId) {
		super(severity, LanguagePlugin.PLUGIN_ID, 0, message, new Object[] { source, featureId });
	}
	
}
