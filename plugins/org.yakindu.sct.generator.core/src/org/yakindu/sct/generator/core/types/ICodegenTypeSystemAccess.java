/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.generator.core.types;

import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypeSpecifier;
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess.DefaultImpl;

import com.google.inject.ImplementedBy;

@ImplementedBy(DefaultImpl.class)
public interface ICodegenTypeSystemAccess {

	public String getTargetLanguageName(Type type);

	public String getTargetLanguageName(TypeSpecifier typeSpecifier);

	public static class DefaultImpl implements ICodegenTypeSystemAccess {

		@Override
		public String getTargetLanguageName(Type type) {
			return type.getName();
		}

		@Override
		public String getTargetLanguageName(TypeSpecifier typeSpecifier) {
			return typeSpecifier.getType().getName();
		}
	}

}
