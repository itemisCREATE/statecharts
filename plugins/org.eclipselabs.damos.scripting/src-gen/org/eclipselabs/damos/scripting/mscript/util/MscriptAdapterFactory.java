/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.damos.scripting.mscript.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipselabs.damos.scripting.mscript.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage
 * @generated
 */
public class MscriptAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static MscriptPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MscriptAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = MscriptPackage.eINSTANCE;
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
  protected MscriptSwitch<Adapter> modelSwitch =
    new MscriptSwitch<Adapter>()
    {
      @Override
      public Adapter caseModel(Model object)
      {
        return createModelAdapter();
      }
      @Override
      public Adapter caseMscript(Mscript object)
      {
        return createMscriptAdapter();
      }
      @Override
      public Adapter casePackageDefinition(PackageDefinition object)
      {
        return createPackageDefinitionAdapter();
      }
      @Override
      public Adapter casePackageDefinitionElement(PackageDefinitionElement object)
      {
        return createPackageDefinitionElementAdapter();
      }
      @Override
      public Adapter caseEnumerationDefinition(EnumerationDefinition object)
      {
        return createEnumerationDefinitionAdapter();
      }
      @Override
      public Adapter caseEnumerationLiteralDefinition(EnumerationLiteralDefinition object)
      {
        return createEnumerationLiteralDefinitionAdapter();
      }
      @Override
      public Adapter caseExpression(Expression object)
      {
        return createExpressionAdapter();
      }
      @Override
      public Adapter caseConditionalExpression(ConditionalExpression object)
      {
        return createConditionalExpressionAdapter();
      }
      @Override
      public Adapter caseConditionalExpressionCase(ConditionalExpressionCase object)
      {
        return createConditionalExpressionCaseAdapter();
      }
      @Override
      public Adapter caseLiteral(Literal object)
      {
        return createLiteralAdapter();
      }
      @Override
      public Adapter caseNumericalLiteral(NumericalLiteral object)
      {
        return createNumericalLiteralAdapter();
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
      public Adapter caseFunctionCall(FunctionCall object)
      {
        return createFunctionCallAdapter();
      }
      @Override
      public Adapter caseNamedFunctionCall(NamedFunctionCall object)
      {
        return createNamedFunctionCallAdapter();
      }
      @Override
      public Adapter caseName(Name object)
      {
        return createNameAdapter();
      }
      @Override
      public Adapter caseKeywordFunctionCall(KeywordFunctionCall object)
      {
        return createKeywordFunctionCallAdapter();
      }
      @Override
      public Adapter caseFunctionArgumentList(FunctionArgumentList object)
      {
        return createFunctionArgumentListAdapter();
      }
      @Override
      public Adapter caseNamedArgument(NamedArgument object)
      {
        return createNamedArgumentAdapter();
      }
      @Override
      public Adapter caseComponentReference(ComponentReference object)
      {
        return createComponentReferenceAdapter();
      }
      @Override
      public Adapter caseComponentReferenceSegment(ComponentReferenceSegment object)
      {
        return createComponentReferenceSegmentAdapter();
      }
      @Override
      public Adapter caseArraySubscriptList(ArraySubscriptList object)
      {
        return createArraySubscriptListAdapter();
      }
      @Override
      public Adapter caseSubscript(Subscript object)
      {
        return createSubscriptAdapter();
      }
      @Override
      public Adapter caseColonSubscript(ColonSubscript object)
      {
        return createColonSubscriptAdapter();
      }
      @Override
      public Adapter caseExpressionSubscript(ExpressionSubscript object)
      {
        return createExpressionSubscriptAdapter();
      }
      @Override
      public Adapter caseArrayConcatenationOperator(ArrayConcatenationOperator object)
      {
        return createArrayConcatenationOperatorAdapter();
      }
      @Override
      public Adapter caseArrayConstructionOperator(ArrayConstructionOperator object)
      {
        return createArrayConstructionOperatorAdapter();
      }
      @Override
      public Adapter caseExpressionList(ExpressionList object)
      {
        return createExpressionListAdapter();
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
      public Adapter caseLogicalNotExpression(LogicalNotExpression object)
      {
        return createLogicalNotExpressionAdapter();
      }
      @Override
      public Adapter caseRelationalExpression(RelationalExpression object)
      {
        return createRelationalExpressionAdapter();
      }
      @Override
      public Adapter caseAddSubtractExpression(AddSubtractExpression object)
      {
        return createAddSubtractExpressionAdapter();
      }
      @Override
      public Adapter caseMultiplyDivideExpression(MultiplyDivideExpression object)
      {
        return createMultiplyDivideExpressionAdapter();
      }
      @Override
      public Adapter casePowerExpression(PowerExpression object)
      {
        return createPowerExpressionAdapter();
      }
      @Override
      public Adapter caseUnaryMinusExpression(UnaryMinusExpression object)
      {
        return createUnaryMinusExpressionAdapter();
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
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.Mscript <em>Mscript</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.Mscript
   * @generated
   */
  public Adapter createMscriptAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.PackageDefinition <em>Package Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.PackageDefinition
   * @generated
   */
  public Adapter createPackageDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.PackageDefinitionElement <em>Package Definition Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.PackageDefinitionElement
   * @generated
   */
  public Adapter createPackageDefinitionElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.EnumerationDefinition <em>Enumeration Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.EnumerationDefinition
   * @generated
   */
  public Adapter createEnumerationDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.EnumerationLiteralDefinition <em>Enumeration Literal Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.EnumerationLiteralDefinition
   * @generated
   */
  public Adapter createEnumerationLiteralDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.Expression
   * @generated
   */
  public Adapter createExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.ConditionalExpression <em>Conditional Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.ConditionalExpression
   * @generated
   */
  public Adapter createConditionalExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.ConditionalExpressionCase <em>Conditional Expression Case</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.ConditionalExpressionCase
   * @generated
   */
  public Adapter createConditionalExpressionCaseAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.Literal <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.Literal
   * @generated
   */
  public Adapter createLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.NumericalLiteral <em>Numerical Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.NumericalLiteral
   * @generated
   */
  public Adapter createNumericalLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.RealLiteral <em>Real Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.RealLiteral
   * @generated
   */
  public Adapter createRealLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.IntegerLiteral <em>Integer Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.IntegerLiteral
   * @generated
   */
  public Adapter createIntegerLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.BooleanLiteral <em>Boolean Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.BooleanLiteral
   * @generated
   */
  public Adapter createBooleanLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.StringLiteral <em>String Literal</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.StringLiteral
   * @generated
   */
  public Adapter createStringLiteralAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.FunctionCall <em>Function Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.FunctionCall
   * @generated
   */
  public Adapter createFunctionCallAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.NamedFunctionCall <em>Named Function Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.NamedFunctionCall
   * @generated
   */
  public Adapter createNamedFunctionCallAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.Name <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.Name
   * @generated
   */
  public Adapter createNameAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.KeywordFunctionCall <em>Keyword Function Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.KeywordFunctionCall
   * @generated
   */
  public Adapter createKeywordFunctionCallAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.FunctionArgumentList <em>Function Argument List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.FunctionArgumentList
   * @generated
   */
  public Adapter createFunctionArgumentListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.NamedArgument <em>Named Argument</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.NamedArgument
   * @generated
   */
  public Adapter createNamedArgumentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.ComponentReference <em>Component Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.ComponentReference
   * @generated
   */
  public Adapter createComponentReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.ComponentReferenceSegment <em>Component Reference Segment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.ComponentReferenceSegment
   * @generated
   */
  public Adapter createComponentReferenceSegmentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.ArraySubscriptList <em>Array Subscript List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.ArraySubscriptList
   * @generated
   */
  public Adapter createArraySubscriptListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.Subscript <em>Subscript</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.Subscript
   * @generated
   */
  public Adapter createSubscriptAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.ColonSubscript <em>Colon Subscript</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.ColonSubscript
   * @generated
   */
  public Adapter createColonSubscriptAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.ExpressionSubscript <em>Expression Subscript</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.ExpressionSubscript
   * @generated
   */
  public Adapter createExpressionSubscriptAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.ArrayConcatenationOperator <em>Array Concatenation Operator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.ArrayConcatenationOperator
   * @generated
   */
  public Adapter createArrayConcatenationOperatorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.ArrayConstructionOperator <em>Array Construction Operator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.ArrayConstructionOperator
   * @generated
   */
  public Adapter createArrayConstructionOperatorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.ExpressionList <em>Expression List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.ExpressionList
   * @generated
   */
  public Adapter createExpressionListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.ParenthesizedExpression <em>Parenthesized Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.ParenthesizedExpression
   * @generated
   */
  public Adapter createParenthesizedExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.BeginExpression <em>Begin Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.BeginExpression
   * @generated
   */
  public Adapter createBeginExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.EndExpression <em>End Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.EndExpression
   * @generated
   */
  public Adapter createEndExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.UnitExpression <em>Unit Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.UnitExpression
   * @generated
   */
  public Adapter createUnitExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.UnitExpressionNumerator <em>Unit Expression Numerator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.UnitExpressionNumerator
   * @generated
   */
  public Adapter createUnitExpressionNumeratorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.UnitExpressionDenominator <em>Unit Expression Denominator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.UnitExpressionDenominator
   * @generated
   */
  public Adapter createUnitExpressionDenominatorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.UnitExpressionFactor <em>Unit Expression Factor</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.UnitExpressionFactor
   * @generated
   */
  public Adapter createUnitExpressionFactorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.UnitExpressionExponent <em>Unit Expression Exponent</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.UnitExpressionExponent
   * @generated
   */
  public Adapter createUnitExpressionExponentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.RangeExpression <em>Range Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.RangeExpression
   * @generated
   */
  public Adapter createRangeExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.LogicalOrExpression <em>Logical Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.LogicalOrExpression
   * @generated
   */
  public Adapter createLogicalOrExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.LogicalAndExpression <em>Logical And Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.LogicalAndExpression
   * @generated
   */
  public Adapter createLogicalAndExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.LogicalNotExpression <em>Logical Not Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.LogicalNotExpression
   * @generated
   */
  public Adapter createLogicalNotExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.RelationalExpression <em>Relational Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.RelationalExpression
   * @generated
   */
  public Adapter createRelationalExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.AddSubtractExpression <em>Add Subtract Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.AddSubtractExpression
   * @generated
   */
  public Adapter createAddSubtractExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.MultiplyDivideExpression <em>Multiply Divide Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.MultiplyDivideExpression
   * @generated
   */
  public Adapter createMultiplyDivideExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.PowerExpression <em>Power Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.PowerExpression
   * @generated
   */
  public Adapter createPowerExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.scripting.mscript.UnaryMinusExpression <em>Unary Minus Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.eclipselabs.damos.scripting.mscript.UnaryMinusExpression
   * @generated
   */
  public Adapter createUnaryMinusExpressionAdapter()
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

} //MscriptAdapterFactory
