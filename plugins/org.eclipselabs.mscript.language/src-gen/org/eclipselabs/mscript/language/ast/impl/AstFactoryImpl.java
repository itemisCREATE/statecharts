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
      case AstPackage.PACKAGE_DEFINITION: return createPackageDefinition();
      case AstPackage.PACKAGE_DEFINITION_ELEMENT: return createPackageDefinitionElement();
      case AstPackage.ENUMERATION_DEFINITION: return createEnumerationDefinition();
      case AstPackage.ENUMERATION_LITERAL_DECLARATION: return createEnumerationLiteralDeclaration();
      case AstPackage.FUNCTION_DEFINITION: return createFunctionDefinition();
      case AstPackage.PARAMETER_DECLARATION: return createParameterDeclaration();
      case AstPackage.STATEMENT: return createStatement();
      case AstPackage.BLOCK: return createBlock();
      case AstPackage.FEATURE_CALL_STATEMENT: return createFeatureCallStatement();
      case AstPackage.IF_STATEMENT: return createIfStatement();
      case AstPackage.IF_CASE: return createIfCase();
      case AstPackage.WHILE_STATEMENT: return createWhileStatement();
      case AstPackage.DO_WHILE_STATEMENT: return createDoWhileStatement();
      case AstPackage.FOREACH_STATEMENT: return createForeachStatement();
      case AstPackage.VARIABLE_DECLARATION: return createVariableDeclaration();
      case AstPackage.VARIABLE_DECLARATION_ITEM: return createVariableDeclarationItem();
      case AstPackage.DATA_TYPE_SPECIFIER: return createDataTypeSpecifier();
      case AstPackage.PRIMITIVE_TYPE_SPECIFIER: return createPrimitiveTypeSpecifier();
      case AstPackage.NUMERICAL_TYPE_SPECIFIER: return createNumericalTypeSpecifier();
      case AstPackage.REAL_TYPE_SPECIFIER: return createRealTypeSpecifier();
      case AstPackage.INTEGER_TYPE_SPECIFIER: return createIntegerTypeSpecifier();
      case AstPackage.COMPLEX_TYPE_SPECIFIER: return createComplexTypeSpecifier();
      case AstPackage.GAUSSIAN_TYPE_SPECIFIER: return createGaussianTypeSpecifier();
      case AstPackage.BOOLEAN_TYPE_SPECIFIER: return createBooleanTypeSpecifier();
      case AstPackage.STRING_TYPE_SPECIFIER: return createStringTypeSpecifier();
      case AstPackage.NAMED_TYPE_SPECIFIER: return createNamedTypeSpecifier();
      case AstPackage.EXPRESSION: return createExpression();
      case AstPackage.CONDITIONAL_EXPRESSION: return createConditionalExpression();
      case AstPackage.CONDITIONAL_EXPRESSION_CASE: return createConditionalExpressionCase();
      case AstPackage.LITERAL: return createLiteral();
      case AstPackage.NUMERICAL_LITERAL: return createNumericalLiteral();
      case AstPackage.REAL_LITERAL: return createRealLiteral();
      case AstPackage.INTEGER_LITERAL: return createIntegerLiteral();
      case AstPackage.BOOLEAN_LITERAL: return createBooleanLiteral();
      case AstPackage.STRING_LITERAL: return createStringLiteral();
      case AstPackage.QUALIFIED_NAME: return createQualifiedName();
      case AstPackage.FEATURE_CALL: return createFeatureCall();
      case AstPackage.COMPONENT_REFERENCE: return createComponentReference();
      case AstPackage.ARRAY_REFERENCE: return createArrayReference();
      case AstPackage.MEMBER_REFERENCE: return createMemberReference();
      case AstPackage.SUBSCRIPT: return createSubscript();
      case AstPackage.COLON_SUBSCRIPT: return createColonSubscript();
      case AstPackage.EXPRESSION_SUBSCRIPT: return createExpressionSubscript();
      case AstPackage.MATRIX_CONSTRUCTION_OPERATOR: return createMatrixConstructionOperator();
      case AstPackage.EXPRESSION_LIST: return createExpressionList();
      case AstPackage.PARENTHESIZED_EXPRESSION: return createParenthesizedExpression();
      case AstPackage.BEGIN_EXPRESSION: return createBeginExpression();
      case AstPackage.END_EXPRESSION: return createEndExpression();
      case AstPackage.UNIT_EXPRESSION: return createUnitExpression();
      case AstPackage.UNIT_EXPRESSION_NUMERATOR: return createUnitExpressionNumerator();
      case AstPackage.UNIT_EXPRESSION_DENOMINATOR: return createUnitExpressionDenominator();
      case AstPackage.UNIT_EXPRESSION_FACTOR: return createUnitExpressionFactor();
      case AstPackage.UNIT_EXPRESSION_EXPONENT: return createUnitExpressionExponent();
      case AstPackage.RANGE_EXPRESSION: return createRangeExpression();
      case AstPackage.LOGICAL_OR_EXPRESSION: return createLogicalOrExpression();
      case AstPackage.LOGICAL_AND_EXPRESSION: return createLogicalAndExpression();
      case AstPackage.LOGICAL_NOT_EXPRESSION: return createLogicalNotExpression();
      case AstPackage.RELATIONAL_EXPRESSION: return createRelationalExpression();
      case AstPackage.ADD_SUBTRACT_EXPRESSION: return createAddSubtractExpression();
      case AstPackage.MULTIPLY_DIVIDE_EXPRESSION: return createMultiplyDivideExpression();
      case AstPackage.POWER_EXPRESSION: return createPowerExpression();
      case AstPackage.UNARY_MINUS_EXPRESSION: return createUnaryMinusExpression();
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
      case AstPackage.RELATIONAL_OPERATOR:
        return createRelationalOperatorFromString(eDataType, initialValue);
      case AstPackage.ADD_SUBTRACT_OPERATOR:
        return createAddSubtractOperatorFromString(eDataType, initialValue);
      case AstPackage.MULTIPLY_DIVIDE_OPERATOR:
        return createMultiplyDivideOperatorFromString(eDataType, initialValue);
      case AstPackage.POWER_OPERATOR:
        return createPowerOperatorFromString(eDataType, initialValue);
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
      case AstPackage.RELATIONAL_OPERATOR:
        return convertRelationalOperatorToString(eDataType, instanceValue);
      case AstPackage.ADD_SUBTRACT_OPERATOR:
        return convertAddSubtractOperatorToString(eDataType, instanceValue);
      case AstPackage.MULTIPLY_DIVIDE_OPERATOR:
        return convertMultiplyDivideOperatorToString(eDataType, instanceValue);
      case AstPackage.POWER_OPERATOR:
        return convertPowerOperatorToString(eDataType, instanceValue);
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
  public Statement createStatement()
  {
    StatementImpl statement = new StatementImpl();
    return statement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Block createBlock()
  {
    BlockImpl block = new BlockImpl();
    return block;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FeatureCallStatement createFeatureCallStatement()
  {
    FeatureCallStatementImpl featureCallStatement = new FeatureCallStatementImpl();
    return featureCallStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfStatement createIfStatement()
  {
    IfStatementImpl ifStatement = new IfStatementImpl();
    return ifStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfCase createIfCase()
  {
    IfCaseImpl ifCase = new IfCaseImpl();
    return ifCase;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WhileStatement createWhileStatement()
  {
    WhileStatementImpl whileStatement = new WhileStatementImpl();
    return whileStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DoWhileStatement createDoWhileStatement()
  {
    DoWhileStatementImpl doWhileStatement = new DoWhileStatementImpl();
    return doWhileStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ForeachStatement createForeachStatement()
  {
    ForeachStatementImpl foreachStatement = new ForeachStatementImpl();
    return foreachStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariableDeclaration createVariableDeclaration()
  {
    VariableDeclarationImpl variableDeclaration = new VariableDeclarationImpl();
    return variableDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariableDeclarationItem createVariableDeclarationItem()
  {
    VariableDeclarationItemImpl variableDeclarationItem = new VariableDeclarationItemImpl();
    return variableDeclarationItem;
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
  public ArrayReference createArrayReference()
  {
    ArrayReferenceImpl arrayReference = new ArrayReferenceImpl();
    return arrayReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MemberReference createMemberReference()
  {
    MemberReferenceImpl memberReference = new MemberReferenceImpl();
    return memberReference;
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
  public MatrixConstructionOperator createMatrixConstructionOperator()
  {
    MatrixConstructionOperatorImpl matrixConstructionOperator = new MatrixConstructionOperatorImpl();
    return matrixConstructionOperator;
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
