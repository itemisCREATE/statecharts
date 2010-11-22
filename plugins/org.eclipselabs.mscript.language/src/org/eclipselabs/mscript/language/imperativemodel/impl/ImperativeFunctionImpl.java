/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.imperativemodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.mscript.language.imperativemodel.Compound;
import org.eclipselabs.mscript.language.imperativemodel.ComputationCompound;
import org.eclipselabs.mscript.language.imperativemodel.ImperativeFunction;
import org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage;
import org.eclipselabs.mscript.language.imperativemodel.InputVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.InstanceVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.OutputVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.TemplateVariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Imperative Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeFunctionImpl#getTemplateVariableDeclarations <em>Template Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeFunctionImpl#getInputVariableDeclarations <em>Input Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeFunctionImpl#getOutputVariableDeclarations <em>Output Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeFunctionImpl#getInstanceVariableDeclarations <em>Instance Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeFunctionImpl#getInitializationCompound <em>Initialization Compound</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeFunctionImpl#getComputationCompounds <em>Computation Compounds</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImperativeFunctionImpl extends EObjectImpl implements ImperativeFunction {
	/**
	 * The cached value of the '{@link #getTemplateVariableDeclarations() <em>Template Variable Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplateVariableDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<TemplateVariableDeclaration> templateVariableDeclarations;

	/**
	 * The cached value of the '{@link #getInputVariableDeclarations() <em>Input Variable Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputVariableDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<InputVariableDeclaration> inputVariableDeclarations;

	/**
	 * The cached value of the '{@link #getOutputVariableDeclarations() <em>Output Variable Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputVariableDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<OutputVariableDeclaration> outputVariableDeclarations;

	/**
	 * The cached value of the '{@link #getInstanceVariableDeclarations() <em>Instance Variable Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceVariableDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<InstanceVariableDeclaration> instanceVariableDeclarations;

	/**
	 * The cached value of the '{@link #getInitializationCompound() <em>Initialization Compound</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitializationCompound()
	 * @generated
	 * @ordered
	 */
	protected Compound initializationCompound;

	/**
	 * The cached value of the '{@link #getComputationCompounds() <em>Computation Compounds</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComputationCompounds()
	 * @generated
	 * @ordered
	 */
	protected EList<ComputationCompound> computationCompounds;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImperativeFunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImperativeModelPackage.Literals.IMPERATIVE_FUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TemplateVariableDeclaration> getTemplateVariableDeclarations() {
		if (templateVariableDeclarations == null) {
			templateVariableDeclarations = new EObjectContainmentEList<TemplateVariableDeclaration>(TemplateVariableDeclaration.class, this, ImperativeModelPackage.IMPERATIVE_FUNCTION__TEMPLATE_VARIABLE_DECLARATIONS);
		}
		return templateVariableDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InputVariableDeclaration> getInputVariableDeclarations() {
		if (inputVariableDeclarations == null) {
			inputVariableDeclarations = new EObjectContainmentEList<InputVariableDeclaration>(InputVariableDeclaration.class, this, ImperativeModelPackage.IMPERATIVE_FUNCTION__INPUT_VARIABLE_DECLARATIONS);
		}
		return inputVariableDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OutputVariableDeclaration> getOutputVariableDeclarations() {
		if (outputVariableDeclarations == null) {
			outputVariableDeclarations = new EObjectContainmentEList<OutputVariableDeclaration>(OutputVariableDeclaration.class, this, ImperativeModelPackage.IMPERATIVE_FUNCTION__OUTPUT_VARIABLE_DECLARATIONS);
		}
		return outputVariableDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InstanceVariableDeclaration> getInstanceVariableDeclarations() {
		if (instanceVariableDeclarations == null) {
			instanceVariableDeclarations = new EObjectContainmentEList<InstanceVariableDeclaration>(InstanceVariableDeclaration.class, this, ImperativeModelPackage.IMPERATIVE_FUNCTION__INSTANCE_VARIABLE_DECLARATIONS);
		}
		return instanceVariableDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Compound getInitializationCompound() {
		return initializationCompound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitializationCompound(Compound newInitializationCompound, NotificationChain msgs) {
		Compound oldInitializationCompound = initializationCompound;
		initializationCompound = newInitializationCompound;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImperativeModelPackage.IMPERATIVE_FUNCTION__INITIALIZATION_COMPOUND, oldInitializationCompound, newInitializationCompound);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitializationCompound(Compound newInitializationCompound) {
		if (newInitializationCompound != initializationCompound) {
			NotificationChain msgs = null;
			if (initializationCompound != null)
				msgs = ((InternalEObject)initializationCompound).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImperativeModelPackage.IMPERATIVE_FUNCTION__INITIALIZATION_COMPOUND, null, msgs);
			if (newInitializationCompound != null)
				msgs = ((InternalEObject)newInitializationCompound).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImperativeModelPackage.IMPERATIVE_FUNCTION__INITIALIZATION_COMPOUND, null, msgs);
			msgs = basicSetInitializationCompound(newInitializationCompound, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeModelPackage.IMPERATIVE_FUNCTION__INITIALIZATION_COMPOUND, newInitializationCompound, newInitializationCompound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComputationCompound> getComputationCompounds() {
		if (computationCompounds == null) {
			computationCompounds = new EObjectContainmentEList<ComputationCompound>(ComputationCompound.class, this, ImperativeModelPackage.IMPERATIVE_FUNCTION__COMPUTATION_COMPOUNDS);
		}
		return computationCompounds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ImperativeModelPackage.IMPERATIVE_FUNCTION__TEMPLATE_VARIABLE_DECLARATIONS:
				return ((InternalEList<?>)getTemplateVariableDeclarations()).basicRemove(otherEnd, msgs);
			case ImperativeModelPackage.IMPERATIVE_FUNCTION__INPUT_VARIABLE_DECLARATIONS:
				return ((InternalEList<?>)getInputVariableDeclarations()).basicRemove(otherEnd, msgs);
			case ImperativeModelPackage.IMPERATIVE_FUNCTION__OUTPUT_VARIABLE_DECLARATIONS:
				return ((InternalEList<?>)getOutputVariableDeclarations()).basicRemove(otherEnd, msgs);
			case ImperativeModelPackage.IMPERATIVE_FUNCTION__INSTANCE_VARIABLE_DECLARATIONS:
				return ((InternalEList<?>)getInstanceVariableDeclarations()).basicRemove(otherEnd, msgs);
			case ImperativeModelPackage.IMPERATIVE_FUNCTION__INITIALIZATION_COMPOUND:
				return basicSetInitializationCompound(null, msgs);
			case ImperativeModelPackage.IMPERATIVE_FUNCTION__COMPUTATION_COMPOUNDS:
				return ((InternalEList<?>)getComputationCompounds()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImperativeModelPackage.IMPERATIVE_FUNCTION__TEMPLATE_VARIABLE_DECLARATIONS:
				return getTemplateVariableDeclarations();
			case ImperativeModelPackage.IMPERATIVE_FUNCTION__INPUT_VARIABLE_DECLARATIONS:
				return getInputVariableDeclarations();
			case ImperativeModelPackage.IMPERATIVE_FUNCTION__OUTPUT_VARIABLE_DECLARATIONS:
				return getOutputVariableDeclarations();
			case ImperativeModelPackage.IMPERATIVE_FUNCTION__INSTANCE_VARIABLE_DECLARATIONS:
				return getInstanceVariableDeclarations();
			case ImperativeModelPackage.IMPERATIVE_FUNCTION__INITIALIZATION_COMPOUND:
				return getInitializationCompound();
			case ImperativeModelPackage.IMPERATIVE_FUNCTION__COMPUTATION_COMPOUNDS:
				return getComputationCompounds();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ImperativeModelPackage.IMPERATIVE_FUNCTION__TEMPLATE_VARIABLE_DECLARATIONS:
				getTemplateVariableDeclarations().clear();
				getTemplateVariableDeclarations().addAll((Collection<? extends TemplateVariableDeclaration>)newValue);
				return;
			case ImperativeModelPackage.IMPERATIVE_FUNCTION__INPUT_VARIABLE_DECLARATIONS:
				getInputVariableDeclarations().clear();
				getInputVariableDeclarations().addAll((Collection<? extends InputVariableDeclaration>)newValue);
				return;
			case ImperativeModelPackage.IMPERATIVE_FUNCTION__OUTPUT_VARIABLE_DECLARATIONS:
				getOutputVariableDeclarations().clear();
				getOutputVariableDeclarations().addAll((Collection<? extends OutputVariableDeclaration>)newValue);
				return;
			case ImperativeModelPackage.IMPERATIVE_FUNCTION__INSTANCE_VARIABLE_DECLARATIONS:
				getInstanceVariableDeclarations().clear();
				getInstanceVariableDeclarations().addAll((Collection<? extends InstanceVariableDeclaration>)newValue);
				return;
			case ImperativeModelPackage.IMPERATIVE_FUNCTION__INITIALIZATION_COMPOUND:
				setInitializationCompound((Compound)newValue);
				return;
			case ImperativeModelPackage.IMPERATIVE_FUNCTION__COMPUTATION_COMPOUNDS:
				getComputationCompounds().clear();
				getComputationCompounds().addAll((Collection<? extends ComputationCompound>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ImperativeModelPackage.IMPERATIVE_FUNCTION__TEMPLATE_VARIABLE_DECLARATIONS:
				getTemplateVariableDeclarations().clear();
				return;
			case ImperativeModelPackage.IMPERATIVE_FUNCTION__INPUT_VARIABLE_DECLARATIONS:
				getInputVariableDeclarations().clear();
				return;
			case ImperativeModelPackage.IMPERATIVE_FUNCTION__OUTPUT_VARIABLE_DECLARATIONS:
				getOutputVariableDeclarations().clear();
				return;
			case ImperativeModelPackage.IMPERATIVE_FUNCTION__INSTANCE_VARIABLE_DECLARATIONS:
				getInstanceVariableDeclarations().clear();
				return;
			case ImperativeModelPackage.IMPERATIVE_FUNCTION__INITIALIZATION_COMPOUND:
				setInitializationCompound((Compound)null);
				return;
			case ImperativeModelPackage.IMPERATIVE_FUNCTION__COMPUTATION_COMPOUNDS:
				getComputationCompounds().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ImperativeModelPackage.IMPERATIVE_FUNCTION__TEMPLATE_VARIABLE_DECLARATIONS:
				return templateVariableDeclarations != null && !templateVariableDeclarations.isEmpty();
			case ImperativeModelPackage.IMPERATIVE_FUNCTION__INPUT_VARIABLE_DECLARATIONS:
				return inputVariableDeclarations != null && !inputVariableDeclarations.isEmpty();
			case ImperativeModelPackage.IMPERATIVE_FUNCTION__OUTPUT_VARIABLE_DECLARATIONS:
				return outputVariableDeclarations != null && !outputVariableDeclarations.isEmpty();
			case ImperativeModelPackage.IMPERATIVE_FUNCTION__INSTANCE_VARIABLE_DECLARATIONS:
				return instanceVariableDeclarations != null && !instanceVariableDeclarations.isEmpty();
			case ImperativeModelPackage.IMPERATIVE_FUNCTION__INITIALIZATION_COMPOUND:
				return initializationCompound != null;
			case ImperativeModelPackage.IMPERATIVE_FUNCTION__COMPUTATION_COMPOUNDS:
				return computationCompounds != null && !computationCompounds.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ImperativeFunctionImpl
