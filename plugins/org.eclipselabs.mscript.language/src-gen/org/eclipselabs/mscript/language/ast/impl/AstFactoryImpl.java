/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipselabs.mscript.language.ast.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AstFactoryImpl extends EFactoryImpl implements AstFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AstFactory init()
  {
    try
    {
      AstFactory theAstFactory = (AstFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipselabs.org/mscript/AST/1.0.0"); 
      if (theAstFactory != null)
      {
        return theAstFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new AstFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AstFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case AstPackage.MSCRIPT: return createMscript();
      case AstPackage.NAMESPACE_DEFINITION: return createNamespaceDefinition();
      case AstPackage.NAMESPACE_MEMBER: return createNamespaceMember();
      case AstPackage.TYPE_DEFINITION: return createTypeDefinition();
      case AstPackage.DATA_TYPE_DEFINITION: return createDataTypeDefinition();
      case AstPackage.ENUMERATION_DEFINITION: return createEnumerationDefinition();
      case AstPackage.ENUMERATION_LITERAL_DECLARATION: return createEnumerationLiteralDeclaration();
      case AstPackage.TYPE_ALIAS_DEFINITION: return createTypeAliasDefinition();
      case AstPackage.RECORD_DEFINITION: return createRecordDefinition();
      case AstPackage.RECORD_FIELD_DECLARATION: return createRecordFieldDeclaration();
      case AstPackage.FUNCTION_DEFINITION: return createFunctionDefinition();
      case AstPackage.PARAMETER_DECLARATION: return createParameterDeclaration();
      case AstPackage.ASSERTION_DECLARATION: return createAssertionDeclaration();
      case AstPackage.STATE_VARIABLE_DECLARATION: return createStateVariableDeclaration();
      case AstPackage.FUNCTOR_DECLARATION: return createFunctorDeclaration();
      case AstPackage.ARGUMENT_DECLARATION: return createArgumentDeclaration();
      case AstPackage.EQUATION_DEFINITION: return createEquationDefinition();
      case AstPackage.DATA_TYPE_SPECIFIER: return createDataTypeSpecifier();
      case AstPackage.PRIMITIVE_TYPE_SPECIFIER: return createPrimitiveTypeSpecifier();
      case AstPackage.NUMERIC_TYPE_SPECIFIER: return createNumericTypeSpecifier();
      case AstPackage.REAL_TYPE_SPECIFIER: return createRealTypeSpecifier();
      case AstPackage.INTEGER_TYPE_SPECIFIER: return createIntegerTypeSpecifier();
      case AstPackage.COMPLEX_TYPE_SPECIFIER: return createComplexTypeSpecifier();
      case AstPackage.GAUSSIAN_TYPE_SPECIFIER: return createGaussianTypeSpecifier();
      case AstPackage.BOOLEAN_TYPE_SPECIFIER: return createBooleanTypeSpecifier();
      case AstPackage.STRING_TYPE_SPECIFIER: return createStringTypeSpecifier();
      case AstPackage.NAMED_TYPE_SPECIFIER: return createNamedTypeSpecifier();
      case AstPackage.ARRAY_DIMENSION_SPECIFICATION: return createArrayDimensionSpecification();
      case AstPackage.EXPRESSION: return createExpression();
      case AstPackage.LET_EXPRESSION: return createLetExpression();
      case AstPackage.LET_EXPRESSION_VARIABLE: return createLetExpressionVariable();
      case AstPackage.IF_EXPRESSION: return createIfExpression();
      case AstPackage.SWITCH_EXPRESSION: return createSwitchExpression();
      case AstPackage.SWITCH_CASE: return createSwitchCase();
      case AstPackage.ADDITIVE_EXPRESSION_PART: return createAdditiveExpressionPart();
      case AstPackage.MULTIPLICATIVE_EXPRESSION_PART: return createMultiplicativeExpressionPart();
      case AstPackage.LITERAL: return createLiteral();
      case AstPackage.NUMERIC_LITERAL: return createNumericLiteral();
      case AstPackage.REAL_LITERAL: return createRealLiteral();
      case AstPackage.INTEGER_LITERAL: return createIntegerLiteral();
      case AstPackage.BOOLEAN_LITERAL: return createBooleanLiteral();
      case AstPackage.STRING_LITERAL: return createStringLiteral();
      case AstPackage.FEATURE_CALL_PART: return createFeatureCallPart();
      case AstPackage.FEATURE_ACCESS: return createFeatureAccess();
      case AstPackage.ARRAY_ELEMENT_ACCESS: return createArrayElementAccess();
      case AstPackage.ARRAY_SUBSCRIPT: return createArraySubscript();
      case AstPackage.OPERATION_CALL: return createOperationCall();
      case AstPackage.ITERATION_CALL: return createIterationCall();
      case AstPackage.ITERATION_VARIABLE: return createIterationVariable();
      case AstPackage.ITERATION_ACCUMULATOR: return createIterationAccumulator();
      case AstPackage.ARRAY_CONSTRUCTION_OPERATOR: return createArrayConstructionOperator();
      case AstPackage.ARRAY_CONSTRUCTION_ITERATION_CLAUSE: return createArrayConstructionIterationClause();
      case AstPackage.ARRAY_CONCATENATION_OPERATOR: return createArrayConcatenationOperator();
      case AstPackage.EXPRESSION_LIST: return createExpressionList();
      case AstPackage.UNIT_CONSTRUCTION_OPERATOR: return createUnitConstructionOperator();
      case AstPackage.PARENTHESIZED_EXPRESSION: return createParenthesizedExpression();
      case AstPackage.BEGIN_EXPRESSION: return createBeginExpression();
      case AstPackage.END_EXPRESSION: return createEndExpression();
      case AstPackage.QUALIFIED_NAME: return createQualifiedName();
      case AstPackage.UNIT_EXPRESSION: return createUnitExpression();
      case AstPackage.UNIT_EXPRESSION_NUMERATOR: return createUnitExpressionNumerator();
      case AstPackage.UNIT_EXPRESSION_DENOMINATOR: return createUnitExpressionDenominator();
      case AstPackage.UNIT_EXPRESSION_FACTOR: return createUnitExpressionFactor();
      case AstPackage.UNIT_EXPRESSION_EXPONENT: return createUnitExpressionExponent();
      case AstPackage.RANGE_EXPRESSION: return createRangeExpression();
      case AstPackage.IMPLIES_EXPRESSION: return createImpliesExpression();
      case AstPackage.LOGICAL_OR_EXPRESSION: return createLogicalOrExpression();
      case AstPackage.LOGICAL_AND_EXPRESSION: return createLogicalAndExpression();
      case AstPackage.EQUALITY_EXPRESSION: return createEqualityExpression();
      case AstPackage.RELATIONAL_EXPRESSION: return createRelationalExpression();
      case AstPackage.ADDITIVE_EXPRESSION: return createAdditiveExpression();
      case AstPackage.MULTIPLICATIVE_EXPRESSION: return createMultiplicativeExpression();
      case AstPackage.POWER_EXPRESSION: return createPowerExpression();
      case AstPackage.UNARY_EXPRESSION: return createUnaryExpression();
      case AstPackage.POSTFIX_EXPRESSION: return createPostfixExpression();
      case AstPackage.SIMPLE_NAME: return createSimpleName();
      case AstPackage.FEATURE_CALL: return createFeatureCall();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case AstPackage.ASSERTION_STATUS_KIND:
        return createAssertionStatusKindFromString(eDataType, initialValue);
      case AstPackage.EQUALITY_OPERATOR:
        return createEqualityOperatorFromString(eDataType, initialValue);
      case AstPackage.RELATIONAL_OPERATOR:
        return createRelationalOperatorFromString(eDataType, initialValue);
      case AstPackage.ADDITIVE_OPERATOR:
        return createAdditiveOperatorFromString(eDataType, initialValue);
      case AstPackage.MULTIPLICATIVE_OPERATOR:
        return createMultiplicativeOperatorFromString(eDataType, initialValue);
      case AstPackage.POWER_OPERATOR:
        return createPowerOperatorFromString(eDataType, initialValue);
      case AstPackage.UNARY_OPERATOR:
        return createUnaryOperatorFromString(eDataType, initialValue);
      case AstPackage.POSTFIX_OPERATOR:
        return createPostfixOperatorFromString(eDataType, initialValue);
      case AstPackage.BOOLEAN_KIND:
        return createBooleanKindFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case AstPackage.ASSERTION_STATUS_KIND:
        return convertAssertionStatusKindToString(eDataType, instanceValue);
      case AstPackage.EQUALITY_OPERATOR:
        return convertEqualityOperatorToString(eDataType, instanceValue);
      case AstPackage.RELATIONAL_OPERATOR:
        return convertRelationalOperatorToString(eDataType, instanceValue);
      case AstPackage.ADDITIVE_OPERATOR:
        return convertAdditiveOperatorToString(eDataType, instanceValue);
      case AstPackage.MULTIPLICATIVE_OPERATOR:
        return convertMultiplicativeOperatorToString(eDataType, instanceValue);
      case AstPackage.POWER_OPERATOR:
        return convertPowerOperatorToString(eDataType, instanceValue);
      case AstPackage.UNARY_OPERATOR:
        return convertUnaryOperatorToString(eDataType, instanceValue);
      case AstPackage.POSTFIX_OPERATOR:
        return convertPostfixOperatorToString(eDataType, instanceValue);
      case AstPackage.BOOLEAN_KIND:
        return convertBooleanKindToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Mscript createMscript()
  {
    MscriptImpl mscript = new MscriptImpl();
    return mscript;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamespaceDefinition createNamespaceDefinition()
  {
    NamespaceDefinitionImpl namespaceDefinition = new NamespaceDefinitionImpl();
    return namespaceDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamespaceMember createNamespaceMember()
  {
    NamespaceMemberImpl namespaceMember = new NamespaceMemberImpl();
    return namespaceMember;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeDefinition createTypeDefinition()
  {
    TypeDefinitionImpl typeDefinition = new TypeDefinitionImpl();
    return typeDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataTypeDefinition createDataTypeDefinition()
  {
    DataTypeDefinitionImpl dataTypeDefinition = new DataTypeDefinitionImpl();
    return dataTypeDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumerationDefinition createEnumerationDefinition()
  {
    EnumerationDefinitionImpl enumerationDefinition = new EnumerationDefinitionImpl();
    return enumerationDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumerationLiteralDeclaration createEnumerationLiteralDeclaration()
  {
    EnumerationLiteralDeclarationImpl enumerationLiteralDeclaration = new EnumerationLiteralDeclarationImpl();
    return enumerationLiteralDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeAliasDefinition createTypeAliasDefinition()
  {
    TypeAliasDefinitionImpl typeAliasDefinition = new TypeAliasDefinitionImpl();
    return typeAliasDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecordDefinition createRecordDefinition()
  {
    RecordDefinitionImpl recordDefinition = new RecordDefinitionImpl();
    return recordDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecordFieldDeclaration createRecordFieldDeclaration()
  {
    RecordFieldDeclarationImpl recordFieldDeclaration = new RecordFieldDeclarationImpl();
    return recordFieldDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionDefinition createFunctionDefinition()
  {
    FunctionDefinitionImpl functionDefinition = new FunctionDefinitionImpl();
    return functionDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParameterDeclaration createParameterDeclaration()
  {
    ParameterDeclarationImpl parameterDeclaration = new ParameterDeclarationImpl();
    return parameterDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssertionDeclaration createAssertionDeclaration()
  {
    AssertionDeclarationImpl assertionDeclaration = new AssertionDeclarationImpl();
    return assertionDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StateVariableDeclaration createStateVariableDeclaration()
  {
    StateVariableDeclarationImpl stateVariableDeclaration = new StateVariableDeclarationImpl();
    return stateVariableDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctorDeclaration createFunctorDeclaration()
  {
    FunctorDeclarationImpl functorDeclaration = new FunctorDeclarationImpl();
    return functorDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArgumentDeclaration createArgumentDeclaration()
  {
    ArgumentDeclarationImpl argumentDeclaration = new ArgumentDeclarationImpl();
    return argumentDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EquationDefinition createEquationDefinition()
  {
    EquationDefinitionImpl equationDefinition = new EquationDefinitionImpl();
    return equationDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DataTypeSpecifier createDataTypeSpecifier()
  {
    DataTypeSpecifierImpl dataTypeSpecifier = new DataTypeSpecifierImpl();
    return dataTypeSpecifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimitiveTypeSpecifier createPrimitiveTypeSpecifier()
  {
    PrimitiveTypeSpecifierImpl primitiveTypeSpecifier = new PrimitiveTypeSpecifierImpl();
    return primitiveTypeSpecifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NumericTypeSpecifier createNumericTypeSpecifier()
  {
    NumericTypeSpecifierImpl numericTypeSpecifier = new NumericTypeSpecifierImpl();
    return numericTypeSpecifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RealTypeSpecifier createRealTypeSpecifier()
  {
    RealTypeSpecifierImpl realTypeSpecifier = new RealTypeSpecifierImpl();
    return realTypeSpecifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntegerTypeSpecifier createIntegerTypeSpecifier()
  {
    IntegerTypeSpecifierImpl integerTypeSpecifier = new IntegerTypeSpecifierImpl();
    return integerTypeSpecifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComplexTypeSpecifier createComplexTypeSpecifier()
  {
    ComplexTypeSpecifierImpl complexTypeSpecifier = new ComplexTypeSpecifierImpl();
    return complexTypeSpecifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GaussianTypeSpecifier createGaussianTypeSpecifier()
  {
    GaussianTypeSpecifierImpl gaussianTypeSpecifier = new GaussianTypeSpecifierImpl();
    return gaussianTypeSpecifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanTypeSpecifier createBooleanTypeSpecifier()
  {
    BooleanTypeSpecifierImpl booleanTypeSpecifier = new BooleanTypeSpecifierImpl();
    return booleanTypeSpecifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringTypeSpecifier createStringTypeSpecifier()
  {
    StringTypeSpecifierImpl stringTypeSpecifier = new StringTypeSpecifierImpl();
    return stringTypeSpecifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedTypeSpecifier createNamedTypeSpecifier()
  {
    NamedTypeSpecifierImpl namedTypeSpecifier = new NamedTypeSpecifierImpl();
    return namedTypeSpecifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArrayDimensionSpecification createArrayDimensionSpecification()
  {
    ArrayDimensionSpecificationImpl arrayDimensionSpecification = new ArrayDimensionSpecificationImpl();
    return arrayDimensionSpecification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LetExpression createLetExpression()
  {
    LetExpressionImpl letExpression = new LetExpressionImpl();
    return letExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LetExpressionVariable createLetExpressionVariable()
  {
    LetExpressionVariableImpl letExpressionVariable = new LetExpressionVariableImpl();
    return letExpressionVariable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfExpression createIfExpression()
  {
    IfExpressionImpl ifExpression = new IfExpressionImpl();
    return ifExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SwitchExpression createSwitchExpression()
  {
    SwitchExpressionImpl switchExpression = new SwitchExpressionImpl();
    return switchExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SwitchCase createSwitchCase()
  {
    SwitchCaseImpl switchCase = new SwitchCaseImpl();
    return switchCase;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AdditiveExpressionPart createAdditiveExpressionPart()
  {
    AdditiveExpressionPartImpl additiveExpressionPart = new AdditiveExpressionPartImpl();
    return additiveExpressionPart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicativeExpressionPart createMultiplicativeExpressionPart()
  {
    MultiplicativeExpressionPartImpl multiplicativeExpressionPart = new MultiplicativeExpressionPartImpl();
    return multiplicativeExpressionPart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Literal createLiteral()
  {
    LiteralImpl literal = new LiteralImpl();
    return literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NumericLiteral createNumericLiteral()
  {
    NumericLiteralImpl numericLiteral = new NumericLiteralImpl();
    return numericLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RealLiteral createRealLiteral()
  {
    RealLiteralImpl realLiteral = new RealLiteralImpl();
    return realLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntegerLiteral createIntegerLiteral()
  {
    IntegerLiteralImpl integerLiteral = new IntegerLiteralImpl();
    return integerLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanLiteral createBooleanLiteral()
  {
    BooleanLiteralImpl booleanLiteral = new BooleanLiteralImpl();
    return booleanLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringLiteral createStringLiteral()
  {
    StringLiteralImpl stringLiteral = new StringLiteralImpl();
    return stringLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FeatureCallPart createFeatureCallPart()
  {
    FeatureCallPartImpl featureCallPart = new FeatureCallPartImpl();
    return featureCallPart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FeatureAccess createFeatureAccess()
  {
    FeatureAccessImpl featureAccess = new FeatureAccessImpl();
    return featureAccess;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArrayElementAccess createArrayElementAccess()
  {
    ArrayElementAccessImpl arrayElementAccess = new ArrayElementAccessImpl();
    return arrayElementAccess;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArraySubscript createArraySubscript()
  {
    ArraySubscriptImpl arraySubscript = new ArraySubscriptImpl();
    return arraySubscript;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OperationCall createOperationCall()
  {
    OperationCallImpl operationCall = new OperationCallImpl();
    return operationCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IterationCall createIterationCall()
  {
    IterationCallImpl iterationCall = new IterationCallImpl();
    return iterationCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IterationVariable createIterationVariable()
  {
    IterationVariableImpl iterationVariable = new IterationVariableImpl();
    return iterationVariable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IterationAccumulator createIterationAccumulator()
  {
    IterationAccumulatorImpl iterationAccumulator = new IterationAccumulatorImpl();
    return iterationAccumulator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArrayConstructionOperator createArrayConstructionOperator()
  {
    ArrayConstructionOperatorImpl arrayConstructionOperator = new ArrayConstructionOperatorImpl();
    return arrayConstructionOperator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArrayConstructionIterationClause createArrayConstructionIterationClause()
  {
    ArrayConstructionIterationClauseImpl arrayConstructionIterationClause = new ArrayConstructionIterationClauseImpl();
    return arrayConstructionIterationClause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArrayConcatenationOperator createArrayConcatenationOperator()
  {
    ArrayConcatenationOperatorImpl arrayConcatenationOperator = new ArrayConcatenationOperatorImpl();
    return arrayConcatenationOperator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionList createExpressionList()
  {
    ExpressionListImpl expressionList = new ExpressionListImpl();
    return expressionList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnitConstructionOperator createUnitConstructionOperator()
  {
    UnitConstructionOperatorImpl unitConstructionOperator = new UnitConstructionOperatorImpl();
    return unitConstructionOperator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParenthesizedExpression createParenthesizedExpression()
  {
    ParenthesizedExpressionImpl parenthesizedExpression = new ParenthesizedExpressionImpl();
    return parenthesizedExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BeginExpression createBeginExpression()
  {
    BeginExpressionImpl beginExpression = new BeginExpressionImpl();
    return beginExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EndExpression createEndExpression()
  {
    EndExpressionImpl endExpression = new EndExpressionImpl();
    return endExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QualifiedName createQualifiedName()
  {
    QualifiedNameImpl qualifiedName = new QualifiedNameImpl();
    return qualifiedName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnitExpression createUnitExpression()
  {
    UnitExpressionImpl unitExpression = new UnitExpressionImpl();
    return unitExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnitExpressionNumerator createUnitExpressionNumerator()
  {
    UnitExpressionNumeratorImpl unitExpressionNumerator = new UnitExpressionNumeratorImpl();
    return unitExpressionNumerator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnitExpressionDenominator createUnitExpressionDenominator()
  {
    UnitExpressionDenominatorImpl unitExpressionDenominator = new UnitExpressionDenominatorImpl();
    return unitExpressionDenominator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnitExpressionFactor createUnitExpressionFactor()
  {
    UnitExpressionFactorImpl unitExpressionFactor = new UnitExpressionFactorImpl();
    return unitExpressionFactor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnitExpressionExponent createUnitExpressionExponent()
  {
    UnitExpressionExponentImpl unitExpressionExponent = new UnitExpressionExponentImpl();
    return unitExpressionExponent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RangeExpression createRangeExpression()
  {
    RangeExpressionImpl rangeExpression = new RangeExpressionImpl();
    return rangeExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImpliesExpression createImpliesExpression()
  {
    ImpliesExpressionImpl impliesExpression = new ImpliesExpressionImpl();
    return impliesExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LogicalOrExpression createLogicalOrExpression()
  {
    LogicalOrExpressionImpl logicalOrExpression = new LogicalOrExpressionImpl();
    return logicalOrExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LogicalAndExpression createLogicalAndExpression()
  {
    LogicalAndExpressionImpl logicalAndExpression = new LogicalAndExpressionImpl();
    return logicalAndExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EqualityExpression createEqualityExpression()
  {
    EqualityExpressionImpl equalityExpression = new EqualityExpressionImpl();
    return equalityExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RelationalExpression createRelationalExpression()
  {
    RelationalExpressionImpl relationalExpression = new RelationalExpressionImpl();
    return relationalExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AdditiveExpression createAdditiveExpression()
  {
    AdditiveExpressionImpl additiveExpression = new AdditiveExpressionImpl();
    return additiveExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicativeExpression createMultiplicativeExpression()
  {
    MultiplicativeExpressionImpl multiplicativeExpression = new MultiplicativeExpressionImpl();
    return multiplicativeExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PowerExpression createPowerExpression()
  {
    PowerExpressionImpl powerExpression = new PowerExpressionImpl();
    return powerExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryExpression createUnaryExpression()
  {
    UnaryExpressionImpl unaryExpression = new UnaryExpressionImpl();
    return unaryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PostfixExpression createPostfixExpression()
  {
    PostfixExpressionImpl postfixExpression = new PostfixExpressionImpl();
    return postfixExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleName createSimpleName()
  {
    SimpleNameImpl simpleName = new SimpleNameImpl();
    return simpleName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FeatureCall createFeatureCall()
  {
    FeatureCallImpl featureCall = new FeatureCallImpl();
    return featureCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssertionStatusKind createAssertionStatusKindFromString(EDataType eDataType, String initialValue)
  {
    AssertionStatusKind result = AssertionStatusKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertAssertionStatusKindToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EqualityOperator createEqualityOperatorFromString(EDataType eDataType, String initialValue)
  {
    EqualityOperator result = EqualityOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertEqualityOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RelationalOperator createRelationalOperatorFromString(EDataType eDataType, String initialValue)
  {
    RelationalOperator result = RelationalOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertRelationalOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AdditiveOperator createAdditiveOperatorFromString(EDataType eDataType, String initialValue)
  {
    AdditiveOperator result = AdditiveOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertAdditiveOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicativeOperator createMultiplicativeOperatorFromString(EDataType eDataType, String initialValue)
  {
    MultiplicativeOperator result = MultiplicativeOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertMultiplicativeOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PowerOperator createPowerOperatorFromString(EDataType eDataType, String initialValue)
  {
    PowerOperator result = PowerOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertPowerOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryOperator createUnaryOperatorFromString(EDataType eDataType, String initialValue)
  {
    UnaryOperator result = UnaryOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertUnaryOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PostfixOperator createPostfixOperatorFromString(EDataType eDataType, String initialValue)
  {
    PostfixOperator result = PostfixOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertPostfixOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanKind createBooleanKindFromString(EDataType eDataType, String initialValue)
  {
    BooleanKind result = BooleanKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertBooleanKindToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AstPackage getAstPackage()
  {
    return (AstPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static AstPackage getPackage()
  {
    return AstPackage.eINSTANCE;
  }

} //AstFactoryImpl
