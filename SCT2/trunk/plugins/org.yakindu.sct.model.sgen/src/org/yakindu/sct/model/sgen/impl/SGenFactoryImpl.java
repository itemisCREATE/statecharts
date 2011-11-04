/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sgen.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.yakindu.sct.model.sgen.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SGenFactoryImpl extends EFactoryImpl implements SGenFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SGenFactory init() {
		try {
			SGenFactory theSGenFactory = (SGenFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.yakindu.org/sct/statechart/SGen"); 
			if (theSGenFactory != null) {
				return theSGenFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SGenFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SGenFactoryImpl() {
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
			case SGenPackage.GENERATOR_MODEL: return createGeneratorModel();
			case SGenPackage.CONFIGURATION: return createConfiguration();
			case SGenPackage.OUTLET_CONFIGURATION: return createOutletConfiguration();
			case SGenPackage.GENERATOR_CONFIGURATION: return createGeneratorConfiguration();
			case SGenPackage.STATECHART_REFERENCES: return createStatechartReferences();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratorModel createGeneratorModel() {
		GeneratorModelImpl generatorModel = new GeneratorModelImpl();
		return generatorModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Configuration createConfiguration() {
		ConfigurationImpl configuration = new ConfigurationImpl();
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutletConfiguration createOutletConfiguration() {
		OutletConfigurationImpl outletConfiguration = new OutletConfigurationImpl();
		return outletConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratorConfiguration createGeneratorConfiguration() {
		GeneratorConfigurationImpl generatorConfiguration = new GeneratorConfigurationImpl();
		return generatorConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatechartReferences createStatechartReferences() {
		StatechartReferencesImpl statechartReferences = new StatechartReferencesImpl();
		return statechartReferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SGenPackage getSGenPackage() {
		return (SGenPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SGenPackage getPackage() {
		return SGenPackage.eINSTANCE;
	}

} //SGenFactoryImpl
