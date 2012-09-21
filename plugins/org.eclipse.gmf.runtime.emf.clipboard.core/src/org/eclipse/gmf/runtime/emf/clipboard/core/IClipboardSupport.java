/******************************************************************************
 * Copyright (c) 2002, 2003 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.gmf.runtime.emf.clipboard.core;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.xmi.XMLResource;


/**
 * An interface to be implemented by EMF metamodel providers to inject
 * metamodel-specific semantics into copy/paste operations.
 * Basically it has hints (e.g., what to do when pasted elements collide, what
 * related elements should always be copied together, etc.) that helps the
 * framework to make decisions.  For maximal flexibility, it is even possible
 * to override the paste operstion altogether.
 * <p>
 * This interface is intended to be implemented by plug-ins on the
 * <tt>clipboardSupport</tt> extension point.
 * See the {@link AbstractClipboardSupport} for a convenient superclass for
 * your implementation.
 * </p>
 * 
 * @see AbstractClipboardSupport
 * 
 * @author Yasser Lulu
 */
public interface IClipboardSupport {

    /**
     * Queries what to do when a paste collision occurs on instances of a
     * particular metaclass.
     * 
     * @param eClass the metaclass in question
     * @return one of the enumerated paste actions
     */
    PasteAction getPasteCollisionAction(EClass eClass);

    /**
     * Queries whether a feature supports a particular paste option.
     * 
     * @param context and object being copied or pasted
     * @param eStructuralFeature a feature of the <code>contextEObject</code>
     * @param pasteOption the paste option to query
     * 
     * @return boolean whether the paste option is supported on this feature
     */
    boolean hasPasteOption(EObject context,
            EStructuralFeature eStructuralFeature, PasteOption pasteOption);

    /**
     * Queries whether a reference needs to be copied even though the referenced
     * element was not specifically included in the copy request.  It is
     * recommended, though not required, that in general:
     * <ul>
     *   <li>containment references should always be copied</li>
     *   <li>transient or derived references should not be copied</li>
     * </ul>
     * 
     * @param context an object being copied that owns the reference
     * @param eReference the reference being to query
     * @param value the object(s) referenced by the <code>eReference</code>.
     *     It is either an {@link EObject} or a collection of
     *     <code>EObject</code>s, according to the multiplicity of the reference
     * 
     * @return boolean whether the <code>value</code> must also be copied
     */
    boolean isCopyAlways(EObject context, EReference eReference, Object value);

    /**
     * Queries whether it is necessary to completely override the default paste
     * behaviour for pasting the specified (contained) child object into its
     * parent.
     * 
     * @param parentElement the target element into which a child is to be pasted
     * @param childEObject the child element to be pasted
     * 
     * @return boolean <code>true</code> if we want to completely override the
     *     paste operation for this child; <code>false</code>, otherwise
     */
    boolean shouldOverrideChildPasteOperation(EObject parentElement,
            EObject childEObject);

    /**
     * Queries whether it is necessary to completely override the default copy
     * behaviour for copying the specified objects.
     * 
     * @param eObjects a collection of {@link EObject}s to be pasted
     * @param hintMap the copy hints provided by the client of the
     *     current copy operation
     * 
     * @return boolean <code>true</code> if we want to completely override the
     *     copy operation for these objects; <code>false</code>, otherwise
     */

    boolean shouldOverrideCopyOperation(Collection eObjects, Map hintMap);

    /**
     * Obtains an override for the specified paste operation.  This method is
     * called immediately after
     * {@link #shouldOverrideChildPasteOperation(EObject, EObject)}, and then
     * only if the latter returned <code>true</code>.
     * 
     * @param overriddenChildPasteOperation the paste operation to override
     * @return the overriding paste operation, or <code>null</code> if it is not
     *      appropriate to override (only in the case that
     *      <code>shouldOverrideChildPasteOperation()</code> was <code>false</code>)
     * 
     * @see #shouldOverrideChildPasteOperation(EObject, EObject)
     */
    OverridePasteChildOperation getOverrideChildPasteOperation(
            PasteChildOperation overriddenChildPasteOperation);

    /**
     * Obtains an override for the specified copy operation.  This method is
     * called immediately after
     * {@link #shouldOverrideCopyOperation(Collection, Map)}, and then
     * only if the latter returned <code>true</code>.
     * 
     * @param overriddenCopyOperation the copy operation to override
     * @return the overriding copy operation, or <code>null</code> if it is not
     *      appropriate to override (only in the case that
     *      <code>shouldOverrideCopyOperation()</code> was <code>false</code>)
     * 
     * @see #shouldOverrideChildPasteOperation(EObject, EObject)
     */
    OverrideCopyOperation getOverrideCopyOperation(
            CopyOperation overriddenCopyOperation);

