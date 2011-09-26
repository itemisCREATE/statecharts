package org.yakindu.sct.generator.base.util;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
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
import org.yakindu.sct.builder.subscriber.IBuilderSubscriber;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.SexecPackage;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.stext.stext.StextPackage;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractXpandCodeGeneratorSubscriber implements
		IBuilderSubscriber {

	public abstract String getTemplatePath();

	public abstract String getOutletPath(IResource resource);

	public void doBuild(IResource resource) {
		try {
			IProject project = resource.getProject();
			Statechart statechart = GeneratorBaseUtil.loadStatechart(resource);
			ExecutionFlow executionFlow = GeneratorBaseUtil
					.createExecutionFlowModel(statechart);
			String absoluteTargetFolder = ResourcesPlugin.getWorkspace()
					.getRoot().getLocation().toOSString()
					+ File.separator
					+ project.getFullPath().toOSString()
					+ File.separator + getOutletPath(resource);

			OutputImpl output = new OutputImpl();
			Outlet outlet = new Outlet(absoluteTargetFolder);
			outlet.setOverwrite(true);
			output.addOutlet(outlet);

			XpandExecutionContextImpl execCtx = new XpandExecutionContextImpl(
					output, null, Collections.<String, Variable> emptyMap(),
					null, null);
			EmfRegistryMetaModel metamodel = new EmfRegistryMetaModel() {
				@Override
				protected EPackage[] allPackages() {
					return new EPackage[] { SGraphPackage.eINSTANCE,
							StextPackage.eINSTANCE, EcorePackage.eINSTANCE,
							SexecPackage.eINSTANCE };
				}
			};
			execCtx.registerMetaModel(metamodel);
			// generate
			XpandFacade facade = XpandFacade.create(execCtx);
			facade.evaluate(getTemplatePath(), executionFlow);
			// refresh the project to get external updates:
			project.refreshLocal(IResource.DEPTH_INFINITE,
					new NullProgressMonitor());
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (CoreException e) {
			e.printStackTrace();
		}

	}
}
