/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.stext.ui.contentassist;

import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.xtext.ui.editor.contentassist.DefaultContentAssistantFactory;

public class AsyncContentAssistContextFactory extends DefaultContentAssistantFactory {

	@Override
	protected ContentAssistant createAssistant() {
		return new ContentAssistant(true);
	}
}
