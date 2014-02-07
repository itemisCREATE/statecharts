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
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * Generic type system representation, which is responsible of listing the
 * available types ({@link #getTypes()}) and inferring types for certain
 * operations (or feature calls - not yet supported).
 * 
 * @author Alexander Nyßen - Initial contribution and API
 */
public interface ITypeSystem {

	/**
	 * Representation of a (type) inference result, which is consists of an
	 * {@link InferredType} and a list of {@link InferenceIssue}.
	 * <p>
	 * Note that the {@link InferredType} may be null. In such a case the list
	 * of issues should document, why a type could not be inferred. The list of
	 * issues may also be non-empty, even if a type could be inferred. As an
	 * example consider the case where a base type could be inferred (e.g.
	 * integer), while issues indicate that value range constraints (modeled via
	 * {@link TypeConstraint}s) are violated.
	 * 
	 */
	public static class InferenceResult {
		private InferredType inferredType;
		private Collection<InferenceIssue> inferenceIssues;

		/**
		 * Constructs an {@link InferenceResult} from a concrete {@link Type}.
		 * The {@link InferenceResult} returned as result will contain an
		 * {@link InferredType} that contains the given {@link Type} and no
		 * {@link TypeConstraint}s and an empty list of {@link InferenceIssue}s.
		 * 
		 * @param type
		 *            The {@link Type} to construct the {@link InferenceResult}
		 *            for.
		 */
		public InferenceResult(Type type) {
			this(new InferredType(type));
		}

		public InferenceResult(InferredType inferredType) {
			this(inferredType, Collections.<InferenceIssue> emptyList());
		}

		public InferenceResult(InferredType inferredType,
				InferenceIssue inferenceIssue) {
			this(inferredType, Collections.singletonList(inferenceIssue));
		}

		public InferenceResult(InferredType inferredType,
				Collection<InferenceIssue> inferenceIssues) {
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

	/**
	 * Representation of an inference problem, consisting of a message and a
	 * severity.
	 */
	public class InferenceIssue {

		private String message;
		private int severity;

		/**
		 * Constructs a new {@link InferenceIssue} with the given message and
		 * severity.
		 * 
		 * @param message
		 *            The message depicting the cause of the inference issue.
		 *            May not be <code>null</null>.
		 * @param severity
		 *            The severity of this {@link InferenceIssue}. May be one of
		 *            {@link IStatus#OK}, {@link IStatus#WARNING}, or
		 *            {@link IStatus#ERROR}.
		 */
		public InferenceIssue(String message, int severity) {
			if (message == null) {
				throw new NullPointerException("Message may not be null.");
			}
			if (severity != IStatus.OK && severity != IStatus.WARNING
					&& severity != IStatus.ERROR) {
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
		 * Returns the severity of this {@link InferenceIssue}. Will be one of
		 * the {@link IStatus#OK}, {@link IStatus#WARNING}, or
		 * {@link IStatus#ERROR}.
		 * 
		 * @return {@link IStatus#OK}, {@link IStatus#WARNING}, or
		 *         {@link IStatus#ERROR}
		 */
		public int getSeverity() {
			return severity;
		}

		@Override
		public boolean equals(Object obj) {
			return obj instanceof InferenceIssue
					&& ((InferenceIssue) obj).message.equals(message)
					&& severity == ((InferenceIssue) obj).severity;
		}

		@Override
		public int hashCode() {
			return message.hashCode() + severity;
		};
	}

	/**
	 * Representation of an inferred type, which is formed by a {@link Type} and
	 * a set of {@link TypeConstraint}s.
	 * <p>
	 * Note that the {@link Type} included in an {@link InferredType} does not
	 * necessarily have to be a concrete type that is provided via
	 * {@link ITypeSystem#getTypes()}, and should thus never be used by clients
	 * directly. In fact, the it may be an (abstract) type that is used by an
	 * {@link ITypeSystem} for purposes of type inference only. As an example
	 * consider a type system that offers a set of different integer types,
	 * which have different value ranges (modeled by {@link TypeConstraint}s)
	 * but no common base type. In such a case, the {@link ITypeSystem} may
	 * synthesize an abstract integer base type and use it during type inference
	 * (together with {@link TypeConstraint}s that narrow the range of supported
	 * values). In the end, {@link ITypeSystem#getTypes(InferredType))} may then
	 * use the synthesized integer base type (and the computed constraints) to
	 * decide which of its concrete integer types may be used and return them to
	 * the client.
	 * 
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
				throw new NullPointerException(
						"Constraints may be empty but not null.");
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

	public interface ITypeSystemOperator {
		public String getSymbol();
	}

	/**
	 * Returns a list of all types known in this type system.
	 * 
	 * @return The list of all types known in the type system
	 */
	public List<Type> getTypes();
	
	/**
	 * Infer a type for a given literal. The literal may represent a primitive
	 * value (primitive type literal) or an instance specification (complex type
	 * literal).
	 * 
	 * @param literal
	 *            The literal for which to infer a type
	 * @return An {@link InferenceResult} containing the {@link InferredType}
	 *         for the literal (or <code>null</code> in case no type could be
	 *         inferred) and potential {@link InferenceIssue}s that occurred
	 *         during the type inference. The result may also contain both, an
	 *         inferred type and issues.
	 */
	public InferenceResult inferTypeForLiteral(Object literal);

	/**
	 * Responsible of inferring the type for a given unary expression (e.g. a
	 * complement), where the type of the operand is already inferred.
	 * 
	 * @param operandType
	 *            The inferred type of the operand of the unary expression
	 * @param unaryOperator
	 *            The unary operator by which the expression is identified
	 * @return An {@link InferenceResult} containing the {@link InferredType} of
	 *         the expression (or <code>null</code> in case no type could be
	 *         inferred) and potential {@link InferenceIssue}s that occurred
	 *         during the type inference. The result may also contain both, an
	 *         inferred type and issues.
	 */
	public InferenceResult inferType(InferredType operandType,
			ITypeSystemOperator unaryOperator);

	/**
	 * Responsible of inferring the type for a given binary expression (e.g. an
	 * assignment), where the types of the two operands are already inferred.
	 * 
	 * @param firstOperandType
	 *            The inferred type of the first operand of the binary
	 *            expression
	 * @param secondOperandType
	 *            The inferred type of the second operand of the binary
	 *            expression
	 * @param binaryOperator
	 *            The binary operator by which the expression is identified
	 * @return An {@link InferenceResult} containing the {@link InferredType} of
	 *         the expression (or <code>null</code> in case no type could be
	 *         inferred) and potential {@link InferenceIssue}s that occurred
	 *         during the type inference. The result may also contain both, an
	 *         inferred type and issues.
	 */
	public InferenceResult inferType(InferredType firstOperandType,
			InferredType secondOperandType, ITypeSystemOperator binaryOperator);

	/**
	 * Responsible of inferring the type for a given ternary expression (e.g. a
	 * conditional expression), where the types of the three operands are
	 * already inferred.
	 * 
	 * @param firstOperandType
	 *            The inferred type of the first operand of the ternary
	 *            expression, e.g. the condition part the inferred type of the
	 *            condition expression
	 * @param secondOperandType
	 *            The inferred type of the second operand of a ternary
	 *            expression, e.g. in case of a conditional expression, the
	 *            inferred type of the <code>true</code> case
	 * @param thirdOperandType
	 *            The inferred type of the third operator of a ternary
	 *            expression, e.g. in case of a conditional expression, the
	 *            inferred type of the <code>false</code> case
	 * @param ternaryOperator
	 *            The ternary operator by which the ternary expression is
	 *            identified, e.g. '?' for conditionals.
	 * @return An {@link InferenceResult} containing the {@link InferredType} of
	 *         the expression (or <code>null</code> in case no type could be
	 *         inferred) and potential {@link InferenceIssue}s that occurred
	 *         during the inference. The result may also contain both, an
	 *         inferred type and issues, if for instance the condition part of a
	 *         conditional expression is not of type boolean but the true and
	 *         false cases provide valid type information that can be used to
	 *         calculate the type of the expression.
	 */
	public InferenceResult inferType(InferredType firstOperandType,
			InferredType secondOperandType, InferredType thirdOperandType,
			ITypeSystemOperator ternaryOperator);

	/**
	 * Returns the list of all concrete types, provided by the type system, that
	 * match the given inferred type, i.e. are compatible to its listed type and
	 * fulfill the given type constraints.
	 * 
	 * @param inferredType
	 *            The inferred type to evaluate
	 * @return The subset of all types returned via {@link #getTypes()} that is
	 *         compatible to the given inferred type.
	 */
	public List<Type> getTypes(InferredType inferredType);

	// TODO: uncomment these and remove need for specific ISTextTypeSystem interface
	// public InferredType getNumericalBaseType();
	// public InferredType getBooleanBaseType();
	// public InferredType getCharacterBaseType();
	// public InferredType getVoidBaseType();

}
