/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.sruntime;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Slot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sruntime.CompositeSlot#getSlots <em>Slots</em>}</li>
 * </ul>
 *
 * @see org.yakindu.sct.model.sruntime.SRuntimePackage#getCompositeSlot()
 * @model
 * @generated
 */
public interface CompositeSlot extends ExecutionSlot {
	/**
	 * Returns the value of the '<em><b>Slots</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.sct.model.sruntime.ExecutionSlot}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Slots</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Slots</em>' containment reference list.
	 * @see org.yakindu.sct.model.sruntime.SRuntimePackage#getCompositeSlot_Slots()
	 * @model containment="true"
	 * @generated
	 */
	List<ExecutionSlot> getSlots();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" doResolveUnique="false"
	 * @generated
	 */
	List<ExecutionSlot> getSlots(boolean doResolve);

} // CompositeSlot
