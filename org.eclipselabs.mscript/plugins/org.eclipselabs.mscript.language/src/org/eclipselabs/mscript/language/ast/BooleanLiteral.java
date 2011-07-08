/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.ast;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.BooleanLiteral#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getBooleanLiteral()
 * @model
 * @generated
 */
public interface BooleanLiteral extends Literal {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipselabs.mscript.language.ast.BooleanKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see org.eclipselabs.mscript.language.ast.BooleanKind
	 * @see #setValue(BooleanKind)
	 * @see org.eclipselabs.mscript.language.ast.AstPackage#getBooleanLiteral_Value()
	 * @model
	 * @generated
	 */
	BooleanKind getValue();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.BooleanLiteral#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see org.eclipselabs.mscript.language.ast.BooleanKind
	 * @see #getValue()
	 * @generated
	 */
	void setValue(BooleanKind value);

} // BooleanLiteral
