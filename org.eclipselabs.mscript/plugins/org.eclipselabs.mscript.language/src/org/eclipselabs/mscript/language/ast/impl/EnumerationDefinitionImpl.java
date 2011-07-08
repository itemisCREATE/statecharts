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
import org.eclipselabs.mscript.language.ast.EnumerationDefinition;
import org.eclipselabs.mscript.language.ast.EnumerationLiteralDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enumeration Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.EnumerationDefinitionImpl#getLiteralDeclarations <em>Literal Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnumerationDefinitionImpl extends DataTypeDefinitionImpl implements EnumerationDefinition {
	/**
	 * The cached value of the '{@link #getLiteralDeclarations() <em>Literal Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLiteralDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<EnumerationLiteralDeclaration> literalDeclarations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumerationDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstPackage.Literals.ENUMERATION_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EnumerationLiteralDeclaration> getLiteralDeclarations() {
		if (literalDeclarations == null) {
			literalDeclarations = new EObjectContainmentEList<EnumerationLiteralDeclaration>(EnumerationLiteralDeclaration.class, this, AstPackage.ENUMERATION_DEFINITION__LITERAL_DECLARATIONS);
		}
		return literalDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstPackage.ENUMERATION_DEFINITION__LITERAL_DECLARATIONS:
				return ((InternalEList<?>)getLiteralDeclarations()).basicRemove(otherEnd, msgs);
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
			case AstPackage.ENUMERATION_DEFINITION__LITERAL_DECLARATIONS:
				return getLiteralDeclarations();
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
			case AstPackage.ENUMERATION_DEFINITION__LITERAL_DECLARATIONS:
				getLiteralDeclarations().clear();
				getLiteralDeclarations().addAll((Collection<? extends EnumerationLiteralDeclaration>)newValue);
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
			case AstPackage.ENUMERATION_DEFINITION__LITERAL_DECLARATIONS:
				getLiteralDeclarations().clear();
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
			case AstPackage.ENUMERATION_DEFINITION__LITERAL_DECLARATIONS:
				return literalDeclarations != null && !literalDeclarations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EnumerationDefinitionImpl
