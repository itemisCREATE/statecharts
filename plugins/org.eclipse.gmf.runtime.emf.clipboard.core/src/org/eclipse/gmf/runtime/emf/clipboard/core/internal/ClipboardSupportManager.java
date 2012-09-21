/******************************************************************************
 * Copyright (c) 2005, 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/


package org.eclipse.gmf.runtime.emf.clipboard.core.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gmf.runtime.common.core.util.Proxy;
import org.eclipse.gmf.runtime.emf.clipboard.core.IClipboardSupportFactory;
import org.eclipse.gmf.runtime.emf.clipboard.core.IClipboardSupportPolicy;
import org.eclipse.gmf.runtime.emf.clipboard.core.internal.l10n.EMFClipboardCoreMessages;
import org.eclipse.osgi.util.NLS;


/**
 * Manager for the <tt>clipboardSupport</tt> extension point.
 *
 * @author Christian W. Damus (cdamus), crevells
 */
public class ClipboardSupportManager {
	public static final String EP_CLIPBOARD_SUPPORT = "org.eclipse.gmf.runtime.emf.clipboard.core.clipboardSupport"; //$NON-NLS-1$
	static final String E_NSURI = "nsURI"; //$NON-NLS-1$
	static final String E_CLASS = "class"; //$NON-NLS-1$
	static final String E_POLICY = "policy"; //$NON-NLS-1$
	
	/** @deprecated need a context-based solution */
	static final String E_PRIORITY = "priority"; //$NON-NLS-1$
	
	/** @deprecated need a context-based solution */
	private static final List PRIORITIES = Arrays.asList(new String[] {
		"lowest", "low", "medium", "high", "highest"});  //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$//$NON-NLS-4$//$NON-NLS-5$
	
	/** An array of lists of descriptors for each priority, index by priority. */
	private static ArrayList[] descriptors; 
	
	/**
	 * Wraps an {@link EObject} to adapt it to the {@link IAdaptable} Eclipse
	 * platform API. This is useful for passing <code>EObject</code>s into APIs
	 * that consume adaptables.
	 */
	private static class EObjectAdapter extends Proxy implements IAdaptable {

		public EObjectAdapter(EObject element) {
			super(element);
		}

		/**
		 * Returns the wrapped {@link EObject} as the adapter when possible. The
		 * following adaptations are supported:
		 * <ul>
		 * <li>if the wrapped <code>EObject</code> conforms to the
		 * <code>adapter</code> type, then it is returned</li>
		 * <li>if this adapter, itself, conforms to the <code>adapter</code>
		 * type, then it is returned</li>
		 * <li>otherwise, there is no adapter (<code>null</code> returned)</li>
		 * </ul>
		 */
		public Object getAdapter(Class adapter) {
			if (adapter.isInstance(getRealObject())) {
				return getRealObject();
			}
			if (adapter.isInstance(this)) {
				return this;
			}
			return null;
		}
	}

	/** Not instantiable by clients. */
	private ClipboardSupportManager() {
		super();
	}

	/**
	 * Configures the extensions on the <tt>clipboardSupport</tt> extension
	 * point.
	 * <p>
	 * <b>Note</b> that this method must only be called by the plug-in class
	 * on initialization.
	 * </p>
	 * 
	 * @param configs the configuration elements representing extensions
	 */
	public static void configureExtensions(IConfigurationElement[] configs) {
		
		// initialize the arrays
		descriptors = new ArrayList[PRIORITIES.size()];
		for (int i = 0; i < PRIORITIES.size(); i++) {
			descriptors[i] = new ArrayList(0);
		}
		
		// create each descriptor and add to appropriate list
		for (int i = 0; i < configs.length; i++) {
			try {
				Descriptor desc = new Descriptor(configs[i]);
				descriptors[desc.getPriority()].add(desc);
			} catch (CoreException e) {
				ClipboardPlugin.getPlugin().log(e.getStatus());
			}
		}
	}
	
	/**
	 * Retrieves the clipboard support factory (if any) that handles the
	 * specified <code>EPackage</code>.
	 * <p>
	 * <b>WARNING: DO NOT USE.</b> Calling this method does not support the full
	 * extensibility capabilities of the ClipboardSupport extension point. Use
	 * the method {@link #lookup(EObject)} instead.
	 * 
	 * @param ePackage an <code>EPackage</code>
	 * @return the registered clipboard support factory, or <code>null</code>
	 *     if none was registered or it could not be initialized
	 */
	public static IClipboardSupportFactory lookup(EPackage ePackage) {
		for (int i = PRIORITIES.size() - 1; i >= 0; i--) {

			List descriptorsAtPriorityN = descriptors[i];
			int size = descriptorsAtPriorityN.size();

			for (int j = 0; j < size; j++) {
				Descriptor descriptor = (Descriptor) descriptorsAtPriorityN
						.get(j);
				if (descriptor.provides(ePackage)) {
					return descriptor.getFactory();
				}
			}
		}

		return null;
	}
	
