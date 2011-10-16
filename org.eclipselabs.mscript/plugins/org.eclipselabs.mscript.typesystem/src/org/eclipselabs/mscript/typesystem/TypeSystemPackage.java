/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.typesystem;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see org.eclipselabs.mscript.typesystem.TypeSystemFactory
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
	String eNS_URI = "http://www.eclipselabs.org/mscript/TypeSystem/1.0.0";

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
	TypeSystemPackage eINSTANCE = org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.typesystem.impl.DataTypeImpl <em>Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.typesystem.impl.DataTypeImpl
	 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 0;

	/**
	 * The number of structural features of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.typesystem.impl.InvalidDataTypeImpl <em>Invalid Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.typesystem.impl.InvalidDataTypeImpl
	 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getInvalidDataType()
	 * @generated
	 */
	int INVALID_DATA_TYPE = 1;

	/**
	 * The number of structural features of the '<em>Invalid Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_DATA_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.typesystem.impl.AnyDataTypeImpl <em>Any Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.typesystem.impl.AnyDataTypeImpl
	 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getAnyDataType()
	 * @generated
	 */
	int ANY_DATA_TYPE = 2;

	/**
	 * The number of structural features of the '<em>Any Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANY_DATA_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.typesystem.impl.UnitTypeImpl <em>Unit Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.typesystem.impl.UnitTypeImpl
	 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getUnitType()
	 * @generated
	 */
	int UNIT_TYPE = 3;

	/**
	 * The number of structural features of the '<em>Unit Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.typesystem.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.typesystem.impl.PrimitiveTypeImpl
	 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getPrimitiveType()
	 * @generated
	 */
	int PRIMITIVE_TYPE = 4;

	/**
	 * The number of structural features of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.typesystem.impl.NumericTypeImpl <em>Numeric Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.typesystem.impl.NumericTypeImpl
	 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getNumericType()
	 * @generated
	 */
	int NUMERIC_TYPE = 5;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_TYPE__UNIT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Numeric Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_TYPE_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.typesystem.impl.RealTypeImpl <em>Real Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.typesystem.impl.RealTypeImpl
	 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getRealType()
	 * @generated
	 */
	int REAL_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE__UNIT = NUMERIC_TYPE__UNIT;

	/**
	 * The number of structural features of the '<em>Real Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TYPE_FEATURE_COUNT = NUMERIC_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.typesystem.impl.IntegerTypeImpl <em>Integer Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.typesystem.impl.IntegerTypeImpl
	 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getIntegerType()
	 * @generated
	 */
	int INTEGER_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE__UNIT = NUMERIC_TYPE__UNIT;

	/**
	 * The number of structural features of the '<em>Integer Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE_FEATURE_COUNT = NUMERIC_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.typesystem.impl.ComplexTypeImpl <em>Complex Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.typesystem.impl.ComplexTypeImpl
	 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getComplexType()
	 * @generated
	 */
	int COMPLEX_TYPE = 8;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_TYPE__UNIT = NUMERIC_TYPE__UNIT;

	/**
	 * The number of structural features of the '<em>Complex Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_TYPE_FEATURE_COUNT = NUMERIC_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.typesystem.impl.GaussianTypeImpl <em>Gaussian Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.typesystem.impl.GaussianTypeImpl
	 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getGaussianType()
	 * @generated
	 */
	int GAUSSIAN_TYPE = 9;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_TYPE__UNIT = NUMERIC_TYPE__UNIT;

	/**
	 * The number of structural features of the '<em>Gaussian Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GAUSSIAN_TYPE_FEATURE_COUNT = NUMERIC_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.typesystem.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.typesystem.impl.BooleanTypeImpl
	 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getBooleanType()
	 * @generated
	 */
	int BOOLEAN_TYPE = 10;

	/**
	 * The number of structural features of the '<em>Boolean Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.typesystem.impl.StringTypeImpl <em>String Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.typesystem.impl.StringTypeImpl
	 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getStringType()
	 * @generated
	 */
	int STRING_TYPE = 11;

	/**
	 * The number of structural features of the '<em>String Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE_FEATURE_COUNT = PRIMITIVE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.typesystem.impl.ArrayTypeImpl <em>Array Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.typesystem.impl.ArrayTypeImpl
	 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getArrayType()
	 * @generated
	 */
	int ARRAY_TYPE = 12;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE__ELEMENT_TYPE = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Defined Element Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE__DEFINED_ELEMENT_TYPE = DATA_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Dimensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE__DIMENSIONS = DATA_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Dimensionality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE__DIMENSIONALITY = DATA_TYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Dimensional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE__DIMENSIONAL = DATA_TYPE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Multidimensional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE__MULTIDIMENSIONAL = DATA_TYPE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Array Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.typesystem.impl.TensorTypeImpl <em>Tensor Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.typesystem.impl.TensorTypeImpl
	 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getTensorType()
	 * @generated
	 */
	int TENSOR_TYPE = 13;

	/**
	 * The feature id for the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENSOR_TYPE__ELEMENT_TYPE = ARRAY_TYPE__ELEMENT_TYPE;

	/**
	 * The feature id for the '<em><b>Defined Element Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENSOR_TYPE__DEFINED_ELEMENT_TYPE = ARRAY_TYPE__DEFINED_ELEMENT_TYPE;

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
	 * The meta object id for the '{@link org.eclipselabs.mscript.typesystem.impl.ArrayDimensionImpl <em>Array Dimension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.typesystem.impl.ArrayDimensionImpl
	 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getArrayDimension()
	 * @generated
	 */
	int ARRAY_DIMENSION = 14;

	/**
	 * The feature id for the '<em><b>Size</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_DIMENSION__SIZE = 0;

	/**
	 * The number of structural features of the '<em>Array Dimension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_DIMENSION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.typesystem.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.typesystem.impl.ExpressionImpl
	 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 15;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.typesystem.impl.UnitImpl <em>Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.typesystem.impl.UnitImpl
	 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getUnit()
	 * @generated
	 */
	int UNIT = 16;

	/**
	 * The feature id for the '<em><b>Numerator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__NUMERATOR = 0;

	/**
	 * The feature id for the '<em><b>Denominator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__DENOMINATOR = 1;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__SCALE = 2;

	/**
	 * The feature id for the '<em><b>Wildcard</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__WILDCARD = 3;

	/**
	 * The number of structural features of the '<em>Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.typesystem.impl.UnitProductImpl <em>Unit Product</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.typesystem.impl.UnitProductImpl
	 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getUnitProduct()
	 * @generated
	 */
	int UNIT_PRODUCT = 17;

	/**
	 * The feature id for the '<em><b>Factors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_PRODUCT__FACTORS = 0;

	/**
	 * The number of structural features of the '<em>Unit Product</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_PRODUCT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.typesystem.impl.UnitNumeratorImpl <em>Unit Numerator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.typesystem.impl.UnitNumeratorImpl
	 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getUnitNumerator()
	 * @generated
	 */
	int UNIT_NUMERATOR = 18;

	/**
	 * The feature id for the '<em><b>Factors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_NUMERATOR__FACTORS = UNIT_PRODUCT__FACTORS;

	/**
	 * The number of structural features of the '<em>Unit Numerator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_NUMERATOR_FEATURE_COUNT = UNIT_PRODUCT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.typesystem.impl.UnitDenominatorImpl <em>Unit Denominator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.typesystem.impl.UnitDenominatorImpl
	 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getUnitDenominator()
	 * @generated
	 */
	int UNIT_DENOMINATOR = 19;

	/**
	 * The feature id for the '<em><b>Factors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_DENOMINATOR__FACTORS = UNIT_PRODUCT__FACTORS;

	/**
	 * The number of structural features of the '<em>Unit Denominator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_DENOMINATOR_FEATURE_COUNT = UNIT_PRODUCT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.typesystem.impl.UnitFactorImpl <em>Unit Factor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.typesystem.impl.UnitFactorImpl
	 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getUnitFactor()
	 * @generated
	 */
	int UNIT_FACTOR = 20;

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
	 * The meta object id for the '{@link org.eclipselabs.mscript.typesystem.impl.LiteralImpl <em>Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.typesystem.impl.LiteralImpl
	 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getLiteral()
	 * @generated
	 */
	int LITERAL = 21;

	/**
	 * The number of structural features of the '<em>Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.typesystem.impl.NumericLiteralImpl <em>Numeric Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.typesystem.impl.NumericLiteralImpl
	 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getNumericLiteral()
	 * @generated
	 */
	int NUMERIC_LITERAL = 22;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL__UNIT = LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Numeric Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.typesystem.impl.RealLiteralImpl <em>Real Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.typesystem.impl.RealLiteralImpl
	 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getRealLiteral()
	 * @generated
	 */
	int REAL_LITERAL = 23;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL__UNIT = NUMERIC_LITERAL__UNIT;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL__DATA = NUMERIC_LITERAL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL__VALUE = NUMERIC_LITERAL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Real Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_FEATURE_COUNT = NUMERIC_LITERAL_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.typesystem.impl.IntegerLiteralImpl <em>Integer Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.typesystem.impl.IntegerLiteralImpl
	 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getIntegerLiteral()
	 * @generated
	 */
	int INTEGER_LITERAL = 24;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL__UNIT = NUMERIC_LITERAL__UNIT;

	/**
	 * The feature id for the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL__DATA = NUMERIC_LITERAL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL__VALUE = NUMERIC_LITERAL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Integer Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_FEATURE_COUNT = NUMERIC_LITERAL_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.typesystem.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.typesystem.impl.BooleanLiteralImpl
	 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getBooleanLiteral()
	 * @generated
	 */
	int BOOLEAN_LITERAL = 25;

	/**
	 * The feature id for the '<em><b>True</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL__TRUE = LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.typesystem.impl.StringLiteralImpl <em>String Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.typesystem.impl.StringLiteralImpl
	 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getStringLiteral()
	 * @generated
	 */
	int STRING_LITERAL = 26;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.typesystem.OperatorKind <em>Operator Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.typesystem.OperatorKind
	 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getOperatorKind()
	 * @generated
	 */
	int OPERATOR_KIND = 27;


	/**
	 * The meta object id for the '<em>Real Data</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.typesystem.RealData
	 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getRealData()
	 * @generated
	 */
	int REAL_DATA = 28;

	/**
	 * The meta object id for the '<em>Integer Data</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.typesystem.IntegerData
	 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getIntegerData()
	 * @generated
	 */
	int INTEGER_DATA = 29;


	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.typesystem.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type</em>'.
	 * @see org.eclipselabs.mscript.typesystem.DataType
	 * @generated
	 */
	EClass getDataType();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.typesystem.InvalidDataType <em>Invalid Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invalid Data Type</em>'.
	 * @see org.eclipselabs.mscript.typesystem.InvalidDataType
	 * @generated
	 */
	EClass getInvalidDataType();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.typesystem.AnyDataType <em>Any Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Any Data Type</em>'.
	 * @see org.eclipselabs.mscript.typesystem.AnyDataType
	 * @generated
	 */
	EClass getAnyDataType();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.typesystem.UnitType <em>Unit Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit Type</em>'.
	 * @see org.eclipselabs.mscript.typesystem.UnitType
	 * @generated
	 */
	EClass getUnitType();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.typesystem.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type</em>'.
	 * @see org.eclipselabs.mscript.typesystem.PrimitiveType
	 * @generated
	 */
	EClass getPrimitiveType();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.typesystem.NumericType <em>Numeric Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numeric Type</em>'.
	 * @see org.eclipselabs.mscript.typesystem.NumericType
	 * @generated
	 */
	EClass getNumericType();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.typesystem.NumericType#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit</em>'.
	 * @see org.eclipselabs.mscript.typesystem.NumericType#getUnit()
	 * @see #getNumericType()
	 * @generated
	 */
	EReference getNumericType_Unit();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.typesystem.RealType <em>Real Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Type</em>'.
	 * @see org.eclipselabs.mscript.typesystem.RealType
	 * @generated
	 */
	EClass getRealType();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.typesystem.IntegerType <em>Integer Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Type</em>'.
	 * @see org.eclipselabs.mscript.typesystem.IntegerType
	 * @generated
	 */
	EClass getIntegerType();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.typesystem.ComplexType <em>Complex Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complex Type</em>'.
	 * @see org.eclipselabs.mscript.typesystem.ComplexType
	 * @generated
	 */
	EClass getComplexType();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.typesystem.GaussianType <em>Gaussian Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gaussian Type</em>'.
	 * @see org.eclipselabs.mscript.typesystem.GaussianType
	 * @generated
	 */
	EClass getGaussianType();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.typesystem.BooleanType <em>Boolean Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Type</em>'.
	 * @see org.eclipselabs.mscript.typesystem.BooleanType
	 * @generated
	 */
	EClass getBooleanType();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.typesystem.StringType <em>String Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Type</em>'.
	 * @see org.eclipselabs.mscript.typesystem.StringType
	 * @generated
	 */
	EClass getStringType();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.typesystem.ArrayType <em>Array Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Array Type</em>'.
	 * @see org.eclipselabs.mscript.typesystem.ArrayType
	 * @generated
	 */
	EClass getArrayType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.mscript.typesystem.ArrayType#getElementType <em>Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element Type</em>'.
	 * @see org.eclipselabs.mscript.typesystem.ArrayType#getElementType()
	 * @see #getArrayType()
	 * @generated
	 */
	EReference getArrayType_ElementType();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.typesystem.ArrayType#getDefinedElementType <em>Defined Element Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Defined Element Type</em>'.
	 * @see org.eclipselabs.mscript.typesystem.ArrayType#getDefinedElementType()
	 * @see #getArrayType()
	 * @generated
	 */
	EReference getArrayType_DefinedElementType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.typesystem.ArrayType#getDimensions <em>Dimensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dimensions</em>'.
	 * @see org.eclipselabs.mscript.typesystem.ArrayType#getDimensions()
	 * @see #getArrayType()
	 * @generated
	 */
	EReference getArrayType_Dimensions();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.typesystem.ArrayType#getDimensionality <em>Dimensionality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dimensionality</em>'.
	 * @see org.eclipselabs.mscript.typesystem.ArrayType#getDimensionality()
	 * @see #getArrayType()
	 * @generated
	 */
	EAttribute getArrayType_Dimensionality();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.typesystem.ArrayType#isDimensional <em>Dimensional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dimensional</em>'.
	 * @see org.eclipselabs.mscript.typesystem.ArrayType#isDimensional()
	 * @see #getArrayType()
	 * @generated
	 */
	EAttribute getArrayType_Dimensional();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.typesystem.ArrayType#isMultidimensional <em>Multidimensional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multidimensional</em>'.
	 * @see org.eclipselabs.mscript.typesystem.ArrayType#isMultidimensional()
	 * @see #getArrayType()
	 * @generated
	 */
	EAttribute getArrayType_Multidimensional();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.typesystem.TensorType <em>Tensor Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tensor Type</em>'.
	 * @see org.eclipselabs.mscript.typesystem.TensorType
	 * @generated
	 */
	EClass getTensorType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.typesystem.TensorType#isVector <em>Vector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Vector</em>'.
	 * @see org.eclipselabs.mscript.typesystem.TensorType#isVector()
	 * @see #getTensorType()
	 * @generated
	 */
	EAttribute getTensorType_Vector();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.typesystem.TensorType#isMatrix <em>Matrix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Matrix</em>'.
	 * @see org.eclipselabs.mscript.typesystem.TensorType#isMatrix()
	 * @see #getTensorType()
	 * @generated
	 */
	EAttribute getTensorType_Matrix();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.typesystem.ArrayDimension <em>Array Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Array Dimension</em>'.
	 * @see org.eclipselabs.mscript.typesystem.ArrayDimension
	 * @generated
	 */
	EClass getArrayDimension();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.typesystem.ArrayDimension#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Size</em>'.
	 * @see org.eclipselabs.mscript.typesystem.ArrayDimension#getSize()
	 * @see #getArrayDimension()
	 * @generated
	 */
	EReference getArrayDimension_Size();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.typesystem.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see org.eclipselabs.mscript.typesystem.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.typesystem.Unit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit</em>'.
	 * @see org.eclipselabs.mscript.typesystem.Unit
	 * @generated
	 */
	EClass getUnit();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.typesystem.Unit#getNumerator <em>Numerator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Numerator</em>'.
	 * @see org.eclipselabs.mscript.typesystem.Unit#getNumerator()
	 * @see #getUnit()
	 * @generated
	 */
	EReference getUnit_Numerator();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.typesystem.Unit#getDenominator <em>Denominator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Denominator</em>'.
	 * @see org.eclipselabs.mscript.typesystem.Unit#getDenominator()
	 * @see #getUnit()
	 * @generated
	 */
	EReference getUnit_Denominator();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.typesystem.Unit#getScale <em>Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scale</em>'.
	 * @see org.eclipselabs.mscript.typesystem.Unit#getScale()
	 * @see #getUnit()
	 * @generated
	 */
	EAttribute getUnit_Scale();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.typesystem.Unit#isWildcard <em>Wildcard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wildcard</em>'.
	 * @see org.eclipselabs.mscript.typesystem.Unit#isWildcard()
	 * @see #getUnit()
	 * @generated
	 */
	EAttribute getUnit_Wildcard();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.typesystem.UnitProduct <em>Unit Product</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit Product</em>'.
	 * @see org.eclipselabs.mscript.typesystem.UnitProduct
	 * @generated
	 */
	EClass getUnitProduct();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.typesystem.UnitProduct#getFactors <em>Factors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Factors</em>'.
	 * @see org.eclipselabs.mscript.typesystem.UnitProduct#getFactors()
	 * @see #getUnitProduct()
	 * @generated
	 */
	EReference getUnitProduct_Factors();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.typesystem.UnitNumerator <em>Unit Numerator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit Numerator</em>'.
	 * @see org.eclipselabs.mscript.typesystem.UnitNumerator
	 * @generated
	 */
	EClass getUnitNumerator();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.typesystem.UnitDenominator <em>Unit Denominator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit Denominator</em>'.
	 * @see org.eclipselabs.mscript.typesystem.UnitDenominator
	 * @generated
	 */
	EClass getUnitDenominator();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.typesystem.UnitFactor <em>Unit Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit Factor</em>'.
	 * @see org.eclipselabs.mscript.typesystem.UnitFactor
	 * @generated
	 */
	EClass getUnitFactor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.typesystem.UnitFactor#getSymbol <em>Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Symbol</em>'.
	 * @see org.eclipselabs.mscript.typesystem.UnitFactor#getSymbol()
	 * @see #getUnitFactor()
	 * @generated
	 */
	EAttribute getUnitFactor_Symbol();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.typesystem.UnitFactor#getExponent <em>Exponent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exponent</em>'.
	 * @see org.eclipselabs.mscript.typesystem.UnitFactor#getExponent()
	 * @see #getUnitFactor()
	 * @generated
	 */
	EAttribute getUnitFactor_Exponent();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.typesystem.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal</em>'.
	 * @see org.eclipselabs.mscript.typesystem.Literal
	 * @generated
	 */
	EClass getLiteral();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.typesystem.NumericLiteral <em>Numeric Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numeric Literal</em>'.
	 * @see org.eclipselabs.mscript.typesystem.NumericLiteral
	 * @generated
	 */
	EClass getNumericLiteral();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.typesystem.NumericLiteral#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit</em>'.
	 * @see org.eclipselabs.mscript.typesystem.NumericLiteral#getUnit()
	 * @see #getNumericLiteral()
	 * @generated
	 */
	EReference getNumericLiteral_Unit();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.typesystem.RealLiteral <em>Real Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Literal</em>'.
	 * @see org.eclipselabs.mscript.typesystem.RealLiteral
	 * @generated
	 */
	EClass getRealLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.typesystem.RealLiteral#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data</em>'.
	 * @see org.eclipselabs.mscript.typesystem.RealLiteral#getData()
	 * @see #getRealLiteral()
	 * @generated
	 */
	EAttribute getRealLiteral_Data();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.typesystem.RealLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipselabs.mscript.typesystem.RealLiteral#getValue()
	 * @see #getRealLiteral()
	 * @generated
	 */
	EAttribute getRealLiteral_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.typesystem.IntegerLiteral <em>Integer Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Literal</em>'.
	 * @see org.eclipselabs.mscript.typesystem.IntegerLiteral
	 * @generated
	 */
	EClass getIntegerLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.typesystem.IntegerLiteral#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Data</em>'.
	 * @see org.eclipselabs.mscript.typesystem.IntegerLiteral#getData()
	 * @see #getIntegerLiteral()
	 * @generated
	 */
	EAttribute getIntegerLiteral_Data();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.typesystem.IntegerLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipselabs.mscript.typesystem.IntegerLiteral#getValue()
	 * @see #getIntegerLiteral()
	 * @generated
	 */
	EAttribute getIntegerLiteral_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.typesystem.BooleanLiteral <em>Boolean Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Literal</em>'.
	 * @see org.eclipselabs.mscript.typesystem.BooleanLiteral
	 * @generated
	 */
	EClass getBooleanLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.typesystem.BooleanLiteral#isTrue <em>True</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>True</em>'.
	 * @see org.eclipselabs.mscript.typesystem.BooleanLiteral#isTrue()
	 * @see #getBooleanLiteral()
	 * @generated
	 */
	EAttribute getBooleanLiteral_True();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.typesystem.StringLiteral <em>String Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Literal</em>'.
	 * @see org.eclipselabs.mscript.typesystem.StringLiteral
	 * @generated
	 */
	EClass getStringLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.typesystem.StringLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipselabs.mscript.typesystem.StringLiteral#getValue()
	 * @see #getStringLiteral()
	 * @generated
	 */
	EAttribute getStringLiteral_Value();

	/**
	 * Returns the meta object for enum '{@link org.eclipselabs.mscript.typesystem.OperatorKind <em>Operator Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Operator Kind</em>'.
	 * @see org.eclipselabs.mscript.typesystem.OperatorKind
	 * @generated
	 */
	EEnum getOperatorKind();

	/**
	 * Returns the meta object for data type '{@link org.eclipselabs.mscript.typesystem.RealData <em>Real Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Real Data</em>'.
	 * @see org.eclipselabs.mscript.typesystem.RealData
	 * @model instanceClass="org.eclipselabs.mscript.typesystem.RealData"
	 * @generated
	 */
	EDataType getRealData();

	/**
	 * Returns the meta object for data type '{@link org.eclipselabs.mscript.typesystem.IntegerData <em>Integer Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Integer Data</em>'.
	 * @see org.eclipselabs.mscript.typesystem.IntegerData
	 * @model instanceClass="org.eclipselabs.mscript.typesystem.IntegerData"
	 * @generated
	 */
	EDataType getIntegerData();

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
		 * The meta object literal for the '{@link org.eclipselabs.mscript.typesystem.impl.DataTypeImpl <em>Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.typesystem.impl.DataTypeImpl
		 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getDataType()
		 * @generated
		 */
		EClass DATA_TYPE = eINSTANCE.getDataType();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.typesystem.impl.InvalidDataTypeImpl <em>Invalid Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.typesystem.impl.InvalidDataTypeImpl
		 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getInvalidDataType()
		 * @generated
		 */
		EClass INVALID_DATA_TYPE = eINSTANCE.getInvalidDataType();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.typesystem.impl.AnyDataTypeImpl <em>Any Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.typesystem.impl.AnyDataTypeImpl
		 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getAnyDataType()
		 * @generated
		 */
		EClass ANY_DATA_TYPE = eINSTANCE.getAnyDataType();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.typesystem.impl.UnitTypeImpl <em>Unit Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.typesystem.impl.UnitTypeImpl
		 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getUnitType()
		 * @generated
		 */
		EClass UNIT_TYPE = eINSTANCE.getUnitType();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.typesystem.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.typesystem.impl.PrimitiveTypeImpl
		 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getPrimitiveType()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.typesystem.impl.NumericTypeImpl <em>Numeric Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.typesystem.impl.NumericTypeImpl
		 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getNumericType()
		 * @generated
		 */
		EClass NUMERIC_TYPE = eINSTANCE.getNumericType();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUMERIC_TYPE__UNIT = eINSTANCE.getNumericType_Unit();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.typesystem.impl.RealTypeImpl <em>Real Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.typesystem.impl.RealTypeImpl
		 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getRealType()
		 * @generated
		 */
		EClass REAL_TYPE = eINSTANCE.getRealType();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.typesystem.impl.IntegerTypeImpl <em>Integer Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.typesystem.impl.IntegerTypeImpl
		 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getIntegerType()
		 * @generated
		 */
		EClass INTEGER_TYPE = eINSTANCE.getIntegerType();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.typesystem.impl.ComplexTypeImpl <em>Complex Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.typesystem.impl.ComplexTypeImpl
		 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getComplexType()
		 * @generated
		 */
		EClass COMPLEX_TYPE = eINSTANCE.getComplexType();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.typesystem.impl.GaussianTypeImpl <em>Gaussian Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.typesystem.impl.GaussianTypeImpl
		 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getGaussianType()
		 * @generated
		 */
		EClass GAUSSIAN_TYPE = eINSTANCE.getGaussianType();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.typesystem.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.typesystem.impl.BooleanTypeImpl
		 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getBooleanType()
		 * @generated
		 */
		EClass BOOLEAN_TYPE = eINSTANCE.getBooleanType();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.typesystem.impl.StringTypeImpl <em>String Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.typesystem.impl.StringTypeImpl
		 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getStringType()
		 * @generated
		 */
		EClass STRING_TYPE = eINSTANCE.getStringType();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.typesystem.impl.ArrayTypeImpl <em>Array Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.typesystem.impl.ArrayTypeImpl
		 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getArrayType()
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
		 * The meta object literal for the '<em><b>Defined Element Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY_TYPE__DEFINED_ELEMENT_TYPE = eINSTANCE.getArrayType_DefinedElementType();

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
		 * The meta object literal for the '{@link org.eclipselabs.mscript.typesystem.impl.TensorTypeImpl <em>Tensor Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.typesystem.impl.TensorTypeImpl
		 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getTensorType()
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
		 * The meta object literal for the '{@link org.eclipselabs.mscript.typesystem.impl.ArrayDimensionImpl <em>Array Dimension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.typesystem.impl.ArrayDimensionImpl
		 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getArrayDimension()
		 * @generated
		 */
		EClass ARRAY_DIMENSION = eINSTANCE.getArrayDimension();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY_DIMENSION__SIZE = eINSTANCE.getArrayDimension_Size();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.typesystem.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.typesystem.impl.ExpressionImpl
		 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.typesystem.impl.UnitImpl <em>Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.typesystem.impl.UnitImpl
		 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getUnit()
		 * @generated
		 */
		EClass UNIT = eINSTANCE.getUnit();

		/**
		 * The meta object literal for the '<em><b>Numerator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT__NUMERATOR = eINSTANCE.getUnit_Numerator();

		/**
		 * The meta object literal for the '<em><b>Denominator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT__DENOMINATOR = eINSTANCE.getUnit_Denominator();

		/**
		 * The meta object literal for the '<em><b>Scale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT__SCALE = eINSTANCE.getUnit_Scale();

		/**
		 * The meta object literal for the '<em><b>Wildcard</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNIT__WILDCARD = eINSTANCE.getUnit_Wildcard();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.typesystem.impl.UnitProductImpl <em>Unit Product</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.typesystem.impl.UnitProductImpl
		 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getUnitProduct()
		 * @generated
		 */
		EClass UNIT_PRODUCT = eINSTANCE.getUnitProduct();

		/**
		 * The meta object literal for the '<em><b>Factors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT_PRODUCT__FACTORS = eINSTANCE.getUnitProduct_Factors();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.typesystem.impl.UnitNumeratorImpl <em>Unit Numerator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.typesystem.impl.UnitNumeratorImpl
		 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getUnitNumerator()
		 * @generated
		 */
		EClass UNIT_NUMERATOR = eINSTANCE.getUnitNumerator();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.typesystem.impl.UnitDenominatorImpl <em>Unit Denominator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.typesystem.impl.UnitDenominatorImpl
		 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getUnitDenominator()
		 * @generated
		 */
		EClass UNIT_DENOMINATOR = eINSTANCE.getUnitDenominator();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.typesystem.impl.UnitFactorImpl <em>Unit Factor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.typesystem.impl.UnitFactorImpl
		 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getUnitFactor()
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
		 * The meta object literal for the '{@link org.eclipselabs.mscript.typesystem.impl.LiteralImpl <em>Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.typesystem.impl.LiteralImpl
		 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getLiteral()
		 * @generated
		 */
		EClass LITERAL = eINSTANCE.getLiteral();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.typesystem.impl.NumericLiteralImpl <em>Numeric Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.typesystem.impl.NumericLiteralImpl
		 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getNumericLiteral()
		 * @generated
		 */
		EClass NUMERIC_LITERAL = eINSTANCE.getNumericLiteral();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUMERIC_LITERAL__UNIT = eINSTANCE.getNumericLiteral_Unit();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.typesystem.impl.RealLiteralImpl <em>Real Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.typesystem.impl.RealLiteralImpl
		 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getRealLiteral()
		 * @generated
		 */
		EClass REAL_LITERAL = eINSTANCE.getRealLiteral();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_LITERAL__DATA = eINSTANCE.getRealLiteral_Data();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_LITERAL__VALUE = eINSTANCE.getRealLiteral_Value();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.typesystem.impl.IntegerLiteralImpl <em>Integer Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.typesystem.impl.IntegerLiteralImpl
		 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getIntegerLiteral()
		 * @generated
		 */
		EClass INTEGER_LITERAL = eINSTANCE.getIntegerLiteral();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_LITERAL__DATA = eINSTANCE.getIntegerLiteral_Data();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_LITERAL__VALUE = eINSTANCE.getIntegerLiteral_Value();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.typesystem.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.typesystem.impl.BooleanLiteralImpl
		 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getBooleanLiteral()
		 * @generated
		 */
		EClass BOOLEAN_LITERAL = eINSTANCE.getBooleanLiteral();

		/**
		 * The meta object literal for the '<em><b>True</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_LITERAL__TRUE = eINSTANCE.getBooleanLiteral_True();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.typesystem.impl.StringLiteralImpl <em>String Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.typesystem.impl.StringLiteralImpl
		 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getStringLiteral()
		 * @generated
		 */
		EClass STRING_LITERAL = eINSTANCE.getStringLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_LITERAL__VALUE = eINSTANCE.getStringLiteral_Value();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.typesystem.OperatorKind <em>Operator Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.typesystem.OperatorKind
		 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getOperatorKind()
		 * @generated
		 */
		EEnum OPERATOR_KIND = eINSTANCE.getOperatorKind();

		/**
		 * The meta object literal for the '<em>Real Data</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.typesystem.RealData
		 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getRealData()
		 * @generated
		 */
		EDataType REAL_DATA = eINSTANCE.getRealData();

		/**
		 * The meta object literal for the '<em>Integer Data</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.typesystem.IntegerData
		 * @see org.eclipselabs.mscript.typesystem.impl.TypeSystemPackageImpl#getIntegerData()
		 * @generated
		 */
		EDataType INTEGER_DATA = eINSTANCE.getIntegerData();

	}

} //TypeSystemPackage
