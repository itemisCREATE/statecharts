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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.LetExpression;
import org.eclipselabs.mscript.language.ast.LetExpressionVariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Let Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.LetExpressionImpl#getVariableDeclarations <em>Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.LetExpressionImpl#getTargetExpression <em>Target Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LetExpressionImpl extends ExpressionImpl implements LetExpression {
	/**
	 * The cached value of the '{@link #getVariableDeclarations() <em>Variable Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<LetExpressionVariableDeclaration> variableDeclarations;

	/**
	 * The cached value of the '{@link #getTargetExpression() <em>Target Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression targetExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LetExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstPackage.Literals.LET_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LetExpressionVariableDeclaration> getVariableDeclarations() {
		if (variableDeclarations == null) {
			variableDeclarations = new EObjectContainmentEList<LetExpressionVariableDeclaration>(LetExpressionVariableDeclaration.class, this, AstPackage.LET_EXPRESSION__VARIABLE_DECLARATIONS);
		}
		return variableDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getTargetExpression() {
		return targetExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetExpression(Expression newTargetExpression, NotificationChain msgs) {
		Expression oldTargetExpression = targetExpression;
		targetExpression = newTargetExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.LET_EXPRESSION__TARGET_EXPRESSION, oldTargetExpression, newTargetExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetExpression(Expression newTargetExpression) {
		if (newTargetExpression != targetExpression) {
			NotificationChain msgs = null;
			if (targetExpression != null)
				msgs = ((InternalEObject)targetExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.LET_EXPRESSION__TARGET_EXPRESSION, null, msgs);
			if (newTargetExpression != null)
				msgs = ((InternalEObject)newTargetExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.LET_EXPRESSION__TARGET_EXPRESSION, null, msgs);
			msgs = basicSetTargetExpression(newTargetExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.LET_EXPRESSION__TARGET_EXPRESSION, newTargetExpression, newTargetExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstPackage.LET_EXPRESSION__VARIABLE_DECLARATIONS:
				return ((InternalEList<?>)getVariableDeclarations()).basicRemove(otherEnd, msgs);
			case AstPackage.LET_EXPRESSION__TARGET_EXPRESSION:
				return basicSetTargetExpression(null, msgs);
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
			case AstPackage.LET_EXPRESSION__VARIABLE_DECLARATIONS:
				return getVariableDeclarations();
			case AstPackage.LET_EXPRESSION__TARGET_EXPRESSION:
				return getTargetExpression();
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
			case AstPackage.LET_EXPRESSION__VARIABLE_DECLARATIONS:
				getVariableDeclarations().clear();
				getVariableDeclarations().addAll((Collection<? extends LetExpressionVariableDeclaration>)newValue);
				return;
			case AstPackage.LET_EXPRESSION__TARGET_EXPRESSION:
				setTargetExpression((Expression)newValue);
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
			case AstPackage.LET_EXPRESSION__VARIABLE_DECLARATIONS:
				getVariableDeclarations().clear();
				return;
			case AstPackage.LET_EXPRESSION__TARGET_EXPRESSION:
				setTargetExpression((Expression)null);
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
			case AstPackage.LET_EXPRESSION__VARIABLE_DECLARATIONS:
				return variableDeclarations != null && !variableDeclarations.isEmpty();
			case AstPackage.LET_EXPRESSION__TARGET_EXPRESSION:
				return targetExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //LetExpressionImpl