	/**
	 * Retrieves the clipboard support factory (if any) that handles the
	 * specified <code>EClass</code>.
	 * <p>
	 * <b>WARNING: DO NOT USE.</b> Calling this method does not support the full
	 * extensibility capabilities of the ClipboardSupport extension point. Use
	 * the method {@link #lookup(EObject)} instead.
	 * 
	 * @param eClass an <code>EClass</code>
	 * @return the registered clipboard support factory, or <code>null</code>
	 *     if none was registered or it could not be initialized
	 */
	public static IClipboardSupportFactory lookup(EClass eClass) {
		return lookup(eClass.getEPackage());
	}
	
	/**
	 * Retrieves the clipboard support factory (if any) that handles the
	 * specified <code>EObject</code>.
	 * 
	 * @param eObject an <code>EObject</code>
	 * @return the registered clipboard support factory, or <code>null</code>
	 *     if none was registered or it could not be initialized
	 */
	public static IClipboardSupportFactory lookup(EObject eObject) {
		for (int i = PRIORITIES.size() - 1; i >= 0; i--) {

			List descriptorsAtPriorityN = descriptors[i];
			int size = descriptorsAtPriorityN.size();

			for (int j = 0; j < size; j++) {
				Descriptor descriptor = (Descriptor) descriptorsAtPriorityN
						.get(j);
				if (descriptor.provides(eObject)) {
					return descriptor.getFactory();
				}
			}
		}

		return null;
	}
	
	/**
	 * Creates an error status with the specified <code>message</code>.
	 * 
	 * @param code the error code
	 * @param message the error message
	 * @return the status object
	 */
	static IStatus createErrorStatus(int code, String message) {
		return createErrorStatus(
			code,
			message,
			null);
	}
	
	/**
	 * Creates an error status with the specified <code>message</code>.
	 * 
	 * @param code the error code
	 * @param message the error message
	 * @param exception an exception to log
	 * @return the status object
	 */
	static IStatus createErrorStatus(int code, String message, Throwable exception) {
		return new Status(
			IStatus.ERROR,
			ClipboardPlugin.getPlugin().getSymbolicName(),
			code,
			message,
			exception);
	}
	
	/**
	 * Descriptor for an extension on the <tt>clipboardSupport</tt> point.
	 * The descriptor is responsible for lazily initializing the
	 * {@link IClipboardSupportFactory} on its first access.
	 *
	 * @author Christian W. Damus (cdamus)
	 */
	private static final class Descriptor {
		private EPackage ePackage = null;
		private IClipboardSupportFactory factory;
		private IClipboardSupportPolicy policy;
		private IConfigurationElement config;
		private int priority = 2;
		
		private boolean factoryClassInitialized = false;
		private boolean policyClassInitialized = false;
		
		Descriptor(IConfigurationElement config) throws CoreException {
			this.config = config;
			
			String nsUri = config.getAttribute(E_NSURI);
			if (nsUri != null && nsUri.length() > 0) {
				ePackage = EPackage.Registry.INSTANCE.getEPackage(nsUri);
				if (ePackage == null) {
					throw new CoreException(createErrorStatus(
						ClipboardStatusCodes.CLIPBOARDSUPPORT_UNRESOLVED_NSURI,
						NLS.bind(EMFClipboardCoreMessages.unresolved_nsUri_ERROR_,
							new Object[] {
								ClipboardPlugin.EXTPT_CLIPBOARDSUPPORT,
								nsUri,
								config.getDeclaringExtension().getNamespaceIdentifier()})));
				}
			} else {
				// there needs to be either an nsURI specified or a policy class
				String policy = config.getAttribute(E_POLICY);
				if ((policy == null) || (policy.length() == 0)) {
					throw new CoreException(createErrorStatus(
							ClipboardStatusCodes.CLIPBOARDSUPPORT_MISSING_CLASS,
							NLS.bind(EMFClipboardCoreMessages.missing_nsUri_ERROR_,
								new Object[] {
									ClipboardPlugin.EXTPT_CLIPBOARDSUPPORT,
									config.getDeclaringExtension().getNamespaceIdentifier()})));					
				}
			}
			
			String className = config.getAttribute(E_CLASS);
			if ((className == null) || (className.length() == 0)) {
				throw new CoreException(createErrorStatus(
					ClipboardStatusCodes.CLIPBOARDSUPPORT_MISSING_CLASS,
					NLS.bind(EMFClipboardCoreMessages.missing_class_ERROR_,
						new Object[] {
							ClipboardPlugin.EXTPT_CLIPBOARDSUPPORT,
							config.getDeclaringExtension().getNamespaceIdentifier()})));
			}
			
			String priorityStr = config.getAttribute(E_PRIORITY);
			if (priorityStr != null) {
				priorityStr = priorityStr.toLowerCase();
				
				if (PRIORITIES.contains(priorityStr)) {
					priority = PRIORITIES.indexOf(priorityStr);
				}
			}
		}

