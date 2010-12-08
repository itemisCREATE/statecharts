/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.il.impl;

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
import org.eclipselabs.mscript.language.il.Compound;
import org.eclipselabs.mscript.language.il.ComputationCompound;
import org.eclipselabs.mscript.language.il.ILFunctionDefinition;
import org.eclipselabs.mscript.language.il.ILPackage;
import org.eclipselabs.mscript.language.il.InputVariableDeclaration;
import org.eclipselabs.mscript.language.il.InstanceVariableDeclaration;
import org.eclipselabs.mscript.language.il.OutputVariableDeclaration;
import org.eclipselabs.mscript.language.il.TemplateVariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Imperative Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.il.impl.ILFunctionDefinitionImpl#isStateful <em>Stateful</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.il.impl.ILFunctionDefinitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.il.impl.ILFunctionDefinitionImpl#getTemplateVariableDeclarations <em>Template Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.il.impl.ILFunctionDefinitionImpl#getInputVariableDeclarations <em>Input Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.il.impl.ILFunctionDefinitionImpl#getOutputVariableDeclarations <em>Output Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.il.impl.ILFunctionDefinitionImpl#getInstanceVariableDeclarations <em>Instance Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.il.impl.ILFunctionDefinitionImpl#getInitializationCompound <em>Initialization Compound</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.il.impl.ILFunctionDefinitionImpl#getComputationCompounds <em>Computation Compounds</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ILFunctionDefinitionImpl extends EObjectImpl implements ILFunctionDefinition {
	/**
	 * The default value of the '{@link #isStateful() <em>Stateful</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStateful()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STATEFUL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStateful() <em>Stateful</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStateful()
	 * @generated
	 * @ordered
	 */
	protected boolean stateful = STATEFUL_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

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
	protected ILFunctionDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ILPackage.Literals.IL_FUNCTION_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStateful() {
		return stateful;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStateful(boolean newStateful) {
		boolean oldStateful = stateful;
		stateful = newStateful;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ILPackage.IL_FUNCTION_DEFINITION__STATEFUL, oldStateful, stateful));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ILPackage.IL_FUNCTION_DEFINITION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TemplateVariableDeclaration> getTemplateVariableDeclarations() {
		if (templateVariableDeclarations == null) {
			templateVariableDeclarations = new EObjectContainmentEList<TemplateVariableDeclaration>(TemplateVariableDeclaration.class, this, ILPackage.IL_FUNCTION_DEFINITION__TEMPLATE_VARIABLE_DECLARATIONS);
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
			inputVariableDeclarations = new EObjectContainmentEList<InputVariableDeclaration>(InputVariableDeclaration.class, this, ILPackage.IL_FUNCTION_DEFINITION__INPUT_VARIABLE_DECLARATIONS);
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
			outputVariableDeclarations = new EObjectContainmentEList<OutputVariableDeclaration>(OutputVariableDeclaration.class, this, ILPackage.IL_FUNCTION_DEFINITION__OUTPUT_VARIABLE_DECLARATIONS);
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
			instanceVariableDeclarations = new EObjectContainmentEList<InstanceVariableDeclaration>(InstanceVariableDeclaration.class, this, ILPackage.IL_FUNCTION_DEFINITION__INSTANCE_VARIABLE_DECLARATIONS);
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ILPackage.IL_FUNCTION_DEFINITION__INITIALIZATION_COMPOUND, oldInitializationCompound, newInitializationCompound);
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
				msgs = ((InternalEObject)initializationCompound).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ILPackage.IL_FUNCTION_DEFINITION__INITIALIZATION_COMPOUND, null, msgs);
			if (newInitializationCompound != null)
				msgs = ((InternalEObject)newInitializationCompound).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ILPackage.IL_FUNCTION_DEFINITION__INITIALIZATION_COMPOUND, null, msgs);
			msgs = basicSetInitializationCompound(newInitializationCompound, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ILPackage.IL_FUNCTION_DEFINITION__INITIALIZATION_COMPOUND, newInitializationCompound, newInitializationCompound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComputationCompound> getComputationCompounds() {
		if (computationCompounds == null) {
			computationCompounds = new EObjectContainmentEList<ComputationCompound>(ComputationCompound.class, this, ILPackage.IL_FUNCTION_DEFINITION__COMPUTATION_COMPOUNDS);
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
			case ILPackage.IL_FUNCTION_DEFINITION__TEMPLATE_VARIABLE_DECLARATIONS:
				return ((InternalEList<?>)getTemplateVariableDeclarations()).basicRemove(otherEnd, msgs);
			case ILPackage.IL_FUNCTION_DEFINITION__INPUT_VARIABLE_DECLARATIONS:
				return ((InternalEList<?>)getInputVariableDeclarations()).basicRemove(otherEnd, msgs);
			case ILPackage.IL_FUNCTION_DEFINITION__OUTPUT_VARIABLE_DECLARATIONS:
				return ((InternalEList<?>)getOutputVariableDeclarations()).basicRemove(otherEnd, msgs);
			case ILPackage.IL_FUNCTION_DEFINITION__INSTANCE_VARIABLE_DECLARATIONS:
				return ((InternalEList<?>)getInstanceVariableDeclarations()).basicRemove(otherEnd, msgs);
			case ILPackage.IL_FUNCTION_DEFINITION__INITIALIZATION_COMPOUND:
				return basicSetInitializationCompound(null, msgs);
			case ILPackage.IL_FUNCTION_DEFINITION__COMPUTATION_COMPOUNDS:
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
			case ILPackage.IL_FUNCTION_DEFINITION__STATEFUL:
				return isStateful();
			case ILPackage.IL_FUNCTION_DEFINITION__NAME:
				return getName();
			case ILPackage.IL_FUNCTION_DEFINITION__TEMPLATE_VARIABLE_DECLARATIONS:
				return getTemplateVariableDeclarations();
			case ILPackage.IL_FUNCTION_DEFINITION__INPUT_VARIABLE_DECLARATIONS:
				return getInputVariableDeclarations();
			case ILPackage.IL_FUNCTION_DEFINITION__OUTPUT_VARIABLE_DECLARATIONS:
				return getOutputVariableDeclarations();
			case ILPackage.IL_FUNCTION_DEFINITION__INSTANCE_VARIABLE_DECLARATIONS:
				return getInstanceVariableDeclarations();
			case ILPackage.IL_FUNCTION_DEFINITION__INITIALIZATION_COMPOUND:
				return getInitializationCompound();
			case ILPackage.IL_FUNCTION_DEFINITION__COMPUTATION_COMPOUNDS:
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
			case ILPackage.IL_FUNCTION_DEFINITION__STATEFUL:
				setStateful((Boolean)newValue);
				return;
			case ILPackage.IL_FUNCTION_DEFINITION__NAME:
				setName((String)newValue);
				return;
			case ILPackage.IL_FUNCTION_DEFINITION__TEMPLATE_VARIABLE_DECLARATIONS:
				getTemplateVariableDeclarations().clear();
				getTemplateVariableDeclarations().addAll((Collection<? extends TemplateVariableDeclaration>)newValue);
				return;
			case ILPackage.IL_FUNCTION_DEFINITION__INPUT_VARIABLE_DECLARATIONS:
				getInputVariableDeclarations().clear();
				getInputVariableDeclarations().addAll((Collection<? extends InputVariableDeclaration>)newValue);
				return;
			case ILPackage.IL_FUNCTION_DEFINITION__OUTPUT_VARIABLE_DECLARATIONS:
				getOutputVariableDeclarations().clear();
				getOutputVariableDeclarations().addAll((Collection<? extends OutputVariableDeclaration>)newValue);
				return;
			case ILPackage.IL_FUNCTION_DEFINITION__INSTANCE_VARIABLE_DECLARATIONS:
				getInstanceVariableDeclarations().clear();
				getInstanceVariableDeclarations().addAll((Collection<? extends InstanceVariableDeclaration>)newValue);
				return;
			case ILPackage.IL_FUNCTION_DEFINITION__INITIALIZATION_COMPOUND:
				setInitializationCompound((Compound)newValue);
				return;
			case ILPackage.IL_FUNCTION_DEFINITION__COMPUTATION_COMPOUNDS:
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
			case ILPackage.IL_FUNCTION_DEFINITION__STATEFUL:
				setStateful(STATEFUL_EDEFAULT);
				return;
			case ILPackage.IL_FUNCTION_DEFINITION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ILPackage.IL_FUNCTION_DEFINITION__TEMPLATE_VARIABLE_DECLARATIONS:
				getTemplateVariableDeclarations().clear();
				return;
			case ILPackage.IL_FUNCTION_DEFINITION__INPUT_VARIABLE_DECLARATIONS:
				getInputVariableDeclarations().clear();
				return;
			case ILPackage.IL_FUNCTION_DEFINITION__OUTPUT_VARIABLE_DECLARATIONS:
				getOutputVariableDeclarations().clear();
				return;
			case ILPackage.IL_FUNCTION_DEFINITION__INSTANCE_VARIABLE_DECLARATIONS:
				getInstanceVariableDeclarations().clear();
				return;
			case ILPackage.IL_FUNCTION_DEFINITION__INITIALIZATION_COMPOUND:
				setInitializationCompound((Compound)null);
				return;
			case ILPackage.IL_FUNCTION_DEFINITION__COMPUTATION_COMPOUNDS:
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
			case ILPackage.IL_FUNCTION_DEFINITION__STATEFUL:
				return stateful != STATEFUL_EDEFAULT;
			case ILPackage.IL_FUNCTION_DEFINITION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ILPackage.IL_FUNCTION_DEFINITION__TEMPLATE_VARIABLE_DECLARATIONS:
				return templateVariableDeclarations != null && !templateVariableDeclarations.isEmpty();
			case ILPackage.IL_FUNCTION_DEFINITION__INPUT_VARIABLE_DECLARATIONS:
				return inputVariableDeclarations != null && !inputVariableDeclarations.isEmpty();
			case ILPackage.IL_FUNCTION_DEFINITION__OUTPUT_VARIABLE_DECLARATIONS:
				return outputVariableDeclarations != null && !outputVariableDeclarations.isEmpty();
			case ILPackage.IL_FUNCTION_DEFINITION__INSTANCE_VARIABLE_DECLARATIONS:
				return instanceVariableDeclarations != null && !instanceVariableDeclarations.isEmpty();
			case ILPackage.IL_FUNCTION_DEFINITION__INITIALIZATION_COMPOUND:
				return initializationCompound != null;
			case ILPackage.IL_FUNCTION_DEFINITION__COMPUTATION_COMPOUNDS:
				return computationCompounds != null && !computationCompounds.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (stateful: ");
		result.append(stateful);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ILFunctionImpl
