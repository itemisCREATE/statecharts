/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.imperativemodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stateful Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.StatefulVariableDeclaration#getCircularBufferDeclaration <em>Circular Buffer Declaration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getStatefulVariableDeclaration()
 * @model abstract="true"
 * @generated
 */
public interface StatefulVariableDeclaration extends VariableDeclaration {
	/**
	 * Returns the value of the '<em><b>Circular Buffer Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Circular Buffer Declaration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Circular Buffer Declaration</em>' reference.
	 * @see #setCircularBufferDeclaration(CircularBufferDeclaration)
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getStatefulVariableDeclaration_CircularBufferDeclaration()
	 * @model
	 * @generated
	 */
	CircularBufferDeclaration getCircularBufferDeclaration();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.imperativemodel.StatefulVariableDeclaration#getCircularBufferDeclaration <em>Circular Buffer Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Circular Buffer Declaration</em>' reference.
	 * @see #getCircularBufferDeclaration()
	 * @generated
	 */
	void setCircularBufferDeclaration(CircularBufferDeclaration value);

} // StatefulVariableDeclaration
