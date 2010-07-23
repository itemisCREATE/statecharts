/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.typesystem.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipselabs.damos.typesystem.ArrayDimension;
import org.eclipselabs.damos.typesystem.ArrayType;
import org.eclipselabs.damos.typesystem.BooleanType;
import org.eclipselabs.damos.typesystem.Enumeration;
import org.eclipselabs.damos.typesystem.EnumerationLiteral;
import org.eclipselabs.damos.typesystem.IntegerType;
import org.eclipselabs.damos.typesystem.InvalidDataType;
import org.eclipselabs.damos.typesystem.OperatorKind;
import org.eclipselabs.damos.typesystem.RealType;
import org.eclipselabs.damos.typesystem.StringType;
import org.eclipselabs.damos.typesystem.TypeSystem;
import org.eclipselabs.damos.typesystem.TypeSystemFactory;
import org.eclipselabs.damos.typesystem.TypeSystemPackage;
import org.eclipselabs.damos.typesystem.Unit;
import org.eclipselabs.damos.typesystem.UnitFactor;
import org.eclipselabs.damos.typesystem.UnitSymbol;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TypeSystemFactoryImpl extends EFactoryImpl implements TypeSystemFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TypeSystemFactory init() {
		try {
			TypeSystemFactory theTypeSystemFactory = (TypeSystemFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipselabs.org/damos/TypeSystem/1.0.0"); 
			if (theTypeSystemFactory != null) {
				return theTypeSystemFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TypeSystemFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeSystemFactoryImpl() {
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
			case TypeSystemPackage.ARRAY_TYPE: return createArrayType();
			case TypeSystemPackage.ARRAY_DIMENSION: return createArrayDimension();
			case TypeSystemPackage.REAL_TYPE: return createRealType();
			case TypeSystemPackage.UNIT: return createUnit();
			case TypeSystemPackage.UNIT_FACTOR: return createUnitFactor();
			case TypeSystemPackage.INTEGER_TYPE: return createIntegerType();
			case TypeSystemPackage.BOOLEAN_TYPE: return createBooleanType();
			case TypeSystemPackage.STRING_TYPE: return createStringType();
			case TypeSystemPackage.ENUMERATION: return createEnumeration();
			case TypeSystemPackage.ENUMERATION_LITERAL: return createEnumerationLiteral();
			case TypeSystemPackage.INVALID_DATA_TYPE: return createInvalidDataType();
			case TypeSystemPackage.TYPE_SYSTEM: return createTypeSystem();
			case TypeSystemPackage.PACKAGE: return createPackage();
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
			case TypeSystemPackage.OPERATOR_KIND:
				return createOperatorKindFromString(eDataType, initialValue);
			case TypeSystemPackage.UNIT_SYMBOL:
				return createUnitSymbolFromString(eDataType, initialValue);
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
			case TypeSystemPackage.OPERATOR_KIND:
				return convertOperatorKindToString(eDataType, instanceValue);
			case TypeSystemPackage.UNIT_SYMBOL:
				return convertUnitSymbolToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayType createArrayType() {
		ArrayTypeImpl arrayType = new ArrayTypeImpl();
		return arrayType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayDimension createArrayDimension() {
		ArrayDimensionImpl arrayDimension = new ArrayDimensionImpl();
		return arrayDimension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RealType createRealType() {
		RealTypeImpl realType = new RealTypeImpl();
		return realType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Unit createUnit() {
		UnitImpl unit = new UnitImpl();
		return unit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitFactor createUnitFactor() {
		UnitFactorImpl unitFactor = new UnitFactorImpl();
		return unitFactor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerType createIntegerType() {
		IntegerTypeImpl integerType = new IntegerTypeImpl();
		return integerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanType createBooleanType() {
		BooleanTypeImpl booleanType = new BooleanTypeImpl();
		return booleanType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringType createStringType() {
		StringTypeImpl stringType = new StringTypeImpl();
		return stringType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Enumeration createEnumeration() {
		EnumerationImpl enumeration = new EnumerationImpl();
		return enumeration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationLiteral createEnumerationLiteral() {
		EnumerationLiteralImpl enumerationLiteral = new EnumerationLiteralImpl();
		return enumerationLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvalidDataType createInvalidDataType() {
		InvalidDataTypeImpl invalidDataType = new InvalidDataTypeImpl();
		return invalidDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeSystem createTypeSystem() {
		TypeSystemImpl typeSystem = new TypeSystemImpl();
		return typeSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipselabs.damos.typesystem.Package createPackage() {
		PackageImpl package_ = new PackageImpl();
		return package_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorKind createOperatorKindFromString(EDataType eDataType, String initialValue) {
		OperatorKind result = OperatorKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOperatorKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitSymbol createUnitSymbolFromString(EDataType eDataType, String initialValue) {
		UnitSymbol result = UnitSymbol.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUnitSymbolToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeSystemPackage getTypeSystemPackage() {
		return (TypeSystemPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TypeSystemPackage getPackage() {
		return TypeSystemPackage.eINSTANCE;
	}

} //TypeSystemFactoryImpl
