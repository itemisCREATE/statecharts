/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sgen.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.eclipse.xtext.xbase.interpreter.IExpressionInterpreter;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.FeatureParameter;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.SGenPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Feature Parameter Value</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.yakindu.sct.model.sgen.impl.FeatureParameterValueImpl#getParameter
 * <em>Parameter</em>}</li>
 * <li>
 * {@link org.yakindu.sct.model.sgen.impl.FeatureParameterValueImpl#getFeatureConfiguration
 * <em>Feature Configuration</em>}</li>
 * <li>
 * {@link org.yakindu.sct.model.sgen.impl.FeatureParameterValueImpl#getExpression
 * <em>Expression</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
@SuppressWarnings("restriction")
public class FeatureParameterValueImpl extends EObjectImpl implements
		FeatureParameterValue {
	/**
	 * The cached value of the '{@link #getParameter() <em>Parameter</em>}'
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
	protected FeatureParameter parameter;

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected XExpression expression;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	protected FeatureParameterValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SGenPackage.Literals.FEATURE_PARAMETER_VALUE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FeatureParameter getParameter() {
		if (parameter != null && parameter.eIsProxy()) {
			InternalEObject oldParameter = (InternalEObject) parameter;
			parameter = (FeatureParameter) eResolveProxy(oldParameter);
			if (parameter != oldParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							SGenPackage.FEATURE_PARAMETER_VALUE__PARAMETER,
							oldParameter, parameter));
			}
		}
		return parameter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FeatureParameter basicGetParameter() {
		return parameter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setParameter(FeatureParameter newParameter) {
		FeatureParameter oldParameter = parameter;
		parameter = newParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					SGenPackage.FEATURE_PARAMETER_VALUE__PARAMETER,
					oldParameter, parameter));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FeatureConfiguration getFeatureConfiguration() {
		if (eContainerFeatureID() != SGenPackage.FEATURE_PARAMETER_VALUE__FEATURE_CONFIGURATION)
			return null;
		return (FeatureConfiguration) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public XExpression getExpression() {
		return expression;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetExpression(XExpression newExpression,
			NotificationChain msgs) {
		XExpression oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					SGenPackage.FEATURE_PARAMETER_VALUE__EXPRESSION,
					oldExpression, newExpression);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setExpression(XExpression newExpression) {
		if (newExpression != expression) {
			NotificationChain msgs = null;
			if (expression != null)
				msgs = ((InternalEObject) expression)
						.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
										- SGenPackage.FEATURE_PARAMETER_VALUE__EXPRESSION,
								null, msgs);
			if (newExpression != null)
				msgs = ((InternalEObject) newExpression)
						.eInverseAdd(
								this,
								EOPPOSITE_FEATURE_BASE
										- SGenPackage.FEATURE_PARAMETER_VALUE__EXPRESSION,
								null, msgs);
			msgs = basicSetExpression(newExpression, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					SGenPackage.FEATURE_PARAMETER_VALUE__EXPRESSION,
					newExpression, newExpression));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setValue(String string) {
		XStringLiteral literal = XbaseFactory.eINSTANCE.createXStringLiteral();
		literal.setValue(string);
		setExpression(literal);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setValue(boolean boolean_) {
		XBooleanLiteral literal = XbaseFactory.eINSTANCE
				.createXBooleanLiteral();
		literal.setIsTrue(boolean_);
		setExpression(literal);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String getStringValue() {
		return (String) getInterpreter().evaluate(getExpression()).getResult();
	}

	private IExpressionInterpreter getInterpreter() {
		if (eResource() instanceof IExpressionInterpreter) {
			return (IExpressionInterpreter) eResource();
		}
		throw new IllegalStateException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean getBooleanValue() {
		return (Boolean) getInterpreter().evaluate(getExpression()).getResult();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Object getValue() {
		return getInterpreter().evaluate(getExpression()).getResult();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case SGenPackage.FEATURE_PARAMETER_VALUE__FEATURE_CONFIGURATION:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return eBasicSetContainer(otherEnd,
					SGenPackage.FEATURE_PARAMETER_VALUE__FEATURE_CONFIGURATION,
					msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case SGenPackage.FEATURE_PARAMETER_VALUE__FEATURE_CONFIGURATION:
			return eBasicSetContainer(null,
					SGenPackage.FEATURE_PARAMETER_VALUE__FEATURE_CONFIGURATION,
					msgs);
		case SGenPackage.FEATURE_PARAMETER_VALUE__EXPRESSION:
			return basicSetExpression(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(
			NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case SGenPackage.FEATURE_PARAMETER_VALUE__FEATURE_CONFIGURATION:
			return eInternalContainer().eInverseRemove(this,
					SGenPackage.FEATURE_CONFIGURATION__PARAMETER_VALUES,
					FeatureConfiguration.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case SGenPackage.FEATURE_PARAMETER_VALUE__PARAMETER:
			if (resolve)
				return getParameter();
			return basicGetParameter();
		case SGenPackage.FEATURE_PARAMETER_VALUE__FEATURE_CONFIGURATION:
			return getFeatureConfiguration();
		case SGenPackage.FEATURE_PARAMETER_VALUE__EXPRESSION:
			return getExpression();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case SGenPackage.FEATURE_PARAMETER_VALUE__PARAMETER:
			setParameter((FeatureParameter) newValue);
			return;
		case SGenPackage.FEATURE_PARAMETER_VALUE__EXPRESSION:
			setExpression((XExpression) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case SGenPackage.FEATURE_PARAMETER_VALUE__PARAMETER:
			setParameter((FeatureParameter) null);
			return;
		case SGenPackage.FEATURE_PARAMETER_VALUE__EXPRESSION:
			setExpression((XExpression) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case SGenPackage.FEATURE_PARAMETER_VALUE__PARAMETER:
			return parameter != null;
		case SGenPackage.FEATURE_PARAMETER_VALUE__FEATURE_CONFIGURATION:
			return getFeatureConfiguration() != null;
		case SGenPackage.FEATURE_PARAMETER_VALUE__EXPRESSION:
			return expression != null;
		}
		return super.eIsSet(featureID);
	}

} // FeatureParameterValueImpl
