/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.sgraph.test.resource;

import static org.junit.Assert.assertTrue;

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

import com.google.inject.Inject;

/**
 * @author Johannes Dicks - Initial contribution and API
 */
@SuppressWarnings("restriction")
@RunWith(XtextRunner.class)
@InjectWith(SCTTestInjectorProvider.class)
public class DomainSpecificTaskFinderTest {

	private static final String TEST_MODEL = "/org.yakindu.sct.model.resource.test/testdata/Tasks.sct";
	private static final int EXPECT_TASKS_FOUND = 5;

	@Inject
	DomainSpecificTaskFinder taskFinder;
	private List<Task> findTasks;

	@Test
	public void testTODOs() {
		assertTrue(findTasks.stream().filter((Task t) -> {
			return t.getTag().getName().equals("FIXME");
		}).findAny().isPresent());

		assertTrue(findTasks.stream().filter((Task t) -> {
			return t.getTag().getName().equals("TODO");
		}).findAny().isPresent());

		assertTrue(EXPECT_TASKS_FOUND == findTasks.size());
	}

	@Before
	public void setup() {
		ResourceSetImpl resourceSetImpl = new ResourceSetImpl();
		URI sctWithTasks = URI.createPlatformPluginURI(
				TEST_MODEL, true);
		Resource resource = resourceSetImpl.getResource(sctWithTasks, true);
		findTasks = taskFinder.findTasks(resource);
	}

}
