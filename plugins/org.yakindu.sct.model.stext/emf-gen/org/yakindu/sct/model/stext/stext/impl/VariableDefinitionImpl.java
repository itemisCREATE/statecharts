/**
 */
package org.yakindu.sct.model.stext.stext.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.yakindu.base.types.Annotation;
import org.yakindu.base.types.impl.PropertyImpl;
import org.yakindu.sct.model.stext.stext.StextPackage;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class VariableDefinitionImpl extends PropertyImpl implements VariableDefinition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StextPackage.Literals.VARIABLE_DEFINITION;
	}
	
	@Override
	public EList<Annotation> getAnnotations() {
		EList<Annotation> result = new BasicEList<Annotation>();
		result.addAll(super.getAnnotations());
		if(getAnnotationInfo() != null) {
			result.addAll(getAnnotationInfo().getAnnotations());
		}
		return ECollections.unmodifiableEList(result);
	}

} //VariableDefinitionImpl
