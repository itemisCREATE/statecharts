/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.sexec.interpreter.stext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class CoreFunction extends Function {

	// TODO: Unify with type system
	public static String EQUALS = "==";
	public static String NOT_EQUALS = "!=";
	public static String SMALLER = "<";
	public static String SMALLER_EQUAL = "<=";
	public static String GREATER = ">";
	public static String GREATER_EQUAL = ">=";

	public static String BIT_AND = "&";
	public static String BIT_OR = "|";
	public static String BIT_XOR = "^";
	public static String BIT_LSHIFT = "<<";
	public static String BIT_RSHIFT = ">>";
	public static String BIT_COMPLEMENT = "~";

	public static String PLUS = "+";
	public static String MINUS = "-";
	public static String MULTIPLY = "*";
	public static String DIVIDE = "/";
	public static String MODULO = "%";

	public static String POSITIVE = "+";
	public static String NEGATIVE = "-";
	public static String NOT = "!";

	@FunctionMethod("+")
	public Integer plus(Integer i1, Integer i2) {
		return i1 + i2;
	}

	@FunctionMethod("+")
	public Float plus(Float f1, Float f2) {
		return f1 + f2;
	}

	@FunctionMethod("+")
	public Float plus(Integer f1, Float f2) {
		return f1 + f2;
	}

	@FunctionMethod("+")
	public Float plus(Float f1, Integer f2) {
		return f1 + f2;
	}

	@FunctionMethod("+")
	public Integer positive(Integer i) {
		return i;
	}

	@FunctionMethod("+")
	public Float positive(Float f) {
		return f;
	}

	@FunctionMethod("-")
	public Integer negative(Integer i) {
		return -i;
	}

	@FunctionMethod("-")
	public Float negative(Float f) {
		return -f;
	}

	@FunctionMethod("-")
	public Integer minus(Integer i1, Integer i2) {
		return i1 - i2;
	}

	@FunctionMethod("-")
	public Float minus(Integer i1, Float i2) {
		return i1 - i2;
	}

	@FunctionMethod("-")
	public Float minus(Float i1, Integer i2) {
		return i1 - i2;
	}

	@FunctionMethod("-")
	public Float minus(Float i1, Float i2) {
		return i1 - i2;
	}

	@FunctionMethod("*")
	public Integer mul(Integer i1, Integer i2) {
		return i1 * i2;
	}

	@FunctionMethod("*")
	public Float mul(Integer i1, Float i2) {
		return i1 * i2;
	}

	@FunctionMethod("*")
	public Float mul(Float i1, Integer i2) {
		return i1 * i2;
	}

	@FunctionMethod("*")
	public Float mul(Float i1, Float i2) {
		return i1 * i2;
	}

	@FunctionMethod("/")
	public Integer div(Integer i1, Integer i2) {
		return i1 / i2;
	}

	@FunctionMethod("/")
	public Float div(Float i1, Integer i2) {
		return i1 / i2;
	}

	@FunctionMethod("/")
	public Float div(Integer i1, Float i2) {
		return i1 / i2;
	}

	@FunctionMethod("/")
	public Float div(Float i1, Float i2) {
		return i1 / i2;
	}

	@FunctionMethod("%")
	public Integer mod(Integer i1, Integer i2) {
		return i1 % i2;
	}

	@FunctionMethod("%")
	public Float mod(Integer i1, Float i2) {
		return i1 % i2;
	}

	@FunctionMethod("%")
	public Float mod(Float i1, Integer i2) {
		return i1 % i2;
	}

	@FunctionMethod("%")
	public Float mod(Float i1, Float i2) {
		return i1 % i2;
	}

	@FunctionMethod("<<")
	public Integer left(Integer i1, Integer i2) {
		return i1 << i2;
	}

	@FunctionMethod(">>")
	public Integer right(Integer i1, Integer i2) {
		return i1 >> i2;
	}

	@FunctionMethod("&")
	public Integer bitwiseAnd(Integer i1, Integer i2) {
		return i1 & i2;
	}

	@FunctionMethod("|")
	public Integer bitwiseOr(Integer i1, Integer i2) {
		return i1 | i2;
	}

	@FunctionMethod("^")
	public Integer bitwiseXor(Integer i1, Integer i2) {
		return i1 ^ i2;
	}

	@FunctionMethod("^")
	public Long bitwiseXor(Long l1, Long l2) {
		return l1 ^ l2;
	}

	@FunctionMethod("==")
	public Boolean equals(Boolean b1, Boolean b2) {
		return b1.equals(b2);
	}

	@FunctionMethod("==")
	public Boolean equals(Integer i1, Integer i2) {
		return i1.intValue() == i2.intValue();
	}

	@FunctionMethod("==")
	public Boolean equals(Float i1, Integer i2) {
		return i1.intValue() == i2.intValue();
	}

	@FunctionMethod("==")
	public Boolean equals(Integer i1, Float i2) {
		return i1.intValue() == i2.intValue();
	}

	@FunctionMethod("==")
	public Boolean equals(EObject e1, EObject e2) {
		return EcoreUtil.equals(e1, e2);
	}

	@FunctionMethod("==")
	public Boolean equals(Float i1, Float i2) {
		return i1.floatValue() == i2.floatValue();
	}

	@FunctionMethod("==")
	public Boolean equals(String string1, String string2) {
		return string1.equals(string2);
	}

	@FunctionMethod("!=")
	public Boolean notEquals(EObject e1, EObject e2) {
		return !EcoreUtil.equals(e1, e2);
	}

	@FunctionMethod("!=")
	public Boolean notEquals(Boolean b1, Boolean b2) {
		return b1.booleanValue() != b2.booleanValue();
	}

	@FunctionMethod("!=")
	public Boolean notEquals(Integer i1, Integer i2) {
		return i1.intValue() != i2.intValue();
	}

	@FunctionMethod("!=")
	public Boolean notEquals(Integer i1, Float i2) {
		return i1.intValue() != i2.intValue();
	}

	@FunctionMethod("!=")
	public Boolean notEquals(Float i1, Integer i2) {
		return i1.intValue() != i2.intValue();
	}

	@FunctionMethod("!=")
	public Boolean notEquals(Float i1, Float i2) {
		return i1.floatValue() != i2.floatValue();
	}

	@FunctionMethod("!=")
	public Boolean notEquals(String i1, String i2) {
		return !i1.equals(i2);
	}

	@FunctionMethod(">=")
	public Boolean greaterEqual(Integer i1, Integer i2) {
		return i1 >= i2;
	}

	@FunctionMethod(">=")
	public Boolean greaterEqual(Integer i1, Float i2) {
		return i1 >= i2;
	}

	@FunctionMethod(">=")
	public Boolean greaterEqual(Float i1, Integer i2) {
		return i1 >= i2;
	}

	@FunctionMethod(">=")
	public Boolean greaterEqual(Float i1, Float i2) {
		return i1 >= i2;
	}

	@FunctionMethod("<=")
	public Boolean smallerEqual(Integer i1, Integer i2) {
		return i1 <= i2;
	}

	@FunctionMethod("<=")
	public Boolean smallerEqual(Integer i1, Float i2) {
		return i1 <= i2;
	}

	@FunctionMethod("<=")
	public Boolean smallerEqual(Float i1, Integer i2) {
		return i1 <= i2;
	}

	@FunctionMethod("<=")
	public Boolean smallerEqual(Float i1, Float i2) {
		return i1 <= i2;
	}

	@FunctionMethod(">")
	public Boolean greater(Integer i1, Integer i2) {
		return i1 > i2;
	}

	@FunctionMethod(">")
	public Boolean greater(Float i1, Integer i2) {
		return i1 > i2;
	}

	@FunctionMethod(">")
	public Boolean greater(Integer i1, Float i2) {
		return i1 > i2;
	}

	@FunctionMethod(">")
	public Boolean greater(Float i1, Float i2) {
		return i1 > i2;
	}

	@FunctionMethod("<")
	public Boolean smaller(Integer i1, Integer i2) {
		return i1 < i2;
	}

	@FunctionMethod("<")
	public Boolean smaller(Integer i1, Float i2) {
		return i1 < i2;
	}

	@FunctionMethod("<")
	public Boolean smaller(Float i1, Integer i2) {
		return i1 < i2;
	}

	@FunctionMethod("<")
	public Boolean smaller(Float i1, Float i2) {
		return i1 < i2;
	}

	@FunctionMethod("!")
	public Boolean not(Boolean b) {
		return !b;
	}

	@FunctionMethod("+")
	public Boolean positive(Boolean b) {
		return b;
	}

	@FunctionMethod("+")
	public String positive(String s) {
		return s;
	}

	@FunctionMethod("+")
	public Double positive(Double d) {
		return d;
	}

	@FunctionMethod("-")
	public Double negative(Double d) {
		return -d;
	}

	@FunctionMethod("~")
	public Integer complement(Integer i) {
		return ~i;
	}
}
