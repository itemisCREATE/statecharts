/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sgen;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.yakindu.base.base.BasePackage;

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
 * @see org.yakindu.sct.model.sgen.SGenFactory
 * @model kind="package"
 * @generated
 */
public interface SGenPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sgen";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.yakindu.org/sct/statechart/SGen";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sgen";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SGenPackage eINSTANCE = org.yakindu.sct.model.sgen.impl.SGenPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgen.impl.GeneratorModelImpl <em>Generator Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgen.impl.GeneratorModelImpl
	 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getGeneratorModel()
	 * @generated
	 */
	int GENERATOR_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Entries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_MODEL__ENTRIES = 0;

	/**
	 * The feature id for the '<em><b>Generator Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_MODEL__GENERATOR_ID = 1;

	/**
	 * The number of structural features of the '<em>Generator Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_MODEL_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgen.impl.GeneratorConfigurationImpl <em>Generator Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgen.impl.GeneratorConfigurationImpl
	 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getGeneratorConfiguration()
	 * @generated
	 */
	int GENERATOR_CONFIGURATION = 1;

	/**
	 * The feature id for the '<em><b>Configurations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_CONFIGURATION__CONFIGURATIONS = 0;

	/**
	 * The number of structural features of the '<em>Generator Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_CONFIGURATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgen.impl.FeatureTypeImpl <em>Feature Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgen.impl.FeatureTypeImpl
	 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getFeatureType()
	 * @generated
	 */
	int FEATURE_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_TYPE__NAME = BasePackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_TYPE__DEPRECATED = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_TYPE__COMMENT = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_TYPE__PARAMETERS = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Library</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_TYPE__LIBRARY = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_TYPE__OPTIONAL = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Feature Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_TYPE_FEATURE_COUNT = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgen.impl.FeatureParameterImpl <em>Feature Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgen.impl.FeatureParameterImpl
	 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getFeatureParameter()
	 * @generated
	 */
	int FEATURE_PARAMETER = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PARAMETER__NAME = BasePackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PARAMETER__DEPRECATED = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PARAMETER__COMMENT = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Feature Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PARAMETER__FEATURE_TYPE = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PARAMETER__OPTIONAL = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Parameter Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PARAMETER__PARAMETER_TYPE = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Feature Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PARAMETER_FEATURE_COUNT = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgen.impl.FeatureConfigurationImpl <em>Feature Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgen.impl.FeatureConfigurationImpl
	 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getFeatureConfiguration()
	 * @generated
	 */
	int FEATURE_CONFIGURATION = 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONFIGURATION__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Parameter Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONFIGURATION__PARAMETER_VALUES = 1;

	/**
	 * The number of structural features of the '<em>Feature Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONFIGURATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgen.impl.GeneratorEntryImpl <em>Generator Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgen.impl.GeneratorEntryImpl
	 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getGeneratorEntry()
	 * @generated
	 */
	int GENERATOR_ENTRY = 5;

	/**
	 * The feature id for the '<em><b>Element Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_ENTRY__ELEMENT_REF = 0;

	/**
	 * The feature id for the '<em><b>Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_ENTRY__FEATURES = 1;

	/**
	 * The feature id for the '<em><b>Content Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_ENTRY__CONTENT_TYPE = 2;

	/**
	 * The number of structural features of the '<em>Generator Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_ENTRY_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgen.impl.FeatureParameterValueImpl <em>Feature Parameter Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgen.impl.FeatureParameterValueImpl
	 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getFeatureParameterValue()
	 * @generated
	 */
	int FEATURE_PARAMETER_VALUE = 6;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PARAMETER_VALUE__PARAMETER = 0;

	/**
	 * The feature id for the '<em><b>Feature Configuration</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PARAMETER_VALUE__FEATURE_CONFIGURATION = 1;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PARAMETER_VALUE__EXPRESSION = 2;

	/**
	 * The number of structural features of the '<em>Feature Parameter Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PARAMETER_VALUE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgen.impl.FeatureTypeLibraryImpl <em>Feature Type Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgen.impl.FeatureTypeLibraryImpl
	 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getFeatureTypeLibrary()
	 * @generated
	 */
	int FEATURE_TYPE_LIBRARY = 7;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_TYPE_LIBRARY__TYPES = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_TYPE_LIBRARY__NAME = 1;

	/**
	 * The number of structural features of the '<em>Feature Type Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_TYPE_LIBRARY_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgen.impl.LiteralImpl <em>Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgen.impl.LiteralImpl
	 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getLiteral()
	 * @generated
	 */
	int LITERAL = 8;

	/**
	 * The number of structural features of the '<em>Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgen.impl.BoolLiteralImpl <em>Bool Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgen.impl.BoolLiteralImpl
	 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getBoolLiteral()
	 * @generated
	 */
	int BOOL_LITERAL = 9;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Bool Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgen.impl.IntLiteralImpl <em>Int Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgen.impl.IntLiteralImpl
	 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getIntLiteral()
	 * @generated
	 */
	int INT_LITERAL = 10;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Int Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgen.impl.RealLiteralImpl <em>Real Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgen.impl.RealLiteralImpl
	 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getRealLiteral()
	 * @generated
	 */
	int REAL_LITERAL = 11;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Real Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgen.impl.StringLiteralImpl <em>String Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgen.impl.StringLiteralImpl
	 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getStringLiteral()
	 * @generated
	 */
	int STRING_LITERAL = 12;

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
	 * The meta object id for the '{@link org.yakindu.sct.model.sgen.impl.DeprecatableElementImpl <em>Deprecatable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgen.impl.DeprecatableElementImpl
	 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getDeprecatableElement()
	 * @generated
	 */
	int DEPRECATABLE_ELEMENT = 13;

	/**
	 * The feature id for the '<em><b>Deprecated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPRECATABLE_ELEMENT__DEPRECATED = 0;

	/**
	 * The feature id for the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPRECATABLE_ELEMENT__COMMENT = 1;

	/**
	 * The number of structural features of the '<em>Deprecatable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPRECATABLE_ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgen.ParameterTypes <em>Parameter Types</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgen.ParameterTypes
	 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getParameterTypes()
	 * @generated
	 */
	int PARAMETER_TYPES = 14;


	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgen.GeneratorModel <em>Generator Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generator Model</em>'.
	 * @see org.yakindu.sct.model.sgen.GeneratorModel
	 * @generated
	 */
	EClass getGeneratorModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.sgen.GeneratorModel#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entries</em>'.
	 * @see org.yakindu.sct.model.sgen.GeneratorModel#getEntries()
	 * @see #getGeneratorModel()
	 * @generated
	 */
	EReference getGeneratorModel_Entries();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sgen.GeneratorModel#getGeneratorId <em>Generator Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Generator Id</em>'.
	 * @see org.yakindu.sct.model.sgen.GeneratorModel#getGeneratorId()
	 * @see #getGeneratorModel()
	 * @generated
	 */
	EAttribute getGeneratorModel_GeneratorId();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgen.GeneratorConfiguration <em>Generator Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generator Configuration</em>'.
	 * @see org.yakindu.sct.model.sgen.GeneratorConfiguration
	 * @generated
	 */
	EClass getGeneratorConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.sgen.GeneratorConfiguration#getConfigurations <em>Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Configurations</em>'.
	 * @see org.yakindu.sct.model.sgen.GeneratorConfiguration#getConfigurations()
	 * @see #getGeneratorConfiguration()
	 * @generated
	 */
	EReference getGeneratorConfiguration_Configurations();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgen.FeatureType <em>Feature Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Type</em>'.
	 * @see org.yakindu.sct.model.sgen.FeatureType
	 * @generated
	 */
	EClass getFeatureType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.sgen.FeatureType#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.yakindu.sct.model.sgen.FeatureType#getParameters()
	 * @see #getFeatureType()
	 * @generated
	 */
	EReference getFeatureType_Parameters();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.sct.model.sgen.FeatureType#getLibrary <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Library</em>'.
	 * @see org.yakindu.sct.model.sgen.FeatureType#getLibrary()
	 * @see #getFeatureType()
	 * @generated
	 */
	EReference getFeatureType_Library();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sgen.FeatureType#isOptional <em>Optional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Optional</em>'.
	 * @see org.yakindu.sct.model.sgen.FeatureType#isOptional()
	 * @see #getFeatureType()
	 * @generated
	 */
	EAttribute getFeatureType_Optional();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgen.FeatureParameter <em>Feature Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Parameter</em>'.
	 * @see org.yakindu.sct.model.sgen.FeatureParameter
	 * @generated
	 */
	EClass getFeatureParameter();

	/**
	 * Returns the meta object for the container reference '{@link org.yakindu.sct.model.sgen.FeatureParameter#getFeatureType <em>Feature Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Feature Type</em>'.
	 * @see org.yakindu.sct.model.sgen.FeatureParameter#getFeatureType()
	 * @see #getFeatureParameter()
	 * @generated
	 */
	EReference getFeatureParameter_FeatureType();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sgen.FeatureParameter#isOptional <em>Optional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Optional</em>'.
	 * @see org.yakindu.sct.model.sgen.FeatureParameter#isOptional()
	 * @see #getFeatureParameter()
	 * @generated
	 */
	EAttribute getFeatureParameter_Optional();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sgen.FeatureParameter#getParameterType <em>Parameter Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parameter Type</em>'.
	 * @see org.yakindu.sct.model.sgen.FeatureParameter#getParameterType()
	 * @see #getFeatureParameter()
	 * @generated
	 */
	EAttribute getFeatureParameter_ParameterType();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgen.FeatureConfiguration <em>Feature Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Configuration</em>'.
	 * @see org.yakindu.sct.model.sgen.FeatureConfiguration
	 * @generated
	 */
	EClass getFeatureConfiguration();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.sct.model.sgen.FeatureConfiguration#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.yakindu.sct.model.sgen.FeatureConfiguration#getType()
	 * @see #getFeatureConfiguration()
	 * @generated
	 */
	EReference getFeatureConfiguration_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.sgen.FeatureConfiguration#getParameterValues <em>Parameter Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter Values</em>'.
	 * @see org.yakindu.sct.model.sgen.FeatureConfiguration#getParameterValues()
	 * @see #getFeatureConfiguration()
	 * @generated
	 */
	EReference getFeatureConfiguration_ParameterValues();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgen.GeneratorEntry <em>Generator Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generator Entry</em>'.
	 * @see org.yakindu.sct.model.sgen.GeneratorEntry
	 * @generated
	 */
	EClass getGeneratorEntry();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.sct.model.sgen.GeneratorEntry#getElementRef <em>Element Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element Ref</em>'.
	 * @see org.yakindu.sct.model.sgen.GeneratorEntry#getElementRef()
	 * @see #getGeneratorEntry()
	 * @generated
	 */
	EReference getGeneratorEntry_ElementRef();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.sgen.GeneratorEntry#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Features</em>'.
	 * @see org.yakindu.sct.model.sgen.GeneratorEntry#getFeatures()
	 * @see #getGeneratorEntry()
	 * @generated
	 */
	EReference getGeneratorEntry_Features();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sgen.GeneratorEntry#getContentType <em>Content Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content Type</em>'.
	 * @see org.yakindu.sct.model.sgen.GeneratorEntry#getContentType()
	 * @see #getGeneratorEntry()
	 * @generated
	 */
	EAttribute getGeneratorEntry_ContentType();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgen.FeatureParameterValue <em>Feature Parameter Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Parameter Value</em>'.
	 * @see org.yakindu.sct.model.sgen.FeatureParameterValue
	 * @generated
	 */
	EClass getFeatureParameterValue();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.sct.model.sgen.FeatureParameterValue#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parameter</em>'.
	 * @see org.yakindu.sct.model.sgen.FeatureParameterValue#getParameter()
	 * @see #getFeatureParameterValue()
	 * @generated
	 */
	EReference getFeatureParameterValue_Parameter();

	/**
	 * Returns the meta object for the container reference '{@link org.yakindu.sct.model.sgen.FeatureParameterValue#getFeatureConfiguration <em>Feature Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Feature Configuration</em>'.
	 * @see org.yakindu.sct.model.sgen.FeatureParameterValue#getFeatureConfiguration()
	 * @see #getFeatureParameterValue()
	 * @generated
	 */
	EReference getFeatureParameterValue_FeatureConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.sgen.FeatureParameterValue#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.yakindu.sct.model.sgen.FeatureParameterValue#getExpression()
	 * @see #getFeatureParameterValue()
	 * @generated
	 */
	EReference getFeatureParameterValue_Expression();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgen.FeatureTypeLibrary <em>Feature Type Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Type Library</em>'.
	 * @see org.yakindu.sct.model.sgen.FeatureTypeLibrary
	 * @generated
	 */
	EClass getFeatureTypeLibrary();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.sgen.FeatureTypeLibrary#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Types</em>'.
	 * @see org.yakindu.sct.model.sgen.FeatureTypeLibrary#getTypes()
	 * @see #getFeatureTypeLibrary()
	 * @generated
	 */
	EReference getFeatureTypeLibrary_Types();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sgen.FeatureTypeLibrary#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.yakindu.sct.model.sgen.FeatureTypeLibrary#getName()
	 * @see #getFeatureTypeLibrary()
	 * @generated
	 */
	EAttribute getFeatureTypeLibrary_Name();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgen.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal</em>'.
	 * @see org.yakindu.sct.model.sgen.Literal
	 * @generated
	 */
	EClass getLiteral();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgen.BoolLiteral <em>Bool Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bool Literal</em>'.
	 * @see org.yakindu.sct.model.sgen.BoolLiteral
	 * @generated
	 */
	EClass getBoolLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sgen.BoolLiteral#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.yakindu.sct.model.sgen.BoolLiteral#isValue()
	 * @see #getBoolLiteral()
	 * @generated
	 */
	EAttribute getBoolLiteral_Value();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgen.IntLiteral <em>Int Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Literal</em>'.
	 * @see org.yakindu.sct.model.sgen.IntLiteral
	 * @generated
	 */
	EClass getIntLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sgen.IntLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.yakindu.sct.model.sgen.IntLiteral#getValue()
	 * @see #getIntLiteral()
	 * @generated
	 */
	EAttribute getIntLiteral_Value();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgen.RealLiteral <em>Real Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Literal</em>'.
	 * @see org.yakindu.sct.model.sgen.RealLiteral
	 * @generated
	 */
	EClass getRealLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sgen.RealLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.yakindu.sct.model.sgen.RealLiteral#getValue()
	 * @see #getRealLiteral()
	 * @generated
	 */
	EAttribute getRealLiteral_Value();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgen.StringLiteral <em>String Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Literal</em>'.
	 * @see org.yakindu.sct.model.sgen.StringLiteral
	 * @generated
	 */
	EClass getStringLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sgen.StringLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.yakindu.sct.model.sgen.StringLiteral#getValue()
	 * @see #getStringLiteral()
	 * @generated
	 */
	EAttribute getStringLiteral_Value();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgen.DeprecatableElement <em>Deprecatable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deprecatable Element</em>'.
	 * @see org.yakindu.sct.model.sgen.DeprecatableElement
	 * @generated
	 */
	EClass getDeprecatableElement();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sgen.DeprecatableElement#isDeprecated <em>Deprecated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deprecated</em>'.
	 * @see org.yakindu.sct.model.sgen.DeprecatableElement#isDeprecated()
	 * @see #getDeprecatableElement()
	 * @generated
	 */
	EAttribute getDeprecatableElement_Deprecated();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sgen.DeprecatableElement#getComment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comment</em>'.
	 * @see org.yakindu.sct.model.sgen.DeprecatableElement#getComment()
	 * @see #getDeprecatableElement()
	 * @generated
	 */
	EAttribute getDeprecatableElement_Comment();

	/**
	 * Returns the meta object for enum '{@link org.yakindu.sct.model.sgen.ParameterTypes <em>Parameter Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Parameter Types</em>'.
	 * @see org.yakindu.sct.model.sgen.ParameterTypes
	 * @generated
	 */
	EEnum getParameterTypes();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SGenFactory getSGenFactory();

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
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgen.impl.GeneratorModelImpl <em>Generator Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgen.impl.GeneratorModelImpl
		 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getGeneratorModel()
		 * @generated
		 */
		EClass GENERATOR_MODEL = eINSTANCE.getGeneratorModel();

		/**
		 * The meta object literal for the '<em><b>Entries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERATOR_MODEL__ENTRIES = eINSTANCE.getGeneratorModel_Entries();

		/**
		 * The meta object literal for the '<em><b>Generator Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATOR_MODEL__GENERATOR_ID = eINSTANCE.getGeneratorModel_GeneratorId();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgen.impl.GeneratorConfigurationImpl <em>Generator Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgen.impl.GeneratorConfigurationImpl
		 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getGeneratorConfiguration()
		 * @generated
		 */
		EClass GENERATOR_CONFIGURATION = eINSTANCE.getGeneratorConfiguration();

		/**
		 * The meta object literal for the '<em><b>Configurations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERATOR_CONFIGURATION__CONFIGURATIONS = eINSTANCE.getGeneratorConfiguration_Configurations();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgen.impl.FeatureTypeImpl <em>Feature Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgen.impl.FeatureTypeImpl
		 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getFeatureType()
		 * @generated
		 */
		EClass FEATURE_TYPE = eINSTANCE.getFeatureType();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_TYPE__PARAMETERS = eINSTANCE.getFeatureType_Parameters();

		/**
		 * The meta object literal for the '<em><b>Library</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_TYPE__LIBRARY = eINSTANCE.getFeatureType_Library();

		/**
		 * The meta object literal for the '<em><b>Optional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_TYPE__OPTIONAL = eINSTANCE.getFeatureType_Optional();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgen.impl.FeatureParameterImpl <em>Feature Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgen.impl.FeatureParameterImpl
		 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getFeatureParameter()
		 * @generated
		 */
		EClass FEATURE_PARAMETER = eINSTANCE.getFeatureParameter();

		/**
		 * The meta object literal for the '<em><b>Feature Type</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_PARAMETER__FEATURE_TYPE = eINSTANCE.getFeatureParameter_FeatureType();

		/**
		 * The meta object literal for the '<em><b>Optional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_PARAMETER__OPTIONAL = eINSTANCE.getFeatureParameter_Optional();

		/**
		 * The meta object literal for the '<em><b>Parameter Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_PARAMETER__PARAMETER_TYPE = eINSTANCE.getFeatureParameter_ParameterType();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgen.impl.FeatureConfigurationImpl <em>Feature Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgen.impl.FeatureConfigurationImpl
		 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getFeatureConfiguration()
		 * @generated
		 */
		EClass FEATURE_CONFIGURATION = eINSTANCE.getFeatureConfiguration();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_CONFIGURATION__TYPE = eINSTANCE.getFeatureConfiguration_Type();

		/**
		 * The meta object literal for the '<em><b>Parameter Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_CONFIGURATION__PARAMETER_VALUES = eINSTANCE.getFeatureConfiguration_ParameterValues();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgen.impl.GeneratorEntryImpl <em>Generator Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgen.impl.GeneratorEntryImpl
		 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getGeneratorEntry()
		 * @generated
		 */
		EClass GENERATOR_ENTRY = eINSTANCE.getGeneratorEntry();

		/**
		 * The meta object literal for the '<em><b>Element Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERATOR_ENTRY__ELEMENT_REF = eINSTANCE.getGeneratorEntry_ElementRef();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERATOR_ENTRY__FEATURES = eINSTANCE.getGeneratorEntry_Features();

		/**
		 * The meta object literal for the '<em><b>Content Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATOR_ENTRY__CONTENT_TYPE = eINSTANCE.getGeneratorEntry_ContentType();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgen.impl.FeatureParameterValueImpl <em>Feature Parameter Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgen.impl.FeatureParameterValueImpl
		 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getFeatureParameterValue()
		 * @generated
		 */
		EClass FEATURE_PARAMETER_VALUE = eINSTANCE.getFeatureParameterValue();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_PARAMETER_VALUE__PARAMETER = eINSTANCE.getFeatureParameterValue_Parameter();

		/**
		 * The meta object literal for the '<em><b>Feature Configuration</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_PARAMETER_VALUE__FEATURE_CONFIGURATION = eINSTANCE.getFeatureParameterValue_FeatureConfiguration();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_PARAMETER_VALUE__EXPRESSION = eINSTANCE.getFeatureParameterValue_Expression();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgen.impl.FeatureTypeLibraryImpl <em>Feature Type Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgen.impl.FeatureTypeLibraryImpl
		 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getFeatureTypeLibrary()
		 * @generated
		 */
		EClass FEATURE_TYPE_LIBRARY = eINSTANCE.getFeatureTypeLibrary();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_TYPE_LIBRARY__TYPES = eINSTANCE.getFeatureTypeLibrary_Types();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_TYPE_LIBRARY__NAME = eINSTANCE.getFeatureTypeLibrary_Name();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgen.impl.LiteralImpl <em>Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgen.impl.LiteralImpl
		 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getLiteral()
		 * @generated
		 */
		EClass LITERAL = eINSTANCE.getLiteral();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgen.impl.BoolLiteralImpl <em>Bool Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgen.impl.BoolLiteralImpl
		 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getBoolLiteral()
		 * @generated
		 */
		EClass BOOL_LITERAL = eINSTANCE.getBoolLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOL_LITERAL__VALUE = eINSTANCE.getBoolLiteral_Value();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgen.impl.IntLiteralImpl <em>Int Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgen.impl.IntLiteralImpl
		 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getIntLiteral()
		 * @generated
		 */
		EClass INT_LITERAL = eINSTANCE.getIntLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INT_LITERAL__VALUE = eINSTANCE.getIntLiteral_Value();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgen.impl.RealLiteralImpl <em>Real Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgen.impl.RealLiteralImpl
		 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getRealLiteral()
		 * @generated
		 */
		EClass REAL_LITERAL = eINSTANCE.getRealLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REAL_LITERAL__VALUE = eINSTANCE.getRealLiteral_Value();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgen.impl.StringLiteralImpl <em>String Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgen.impl.StringLiteralImpl
		 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getStringLiteral()
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
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgen.impl.DeprecatableElementImpl <em>Deprecatable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgen.impl.DeprecatableElementImpl
		 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getDeprecatableElement()
		 * @generated
		 */
		EClass DEPRECATABLE_ELEMENT = eINSTANCE.getDeprecatableElement();

		/**
		 * The meta object literal for the '<em><b>Deprecated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPRECATABLE_ELEMENT__DEPRECATED = eINSTANCE.getDeprecatableElement_Deprecated();

		/**
		 * The meta object literal for the '<em><b>Comment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPRECATABLE_ELEMENT__COMMENT = eINSTANCE.getDeprecatableElement_Comment();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgen.ParameterTypes <em>Parameter Types</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgen.ParameterTypes
		 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getParameterTypes()
		 * @generated
		 */
		EEnum PARAMETER_TYPES = eINSTANCE.getParameterTypes();

	}

} //SGenPackage
