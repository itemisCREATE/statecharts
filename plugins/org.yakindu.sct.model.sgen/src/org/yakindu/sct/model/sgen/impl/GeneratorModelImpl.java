/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sgen.impl;

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
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgen.GeneratorModel;
import org.yakindu.sct.model.sgen.SGenPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generator Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sgen.impl.GeneratorModelImpl#getEntries <em>Entries</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgen.impl.GeneratorModelImpl#getGeneratorId <em>Generator Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GeneratorModelImpl extends EObjectImpl implements GeneratorModel {
	/**
	 * The cached value of the '{@link #getEntries() <em>Entries</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntries()
	 * @generated
	 * @ordered
	 */
	protected EList<GeneratorEntry> entries;

	/**
	 * The default value of the '{@link #getGeneratorId() <em>Generator Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneratorId()
	 * @generated
	 * @ordered
	 */
	protected static final String GENERATOR_ID_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getGeneratorId() <em>Generator Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneratorId()
	 * @generated
	 * @ordered
	 */
	protected String generatorId = GENERATOR_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeneratorModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SGenPackage.Literals.GENERATOR_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GeneratorEntry> getEntries() {
		if (entries == null) {
			entries = new EObjectContainmentEList<GeneratorEntry>(GeneratorEntry.class, this, SGenPackage.GENERATOR_MODEL__ENTRIES);
		}
		return entries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGeneratorId() {
		return generatorId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGeneratorId(String newGeneratorId) {
		String oldGeneratorId = generatorId;
		generatorId = newGeneratorId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SGenPackage.GENERATOR_MODEL__GENERATOR_ID, oldGeneratorId, generatorId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SGenPackage.GENERATOR_MODEL__ENTRIES:
				return ((InternalEList<?>)getEntries()).basicRemove(otherEnd, msgs);
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
			case SGenPackage.GENERATOR_MODEL__ENTRIES:
				return getEntries();
			case SGenPackage.GENERATOR_MODEL__GENERATOR_ID:
				return getGeneratorId();
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
			case SGenPackage.GENERATOR_MODEL__ENTRIES:
				getEntries().clear();
				getEntries().addAll((Collection<? extends GeneratorEntry>)newValue);
				return;
			case SGenPackage.GENERATOR_MODEL__GENERATOR_ID:
				setGeneratorId((String)newValue);
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
			case SGenPackage.GENERATOR_MODEL__ENTRIES:
				getEntries().clear();
				return;
			case SGenPackage.GENERATOR_MODEL__GENERATOR_ID:
				setGeneratorId(GENERATOR_ID_EDEFAULT);
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
			case SGenPackage.GENERATOR_MODEL__ENTRIES:
				return entries != null && !entries.isEmpty();
			case SGenPackage.GENERATOR_MODEL__GENERATOR_ID:
				return GENERATOR_ID_EDEFAULT == null ? generatorId != null : !GENERATOR_ID_EDEFAULT.equals(generatorId);
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
		result.append(" (generatorId: ");
		result.append(generatorId);
		result.append(')');
		return result.toString();
	}

} //GeneratorModelImpl