    /**
     * Queries whether any of a set of {@link EObject}s, or any objects
     * contained in their sub-trees,
     * should be excluded altogether from the copy operation.  These objects
     * will not be copied.  It is up to the receiver to explicitly search the
     * <code>eObjects</code> recursively for exclusions.
     * 
     * @param eObjects the objects considered for copying
     * @return collection of object that we should not copy, or empty if none
     */
    Collection getExcludedCopyObjects(Set eObjects);
    
    /**
     * Obtains the resource containing an <code>eObject</code> or, if the
     * <code>eObject</code> is to be copied but is not attached to a resource,
     * the resource containing some related element that the detached
     * <code>eObject</code> would otherwise have been in.
     * 
     * @param eObject the object for which we need the associated resource
     * @return the containing resource or, if the <code>eObject</code> is
     *     detached, some resource from which it is reachable via some
     *     other attached object
     */
    XMLResource getResource(EObject eObject);
    
    /**
     * Queries whether an <code>eObject</code> should have a reference to the
     * corresponding original element save along with a record of the original
     * containment feature.  All original top-level copy objects must have
     * this information saved.  As for their children (recursively), it is
     * optional.
     * 
     * @param eObject the eObject to query whether the containment feature
     *     should be saved
     * @return whether that feature information should be saved
     */
    boolean shouldSaveContainmentFeature(EObject eObject);
    
    /**
     *Performs what is necessary by the target paste model for the newly pasted elements
     *This because we disable the semantic procedures, and they used to handle migration
     *of profiles. now this function will end up doing that.
     * 
     * @param pastedEObjects the pasted objects to process     
     */
    void performPostPasteProcessing(Set pastedEObjects);
    
    /**
     * Queries whether an <code>eObject</code>'s metamodel supports the concept
     * of "naming" the <code>eObject</code>.  The "name" of an element may be
     * assigned to copies with an adornment (e.g., "Copy of " as done by a
     * certain well-known file system).
     * 
     * @param eObject an <code>EObject</code>
     * @return whether the <code>eObject</code> supports a "name" of some kind
     * 
     * @see #getName(EObject)
     * @see #setName(EObject, String)
     */
    boolean isNameable(EObject eObject);
    
    /**
     * Obtains the "name" of an element, if the metamodel supports the
     * concept of naming elements and this <code>eObject</code> has a name.
     * 
     * @param eObject an element
     * @return the element's "name" if it has any, or <code>null</code> if not
     * 
     * @see #isNameable(EObject)
     */
    String getName(EObject eObject);
    
    /**
     * Sets the "name" of an element, if the metamodel supports the
     * concept of naming elements and this <code>eObject</code> is nameable.
     * 
     * @param eObject an element
     * @param name the element's new "name", or <code>null</code> to clear it
     * 
     * @throws IllegalArgumentException if the <code>eObject</code> is not
     *      nameable
     * 
     * @see #isNameable(EObject)
     */
    void setName(EObject eObject, String name);
    
    /**
     * Destroys an <code>eObject</code>, to ensure that it no longer exists in
     * its containing resource.  At a minimum, this method must remove the
     * <code>eObject</code> from its container.  It may also do more, such as
     * cleaning up references to the <code>eObject</code>.
     * 
     * @param eObject the object to be destroyed
     */
    void destroy(EObject eObject);
    
    /**
     * Sends a notification that an <code>eObject</code> was created in its
     * host editing domain.  This is an optional operation, for those
     * applications that support the "create" notification type that is
     * currently deprecated in EMF.
     * 
     * @param eObject an object newly created in the editing domain
     */
    void sendCreateNotification(EObject eObject);

	/**
	 * Queries whether an object can contain an object of a given type
	 * in a specified containment reference.  The containment conditions
	 * may be stricter than merely conformance to the declared type of the
	 * containment reference.
	 * 
	 * @param container a prospective containing object
	 * @param reference the containment reference to check
	 * @param containedType the type of the prospective contained object
	 * 
	 * @return <code>true</code> if an element of the specified type is
	 *     permitted to be contained as indicated; <code>false</code>, otherwise
	 */
	boolean canContain(EObject container, EReference reference, EClass containedType);
}