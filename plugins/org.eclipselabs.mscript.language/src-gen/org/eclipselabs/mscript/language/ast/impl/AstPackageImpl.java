/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipselabs.mscript.language.ast.AddSubtractExpression;
import org.eclipselabs.mscript.language.ast.AddSubtractOperator;
import org.eclipselabs.mscript.language.ast.ArrayDimensionSpecification;
import org.eclipselabs.mscript.language.ast.ArrayElementReference;
import org.eclipselabs.mscript.language.ast.AstFactory;
import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.BeginExpression;
import org.eclipselabs.mscript.language.ast.Block;
import org.eclipselabs.mscript.language.ast.BooleanKind;
import org.eclipselabs.mscript.language.ast.BooleanLiteral;
import org.eclipselabs.mscript.language.ast.BooleanTypeSpecifier;
import org.eclipselabs.mscript.language.ast.ColonSubscript;
import org.eclipselabs.mscript.language.ast.ComplexTypeSpecifier;
import org.eclipselabs.mscript.language.ast.ConditionalExpression;
import org.eclipselabs.mscript.language.ast.ConditionalExpressionCase;
import org.eclipselabs.mscript.language.ast.DataTypeSpecifier;
import org.eclipselabs.mscript.language.ast.DoWhileStatement;
import org.eclipselabs.mscript.language.ast.EndExpression;
import org.eclipselabs.mscript.language.ast.EnumerationDefinition;
import org.eclipselabs.mscript.language.ast.EnumerationLiteralDeclaration;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.ExpressionList;
import org.eclipselabs.mscript.language.ast.ExpressionSubscript;
import org.eclipselabs.mscript.language.ast.FeatureCall;
import org.eclipselabs.mscript.language.ast.FeatureCallPart;
import org.eclipselabs.mscript.language.ast.FeatureCallStatement;
import org.eclipselabs.mscript.language.ast.FeatureReference;
import org.eclipselabs.mscript.language.ast.ForeachStatement;
import org.eclipselabs.mscript.language.ast.FunctionDefinition;
import org.eclipselabs.mscript.language.ast.GaussianTypeSpecifier;
import org.eclipselabs.mscript.language.ast.IfCase;
import org.eclipselabs.mscript.language.ast.IfStatement;
import org.eclipselabs.mscript.language.ast.IntegerLiteral;
import org.eclipselabs.mscript.language.ast.IntegerTypeSpecifier;
import org.eclipselabs.mscript.language.ast.Literal;
import org.eclipselabs.mscript.language.ast.LogicalAndExpression;
import org.eclipselabs.mscript.language.ast.LogicalNotExpression;
import org.eclipselabs.mscript.language.ast.LogicalOrExpression;
import org.eclipselabs.mscript.language.ast.MatrixConstructionOperator;
import org.eclipselabs.mscript.language.ast.Mscript;
import org.eclipselabs.mscript.language.ast.MultiplyDivideExpression;
import org.eclipselabs.mscript.language.ast.MultiplyDivideOperator;
import org.eclipselabs.mscript.language.ast.NamedTypeSpecifier;
import org.eclipselabs.mscript.language.ast.NumericalLiteral;
import org.eclipselabs.mscript.language.ast.NumericalTypeSpecifier;
import org.eclipselabs.mscript.language.ast.OperationCall;
import org.eclipselabs.mscript.language.ast.PackageDefinition;
import org.eclipselabs.mscript.language.ast.PackageDefinitionElement;
import org.eclipselabs.mscript.language.ast.ParameterDeclaration;
import org.eclipselabs.mscript.language.ast.ParenthesizedExpression;
import org.eclipselabs.mscript.language.ast.PowerExpression;
import org.eclipselabs.mscript.language.ast.PowerOperator;
import org.eclipselabs.mscript.language.ast.PrimitiveTypeSpecifier;
import org.eclipselabs.mscript.language.ast.QualifiedName;
import org.eclipselabs.mscript.language.ast.RangeExpression;
import org.eclipselabs.mscript.language.ast.RealLiteral;
import org.eclipselabs.mscript.language.ast.RealTypeSpecifier;
import org.eclipselabs.mscript.language.ast.RecordDefinition;
import org.eclipselabs.mscript.language.ast.RecordFieldDeclaration;
import org.eclipselabs.mscript.language.ast.RecordFieldDeclarationItem;
import org.eclipselabs.mscript.language.ast.RelationalExpression;
import org.eclipselabs.mscript.language.ast.RelationalOperator;
import org.eclipselabs.mscript.language.ast.ReturnStatement;
import org.eclipselabs.mscript.language.ast.Statement;
import org.eclipselabs.mscript.language.ast.StringLiteral;
import org.eclipselabs.mscript.language.ast.StringTypeSpecifier;
import org.eclipselabs.mscript.language.ast.Subscript;
import org.eclipselabs.mscript.language.ast.SymbolReference;
import org.eclipselabs.mscript.language.ast.TypeDefinition;
import org.eclipselabs.mscript.language.ast.TypeSpecifier;
import org.eclipselabs.mscript.language.ast.UnaryMinusExpression;
import org.eclipselabs.mscript.language.ast.UnitConstructionOperator;
import org.eclipselabs.mscript.language.ast.UnitExpression;
import org.eclipselabs.mscript.language.ast.UnitExpressionDenominator;
import org.eclipselabs.mscript.language.ast.UnitExpressionExponent;
import org.eclipselabs.mscript.language.ast.UnitExpressionFactor;
import org.eclipselabs.mscript.language.ast.UnitExpressionNumerator;
import org.eclipselabs.mscript.language.ast.UnitTypeSpecifier;
import org.eclipselabs.mscript.language.ast.VariableDeclaration;
import org.eclipselabs.mscript.language.ast.VariableDeclarationItem;
import org.eclipselabs.mscript.language.ast.VariableModifier;
import org.eclipselabs.mscript.language.ast.WhileStatement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AstPackageImpl extends EPackageImpl implements AstPackage
{
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
  private EClass enumerationLiteralDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass recordDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass recordFieldDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass recordFieldDeclarationItemEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass functionDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parameterDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass statementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass blockEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass featureCallStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ifStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ifCaseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass whileStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass doWhileStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass foreachStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variableDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variableModifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variableDeclarationItemEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass returnStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeSpecifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dataTypeSpecifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass primitiveTypeSpecifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass numericalTypeSpecifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass realTypeSpecifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass integerTypeSpecifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass complexTypeSpecifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass gaussianTypeSpecifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass booleanTypeSpecifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stringTypeSpecifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass namedTypeSpecifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass arrayDimensionSpecificationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unitTypeSpecifierEClass = null;

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
  private EClass featureCallPartEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass featureReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass arrayElementReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass operationCallEClass = null;

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
  private EClass qualifiedNameEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass symbolReferenceEClass = null;

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
  private EClass matrixConstructionOperatorEClass = null;

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
  private EClass unitConstructionOperatorEClass = null;

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
  private EClass featureCallEClass = null;

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
   * @see org.eclipselabs.mscript.language.ast.AstPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private AstPackageImpl()
  {
    super(eNS_URI, AstFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link AstPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static AstPackage init()
  {
    if (isInited) return (AstPackage)EPackage.Registry.INSTANCE.getEPackage(AstPackage.eNS_URI);

    // Obtain or create and register package
    AstPackageImpl theAstPackage = (AstPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AstPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AstPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theAstPackage.createPackageContents();

    // Initialize created meta-data
    theAstPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theAstPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(AstPackage.eNS_URI, theAstPackage);
    return theAstPackage;
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
  public EClass getEnumerationLiteralDeclaration()
  {
    return enumerationLiteralDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEnumerationLiteralDeclaration_Name()
  {
    return (EAttribute)enumerationLiteralDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRecordDefinition()
  {
    return recordDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRecordDefinition_Name()
  {
    return (EAttribute)recordDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRecordDefinition_Fields()
  {
    return (EReference)recordDefinitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRecordFieldDeclaration()
  {
    return recordFieldDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRecordFieldDeclaration_Type()
  {
    return (EReference)recordFieldDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRecordFieldDeclaration_Items()
  {
    return (EReference)recordFieldDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRecordFieldDeclarationItem()
  {
    return recordFieldDeclarationItemEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRecordFieldDeclarationItem_Name()
  {
    return (EAttribute)recordFieldDeclarationItemEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFunctionDefinition()
  {
    return functionDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFunctionDefinition_Static()
  {
    return (EAttribute)functionDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFunctionDefinition_Name()
  {
    return (EAttribute)functionDefinitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunctionDefinition_Parameters()
  {
    return (EReference)functionDefinitionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunctionDefinition_Body()
  {
    return (EReference)functionDefinitionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParameterDeclaration()
  {
    return parameterDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParameterDeclaration_Modifier()
  {
    return (EReference)parameterDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getParameterDeclaration_Reference()
  {
    return (EAttribute)parameterDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParameterDeclaration_Type()
  {
    return (EReference)parameterDeclarationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getParameterDeclaration_Name()
  {
    return (EAttribute)parameterDeclarationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStatement()
  {
    return statementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBlock()
  {
    return blockEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBlock_Statements()
  {
    return (EReference)blockEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFeatureCallStatement()
  {
    return featureCallStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFeatureCallStatement_FeatureCall()
  {
    return (EReference)featureCallStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFeatureCallStatement_Assignment()
  {
    return (EAttribute)featureCallStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFeatureCallStatement_Expression()
  {
    return (EReference)featureCallStatementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIfStatement()
  {
    return ifStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfStatement_Cases()
  {
    return (EReference)ifStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfStatement_ElseBody()
  {
    return (EReference)ifStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIfCase()
  {
    return ifCaseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfCase_Condition()
  {
    return (EReference)ifCaseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfCase_Body()
  {
    return (EReference)ifCaseEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getWhileStatement()
  {
    return whileStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWhileStatement_Predicate()
  {
    return (EReference)whileStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWhileStatement_Body()
  {
    return (EReference)whileStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDoWhileStatement()
  {
    return doWhileStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDoWhileStatement_Body()
  {
    return (EReference)doWhileStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDoWhileStatement_Predicate()
  {
    return (EReference)doWhileStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getForeachStatement()
  {
    return foreachStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getForeachStatement_ElementName()
  {
    return (EAttribute)foreachStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForeachStatement_CollectionExpression()
  {
    return (EReference)foreachStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForeachStatement_Body()
  {
    return (EReference)foreachStatementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariableDeclaration()
  {
    return variableDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariableDeclaration_Modifier()
  {
    return (EReference)variableDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariableDeclaration_Type()
  {
    return (EReference)variableDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariableDeclaration_Items()
  {
    return (EReference)variableDeclarationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariableModifier()
  {
    return variableModifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVariableModifier_Auto()
  {
    return (EAttribute)variableModifierEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVariableModifier_Constant()
  {
    return (EAttribute)variableModifierEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVariableModifier_Static()
  {
    return (EAttribute)variableModifierEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariableDeclarationItem()
  {
    return variableDeclarationItemEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVariableDeclarationItem_Name()
  {
    return (EAttribute)variableDeclarationItemEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariableDeclarationItem_InitialValue()
  {
    return (EReference)variableDeclarationItemEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeDefinition()
  {
    return typeDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeDefinition_Type()
  {
    return (EReference)typeDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeDefinition_Name()
  {
    return (EAttribute)typeDefinitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReturnStatement()
  {
    return returnStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReturnStatement_Value()
  {
    return (EReference)returnStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeSpecifier()
  {
    return typeSpecifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDataTypeSpecifier()
  {
    return dataTypeSpecifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDataTypeSpecifier_Dimensions()
  {
    return (EReference)dataTypeSpecifierEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPrimitiveTypeSpecifier()
  {
    return primitiveTypeSpecifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNumericalTypeSpecifier()
  {
    return numericalTypeSpecifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNumericalTypeSpecifier_Unit()
  {
    return (EReference)numericalTypeSpecifierEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRealTypeSpecifier()
  {
    return realTypeSpecifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIntegerTypeSpecifier()
  {
    return integerTypeSpecifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getComplexTypeSpecifier()
  {
    return complexTypeSpecifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGaussianTypeSpecifier()
  {
    return gaussianTypeSpecifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBooleanTypeSpecifier()
  {
    return booleanTypeSpecifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStringTypeSpecifier()
  {
    return stringTypeSpecifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNamedTypeSpecifier()
  {
    return namedTypeSpecifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNamedTypeSpecifier_TypeReference()
  {
    return (EReference)namedTypeSpecifierEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getArrayDimensionSpecification()
  {
    return arrayDimensionSpecificationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getArrayDimensionSpecification_Unspecified()
  {
    return (EAttribute)arrayDimensionSpecificationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getArrayDimensionSpecification_Size()
  {
    return (EReference)arrayDimensionSpecificationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getArrayDimensionSpecification_BeginIndex()
  {
    return (EReference)arrayDimensionSpecificationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getArrayDimensionSpecification_EndIndex()
  {
    return (EReference)arrayDimensionSpecificationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnitTypeSpecifier()
  {
    return unitTypeSpecifierEClass;
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
  public EClass getFeatureCallPart()
  {
    return featureCallPartEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFeatureReference()
  {
    return featureReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFeatureReference_FeatureName()
  {
    return (EAttribute)featureReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getArrayElementReference()
  {
    return arrayElementReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getArrayElementReference_Subscripts()
  {
    return (EReference)arrayElementReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOperationCall()
  {
    return operationCallEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperationCall_Arguments()
  {
    return (EReference)operationCallEClass.getEStructuralFeatures().get(0);
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
  public EAttribute getNumericalLiteral_Imaginary()
  {
    return (EAttribute)numericalLiteralEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNumericalLiteral_Unit()
  {
    return (EReference)numericalLiteralEClass.getEStructuralFeatures().get(1);
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
  public EClass getQualifiedName()
  {
    return qualifiedNameEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getQualifiedName_Identifiers()
  {
    return (EAttribute)qualifiedNameEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSymbolReference()
  {
    return symbolReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSymbolReference_Global()
  {
    return (EAttribute)symbolReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSymbolReference_Name()
  {
    return (EReference)symbolReferenceEClass.getEStructuralFeatures().get(1);
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
  public EClass getMatrixConstructionOperator()
  {
    return matrixConstructionOperatorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMatrixConstructionOperator_ExpressionLists()
  {
    return (EReference)matrixConstructionOperatorEClass.getEStructuralFeatures().get(0);
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
  public EClass getUnitConstructionOperator()
  {
    return unitConstructionOperatorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnitConstructionOperator_UnitExpression()
  {
    return (EReference)unitConstructionOperatorEClass.getEStructuralFeatures().get(0);
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
  public EAttribute getUnitExpression_Unspecified()
  {
    return (EAttribute)unitExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnitExpression_Expression()
  {
    return (EReference)unitExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnitExpression_Numerator()
  {
    return (EReference)unitExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnitExpression_Denominator()
  {
    return (EReference)unitExpressionEClass.getEStructuralFeatures().get(3);
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
  public EReference getRangeExpression_Begin()
  {
    return (EReference)rangeExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRangeExpression_End()
  {
    return (EReference)rangeExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRangeExpression_Increment()
  {
    return (EReference)rangeExpressionEClass.getEStructuralFeatures().get(2);
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
  public EReference getRelationalExpression_LeftOperand()
  {
    return (EReference)relationalExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRelationalExpression_TypeTest()
  {
    return (EAttribute)relationalExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRelationalExpression_Type()
  {
    return (EReference)relationalExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRelationalExpression_Operator()
  {
    return (EAttribute)relationalExpressionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRelationalExpression_RightOperand()
  {
    return (EReference)relationalExpressionEClass.getEStructuralFeatures().get(4);
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
  public EReference getPowerExpression_Operand()
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
  public EClass getFeatureCall()
  {
    return featureCallEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFeatureCall_Target()
  {
    return (EReference)featureCallEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFeatureCall_Parts()
  {
    return (EReference)featureCallEClass.getEStructuralFeatures().get(1);
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
  public AstFactory getAstFactory()
  {
    return (AstFactory)getEFactoryInstance();
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
    mscriptEClass = createEClass(MSCRIPT);
    createEReference(mscriptEClass, MSCRIPT__PACKAGES);

    packageDefinitionEClass = createEClass(PACKAGE_DEFINITION);
    createEReference(packageDefinitionEClass, PACKAGE_DEFINITION__NAME);
    createEReference(packageDefinitionEClass, PACKAGE_DEFINITION__ELEMENTS);

    packageDefinitionElementEClass = createEClass(PACKAGE_DEFINITION_ELEMENT);

    enumerationDefinitionEClass = createEClass(ENUMERATION_DEFINITION);
    createEAttribute(enumerationDefinitionEClass, ENUMERATION_DEFINITION__NAME);
    createEReference(enumerationDefinitionEClass, ENUMERATION_DEFINITION__LITERALS);

    enumerationLiteralDeclarationEClass = createEClass(ENUMERATION_LITERAL_DECLARATION);
    createEAttribute(enumerationLiteralDeclarationEClass, ENUMERATION_LITERAL_DECLARATION__NAME);

    recordDefinitionEClass = createEClass(RECORD_DEFINITION);
    createEAttribute(recordDefinitionEClass, RECORD_DEFINITION__NAME);
    createEReference(recordDefinitionEClass, RECORD_DEFINITION__FIELDS);

    recordFieldDeclarationEClass = createEClass(RECORD_FIELD_DECLARATION);
    createEReference(recordFieldDeclarationEClass, RECORD_FIELD_DECLARATION__TYPE);
    createEReference(recordFieldDeclarationEClass, RECORD_FIELD_DECLARATION__ITEMS);

    recordFieldDeclarationItemEClass = createEClass(RECORD_FIELD_DECLARATION_ITEM);
    createEAttribute(recordFieldDeclarationItemEClass, RECORD_FIELD_DECLARATION_ITEM__NAME);

    functionDefinitionEClass = createEClass(FUNCTION_DEFINITION);
    createEAttribute(functionDefinitionEClass, FUNCTION_DEFINITION__STATIC);
    createEAttribute(functionDefinitionEClass, FUNCTION_DEFINITION__NAME);
    createEReference(functionDefinitionEClass, FUNCTION_DEFINITION__PARAMETERS);
    createEReference(functionDefinitionEClass, FUNCTION_DEFINITION__BODY);

    parameterDeclarationEClass = createEClass(PARAMETER_DECLARATION);
    createEReference(parameterDeclarationEClass, PARAMETER_DECLARATION__MODIFIER);
    createEAttribute(parameterDeclarationEClass, PARAMETER_DECLARATION__REFERENCE);
    createEReference(parameterDeclarationEClass, PARAMETER_DECLARATION__TYPE);
    createEAttribute(parameterDeclarationEClass, PARAMETER_DECLARATION__NAME);

    statementEClass = createEClass(STATEMENT);

    blockEClass = createEClass(BLOCK);
    createEReference(blockEClass, BLOCK__STATEMENTS);

    featureCallStatementEClass = createEClass(FEATURE_CALL_STATEMENT);
    createEReference(featureCallStatementEClass, FEATURE_CALL_STATEMENT__FEATURE_CALL);
    createEAttribute(featureCallStatementEClass, FEATURE_CALL_STATEMENT__ASSIGNMENT);
    createEReference(featureCallStatementEClass, FEATURE_CALL_STATEMENT__EXPRESSION);

    ifStatementEClass = createEClass(IF_STATEMENT);
    createEReference(ifStatementEClass, IF_STATEMENT__CASES);
    createEReference(ifStatementEClass, IF_STATEMENT__ELSE_BODY);

    ifCaseEClass = createEClass(IF_CASE);
    createEReference(ifCaseEClass, IF_CASE__CONDITION);
    createEReference(ifCaseEClass, IF_CASE__BODY);

    whileStatementEClass = createEClass(WHILE_STATEMENT);
    createEReference(whileStatementEClass, WHILE_STATEMENT__PREDICATE);
    createEReference(whileStatementEClass, WHILE_STATEMENT__BODY);

    doWhileStatementEClass = createEClass(DO_WHILE_STATEMENT);
    createEReference(doWhileStatementEClass, DO_WHILE_STATEMENT__BODY);
    createEReference(doWhileStatementEClass, DO_WHILE_STATEMENT__PREDICATE);

    foreachStatementEClass = createEClass(FOREACH_STATEMENT);
    createEAttribute(foreachStatementEClass, FOREACH_STATEMENT__ELEMENT_NAME);
    createEReference(foreachStatementEClass, FOREACH_STATEMENT__COLLECTION_EXPRESSION);
    createEReference(foreachStatementEClass, FOREACH_STATEMENT__BODY);

    variableDeclarationEClass = createEClass(VARIABLE_DECLARATION);
    createEReference(variableDeclarationEClass, VARIABLE_DECLARATION__MODIFIER);
    createEReference(variableDeclarationEClass, VARIABLE_DECLARATION__TYPE);
    createEReference(variableDeclarationEClass, VARIABLE_DECLARATION__ITEMS);

    variableModifierEClass = createEClass(VARIABLE_MODIFIER);
    createEAttribute(variableModifierEClass, VARIABLE_MODIFIER__AUTO);
    createEAttribute(variableModifierEClass, VARIABLE_MODIFIER__CONSTANT);
    createEAttribute(variableModifierEClass, VARIABLE_MODIFIER__STATIC);

    variableDeclarationItemEClass = createEClass(VARIABLE_DECLARATION_ITEM);
    createEAttribute(variableDeclarationItemEClass, VARIABLE_DECLARATION_ITEM__NAME);
    createEReference(variableDeclarationItemEClass, VARIABLE_DECLARATION_ITEM__INITIAL_VALUE);

    typeDefinitionEClass = createEClass(TYPE_DEFINITION);
    createEReference(typeDefinitionEClass, TYPE_DEFINITION__TYPE);
    createEAttribute(typeDefinitionEClass, TYPE_DEFINITION__NAME);

    returnStatementEClass = createEClass(RETURN_STATEMENT);
    createEReference(returnStatementEClass, RETURN_STATEMENT__VALUE);

    typeSpecifierEClass = createEClass(TYPE_SPECIFIER);

    dataTypeSpecifierEClass = createEClass(DATA_TYPE_SPECIFIER);
    createEReference(dataTypeSpecifierEClass, DATA_TYPE_SPECIFIER__DIMENSIONS);

    primitiveTypeSpecifierEClass = createEClass(PRIMITIVE_TYPE_SPECIFIER);

    numericalTypeSpecifierEClass = createEClass(NUMERICAL_TYPE_SPECIFIER);
    createEReference(numericalTypeSpecifierEClass, NUMERICAL_TYPE_SPECIFIER__UNIT);

    realTypeSpecifierEClass = createEClass(REAL_TYPE_SPECIFIER);

    integerTypeSpecifierEClass = createEClass(INTEGER_TYPE_SPECIFIER);

    complexTypeSpecifierEClass = createEClass(COMPLEX_TYPE_SPECIFIER);

    gaussianTypeSpecifierEClass = createEClass(GAUSSIAN_TYPE_SPECIFIER);

    booleanTypeSpecifierEClass = createEClass(BOOLEAN_TYPE_SPECIFIER);

    stringTypeSpecifierEClass = createEClass(STRING_TYPE_SPECIFIER);

    namedTypeSpecifierEClass = createEClass(NAMED_TYPE_SPECIFIER);
    createEReference(namedTypeSpecifierEClass, NAMED_TYPE_SPECIFIER__TYPE_REFERENCE);

    arrayDimensionSpecificationEClass = createEClass(ARRAY_DIMENSION_SPECIFICATION);
    createEAttribute(arrayDimensionSpecificationEClass, ARRAY_DIMENSION_SPECIFICATION__UNSPECIFIED);
    createEReference(arrayDimensionSpecificationEClass, ARRAY_DIMENSION_SPECIFICATION__SIZE);
    createEReference(arrayDimensionSpecificationEClass, ARRAY_DIMENSION_SPECIFICATION__BEGIN_INDEX);
    createEReference(arrayDimensionSpecificationEClass, ARRAY_DIMENSION_SPECIFICATION__END_INDEX);

    unitTypeSpecifierEClass = createEClass(UNIT_TYPE_SPECIFIER);

    expressionEClass = createEClass(EXPRESSION);

    conditionalExpressionEClass = createEClass(CONDITIONAL_EXPRESSION);
    createEReference(conditionalExpressionEClass, CONDITIONAL_EXPRESSION__CASES);
    createEReference(conditionalExpressionEClass, CONDITIONAL_EXPRESSION__ELSE_EXPRESSION);

    conditionalExpressionCaseEClass = createEClass(CONDITIONAL_EXPRESSION_CASE);
    createEReference(conditionalExpressionCaseEClass, CONDITIONAL_EXPRESSION_CASE__CONDITION_EXPRESSION);
    createEReference(conditionalExpressionCaseEClass, CONDITIONAL_EXPRESSION_CASE__THEN_EXPRESSION);

    featureCallPartEClass = createEClass(FEATURE_CALL_PART);

    featureReferenceEClass = createEClass(FEATURE_REFERENCE);
    createEAttribute(featureReferenceEClass, FEATURE_REFERENCE__FEATURE_NAME);

    arrayElementReferenceEClass = createEClass(ARRAY_ELEMENT_REFERENCE);
    createEReference(arrayElementReferenceEClass, ARRAY_ELEMENT_REFERENCE__SUBSCRIPTS);

    operationCallEClass = createEClass(OPERATION_CALL);
    createEReference(operationCallEClass, OPERATION_CALL__ARGUMENTS);

    literalEClass = createEClass(LITERAL);

    numericalLiteralEClass = createEClass(NUMERICAL_LITERAL);
    createEAttribute(numericalLiteralEClass, NUMERICAL_LITERAL__IMAGINARY);
    createEReference(numericalLiteralEClass, NUMERICAL_LITERAL__UNIT);

    realLiteralEClass = createEClass(REAL_LITERAL);
    createEAttribute(realLiteralEClass, REAL_LITERAL__VALUE);

    integerLiteralEClass = createEClass(INTEGER_LITERAL);
    createEAttribute(integerLiteralEClass, INTEGER_LITERAL__VALUE);

    booleanLiteralEClass = createEClass(BOOLEAN_LITERAL);
    createEAttribute(booleanLiteralEClass, BOOLEAN_LITERAL__VALUE);

    stringLiteralEClass = createEClass(STRING_LITERAL);
    createEAttribute(stringLiteralEClass, STRING_LITERAL__VALUE);

    qualifiedNameEClass = createEClass(QUALIFIED_NAME);
    createEAttribute(qualifiedNameEClass, QUALIFIED_NAME__IDENTIFIERS);

    symbolReferenceEClass = createEClass(SYMBOL_REFERENCE);
    createEAttribute(symbolReferenceEClass, SYMBOL_REFERENCE__GLOBAL);
    createEReference(symbolReferenceEClass, SYMBOL_REFERENCE__NAME);

    subscriptEClass = createEClass(SUBSCRIPT);

    colonSubscriptEClass = createEClass(COLON_SUBSCRIPT);

    expressionSubscriptEClass = createEClass(EXPRESSION_SUBSCRIPT);
    createEReference(expressionSubscriptEClass, EXPRESSION_SUBSCRIPT__EXPRESSION);

    matrixConstructionOperatorEClass = createEClass(MATRIX_CONSTRUCTION_OPERATOR);
    createEReference(matrixConstructionOperatorEClass, MATRIX_CONSTRUCTION_OPERATOR__EXPRESSION_LISTS);

    expressionListEClass = createEClass(EXPRESSION_LIST);
    createEReference(expressionListEClass, EXPRESSION_LIST__EXPRESSIONS);

    unitConstructionOperatorEClass = createEClass(UNIT_CONSTRUCTION_OPERATOR);
    createEReference(unitConstructionOperatorEClass, UNIT_CONSTRUCTION_OPERATOR__UNIT_EXPRESSION);

    parenthesizedExpressionEClass = createEClass(PARENTHESIZED_EXPRESSION);
    createEReference(parenthesizedExpressionEClass, PARENTHESIZED_EXPRESSION__EXPRESSION);

    beginExpressionEClass = createEClass(BEGIN_EXPRESSION);

    endExpressionEClass = createEClass(END_EXPRESSION);

    unitExpressionEClass = createEClass(UNIT_EXPRESSION);
    createEAttribute(unitExpressionEClass, UNIT_EXPRESSION__UNSPECIFIED);
    createEReference(unitExpressionEClass, UNIT_EXPRESSION__EXPRESSION);
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
    createEReference(rangeExpressionEClass, RANGE_EXPRESSION__BEGIN);
    createEReference(rangeExpressionEClass, RANGE_EXPRESSION__END);
    createEReference(rangeExpressionEClass, RANGE_EXPRESSION__INCREMENT);

    logicalOrExpressionEClass = createEClass(LOGICAL_OR_EXPRESSION);
    createEReference(logicalOrExpressionEClass, LOGICAL_OR_EXPRESSION__OPERANDS);

    logicalAndExpressionEClass = createEClass(LOGICAL_AND_EXPRESSION);
    createEReference(logicalAndExpressionEClass, LOGICAL_AND_EXPRESSION__OPERANDS);

    logicalNotExpressionEClass = createEClass(LOGICAL_NOT_EXPRESSION);
    createEReference(logicalNotExpressionEClass, LOGICAL_NOT_EXPRESSION__OPERAND);

    relationalExpressionEClass = createEClass(RELATIONAL_EXPRESSION);
    createEReference(relationalExpressionEClass, RELATIONAL_EXPRESSION__LEFT_OPERAND);
    createEAttribute(relationalExpressionEClass, RELATIONAL_EXPRESSION__TYPE_TEST);
    createEReference(relationalExpressionEClass, RELATIONAL_EXPRESSION__TYPE);
    createEAttribute(relationalExpressionEClass, RELATIONAL_EXPRESSION__OPERATOR);
    createEReference(relationalExpressionEClass, RELATIONAL_EXPRESSION__RIGHT_OPERAND);

    addSubtractExpressionEClass = createEClass(ADD_SUBTRACT_EXPRESSION);
    createEReference(addSubtractExpressionEClass, ADD_SUBTRACT_EXPRESSION__OPERANDS);
    createEAttribute(addSubtractExpressionEClass, ADD_SUBTRACT_EXPRESSION__OPERATORS);

    multiplyDivideExpressionEClass = createEClass(MULTIPLY_DIVIDE_EXPRESSION);
    createEReference(multiplyDivideExpressionEClass, MULTIPLY_DIVIDE_EXPRESSION__OPERANDS);
    createEAttribute(multiplyDivideExpressionEClass, MULTIPLY_DIVIDE_EXPRESSION__OPERATORS);

    powerExpressionEClass = createEClass(POWER_EXPRESSION);
    createEReference(powerExpressionEClass, POWER_EXPRESSION__OPERAND);
    createEAttribute(powerExpressionEClass, POWER_EXPRESSION__OPERATOR);
    createEReference(powerExpressionEClass, POWER_EXPRESSION__EXPONENT);

    unaryMinusExpressionEClass = createEClass(UNARY_MINUS_EXPRESSION);
    createEReference(unaryMinusExpressionEClass, UNARY_MINUS_EXPRESSION__OPERAND);

    featureCallEClass = createEClass(FEATURE_CALL);
    createEReference(featureCallEClass, FEATURE_CALL__TARGET);
    createEReference(featureCallEClass, FEATURE_CALL__PARTS);

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
    recordDefinitionEClass.getESuperTypes().add(this.getPackageDefinitionElement());
    functionDefinitionEClass.getESuperTypes().add(this.getPackageDefinitionElement());
    blockEClass.getESuperTypes().add(this.getStatement());
    featureCallStatementEClass.getESuperTypes().add(this.getStatement());
    ifStatementEClass.getESuperTypes().add(this.getStatement());
    whileStatementEClass.getESuperTypes().add(this.getStatement());
    doWhileStatementEClass.getESuperTypes().add(this.getStatement());
    foreachStatementEClass.getESuperTypes().add(this.getStatement());
    variableDeclarationEClass.getESuperTypes().add(this.getPackageDefinitionElement());
    variableDeclarationEClass.getESuperTypes().add(this.getStatement());
    typeDefinitionEClass.getESuperTypes().add(this.getPackageDefinitionElement());
    typeDefinitionEClass.getESuperTypes().add(this.getStatement());
    returnStatementEClass.getESuperTypes().add(this.getStatement());
    dataTypeSpecifierEClass.getESuperTypes().add(this.getTypeSpecifier());
    primitiveTypeSpecifierEClass.getESuperTypes().add(this.getDataTypeSpecifier());
    numericalTypeSpecifierEClass.getESuperTypes().add(this.getPrimitiveTypeSpecifier());
    realTypeSpecifierEClass.getESuperTypes().add(this.getNumericalTypeSpecifier());
    integerTypeSpecifierEClass.getESuperTypes().add(this.getNumericalTypeSpecifier());
    complexTypeSpecifierEClass.getESuperTypes().add(this.getNumericalTypeSpecifier());
    gaussianTypeSpecifierEClass.getESuperTypes().add(this.getNumericalTypeSpecifier());
    booleanTypeSpecifierEClass.getESuperTypes().add(this.getPrimitiveTypeSpecifier());
    stringTypeSpecifierEClass.getESuperTypes().add(this.getPrimitiveTypeSpecifier());
    namedTypeSpecifierEClass.getESuperTypes().add(this.getDataTypeSpecifier());
    unitTypeSpecifierEClass.getESuperTypes().add(this.getTypeSpecifier());
    conditionalExpressionEClass.getESuperTypes().add(this.getExpression());
    featureReferenceEClass.getESuperTypes().add(this.getFeatureCallPart());
    arrayElementReferenceEClass.getESuperTypes().add(this.getFeatureCallPart());
    operationCallEClass.getESuperTypes().add(this.getFeatureCallPart());
    literalEClass.getESuperTypes().add(this.getExpression());
    numericalLiteralEClass.getESuperTypes().add(this.getLiteral());
    realLiteralEClass.getESuperTypes().add(this.getNumericalLiteral());
    integerLiteralEClass.getESuperTypes().add(this.getNumericalLiteral());
    booleanLiteralEClass.getESuperTypes().add(this.getLiteral());
    stringLiteralEClass.getESuperTypes().add(this.getLiteral());
    symbolReferenceEClass.getESuperTypes().add(this.getExpression());
    colonSubscriptEClass.getESuperTypes().add(this.getSubscript());
    expressionSubscriptEClass.getESuperTypes().add(this.getSubscript());
    matrixConstructionOperatorEClass.getESuperTypes().add(this.getExpression());
    unitConstructionOperatorEClass.getESuperTypes().add(this.getExpression());
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
    featureCallEClass.getESuperTypes().add(this.getExpression());

    // Initialize classes and features; add operations and parameters
    initEClass(mscriptEClass, Mscript.class, "Mscript", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMscript_Packages(), this.getPackageDefinition(), null, "packages", null, 0, -1, Mscript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(packageDefinitionEClass, PackageDefinition.class, "PackageDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPackageDefinition_Name(), this.getQualifiedName(), null, "name", null, 0, 1, PackageDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPackageDefinition_Elements(), this.getPackageDefinitionElement(), null, "elements", null, 0, -1, PackageDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(packageDefinitionElementEClass, PackageDefinitionElement.class, "PackageDefinitionElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(enumerationDefinitionEClass, EnumerationDefinition.class, "EnumerationDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEnumerationDefinition_Name(), ecorePackage.getEString(), "name", null, 0, 1, EnumerationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEnumerationDefinition_Literals(), this.getEnumerationLiteralDeclaration(), null, "literals", null, 0, -1, EnumerationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(enumerationLiteralDeclarationEClass, EnumerationLiteralDeclaration.class, "EnumerationLiteralDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEnumerationLiteralDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, EnumerationLiteralDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(recordDefinitionEClass, RecordDefinition.class, "RecordDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRecordDefinition_Name(), ecorePackage.getEString(), "name", null, 0, 1, RecordDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRecordDefinition_Fields(), this.getRecordFieldDeclaration(), null, "fields", null, 0, -1, RecordDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(recordFieldDeclarationEClass, RecordFieldDeclaration.class, "RecordFieldDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRecordFieldDeclaration_Type(), this.getDataTypeSpecifier(), null, "type", null, 0, 1, RecordFieldDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRecordFieldDeclaration_Items(), this.getRecordFieldDeclarationItem(), null, "items", null, 0, -1, RecordFieldDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(recordFieldDeclarationItemEClass, RecordFieldDeclarationItem.class, "RecordFieldDeclarationItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRecordFieldDeclarationItem_Name(), ecorePackage.getEString(), "name", null, 0, 1, RecordFieldDeclarationItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(functionDefinitionEClass, FunctionDefinition.class, "FunctionDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFunctionDefinition_Static(), ecorePackage.getEBoolean(), "static", null, 0, 1, FunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFunctionDefinition_Name(), ecorePackage.getEString(), "name", null, 0, 1, FunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFunctionDefinition_Parameters(), this.getParameterDeclaration(), null, "parameters", null, 0, -1, FunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFunctionDefinition_Body(), this.getBlock(), null, "body", null, 0, 1, FunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(parameterDeclarationEClass, ParameterDeclaration.class, "ParameterDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getParameterDeclaration_Modifier(), this.getVariableModifier(), null, "modifier", null, 0, 1, ParameterDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getParameterDeclaration_Reference(), ecorePackage.getEBoolean(), "reference", null, 0, 1, ParameterDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getParameterDeclaration_Type(), this.getTypeSpecifier(), null, "type", null, 0, 1, ParameterDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getParameterDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, ParameterDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(statementEClass, Statement.class, "Statement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(blockEClass, Block.class, "Block", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBlock_Statements(), this.getStatement(), null, "statements", null, 0, -1, Block.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(featureCallStatementEClass, FeatureCallStatement.class, "FeatureCallStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFeatureCallStatement_FeatureCall(), this.getExpression(), null, "featureCall", null, 0, 1, FeatureCallStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFeatureCallStatement_Assignment(), ecorePackage.getEBoolean(), "assignment", null, 0, 1, FeatureCallStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFeatureCallStatement_Expression(), this.getExpression(), null, "expression", null, 0, 1, FeatureCallStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ifStatementEClass, IfStatement.class, "IfStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIfStatement_Cases(), this.getIfCase(), null, "cases", null, 0, -1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIfStatement_ElseBody(), this.getBlock(), null, "elseBody", null, 0, 1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ifCaseEClass, IfCase.class, "IfCase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIfCase_Condition(), this.getExpression(), null, "condition", null, 0, 1, IfCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIfCase_Body(), this.getBlock(), null, "body", null, 0, 1, IfCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(whileStatementEClass, WhileStatement.class, "WhileStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getWhileStatement_Predicate(), this.getExpression(), null, "predicate", null, 0, 1, WhileStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getWhileStatement_Body(), this.getBlock(), null, "body", null, 0, 1, WhileStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(doWhileStatementEClass, DoWhileStatement.class, "DoWhileStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDoWhileStatement_Body(), this.getBlock(), null, "body", null, 0, 1, DoWhileStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDoWhileStatement_Predicate(), this.getExpression(), null, "predicate", null, 0, 1, DoWhileStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(foreachStatementEClass, ForeachStatement.class, "ForeachStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getForeachStatement_ElementName(), ecorePackage.getEString(), "elementName", null, 0, 1, ForeachStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getForeachStatement_CollectionExpression(), this.getExpression(), null, "collectionExpression", null, 0, 1, ForeachStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getForeachStatement_Body(), this.getBlock(), null, "body", null, 0, 1, ForeachStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(variableDeclarationEClass, VariableDeclaration.class, "VariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVariableDeclaration_Modifier(), this.getVariableModifier(), null, "modifier", null, 0, 1, VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVariableDeclaration_Type(), this.getTypeSpecifier(), null, "type", null, 0, 1, VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVariableDeclaration_Items(), this.getVariableDeclarationItem(), null, "items", null, 0, -1, VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(variableModifierEClass, VariableModifier.class, "VariableModifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVariableModifier_Auto(), ecorePackage.getEString(), "Auto", null, 0, 1, VariableModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVariableModifier_Constant(), ecorePackage.getEString(), "Constant", null, 0, 1, VariableModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVariableModifier_Static(), ecorePackage.getEString(), "Static", null, 0, 1, VariableModifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(variableDeclarationItemEClass, VariableDeclarationItem.class, "VariableDeclarationItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVariableDeclarationItem_Name(), ecorePackage.getEString(), "name", null, 0, 1, VariableDeclarationItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVariableDeclarationItem_InitialValue(), this.getExpression(), null, "initialValue", null, 0, 1, VariableDeclarationItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeDefinitionEClass, TypeDefinition.class, "TypeDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTypeDefinition_Type(), this.getDataTypeSpecifier(), null, "type", null, 0, 1, TypeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTypeDefinition_Name(), ecorePackage.getEString(), "name", null, 0, 1, TypeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(returnStatementEClass, ReturnStatement.class, "ReturnStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getReturnStatement_Value(), this.getExpression(), null, "value", null, 0, 1, ReturnStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeSpecifierEClass, TypeSpecifier.class, "TypeSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(dataTypeSpecifierEClass, DataTypeSpecifier.class, "DataTypeSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDataTypeSpecifier_Dimensions(), this.getArrayDimensionSpecification(), null, "dimensions", null, 0, -1, DataTypeSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(primitiveTypeSpecifierEClass, PrimitiveTypeSpecifier.class, "PrimitiveTypeSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(numericalTypeSpecifierEClass, NumericalTypeSpecifier.class, "NumericalTypeSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNumericalTypeSpecifier_Unit(), this.getUnitExpression(), null, "unit", null, 0, 1, NumericalTypeSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(realTypeSpecifierEClass, RealTypeSpecifier.class, "RealTypeSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(integerTypeSpecifierEClass, IntegerTypeSpecifier.class, "IntegerTypeSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(complexTypeSpecifierEClass, ComplexTypeSpecifier.class, "ComplexTypeSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(gaussianTypeSpecifierEClass, GaussianTypeSpecifier.class, "GaussianTypeSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(booleanTypeSpecifierEClass, BooleanTypeSpecifier.class, "BooleanTypeSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(stringTypeSpecifierEClass, StringTypeSpecifier.class, "StringTypeSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(namedTypeSpecifierEClass, NamedTypeSpecifier.class, "NamedTypeSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNamedTypeSpecifier_TypeReference(), this.getSymbolReference(), null, "typeReference", null, 0, 1, NamedTypeSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(arrayDimensionSpecificationEClass, ArrayDimensionSpecification.class, "ArrayDimensionSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getArrayDimensionSpecification_Unspecified(), ecorePackage.getEBoolean(), "unspecified", null, 0, 1, ArrayDimensionSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getArrayDimensionSpecification_Size(), this.getExpression(), null, "size", null, 0, 1, ArrayDimensionSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getArrayDimensionSpecification_BeginIndex(), this.getArrayDimensionSpecification(), null, "beginIndex", null, 0, 1, ArrayDimensionSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getArrayDimensionSpecification_EndIndex(), this.getExpression(), null, "endIndex", null, 0, 1, ArrayDimensionSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unitTypeSpecifierEClass, UnitTypeSpecifier.class, "UnitTypeSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(conditionalExpressionEClass, ConditionalExpression.class, "ConditionalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConditionalExpression_Cases(), this.getConditionalExpressionCase(), null, "cases", null, 0, -1, ConditionalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConditionalExpression_ElseExpression(), this.getExpression(), null, "elseExpression", null, 0, 1, ConditionalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(conditionalExpressionCaseEClass, ConditionalExpressionCase.class, "ConditionalExpressionCase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConditionalExpressionCase_ConditionExpression(), this.getExpression(), null, "conditionExpression", null, 0, 1, ConditionalExpressionCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConditionalExpressionCase_ThenExpression(), this.getExpression(), null, "thenExpression", null, 0, 1, ConditionalExpressionCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(featureCallPartEClass, FeatureCallPart.class, "FeatureCallPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(featureReferenceEClass, FeatureReference.class, "FeatureReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFeatureReference_FeatureName(), ecorePackage.getEString(), "featureName", null, 0, 1, FeatureReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(arrayElementReferenceEClass, ArrayElementReference.class, "ArrayElementReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getArrayElementReference_Subscripts(), this.getSubscript(), null, "subscripts", null, 0, -1, ArrayElementReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(operationCallEClass, OperationCall.class, "OperationCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOperationCall_Arguments(), this.getExpression(), null, "arguments", null, 0, -1, OperationCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(literalEClass, Literal.class, "Literal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(numericalLiteralEClass, NumericalLiteral.class, "NumericalLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNumericalLiteral_Imaginary(), ecorePackage.getEBoolean(), "imaginary", null, 0, 1, NumericalLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNumericalLiteral_Unit(), this.getUnitExpression(), null, "unit", null, 0, 1, NumericalLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(realLiteralEClass, RealLiteral.class, "RealLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRealLiteral_Value(), ecorePackage.getEDouble(), "value", null, 0, 1, RealLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(integerLiteralEClass, IntegerLiteral.class, "IntegerLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIntegerLiteral_Value(), ecorePackage.getELong(), "value", null, 0, 1, IntegerLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(booleanLiteralEClass, BooleanLiteral.class, "BooleanLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBooleanLiteral_Value(), this.getBooleanKind(), "value", null, 0, 1, BooleanLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stringLiteralEClass, StringLiteral.class, "StringLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStringLiteral_Value(), ecorePackage.getEString(), "value", null, 0, 1, StringLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(qualifiedNameEClass, QualifiedName.class, "QualifiedName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getQualifiedName_Identifiers(), ecorePackage.getEString(), "identifiers", null, 0, -1, QualifiedName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(symbolReferenceEClass, SymbolReference.class, "SymbolReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSymbolReference_Global(), ecorePackage.getEBoolean(), "global", null, 0, 1, SymbolReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSymbolReference_Name(), this.getQualifiedName(), null, "name", null, 0, 1, SymbolReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(subscriptEClass, Subscript.class, "Subscript", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(colonSubscriptEClass, ColonSubscript.class, "ColonSubscript", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(expressionSubscriptEClass, ExpressionSubscript.class, "ExpressionSubscript", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExpressionSubscript_Expression(), this.getExpression(), null, "expression", null, 0, 1, ExpressionSubscript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(matrixConstructionOperatorEClass, MatrixConstructionOperator.class, "MatrixConstructionOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMatrixConstructionOperator_ExpressionLists(), this.getExpressionList(), null, "expressionLists", null, 0, -1, MatrixConstructionOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expressionListEClass, ExpressionList.class, "ExpressionList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExpressionList_Expressions(), this.getExpression(), null, "expressions", null, 0, -1, ExpressionList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unitConstructionOperatorEClass, UnitConstructionOperator.class, "UnitConstructionOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUnitConstructionOperator_UnitExpression(), this.getUnitExpression(), null, "unitExpression", null, 0, 1, UnitConstructionOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(parenthesizedExpressionEClass, ParenthesizedExpression.class, "ParenthesizedExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getParenthesizedExpression_Expression(), this.getExpression(), null, "expression", null, 0, 1, ParenthesizedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(beginExpressionEClass, BeginExpression.class, "BeginExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(endExpressionEClass, EndExpression.class, "EndExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(unitExpressionEClass, UnitExpression.class, "UnitExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUnitExpression_Unspecified(), ecorePackage.getEBoolean(), "unspecified", null, 0, 1, UnitExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUnitExpression_Expression(), this.getExpression(), null, "expression", null, 0, 1, UnitExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
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
    initEReference(getRangeExpression_Begin(), this.getExpression(), null, "begin", null, 0, 1, RangeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRangeExpression_End(), this.getExpression(), null, "end", null, 0, 1, RangeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRangeExpression_Increment(), this.getRangeExpression(), null, "increment", null, 0, 1, RangeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(logicalOrExpressionEClass, LogicalOrExpression.class, "LogicalOrExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLogicalOrExpression_Operands(), this.getExpression(), null, "operands", null, 0, -1, LogicalOrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(logicalAndExpressionEClass, LogicalAndExpression.class, "LogicalAndExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLogicalAndExpression_Operands(), this.getExpression(), null, "operands", null, 0, -1, LogicalAndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(logicalNotExpressionEClass, LogicalNotExpression.class, "LogicalNotExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLogicalNotExpression_Operand(), this.getExpression(), null, "operand", null, 0, 1, LogicalNotExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(relationalExpressionEClass, RelationalExpression.class, "RelationalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRelationalExpression_LeftOperand(), this.getExpression(), null, "leftOperand", null, 0, 1, RelationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRelationalExpression_TypeTest(), ecorePackage.getEBoolean(), "typeTest", null, 0, 1, RelationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRelationalExpression_Type(), this.getDataTypeSpecifier(), null, "type", null, 0, 1, RelationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRelationalExpression_Operator(), this.getRelationalOperator(), "operator", null, 0, 1, RelationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRelationalExpression_RightOperand(), this.getExpression(), null, "rightOperand", null, 0, 1, RelationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(addSubtractExpressionEClass, AddSubtractExpression.class, "AddSubtractExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAddSubtractExpression_Operands(), this.getExpression(), null, "operands", null, 0, -1, AddSubtractExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAddSubtractExpression_Operators(), this.getAddSubtractOperator(), "operators", null, 0, -1, AddSubtractExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(multiplyDivideExpressionEClass, MultiplyDivideExpression.class, "MultiplyDivideExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMultiplyDivideExpression_Operands(), this.getExpression(), null, "operands", null, 0, -1, MultiplyDivideExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMultiplyDivideExpression_Operators(), this.getMultiplyDivideOperator(), "operators", null, 0, -1, MultiplyDivideExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(powerExpressionEClass, PowerExpression.class, "PowerExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPowerExpression_Operand(), this.getExpression(), null, "operand", null, 0, 1, PowerExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getPowerExpression_Operator(), this.getPowerOperator(), "operator", null, 0, 1, PowerExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPowerExpression_Exponent(), this.getExpression(), null, "exponent", null, 0, 1, PowerExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unaryMinusExpressionEClass, UnaryMinusExpression.class, "UnaryMinusExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUnaryMinusExpression_Operand(), this.getExpression(), null, "operand", null, 0, 1, UnaryMinusExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(featureCallEClass, FeatureCall.class, "FeatureCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFeatureCall_Target(), this.getExpression(), null, "target", null, 0, 1, FeatureCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFeatureCall_Parts(), this.getFeatureCallPart(), null, "parts", null, 0, -1, FeatureCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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

} //AstPackageImpl
