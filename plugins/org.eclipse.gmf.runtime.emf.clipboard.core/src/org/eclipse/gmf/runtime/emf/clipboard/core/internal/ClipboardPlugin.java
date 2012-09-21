/******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/
package org.eclipse.gmf.runtime.emf.clipboard.core.internal;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.osgi.framework.BundleContext;

/**
 * The main plugin class to be used in the desktop.
 */
public class ClipboardPlugin extends EMFPlugin {
	//TODO This plugin class contains many of the tracing options in common with other plugins. Perhaps these should be conglomerated so that they share alot of this code?
	
	///
	// TRACING STRINGS
	//
	
	/**
	 * String containing an open parenthesis.
	 * 
	 */
	protected static final String PARENTHESIS_OPEN = "("; //$NON-NLS-1$

	/**
	 * String containing a close parenthesis.
	 * 
	 */
	protected static final String PARENTHESIS_CLOSE = ")"; //$NON-NLS-1$

	/**
	 * Prefix for tracing the changing of values.
	 * 
	 */
	protected static final String PREFIX_CHANGING = "CHANGING "; //$NON-NLS-1$
	
	/**
	 * Prefix for tracing the catching of throwables.
	 * 
	 */
	protected static final String PREFIX_CATCHING = "CAUGHT "; //$NON-NLS-1$

	/**
	 * Prefix for tracing the throwing of throwables.
	 * 
	 */
	protected static final String PREFIX_THROWING = "THROWN "; //$NON-NLS-1$

	/**
	 * Prefix for tracing the entering of methods.
	 * 
	 */
	protected static final String PREFIX_ENTERING = "ENTERING "; //$NON-NLS-1$

	/**
	 * Prefix for tracing the exiting of methods.
	 * 
	 */
	protected static final String PREFIX_EXITING = "EXITING "; //$NON-NLS-1$

	/**
	 * Separator for methods.
	 * 
	 */
	protected static final String SEPARATOR_METHOD = "#"; //$NON-NLS-1$

	/**
	 * Separator for parameters.
	 * 
	 */
	protected static final String SEPARATOR_PARAMETER = ", "; //$NON-NLS-1$

	/**
	 * Separator for return values.
	 * 
	 */
	protected static final String SEPARATOR_RETURN = ":"; //$NON-NLS-1$

	/**
	 * Separator containing a space.
	 * 
	 */
	protected static final String SEPARATOR_SPACE = " "; //$NON-NLS-1$
	
	/**
	 * Label indicating old value.
	 * 
	 */
	protected static final String LABEL_OLD_VALUE = "old="; //$NON-NLS-1$

	/**
	 * Label indicating new value.
	 * 
	 */
	protected static final String LABEL_NEW_VALUE = "new="; //$NON-NLS-1$

    /**
     * The shared plug-in instance.
     */
    public static final ClipboardPlugin INSTANCE = new ClipboardPlugin();

    private static Implementation plugin;
    
	/** IClipboardSupport extension point ID. */
	public static final String EXTPT_CLIPBOARDSUPPORT = "clipboardSupport"; //$NON-NLS-1$

    /**
     * Initializes me.
     */
    public ClipboardPlugin() {
        super(new ResourceLocator[] {});
    }

    public ResourceLocator getPluginResourceLocator() {
        return plugin;
    }

    /**
     * Gets the shared Eclipse plug-in implementation.
     * 
     * @return the shared implementation plug-in
     */
    public static Implementation getPlugin() {
        return plugin;
    }

    /**
     * The Eclipse plug-in implementation that represents the EMF plug-in.
     */
    public static class Implementation extends EclipsePlugin {
    	
    	/** Initializes me. */
        public Implementation() {
            super();

            // Remember the static instance.
            //
            plugin = this;
        }
        
		public void start(BundleContext context) throws Exception {
			super.start(context);

			configureClipboardSupport();
		}

		private void configureClipboardSupport() {
			ClipboardSupportManager.configureExtensions(Platform
				.getExtensionRegistry().getConfigurationElementsFor(
					ClipboardSupportManager.EP_CLIPBOARD_SUPPORT));
		}
    }
    
    public static class Tracing {
    	/**
    	 * The cached debug options (for optimization).
    	 */
    	private static final Map cachedOptions = new HashMap();

    	/**
    	 * Retrieves a Boolean value indicating whether tracing is enabled.
    	 * 
    	 * @return Whether tracing is enabled for the plug-in.
    	 * 
    	 */
    	protected static boolean shouldTrace() {
    		return plugin.isDebugging();
    	}

    	/**
    	 * Retrieves a Boolean value indicating whether tracing is enabled for the
    	 * specified debug option.
    	 * 
    	 * @return Whether tracing is enabled for the debug option of the plug-in.
    	 * @param option The debug option for which to determine trace enablement.
    	 * 
    	 */
    	public static boolean shouldTrace(String option) {
    		if (shouldTrace()) {
    			Boolean value = null;
    			
    			synchronized (cachedOptions) {
    				value = (Boolean) cachedOptions.get(option);
    	
    				if (null == value) {
    					value =
    						Boolean.valueOf(
    							Boolean.TRUE.toString().equalsIgnoreCase(
    								org.eclipse.core.runtime.Platform.getDebugOption(option)));
    	
    					cachedOptions.put(option, value);
    				}
    			}
    			
    			return value.booleanValue();
    		}

    		return false;
    	}

