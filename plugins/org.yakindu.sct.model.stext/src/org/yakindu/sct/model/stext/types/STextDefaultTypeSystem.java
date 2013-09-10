package org.yakindu.sct.model.stext.types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.yakindu.base.types.AbstractTypeSystem;
import org.yakindu.base.types.ComplexType;
import org.yakindu.base.types.EnumerationType;
import org.yakindu.base.types.ITypeSystem;
import org.yakindu.base.types.PrimitiveType;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypesFactory;

import com.google.inject.Singleton;

/**
 * Default implementation of an {@link ISTextTypeSystem} that is provided with
 * SText. The type system offers exactly five types, namely the primitives
 * <code>void</code>, <code>boolean</code>, <code>integer</code>,
 * <code>real</code>, <code>string</code>.
 * 
 * @author Alexander Nyßen (alexander.nyssen@itemis.de) - Initial contributino
 *         and API
 * 
 */
@Singleton
public class STextDefaultTypeSystem extends AbstractTypeSystem implements ISTextTypeSystem {

	/**
	 * Dummy resource. Xtext linker expects types to be contained in a resource.
	 */
	private static Resource resource;
	private static PrimitiveType voidType;
	private static PrimitiveType stringType;
	private static PrimitiveType realType;
	private static PrimitiveType integerType;
	private static PrimitiveType booleanType;

	protected static synchronized Resource getResource() {
		if (resource == null) {
			resource = new ResourceImpl();
			// use old uri for backwards compatibility
			resource.setURI(URI.createURI("platform:/plugin/org.yakindu.sct.model.stext/libraries/Primitives.types"));
		}
		return resource;
	}

	public Type getBooleanType() {
		synchronized (STextDefaultTypeSystem.class) {
			if (booleanType == null) {
				booleanType = TypesFactory.eINSTANCE.createPrimitiveType();
				booleanType.setName("boolean");
				getResource().getContents().add(booleanType);
			}
			return booleanType;
		}
	}

	public Type getIntegerType() {
		synchronized (STextDefaultTypeSystem.class) {
			if (integerType == null) {
				integerType = TypesFactory.eINSTANCE.createPrimitiveType();
				integerType.setName("integer");
				getResource().getContents().add(integerType);
			}
			return integerType;
		}
	}

	public Type getRealType() {
		synchronized (STextDefaultTypeSystem.class) {
			if (realType == null) {
				realType = TypesFactory.eINSTANCE.createPrimitiveType();
				realType.setName("real");
				getResource().getContents().add(realType);
			}
			return realType;
		}
	}

	public Type getStringType() {
		synchronized (STextDefaultTypeSystem.class) {
			if (stringType == null) {
				stringType = TypesFactory.eINSTANCE.createPrimitiveType();
				stringType.setName("string");
				getResource().getContents().add(stringType);
			}
			return stringType;
		}
	}

	public Type getVoidType() {
		synchronized (STextDefaultTypeSystem.class) {
			if (voidType == null) {
				voidType = TypesFactory.eINSTANCE.createPrimitiveType();
				voidType.setName("void");
				getResource().getContents().add(voidType);
			}
			return voidType;
		}
	}

	public InferenceResult inferTypeForLiteral(Object literal) {
		if (literal instanceof String) {
			return new InferenceResult(getStringType());
		} else if (literal instanceof Boolean) {
			return new InferenceResult(getBooleanType());
		} else if (literal instanceof Integer) {
			return new InferenceResult(getIntegerType());
		} else if (literal instanceof Float) {
			return new InferenceResult(getRealType());
		}
		throw new IllegalArgumentException("Literal of unknown kind " + literal);
	}

