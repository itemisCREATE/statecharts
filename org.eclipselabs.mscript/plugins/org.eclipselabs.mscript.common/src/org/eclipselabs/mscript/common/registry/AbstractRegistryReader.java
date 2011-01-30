/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.mscript.common.registry;

import java.util.Arrays;
import java.util.Comparator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

/**
 * Template implementation of a registry reader that creates objects
 * representing registry contents. Typically, an extension contains one element,
 * but this reader handles multiple elements per extension.
 * 
 * To start reading the extensions from the registry for an extension point,
 * call the method <code>readRegistry</code>.
 * 
 * To read children of an IConfigurationElement, call the method
 * <code>readElementChildren</code> from your implementation of the method
 * <code>readElement</code>, as it will not be done by default.
 */
public abstract class AbstractRegistryReader {

	/**
	 * The constructor.
	 */
	protected AbstractRegistryReader() {
	}
	
	protected abstract String getPluginId();
	protected abstract ILog getLog();

	protected void logError(IConfigurationElement element, String text) {
		logError(element, text, null);
	}
	
	protected void logError(IConfigurationElement element, String text, Throwable exception) {
		IExtension extension = element.getDeclaringExtension();
		StringBuffer sb = new StringBuffer();
		sb.append("Plugin " + extension.getContributor().getName() + ", extension " + extension.getExtensionPointUniqueIdentifier()); //$NON-NLS-2$//$NON-NLS-1$
		// look for an ID if available - this should help debugging
		String id = element.getAttribute(IRegistryConstants.ATT_ID); //$NON-NLS-1$
		if (id != null) {
			sb.append(", id "); //$NON-NLS-1$
			sb.append(id);
		}
		sb.append(": " + text); //$NON-NLS-1$
		getLog().log(new Status(IStatus.ERROR, getPluginId(), sb.toString(), exception));
	}

	/**
	 * Logs a very common registry error when a required attribute is missing.
	 */
	protected void logMissingAttribute(IConfigurationElement element, String attributeName) {
		logError(element, "Required attribute '" + attributeName + "' not defined"); //$NON-NLS-2$//$NON-NLS-1$
	}

	/**
	 * Logs a very common registry error when a required child is missing.
	 */
	protected void logMissingElement(IConfigurationElement element, String elementName) {
		logError(element, "Required sub element '" + elementName + "' not defined"); //$NON-NLS-2$//$NON-NLS-1$
	}

	/**
	 * Logs a registry error when the configuration element is unknown.
	 */
	protected void logUnknownElement(IConfigurationElement element) {
		logError(element, "Unknown extension tag found: " + element.getName()); //$NON-NLS-1$
	}

	/**
	 * Apply a reproducible order to the list of extensions provided, such that
	 * the order will not change as extensions are added or removed.
	 * 
	 * @param extensions
	 *            the extensions to order
	 * @return ordered extensions
	 */
	public static IExtension[] orderExtensions(IExtension[] extensions) {
		// By default, the order is based on plug-in id sorted
		// in ascending order. The order for a plug-in providing
		// more than one extension for an extension point is
		// dependent in the order listed in the XML file.
		IExtension[] sortedExtension = new IExtension[extensions.length];
		System.arraycopy(extensions, 0, sortedExtension, 0, extensions.length);
		Comparator<IExtension> comparer = new Comparator<IExtension>() {
			
			public int compare(IExtension extension1, IExtension extension2) {
				String s1 = extension1.getNamespaceIdentifier();
				String s2 = extension2.getNamespaceIdentifier();
				return s1.compareToIgnoreCase(s2);
			}
			
		};
		Arrays.sort(sortedExtension, comparer);
		return sortedExtension;
	}

	/**
	 * Implement this method to read element's attributes. If children should
	 * also be read, then implementor is responsible for calling
	 * <code>readElementChildren</code>. Implementor is also responsible for
	 * logging missing attributes.
	 * 
	 * @return true if element was recognized, false if not.
	 */
	protected abstract boolean readElement(IConfigurationElement element);

	/**
	 * Read the element's children. This is called by the subclass' readElement
	 * method when it wants to read the children of the element.
	 */
	protected void readElementChildren(IConfigurationElement element) {
		readElements(element.getChildren());
	}

	/**
	 * Read each element one at a time by calling the subclass implementation of
	 * <code>readElement</code>.
	 * 
	 * Logs an error if the element was not recognized.
	 */
	protected void readElements(IConfigurationElement[] elements) {
		for (int i = 0; i < elements.length; i++) {
			if (!readElement(elements[i])) {
				logUnknownElement(elements[i]);
			}
		}
	}

	/**
	 * Read one extension by looping through its configuration elements.
	 */
	protected void readExtension(IExtension extension) {
		readElements(extension.getConfigurationElements());
	}

	/**
	 * Start the registry reading process using the supplied plugin ID and
	 * extension point.
	 * 
	 * @param registry
	 *            the registry to read from
	 * @param pluginId
	 *            the plugin id of the extenion point
	 * @param extensionPoint
	 *            the extension point id
	 */
	public void readRegistry(IExtensionRegistry registry, String extensionPoint) {
		IExtensionPoint point = registry.getExtensionPoint(getPluginId(), extensionPoint);
		if (point == null) {
			return;
		}
		IExtension[] extensions = point.getExtensions();
		extensions = orderExtensions(extensions);
		for (int i = 0; i < extensions.length; i++) {
			readExtension(extensions[i]);
		}
	}
	
	protected String getRequiredAttribute(IConfigurationElement element, String name) {
		String value = element.getAttribute(name);
		if (value == null) {
			logMissingAttribute(element, name);
		}
		return value;
	}

	public <T> T createExecutableExtension(IConfigurationElement element, String attributeName, Class<T> clazz) {
        try {
			Object o = element.createExecutableExtension(attributeName);
			if (clazz.isInstance(o)) {
				return clazz.cast(o);
			} else {
				logError(element, "Specified class in attribute '" + attributeName + "' must be instance of " + clazz.getName());
			}
		} catch (CoreException e) {
			logError(element, "Specified class in attribute '" + attributeName + "' could not be created", e);
		}
		return null;
	}

	/**
	 * Utility for extracting the description child of an element.
	 * 
	 * @param element
	 *            the element
	 * @return the description
	 * @since 3.1
	 */
	public static String getDescription(IConfigurationElement element) {
		IConfigurationElement[] children = element.getChildren(IRegistryConstants.TAG_DESCRIPTION);
		if (children.length >= 1) {
			return children[0].getValue();
		}
		return ""; //$NON-NLS-1$
	}

	/**
	 * Utility for extracting the value of a class attribute or a nested class
	 * element that follows the pattern set forth by
	 * {@link org.eclipse.core.runtime.IExecutableExtension}.
	 * 
	 * @param element
	 *            the element
	 * @param classAttributeName
	 *            the name of the class attribute to check
	 * @return the value of the attribute or nested class element
	 * @since 3.1
	 */
	public static String getClassValue(IConfigurationElement element, String classAttributeName) {
		String className = element.getAttribute(classAttributeName);
		if (className != null) {
			return className;
		}
		IConfigurationElement[] candidateChildren = element.getChildren(classAttributeName);
		if (candidateChildren.length == 0) {
			return null;
		}

		return candidateChildren[0].getAttribute(IRegistryConstants.ATT_CLASS);
	}
		
}