    	/**
    	 * Retrieves a textual representation of the specified argument.
    	 * 
    	 * @return A textual representation of the specified argument.
    	 * @param argument The argument for which to retrieve a textual
    	 *                  representation.
    	 * 
    	 */
    	protected static String getArgumentString(Object argument) {
    		return String.valueOf(argument);
    	}

    	/**
    	 * Retrieves a textual representation of the specified arguments.
    	 * 
    	 * @return A textual representation of the specified arguments.
    	 * @param arguments The arguments for which to retrieve a textual
    	 *                   representation.
    	 * 
    	 */
    	protected static String getArgumentsString(Object[] arguments) {
    		StringBuffer buffer = new StringBuffer();

    		for (int i = 0; i < arguments.length; i++) {
    			buffer.append(getArgumentString(arguments[i]));

    			if (i < arguments.length - 1) {
    				buffer.append(SEPARATOR_PARAMETER);
    			}
    		}

    		return buffer.toString();
    	}

    	/**
    	 * Traces the specified message.
    	 * 
    	 * @param message The message to be traced.
    	 * 
    	 */
    	public static void trace(String message) {
    		if (shouldTrace()) {
    			System.out.println(message);
    		}
    	}

    	/**
    	 * Traces the specified message for the specified
    	 * debug option.
    	 * 
    	 * @param option The debug option for which to trace.
    	 * @param message The message to be traced.
    	 * 
    	 */
    	public static void trace(String option, String message) {
    		if (shouldTrace(option)) {
    			trace(message);
    		}
    	}
    	
    	/**
    	 * Traces the changing of a value.
    	 * 
    	 * @param option The debug option for which to trace.
    	 * @param valueDescription The description of the value which is changing.
    	 * @param oldValue The old value.
    	 * @param newValue The new value.
    	 */
    	public static void changing(
    	        String option,
    	        String valueDescription,
    	        Object oldValue,
    	        Object newValue) {
    		    
    	        if (shouldTrace(option)) {
    	            trace(
    	                PREFIX_CHANGING
    	                	+ valueDescription
    	                	+ SEPARATOR_SPACE
    	                	+ LABEL_OLD_VALUE
    	                	+ getArgumentString(oldValue)
    	                	+ SEPARATOR_PARAMETER
    	                   	+ LABEL_NEW_VALUE
    	                	+ getArgumentString(newValue)
    						);
    	        }
    	    }
    	
    	/**
    	 * 
    	 * @param option The debug option for which to trace.
    	 * @param clazz The class in which the value is changing.
    	 * @param methodName The name of the method in which the value is changing.
    	 * @param valueDescription The description of the value which is changing.
    	 * @param oldValue The old value.
    	 * @param newValue The new value.
    	 */
    	public static void changing(
            String option,
            Class clazz,
            String methodName,
            String valueDescription,
            Object oldValue,
            Object newValue) {
    	    
            if (shouldTrace(option)) {
                trace(
                    PREFIX_CHANGING
                    	+ valueDescription
                    	+ SEPARATOR_SPACE
                    	+ LABEL_OLD_VALUE
                    	+ getArgumentString(oldValue)
                    	+ SEPARATOR_PARAMETER
                       	+ LABEL_NEW_VALUE
                    	+ getArgumentString(newValue)
                    	+ SEPARATOR_SPACE
                    	+ PARENTHESIS_OPEN
    					+ clazz.getName()
    					+ SEPARATOR_METHOD
    					+ methodName
    					+ PARENTHESIS_CLOSE
    					);
            }
        }

    	/**
    	 * Traces the catching of the specified throwable in the specified method of
    	 * the specified class.
    	 * 
    	 * @param option The debug option for which to trace.
    	 * @param clazz The class in which the throwable is being caught.
    	 * @param methodName The name of the method in which the throwable is being
    	 *                    caught.
    	 * @param throwable The throwable that is being caught.
    	 * 
    	 */
    	public static void catching(
    		String option,
    		Class clazz,
    		String methodName,
    		Throwable throwable) {

    		if (shouldTrace(option)) {

    			trace(
    				PREFIX_CATCHING
    					+ throwable.getMessage()
    					+ SEPARATOR_SPACE
    					+ PARENTHESIS_OPEN
    					+ clazz.getName()
    					+ SEPARATOR_METHOD
    					+ methodName
    					+ PARENTHESIS_CLOSE);

    			throwable.printStackTrace(System.err);
    		}
    	}

