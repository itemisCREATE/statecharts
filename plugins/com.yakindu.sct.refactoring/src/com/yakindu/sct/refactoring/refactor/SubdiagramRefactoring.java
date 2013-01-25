/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package com.yakindu.sct.refactoring.refactor;

import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.ui.editor.utils.GMFNotationUtil;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class SubdiagramRefactoring extends AbstractRefactoring<View> {

	private static final String INLINE_STYLE = "isInline";

	@SuppressWarnings("unchecked")
	protected BooleanValueStyle getInlineStyle() {
		BooleanValueStyle result = GMFNotationUtil.getBooleanValueStyle(
				getContextObject(), INLINE_STYLE);
		if (result == null) {
			result = NotationFactory.eINSTANCE.createBooleanValueStyle();
			result.setName(INLINE_STYLE);
			result.setBooleanValue(true);
			getContextObject().getStyles().add(result);
		}
		return result;

	}

}
