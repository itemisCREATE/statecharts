/** 
 * Copyright (c) 2017 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * 
 * Jonathan Thoene - initial API and implementation
 *
*/
package org.yakindu.base.expressions.terminals;

import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractIDValueConverter;
import org.eclipse.xtext.conversion.impl.AbstractValueConverter;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;

import com.google.inject.Inject;

/**
 * 
 * @author jonathan thoene - Initial contribution and API
 * 
 */

public class QIDValueConverter extends AbstractValueConverter<String> {

	@Inject
	protected AbstractIDValueConverter idValueConverter;
	@Inject
	protected IQualifiedNameConverter converter;

	@Override
	public String toValue(String string, INode node) throws ValueConverterException {
		QualifiedName name = converter.toQualifiedName(string);
		QualifiedName result = QualifiedName.EMPTY;
		for(String str : name.getSegments()){
			result = result.append(idValueConverter.toValue(str, node));
		}
		return result.toString();
	}

	@Override
	public String toString(String value) throws ValueConverterException {
		QualifiedName name = converter.toQualifiedName(value);
		QualifiedName result = QualifiedName.EMPTY;
		for(String str : name.getSegments()){
			result = result.append(idValueConverter.toString(str));
		}
		return result.toString();
	}
}
