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
import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.CallableElement;
import org.eclipselabs.mscript.language.ast.ForStatement;
import org.eclipselabs.mscript.language.ast.IterationVariable;
import org.eclipselabs.mscript.language.ast.Statement;
import org.eclipselabs.mscript.typesystem.Expression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>For Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.ForStatementImpl#getDeclaredIterationVariable <em>Declared Iteration Variable</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.ForStatementImpl#getIterationVariable <em>Iteration Variable</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.ForStatementImpl#getCollectionExpression <em>Collection Expression</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.ForStatementImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.ForStatementImpl#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ForStatementImpl extends StatementImpl implements ForStatement {
	/**
	 * The cached value of the '{@link #getDeclaredIterationVariable() <em>Declared Iteration Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaredIterationVariable()
	 * @generated
	 * @ordered
	 */
	protected IterationVariable declaredIterationVariable;

	/**
	 * The cached value of the '{@link #getIterationVariable() <em>Iteration Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterationVariable()
	 * @generated
	 * @ordered
	 */
	protected CallableElement iterationVariable;

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
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected Expression condition;

	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected Statement body;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstPackage.Literals.FOR_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IterationVariable getDeclaredIterationVariable() {
		return declaredIterationVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeclaredIterationVariable(IterationVariable newDeclaredIterationVariable, NotificationChain msgs) {
		IterationVariable oldDeclaredIterationVariable = declaredIterationVariable;
		declaredIterationVariable = newDeclaredIterationVariable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.FOR_STATEMENT__DECLARED_ITERATION_VARIABLE, oldDeclaredIterationVariable, newDeclaredIterationVariable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclaredIterationVariable(IterationVariable newDeclaredIterationVariable) {
		if (newDeclaredIterationVariable != declaredIterationVariable) {
			NotificationChain msgs = null;
			if (declaredIterationVariable != null)
				msgs = ((InternalEObject)declaredIterationVariable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.FOR_STATEMENT__DECLARED_ITERATION_VARIABLE, null, msgs);
			if (newDeclaredIterationVariable != null)
				msgs = ((InternalEObject)newDeclaredIterationVariable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.FOR_STATEMENT__DECLARED_ITERATION_VARIABLE, null, msgs);
			msgs = basicSetDeclaredIterationVariable(newDeclaredIterationVariable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.FOR_STATEMENT__DECLARED_ITERATION_VARIABLE, newDeclaredIterationVariable, newDeclaredIterationVariable));
	}

	public CallableElement getIterationVariable() {
		CallableElement iterationVariable = getDeclaredIterationVariable();
		return iterationVariable != null ? iterationVariable : getIterationVariableGen();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallableElement getIterationVariableGen() {
		if (iterationVariable != null && iterationVariable.eIsProxy()) {
			InternalEObject oldIterationVariable = (InternalEObject)iterationVariable;
			iterationVariable = (CallableElement)eResolveProxy(oldIterationVariable);
			if (iterationVariable != oldIterationVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AstPackage.FOR_STATEMENT__ITERATION_VARIABLE, oldIterationVariable, iterationVariable));
			}
		}
		return iterationVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallableElement basicGetIterationVariable() {
		return iterationVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIterationVariable(CallableElement newIterationVariable) {
		CallableElement oldIterationVariable = iterationVariable;
		iterationVariable = newIterationVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.FOR_STATEMENT__ITERATION_VARIABLE, oldIterationVariable, iterationVariable));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.FOR_STATEMENT__COLLECTION_EXPRESSION, oldCollectionExpression, newCollectionExpression);
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
				msgs = ((InternalEObject)collectionExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.FOR_STATEMENT__COLLECTION_EXPRESSION, null, msgs);
			if (newCollectionExpression != null)
				msgs = ((InternalEObject)newCollectionExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.FOR_STATEMENT__COLLECTION_EXPRESSION, null, msgs);
			msgs = basicSetCollectionExpression(newCollectionExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.FOR_STATEMENT__COLLECTION_EXPRESSION, newCollectionExpression, newCollectionExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(Expression newCondition, NotificationChain msgs) {
		Expression oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.FOR_STATEMENT__CONDITION, oldCondition, newCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(Expression newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.FOR_STATEMENT__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.FOR_STATEMENT__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.FOR_STATEMENT__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Statement getBody() {
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBody(Statement newBody, NotificationChain msgs) {
		Statement oldBody = body;
		body = newBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.FOR_STATEMENT__BODY, oldBody, newBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBody(Statement newBody) {
		if (newBody != body) {
			NotificationChain msgs = null;
			if (body != null)
				msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.FOR_STATEMENT__BODY, null, msgs);
			if (newBody != null)
				msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.FOR_STATEMENT__BODY, null, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.FOR_STATEMENT__BODY, newBody, newBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstPackage.FOR_STATEMENT__DECLARED_ITERATION_VARIABLE:
				return basicSetDeclaredIterationVariable(null, msgs);
			case AstPackage.FOR_STATEMENT__COLLECTION_EXPRESSION:
				return basicSetCollectionExpression(null, msgs);
			case AstPackage.FOR_STATEMENT__CONDITION:
				return basicSetCondition(null, msgs);
			case AstPackage.FOR_STATEMENT__BODY:
				return basicSetBody(null, msgs);
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
			case AstPackage.FOR_STATEMENT__DECLARED_ITERATION_VARIABLE:
				return getDeclaredIterationVariable();
			case AstPackage.FOR_STATEMENT__ITERATION_VARIABLE:
				if (resolve) return getIterationVariable();
				return basicGetIterationVariable();
			case AstPackage.FOR_STATEMENT__COLLECTION_EXPRESSION:
				return getCollectionExpression();
			case AstPackage.FOR_STATEMENT__CONDITION:
				return getCondition();
			case AstPackage.FOR_STATEMENT__BODY:
				return getBody();
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
			case AstPackage.FOR_STATEMENT__DECLARED_ITERATION_VARIABLE:
				setDeclaredIterationVariable((IterationVariable)newValue);
				return;
			case AstPackage.FOR_STATEMENT__ITERATION_VARIABLE:
				setIterationVariable((CallableElement)newValue);
				return;
			case AstPackage.FOR_STATEMENT__COLLECTION_EXPRESSION:
				setCollectionExpression((Expression)newValue);
				return;
			case AstPackage.FOR_STATEMENT__CONDITION:
				setCondition((Expression)newValue);
				return;
			case AstPackage.FOR_STATEMENT__BODY:
				setBody((Statement)newValue);
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
			case AstPackage.FOR_STATEMENT__DECLARED_ITERATION_VARIABLE:
				setDeclaredIterationVariable((IterationVariable)null);
				return;
			case AstPackage.FOR_STATEMENT__ITERATION_VARIABLE:
				setIterationVariable((CallableElement)null);
				return;
			case AstPackage.FOR_STATEMENT__COLLECTION_EXPRESSION:
				setCollectionExpression((Expression)null);
				return;
			case AstPackage.FOR_STATEMENT__CONDITION:
				setCondition((Expression)null);
				return;
			case AstPackage.FOR_STATEMENT__BODY:
				setBody((Statement)null);
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
			case AstPackage.FOR_STATEMENT__DECLARED_ITERATION_VARIABLE:
				return declaredIterationVariable != null;
			case AstPackage.FOR_STATEMENT__ITERATION_VARIABLE:
				return iterationVariable != null;
			case AstPackage.FOR_STATEMENT__COLLECTION_EXPRESSION:
				return collectionExpression != null;
			case AstPackage.FOR_STATEMENT__CONDITION:
				return condition != null;
			case AstPackage.FOR_STATEMENT__BODY:
				return body != null;
		}
		return super.eIsSet(featureID);
	}

} //ForStatementImpl
