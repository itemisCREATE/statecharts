/**
 */
package org.yakindu.sct.model.stext.stext.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.yakindu.base.types.Annotation;
import org.yakindu.base.types.impl.OperationImpl;
import org.yakindu.sct.model.stext.stext.OperationDefinition;
import org.yakindu.sct.model.stext.stext.StextPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class OperationDefinitionImpl extends OperationImpl implements OperationDefinition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StextPackage.Literals.OPERATION_DEFINITION;
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

} //OperationDefinitionImpl