    	/**
    	 * Traces the throwing of the specified throwable from the specified method
    	 * of the specified class.
    	 * 
    	 * @param option The debug option for which to trace.
    	 * @param clazz The class from which the throwable is being thrown.
    	 * @param methodName The name of the method from which the throwable is
    	 *                    being thrown.
    	 * @param throwable The throwable that is being thrown.
    	 * 
    	 */
    	public static void throwing(
    		String option,
    		Class clazz,
    		String methodName,
    		Throwable throwable) {

    		if (shouldTrace(option)) {

    			trace(
    				PREFIX_THROWING
    					+ throwable.getMessage()
    					+ SEPARATOR_SPACE
    					+ PARENTHESIS_OPEN
    					+ clazz.getName()
    					+ SEPARATOR_METHOD
    					+ methodName
    					+ PARENTHESIS_CLOSE);

    			throwable.printStackTrace(System.err);
    		}
    	}

    	/**
    	 * Traces the entering into the specified method of the specified class.
    	 * 
    	 * @param option The debug option for which to trace.
    	 * @param clazz The class whose method is being entered.
    	 * @param methodName The name of method that is being entered.
    	 * 
    	 */
    	public static void entering(
    		String option,
    		Class clazz,
    		String methodName) {

    		if (shouldTrace(option)) {

    			trace(
    				PREFIX_ENTERING
    					+ clazz.getName()
    					+ SEPARATOR_METHOD
    					+ methodName);
    		}
    	}

    	/**
    	 * Traces the entering into the specified method of the specified class,
    	 * with the specified parameter.
    	 * 
    	 * @param option The debug option for which to trace.
    	 * @param clazz The class whose method is being entered.
    	 * @param methodName The name of method that is being entered.
    	 * @param parameter The parameter to the method being entered.
    	 * 
    	 */
    	public static void entering(
    		String option,
    		Class clazz,
    		String methodName,
    		Object parameter) {

    		if (shouldTrace(option)) {

    			trace(
    				PREFIX_ENTERING
    					+ clazz.getName()
    					+ SEPARATOR_METHOD
    					+ methodName
    					+ PARENTHESIS_OPEN
    					+ getArgumentString(parameter)
    					+ PARENTHESIS_CLOSE);
    		}
    	}

    	/**
    	 * Traces the entering into the specified method of the specified class,
    	 * with the specified parameters.
    	 * 
    	 * @param option The debug option for which to trace.
    	 * @param clazz The class whose method is being entered.
    	 * @param methodName The name of method that is being entered.
    	 * @param parameters The parameters to the method being entered.
    	 * 
    	 */
    	public static void entering(
    		String option,
    		Class clazz,
    		String methodName,
    		Object[] parameters) {

    		if (shouldTrace(option)) {

    			trace(
    				PREFIX_ENTERING
    					+ clazz.getName()
    					+ SEPARATOR_METHOD
    					+ methodName
    					+ PARENTHESIS_OPEN
    					+ getArgumentsString(parameters)
    					+ PARENTHESIS_CLOSE);
    		}
    	}

    	/**
    	 * Traces the exiting from the specified method of the specified class.
    	 * 
    	 * @param option The debug option for which to trace.
    	 * @param clazz The class whose method is being exited.
    	 * @param methodName The name of method that is being exited.
    	 * 
    	 */
    	public static void exiting(
    		String option,
    		Class clazz,
    		String methodName) {

    		if (shouldTrace(option)) {

    			trace(
    				PREFIX_EXITING
    					+ clazz.getName()
    					+ SEPARATOR_METHOD
    					+ methodName);
    		}
    	}

    	/**
    	 * Traces the exiting from the specified method of the specified class,
    	 * with the specified return value.
    	 * 
    	 * @param option The debug option for which to trace.
    	 * @param clazz The class whose method is being exited.
    	 * @param methodName The name of method that is being exited.
    	 * @param returnValue The return value of the method being exited.
    	 * 
    	 */
    	public static void exiting(
    		String option,
    		Class clazz,
    		String methodName,
    		Object returnValue) {

    		if (shouldTrace(option)) {

    			trace(
    				PREFIX_EXITING
    					+ clazz.getName()
    					+ SEPARATOR_METHOD
    					+ methodName
    					+ SEPARATOR_RETURN
    					+ getArgumentString(returnValue));
    		}
    	}
    }

	public static void catching(Class class1, String functionName, Throwable exception) {
		Tracing.catching(ClipboardDebugOptions.EXCEPTIONS_CATCHING, class1, functionName, exception);
	}
	
	public static void throwing(Class class1, String functionName, Throwable exception) {
		Tracing.throwing(ClipboardDebugOptions.EXCEPTIONS_THROWING, class1, functionName, exception);
	}

	public static void log(int code, String message, Throwable exception) {
		Status s = new Status(IStatus.INFO, plugin.getSymbolicName(),
			code, message != null ? message : "", exception); //$NON-NLS-1$
		
		getPlugin().log(s);
	}

	public static void warning(int code, String message, Throwable exception) {
		Status s = new Status(IStatus.WARNING, plugin.getSymbolicName(),
			code, message != null ? message : "", exception); //$NON-NLS-1$
		
		getPlugin().log(s);
	}
}
