/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 *
 */
package org.yakindu.sct.commons;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;

public class EMFHelper {
	public static List<EClass> getAllSuperClasses(EClass eClass) {
		List<List<EClass>> superClasses = new ArrayList<>();

		getSuperClassTree(superClasses, eClass, 0);

		List<EClass> result = new ArrayList<>();
		for (List<EClass> list : superClasses) {
			result.addAll(list);
		}

		return result;
	}

	protected static void getSuperClassTree(List<List<EClass>> superClasses, EClass eClass, int depth) {
		if (superClasses.size() <= depth) {
			superClasses.add(depth, new ArrayList<>());
		}

		List<EClass> superTypes = eClass.getESuperTypes();

		superClasses.get(depth).add(eClass);

		for (EClass superType : superTypes) {
			getSuperClassTree(superClasses, superType, depth + 1);
		}
	}

	public static IFile getIFileFromEMFUri(URI uri) {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toPlatformString(true)));
	}
}
