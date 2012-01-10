package org.yakindu.sct.generator.c.test;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashSet;
import java.util.concurrent.Semaphore;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.junit.Ignore;
import org.junit.Test;
import org.osgi.framework.Bundle;
import org.yakindu.sct.generator.core.GeneratorExecutor;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class CTestAdapterTest {
	private static final String PROJECT_NAME = "TestScenarios";

	@Inject
	private GeneratorExecutor generatorExecutor;

	private final String bundleName = "org.yakindu.sct.generator.c.test";

	private Injector injector;

	private HashSet<String> ignoredFiles;

	public CTestAdapterTest() {
		ignoredFiles = new HashSet<String>();
		ignoredFiles.add(".svn");
	}

	@Test
	@Ignore("Runnable on Jenkins is missing")
	public void runCTest() throws CoreException, IOException,
			InterruptedException, TransformerException {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		final int[] doneCounter = new int[1];
		doneCounter[0] = 1;
		NullProgressMonitor monitor = new NullProgressMonitor() {
			@Override
			public void done() {
				super.done();
				doneCounter[0]++;

			}
		};
		IProject project = root.getProject(PROJECT_NAME);
		int counterBefore = doneCounter[0];
		project.create(monitor);
		while (counterBefore == doneCounter[0]) {
			Thread.sleep(10);
		}
		File workingDirectory = project.getLocation().toFile();
		File tempDir = new File("/tmp/build");// File.createTempFile("ctest",
												// ".tmp");
		if (tempDir.exists()) {
			tempDir.delete();
		}
		tempDir.mkdir();
		copy(new File("TestScenarios"), workingDirectory);

		counterBefore = doneCounter[0];
		project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
		while (counterBefore == doneCounter[0]) {
			Thread.sleep(10);
		}

		counterBefore = doneCounter[0];
		project.open(monitor);
		while (counterBefore == doneCounter[0]) {
			Thread.sleep(10);
		}

		getInjector().injectMembers(this);

		IFile file = project.getFile("GenModelC.sgen");
		generatorExecutor.executeGenerator(file);
		waitForJobFinished(file.getProject().getWorkspace().getRuleFactory()
				.buildRule());

		// TODO parameterize cmake skript and call appropriate with conversion
		// for to junit.xml
		ProcessBuilder processBuilder = new ProcessBuilder(
				"/opt/local/bin/ctest", "-V", "-S", "ctest-command.cmake");
		processBuilder.environment().put("CTEST_SOURCE_DIRECTORY",
				workingDirectory.getAbsolutePath());
		processBuilder.environment().put("CTEST_BINARY_DIRECTORY",
				tempDir.getAbsolutePath());
		processBuilder.directory(workingDirectory);
		processBuilder.redirectErrorStream();

		Process process = processBuilder.start();

		System.out.println("CTEST-OUTPUT");
		copy(process.getInputStream(), System.out);
		System.out.println("CTEST-OUTPUT-ERROR");
		copy(process.getErrorStream(), System.out);

		transformTestResults(workingDirectory, tempDir);

		System.out.println("Delete temporary directory: "
				+ tempDir.getAbsolutePath());

		delete(tempDir);
	}

	private File findFolderInBundleDirectory(String bundleName,
			String folderName) {
		Bundle bundle = Platform.getBundle(bundleName);
		Path path = new Path(folderName);
		URL folderUrl = FileLocator.find(bundle, path, null);

		if (folderUrl != null) {
			try {
				URL resolved = FileLocator.resolve(folderUrl);
				return new File(resolved.toURI());
			} catch (URISyntaxException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	private void transformTestResults(File workingDirectory, File tempDir)
			throws TransformerFactoryConfigurationError,
			TransformerConfigurationException, TransformerException {
		File xmlFile = findTestResult(tempDir);
		File scriptsFolder = findFolderInBundleDirectory(bundleName, "scripts");
		if (scriptsFolder == null) {
			fail("Folder scripts in bundle not found");
		}
		File xsltFile = new File(scriptsFolder, "CTest2JUnit.xsl");

		if (xmlFile == null) {
			fail("no Test.xml found");
		}

		// JAXP liest Daten über die Source-Schnittstelle
		Source xmlSource = new StreamSource(xmlFile);
		Source xsltSource = new StreamSource(xsltFile);

		// das Factory-Pattern unterstützt verschiedene XSLT-Prozessoren
		TransformerFactory transFact = TransformerFactory.newInstance();
		Transformer trans = transFact.newTransformer(xsltSource);

		trans.transform(xmlSource, new StreamResult(new File(workingDirectory,
				"CMakeTestResult.xml")));
	}

	private File findTestResult(File tempDir) {
		if (tempDir.isFile() && "Test.xml".equals(tempDir.getName())) {
			return tempDir;
		}
		if (tempDir.isDirectory()) {
			for (File child : tempDir.listFiles()) {
				File result = findTestResult(child);
				if (result != null) {
					return result;
				}
			}
		}
		return null;
	}

	void copy(InputStream in, OutputStream out) throws IOException {
		while (true) {
			int c = in.read();
			if (c == -1)
				break;
			out.write((char) c);
		}
	}

	private void delete(File file) {
		if (file.isDirectory()) {
			for (File child : file.listFiles()) {
				delete(child);
			}
			file.delete();
		} else if (file.isFile()) {
			file.delete();
		}
	}

	private void waitForJobFinished(ISchedulingRule schedulingRule)
			throws InterruptedException {
		final Semaphore semaphore = new Semaphore(1);
		semaphore.acquire();
		new Job("Wait Job") {
			protected org.eclipse.core.runtime.IStatus run(
					org.eclipse.core.runtime.IProgressMonitor monitor) {
				semaphore.release();
				return Status.OK_STATUS;
			};
		}.schedule();
		semaphore.acquire();
	}

	private Injector getInjector() {
		if (injector == null) {
			injector = Guice
					.createInjector(new org.yakindu.sct.generator.genmodel.SGenRuntimeModule());
		}
		return injector;
	}

	private void copy(File source, File target) throws IOException {
		for (File child : source.listFiles()) {
			if (ignoredFiles.contains(source.getName())) {
				return;
			}
			if (child.isDirectory()) {
				File childTargetDir = new File(target, child.getName());
				childTargetDir.mkdir();
				copy(child, childTargetDir);
			} else if (child.isFile()) {
				File childTargetFile = new File(target, child.getName());

				if (childTargetFile.exists()) {
					childTargetFile.delete();
				}

				FileReader in = null;
				FileWriter out = null;
				try {
					in = new FileReader(child);
					out = new FileWriter(childTargetFile);

					int c = in.read();
					while (c != -1) {
						out.write(c);
						c = in.read();
					}
				} finally {
					if (in != null)
						in.close();
					if (out != null)
						out.close();
				}
			}

		}
	}
}
