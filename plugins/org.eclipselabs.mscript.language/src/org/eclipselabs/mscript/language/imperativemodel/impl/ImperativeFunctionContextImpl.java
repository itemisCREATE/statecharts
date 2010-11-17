/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.imperativemodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.mscript.language.ast.StateVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.CircularBufferDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.Compound;
import org.eclipselabs.mscript.language.imperativemodel.ImperativeFunctionContext;
import org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage;
import org.eclipselabs.mscript.language.imperativemodel.TemplateVariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Imperative Function Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeFunctionContextImpl#getTemplateVariableDeclarations <em>Template Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeFunctionContextImpl#getStateVariableDeclarations <em>State Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeFunctionContextImpl#getCircularBufferDeclarations <em>Circular Buffer Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeFunctionContextImpl#getInitializationCompound <em>Initialization Compound</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImperativeFunctionContextImpl extends EObjectImpl implements ImperativeFunctionContext {
	/**
	 * The cached value of the '{@link #getTemplateVariableDeclarations() <em>Template Variable Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplateVariableDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<TemplateVariableDeclaration> templateVariableDeclarations;

	/**
	 * The cached value of the '{@link #getStateVariableDeclarations() <em>State Variable Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateVariableDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<StateVariableDeclaration> stateVariableDeclarations;

	/**
	 * The cached value of the '{@link #getCircularBufferDeclarations() <em>Circular Buffer Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCircularBufferDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<CircularBufferDeclaration> circularBufferDeclarations;

	/**
	 * The cached value of the '{@link #getInitializationCompound() <em>Initialization Compound</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitializationCompound()
	 * @generated
	 * @ordered
	 */
	protected Compound initializationCompound;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImperativeFunctionContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImperativeModelPackage.Literals.IMPERATIVE_FUNCTION_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TemplateVariableDeclaration> getTemplateVariableDeclarations() {
		if (templateVariableDeclarations == null) {
			templateVariableDeclarations = new EObjectContainmentEList<TemplateVariableDeclaration>(TemplateVariableDeclaration.class, this, ImperativeModelPackage.IMPERATIVE_FUNCTION_CONTEXT__TEMPLATE_VARIABLE_DECLARATIONS);
		}
		return templateVariableDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StateVariableDeclaration> getStateVariableDeclarations() {
		if (stateVariableDeclarations == null) {
			stateVariableDeclarations = new EObjectContainmentEList<StateVariableDeclaration>(StateVariableDeclaration.class, this, ImperativeModelPackage.IMPERATIVE_FUNCTION_CONTEXT__STATE_VARIABLE_DECLARATIONS);
		}
		return stateVariableDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CircularBufferDeclaration> getCircularBufferDeclarations() {
		if (circularBufferDeclarations == null) {
			circularBufferDeclarations = new EObjectContainmentEList<CircularBufferDeclaration>(CircularBufferDeclaration.class, this, ImperativeModelPackage.IMPERATIVE_FUNCTION_CONTEXT__CIRCULAR_BUFFER_DECLARATIONS);
		}
		return circularBufferDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Compound getInitializationCompound() {
		return initializationCompound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitializationCompound(Compound newInitializationCompound, NotificationChain msgs) {
		Compound oldInitializationCompound = initializationCompound;
		initializationCompound = newInitializationCompound;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImperativeModelPackage.IMPERATIVE_FUNCTION_CONTEXT__INITIALIZATION_COMPOUND, oldInitializationCompound, newInitializationCompound);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitializationCompound(Compound newInitializationCompound) {
		if (newInitializationCompound != initializationCompound) {
			NotificationChain msgs = null;
			if (initializationCompound != null)
				msgs = ((InternalEObject)initializationCompound).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImperativeModelPackage.IMPERATIVE_FUNCTION_CONTEXT__INITIALIZATION_COMPOUND, null, msgs);
			if (newInitializationCompound != null)
				msgs = ((InternalEObject)newInitializationCompound).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImperativeModelPackage.IMPERATIVE_FUNCTION_CONTEXT__INITIALIZATION_COMPOUND, null, msgs);
			msgs = basicSetInitializationCompound(newInitializationCompound, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeModelPackage.IMPERATIVE_FUNCTION_CONTEXT__INITIALIZATION_COMPOUND, newInitializationCompound, newInitializationCompound));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ImperativeModelPackage.IMPERATIVE_FUNCTION_CONTEXT__TEMPLATE_VARIABLE_DECLARATIONS:
				return ((InternalEList<?>)getTemplateVariableDeclarations()).basicRemove(otherEnd, msgs);
			case ImperativeModelPackage.IMPERATIVE_FUNCTION_CONTEXT__STATE_VARIABLE_DECLARATIONS:
				return ((InternalEList<?>)getStateVariableDeclarations()).basicRemove(otherEnd, msgs);
			case ImperativeModelPackage.IMPERATIVE_FUNCTION_CONTEXT__CIRCULAR_BUFFER_DECLARATIONS:
				return ((InternalEList<?>)getCircularBufferDeclarations()).basicRemove(otherEnd, msgs);
			case ImperativeModelPackage.IMPERATIVE_FUNCTION_CONTEXT__INITIALIZATION_COMPOUND:
				return basicSetInitializationCompound(null, msgs);
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
			case ImperativeModelPackage.IMPERATIVE_FUNCTION_CONTEXT__TEMPLATE_VARIABLE_DECLARATIONS:
				return getTemplateVariableDeclarations();
			case ImperativeModelPackage.IMPERATIVE_FUNCTION_CONTEXT__STATE_VARIABLE_DECLARATIONS:
				return getStateVariableDeclarations();
			case ImperativeModelPackage.IMPERATIVE_FUNCTION_CONTEXT__CIRCULAR_BUFFER_DECLARATIONS:
				return getCircularBufferDeclarations();
			case ImperativeModelPackage.IMPERATIVE_FUNCTION_CONTEXT__INITIALIZATION_COMPOUND:
				return getInitializationCompound();
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
			case ImperativeModelPackage.IMPERATIVE_FUNCTION_CONTEXT__TEMPLATE_VARIABLE_DECLARATIONS:
				getTemplateVariableDeclarations().clear();
				getTemplateVariableDeclarations().addAll((Collection<? extends TemplateVariableDeclaration>)newValue);
				return;
			case ImperativeModelPackage.IMPERATIVE_FUNCTION_CONTEXT__STATE_VARIABLE_DECLARATIONS:
				getStateVariableDeclarations().clear();
				getStateVariableDeclarations().addAll((Collection<? extends StateVariableDeclaration>)newValue);
				return;
			case ImperativeModelPackage.IMPERATIVE_FUNCTION_CONTEXT__CIRCULAR_BUFFER_DECLARATIONS:
				getCircularBufferDeclarations().clear();
				getCircularBufferDeclarations().addAll((Collection<? extends CircularBufferDeclaration>)newValue);
				return;
			case ImperativeModelPackage.IMPERATIVE_FUNCTION_CONTEXT__INITIALIZATION_COMPOUND:
				setInitializationCompound((Compound)newValue);
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
			case ImperativeModelPackage.IMPERATIVE_FUNCTION_CONTEXT__TEMPLATE_VARIABLE_DECLARATIONS:
				getTemplateVariableDeclarations().clear();
				return;
			case ImperativeModelPackage.IMPERATIVE_FUNCTION_CONTEXT__STATE_VARIABLE_DECLARATIONS:
				getStateVariableDeclarations().clear();
				return;
			case ImperativeModelPackage.IMPERATIVE_FUNCTION_CONTEXT__CIRCULAR_BUFFER_DECLARATIONS:
				getCircularBufferDeclarations().clear();
				return;
			case ImperativeModelPackage.IMPERATIVE_FUNCTION_CONTEXT__INITIALIZATION_COMPOUND:
				setInitializationCompound((Compound)null);
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
			case ImperativeModelPackage.IMPERATIVE_FUNCTION_CONTEXT__TEMPLATE_VARIABLE_DECLARATIONS:
				return templateVariableDeclarations != null && !templateVariableDeclarations.isEmpty();
			case ImperativeModelPackage.IMPERATIVE_FUNCTION_CONTEXT__STATE_VARIABLE_DECLARATIONS:
				return stateVariableDeclarations != null && !stateVariableDeclarations.isEmpty();
			case ImperativeModelPackage.IMPERATIVE_FUNCTION_CONTEXT__CIRCULAR_BUFFER_DECLARATIONS:
				return circularBufferDeclarations != null && !circularBufferDeclarations.isEmpty();
			case ImperativeModelPackage.IMPERATIVE_FUNCTION_CONTEXT__INITIALIZATION_COMPOUND:
				return initializationCompound != null;
		}
		return super.eIsSet(featureID);
	}

} //ImperativeFunctionContextImpl
