/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.sgen.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.yakindu.base.base.BasePackage;
import org.yakindu.base.expressions.expressions.ExpressionsPackage;
import org.yakindu.base.types.TypesPackage;
import org.yakindu.sct.model.sgen.DeprecatableElement;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.FeatureParameter;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.FeatureType;
import org.yakindu.sct.model.sgen.FeatureTypeLibrary;
import org.yakindu.sct.model.sgen.GeneratorConfiguration;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgen.GeneratorModel;
import org.yakindu.sct.model.sgen.ParameterTypes;
import org.yakindu.sct.model.sgen.PropertyDefinition;
import org.yakindu.sct.model.sgen.SGenFactory;
import org.yakindu.sct.model.sgen.SGenPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SGenPackageImpl extends EPackageImpl implements SGenPackage {
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
	private EClass deprecatableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyDefinitionEClass = null;

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
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SGenPackage init() {
		if (isInited) return (SGenPackage)EPackage.Registry.INSTANCE.getEPackage(SGenPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredSGenPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		SGenPackageImpl theSGenPackage = registeredSGenPackage instanceof SGenPackageImpl ? (SGenPackageImpl)registeredSGenPackage : new SGenPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		BasePackage.eINSTANCE.eClass();
		ExpressionsPackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSGenPackage.createPackageContents();

		// Initialize created meta-data
		theSGenPackage.initializePackageContents();

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
		return generatorModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeneratorModel_Entries() {
		return (EReference)generatorModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratorModel_GeneratorId() {
		return (EAttribute)generatorModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeneratorModel_Properties() {
		return (EReference)generatorModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGeneratorConfiguration() {
		return generatorConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeneratorConfiguration_Configurations() {
		return (EReference)generatorConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureType() {
		return featureTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureType_Parameters() {
		return (EReference)featureTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureType_Library() {
		return (EReference)featureTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureType_Optional() {
		return (EAttribute)featureTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureParameter() {
		return featureParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureParameter_FeatureType() {
		return (EReference)featureParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureParameter_Optional() {
		return (EAttribute)featureParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureParameter_ParameterType() {
		return (EAttribute)featureParameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureConfiguration() {
		return featureConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureConfiguration_Type() {
		return (EReference)featureConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureConfiguration_ParameterValues() {
		return (EReference)featureConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGeneratorEntry() {
		return generatorEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeneratorEntry_ElementRef() {
		return (EReference)generatorEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeneratorEntry_Features() {
		return (EReference)generatorEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneratorEntry_ContentType() {
		return (EAttribute)generatorEntryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureParameterValue() {
		return featureParameterValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureParameterValue_Parameter() {
		return (EReference)featureParameterValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureParameterValue_FeatureConfiguration() {
		return (EReference)featureParameterValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureParameterValue_Expression() {
		return (EReference)featureParameterValueEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureTypeLibrary() {
		return featureTypeLibraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureTypeLibrary_Types() {
		return (EReference)featureTypeLibraryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureTypeLibrary_Name() {
		return (EAttribute)featureTypeLibraryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeprecatableElement() {
		return deprecatableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeprecatableElement_Deprecated() {
		return (EAttribute)deprecatableElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeprecatableElement_Comment() {
		return (EAttribute)deprecatableElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyDefinition() {
		return propertyDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyDefinition_InitialValue() {
		return (EReference)propertyDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getParameterTypes() {
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
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		generatorModelEClass = createEClass(GENERATOR_MODEL);
		createEReference(generatorModelEClass, GENERATOR_MODEL__ENTRIES);
		createEAttribute(generatorModelEClass, GENERATOR_MODEL__GENERATOR_ID);
		createEReference(generatorModelEClass, GENERATOR_MODEL__PROPERTIES);

		generatorConfigurationEClass = createEClass(GENERATOR_CONFIGURATION);
		createEReference(generatorConfigurationEClass, GENERATOR_CONFIGURATION__CONFIGURATIONS);

		featureTypeEClass = createEClass(FEATURE_TYPE);
		createEReference(featureTypeEClass, FEATURE_TYPE__PARAMETERS);
		createEReference(featureTypeEClass, FEATURE_TYPE__LIBRARY);
		createEAttribute(featureTypeEClass, FEATURE_TYPE__OPTIONAL);

		featureParameterEClass = createEClass(FEATURE_PARAMETER);
		createEReference(featureParameterEClass, FEATURE_PARAMETER__FEATURE_TYPE);
		createEAttribute(featureParameterEClass, FEATURE_PARAMETER__OPTIONAL);
		createEAttribute(featureParameterEClass, FEATURE_PARAMETER__PARAMETER_TYPE);

		featureConfigurationEClass = createEClass(FEATURE_CONFIGURATION);
		createEReference(featureConfigurationEClass, FEATURE_CONFIGURATION__TYPE);
		createEReference(featureConfigurationEClass, FEATURE_CONFIGURATION__PARAMETER_VALUES);

		generatorEntryEClass = createEClass(GENERATOR_ENTRY);
		createEReference(generatorEntryEClass, GENERATOR_ENTRY__ELEMENT_REF);
		createEReference(generatorEntryEClass, GENERATOR_ENTRY__FEATURES);
		createEAttribute(generatorEntryEClass, GENERATOR_ENTRY__CONTENT_TYPE);

		featureParameterValueEClass = createEClass(FEATURE_PARAMETER_VALUE);
		createEReference(featureParameterValueEClass, FEATURE_PARAMETER_VALUE__PARAMETER);
		createEReference(featureParameterValueEClass, FEATURE_PARAMETER_VALUE__FEATURE_CONFIGURATION);
		createEReference(featureParameterValueEClass, FEATURE_PARAMETER_VALUE__EXPRESSION);

		featureTypeLibraryEClass = createEClass(FEATURE_TYPE_LIBRARY);
		createEReference(featureTypeLibraryEClass, FEATURE_TYPE_LIBRARY__TYPES);
		createEAttribute(featureTypeLibraryEClass, FEATURE_TYPE_LIBRARY__NAME);

		deprecatableElementEClass = createEClass(DEPRECATABLE_ELEMENT);
		createEAttribute(deprecatableElementEClass, DEPRECATABLE_ELEMENT__DEPRECATED);
		createEAttribute(deprecatableElementEClass, DEPRECATABLE_ELEMENT__COMMENT);

		propertyDefinitionEClass = createEClass(PROPERTY_DEFINITION);
		createEReference(propertyDefinitionEClass, PROPERTY_DEFINITION__INITIAL_VALUE);

		// Create enums
		parameterTypesEEnum = createEEnum(PARAMETER_TYPES);
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
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		BasePackage theBasePackage = (BasePackage)EPackage.Registry.INSTANCE.getEPackage(BasePackage.eNS_URI);
		ExpressionsPackage theExpressionsPackage = (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		featureTypeEClass.getESuperTypes().add(theBasePackage.getNamedElement());
		featureTypeEClass.getESuperTypes().add(this.getDeprecatableElement());
		featureParameterEClass.getESuperTypes().add(theBasePackage.getNamedElement());
		featureParameterEClass.getESuperTypes().add(this.getDeprecatableElement());
		propertyDefinitionEClass.getESuperTypes().add(theTypesPackage.getProperty());

		// Initialize classes and features; add operations and parameters
		initEClass(generatorModelEClass, GeneratorModel.class, "GeneratorModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGeneratorModel_Entries(), this.getGeneratorEntry(), null, "entries", null, 0, -1, GeneratorModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratorModel_GeneratorId(), ecorePackage.getEString(), "generatorId", null, 0, 1, GeneratorModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGeneratorModel_Properties(), this.getPropertyDefinition(), null, "properties", null, 0, -1, GeneratorModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(generatorConfigurationEClass, GeneratorConfiguration.class, "GeneratorConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGeneratorConfiguration_Configurations(), this.getFeatureConfiguration(), null, "configurations", null, 0, -1, GeneratorConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureTypeEClass, FeatureType.class, "FeatureType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFeatureType_Parameters(), this.getFeatureParameter(), this.getFeatureParameter_FeatureType(), "parameters", null, 0, -1, FeatureType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFeatureType_Library(), this.getFeatureTypeLibrary(), null, "library", null, 1, 1, FeatureType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeatureType_Optional(), ecorePackage.getEBoolean(), "optional", "false", 0, 1, FeatureType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureParameterEClass, FeatureParameter.class, "FeatureParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFeatureParameter_FeatureType(), this.getFeatureType(), this.getFeatureType_Parameters(), "featureType", null, 0, 1, FeatureParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeatureParameter_Optional(), ecorePackage.getEBoolean(), "optional", "false", 0, 1, FeatureParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeatureParameter_ParameterType(), this.getParameterTypes(), "parameterType", null, 0, 1, FeatureParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureConfigurationEClass, FeatureConfiguration.class, "FeatureConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFeatureConfiguration_Type(), this.getFeatureType(), null, "type", null, 0, 1, FeatureConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFeatureConfiguration_ParameterValues(), this.getFeatureParameterValue(), this.getFeatureParameterValue_FeatureConfiguration(), "parameterValues", null, 0, -1, FeatureConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(featureConfigurationEClass, this.getFeatureParameterValue(), "getParameterValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "parameterName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(generatorEntryEClass, GeneratorEntry.class, "GeneratorEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGeneratorEntry_ElementRef(), ecorePackage.getEObject(), null, "elementRef", null, 0, 1, GeneratorEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGeneratorEntry_Features(), this.getFeatureConfiguration(), null, "features", null, 0, -1, GeneratorEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneratorEntry_ContentType(), ecorePackage.getEString(), "contentType", null, 0, 1, GeneratorEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(generatorEntryEClass, this.getFeatureConfiguration(), "getFeatureConfiguration", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "featureName", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(generatorEntryEClass, this.getFeatureParameterValue(), "getFeatureParameterValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "featureName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "paramName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(featureParameterValueEClass, FeatureParameterValue.class, "FeatureParameterValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFeatureParameterValue_Parameter(), this.getFeatureParameter(), null, "parameter", null, 0, 1, FeatureParameterValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFeatureParameterValue_FeatureConfiguration(), this.getFeatureConfiguration(), this.getFeatureConfiguration_ParameterValues(), "featureConfiguration", null, 0, 1, FeatureParameterValue.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFeatureParameterValue_Expression(), theExpressionsPackage.getExpression(), null, "expression", null, 0, 1, FeatureParameterValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(featureParameterValueEClass, null, "setValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "string", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(featureParameterValueEClass, null, "setValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "boolean_", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(featureParameterValueEClass, ecorePackage.getEString(), "getStringValue", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(featureParameterValueEClass, ecorePackage.getEBoolean(), "getBooleanValue", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(featureParameterValueEClass, null, "setValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(featureParameterValueEClass, ecorePackage.getEInt(), "getIntegerValue", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(featureTypeLibraryEClass, FeatureTypeLibrary.class, "FeatureTypeLibrary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFeatureTypeLibrary_Types(), this.getFeatureType(), null, "types", null, 0, -1, FeatureTypeLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFeatureTypeLibrary_Name(), ecorePackage.getEString(), "name", null, 0, 1, FeatureTypeLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deprecatableElementEClass, DeprecatableElement.class, "DeprecatableElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDeprecatableElement_Deprecated(), ecorePackage.getEBoolean(), "deprecated", "false", 1, 1, DeprecatableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDeprecatableElement_Comment(), ecorePackage.getEString(), "comment", null, 0, 1, DeprecatableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyDefinitionEClass, PropertyDefinition.class, "PropertyDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyDefinition_InitialValue(), theExpressionsPackage.getExpression(), null, "initialValue", null, 0, 1, PropertyDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(parameterTypesEEnum, ParameterTypes.class, "ParameterTypes");
		addEEnumLiteral(parameterTypesEEnum, ParameterTypes.STRING);
		addEEnumLiteral(parameterTypesEEnum, ParameterTypes.FLOAT);
		addEEnumLiteral(parameterTypesEEnum, ParameterTypes.BOOLEAN);
		addEEnumLiteral(parameterTypesEEnum, ParameterTypes.INTEGER);

		// Create resource
		createResource(eNS_URI);
	}

} //SGenPackageImpl
