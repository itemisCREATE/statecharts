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

import java.util.regex.Pattern;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;
import org.eclipselabs.mscript.typesystem.IntegerData;
import org.eclipselabs.mscript.typesystem.RealData;

/**
 * @author Andreas Unger
 *
 */
public class MscriptTerminalConverters extends DefaultTerminalConverters {
	
	private static final Pattern WHITE_SPACE_PATTERN = Pattern.compile("\\s");

	@ValueConverter(rule = "RealData")
	public IValueConverter<RealData> RealData() {
		return new IValueConverter<RealData>() {
			
			public RealData toValue(String string, INode node) {
				if (Strings.isEmpty(string)) {
					return new RealData(0.0);
				}
				try {
					return RealData.valueOf(string);
				} catch (NumberFormatException e) {
					throw new ValueConverterException("Couldn't convert '" + string + "' to RealData", node, e);
				}
			}

			public String toString(RealData value) {
				return value.toString();
			}

		};
	}

	@ValueConverter(rule = "IntegerData")
	public IValueConverter<IntegerData> IntegerData() {
		return new IValueConverter<IntegerData>() {
			
			public IntegerData toValue(String string, INode node) {
				if (Strings.isEmpty(string)) {
					return new IntegerData(0);
				}
				try {
					return IntegerData.valueOf(string);
				} catch (NumberFormatException e) {
					throw new ValueConverterException("Couldn't convert '" + string + "' to IntegerData", node, e);
				}
			}

			public String toString(IntegerData value) {
				return value.toString();
			}

		};
	}

	@ValueConverter(rule = "ValidInt")
	public IValueConverter<Integer> ValidInt() {
		return new IValueConverter<Integer>() {
			
			public Integer toValue(String string, INode node) {
				if (Strings.isEmpty(string)) {
					return Integer.valueOf(0);
				}
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

	@ValueConverter(rule = "ValidLong")
	public IValueConverter<Long> ValidLong() {
		return new IValueConverter<Long>() {
			
			public Long toValue(String string, INode node) {
				if (Strings.isEmpty(string)) {
					return Long.valueOf(0L);
				}
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

	@ValueConverter(rule = "UnitExponent")
	public IValueConverter<Integer> UnitExponent() {
		return new IValueConverter<Integer>() {
			
			public Integer toValue(String string, INode node) {
				if (Strings.isEmpty(string)) {
					return Integer.valueOf(0);
				}
				try {
					return Integer.valueOf(WHITE_SPACE_PATTERN.matcher(string).replaceAll(""));
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
