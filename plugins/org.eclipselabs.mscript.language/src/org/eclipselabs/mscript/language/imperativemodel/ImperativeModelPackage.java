/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.imperativemodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipselabs.mscript.language.ast.AstPackage;

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
 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelFactory
 * @model kind="package"
 * @generated
 */
public interface ImperativeModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "imperativemodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipselabs.org/mscript/ImperativeModel/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "imperativemodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ImperativeModelPackage eINSTANCE = org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.SubroutineImpl <em>Subroutine</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.SubroutineImpl
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getSubroutine()
	 * @generated
	 */
	int SUBROUTINE = 0;

	/**
	 * The feature id for the '<em><b>Template Variable Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBROUTINE__TEMPLATE_VARIABLE_DECLARATIONS = 0;

	/**
	 * The feature id for the '<em><b>Input Variable Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBROUTINE__INPUT_VARIABLE_DECLARATIONS = 1;

	/**
	 * The feature id for the '<em><b>Output Variable Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBROUTINE__OUTPUT_VARIABLE_DECLARATIONS = 2;

	/**
	 * The feature id for the '<em><b>State Variable Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBROUTINE__STATE_VARIABLE_DECLARATIONS = 3;

	/**
	 * The feature id for the '<em><b>Initialization Compound</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBROUTINE__INITIALIZATION_COMPOUND = 4;

	/**
	 * The feature id for the '<em><b>Computation Compounds</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBROUTINE__COMPUTATION_COMPOUNDS = 5;

	/**
	 * The number of structural features of the '<em>Subroutine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBROUTINE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.StatementImpl <em>Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.StatementImpl
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getStatement()
	 * @generated
	 */
	int STATEMENT = 1;

	/**
	 * The number of structural features of the '<em>Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.VariableDeclarationImpl
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getVariableDeclaration()
	 * @generated
	 */
	int VARIABLE_DECLARATION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__NAME = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__TYPE = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Initializer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__INITIALIZER = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Ring Buffer Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__RING_BUFFER_SIZE = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.CompoundImpl <em>Compound</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.CompoundImpl
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getCompound()
	 * @generated
	 */
	int COMPOUND = 3;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND__STATEMENTS = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Compound</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.ComputationCompoundImpl <em>Computation Compound</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ComputationCompoundImpl
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getComputationCompound()
	 * @generated
	 */
	int COMPUTATION_COMPOUND = 4;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_COMPOUND__STATEMENTS = COMPOUND__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Used Inputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_COMPOUND__USED_INPUTS = COMPOUND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Computed Outputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_COMPOUND__COMPUTED_OUTPUTS = COMPOUND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Computation Compound</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_COMPOUND_FEATURE_COUNT = COMPOUND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.AssignmentImpl <em>Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.AssignmentImpl
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getAssignment()
	 * @generated
	 */
	int ASSIGNMENT = 5;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__TARGET = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Assigned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__ASSIGNED_EXPRESSION = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.IfStatementImpl <em>If Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.IfStatementImpl
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getIfStatement()
	 * @generated
	 */
	int IF_STATEMENT = 6;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__CONDITION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Then Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__THEN_STATEMENT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Else Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__ELSE_STATEMENT = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>If Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.ForeachStatementImpl <em>Foreach Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ForeachStatementImpl
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getForeachStatement()
	 * @generated
	 */
	int FOREACH_STATEMENT = 7;

	/**
	 * The feature id for the '<em><b>Iteration Variable Declaration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREACH_STATEMENT__ITERATION_VARIABLE_DECLARATION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Collection Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREACH_STATEMENT__COLLECTION_EXPRESSION = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREACH_STATEMENT__BODY = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Foreach Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREACH_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.VariableAccessImpl <em>Variable Access</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.VariableAccessImpl
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getVariableAccess()
	 * @generated
	 */
	int VARIABLE_ACCESS = 8;

	/**
	 * The feature id for the '<em><b>Accessed Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ACCESS__ACCESSED_DECLARATION = AstPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Step Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ACCESS__STEP_INDEX = AstPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Variable Access</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ACCESS_FEATURE_COUNT = AstPackage.EXPRESSION_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.imperativemodel.Subroutine <em>Subroutine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subroutine</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.Subroutine
	 * @generated
	 */
	EClass getSubroutine();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.imperativemodel.Subroutine#getTemplateVariableDeclarations <em>Template Variable Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Template Variable Declarations</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.Subroutine#getTemplateVariableDeclarations()
	 * @see #getSubroutine()
	 * @generated
	 */
	EReference getSubroutine_TemplateVariableDeclarations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.imperativemodel.Subroutine#getInputVariableDeclarations <em>Input Variable Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Variable Declarations</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.Subroutine#getInputVariableDeclarations()
	 * @see #getSubroutine()
	 * @generated
	 */
	EReference getSubroutine_InputVariableDeclarations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.imperativemodel.Subroutine#getOutputVariableDeclarations <em>Output Variable Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Variable Declarations</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.Subroutine#getOutputVariableDeclarations()
	 * @see #getSubroutine()
	 * @generated
	 */
	EReference getSubroutine_OutputVariableDeclarations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.imperativemodel.Subroutine#getStateVariableDeclarations <em>State Variable Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>State Variable Declarations</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.Subroutine#getStateVariableDeclarations()
	 * @see #getSubroutine()
	 * @generated
	 */
	EReference getSubroutine_StateVariableDeclarations();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.imperativemodel.Subroutine#getInitializationCompound <em>Initialization Compound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initialization Compound</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.Subroutine#getInitializationCompound()
	 * @see #getSubroutine()
	 * @generated
	 */
	EReference getSubroutine_InitializationCompound();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.imperativemodel.Subroutine#getComputationCompounds <em>Computation Compounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Computation Compounds</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.Subroutine#getComputationCompounds()
	 * @see #getSubroutine()
	 * @generated
	 */
	EReference getSubroutine_ComputationCompounds();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.imperativemodel.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statement</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.Statement
	 * @generated
	 */
	EClass getStatement();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration <em>Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Declaration</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration
	 * @generated
	 */
	EClass getVariableDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration#getName()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	EAttribute getVariableDeclaration_Name();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration#getType()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	EReference getVariableDeclaration_Type();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration#getInitializer <em>Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initializer</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration#getInitializer()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	EReference getVariableDeclaration_Initializer();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration#getRingBufferSize <em>Ring Buffer Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ring Buffer Size</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration#getRingBufferSize()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	EAttribute getVariableDeclaration_RingBufferSize();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.imperativemodel.Compound <em>Compound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compound</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.Compound
	 * @generated
	 */
	EClass getCompound();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.imperativemodel.Compound#getStatements <em>Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Statements</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.Compound#getStatements()
	 * @see #getCompound()
	 * @generated
	 */
	EReference getCompound_Statements();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.imperativemodel.ComputationCompound <em>Computation Compound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Computation Compound</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.ComputationCompound
	 * @generated
	 */
	EClass getComputationCompound();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.mscript.language.imperativemodel.ComputationCompound#getUsedInputs <em>Used Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Used Inputs</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.ComputationCompound#getUsedInputs()
	 * @see #getComputationCompound()
	 * @generated
	 */
	EReference getComputationCompound_UsedInputs();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.mscript.language.imperativemodel.ComputationCompound#getComputedOutputs <em>Computed Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Computed Outputs</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.ComputationCompound#getComputedOutputs()
	 * @see #getComputationCompound()
	 * @generated
	 */
	EReference getComputationCompound_ComputedOutputs();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.imperativemodel.Assignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assignment</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.Assignment
	 * @generated
	 */
	EClass getAssignment();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.mscript.language.imperativemodel.Assignment#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.Assignment#getTarget()
	 * @see #getAssignment()
	 * @generated
	 */
	EReference getAssignment_Target();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.imperativemodel.Assignment#getAssignedExpression <em>Assigned Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Assigned Expression</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.Assignment#getAssignedExpression()
	 * @see #getAssignment()
	 * @generated
	 */
	EReference getAssignment_AssignedExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.imperativemodel.IfStatement <em>If Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If Statement</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.IfStatement
	 * @generated
	 */
	EClass getIfStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.imperativemodel.IfStatement#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.IfStatement#getCondition()
	 * @see #getIfStatement()
	 * @generated
	 */
	EReference getIfStatement_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.imperativemodel.IfStatement#getThenStatement <em>Then Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then Statement</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.IfStatement#getThenStatement()
	 * @see #getIfStatement()
	 * @generated
	 */
	EReference getIfStatement_ThenStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.imperativemodel.IfStatement#getElseStatement <em>Else Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else Statement</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.IfStatement#getElseStatement()
	 * @see #getIfStatement()
	 * @generated
	 */
	EReference getIfStatement_ElseStatement();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.imperativemodel.ForeachStatement <em>Foreach Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Foreach Statement</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.ForeachStatement
	 * @generated
	 */
	EClass getForeachStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.imperativemodel.ForeachStatement#getIterationVariableDeclaration <em>Iteration Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Iteration Variable Declaration</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.ForeachStatement#getIterationVariableDeclaration()
	 * @see #getForeachStatement()
	 * @generated
	 */
	EReference getForeachStatement_IterationVariableDeclaration();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.imperativemodel.ForeachStatement#getCollectionExpression <em>Collection Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Collection Expression</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.ForeachStatement#getCollectionExpression()
	 * @see #getForeachStatement()
	 * @generated
	 */
	EReference getForeachStatement_CollectionExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.imperativemodel.ForeachStatement#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.ForeachStatement#getBody()
	 * @see #getForeachStatement()
	 * @generated
	 */
	EReference getForeachStatement_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.imperativemodel.VariableAccess <em>Variable Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Access</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.VariableAccess
	 * @generated
	 */
	EClass getVariableAccess();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.mscript.language.imperativemodel.VariableAccess#getAccessedDeclaration <em>Accessed Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Accessed Declaration</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.VariableAccess#getAccessedDeclaration()
	 * @see #getVariableAccess()
	 * @generated
	 */
	EReference getVariableAccess_AccessedDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.imperativemodel.VariableAccess#getStepIndex <em>Step Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Step Index</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.VariableAccess#getStepIndex()
	 * @see #getVariableAccess()
	 * @generated
	 */
	EAttribute getVariableAccess_StepIndex();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ImperativeModelFactory getImperativeModelFactory();

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
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.SubroutineImpl <em>Subroutine</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.SubroutineImpl
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getSubroutine()
		 * @generated
		 */
		EClass SUBROUTINE = eINSTANCE.getSubroutine();

		/**
		 * The meta object literal for the '<em><b>Template Variable Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBROUTINE__TEMPLATE_VARIABLE_DECLARATIONS = eINSTANCE.getSubroutine_TemplateVariableDeclarations();

		/**
		 * The meta object literal for the '<em><b>Input Variable Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBROUTINE__INPUT_VARIABLE_DECLARATIONS = eINSTANCE.getSubroutine_InputVariableDeclarations();

		/**
		 * The meta object literal for the '<em><b>Output Variable Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBROUTINE__OUTPUT_VARIABLE_DECLARATIONS = eINSTANCE.getSubroutine_OutputVariableDeclarations();

		/**
		 * The meta object literal for the '<em><b>State Variable Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBROUTINE__STATE_VARIABLE_DECLARATIONS = eINSTANCE.getSubroutine_StateVariableDeclarations();

		/**
		 * The meta object literal for the '<em><b>Initialization Compound</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBROUTINE__INITIALIZATION_COMPOUND = eINSTANCE.getSubroutine_InitializationCompound();

		/**
		 * The meta object literal for the '<em><b>Computation Compounds</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBROUTINE__COMPUTATION_COMPOUNDS = eINSTANCE.getSubroutine_ComputationCompounds();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.StatementImpl <em>Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.StatementImpl
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getStatement()
		 * @generated
		 */
		EClass STATEMENT = eINSTANCE.getStatement();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.VariableDeclarationImpl
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getVariableDeclaration()
		 * @generated
		 */
		EClass VARIABLE_DECLARATION = eINSTANCE.getVariableDeclaration();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_DECLARATION__NAME = eINSTANCE.getVariableDeclaration_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_DECLARATION__TYPE = eINSTANCE.getVariableDeclaration_Type();

		/**
		 * The meta object literal for the '<em><b>Initializer</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_DECLARATION__INITIALIZER = eINSTANCE.getVariableDeclaration_Initializer();

		/**
		 * The meta object literal for the '<em><b>Ring Buffer Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_DECLARATION__RING_BUFFER_SIZE = eINSTANCE.getVariableDeclaration_RingBufferSize();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.CompoundImpl <em>Compound</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.CompoundImpl
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getCompound()
		 * @generated
		 */
		EClass COMPOUND = eINSTANCE.getCompound();

		/**
		 * The meta object literal for the '<em><b>Statements</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOUND__STATEMENTS = eINSTANCE.getCompound_Statements();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.ComputationCompoundImpl <em>Computation Compound</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ComputationCompoundImpl
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getComputationCompound()
		 * @generated
		 */
		EClass COMPUTATION_COMPOUND = eINSTANCE.getComputationCompound();

		/**
		 * The meta object literal for the '<em><b>Used Inputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTATION_COMPOUND__USED_INPUTS = eINSTANCE.getComputationCompound_UsedInputs();

		/**
		 * The meta object literal for the '<em><b>Computed Outputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTATION_COMPOUND__COMPUTED_OUTPUTS = eINSTANCE.getComputationCompound_ComputedOutputs();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.AssignmentImpl <em>Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.AssignmentImpl
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getAssignment()
		 * @generated
		 */
		EClass ASSIGNMENT = eINSTANCE.getAssignment();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT__TARGET = eINSTANCE.getAssignment_Target();

		/**
		 * The meta object literal for the '<em><b>Assigned Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT__ASSIGNED_EXPRESSION = eINSTANCE.getAssignment_AssignedExpression();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.IfStatementImpl <em>If Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.IfStatementImpl
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getIfStatement()
		 * @generated
		 */
		EClass IF_STATEMENT = eINSTANCE.getIfStatement();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_STATEMENT__CONDITION = eINSTANCE.getIfStatement_Condition();

		/**
		 * The meta object literal for the '<em><b>Then Statement</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_STATEMENT__THEN_STATEMENT = eINSTANCE.getIfStatement_ThenStatement();

		/**
		 * The meta object literal for the '<em><b>Else Statement</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_STATEMENT__ELSE_STATEMENT = eINSTANCE.getIfStatement_ElseStatement();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.ForeachStatementImpl <em>Foreach Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ForeachStatementImpl
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getForeachStatement()
		 * @generated
		 */
		EClass FOREACH_STATEMENT = eINSTANCE.getForeachStatement();

		/**
		 * The meta object literal for the '<em><b>Iteration Variable Declaration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOREACH_STATEMENT__ITERATION_VARIABLE_DECLARATION = eINSTANCE.getForeachStatement_IterationVariableDeclaration();

		/**
		 * The meta object literal for the '<em><b>Collection Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOREACH_STATEMENT__COLLECTION_EXPRESSION = eINSTANCE.getForeachStatement_CollectionExpression();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOREACH_STATEMENT__BODY = eINSTANCE.getForeachStatement_Body();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.VariableAccessImpl <em>Variable Access</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.VariableAccessImpl
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getVariableAccess()
		 * @generated
		 */
		EClass VARIABLE_ACCESS = eINSTANCE.getVariableAccess();

		/**
		 * The meta object literal for the '<em><b>Accessed Declaration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_ACCESS__ACCESSED_DECLARATION = eINSTANCE.getVariableAccess_AccessedDeclaration();

		/**
		 * The meta object literal for the '<em><b>Step Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_ACCESS__STEP_INDEX = eINSTANCE.getVariableAccess_StepIndex();

	}

} //ImperativeModelPackage
