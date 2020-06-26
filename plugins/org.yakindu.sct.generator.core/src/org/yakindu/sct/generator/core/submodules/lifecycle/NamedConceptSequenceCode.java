/**
 * Copyright (c) 2020 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.core.submodules.lifecycle;


import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.Sequence;

import com.google.inject.ImplementedBy;

/**
 * Named sequences are created by the ModelSequencer. These sequences contain 
 * no concrete (sexec & expression) code but are placeholders for higher level 
 * behavior which must be contributed by the specific code generators. This interface
 * allows higher level code generators to hook into the low level sexec flow code generators.
 * 
 * @author aterfloth
 */
@ImplementedBy(NamedConceptSequenceCodeDispatcher.class)
public interface NamedConceptSequenceCode {
	
	CharSequence stateMachineConceptCode(ExecutionFlow flow, Sequence s);

}