		/**
		 * Determines if this descriptor provides for the given EPackage by
		 * comparing its nsURI with the nsURI attribute field. In this case, the
		 * policy class is not consulted at all.
		 * 
		 * @param ePackage the ePackage in question
		 * @return true if this descriptor provides for the given ePackage
		 */
		private boolean provides(EPackage ePackage) {
			return (ePackage != null && ePackage.equals(getEPackage()));
		}
		
		/**
		 * Determines if this descriptor provides for the given EObject by
		 * consulting the policy class if there is one provided. If there is no
		 * policy class provided, then the {@link #provides(EPackage)} method is
		 * called with the EPackage of the given EObject.
		 * 
		 * @param eObject
		 *            the eObject in question
		 * @return true if this descriptor provides for the given eObject
		 */
		private boolean provides(EObject eObject) {
			policy = getPolicy();

			if (policy != null) {
				try {
					return policy.provides(new EObjectAdapter(eObject));
				} catch (Throwable e) {
					ClipboardPlugin.getPlugin().log(createErrorStatus(
							ClipboardStatusCodes.CLIPBOARDSUPPORT_MISSING_CLASS,
							NLS.bind(EMFClipboardCoreMessages.missing_class_ERROR_,
								new Object[] {
									IClipboardSupportFactory.class.getName(),
									config.getAttribute(E_POLICY)}),
							e));
					
					// re-throw fatal errors
					if (e instanceof ThreadDeath) {
						throw (ThreadDeath) e;
					}

					if (e instanceof VirtualMachineError) {
						throw (VirtualMachineError) e;
					}

					return false;
				}
			}
			return provides(eObject.eClass().getEPackage());
		}
		
		EPackage getEPackage() {
			return ePackage;
		}
		
		/** @deprecated need a context-based solution */
		int getPriority() {
			return priority;
		}
		
		IClipboardSupportFactory getFactory() {
			if (factory == null && !factoryClassInitialized) {
				factoryClassInitialized = true;
				factory = createFactory();
			}
			
			return factory;
		}
		
		IClipboardSupportPolicy getPolicy() {
			if (policy == null && !policyClassInitialized) {
				policyClassInitialized = true;
				policy = createPolicy();
			}
			return policy;
		}
		
		private IClipboardSupportFactory createFactory() {
			IClipboardSupportFactory result = null;
			
			try {
				result = (IClipboardSupportFactory) config.createExecutableExtension(E_CLASS);
			} catch (CoreException e) {
				ClipboardPlugin.getPlugin().log(e.getStatus());
			} catch (Exception e) {
				// log any other exception, too (such as ClassCastException)
				ClipboardPlugin.getPlugin().log(createErrorStatus(
					ClipboardStatusCodes.CLIPBOARDSUPPORT_FACTORY_FAILED,
					NLS.bind(EMFClipboardCoreMessages.factory_failed_ERROR_,
						new Object[] {
							IClipboardSupportFactory.class.getName(),
							config.getAttribute(E_CLASS)}),
					e));
			} 
			
			return result;
		}
		
		private IClipboardSupportPolicy createPolicy() {
			IClipboardSupportPolicy result = null;
			
			String policyClassName = config.getAttribute(E_POLICY);
			if (policyClassName != null && policyClassName.length() > 0) {
				try {
					result = (IClipboardSupportPolicy) config.createExecutableExtension(E_POLICY);
				} catch (CoreException e) {
					ClipboardPlugin.getPlugin().log(e.getStatus());
				} catch (Exception e) {
					// log any other exception, too (such as ClassCastException)
					ClipboardPlugin.getPlugin().log(createErrorStatus(
						ClipboardStatusCodes.CLIPBOARDSUPPORT_MISSING_CLASS,
						NLS.bind(EMFClipboardCoreMessages.missing_class_ERROR_,
							new Object[] {
								IClipboardSupportFactory.class.getName(),
								config.getAttribute(E_POLICY)}),
						e));
				} 
			}
			
			return result;
		}
	}
}
