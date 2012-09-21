/******************************************************************************
 * Copyright (c) 2002, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.gmf.runtime.emf.clipboard.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.gmf.runtime.emf.clipboard.core.internal.ClipboardPlugin;

/**
 * Utilities to assist the implementation of {@link IClipboardSupport}s by
 * plug-ins extending the <tt>clipboardSupport</tt> extension point.
 * 
 * @author Yasser Lulu
 */
public final class ClipboardSupportUtil {
	/** Index in an array or list indicating absence of the element sought. */
	public static final int NONE = -1;

	private static final String ONE = "1"; //$NON-NLS-1$

	private static final String UNDERSCORE = "_"; //$NON-NLS-1$

	private static final String RESOLVE = "resolve"; //$NON-NLS-1$

	private static final EReference[] EMPTY_REF_ARRAY = new EReference[0];

	/**
	 * Not instantiable by clients.
	 */
	private ClipboardSupportUtil() {
		super();
	}

	/**
	 * Removes from a collection of <code>elements</code> any elements that
	 * should not be copied.  These are those that have containers that are
	 * already in the <code>elements</code> collection.
	 * 
	 * @param elements the collection of elements to be whittled down to those
	 *     that should be copied.  <b>Note</b> that this collection is modified
	 *     in place
	 * @return the <code>elements</code> collection, again
	 */
	public static Collection getCopyElements(Collection elements) {
		Iterator it = elements.iterator();
		EObject element = null;
		Set set = new HashSet();
		while (it.hasNext()) {
			element = (EObject) it.next();
			set.add(element);
		}
		elements.clear();
		elements.addAll(getUniqueElementsAncestry(set));
		return elements;
	}

	/**
	 * Finds the subset of a set of elements that do not have ancestors in that
	 * set.
	 * 
	 * @param elementSet a set of {@link EObject}s
	 * @return the subset of the elements that are not contained within others
	 *     in the set
	 */
	private static Set getUniqueElementsAncestry(Set elementSet) {
		Iterator it = elementSet.iterator();
		EObject container = null;
		while (it.hasNext()) {
			container = ((EObject) it.next()).eContainer();
			while (container != null) {
				if (elementSet.contains(container)) {
					it.remove();
					break;
				}
				container = container.eContainer();
			}
		}
		return elementSet;
	}
	
	/**
	 * Replaces an object's many reference with an entirely new list of
	 * references.  Does nothing if the <code>reference</code> specified is
	 * not {@linkplain #isOkToSetEList(EObject, EReference) settable}.
	 * 
	 * @param eObject the element owning the reference to be set
	 * @param reference the many reference to be set
	 * @param referencedObjects the new value of the reference; must be an
	 *     {@link org.eclipse.emf.common.util.EList} of {@link EObject}s
	 * 
	 * @return the <code>referencedObjects</code>
	 * 
	 * @see #isOkToSetEList(EObject, EReference)
	 */
	public static List setEObjectList(EObject eObject,
			EReference reference, List referencedObjects) {
		
		if (isOkToSetEList(eObject, reference)) {
			if (reference.isContainment()) {
                for (Iterator referenced = referencedObjects.iterator();referenced.hasNext();) {
                    EObject referencedObject = (EObject)referenced.next();
                    if(referencedObject.eResource() != null){
                    	referencedObject.eResource().getContents().remove(referencedObject);
                    }
                }
				sendCreateEvent(referencedObjects);
			}
			eObject.eSet(reference, referencedObjects);
		}
		return referencedObjects;
	}

	/**
	 * Queries whether a reference is mutable.  A reference is considered
	 * mutable if and only if it is changeable and it is either not derived
	 * or it is a member of a feature map (though not itself a feature map).
	 * 
	 * @param reference the reference to test
	 * 
	 * @return <code>true</code> if the reference is mutable;
	 *     <code>false</code>, otherwise
	 */
	static boolean isMutable(EReference reference) {
		boolean result = reference.isChangeable();
		
		if (result) {
			if (reference.isDerived()) {
				// check whether it is a feature-map member that is not, itself,
				//    a feature map
				EStructuralFeature group = ExtendedMetaData.INSTANCE.getGroup(reference);
				
				result = (group != null) && !FeatureMapUtil.isFeatureMap(reference);
			}
		}
		
		return result;
	}
	
