/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.functionmodel.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipselabs.mscript.language.functionmodel.EquationDescriptor;
import org.eclipselabs.mscript.language.functionmodel.EquationPart;
import org.eclipselabs.mscript.language.functionmodel.EquationSide;
import org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor;
import org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage;
import org.eclipselabs.mscript.language.functionmodel.VariableDescriptor;
import org.eclipselabs.mscript.language.functionmodel.VariableKind;
import org.eclipselabs.mscript.language.functionmodel.VariableStep;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage
 * @generated
 */
public class FunctionModelValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final FunctionModelValidator INSTANCE = new FunctionModelValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipselabs.mscript.language.functionmodel";

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Has No Duplicate Equations' of 'Function Descriptor'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FUNCTION_DESCRIPTOR__HAS_NO_DUPLICATE_EQUATIONS = 1;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Has No Cyclic Equations' of 'Function Descriptor'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FUNCTION_DESCRIPTOR__HAS_NO_CYCLIC_EQUATIONS = 2;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Has Equations For Each Output' of 'Function Descriptor'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FUNCTION_DESCRIPTOR__HAS_EQUATIONS_FOR_EACH_OUTPUT = 3;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Has Equations For Each Variable Step' of 'Function Descriptor'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int FUNCTION_DESCRIPTOR__HAS_EQUATIONS_FOR_EACH_VARIABLE_STEP = 4;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Is Left Hand Side Valid' of 'Equation Descriptor'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EQUATION_DESCRIPTOR__IS_LEFT_HAND_SIDE_VALID = 5;

	/**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Is Right Hand Side Valid' of 'Equation Descriptor'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final int EQUATION_DESCRIPTOR__IS_RIGHT_HAND_SIDE_VALID = 6;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 6;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionModelValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return FunctionModelPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case FunctionModelPackage.FUNCTION_DESCRIPTOR:
				return validateFunctionDescriptor((FunctionDescriptor)value, diagnostics, context);
			case FunctionModelPackage.EQUATION_DESCRIPTOR:
				return validateEquationDescriptor((EquationDescriptor)value, diagnostics, context);
			case FunctionModelPackage.EQUATION_SIDE:
				return validateEquationSide((EquationSide)value, diagnostics, context);
			case FunctionModelPackage.EQUATION_PART:
				return validateEquationPart((EquationPart)value, diagnostics, context);
			case FunctionModelPackage.VARIABLE_DESCRIPTOR:
				return validateVariableDescriptor((VariableDescriptor)value, diagnostics, context);
			case FunctionModelPackage.VARIABLE_STEP:
				return validateVariableStep((VariableStep)value, diagnostics, context);
			case FunctionModelPackage.VARIABLE_KIND:
				return validateVariableKind((VariableKind)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunctionDescriptor(FunctionDescriptor functionDescriptor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(functionDescriptor, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(functionDescriptor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(functionDescriptor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(functionDescriptor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(functionDescriptor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(functionDescriptor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(functionDescriptor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(functionDescriptor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(functionDescriptor, diagnostics, context);
		if (result || diagnostics != null) result &= validateFunctionDescriptor_hasNoDuplicateEquations(functionDescriptor, diagnostics, context);
		if (result || diagnostics != null) result &= validateFunctionDescriptor_hasNoCyclicEquations(functionDescriptor, diagnostics, context);
		if (result || diagnostics != null) result &= validateFunctionDescriptor_hasEquationsForEachOutput(functionDescriptor, diagnostics, context);
		if (result || diagnostics != null) result &= validateFunctionDescriptor_hasEquationsForEachVariableStep(functionDescriptor, diagnostics, context);
		return result;
	}

	/**
	 * Validates the hasNoDuplicateEquations constraint of '<em>Function Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunctionDescriptor_hasNoDuplicateEquations(FunctionDescriptor functionDescriptor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return functionDescriptor.hasNoDuplicateEquations(diagnostics, context);
	}

	/**
	 * Validates the hasNoCyclicEquations constraint of '<em>Function Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunctionDescriptor_hasNoCyclicEquations(FunctionDescriptor functionDescriptor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return functionDescriptor.hasNoCyclicEquations(diagnostics, context);
	}

	/**
	 * Validates the hasEquationsForEachOutput constraint of '<em>Function Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunctionDescriptor_hasEquationsForEachOutput(FunctionDescriptor functionDescriptor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return functionDescriptor.hasEquationsForEachOutput(diagnostics, context);
	}

	/**
	 * Validates the hasEquationsForEachVariableStep constraint of '<em>Function Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFunctionDescriptor_hasEquationsForEachVariableStep(FunctionDescriptor functionDescriptor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return functionDescriptor.hasEquationsForEachVariableStep(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEquationDescriptor(EquationDescriptor equationDescriptor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(equationDescriptor, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(equationDescriptor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(equationDescriptor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(equationDescriptor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(equationDescriptor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(equationDescriptor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(equationDescriptor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(equationDescriptor, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(equationDescriptor, diagnostics, context);
		if (result || diagnostics != null) result &= validateEquationDescriptor_isLeftHandSideValid(equationDescriptor, diagnostics, context);
		if (result || diagnostics != null) result &= validateEquationDescriptor_isRightHandSideValid(equationDescriptor, diagnostics, context);
		return result;
	}

	/**
	 * Validates the isLeftHandSideValid constraint of '<em>Equation Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEquationDescriptor_isLeftHandSideValid(EquationDescriptor equationDescriptor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return equationDescriptor.isLeftHandSideValid(diagnostics, context);
	}

	/**
	 * Validates the isRightHandSideValid constraint of '<em>Equation Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEquationDescriptor_isRightHandSideValid(EquationDescriptor equationDescriptor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return equationDescriptor.isRightHandSideValid(diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEquationSide(EquationSide equationSide, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(equationSide, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEquationPart(EquationPart equationPart, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(equationPart, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableDescriptor(VariableDescriptor variableDescriptor, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(variableDescriptor, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableStep(VariableStep variableStep, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(variableStep, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariableKind(VariableKind variableKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //FunctionModelValidator
