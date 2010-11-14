/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.imperativemodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage;
import org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration;
import org.eclipselabs.mscript.typesystem.DataType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.impl.VariableDeclarationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.impl.VariableDeclarationImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.impl.VariableDeclarationImpl#getInitializer <em>Initializer</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.impl.VariableDeclarationImpl#getRingBufferSize <em>Ring Buffer Size</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableDeclarationImpl extends StatementImpl implements VariableDeclaration {
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
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected DataType type;

	/**
	 * The cached value of the '{@link #getInitializer() <em>Initializer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitializer()
	 * @generated
	 * @ordered
	 */
	protected Expression initializer;

	/**
	 * The default value of the '{@link #getRingBufferSize() <em>Ring Buffer Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRingBufferSize()
	 * @generated
	 * @ordered
	 */
	protected static final int RING_BUFFER_SIZE_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getRingBufferSize() <em>Ring Buffer Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRingBufferSize()
	 * @generated
	 * @ordered
	 */
	protected int ringBufferSize = RING_BUFFER_SIZE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImperativeModelPackage.Literals.VARIABLE_DECLARATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeModelPackage.VARIABLE_DECLARATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (DataType)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ImperativeModelPackage.VARIABLE_DECLARATION__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(DataType newType) {
		DataType oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeModelPackage.VARIABLE_DECLARATION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getInitializer() {
		return initializer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitializer(Expression newInitializer, NotificationChain msgs) {
		Expression oldInitializer = initializer;
		initializer = newInitializer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImperativeModelPackage.VARIABLE_DECLARATION__INITIALIZER, oldInitializer, newInitializer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitializer(Expression newInitializer) {
		if (newInitializer != initializer) {
			NotificationChain msgs = null;
			if (initializer != null)
				msgs = ((InternalEObject)initializer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImperativeModelPackage.VARIABLE_DECLARATION__INITIALIZER, null, msgs);
			if (newInitializer != null)
				msgs = ((InternalEObject)newInitializer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImperativeModelPackage.VARIABLE_DECLARATION__INITIALIZER, null, msgs);
			msgs = basicSetInitializer(newInitializer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeModelPackage.VARIABLE_DECLARATION__INITIALIZER, newInitializer, newInitializer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRingBufferSize() {
		return ringBufferSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRingBufferSize(int newRingBufferSize) {
		int oldRingBufferSize = ringBufferSize;
		ringBufferSize = newRingBufferSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeModelPackage.VARIABLE_DECLARATION__RING_BUFFER_SIZE, oldRingBufferSize, ringBufferSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ImperativeModelPackage.VARIABLE_DECLARATION__INITIALIZER:
				return basicSetInitializer(null, msgs);
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
			case ImperativeModelPackage.VARIABLE_DECLARATION__NAME:
				return getName();
			case ImperativeModelPackage.VARIABLE_DECLARATION__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case ImperativeModelPackage.VARIABLE_DECLARATION__INITIALIZER:
				return getInitializer();
			case ImperativeModelPackage.VARIABLE_DECLARATION__RING_BUFFER_SIZE:
				return getRingBufferSize();
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
			case ImperativeModelPackage.VARIABLE_DECLARATION__NAME:
				setName((String)newValue);
				return;
			case ImperativeModelPackage.VARIABLE_DECLARATION__TYPE:
				setType((DataType)newValue);
				return;
			case ImperativeModelPackage.VARIABLE_DECLARATION__INITIALIZER:
				setInitializer((Expression)newValue);
				return;
			case ImperativeModelPackage.VARIABLE_DECLARATION__RING_BUFFER_SIZE:
				setRingBufferSize((Integer)newValue);
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
			case ImperativeModelPackage.VARIABLE_DECLARATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ImperativeModelPackage.VARIABLE_DECLARATION__TYPE:
				setType((DataType)null);
				return;
			case ImperativeModelPackage.VARIABLE_DECLARATION__INITIALIZER:
				setInitializer((Expression)null);
				return;
			case ImperativeModelPackage.VARIABLE_DECLARATION__RING_BUFFER_SIZE:
				setRingBufferSize(RING_BUFFER_SIZE_EDEFAULT);
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
			case ImperativeModelPackage.VARIABLE_DECLARATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ImperativeModelPackage.VARIABLE_DECLARATION__TYPE:
				return type != null;
			case ImperativeModelPackage.VARIABLE_DECLARATION__INITIALIZER:
				return initializer != null;
			case ImperativeModelPackage.VARIABLE_DECLARATION__RING_BUFFER_SIZE:
				return ringBufferSize != RING_BUFFER_SIZE_EDEFAULT;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", ringBufferSize: ");
		result.append(ringBufferSize);
		result.append(')');
		return result.toString();
	}

} //VariableDeclarationImpl
