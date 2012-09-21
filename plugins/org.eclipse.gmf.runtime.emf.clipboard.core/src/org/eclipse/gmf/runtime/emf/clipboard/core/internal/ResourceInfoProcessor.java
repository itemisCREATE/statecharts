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

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.clipboard.core.CopyObjects;
import org.eclipse.gmf.runtime.emf.clipboard.core.ObjectInfo;

import com.ibm.icu.util.StringTokenizer;


/**
 * Codec for the {@link ResourceInfo meta-data} stored with the resource that
 * is serialized to a string by the copy operation.  The meta-data are
 * implemented as XML comments following the <tt>&lt;XMI&gt;</tt> document
 * element.
 * 
 * @author Yasser Lulu
 * 
 * @see ResourceInfo 
 */
public class ResourceInfoProcessor {

	private static final String EMPTY_STRING = ""; //$NON-NLS-1$

	private static final String BEGIN_COMMENT = "<!-- "; //$NON-NLS-1$

	private static final String END_COMMENT = " -->"; //$NON-NLS-1$

	private static final String ENDL = "\n"; //$NON-NLS-1$

	private static final String SEPARATOR = "|"; //$NON-NLS-1$

	private static final String PLUS = "+"; //$NON-NLS-1$

	private static final String COMMA = ","; //$NON-NLS-1$	

	private static final String PROPERTY_DELIM = SEPARATOR + PLUS;	

	private static final String VERSION = "VERSION"; //$NON-NLS-1$

	private static final String VERSION_VALUE = "1.0"; //$NON-NLS-1$

	private static final String TYPE = "TYPE"; //$NON-NLS-1$

	private static final String TYPE_VALUE = "EMF"; //$NON-NLS-1$

	private static final String OFFSET = "OFFSET"; //$NON-NLS-1$

	private static final String ENCODING = "ENCODING"; //$NON-NLS-1$

	private static final String OBJ_ID = "OBJ_ID"; //$NON-NLS-1$

	private static final String OBJ_COPY_TYPE = "OBJ_COPY_TYPE"; //$NON-NLS-1$

	private static final String CONTAINER_ID = "CONTAINER_ID"; //$NON-NLS-1$

	private static final String CONTAINER_CLASS = "CONTAINER_CLASS"; //$NON-NLS-1$

	private static final String HINTS = "HINTS"; //$NON-NLS-1$

	public static final String NONE = "NONE"; //$NON-NLS-1$

	private static final String COPY_PARENT_ID = "COPY_PARENT_ID"; //$NON-NLS-1$

	private static final String COPY_ALWAYS_IDS = "COPY_ALWAYS_IDS"; //$NON-NLS-1$

	private ResourceInfoProcessor() {
		//private
	}

	private static Properties getProperties(String commnetedString) {
		String str = removeCommnetTags(commnetedString);
		StringTokenizer tokenizer = new StringTokenizer(str, PROPERTY_DELIM);
		Properties properties = new Properties();
		String key = null;
		String value = null;
		while (tokenizer.hasMoreTokens()) {
			key = tokenizer.nextToken();
			value = tokenizer.nextToken();
			properties.setProperty(key.trim(), value.trim());
		}
		return properties;
	}

	private static List getCommaSeparatedStringsList(String string) {
		List list = new ArrayList();
		StringTokenizer tokenizer = new StringTokenizer(string, COMMA);
		while (tokenizer.hasMoreTokens()) {
			list.add(tokenizer.nextToken().trim());
		}
		return list;
	}

	private static String removeCommnetTags(String commnetedString) {
		return trimStrings(commnetedString, BEGIN_COMMENT, END_COMMENT);
	}

	private static String trimStrings(String string, String beginStr,
			String endStr) {
		int begin = string.indexOf(beginStr);
		int end = string.indexOf(endStr);
		String result = string.substring(begin + beginStr.length(), end);
		return result.trim();
	}

