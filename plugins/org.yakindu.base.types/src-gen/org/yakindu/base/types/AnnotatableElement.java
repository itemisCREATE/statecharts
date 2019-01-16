/**
 */
package org.yakindu.base.types;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotatable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.types.AnnotatableElement#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.yakindu.base.types.AnnotatableElement#getAnnotationInfo <em>Annotation Info</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.types.TypesPackage#getAnnotatableElement()
 * @model
 * @generated
 */
public interface AnnotatableElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Annotations</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.base.types.Annotation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotations</em>' containment reference list.
	 * @see org.yakindu.base.types.TypesPackage#getAnnotatableElement_Annotations()
	 * @model containment="true" transient="true"
	 * @generated
	 */
	EList<Annotation> getAnnotations();

	/**
	 * Returns the value of the '<em><b>Annotation Info</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotation Info</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotation Info</em>' containment reference.
	 * @see #setAnnotationInfo(AnnotatableElement)
	 * @see org.yakindu.base.types.TypesPackage#getAnnotatableElement_AnnotationInfo()
	 * @model containment="true"
	 * @generated
	 */
	AnnotatableElement getAnnotationInfo();

	/**
	 * Sets the value of the '{@link org.yakindu.base.types.AnnotatableElement#getAnnotationInfo <em>Annotation Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Annotation Info</em>' containment reference.
	 * @see #getAnnotationInfo()
	 * @generated
	 */
	void setAnnotationInfo(AnnotatableElement value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Annotation getAnnotationOfType(String typeName);

} // AnnotatableElement
