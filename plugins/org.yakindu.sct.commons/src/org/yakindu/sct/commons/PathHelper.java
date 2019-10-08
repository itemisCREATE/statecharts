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

import java.io.File;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;

public class PathHelper {
	public String toPathString(File file) {
		try {
			return file.getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
			return file.getAbsolutePath();
		}
	}

	public Path toPath(String pathString, LinkOption... options) {
		if (pathString == null) {
			return null;
		}
		Path path = Paths.get(pathString);
		try {
			return path.toRealPath(options);
		} catch (IOException e) {
			e.printStackTrace();
			return path;
		}
	}
	
	public Path toPath(URI uri, LinkOption... options) {
		return toPath(uri.toFileString(), options);
	}

	public Path toPath(IResource file, LinkOption... options) {
		return toPath(file.getLocation().toOSString(), options);
	}
	
	public boolean pathsEqual(String p1, String p2) {
		Path path1 = toPath(p1);
		Path path2 = toPath(p2);
		return pathsEqual(path1, path2);
	}

	public boolean pathsEqual(Path p1, Path p2) {
		return Objects.equals(p1, p2);
	}
}