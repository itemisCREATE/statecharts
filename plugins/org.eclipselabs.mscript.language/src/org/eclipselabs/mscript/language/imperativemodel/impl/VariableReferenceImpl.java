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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.impl.ExpressionImpl;
import org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage;
import org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.VariableReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.impl.VariableReferenceImpl#getDeclaration <em>Declaration</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.impl.VariableReferenceImpl#getStepIndex <em>Step Index</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.impl.VariableReferenceImpl#getArrayIndices <em>Array Indices</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableReferenceImpl extends ExpressionImpl implements VariableReference {
	/**
	 * The cached value of the '{@link #getDeclaration() <em>Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaration()
	 * @generated
	 * @ordered
	 */
	protected VariableDeclaration declaration;

	/**
	 * The default value of the '{@link #getStepIndex() <em>Step Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int STEP_INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStepIndex() <em>Step Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepIndex()
	 * @generated
	 * @ordered
	 */
	protected int stepIndex = STEP_INDEX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getArrayIndices() <em>Array Indices</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrayIndices()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> arrayIndices;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImperativeModelPackage.Literals.VARIABLE_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration getDeclaration() {
		if (declaration != null && declaration.eIsProxy()) {
			InternalEObject oldDeclaration = (InternalEObject)declaration;
			declaration = (VariableDeclaration)eResolveProxy(oldDeclaration);
			if (declaration != oldDeclaration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ImperativeModelPackage.VARIABLE_REFERENCE__DECLARATION, oldDeclaration, declaration));
			}
		}
		return declaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration basicGetDeclaration() {
		return declaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclaration(VariableDeclaration newDeclaration) {
		VariableDeclaration oldDeclaration = declaration;
		declaration = newDeclaration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeModelPackage.VARIABLE_REFERENCE__DECLARATION, oldDeclaration, declaration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStepIndex() {
		return stepIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStepIndex(int newStepIndex) {
		int oldStepIndex = stepIndex;
		stepIndex = newStepIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeModelPackage.VARIABLE_REFERENCE__STEP_INDEX, oldStepIndex, stepIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expression> getArrayIndices() {
		if (arrayIndices == null) {
			arrayIndices = new EObjectContainmentEList<Expression>(Expression.class, this, ImperativeModelPackage.VARIABLE_REFERENCE__ARRAY_INDICES);
		}
		return arrayIndices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ImperativeModelPackage.VARIABLE_REFERENCE__ARRAY_INDICES:
				return ((InternalEList<?>)getArrayIndices()).basicRemove(otherEnd, msgs);
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
			case ImperativeModelPackage.VARIABLE_REFERENCE__DECLARATION:
				if (resolve) return getDeclaration();
				return basicGetDeclaration();
			case ImperativeModelPackage.VARIABLE_REFERENCE__STEP_INDEX:
				return getStepIndex();
			case ImperativeModelPackage.VARIABLE_REFERENCE__ARRAY_INDICES:
				return getArrayIndices();
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
			case ImperativeModelPackage.VARIABLE_REFERENCE__DECLARATION:
				setDeclaration((VariableDeclaration)newValue);
				return;
			case ImperativeModelPackage.VARIABLE_REFERENCE__STEP_INDEX:
				setStepIndex((Integer)newValue);
				return;
			case ImperativeModelPackage.VARIABLE_REFERENCE__ARRAY_INDICES:
				getArrayIndices().clear();
				getArrayIndices().addAll((Collection<? extends Expression>)newValue);
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
			case ImperativeModelPackage.VARIABLE_REFERENCE__DECLARATION:
				setDeclaration((VariableDeclaration)null);
				return;
			case ImperativeModelPackage.VARIABLE_REFERENCE__STEP_INDEX:
				setStepIndex(STEP_INDEX_EDEFAULT);
				return;
			case ImperativeModelPackage.VARIABLE_REFERENCE__ARRAY_INDICES:
				getArrayIndices().clear();
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
			case ImperativeModelPackage.VARIABLE_REFERENCE__DECLARATION:
				return declaration != null;
			case ImperativeModelPackage.VARIABLE_REFERENCE__STEP_INDEX:
				return stepIndex != STEP_INDEX_EDEFAULT;
			case ImperativeModelPackage.VARIABLE_REFERENCE__ARRAY_INDICES:
				return arrayIndices != null && !arrayIndices.isEmpty();
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
		result.append(" (stepIndex: ");
		result.append(stepIndex);
		result.append(')');
		return result.toString();
	}

} //VariableReferenceImpl