	/**
	 * Queries whether a many reference may be replaced with an entirely new
	 * list of {@link EObject}s.
	 * 
	 * @param eObject the owner of the <code>reference</code>
	 * @param reference a many reference to query whether it is settable
	 * @return <code>true</code> if the <code>reference</code> is changeable
	 *     and is not derived; <code>false</code>, otherwise
	 */
	public static boolean isOkToSetEList(EObject eObject, EReference reference) {
		if (isMutable(reference)) {
			return true;
		}
		return false;
	}

	/**
	 * Appends an object's many reference with a list of additional
	 * references.
	 * 
	 * @param eObject the element owning the reference list to be appended
	 * @param reference the many reference to be appended
	 * @param referencedObjects {@link EObject}s to append to the list
	 * 
	 * @return those of the <code>referencedObjects</code> that were
	 *    successfully appended
	 * 
	 * @see #appendEObjectAt(EObject, EReference, EObject)
	 */
	public static List appendEObjectListAt(EObject eObject,
			EReference reference, List referencedObjects) {
		List list = new ArrayList();
		EObject childEObject = null;
		Iterator childIt = referencedObjects.iterator();
		while (childIt.hasNext()) {
			childEObject = (EObject) childIt.next();
			childEObject = appendEObjectAt(eObject, reference,
				childEObject);
			if (childEObject != null) {
				list.add(childEObject);
			}
		}
		return list;
	}

	/**
	 * Appends an object's many reference with an additional reference.
	 * Has no effect if this <code>reference</code> cannot be
	 * {@linkplain #isOkToAppendEObjectAt(EObject, EReference, EObject) appended}.
	 * 
	 * @param eObject the element owning the reference list to be appended
	 * @param reference the many reference to be appended
	 * @param referencedObject an object to append to the list
	 * 
	 * @return <code>referencedObject</code> if it was successfully appended
	 *     to the reference; <code>null</code>, otherwise
	 * 
	 * @see #appendEObjectAt(EObject, EReference, EObject)
	 * @see #isOkToAppendEObjectAt(EObject, EReference, EObject)
	 */
	public static EObject appendEObjectAt(EObject eObject,
			EReference reference, EObject referencedObject) {
		if (isOkToAppendEObjectAt(eObject, reference, referencedObject) == false) {
			return null;
		}
		if (reference.isContainment()) {
			if(referencedObject.eResource() != null){
				referencedObject.eResource().getContents().remove(referencedObject);
		    }
			sendCreateEvent(referencedObject);
		}
		((Collection) eObject.eGet(reference)).add(referencedObject);
		return referencedObject;
	}

	/**
	 * Appends a resource's contents with an additional reference.
	 * 
	 * @param resource the resource
	 * @param referencedObject an object to append to the list
	 * 
	 * @return <code>referencedObject</code> if it was successfully appended
	 *     to the resource; <code>null</code>, otherwise
	 * 
	 */
	public static EObject appendEObject(Resource resource, EObject referencedObject) {
		 if(referencedObject.eResource() != null){
          	referencedObject.eResource().getContents().remove(referencedObject);
         }
		sendCreateEvent(referencedObject);
		resource.getContents().add(referencedObject);
		return referencedObject;
	}

	/**
	 * Replaces an object's scalar reference with an new element.
	 * Does nothing if the <code>reference</code> specified is not
	 * {@linkplain #isOkToSetEObject(EObject, EReference, EObject) settable}.
	 * 
	 * @param eObject the element owning the reference to be set
	 * @param reference the scalar reference to be set
	 * @param referencedObject the new value of the reference
	 * 
	 * @return the <code>referencedObjects</code>
	 * 
	 * @see #isOkToSetEObject(EObject, EReference, EObject)
	 */
	public static EObject setEObject(EObject eObject,
			EReference reference, EObject referencedObject) {
		if (isOkToSetEObject(eObject, reference, referencedObject) == false) {
			return null;
		}
		if (reference.isContainment()) {
			if(referencedObject.eResource() != null){
				referencedObject.eResource().getContents().remove(referencedObject);
		    }
			sendCreateEvent(referencedObject);
		}
		eObject.eSet(reference, referencedObject);
		return referencedObject;
	}

