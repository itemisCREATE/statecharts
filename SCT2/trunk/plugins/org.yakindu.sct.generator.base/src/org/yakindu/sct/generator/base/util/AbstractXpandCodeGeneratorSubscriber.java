package org.yakindu.sct.generator.base.util;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.yakindu.sct.builder.subscriber.IBuilderSubscriber;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sgraph.Statechart;

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
			Statechart statechart;

			statechart = GeneratorBaseUtil.loadStatechart(resource);

			ExecutionFlow executionFlow = GeneratorBaseUtil
					.createExecutionFlowModel(statechart);
			String absoluteTargetFolder = ResourcesPlugin.getWorkspace()
					.getRoot().getLocation().toOSString()
					+ File.separator
					+ project.getFullPath().toOSString()
					+ File.separator + getOutletPath(resource);
			GeneratorBaseUtil.generate(executionFlow, getTemplatePath(),
					project, absoluteTargetFolder);
		} catch (CoreException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
