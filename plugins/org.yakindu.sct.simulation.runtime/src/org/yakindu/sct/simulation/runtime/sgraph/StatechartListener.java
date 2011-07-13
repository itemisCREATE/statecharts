/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.runtime.sgraph;

import org.yakindu.sct.simulation.runtime.sgraph.State;
import org.yakindu.sct.simulation.runtime.sgraph.Transition;

public interface StatechartListener {
	
	void stateEntered(State state);
	void stateLeft(State state);
	void transitionFired(Transition trans);

}
