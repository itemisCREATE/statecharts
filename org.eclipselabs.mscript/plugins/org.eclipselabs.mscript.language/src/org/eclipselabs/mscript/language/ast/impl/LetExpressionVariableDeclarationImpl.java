/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.ast.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.LetExpressionVariableDeclaration;
import org.eclipselabs.mscript.typesystem.Expression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Let Expression Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.LetExpressionVariableDeclarationImpl#getNames <em>Names</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.LetExpressionVariableDeclarationImpl#getAssignedExpression <em>Assigned Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LetExpressionVariableDeclarationImpl extends MinimalEObjectImpl.Container implements LetExpressionVariableDeclaration {
	/**
	 * The cached value of the '{@link #getNames() <em>Names</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNames()
	 * @generated
	 * @ordered
	 */
	protected EList<String> names;

	/**
	 * The cached value of the '{@link #getAssignedExpression() <em>Assigned Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssignedExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression assignedExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LetExpressionVariableDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstPackage.Literals.LET_EXPRESSION_VARIABLE_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getNames() {
		if (names == null) {
			names = new EDataTypeEList<String>(String.class, this, AstPackage.LET_EXPRESSION_VARIABLE_DECLARATION__NAMES);
		}
		return names;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getAssignedExpression() {
		return assignedExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAssignedExpression(Expression newAssignedExpression, NotificationChain msgs) {
		Expression oldAssignedExpression = assignedExpression;
		assignedExpression = newAssignedExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.LET_EXPRESSION_VARIABLE_DECLARATION__ASSIGNED_EXPRESSION, oldAssignedExpression, newAssignedExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssignedExpression(Expression newAssignedExpression) {
		if (newAssignedExpression != assignedExpression) {
			NotificationChain msgs = null;
			if (assignedExpression != null)
				msgs = ((InternalEObject)assignedExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.LET_EXPRESSION_VARIABLE_DECLARATION__ASSIGNED_EXPRESSION, null, msgs);
			if (newAssignedExpression != null)
				msgs = ((InternalEObject)newAssignedExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.LET_EXPRESSION_VARIABLE_DECLARATION__ASSIGNED_EXPRESSION, null, msgs);
			msgs = basicSetAssignedExpression(newAssignedExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.LET_EXPRESSION_VARIABLE_DECLARATION__ASSIGNED_EXPRESSION, newAssignedExpression, newAssignedExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstPackage.LET_EXPRESSION_VARIABLE_DECLARATION__ASSIGNED_EXPRESSION:
				return basicSetAssignedExpression(null, msgs);
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
			case AstPackage.LET_EXPRESSION_VARIABLE_DECLARATION__NAMES:
				return getNames();
			case AstPackage.LET_EXPRESSION_VARIABLE_DECLARATION__ASSIGNED_EXPRESSION:
				return getAssignedExpression();
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
			case AstPackage.LET_EXPRESSION_VARIABLE_DECLARATION__NAMES:
				getNames().clear();
				getNames().addAll((Collection<? extends String>)newValue);
				return;
			case AstPackage.LET_EXPRESSION_VARIABLE_DECLARATION__ASSIGNED_EXPRESSION:
				setAssignedExpression((Expression)newValue);
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
			case AstPackage.LET_EXPRESSION_VARIABLE_DECLARATION__NAMES:
				getNames().clear();
				return;
			case AstPackage.LET_EXPRESSION_VARIABLE_DECLARATION__ASSIGNED_EXPRESSION:
				setAssignedExpression((Expression)null);
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
			case AstPackage.LET_EXPRESSION_VARIABLE_DECLARATION__NAMES:
				return names != null && !names.isEmpty();
			case AstPackage.LET_EXPRESSION_VARIABLE_DECLARATION__ASSIGNED_EXPRESSION:
				return assignedExpression != null;
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
		result.append(" (names: ");
		result.append(names);
		result.append(')');
		return result.toString();
	}

} //LetExpressionVariableDeclarationImpl
