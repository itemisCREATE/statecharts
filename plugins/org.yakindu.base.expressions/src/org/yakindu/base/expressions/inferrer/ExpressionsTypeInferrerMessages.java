package org.yakindu.base.expressions.inferrer;

public interface ExpressionsTypeInferrerMessages {

	public static final String LOGICAL_OPERATOR = "Logical operator '%s' may only be applied on boolean types, not on %s.";
	public static final String LOGICAL_OPERATORS = "Logical operator '%s' may only be applied on boolean types, not on %s and %s.";
	public static final String COMPARSION_OPERATOR = "Comparison operator '%s' may only be applied on compatible types, not on %s and %s.";
	public static final String BITWISE_OPERATOR = "Bitwise operator '%s' may only be applied on integer types, not on %s.";
	public static final String BITWISE_OPERATORS = "Bitwise operator '%s' may only be applied on integer types, not on %s and %s.";
	public static final String ASSIGNMENT_OPERATOR = "Assignment operator '%s' may only be applied on compatible types, not on %s and %s.";
	public static final String ARITHMETIC_OPERATOR = "Arithmetic operator '%s' may only be applied on numeric types, not on %s.";
	public static final String ARITHMETIC_OPERATORS = "Arithmetic operator '%s' may only be applied on numeric types, not on %s and %s.";
	public static final String COMMON_TYPE = "Could not determine a common type for %s and %s.";
	public static final String CONDITIONAL_BOOLEAN = "conditional expression must be of type boolean.";
	public static final String CAST_OPERATORS = "Cannot cast from %s to %s.";
	
//	public static final String COULD_NOT_INFER_A_TYPE_FOR_THE_OPERATION_NO_TYPE = "Could not infer a type for the operation %s, because no type was inferred for its operand.";
//	public static final String COULD_NOT_INFER_A_TYPE_FOR_THE_OPERATION_NOT_INFERRED = "Could not infer a type for the operation %s, because types were not inferred for all of its operands.";
//
//	public static final String OPERATOR_MAY_ONLY_BE_APPLIED_ON_A_PRIMITIVE_TYPE = "Operator %s may only be applied on a primitive type.";
//
//	public static final String BITWISE_OPERATOR_MAY_ONLY_BE_APPLIED_ON_INTEGER_TYPES = "Bitwise operator '%s' may only be applied on integer types, not on %s.";
//
//	public static final String ARITHMETIC_OPERATORS_MAY_ONLY_BE_APPLIED_ON_NUMERIC_TYPES_2 = "Arithmetic operator '%s' may only be applied on numeric types, not on %s and %s.";
//
//	public static final String LOGICAL_OPERATORS_MAY_ONLY_BE_APPLIED_ON_BOOLEAN_TYPES = "Logical operator '%s' may only be applied on boolean types, not on %s.";
//
//	public static final String COMPARSION_OPERATOR_MAY_ONLY_BE_APPLIED_ON_COMPATIBLE_TYPES = "Comparison operator '%s' may only be applied on compatible types, not on %s and %s.";
//
//	public static final String ASSIGNMENT_AND_EQUALITY_OPERATIONS_MAY_ONLY_BE_APPLIED_ON_TYPES_OF_THE_SAME_KIND = "Assignment and equality operations may only be applied on types of the same kind, not on %s and %s.";
//
//
//	
}
