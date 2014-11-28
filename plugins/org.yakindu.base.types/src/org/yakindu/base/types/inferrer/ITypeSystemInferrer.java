/**
 * Copyright (c) 2014 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.base.types.inferrer;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer.ITypeTraceAcceptor.TypeTrace.Severity;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface ITypeSystemInferrer {

	public Type inferType(EObject object, ITypeTraceAcceptor acceptor);
	
	public Type inferType(EObject object);

	public interface ITypeTraceAcceptor {

		public static class TypeTrace {
			public static enum Severity {
				ERROR, WARNING, INFO
			}

			public TypeTrace(Severity severity, String message) {
				super();
				this.severity = severity;
				this.message = message;
			}

			private Severity severity;
			private String message;

			public Severity getSeverity() {
				return severity;
			}

			public void setSeverity(Severity severity) {
				this.severity = severity;
			}

			public String getMessage() {
				return message;
			}

			public void setMessage(String message) {
				this.message = message;
			}

			@Override
			public String toString() {
				return "TypeTrace [" + severity + ", message=" + message + "]";
			}
		}

		public void accept(TypeTrace trace);
	}

	public static final class ListBasedTypeTraceAcceptor implements ITypeTraceAcceptor {

		private List<TypeTrace> traces = Lists.newArrayList();

		@Override
		public void accept(TypeTrace trace) {
			traces.add(trace);
		}

		public List<TypeTrace> getTraces() {
			return traces;
		}

		public List<TypeTrace> getTraces(final Severity severity) {
			return Lists.newArrayList(Iterables.filter(traces, new Predicate<TypeTrace>() {
				@Override
				public boolean apply(TypeTrace input) {
					return input.getSeverity() == severity;
				}
			}));
		}

	}
}
