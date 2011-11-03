/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sgen;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
	 * The feature id for the '<em><b>Configurations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_MODEL__CONFIGURATIONS = 0;

	/**
	 * The feature id for the '<em><b>Statecharts</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_MODEL__STATECHARTS = 1;

	/**
	 * The number of structural features of the '<em>Generator Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_MODEL_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgen.impl.ConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgen.impl.ConfigurationImpl
	 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getConfiguration()
	 * @generated
	 */
	int CONFIGURATION = 1;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgen.impl.OutletConfigurationImpl <em>Outlet Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgen.impl.OutletConfigurationImpl
	 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getOutletConfiguration()
	 * @generated
	 */
	int OUTLET_CONFIGURATION = 2;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTLET_CONFIGURATION__PATH = CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Override</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTLET_CONFIGURATION__OVERRIDE = CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Outlet Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTLET_CONFIGURATION_FEATURE_COUNT = CONFIGURATION_FEATURE_COUNT + 2;


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
	 * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.sgen.GeneratorModel#getConfigurations <em>Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Configurations</em>'.
	 * @see org.yakindu.sct.model.sgen.GeneratorModel#getConfigurations()
	 * @see #getGeneratorModel()
	 * @generated
	 */
	EReference getGeneratorModel_Configurations();

	/**
	 * Returns the meta object for the reference list '{@link org.yakindu.sct.model.sgen.GeneratorModel#getStatecharts <em>Statecharts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Statecharts</em>'.
	 * @see org.yakindu.sct.model.sgen.GeneratorModel#getStatecharts()
	 * @see #getGeneratorModel()
	 * @generated
	 */
	EReference getGeneratorModel_Statecharts();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgen.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see org.yakindu.sct.model.sgen.Configuration
	 * @generated
	 */
	EClass getConfiguration();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgen.OutletConfiguration <em>Outlet Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Outlet Configuration</em>'.
	 * @see org.yakindu.sct.model.sgen.OutletConfiguration
	 * @generated
	 */
	EClass getOutletConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sgen.OutletConfiguration#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.yakindu.sct.model.sgen.OutletConfiguration#getPath()
	 * @see #getOutletConfiguration()
	 * @generated
	 */
	EAttribute getOutletConfiguration_Path();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sgen.OutletConfiguration#isOverride <em>Override</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Override</em>'.
	 * @see org.yakindu.sct.model.sgen.OutletConfiguration#isOverride()
	 * @see #getOutletConfiguration()
	 * @generated
	 */
	EAttribute getOutletConfiguration_Override();

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
		 * The meta object literal for the '<em><b>Configurations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERATOR_MODEL__CONFIGURATIONS = eINSTANCE.getGeneratorModel_Configurations();

		/**
		 * The meta object literal for the '<em><b>Statecharts</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERATOR_MODEL__STATECHARTS = eINSTANCE.getGeneratorModel_Statecharts();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgen.impl.ConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgen.impl.ConfigurationImpl
		 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getConfiguration()
		 * @generated
		 */
		EClass CONFIGURATION = eINSTANCE.getConfiguration();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgen.impl.OutletConfigurationImpl <em>Outlet Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgen.impl.OutletConfigurationImpl
		 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getOutletConfiguration()
		 * @generated
		 */
		EClass OUTLET_CONFIGURATION = eINSTANCE.getOutletConfiguration();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OUTLET_CONFIGURATION__PATH = eINSTANCE.getOutletConfiguration_Path();

		/**
		 * The meta object literal for the '<em><b>Override</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OUTLET_CONFIGURATION__OVERRIDE = eINSTANCE.getOutletConfiguration_Override();

	}

} //SGenPackage
