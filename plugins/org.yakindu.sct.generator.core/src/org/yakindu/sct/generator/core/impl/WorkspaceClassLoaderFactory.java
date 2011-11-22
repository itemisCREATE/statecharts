package org.yakindu.sct.generator.core.impl;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.JavaRuntime;

import com.google.common.collect.Lists;

/**
 * Factory for {@link ClassLoader}s based on {@link IProject}s inside the
 * workspace
 * 
 * @author koenemann - Initial contribution and API
 * @author holger willebrandt
 */
public class WorkspaceClassLoaderFactory {

	/**
	 * Creates a {@link ClassLoader} that can be used to load resources from the
	 * workspace.
	 */
	public ClassLoader createClassLoader(IProject project) {
		final List<URL> urls = Lists.newArrayList();

		addClasspathEntries(project, urls);

		return URLClassLoader.newInstance(urls.toArray(new URL[urls.size()]),
				WorkspaceClassLoaderFactory.class.getClassLoader());
	}

	protected void addClasspathEntries(IProject project, List<URL> urls) {
		IJavaProject javaProject = toJavaProject(project);
		if (javaProject != null) {
			addJavaClasspathEntries(javaProject, urls);
		} else {
			try {
				urls.add(getFileSystemFile(project).toURI().toURL());
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			addReferencedProjectsClasspaths(project, urls);
		}
	}

	protected void addReferencedProjectsClasspaths(IProject project,
			List<URL> urls) {
		try {
			IProject[] referencedProjects = project.getReferencedProjects();
			for (IProject iProject : referencedProjects) {
				addClasspathEntries(iProject, urls);
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected File getFileSystemFile(IResource resource) {
		return new File(resource.getWorkspace().getRoot().getRawLocation()
				.toFile().getAbsolutePath()
				+ File.separator
				+ resource.getFullPath().toFile().getAbsolutePath());
	}

	protected IJavaProject toJavaProject(IProject project) {
		IJavaProject javaProject = null;
		try {
			javaProject = JavaCore.create(project);
//			javaProject.e
			// access children to decide whether we have a java project or not
			javaProject.getChildren();
		} catch (JavaModelException jme) {
			return null;
		}
		return javaProject;
	}

	protected void addJavaClasspathEntries(IJavaProject project, List<URL> urls) {
		try {
			urls.addAll(Lists.newArrayList(convertClassPath(JavaRuntime
					.computeDefaultRuntimeClassPath(project))));
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Converting string classpath to {@link URL}s.
	 */
	private static URL[] convertClassPath(String[] classPath) {
		final URL[] urls = new URL[classPath.length];
		for (int i = 0; i < classPath.length; i++) {
			final String entry = classPath[i];
			final IPath path = new Path(entry);
			try {
				final URL url = path.toFile().toURI().toURL();
				urls[i] = url;
			} catch (MalformedURLException e) {
				throw new RuntimeException(
						"Could not convert classpath entry to URL: "
								+ path.toString(), e);
			}
		}
		return urls;
	}

}