	public InferenceResult inferType(InferredType operandType, ITypeSystemOperator unaryOperator) {
		// some defense programming
		if (operandType == null) {
			throw new NullPointerException("operandType may not be null.");
		}

		// if the operand type could not be inferred, there is not much we can
		// do here
		if (operandType.getType() == null) {
			return new InferenceResult(null, new InferenceIssue("Could not infer a type for the operation "
					+ unaryOperator.getSymbol() + ", because no type was inferred for its operand.", IStatus.ERROR));
		}

		// check we have a primitive type
		if (!(operandType.getType() instanceof PrimitiveType)) {
			return new InferenceResult(null, new InferenceIssue("Operator " + unaryOperator.getSymbol()
					+ " may only be applied on a primitive type.", IStatus.ERROR));
		}

		// infer type based on given operator
		UnaryOperators o = (UnaryOperators) unaryOperator;
		switch (o) {
		case COMPLEMENT:
			if (!isIntegerType(operandType.getType())) {
				return new InferenceResult(null, new InferenceIssue("Bitwise operator '" + o.getSymbol()
						+ "' may only be applied on integer types, not on " + operandType.getType().getName() + ".",
						IStatus.ERROR));

			}
			return new InferenceResult(operandType);
		case NEGATIVE:
		case POSITIVE:
			if (!isIntegerType(operandType.getType()) && !isRealType(operandType.getType())) {
				return new InferenceResult(null, new InferenceIssue("Arithmetic operator '" + o.getSymbol()
						+ "' may only be applied on numeric types, not on " + operandType.getType().getName() + ".",
						IStatus.ERROR));
			}
			return new InferenceResult(operandType);
		case LOGICAL_NOT:
			if (!isBooleanType(operandType.getType())) {
				return new InferenceResult(null, new InferenceIssue("Logical operator '" + o.getSymbol()
						+ "' may only be applied on boolean types, not on " + operandType.getType().getName() + ".",
						IStatus.ERROR));

			}
			return new InferenceResult(operandType);
		default:
			throw new IllegalArgumentException("Unsupported unary operator: " + unaryOperator);
		}
	}

