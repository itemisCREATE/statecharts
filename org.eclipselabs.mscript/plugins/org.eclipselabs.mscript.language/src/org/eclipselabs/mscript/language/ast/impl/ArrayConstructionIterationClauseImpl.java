/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.ast.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipselabs.mscript.language.ast.ArrayConstructionIterationClause;
import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.Expression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Array Construction Iteration Clause</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.ArrayConstructionIterationClauseImpl#getVariableName <em>Variable Name</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.ArrayConstructionIterationClauseImpl#getCollectionExpression <em>Collection Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArrayConstructionIterationClauseImpl extends MinimalEObjectImpl.Container implements ArrayConstructionIterationClause {
	/**
	 * The default value of the '{@link #getVariableName() <em>Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableName()
	 * @generated
	 * @ordered
	 */
	protected static final String VARIABLE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVariableName() <em>Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableName()
	 * @generated
	 * @ordered
	 */
	protected String variableName = VARIABLE_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCollectionExpression() <em>Collection Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollectionExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression collectionExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArrayConstructionIterationClauseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstPackage.Literals.ARRAY_CONSTRUCTION_ITERATION_CLAUSE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVariableName() {
		return variableName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariableName(String newVariableName) {
		String oldVariableName = variableName;
		variableName = newVariableName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.ARRAY_CONSTRUCTION_ITERATION_CLAUSE__VARIABLE_NAME, oldVariableName, variableName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getCollectionExpression() {
		return collectionExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCollectionExpression(Expression newCollectionExpression, NotificationChain msgs) {
		Expression oldCollectionExpression = collectionExpression;
		collectionExpression = newCollectionExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.ARRAY_CONSTRUCTION_ITERATION_CLAUSE__COLLECTION_EXPRESSION, oldCollectionExpression, newCollectionExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCollectionExpression(Expression newCollectionExpression) {
		if (newCollectionExpression != collectionExpression) {
			NotificationChain msgs = null;
			if (collectionExpression != null)
				msgs = ((InternalEObject)collectionExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.ARRAY_CONSTRUCTION_ITERATION_CLAUSE__COLLECTION_EXPRESSION, null, msgs);
			if (newCollectionExpression != null)
				msgs = ((InternalEObject)newCollectionExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.ARRAY_CONSTRUCTION_ITERATION_CLAUSE__COLLECTION_EXPRESSION, null, msgs);
			msgs = basicSetCollectionExpression(newCollectionExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.ARRAY_CONSTRUCTION_ITERATION_CLAUSE__COLLECTION_EXPRESSION, newCollectionExpression, newCollectionExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstPackage.ARRAY_CONSTRUCTION_ITERATION_CLAUSE__COLLECTION_EXPRESSION:
				return basicSetCollectionExpression(null, msgs);
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
			case AstPackage.ARRAY_CONSTRUCTION_ITERATION_CLAUSE__VARIABLE_NAME:
				return getVariableName();
			case AstPackage.ARRAY_CONSTRUCTION_ITERATION_CLAUSE__COLLECTION_EXPRESSION:
				return getCollectionExpression();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AstPackage.ARRAY_CONSTRUCTION_ITERATION_CLAUSE__VARIABLE_NAME:
				setVariableName((String)newValue);
				return;
			case AstPackage.ARRAY_CONSTRUCTION_ITERATION_CLAUSE__COLLECTION_EXPRESSION:
				setCollectionExpression((Expression)newValue);
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
			case AstPackage.ARRAY_CONSTRUCTION_ITERATION_CLAUSE__VARIABLE_NAME:
				setVariableName(VARIABLE_NAME_EDEFAULT);
				return;
			case AstPackage.ARRAY_CONSTRUCTION_ITERATION_CLAUSE__COLLECTION_EXPRESSION:
				setCollectionExpression((Expression)null);
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
			case AstPackage.ARRAY_CONSTRUCTION_ITERATION_CLAUSE__VARIABLE_NAME:
				return VARIABLE_NAME_EDEFAULT == null ? variableName != null : !VARIABLE_NAME_EDEFAULT.equals(variableName);
			case AstPackage.ARRAY_CONSTRUCTION_ITERATION_CLAUSE__COLLECTION_EXPRESSION:
				return collectionExpression != null;
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
		result.append(" (variableName: ");
		result.append(variableName);
		result.append(')');
		return result.toString();
	}

} //ArrayConstructionIterationClauseImpl
