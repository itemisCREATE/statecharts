/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipselabs.mscript.language.ast.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.mscript.language.ast.AstPackage
 * @generated
 */
public class AstSwitch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static AstPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AstSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = AstPackage.eINSTANCE;
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  public T doSwitch(EObject theEObject)
  {
    return doSwitch(theEObject.eClass(), theEObject);
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T doSwitch(EClass theEClass, EObject theEObject)
  {
    if (theEClass.eContainer() == modelPackage)
    {
      return doSwitch(theEClass.getClassifierID(), theEObject);
    }
    else
    {
      List<EClass> eSuperTypes = theEClass.getESuperTypes();
      return
        eSuperTypes.isEmpty() ?
          defaultCase(theEObject) :
          doSwitch(eSuperTypes.get(0), theEObject);
    }
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case AstPackage.MSCRIPT:
      {
        Mscript mscript = (Mscript)theEObject;
        T result = caseMscript(mscript);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.PACKAGE_DEFINITION:
      {
        PackageDefinition packageDefinition = (PackageDefinition)theEObject;
        T result = casePackageDefinition(packageDefinition);
        if (result == null) result = casePackageDefinitionElement(packageDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.PACKAGE_DEFINITION_ELEMENT:
      {
        PackageDefinitionElement packageDefinitionElement = (PackageDefinitionElement)theEObject;
        T result = casePackageDefinitionElement(packageDefinitionElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.ENUMERATION_DEFINITION:
      {
        EnumerationDefinition enumerationDefinition = (EnumerationDefinition)theEObject;
        T result = caseEnumerationDefinition(enumerationDefinition);
        if (result == null) result = casePackageDefinitionElement(enumerationDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.ENUMERATION_LITERAL_DECLARATION:
      {
        EnumerationLiteralDeclaration enumerationLiteralDeclaration = (EnumerationLiteralDeclaration)theEObject;
        T result = caseEnumerationLiteralDeclaration(enumerationLiteralDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.FUNCTION_DEFINITION:
      {
        FunctionDefinition functionDefinition = (FunctionDefinition)theEObject;
        T result = caseFunctionDefinition(functionDefinition);
        if (result == null) result = casePackageDefinitionElement(functionDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.PARAMETER_DECLARATION:
      {
        ParameterDeclaration parameterDeclaration = (ParameterDeclaration)theEObject;
        T result = caseParameterDeclaration(parameterDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.STATEMENT:
      {
        Statement statement = (Statement)theEObject;
        T result = caseStatement(statement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.BLOCK:
      {
        Block block = (Block)theEObject;
        T result = caseBlock(block);
        if (result == null) result = caseStatement(block);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.FEATURE_CALL_STATEMENT:
      {
        FeatureCallStatement featureCallStatement = (FeatureCallStatement)theEObject;
        T result = caseFeatureCallStatement(featureCallStatement);
        if (result == null) result = caseStatement(featureCallStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.IF_STATEMENT:
      {
        IfStatement ifStatement = (IfStatement)theEObject;
        T result = caseIfStatement(ifStatement);
        if (result == null) result = caseStatement(ifStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.IF_CASE:
      {
        IfCase ifCase = (IfCase)theEObject;
        T result = caseIfCase(ifCase);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.WHILE_STATEMENT:
      {
        WhileStatement whileStatement = (WhileStatement)theEObject;
        T result = caseWhileStatement(whileStatement);
        if (result == null) result = caseStatement(whileStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.VARIABLE_DECLARATION:
      {
        VariableDeclaration variableDeclaration = (VariableDeclaration)theEObject;
        T result = caseVariableDeclaration(variableDeclaration);
        if (result == null) result = casePackageDefinitionElement(variableDeclaration);
        if (result == null) result = caseStatement(variableDeclaration);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.VARIABLE_DECLARATION_ITEM:
      {
        VariableDeclarationItem variableDeclarationItem = (VariableDeclarationItem)theEObject;
        T result = caseVariableDeclarationItem(variableDeclarationItem);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.DATA_TYPE_SPECIFIER:
      {
        DataTypeSpecifier dataTypeSpecifier = (DataTypeSpecifier)theEObject;
        T result = caseDataTypeSpecifier(dataTypeSpecifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.PRIMITIVE_TYPE_SPECIFIER:
      {
        PrimitiveTypeSpecifier primitiveTypeSpecifier = (PrimitiveTypeSpecifier)theEObject;
        T result = casePrimitiveTypeSpecifier(primitiveTypeSpecifier);
        if (result == null) result = caseDataTypeSpecifier(primitiveTypeSpecifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.NUMERICAL_TYPE_SPECIFIER:
      {
        NumericalTypeSpecifier numericalTypeSpecifier = (NumericalTypeSpecifier)theEObject;
        T result = caseNumericalTypeSpecifier(numericalTypeSpecifier);
        if (result == null) result = casePrimitiveTypeSpecifier(numericalTypeSpecifier);
        if (result == null) result = caseDataTypeSpecifier(numericalTypeSpecifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.REAL_TYPE_SPECIFIER:
      {
        RealTypeSpecifier realTypeSpecifier = (RealTypeSpecifier)theEObject;
        T result = caseRealTypeSpecifier(realTypeSpecifier);
        if (result == null) result = caseNumericalTypeSpecifier(realTypeSpecifier);
        if (result == null) result = casePrimitiveTypeSpecifier(realTypeSpecifier);
        if (result == null) result = caseDataTypeSpecifier(realTypeSpecifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.INTEGER_TYPE_SPECIFIER:
      {
        IntegerTypeSpecifier integerTypeSpecifier = (IntegerTypeSpecifier)theEObject;
        T result = caseIntegerTypeSpecifier(integerTypeSpecifier);
        if (result == null) result = caseNumericalTypeSpecifier(integerTypeSpecifier);
        if (result == null) result = casePrimitiveTypeSpecifier(integerTypeSpecifier);
        if (result == null) result = caseDataTypeSpecifier(integerTypeSpecifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.COMPLEX_TYPE_SPECIFIER:
      {
        ComplexTypeSpecifier complexTypeSpecifier = (ComplexTypeSpecifier)theEObject;
        T result = caseComplexTypeSpecifier(complexTypeSpecifier);
        if (result == null) result = caseNumericalTypeSpecifier(complexTypeSpecifier);
        if (result == null) result = casePrimitiveTypeSpecifier(complexTypeSpecifier);
        if (result == null) result = caseDataTypeSpecifier(complexTypeSpecifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.GAUSSIAN_TYPE_SPECIFIER:
      {
        GaussianTypeSpecifier gaussianTypeSpecifier = (GaussianTypeSpecifier)theEObject;
        T result = caseGaussianTypeSpecifier(gaussianTypeSpecifier);
        if (result == null) result = caseNumericalTypeSpecifier(gaussianTypeSpecifier);
        if (result == null) result = casePrimitiveTypeSpecifier(gaussianTypeSpecifier);
        if (result == null) result = caseDataTypeSpecifier(gaussianTypeSpecifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.BOOLEAN_TYPE_SPECIFIER:
      {
        BooleanTypeSpecifier booleanTypeSpecifier = (BooleanTypeSpecifier)theEObject;
        T result = caseBooleanTypeSpecifier(booleanTypeSpecifier);
        if (result == null) result = casePrimitiveTypeSpecifier(booleanTypeSpecifier);
        if (result == null) result = caseDataTypeSpecifier(booleanTypeSpecifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.STRING_TYPE_SPECIFIER:
      {
        StringTypeSpecifier stringTypeSpecifier = (StringTypeSpecifier)theEObject;
        T result = caseStringTypeSpecifier(stringTypeSpecifier);
        if (result == null) result = casePrimitiveTypeSpecifier(stringTypeSpecifier);
        if (result == null) result = caseDataTypeSpecifier(stringTypeSpecifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.NAMED_TYPE_SPECIFIER:
      {
        NamedTypeSpecifier namedTypeSpecifier = (NamedTypeSpecifier)theEObject;
        T result = caseNamedTypeSpecifier(namedTypeSpecifier);
        if (result == null) result = caseDataTypeSpecifier(namedTypeSpecifier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.EXPRESSION:
      {
        Expression expression = (Expression)theEObject;
        T result = caseExpression(expression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.CONDITIONAL_EXPRESSION:
      {
        ConditionalExpression conditionalExpression = (ConditionalExpression)theEObject;
        T result = caseConditionalExpression(conditionalExpression);
        if (result == null) result = caseExpression(conditionalExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.CONDITIONAL_EXPRESSION_CASE:
      {
        ConditionalExpressionCase conditionalExpressionCase = (ConditionalExpressionCase)theEObject;
        T result = caseConditionalExpressionCase(conditionalExpressionCase);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.LITERAL:
      {
        Literal literal = (Literal)theEObject;
        T result = caseLiteral(literal);
        if (result == null) result = caseExpression(literal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.NUMERICAL_LITERAL:
      {
        NumericalLiteral numericalLiteral = (NumericalLiteral)theEObject;
        T result = caseNumericalLiteral(numericalLiteral);
        if (result == null) result = caseLiteral(numericalLiteral);
        if (result == null) result = caseExpression(numericalLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.REAL_LITERAL:
      {
        RealLiteral realLiteral = (RealLiteral)theEObject;
        T result = caseRealLiteral(realLiteral);
        if (result == null) result = caseNumericalLiteral(realLiteral);
        if (result == null) result = caseLiteral(realLiteral);
        if (result == null) result = caseExpression(realLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.INTEGER_LITERAL:
      {
        IntegerLiteral integerLiteral = (IntegerLiteral)theEObject;
        T result = caseIntegerLiteral(integerLiteral);
        if (result == null) result = caseNumericalLiteral(integerLiteral);
        if (result == null) result = caseLiteral(integerLiteral);
        if (result == null) result = caseExpression(integerLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.BOOLEAN_LITERAL:
      {
        BooleanLiteral booleanLiteral = (BooleanLiteral)theEObject;
        T result = caseBooleanLiteral(booleanLiteral);
        if (result == null) result = caseLiteral(booleanLiteral);
        if (result == null) result = caseExpression(booleanLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.STRING_LITERAL:
      {
        StringLiteral stringLiteral = (StringLiteral)theEObject;
        T result = caseStringLiteral(stringLiteral);
        if (result == null) result = caseLiteral(stringLiteral);
        if (result == null) result = caseExpression(stringLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.QUALIFIED_NAME:
      {
        QualifiedName qualifiedName = (QualifiedName)theEObject;
        T result = caseQualifiedName(qualifiedName);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.FEATURE_CALL:
      {
        FeatureCall featureCall = (FeatureCall)theEObject;
        T result = caseFeatureCall(featureCall);
        if (result == null) result = caseExpression(featureCall);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.COMPONENT_REFERENCE:
      {
        ComponentReference componentReference = (ComponentReference)theEObject;
        T result = caseComponentReference(componentReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.ARRAY_REFERENCE:
      {
        ArrayReference arrayReference = (ArrayReference)theEObject;
        T result = caseArrayReference(arrayReference);
        if (result == null) result = caseComponentReference(arrayReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.MEMBER_REFERENCE:
      {
        MemberReference memberReference = (MemberReference)theEObject;
        T result = caseMemberReference(memberReference);
        if (result == null) result = caseComponentReference(memberReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.SUBSCRIPT:
      {
        Subscript subscript = (Subscript)theEObject;
        T result = caseSubscript(subscript);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.COLON_SUBSCRIPT:
      {
        ColonSubscript colonSubscript = (ColonSubscript)theEObject;
        T result = caseColonSubscript(colonSubscript);
        if (result == null) result = caseSubscript(colonSubscript);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.EXPRESSION_SUBSCRIPT:
      {
        ExpressionSubscript expressionSubscript = (ExpressionSubscript)theEObject;
        T result = caseExpressionSubscript(expressionSubscript);
        if (result == null) result = caseSubscript(expressionSubscript);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.MATRIX_CONSTRUCTION_OPERATOR:
      {
        MatrixConstructionOperator matrixConstructionOperator = (MatrixConstructionOperator)theEObject;
        T result = caseMatrixConstructionOperator(matrixConstructionOperator);
        if (result == null) result = caseExpression(matrixConstructionOperator);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.EXPRESSION_LIST:
      {
        ExpressionList expressionList = (ExpressionList)theEObject;
        T result = caseExpressionList(expressionList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.PARENTHESIZED_EXPRESSION:
      {
        ParenthesizedExpression parenthesizedExpression = (ParenthesizedExpression)theEObject;
        T result = caseParenthesizedExpression(parenthesizedExpression);
        if (result == null) result = caseExpression(parenthesizedExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.BEGIN_EXPRESSION:
      {
        BeginExpression beginExpression = (BeginExpression)theEObject;
        T result = caseBeginExpression(beginExpression);
        if (result == null) result = caseExpression(beginExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.END_EXPRESSION:
      {
        EndExpression endExpression = (EndExpression)theEObject;
        T result = caseEndExpression(endExpression);
        if (result == null) result = caseExpression(endExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.UNIT_EXPRESSION:
      {
        UnitExpression unitExpression = (UnitExpression)theEObject;
        T result = caseUnitExpression(unitExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.UNIT_EXPRESSION_NUMERATOR:
      {
        UnitExpressionNumerator unitExpressionNumerator = (UnitExpressionNumerator)theEObject;
        T result = caseUnitExpressionNumerator(unitExpressionNumerator);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.UNIT_EXPRESSION_DENOMINATOR:
      {
        UnitExpressionDenominator unitExpressionDenominator = (UnitExpressionDenominator)theEObject;
        T result = caseUnitExpressionDenominator(unitExpressionDenominator);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.UNIT_EXPRESSION_FACTOR:
      {
        UnitExpressionFactor unitExpressionFactor = (UnitExpressionFactor)theEObject;
        T result = caseUnitExpressionFactor(unitExpressionFactor);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.UNIT_EXPRESSION_EXPONENT:
      {
        UnitExpressionExponent unitExpressionExponent = (UnitExpressionExponent)theEObject;
        T result = caseUnitExpressionExponent(unitExpressionExponent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.RANGE_EXPRESSION:
      {
        RangeExpression rangeExpression = (RangeExpression)theEObject;
        T result = caseRangeExpression(rangeExpression);
        if (result == null) result = caseExpression(rangeExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.LOGICAL_OR_EXPRESSION:
      {
        LogicalOrExpression logicalOrExpression = (LogicalOrExpression)theEObject;
        T result = caseLogicalOrExpression(logicalOrExpression);
        if (result == null) result = caseExpression(logicalOrExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.LOGICAL_AND_EXPRESSION:
      {
        LogicalAndExpression logicalAndExpression = (LogicalAndExpression)theEObject;
        T result = caseLogicalAndExpression(logicalAndExpression);
        if (result == null) result = caseExpression(logicalAndExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.LOGICAL_NOT_EXPRESSION:
      {
        LogicalNotExpression logicalNotExpression = (LogicalNotExpression)theEObject;
        T result = caseLogicalNotExpression(logicalNotExpression);
        if (result == null) result = caseExpression(logicalNotExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.RELATIONAL_EXPRESSION:
      {
        RelationalExpression relationalExpression = (RelationalExpression)theEObject;
        T result = caseRelationalExpression(relationalExpression);
        if (result == null) result = caseExpression(relationalExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.ADD_SUBTRACT_EXPRESSION:
      {
        AddSubtractExpression addSubtractExpression = (AddSubtractExpression)theEObject;
        T result = caseAddSubtractExpression(addSubtractExpression);
        if (result == null) result = caseExpression(addSubtractExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.MULTIPLY_DIVIDE_EXPRESSION:
      {
        MultiplyDivideExpression multiplyDivideExpression = (MultiplyDivideExpression)theEObject;
        T result = caseMultiplyDivideExpression(multiplyDivideExpression);
        if (result == null) result = caseExpression(multiplyDivideExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.POWER_EXPRESSION:
      {
        PowerExpression powerExpression = (PowerExpression)theEObject;
        T result = casePowerExpression(powerExpression);
        if (result == null) result = caseExpression(powerExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AstPackage.UNARY_MINUS_EXPRESSION:
      {
        UnaryMinusExpression unaryMinusExpression = (UnaryMinusExpression)theEObject;
        T result = caseUnaryMinusExpression(unaryMinusExpression);
        if (result == null) result = caseExpression(unaryMinusExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mscript</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mscript</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMscript(Mscript object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Package Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Package Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePackageDefinition(PackageDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Package Definition Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Package Definition Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePackageDefinitionElement(PackageDefinitionElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enumeration Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enumeration Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumerationDefinition(EnumerationDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enumeration Literal Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enumeration Literal Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumerationLiteralDeclaration(EnumerationLiteralDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Function Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Function Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFunctionDefinition(FunctionDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parameter Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parameter Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParameterDeclaration(ParameterDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStatement(Statement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBlock(Block object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Feature Call Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Feature Call Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFeatureCallStatement(FeatureCallStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>If Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>If Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIfStatement(IfStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>If Case</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>If Case</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIfCase(IfCase object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>While Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>While Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseWhileStatement(WhileStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVariableDeclaration(VariableDeclaration object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Variable Declaration Item</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Variable Declaration Item</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVariableDeclarationItem(VariableDeclarationItem object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Data Type Specifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Data Type Specifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDataTypeSpecifier(DataTypeSpecifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Primitive Type Specifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Primitive Type Specifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrimitiveTypeSpecifier(PrimitiveTypeSpecifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Numerical Type Specifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Numerical Type Specifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNumericalTypeSpecifier(NumericalTypeSpecifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Real Type Specifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Real Type Specifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRealTypeSpecifier(RealTypeSpecifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Integer Type Specifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Integer Type Specifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntegerTypeSpecifier(IntegerTypeSpecifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Complex Type Specifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Complex Type Specifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseComplexTypeSpecifier(ComplexTypeSpecifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Gaussian Type Specifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Gaussian Type Specifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGaussianTypeSpecifier(GaussianTypeSpecifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Boolean Type Specifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Boolean Type Specifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBooleanTypeSpecifier(BooleanTypeSpecifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>String Type Specifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>String Type Specifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStringTypeSpecifier(StringTypeSpecifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Type Specifier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Type Specifier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedTypeSpecifier(NamedTypeSpecifier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpression(Expression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Conditional Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Conditional Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConditionalExpression(ConditionalExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Conditional Expression Case</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Conditional Expression Case</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConditionalExpressionCase(ConditionalExpressionCase object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLiteral(Literal object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Numerical Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Numerical Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNumericalLiteral(NumericalLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Real Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Real Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRealLiteral(RealLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Integer Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Integer Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntegerLiteral(IntegerLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Boolean Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Boolean Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBooleanLiteral(BooleanLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>String Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>String Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStringLiteral(StringLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Qualified Name</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Qualified Name</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQualifiedName(QualifiedName object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Feature Call</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Feature Call</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFeatureCall(FeatureCall object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Component Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Component Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseComponentReference(ComponentReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Array Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Array Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArrayReference(ArrayReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Member Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Member Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMemberReference(MemberReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Subscript</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Subscript</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSubscript(Subscript object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Colon Subscript</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Colon Subscript</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseColonSubscript(ColonSubscript object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression Subscript</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression Subscript</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpressionSubscript(ExpressionSubscript object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Matrix Construction Operator</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Matrix Construction Operator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMatrixConstructionOperator(MatrixConstructionOperator object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpressionList(ExpressionList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parenthesized Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parenthesized Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParenthesizedExpression(ParenthesizedExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Begin Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Begin Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBeginExpression(BeginExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>End Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>End Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEndExpression(EndExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unit Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unit Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnitExpression(UnitExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unit Expression Numerator</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unit Expression Numerator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnitExpressionNumerator(UnitExpressionNumerator object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unit Expression Denominator</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unit Expression Denominator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnitExpressionDenominator(UnitExpressionDenominator object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unit Expression Factor</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unit Expression Factor</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnitExpressionFactor(UnitExpressionFactor object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unit Expression Exponent</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unit Expression Exponent</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnitExpressionExponent(UnitExpressionExponent object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Range Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Range Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRangeExpression(RangeExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Logical Or Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Logical Or Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLogicalOrExpression(LogicalOrExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Logical And Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Logical And Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLogicalAndExpression(LogicalAndExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Logical Not Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Logical Not Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLogicalNotExpression(LogicalNotExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Relational Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Relational Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRelationalExpression(RelationalExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Add Subtract Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Add Subtract Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAddSubtractExpression(AddSubtractExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Multiply Divide Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Multiply Divide Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMultiplyDivideExpression(MultiplyDivideExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Power Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Power Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePowerExpression(PowerExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unary Minus Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unary Minus Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnaryMinusExpression(UnaryMinusExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  public T defaultCase(EObject object)
  {
    return null;
  }

} //AstSwitch
