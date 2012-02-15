/**
 * <copyright>
 * </copyright>
 *
 */
package org.yakindu.sct.model.stext.stext.provider;


import java.util.Collection;
import java.util.List;

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
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.yakindu.base.base.BasePackage;

import org.yakindu.base.types.TypesFactory;
import org.yakindu.base.types.TypesPackage;

import org.yakindu.sct.model.sgraph.SGraphPackage;

import org.yakindu.sct.model.sgraph.provider.ScopeItemProvider;

import org.yakindu.sct.model.stext.stext.StatechartScope;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.stext.StextPackage;

/**
 * This is the item provider adapter for a {@link org.yakindu.sct.model.stext.stext.StatechartScope} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class StatechartScopeItemProvider
  extends ScopeItemProvider
  implements
    IEditingDomainItemProvider,
    IStructuredItemContentProvider,
    ITreeItemContentProvider,
    IItemLabelProvider,
    IItemPropertySource
{
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StatechartScopeItemProvider(AdapterFactory adapterFactory)
  {
    super(adapterFactory);
  }

  /**
   * This returns the property descriptors for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object)
  {
    if (itemPropertyDescriptors == null)
    {
      super.getPropertyDescriptors(object);

      addNamePropertyDescriptor(object);
      addSuperTypesPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Name feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addNamePropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_NamedElement_name_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_NamedElement_name_feature", "_UI_NamedElement_type"),
         BasePackage.Literals.NAMED_ELEMENT__NAME,
         true,
         false,
         false,
         ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
         null,
         null));
  }

  /**
   * This adds a property descriptor for the Super Types feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addSuperTypesPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add
      (createItemPropertyDescriptor
        (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
         getResourceLocator(),
         getString("_UI_Type_superTypes_feature"),
         getString("_UI_PropertyDescriptor_description", "_UI_Type_superTypes_feature", "_UI_Type_type"),
         TypesPackage.Literals.TYPE__SUPER_TYPES,
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
  public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object)
  {
    if (childrenFeatures == null)
    {
      super.getChildrenFeatures(object);
      childrenFeatures.add(TypesPackage.Literals.TYPE__FEATURES);
    }
    return childrenFeatures;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EStructuralFeature getChildFeature(Object object, Object child)
  {
    // Check the type of the specified child object and return the proper feature to use for
    // adding (see {@link AddCommand}) it as a child.

    return super.getChildFeature(object, child);
  }

  /**
   * This returns StatechartScope.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object getImage(Object object)
  {
    return overlayImage(object, getResourceLocator().getImage("full/obj16/StatechartScope"));
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getText(Object object)
  {
    String label = ((StatechartScope)object).getName();
    return label == null || label.length() == 0 ?
      getString("_UI_StatechartScope_type") :
      getString("_UI_StatechartScope_type") + " " + label;
  }

  /**
   * This handles model notifications by calling {@link #updateChildren} to update any cached
   * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void notifyChanged(Notification notification)
  {
    updateChildren(notification);

    switch (notification.getFeatureID(StatechartScope.class))
    {
      case StextPackage.STATECHART_SCOPE__NAME:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
        return;
      case StextPackage.STATECHART_SCOPE__FEATURES:
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
  protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object)
  {
    super.collectNewChildDescriptors(newChildDescriptors, object);

    newChildDescriptors.add
      (createChildParameter
        (SGraphPackage.Literals.SCOPE__DECLARATIONS,
         StextFactory.eINSTANCE.createEventDefinition()));

    newChildDescriptors.add
      (createChildParameter
        (SGraphPackage.Literals.SCOPE__DECLARATIONS,
         StextFactory.eINSTANCE.createLocalReaction()));

    newChildDescriptors.add
      (createChildParameter
        (SGraphPackage.Literals.SCOPE__DECLARATIONS,
         StextFactory.eINSTANCE.createVariableDefinition()));

    newChildDescriptors.add
      (createChildParameter
        (SGraphPackage.Literals.SCOPE__DECLARATIONS,
         StextFactory.eINSTANCE.createOperation()));

    newChildDescriptors.add
      (createChildParameter
        (SGraphPackage.Literals.SCOPE__DECLARATIONS,
         StextFactory.eINSTANCE.createEntrypoint()));

    newChildDescriptors.add
      (createChildParameter
        (SGraphPackage.Literals.SCOPE__DECLARATIONS,
         StextFactory.eINSTANCE.createExitpoint()));

    newChildDescriptors.add
      (createChildParameter
        (TypesPackage.Literals.TYPE__FEATURES,
         StextFactory.eINSTANCE.createEventDefinition()));

    newChildDescriptors.add
      (createChildParameter
        (TypesPackage.Literals.TYPE__FEATURES,
         TypesFactory.eINSTANCE.createOperation()));

    newChildDescriptors.add
      (createChildParameter
        (TypesPackage.Literals.TYPE__FEATURES,
         TypesFactory.eINSTANCE.createProperty()));

    newChildDescriptors.add
      (createChildParameter
        (TypesPackage.Literals.TYPE__FEATURES,
         TypesFactory.eINSTANCE.createEvent()));
  }

  /**
   * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection)
  {
    Object childFeature = feature;
    Object childObject = child;

    boolean qualify =
      childFeature == SGraphPackage.Literals.SCOPE__DECLARATIONS ||
      childFeature == TypesPackage.Literals.TYPE__FEATURES;

    if (qualify)
    {
      return getString
        ("_UI_CreateChild_text2",
         new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
    }
    return super.getCreateChildText(owner, feature, child, selection);
  }

  /**
   * Return the resource locator for this item provider's resources.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ResourceLocator getResourceLocator()
  {
    return STextEditPlugin.INSTANCE;
  }

}
