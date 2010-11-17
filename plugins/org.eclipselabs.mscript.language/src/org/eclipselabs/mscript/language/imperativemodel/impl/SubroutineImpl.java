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
import org.eclipselabs.mscript.language.imperativemodel.ComputationCompound;
import org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage;
import org.eclipselabs.mscript.language.imperativemodel.InputVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.OutputVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.Subroutine;
import org.eclipselabs.mscript.language.imperativemodel.SubroutineContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subroutine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.impl.SubroutineImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.impl.SubroutineImpl#getInputVariableDeclarations <em>Input Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.impl.SubroutineImpl#getOutputVariableDeclarations <em>Output Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.impl.SubroutineImpl#getComputationCompounds <em>Computation Compounds</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubroutineImpl extends EObjectImpl implements Subroutine {
	/**
	 * The cached value of the '{@link #getContext() <em>Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected SubroutineContext context;

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
	protected SubroutineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImperativeModelPackage.Literals.SUBROUTINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubroutineContext getContext() {
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContext(SubroutineContext newContext, NotificationChain msgs) {
		SubroutineContext oldContext = context;
		context = newContext;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImperativeModelPackage.SUBROUTINE__CONTEXT, oldContext, newContext);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContext(SubroutineContext newContext) {
		if (newContext != context) {
			NotificationChain msgs = null;
			if (context != null)
				msgs = ((InternalEObject)context).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImperativeModelPackage.SUBROUTINE__CONTEXT, null, msgs);
			if (newContext != null)
				msgs = ((InternalEObject)newContext).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImperativeModelPackage.SUBROUTINE__CONTEXT, null, msgs);
			msgs = basicSetContext(newContext, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeModelPackage.SUBROUTINE__CONTEXT, newContext, newContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InputVariableDeclaration> getInputVariableDeclarations() {
		if (inputVariableDeclarations == null) {
			inputVariableDeclarations = new EObjectContainmentEList<InputVariableDeclaration>(InputVariableDeclaration.class, this, ImperativeModelPackage.SUBROUTINE__INPUT_VARIABLE_DECLARATIONS);
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
			outputVariableDeclarations = new EObjectContainmentEList<OutputVariableDeclaration>(OutputVariableDeclaration.class, this, ImperativeModelPackage.SUBROUTINE__OUTPUT_VARIABLE_DECLARATIONS);
		}
		return outputVariableDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComputationCompound> getComputationCompounds() {
		if (computationCompounds == null) {
			computationCompounds = new EObjectContainmentEList<ComputationCompound>(ComputationCompound.class, this, ImperativeModelPackage.SUBROUTINE__COMPUTATION_COMPOUNDS);
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
			case ImperativeModelPackage.SUBROUTINE__CONTEXT:
				return basicSetContext(null, msgs);
			case ImperativeModelPackage.SUBROUTINE__INPUT_VARIABLE_DECLARATIONS:
				return ((InternalEList<?>)getInputVariableDeclarations()).basicRemove(otherEnd, msgs);
			case ImperativeModelPackage.SUBROUTINE__OUTPUT_VARIABLE_DECLARATIONS:
				return ((InternalEList<?>)getOutputVariableDeclarations()).basicRemove(otherEnd, msgs);
			case ImperativeModelPackage.SUBROUTINE__COMPUTATION_COMPOUNDS:
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
			case ImperativeModelPackage.SUBROUTINE__CONTEXT:
				return getContext();
			case ImperativeModelPackage.SUBROUTINE__INPUT_VARIABLE_DECLARATIONS:
				return getInputVariableDeclarations();
			case ImperativeModelPackage.SUBROUTINE__OUTPUT_VARIABLE_DECLARATIONS:
				return getOutputVariableDeclarations();
			case ImperativeModelPackage.SUBROUTINE__COMPUTATION_COMPOUNDS:
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
			case ImperativeModelPackage.SUBROUTINE__CONTEXT:
				setContext((SubroutineContext)newValue);
				return;
			case ImperativeModelPackage.SUBROUTINE__INPUT_VARIABLE_DECLARATIONS:
				getInputVariableDeclarations().clear();
				getInputVariableDeclarations().addAll((Collection<? extends InputVariableDeclaration>)newValue);
				return;
			case ImperativeModelPackage.SUBROUTINE__OUTPUT_VARIABLE_DECLARATIONS:
				getOutputVariableDeclarations().clear();
				getOutputVariableDeclarations().addAll((Collection<? extends OutputVariableDeclaration>)newValue);
				return;
			case ImperativeModelPackage.SUBROUTINE__COMPUTATION_COMPOUNDS:
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
			case ImperativeModelPackage.SUBROUTINE__CONTEXT:
				setContext((SubroutineContext)null);
				return;
			case ImperativeModelPackage.SUBROUTINE__INPUT_VARIABLE_DECLARATIONS:
				getInputVariableDeclarations().clear();
				return;
			case ImperativeModelPackage.SUBROUTINE__OUTPUT_VARIABLE_DECLARATIONS:
				getOutputVariableDeclarations().clear();
				return;
			case ImperativeModelPackage.SUBROUTINE__COMPUTATION_COMPOUNDS:
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
			case ImperativeModelPackage.SUBROUTINE__CONTEXT:
				return context != null;
			case ImperativeModelPackage.SUBROUTINE__INPUT_VARIABLE_DECLARATIONS:
				return inputVariableDeclarations != null && !inputVariableDeclarations.isEmpty();
			case ImperativeModelPackage.SUBROUTINE__OUTPUT_VARIABLE_DECLARATIONS:
				return outputVariableDeclarations != null && !outputVariableDeclarations.isEmpty();
			case ImperativeModelPackage.SUBROUTINE__COMPUTATION_COMPOUNDS:
				return computationCompounds != null && !computationCompounds.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SubroutineImpl
