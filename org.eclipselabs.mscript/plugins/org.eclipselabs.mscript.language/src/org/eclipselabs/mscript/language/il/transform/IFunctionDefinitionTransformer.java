/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.mscript.language.il.transform;

import java.util.List;

import org.eclipselabs.mscript.computation.core.value.IValue;
import org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor;
import org.eclipselabs.mscript.typesystem.DataType;

/**
 * @author Andreas Unger
 *
 */
public interface IFunctionDefinitionTransformer {

	IFunctionDefinitionTransformerResult transform(FunctionDescriptor functionDescriptor, String functionName,
			List<IValue> templateArguments, List<DataType> inputParameterDataTypes);

}