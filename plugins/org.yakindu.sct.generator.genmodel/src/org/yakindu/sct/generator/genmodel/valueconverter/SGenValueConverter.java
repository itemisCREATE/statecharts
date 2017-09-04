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
package org.yakindu.sct.generator.genmodel.valueconverter;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.impl.AbstractIDValueConverter;

import com.google.inject.Inject;
/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SGenValueConverter extends DefaultTerminalConverters {

	@Inject
	private AbstractIDValueConverter idValueConverter;

	@ValueConverter(rule = "QID")
	public IValueConverter<String> ID() {
		return idValueConverter;
	}
	
}
