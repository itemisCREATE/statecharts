/**
 * Copyright (c) 2014 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.core.util;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;

/**
 * Source:
 * http://stackoverflow.com/questions/7993838/programmatically-add-source
 * -folder-from-eclipse-plugin
 * 
 * @author oliver bohl
 * 
 */

public class ClasspathChanger {

	public void addFolderToClassPath(IProject project, String folder) {

		if (!isPartOfClassPath(project, folder)) {
			IJavaProject javaProject = JavaCore.create(project);
			IClasspathEntry[] entries = null;

			try {
				entries = javaProject.getRawClasspath();
			} catch (JavaModelException e) {
				e.printStackTrace();
			}

			IClasspathEntry[] newEntries = new IClasspathEntry[entries.length + 1];
			System.arraycopy(entries, 0, newEntries, 0, entries.length);

			IPath srcPath = javaProject.getPath().append(folder);
			IClasspathEntry srcEntry = JavaCore.newSourceEntry(srcPath, null);

			newEntries[entries.length] = JavaCore.newSourceEntry(srcEntry.getPath());

			try {
				javaProject.setRawClasspath(newEntries, null);
			} catch (JavaModelException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean isPartOfClassPath(IProject project, String folder) {

		IJavaProject javaProject = JavaCore.create(project);
		IClasspathEntry[] entries = null;

		try {
			entries = javaProject.getRawClasspath();
		} catch (JavaModelException e) {
			e.printStackTrace();
		}

		for (IClasspathEntry entry : entries) {
			String projectString = "/" + project.getName() + "/" + folder;
			if (entry.getPath().toString().equals(projectString)) {
				return true;
			}
		}
		return false;
	}
}
