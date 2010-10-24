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
	 * The feature id for the '<em><b>Variable References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__VARIABLE_REFERENCES = 2;

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
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION__DEFINITION = 1;

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
	 * The feature id for the '<em><b>Variable Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_PART__VARIABLE_REFERENCE = 2;

	/**
	 * The number of structural features of the '<em>Equation Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_PART_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.functionmodel.impl.VariableReferenceImpl <em>Variable Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.functionmodel.impl.VariableReferenceImpl
	 * @see org.eclipselabs.mscript.language.functionmodel.impl.FunctionModelPackageImpl#getVariableReference()
	 * @generated
	 */
	int VARIABLE_REFERENCE = 4;

	/**
	 * The feature id for the '<em><b>Function</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REFERENCE__FUNCTION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REFERENCE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REFERENCE__KIND = 2;

	/**
	 * The feature id for the '<em><b>Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REFERENCE__STEP = 3;

	/**
	 * The feature id for the '<em><b>Initial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REFERENCE__INITIAL = 4;

	/**
	 * The feature id for the '<em><b>Using Equation Parts</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REFERENCE__USING_EQUATION_PARTS = 5;

	/**
	 * The number of structural features of the '<em>Variable Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REFERENCE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.functionmodel.VariableReferenceKind <em>Variable Reference Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.functionmodel.VariableReferenceKind
	 * @see org.eclipselabs.mscript.language.functionmodel.impl.FunctionModelPackageImpl#getVariableReferenceKind()
	 * @generated
	 */
	int VARIABLE_REFERENCE_KIND = 5;

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
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.functionmodel.Function#getVariableReferences <em>Variable References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variable References</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.Function#getVariableReferences()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_VariableReferences();

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
	 * Returns the meta object for the reference '{@link org.eclipselabs.mscript.language.functionmodel.Equation#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.Equation#getDefinition()
	 * @see #getEquation()
	 * @generated
	 */
	EReference getEquation_Definition();

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
	 * Returns the meta object for the reference '{@link org.eclipselabs.mscript.language.functionmodel.EquationPart#getVariableReference <em>Variable Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable Reference</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.EquationPart#getVariableReference()
	 * @see #getEquationPart()
	 * @generated
	 */
	EReference getEquationPart_VariableReference();

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
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.functionmodel.VariableReference <em>Variable Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Reference</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.VariableReference
	 * @generated
	 */
	EClass getVariableReference();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.mscript.language.functionmodel.VariableReference#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Function</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.VariableReference#getFunction()
	 * @see #getVariableReference()
	 * @generated
	 */
	EReference getVariableReference_Function();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.functionmodel.VariableReference#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.VariableReference#getName()
	 * @see #getVariableReference()
	 * @generated
	 */
	EAttribute getVariableReference_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.functionmodel.VariableReference#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.VariableReference#getKind()
	 * @see #getVariableReference()
	 * @generated
	 */
	EAttribute getVariableReference_Kind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.functionmodel.VariableReference#getStep <em>Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Step</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.VariableReference#getStep()
	 * @see #getVariableReference()
	 * @generated
	 */
	EAttribute getVariableReference_Step();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.functionmodel.VariableReference#isInitial <em>Initial</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.VariableReference#isInitial()
	 * @see #getVariableReference()
	 * @generated
	 */
	EAttribute getVariableReference_Initial();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.mscript.language.functionmodel.VariableReference#getUsingEquationParts <em>Using Equation Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Using Equation Parts</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.VariableReference#getUsingEquationParts()
	 * @see #getVariableReference()
	 * @generated
	 */
	EReference getVariableReference_UsingEquationParts();

	/**
	 * Returns the meta object for enum '{@link org.eclipselabs.mscript.language.functionmodel.VariableReferenceKind <em>Variable Reference Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Variable Reference Kind</em>'.
	 * @see org.eclipselabs.mscript.language.functionmodel.VariableReferenceKind
	 * @generated
	 */
	EEnum getVariableReferenceKind();

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
		 * The meta object literal for the '<em><b>Variable References</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__VARIABLE_REFERENCES = eINSTANCE.getFunction_VariableReferences();

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
		 * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION__DEFINITION = eINSTANCE.getEquation_Definition();

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
		 * The meta object literal for the '<em><b>Variable Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION_PART__VARIABLE_REFERENCE = eINSTANCE.getEquationPart_VariableReference();

		/**
		 * The meta object literal for the '<em><b>Feature Call</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION_PART__FEATURE_CALL = eINSTANCE.getEquationPart_FeatureCall();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.functionmodel.impl.VariableReferenceImpl <em>Variable Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.functionmodel.impl.VariableReferenceImpl
		 * @see org.eclipselabs.mscript.language.functionmodel.impl.FunctionModelPackageImpl#getVariableReference()
		 * @generated
		 */
		EClass VARIABLE_REFERENCE = eINSTANCE.getVariableReference();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_REFERENCE__FUNCTION = eINSTANCE.getVariableReference_Function();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_REFERENCE__NAME = eINSTANCE.getVariableReference_Name();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_REFERENCE__KIND = eINSTANCE.getVariableReference_Kind();

		/**
		 * The meta object literal for the '<em><b>Step</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_REFERENCE__STEP = eINSTANCE.getVariableReference_Step();

		/**
		 * The meta object literal for the '<em><b>Initial</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_REFERENCE__INITIAL = eINSTANCE.getVariableReference_Initial();

		/**
		 * The meta object literal for the '<em><b>Using Equation Parts</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_REFERENCE__USING_EQUATION_PARTS = eINSTANCE.getVariableReference_UsingEquationParts();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.functionmodel.VariableReferenceKind <em>Variable Reference Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.functionmodel.VariableReferenceKind
		 * @see org.eclipselabs.mscript.language.functionmodel.impl.FunctionModelPackageImpl#getVariableReferenceKind()
		 * @generated
		 */
		EEnum VARIABLE_REFERENCE_KIND = eINSTANCE.getVariableReferenceKind();

	}

} //FunctionModelPackage
