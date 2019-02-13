/**
 */
package org.yakindu.sct.model.stext.stext.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.yakindu.base.types.AnnotatableElement;
import org.yakindu.base.types.Annotation;
import org.yakindu.base.types.TypesPackage;

import org.yakindu.sct.model.sgraph.impl.ScopedElementImpl;

import org.yakindu.sct.model.stext.stext.StatechartSpecification;
import org.yakindu.sct.model.stext.stext.StextPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Statechart Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.StatechartSpecificationImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.StatechartSpecificationImpl#getAnnotationInfo <em>Annotation Info</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StatechartSpecificationImpl extends ScopedElementImpl implements StatechartSpecification {
	/**
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<Annotation> annotations;

	/**
	 * The cached value of the '{@link #getAnnotationInfo() <em>Annotation Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotationInfo()
	 * @generated
	 * @ordered
	 */
	protected AnnotatableElement annotationInfo;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StatechartSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StextPackage.Literals.STATECHART_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Annotation> getAnnotations() {
		if (annotations == null) {
			annotations = new EObjectContainmentEList<Annotation>(Annotation.class, this, StextPackage.STATECHART_SPECIFICATION__ANNOTATIONS);
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AnnotatableElement getAnnotationInfo() {
		return annotationInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnnotationInfo(AnnotatableElement newAnnotationInfo, NotificationChain msgs) {
		AnnotatableElement oldAnnotationInfo = annotationInfo;
		annotationInfo = newAnnotationInfo;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StextPackage.STATECHART_SPECIFICATION__ANNOTATION_INFO, oldAnnotationInfo, newAnnotationInfo);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAnnotationInfo(AnnotatableElement newAnnotationInfo) {
		if (newAnnotationInfo != annotationInfo) {
			NotificationChain msgs = null;
			if (annotationInfo != null)
				msgs = ((InternalEObject)annotationInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StextPackage.STATECHART_SPECIFICATION__ANNOTATION_INFO, null, msgs);
			if (newAnnotationInfo != null)
				msgs = ((InternalEObject)newAnnotationInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StextPackage.STATECHART_SPECIFICATION__ANNOTATION_INFO, null, msgs);
			msgs = basicSetAnnotationInfo(newAnnotationInfo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StextPackage.STATECHART_SPECIFICATION__ANNOTATION_INFO, newAnnotationInfo, newAnnotationInfo));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public Annotation getAnnotationOfType(String typeName) {
		EList<Annotation> annotations = getAnnotations();
		for (Annotation annotation : annotations) {
			if (typeName.equals(annotation.getType().getName())) {
				return annotation;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StextPackage.STATECHART_SPECIFICATION__ANNOTATIONS:
				return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
			case StextPackage.STATECHART_SPECIFICATION__ANNOTATION_INFO:
				return basicSetAnnotationInfo(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StextPackage.STATECHART_SPECIFICATION__ANNOTATIONS:
				return getAnnotations();
			case StextPackage.STATECHART_SPECIFICATION__ANNOTATION_INFO:
				return getAnnotationInfo();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StextPackage.STATECHART_SPECIFICATION__ANNOTATIONS:
				getAnnotations().clear();
				getAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case StextPackage.STATECHART_SPECIFICATION__ANNOTATION_INFO:
				setAnnotationInfo((AnnotatableElement)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case StextPackage.STATECHART_SPECIFICATION__ANNOTATIONS:
				getAnnotations().clear();
				return;
			case StextPackage.STATECHART_SPECIFICATION__ANNOTATION_INFO:
				setAnnotationInfo((AnnotatableElement)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StextPackage.STATECHART_SPECIFICATION__ANNOTATIONS:
				return annotations != null && !annotations.isEmpty();
			case StextPackage.STATECHART_SPECIFICATION__ANNOTATION_INFO:
				return annotationInfo != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == AnnotatableElement.class) {
			switch (derivedFeatureID) {
				case StextPackage.STATECHART_SPECIFICATION__ANNOTATIONS: return TypesPackage.ANNOTATABLE_ELEMENT__ANNOTATIONS;
				case StextPackage.STATECHART_SPECIFICATION__ANNOTATION_INFO: return TypesPackage.ANNOTATABLE_ELEMENT__ANNOTATION_INFO;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == AnnotatableElement.class) {
			switch (baseFeatureID) {
				case TypesPackage.ANNOTATABLE_ELEMENT__ANNOTATIONS: return StextPackage.STATECHART_SPECIFICATION__ANNOTATIONS;
				case TypesPackage.ANNOTATABLE_ELEMENT__ANNOTATION_INFO: return StextPackage.STATECHART_SPECIFICATION__ANNOTATION_INFO;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //StatechartSpecificationImpl
