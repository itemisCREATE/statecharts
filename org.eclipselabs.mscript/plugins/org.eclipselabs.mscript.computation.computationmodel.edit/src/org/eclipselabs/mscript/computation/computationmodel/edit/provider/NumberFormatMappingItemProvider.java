/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.computation.computationmodel.edit.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipselabs.mscript.computation.computationmodel.ComputationModelPackage;
import org.eclipselabs.mscript.computation.computationmodel.NumberFormatMapping;
import org.eclipselabs.mscript.computation.computationmodel.edit.ComputationModelEditPlugin;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.edit.provider.TypeSystemItemProviderAdapterFactory;

/**
 * This is the item provider adapter for a {@link org.eclipselabs.mscript.computation.computationmodel.NumberFormatMapping} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class NumberFormatMappingItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberFormatMappingItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addNumberFormatPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Number Format feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNumberFormatPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_NumberFormatMapping_numberFormat_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_NumberFormatMapping_numberFormat_feature", "_UI_NumberFormatMapping_type"),
				 ComputationModelPackage.Literals.NUMBER_FORMAT_MAPPING__NUMBER_FORMAT,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ComputationModelPackage.Literals.NUMBER_FORMAT_MAPPING__DATA_TYPE);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns NumberFormatMapping.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/NumberFormatMapping"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		NumberFormatMapping mapping = (NumberFormatMapping) object;
		StringBuilder sb = new StringBuilder(getString("_UI_NumberFormatMapping_type"));
		if (mapping.getDataType() != null && mapping.getNumberFormat() != null) {
			sb.append(" ");
			Adapter dataTypeAdapter = new TypeSystemItemProviderAdapterFactory().createAdapter(mapping.getDataType());
			Adapter numberFormatAdapter = new ComputationModelItemProviderAdapterFactory().createAdapter(mapping.getNumberFormat());
			if (dataTypeAdapter instanceof IItemLabelProvider && numberFormatAdapter instanceof IItemLabelProvider) {
				sb.append("[");
				sb.append(((ItemProviderAdapter) dataTypeAdapter).getText(mapping.getDataType()));
				sb.append(" -> ");
				sb.append(((ItemProviderAdapter) numberFormatAdapter).getText(mapping.getNumberFormat()));
				sb.append("]");
			}
		}
		return sb.toString();
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(NumberFormatMapping.class)) {
			case ComputationModelPackage.NUMBER_FORMAT_MAPPING__DATA_TYPE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(ComputationModelPackage.Literals.NUMBER_FORMAT_MAPPING__DATA_TYPE,
				 TypeSystemFactory.eINSTANCE.createArrayType()));

		newChildDescriptors.add
			(createChildParameter
				(ComputationModelPackage.Literals.NUMBER_FORMAT_MAPPING__DATA_TYPE,
				 TypeSystemFactory.eINSTANCE.createRealType()));

		newChildDescriptors.add
			(createChildParameter
				(ComputationModelPackage.Literals.NUMBER_FORMAT_MAPPING__DATA_TYPE,
				 TypeSystemFactory.eINSTANCE.createIntegerType()));

		newChildDescriptors.add
			(createChildParameter
				(ComputationModelPackage.Literals.NUMBER_FORMAT_MAPPING__DATA_TYPE,
				 TypeSystemFactory.eINSTANCE.createBooleanType()));

		newChildDescriptors.add
			(createChildParameter
				(ComputationModelPackage.Literals.NUMBER_FORMAT_MAPPING__DATA_TYPE,
				 TypeSystemFactory.eINSTANCE.createStringType()));

		newChildDescriptors.add
			(createChildParameter
				(ComputationModelPackage.Literals.NUMBER_FORMAT_MAPPING__DATA_TYPE,
				 TypeSystemFactory.eINSTANCE.createEnumeration()));

		newChildDescriptors.add
			(createChildParameter
				(ComputationModelPackage.Literals.NUMBER_FORMAT_MAPPING__DATA_TYPE,
				 TypeSystemFactory.eINSTANCE.createInvalidDataType()));

		newChildDescriptors.add
			(createChildParameter
				(ComputationModelPackage.Literals.NUMBER_FORMAT_MAPPING__DATA_TYPE,
				 TypeSystemFactory.eINSTANCE.createTensorType()));

		newChildDescriptors.add
			(createChildParameter
				(ComputationModelPackage.Literals.NUMBER_FORMAT_MAPPING__DATA_TYPE,
				 TypeSystemFactory.eINSTANCE.createRecord()));

		newChildDescriptors.add
			(createChildParameter
				(ComputationModelPackage.Literals.NUMBER_FORMAT_MAPPING__DATA_TYPE,
				 TypeSystemFactory.eINSTANCE.createUnitType()));

		newChildDescriptors.add
			(createChildParameter
				(ComputationModelPackage.Literals.NUMBER_FORMAT_MAPPING__DATA_TYPE,
				 TypeSystemFactory.eINSTANCE.createAnyDataType()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ComputationModelEditPlugin.INSTANCE;
	}

}
