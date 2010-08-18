/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.damos.scripting.mscript.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipselabs.damos.scripting.mscript.AddSubtractExpression;
import org.eclipselabs.damos.scripting.mscript.AddSubtractOperator;
import org.eclipselabs.damos.scripting.mscript.ArrayConcatenationOperator;
import org.eclipselabs.damos.scripting.mscript.ArrayConstructionOperator;
import org.eclipselabs.damos.scripting.mscript.ArraySubscriptList;
import org.eclipselabs.damos.scripting.mscript.BeginExpression;
import org.eclipselabs.damos.scripting.mscript.BooleanKind;
import org.eclipselabs.damos.scripting.mscript.BooleanLiteral;
import org.eclipselabs.damos.scripting.mscript.ColonSubscript;
import org.eclipselabs.damos.scripting.mscript.ComponentReference;
import org.eclipselabs.damos.scripting.mscript.ComponentReferenceSegment;
import org.eclipselabs.damos.scripting.mscript.ConditionalExpression;
import org.eclipselabs.damos.scripting.mscript.ConditionalExpressionCase;
import org.eclipselabs.damos.scripting.mscript.EndExpression;
import org.eclipselabs.damos.scripting.mscript.EnumerationDefinition;
import org.eclipselabs.damos.scripting.mscript.EnumerationLiteralDefinition;
import org.eclipselabs.damos.scripting.mscript.Expression;
import org.eclipselabs.damos.scripting.mscript.ExpressionList;
import org.eclipselabs.damos.scripting.mscript.ExpressionSubscript;
import org.eclipselabs.damos.scripting.mscript.FunctionArgumentList;
import org.eclipselabs.damos.scripting.mscript.FunctionCall;
import org.eclipselabs.damos.scripting.mscript.IntegerLiteral;
import org.eclipselabs.damos.scripting.mscript.KeywordFunctionCall;
import org.eclipselabs.damos.scripting.mscript.Literal;
import org.eclipselabs.damos.scripting.mscript.LogicalAndExpression;
import org.eclipselabs.damos.scripting.mscript.LogicalNotExpression;
import org.eclipselabs.damos.scripting.mscript.LogicalOrExpression;
import org.eclipselabs.damos.scripting.mscript.Model;
import org.eclipselabs.damos.scripting.mscript.Mscript;
import org.eclipselabs.damos.scripting.mscript.MscriptFactory;
import org.eclipselabs.damos.scripting.mscript.MscriptPackage;
import org.eclipselabs.damos.scripting.mscript.MultiplyDivideExpression;
import org.eclipselabs.damos.scripting.mscript.MultiplyDivideOperator;
import org.eclipselabs.damos.scripting.mscript.Name;
import org.eclipselabs.damos.scripting.mscript.NamedArgument;
import org.eclipselabs.damos.scripting.mscript.NamedFunctionCall;
import org.eclipselabs.damos.scripting.mscript.NumericalLiteral;
import org.eclipselabs.damos.scripting.mscript.PackageDefinition;
import org.eclipselabs.damos.scripting.mscript.PackageDefinitionElement;
import org.eclipselabs.damos.scripting.mscript.ParenthesizedExpression;
import org.eclipselabs.damos.scripting.mscript.PowerExpression;
import org.eclipselabs.damos.scripting.mscript.PowerOperator;
import org.eclipselabs.damos.scripting.mscript.RangeExpression;
import org.eclipselabs.damos.scripting.mscript.RealLiteral;
import org.eclipselabs.damos.scripting.mscript.RelationalExpression;
import org.eclipselabs.damos.scripting.mscript.RelationalOperator;
import org.eclipselabs.damos.scripting.mscript.StringLiteral;
import org.eclipselabs.damos.scripting.mscript.Subscript;
import org.eclipselabs.damos.scripting.mscript.UnaryMinusExpression;
import org.eclipselabs.damos.scripting.mscript.UnitExpression;
import org.eclipselabs.damos.scripting.mscript.UnitExpressionDenominator;
import org.eclipselabs.damos.scripting.mscript.UnitExpressionExponent;
import org.eclipselabs.damos.scripting.mscript.UnitExpressionFactor;
import org.eclipselabs.damos.scripting.mscript.UnitExpressionNumerator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MscriptPackageImpl extends EPackageImpl implements MscriptPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mscriptEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass packageDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass packageDefinitionElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumerationDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumerationLiteralDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass conditionalExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass conditionalExpressionCaseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass literalEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass numericalLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass realLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass integerLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass booleanLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stringLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass functionCallEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass namedFunctionCallEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nameEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass keywordFunctionCallEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass functionArgumentListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass namedArgumentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass componentReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass componentReferenceSegmentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass arraySubscriptListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass subscriptEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass colonSubscriptEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionSubscriptEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass arrayConcatenationOperatorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass arrayConstructionOperatorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parenthesizedExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass beginExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass endExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unitExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unitExpressionNumeratorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unitExpressionDenominatorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unitExpressionFactorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unitExpressionExponentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rangeExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass logicalOrExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass logicalAndExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass logicalNotExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass relationalExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass addSubtractExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass multiplyDivideExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass powerExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unaryMinusExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum relationalOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum addSubtractOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum multiplyDivideOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum powerOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum booleanKindEEnum = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private MscriptPackageImpl()
  {
    super(eNS_URI, MscriptFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link MscriptPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static MscriptPackage init()
  {
    if (isInited) return (MscriptPackage)EPackage.Registry.INSTANCE.getEPackage(MscriptPackage.eNS_URI);

    // Obtain or create and register package
    MscriptPackageImpl theMscriptPackage = (MscriptPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MscriptPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MscriptPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theMscriptPackage.createPackageContents();

    // Initialize created meta-data
    theMscriptPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theMscriptPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(MscriptPackage.eNS_URI, theMscriptPackage);
    return theMscriptPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModel()
  {
    return modelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMscript()
  {
    return mscriptEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMscript_Packages()
  {
    return (EReference)mscriptEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPackageDefinition()
  {
    return packageDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPackageDefinition_Name()
  {
    return (EReference)packageDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPackageDefinition_Elements()
  {
    return (EReference)packageDefinitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPackageDefinitionElement()
  {
    return packageDefinitionElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnumerationDefinition()
  {
    return enumerationDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEnumerationDefinition_Name()
  {
    return (EAttribute)enumerationDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnumerationDefinition_Literals()
  {
    return (EReference)enumerationDefinitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnumerationLiteralDefinition()
  {
    return enumerationLiteralDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEnumerationLiteralDefinition_Name()
  {
    return (EAttribute)enumerationLiteralDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpression()
  {
    return expressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConditionalExpression()
  {
    return conditionalExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalExpression_Cases()
  {
    return (EReference)conditionalExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalExpression_ElseExpression()
  {
    return (EReference)conditionalExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConditionalExpressionCase()
  {
    return conditionalExpressionCaseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalExpressionCase_ConditionExpression()
  {
    return (EReference)conditionalExpressionCaseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalExpressionCase_ThenExpression()
  {
    return (EReference)conditionalExpressionCaseEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLiteral()
  {
    return literalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNumericalLiteral()
  {
    return numericalLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNumericalLiteral_Unit()
  {
    return (EReference)numericalLiteralEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRealLiteral()
  {
    return realLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRealLiteral_Value()
  {
    return (EAttribute)realLiteralEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIntegerLiteral()
  {
    return integerLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIntegerLiteral_Value()
  {
    return (EAttribute)integerLiteralEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBooleanLiteral()
  {
    return booleanLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBooleanLiteral_Value()
  {
    return (EAttribute)booleanLiteralEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStringLiteral()
  {
    return stringLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStringLiteral_Value()
  {
    return (EAttribute)stringLiteralEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFunctionCall()
  {
    return functionCallEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunctionCall_ArgumentList()
  {
    return (EReference)functionCallEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNamedFunctionCall()
  {
    return namedFunctionCallEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNamedFunctionCall_Name()
  {
    return (EReference)namedFunctionCallEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getName_()
  {
    return nameEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getName_Global()
  {
    return (EAttribute)nameEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getName_Identifiers()
  {
    return (EAttribute)nameEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getKeywordFunctionCall()
  {
    return keywordFunctionCallEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getKeywordFunctionCall_Name()
  {
    return (EAttribute)keywordFunctionCallEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFunctionArgumentList()
  {
    return functionArgumentListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunctionArgumentList_Arguments()
  {
    return (EReference)functionArgumentListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunctionArgumentList_NamedArguments()
  {
    return (EReference)functionArgumentListEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNamedArgument()
  {
    return namedArgumentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNamedArgument_Identifier()
  {
    return (EAttribute)namedArgumentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNamedArgument_Expression()
  {
    return (EReference)namedArgumentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getComponentReference()
  {
    return componentReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getComponentReference_Global()
  {
    return (EAttribute)componentReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComponentReference_Segments()
  {
    return (EReference)componentReferenceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getComponentReferenceSegment()
  {
    return componentReferenceSegmentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getComponentReferenceSegment_Identifier()
  {
    return (EAttribute)componentReferenceSegmentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getComponentReferenceSegment_SubscriptList()
  {
    return (EReference)componentReferenceSegmentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getArraySubscriptList()
  {
    return arraySubscriptListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getArraySubscriptList_Subscripts()
  {
    return (EReference)arraySubscriptListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSubscript()
  {
    return subscriptEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getColonSubscript()
  {
    return colonSubscriptEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpressionSubscript()
  {
    return expressionSubscriptEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpressionSubscript_Expression()
  {
    return (EReference)expressionSubscriptEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getArrayConcatenationOperator()
  {
    return arrayConcatenationOperatorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getArrayConcatenationOperator_ExpressionLists()
  {
    return (EReference)arrayConcatenationOperatorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getArrayConstructionOperator()
  {
    return arrayConstructionOperatorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getArrayConstructionOperator_ArgumentList()
  {
    return (EReference)arrayConstructionOperatorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpressionList()
  {
    return expressionListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpressionList_Expressions()
  {
    return (EReference)expressionListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParenthesizedExpression()
  {
    return parenthesizedExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParenthesizedExpression_Expression()
  {
    return (EReference)parenthesizedExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBeginExpression()
  {
    return beginExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEndExpression()
  {
    return endExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnitExpression()
  {
    return unitExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnitExpression_Numerator()
  {
    return (EReference)unitExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnitExpression_Denominator()
  {
    return (EReference)unitExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnitExpressionNumerator()
  {
    return unitExpressionNumeratorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnitExpressionNumerator_One()
  {
    return (EAttribute)unitExpressionNumeratorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnitExpressionNumerator_Factors()
  {
    return (EReference)unitExpressionNumeratorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnitExpressionDenominator()
  {
    return unitExpressionDenominatorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnitExpressionDenominator_Factors()
  {
    return (EReference)unitExpressionDenominatorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnitExpressionFactor()
  {
    return unitExpressionFactorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnitExpressionFactor_Operand()
  {
    return (EAttribute)unitExpressionFactorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnitExpressionFactor_Exponent()
  {
    return (EReference)unitExpressionFactorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnitExpressionExponent()
  {
    return unitExpressionExponentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnitExpressionExponent_Negative()
  {
    return (EAttribute)unitExpressionExponentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getUnitExpressionExponent_Value()
  {
    return (EAttribute)unitExpressionExponentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRangeExpression()
  {
    return rangeExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRangeExpression_Expressions()
  {
    return (EReference)rangeExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLogicalOrExpression()
  {
    return logicalOrExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLogicalOrExpression_Operands()
  {
    return (EReference)logicalOrExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLogicalAndExpression()
  {
    return logicalAndExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLogicalAndExpression_Operands()
  {
    return (EReference)logicalAndExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLogicalNotExpression()
  {
    return logicalNotExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLogicalNotExpression_Operand()
  {
    return (EReference)logicalNotExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRelationalExpression()
  {
    return relationalExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRelationalExpression_Operands()
  {
    return (EReference)relationalExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRelationalExpression_Operators()
  {
    return (EAttribute)relationalExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAddSubtractExpression()
  {
    return addSubtractExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAddSubtractExpression_Operands()
  {
    return (EReference)addSubtractExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAddSubtractExpression_Operators()
  {
    return (EAttribute)addSubtractExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMultiplyDivideExpression()
  {
    return multiplyDivideExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMultiplyDivideExpression_Operands()
  {
    return (EReference)multiplyDivideExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMultiplyDivideExpression_Operators()
  {
    return (EAttribute)multiplyDivideExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPowerExpression()
  {
    return powerExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPowerExpression_Operands()
  {
    return (EReference)powerExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPowerExpression_Operator()
  {
    return (EAttribute)powerExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPowerExpression_Exponent()
  {
    return (EReference)powerExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnaryMinusExpression()
  {
    return unaryMinusExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnaryMinusExpression_Operand()
  {
    return (EReference)unaryMinusExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getRelationalOperator()
  {
    return relationalOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getAddSubtractOperator()
  {
    return addSubtractOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getMultiplyDivideOperator()
  {
    return multiplyDivideOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getPowerOperator()
  {
    return powerOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getBooleanKind()
  {
    return booleanKindEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MscriptFactory getMscriptFactory()
  {
    return (MscriptFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    modelEClass = createEClass(MODEL);

    mscriptEClass = createEClass(MSCRIPT);
    createEReference(mscriptEClass, MSCRIPT__PACKAGES);

    packageDefinitionEClass = createEClass(PACKAGE_DEFINITION);
    createEReference(packageDefinitionEClass, PACKAGE_DEFINITION__NAME);
    createEReference(packageDefinitionEClass, PACKAGE_DEFINITION__ELEMENTS);

    packageDefinitionElementEClass = createEClass(PACKAGE_DEFINITION_ELEMENT);

    enumerationDefinitionEClass = createEClass(ENUMERATION_DEFINITION);
    createEAttribute(enumerationDefinitionEClass, ENUMERATION_DEFINITION__NAME);
    createEReference(enumerationDefinitionEClass, ENUMERATION_DEFINITION__LITERALS);

    enumerationLiteralDefinitionEClass = createEClass(ENUMERATION_LITERAL_DEFINITION);
    createEAttribute(enumerationLiteralDefinitionEClass, ENUMERATION_LITERAL_DEFINITION__NAME);

    expressionEClass = createEClass(EXPRESSION);

    conditionalExpressionEClass = createEClass(CONDITIONAL_EXPRESSION);
    createEReference(conditionalExpressionEClass, CONDITIONAL_EXPRESSION__CASES);
    createEReference(conditionalExpressionEClass, CONDITIONAL_EXPRESSION__ELSE_EXPRESSION);

    conditionalExpressionCaseEClass = createEClass(CONDITIONAL_EXPRESSION_CASE);
    createEReference(conditionalExpressionCaseEClass, CONDITIONAL_EXPRESSION_CASE__CONDITION_EXPRESSION);
    createEReference(conditionalExpressionCaseEClass, CONDITIONAL_EXPRESSION_CASE__THEN_EXPRESSION);

    literalEClass = createEClass(LITERAL);

    numericalLiteralEClass = createEClass(NUMERICAL_LITERAL);
    createEReference(numericalLiteralEClass, NUMERICAL_LITERAL__UNIT);

    realLiteralEClass = createEClass(REAL_LITERAL);
    createEAttribute(realLiteralEClass, REAL_LITERAL__VALUE);

    integerLiteralEClass = createEClass(INTEGER_LITERAL);
    createEAttribute(integerLiteralEClass, INTEGER_LITERAL__VALUE);

    booleanLiteralEClass = createEClass(BOOLEAN_LITERAL);
    createEAttribute(booleanLiteralEClass, BOOLEAN_LITERAL__VALUE);

    stringLiteralEClass = createEClass(STRING_LITERAL);
    createEAttribute(stringLiteralEClass, STRING_LITERAL__VALUE);

    functionCallEClass = createEClass(FUNCTION_CALL);
    createEReference(functionCallEClass, FUNCTION_CALL__ARGUMENT_LIST);

    namedFunctionCallEClass = createEClass(NAMED_FUNCTION_CALL);
    createEReference(namedFunctionCallEClass, NAMED_FUNCTION_CALL__NAME);

    nameEClass = createEClass(NAME);
    createEAttribute(nameEClass, NAME__GLOBAL);
    createEAttribute(nameEClass, NAME__IDENTIFIERS);

    keywordFunctionCallEClass = createEClass(KEYWORD_FUNCTION_CALL);
    createEAttribute(keywordFunctionCallEClass, KEYWORD_FUNCTION_CALL__NAME);

    functionArgumentListEClass = createEClass(FUNCTION_ARGUMENT_LIST);
    createEReference(functionArgumentListEClass, FUNCTION_ARGUMENT_LIST__ARGUMENTS);
    createEReference(functionArgumentListEClass, FUNCTION_ARGUMENT_LIST__NAMED_ARGUMENTS);

    namedArgumentEClass = createEClass(NAMED_ARGUMENT);
    createEAttribute(namedArgumentEClass, NAMED_ARGUMENT__IDENTIFIER);
    createEReference(namedArgumentEClass, NAMED_ARGUMENT__EXPRESSION);

    componentReferenceEClass = createEClass(COMPONENT_REFERENCE);
    createEAttribute(componentReferenceEClass, COMPONENT_REFERENCE__GLOBAL);
    createEReference(componentReferenceEClass, COMPONENT_REFERENCE__SEGMENTS);

    componentReferenceSegmentEClass = createEClass(COMPONENT_REFERENCE_SEGMENT);
    createEAttribute(componentReferenceSegmentEClass, COMPONENT_REFERENCE_SEGMENT__IDENTIFIER);
    createEReference(componentReferenceSegmentEClass, COMPONENT_REFERENCE_SEGMENT__SUBSCRIPT_LIST);

    arraySubscriptListEClass = createEClass(ARRAY_SUBSCRIPT_LIST);
    createEReference(arraySubscriptListEClass, ARRAY_SUBSCRIPT_LIST__SUBSCRIPTS);

    subscriptEClass = createEClass(SUBSCRIPT);

    colonSubscriptEClass = createEClass(COLON_SUBSCRIPT);

    expressionSubscriptEClass = createEClass(EXPRESSION_SUBSCRIPT);
    createEReference(expressionSubscriptEClass, EXPRESSION_SUBSCRIPT__EXPRESSION);

    arrayConcatenationOperatorEClass = createEClass(ARRAY_CONCATENATION_OPERATOR);
    createEReference(arrayConcatenationOperatorEClass, ARRAY_CONCATENATION_OPERATOR__EXPRESSION_LISTS);

    arrayConstructionOperatorEClass = createEClass(ARRAY_CONSTRUCTION_OPERATOR);
    createEReference(arrayConstructionOperatorEClass, ARRAY_CONSTRUCTION_OPERATOR__ARGUMENT_LIST);

    expressionListEClass = createEClass(EXPRESSION_LIST);
    createEReference(expressionListEClass, EXPRESSION_LIST__EXPRESSIONS);

    parenthesizedExpressionEClass = createEClass(PARENTHESIZED_EXPRESSION);
    createEReference(parenthesizedExpressionEClass, PARENTHESIZED_EXPRESSION__EXPRESSION);

    beginExpressionEClass = createEClass(BEGIN_EXPRESSION);

    endExpressionEClass = createEClass(END_EXPRESSION);

    unitExpressionEClass = createEClass(UNIT_EXPRESSION);
    createEReference(unitExpressionEClass, UNIT_EXPRESSION__NUMERATOR);
    createEReference(unitExpressionEClass, UNIT_EXPRESSION__DENOMINATOR);

    unitExpressionNumeratorEClass = createEClass(UNIT_EXPRESSION_NUMERATOR);
    createEAttribute(unitExpressionNumeratorEClass, UNIT_EXPRESSION_NUMERATOR__ONE);
    createEReference(unitExpressionNumeratorEClass, UNIT_EXPRESSION_NUMERATOR__FACTORS);

    unitExpressionDenominatorEClass = createEClass(UNIT_EXPRESSION_DENOMINATOR);
    createEReference(unitExpressionDenominatorEClass, UNIT_EXPRESSION_DENOMINATOR__FACTORS);

    unitExpressionFactorEClass = createEClass(UNIT_EXPRESSION_FACTOR);
    createEAttribute(unitExpressionFactorEClass, UNIT_EXPRESSION_FACTOR__OPERAND);
    createEReference(unitExpressionFactorEClass, UNIT_EXPRESSION_FACTOR__EXPONENT);

    unitExpressionExponentEClass = createEClass(UNIT_EXPRESSION_EXPONENT);
    createEAttribute(unitExpressionExponentEClass, UNIT_EXPRESSION_EXPONENT__NEGATIVE);
    createEAttribute(unitExpressionExponentEClass, UNIT_EXPRESSION_EXPONENT__VALUE);

    rangeExpressionEClass = createEClass(RANGE_EXPRESSION);
    createEReference(rangeExpressionEClass, RANGE_EXPRESSION__EXPRESSIONS);

    logicalOrExpressionEClass = createEClass(LOGICAL_OR_EXPRESSION);
    createEReference(logicalOrExpressionEClass, LOGICAL_OR_EXPRESSION__OPERANDS);

    logicalAndExpressionEClass = createEClass(LOGICAL_AND_EXPRESSION);
    createEReference(logicalAndExpressionEClass, LOGICAL_AND_EXPRESSION__OPERANDS);

    logicalNotExpressionEClass = createEClass(LOGICAL_NOT_EXPRESSION);
    createEReference(logicalNotExpressionEClass, LOGICAL_NOT_EXPRESSION__OPERAND);

    relationalExpressionEClass = createEClass(RELATIONAL_EXPRESSION);
    createEReference(relationalExpressionEClass, RELATIONAL_EXPRESSION__OPERANDS);
    createEAttribute(relationalExpressionEClass, RELATIONAL_EXPRESSION__OPERATORS);

    addSubtractExpressionEClass = createEClass(ADD_SUBTRACT_EXPRESSION);
    createEReference(addSubtractExpressionEClass, ADD_SUBTRACT_EXPRESSION__OPERANDS);
    createEAttribute(addSubtractExpressionEClass, ADD_SUBTRACT_EXPRESSION__OPERATORS);

    multiplyDivideExpressionEClass = createEClass(MULTIPLY_DIVIDE_EXPRESSION);
    createEReference(multiplyDivideExpressionEClass, MULTIPLY_DIVIDE_EXPRESSION__OPERANDS);
    createEAttribute(multiplyDivideExpressionEClass, MULTIPLY_DIVIDE_EXPRESSION__OPERATORS);

    powerExpressionEClass = createEClass(POWER_EXPRESSION);
    createEReference(powerExpressionEClass, POWER_EXPRESSION__OPERANDS);
    createEAttribute(powerExpressionEClass, POWER_EXPRESSION__OPERATOR);
    createEReference(powerExpressionEClass, POWER_EXPRESSION__EXPONENT);

    unaryMinusExpressionEClass = createEClass(UNARY_MINUS_EXPRESSION);
    createEReference(unaryMinusExpressionEClass, UNARY_MINUS_EXPRESSION__OPERAND);

    // Create enums
    relationalOperatorEEnum = createEEnum(RELATIONAL_OPERATOR);
    addSubtractOperatorEEnum = createEEnum(ADD_SUBTRACT_OPERATOR);
    multiplyDivideOperatorEEnum = createEEnum(MULTIPLY_DIVIDE_OPERATOR);
    powerOperatorEEnum = createEEnum(POWER_OPERATOR);
    booleanKindEEnum = createEEnum(BOOLEAN_KIND);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    packageDefinitionEClass.getESuperTypes().add(this.getPackageDefinitionElement());
    enumerationDefinitionEClass.getESuperTypes().add(this.getPackageDefinitionElement());
    expressionEClass.getESuperTypes().add(this.getModel());
    conditionalExpressionEClass.getESuperTypes().add(this.getExpression());
    literalEClass.getESuperTypes().add(this.getExpression());
    numericalLiteralEClass.getESuperTypes().add(this.getLiteral());
    realLiteralEClass.getESuperTypes().add(this.getNumericalLiteral());
    integerLiteralEClass.getESuperTypes().add(this.getNumericalLiteral());
    booleanLiteralEClass.getESuperTypes().add(this.getLiteral());
    stringLiteralEClass.getESuperTypes().add(this.getLiteral());
    functionCallEClass.getESuperTypes().add(this.getExpression());
    namedFunctionCallEClass.getESuperTypes().add(this.getFunctionCall());
    keywordFunctionCallEClass.getESuperTypes().add(this.getFunctionCall());
    componentReferenceEClass.getESuperTypes().add(this.getExpression());
    colonSubscriptEClass.getESuperTypes().add(this.getSubscript());
    expressionSubscriptEClass.getESuperTypes().add(this.getSubscript());
    arrayConcatenationOperatorEClass.getESuperTypes().add(this.getExpression());
    arrayConstructionOperatorEClass.getESuperTypes().add(this.getExpression());
    parenthesizedExpressionEClass.getESuperTypes().add(this.getExpression());
    beginExpressionEClass.getESuperTypes().add(this.getExpression());
    endExpressionEClass.getESuperTypes().add(this.getExpression());
    rangeExpressionEClass.getESuperTypes().add(this.getExpression());
    logicalOrExpressionEClass.getESuperTypes().add(this.getExpression());
    logicalAndExpressionEClass.getESuperTypes().add(this.getExpression());
    logicalNotExpressionEClass.getESuperTypes().add(this.getExpression());
    relationalExpressionEClass.getESuperTypes().add(this.getExpression());
    addSubtractExpressionEClass.getESuperTypes().add(this.getExpression());
    multiplyDivideExpressionEClass.getESuperTypes().add(this.getExpression());
    powerExpressionEClass.getESuperTypes().add(this.getExpression());
    unaryMinusExpressionEClass.getESuperTypes().add(this.getExpression());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(mscriptEClass, Mscript.class, "Mscript", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMscript_Packages(), this.getPackageDefinition(), null, "packages", null, 0, -1, Mscript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(packageDefinitionEClass, PackageDefinition.class, "PackageDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPackageDefinition_Name(), this.getName_(), null, "name", null, 0, 1, PackageDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPackageDefinition_Elements(), this.getPackageDefinitionElement(), null, "elements", null, 0, -1, PackageDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(packageDefinitionElementEClass, PackageDefinitionElement.class, "PackageDefinitionElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(enumerationDefinitionEClass, EnumerationDefinition.class, "EnumerationDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEnumerationDefinition_Name(), ecorePackage.getEString(), "name", null, 0, 1, EnumerationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEnumerationDefinition_Literals(), this.getEnumerationLiteralDefinition(), null, "literals", null, 0, -1, EnumerationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(enumerationLiteralDefinitionEClass, EnumerationLiteralDefinition.class, "EnumerationLiteralDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEnumerationLiteralDefinition_Name(), ecorePackage.getEString(), "name", null, 0, 1, EnumerationLiteralDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(conditionalExpressionEClass, ConditionalExpression.class, "ConditionalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConditionalExpression_Cases(), this.getConditionalExpressionCase(), null, "cases", null, 0, -1, ConditionalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConditionalExpression_ElseExpression(), this.getExpression(), null, "elseExpression", null, 0, 1, ConditionalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(conditionalExpressionCaseEClass, ConditionalExpressionCase.class, "ConditionalExpressionCase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConditionalExpressionCase_ConditionExpression(), this.getExpression(), null, "conditionExpression", null, 0, 1, ConditionalExpressionCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConditionalExpressionCase_ThenExpression(), this.getExpression(), null, "thenExpression", null, 0, 1, ConditionalExpressionCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(literalEClass, Literal.class, "Literal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(numericalLiteralEClass, NumericalLiteral.class, "NumericalLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNumericalLiteral_Unit(), this.getUnitExpression(), null, "unit", null, 0, 1, NumericalLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(realLiteralEClass, RealLiteral.class, "RealLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRealLiteral_Value(), ecorePackage.getEDouble(), "value", null, 0, 1, RealLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(integerLiteralEClass, IntegerLiteral.class, "IntegerLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIntegerLiteral_Value(), ecorePackage.getELong(), "value", null, 0, 1, IntegerLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(booleanLiteralEClass, BooleanLiteral.class, "BooleanLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBooleanLiteral_Value(), this.getBooleanKind(), "value", null, 0, 1, BooleanLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stringLiteralEClass, StringLiteral.class, "StringLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStringLiteral_Value(), ecorePackage.getEString(), "value", null, 0, 1, StringLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(functionCallEClass, FunctionCall.class, "FunctionCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFunctionCall_ArgumentList(), this.getFunctionArgumentList(), null, "argumentList", null, 0, 1, FunctionCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(namedFunctionCallEClass, NamedFunctionCall.class, "NamedFunctionCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNamedFunctionCall_Name(), this.getName_(), null, "name", null, 0, 1, NamedFunctionCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nameEClass, Name.class, "Name", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getName_Global(), ecorePackage.getEBoolean(), "global", null, 0, 1, Name.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getName_Identifiers(), ecorePackage.getEString(), "identifiers", null, 0, -1, Name.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(keywordFunctionCallEClass, KeywordFunctionCall.class, "KeywordFunctionCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getKeywordFunctionCall_Name(), ecorePackage.getEString(), "name", null, 0, 1, KeywordFunctionCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(functionArgumentListEClass, FunctionArgumentList.class, "FunctionArgumentList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFunctionArgumentList_Arguments(), this.getExpression(), null, "arguments", null, 0, -1, FunctionArgumentList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFunctionArgumentList_NamedArguments(), this.getNamedArgument(), null, "namedArguments", null, 0, -1, FunctionArgumentList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(namedArgumentEClass, NamedArgument.class, "NamedArgument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNamedArgument_Identifier(), ecorePackage.getEString(), "identifier", null, 0, 1, NamedArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNamedArgument_Expression(), this.getExpression(), null, "expression", null, 0, 1, NamedArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(componentReferenceEClass, ComponentReference.class, "ComponentReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getComponentReference_Global(), ecorePackage.getEBoolean(), "global", null, 0, 1, ComponentReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getComponentReference_Segments(), this.getComponentReferenceSegment(), null, "segments", null, 0, -1, ComponentReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(componentReferenceSegmentEClass, ComponentReferenceSegment.class, "ComponentReferenceSegment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getComponentReferenceSegment_Identifier(), ecorePackage.getEString(), "identifier", null, 0, 1, ComponentReferenceSegment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getComponentReferenceSegment_SubscriptList(), this.getArraySubscriptList(), null, "subscriptList", null, 0, 1, ComponentReferenceSegment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(arraySubscriptListEClass, ArraySubscriptList.class, "ArraySubscriptList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getArraySubscriptList_Subscripts(), this.getSubscript(), null, "subscripts", null, 0, -1, ArraySubscriptList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(subscriptEClass, Subscript.class, "Subscript", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(colonSubscriptEClass, ColonSubscript.class, "ColonSubscript", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(expressionSubscriptEClass, ExpressionSubscript.class, "ExpressionSubscript", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExpressionSubscript_Expression(), this.getExpression(), null, "expression", null, 0, 1, ExpressionSubscript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(arrayConcatenationOperatorEClass, ArrayConcatenationOperator.class, "ArrayConcatenationOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getArrayConcatenationOperator_ExpressionLists(), this.getExpressionList(), null, "expressionLists", null, 0, -1, ArrayConcatenationOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(arrayConstructionOperatorEClass, ArrayConstructionOperator.class, "ArrayConstructionOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getArrayConstructionOperator_ArgumentList(), this.getFunctionArgumentList(), null, "argumentList", null, 0, 1, ArrayConstructionOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expressionListEClass, ExpressionList.class, "ExpressionList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExpressionList_Expressions(), this.getExpression(), null, "expressions", null, 0, -1, ExpressionList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(parenthesizedExpressionEClass, ParenthesizedExpression.class, "ParenthesizedExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getParenthesizedExpression_Expression(), this.getExpression(), null, "expression", null, 0, 1, ParenthesizedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(beginExpressionEClass, BeginExpression.class, "BeginExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(endExpressionEClass, EndExpression.class, "EndExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(unitExpressionEClass, UnitExpression.class, "UnitExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUnitExpression_Numerator(), this.getUnitExpressionNumerator(), null, "numerator", null, 0, 1, UnitExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUnitExpression_Denominator(), this.getUnitExpressionDenominator(), null, "denominator", null, 0, 1, UnitExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unitExpressionNumeratorEClass, UnitExpressionNumerator.class, "UnitExpressionNumerator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUnitExpressionNumerator_One(), ecorePackage.getELong(), "one", null, 0, 1, UnitExpressionNumerator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUnitExpressionNumerator_Factors(), this.getUnitExpressionFactor(), null, "factors", null, 0, -1, UnitExpressionNumerator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unitExpressionDenominatorEClass, UnitExpressionDenominator.class, "UnitExpressionDenominator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUnitExpressionDenominator_Factors(), this.getUnitExpressionFactor(), null, "factors", null, 0, -1, UnitExpressionDenominator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unitExpressionFactorEClass, UnitExpressionFactor.class, "UnitExpressionFactor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUnitExpressionFactor_Operand(), ecorePackage.getEString(), "operand", null, 0, 1, UnitExpressionFactor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUnitExpressionFactor_Exponent(), this.getUnitExpressionExponent(), null, "exponent", null, 0, 1, UnitExpressionFactor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unitExpressionExponentEClass, UnitExpressionExponent.class, "UnitExpressionExponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUnitExpressionExponent_Negative(), ecorePackage.getEBoolean(), "negative", null, 0, 1, UnitExpressionExponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getUnitExpressionExponent_Value(), ecorePackage.getELong(), "value", null, 0, 1, UnitExpressionExponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(rangeExpressionEClass, RangeExpression.class, "RangeExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRangeExpression_Expressions(), this.getExpression(), null, "expressions", null, 0, -1, RangeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(logicalOrExpressionEClass, LogicalOrExpression.class, "LogicalOrExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLogicalOrExpression_Operands(), this.getExpression(), null, "operands", null, 0, -1, LogicalOrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(logicalAndExpressionEClass, LogicalAndExpression.class, "LogicalAndExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLogicalAndExpression_Operands(), this.getExpression(), null, "operands", null, 0, -1, LogicalAndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(logicalNotExpressionEClass, LogicalNotExpression.class, "LogicalNotExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLogicalNotExpression_Operand(), this.getExpression(), null, "operand", null, 0, 1, LogicalNotExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(relationalExpressionEClass, RelationalExpression.class, "RelationalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRelationalExpression_Operands(), this.getExpression(), null, "operands", null, 0, -1, RelationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRelationalExpression_Operators(), this.getRelationalOperator(), "operators", null, 0, -1, RelationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(addSubtractExpressionEClass, AddSubtractExpression.class, "AddSubtractExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAddSubtractExpression_Operands(), this.getExpression(), null, "operands", null, 0, -1, AddSubtractExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAddSubtractExpression_Operators(), this.getAddSubtractOperator(), "operators", null, 0, -1, AddSubtractExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(multiplyDivideExpressionEClass, MultiplyDivideExpression.class, "MultiplyDivideExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMultiplyDivideExpression_Operands(), this.getExpression(), null, "operands", null, 0, -1, MultiplyDivideExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMultiplyDivideExpression_Operators(), this.getMultiplyDivideOperator(), "operators", null, 0, -1, MultiplyDivideExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(powerExpressionEClass, PowerExpression.class, "PowerExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPowerExpression_Operands(), this.getExpression(), null, "operands", null, 0, -1, PowerExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPowerExpression_Operator(), this.getPowerOperator(), "operator", null, 0, 1, PowerExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPowerExpression_Exponent(), this.getExpression(), null, "exponent", null, 0, 1, PowerExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unaryMinusExpressionEClass, UnaryMinusExpression.class, "UnaryMinusExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUnaryMinusExpression_Operand(), this.getExpression(), null, "operand", null, 0, 1, UnaryMinusExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(relationalOperatorEEnum, RelationalOperator.class, "RelationalOperator");
    addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.LESS_THAN);
    addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.LESS_THAN_OR_EQUAL_TO);
    addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.GREATER_THAN);
    addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.GREATER_THAN_OR_EQUAL_TO);
    addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.EQUAL_TO);
    addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.NOT_EQUAL_TO);

    initEEnum(addSubtractOperatorEEnum, AddSubtractOperator.class, "AddSubtractOperator");
    addEEnumLiteral(addSubtractOperatorEEnum, AddSubtractOperator.ADD);
    addEEnumLiteral(addSubtractOperatorEEnum, AddSubtractOperator.SUBTRACT);
    addEEnumLiteral(addSubtractOperatorEEnum, AddSubtractOperator.ELEMENT_WISE_ADD);
    addEEnumLiteral(addSubtractOperatorEEnum, AddSubtractOperator.ELEMENT_WISE_SUBTRACT);

    initEEnum(multiplyDivideOperatorEEnum, MultiplyDivideOperator.class, "MultiplyDivideOperator");
    addEEnumLiteral(multiplyDivideOperatorEEnum, MultiplyDivideOperator.MULTIPLY);
    addEEnumLiteral(multiplyDivideOperatorEEnum, MultiplyDivideOperator.DIVIDE);
    addEEnumLiteral(multiplyDivideOperatorEEnum, MultiplyDivideOperator.ELEMENT_WISE_MULTIPLY);
    addEEnumLiteral(multiplyDivideOperatorEEnum, MultiplyDivideOperator.ELEMENT_WISE_DIVIDE);

    initEEnum(powerOperatorEEnum, PowerOperator.class, "PowerOperator");
    addEEnumLiteral(powerOperatorEEnum, PowerOperator.POWER);
    addEEnumLiteral(powerOperatorEEnum, PowerOperator.ELEMENT_WISE_POWER);

    initEEnum(booleanKindEEnum, BooleanKind.class, "BooleanKind");
    addEEnumLiteral(booleanKindEEnum, BooleanKind.FALSE);
    addEEnumLiteral(booleanKindEEnum, BooleanKind.TRUE);

    // Create resource
    createResource(eNS_URI);
  }

} //MscriptPackageImpl
