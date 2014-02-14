/**
 * Copyright (c) 2013 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 * 
 */
package org.yakindu.base.types;

import org.eclipse.core.runtime.IStatus;

/**
 * Representation of an inference problem, consisting of a message and a
 * severity.
 * 
 * @author Alexander Nyßen - Initial contribution and API
 */
public class InferenceIssue {

	private String message;
	private int severity;

	/**
	 * Constructs a new {@link InferenceIssue} with the given message and
	 * severity.
	 * 
	 * @param message
	 *            The message depicting the cause of the inference issue. May
	 *            not be <code>null</null>.
	 * @param severity
	 *            The severity of this {@link InferenceIssue}. May be one of
	 *            {@link IStatus#OK}, {@link IStatus#WARNING}, or
	 *            {@link IStatus#ERROR}.
	 */
	public InferenceIssue(String message, int severity) {
		if (message == null) {
			throw new NullPointerException("Message may not be null.");
		}
		if (severity != IStatus.OK && severity != IStatus.WARNING && severity != IStatus.ERROR) {
			throw new IllegalArgumentException(
					"Unsupported severity. Has to be one of IStatus#OK, IStatus#WARNING, or IStatus#ERROR");
		}
		this.severity = severity;
		this.message = message;
	}

	/**
	 * Returns the message that indicates the cause of this
	 * {@link InferenceIssue}.
	 * 
	 * @return A {@link String} depicting the message. Will never return
	 *         <code>null</code>
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Returns the severity of this {@link InferenceIssue}. Will be one of the
	 * {@link IStatus#OK}, {@link IStatus#WARNING}, or {@link IStatus#ERROR}.
	 * 
	 * @return {@link IStatus#OK}, {@link IStatus#WARNING}, or
	 *         {@link IStatus#ERROR}
	 */
	public int getSeverity() {
		return severity;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof InferenceIssue && ((InferenceIssue) obj).message.equals(message)
				&& severity == ((InferenceIssue) obj).severity;
	}

	@Override
	public int hashCode() {
		return message.hashCode() + severity;
	};
}