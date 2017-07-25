/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.resource.tasks;

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
/**
 * 
 * @author Johannes Dicks - Initial contribution and API
 * 
 */
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
