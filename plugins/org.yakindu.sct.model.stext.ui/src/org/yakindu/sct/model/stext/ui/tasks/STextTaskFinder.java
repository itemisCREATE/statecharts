/**
 * Copyright (c) 2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.ui.tasks;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.tasks.DefaultTaskFinder;
import org.eclipse.xtext.tasks.ITaskParser;
import org.eclipse.xtext.tasks.ITaskTagProvider;
import org.eclipse.xtext.tasks.Task;
import org.eclipse.xtext.tasks.TaskTags;
import org.yakindu.base.base.BasePackage;
import org.yakindu.base.base.DocumentedElement;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.SpecificationElement;
import org.yakindu.sct.model.stext.resource.StextResource;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@SuppressWarnings("restriction")
public class STextTaskFinder extends DefaultTaskFinder {

	@Inject
	ITaskTagProvider taskTagProvider;
	@Inject
	private ITaskParser parser;

	@Override
	public List<Task> findTasks(Resource resource) {
		if (resource instanceof StextResource) {
			return findTasks((StextResource) resource);
		}
		return super.findTasks(resource);
	}

	//TODO: Extend the Task class to provide element id for MarkerNavigatorService 
	public List<Task> findTasks(StextResource resource) {
		TaskTags taskTags = taskTagProvider.getTaskTags(resource);
		List<Task> result = Lists.newArrayList();
		TreeIterator<EObject> allContents = resource.getAllContents();
		while (allContents.hasNext()) {
			EObject eObject = (EObject) allContents.next();
			if (eObject instanceof SpecificationElement) {
				List<Task> parseTasks = parseTasks(eObject,
						SGraphPackage.Literals.SPECIFICATION_ELEMENT__SPECIFICATION, taskTags);
				result.addAll(parseTasks);
			}
			if (eObject instanceof DocumentedElement) {
				result.addAll(parseTasks(eObject, BasePackage.Literals.DOCUMENTED_ELEMENT__DOCUMENTATION, taskTags));
			}
		}
		return result;
	}

	protected List<Task> parseTasks(EObject element, EStructuralFeature feature, TaskTags tags) {
		String expression = (String) element.eGet(feature);
		if (expression == null)
			return Collections.emptyList();
		return parser.parseTasks(expression, tags);
	}
}
