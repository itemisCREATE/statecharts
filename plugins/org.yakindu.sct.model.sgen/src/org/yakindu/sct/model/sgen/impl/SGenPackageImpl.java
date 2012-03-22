/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sgen.impl;

import java.io.IOException;
import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.xtext.xbase.XbasePackage;
import org.yakindu.sct.model.sgen.SGenFactory;
import org.yakindu.sct.model.sgen.SGenPackage;
import org.yakindu.sct.model.sgraph.SGraphPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
@SuppressWarnings("restriction")
public class SGenPackageImpl extends EPackageImpl implements SGenPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected String packageFilename = "sgen.ecore";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass generatorModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass generatorConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass generatorEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureParameterValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureTypeLibraryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum parameterTypesEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.yakindu.sct.model.sgen.SGenPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SGenPackageImpl() {
		super(eNS_URI, SGenFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link SGenPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @generated
	 */
	public static SGenPackage init() {
		if (isInited) return (SGenPackage)EPackage.Registry.INSTANCE.getEPackage(SGenPackage.eNS_URI);

		// Obtain or create and register package
		SGenPackageImpl theSGenPackage = (SGenPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SGenPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SGenPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		SGraphPackage.eINSTANCE.eClass();
		XbasePackage.eINSTANCE.eClass();

		// Load packages
		theSGenPackage.loadPackage();

		// Fix loaded packages
		theSGenPackage.fixPackageContents();

		// Mark meta-data to indicate it can't be changed
		theSGenPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SGenPackage.eNS_URI, theSGenPackage);
		return theSGenPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGeneratorModel() {
		if (generatorModelEClass == null) {
			generatorModelEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(SGenPackage.eNS_URI).getEClassifiers().get(0);
		}
		return generatorModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeneratorModel_Entries() {
        return (EReference)getGeneratorModel().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratorModel_GeneratorId() {
        return (EAttribute)getGeneratorModel().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGeneratorConfiguration() {
		if (generatorConfigurationEClass == null) {
			generatorConfigurationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(SGenPackage.eNS_URI).getEClassifiers().get(1);
		}
		return generatorConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeneratorConfiguration_Configurations() {
        return (EReference)getGeneratorConfiguration().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureType() {
		if (featureTypeEClass == null) {
			featureTypeEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(SGenPackage.eNS_URI).getEClassifiers().get(2);
		}
		return featureTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureType_Parameters() {
        return (EReference)getFeatureType().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureType_Library() {
        return (EReference)getFeatureType().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureType_Optional() {
        return (EAttribute)getFeatureType().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureParameter() {
		if (featureParameterEClass == null) {
			featureParameterEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(SGenPackage.eNS_URI).getEClassifiers().get(3);
		}
		return featureParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureParameter_FeatureType() {
        return (EReference)getFeatureParameter().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureParameter_Optional() {
        return (EAttribute)getFeatureParameter().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureParameter_ParameterType() {
        return (EAttribute)getFeatureParameter().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureConfiguration() {
		if (featureConfigurationEClass == null) {
			featureConfigurationEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(SGenPackage.eNS_URI).getEClassifiers().get(4);
		}
		return featureConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureConfiguration_Type() {
        return (EReference)getFeatureConfiguration().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureConfiguration_ParameterValues() {
        return (EReference)getFeatureConfiguration().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGeneratorEntry() {
		if (generatorEntryEClass == null) {
			generatorEntryEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(SGenPackage.eNS_URI).getEClassifiers().get(5);
		}
		return generatorEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeneratorEntry_ElementRef() {
        return (EReference)getGeneratorEntry().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeneratorEntry_Features() {
        return (EReference)getGeneratorEntry().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratorEntry_ContentType() {
        return (EAttribute)getGeneratorEntry().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureParameterValue() {
		if (featureParameterValueEClass == null) {
			featureParameterValueEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(SGenPackage.eNS_URI).getEClassifiers().get(6);
		}
		return featureParameterValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureParameterValue_Parameter() {
        return (EReference)getFeatureParameterValue().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureParameterValue_FeatureConfiguration() {
        return (EReference)getFeatureParameterValue().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureParameterValue_Expression() {
        return (EReference)getFeatureParameterValue().getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureTypeLibrary() {
		if (featureTypeLibraryEClass == null) {
			featureTypeLibraryEClass = (EClass)EPackage.Registry.INSTANCE.getEPackage(SGenPackage.eNS_URI).getEClassifiers().get(7);
		}
		return featureTypeLibraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureTypeLibrary_Types() {
        return (EReference)getFeatureTypeLibrary().getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureTypeLibrary_Name() {
        return (EAttribute)getFeatureTypeLibrary().getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getParameterTypes() {
		if (parameterTypesEEnum == null) {
			parameterTypesEEnum = (EEnum)EPackage.Registry.INSTANCE.getEPackage(SGenPackage.eNS_URI).getEClassifiers().get(8);
		}
		return parameterTypesEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SGenFactory getSGenFactory() {
		return (SGenFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isLoaded = false;

	/**
	 * Laods the package and any sub-packages from their serialized form.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void loadPackage() {
		if (isLoaded) return;
		isLoaded = true;

		URL url = getClass().getResource(packageFilename);
		if (url == null) {
			throw new RuntimeException("Missing serialized package: " + packageFilename);
		}
		URI uri = URI.createURI(url.toString());
		Resource resource = new EcoreResourceFactoryImpl().createResource(uri);
		try {
			resource.load(null);
		}
		catch (IOException exception) {
			throw new WrappedException(exception);
		}
		initializeFromLoadedEPackage(this, (EPackage)resource.getContents().get(0));
		createResource(eNS_URI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isFixed = false;

	/**
	 * Fixes up the loaded package, to make it appear as if it had been programmatically built.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fixPackageContents() {
		if (isFixed) return;
		isFixed = true;
		fixEClassifiers();
	}

	/**
	 * Sets the instance class on the given classifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void fixInstanceClass(EClassifier eClassifier) {
		if (eClassifier.getInstanceClassName() == null) {
			eClassifier.setInstanceClassName("org.yakindu.sct.model.sgen." + eClassifier.getName());
			setGeneratedClassName(eClassifier);
		}
	}

} //SGenPackageImpl
