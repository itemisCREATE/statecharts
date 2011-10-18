/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.ast.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.StructDefinition;
import org.eclipselabs.mscript.language.ast.StructMemberDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Struct Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.StructDefinitionImpl#getMemberDeclarations <em>Member Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StructDefinitionImpl extends DataTypeDefinitionImpl implements StructDefinition {
	/**
	 * The cached value of the '{@link #getMemberDeclarations() <em>Member Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemberDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<StructMemberDeclaration> memberDeclarations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StructDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstPackage.Literals.STRUCT_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StructMemberDeclaration> getMemberDeclarations() {
		if (memberDeclarations == null) {
			memberDeclarations = new EObjectContainmentEList<StructMemberDeclaration>(StructMemberDeclaration.class, this, AstPackage.STRUCT_DEFINITION__MEMBER_DECLARATIONS);
		}
		return memberDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstPackage.STRUCT_DEFINITION__MEMBER_DECLARATIONS:
				return ((InternalEList<?>)getMemberDeclarations()).basicRemove(otherEnd, msgs);
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
			case AstPackage.STRUCT_DEFINITION__MEMBER_DECLARATIONS:
				return getMemberDeclarations();
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
			case AstPackage.STRUCT_DEFINITION__MEMBER_DECLARATIONS:
				getMemberDeclarations().clear();
				getMemberDeclarations().addAll((Collection<? extends StructMemberDeclaration>)newValue);
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
			case AstPackage.STRUCT_DEFINITION__MEMBER_DECLARATIONS:
				getMemberDeclarations().clear();
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
			case AstPackage.STRUCT_DEFINITION__MEMBER_DECLARATIONS:
				return memberDeclarations != null && !memberDeclarations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StructDefinitionImpl