	/**
	 * Replaces an object's attribute with an new value.
	 * Does nothing if the <code>attribute</code> specified is not
	 * {@linkplain #isOkToSetEAttribute(EObject, EAttribute, Object) settable}.
	 * 
	 * @param eObject the element owning the attribute to be set
	 * @param attribute the attribute to be set
	 * @param value the new value of the attribute
	 * 
	 * @see #isOkToSetEAttribute(EObject, EAttribute, Object)
	 */
	public static void setEAttribute(EObject eObject,
			EAttribute attribute, Object value) {
		if (isOkToSetEAttribute(eObject, attribute, value)) {
			eObject.eSet(attribute, value);
		}
	}

	private static IClipboardSupport createClipboardSupport(EObject eObject) {
		return ClipboardUtil.createClipboardSupport(eObject);
	}
	
	/**
	 * Broadcasts a creatio notification for a new {@link EObject}
	 * via the appropriate clipboard support utility, if the metamodel support
	 * such notifications.
	 * 
	 * @param eObject a newly created <code>EObject</code>
	 * 
	 * @see IClipboardSupport#sendCreateNotification(EObject)
	 */
	public static void sendCreateEvent(EObject eObject) {
		IClipboardSupport cSupport = createClipboardSupport(eObject);
		
		if (null != cSupport)
			cSupport.sendCreateNotification(eObject);
	}
	
	/**
	 * Broadcasts creation notifications for a list of new {@link EObject}s
	 * via the appropriate clipboard support utility, if the metamodel support
	 * such notifications.
	 * 
	 * @param eObjects a list of newly created {@link EObject}s
	 * 
	 * @see #sendCreateEvent(EObject)
	 */
	public static void sendCreateEvent(List eObjects) {
		for (Iterator i = eObjects.iterator(); i.hasNext();)
			sendCreateEvent((EObject) i.next());
	}

	/**
	 * Queries whether an attribute may be set to the specified new value.
	 * 
	 * @param eObject the owner of the <code>attribute</code>
	 * @param attribute an attribute to query whether it is settable
	 * @param value the proposed new value of the <code>attribute</code>
	 * 
	 * @return <code>true</code> if the <code>attribute</code> is changeable
	 *     and the <code>value</code> is not <code>null</code>;
	 *     <code>false</code>, otherwise
	 */
	public static boolean isOkToSetEAttribute(EObject eObject,
			EAttribute attribute, Object value) {
		if ((value != null) && (attribute != null)) {
			return attribute.isChangeable();
		}
		return false;
	}

	/**
	 * Clears an object's scalar reference.
	 * Has no effect if this <code>reference</code> cannot be
	 * {@linkplain #isOkToDestroyEObject(EObject, EReference) cleared}.
	 * 
	 * @param eObject the element owning the reference to be cleared
	 * @param reference the scalar reference to be cleared
	 * 
	 * @see #isOkToDestroyEObject(EObject, EReference)
	 */
	public static void destroyEObject(EObject eObject,
			EReference reference) {
		if (isOkToDestroyEObject(eObject, reference) == false) {
			return;
		}
		EObject current = (EObject) eObject.eGet(reference);
		if (current == null) {
			return;
		}
		if (reference.isContainment()) {
			createClipboardSupport(current).destroy(current);
		} else {
			eObject.eSet(reference, null);
		}
	}

