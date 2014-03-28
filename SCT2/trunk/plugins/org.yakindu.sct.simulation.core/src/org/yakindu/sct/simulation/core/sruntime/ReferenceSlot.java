/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.core.sruntime;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Slot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.simulation.core.sruntime.ReferenceSlot#getReference <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.simulation.core.sruntime.SRuntimePackage#getReferenceSlot()
 * @model
 * @generated
 */
public interface ReferenceSlot extends CompositeSlot {
	/**
	 * Returns the value of the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference</em>' reference.
	 * @see #setReference(CompositeSlot)
	 * @see org.yakindu.sct.simulation.core.sruntime.SRuntimePackage#getReferenceSlot_Reference()
	 * @model
	 * @generated
	 */
	CompositeSlot getReference();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.simulation.core.sruntime.ReferenceSlot#getReference <em>Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference</em>' reference.
	 * @see #getReference()
	 * @generated
	 */
	void setReference(CompositeSlot value);

} // ReferenceSlot
