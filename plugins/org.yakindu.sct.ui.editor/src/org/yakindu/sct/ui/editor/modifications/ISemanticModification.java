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
package org.yakindu.sct.ui.editor.modifications;

import org.eclipse.gmf.runtime.notation.View;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * @author terfloth - extenden API and made it stateful.
 * 
 */
public interface ISemanticModification {

	public void setTargetView(View view);
	public View getTargetView();
	
	public boolean isApplicable();

	public void modify();	
}
