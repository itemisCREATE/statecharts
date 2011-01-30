/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.functionmodel.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.mscript.language.functionmodel.EquationDescriptor;
import org.eclipselabs.mscript.language.functionmodel.EquationPart;
import org.eclipselabs.mscript.language.functionmodel.EquationSide;
import org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor;
import org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage;
import org.eclipselabs.mscript.language.functionmodel.VariableDescriptor;
import org.eclipselabs.mscript.language.functionmodel.VariableStep;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage
 * @generated
 */
public class FunctionModelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static FunctionModelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionModelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = FunctionModelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionModelSwitch<Adapter> modelSwitch =
		new FunctionModelSwitch<Adapter>() {
			@Override
			public Adapter caseFunctionDescriptor(FunctionDescriptor object) {
				return createFunctionDescriptorAdapter();
			}
			@Override
			public Adapter caseEquationDescriptor(EquationDescriptor object) {
				return createEquationDescriptorAdapter();
			}
			@Override
			public Adapter caseEquationSide(EquationSide object) {
				return createEquationSideAdapter();
			}
			@Override
			public Adapter caseEquationPart(EquationPart object) {
				return createEquationPartAdapter();
			}
			@Override
			public Adapter caseVariableDescriptor(VariableDescriptor object) {
				return createVariableDescriptorAdapter();
			}
			@Override
			public Adapter caseVariableStep(VariableStep object) {
				return createVariableStepAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor <em>Function Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor
	 * @generated
	 */
	public Adapter createFunctionDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.functionmodel.EquationDescriptor <em>Equation Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.functionmodel.EquationDescriptor
	 * @generated
	 */
	public Adapter createEquationDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.functionmodel.EquationSide <em>Equation Side</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.functionmodel.EquationSide
	 * @generated
	 */
	public Adapter createEquationSideAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.functionmodel.EquationPart <em>Equation Part</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.functionmodel.EquationPart
	 * @generated
	 */
	public Adapter createEquationPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.functionmodel.VariableDescriptor <em>Variable Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.functionmodel.VariableDescriptor
	 * @generated
	 */
	public Adapter createVariableDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.language.functionmodel.VariableStep <em>Variable Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.language.functionmodel.VariableStep
	 * @generated
	 */
	public Adapter createVariableStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //FunctionModelAdapterFactory
