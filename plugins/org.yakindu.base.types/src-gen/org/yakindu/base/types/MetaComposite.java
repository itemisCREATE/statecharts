/**
 */
package org.yakindu.base.types;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Meta Composite</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.types.MetaComposite#getMetaFeatures <em>Meta Features</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.types.TypesPackage#getMetaComposite()
 * @model
 * @generated
 */
public interface MetaComposite extends EObject {
	/**
	 * Returns the value of the '<em><b>Meta Features</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.base.types.Declaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Features</em>' containment reference list.
	 * @see org.yakindu.base.types.TypesPackage#getMetaComposite_MetaFeatures()
	 * @model containment="true"
	 * @generated
	 */
	EList<Declaration> getMetaFeatures();

} // MetaComposite
