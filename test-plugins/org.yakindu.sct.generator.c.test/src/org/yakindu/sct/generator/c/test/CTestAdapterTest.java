package org.yakindu.sct.generator.c.test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Semaphore;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.junit.Test;
import org.yakindu.sct.generator.core.GeneratorExecutor;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class CTestAdapterTest {
	private static final String PROJECT_NAME = "TestScenarios";

	@Inject
	private GeneratorExecutor generatorExecutor;

	private Injector injector;

	@Test
	public void runCTest() throws CoreException, IOException,
			InterruptedException {
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
		copy(new File("TestScenarios"), project.getLocation().toFile());

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
				"/opt/local/bin/cmake");
		processBuilder.directory(project.getLocation().toFile());

		processBuilder.start();
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
