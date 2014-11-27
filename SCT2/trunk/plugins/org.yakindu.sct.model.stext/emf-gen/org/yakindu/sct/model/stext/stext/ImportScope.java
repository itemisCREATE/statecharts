/**
 */
package org.yakindu.sct.model.stext.stext;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import Scope</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.ImportScope#getImports <em>Imports</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.stext.stext.StextPackage#getImportScope()
 * @model
 * @generated
 */
public interface ImportScope extends StatechartScope {
	/**
	 * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.sct.model.stext.stext.Import}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' containment reference list.
	 * @see org.yakindu.sct.model.stext.stext.StextPackage#getImportScope_Imports()
	 * @model containment="true"
	 * @generated
	 */
	EList<Import> getImports();

} // ImportScope
