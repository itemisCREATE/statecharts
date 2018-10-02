package org.yakindu.sct.commons;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;

public class PathHelper {
	public String getPathString(File file) {
		if (file == null) {
			return "";
		}
		try {
			return file.getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
			return file.getAbsolutePath();
		}
	}

	public Path toPath(String pathString) {
		if (pathString == null) {
			return null;
		}
		Path path = Paths.get(pathString);
		try {
			return path.toRealPath();
		} catch (IOException e) {
			e.printStackTrace();
			return path;
		}
	}
	
	public Path toPath(URI uri) {
		return toPath(uri.toFileString());
	}

	public Path toPath(IFile file) {
		return toPath(file.getLocation().toOSString());
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