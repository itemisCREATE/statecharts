/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.generator.model.base.javaGenModel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.yakindu.sct.generator.model.base.javaGenModel.JavaGenModelFactory;
import org.yakindu.sct.generator.model.base.javaGenModel.JavaGenModelPackage;
import org.yakindu.sct.generator.model.base.javaGenModel.OutletConfigurationCustom;

import org.yakindu.sct.model.sgen.SGenPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JavaGenModelPackageImpl extends EPackageImpl implements JavaGenModelPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass outletConfigurationCustomEClass = null;

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
   * @see org.yakindu.sct.generator.model.base.javaGenModel.JavaGenModelPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private JavaGenModelPackageImpl()
  {
    super(eNS_URI, JavaGenModelFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link JavaGenModelPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static JavaGenModelPackage init()
  {
    if (isInited) return (JavaGenModelPackage)EPackage.Registry.INSTANCE.getEPackage(JavaGenModelPackage.eNS_URI);

    // Obtain or create and register package
    JavaGenModelPackageImpl theJavaGenModelPackage = (JavaGenModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof JavaGenModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new JavaGenModelPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    SGenPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theJavaGenModelPackage.createPackageContents();

    // Initialize created meta-data
    theJavaGenModelPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theJavaGenModelPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(JavaGenModelPackage.eNS_URI, theJavaGenModelPackage);
    return theJavaGenModelPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOutletConfigurationCustom()
  {
    return outletConfigurationCustomEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOutletConfigurationCustom_ProjectName()
  {
    return (EAttribute)outletConfigurationCustomEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOutletConfigurationCustom_TargetFolder()
  {
    return (EAttribute)outletConfigurationCustomEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JavaGenModelFactory getJavaGenModelFactory()
  {
    return (JavaGenModelFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    outletConfigurationCustomEClass = createEClass(OUTLET_CONFIGURATION_CUSTOM);
    createEAttribute(outletConfigurationCustomEClass, OUTLET_CONFIGURATION_CUSTOM__PROJECT_NAME);
    createEAttribute(outletConfigurationCustomEClass, OUTLET_CONFIGURATION_CUSTOM__TARGET_FOLDER);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    SGenPackage theSGenPackage = (SGenPackage)EPackage.Registry.INSTANCE.getEPackage(SGenPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    outletConfigurationCustomEClass.getESuperTypes().add(theSGenPackage.getOutletConfiguration());

    // Initialize classes and features; add operations and parameters
    initEClass(outletConfigurationCustomEClass, OutletConfigurationCustom.class, "OutletConfigurationCustom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOutletConfigurationCustom_ProjectName(), ecorePackage.getEString(), "projectName", null, 0, 1, OutletConfigurationCustom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getOutletConfigurationCustom_TargetFolder(), ecorePackage.getEString(), "targetFolder", null, 0, 1, OutletConfigurationCustom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //JavaGenModelPackageImpl