	public InferenceResult inferType(InferredType firstOperandType, InferredType secondOperandType,
			ITypeSystemOperator binaryOperator) {
		// some defense programming
		if (firstOperandType == null || secondOperandType == null) {
			throw new NullPointerException("Operand types may not be null.");
		}

		// if the operand type could not be inferred, there is not much we can
		// do here
		if (firstOperandType.getType() == null || secondOperandType.getType() == null) {
			return new InferenceResult(null, new InferenceIssue("Could not infer a type for the operation "
					+ binaryOperator.getSymbol() + ", because types were not inferred for all of its operands.",
					IStatus.ERROR));
		}

		// infer type base on operator (fist pass: check types are valid, second
		// pass: compute result type)
		BinaryOperators o = (BinaryOperators) binaryOperator;
		switch (o) {
		case BITWISE_OR:
		case BITWISE_XOR:
		case BITWISE_AND:
		case RIGHT_SHIFT:
		case LEFT_SHIFT:
		case ASSIGN_BITWISE_AND:
		case ASSIGN_BITWISE_OR:
		case ASSIGN_BITWISE_XOR:
		case ASSIGN_LEFT_SHIFT:
		case ASSIGN_RIGHT_SHIFT:
			// check only integer types are used
			if (!isIntegerType(firstOperandType.getType()) || !isIntegerType(secondOperandType.getType())) {
				return new InferenceResult(null, new InferenceIssue("Bitwise operator '" + o.getSymbol()
						+ "' may only be applied on integer types, not on " + firstOperandType.getType().getName()
						+ " and " + secondOperandType.getType().getName() + ".", IStatus.ERROR));
			}
			// second pass: compute common type
			switch (o) {
			case BITWISE_OR:
			case BITWISE_XOR:
			case BITWISE_AND:
				// compute union type
				return union(firstOperandType, secondOperandType);
			case RIGHT_SHIFT:
			case LEFT_SHIFT:
			case ASSIGN_LEFT_SHIFT:
			case ASSIGN_RIGHT_SHIFT:
			case ASSIGN_BITWISE_AND:
			case ASSIGN_BITWISE_OR:
			case ASSIGN_BITWISE_XOR:
				// return type of assignment target
				return new InferenceResult(firstOperandType);
			default:
				throw new IllegalStateException("Unsupported operator kind.");
			}
		case ADD:
		case SUBTRACT:
		case MULTIPLY:
		case DIV:
		case MOD:
		case ASSIGN_ADD:
		case ASSIGN_SUBTRACT:
		case ASSIGN_MULTIPLY:
		case ASSIGN_DIV:
		case ASSIGN_MOD:
			// only numeric types
			if (!isNumericType(firstOperandType.getType()) || !isNumericType(secondOperandType.getType())) {
				return new InferenceResult(null, new InferenceIssue("Arithmetic operator '" + o.getSymbol()
						+ "' may only be applied on numeric types, not on " + firstOperandType.getType().getName()
						+ " and " + secondOperandType.getType().getName() + ".", IStatus.ERROR));
			}

			// second pass: compute type
			switch (o) {
			case ADD:
			case SUBTRACT:
			case MULTIPLY:
			case DIV:
			case MOD:
				return union(firstOperandType, secondOperandType);
			case ASSIGN_ADD:
			case ASSIGN_SUBTRACT:
			case ASSIGN_MULTIPLY:
			case ASSIGN_DIV:
			case ASSIGN_MOD:
				// return type of assignment target
				return new InferenceResult(firstOperandType);
			default:
				throw new IllegalStateException("Unsupported operator kind.");
			}
		case LOGICAL_OR:
		case LOGICAL_AND:
			// only boolean types allowed
			if (!isBooleanType(firstOperandType.getType()) || !isBooleanType(secondOperandType.getType())) {
				return new InferenceResult(null, new InferenceIssue("Logical operator '" + o.getSymbol()
						+ "' may only be applied on boolean types, not on " + firstOperandType.getType().getName()
						+ " and " + secondOperandType.getType().getName() + ".", IStatus.ERROR));
			}

			// second pass: compute type
			switch (o) {
			case LOGICAL_OR:
			case LOGICAL_AND:
				return union(firstOperandType, secondOperandType);
			default:
				throw new IllegalStateException("Unsupported operator kind.");
			}
		case GREATER:
		case GREATER_EQUAL:
		case SMALLER:
		case SMALLER_EQUAL:
			// check we have primitive types
			if (!(firstOperandType.getType() instanceof PrimitiveType)
					|| !(secondOperandType.getType() instanceof PrimitiveType)) {
				return new InferenceResult(null, new InferenceIssue("Comparison operator '" + o.getSymbol()
						+ "' may only be applied on primitive types, not on " + firstOperandType.getType().getName()
						+ " and " + secondOperandType.getType().getName() + ".", IStatus.ERROR));
			}
			// check types have the same base type
			if (!EcoreUtil.equals(getBaseType((PrimitiveType) firstOperandType.getType()),
					getBaseType((PrimitiveType) secondOperandType.getType()))) {
				// exclude coercion case (integer -> real)
				if (!(isNumericType(firstOperandType.getType()) && isNumericType(secondOperandType.getType()))) {
					return new InferenceResult(null, new InferenceIssue("Comparison operator '" + o.getSymbol()
							+ "' may only be applied on compatible types, not on "
							+ firstOperandType.getType().getName() + " and " + secondOperandType.getType().getName()
							+ ".", IStatus.ERROR));
				}

			}
			// expression has boolean type
			return new InferenceResult(new InferredType(getBooleanType()));
		case EQUAL:
		case NOT_EQUAL:
		case ASSIGN:
			// complex types are allowed here
			if (firstOperandType.getType() instanceof PrimitiveType
					&& secondOperandType.getType() instanceof PrimitiveType) {
				// check primitive types have the same base type
				if (!EcoreUtil.equals(getBaseType((PrimitiveType) firstOperandType.getType()),
						getBaseType((PrimitiveType) secondOperandType.getType()))) {
					// handle coercion
					if (!(isNumericType(firstOperandType.getType()) && isNumericType(secondOperandType.getType()))) {
						return new InferenceResult(null, o.equals(BinaryOperators.ASSIGN) ? new InferenceIssue(
								"Assignment operator '" + o.getSymbol()
										+ "' may only be applied on compatible types, not on "
										+ firstOperandType.getType().getName() + " and "
										+ secondOperandType.getType().getName() + ".", IStatus.ERROR)
								: new InferenceIssue("Comparison operator '" + o.getSymbol()
										+ "' may only be applied on compatible types, not on "
										+ firstOperandType.getType().getName() + " and "
										+ secondOperandType.getType().getName() + ".", IStatus.ERROR));
					} else {
						if (o.equals(BinaryOperators.ASSIGN) && !isRealType(firstOperandType.getType())
								&& isRealType(secondOperandType.getType())) {
							// may only assign integer to real, not vice versa
							return new InferenceResult(null, new InferenceIssue("Assignment operator '" + o.getSymbol()
									+ "' may only be applied on compatible types, not on "
									+ firstOperandType.getType().getName() + " and "
									+ secondOperandType.getType().getName() + ".", IStatus.ERROR));
						}
					}
				}
			} else if (firstOperandType instanceof ComplexType && secondOperandType.getType() instanceof ComplexType) {
				// no further checks for complex types required here
				// (computation of type in second pass will result in null, if
				// they are not compatible)
			} else {
				return new InferenceResult(null, new InferenceIssue(
						"Assignment and equality operations may only be applied on types of the same kind, not on "
								+ firstOperandType.getType().getName() + " and "
								+ secondOperandType.getType().getName() + ".", IStatus.ERROR));
			}

			// second pass, compute types
			switch (o) {
			case ASSIGN:
				// type of assignment target
				return new InferenceResult(firstOperandType);
			case EQUAL:
			case NOT_EQUAL:
				// boolean type
				return new InferenceResult(new InferredType(getBooleanType()));
			default:
				throw new IllegalStateException("Unsupported operator kind.");
			}
		default:
			throw new IllegalArgumentException("Unsupported binary operator: " + binaryOperator);
		}
	}

