/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.core.simulation;

import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface ISGraphExecutionListener {

	void stateEntered(Vertex vertex);

	void stateLeft(Vertex vertex);

	void transitionFired(Transition transition);


	void variableValueChanged(String variableName, Object value);

	void eventRaised(String eventName);

}
