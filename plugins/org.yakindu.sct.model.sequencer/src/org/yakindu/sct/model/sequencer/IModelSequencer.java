/** 
 * Copyright (c) 2019 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.sequencer;

import org.yakindu.base.types.Package;
import org.yakindu.base.types.validation.IValidationIssueAcceptor;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.inject.ImplementedBy;

@ImplementedBy(ModelSequencer.class)
public interface IModelSequencer {
	
	public static final String ADD_TRACES = "ADD_TRACES";

	public Package transform(Statechart statechart, IValidationIssueAcceptor acceptor);
	
	public Package transform(Statechart statechart);
}
