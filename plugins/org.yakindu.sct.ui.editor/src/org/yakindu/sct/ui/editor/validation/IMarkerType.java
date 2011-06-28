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
package org.yakindu.sct.ui.editor.validation;

import org.yakindu.sct.ui.editor.DiagramActivator;

/**
 * 
 * @author andreas muelder
 * 
 */
public interface IMarkerType {

	public static final String DIAGRAM_MARKER_TYPE = DiagramActivator.PLUGIN_ID
			+ ".diagnostic";

	public static final String XTEXT_MARKER_TYPE = DiagramActivator.PLUGIN_ID
			+ ".xtext.diagnostic";

}
