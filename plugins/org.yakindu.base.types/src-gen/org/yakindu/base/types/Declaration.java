/**
 */
package org.yakindu.base.types;

import org.eclipse.emf.common.util.EList;
import org.yakindu.base.base.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.types.Declaration#getAnnotations <em>Annotations</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.types.TypesPackage#getDeclaration()
 * @model abstract="true"
 * @generated
 */
public interface Declaration extends TypedElement, NamedElement, PackageMember {

	/**
	 * Returns the value of the '<em><b>Annotations</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.base.types.Annotation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotations</em>' containment reference list.
	 * @see org.yakindu.base.types.TypesPackage#getDeclaration_Annotations()
	 * @model containment="true"
	 * @generated
	 */
	EList<Annotation> getAnnotations();
} // Declaration
