/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.typesystem.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.mscript.typesystem.NamedElement;
import org.eclipselabs.mscript.typesystem.TypeSystem;
import org.eclipselabs.mscript.typesystem.TypeSystemPackage;
import org.eclipselabs.mscript.typesystem.internal.operations.TypeSystemOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.typesystem.impl.TypeSystemImpl#getTopLevelElements <em>Top Level Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeSystemImpl extends EObjectImpl implements TypeSystem {
	/**
	 * The cached value of the '{@link #getTopLevelElements() <em>Top Level Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTopLevelElements()
	 * @generated
	 * @ordered
	 */
	protected EList<NamedElement> topLevelElements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypeSystemPackage.Literals.TYPE_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NamedElement> getTopLevelElements() {
		if (topLevelElements == null) {
			topLevelElements = new EObjectContainmentEList<NamedElement>(NamedElement.class, this, TypeSystemPackage.TYPE_SYSTEM__TOP_LEVEL_ELEMENTS);
		}
		return topLevelElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public NamedElement getElement(String qualifiedName) {
		return TypeSystemOperations.getElement(this, qualifiedName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TypeSystemPackage.TYPE_SYSTEM__TOP_LEVEL_ELEMENTS:
				return ((InternalEList<?>)getTopLevelElements()).basicRemove(otherEnd, msgs);
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
			case TypeSystemPackage.TYPE_SYSTEM__TOP_LEVEL_ELEMENTS:
				return getTopLevelElements();
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
			case TypeSystemPackage.TYPE_SYSTEM__TOP_LEVEL_ELEMENTS:
				getTopLevelElements().clear();
				getTopLevelElements().addAll((Collection<? extends NamedElement>)newValue);
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
			case TypeSystemPackage.TYPE_SYSTEM__TOP_LEVEL_ELEMENTS:
				getTopLevelElements().clear();
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
			case TypeSystemPackage.TYPE_SYSTEM__TOP_LEVEL_ELEMENTS:
				return topLevelElements != null && !topLevelElements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TypeSystemImpl