	private static void processOffset(StringBuffer stringBuffer, int offset) {
		stringBuffer.append(BEGIN_COMMENT);
		stringBuffer.append(OFFSET).append(SEPARATOR).append(offset);
		stringBuffer.append(END_COMMENT);
		stringBuffer.append(ENDL);
	}

	private static void processOffset(ResourceInfo resourceInfo, String str) {
		StringBuffer buffer = new StringBuffer(str);
		int baseLenStrOffset = str.lastIndexOf(BEGIN_COMMENT);
		String baseLenStr = buffer.substring(baseLenStrOffset);
		buffer.delete(baseLenStrOffset, buffer.length());
		int infoStrOffset = Integer.parseInt(getProperties(baseLenStr)
			.getProperty(OFFSET));
		resourceInfo.info = buffer.substring(infoStrOffset);
		buffer.delete(infoStrOffset, buffer.length());
		resourceInfo.data = buffer.toString();
	}

	private static void processEObject(ResourceInfo resourceInfo, String line) {
		ObjectInfo objectInfo = new ObjectInfo();
		Properties properties = getProperties(line);
		objectInfo.objCopyType = properties.getProperty(OBJ_COPY_TYPE);
		objectInfo.objId = properties.getProperty(OBJ_ID);
		objectInfo.containerId = properties.getProperty(CONTAINER_ID);
		objectInfo.containerClass = properties.getProperty(CONTAINER_CLASS);
		objectInfo.hints = properties.getProperty(HINTS);
		objectInfo.copyParentId = properties.getProperty(COPY_PARENT_ID);
		String copyAlwaysIdStr = properties.getProperty(COPY_ALWAYS_IDS);
		if (copyAlwaysIdStr.equals(NONE) == false) {
			List ids = getCommaSeparatedStringsList(copyAlwaysIdStr);
			objectInfo.copyAlwaysIds.addAll(ids);
		}

		resourceInfo.objects.put(objectInfo.objId, objectInfo);
	}

	private static void processEObject(StringBuffer stringBuffer,
			EObject eObject, SavingEMFResource emfResource, Map hintMap,
			CopyObjects copyObjects) {

		stringBuffer.append(BEGIN_COMMENT);

		String copyType = null;
		String containerId = null;
		String containerClass = null;
		EObject eObjectWithValidContainer = eObject;

		if (copyObjects.originalObjects.contains(eObject)) {
			copyType = ObjectCopyType.OBJ_COPY_TYPE_ORIGINAL;
		} else if (copyObjects.combinedCopyAlwaysSet.contains(eObject)) {
			copyType = ObjectCopyType.OBJ_COPY_TYPE_ALWAYS;
		} else {
			copyType = ObjectCopyType.OBJ_COPY_TYPE_PARENT;
			eObjectWithValidContainer = emfResource.getOriginalEObject(eObject);
		}

		stringBuffer.append(OBJ_COPY_TYPE).append(SEPARATOR).append(copyType)
			.append(PLUS);

		stringBuffer.append(OBJ_ID).append(SEPARATOR).append(
			emfResource.getID(eObject)).append(PLUS);
		
		if (eObjectWithValidContainer != null && eObjectWithValidContainer.eContainer() != null) {
			containerId = emfResource.getID(eObjectWithValidContainer.eContainer());
			containerClass = eObjectWithValidContainer.eContainer().eClass()
				.getInstanceClassName();

			stringBuffer.append(CONTAINER_ID).append(SEPARATOR).append(containerId)
				.append(PLUS);
	
			stringBuffer.append(CONTAINER_CLASS).append(SEPARATOR).append(
				containerClass).append(PLUS);
		}

		String hints = (String) hintMap.get(eObject);
		stringBuffer.append(HINTS).append(SEPARATOR).append(
			(hints == null) ? NONE
				: hints).append(PLUS);

		EObject copyParent = (EObject) copyObjects.objectsToCopyParentMap
			.get(eObject);
		stringBuffer.append(COPY_PARENT_ID).append(SEPARATOR).append(
			(copyParent == null) ? NONE
				: emfResource.getID(copyParent)).append(PLUS);

		String copyAlwaysIdsStr = null;
		Set copyAlwaysSet = (Set) copyObjects.copyAlwaysMap.get(eObject);
		if ((copyAlwaysSet != null) && (copyAlwaysSet.isEmpty() == false)) {
			copyAlwaysSet.retainAll(copyObjects.combinedCopyAlwaysSet);
			if (copyAlwaysSet.isEmpty() == false) {
				copyAlwaysIdsStr = EMPTY_STRING; //init
				Iterator copyAlwaysSetIt = copyAlwaysSet.iterator();
				while (copyAlwaysSetIt.hasNext()) {
					EObject copyAlwaysObject = (EObject) copyAlwaysSetIt.next();
					copyAlwaysIdsStr = copyAlwaysIdsStr
						+ emfResource.getID(copyAlwaysObject);
					if (copyAlwaysSetIt.hasNext()) {
						copyAlwaysIdsStr = copyAlwaysIdsStr + COMMA;
					}
				}
			}
		}
		stringBuffer.append(COPY_ALWAYS_IDS).append(SEPARATOR).append(
			(copyAlwaysIdsStr == null) ? NONE
				: copyAlwaysIdsStr);

		stringBuffer.append(END_COMMENT);
		stringBuffer.append(ENDL);
	}

