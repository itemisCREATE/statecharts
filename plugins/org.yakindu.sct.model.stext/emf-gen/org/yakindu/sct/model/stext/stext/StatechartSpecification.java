/**
 */
package org.yakindu.sct.model.stext.stext;

import org.eclipse.emf.common.util.EList;
import org.yakindu.base.types.Annotation;
import org.yakindu.sct.model.sgraph.ScopedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statechart Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.StatechartSpecification#getAnnotations <em>Annotations</em>}</li>
 * </ul>
 *
 * @see org.yakindu.sct.model.stext.stext.StextPackage#getStatechartSpecification()
 * @model
 * @generated
 */
public interface StatechartSpecification extends ScopedElement {

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
	 * @see org.yakindu.sct.model.stext.stext.StextPackage#getStatechartSpecification_Annotations()
	 * @model containment="true"
	 * @generated
	 */
	EList<Annotation> getAnnotations();
} // StatechartSpecification
