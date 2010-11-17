/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.imperativemodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipselabs.mscript.language.imperativemodel.Assignment;
import org.eclipselabs.mscript.language.imperativemodel.CircularBufferDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.Compound;
import org.eclipselabs.mscript.language.imperativemodel.CompoundStatement;
import org.eclipselabs.mscript.language.imperativemodel.ComputationCompound;
import org.eclipselabs.mscript.language.imperativemodel.ForeachStatement;
import org.eclipselabs.mscript.language.imperativemodel.IfStatement;
import org.eclipselabs.mscript.language.imperativemodel.ImperativeModelFactory;
import org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage;
import org.eclipselabs.mscript.language.imperativemodel.InputVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.LocalVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.OutputVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.StateVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.Subroutine;
import org.eclipselabs.mscript.language.imperativemodel.SubroutineContext;
import org.eclipselabs.mscript.language.imperativemodel.TemplateVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.VariableReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ImperativeModelFactoryImpl extends EFactoryImpl implements ImperativeModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ImperativeModelFactory init() {
		try {
			ImperativeModelFactory theImperativeModelFactory = (ImperativeModelFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipselabs.org/mscript/ImperativeModel/1.0.0"); 
			if (theImperativeModelFactory != null) {
				return theImperativeModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ImperativeModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ImperativeModelPackage.SUBROUTINE: return createSubroutine();
			case ImperativeModelPackage.SUBROUTINE_CONTEXT: return createSubroutineContext();
			case ImperativeModelPackage.CIRCULAR_BUFFER_DECLARATION: return createCircularBufferDeclaration();
			case ImperativeModelPackage.COMPOUND: return createCompound();
			case ImperativeModelPackage.COMPUTATION_COMPOUND: return createComputationCompound();
			case ImperativeModelPackage.INPUT_VARIABLE_DECLARATION: return createInputVariableDeclaration();
			case ImperativeModelPackage.OUTPUT_VARIABLE_DECLARATION: return createOutputVariableDeclaration();
			case ImperativeModelPackage.TEMPLATE_VARIABLE_DECLARATION: return createTemplateVariableDeclaration();
			case ImperativeModelPackage.STATE_VARIABLE_DECLARATION: return createStateVariableDeclaration();
			case ImperativeModelPackage.LOCAL_VARIABLE_DECLARATION: return createLocalVariableDeclaration();
			case ImperativeModelPackage.COMPOUND_STATEMENT: return createCompoundStatement();
			case ImperativeModelPackage.ASSIGNMENT: return createAssignment();
			case ImperativeModelPackage.IF_STATEMENT: return createIfStatement();
			case ImperativeModelPackage.FOREACH_STATEMENT: return createForeachStatement();
			case ImperativeModelPackage.VARIABLE_REFERENCE: return createVariableReference();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subroutine createSubroutine() {
		SubroutineImpl subroutine = new SubroutineImpl();
		return subroutine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubroutineContext createSubroutineContext() {
		SubroutineContextImpl subroutineContext = new SubroutineContextImpl();
		return subroutineContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CircularBufferDeclaration createCircularBufferDeclaration() {
		CircularBufferDeclarationImpl circularBufferDeclaration = new CircularBufferDeclarationImpl();
		return circularBufferDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Compound createCompound() {
		CompoundImpl compound = new CompoundImpl();
		return compound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputationCompound createComputationCompound() {
		ComputationCompoundImpl computationCompound = new ComputationCompoundImpl();
		return computationCompound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputVariableDeclaration createInputVariableDeclaration() {
		InputVariableDeclarationImpl inputVariableDeclaration = new InputVariableDeclarationImpl();
		return inputVariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputVariableDeclaration createOutputVariableDeclaration() {
		OutputVariableDeclarationImpl outputVariableDeclaration = new OutputVariableDeclarationImpl();
		return outputVariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateVariableDeclaration createTemplateVariableDeclaration() {
		TemplateVariableDeclarationImpl templateVariableDeclaration = new TemplateVariableDeclarationImpl();
		return templateVariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateVariableDeclaration createStateVariableDeclaration() {
		StateVariableDeclarationImpl stateVariableDeclaration = new StateVariableDeclarationImpl();
		return stateVariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalVariableDeclaration createLocalVariableDeclaration() {
		LocalVariableDeclarationImpl localVariableDeclaration = new LocalVariableDeclarationImpl();
		return localVariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompoundStatement createCompoundStatement() {
		CompoundStatementImpl compoundStatement = new CompoundStatementImpl();
		return compoundStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Assignment createAssignment() {
		AssignmentImpl assignment = new AssignmentImpl();
		return assignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfStatement createIfStatement() {
		IfStatementImpl ifStatement = new IfStatementImpl();
		return ifStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForeachStatement createForeachStatement() {
		ForeachStatementImpl foreachStatement = new ForeachStatementImpl();
		return foreachStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableReference createVariableReference() {
		VariableReferenceImpl variableReference = new VariableReferenceImpl();
		return variableReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeModelPackage getImperativeModelPackage() {
		return (ImperativeModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ImperativeModelPackage getPackage() {
		return ImperativeModelPackage.eINSTANCE;
	}

} //ImperativeModelFactoryImpl
