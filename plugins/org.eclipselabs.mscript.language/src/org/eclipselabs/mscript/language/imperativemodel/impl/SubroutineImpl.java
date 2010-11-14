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
import org.eclipselabs.mscript.language.imperativemodel.Block;
import org.eclipselabs.mscript.language.imperativemodel.ComputationBlock;
import org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage;
import org.eclipselabs.mscript.language.imperativemodel.Subroutine;
import org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subroutine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.impl.SubroutineImpl#getTemplateVariableDeclarations <em>Template Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.impl.SubroutineImpl#getInputVariableDeclarations <em>Input Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.impl.SubroutineImpl#getOutputVariableDeclarations <em>Output Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.impl.SubroutineImpl#getStateVariableDeclarations <em>State Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.impl.SubroutineImpl#getInitializationBlock <em>Initialization Block</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.impl.SubroutineImpl#getComputationBlocks <em>Computation Blocks</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubroutineImpl extends EObjectImpl implements Subroutine {
	/**
	 * The cached value of the '{@link #getTemplateVariableDeclarations() <em>Template Variable Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplateVariableDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableDeclaration> templateVariableDeclarations;

	/**
	 * The cached value of the '{@link #getInputVariableDeclarations() <em>Input Variable Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputVariableDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableDeclaration> inputVariableDeclarations;

	/**
	 * The cached value of the '{@link #getOutputVariableDeclarations() <em>Output Variable Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputVariableDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableDeclaration> outputVariableDeclarations;

	/**
	 * The cached value of the '{@link #getStateVariableDeclarations() <em>State Variable Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateVariableDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableDeclaration> stateVariableDeclarations;

	/**
	 * The cached value of the '{@link #getInitializationBlock() <em>Initialization Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitializationBlock()
	 * @generated
	 * @ordered
	 */
	protected Block initializationBlock;

	/**
	 * The cached value of the '{@link #getComputationBlocks() <em>Computation Blocks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComputationBlocks()
	 * @generated
	 * @ordered
	 */
	protected EList<ComputationBlock> computationBlocks;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubroutineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImperativeModelPackage.Literals.SUBROUTINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableDeclaration> getTemplateVariableDeclarations() {
		if (templateVariableDeclarations == null) {
			templateVariableDeclarations = new EObjectContainmentEList<VariableDeclaration>(VariableDeclaration.class, this, ImperativeModelPackage.SUBROUTINE__TEMPLATE_VARIABLE_DECLARATIONS);
		}
		return templateVariableDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableDeclaration> getInputVariableDeclarations() {
		if (inputVariableDeclarations == null) {
			inputVariableDeclarations = new EObjectContainmentEList<VariableDeclaration>(VariableDeclaration.class, this, ImperativeModelPackage.SUBROUTINE__INPUT_VARIABLE_DECLARATIONS);
		}
		return inputVariableDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableDeclaration> getOutputVariableDeclarations() {
		if (outputVariableDeclarations == null) {
			outputVariableDeclarations = new EObjectContainmentEList<VariableDeclaration>(VariableDeclaration.class, this, ImperativeModelPackage.SUBROUTINE__OUTPUT_VARIABLE_DECLARATIONS);
		}
		return outputVariableDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableDeclaration> getStateVariableDeclarations() {
		if (stateVariableDeclarations == null) {
			stateVariableDeclarations = new EObjectContainmentEList<VariableDeclaration>(VariableDeclaration.class, this, ImperativeModelPackage.SUBROUTINE__STATE_VARIABLE_DECLARATIONS);
		}
		return stateVariableDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Block getInitializationBlock() {
		return initializationBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitializationBlock(Block newInitializationBlock, NotificationChain msgs) {
		Block oldInitializationBlock = initializationBlock;
		initializationBlock = newInitializationBlock;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImperativeModelPackage.SUBROUTINE__INITIALIZATION_BLOCK, oldInitializationBlock, newInitializationBlock);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitializationBlock(Block newInitializationBlock) {
		if (newInitializationBlock != initializationBlock) {
			NotificationChain msgs = null;
			if (initializationBlock != null)
				msgs = ((InternalEObject)initializationBlock).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImperativeModelPackage.SUBROUTINE__INITIALIZATION_BLOCK, null, msgs);
			if (newInitializationBlock != null)
				msgs = ((InternalEObject)newInitializationBlock).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImperativeModelPackage.SUBROUTINE__INITIALIZATION_BLOCK, null, msgs);
			msgs = basicSetInitializationBlock(newInitializationBlock, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeModelPackage.SUBROUTINE__INITIALIZATION_BLOCK, newInitializationBlock, newInitializationBlock));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComputationBlock> getComputationBlocks() {
		if (computationBlocks == null) {
			computationBlocks = new EObjectContainmentEList<ComputationBlock>(ComputationBlock.class, this, ImperativeModelPackage.SUBROUTINE__COMPUTATION_BLOCKS);
		}
		return computationBlocks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ImperativeModelPackage.SUBROUTINE__TEMPLATE_VARIABLE_DECLARATIONS:
				return ((InternalEList<?>)getTemplateVariableDeclarations()).basicRemove(otherEnd, msgs);
			case ImperativeModelPackage.SUBROUTINE__INPUT_VARIABLE_DECLARATIONS:
				return ((InternalEList<?>)getInputVariableDeclarations()).basicRemove(otherEnd, msgs);
			case ImperativeModelPackage.SUBROUTINE__OUTPUT_VARIABLE_DECLARATIONS:
				return ((InternalEList<?>)getOutputVariableDeclarations()).basicRemove(otherEnd, msgs);
			case ImperativeModelPackage.SUBROUTINE__STATE_VARIABLE_DECLARATIONS:
				return ((InternalEList<?>)getStateVariableDeclarations()).basicRemove(otherEnd, msgs);
			case ImperativeModelPackage.SUBROUTINE__INITIALIZATION_BLOCK:
				return basicSetInitializationBlock(null, msgs);
			case ImperativeModelPackage.SUBROUTINE__COMPUTATION_BLOCKS:
				return ((InternalEList<?>)getComputationBlocks()).basicRemove(otherEnd, msgs);
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
			case ImperativeModelPackage.SUBROUTINE__TEMPLATE_VARIABLE_DECLARATIONS:
				return getTemplateVariableDeclarations();
			case ImperativeModelPackage.SUBROUTINE__INPUT_VARIABLE_DECLARATIONS:
				return getInputVariableDeclarations();
			case ImperativeModelPackage.SUBROUTINE__OUTPUT_VARIABLE_DECLARATIONS:
				return getOutputVariableDeclarations();
			case ImperativeModelPackage.SUBROUTINE__STATE_VARIABLE_DECLARATIONS:
				return getStateVariableDeclarations();
			case ImperativeModelPackage.SUBROUTINE__INITIALIZATION_BLOCK:
				return getInitializationBlock();
			case ImperativeModelPackage.SUBROUTINE__COMPUTATION_BLOCKS:
				return getComputationBlocks();
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
			case ImperativeModelPackage.SUBROUTINE__TEMPLATE_VARIABLE_DECLARATIONS:
				getTemplateVariableDeclarations().clear();
				getTemplateVariableDeclarations().addAll((Collection<? extends VariableDeclaration>)newValue);
				return;
			case ImperativeModelPackage.SUBROUTINE__INPUT_VARIABLE_DECLARATIONS:
				getInputVariableDeclarations().clear();
				getInputVariableDeclarations().addAll((Collection<? extends VariableDeclaration>)newValue);
				return;
			case ImperativeModelPackage.SUBROUTINE__OUTPUT_VARIABLE_DECLARATIONS:
				getOutputVariableDeclarations().clear();
				getOutputVariableDeclarations().addAll((Collection<? extends VariableDeclaration>)newValue);
				return;
			case ImperativeModelPackage.SUBROUTINE__STATE_VARIABLE_DECLARATIONS:
				getStateVariableDeclarations().clear();
				getStateVariableDeclarations().addAll((Collection<? extends VariableDeclaration>)newValue);
				return;
			case ImperativeModelPackage.SUBROUTINE__INITIALIZATION_BLOCK:
				setInitializationBlock((Block)newValue);
				return;
			case ImperativeModelPackage.SUBROUTINE__COMPUTATION_BLOCKS:
				getComputationBlocks().clear();
				getComputationBlocks().addAll((Collection<? extends ComputationBlock>)newValue);
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
			case ImperativeModelPackage.SUBROUTINE__TEMPLATE_VARIABLE_DECLARATIONS:
				getTemplateVariableDeclarations().clear();
				return;
			case ImperativeModelPackage.SUBROUTINE__INPUT_VARIABLE_DECLARATIONS:
				getInputVariableDeclarations().clear();
				return;
			case ImperativeModelPackage.SUBROUTINE__OUTPUT_VARIABLE_DECLARATIONS:
				getOutputVariableDeclarations().clear();
				return;
			case ImperativeModelPackage.SUBROUTINE__STATE_VARIABLE_DECLARATIONS:
				getStateVariableDeclarations().clear();
				return;
			case ImperativeModelPackage.SUBROUTINE__INITIALIZATION_BLOCK:
				setInitializationBlock((Block)null);
				return;
			case ImperativeModelPackage.SUBROUTINE__COMPUTATION_BLOCKS:
				getComputationBlocks().clear();
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
			case ImperativeModelPackage.SUBROUTINE__TEMPLATE_VARIABLE_DECLARATIONS:
				return templateVariableDeclarations != null && !templateVariableDeclarations.isEmpty();
			case ImperativeModelPackage.SUBROUTINE__INPUT_VARIABLE_DECLARATIONS:
				return inputVariableDeclarations != null && !inputVariableDeclarations.isEmpty();
			case ImperativeModelPackage.SUBROUTINE__OUTPUT_VARIABLE_DECLARATIONS:
				return outputVariableDeclarations != null && !outputVariableDeclarations.isEmpty();
			case ImperativeModelPackage.SUBROUTINE__STATE_VARIABLE_DECLARATIONS:
				return stateVariableDeclarations != null && !stateVariableDeclarations.isEmpty();
			case ImperativeModelPackage.SUBROUTINE__INITIALIZATION_BLOCK:
				return initializationBlock != null;
			case ImperativeModelPackage.SUBROUTINE__COMPUTATION_BLOCKS:
				return computationBlocks != null && !computationBlocks.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SubroutineImpl