	/**
	 * Removes an element from an object's many reference.
	 * Has no effect if this <code>reference</code> cannot be
	 * {@linkplain #isOkToDestroyEObjectInCollection(EObject, EReference) removed}.
	 * 
	 * @param eObject the element owning the reference list to be reduced
	 * @param reference the many reference to be reduced
	 * @param referencedObject an object to remove from the list
	 * 
	 * @see #isOkToDestroyEObjectInCollection(EObject, EReference)
	 */
	public static void destroyEObjectInCollection(EObject eObject,
			EReference reference, EObject referencedObject) {
		if (isOkToDestroyEObjectInCollection(eObject, reference) == false) {
			return;
		}
		if (reference.isContainment()) {
			createClipboardSupport(referencedObject).destroy(referencedObject);
		} else {
			((Collection) eObject.eGet(reference)).remove(referencedObject);
		}
	}

	/**
	 * Removes an element from a resource.
	 * 
	 * @param referencedObject an object to remove from the resource
	 */
	public static void destroyEObjectInResource(EObject referencedObject) {
		createClipboardSupport(referencedObject).destroy(referencedObject);
	}

	/**
	 * Queries whether a many reference may be appended with an new
	 * {@link EObject}.
	 * 
	 * @param eObject the owner of the <code>reference</code>
	 * @param reference a many reference to query whether it is appendable
	 * @param referencedObject an object that is proposed to be appended
	 *      to the <code>reference</code>
	 * 
	 * @return <code>true</code> if the <code>reference</code> is changeable
	 *     and is not derived, and does not already contain the
	 *     <code>referencedObject</code> or appending it would not violate
	 *     the <code>reference</code>'s declared upper bound;
	 *     <code>false</code>, otherwise
	 */
	public static boolean isOkToAppendEObjectAt(EObject eObject,
			EReference reference, EObject referencedObject) {
		if (isMutable(reference)) {
			int lowerBound = reference.getLowerBound();
			int upperBound = reference.getUpperBound();
			if (lowerBound != upperBound) {
				if (eObject.eIsSet(reference)) {
					List list = (List) eObject.eGet(reference);
					return (((upperBound == NONE) || (list.size() < upperBound)) && (list
						.contains(referencedObject) == false));
				} else {
					return ((upperBound == NONE) || (upperBound > 0));
				}
			}
		}
		return false;
	}

	/**
	 * Queries whether a scalar reference may be set to an new {@link EObject}.
	 * 
	 * @param eObject the owner of the <code>reference</code>
	 * @param reference a scalar reference to query whether it is settable
	 * @param referencedObject an object that is proposed to be assigned
	 *      to the <code>reference</code>
	 * 
	 * @return <code>true</code> if the <code>reference</code> is changeable
	 *     and is not derived, and does not already contain the
	 *     <code>referencedObject</code> or the <code>referencedObject</code>
	 *     is <code>null</code>; <code>false</code>, otherwise
	 */
	public static boolean isOkToSetEObject(EObject eObject,
			EReference reference, EObject referencedObject) {
		if (isMutable(reference)) {
			Object value = eObject.eGet(reference);
			return ((referencedObject != null) && (value != referencedObject));
		}
		return false;
	}

	/**
	 * Queries whether a scalar reference may be cleared.
	 * 
	 * @param eObject the owner of the <code>reference</code>
	 * @param reference a scalar reference to query whether it is clearable
	 * 
	 * @return <code>true</code> if the <code>reference</code> is changeable
	 *     and its value is not already <code>null</code>;
	 *     <code>false</code>, otherwise
	 */
	public static boolean isOkToDestroyEObject(EObject eObject,
			EReference reference) {
		if (reference.isChangeable()) {
			Object value = eObject.eGet(reference);
			return (value != null);
		}
		return false;
	}

	/**
	 * Queries whether a many reference may have a reference removed from it.
	 * 
	 * @param eObject the owner of the <code>reference</code>
	 * @param reference a many reference to query whether it is removable
	 * 
	 * @return <code>true</code> if the <code>reference</code> is changeable
	 *     and is not derived, and removing an element would not violate
	 *     its declared lower bound; <code>false</code>, otherwise
	 */
	public static boolean isOkToDestroyEObjectInCollection(EObject eObject,
			EReference reference) {
		if (isMutable(reference)) {
			int lowerBound = reference.getLowerBound();
			int upperBound = reference.getUpperBound();
			if ((lowerBound != upperBound) && (eObject.eIsSet(reference))) {
				List list = (List) eObject.eGet(reference);
				return (list.size() > lowerBound);
			}
		}
		return false;
	}

