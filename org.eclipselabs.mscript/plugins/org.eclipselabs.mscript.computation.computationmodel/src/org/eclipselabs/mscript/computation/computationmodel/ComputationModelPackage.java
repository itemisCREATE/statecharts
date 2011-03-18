/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.computation.computationmodel;

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
 * @see org.eclipselabs.mscript.computation.computationmodel.ComputationModelFactory
 * @model kind="package"
 * @generated
 */
public interface ComputationModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "computationmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipselabs.org/mscript/ComputationModel/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "computationmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ComputationModelPackage eINSTANCE = org.eclipselabs.mscript.computation.computationmodel.impl.ComputationModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.computation.computationmodel.impl.NumberFormatImpl <em>Number Format</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.computation.computationmodel.impl.NumberFormatImpl
	 * @see org.eclipselabs.mscript.computation.computationmodel.impl.ComputationModelPackageImpl#getNumberFormat()
	 * @generated
	 */
	int NUMBER_FORMAT = 1;

	/**
	 * The number of structural features of the '<em>Number Format</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_FORMAT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.computation.computationmodel.impl.FloatingPointFormatImpl <em>Floating Point Format</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.computation.computationmodel.impl.FloatingPointFormatImpl
	 * @see org.eclipselabs.mscript.computation.computationmodel.impl.ComputationModelPackageImpl#getFloatingPointFormat()
	 * @generated
	 */
	int FLOATING_POINT_FORMAT = 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOATING_POINT_FORMAT__KIND = NUMBER_FORMAT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Floating Point Format</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOATING_POINT_FORMAT_FEATURE_COUNT = NUMBER_FORMAT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.computation.computationmodel.impl.FixedPointFormatImpl <em>Fixed Point Format</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.computation.computationmodel.impl.FixedPointFormatImpl
	 * @see org.eclipselabs.mscript.computation.computationmodel.impl.ComputationModelPackageImpl#getFixedPointFormat()
	 * @generated
	 */
	int FIXED_POINT_FORMAT = 2;

	/**
	 * The feature id for the '<em><b>Integer Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT_FORMAT__INTEGER_LENGTH = NUMBER_FORMAT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fraction Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT_FORMAT__FRACTION_LENGTH = NUMBER_FORMAT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Word Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT_FORMAT__WORD_SIZE = NUMBER_FORMAT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT_FORMAT__OPERATIONS = NUMBER_FORMAT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Fixed Point Format</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT_FORMAT_FEATURE_COUNT = NUMBER_FORMAT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.computation.computationmodel.impl.FixedPointOperationImpl <em>Fixed Point Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.computation.computationmodel.impl.FixedPointOperationImpl
	 * @see org.eclipselabs.mscript.computation.computationmodel.impl.ComputationModelPackageImpl#getFixedPointOperation()
	 * @generated
	 */
	int FIXED_POINT_OPERATION = 3;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT_OPERATION__KIND = 0;

	/**
	 * The feature id for the '<em><b>Intermediate Word Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT_OPERATION__INTERMEDIATE_WORD_SIZE = 1;

	/**
	 * The feature id for the '<em><b>Saturate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT_OPERATION__SATURATE = 2;

	/**
	 * The number of structural features of the '<em>Fixed Point Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIXED_POINT_OPERATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.computation.computationmodel.impl.ComputationModelImpl <em>Computation Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.computation.computationmodel.impl.ComputationModelImpl
	 * @see org.eclipselabs.mscript.computation.computationmodel.impl.ComputationModelPackageImpl#getComputationModel()
	 * @generated
	 */
	int COMPUTATION_MODEL = 4;

	/**
	 * The feature id for the '<em><b>Number Formats</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_MODEL__NUMBER_FORMATS = 0;

	/**
	 * The feature id for the '<em><b>Number Format Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_MODEL__NUMBER_FORMAT_MAPPINGS = 1;

	/**
	 * The number of structural features of the '<em>Computation Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_MODEL_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.computation.computationmodel.impl.NumberFormatMappingImpl <em>Number Format Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.computation.computationmodel.impl.NumberFormatMappingImpl
	 * @see org.eclipselabs.mscript.computation.computationmodel.impl.ComputationModelPackageImpl#getNumberFormatMapping()
	 * @generated
	 */
	int NUMBER_FORMAT_MAPPING = 5;

	/**
	 * The feature id for the '<em><b>Owned Data Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_FORMAT_MAPPING__OWNED_DATA_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_FORMAT_MAPPING__DATA_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Number Format</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_FORMAT_MAPPING__NUMBER_FORMAT = 2;

	/**
	 * The number of structural features of the '<em>Number Format Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_FORMAT_MAPPING_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormatKind <em>Floating Point Format Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormatKind
	 * @see org.eclipselabs.mscript.computation.computationmodel.impl.ComputationModelPackageImpl#getFloatingPointFormatKind()
	 * @generated
	 */
	int FLOATING_POINT_FORMAT_KIND = 6;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.computation.computationmodel.FixedPointOperationKind <em>Fixed Point Operation Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.computation.computationmodel.FixedPointOperationKind
	 * @see org.eclipselabs.mscript.computation.computationmodel.impl.ComputationModelPackageImpl#getFixedPointOperationKind()
	 * @generated
	 */
	int FIXED_POINT_OPERATION_KIND = 7;


	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormat <em>Floating Point Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Floating Point Format</em>'.
	 * @see org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormat
	 * @generated
	 */
	EClass getFloatingPointFormat();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormat#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormat#getKind()
	 * @see #getFloatingPointFormat()
	 * @generated
	 */
	EAttribute getFloatingPointFormat_Kind();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.computation.computationmodel.NumberFormat <em>Number Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Number Format</em>'.
	 * @see org.eclipselabs.mscript.computation.computationmodel.NumberFormat
	 * @generated
	 */
	EClass getNumberFormat();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat <em>Fixed Point Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fixed Point Format</em>'.
	 * @see org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat
	 * @generated
	 */
	EClass getFixedPointFormat();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat#getIntegerLength <em>Integer Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Integer Length</em>'.
	 * @see org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat#getIntegerLength()
	 * @see #getFixedPointFormat()
	 * @generated
	 */
	EAttribute getFixedPointFormat_IntegerLength();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat#getFractionLength <em>Fraction Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fraction Length</em>'.
	 * @see org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat#getFractionLength()
	 * @see #getFixedPointFormat()
	 * @generated
	 */
	EAttribute getFixedPointFormat_FractionLength();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat#getWordSize <em>Word Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Word Size</em>'.
	 * @see org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat#getWordSize()
	 * @see #getFixedPointFormat()
	 * @generated
	 */
	EAttribute getFixedPointFormat_WordSize();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operations</em>'.
	 * @see org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat#getOperations()
	 * @see #getFixedPointFormat()
	 * @generated
	 */
	EReference getFixedPointFormat_Operations();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.computation.computationmodel.FixedPointOperation <em>Fixed Point Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fixed Point Operation</em>'.
	 * @see org.eclipselabs.mscript.computation.computationmodel.FixedPointOperation
	 * @generated
	 */
	EClass getFixedPointOperation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.computation.computationmodel.FixedPointOperation#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipselabs.mscript.computation.computationmodel.FixedPointOperation#getKind()
	 * @see #getFixedPointOperation()
	 * @generated
	 */
	EAttribute getFixedPointOperation_Kind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.computation.computationmodel.FixedPointOperation#getIntermediateWordSize <em>Intermediate Word Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Intermediate Word Size</em>'.
	 * @see org.eclipselabs.mscript.computation.computationmodel.FixedPointOperation#getIntermediateWordSize()
	 * @see #getFixedPointOperation()
	 * @generated
	 */
	EAttribute getFixedPointOperation_IntermediateWordSize();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.computation.computationmodel.FixedPointOperation#isSaturate <em>Saturate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Saturate</em>'.
	 * @see org.eclipselabs.mscript.computation.computationmodel.FixedPointOperation#isSaturate()
	 * @see #getFixedPointOperation()
	 * @generated
	 */
	EAttribute getFixedPointOperation_Saturate();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.computation.computationmodel.ComputationModel <em>Computation Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Computation Model</em>'.
	 * @see org.eclipselabs.mscript.computation.computationmodel.ComputationModel
	 * @generated
	 */
	EClass getComputationModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.computation.computationmodel.ComputationModel#getNumberFormats <em>Number Formats</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Number Formats</em>'.
	 * @see org.eclipselabs.mscript.computation.computationmodel.ComputationModel#getNumberFormats()
	 * @see #getComputationModel()
	 * @generated
	 */
	EReference getComputationModel_NumberFormats();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.computation.computationmodel.ComputationModel#getNumberFormatMappings <em>Number Format Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Number Format Mappings</em>'.
	 * @see org.eclipselabs.mscript.computation.computationmodel.ComputationModel#getNumberFormatMappings()
	 * @see #getComputationModel()
	 * @generated
	 */
	EReference getComputationModel_NumberFormatMappings();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.computation.computationmodel.NumberFormatMapping <em>Number Format Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Number Format Mapping</em>'.
	 * @see org.eclipselabs.mscript.computation.computationmodel.NumberFormatMapping
	 * @generated
	 */
	EClass getNumberFormatMapping();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.computation.computationmodel.NumberFormatMapping#getOwnedDataType <em>Owned Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Data Type</em>'.
	 * @see org.eclipselabs.mscript.computation.computationmodel.NumberFormatMapping#getOwnedDataType()
	 * @see #getNumberFormatMapping()
	 * @generated
	 */
	EReference getNumberFormatMapping_OwnedDataType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.mscript.computation.computationmodel.NumberFormatMapping#getDataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data Type</em>'.
	 * @see org.eclipselabs.mscript.computation.computationmodel.NumberFormatMapping#getDataType()
	 * @see #getNumberFormatMapping()
	 * @generated
	 */
	EReference getNumberFormatMapping_DataType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.mscript.computation.computationmodel.NumberFormatMapping#getNumberFormat <em>Number Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Number Format</em>'.
	 * @see org.eclipselabs.mscript.computation.computationmodel.NumberFormatMapping#getNumberFormat()
	 * @see #getNumberFormatMapping()
	 * @generated
	 */
	EReference getNumberFormatMapping_NumberFormat();

	/**
	 * Returns the meta object for enum '{@link org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormatKind <em>Floating Point Format Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Floating Point Format Kind</em>'.
	 * @see org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormatKind
	 * @generated
	 */
	EEnum getFloatingPointFormatKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipselabs.mscript.computation.computationmodel.FixedPointOperationKind <em>Fixed Point Operation Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Fixed Point Operation Kind</em>'.
	 * @see org.eclipselabs.mscript.computation.computationmodel.FixedPointOperationKind
	 * @generated
	 */
	EEnum getFixedPointOperationKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ComputationModelFactory getComputationModelFactory();

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
		 * The meta object literal for the '{@link org.eclipselabs.mscript.computation.computationmodel.impl.FloatingPointFormatImpl <em>Floating Point Format</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.computation.computationmodel.impl.FloatingPointFormatImpl
		 * @see org.eclipselabs.mscript.computation.computationmodel.impl.ComputationModelPackageImpl#getFloatingPointFormat()
		 * @generated
		 */
		EClass FLOATING_POINT_FORMAT = eINSTANCE.getFloatingPointFormat();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FLOATING_POINT_FORMAT__KIND = eINSTANCE.getFloatingPointFormat_Kind();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.computation.computationmodel.impl.NumberFormatImpl <em>Number Format</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.computation.computationmodel.impl.NumberFormatImpl
		 * @see org.eclipselabs.mscript.computation.computationmodel.impl.ComputationModelPackageImpl#getNumberFormat()
		 * @generated
		 */
		EClass NUMBER_FORMAT = eINSTANCE.getNumberFormat();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.computation.computationmodel.impl.FixedPointFormatImpl <em>Fixed Point Format</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.computation.computationmodel.impl.FixedPointFormatImpl
		 * @see org.eclipselabs.mscript.computation.computationmodel.impl.ComputationModelPackageImpl#getFixedPointFormat()
		 * @generated
		 */
		EClass FIXED_POINT_FORMAT = eINSTANCE.getFixedPointFormat();

		/**
		 * The meta object literal for the '<em><b>Integer Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIXED_POINT_FORMAT__INTEGER_LENGTH = eINSTANCE.getFixedPointFormat_IntegerLength();

		/**
		 * The meta object literal for the '<em><b>Fraction Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIXED_POINT_FORMAT__FRACTION_LENGTH = eINSTANCE.getFixedPointFormat_FractionLength();

		/**
		 * The meta object literal for the '<em><b>Word Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIXED_POINT_FORMAT__WORD_SIZE = eINSTANCE.getFixedPointFormat_WordSize();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FIXED_POINT_FORMAT__OPERATIONS = eINSTANCE.getFixedPointFormat_Operations();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.computation.computationmodel.impl.FixedPointOperationImpl <em>Fixed Point Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.computation.computationmodel.impl.FixedPointOperationImpl
		 * @see org.eclipselabs.mscript.computation.computationmodel.impl.ComputationModelPackageImpl#getFixedPointOperation()
		 * @generated
		 */
		EClass FIXED_POINT_OPERATION = eINSTANCE.getFixedPointOperation();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIXED_POINT_OPERATION__KIND = eINSTANCE.getFixedPointOperation_Kind();

		/**
		 * The meta object literal for the '<em><b>Intermediate Word Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIXED_POINT_OPERATION__INTERMEDIATE_WORD_SIZE = eINSTANCE.getFixedPointOperation_IntermediateWordSize();

		/**
		 * The meta object literal for the '<em><b>Saturate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIXED_POINT_OPERATION__SATURATE = eINSTANCE.getFixedPointOperation_Saturate();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.computation.computationmodel.impl.ComputationModelImpl <em>Computation Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.computation.computationmodel.impl.ComputationModelImpl
		 * @see org.eclipselabs.mscript.computation.computationmodel.impl.ComputationModelPackageImpl#getComputationModel()
		 * @generated
		 */
		EClass COMPUTATION_MODEL = eINSTANCE.getComputationModel();

		/**
		 * The meta object literal for the '<em><b>Number Formats</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTATION_MODEL__NUMBER_FORMATS = eINSTANCE.getComputationModel_NumberFormats();

		/**
		 * The meta object literal for the '<em><b>Number Format Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTATION_MODEL__NUMBER_FORMAT_MAPPINGS = eINSTANCE.getComputationModel_NumberFormatMappings();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.computation.computationmodel.impl.NumberFormatMappingImpl <em>Number Format Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.computation.computationmodel.impl.NumberFormatMappingImpl
		 * @see org.eclipselabs.mscript.computation.computationmodel.impl.ComputationModelPackageImpl#getNumberFormatMapping()
		 * @generated
		 */
		EClass NUMBER_FORMAT_MAPPING = eINSTANCE.getNumberFormatMapping();

		/**
		 * The meta object literal for the '<em><b>Owned Data Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUMBER_FORMAT_MAPPING__OWNED_DATA_TYPE = eINSTANCE.getNumberFormatMapping_OwnedDataType();

		/**
		 * The meta object literal for the '<em><b>Data Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUMBER_FORMAT_MAPPING__DATA_TYPE = eINSTANCE.getNumberFormatMapping_DataType();

		/**
		 * The meta object literal for the '<em><b>Number Format</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NUMBER_FORMAT_MAPPING__NUMBER_FORMAT = eINSTANCE.getNumberFormatMapping_NumberFormat();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormatKind <em>Floating Point Format Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormatKind
		 * @see org.eclipselabs.mscript.computation.computationmodel.impl.ComputationModelPackageImpl#getFloatingPointFormatKind()
		 * @generated
		 */
		EEnum FLOATING_POINT_FORMAT_KIND = eINSTANCE.getFloatingPointFormatKind();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.computation.computationmodel.FixedPointOperationKind <em>Fixed Point Operation Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.computation.computationmodel.FixedPointOperationKind
		 * @see org.eclipselabs.mscript.computation.computationmodel.impl.ComputationModelPackageImpl#getFixedPointOperationKind()
		 * @generated
		 */
		EEnum FIXED_POINT_OPERATION_KIND = eINSTANCE.getFixedPointOperationKind();

	}

} //ComputationModelPackage
