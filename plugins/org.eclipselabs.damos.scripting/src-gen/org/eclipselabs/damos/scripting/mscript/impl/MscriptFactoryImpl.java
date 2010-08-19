/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.damos.scripting.mscript.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipselabs.damos.scripting.mscript.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MscriptFactoryImpl extends EFactoryImpl implements MscriptFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static MscriptFactory init()
  {
    try
    {
      MscriptFactory theMscriptFactory = (MscriptFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipselabs.org/damos/Mscript/1.0.0"); 
      if (theMscriptFactory != null)
      {
        return theMscriptFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new MscriptFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MscriptFactoryImpl()
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
      case MscriptPackage.MSCRIPT: return createMscript();
      case MscriptPackage.PACKAGE_DEFINITION: return createPackageDefinition();
      case MscriptPackage.PACKAGE_DEFINITION_ELEMENT: return createPackageDefinitionElement();
      case MscriptPackage.ENUMERATION_DEFINITION: return createEnumerationDefinition();
      case MscriptPackage.ENUMERATION_LITERAL_DEFINITION: return createEnumerationLiteralDefinition();
      case MscriptPackage.DATA_TYPE_SPECIFIER: return createDataTypeSpecifier();
      case MscriptPackage.PRIMITIVE_TYPE_SPECIFIER: return createPrimitiveTypeSpecifier();
      case MscriptPackage.NUMERICAL_TYPE_SPECIFIER: return createNumericalTypeSpecifier();
      case MscriptPackage.REAL_TYPE_SPECIFIER: return createRealTypeSpecifier();
      case MscriptPackage.INTEGER_TYPE_SPECIFIER: return createIntegerTypeSpecifier();
      case MscriptPackage.BOOLEAN_TYPE_SPECIFIER: return createBooleanTypeSpecifier();
      case MscriptPackage.STRING_TYPE_SPECIFIER: return createStringTypeSpecifier();
      case MscriptPackage.COMPLEX_TYPE_SPECIFIER: return createComplexTypeSpecifier();
      case MscriptPackage.EXPRESSION: return createExpression();
      case MscriptPackage.CONDITIONAL_EXPRESSION: return createConditionalExpression();
      case MscriptPackage.CONDITIONAL_EXPRESSION_CASE: return createConditionalExpressionCase();
      case MscriptPackage.LITERAL: return createLiteral();
      case MscriptPackage.NUMERICAL_LITERAL: return createNumericalLiteral();
      case MscriptPackage.REAL_LITERAL: return createRealLiteral();
      case MscriptPackage.INTEGER_LITERAL: return createIntegerLiteral();
      case MscriptPackage.BOOLEAN_LITERAL: return createBooleanLiteral();
      case MscriptPackage.STRING_LITERAL: return createStringLiteral();
      case MscriptPackage.FUNCTION_CALL: return createFunctionCall();
      case MscriptPackage.NAMED_FUNCTION_CALL: return createNamedFunctionCall();
      case MscriptPackage.NAME: return createName();
      case MscriptPackage.KEYWORD_FUNCTION_CALL: return createKeywordFunctionCall();
      case MscriptPackage.FUNCTION_ARGUMENT_LIST: return createFunctionArgumentList();
      case MscriptPackage.NAMED_ARGUMENT: return createNamedArgument();
      case MscriptPackage.COMPONENT_REFERENCE: return createComponentReference();
      case MscriptPackage.COMPONENT_REFERENCE_SEGMENT: return createComponentReferenceSegment();
      case MscriptPackage.ARRAY_SUBSCRIPT_LIST: return createArraySubscriptList();
      case MscriptPackage.SUBSCRIPT: return createSubscript();
      case MscriptPackage.COLON_SUBSCRIPT: return createColonSubscript();
      case MscriptPackage.EXPRESSION_SUBSCRIPT: return createExpressionSubscript();
      case MscriptPackage.ARRAY_CONCATENATION_OPERATOR: return createArrayConcatenationOperator();
      case MscriptPackage.ARRAY_CONSTRUCTION_OPERATOR: return createArrayConstructionOperator();
      case MscriptPackage.EXPRESSION_LIST: return createExpressionList();
      case MscriptPackage.PARENTHESIZED_EXPRESSION: return createParenthesizedExpression();
      case MscriptPackage.BEGIN_EXPRESSION: return createBeginExpression();
      case MscriptPackage.END_EXPRESSION: return createEndExpression();
      case MscriptPackage.UNIT_EXPRESSION: return createUnitExpression();
      case MscriptPackage.UNIT_EXPRESSION_NUMERATOR: return createUnitExpressionNumerator();
      case MscriptPackage.UNIT_EXPRESSION_DENOMINATOR: return createUnitExpressionDenominator();
      case MscriptPackage.UNIT_EXPRESSION_FACTOR: return createUnitExpressionFactor();
      case MscriptPackage.UNIT_EXPRESSION_EXPONENT: return createUnitExpressionExponent();
      case MscriptPackage.RANGE_EXPRESSION: return createRangeExpression();
      case MscriptPackage.LOGICAL_OR_EXPRESSION: return createLogicalOrExpression();
      case MscriptPackage.LOGICAL_AND_EXPRESSION: return createLogicalAndExpression();
      case MscriptPackage.LOGICAL_NOT_EXPRESSION: return createLogicalNotExpression();
      case MscriptPackage.RELATIONAL_EXPRESSION: return createRelationalExpression();
      case MscriptPackage.ADD_SUBTRACT_EXPRESSION: return createAddSubtractExpression();
      case MscriptPackage.MULTIPLY_DIVIDE_EXPRESSION: return createMultiplyDivideExpression();
      case MscriptPackage.POWER_EXPRESSION: return createPowerExpression();
      case MscriptPackage.UNARY_MINUS_EXPRESSION: return createUnaryMinusExpression();
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
      case MscriptPackage.RELATIONAL_OPERATOR:
        return createRelationalOperatorFromString(eDataType, initialValue);
      case MscriptPackage.ADD_SUBTRACT_OPERATOR:
        return createAddSubtractOperatorFromString(eDataType, initialValue);
      case MscriptPackage.MULTIPLY_DIVIDE_OPERATOR:
        return createMultiplyDivideOperatorFromString(eDataType, initialValue);
      case MscriptPackage.POWER_OPERATOR:
        return createPowerOperatorFromString(eDataType, initialValue);
      case MscriptPackage.BOOLEAN_KIND:
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
      case MscriptPackage.RELATIONAL_OPERATOR:
        return convertRelationalOperatorToString(eDataType, instanceValue);
      case MscriptPackage.ADD_SUBTRACT_OPERATOR:
        return convertAddSubtractOperatorToString(eDataType, instanceValue);
      case MscriptPackage.MULTIPLY_DIVIDE_OPERATOR:
        return convertMultiplyDivideOperatorToString(eDataType, instanceValue);
      case MscriptPackage.POWER_OPERATOR:
        return convertPowerOperatorToString(eDataType, instanceValue);
      case MscriptPackage.BOOLEAN_KIND:
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
  public PackageDefinition createPackageDefinition()
  {
    PackageDefinitionImpl packageDefinition = new PackageDefinitionImpl();
    return packageDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PackageDefinitionElement createPackageDefinitionElement()
  {
    PackageDefinitionElementImpl packageDefinitionElement = new PackageDefinitionElementImpl();
    return packageDefinitionElement;
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
  public EnumerationLiteralDefinition createEnumerationLiteralDefinition()
  {
    EnumerationLiteralDefinitionImpl enumerationLiteralDefinition = new EnumerationLiteralDefinitionImpl();
    return enumerationLiteralDefinition;
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
  public NumericalTypeSpecifier createNumericalTypeSpecifier()
  {
    NumericalTypeSpecifierImpl numericalTypeSpecifier = new NumericalTypeSpecifierImpl();
    return numericalTypeSpecifier;
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
  public ConditionalExpression createConditionalExpression()
  {
    ConditionalExpressionImpl conditionalExpression = new ConditionalExpressionImpl();
    return conditionalExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionalExpressionCase createConditionalExpressionCase()
  {
    ConditionalExpressionCaseImpl conditionalExpressionCase = new ConditionalExpressionCaseImpl();
    return conditionalExpressionCase;
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
  public NumericalLiteral createNumericalLiteral()
  {
    NumericalLiteralImpl numericalLiteral = new NumericalLiteralImpl();
    return numericalLiteral;
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
  public FunctionCall createFunctionCall()
  {
    FunctionCallImpl functionCall = new FunctionCallImpl();
    return functionCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedFunctionCall createNamedFunctionCall()
  {
    NamedFunctionCallImpl namedFunctionCall = new NamedFunctionCallImpl();
    return namedFunctionCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Name createName()
  {
    NameImpl name = new NameImpl();
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public KeywordFunctionCall createKeywordFunctionCall()
  {
    KeywordFunctionCallImpl keywordFunctionCall = new KeywordFunctionCallImpl();
    return keywordFunctionCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionArgumentList createFunctionArgumentList()
  {
    FunctionArgumentListImpl functionArgumentList = new FunctionArgumentListImpl();
    return functionArgumentList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedArgument createNamedArgument()
  {
    NamedArgumentImpl namedArgument = new NamedArgumentImpl();
    return namedArgument;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentReference createComponentReference()
  {
    ComponentReferenceImpl componentReference = new ComponentReferenceImpl();
    return componentReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComponentReferenceSegment createComponentReferenceSegment()
  {
    ComponentReferenceSegmentImpl componentReferenceSegment = new ComponentReferenceSegmentImpl();
    return componentReferenceSegment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArraySubscriptList createArraySubscriptList()
  {
    ArraySubscriptListImpl arraySubscriptList = new ArraySubscriptListImpl();
    return arraySubscriptList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Subscript createSubscript()
  {
    SubscriptImpl subscript = new SubscriptImpl();
    return subscript;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ColonSubscript createColonSubscript()
  {
    ColonSubscriptImpl colonSubscript = new ColonSubscriptImpl();
    return colonSubscript;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionSubscript createExpressionSubscript()
  {
    ExpressionSubscriptImpl expressionSubscript = new ExpressionSubscriptImpl();
    return expressionSubscript;
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
  public LogicalNotExpression createLogicalNotExpression()
  {
    LogicalNotExpressionImpl logicalNotExpression = new LogicalNotExpressionImpl();
    return logicalNotExpression;
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
  public AddSubtractExpression createAddSubtractExpression()
  {
    AddSubtractExpressionImpl addSubtractExpression = new AddSubtractExpressionImpl();
    return addSubtractExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplyDivideExpression createMultiplyDivideExpression()
  {
    MultiplyDivideExpressionImpl multiplyDivideExpression = new MultiplyDivideExpressionImpl();
    return multiplyDivideExpression;
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
  public UnaryMinusExpression createUnaryMinusExpression()
  {
    UnaryMinusExpressionImpl unaryMinusExpression = new UnaryMinusExpressionImpl();
    return unaryMinusExpression;
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
  public AddSubtractOperator createAddSubtractOperatorFromString(EDataType eDataType, String initialValue)
  {
    AddSubtractOperator result = AddSubtractOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertAddSubtractOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplyDivideOperator createMultiplyDivideOperatorFromString(EDataType eDataType, String initialValue)
  {
    MultiplyDivideOperator result = MultiplyDivideOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertMultiplyDivideOperatorToString(EDataType eDataType, Object instanceValue)
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
  public MscriptPackage getMscriptPackage()
  {
    return (MscriptPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static MscriptPackage getPackage()
  {
    return MscriptPackage.eINSTANCE;
  }

} //MscriptFactoryImpl