	/**
	 * Finds an Ecore element from a list of <code>elements</code> whose having
	 * the specified <code>name</code>.  If an exact match is not found, and
	 * <code>trySubNames</code> is <code>true</code>, then the match is
	 * attempted again by trying to find an element whose name is a superset or
	 * a subset of the <code>name</code>.
	 * 
	 * @param elements a list of elements to search
	 * @param name the name to find
	 * @param trySubNames whether to attempt a loose name match, if necessary
	 * 
	 * @return the first named element found, or <code>null</code> if none
	 */
	private static ENamedElement matchName(ENamedElement[] elements,
			String name, boolean trySubNames) {
		//match on exact name
		for (int i = 0; i < elements.length; ++i) {
			if (elements[i].getName().equalsIgnoreCase(name)) {
				return elements[i];
			}
		}

		if (trySubNames) {
			//match on subname
			for (int i = 0; i < elements.length; ++i) {
				if ((elements[i].getName().indexOf(name) != NONE)
					|| (name.indexOf(elements[i].getName()) != NONE)) {
					return elements[i];
				}
			}
		}
		return null;
	}

	/**
	 * Queries whether the specified <code>eObject</code> is contained within
	 * another.  This differs from the
	 * {@link org.eclipse.emf.ecore.util.EcoreUtil#isAncestor(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject)}
	 * method in checking for equality rather than identity.
	 * 
	 * @param eParent an element
	 * @param eObject an element to see whether it is contained in the
	 *    <code>eParent</code>
	 * @return <code>true</code> if the <code>eObject</code> is contained within
	 *     an element equal to the <code>eParent</code>;
	 *      <code>false</code>, otherwise
	 */
	public static boolean isChild(EObject eParent, EObject eObject) {
		EObject eContainer = eObject.eContainer();
		while (eContainer != null) {
			if (eContainer.equals(eParent)) {
				return true;
			}
			eContainer = eContainer.eContainer();
		}
		return false;
	}

