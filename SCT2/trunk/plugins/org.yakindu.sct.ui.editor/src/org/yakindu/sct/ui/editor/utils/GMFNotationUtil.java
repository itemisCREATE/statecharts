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
package org.yakindu.sct.ui.editor.utils;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.NamedStyle;
import org.eclipse.gmf.runtime.notation.StringValueStyle;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.ViewImpl;

/**
 * Should be used instead of {@link ViewImpl}
 * {@link #getNamedStyle(View, Class, String)} because of
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=398976
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class GMFNotationUtil {

	@SuppressWarnings("unchecked")
	public static <T extends NamedStyle> T getNamedStyle(View view,
			Class<T> type, String name) {
		EList<Style> styles = view.getStyles();
		for (Style style : styles) {
			if (type.isAssignableFrom(style.getClass())) {
				if (name.equals(((NamedStyle) style).getName()))
					return (T) style;
			}
		}
		return null;
	}

	public static BooleanValueStyle getBooleanValueStyle(View view, String name) {
		return getNamedStyle(view, BooleanValueStyle.class, name);
	}

	public static StringValueStyle getStringValueStyle(View view, String name) {
		return getNamedStyle(view, StringValueStyle.class, name);
	}

}
