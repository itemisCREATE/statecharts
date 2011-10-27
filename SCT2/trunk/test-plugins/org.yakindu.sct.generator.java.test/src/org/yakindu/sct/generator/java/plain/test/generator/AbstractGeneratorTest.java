package org.yakindu.sct.generator.java.plain.test.generator;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class AbstractGeneratorTest {

	public static void copyUrlFileToIFile(URL url, IFile file) throws Exception {
		InputStream stream = null;
		try {
			stream = url.openStream();
			file.create(stream, true, new NullProgressMonitor());
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
				}
			}
		}
	}

	/**
	 * Creates a new Test project Project
	 */
	protected IProject createTestProject(String projectName,
			boolean deleteIfExists) throws Exception {
		final IProject project = ResourcesPlugin.getWorkspace().getRoot()
				.getProject(projectName);

		if (project.exists() && deleteIfExists) {
			project.delete(true, true, new NullProgressMonitor());
		}

		if (!project.exists() || deleteIfExists) {
			project.create(new NullProgressMonitor());
			project.open(new NullProgressMonitor());
		}

		return project;
	}
}
