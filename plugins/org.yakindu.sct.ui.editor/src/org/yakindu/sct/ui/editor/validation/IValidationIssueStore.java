/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.validation;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ui.editor.validation.IValidationIssueProcessor;
import org.yakindu.sct.model.sgraph.ui.validation.SCTIssue;

import com.google.inject.ImplementedBy;

/**
 * 
 *
 * @author Andreas Muelder - Initial contribution and API
 *
 */
@ImplementedBy(DefaultValidationIssueStore.class)
public interface IValidationIssueStore extends IValidationIssueProcessor {

	public interface IResourceIssueStoreListener {

		public void issuesChanged();

	}

	public void addIssueStoreListener(IResourceIssueStoreListener listener);

	public void removeIssueStoreListener(IResourceIssueStoreListener listener);

	public void connect(Resource resource);

	public void disconnect(Resource resource);

	public List<SCTIssue> getIssues(String uri);
}
