/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.resource.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.tasks.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.sct.model.resource.tasks.DomainSpecificTaskFinder;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.inject.Inject;

/**
 * @author Johannes Dicks - Initial contribution and API
 */
@SuppressWarnings("restriction")
@RunWith(XtextRunner.class)
@InjectWith(SCTTestInjectorProvider.class)
public class DomainSpecificTaskFinderTest {

	private static final String TAG_FIXME = "FIXME";
	private static final String TAG_TODO = "TODO";
	private static final String TEST_MODEL_WITH_TASKS = "/org.yakindu.sct.model.resource.test/testdata/Tasks.sct";
	private static final int EXPECT_TASKS_FOUND = 15;
	private static final int EXPECT_FIXME_FOUND = 8;
	private static final int EXPECT_TODO_FOUND = 7;

	@Inject
	DomainSpecificTaskFinder taskFinder;
	private List<Task> foundTasks;

	@Test
	public void testFindTODOs() {

		assertEquals(EXPECT_TODO_FOUND, Collections2.filter(foundTasks, new Predicate<Task>() {
			@Override
			public boolean apply(Task task) {
				return task.getTag().getName().equals(TAG_TODO);
			}
		}).size());
	}

	@Test
	public void testFindFIXMEs() {

		assertEquals(EXPECT_FIXME_FOUND, Collections2.filter(foundTasks, new Predicate<Task>() {
			@Override
			public boolean apply(Task task) {
				return task.getTag().getName().equals(TAG_FIXME);
			}
		}).size());
	}

	@Test
	public void testFindAllAvailableTasks() {
		assertEquals(EXPECT_TASKS_FOUND, foundTasks.size());
	}

	@Before
	public void setup() {
		ResourceSetImpl resourceSetImpl = new ResourceSetImpl();
		URI sctWithTasks = URI.createPlatformPluginURI(
				TEST_MODEL_WITH_TASKS, true);
		Resource resource = resourceSetImpl.getResource(sctWithTasks, true);
		foundTasks = taskFinder.findTasks(resource);
	}

}
