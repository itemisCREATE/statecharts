/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.ui.validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.ResourceValidatorImpl;
import org.yakindu.sct.model.sgraph.resource.AbstractSCTResource;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTResourceValidatorImpl extends ResourceValidatorImpl {

	@Override
	protected void resolveProxies(final Resource resource, final CancelIndicator monitor) {
		if (resource instanceof AbstractSCTResource) {
			((AbstractSCTResource) resource).resolveLazyCrossReferences(monitor);
		} else
			super.resolveProxies(resource, monitor);
	}

	protected void validate(Resource resource, final CheckMode mode, final CancelIndicator monitor,
			IAcceptor<Issue> acceptor) {
		for (EObject ele : resource.getContents()) {
			if (ele instanceof Diagram) {
				continue;
			}
			if (!monitor.isCanceled()) {
				validate(null, ele, mode, monitor, acceptor);
			}
		}
	}
}