	public InferenceResult inferType(InferredType firstOperandType, InferredType secondOperandType,
			InferredType thirdOperandType, ITypeSystemOperator ternaryOperator) {
		// some defense programming
		if (firstOperandType == null || secondOperandType == null || thirdOperandType == null) {
			throw new NullPointerException("Operand types may not be null");
		}

		// if the operand type could not be inferred, there is not much we can
		// do here
		if (firstOperandType.getType() == null || secondOperandType.getType() == null
				|| thirdOperandType.getType() == null) {
			return new InferenceResult(null, new InferenceIssue("Could not infer a type for the operation "
					+ ternaryOperator.getSymbol() + ", because types were not inferred for all of its operands.",
					IStatus.ERROR));
		}

		// infer type based on operator
		TernaryOperators o = (TernaryOperators) ternaryOperator;
		switch (o) {
		case CONDITIONAL:
			// first operand has to be boolean, second and third determine the
			// inferred type of the expression
			List<InferenceIssue> issues = new ArrayList<ITypeSystem.InferenceIssue>();
			if (!isBooleanType(firstOperandType.getType())) {
				issues.add(new InferenceIssue(
						"No valid type can be inferred for conditional expression, because type of first operand is not boolean.",
						IStatus.ERROR));
			}
			// compute a union of the second and third operand types
			InferenceResult unionResult = union(secondOperandType, thirdOperandType);
			unionResult.getIssues().addAll(issues);
			return unionResult;
		default:
			throw new IllegalArgumentException("Unsupported ternary operator: " + ternaryOperator);
		}
	}

