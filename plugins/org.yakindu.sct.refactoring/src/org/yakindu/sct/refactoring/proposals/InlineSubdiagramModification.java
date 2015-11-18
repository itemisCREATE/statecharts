/**
 * Copyright (c) 2013-2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.refactoring.proposals;

import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.refactoring.refactor.impl.InlineSubdiagramRefactoring;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * @author terfloth
 * 
 */
public class InlineSubdiagramModification extends RefactoringBasedModification {

	public InlineSubdiagramModification(View view) {
		super(view, new InlineSubdiagramRefactoring());
	}

}
