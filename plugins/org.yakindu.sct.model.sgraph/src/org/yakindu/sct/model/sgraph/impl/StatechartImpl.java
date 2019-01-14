/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
 */
package org.yakindu.sct.model.sgraph.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.yakindu.base.base.BasePackage;
import org.yakindu.base.base.DocumentedElement;
import org.yakindu.base.base.DomainElement;
import org.yakindu.base.base.NamedElement;
import org.yakindu.base.types.AnnotatableElement;
import org.yakindu.base.types.Annotation;
import org.yakindu.base.types.TypesPackage;
import org.yakindu.sct.model.sgraph.CompositeElement;
import org.yakindu.sct.model.sgraph.Reaction;
import org.yakindu.sct.model.sgraph.ReactiveElement;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.ScopedElement;
import org.yakindu.sct.model.sgraph.Statechart;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Statechart</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sgraph.impl.StatechartImpl#getLocalReactions <em>Local Reactions</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.impl.StatechartImpl#getScopes <em>Scopes</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.impl.StatechartImpl#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.impl.StatechartImpl#getRegions <em>Regions</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.impl.StatechartImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.impl.StatechartImpl#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.impl.StatechartImpl#getDomainID <em>Domain ID</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.impl.StatechartImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.impl.StatechartImpl#getAnnotationInfo <em>Annotation Info</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StatechartImpl extends SpecificationElementImpl implements
Statechart {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2011 committers of YAKINDU and others.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\nContributors:\r\ncommitters of YAKINDU - initial API and implementation\r\n";
	
	/**
	 * The cached value of the '{@link #getScopes() <em>Scopes</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getScopes()
	 * @generated
	 * @ordered
	 */
	protected EList<Scope> scopes;
	
	/**
	 * The default value of the '{@link #getNamespace() <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getNamespace()
	 * @generated
	 * @ordered
	 */
	protected static final String NAMESPACE_EDEFAULT = null;
	
	/**
	 * The cached value of the '{@link #getNamespace() <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getNamespace()
	 * @generated
	 * @ordered
	 */
	protected String namespace = NAMESPACE_EDEFAULT;
	
	/**
	 * The cached value of the '{@link #getRegions() <em>Regions</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRegions()
	 * @generated
	 * @ordered
	 */
	protected EList<Region> regions;
	
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;
	
	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;
	
	/**
	 * The default value of the '{@link #getDocumentation() <em>Documentation</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getDocumentation()
	 * @generated
	 * @ordered
	 */
	protected static final String DOCUMENTATION_EDEFAULT = "";
	
	/**
	 * The cached value of the '{@link #getDocumentation() <em>Documentation</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getDocumentation()
	 * @generated
	 * @ordered
	 */
	protected String documentation = DOCUMENTATION_EDEFAULT;
	
	/**
	 * The default value of the '{@link #getDomainID() <em>Domain ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainID()
	 * @generated
	 * @ordered
	 */
	protected static final String DOMAIN_ID_EDEFAULT = "org.yakindu.domain.default";
	
	/**
	 * The cached value of the '{@link #getDomainID() <em>Domain ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainID()
	 * @generated
	 * @ordered
	 */
	protected String domainID = DOMAIN_ID_EDEFAULT;
	
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected StatechartImpl() {
		super();
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SGraphPackage.Literals.STATECHART;
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public EList<Reaction> getReactions() {
		EList<Reaction> result = new BasicInternalEList<Reaction>(
				Reaction.class);
		result.addAll(getLocalReactions());
		return result;
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public EList<Reaction> getLocalReactions() {
		EList<Reaction> result = new BasicEList<Reaction>();
		EList<Scope> scopes = getScopes();
		for (Scope scope : scopes) {
			result.addAll(scope.getReactions());
		}
		return new EcoreEList.UnmodifiableEList<Reaction>(this,
				SGraphPackage.Literals.REACTIVE_ELEMENT__LOCAL_REACTIONS, result.size(), result.toArray());
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Scope> getScopes() {
		if (scopes == null) {
			scopes = new EObjectContainmentEList.Resolving<Scope>(Scope.class, this, SGraphPackage.STATECHART__SCOPES);
		}
		return scopes;
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getNamespace() {
		return namespace;
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNamespace(String newNamespace) {
		String oldNamespace = namespace;
		namespace = newNamespace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SGraphPackage.STATECHART__NAMESPACE, oldNamespace, namespace));
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Region> getRegions() {
		if (regions == null) {
			regions = new EObjectContainmentWithInverseEList.Resolving<Region>(Region.class, this, SGraphPackage.STATECHART__REGIONS, SGraphPackage.REGION__COMPOSITE);
		}
		return regions;
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SGraphPackage.STATECHART__NAME, oldName, name));
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDocumentation() {
		return documentation;
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDocumentation(String newDocumentation) {
		String oldDocumentation = documentation;
		documentation = newDocumentation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SGraphPackage.STATECHART__DOCUMENTATION, oldDocumentation, documentation));
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDomainID() {
		return domainID;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDomainID(String newDomainID) {
		String oldDomainID = domainID;
		domainID = newDomainID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SGraphPackage.STATECHART__DOMAIN_ID, oldDomainID, domainID));
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Annotation> getAnnotations() {
		if (annotations == null) {
			annotations = new EObjectContainmentEList<Annotation>(Annotation.class, this, SGraphPackage.STATECHART__ANNOTATIONS);
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SGraphPackage.STATECHART__ANNOTATION_INFO, oldAnnotationInfo, newAnnotationInfo);
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
				msgs = ((InternalEObject)annotationInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SGraphPackage.STATECHART__ANNOTATION_INFO, null, msgs);
			if (newAnnotationInfo != null)
				msgs = ((InternalEObject)newAnnotationInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SGraphPackage.STATECHART__ANNOTATION_INFO, null, msgs);
			msgs = basicSetAnnotationInfo(newAnnotationInfo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SGraphPackage.STATECHART__ANNOTATION_INFO, newAnnotationInfo, newAnnotationInfo));
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public Annotation getAnnotationOfType(final String typeName) {
		EList<Annotation> annotations = getAnnotations();
		for (Annotation annotation : annotations) {
			if (typeName.equals(annotation.getType().getName())) {
				return annotation;
			}
		}
		return null;
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SGraphPackage.STATECHART__REGIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRegions()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SGraphPackage.STATECHART__SCOPES:
				return ((InternalEList<?>)getScopes()).basicRemove(otherEnd, msgs);
			case SGraphPackage.STATECHART__REGIONS:
				return ((InternalEList<?>)getRegions()).basicRemove(otherEnd, msgs);
			case SGraphPackage.STATECHART__ANNOTATIONS:
				return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
			case SGraphPackage.STATECHART__ANNOTATION_INFO:
				return basicSetAnnotationInfo(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SGraphPackage.STATECHART__LOCAL_REACTIONS:
				return getLocalReactions();
			case SGraphPackage.STATECHART__SCOPES:
				return getScopes();
			case SGraphPackage.STATECHART__NAMESPACE:
				return getNamespace();
			case SGraphPackage.STATECHART__REGIONS:
				return getRegions();
			case SGraphPackage.STATECHART__NAME:
				return getName();
			case SGraphPackage.STATECHART__DOCUMENTATION:
				return getDocumentation();
			case SGraphPackage.STATECHART__DOMAIN_ID:
				return getDomainID();
			case SGraphPackage.STATECHART__ANNOTATIONS:
				return getAnnotations();
			case SGraphPackage.STATECHART__ANNOTATION_INFO:
				return getAnnotationInfo();
		}
		return super.eGet(featureID, resolve, coreType);
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SGraphPackage.STATECHART__SCOPES:
				getScopes().clear();
				getScopes().addAll((Collection<? extends Scope>)newValue);
				return;
			case SGraphPackage.STATECHART__NAMESPACE:
				setNamespace((String)newValue);
				return;
			case SGraphPackage.STATECHART__REGIONS:
				getRegions().clear();
				getRegions().addAll((Collection<? extends Region>)newValue);
				return;
			case SGraphPackage.STATECHART__NAME:
				setName((String)newValue);
				return;
			case SGraphPackage.STATECHART__DOCUMENTATION:
				setDocumentation((String)newValue);
				return;
			case SGraphPackage.STATECHART__DOMAIN_ID:
				setDomainID((String)newValue);
				return;
			case SGraphPackage.STATECHART__ANNOTATIONS:
				getAnnotations().clear();
				getAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case SGraphPackage.STATECHART__ANNOTATION_INFO:
				setAnnotationInfo((AnnotatableElement)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SGraphPackage.STATECHART__SCOPES:
				getScopes().clear();
				return;
			case SGraphPackage.STATECHART__NAMESPACE:
				setNamespace(NAMESPACE_EDEFAULT);
				return;
			case SGraphPackage.STATECHART__REGIONS:
				getRegions().clear();
				return;
			case SGraphPackage.STATECHART__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SGraphPackage.STATECHART__DOCUMENTATION:
				setDocumentation(DOCUMENTATION_EDEFAULT);
				return;
			case SGraphPackage.STATECHART__DOMAIN_ID:
				setDomainID(DOMAIN_ID_EDEFAULT);
				return;
			case SGraphPackage.STATECHART__ANNOTATIONS:
				getAnnotations().clear();
				return;
			case SGraphPackage.STATECHART__ANNOTATION_INFO:
				setAnnotationInfo((AnnotatableElement)null);
				return;
		}
		super.eUnset(featureID);
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SGraphPackage.STATECHART__LOCAL_REACTIONS:
				return !getLocalReactions().isEmpty();
			case SGraphPackage.STATECHART__SCOPES:
				return scopes != null && !scopes.isEmpty();
			case SGraphPackage.STATECHART__NAMESPACE:
				return NAMESPACE_EDEFAULT == null ? namespace != null : !NAMESPACE_EDEFAULT.equals(namespace);
			case SGraphPackage.STATECHART__REGIONS:
				return regions != null && !regions.isEmpty();
			case SGraphPackage.STATECHART__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SGraphPackage.STATECHART__DOCUMENTATION:
				return DOCUMENTATION_EDEFAULT == null ? documentation != null : !DOCUMENTATION_EDEFAULT.equals(documentation);
			case SGraphPackage.STATECHART__DOMAIN_ID:
				return DOMAIN_ID_EDEFAULT == null ? domainID != null : !DOMAIN_ID_EDEFAULT.equals(domainID);
			case SGraphPackage.STATECHART__ANNOTATIONS:
				return annotations != null && !annotations.isEmpty();
			case SGraphPackage.STATECHART__ANNOTATION_INFO:
				return annotationInfo != null;
		}
		return super.eIsSet(featureID);
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ReactiveElement.class) {
			switch (derivedFeatureID) {
				case SGraphPackage.STATECHART__LOCAL_REACTIONS: return SGraphPackage.REACTIVE_ELEMENT__LOCAL_REACTIONS;
				default: return -1;
			}
		}
		if (baseClass == ScopedElement.class) {
			switch (derivedFeatureID) {
				case SGraphPackage.STATECHART__SCOPES: return SGraphPackage.SCOPED_ELEMENT__SCOPES;
				case SGraphPackage.STATECHART__NAMESPACE: return SGraphPackage.SCOPED_ELEMENT__NAMESPACE;
				default: return -1;
			}
		}
		if (baseClass == CompositeElement.class) {
			switch (derivedFeatureID) {
				case SGraphPackage.STATECHART__REGIONS: return SGraphPackage.COMPOSITE_ELEMENT__REGIONS;
				default: return -1;
			}
		}
		if (baseClass == NamedElement.class) {
			switch (derivedFeatureID) {
				case SGraphPackage.STATECHART__NAME: return BasePackage.NAMED_ELEMENT__NAME;
				default: return -1;
			}
		}
		if (baseClass == DocumentedElement.class) {
			switch (derivedFeatureID) {
				case SGraphPackage.STATECHART__DOCUMENTATION: return BasePackage.DOCUMENTED_ELEMENT__DOCUMENTATION;
				default: return -1;
			}
		}
		if (baseClass == DomainElement.class) {
			switch (derivedFeatureID) {
				case SGraphPackage.STATECHART__DOMAIN_ID: return BasePackage.DOMAIN_ELEMENT__DOMAIN_ID;
				default: return -1;
			}
		}
		if (baseClass == AnnotatableElement.class) {
			switch (derivedFeatureID) {
				case SGraphPackage.STATECHART__ANNOTATIONS: return TypesPackage.ANNOTATABLE_ELEMENT__ANNOTATIONS;
				case SGraphPackage.STATECHART__ANNOTATION_INFO: return TypesPackage.ANNOTATABLE_ELEMENT__ANNOTATION_INFO;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ReactiveElement.class) {
			switch (baseFeatureID) {
				case SGraphPackage.REACTIVE_ELEMENT__LOCAL_REACTIONS: return SGraphPackage.STATECHART__LOCAL_REACTIONS;
				default: return -1;
			}
		}
		if (baseClass == ScopedElement.class) {
			switch (baseFeatureID) {
				case SGraphPackage.SCOPED_ELEMENT__SCOPES: return SGraphPackage.STATECHART__SCOPES;
				case SGraphPackage.SCOPED_ELEMENT__NAMESPACE: return SGraphPackage.STATECHART__NAMESPACE;
				default: return -1;
			}
		}
		if (baseClass == CompositeElement.class) {
			switch (baseFeatureID) {
				case SGraphPackage.COMPOSITE_ELEMENT__REGIONS: return SGraphPackage.STATECHART__REGIONS;
				default: return -1;
			}
		}
		if (baseClass == NamedElement.class) {
			switch (baseFeatureID) {
				case BasePackage.NAMED_ELEMENT__NAME: return SGraphPackage.STATECHART__NAME;
				default: return -1;
			}
		}
		if (baseClass == DocumentedElement.class) {
			switch (baseFeatureID) {
				case BasePackage.DOCUMENTED_ELEMENT__DOCUMENTATION: return SGraphPackage.STATECHART__DOCUMENTATION;
				default: return -1;
			}
		}
		if (baseClass == DomainElement.class) {
			switch (baseFeatureID) {
				case BasePackage.DOMAIN_ELEMENT__DOMAIN_ID: return SGraphPackage.STATECHART__DOMAIN_ID;
				default: return -1;
			}
		}
		if (baseClass == AnnotatableElement.class) {
			switch (baseFeatureID) {
				case TypesPackage.ANNOTATABLE_ELEMENT__ANNOTATIONS: return SGraphPackage.STATECHART__ANNOTATIONS;
				case TypesPackage.ANNOTATABLE_ELEMENT__ANNOTATION_INFO: return SGraphPackage.STATECHART__ANNOTATION_INFO;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}
	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (namespace: ");
		result.append(namespace);
		result.append(", name: ");
		result.append(name);
		result.append(", documentation: ");
		result.append(documentation);
		result.append(", domainID: ");
		result.append(domainID);
		result.append(')');
		return result.toString();
	}
	
} // StatechartImpl
