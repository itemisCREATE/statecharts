/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
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

import java.util.Arrays;

import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractIDValueConverter;
import org.eclipse.xtext.conversion.impl.AbstractValueConverter;
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

	@Override
	public String toValue(String string, INode node) throws ValueConverterException {
		if(string.split(".").length > 0){
			QualifiedName name = QualifiedName.create(Arrays.asList(string.split(".")));
			QualifiedName result = QualifiedName.EMPTY;
			for(String str : name.getSegments()){
				result.append(idValueConverter.toValue(str, node));
			}
			return result.toString();
		}else{
			return idValueConverter.toValue(string, node);
		}
	}

	@Override
	public String toString(String value) throws ValueConverterException {
		if(value.split(".").length > 0){
			QualifiedName name = QualifiedName.create(Arrays.asList(value.split(".")));
			QualifiedName result = QualifiedName.EMPTY;
			for(String str : name.getSegments()){
				result.append(idValueConverter.toString(str));
			}
			return result.toString();
		}else{
			return idValueConverter.toString(value);
		}
	}
}
