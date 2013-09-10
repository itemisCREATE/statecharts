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
package org.yakindu.sct.simulation.core.sexec.interpreter;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class CoreFunction extends Function {

	public static final String EQUALS = "==";
	public static final String NOT_EQUALS = "!=";
	public static final String SMALLER = "<";
	public static final String SMALLER_EQUAL = "<=";
	public static final String GREATER = ">";
	public static final String GREATER_EQUAL = ">=";

	public static final String BIT_AND = "&";
	public static final String BIT_OR = "|";
	public static final String BIT_XOR = "^";
	public static final String BIT_LSHIFT = "<<";
	public static final String BIT_RSHIFT = ">>";
	public static final String BIT_COMPLEMENT = "~";

	public static final String PLUS = "+";
	public static final String MINUS = "-";
	public static final String MULTIPLY = "*";
	public static final String DIVIDE = "/";
	public static final String MODULO = "%";

	public static final String POSITIVE = PLUS;
	public static final String NEGATIVE = MINUS;
	public static final String NOT = "!";

	@FunctionMethod(PLUS)
	public Integer plus(Integer i1, Integer i2) {
		return i1 + i2;
	}

	@FunctionMethod(PLUS)
	public Float plus(Float f1, Float f2) {
		return f1 + f2;
	}

	@FunctionMethod(PLUS)
	public Double plus(Double d1, Double d2) {
		return d1 + d2;
	}

	@FunctionMethod(PLUS)
	public Long plus(Long l1, Long l2) {
		return l1 + l2;
	}

	@FunctionMethod(PLUS)
	public Float plus(Integer f1, Float f2) {
		return f1 + f2;
	}

	@FunctionMethod(PLUS)
	public Double plus(Integer i1, Double d1) {
		return i1 + d1;
	}

	@FunctionMethod(PLUS)
	public Long plus(Integer i1, Long l1) {
		return i1 + l1;
	}

	@FunctionMethod(PLUS)
	public Float plus(Float f1, Integer i1) {
		return f1 + i1;
	}

	@FunctionMethod(PLUS)
	public Double plus(Float f1, Double d2) {
		return f1 + d2;
	}

	@FunctionMethod(PLUS)
	public Double plus(Double d1, Integer i1) {
		return d1 + i1;
	}

	@FunctionMethod(PLUS)
	public Double plus(Double d1, Float i1) {
		return d1 + i1;
	}

	@FunctionMethod(PLUS)
	public Double plus(Double d1, Long i1) {
		return d1 + i1;
	}

	@FunctionMethod(PLUS)
	public Long plus(Long l1, Integer i1) {
		return l1 + i1;
	}

	@FunctionMethod(PLUS)
	public Integer positive(Integer i) {
		return i;
	}

	@FunctionMethod(PLUS)
	public Float positive(Float f) {
		return f;
	}

	@FunctionMethod(PLUS)
	public Long positive(Long l) {
		return l;
	}

	@FunctionMethod(PLUS)
	public Double positive(Double d) {
		return d;
	}

	@FunctionMethod(PLUS)
	public Boolean positive(Boolean b) {
		return b;
	}

	@FunctionMethod(PLUS)
	public String positive(String s) {
		return s;
	}

	@FunctionMethod(MINUS)
	public Integer negative(Integer i) {
		return -i;
	}

	@FunctionMethod(MINUS)
	public Float negative(Float f) {
		return -f;
	}

	@FunctionMethod(MINUS)
	public Double negative(Double d) {
		return -d;
	}

	@FunctionMethod(MINUS)
	public Long negative(Long d) {
		return -d;
	}

	@FunctionMethod(MINUS)
	public Integer minus(Integer i1, Integer i2) {
		return i1 - i2;
	}

	@FunctionMethod(MINUS)
	public Float minus(Float f1, Float f2) {
		return f1 - f2;
	}

	@FunctionMethod(MINUS)
	public Double minus(Double d1, Double d2) {
		return d1 - d2;
	}

	@FunctionMethod(MINUS)
	public Long minus(Long l1, Long l2) {
		return l1 - l2;
	}

	@FunctionMethod(MINUS)
	public Float minus(Integer f1, Float f2) {
		return f1 - f2;
	}

	@FunctionMethod(MINUS)
	public Double minus(Integer i1, Double d1) {
		return i1 - d1;
	}

	@FunctionMethod(MINUS)
	public Long minus(Integer i1, Long l1) {
		return i1 - l1;
	}

	@FunctionMethod(MINUS)
	public Float minus(Float f1, Integer i1) {
		return f1 - i1;
	}

	@FunctionMethod(MINUS)
	public Double minus(Float f1, Double d2) {
		return f1 - d2;
	}

	@FunctionMethod(MINUS)
	public Double minus(Double d1, Integer i1) {
		return d1 - i1;
	}

	@FunctionMethod(MINUS)
	public Double minus(Double d1, Float i1) {
		return d1 - i1;
	}

	@FunctionMethod(MINUS)
	public Double minus(Double d1, Long i1) {
		return d1 - i1;
	}

	@FunctionMethod(MINUS)
	public Long minus(Long l1, Integer i1) {
		return l1 - i1;
	}

	@FunctionMethod(MULTIPLY)
	public Integer mul(Integer i1, Integer i2) {
		return i1 * i2;
	}

	@FunctionMethod(MULTIPLY)
	public Float mul(Float f1, Float f2) {
		return f1 * f2;
	}

	@FunctionMethod(MULTIPLY)
	public Double mul(Double d1, Double d2) {
		return d1 * d2;
	}

	@FunctionMethod(MULTIPLY)
	public Long mul(Long l1, Long l2) {
		return l1 * l2;
	}

	@FunctionMethod(MULTIPLY)
	public Float mul(Integer f1, Float f2) {
		return f1 * f2;
	}

	@FunctionMethod(MULTIPLY)
	public Double mul(Integer i1, Double d1) {
		return i1 * d1;
	}

	@FunctionMethod(MULTIPLY)
	public Long mul(Integer i1, Long l1) {
		return i1 * l1;
	}

	@FunctionMethod(MULTIPLY)
	public Float mul(Float f1, Integer i1) {
		return f1 * i1;
	}

	@FunctionMethod(MULTIPLY)
	public Double mul(Float f1, Double d2) {
		return f1 * d2;
	}

	@FunctionMethod(MULTIPLY)
	public Double mul(Double d1, Integer i1) {
		return d1 * i1;
	}

	@FunctionMethod(MULTIPLY)
	public Double mul(Double d1, Float i1) {
		return d1 * i1;
	}

	@FunctionMethod(MULTIPLY)
	public Double mul(Double d1, Long i1) {
		return d1 * i1;
	}

	@FunctionMethod(MULTIPLY)
	public Long mul(Long l1, Integer i1) {
		return l1 * i1;
	}

	@FunctionMethod(DIVIDE)
	public Integer div(Integer i1, Integer i2) {
		return i1 / i2;
	}

	@FunctionMethod(DIVIDE)
	public Float div(Float f1, Float f2) {
		return f1 / f2;
	}

	@FunctionMethod(DIVIDE)
	public Double div(Double d1, Double d2) {
		return d1 / d2;
	}

	@FunctionMethod(DIVIDE)
	public Long div(Long l1, Long l2) {
		return l1 / l2;
	}

	@FunctionMethod(DIVIDE)
	public Float div(Integer f1, Float f2) {
		return f1 / f2;
	}

	@FunctionMethod(DIVIDE)
	public Double div(Integer i1, Double d1) {
		return i1 / d1;
	}

	@FunctionMethod(DIVIDE)
	public Long div(Integer i1, Long l1) {
		return i1 / l1;
	}

	@FunctionMethod(DIVIDE)
	public Float div(Float f1, Integer i1) {
		return f1 / i1;
	}

	@FunctionMethod(DIVIDE)
	public Double div(Float f1, Double d2) {
		return f1 / d2;
	}

	@FunctionMethod(DIVIDE)
	public Double div(Double d1, Integer i1) {
		return d1 / i1;
	}

	@FunctionMethod(DIVIDE)
	public Double div(Double d1, Float i1) {
		return d1 / i1;
	}

	@FunctionMethod(DIVIDE)
	public Double div(Double d1, Long i1) {
		return d1 / i1;
	}

	@FunctionMethod(DIVIDE)
	public Long div(Long l1, Integer i1) {
		return l1 / i1;
	}

	@FunctionMethod(MODULO)
	public Integer mod(Integer i1, Integer i2) {
		return i1 % i2;
	}

	@FunctionMethod(MODULO)
	public Float mod(Float f1, Float f2) {
		return f1 % f2;
	}

	@FunctionMethod(MODULO)
	public Double mod(Double d1, Double d2) {
		return d1 % d2;
	}

	@FunctionMethod(MODULO)
	public Long mod(Long l1, Long l2) {
		return l1 % l2;
	}

	@FunctionMethod(MODULO)
	public Float mod(Integer f1, Float f2) {
		return f1 % f2;
	}

	@FunctionMethod(MODULO)
	public Double mod(Integer i1, Double d1) {
		return i1 % d1;
	}

	@FunctionMethod(MODULO)
	public Long mod(Integer i1, Long l1) {
		return i1 % l1;
	}

	@FunctionMethod(MODULO)
	public Float mod(Float f1, Integer i1) {
		return f1 % i1;
	}

	@FunctionMethod(MODULO)
	public Double mod(Float f1, Double d2) {
		return f1 % d2;
	}

	@FunctionMethod(MODULO)
	public Double mod(Double d1, Integer i1) {
		return d1 % i1;
	}

	@FunctionMethod(MODULO)
	public Double mod(Double d1, Float i1) {
		return d1 % i1;
	}

	@FunctionMethod(MODULO)
	public Double mod(Double d1, Long i1) {
		return d1 % i1;
	}

	@FunctionMethod(MODULO)
	public Long mod(Long l1, Integer i1) {
		return l1 % i1;
	}

	@FunctionMethod(BIT_LSHIFT)
	public Integer left(Integer i1, Integer i2) {
		return i1 << i2;
	}

	@FunctionMethod(BIT_RSHIFT)
	public Integer right(Integer i1, Integer i2) {
		return i1 >> i2;
	}

	@FunctionMethod(BIT_AND)
	public Integer bitwiseAnd(Integer i1, Integer i2) {
		return i1 & i2;
	}

	@FunctionMethod(BIT_OR)
	public Integer bitwiseOr(Integer i1, Integer i2) {
		return i1 | i2;
	}

	@FunctionMethod(BIT_XOR)
	public Integer bitwiseXor(Integer i1, Integer i2) {
		return i1 ^ i2;
	}

	@FunctionMethod(BIT_XOR)
	public Long bitwiseXor(Long l1, Long l2) {
		return l1 ^ l2;
	}

	@FunctionMethod(EQUALS)
	public Boolean equals(Boolean b1, Boolean b2) {
		return b1.equals(b2);
	}

	@FunctionMethod(EQUALS)
	public Boolean equals(EObject e1, EObject e2) {
		return EcoreUtil.equals(e1, e2);
	}

	@FunctionMethod(EQUALS)
	public Boolean equals(String string1, String string2) {
		return string1.equals(string2);
	}

	@FunctionMethod(EQUALS)
	public Boolean equals(Integer i1, Integer i2) {
		return i1.intValue() == i2.intValue();
	}

	@FunctionMethod(EQUALS)
	public Boolean equals(Float f1, Float f2) {
		return f1.floatValue() == f2.floatValue();
	}

	@FunctionMethod(EQUALS)
	public Boolean equals(Double d1, Double d2) {
		return d1.doubleValue() == d2.doubleValue();
	}

	@FunctionMethod(EQUALS)
	public Boolean equals(Long l1, Long l2) {
		return l1.longValue() == l2.longValue();
	}

	@FunctionMethod(EQUALS)
	public Boolean equals(Integer f1, Float f2) {
		return f1.intValue() == f2.floatValue();
	}

	@FunctionMethod(EQUALS)
	public Boolean equals(Integer i1, Double d1) {
		return i1.intValue() == d1.doubleValue();
	}

	@FunctionMethod(EQUALS)
	public Boolean equals(Integer i1, Long l1) {
		return i1.intValue() == l1.longValue();
	}

	@FunctionMethod(EQUALS)
	public Boolean equals(Float f1, Integer i1) {
		return f1.floatValue() == i1.intValue();
	}

	@FunctionMethod(EQUALS)
	public Boolean equals(Float f1, Double d2) {
		return f1.floatValue() == d2.doubleValue();
	}

	@FunctionMethod(EQUALS)
	public Boolean equals(Double d1, Integer i1) {
		return d1.doubleValue() == i1.intValue();
	}

	@FunctionMethod(EQUALS)
	public Boolean equals(Double d1, Float i1) {
		return d1.doubleValue() == i1.floatValue();
	}

	@FunctionMethod(EQUALS)
	public Boolean equals(Double d1, Long i1) {
		return d1.doubleValue() == i1.longValue();
	}

	@FunctionMethod(EQUALS)
	public Boolean equals(Long l1, Integer i1) {
		return l1.longValue() == i1.intValue();
	}

	@FunctionMethod(NOT_EQUALS)
	public Boolean notEquals(EObject e1, EObject e2) {
		return !EcoreUtil.equals(e1, e2);
	}

	@FunctionMethod(NOT_EQUALS)
	public Boolean notEquals(Boolean b1, Boolean b2) {
		return b1.booleanValue() != b2.booleanValue();
	}

	@FunctionMethod(NOT_EQUALS)
	public Boolean notEquals(String i1, String i2) {
		return !i1.equals(i2);
	}

	@FunctionMethod(NOT_EQUALS)
	public Boolean notEquals(Integer i1, Integer i2) {
		return i1.intValue() != i2.intValue();
	}

	@FunctionMethod(NOT_EQUALS)
	public Boolean notEquals(Float f1, Float f2) {
		return f1.floatValue() != f2.floatValue();
	}

	@FunctionMethod(NOT_EQUALS)
	public Boolean notEquals(Double d1, Double d2) {
		return d1.doubleValue() != d2.doubleValue();
	}

	@FunctionMethod(NOT_EQUALS)
	public Boolean notEquals(Long l1, Long l2) {
		return l1.longValue() != l2.longValue();
	}

	@FunctionMethod(NOT_EQUALS)
	public Boolean notEquals(Integer f1, Float f2) {
		return f1.intValue() != f2.floatValue();
	}

	@FunctionMethod(NOT_EQUALS)
	public Boolean notEquals(Integer i1, Double d1) {
		return i1.intValue() != d1.doubleValue();
	}

	@FunctionMethod(NOT_EQUALS)
	public Boolean notEquals(Integer i1, Long l1) {
		return i1.intValue() != l1.longValue();
	}

	@FunctionMethod(NOT_EQUALS)
	public Boolean notEquals(Float f1, Integer i1) {
		return f1.floatValue() != i1.intValue();
	}

	@FunctionMethod(NOT_EQUALS)
	public Boolean notEquals(Float f1, Double d2) {
		return f1.floatValue() != d2.doubleValue();
	}

	@FunctionMethod(NOT_EQUALS)
	public Boolean notEquals(Double d1, Integer i1) {
		return d1.doubleValue() != i1.intValue();
	}

	@FunctionMethod(NOT_EQUALS)
	public Boolean notEquals(Double d1, Float i1) {
		return d1.doubleValue() != i1.floatValue();
	}

	@FunctionMethod(NOT_EQUALS)
	public Boolean notEquals(Double d1, Long i1) {
		return d1.doubleValue() != i1.longValue();
	}

	@FunctionMethod(NOT_EQUALS)
	public Boolean notEquals(Long l1, Integer i1) {
		return l1.longValue() != i1.intValue();
	}

	@FunctionMethod(GREATER_EQUAL)
	public Boolean greaterEqual(Integer i1, Integer i2) {
		return i1 >= i2;
	}

	@FunctionMethod(GREATER_EQUAL)
	public Boolean greaterEqual(Float f1, Float f2) {
		return f1 >= f2;
	}

	@FunctionMethod(GREATER_EQUAL)
	public Boolean greaterEqual(Double d1, Double d2) {
		return d1 >= d2;
	}

	@FunctionMethod(GREATER_EQUAL)
	public Boolean greaterEqual(Long l1, Long l2) {
		return l1 >= l2;
	}

	@FunctionMethod(GREATER_EQUAL)
	public Boolean greaterEqual(Integer f1, Float f2) {
		return f1 >= f2;
	}

	@FunctionMethod(GREATER_EQUAL)
	public Boolean greaterEqual(Integer i1, Double d1) {
		return i1 >= d1;
	}

	@FunctionMethod(GREATER_EQUAL)
	public Boolean greaterEqual(Integer i1, Long l1) {
		return i1 >= l1;
	}

	@FunctionMethod(GREATER_EQUAL)
	public Boolean greaterEqual(Float f1, Integer i1) {
		return f1 >= i1;
	}

	@FunctionMethod(GREATER_EQUAL)
	public Boolean greaterEqual(Float f1, Double d2) {
		return f1 >= d2;
	}

	@FunctionMethod(GREATER_EQUAL)
	public Boolean greaterEqual(Double d1, Integer i1) {
		return d1 >= i1;
	}

	@FunctionMethod(GREATER_EQUAL)
	public Boolean greaterEqual(Double d1, Float i1) {
		return d1 >= i1;
	}

	@FunctionMethod(GREATER_EQUAL)
	public Boolean greaterEqual(Double d1, Long i1) {
		return d1 >= i1;
	}

	@FunctionMethod(GREATER_EQUAL)
	public Boolean greaterEqual(Long l1, Integer i1) {
		return l1 >= i1;
	}

	@FunctionMethod(SMALLER_EQUAL)
	public Boolean smallerEqual(Integer i1, Integer i2) {
		return i1 <= i2;
	}

	@FunctionMethod(SMALLER_EQUAL)
	public Boolean smallerEqual(Float f1, Float f2) {
		return f1 <= f2;
	}

	@FunctionMethod(SMALLER_EQUAL)
	public Boolean smallerEqual(Double d1, Double d2) {
		return d1 <= d2;
	}

	@FunctionMethod(SMALLER_EQUAL)
	public Boolean smallerEqual(Long l1, Long l2) {
		return l1 <= l2;
	}

	@FunctionMethod(SMALLER_EQUAL)
	public Boolean smallerEqual(Integer f1, Float f2) {
		return f1 <= f2;
	}

	@FunctionMethod(SMALLER_EQUAL)
	public Boolean smallerEqual(Integer i1, Double d1) {
		return i1 <= d1;
	}

	@FunctionMethod(SMALLER_EQUAL)
	public Boolean smallerEqual(Integer i1, Long l1) {
		return i1 <= l1;
	}

	@FunctionMethod(SMALLER_EQUAL)
	public Boolean smallerEqual(Float f1, Integer i1) {
		return f1 <= i1;
	}

	@FunctionMethod(SMALLER_EQUAL)
	public Boolean smallerEqual(Float f1, Double d2) {
		return f1 <= d2;
	}

	@FunctionMethod(SMALLER_EQUAL)
	public Boolean smallerEqual(Double d1, Integer i1) {
		return d1 <= i1;
	}

	@FunctionMethod(SMALLER_EQUAL)
	public Boolean smallerEqual(Double d1, Float i1) {
		return d1 <= i1;
	}

	@FunctionMethod(SMALLER_EQUAL)
	public Boolean smallerEqual(Double d1, Long i1) {
		return d1 <= i1;
	}

	@FunctionMethod(SMALLER_EQUAL)
	public Boolean smallerEqual(Long l1, Integer i1) {
		return l1 <= i1;
	}

	@FunctionMethod(GREATER)
	public Boolean greater(Integer i1, Integer i2) {
		return i1 > i2;
	}

	@FunctionMethod(GREATER)
	public Boolean greater(Float f1, Float f2) {
		return f1 > f2;
	}

	@FunctionMethod(GREATER)
	public Boolean greater(Double d1, Double d2) {
		return d1 > d2;
	}

	@FunctionMethod(GREATER)
	public Boolean greater(Long l1, Long l2) {
		return l1 > l2;
	}

	@FunctionMethod(GREATER)
	public Boolean greater(Integer f1, Float f2) {
		return f1 > f2;
	}

	@FunctionMethod(GREATER)
	public Boolean greater(Integer i1, Double d1) {
		return i1 > d1;
	}

	@FunctionMethod(GREATER)
	public Boolean greater(Integer i1, Long l1) {
		return i1 > l1;
	}

	@FunctionMethod(GREATER)
	public Boolean greater(Float f1, Integer i1) {
		return f1 > i1;
	}

	@FunctionMethod(GREATER)
	public Boolean greater(Float f1, Double d2) {
		return f1 > d2;
	}

	@FunctionMethod(GREATER)
	public Boolean greater(Double d1, Integer i1) {
		return d1 > i1;
	}

	@FunctionMethod(GREATER)
	public Boolean greater(Double d1, Float i1) {
		return d1 > i1;
	}

	@FunctionMethod(GREATER)
	public Boolean greater(Double d1, Long i1) {
		return d1 > i1;
	}

	@FunctionMethod(GREATER)
	public Boolean greater(Long l1, Integer i1) {
		return l1 > i1;
	}

	@FunctionMethod(SMALLER)
	public Boolean smaller(Integer i1, Integer i2) {
		return i1 < i2;
	}

	@FunctionMethod(SMALLER)
	public Boolean smaller(Float f1, Float f2) {
		return f1 < f2;
	}

	@FunctionMethod(SMALLER)
	public Boolean smaller(Double d1, Double d2) {
		return d1 < d2;
	}

	@FunctionMethod(SMALLER)
	public Boolean smaller(Long l1, Long l2) {
		return l1 < l2;
	}

	@FunctionMethod(SMALLER)
	public Boolean smaller(Integer f1, Float f2) {
		return f1 < f2;
	}

	@FunctionMethod(SMALLER)
	public Boolean smaller(Integer i1, Double d1) {
		return i1 < d1;
	}

	@FunctionMethod(SMALLER)
	public Boolean smaller(Integer i1, Long l1) {
		return i1 < l1;
	}

	@FunctionMethod(SMALLER)
	public Boolean smaller(Float f1, Integer i1) {
		return f1 < i1;
	}

	@FunctionMethod(SMALLER)
	public Boolean smaller(Float f1, Double d2) {
		return f1 < d2;
	}

	@FunctionMethod(SMALLER)
	public Boolean smaller(Double d1, Integer i1) {
		return d1 < i1;
	}

	@FunctionMethod(SMALLER)
	public Boolean smaller(Double d1, Float i1) {
		return d1 < i1;
	}

	@FunctionMethod(SMALLER)
	public Boolean smaller(Double d1, Long i1) {
		return d1 < i1;
	}

	@FunctionMethod(SMALLER)
	public Boolean smaller(Long l1, Integer i1) {
		return l1 < i1;
	}

	@FunctionMethod(NOT)
	public Boolean not(Boolean b) {
		return !b;
	}

	@FunctionMethod(BIT_COMPLEMENT)
	public Integer complement(Integer i) {
		return ~i;
	}
}