	private static void processResource(ResourceInfo resourceInfo, String line) {
		Properties properties = getProperties(line);
		resourceInfo.encoding = properties.getProperty(ENCODING);
	}

	private static void processResource(StringBuffer stringBuffer,
			String encoding) {
		stringBuffer.append(BEGIN_COMMENT);
		stringBuffer.append(ENCODING).append(SEPARATOR).append(encoding);
		stringBuffer.append(END_COMMENT);
		stringBuffer.append(ENDL);
	}

	private static void processVersion(ResourceInfo resourceInfo, String line) {
		Properties properties = getProperties(line);
		resourceInfo.type = properties.getProperty(TYPE);
		resourceInfo.version = properties.getProperty(VERSION);
	}

	private static void processVersion(StringBuffer stringBuffer) {
		stringBuffer.append(BEGIN_COMMENT);
		stringBuffer.append(TYPE).append(SEPARATOR).append(TYPE_VALUE).append(
			PLUS);
		stringBuffer.append(VERSION).append(SEPARATOR).append(VERSION_VALUE);
		stringBuffer.append(END_COMMENT);
		stringBuffer.append(ENDL);
	}

	static ResourceInfo getResourceInfo(String str)
		throws Exception {
		ResourceInfo resourceInfo = new ResourceInfo();
		processOffset(resourceInfo, str);
		BufferedReader reader = new BufferedReader(new StringReader(
			resourceInfo.info));
		processVersion(resourceInfo, reader.readLine());
		processResource(resourceInfo, reader.readLine());
		String line = reader.readLine();
		while (line != null) {
			processEObject(resourceInfo, line);
			line = reader.readLine();
		}

		resourceInfo.completeEObjectInitialization();

		return resourceInfo;
	}

	public static String getResourceInfo(int offset, String encoding,
			SavingEMFResource emfResource, Map hintMap, CopyObjects copyObjects) {

		StringBuffer stringBuffer = new StringBuffer();

		//(1)type + version
		processVersion(stringBuffer);

		//(2)general model + resource stuff
		processResource(stringBuffer, encoding);

		//(3)generate ObjectInfo entries
		Set objectInfoSet = new LinkedHashSet(copyObjects.totalCopyObjects);
		objectInfoSet.addAll(copyObjects.originalObjects);
		Iterator it = objectInfoSet.iterator();
		while (it.hasNext()) {
			processEObject(stringBuffer, (EObject) it.next(), emfResource,
				hintMap, copyObjects);
		}

		//write offset at the end
		processOffset(stringBuffer, offset);

		return stringBuffer.toString();
	}
}