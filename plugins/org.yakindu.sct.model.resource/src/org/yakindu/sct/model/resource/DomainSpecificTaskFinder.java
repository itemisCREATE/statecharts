package org.yakindu.sct.model.resource;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.tasks.ITaskFinder;
import org.eclipse.xtext.tasks.Task;
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.domain.extension.IDomain;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.resource.AbstractSCTResource;

import com.google.inject.Injector;

@SuppressWarnings("restriction")
public class DomainSpecificTaskFinder implements ITaskFinder {

	@Override
	public List<Task> findTasks(Resource resource) {
		if (resource instanceof AbstractSCTResource) {
			IDomain domain = DomainRegistry.getDomain(
					(EObject) EcoreUtil2.getObjectByType(resource.getContents(), SGraphPackage.Literals.STATECHART));
			ITaskFinder taskFinder = domain.getInjector(IDomain.FEATURE_RESOURCE).getInstance(ITaskFinder.class);
			if (taskFinder != null)
				return taskFinder.findTasks(resource);
		}
		return Collections.emptyList();
	}

}
