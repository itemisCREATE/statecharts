/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.mscript.language.conversion;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

/**
 * @author Andreas Unger
 *
 */
public class MscriptTerminalConverters extends DefaultTerminalConverters {

	@ValueConverter(rule = "ValidDouble")
	public IValueConverter<Double> ValidDouble() {
		return new IValueConverter<Double>() {
			
			public Double toValue(String string, INode node) {
				if (Strings.isEmpty(string))
					throw new ValueConverterException("Couldn't convert empty string to double", node, null);
				try {
					return Double.valueOf(string);
				} catch (NumberFormatException e) {
					throw new ValueConverterException("Couldn't convert '" + string + "' to double", node, e);
				}
			}

			public String toString(Double value) {
				return value.toString();
			}

		};
	}

	@ValueConverter(rule = "ValidInt")
	public IValueConverter<Integer> ValidInt() {
		return new IValueConverter<Integer>() {
			
			public Integer toValue(String string, INode node) {
				if (Strings.isEmpty(string))
					throw new ValueConverterException("Couldn't convert empty string to long", node, null);
				try {
					return Integer.valueOf(string);
				} catch (NumberFormatException e) {
					throw new ValueConverterException("Couldn't convert '" + string + "' to long", node, e);
				}
			}

			public String toString(Integer value) {
				return value.toString();
			}

		};
	}

	@ValueConverter(rule = "ValidLong")
	public IValueConverter<Long> ValidLong() {
		return new IValueConverter<Long>() {
			
			public Long toValue(String string, INode node) {
				if (Strings.isEmpty(string))
					throw new ValueConverterException("Couldn't convert empty string to long", node, null);
				try {
					return Long.valueOf(string);
				} catch (NumberFormatException e) {
					throw new ValueConverterException("Couldn't convert '" + string + "' to long", node, e);
				}
			}

			public String toString(Long value) {
				return value.toString();
			}

		};
	}

	@ValueConverter(rule = "UnitExpressionExponent")
	public IValueConverter<Integer> UnitExpressionExponent() {
		return new IValueConverter<Integer>() {
			
			public Integer toValue(String string, INode node) {
				if (Strings.isEmpty(string))
					throw new ValueConverterException("Couldn't convert empty string to int", node, null);
				try {
					return Integer.valueOf(string);
				} catch (NumberFormatException e) {
					throw new ValueConverterException("Couldn't convert '" + string + "' to int", node, e);
				}
			}

			public String toString(Integer value) {
				return value.toString();
			}

		};
	}

}