	/**
	 * Queries whether two elements are both
	 * {@linkplain IClipboardSupport#isNameable(EObject) nameable} and have
	 * the same name (ignoring case).
	 * 
	 * @param eObject1 an object
	 * @param eObject2 another object
	 * @return <code>true</code> if both objects are nameable and have the
	 *     same name (ignoring case); <code>false</code>, otherwise
	 * 
	 * @see IClipboardSupport#isNameable(EObject)
	 */
	public static boolean hasNameCollision(EObject eObject1, EObject eObject2) {
		if (eObject1.eClass().equals(eObject2.eClass())) {
			IClipboardSupport cs = createClipboardSupport(eObject1);
			
			//if the same object then no collision
			if (eObject1.equals(eObject2)) {
				return false;
			} else if (isNameable(eObject1)) {
				String childEObjectName = cs.getName(eObject2);
				if (!isEmptyName(childEObjectName)) {
					if (childEObjectName.equalsIgnoreCase(cs.getName(eObject1))) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Queries whether the specified element name is empty, indicating that the
	 * element does not have a name. This is the case if the name is either the
	 * <code>null</code> reference or an empty string. No consideration is
	 * made for names that may be different if they were trimmed (for example, a
	 * name consisting of just a bunch of blanks is not "empty").
	 * 
	 * @param elementName
	 *            an element (eobject) name
	 * @return <code>true</code> if the <code>elementName</code> is either
	 *         <code>null</code> or empty; <code>false</code>, otherwise
	 */
	private static boolean isEmptyName(String elementName) {
		return (elementName == null) || (elementName.length() == 0);
	}

	/**
	 * Determines whether an object is nameable.
	 * 
	 * @param eObject an object
	 * 
	 * @return whether it is nameable
	 */
	private static boolean isNameable(EObject eObject) {
		return createClipboardSupport(eObject).isNameable(eObject);
	}

	/**
	 * Queries whether an object is
	 * {@linkplain IClipboardSupport#isNameable(EObject) nameable} and have
	 * the same name (ignoring case) as any element in a <code>list</code>.
	 * 
	 * @param list a ist of objects
	 * @param eObject another object
	 * @return <code>true</code> if the <code>eObject</code>is nameable and
	 *     has the same name (ignoring case) as any object in the
	 *     <code>list</code>; <code>false</code>, otherwise
	 * 
	 * @see IClipboardSupport#isNameable(EObject)
	 */
	public static boolean hasNameCollision(Collection list, EObject eObject) {
		Iterator it = list.iterator();
		EObject eOther = null;
		while (it.hasNext()) {
			eOther = (EObject) it.next();
			if (hasNameCollision(eOther, eObject)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Given an object that has a name collision with one or more elements in 
	 * a <code>list</code>, renames it to have a unique name.
	 * 
	 * @param list a list of objects
	 * @param eObject another object whose name collides with the <code>list</code>
	 * @param prefix the prefix to append; it will be modified by '_1', '_2',
	 *     etc. as necessary
	 * 
	 * @see #hasNameCollision(Collection, EObject)
	 */
	public static void rename(Collection list, EObject eObject, String prefix) {
		if (isNameable(eObject) == false) {
			return;
		}
		String new_name = null;
		String name = createClipboardSupport(eObject).getName(eObject);
		String prefix_underscore = prefix + UNDERSCORE;
		if (name.startsWith(prefix_underscore)) {
			int close_index = name.indexOf(UNDERSCORE, prefix_underscore
				.length());
			if (close_index != NONE) {
				String copy_prefix = name.substring(0, close_index);
				int open_index = copy_prefix.indexOf(UNDERSCORE);
				String copy_count_str = copy_prefix.substring(open_index + 1);
				try {
					int copy_count = Integer.parseInt(copy_count_str);
					String name_proper = name.substring(close_index + 1).trim();
					new_name = prefix_underscore + ++copy_count + UNDERSCORE
						+ name_proper;
				} catch (NumberFormatException nfe) {
					ClipboardPlugin.catching(ClipboardSupportUtil.class,
						"rename", nfe); //$NON-NLS-1$
					new_name = null;
				}
			}
		}

		if (new_name == null) {
			new_name = prefix_underscore + ONE + UNDERSCORE + name;
		}

		createClipboardSupport(eObject).setName(eObject, new_name);

		//check this new name itself does not collide with an existing one
		if (hasNameCollision(list, eObject)) {
			rename(list, eObject, prefix);
		}
	}

	/**
	 * Queries whether two collections intersect.
	 * 
	 * @param collection1 a collection
	 * @param collection2 another
	 * 
	 * @return <code>true</code> if they have any elements in common;
	 *    <code>false</code>, otherwise
	 */
	public static boolean containsAny(Collection collection1,
			Collection collection2) {
		Iterator it = collection2.iterator();
		while (it.hasNext()) {
			if (collection1.contains(it.next())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Resolves a <code>proxy</code>, using the specified ID map.  If a proxy
	 * resolves to another proxy, then this procedure repeats until either a
	 * non-proxy is found or it is not resolved.
	 * 
	 * @param proxy a proxy
	 * @param idToEObjectMap a mapping of element ID strings to {@link EObject}s
	 * @return a resolved element, or a proxy if it could not be resolved.  In
	 *     either case, the result may be different than the original
	 *     <code>proxy</code> (this is different from the behaviour of the
	 *     {@link org.eclipse.emf.ecore.util.EcoreUtil#resolve(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject)}
	 *     method
	 */
	public static EObject resolve(EObject proxy, Map idToEObjectMap) {
		URI proxyUri = ((InternalEObject) proxy).eProxyURI();
		if (proxyUri != null) {
			try {
				String id = getProxyID(proxyUri);
				if ((id == null) || (id.length() == 0)) {
					id = proxyUri.fragment();
				}
				EObject resolvedObject = (EObject) idToEObjectMap.get(id);
				if (resolvedObject != null && resolvedObject != proxy) {
					return resolve(resolvedObject, idToEObjectMap);
				}
			} catch (Exception exception) {
				ClipboardPlugin.catching(ClipboardSupportUtil.class, RESOLVE, exception);
			}
		}
		return proxy;
	}

	/**
	 * Resolves a <code>proxy</code>, using the specified resource.  If a proxy
	 * resolves to another proxy, then this procedure repeats until either a
	 * non-proxy is found or it is not resolved.
	 * 
	 * @param proxy a proxy
	 * @param resource the resource containing a mapping of element ID strings to {@link EObject}s
	 * @return a resolved element, or a proxy if it could not be resolved.  In
	 *     either case, the result may be different than the original
	 *     <code>proxy</code> (this is different from the behaviour of the
	 *     {@link org.eclipse.emf.ecore.util.EcoreUtil#resolve(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject)}
	 *     method
	 */
	public static EObject resolve(EObject proxy, XMLResource resource) {
		URI proxyUri = ((InternalEObject) proxy).eProxyURI();
		if (proxyUri != null) {
			try {
				String id = getProxyID(proxyUri);
				if ((id == null) || (id.length() == 0)) {
					id = proxyUri.fragment();
				}
				EObject resolvedObject = resource.getEObject(id);
				if (resolvedObject != null && resolvedObject != proxy) {
					return resolve(resolvedObject, resource);
				}
			} catch (Exception exception) {
				ClipboardPlugin.catching(ClipboardSupportUtil.class, RESOLVE, exception);
			}
		}
		return proxy;
	}

	/**
	 * Obtains the proxy ID from a proxy, accounting for possible fragment
	 * queries.
	 * 
	 * @param proxyUri a proxy URI
	 * @return the fragment portion, minus the query (if any)
	 */
	private static String getProxyID(URI proxyUri) {

		String uriFragment = proxyUri.fragment();

		int index = uriFragment.indexOf('?');

		return index != -1 ? uriFragment.substring(0, index)
			: uriFragment;
	}

	/**
	 * Obtains the containment feature of a parent element into which a child
	 * should be pasted, that best matches the child's original containment
	 * feature.
	 * 
	 * @param parentEObject the target element into which a child is to be
	 *     pasted
	 * @param eObject the child element to be pasted into the parent
	 * @param originalReference the child's original containment reference
	 * 
	 * @return the best-match containment reference, or <code>null</code> if
	 *     child <code>eObject</code> simply cannot be contained by the
	 *     <code>parentEObject</code>
	 */
	public static EReference getPasteContainmentFeature(EObject parentEObject,
			EObject eObject, EReference originalReference) {
		//NOTE: originalReference could be null
		List compatibleRefrencesList = new ArrayList();
		EClass parentEClass = parentEObject.eClass();
		EClass childEClass = eObject.eClass();
		Iterator it = parentEClass.getEAllReferences().iterator();
		EReference parentReference = null;
		while (it.hasNext()) {
			parentReference = (EReference) it.next();
			// check if the parentReference is a containment reference
			if (parentReference.isContainment()) {
				if ((originalReference != null)
					&& parentReference.equals(originalReference)) {
					//perfect match...return it
					return parentReference;
				}
				if (isMutable(parentReference)) {
					if (createClipboardSupport(parentEObject).canContain(
							parentEObject, parentReference, childEClass)) {
						//holds same eObject type, collect it
						compatibleRefrencesList.add(parentReference);
					}
				}
			}
		}

		//found none
		if (compatibleRefrencesList.size() == 0) {
			return null;
		} else if (compatibleRefrencesList.size() == 1) {
			//only one, then return it
			return (EReference) compatibleRefrencesList.get(0);
		}

		//didn't return from above, ok try to choose one based on name match.
		EReference[] references = (EReference[]) compatibleRefrencesList
			.toArray(EMPTY_REF_ARRAY);
		//match on exact name of originalReference.
		EReference ref = null;
		if (originalReference != null) {
			ref = (EReference) ClipboardSupportUtil.matchName(references,
				originalReference.getName(), true);
		}

		return (ref == null) ? (EReference) ClipboardSupportUtil.matchName(
			references, childEClass.getName(), true)
			: ref;
	}
}