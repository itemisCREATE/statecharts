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
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBROUTINE__CONTEXT = 0;

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
	 * The feature id for the '<em><b>Computation Compounds</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBROUTINE__COMPUTATION_COMPOUNDS = 3;

	/**
	 * The number of structural features of the '<em>Subroutine</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBROUTINE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.SubroutineContextImpl <em>Subroutine Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.SubroutineContextImpl
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getSubroutineContext()
	 * @generated
	 */
	int SUBROUTINE_CONTEXT = 1;

	/**
	 * The feature id for the '<em><b>Template Variable Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBROUTINE_CONTEXT__TEMPLATE_VARIABLE_DECLARATIONS = 0;

	/**
	 * The feature id for the '<em><b>State Variable Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBROUTINE_CONTEXT__STATE_VARIABLE_DECLARATIONS = 1;

	/**
	 * The feature id for the '<em><b>Circular Buffer Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBROUTINE_CONTEXT__CIRCULAR_BUFFER_DECLARATIONS = 2;

	/**
	 * The feature id for the '<em><b>Initialization Compound</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBROUTINE_CONTEXT__INITIALIZATION_COMPOUND = 3;

	/**
	 * The number of structural features of the '<em>Subroutine Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBROUTINE_CONTEXT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.CircularBufferDeclarationImpl <em>Circular Buffer Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.CircularBufferDeclarationImpl
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getCircularBufferDeclaration()
	 * @generated
	 */
	int CIRCULAR_BUFFER_DECLARATION = 2;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CIRCULAR_BUFFER_DECLARATION__SIZE = 0;

	/**
	 * The number of structural features of the '<em>Circular Buffer Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CIRCULAR_BUFFER_DECLARATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.StatementImpl <em>Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.StatementImpl
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getStatement()
	 * @generated
	 */
	int STATEMENT = 12;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.CompoundStatementImpl <em>Compound Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.CompoundStatementImpl
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getCompoundStatement()
	 * @generated
	 */
	int COMPOUND_STATEMENT = 13;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.VariableDeclarationImpl
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getVariableDeclaration()
	 * @generated
	 */
	int VARIABLE_DECLARATION = 5;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.StatefulVariableDeclarationImpl <em>Stateful Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.StatefulVariableDeclarationImpl
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getStatefulVariableDeclaration()
	 * @generated
	 */
	int STATEFUL_VARIABLE_DECLARATION = 6;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.InputVariableDeclarationImpl <em>Input Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.InputVariableDeclarationImpl
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getInputVariableDeclaration()
	 * @generated
	 */
	int INPUT_VARIABLE_DECLARATION = 7;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.OutputVariableDeclarationImpl <em>Output Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.OutputVariableDeclarationImpl
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getOutputVariableDeclaration()
	 * @generated
	 */
	int OUTPUT_VARIABLE_DECLARATION = 8;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.TemplateVariableDeclarationImpl <em>Template Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.TemplateVariableDeclarationImpl
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getTemplateVariableDeclaration()
	 * @generated
	 */
	int TEMPLATE_VARIABLE_DECLARATION = 9;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.StateVariableDeclarationImpl <em>State Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.StateVariableDeclarationImpl
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getStateVariableDeclaration()
	 * @generated
	 */
	int STATE_VARIABLE_DECLARATION = 10;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.LocalVariableDeclarationImpl <em>Local Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.LocalVariableDeclarationImpl
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getLocalVariableDeclaration()
	 * @generated
	 */
	int LOCAL_VARIABLE_DECLARATION = 11;

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
	int COMPOUND__STATEMENTS = 0;

	/**
	 * The number of structural features of the '<em>Compound</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_FEATURE_COUNT = 1;

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
	 * The feature id for the '<em><b>Inputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_COMPOUND__INPUTS = COMPOUND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_COMPOUND__OUTPUTS = COMPOUND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Computation Compound</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_COMPOUND_FEATURE_COUNT = COMPOUND_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__TYPE = 1;

	/**
	 * The number of structural features of the '<em>Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL_VARIABLE_DECLARATION__NAME = VARIABLE_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL_VARIABLE_DECLARATION__TYPE = VARIABLE_DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Circular Buffer Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL_VARIABLE_DECLARATION__CIRCULAR_BUFFER_DECLARATION = VARIABLE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Stateful Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL_VARIABLE_DECLARATION_FEATURE_COUNT = VARIABLE_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VARIABLE_DECLARATION__NAME = STATEFUL_VARIABLE_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VARIABLE_DECLARATION__TYPE = STATEFUL_VARIABLE_DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Circular Buffer Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VARIABLE_DECLARATION__CIRCULAR_BUFFER_DECLARATION = STATEFUL_VARIABLE_DECLARATION__CIRCULAR_BUFFER_DECLARATION;

	/**
	 * The number of structural features of the '<em>Input Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VARIABLE_DECLARATION_FEATURE_COUNT = STATEFUL_VARIABLE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VARIABLE_DECLARATION__NAME = STATEFUL_VARIABLE_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VARIABLE_DECLARATION__TYPE = STATEFUL_VARIABLE_DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Circular Buffer Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VARIABLE_DECLARATION__CIRCULAR_BUFFER_DECLARATION = STATEFUL_VARIABLE_DECLARATION__CIRCULAR_BUFFER_DECLARATION;

	/**
	 * The number of structural features of the '<em>Output Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VARIABLE_DECLARATION_FEATURE_COUNT = STATEFUL_VARIABLE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE_DECLARATION__NAME = VARIABLE_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE_DECLARATION__TYPE = VARIABLE_DECLARATION__TYPE;

	/**
	 * The number of structural features of the '<em>Template Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE_DECLARATION_FEATURE_COUNT = VARIABLE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_VARIABLE_DECLARATION__NAME = STATEFUL_VARIABLE_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_VARIABLE_DECLARATION__TYPE = STATEFUL_VARIABLE_DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Circular Buffer Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_VARIABLE_DECLARATION__CIRCULAR_BUFFER_DECLARATION = STATEFUL_VARIABLE_DECLARATION__CIRCULAR_BUFFER_DECLARATION;

	/**
	 * The number of structural features of the '<em>State Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_VARIABLE_DECLARATION_FEATURE_COUNT = STATEFUL_VARIABLE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE_DECLARATION__NAME = VARIABLE_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE_DECLARATION__TYPE = VARIABLE_DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Initializer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE_DECLARATION__INITIALIZER = VARIABLE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Local Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE_DECLARATION_FEATURE_COUNT = VARIABLE_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_FEATURE_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_STATEMENT__STATEMENTS = COMPOUND__STATEMENTS;

	/**
	 * The number of structural features of the '<em>Compound Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_STATEMENT_FEATURE_COUNT = COMPOUND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.AssignmentImpl <em>Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.AssignmentImpl
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getAssignment()
	 * @generated
	 */
	int ASSIGNMENT = 14;

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
	int IF_STATEMENT = 15;

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
	int FOREACH_STATEMENT = 16;

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
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.VariableReferenceImpl <em>Variable Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.VariableReferenceImpl
	 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getVariableReference()
	 * @generated
	 */
	int VARIABLE_REFERENCE = 17;

	/**
	 * The feature id for the '<em><b>Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REFERENCE__DECLARATION = AstPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Step Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REFERENCE__STEP_INDEX = AstPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Array Indices</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REFERENCE__ARRAY_INDICES = AstPackage.EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Variable Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REFERENCE_FEATURE_COUNT = AstPackage.EXPRESSION_FEATURE_COUNT + 3;

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
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.imperativemodel.Subroutine#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Context</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.Subroutine#getContext()
	 * @see #getSubroutine()
	 * @generated
	 */
	EReference getSubroutine_Context();

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
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.imperativemodel.SubroutineContext <em>Subroutine Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subroutine Context</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.SubroutineContext
	 * @generated
	 */
	EClass getSubroutineContext();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.imperativemodel.SubroutineContext#getTemplateVariableDeclarations <em>Template Variable Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Template Variable Declarations</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.SubroutineContext#getTemplateVariableDeclarations()
	 * @see #getSubroutineContext()
	 * @generated
	 */
	EReference getSubroutineContext_TemplateVariableDeclarations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.imperativemodel.SubroutineContext#getStateVariableDeclarations <em>State Variable Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>State Variable Declarations</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.SubroutineContext#getStateVariableDeclarations()
	 * @see #getSubroutineContext()
	 * @generated
	 */
	EReference getSubroutineContext_StateVariableDeclarations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.imperativemodel.SubroutineContext#getCircularBufferDeclarations <em>Circular Buffer Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Circular Buffer Declarations</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.SubroutineContext#getCircularBufferDeclarations()
	 * @see #getSubroutineContext()
	 * @generated
	 */
	EReference getSubroutineContext_CircularBufferDeclarations();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.imperativemodel.SubroutineContext#getInitializationCompound <em>Initialization Compound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initialization Compound</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.SubroutineContext#getInitializationCompound()
	 * @see #getSubroutineContext()
	 * @generated
	 */
	EReference getSubroutineContext_InitializationCompound();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.imperativemodel.CircularBufferDeclaration <em>Circular Buffer Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Circular Buffer Declaration</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.CircularBufferDeclaration
	 * @generated
	 */
	EClass getCircularBufferDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.imperativemodel.CircularBufferDeclaration#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.CircularBufferDeclaration#getSize()
	 * @see #getCircularBufferDeclaration()
	 * @generated
	 */
	EAttribute getCircularBufferDeclaration_Size();

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
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.imperativemodel.CompoundStatement <em>Compound Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compound Statement</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.CompoundStatement
	 * @generated
	 */
	EClass getCompoundStatement();

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
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.imperativemodel.StatefulVariableDeclaration <em>Stateful Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stateful Variable Declaration</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.StatefulVariableDeclaration
	 * @generated
	 */
	EClass getStatefulVariableDeclaration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.mscript.language.imperativemodel.StatefulVariableDeclaration#getCircularBufferDeclaration <em>Circular Buffer Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Circular Buffer Declaration</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.StatefulVariableDeclaration#getCircularBufferDeclaration()
	 * @see #getStatefulVariableDeclaration()
	 * @generated
	 */
	EReference getStatefulVariableDeclaration_CircularBufferDeclaration();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.imperativemodel.InputVariableDeclaration <em>Input Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Variable Declaration</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.InputVariableDeclaration
	 * @generated
	 */
	EClass getInputVariableDeclaration();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.imperativemodel.OutputVariableDeclaration <em>Output Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Variable Declaration</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.OutputVariableDeclaration
	 * @generated
	 */
	EClass getOutputVariableDeclaration();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.imperativemodel.TemplateVariableDeclaration <em>Template Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Variable Declaration</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.TemplateVariableDeclaration
	 * @generated
	 */
	EClass getTemplateVariableDeclaration();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.imperativemodel.StateVariableDeclaration <em>State Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Variable Declaration</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.StateVariableDeclaration
	 * @generated
	 */
	EClass getStateVariableDeclaration();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.imperativemodel.LocalVariableDeclaration <em>Local Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local Variable Declaration</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.LocalVariableDeclaration
	 * @generated
	 */
	EClass getLocalVariableDeclaration();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.imperativemodel.LocalVariableDeclaration#getInitializer <em>Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initializer</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.LocalVariableDeclaration#getInitializer()
	 * @see #getLocalVariableDeclaration()
	 * @generated
	 */
	EReference getLocalVariableDeclaration_Initializer();

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
	 * Returns the meta object for the reference list '{@link org.eclipselabs.mscript.language.imperativemodel.ComputationCompound#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inputs</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.ComputationCompound#getInputs()
	 * @see #getComputationCompound()
	 * @generated
	 */
	EReference getComputationCompound_Inputs();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.mscript.language.imperativemodel.ComputationCompound#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outputs</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.ComputationCompound#getOutputs()
	 * @see #getComputationCompound()
	 * @generated
	 */
	EReference getComputationCompound_Outputs();

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
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.imperativemodel.VariableReference <em>Variable Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Reference</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.VariableReference
	 * @generated
	 */
	EClass getVariableReference();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.mscript.language.imperativemodel.VariableReference#getDeclaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Declaration</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.VariableReference#getDeclaration()
	 * @see #getVariableReference()
	 * @generated
	 */
	EReference getVariableReference_Declaration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.imperativemodel.VariableReference#getStepIndex <em>Step Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Step Index</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.VariableReference#getStepIndex()
	 * @see #getVariableReference()
	 * @generated
	 */
	EAttribute getVariableReference_StepIndex();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.imperativemodel.VariableReference#getArrayIndices <em>Array Indices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Array Indices</em>'.
	 * @see org.eclipselabs.mscript.language.imperativemodel.VariableReference#getArrayIndices()
	 * @see #getVariableReference()
	 * @generated
	 */
	EReference getVariableReference_ArrayIndices();

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
		 * The meta object literal for the '<em><b>Context</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBROUTINE__CONTEXT = eINSTANCE.getSubroutine_Context();

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
		 * The meta object literal for the '<em><b>Computation Compounds</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBROUTINE__COMPUTATION_COMPOUNDS = eINSTANCE.getSubroutine_ComputationCompounds();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.SubroutineContextImpl <em>Subroutine Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.SubroutineContextImpl
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getSubroutineContext()
		 * @generated
		 */
		EClass SUBROUTINE_CONTEXT = eINSTANCE.getSubroutineContext();

		/**
		 * The meta object literal for the '<em><b>Template Variable Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBROUTINE_CONTEXT__TEMPLATE_VARIABLE_DECLARATIONS = eINSTANCE.getSubroutineContext_TemplateVariableDeclarations();

		/**
		 * The meta object literal for the '<em><b>State Variable Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBROUTINE_CONTEXT__STATE_VARIABLE_DECLARATIONS = eINSTANCE.getSubroutineContext_StateVariableDeclarations();

		/**
		 * The meta object literal for the '<em><b>Circular Buffer Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBROUTINE_CONTEXT__CIRCULAR_BUFFER_DECLARATIONS = eINSTANCE.getSubroutineContext_CircularBufferDeclarations();

		/**
		 * The meta object literal for the '<em><b>Initialization Compound</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBROUTINE_CONTEXT__INITIALIZATION_COMPOUND = eINSTANCE.getSubroutineContext_InitializationCompound();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.CircularBufferDeclarationImpl <em>Circular Buffer Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.CircularBufferDeclarationImpl
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getCircularBufferDeclaration()
		 * @generated
		 */
		EClass CIRCULAR_BUFFER_DECLARATION = eINSTANCE.getCircularBufferDeclaration();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CIRCULAR_BUFFER_DECLARATION__SIZE = eINSTANCE.getCircularBufferDeclaration_Size();

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
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.CompoundStatementImpl <em>Compound Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.CompoundStatementImpl
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getCompoundStatement()
		 * @generated
		 */
		EClass COMPOUND_STATEMENT = eINSTANCE.getCompoundStatement();

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
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.StatefulVariableDeclarationImpl <em>Stateful Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.StatefulVariableDeclarationImpl
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getStatefulVariableDeclaration()
		 * @generated
		 */
		EClass STATEFUL_VARIABLE_DECLARATION = eINSTANCE.getStatefulVariableDeclaration();

		/**
		 * The meta object literal for the '<em><b>Circular Buffer Declaration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATEFUL_VARIABLE_DECLARATION__CIRCULAR_BUFFER_DECLARATION = eINSTANCE.getStatefulVariableDeclaration_CircularBufferDeclaration();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.InputVariableDeclarationImpl <em>Input Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.InputVariableDeclarationImpl
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getInputVariableDeclaration()
		 * @generated
		 */
		EClass INPUT_VARIABLE_DECLARATION = eINSTANCE.getInputVariableDeclaration();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.OutputVariableDeclarationImpl <em>Output Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.OutputVariableDeclarationImpl
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getOutputVariableDeclaration()
		 * @generated
		 */
		EClass OUTPUT_VARIABLE_DECLARATION = eINSTANCE.getOutputVariableDeclaration();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.TemplateVariableDeclarationImpl <em>Template Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.TemplateVariableDeclarationImpl
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getTemplateVariableDeclaration()
		 * @generated
		 */
		EClass TEMPLATE_VARIABLE_DECLARATION = eINSTANCE.getTemplateVariableDeclaration();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.StateVariableDeclarationImpl <em>State Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.StateVariableDeclarationImpl
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getStateVariableDeclaration()
		 * @generated
		 */
		EClass STATE_VARIABLE_DECLARATION = eINSTANCE.getStateVariableDeclaration();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.LocalVariableDeclarationImpl <em>Local Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.LocalVariableDeclarationImpl
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getLocalVariableDeclaration()
		 * @generated
		 */
		EClass LOCAL_VARIABLE_DECLARATION = eINSTANCE.getLocalVariableDeclaration();

		/**
		 * The meta object literal for the '<em><b>Initializer</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOCAL_VARIABLE_DECLARATION__INITIALIZER = eINSTANCE.getLocalVariableDeclaration_Initializer();

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
		 * The meta object literal for the '<em><b>Inputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTATION_COMPOUND__INPUTS = eINSTANCE.getComputationCompound_Inputs();

		/**
		 * The meta object literal for the '<em><b>Outputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTATION_COMPOUND__OUTPUTS = eINSTANCE.getComputationCompound_Outputs();

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
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.imperativemodel.impl.VariableReferenceImpl <em>Variable Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.VariableReferenceImpl
		 * @see org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelPackageImpl#getVariableReference()
		 * @generated
		 */
		EClass VARIABLE_REFERENCE = eINSTANCE.getVariableReference();

		/**
		 * The meta object literal for the '<em><b>Declaration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_REFERENCE__DECLARATION = eINSTANCE.getVariableReference_Declaration();

		/**
		 * The meta object literal for the '<em><b>Step Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_REFERENCE__STEP_INDEX = eINSTANCE.getVariableReference_StepIndex();

		/**
		 * The meta object literal for the '<em><b>Array Indices</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_REFERENCE__ARRAY_INDICES = eINSTANCE.getVariableReference_ArrayIndices();

	}

} //ImperativeModelPackage
