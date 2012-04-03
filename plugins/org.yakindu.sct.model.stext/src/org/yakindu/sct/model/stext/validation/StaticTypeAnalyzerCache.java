package org.yakindu.sct.model.stext.validation;

import org.eclipse.xtext.util.OnChangeEvictingCache;
import org.yakindu.base.types.Type;
import org.yakindu.sct.model.sgraph.Statement;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class StaticTypeAnalyzerCache {
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
