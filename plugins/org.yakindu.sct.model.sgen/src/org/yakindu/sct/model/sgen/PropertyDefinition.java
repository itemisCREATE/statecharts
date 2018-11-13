/**
 */
package org.yakindu.sct.model.sgen;

import org.yakindu.base.types.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sgen.PropertyDefinition#getInitialValue <em>Initial Value</em>}</li>
 * </ul>
 *
 * @see org.yakindu.sct.model.sgen.SGenPackage#getPropertyDefinition()
 * @model
 * @generated
 */
public interface PropertyDefinition extends Property {
	/**
	 * Returns the value of the '<em><b>Initial Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Value</em>' containment reference.
	 * @see #setInitialValue(org.yakindu.base.types.Expression)
	 * @see org.yakindu.sct.model.sgen.SGenPackage#getPropertyDefinition_InitialValue()
	 * @model containment="true"
	 * @generated
	 */
	org.yakindu.base.types.Expression getInitialValue();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sgen.PropertyDefinition#getInitialValue <em>Initial Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Value</em>' containment reference.
	 * @see #getInitialValue()
	 * @generated
	 */
	void setInitialValue(org.yakindu.base.types.Expression value);

} // PropertyDefinition
