/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.generator.model.java.javaGen.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.yakindu.sct.generator.model.java.javaGen.ExecutionType;
import org.yakindu.sct.generator.model.java.javaGen.ExecutionTypeConfiguration;
import org.yakindu.sct.generator.model.java.javaGen.JavaGenFactory;
import org.yakindu.sct.generator.model.java.javaGen.JavaGenPackage;
import org.yakindu.sct.generator.model.java.javaGen.NamingConfiguration;

import org.yakindu.sct.model.sgen.SGenPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JavaGenPackageImpl extends EPackageImpl implements JavaGenPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass namingConfigurationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass executionTypeConfigurationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum executionTypeEEnum = null;

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
   * @see org.yakindu.sct.generator.model.java.javaGen.JavaGenPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private JavaGenPackageImpl()
  {
    super(eNS_URI, JavaGenFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link JavaGenPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static JavaGenPackage init()
  {
    if (isInited) return (JavaGenPackage)EPackage.Registry.INSTANCE.getEPackage(JavaGenPackage.eNS_URI);

    // Obtain or create and register package
    JavaGenPackageImpl theJavaGenPackage = (JavaGenPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof JavaGenPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new JavaGenPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    SGenPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theJavaGenPackage.createPackageContents();

    // Initialize created meta-data
    theJavaGenPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theJavaGenPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(JavaGenPackage.eNS_URI, theJavaGenPackage);
    return theJavaGenPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNamingConfiguration()
  {
    return namingConfigurationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNamingConfiguration_InterfacePackageName()
  {
    return (EAttribute)namingConfigurationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNamingConfiguration_ImplementationPackageName()
  {
    return (EAttribute)namingConfigurationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNamingConfiguration_Copyright()
  {
    return (EAttribute)namingConfigurationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExecutionTypeConfiguration()
  {
    return executionTypeConfigurationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExecutionTypeConfiguration_Type()
  {
    return (EAttribute)executionTypeConfigurationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getExecutionType()
  {
    return executionTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JavaGenFactory getJavaGenFactory()
  {
    return (JavaGenFactory)getEFactoryInstance();
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
    namingConfigurationEClass = createEClass(NAMING_CONFIGURATION);
    createEAttribute(namingConfigurationEClass, NAMING_CONFIGURATION__INTERFACE_PACKAGE_NAME);
    createEAttribute(namingConfigurationEClass, NAMING_CONFIGURATION__IMPLEMENTATION_PACKAGE_NAME);
    createEAttribute(namingConfigurationEClass, NAMING_CONFIGURATION__COPYRIGHT);

    executionTypeConfigurationEClass = createEClass(EXECUTION_TYPE_CONFIGURATION);
    createEAttribute(executionTypeConfigurationEClass, EXECUTION_TYPE_CONFIGURATION__TYPE);

    // Create enums
    executionTypeEEnum = createEEnum(EXECUTION_TYPE);
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
    namingConfigurationEClass.getESuperTypes().add(theSGenPackage.getConfiguration());
    executionTypeConfigurationEClass.getESuperTypes().add(theSGenPackage.getConfiguration());

    // Initialize classes and features; add operations and parameters
    initEClass(namingConfigurationEClass, NamingConfiguration.class, "NamingConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNamingConfiguration_InterfacePackageName(), ecorePackage.getEString(), "interfacePackageName", null, 0, 1, NamingConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getNamingConfiguration_ImplementationPackageName(), ecorePackage.getEString(), "implementationPackageName", null, 0, 1, NamingConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getNamingConfiguration_Copyright(), ecorePackage.getEString(), "copyright", null, 0, 1, NamingConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(executionTypeConfigurationEClass, ExecutionTypeConfiguration.class, "ExecutionTypeConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getExecutionTypeConfiguration_Type(), this.getExecutionType(), "type", null, 0, 1, ExecutionTypeConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(executionTypeEEnum, ExecutionType.class, "ExecutionType");
    addEEnumLiteral(executionTypeEEnum, ExecutionType.CYCLE_BASED);
    addEEnumLiteral(executionTypeEEnum, ExecutionType.EVENT_DRIVEN);

    // Create resource
    createResource(eNS_URI);
  }

} //JavaGenPackageImpl
