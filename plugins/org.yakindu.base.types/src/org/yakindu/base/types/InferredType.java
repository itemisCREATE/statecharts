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

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypeConstraint;

/**
 * Representation of an inferred type, which is formed by a {@link Type} and a
 * set of {@link TypeConstraint}s.
 * <p>
 * Note that the {@link Type} included in an {@link InferredType} does not
 * necessarily have to be a concrete type that is provided via
 * {@link ITypeSystem#getTypes()}, and should thus never be used by clients
 * directly. In fact, the it may be an (abstract) type that is used by an
 * {@link ITypeSystem} for purposes of type inference only. As an example
 * consider a type system that offers a set of different integer types, which
 * have different value ranges (modeled by {@link TypeConstraint}s) but no
 * common base type. In such a case, the {@link ITypeSystem} may synthesize an
 * abstract integer base type and use it during type inference (together with
 * {@link TypeConstraint}s that narrow the range of supported values). In the
 * end, {@link ITypeSystem#getTypes(InferredType))} may then use the synthesized
 * integer base type (and the computed constraints) to decide which of its
 * concrete integer types may be used and return them to the client.
 * 
 * @author Alexander Nyßen - Initial contribution and API
 */
public class InferredType {

	private Type type;
	private Collection<? extends TypeConstraint> constraints;

	public InferredType(Type type) {
		this(type, Collections.<TypeConstraint> emptyList());
	}

	public InferredType(Type type, Collection<TypeConstraint> constraints) {
		if (type == null) {
			throw new NullPointerException("Type may not be null.");
		}
		if (constraints == null) {
			throw new NullPointerException("Constraints may be empty but not null.");
		}
		this.type = type;
		this.constraints = constraints;
	}

	public Type getType() {
		return type;
	}

	public Collection<? extends TypeConstraint> getConstraints() {
		return constraints;
	}

	@Override
	public String toString() {
		return type.getName(); // TODO handle constraints...
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof InferredType)) {
			return false;
		}
		// check types
		InferredType other = (InferredType) obj;
		if (!EcoreUtil.equals(type, other.type)) {
			return false;
		}
		// check constraints
		for (TypeConstraint t1 : constraints) {
			boolean foundEqual = false;
			for (TypeConstraint t2 : other.constraints) {
				if (EcoreUtil.equals(t1, t2)) {
					foundEqual = true;
				}
			}
			if (!foundEqual) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		return type.hashCode();
	}
}