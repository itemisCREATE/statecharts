/**
 */
package org.yakindu.sct.model.stext.stext;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statechart Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.StatechartRoot#getDef <em>Def</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.stext.stext.StextPackage#getStatechartRoot()
 * @model
 * @generated
 */
public interface StatechartRoot extends DefRoot {
	/**
	 * Returns the value of the '<em><b>Def</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Def</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Def</em>' containment reference.
	 * @see #setDef(StatechartSpecification)
	 * @see org.yakindu.sct.model.stext.stext.StextPackage#getStatechartRoot_Def()
	 * @model containment="true"
	 * @generated
	 */
	StatechartSpecification getDef();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.StatechartRoot#getDef <em>Def</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Def</em>' containment reference.
	 * @see #getDef()
	 * @generated
	 */
	void setDef(StatechartSpecification value);

} // StatechartRoot
