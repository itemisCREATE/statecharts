/** 
 * Copyright (c) 2017 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.ui.editor.validation;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ui.editor.validation.IValidationIssueProcessor;
import org.eclipse.xtext.validation.IResourceValidator;

import com.google.inject.ImplementedBy;
import com.google.inject.Inject;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
@ImplementedBy(ShadowModelValidationJob.class)
public abstract class ValidationJob extends Job {

	@Inject
	protected IResourceValidator validator;

	protected IValidationIssueProcessor validationIssueProcessor;

	protected Resource resource;

	public ValidationJob() {
		super("validate model...");
		setUser(false);
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public void setValidationIssueProcessor(IValidationIssueProcessor validationIssueProcessor) {
		this.validationIssueProcessor = validationIssueProcessor;
	}

}
