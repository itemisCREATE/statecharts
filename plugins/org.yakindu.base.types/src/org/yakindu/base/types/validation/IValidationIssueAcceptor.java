/**
 * Copyright (c) 2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.base.types.validation;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.yakindu.base.types.validation.IValidationIssueAcceptor.ValidationIssue.Severity;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface IValidationIssueAcceptor {

	public static class ValidationIssue {
		public static enum Severity {
			ERROR, WARNING, INFO
		}

		private Severity severity;
		private String message;
		private EObject target;

		public ValidationIssue(Severity severity, String message) {
			super();
			this.severity = severity;
			this.message = message;
		}

		public ValidationIssue(Severity severity, String message, EObject target) {
			super();
			this.severity = severity;
			this.message = message;
			this.target = target;
		}

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

		public EObject getTarget() {
			return target;
		}

		public void setTarget(EObject target) {
			this.target = target;
		}

		@Override
		public String toString() {
			return "ValidationIssue [severity=" + severity + ", message=" + message + ", target=" + target + "]";
		}

	}

	public void accept(ValidationIssue trace);

	public static final class ListBasedValidationIssueAcceptor implements IValidationIssueAcceptor {

		private List<ValidationIssue> traces = Lists.newArrayList();

		@Override
		public void accept(ValidationIssue trace) {
			traces.add(trace);
		}

		public List<ValidationIssue> getTraces() {
			return traces;
		}

		public List<ValidationIssue> getTraces(final Severity severity) {
			return Lists.newArrayList(Iterables.filter(traces, new Predicate<ValidationIssue>() {
				@Override
				public boolean apply(ValidationIssue input) {
					return input.getSeverity() == severity;
				}
			}));
		}

	}

}
