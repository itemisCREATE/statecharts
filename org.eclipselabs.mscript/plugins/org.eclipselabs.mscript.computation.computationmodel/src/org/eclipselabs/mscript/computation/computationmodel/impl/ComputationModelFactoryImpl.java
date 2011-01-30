/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.computation.computationmodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipselabs.mscript.computation.computationmodel.ComputationModel;
import org.eclipselabs.mscript.computation.computationmodel.ComputationModelFactory;
import org.eclipselabs.mscript.computation.computationmodel.ComputationModelPackage;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointOperation;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointOperationKind;
import org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormat;
import org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormatKind;
import org.eclipselabs.mscript.computation.computationmodel.NumberFormatMapping;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ComputationModelFactoryImpl extends EFactoryImpl implements ComputationModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ComputationModelFactory init() {
		try {
			ComputationModelFactory theComputationModelFactory = (ComputationModelFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipselabs.org/mscript/ComputationModel/1.0.0"); 
			if (theComputationModelFactory != null) {
				return theComputationModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ComputationModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputationModelFactoryImpl() {
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
			case ComputationModelPackage.FLOATING_POINT_FORMAT: return createFloatingPointFormat();
			case ComputationModelPackage.FIXED_POINT_FORMAT: return createFixedPointFormat();
			case ComputationModelPackage.FIXED_POINT_OPERATION: return createFixedPointOperation();
			case ComputationModelPackage.COMPUTATION_MODEL: return createComputationModel();
			case ComputationModelPackage.NUMBER_FORMAT_MAPPING: return createNumberFormatMapping();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ComputationModelPackage.FLOATING_POINT_FORMAT_KIND:
				return createFloatingPointFormatKindFromString(eDataType, initialValue);
			case ComputationModelPackage.FIXED_POINT_OPERATION_KIND:
				return createFixedPointOperationKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ComputationModelPackage.FLOATING_POINT_FORMAT_KIND:
				return convertFloatingPointFormatKindToString(eDataType, instanceValue);
			case ComputationModelPackage.FIXED_POINT_OPERATION_KIND:
				return convertFixedPointOperationKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FloatingPointFormat createFloatingPointFormat() {
		FloatingPointFormatImpl floatingPointFormat = new FloatingPointFormatImpl();
		return floatingPointFormat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FixedPointFormat createFixedPointFormat() {
		FixedPointFormatImpl fixedPointFormat = new FixedPointFormatImpl();
		return fixedPointFormat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FixedPointOperation createFixedPointOperation() {
		FixedPointOperationImpl fixedPointOperation = new FixedPointOperationImpl();
		return fixedPointOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputationModel createComputationModel() {
		ComputationModelImpl computationModel = new ComputationModelImpl();
		return computationModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberFormatMapping createNumberFormatMapping() {
		NumberFormatMappingImpl numberFormatMapping = new NumberFormatMappingImpl();
		return numberFormatMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FloatingPointFormatKind createFloatingPointFormatKindFromString(EDataType eDataType, String initialValue) {
		FloatingPointFormatKind result = FloatingPointFormatKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFloatingPointFormatKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FixedPointOperationKind createFixedPointOperationKindFromString(EDataType eDataType, String initialValue) {
		FixedPointOperationKind result = FixedPointOperationKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFixedPointOperationKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputationModelPackage getComputationModelPackage() {
		return (ComputationModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ComputationModelPackage getPackage() {
		return ComputationModelPackage.eINSTANCE;
	}

} //ComputationModelFactoryImpl
