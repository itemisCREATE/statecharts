/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.imperativemodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipselabs.mscript.language.imperativemodel.CircularBufferDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage;
import org.eclipselabs.mscript.language.imperativemodel.StatefulVariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stateful Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.impl.StatefulVariableDeclarationImpl#getCircularBufferDeclaration <em>Circular Buffer Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class StatefulVariableDeclarationImpl extends VariableDeclarationImpl implements StatefulVariableDeclaration {
	/**
	 * The cached value of the '{@link #getCircularBufferDeclaration() <em>Circular Buffer Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCircularBufferDeclaration()
	 * @generated
	 * @ordered
	 */
	protected CircularBufferDeclaration circularBufferDeclaration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StatefulVariableDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImperativeModelPackage.Literals.STATEFUL_VARIABLE_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CircularBufferDeclaration getCircularBufferDeclaration() {
		if (circularBufferDeclaration != null && circularBufferDeclaration.eIsProxy()) {
			InternalEObject oldCircularBufferDeclaration = (InternalEObject)circularBufferDeclaration;
			circularBufferDeclaration = (CircularBufferDeclaration)eResolveProxy(oldCircularBufferDeclaration);
			if (circularBufferDeclaration != oldCircularBufferDeclaration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ImperativeModelPackage.STATEFUL_VARIABLE_DECLARATION__CIRCULAR_BUFFER_DECLARATION, oldCircularBufferDeclaration, circularBufferDeclaration));
			}
		}
		return circularBufferDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CircularBufferDeclaration basicGetCircularBufferDeclaration() {
		return circularBufferDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCircularBufferDeclaration(CircularBufferDeclaration newCircularBufferDeclaration) {
		CircularBufferDeclaration oldCircularBufferDeclaration = circularBufferDeclaration;
		circularBufferDeclaration = newCircularBufferDeclaration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeModelPackage.STATEFUL_VARIABLE_DECLARATION__CIRCULAR_BUFFER_DECLARATION, oldCircularBufferDeclaration, circularBufferDeclaration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImperativeModelPackage.STATEFUL_VARIABLE_DECLARATION__CIRCULAR_BUFFER_DECLARATION:
				if (resolve) return getCircularBufferDeclaration();
				return basicGetCircularBufferDeclaration();
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
			case ImperativeModelPackage.STATEFUL_VARIABLE_DECLARATION__CIRCULAR_BUFFER_DECLARATION:
				setCircularBufferDeclaration((CircularBufferDeclaration)newValue);
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
			case ImperativeModelPackage.STATEFUL_VARIABLE_DECLARATION__CIRCULAR_BUFFER_DECLARATION:
				setCircularBufferDeclaration((CircularBufferDeclaration)null);
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
			case ImperativeModelPackage.STATEFUL_VARIABLE_DECLARATION__CIRCULAR_BUFFER_DECLARATION:
				return circularBufferDeclaration != null;
		}
		return super.eIsSet(featureID);
	}

} //StatefulVariableDeclarationImpl
