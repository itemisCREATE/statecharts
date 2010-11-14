/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipselabs.mscript.language.ast.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.mscript.language.ast.AstPackage
 * @generated
 */
public class AstAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static AstPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AstAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = AstPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AstSwitch<Adapter> modelSwitch =
    new AstSwitch<Adapter>()
    {
      @Override
      public Adapter caseModule(Module object)
      {
        return createModuleAdapter();
      }
      @Override
      public Adapter caseDefinition(Definition object)
      {
        return createDefinitionAdapter();
      }
      @Override
      public Adapter caseDataTypeDefinition(DataTypeDefinition object)
      {
        return createDataTypeDefinitionAdapter();
      }
      @Override
      public Adapter caseEnumerationDefinition(EnumerationDefinition object)
      {
        return createEnumerationDefinitionAdapter();
      }
      @Override
      public Adapter caseEnumerationLiteralDeclaration(EnumerationLiteralDeclaration object)
      {
        return createEnumerationLiteralDeclarationAdapter();
      }
      @Override
      public Adapter caseTypeAliasDefinition(TypeAliasDefinition object)
      {
        return createTypeAliasDefinitionAdapter();
      }
      @Override
      public Adapter caseRecordDefinition(RecordDefinition object)
      {
        return createRecordDefinitionAdapter();
      }
      @Override
      public Adapter caseRecordFieldDeclaration(RecordFieldDeclaration object)
      {
        return createRecordFieldDeclarationAdapter();
      }
      @Override
      public Adapter caseFunctionDefinition(FunctionDefinition object)
      {
        return createFunctionDefinitionAdapter();
      }
      @Override
      public Adapter caseParameterDeclaration(ParameterDeclaration object)
      {
        return createParameterDeclarationAdapter();
      }
      @Override
      public Adapter caseAssertion(Assertion object)
      {
        return createAssertionAdapter();
      }
      @Override
      public Adapter caseStateVariableDeclaration(StateVariableDeclaration object)
      {
        return createStateVariableDeclarationAdapter();
      }
      @Override
      public Adapter caseFunctorDeclaration(FunctorDeclaration object)
      {
        return createFunctorDeclarationAdapter();
      }
      @Override
      public Adapter caseEquation(Equation object)
      {
        return createEquationAdapter();
      }
      @Override
      public Adapter caseDataTypeSpecifier(DataTypeSpecifier object)
      {
        return createDataTypeSpecifierAdapter();
      }
      @Override
      public Adapter casePrimitiveTypeSpecifier(PrimitiveTypeSpecifier object)
      {
        return createPrimitiveTypeSpecifierAdapter();
      }
      @Override
      public Adapter caseNumericTypeSpecifier(NumericTypeSpecifier object)
      {
        return createNumericTypeSpecifierAdapter();
      }
      @Override
      public Adapter caseRealTypeSpecifier(RealTypeSpecifier object)
      {
        return createRealTypeSpecifierAdapter();
      }
      @Override
      public Adapter caseIntegerTypeSpecifier(IntegerTypeSpecifier object)
      {
        return createIntegerTypeSpecifierAdapter();
      }
      @Override
      public Adapter caseComplexTypeSpecifier(ComplexTypeSpecifier object)
      {
        return createComplexTypeSpecifierAdapter();
      }
      @Override
      public Adapter caseGaussianTypeSpecifier(GaussianTypeSpecifier object)
      {
        return createGaussianTypeSpecifierAdapter();
      }
      @Override
      public Adapter caseBooleanTypeSpecifier(BooleanTypeSpecifier object)
      {
        return createBooleanTypeSpecifierAdapter();
      }
      @Override
      public Adapter caseStringTypeSpecifier(StringTypeSpecifier object)
      {
        return createStringTypeSpecifierAdapter();
      }
      @Override
      public Adapter caseNamedTypeSpecifier(NamedTypeSpecifier object)
      {
        return createNamedTypeSpecifierAdapter();
      }
      @Override
      public Adapter caseArrayDimensionSpecification(ArrayDimensionSpecification object)
      {
        return createArrayDimensionSpecificationAdapter();
      }
      @Override
      public Adapter caseExpression(Expression object)
      {
        return createExpressionAdapter();
      }
      @Override
      public Adapter caseLetExpression(LetExpression object)
      {
        return createLetExpressionAdapter();
      }
      @Override
      public Adapter caseLetExpressionVariable(LetExpressionVariable object)
      {
        return createLetExpressionVariableAdapter();
      }
      @Override
      public Adapter caseIfExpression(IfExpression object)
      {
        return createIfExpressionAdapter();
      }
      @Override
      public Adapter caseSwitchExpression(SwitchExpression object)
      {
        return createSwitchExpressionAdapter();
      }
      @Override
      public Adapter caseSwitchCase(SwitchCase object)
      {
        return createSwitchCaseAdapter();
      }
      @Override
      public Adapter caseAdditiveExpressionPart(AdditiveExpressionPart object)
      {
        return createAdditiveExpressionPartAdapter();
      }
      @Override
      public Adapter caseMultiplicativeExpressionPart(MultiplicativeExpressionPart object)
      {
        return createMultiplicativeExpressionPartAdapter();
      }
      @Override
      public Adapter caseLiteral(Literal object)
      {
        return createLiteralAdapter();
      }
      @Override
      public Adapter caseNumericLiteral(NumericLiteral object)
      {
        return createNumericLiteralAdapter();
      }
      @Override
      public Adapter caseRealLiteral(RealLiteral object)
      {
        return createRealLiteralAdapter();
      }
      @Override
      public Adapter caseIntegerLiteral(IntegerLiteral object)
      {
        return createIntegerLiteralAdapter();
      }
      @Override
      public Adapter caseBooleanLiteral(BooleanLiteral object)
      {
        return createBooleanLiteralAdapter();
      }
      @Override
      public Adapter caseStringLiteral(StringLiteral object)
      {
        return createStringLiteralAdapter();
      }
      @Override
      public Adapter caseFeatureCallPart(FeatureCallPart object)
      {
        return createFeatureCallPartAdapter();
      }
      @Override
      public Adapter caseFeatureAccess(FeatureAccess object)
      {
        return createFeatureAccessAdapter();
      }
      @Override
      public Adapter caseArrayElementAccess(ArrayElementAccess object)
      {
        return createArrayElementAccessAdapter();
      }
      @Override
      public Adapter caseArraySubscript(ArraySubscript object)
      {
        return createArraySubscriptAdapter();
      }
      @Override
      public Adapter caseOperationCall(OperationCall object)
      {
        return createOperationCallAdapter();
      }
      @Override
      public Adapter caseIterationCall(IterationCall object)
      {
        return createIterationCallAdapter();
      }
      @Override
      public Adapter caseIterationVariable(IterationVariable object)
      {
        return createIterationVariableAdapter();
      }
      @Override
      public Adapter caseIterationAccumulator(IterationAccumulator object)
      {
        return createIterationAccumulatorAdapter();
      }
      @Override
      public Adapter caseArrayConstructionOperator(ArrayConstructionOperator object)
      {
        return createArrayConstructionOperatorAdapter();
      }
      @Override
      public Adapter caseArrayConstructionIterationClause(ArrayConstructionIterationClause object)
      {
        return createArrayConstructionIterationClauseAdapter();
      }
      @Override
      public Adapter caseArrayConcatenationOperator(ArrayConcatenationOperator object)
      {
        return createArrayConcatenationOperatorAdapter();
      }
      @Override
      public Adapter caseExpressionList(ExpressionList object)
      {
        return createExpressionListAdapter();
      }
      @Override
      public Adapter caseUnitConstructionOperator(UnitConstructionOperator object)
      {
        return createUnitConstructionOperatorAdapter();
      }
      @Override
      public Adapter caseParenthesizedExpression(ParenthesizedExpression object)
      {
        return createParenthesizedExpressionAdapter();
      }
      @Override
      public Adapter caseBeginExpression(BeginExpression object)
      {
        return createBeginExpressionAdapter();
      }
      @Override
      public Adapter caseEndExpression(EndExpression object)
      {
        return createEndExpressionAdapter();
      }
      @Override
      public Adapter caseQualifiedName(QualifiedName object)
      {
        return createQualifiedNameAdapter();
      }
      @Override
      public Adapter caseUnitExpression(UnitExpression object)
      {
        return createUnitExpressionAdapter();
      }
      @Override
      public Adapter caseUnitExpressionNumerator(UnitExpressionNumerator object)
      {
        return createUnitExpressionNumeratorAdapter();
      }
      @Override
      public Adapter caseUnitExpressionDenominator(UnitExpressionDenominator object)
      {
        return createUnitExpressionDenominatorAdapter();
      }
      @Override
      public Adapter caseUnitExpressionFactor(UnitExpressionFactor object)
      {
        return createUnitExpressionFactorAdapter();
      }
      @Override
      public Adapter caseUnitExpressionExponent(UnitExpressionExponent object)
      {
        return createUnitExpressionExponentAdapter();
      }
      @Override
      public Adapter caseRangeExpression(RangeExpression object)
      {
        return createRangeExpressionAdapter();
      }
      @Override
      public Adapter caseImpliesExpression(ImpliesExpression object)
      {
        return createImpliesExpressionAdapter();
      }
      @Override
      public Adapter caseLogicalOrExpression(LogicalOrExpression object)
      {
        return createLogicalOrExpressionAdapter();
      }
      @Override
      public Adapter caseLogicalAndExpression(LogicalAndExpression object)
      {
        return createLogicalAndExpressionAdapter();
      }
      @Override
      public Adapter caseEqualityExpression(EqualityExpression object)
      {
        return createEqualityExpressionAdapter();
      }
      @Override
      public Adapter caseRelationalExpression(RelationalExpression object)
      {
        return createRelationalExpressionAdapter();
      }
      @Override
      public Adapter caseAdditiveExpression(AdditiveExpression object)
      {
        return createAdditiveExpressionAdapter();
      }
      @Override
      public Adapter caseMultiplicativeExpression(MultiplicativeExpression object)
      {
        return createMultiplicativeExpressionAdapter();
      }
      @Override
      public Adapter casePowerExpression(PowerExpression object)
      {
        return createPowerExpressionAdapter();
      }
      @Override
      public Adapter caseUnaryExpression(UnaryExpression object)
      {
        return createUnaryExpressionAdapter();
      }
      @Override
      public Adapter casePostfixExpression(PostfixExpression object)
      {
        return createPostfixExpressionAdapter();
      }
      @Override
      public Adapter caseSimpleName(SimpleName object)
      {
        return createSimpleNameAdapter();
      }
      @Override
      public Adapter caseFeatureCall(FeatureCall object)
      {
        return createFeatureCallAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.Module <em>Module</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.Module
   * @generated
   */
  public Adapter createModuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.Definition <em>Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.Definition
   * @generated
   */
  public Adapter createDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.DataTypeDefinition <em>Data Type Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.DataTypeDefinition
   * @generated
   */
  public Adapter createDataTypeDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.EnumerationDefinition <em>Enumeration Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.EnumerationDefinition
   * @generated
   */
  public Adapter createEnumerationDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.EnumerationLiteralDeclaration <em>Enumeration Literal Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.EnumerationLiteralDeclaration
   * @generated
   */
  public Adapter createEnumerationLiteralDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.TypeAliasDefinition <em>Type Alias Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.TypeAliasDefinition
   * @generated
   */
  public Adapter createTypeAliasDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.RecordDefinition <em>Record Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.RecordDefinition
   * @generated
   */
  public Adapter createRecordDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.RecordFieldDeclaration <em>Record Field Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.RecordFieldDeclaration
   * @generated
   */
  public Adapter createRecordFieldDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.FunctionDefinition <em>Function Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.FunctionDefinition
   * @generated
   */
  public Adapter createFunctionDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.ParameterDeclaration <em>Parameter Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.ParameterDeclaration
   * @generated
   */
  public Adapter createParameterDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.Assertion <em>Assertion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.Assertion
   * @generated
   */
  public Adapter createAssertionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.StateVariableDeclaration <em>State Variable Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.StateVariableDeclaration
   * @generated
   */
  public Adapter createStateVariableDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.FunctorDeclaration <em>Functor Declaration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.FunctorDeclaration
   * @generated
   */
  public Adapter createFunctorDeclarationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.Equation <em>Equation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.Equation
   * @generated
   */
  public Adapter createEquationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.DataTypeSpecifier <em>Data Type Specifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.DataTypeSpecifier
   * @generated
   */
  public Adapter createDataTypeSpecifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.PrimitiveTypeSpecifier <em>Primitive Type Specifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.PrimitiveTypeSpecifier
   * @generated
   */
  public Adapter createPrimitiveTypeSpecifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.NumericTypeSpecifier <em>Numeric Type Specifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.NumericTypeSpecifier
   * @generated
   */
  public Adapter createNumericTypeSpecifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.RealTypeSpecifier <em>Real Type Specifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.RealTypeSpecifier
   * @generated
   */
  public Adapter createRealTypeSpecifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.IntegerTypeSpecifier <em>Integer Type Specifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.IntegerTypeSpecifier
   * @generated
   */
  public Adapter createIntegerTypeSpecifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.ComplexTypeSpecifier <em>Complex Type Specifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.ComplexTypeSpecifier
   * @generated
   */
  public Adapter createComplexTypeSpecifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.GaussianTypeSpecifier <em>Gaussian Type Specifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.GaussianTypeSpecifier
   * @generated
   */
  public Adapter createGaussianTypeSpecifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.BooleanTypeSpecifier <em>Boolean Type Specifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.BooleanTypeSpecifier
   * @generated
   */
  public Adapter createBooleanTypeSpecifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.StringTypeSpecifier <em>String Type Specifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.StringTypeSpecifier
   * @generated
   */
  public Adapter createStringTypeSpecifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.NamedTypeSpecifier <em>Named Type Specifier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.NamedTypeSpecifier
   * @generated
   */
  public Adapter createNamedTypeSpecifierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.ArrayDimensionSpecification <em>Array Dimension Specification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.ArrayDimensionSpecification
   * @generated
   */
  public Adapter createArrayDimensionSpecificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.Expression
   * @generated
   */
  public Adapter createExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.LetExpression <em>Let Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.LetExpression
   * @generated
   */
  public Adapter createLetExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.LetExpressionVariable <em>Let Expression Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.LetExpressionVariable
   * @generated
   */
  public Adapter createLetExpressionVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.IfExpression <em>If Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.IfExpression
   * @generated
   */
  public Adapter createIfExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.SwitchExpression <em>Switch Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.SwitchExpression
   * @generated
   */
  public Adapter createSwitchExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.SwitchCase <em>Switch Case</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.SwitchCase
   * @generated
   */
  public Adapter createSwitchCaseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.AdditiveExpressionPart <em>Additive Expression Part</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.AdditiveExpressionPart
   * @generated
   */
  public Adapter createAdditiveExpressionPartAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.MultiplicativeExpressionPart <em>Multiplicative Expression Part</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.MultiplicativeExpressionPart
   * @generated
   */
  public Adapter createMultiplicativeExpressionPartAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.Literal <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.Literal
   * @generated
   */
  public Adapter createLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.NumericLiteral <em>Numeric Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.NumericLiteral
   * @generated
   */
  public Adapter createNumericLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.RealLiteral <em>Real Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.RealLiteral
   * @generated
   */
  public Adapter createRealLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.IntegerLiteral <em>Integer Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.IntegerLiteral
   * @generated
   */
  public Adapter createIntegerLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.BooleanLiteral <em>Boolean Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.BooleanLiteral
   * @generated
   */
  public Adapter createBooleanLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.StringLiteral <em>String Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.StringLiteral
   * @generated
   */
  public Adapter createStringLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.FeatureCallPart <em>Feature Call Part</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.FeatureCallPart
   * @generated
   */
  public Adapter createFeatureCallPartAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.FeatureAccess <em>Feature Access</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.FeatureAccess
   * @generated
   */
  public Adapter createFeatureAccessAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.ArrayElementAccess <em>Array Element Access</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.ArrayElementAccess
   * @generated
   */
  public Adapter createArrayElementAccessAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.ArraySubscript <em>Array Subscript</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.ArraySubscript
   * @generated
   */
  public Adapter createArraySubscriptAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.OperationCall <em>Operation Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.OperationCall
   * @generated
   */
  public Adapter createOperationCallAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.IterationCall <em>Iteration Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.IterationCall
   * @generated
   */
  public Adapter createIterationCallAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.IterationVariable <em>Iteration Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.IterationVariable
   * @generated
   */
  public Adapter createIterationVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.IterationAccumulator <em>Iteration Accumulator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.IterationAccumulator
   * @generated
   */
  public Adapter createIterationAccumulatorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.ArrayConstructionOperator <em>Array Construction Operator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.ArrayConstructionOperator
   * @generated
   */
  public Adapter createArrayConstructionOperatorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.ArrayConstructionIterationClause <em>Array Construction Iteration Clause</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.ArrayConstructionIterationClause
   * @generated
   */
  public Adapter createArrayConstructionIterationClauseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.ArrayConcatenationOperator <em>Array Concatenation Operator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.ArrayConcatenationOperator
   * @generated
   */
  public Adapter createArrayConcatenationOperatorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.ExpressionList <em>Expression List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.ExpressionList
   * @generated
   */
  public Adapter createExpressionListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.UnitConstructionOperator <em>Unit Construction Operator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.UnitConstructionOperator
   * @generated
   */
  public Adapter createUnitConstructionOperatorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.ParenthesizedExpression <em>Parenthesized Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.ParenthesizedExpression
   * @generated
   */
  public Adapter createParenthesizedExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.BeginExpression <em>Begin Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.BeginExpression
   * @generated
   */
  public Adapter createBeginExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.EndExpression <em>End Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.EndExpression
   * @generated
   */
  public Adapter createEndExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.QualifiedName <em>Qualified Name</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.QualifiedName
   * @generated
   */
  public Adapter createQualifiedNameAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.UnitExpression <em>Unit Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.UnitExpression
   * @generated
   */
  public Adapter createUnitExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.UnitExpressionNumerator <em>Unit Expression Numerator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.UnitExpressionNumerator
   * @generated
   */
  public Adapter createUnitExpressionNumeratorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.UnitExpressionDenominator <em>Unit Expression Denominator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.UnitExpressionDenominator
   * @generated
   */
  public Adapter createUnitExpressionDenominatorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.UnitExpressionFactor <em>Unit Expression Factor</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.UnitExpressionFactor
   * @generated
   */
  public Adapter createUnitExpressionFactorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.UnitExpressionExponent <em>Unit Expression Exponent</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.UnitExpressionExponent
   * @generated
   */
  public Adapter createUnitExpressionExponentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.RangeExpression <em>Range Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.RangeExpression
   * @generated
   */
  public Adapter createRangeExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.ImpliesExpression <em>Implies Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.ImpliesExpression
   * @generated
   */
  public Adapter createImpliesExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.LogicalOrExpression <em>Logical Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.LogicalOrExpression
   * @generated
   */
  public Adapter createLogicalOrExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.LogicalAndExpression <em>Logical And Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.LogicalAndExpression
   * @generated
   */
  public Adapter createLogicalAndExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.EqualityExpression <em>Equality Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.EqualityExpression
   * @generated
   */
  public Adapter createEqualityExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.RelationalExpression <em>Relational Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.RelationalExpression
   * @generated
   */
  public Adapter createRelationalExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.AdditiveExpression <em>Additive Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.AdditiveExpression
   * @generated
   */
  public Adapter createAdditiveExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.MultiplicativeExpression <em>Multiplicative Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.MultiplicativeExpression
   * @generated
   */
  public Adapter createMultiplicativeExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.PowerExpression <em>Power Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.PowerExpression
   * @generated
   */
  public Adapter createPowerExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.UnaryExpression <em>Unary Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.UnaryExpression
   * @generated
   */
  public Adapter createUnaryExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.PostfixExpression <em>Postfix Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.PostfixExpression
   * @generated
   */
  public Adapter createPostfixExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.SimpleName <em>Simple Name</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.SimpleName
   * @generated
   */
  public Adapter createSimpleNameAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.ast.FeatureCall <em>Feature Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.mscript.language.ast.FeatureCall
   * @generated
   */
  public Adapter createFeatureCallAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //AstAdapterFactory
