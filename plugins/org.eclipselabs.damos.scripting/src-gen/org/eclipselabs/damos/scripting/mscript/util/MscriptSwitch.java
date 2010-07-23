/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.damos.scripting.mscript.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipselabs.damos.scripting.mscript.*;

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
 * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage
 * @generated
 */
public class MscriptSwitch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static MscriptPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MscriptSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = MscriptPackage.eINSTANCE;
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
      case MscriptPackage.MODEL:
      {
        Model model = (Model)theEObject;
        T result = caseModel(model);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.MSCRIPT:
      {
        Mscript mscript = (Mscript)theEObject;
        T result = caseMscript(mscript);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.PACKAGE_AS:
      {
        PackageAS packageAS = (PackageAS)theEObject;
        T result = casePackageAS(packageAS);
        if (result == null) result = casePackageableElementAS(packageAS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.PACKAGEABLE_ELEMENT_AS:
      {
        PackageableElementAS packageableElementAS = (PackageableElementAS)theEObject;
        T result = casePackageableElementAS(packageableElementAS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.ENUMERATION_AS:
      {
        EnumerationAS enumerationAS = (EnumerationAS)theEObject;
        T result = caseEnumerationAS(enumerationAS);
        if (result == null) result = casePackageableElementAS(enumerationAS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.ENUMERATION_LITERAL_AS:
      {
        EnumerationLiteralAS enumerationLiteralAS = (EnumerationLiteralAS)theEObject;
        T result = caseEnumerationLiteralAS(enumerationLiteralAS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.EXPRESSION:
      {
        Expression expression = (Expression)theEObject;
        T result = caseExpression(expression);
        if (result == null) result = caseModel(expression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.CONDITIONAL_EXPRESSION:
      {
        ConditionalExpression conditionalExpression = (ConditionalExpression)theEObject;
        T result = caseConditionalExpression(conditionalExpression);
        if (result == null) result = caseExpression(conditionalExpression);
        if (result == null) result = caseModel(conditionalExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.CONDITIONAL_EXPRESSION_CASE:
      {
        ConditionalExpressionCase conditionalExpressionCase = (ConditionalExpressionCase)theEObject;
        T result = caseConditionalExpressionCase(conditionalExpressionCase);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.LITERAL:
      {
        Literal literal = (Literal)theEObject;
        T result = caseLiteral(literal);
        if (result == null) result = caseExpression(literal);
        if (result == null) result = caseModel(literal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.NUMERICAL_LITERAL:
      {
        NumericalLiteral numericalLiteral = (NumericalLiteral)theEObject;
        T result = caseNumericalLiteral(numericalLiteral);
        if (result == null) result = caseLiteral(numericalLiteral);
        if (result == null) result = caseExpression(numericalLiteral);
        if (result == null) result = caseModel(numericalLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.REAL_LITERAL:
      {
        RealLiteral realLiteral = (RealLiteral)theEObject;
        T result = caseRealLiteral(realLiteral);
        if (result == null) result = caseNumericalLiteral(realLiteral);
        if (result == null) result = caseLiteral(realLiteral);
        if (result == null) result = caseExpression(realLiteral);
        if (result == null) result = caseModel(realLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.INTEGER_LITERAL:
      {
        IntegerLiteral integerLiteral = (IntegerLiteral)theEObject;
        T result = caseIntegerLiteral(integerLiteral);
        if (result == null) result = caseNumericalLiteral(integerLiteral);
        if (result == null) result = caseLiteral(integerLiteral);
        if (result == null) result = caseExpression(integerLiteral);
        if (result == null) result = caseModel(integerLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.BOOLEAN_LITERAL:
      {
        BooleanLiteral booleanLiteral = (BooleanLiteral)theEObject;
        T result = caseBooleanLiteral(booleanLiteral);
        if (result == null) result = caseLiteral(booleanLiteral);
        if (result == null) result = caseExpression(booleanLiteral);
        if (result == null) result = caseModel(booleanLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.STRING_LITERAL:
      {
        StringLiteral stringLiteral = (StringLiteral)theEObject;
        T result = caseStringLiteral(stringLiteral);
        if (result == null) result = caseLiteral(stringLiteral);
        if (result == null) result = caseExpression(stringLiteral);
        if (result == null) result = caseModel(stringLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.FUNCTION_CALL:
      {
        FunctionCall functionCall = (FunctionCall)theEObject;
        T result = caseFunctionCall(functionCall);
        if (result == null) result = caseExpression(functionCall);
        if (result == null) result = caseModel(functionCall);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.NAMED_FUNCTION_CALL:
      {
        NamedFunctionCall namedFunctionCall = (NamedFunctionCall)theEObject;
        T result = caseNamedFunctionCall(namedFunctionCall);
        if (result == null) result = caseFunctionCall(namedFunctionCall);
        if (result == null) result = caseExpression(namedFunctionCall);
        if (result == null) result = caseModel(namedFunctionCall);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.NAME:
      {
        Name name = (Name)theEObject;
        T result = caseName(name);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.KEYWORD_FUNCTION_CALL:
      {
        KeywordFunctionCall keywordFunctionCall = (KeywordFunctionCall)theEObject;
        T result = caseKeywordFunctionCall(keywordFunctionCall);
        if (result == null) result = caseFunctionCall(keywordFunctionCall);
        if (result == null) result = caseExpression(keywordFunctionCall);
        if (result == null) result = caseModel(keywordFunctionCall);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.FUNCTION_ARGUMENT_LIST:
      {
        FunctionArgumentList functionArgumentList = (FunctionArgumentList)theEObject;
        T result = caseFunctionArgumentList(functionArgumentList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.NAMED_ARGUMENT:
      {
        NamedArgument namedArgument = (NamedArgument)theEObject;
        T result = caseNamedArgument(namedArgument);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.COMPONENT_REFERENCE:
      {
        ComponentReference componentReference = (ComponentReference)theEObject;
        T result = caseComponentReference(componentReference);
        if (result == null) result = caseExpression(componentReference);
        if (result == null) result = caseModel(componentReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.COMPONENT_REFERENCE_SEGMENT:
      {
        ComponentReferenceSegment componentReferenceSegment = (ComponentReferenceSegment)theEObject;
        T result = caseComponentReferenceSegment(componentReferenceSegment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.ARRAY_SUBSCRIPT_LIST:
      {
        ArraySubscriptList arraySubscriptList = (ArraySubscriptList)theEObject;
        T result = caseArraySubscriptList(arraySubscriptList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.SUBSCRIPT:
      {
        Subscript subscript = (Subscript)theEObject;
        T result = caseSubscript(subscript);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.COLON_SUBSCRIPT:
      {
        ColonSubscript colonSubscript = (ColonSubscript)theEObject;
        T result = caseColonSubscript(colonSubscript);
        if (result == null) result = caseSubscript(colonSubscript);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.EXPRESSION_SUBSCRIPT:
      {
        ExpressionSubscript expressionSubscript = (ExpressionSubscript)theEObject;
        T result = caseExpressionSubscript(expressionSubscript);
        if (result == null) result = caseSubscript(expressionSubscript);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.ARRAY_CONCATENATION_OPERATOR:
      {
        ArrayConcatenationOperator arrayConcatenationOperator = (ArrayConcatenationOperator)theEObject;
        T result = caseArrayConcatenationOperator(arrayConcatenationOperator);
        if (result == null) result = caseExpression(arrayConcatenationOperator);
        if (result == null) result = caseModel(arrayConcatenationOperator);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.ARRAY_CONSTRUCTION_OPERATOR:
      {
        ArrayConstructionOperator arrayConstructionOperator = (ArrayConstructionOperator)theEObject;
        T result = caseArrayConstructionOperator(arrayConstructionOperator);
        if (result == null) result = caseExpression(arrayConstructionOperator);
        if (result == null) result = caseModel(arrayConstructionOperator);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.EXPRESSION_LIST:
      {
        ExpressionList expressionList = (ExpressionList)theEObject;
        T result = caseExpressionList(expressionList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.PARENTHESIZED_EXPRESSION:
      {
        ParenthesizedExpression parenthesizedExpression = (ParenthesizedExpression)theEObject;
        T result = caseParenthesizedExpression(parenthesizedExpression);
        if (result == null) result = caseExpression(parenthesizedExpression);
        if (result == null) result = caseModel(parenthesizedExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.BEGIN_EXPRESSION:
      {
        BeginExpression beginExpression = (BeginExpression)theEObject;
        T result = caseBeginExpression(beginExpression);
        if (result == null) result = caseExpression(beginExpression);
        if (result == null) result = caseModel(beginExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.END_EXPRESSION:
      {
        EndExpression endExpression = (EndExpression)theEObject;
        T result = caseEndExpression(endExpression);
        if (result == null) result = caseExpression(endExpression);
        if (result == null) result = caseModel(endExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.UNIT_EXPRESSION:
      {
        UnitExpression unitExpression = (UnitExpression)theEObject;
        T result = caseUnitExpression(unitExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.UNIT_EXPRESSION_NUMERATOR:
      {
        UnitExpressionNumerator unitExpressionNumerator = (UnitExpressionNumerator)theEObject;
        T result = caseUnitExpressionNumerator(unitExpressionNumerator);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.UNIT_EXPRESSION_DENOMINATOR:
      {
        UnitExpressionDenominator unitExpressionDenominator = (UnitExpressionDenominator)theEObject;
        T result = caseUnitExpressionDenominator(unitExpressionDenominator);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.UNIT_EXPRESSION_FACTOR:
      {
        UnitExpressionFactor unitExpressionFactor = (UnitExpressionFactor)theEObject;
        T result = caseUnitExpressionFactor(unitExpressionFactor);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.UNIT_EXPRESSION_EXPONENT:
      {
        UnitExpressionExponent unitExpressionExponent = (UnitExpressionExponent)theEObject;
        T result = caseUnitExpressionExponent(unitExpressionExponent);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.RANGE_EXPRESSION:
      {
        RangeExpression rangeExpression = (RangeExpression)theEObject;
        T result = caseRangeExpression(rangeExpression);
        if (result == null) result = caseExpression(rangeExpression);
        if (result == null) result = caseModel(rangeExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.LOGICAL_OR_EXPRESSION:
      {
        LogicalOrExpression logicalOrExpression = (LogicalOrExpression)theEObject;
        T result = caseLogicalOrExpression(logicalOrExpression);
        if (result == null) result = caseExpression(logicalOrExpression);
        if (result == null) result = caseModel(logicalOrExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.LOGICAL_AND_EXPRESSION:
      {
        LogicalAndExpression logicalAndExpression = (LogicalAndExpression)theEObject;
        T result = caseLogicalAndExpression(logicalAndExpression);
        if (result == null) result = caseExpression(logicalAndExpression);
        if (result == null) result = caseModel(logicalAndExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.LOGICAL_NOT_EXPRESSION:
      {
        LogicalNotExpression logicalNotExpression = (LogicalNotExpression)theEObject;
        T result = caseLogicalNotExpression(logicalNotExpression);
        if (result == null) result = caseExpression(logicalNotExpression);
        if (result == null) result = caseModel(logicalNotExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.RELATIONAL_EXPRESSION:
      {
        RelationalExpression relationalExpression = (RelationalExpression)theEObject;
        T result = caseRelationalExpression(relationalExpression);
        if (result == null) result = caseExpression(relationalExpression);
        if (result == null) result = caseModel(relationalExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.ADD_SUBTRACT_EXPRESSION:
      {
        AddSubtractExpression addSubtractExpression = (AddSubtractExpression)theEObject;
        T result = caseAddSubtractExpression(addSubtractExpression);
        if (result == null) result = caseExpression(addSubtractExpression);
        if (result == null) result = caseModel(addSubtractExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.MULTIPLY_DIVIDE_EXPRESSION:
      {
        MultiplyDivideExpression multiplyDivideExpression = (MultiplyDivideExpression)theEObject;
        T result = caseMultiplyDivideExpression(multiplyDivideExpression);
        if (result == null) result = caseExpression(multiplyDivideExpression);
        if (result == null) result = caseModel(multiplyDivideExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.POWER_EXPRESSION:
      {
        PowerExpression powerExpression = (PowerExpression)theEObject;
        T result = casePowerExpression(powerExpression);
        if (result == null) result = caseExpression(powerExpression);
        if (result == null) result = caseModel(powerExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MscriptPackage.UNARY_MINUS_EXPRESSION:
      {
        UnaryMinusExpression unaryMinusExpression = (UnaryMinusExpression)theEObject;
        T result = caseUnaryMinusExpression(unaryMinusExpression);
        if (result == null) result = caseExpression(unaryMinusExpression);
        if (result == null) result = caseModel(unaryMinusExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModel(Model object)
  {
    return null;
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
   * Returns the result of interpreting the object as an instance of '<em>Package AS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Package AS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePackageAS(PackageAS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Packageable Element AS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Packageable Element AS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePackageableElementAS(PackageableElementAS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enumeration AS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enumeration AS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumerationAS(EnumerationAS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enumeration Literal AS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enumeration Literal AS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumerationLiteralAS(EnumerationLiteralAS object)
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
   * Returns the result of interpreting the object as an instance of '<em>Function Call</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Function Call</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFunctionCall(FunctionCall object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Function Call</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Function Call</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedFunctionCall(NamedFunctionCall object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Name</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Name</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseName(Name object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Keyword Function Call</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Keyword Function Call</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseKeywordFunctionCall(KeywordFunctionCall object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Function Argument List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Function Argument List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFunctionArgumentList(FunctionArgumentList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Argument</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Argument</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedArgument(NamedArgument object)
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
   * Returns the result of interpreting the object as an instance of '<em>Component Reference Segment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Component Reference Segment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseComponentReferenceSegment(ComponentReferenceSegment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Array Subscript List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Array Subscript List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArraySubscriptList(ArraySubscriptList object)
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
   * Returns the result of interpreting the object as an instance of '<em>Array Concatenation Operator</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Array Concatenation Operator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArrayConcatenationOperator(ArrayConcatenationOperator object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Array Construction Operator</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Array Construction Operator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArrayConstructionOperator(ArrayConstructionOperator object)
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

} //MscriptSwitch
