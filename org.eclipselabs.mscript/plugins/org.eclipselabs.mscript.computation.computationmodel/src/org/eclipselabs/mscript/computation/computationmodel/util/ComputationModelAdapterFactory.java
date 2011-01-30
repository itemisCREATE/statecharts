/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.computation.computationmodel.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.mscript.computation.computationmodel.ComputationModel;
import org.eclipselabs.mscript.computation.computationmodel.ComputationModelPackage;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointOperation;
import org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormat;
import org.eclipselabs.mscript.computation.computationmodel.NumberFormat;
import org.eclipselabs.mscript.computation.computationmodel.NumberFormatMapping;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.mscript.computation.computationmodel.ComputationModelPackage
 * @generated
 */
public class ComputationModelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ComputationModelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputationModelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ComputationModelPackage.eINSTANCE;
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
	protected ComputationModelSwitch<Adapter> modelSwitch =
		new ComputationModelSwitch<Adapter>() {
			@Override
			public Adapter caseFloatingPointFormat(FloatingPointFormat object) {
				return createFloatingPointFormatAdapter();
			}
			@Override
			public Adapter caseNumberFormat(NumberFormat object) {
				return createNumberFormatAdapter();
			}
			@Override
			public Adapter caseFixedPointFormat(FixedPointFormat object) {
				return createFixedPointFormatAdapter();
			}
			@Override
			public Adapter caseFixedPointOperation(FixedPointOperation object) {
				return createFixedPointOperationAdapter();
			}
			@Override
			public Adapter caseComputationModel(ComputationModel object) {
				return createComputationModelAdapter();
			}
			@Override
			public Adapter caseNumberFormatMapping(NumberFormatMapping object) {
				return createNumberFormatMappingAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormat <em>Floating Point Format</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormat
	 * @generated
	 */
	public Adapter createFloatingPointFormatAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.computation.computationmodel.NumberFormat <em>Number Format</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.computation.computationmodel.NumberFormat
	 * @generated
	 */
	public Adapter createNumberFormatAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat <em>Fixed Point Format</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat
	 * @generated
	 */
	public Adapter createFixedPointFormatAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.computation.computationmodel.FixedPointOperation <em>Fixed Point Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.computation.computationmodel.FixedPointOperation
	 * @generated
	 */
	public Adapter createFixedPointOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.computation.computationmodel.ComputationModel <em>Computation Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.computation.computationmodel.ComputationModel
	 * @generated
	 */
	public Adapter createComputationModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.mscript.computation.computationmodel.NumberFormatMapping <em>Number Format Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.mscript.computation.computationmodel.NumberFormatMapping
	 * @generated
	 */
	public Adapter createNumberFormatMappingAdapter() {
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

} //ComputationModelAdapterFactory
