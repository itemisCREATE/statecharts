/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	rbeckmann - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.core.language.factory;

import org.yakindu.sct.generator.core.language.IFunction;
import org.yakindu.sct.generator.core.language.IType;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.StatechartScope;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

/**
 * @author rbeckmann
 *
 */
public interface IStandardFunctionProvider {
	/*
	 * Standard public Statemachine functions
	 */
	public IFunction init(ExecutionFlow it);
	public IFunction enter(ExecutionFlow it);
	public IFunction exit(ExecutionFlow it);
	public IFunction runCycle(ExecutionFlow it);
	public IFunction isActive(ExecutionFlow it);
	public IFunction isStateActive(ExecutionFlow it, IType statesEnumType);
	public IFunction isFinal(ExecutionFlow it);
	
	/* 
	 * Timed functions
	 */
	public IFunction getTimer();
	public IFunction setTimer();
	public IFunction raiseTimeEvent(ExecutionFlow it);

	/*
	 * Event related functions
	 */
	/* Internal interface */
	public IFunction raiseInternalEvent(StatechartScope scope, EventDefinition evd);
	public IFunction isInternalEventRaised(StatechartScope scope, EventDefinition evd);
	public IFunction getInternalEventValue(StatechartScope scope, EventDefinition evd);
	/* Regular interface */
	public IFunction raiseInterfaceEvent(StatechartScope scope, EventDefinition evd);
	public IFunction isInterfaceEventRaised(StatechartScope scope, EventDefinition evd);
	public IFunction getInterfaceEventValue(StatechartScope scope, EventDefinition evd);
	/* Default interface */
	public IFunction raiseDefaultInterfaceEvent(StatechartScope scope, EventDefinition evd);
	public IFunction isDefaultInterfaceEventRaised(StatechartScope scope, EventDefinition evd);
	public IFunction getDefaultInterfaceEventValue(StatechartScope scope, EventDefinition evd);

	/* Variable related functions */
	public IFunction getInterfaceVariable(VariableDefinition vad);
	public IFunction setInterfaceVariable(VariableDefinition vad);
	public IFunction getDefaultInterfaceVariable(VariableDefinition vad);
	public IFunction setDefaultInterfaceVariable(VariableDefinition vad);

}