	public InferenceResult union(InferredType firstType, InferredType secondType) {
		// defense programming
		if (firstType == null || secondType == null) {
			throw new NullPointerException("firstType and secondType may not be null.");
		}

		// if the operand type could not be inferred, there is not much we can
		// do here
		if (firstType.getType() == null || secondType.getType() == null) {
			return new InferenceResult(null, new InferenceIssue(
					"Could not infer a type union, because not all given types were properly inferred in advance.",
					IStatus.ERROR));
		}

		// infer the union of both given types
		if (firstType.getType() instanceof PrimitiveType && secondType.getType() instanceof PrimitiveType) {
			Type commonType = computeCommonType((PrimitiveType) firstType.getType(),
					(PrimitiveType) secondType.getType());
			if (commonType != null) {
				return new InferenceResult(new InferredType(commonType));
			} else {
				// handle coercion of types
				if (isNumericType(firstType) && isNumericType(secondType)) {
					// integer to real coercion
					if (isRealType(firstType)) {
						return new InferenceResult(firstType);
					} else {
						return new InferenceResult(secondType);
					}
				}
			}
		}
		return new InferenceResult(null, new InferenceIssue("Cannot compute a type union for the given types: "
				+ firstType + ", " + secondType, IStatus.ERROR));
	}

	public List<Type> getTypes(InferenceResult inferenceResult) {
		if (inferenceResult == null) {
			throw new NullPointerException("InferenceResult result may not be null.");
		}
		// we do not evaluate constraints and we only have one type of a kind
		if (inferenceResult.getType() == null) {
			return Collections.<Type> emptyList();
		} else {
			return Collections.singletonList(inferenceResult.getType().getType());
		}
	}

	public List<Type> getTypes() {
		List<Type> types = new ArrayList<Type>();
		types.add(getVoidType());
		types.add(getBooleanType());
		types.add(getIntegerType());
		types.add(getRealType());
		types.add(getStringType());
		return types;
	}

	public boolean isVoidType(Type type) {
		return EcoreUtil.equals(getVoidType(), type);
	}

	public boolean isVoidType(InferredType type) {
		return isVoidType(type.getType());
	}

	public boolean isBooleanType(InferredType type) {
		return isBooleanType(type.getType());
	}

	public boolean isBooleanType(Type type) {
		return EcoreUtil.equals(getBooleanType(), type);
	}

	public boolean isRealType(Type type) {
		return EcoreUtil.equals(getRealType(), type);
	}

	public boolean isRealType(InferredType type) {
		return isRealType(type.getType());
	}

	public boolean isIntegerType(Type type) {
		return EcoreUtil.equals(getIntegerType(), type);
	}

	public boolean isIntegerType(InferredType type) {
		return isIntegerType(type.getType());
	}

	public boolean isStringType(Type type) {
		return EcoreUtil.equals(getStringType(), type);
	}

	public boolean isStringType(InferredType type) {
		return isStringType(type.getType());
	}

	public boolean isNumericType(Type type) {
		return EcoreUtil.equals(getIntegerType(), type) || EcoreUtil.equals(getRealType(), type);
	}

	public boolean isNumericType(InferredType type) {
		return isNumericType(type.getType());
	}

	public List<Type> getTypes(InferredType inferredType) {
		if (inferredType == null) {
			throw new NullPointerException("inferredType may not be null.");
		}
		return Collections.singletonList(inferredType.getType());
	}

	public Object defaultValue(Type type) {
		if (isBooleanType(type))
			return true;
		if (isIntegerType(type))
			return 0;
		if (isRealType(type))
			return 0.0;
		if (isVoidType(type))
			return null;
		if (isStringType(type))
			return "";
		if (type instanceof EnumerationType) {
			return ((EnumerationType) type).getEnumerator().get(0);
		}
		throw new RuntimeException("No default value for type " + type);
	}

	public Object defaultValue(InferredType type) {
		return defaultValue(type.getType());
	}

}
