/** 
 * Copyright (c) 2017 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.stext.ui.contentassist;

import java.lang.reflect.Constructor;

import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.xtext.ui.editor.contentassist.DefaultContentAssistantFactory;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class AsyncContentAssistContextFactory extends DefaultContentAssistantFactory {

	@Override
	protected ContentAssistant createAssistant() {
		try {
			// Async ContentAssist is only available since Oxygen
			Constructor<ContentAssistant> asyncConstructor = ContentAssistant.class.getConstructor(Boolean.TYPE);
			return asyncConstructor.newInstance(true);
		} catch (Exception e) {
			return new ContentAssistant();
		}
	}
}