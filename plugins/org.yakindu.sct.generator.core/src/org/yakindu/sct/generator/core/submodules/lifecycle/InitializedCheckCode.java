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

import com.google.inject.ImplementedBy;

/**
 * 
 * @author Thomas Kutz
 */
@ImplementedBy(InitializedCheckCode.Empty.class)
public interface InitializedCheckCode {
	
	CharSequence initializedCheckCode(ExecutionFlow flow);
	
	public static class Empty implements InitializedCheckCode {

		@Override
		public CharSequence initializedCheckCode(ExecutionFlow flow) {
			return "";
		}
		
	}
}
