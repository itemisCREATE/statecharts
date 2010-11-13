/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.functionmodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelFactory
 * @model kind="package"
 * @generated
 */
public interface FunctionModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "functionmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipselabs.org/mscript/FunctionModel/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "functionmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FunctionModelPackage eINSTANCE = org.eclipselabs.mscript.language.functionmodel.impl.FunctionModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.functionmodel.impl.FunctionImpl <em>Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.functionmodel.impl.FunctionImpl
	 * @see org.eclipselabs.mscript.language.functionmodel.impl.FunctionModelPackageImpl#getFunction()
	 * @generated
	 */
	int FUNCTION = 0;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__DEFINITION = 0;

	/**
	 * The feature id for the '<em><b>Equations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__EQUATIONS = 1;

	/**
	 * The feature id for the '<em><b>Variable Descriptors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__VARIABLE_DESCRIPTORS = 2;

	/**
	 * The number of structural features of the '<em>Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.functionmodel.impl.EquationImpl <em>Equation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.functionmodel.impl.EquationImpl
	 * @see org.eclipselabs.mscript.language.functionmodel.impl.FunctionModelPackageImpl#getEquation()
	 * @generated
	 */
	int EQUATION = 1;

	/**
	 * The feature id for the '<em><b>Function</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION__FUNCTION = 0;

	/**
	 * The feature id for the '<em><b>Statement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION__STATEMENT = 1;

	/**
	 * The feature id for the '<em><b>Sides</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION__SIDES = 2;

	/**
	 * The feature id for the '<em><b>Left Hand Side</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION__LEFT_HAND_SIDE = 3;

	/**
	 * The feature id for the '<em><b>Right Hand Side</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION__RIGHT_HAND_SIDE = 4;

	/**
	 * The number of structural features of the '<em>Equation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.functionmodel.impl.EquationSideImpl <em>Equation Side</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.functionmodel.impl.EquationSideImpl
	 * @see org.eclipselabs.mscript.language.functionmodel.impl.FunctionModelPackageImpl#getEquationSide()
	 * @generated
	 */
	int EQUATION_SIDE = 2;

	/**
	 * The feature id for the '<em><b>Equation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_SIDE__EQUATION = 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_SIDE__EXPRESSION = 1;

	/**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_SIDE__PARTS = 2;

	/**
	 * The number of structural features of the '<em>Equation Side</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_SIDE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.functionmodel.impl.EquationPartImpl <em>Equation Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.functionmodel.impl.EquationPartImpl
	 * @see org.eclipselabs.mscript.language.functionmodel.impl.FunctionModelPackageImpl#getEquationPart()
	 * @generated
	 */
	int EQUATION_PART = 3;

	/**
	 * The feature id for the '<em><b>Side</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_PART__SIDE = 0;

	/**
	 * The feature id for the '<em><b>Feature Call</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_PART__FEATURE_CALL = 1;

	/**
	 * The feature id for the '<em><b>Variable Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_PART__VARIABLE_STEP = 2;

	/**
	 * The number of structural features of the '<em>Equation Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_PART_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.functionmodel.impl.VariableDescriptorImpl <em>Variable Descriptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.functionmodel.impl.VariableDescriptorImpl
	 * @see org.eclipselabs.mscript.language.functionmodel.impl.FunctionModelPackageImpl#getVariableDescriptor()
	 * @generated
	 */
	int VARIABLE_DESCRIPTOR = 4;

	/**
	 * The feature id for the '<em><b>Function</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DESCRIPTOR__FUNCTION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DESCRIPTOR__NAME = 1;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DESCRIPTOR__KIND = 2;

	/**
	 * The feature id for the '<em><b>Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DESCRIPTOR__STEPS = 3;

	/**
	 * The number of structural features of the '<em>Variable Descriptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DESCRIPTOR_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.functionmodel.impl.VariableStepImpl <em>Variable Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.functionmodel.impl.VariableStepImpl
	 * @see org.eclipselabs.mscript.language.functionmodel.impl.FunctionModelPackageImpl#getVariableStep()
	 * @generated
	 */
	int VARIABLE_STEP = 5;

	/**
	 * The feature id for the '<em><b>Descriptor</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_STEP__DESCRIPTOR = 0;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_STEP__INDEX = 1;

	/**
	 * The feature id for the '<em><b>Initial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_STEP__INITIAL = 2;

	/**
	 * The feature id for the '<em><b>Using Equation Parts</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_STEP__USING_EQUATION_PARTS = 3;

	/**
	 * The number of structural features of the '<em>Variable Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_STEP_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.functionmodel.VariableKind <em>Variable Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.functionmodel.VariableKind
	 * @see org.eclipselabs.mscript.language.functionmodel.impl.FunctionModelPackageImpl#getVariableKind()
	 * @generated
	 */
	int VARIABLE_KIND = 6;

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.functionmodel.Function <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.Function
	 * @generated
	 */
	EClass getFunction();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.mscript.language.functionmodel.Function#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.Function#getDefinition()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_Definition();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.functionmodel.Function#getEquations <em>Equations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Equations</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.Function#getEquations()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_Equations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.functionmodel.Function#getVariableDescriptors <em>Variable Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variable Descriptors</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.Function#getVariableDescriptors()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_VariableDescriptors();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.functionmodel.Equation <em>Equation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equation</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.Equation
	 * @generated
	 */
	EClass getEquation();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.mscript.language.functionmodel.Equation#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Function</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.Equation#getFunction()
	 * @see #getEquation()
	 * @generated
	 */
	EReference getEquation_Function();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.mscript.language.functionmodel.Equation#getStatement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Statement</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.Equation#getStatement()
	 * @see #getEquation()
	 * @generated
	 */
	EReference getEquation_Statement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.functionmodel.Equation#getSides <em>Sides</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sides</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.Equation#getSides()
	 * @see #getEquation()
	 * @generated
	 */
	EReference getEquation_Sides();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.mscript.language.functionmodel.Equation#getLeftHandSide <em>Left Hand Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Left Hand Side</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.Equation#getLeftHandSide()
	 * @see #getEquation()
	 * @generated
	 */
	EReference getEquation_LeftHandSide();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.mscript.language.functionmodel.Equation#getRightHandSide <em>Right Hand Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Right Hand Side</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.Equation#getRightHandSide()
	 * @see #getEquation()
	 * @generated
	 */
	EReference getEquation_RightHandSide();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.functionmodel.EquationSide <em>Equation Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equation Side</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.EquationSide
	 * @generated
	 */
	EClass getEquationSide();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.mscript.language.functionmodel.EquationSide#getEquation <em>Equation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Equation</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.EquationSide#getEquation()
	 * @see #getEquationSide()
	 * @generated
	 */
	EReference getEquationSide_Equation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.mscript.language.functionmodel.EquationSide#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Expression</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.EquationSide#getExpression()
	 * @see #getEquationSide()
	 * @generated
	 */
	EReference getEquationSide_Expression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.functionmodel.EquationSide#getParts <em>Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parts</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.EquationSide#getParts()
	 * @see #getEquationSide()
	 * @generated
	 */
	EReference getEquationSide_Parts();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.functionmodel.EquationPart <em>Equation Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equation Part</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.EquationPart
	 * @generated
	 */
	EClass getEquationPart();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.mscript.language.functionmodel.EquationPart#getSide <em>Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Side</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.EquationPart#getSide()
	 * @see #getEquationPart()
	 * @generated
	 */
	EReference getEquationPart_Side();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.mscript.language.functionmodel.EquationPart#getFeatureCall <em>Feature Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature Call</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.EquationPart#getFeatureCall()
	 * @see #getEquationPart()
	 * @generated
	 */
	EReference getEquationPart_FeatureCall();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.mscript.language.functionmodel.EquationPart#getVariableStep <em>Variable Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable Step</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.EquationPart#getVariableStep()
	 * @see #getEquationPart()
	 * @generated
	 */
	EReference getEquationPart_VariableStep();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.functionmodel.VariableDescriptor <em>Variable Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Descriptor</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.VariableDescriptor
	 * @generated
	 */
	EClass getVariableDescriptor();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.mscript.language.functionmodel.VariableDescriptor#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Function</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.VariableDescriptor#getFunction()
	 * @see #getVariableDescriptor()
	 * @generated
	 */
	EReference getVariableDescriptor_Function();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.functionmodel.VariableDescriptor#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.VariableDescriptor#getName()
	 * @see #getVariableDescriptor()
	 * @generated
	 */
	EAttribute getVariableDescriptor_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.functionmodel.VariableDescriptor#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.VariableDescriptor#getKind()
	 * @see #getVariableDescriptor()
	 * @generated
	 */
	EAttribute getVariableDescriptor_Kind();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.functionmodel.VariableDescriptor#getSteps <em>Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Steps</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.VariableDescriptor#getSteps()
	 * @see #getVariableDescriptor()
	 * @generated
	 */
	EReference getVariableDescriptor_Steps();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.functionmodel.VariableStep <em>Variable Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Step</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.VariableStep
	 * @generated
	 */
	EClass getVariableStep();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.mscript.language.functionmodel.VariableStep#getDescriptor <em>Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Descriptor</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.VariableStep#getDescriptor()
	 * @see #getVariableStep()
	 * @generated
	 */
	EReference getVariableStep_Descriptor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.functionmodel.VariableStep#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.VariableStep#getIndex()
	 * @see #getVariableStep()
	 * @generated
	 */
	EAttribute getVariableStep_Index();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.functionmodel.VariableStep#isInitial <em>Initial</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.VariableStep#isInitial()
	 * @see #getVariableStep()
	 * @generated
	 */
	EAttribute getVariableStep_Initial();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.mscript.language.functionmodel.VariableStep#getUsingEquationParts <em>Using Equation Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Using Equation Parts</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.VariableStep#getUsingEquationParts()
	 * @see #getVariableStep()
	 * @generated
	 */
	EReference getVariableStep_UsingEquationParts();

	/**
	 * Returns the meta object for enum '{@link org.eclipselabs.mscript.language.functionmodel.VariableKind <em>Variable Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Variable Kind</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.VariableKind
	 * @generated
	 */
	EEnum getVariableKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FunctionModelFactory getFunctionModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.functionmodel.impl.FunctionImpl <em>Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.functionmodel.impl.FunctionImpl
		 * @see org.eclipselabs.mscript.language.functionmodel.impl.FunctionModelPackageImpl#getFunction()
		 * @generated
		 */
		EClass FUNCTION = eINSTANCE.getFunction();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__DEFINITION = eINSTANCE.getFunction_Definition();

		/**
		 * The meta object literal for the '<em><b>Equations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__EQUATIONS = eINSTANCE.getFunction_Equations();

		/**
		 * The meta object literal for the '<em><b>Variable Descriptors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__VARIABLE_DESCRIPTORS = eINSTANCE.getFunction_VariableDescriptors();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.functionmodel.impl.EquationImpl <em>Equation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.functionmodel.impl.EquationImpl
		 * @see org.eclipselabs.mscript.language.functionmodel.impl.FunctionModelPackageImpl#getEquation()
		 * @generated
		 */
		EClass EQUATION = eINSTANCE.getEquation();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION__FUNCTION = eINSTANCE.getEquation_Function();

		/**
		 * The meta object literal for the '<em><b>Statement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION__STATEMENT = eINSTANCE.getEquation_Statement();

		/**
		 * The meta object literal for the '<em><b>Sides</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION__SIDES = eINSTANCE.getEquation_Sides();

		/**
		 * The meta object literal for the '<em><b>Left Hand Side</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION__LEFT_HAND_SIDE = eINSTANCE.getEquation_LeftHandSide();

		/**
		 * The meta object literal for the '<em><b>Right Hand Side</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION__RIGHT_HAND_SIDE = eINSTANCE.getEquation_RightHandSide();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.functionmodel.impl.EquationSideImpl <em>Equation Side</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.functionmodel.impl.EquationSideImpl
		 * @see org.eclipselabs.mscript.language.functionmodel.impl.FunctionModelPackageImpl#getEquationSide()
		 * @generated
		 */
		EClass EQUATION_SIDE = eINSTANCE.getEquationSide();

		/**
		 * The meta object literal for the '<em><b>Equation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION_SIDE__EQUATION = eINSTANCE.getEquationSide_Equation();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION_SIDE__EXPRESSION = eINSTANCE.getEquationSide_Expression();

		/**
		 * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION_SIDE__PARTS = eINSTANCE.getEquationSide_Parts();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.functionmodel.impl.EquationPartImpl <em>Equation Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.functionmodel.impl.EquationPartImpl
		 * @see org.eclipselabs.mscript.language.functionmodel.impl.FunctionModelPackageImpl#getEquationPart()
		 * @generated
		 */
		EClass EQUATION_PART = eINSTANCE.getEquationPart();

		/**
		 * The meta object literal for the '<em><b>Side</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION_PART__SIDE = eINSTANCE.getEquationPart_Side();

		/**
		 * The meta object literal for the '<em><b>Feature Call</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION_PART__FEATURE_CALL = eINSTANCE.getEquationPart_FeatureCall();

		/**
		 * The meta object literal for the '<em><b>Variable Step</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION_PART__VARIABLE_STEP = eINSTANCE.getEquationPart_VariableStep();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.functionmodel.impl.VariableDescriptorImpl <em>Variable Descriptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.functionmodel.impl.VariableDescriptorImpl
		 * @see org.eclipselabs.mscript.language.functionmodel.impl.FunctionModelPackageImpl#getVariableDescriptor()
		 * @generated
		 */
		EClass VARIABLE_DESCRIPTOR = eINSTANCE.getVariableDescriptor();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_DESCRIPTOR__FUNCTION = eINSTANCE.getVariableDescriptor_Function();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_DESCRIPTOR__NAME = eINSTANCE.getVariableDescriptor_Name();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_DESCRIPTOR__KIND = eINSTANCE.getVariableDescriptor_Kind();

		/**
		 * The meta object literal for the '<em><b>Steps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_DESCRIPTOR__STEPS = eINSTANCE.getVariableDescriptor_Steps();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.functionmodel.impl.VariableStepImpl <em>Variable Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.functionmodel.impl.VariableStepImpl
		 * @see org.eclipselabs.mscript.language.functionmodel.impl.FunctionModelPackageImpl#getVariableStep()
		 * @generated
		 */
		EClass VARIABLE_STEP = eINSTANCE.getVariableStep();

		/**
		 * The meta object literal for the '<em><b>Descriptor</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_STEP__DESCRIPTOR = eINSTANCE.getVariableStep_Descriptor();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_STEP__INDEX = eINSTANCE.getVariableStep_Index();

		/**
		 * The meta object literal for the '<em><b>Initial</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_STEP__INITIAL = eINSTANCE.getVariableStep_Initial();

		/**
		 * The meta object literal for the '<em><b>Using Equation Parts</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_STEP__USING_EQUATION_PARTS = eINSTANCE.getVariableStep_UsingEquationParts();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.functionmodel.VariableKind <em>Variable Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.functionmodel.VariableKind
		 * @see org.eclipselabs.mscript.language.functionmodel.impl.FunctionModelPackageImpl#getVariableKind()
		 * @generated
		 */
		EEnum VARIABLE_KIND = eINSTANCE.getVariableKind();

	}

} //FunctionModelPackage
