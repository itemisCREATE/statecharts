/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.typesystem;

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
 * @see org.eclipselabs.damos.typesystem.TypeSystemFactory
 * @model kind="package"
 * @generated
 */
public interface TypeSystemPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "typesystem";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipselabs.org/damos/TypeSystem/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "typesystem";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TypeSystemPackage eINSTANCE = org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.typesystem.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.typesystem.impl.NamedElementImpl
	 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__QUALIFIED_NAME = 1;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAMESPACE = 2;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.typesystem.impl.PackageableElementImpl <em>Packageable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.typesystem.impl.PackageableElementImpl
	 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getPackageableElement()
	 * @generated
	 */
	int PACKAGEABLE_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGEABLE_ELEMENT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGEABLE_ELEMENT__QUALIFIED_NAME = NAMED_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGEABLE_ELEMENT__NAMESPACE = NAMED_ELEMENT__NAMESPACE;

	/**
	 * The number of structural features of the '<em>Packageable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGEABLE_ELEMENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.typesystem.impl.TypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.typesystem.impl.TypeImpl
	 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__NAME = PACKAGEABLE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__QUALIFIED_NAME = PACKAGEABLE_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__NAMESPACE = PACKAGEABLE_ELEMENT__NAMESPACE;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = PACKAGEABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.typesystem.impl.NamespaceImpl <em>Namespace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.typesystem.impl.NamespaceImpl
	 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getNamespace()
	 * @generated
	 */
	int NAMESPACE = 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.typesystem.impl.DataTypeImpl <em>Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.typesystem.impl.DataTypeImpl
	 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 5;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.typesystem.impl.ArrayTypeImpl <em>Array Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.typesystem.impl.ArrayTypeImpl
	 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getArrayType()
	 * @generated
	 */
	int ARRAY_TYPE = 4;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.typesystem.impl.ArrayDimensionImpl <em>Array Dimension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.typesystem.impl.ArrayDimensionImpl
	 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getArrayDimension()
	 * @generated
	 */
	int ARRAY_DIMENSION = 6;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.typesystem.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.typesystem.impl.PrimitiveTypeImpl
	 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getPrimitiveType()
	 * @generated
	 */
	int PRIMITIVE_TYPE = 7;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.typesystem.impl.NumericalTypeImpl <em>Numerical Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.typesystem.impl.NumericalTypeImpl
	 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getNumericalType()
	 * @generated
	 */
	int NUMERICAL_TYPE = 9;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.typesystem.impl.RealTypeImpl <em>Real Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.typesystem.impl.RealTypeImpl
	 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getRealType()
	 * @generated
	 */
	int REAL_TYPE = 8;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.typesystem.impl.UnitImpl <em>Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.typesystem.impl.UnitImpl
	 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getUnit()
	 * @generated
	 */
	int UNIT = 10;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.typesystem.impl.UnitFactorImpl <em>Unit Factor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.typesystem.impl.UnitFactorImpl
	 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getUnitFactor()
	 * @generated
	 */
	int UNIT_FACTOR = 11;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.typesystem.impl.IntegerTypeImpl <em>Integer Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.typesystem.impl.IntegerTypeImpl
	 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getIntegerType()
	 * @generated
	 */
	int INTEGER_TYPE = 12;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.typesystem.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.typesystem.impl.BooleanTypeImpl
	 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getBooleanType()
	 * @generated
	 */
	int BOOLEAN_TYPE = 13;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.typesystem.impl.StringTypeImpl <em>String Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.typesystem.impl.StringTypeImpl
	 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getStringType()
	 * @generated
	 */
	int STRING_TYPE = 14;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.typesystem.impl.EnumerationImpl <em>Enumeration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.typesystem.impl.EnumerationImpl
	 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getEnumeration()
	 * @generated
	 */
	int ENUMERATION = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE__QUALIFIED_NAME = NAMED_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE__NAMESPACE = NAMED_ELEMENT__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Members</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE__MEMBERS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Members</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE__OWNED_MEMBERS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Namespace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__NAME = TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__QUALIFIED_NAME = TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__NAMESPACE = TYPE__NAMESPACE;

	/**
	 * The number of structural features of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE__NAME = DATA_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE__QUALIFIED_NAME = DATA_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE__NAMESPACE = DATA_TYPE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE__ELEMENT_TYPE = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE__DIMENSIONS = DATA_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Dimensionality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE__DIMENSIONALITY = DATA_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Row Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE__ROW_SIZE = DATA_TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Column Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE__COLUMN_SIZE = DATA_TYPE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Dimensional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE__DIMENSIONAL = DATA_TYPE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Multidimensional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE__MULTIDIMENSIONAL = DATA_TYPE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Array Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>From Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_DIMENSION__FROM_INDEX = 0;

	/**
	 * The feature id for the '<em><b>To Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_DIMENSION__TO_INDEX = 1;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_DIMENSION__SIZE = 2;

	/**
	 * The number of structural features of the '<em>Array Dimension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_DIMENSION_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__NAME = DATA_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__QUALIFIED_NAME = DATA_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__NAMESPACE = DATA_TYPE__NAMESPACE;

	/**
	 * The number of structural features of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_TYPE__NAME = PRIMITIVE_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_TYPE__QUALIFIED_NAME = PRIMITIVE_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_TYPE__NAMESPACE = PRIMITIVE_TYPE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_TYPE__UNIT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Numerical Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERICAL_TYPE_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE__NAME = NUMERICAL_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE__QUALIFIED_NAME = NUMERICAL_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE__NAMESPACE = NUMERICAL_TYPE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE__UNIT = NUMERICAL_TYPE__UNIT;

	/**
	 * The number of structural features of the '<em>Real Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE_FEATURE_COUNT = NUMERICAL_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Factors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__FACTORS = 0;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__SCALE = 1;

	/**
	 * The number of structural features of the '<em>Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_FACTOR__SYMBOL = 0;

	/**
	 * The feature id for the '<em><b>Exponent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_FACTOR__EXPONENT = 1;

	/**
	 * The number of structural features of the '<em>Unit Factor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_FACTOR_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE__NAME = NUMERICAL_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE__QUALIFIED_NAME = NUMERICAL_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE__NAMESPACE = NUMERICAL_TYPE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE__UNIT = NUMERICAL_TYPE__UNIT;

	/**
	 * The number of structural features of the '<em>Integer Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE_FEATURE_COUNT = NUMERICAL_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE__NAME = PRIMITIVE_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE__QUALIFIED_NAME = PRIMITIVE_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE__NAMESPACE = PRIMITIVE_TYPE__NAMESPACE;

	/**
	 * The number of structural features of the '<em>Boolean Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE__NAME = PRIMITIVE_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE__QUALIFIED_NAME = PRIMITIVE_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE__NAMESPACE = PRIMITIVE_TYPE__NAMESPACE;

	/**
	 * The number of structural features of the '<em>String Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__NAME = NAMESPACE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__QUALIFIED_NAME = NAMESPACE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__NAMESPACE = NAMESPACE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Members</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__MEMBERS = NAMESPACE__MEMBERS;

	/**
	 * The feature id for the '<em><b>Owned Members</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__OWNED_MEMBERS = NAMESPACE__OWNED_MEMBERS;

	/**
	 * The feature id for the '<em><b>Literals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION__LITERALS = NAMESPACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enumeration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_FEATURE_COUNT = NAMESPACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.typesystem.impl.EnumerationLiteralImpl <em>Enumeration Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.typesystem.impl.EnumerationLiteralImpl
	 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getEnumerationLiteral()
	 * @generated
	 */
	int ENUMERATION_LITERAL = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__QUALIFIED_NAME = NAMED_ELEMENT__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__NAMESPACE = NAMED_ELEMENT__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Enumeration</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL__ENUMERATION = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enumeration Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.typesystem.impl.InvalidDataTypeImpl <em>Invalid Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.typesystem.impl.InvalidDataTypeImpl
	 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getInvalidDataType()
	 * @generated
	 */
	int INVALID_DATA_TYPE = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_DATA_TYPE__NAME = DATA_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_DATA_TYPE__QUALIFIED_NAME = DATA_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_DATA_TYPE__NAMESPACE = DATA_TYPE__NAMESPACE;

	/**
	 * The number of structural features of the '<em>Invalid Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_DATA_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.typesystem.impl.TypeSystemImpl <em>Type System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemImpl
	 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getTypeSystem()
	 * @generated
	 */
	int TYPE_SYSTEM = 18;

	/**
	 * The feature id for the '<em><b>Top Level Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SYSTEM__TOP_LEVEL_ELEMENTS = 0;

	/**
	 * The number of structural features of the '<em>Type System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_SYSTEM_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.typesystem.impl.PackageImpl <em>Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.typesystem.impl.PackageImpl
	 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getPackage()
	 * @generated
	 */
	int PACKAGE = 19;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__NAME = NAMESPACE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__QUALIFIED_NAME = NAMESPACE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__NAMESPACE = NAMESPACE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Members</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__MEMBERS = NAMESPACE__MEMBERS;

	/**
	 * The feature id for the '<em><b>Owned Members</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__OWNED_MEMBERS = NAMESPACE__OWNED_MEMBERS;

	/**
	 * The feature id for the '<em><b>Packaged Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__PACKAGED_ELEMENTS = NAMESPACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FEATURE_COUNT = NAMESPACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.typesystem.impl.TensorTypeImpl <em>Tensor Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.typesystem.impl.TensorTypeImpl
	 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getTensorType()
	 * @generated
	 */
	int TENSOR_TYPE = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENSOR_TYPE__NAME = ARRAY_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENSOR_TYPE__QUALIFIED_NAME = ARRAY_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENSOR_TYPE__NAMESPACE = ARRAY_TYPE__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENSOR_TYPE__ELEMENT_TYPE = ARRAY_TYPE__ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENSOR_TYPE__DIMENSIONS = ARRAY_TYPE__DIMENSIONS;

	/**
	 * The feature id for the '<em><b>Dimensionality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENSOR_TYPE__DIMENSIONALITY = ARRAY_TYPE__DIMENSIONALITY;

	/**
	 * The feature id for the '<em><b>Row Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENSOR_TYPE__ROW_SIZE = ARRAY_TYPE__ROW_SIZE;

	/**
	 * The feature id for the '<em><b>Column Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENSOR_TYPE__COLUMN_SIZE = ARRAY_TYPE__COLUMN_SIZE;

	/**
	 * The feature id for the '<em><b>Dimensional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENSOR_TYPE__DIMENSIONAL = ARRAY_TYPE__DIMENSIONAL;

	/**
	 * The feature id for the '<em><b>Multidimensional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENSOR_TYPE__MULTIDIMENSIONAL = ARRAY_TYPE__MULTIDIMENSIONAL;

	/**
	 * The feature id for the '<em><b>Vector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENSOR_TYPE__VECTOR = ARRAY_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Matrix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENSOR_TYPE__MATRIX = ARRAY_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Tensor Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENSOR_TYPE_FEATURE_COUNT = ARRAY_TYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.typesystem.OperatorKind <em>Operator Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.typesystem.OperatorKind
	 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getOperatorKind()
	 * @generated
	 */
	int OPERATOR_KIND = 21;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.typesystem.UnitSymbol <em>Unit Symbol</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.typesystem.UnitSymbol
	 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getUnitSymbol()
	 * @generated
	 */
	int UNIT_SYMBOL = 22;

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.typesystem.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see org.eclipselabs.damos.typesystem.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.typesystem.PackageableElement <em>Packageable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Packageable Element</em>'.
	 * @see org.eclipselabs.damos.typesystem.PackageableElement
	 * @generated
	 */
	EClass getPackageableElement();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.typesystem.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see org.eclipselabs.damos.typesystem.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.typesystem.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.damos.typesystem.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.typesystem.NamedElement#getQualifiedName <em>Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualified Name</em>'.
	 * @see org.eclipselabs.damos.typesystem.NamedElement#getQualifiedName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_QualifiedName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.typesystem.NamedElement#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Namespace</em>'.
	 * @see org.eclipselabs.damos.typesystem.NamedElement#getNamespace()
	 * @see #getNamedElement()
	 * @generated
	 */
	EReference getNamedElement_Namespace();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.typesystem.Namespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Namespace</em>'.
	 * @see org.eclipselabs.damos.typesystem.Namespace
	 * @generated
	 */
	EClass getNamespace();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.damos.typesystem.Namespace#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Members</em>'.
	 * @see org.eclipselabs.damos.typesystem.Namespace#getMembers()
	 * @see #getNamespace()
	 * @generated
	 */
	EReference getNamespace_Members();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.damos.typesystem.Namespace#getOwnedMembers <em>Owned Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Owned Members</em>'.
	 * @see org.eclipselabs.damos.typesystem.Namespace#getOwnedMembers()
	 * @see #getNamespace()
	 * @generated
	 */
	EReference getNamespace_OwnedMembers();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.typesystem.ArrayType <em>Array Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Array Type</em>'.
	 * @see org.eclipselabs.damos.typesystem.ArrayType
	 * @generated
	 */
	EClass getArrayType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.typesystem.ArrayType#getElementType <em>Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element Type</em>'.
	 * @see org.eclipselabs.damos.typesystem.ArrayType#getElementType()
	 * @see #getArrayType()
	 * @generated
	 */
	EReference getArrayType_ElementType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.typesystem.ArrayType#getDimensions <em>Dimensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dimensions</em>'.
	 * @see org.eclipselabs.damos.typesystem.ArrayType#getDimensions()
	 * @see #getArrayType()
	 * @generated
	 */
	EReference getArrayType_Dimensions();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.typesystem.ArrayType#getDimensionality <em>Dimensionality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dimensionality</em>'.
	 * @see org.eclipselabs.damos.typesystem.ArrayType#getDimensionality()
	 * @see #getArrayType()
	 * @generated
	 */
	EAttribute getArrayType_Dimensionality();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.typesystem.ArrayType#getRowSize <em>Row Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Row Size</em>'.
	 * @see org.eclipselabs.damos.typesystem.ArrayType#getRowSize()
	 * @see #getArrayType()
	 * @generated
	 */
	EAttribute getArrayType_RowSize();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.typesystem.ArrayType#getColumnSize <em>Column Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Column Size</em>'.
	 * @see org.eclipselabs.damos.typesystem.ArrayType#getColumnSize()
	 * @see #getArrayType()
	 * @generated
	 */
	EAttribute getArrayType_ColumnSize();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.typesystem.ArrayType#isDimensional <em>Dimensional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dimensional</em>'.
	 * @see org.eclipselabs.damos.typesystem.ArrayType#isDimensional()
	 * @see #getArrayType()
	 * @generated
	 */
	EAttribute getArrayType_Dimensional();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.typesystem.ArrayType#isMultidimensional <em>Multidimensional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multidimensional</em>'.
	 * @see org.eclipselabs.damos.typesystem.ArrayType#isMultidimensional()
	 * @see #getArrayType()
	 * @generated
	 */
	EAttribute getArrayType_Multidimensional();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.typesystem.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type</em>'.
	 * @see org.eclipselabs.damos.typesystem.DataType
	 * @generated
	 */
	EClass getDataType();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.typesystem.ArrayDimension <em>Array Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Array Dimension</em>'.
	 * @see org.eclipselabs.damos.typesystem.ArrayDimension
	 * @generated
	 */
	EClass getArrayDimension();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.typesystem.ArrayDimension#getFromIndex <em>From Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From Index</em>'.
	 * @see org.eclipselabs.damos.typesystem.ArrayDimension#getFromIndex()
	 * @see #getArrayDimension()
	 * @generated
	 */
	EAttribute getArrayDimension_FromIndex();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.typesystem.ArrayDimension#getToIndex <em>To Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To Index</em>'.
	 * @see org.eclipselabs.damos.typesystem.ArrayDimension#getToIndex()
	 * @see #getArrayDimension()
	 * @generated
	 */
	EAttribute getArrayDimension_ToIndex();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.typesystem.ArrayDimension#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see org.eclipselabs.damos.typesystem.ArrayDimension#getSize()
	 * @see #getArrayDimension()
	 * @generated
	 */
	EAttribute getArrayDimension_Size();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.typesystem.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type</em>'.
	 * @see org.eclipselabs.damos.typesystem.PrimitiveType
	 * @generated
	 */
	EClass getPrimitiveType();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.typesystem.RealType <em>Real Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Type</em>'.
	 * @see org.eclipselabs.damos.typesystem.RealType
	 * @generated
	 */
	EClass getRealType();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.typesystem.NumericalType <em>Numerical Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numerical Type</em>'.
	 * @see org.eclipselabs.damos.typesystem.NumericalType
	 * @generated
	 */
	EClass getNumericalType();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.typesystem.NumericalType#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit</em>'.
	 * @see org.eclipselabs.damos.typesystem.NumericalType#getUnit()
	 * @see #getNumericalType()
	 * @generated
	 */
	EReference getNumericalType_Unit();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.typesystem.Unit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit</em>'.
	 * @see org.eclipselabs.damos.typesystem.Unit
	 * @generated
	 */
	EClass getUnit();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.typesystem.Unit#getFactors <em>Factors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Factors</em>'.
	 * @see org.eclipselabs.damos.typesystem.Unit#getFactors()
	 * @see #getUnit()
	 * @generated
	 */
	EReference getUnit_Factors();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.typesystem.Unit#getScale <em>Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scale</em>'.
	 * @see org.eclipselabs.damos.typesystem.Unit#getScale()
	 * @see #getUnit()
	 * @generated
	 */
	EAttribute getUnit_Scale();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.typesystem.UnitFactor <em>Unit Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit Factor</em>'.
	 * @see org.eclipselabs.damos.typesystem.UnitFactor
	 * @generated
	 */
	EClass getUnitFactor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.typesystem.UnitFactor#getSymbol <em>Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Symbol</em>'.
	 * @see org.eclipselabs.damos.typesystem.UnitFactor#getSymbol()
	 * @see #getUnitFactor()
	 * @generated
	 */
	EAttribute getUnitFactor_Symbol();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.typesystem.UnitFactor#getExponent <em>Exponent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exponent</em>'.
	 * @see org.eclipselabs.damos.typesystem.UnitFactor#getExponent()
	 * @see #getUnitFactor()
	 * @generated
	 */
	EAttribute getUnitFactor_Exponent();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.typesystem.IntegerType <em>Integer Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Type</em>'.
	 * @see org.eclipselabs.damos.typesystem.IntegerType
	 * @generated
	 */
	EClass getIntegerType();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.typesystem.BooleanType <em>Boolean Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Type</em>'.
	 * @see org.eclipselabs.damos.typesystem.BooleanType
	 * @generated
	 */
	EClass getBooleanType();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.typesystem.StringType <em>String Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Type</em>'.
	 * @see org.eclipselabs.damos.typesystem.StringType
	 * @generated
	 */
	EClass getStringType();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.typesystem.Enumeration <em>Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration</em>'.
	 * @see org.eclipselabs.damos.typesystem.Enumeration
	 * @generated
	 */
	EClass getEnumeration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.typesystem.Enumeration#getLiterals <em>Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Literals</em>'.
	 * @see org.eclipselabs.damos.typesystem.Enumeration#getLiterals()
	 * @see #getEnumeration()
	 * @generated
	 */
	EReference getEnumeration_Literals();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.typesystem.EnumerationLiteral <em>Enumeration Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration Literal</em>'.
	 * @see org.eclipselabs.damos.typesystem.EnumerationLiteral
	 * @generated
	 */
	EClass getEnumerationLiteral();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.damos.typesystem.EnumerationLiteral#getEnumeration <em>Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Enumeration</em>'.
	 * @see org.eclipselabs.damos.typesystem.EnumerationLiteral#getEnumeration()
	 * @see #getEnumerationLiteral()
	 * @generated
	 */
	EReference getEnumerationLiteral_Enumeration();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.typesystem.InvalidDataType <em>Invalid Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invalid Data Type</em>'.
	 * @see org.eclipselabs.damos.typesystem.InvalidDataType
	 * @generated
	 */
	EClass getInvalidDataType();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.typesystem.TypeSystem <em>Type System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type System</em>'.
	 * @see org.eclipselabs.damos.typesystem.TypeSystem
	 * @generated
	 */
	EClass getTypeSystem();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.typesystem.TypeSystem#getTopLevelElements <em>Top Level Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Top Level Elements</em>'.
	 * @see org.eclipselabs.damos.typesystem.TypeSystem#getTopLevelElements()
	 * @see #getTypeSystem()
	 * @generated
	 */
	EReference getTypeSystem_TopLevelElements();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.typesystem.Package <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package</em>'.
	 * @see org.eclipselabs.damos.typesystem.Package
	 * @generated
	 */
	EClass getPackage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.typesystem.Package#getPackagedElements <em>Packaged Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Packaged Elements</em>'.
	 * @see org.eclipselabs.damos.typesystem.Package#getPackagedElements()
	 * @see #getPackage()
	 * @generated
	 */
	EReference getPackage_PackagedElements();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.typesystem.TensorType <em>Tensor Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tensor Type</em>'.
	 * @see org.eclipselabs.damos.typesystem.TensorType
	 * @generated
	 */
	EClass getTensorType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.typesystem.TensorType#isVector <em>Vector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vector</em>'.
	 * @see org.eclipselabs.damos.typesystem.TensorType#isVector()
	 * @see #getTensorType()
	 * @generated
	 */
	EAttribute getTensorType_Vector();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.typesystem.TensorType#isMatrix <em>Matrix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Matrix</em>'.
	 * @see org.eclipselabs.damos.typesystem.TensorType#isMatrix()
	 * @see #getTensorType()
	 * @generated
	 */
	EAttribute getTensorType_Matrix();

	/**
	 * Returns the meta object for enum '{@link org.eclipselabs.damos.typesystem.OperatorKind <em>Operator Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Operator Kind</em>'.
	 * @see org.eclipselabs.damos.typesystem.OperatorKind
	 * @generated
	 */
	EEnum getOperatorKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipselabs.damos.typesystem.UnitSymbol <em>Unit Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Unit Symbol</em>'.
	 * @see org.eclipselabs.damos.typesystem.UnitSymbol
	 * @generated
	 */
	EEnum getUnitSymbol();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TypeSystemFactory getTypeSystemFactory();

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
		 * The meta object literal for the '{@link org.eclipselabs.damos.typesystem.impl.TypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.typesystem.impl.TypeImpl
		 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.typesystem.impl.PackageableElementImpl <em>Packageable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.typesystem.impl.PackageableElementImpl
		 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getPackageableElement()
		 * @generated
		 */
		EClass PACKAGEABLE_ELEMENT = eINSTANCE.getPackageableElement();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.typesystem.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.typesystem.impl.NamedElementImpl
		 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__QUALIFIED_NAME = eINSTANCE.getNamedElement_QualifiedName();

		/**
		 * The meta object literal for the '<em><b>Namespace</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAMED_ELEMENT__NAMESPACE = eINSTANCE.getNamedElement_Namespace();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.typesystem.impl.NamespaceImpl <em>Namespace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.typesystem.impl.NamespaceImpl
		 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getNamespace()
		 * @generated
		 */
		EClass NAMESPACE = eINSTANCE.getNamespace();

		/**
		 * The meta object literal for the '<em><b>Members</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAMESPACE__MEMBERS = eINSTANCE.getNamespace_Members();

		/**
		 * The meta object literal for the '<em><b>Owned Members</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAMESPACE__OWNED_MEMBERS = eINSTANCE.getNamespace_OwnedMembers();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.typesystem.impl.ArrayTypeImpl <em>Array Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.typesystem.impl.ArrayTypeImpl
		 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getArrayType()
		 * @generated
		 */
		EClass ARRAY_TYPE = eINSTANCE.getArrayType();

		/**
		 * The meta object literal for the '<em><b>Element Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY_TYPE__ELEMENT_TYPE = eINSTANCE.getArrayType_ElementType();

		/**
		 * The meta object literal for the '<em><b>Dimensions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY_TYPE__DIMENSIONS = eINSTANCE.getArrayType_Dimensions();

		/**
		 * The meta object literal for the '<em><b>Dimensionality</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARRAY_TYPE__DIMENSIONALITY = eINSTANCE.getArrayType_Dimensionality();

		/**
		 * The meta object literal for the '<em><b>Row Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARRAY_TYPE__ROW_SIZE = eINSTANCE.getArrayType_RowSize();

		/**
		 * The meta object literal for the '<em><b>Column Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARRAY_TYPE__COLUMN_SIZE = eINSTANCE.getArrayType_ColumnSize();

		/**
		 * The meta object literal for the '<em><b>Dimensional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARRAY_TYPE__DIMENSIONAL = eINSTANCE.getArrayType_Dimensional();

		/**
		 * The meta object literal for the '<em><b>Multidimensional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARRAY_TYPE__MULTIDIMENSIONAL = eINSTANCE.getArrayType_Multidimensional();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.typesystem.impl.DataTypeImpl <em>Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.typesystem.impl.DataTypeImpl
		 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getDataType()
		 * @generated
		 */
		EClass DATA_TYPE = eINSTANCE.getDataType();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.typesystem.impl.ArrayDimensionImpl <em>Array Dimension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.typesystem.impl.ArrayDimensionImpl
		 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getArrayDimension()
		 * @generated
		 */
		EClass ARRAY_DIMENSION = eINSTANCE.getArrayDimension();

		/**
		 * The meta object literal for the '<em><b>From Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARRAY_DIMENSION__FROM_INDEX = eINSTANCE.getArrayDimension_FromIndex();

		/**
		 * The meta object literal for the '<em><b>To Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARRAY_DIMENSION__TO_INDEX = eINSTANCE.getArrayDimension_ToIndex();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARRAY_DIMENSION__SIZE = eINSTANCE.getArrayDimension_Size();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.typesystem.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.typesystem.impl.PrimitiveTypeImpl
		 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getPrimitiveType()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.typesystem.impl.RealTypeImpl <em>Real Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.typesystem.impl.RealTypeImpl
		 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getRealType()
		 * @generated
		 */
		EClass REAL_TYPE = eINSTANCE.getRealType();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.typesystem.impl.NumericalTypeImpl <em>Numerical Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.typesystem.impl.NumericalTypeImpl
		 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getNumericalType()
		 * @generated
		 */
		EClass NUMERICAL_TYPE = eINSTANCE.getNumericalType();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUMERICAL_TYPE__UNIT = eINSTANCE.getNumericalType_Unit();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.typesystem.impl.UnitImpl <em>Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.typesystem.impl.UnitImpl
		 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getUnit()
		 * @generated
		 */
		EClass UNIT = eINSTANCE.getUnit();

		/**
		 * The meta object literal for the '<em><b>Factors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT__FACTORS = eINSTANCE.getUnit_Factors();

		/**
		 * The meta object literal for the '<em><b>Scale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT__SCALE = eINSTANCE.getUnit_Scale();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.typesystem.impl.UnitFactorImpl <em>Unit Factor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.typesystem.impl.UnitFactorImpl
		 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getUnitFactor()
		 * @generated
		 */
		EClass UNIT_FACTOR = eINSTANCE.getUnitFactor();

		/**
		 * The meta object literal for the '<em><b>Symbol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT_FACTOR__SYMBOL = eINSTANCE.getUnitFactor_Symbol();

		/**
		 * The meta object literal for the '<em><b>Exponent</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT_FACTOR__EXPONENT = eINSTANCE.getUnitFactor_Exponent();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.typesystem.impl.IntegerTypeImpl <em>Integer Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.typesystem.impl.IntegerTypeImpl
		 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getIntegerType()
		 * @generated
		 */
		EClass INTEGER_TYPE = eINSTANCE.getIntegerType();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.typesystem.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.typesystem.impl.BooleanTypeImpl
		 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getBooleanType()
		 * @generated
		 */
		EClass BOOLEAN_TYPE = eINSTANCE.getBooleanType();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.typesystem.impl.StringTypeImpl <em>String Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.typesystem.impl.StringTypeImpl
		 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getStringType()
		 * @generated
		 */
		EClass STRING_TYPE = eINSTANCE.getStringType();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.typesystem.impl.EnumerationImpl <em>Enumeration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.typesystem.impl.EnumerationImpl
		 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getEnumeration()
		 * @generated
		 */
		EClass ENUMERATION = eINSTANCE.getEnumeration();

		/**
		 * The meta object literal for the '<em><b>Literals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION__LITERALS = eINSTANCE.getEnumeration_Literals();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.typesystem.impl.EnumerationLiteralImpl <em>Enumeration Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.typesystem.impl.EnumerationLiteralImpl
		 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getEnumerationLiteral()
		 * @generated
		 */
		EClass ENUMERATION_LITERAL = eINSTANCE.getEnumerationLiteral();

		/**
		 * The meta object literal for the '<em><b>Enumeration</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION_LITERAL__ENUMERATION = eINSTANCE.getEnumerationLiteral_Enumeration();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.typesystem.impl.InvalidDataTypeImpl <em>Invalid Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.typesystem.impl.InvalidDataTypeImpl
		 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getInvalidDataType()
		 * @generated
		 */
		EClass INVALID_DATA_TYPE = eINSTANCE.getInvalidDataType();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.typesystem.impl.TypeSystemImpl <em>Type System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemImpl
		 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getTypeSystem()
		 * @generated
		 */
		EClass TYPE_SYSTEM = eINSTANCE.getTypeSystem();

		/**
		 * The meta object literal for the '<em><b>Top Level Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_SYSTEM__TOP_LEVEL_ELEMENTS = eINSTANCE.getTypeSystem_TopLevelElements();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.typesystem.impl.PackageImpl <em>Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.typesystem.impl.PackageImpl
		 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getPackage()
		 * @generated
		 */
		EClass PACKAGE = eINSTANCE.getPackage();

		/**
		 * The meta object literal for the '<em><b>Packaged Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE__PACKAGED_ELEMENTS = eINSTANCE.getPackage_PackagedElements();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.typesystem.impl.TensorTypeImpl <em>Tensor Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.typesystem.impl.TensorTypeImpl
		 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getTensorType()
		 * @generated
		 */
		EClass TENSOR_TYPE = eINSTANCE.getTensorType();

		/**
		 * The meta object literal for the '<em><b>Vector</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TENSOR_TYPE__VECTOR = eINSTANCE.getTensorType_Vector();

		/**
		 * The meta object literal for the '<em><b>Matrix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TENSOR_TYPE__MATRIX = eINSTANCE.getTensorType_Matrix();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.typesystem.OperatorKind <em>Operator Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.typesystem.OperatorKind
		 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getOperatorKind()
		 * @generated
		 */
		EEnum OPERATOR_KIND = eINSTANCE.getOperatorKind();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.typesystem.UnitSymbol <em>Unit Symbol</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.typesystem.UnitSymbol
		 * @see org.eclipselabs.damos.typesystem.impl.TypeSystemPackageImpl#getUnitSymbol()
		 * @generated
		 */
		EEnum UNIT_SYMBOL = eINSTANCE.getUnitSymbol();

	}

} //TypeSystemPackage
