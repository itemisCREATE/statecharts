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

import java.util.Collection;
import java.util.Collections;

import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypeConstraint;

import com.google.common.collect.Lists;

/**
 * Representation of a (type) inference result, which is consists of an
 * {@link InferredType} and a list of {@link InferenceIssue}.
 * <p>
 * Note that the {@link InferredType} may be null. In such a case the list of
 * issues should document, why a type could not be inferred. The list of issues
 * may also be non-empty, even if a type could be inferred. As an example
 * consider the case where a base type could be inferred (e.g. integer), while
 * issues indicate that value range constraints (modeled via
 * {@link TypeConstraint}s) are violated.
 * 
 * @author Alexander Nyßen - Initial contribution and API
 * 
 */
public class InferenceResult {
	private InferredType inferredType;
	private Collection<InferenceIssue> inferenceIssues;

	/**
	 * Constructs an {@link InferenceResult} from a concrete {@link Type}. The
	 * {@link InferenceResult} returned as result will contain an
	 * {@link InferredType} that contains the given {@link Type} and no
	 * {@link TypeConstraint}s and an empty list of {@link InferenceIssue}s.
	 * 
	 * @param type
	 *            The {@link Type} to construct the {@link InferenceResult} for.
	 */
	public InferenceResult(Type type) {
		this(new InferredType(type));
	}

	public InferenceResult(InferredType inferredType) {
		this(inferredType, Lists.<InferenceIssue> newArrayList());
	}

	public InferenceResult(InferredType inferredType, InferenceIssue inferenceIssue) {
		this(inferredType, Collections.singletonList(inferenceIssue));
	}

	public InferenceResult(InferredType inferredType, Collection<InferenceIssue> inferenceIssues) {
		this.inferredType = inferredType;
		this.inferenceIssues = inferenceIssues;
	}

	public InferredType getType() {
		return inferredType;
	}

	public Collection<InferenceIssue> getIssues() {
		return inferenceIssues;
	}
}