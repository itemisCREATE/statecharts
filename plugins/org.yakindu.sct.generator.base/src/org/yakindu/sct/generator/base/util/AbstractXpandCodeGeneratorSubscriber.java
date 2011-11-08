package org.yakindu.sct.generator.base.util;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
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
		System.out.println(getClass() + ".doBuild()");
		try {
			IProject project = resource.getProject();
			Statechart statechart;
			if (resource == null || !resource.exists()) {
				return;
			}
			statechart = GeneratorBaseUtil.loadStatechart(resource);

			ExecutionFlow executionFlow = GeneratorBaseUtil
					.createExecutionFlowModel(statechart);
			IPath location = project.getRawLocation();
			if (location == null) {
				location = project.getLocation();
			}
			String absoluteTargetFolder = location.toOSString()
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
