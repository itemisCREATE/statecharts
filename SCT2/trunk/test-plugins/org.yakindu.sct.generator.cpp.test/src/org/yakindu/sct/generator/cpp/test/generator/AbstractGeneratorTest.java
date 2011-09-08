package org.yakindu.sct.generator.cpp.test.generator;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xpand2.XpandExecutionContextImpl;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.OutputImpl;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.typesystem.emf.EmfRegistryMetaModel;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.stext.stext.StextPackage;

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

	/**
	 * Executes the Template via the {@link XpandFacade}
	 * 
	 * @param statechart
	 *            the Statechart model to generate code for
	 */
	protected void generate(ExecutionFlow flow, String templatePath,
			IProject project) throws CoreException {

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IResource resource = root.getProject(project.getName());
		String containerName = root.getLocation().toOSString() + File.separator
				+ project.getName() + File.separator + "src-gen";

		OutputImpl output = new OutputImpl();
		Outlet outlet = new Outlet(containerName);
		outlet.setOverwrite(true);
		output.addOutlet(outlet);

		XpandExecutionContextImpl execCtx = new XpandExecutionContextImpl(
				output, null, Collections.<String, Variable> emptyMap(), null,
				null);
		EmfRegistryMetaModel metamodel = new EmfRegistryMetaModel() {
			@Override
			protected EPackage[] allPackages() {
				return new EPackage[] { SGraphPackage.eINSTANCE,
						StextPackage.eINSTANCE, EcorePackage.eINSTANCE };
			}
		};
		execCtx.registerMetaModel(metamodel);

		// generate
		XpandFacade facade = XpandFacade.create(execCtx);
		facade.evaluate(templatePath, flow);

		// refresh the project to get external updates:
		resource.refreshLocal(IResource.DEPTH_INFINITE,
				new NullProgressMonitor());
		System.out.println("Written to " + containerName);
	}

}
