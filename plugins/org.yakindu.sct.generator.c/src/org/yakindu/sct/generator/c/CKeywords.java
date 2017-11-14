/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.c;

/**
 * Helper class which contains an array with c language keywords
 * 
 * @author Markus Mühlbrandt
 * 
 */
public final class CKeywords implements org.yakindu.sct.generator.c.language.CKeywords {
	public static final String[] C_KEYWORDS = {ALIGNAS, ALIGNOF, AND, AND_EQ, ASM, AUTO, BITAND, BITOR, BOOL, BREAK,
			CASE, CATCH, CHAR, CHAR16_T, CHAR32_T, CLASS, COMPL, CONST, CONSTEXPR, CONST_CAST, CONTINUE, DECLTYPE,
			DEFAULT, DELETE, DO, DOUBLE, DYNAMIC_CAST, ELSE, ENUM, EXPLICIT, EXPORT, EXTERN, FALSE, FLOAT, FOR, FRIEND,
			GOTO, IF, INLINE, INT, LONG, MUTABLE, NAMESPACE, NEW, NOEXCEPT, NOT, NOT_EQ, NULLPTR, OPERATOR, OR, OR_EQ,
			PRIVATE, PROTECTED, PUBLIC, REGISTER, REINTERPRET_CAST, RETURN, SHORT, SIGNED, SIZEOF, STATIC,
			STATIC_ASSERT, STATIC_CAST, STRUCT, SWITCH, TEMPLATE, THIS, THREAD_LOCAL, THROW, TRUE, TRY, TYPEDEF, TYPEID,
			TYPENAME, UNION, UNSIGNED, USING, VIRTUAL, VOID, VOLATILE, WCHAR_T, WHILE, XOR, XOR_EQ,};

}
