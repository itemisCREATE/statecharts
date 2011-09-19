/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.il;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.typesystem.TypeSystemPackage;

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
 * @see org.eclipselabs.mscript.language.il.ILFactory
 * @model kind="package"
 * @generated
 */
public interface ILPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "il";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipselabs.org/mscript/IL/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "il";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ILPackage eINSTANCE = org.eclipselabs.mscript.language.il.impl.ILPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.il.impl.ILFunctionDefinitionImpl <em>Function Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.il.impl.ILFunctionDefinitionImpl
	 * @see org.eclipselabs.mscript.language.il.impl.ILPackageImpl#getILFunctionDefinition()
	 * @generated
	 */
	int IL_FUNCTION_DEFINITION = 0;

	/**
	 * The feature id for the '<em><b>Stateful</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IL_FUNCTION_DEFINITION__STATEFUL = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IL_FUNCTION_DEFINITION__NAME = 1;

	/**
	 * The feature id for the '<em><b>Template Variable Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IL_FUNCTION_DEFINITION__TEMPLATE_VARIABLE_DECLARATIONS = 2;

	/**
	 * The feature id for the '<em><b>Input Variable Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IL_FUNCTION_DEFINITION__INPUT_VARIABLE_DECLARATIONS = 3;

	/**
	 * The feature id for the '<em><b>Output Variable Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IL_FUNCTION_DEFINITION__OUTPUT_VARIABLE_DECLARATIONS = 4;

	/**
	 * The feature id for the '<em><b>Instance Variable Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IL_FUNCTION_DEFINITION__INSTANCE_VARIABLE_DECLARATIONS = 5;

	/**
	 * The feature id for the '<em><b>Initialization Compound</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IL_FUNCTION_DEFINITION__INITIALIZATION_COMPOUND = 6;

	/**
	 * The feature id for the '<em><b>Computation Compounds</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IL_FUNCTION_DEFINITION__COMPUTATION_COMPOUNDS = 7;

	/**
	 * The number of structural features of the '<em>Function Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IL_FUNCTION_DEFINITION_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.il.impl.CompoundStatementImpl <em>Compound Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.il.impl.CompoundStatementImpl
	 * @see org.eclipselabs.mscript.language.il.impl.ILPackageImpl#getCompoundStatement()
	 * @generated
	 */
	int COMPOUND_STATEMENT = 10;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.il.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.il.impl.VariableDeclarationImpl
	 * @see org.eclipselabs.mscript.language.il.impl.ILPackageImpl#getVariableDeclaration()
	 * @generated
	 */
	int VARIABLE_DECLARATION = 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.il.impl.StatefulVariableDeclarationImpl <em>Stateful Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.il.impl.StatefulVariableDeclarationImpl
	 * @see org.eclipselabs.mscript.language.il.impl.ILPackageImpl#getStatefulVariableDeclaration()
	 * @generated
	 */
	int STATEFUL_VARIABLE_DECLARATION = 4;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.il.impl.InputVariableDeclarationImpl <em>Input Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.il.impl.InputVariableDeclarationImpl
	 * @see org.eclipselabs.mscript.language.il.impl.ILPackageImpl#getInputVariableDeclaration()
	 * @generated
	 */
	int INPUT_VARIABLE_DECLARATION = 6;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.il.impl.OutputVariableDeclarationImpl <em>Output Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.il.impl.OutputVariableDeclarationImpl
	 * @see org.eclipselabs.mscript.language.il.impl.ILPackageImpl#getOutputVariableDeclaration()
	 * @generated
	 */
	int OUTPUT_VARIABLE_DECLARATION = 7;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.il.impl.LocalVariableDeclarationImpl <em>Local Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.il.impl.LocalVariableDeclarationImpl
	 * @see org.eclipselabs.mscript.language.il.impl.ILPackageImpl#getLocalVariableDeclaration()
	 * @generated
	 */
	int LOCAL_VARIABLE_DECLARATION = 9;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.il.impl.CompoundImpl <em>Compound</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.il.impl.CompoundImpl
	 * @see org.eclipselabs.mscript.language.il.impl.ILPackageImpl#getCompound()
	 * @generated
	 */
	int COMPOUND = 1;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND__STATEMENTS = 0;

	/**
	 * The feature id for the '<em><b>Local Variable Declarations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND__LOCAL_VARIABLE_DECLARATIONS = 1;

	/**
	 * The number of structural features of the '<em>Compound</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.il.impl.ComputationCompoundImpl <em>Computation Compound</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.il.impl.ComputationCompoundImpl
	 * @see org.eclipselabs.mscript.language.il.impl.ILPackageImpl#getComputationCompound()
	 * @generated
	 */
	int COMPUTATION_COMPOUND = 2;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_COMPOUND__STATEMENTS = COMPOUND__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Local Variable Declarations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_COMPOUND__LOCAL_VARIABLE_DECLARATIONS = COMPOUND__LOCAL_VARIABLE_DECLARATIONS;

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
	 * The number of structural features of the '<em>Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL_VARIABLE_DECLARATION__NAME = VARIABLE_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Circular Buffer Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL_VARIABLE_DECLARATION__CIRCULAR_BUFFER_SIZE = VARIABLE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Stateful Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL_VARIABLE_DECLARATION_FEATURE_COUNT = VARIABLE_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.il.impl.TemplateVariableDeclarationImpl <em>Template Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.il.impl.TemplateVariableDeclarationImpl
	 * @see org.eclipselabs.mscript.language.il.impl.ILPackageImpl#getTemplateVariableDeclaration()
	 * @generated
	 */
	int TEMPLATE_VARIABLE_DECLARATION = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE_DECLARATION__NAME = VARIABLE_DECLARATION__NAME;

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
	int INPUT_VARIABLE_DECLARATION__NAME = STATEFUL_VARIABLE_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Circular Buffer Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VARIABLE_DECLARATION__CIRCULAR_BUFFER_SIZE = STATEFUL_VARIABLE_DECLARATION__CIRCULAR_BUFFER_SIZE;

	/**
	 * The feature id for the '<em><b>Feeding Compounds</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VARIABLE_DECLARATION__FEEDING_COMPOUNDS = STATEFUL_VARIABLE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Direct Feedthrough</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VARIABLE_DECLARATION__DIRECT_FEEDTHROUGH = STATEFUL_VARIABLE_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Input Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_VARIABLE_DECLARATION_FEATURE_COUNT = STATEFUL_VARIABLE_DECLARATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VARIABLE_DECLARATION__NAME = STATEFUL_VARIABLE_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Circular Buffer Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VARIABLE_DECLARATION__CIRCULAR_BUFFER_SIZE = STATEFUL_VARIABLE_DECLARATION__CIRCULAR_BUFFER_SIZE;

	/**
	 * The number of structural features of the '<em>Output Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_VARIABLE_DECLARATION_FEATURE_COUNT = STATEFUL_VARIABLE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.il.impl.InstanceVariableDeclarationImpl <em>Instance Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.il.impl.InstanceVariableDeclarationImpl
	 * @see org.eclipselabs.mscript.language.il.impl.ILPackageImpl#getInstanceVariableDeclaration()
	 * @generated
	 */
	int INSTANCE_VARIABLE_DECLARATION = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_VARIABLE_DECLARATION__NAME = STATEFUL_VARIABLE_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Circular Buffer Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_VARIABLE_DECLARATION__CIRCULAR_BUFFER_SIZE = STATEFUL_VARIABLE_DECLARATION__CIRCULAR_BUFFER_SIZE;

	/**
	 * The number of structural features of the '<em>Instance Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_VARIABLE_DECLARATION_FEATURE_COUNT = STATEFUL_VARIABLE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE_DECLARATION__NAME = VARIABLE_DECLARATION__NAME;

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
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_STATEMENT__STATEMENTS = COMPOUND__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Local Variable Declarations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_STATEMENT__LOCAL_VARIABLE_DECLARATIONS = COMPOUND__LOCAL_VARIABLE_DECLARATIONS;

	/**
	 * The number of structural features of the '<em>Compound Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_STATEMENT_FEATURE_COUNT = COMPOUND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.il.impl.VariableAccessImpl <em>Variable Access</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.il.impl.VariableAccessImpl
	 * @see org.eclipselabs.mscript.language.il.impl.ILPackageImpl#getVariableAccess()
	 * @generated
	 */
	int VARIABLE_ACCESS = 11;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ACCESS__TARGET = 0;

	/**
	 * The feature id for the '<em><b>Step Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ACCESS__STEP_INDEX = 1;

	/**
	 * The number of structural features of the '<em>Variable Access</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ACCESS_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.il.impl.AssignmentImpl <em>Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.il.impl.AssignmentImpl
	 * @see org.eclipselabs.mscript.language.il.impl.ILPackageImpl#getAssignment()
	 * @generated
	 */
	int ASSIGNMENT = 12;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__TARGET = VARIABLE_ACCESS__TARGET;

	/**
	 * The feature id for the '<em><b>Step Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__STEP_INDEX = VARIABLE_ACCESS__STEP_INDEX;

	/**
	 * The feature id for the '<em><b>Assigned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__ASSIGNED_EXPRESSION = VARIABLE_ACCESS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_FEATURE_COUNT = VARIABLE_ACCESS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.il.impl.ForeachStatementImpl <em>Foreach Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.il.impl.ForeachStatementImpl
	 * @see org.eclipselabs.mscript.language.il.impl.ILPackageImpl#getForeachStatement()
	 * @generated
	 */
	int FOREACH_STATEMENT = 13;

	/**
	 * The feature id for the '<em><b>Iteration Variable Declaration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREACH_STATEMENT__ITERATION_VARIABLE_DECLARATION = AstPackage.STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Collection Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREACH_STATEMENT__COLLECTION_EXPRESSION = AstPackage.STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREACH_STATEMENT__BODY = AstPackage.STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Foreach Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREACH_STATEMENT_FEATURE_COUNT = AstPackage.STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.il.impl.VariableReferenceImpl <em>Variable Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.il.impl.VariableReferenceImpl
	 * @see org.eclipselabs.mscript.language.il.impl.ILPackageImpl#getVariableReference()
	 * @generated
	 */
	int VARIABLE_REFERENCE = 14;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REFERENCE__TARGET = VARIABLE_ACCESS__TARGET;

	/**
	 * The feature id for the '<em><b>Step Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REFERENCE__STEP_INDEX = VARIABLE_ACCESS__STEP_INDEX;

	/**
	 * The feature id for the '<em><b>Array Indices</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REFERENCE__ARRAY_INDICES = VARIABLE_ACCESS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REFERENCE_FEATURE_COUNT = VARIABLE_ACCESS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.il.impl.InvalidExpressionImpl <em>Invalid Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.il.impl.InvalidExpressionImpl
	 * @see org.eclipselabs.mscript.language.il.impl.ILPackageImpl#getInvalidExpression()
	 * @generated
	 */
	int INVALID_EXPRESSION = 15;

	/**
	 * The number of structural features of the '<em>Invalid Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_EXPRESSION_FEATURE_COUNT = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.il.ILFunctionDefinition <em>Function Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Definition</em>'.
	 * @see org.eclipselabs.mscript.language.il.ILFunctionDefinition
	 * @generated
	 */
	EClass getILFunctionDefinition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.il.ILFunctionDefinition#isStateful <em>Stateful</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stateful</em>'.
	 * @see org.eclipselabs.mscript.language.il.ILFunctionDefinition#isStateful()
	 * @see #getILFunctionDefinition()
	 * @generated
	 */
	EAttribute getILFunctionDefinition_Stateful();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.il.ILFunctionDefinition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.mscript.language.il.ILFunctionDefinition#getName()
	 * @see #getILFunctionDefinition()
	 * @generated
	 */
	EAttribute getILFunctionDefinition_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.il.ILFunctionDefinition#getTemplateVariableDeclarations <em>Template Variable Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Template Variable Declarations</em>'.
	 * @see org.eclipselabs.mscript.language.il.ILFunctionDefinition#getTemplateVariableDeclarations()
	 * @see #getILFunctionDefinition()
	 * @generated
	 */
	EReference getILFunctionDefinition_TemplateVariableDeclarations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.il.ILFunctionDefinition#getInputVariableDeclarations <em>Input Variable Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Variable Declarations</em>'.
	 * @see org.eclipselabs.mscript.language.il.ILFunctionDefinition#getInputVariableDeclarations()
	 * @see #getILFunctionDefinition()
	 * @generated
	 */
	EReference getILFunctionDefinition_InputVariableDeclarations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.il.ILFunctionDefinition#getOutputVariableDeclarations <em>Output Variable Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Variable Declarations</em>'.
	 * @see org.eclipselabs.mscript.language.il.ILFunctionDefinition#getOutputVariableDeclarations()
	 * @see #getILFunctionDefinition()
	 * @generated
	 */
	EReference getILFunctionDefinition_OutputVariableDeclarations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.il.ILFunctionDefinition#getInstanceVariableDeclarations <em>Instance Variable Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Instance Variable Declarations</em>'.
	 * @see org.eclipselabs.mscript.language.il.ILFunctionDefinition#getInstanceVariableDeclarations()
	 * @see #getILFunctionDefinition()
	 * @generated
	 */
	EReference getILFunctionDefinition_InstanceVariableDeclarations();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.il.ILFunctionDefinition#getInitializationCompound <em>Initialization Compound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initialization Compound</em>'.
	 * @see org.eclipselabs.mscript.language.il.ILFunctionDefinition#getInitializationCompound()
	 * @see #getILFunctionDefinition()
	 * @generated
	 */
	EReference getILFunctionDefinition_InitializationCompound();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.il.ILFunctionDefinition#getComputationCompounds <em>Computation Compounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Computation Compounds</em>'.
	 * @see org.eclipselabs.mscript.language.il.ILFunctionDefinition#getComputationCompounds()
	 * @see #getILFunctionDefinition()
	 * @generated
	 */
	EReference getILFunctionDefinition_ComputationCompounds();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.il.CompoundStatement <em>Compound Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compound Statement</em>'.
	 * @see org.eclipselabs.mscript.language.il.CompoundStatement
	 * @generated
	 */
	EClass getCompoundStatement();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.il.VariableAccess <em>Variable Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Access</em>'.
	 * @see org.eclipselabs.mscript.language.il.VariableAccess
	 * @generated
	 */
	EClass getVariableAccess();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.mscript.language.il.VariableAccess#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.eclipselabs.mscript.language.il.VariableAccess#getTarget()
	 * @see #getVariableAccess()
	 * @generated
	 */
	EReference getVariableAccess_Target();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.il.VariableAccess#getStepIndex <em>Step Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Step Index</em>'.
	 * @see org.eclipselabs.mscript.language.il.VariableAccess#getStepIndex()
	 * @see #getVariableAccess()
	 * @generated
	 */
	EAttribute getVariableAccess_StepIndex();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.il.VariableDeclaration <em>Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Declaration</em>'.
	 * @see org.eclipselabs.mscript.language.il.VariableDeclaration
	 * @generated
	 */
	EClass getVariableDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.il.VariableDeclaration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.mscript.language.il.VariableDeclaration#getName()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	EAttribute getVariableDeclaration_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.il.StatefulVariableDeclaration <em>Stateful Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stateful Variable Declaration</em>'.
	 * @see org.eclipselabs.mscript.language.il.StatefulVariableDeclaration
	 * @generated
	 */
	EClass getStatefulVariableDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.il.StatefulVariableDeclaration#getCircularBufferSize <em>Circular Buffer Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Circular Buffer Size</em>'.
	 * @see org.eclipselabs.mscript.language.il.StatefulVariableDeclaration#getCircularBufferSize()
	 * @see #getStatefulVariableDeclaration()
	 * @generated
	 */
	EAttribute getStatefulVariableDeclaration_CircularBufferSize();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.il.TemplateVariableDeclaration <em>Template Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Variable Declaration</em>'.
	 * @see org.eclipselabs.mscript.language.il.TemplateVariableDeclaration
	 * @generated
	 */
	EClass getTemplateVariableDeclaration();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.il.InputVariableDeclaration <em>Input Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Variable Declaration</em>'.
	 * @see org.eclipselabs.mscript.language.il.InputVariableDeclaration
	 * @generated
	 */
	EClass getInputVariableDeclaration();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.mscript.language.il.InputVariableDeclaration#getFeedingCompounds <em>Feeding Compounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Feeding Compounds</em>'.
	 * @see org.eclipselabs.mscript.language.il.InputVariableDeclaration#getFeedingCompounds()
	 * @see #getInputVariableDeclaration()
	 * @generated
	 */
	EReference getInputVariableDeclaration_FeedingCompounds();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.il.InputVariableDeclaration#isDirectFeedthrough <em>Direct Feedthrough</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direct Feedthrough</em>'.
	 * @see org.eclipselabs.mscript.language.il.InputVariableDeclaration#isDirectFeedthrough()
	 * @see #getInputVariableDeclaration()
	 * @generated
	 */
	EAttribute getInputVariableDeclaration_DirectFeedthrough();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.il.OutputVariableDeclaration <em>Output Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Variable Declaration</em>'.
	 * @see org.eclipselabs.mscript.language.il.OutputVariableDeclaration
	 * @generated
	 */
	EClass getOutputVariableDeclaration();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.il.InstanceVariableDeclaration <em>Instance Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance Variable Declaration</em>'.
	 * @see org.eclipselabs.mscript.language.il.InstanceVariableDeclaration
	 * @generated
	 */
	EClass getInstanceVariableDeclaration();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.il.LocalVariableDeclaration <em>Local Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local Variable Declaration</em>'.
	 * @see org.eclipselabs.mscript.language.il.LocalVariableDeclaration
	 * @generated
	 */
	EClass getLocalVariableDeclaration();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.il.LocalVariableDeclaration#getInitializer <em>Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initializer</em>'.
	 * @see org.eclipselabs.mscript.language.il.LocalVariableDeclaration#getInitializer()
	 * @see #getLocalVariableDeclaration()
	 * @generated
	 */
	EReference getLocalVariableDeclaration_Initializer();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.il.Compound <em>Compound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compound</em>'.
	 * @see org.eclipselabs.mscript.language.il.Compound
	 * @generated
	 */
	EClass getCompound();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.il.Compound#getStatements <em>Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statements</em>'.
	 * @see org.eclipselabs.mscript.language.il.Compound#getStatements()
	 * @see #getCompound()
	 * @generated
	 */
	EReference getCompound_Statements();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.mscript.language.il.Compound#getLocalVariableDeclarations <em>Local Variable Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Local Variable Declarations</em>'.
	 * @see org.eclipselabs.mscript.language.il.Compound#getLocalVariableDeclarations()
	 * @see #getCompound()
	 * @generated
	 */
	EReference getCompound_LocalVariableDeclarations();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.il.ComputationCompound <em>Computation Compound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Computation Compound</em>'.
	 * @see org.eclipselabs.mscript.language.il.ComputationCompound
	 * @generated
	 */
	EClass getComputationCompound();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.mscript.language.il.ComputationCompound#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inputs</em>'.
	 * @see org.eclipselabs.mscript.language.il.ComputationCompound#getInputs()
	 * @see #getComputationCompound()
	 * @generated
	 */
	EReference getComputationCompound_Inputs();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.mscript.language.il.ComputationCompound#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outputs</em>'.
	 * @see org.eclipselabs.mscript.language.il.ComputationCompound#getOutputs()
	 * @see #getComputationCompound()
	 * @generated
	 */
	EReference getComputationCompound_Outputs();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.il.Assignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assignment</em>'.
	 * @see org.eclipselabs.mscript.language.il.Assignment
	 * @generated
	 */
	EClass getAssignment();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.il.Assignment#getAssignedExpression <em>Assigned Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Assigned Expression</em>'.
	 * @see org.eclipselabs.mscript.language.il.Assignment#getAssignedExpression()
	 * @see #getAssignment()
	 * @generated
	 */
	EReference getAssignment_AssignedExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.il.ForeachStatement <em>Foreach Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Foreach Statement</em>'.
	 * @see org.eclipselabs.mscript.language.il.ForeachStatement
	 * @generated
	 */
	EClass getForeachStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.il.ForeachStatement#getIterationVariableDeclaration <em>Iteration Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Iteration Variable Declaration</em>'.
	 * @see org.eclipselabs.mscript.language.il.ForeachStatement#getIterationVariableDeclaration()
	 * @see #getForeachStatement()
	 * @generated
	 */
	EReference getForeachStatement_IterationVariableDeclaration();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.il.ForeachStatement#getCollectionExpression <em>Collection Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Collection Expression</em>'.
	 * @see org.eclipselabs.mscript.language.il.ForeachStatement#getCollectionExpression()
	 * @see #getForeachStatement()
	 * @generated
	 */
	EReference getForeachStatement_CollectionExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.il.ForeachStatement#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipselabs.mscript.language.il.ForeachStatement#getBody()
	 * @see #getForeachStatement()
	 * @generated
	 */
	EReference getForeachStatement_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.il.VariableReference <em>Variable Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Reference</em>'.
	 * @see org.eclipselabs.mscript.language.il.VariableReference
	 * @generated
	 */
	EClass getVariableReference();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.il.VariableReference#getArrayIndices <em>Array Indices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Array Indices</em>'.
	 * @see org.eclipselabs.mscript.language.il.VariableReference#getArrayIndices()
	 * @see #getVariableReference()
	 * @generated
	 */
	EReference getVariableReference_ArrayIndices();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.il.InvalidExpression <em>Invalid Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invalid Expression</em>'.
	 * @see org.eclipselabs.mscript.language.il.InvalidExpression
	 * @generated
	 */
	EClass getInvalidExpression();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ILFactory getILFactory();

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
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.il.impl.ILFunctionDefinitionImpl <em>Function Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.il.impl.ILFunctionDefinitionImpl
		 * @see org.eclipselabs.mscript.language.il.impl.ILPackageImpl#getILFunctionDefinition()
		 * @generated
		 */
		EClass IL_FUNCTION_DEFINITION = eINSTANCE.getILFunctionDefinition();

		/**
		 * The meta object literal for the '<em><b>Stateful</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IL_FUNCTION_DEFINITION__STATEFUL = eINSTANCE.getILFunctionDefinition_Stateful();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IL_FUNCTION_DEFINITION__NAME = eINSTANCE.getILFunctionDefinition_Name();

		/**
		 * The meta object literal for the '<em><b>Template Variable Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IL_FUNCTION_DEFINITION__TEMPLATE_VARIABLE_DECLARATIONS = eINSTANCE.getILFunctionDefinition_TemplateVariableDeclarations();

		/**
		 * The meta object literal for the '<em><b>Input Variable Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IL_FUNCTION_DEFINITION__INPUT_VARIABLE_DECLARATIONS = eINSTANCE.getILFunctionDefinition_InputVariableDeclarations();

		/**
		 * The meta object literal for the '<em><b>Output Variable Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IL_FUNCTION_DEFINITION__OUTPUT_VARIABLE_DECLARATIONS = eINSTANCE.getILFunctionDefinition_OutputVariableDeclarations();

		/**
		 * The meta object literal for the '<em><b>Instance Variable Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IL_FUNCTION_DEFINITION__INSTANCE_VARIABLE_DECLARATIONS = eINSTANCE.getILFunctionDefinition_InstanceVariableDeclarations();

		/**
		 * The meta object literal for the '<em><b>Initialization Compound</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IL_FUNCTION_DEFINITION__INITIALIZATION_COMPOUND = eINSTANCE.getILFunctionDefinition_InitializationCompound();

		/**
		 * The meta object literal for the '<em><b>Computation Compounds</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IL_FUNCTION_DEFINITION__COMPUTATION_COMPOUNDS = eINSTANCE.getILFunctionDefinition_ComputationCompounds();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.il.impl.CompoundStatementImpl <em>Compound Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.il.impl.CompoundStatementImpl
		 * @see org.eclipselabs.mscript.language.il.impl.ILPackageImpl#getCompoundStatement()
		 * @generated
		 */
		EClass COMPOUND_STATEMENT = eINSTANCE.getCompoundStatement();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.il.impl.VariableAccessImpl <em>Variable Access</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.il.impl.VariableAccessImpl
		 * @see org.eclipselabs.mscript.language.il.impl.ILPackageImpl#getVariableAccess()
		 * @generated
		 */
		EClass VARIABLE_ACCESS = eINSTANCE.getVariableAccess();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_ACCESS__TARGET = eINSTANCE.getVariableAccess_Target();

		/**
		 * The meta object literal for the '<em><b>Step Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_ACCESS__STEP_INDEX = eINSTANCE.getVariableAccess_StepIndex();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.il.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.il.impl.VariableDeclarationImpl
		 * @see org.eclipselabs.mscript.language.il.impl.ILPackageImpl#getVariableDeclaration()
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
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.il.impl.StatefulVariableDeclarationImpl <em>Stateful Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.il.impl.StatefulVariableDeclarationImpl
		 * @see org.eclipselabs.mscript.language.il.impl.ILPackageImpl#getStatefulVariableDeclaration()
		 * @generated
		 */
		EClass STATEFUL_VARIABLE_DECLARATION = eINSTANCE.getStatefulVariableDeclaration();

		/**
		 * The meta object literal for the '<em><b>Circular Buffer Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATEFUL_VARIABLE_DECLARATION__CIRCULAR_BUFFER_SIZE = eINSTANCE.getStatefulVariableDeclaration_CircularBufferSize();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.il.impl.TemplateVariableDeclarationImpl <em>Template Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.il.impl.TemplateVariableDeclarationImpl
		 * @see org.eclipselabs.mscript.language.il.impl.ILPackageImpl#getTemplateVariableDeclaration()
		 * @generated
		 */
		EClass TEMPLATE_VARIABLE_DECLARATION = eINSTANCE.getTemplateVariableDeclaration();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.il.impl.InputVariableDeclarationImpl <em>Input Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.il.impl.InputVariableDeclarationImpl
		 * @see org.eclipselabs.mscript.language.il.impl.ILPackageImpl#getInputVariableDeclaration()
		 * @generated
		 */
		EClass INPUT_VARIABLE_DECLARATION = eINSTANCE.getInputVariableDeclaration();

		/**
		 * The meta object literal for the '<em><b>Feeding Compounds</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_VARIABLE_DECLARATION__FEEDING_COMPOUNDS = eINSTANCE.getInputVariableDeclaration_FeedingCompounds();

		/**
		 * The meta object literal for the '<em><b>Direct Feedthrough</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INPUT_VARIABLE_DECLARATION__DIRECT_FEEDTHROUGH = eINSTANCE.getInputVariableDeclaration_DirectFeedthrough();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.il.impl.OutputVariableDeclarationImpl <em>Output Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.il.impl.OutputVariableDeclarationImpl
		 * @see org.eclipselabs.mscript.language.il.impl.ILPackageImpl#getOutputVariableDeclaration()
		 * @generated
		 */
		EClass OUTPUT_VARIABLE_DECLARATION = eINSTANCE.getOutputVariableDeclaration();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.il.impl.InstanceVariableDeclarationImpl <em>Instance Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.il.impl.InstanceVariableDeclarationImpl
		 * @see org.eclipselabs.mscript.language.il.impl.ILPackageImpl#getInstanceVariableDeclaration()
		 * @generated
		 */
		EClass INSTANCE_VARIABLE_DECLARATION = eINSTANCE.getInstanceVariableDeclaration();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.il.impl.LocalVariableDeclarationImpl <em>Local Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.il.impl.LocalVariableDeclarationImpl
		 * @see org.eclipselabs.mscript.language.il.impl.ILPackageImpl#getLocalVariableDeclaration()
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
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.il.impl.CompoundImpl <em>Compound</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.il.impl.CompoundImpl
		 * @see org.eclipselabs.mscript.language.il.impl.ILPackageImpl#getCompound()
		 * @generated
		 */
		EClass COMPOUND = eINSTANCE.getCompound();

		/**
		 * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOUND__STATEMENTS = eINSTANCE.getCompound_Statements();

		/**
		 * The meta object literal for the '<em><b>Local Variable Declarations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOUND__LOCAL_VARIABLE_DECLARATIONS = eINSTANCE.getCompound_LocalVariableDeclarations();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.il.impl.ComputationCompoundImpl <em>Computation Compound</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.il.impl.ComputationCompoundImpl
		 * @see org.eclipselabs.mscript.language.il.impl.ILPackageImpl#getComputationCompound()
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
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.il.impl.AssignmentImpl <em>Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.il.impl.AssignmentImpl
		 * @see org.eclipselabs.mscript.language.il.impl.ILPackageImpl#getAssignment()
		 * @generated
		 */
		EClass ASSIGNMENT = eINSTANCE.getAssignment();

		/**
		 * The meta object literal for the '<em><b>Assigned Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT__ASSIGNED_EXPRESSION = eINSTANCE.getAssignment_AssignedExpression();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.il.impl.ForeachStatementImpl <em>Foreach Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.il.impl.ForeachStatementImpl
		 * @see org.eclipselabs.mscript.language.il.impl.ILPackageImpl#getForeachStatement()
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
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.il.impl.VariableReferenceImpl <em>Variable Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.il.impl.VariableReferenceImpl
		 * @see org.eclipselabs.mscript.language.il.impl.ILPackageImpl#getVariableReference()
		 * @generated
		 */
		EClass VARIABLE_REFERENCE = eINSTANCE.getVariableReference();

		/**
		 * The meta object literal for the '<em><b>Array Indices</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_REFERENCE__ARRAY_INDICES = eINSTANCE.getVariableReference_ArrayIndices();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.il.impl.InvalidExpressionImpl <em>Invalid Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.il.impl.InvalidExpressionImpl
		 * @see org.eclipselabs.mscript.language.il.impl.ILPackageImpl#getInvalidExpression()
		 * @generated
		 */
		EClass INVALID_EXPRESSION = eINSTANCE.getInvalidExpression();

	}

} //ILPackage
