/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.examples.wizard.service;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.yakindu.sct.examples.wizard.service.data.ExampleData;

/**
 * 
 * @author t00manysecretss
 * 
 */
public interface IExampleService {

	public boolean exists();

	public UpdateResult fetchNewUpdates(IProgressMonitor monitor);

	public IStatus fetchAllExamples(IProgressMonitor monitor);

	public List<ExampleData> getExamples(IProgressMonitor monitor);

	enum UpdateResult {
		UPDATE_AVAILABLE, NO_UPDATES, 
		
		REMOTE_BRANCH_NOT_FOUND, INVALID_CONFIGURATION, REPO_CONTAINS_CONFLICTS;
	}
}