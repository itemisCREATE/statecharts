/******************************************************************************
 * Copyright (c) 2002, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.gmf.runtime.emf.clipboard.core.internal;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.UnresolvedReferenceException;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLLoad;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMILoadImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import org.eclipse.gmf.runtime.emf.clipboard.core.IClipboardSupport;

/**
 * @author Yasser Lulu
 */
public abstract class SerializationEMFResource
	extends XMIResourceImpl {

	// default load options.
	public static final Map LOAD_OPTIONS = new HashMap();

	// default save options.
	public static final Map SAVE_OPTIONS = new HashMap();

	static {

		XMIResource resource = new XMIResourceImpl();

		// default load options.
		LOAD_OPTIONS.putAll(resource.getDefaultLoadOptions());

		// default save options.
		SAVE_OPTIONS.putAll(resource.getDefaultSaveOptions());
		SAVE_OPTIONS.put(XMIResource.OPTION_DECLARE_XML, Boolean.TRUE);
		SAVE_OPTIONS.put(XMIResource.OPTION_PROCESS_DANGLING_HREF,
			XMIResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);
		SAVE_OPTIONS.put(XMIResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
		SAVE_OPTIONS.put(XMIResource.OPTION_USE_XMI_TYPE, Boolean.TRUE);
		SAVE_OPTIONS.put(XMIResource.OPTION_SAVE_TYPE_INFORMATION, Boolean.TRUE);
		SAVE_OPTIONS.put(XMIResource.OPTION_SKIP_ESCAPE_URI, Boolean.FALSE);
	}

	public static String SERIALIZATION_ANNOTATIONS = "serialization_annotations";//$NON-NLS-1$

	private IClipboardSupport clipboardOperationHelper;

	public SerializationEMFResource(String encoding,
		IClipboardSupport clipboardOperationHelper) {
		this(encoding, URI.createFileURI(""), //$NON-NLS-1$
			clipboardOperationHelper);
	}

	public SerializationEMFResource(String encoding, URI uri,
		IClipboardSupport clipboardOperationHelper) {
		super(uri);
		setEncoding(encoding);
		this.clipboardOperationHelper = clipboardOperationHelper;
	}

	protected final IClipboardSupport getClipboardOperationHelper() {
		return clipboardOperationHelper;
	}

	protected boolean useIDAttributes() {
		return false;
	}

	protected boolean useUUIDs() {
		return true;
	}

	protected XMLLoad createXMLLoad() {
		// return an XML Load that suppresses UnresolvedReferenceExceptions
		return new XMILoadImpl(createXMLHelper()) {

			public void load(XMLResource r, InputStream s, Map o)
				throws IOException {

				try {

					super.load(r, s, o);

				} catch (Resource.IOWrappedException e) {

					if (!(e.getCause() instanceof UnresolvedReferenceException))
						throw e;
				}
			}};
	}

	protected void unloaded(InternalEObject internalEObject) {
		//disable parent
	}

	/**
	 * @see org.eclipse.emf.common.notify.impl.NotifierImpl#eNotificationRequired()
	 */
	public boolean eNotificationRequired() {
		return false;
	}

	public void setIDToEObjectMap(Map idToEObjectMap) {
		this.idToEObjectMap = idToEObjectMap;
	}

	public void setEObjectToIDMap(Map eObjectToIDMap) {
		this.eObjectToIDMap = eObjectToIDMap;
	}

	protected void throwUnsupportedOperationException(String methodName,
		UnsupportedOperationException ex) {
		ClipboardPlugin.throwing(getClass(), methodName, ex);
		throw ex;
	}
}