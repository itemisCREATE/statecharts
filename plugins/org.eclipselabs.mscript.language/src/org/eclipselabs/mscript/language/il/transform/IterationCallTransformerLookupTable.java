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

package org.eclipselabs.mscript.language.il.transform;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Andreas Unger
 *
 */
public class IterationCallTransformerLookupTable {

	private Map<String, IIterationCallTransformer> transformers = new HashMap<String, IIterationCallTransformer>();
	
	{
		transformers.put("iterate", new IterateTransformer());
	}
	
	public IIterationCallTransformer getTransformer(String name) {
		return transformers.get(name);
	}
	
}
