/**
 * Copyright (c) 2012 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.validation;

import org.eclipse.xtext.util.OnChangeEvictingCache;
import org.yakindu.base.types.Type;
import org.yakindu.sct.model.sgraph.Statement;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class TypeInferrerCache {
	public static interface ICacheableTypeAnalyzer {
		/**
		 * calculate the type of the statement. This method is not directly
		 * cached, but could delegate caches for subsequent elements
		 */
		public Type inferType(Statement stmt);
	}

	@Inject
	OnChangeEvictingCache cache;

	public Type get(final Statement stmt, final ICacheableTypeAnalyzer analyzer) {
		return cache.get(stmt, stmt.eResource(), new Provider<Type>() {
			public Type get() {
				return analyzer.inferType(stmt);
			}
		});
	}
}
