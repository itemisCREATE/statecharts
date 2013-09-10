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
package org.yakindu.sct.simulation.core.hmr;

import java.util.List;

import org.eclipse.debug.core.model.IDebugTarget;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface IHotModelReplacementListener {

	public void hotCodeReplaceFailed(List<IDebugTarget> affectedTargets);

}
