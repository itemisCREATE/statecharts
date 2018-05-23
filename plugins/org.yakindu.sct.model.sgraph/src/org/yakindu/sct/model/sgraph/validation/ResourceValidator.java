/**
 * Copyright (c) 2012-2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.sgraph.validation;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.yakindu.sct.model.sgraph.SpecificationElement;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.resource.AbstractSCTResource;

public class ResourceValidator extends AbstractSGraphValidator {

	@Check(CheckType.FAST)
	public void checkUnresolvableProxies(Statechart sc) {
		if (!(sc.eResource() instanceof AbstractSCTResource)) {
			return;
		}
		AbstractSCTResource resource = (AbstractSCTResource) sc.eResource();
		for (Map.Entry<SpecificationElement, Collection<Diagnostic>> entry : resource.getLinkingDiagnostics().asMap()
				.entrySet()) {
			for (Diagnostic diag : entry.getValue()) {
				if (entry.getKey().eResource() != null)
					error(diag.getMessage(), entry.getKey(), null, -1);
			}
		}
	}

	@Check(CheckType.FAST)
	public void checkSyntaxErrors(Statechart sc) {
		if (!(sc.eResource() instanceof AbstractSCTResource)) {
			return;
		}
		AbstractSCTResource resource = (AbstractSCTResource) sc.eResource();
		for (Map.Entry<SpecificationElement, Collection<Diagnostic>> entry : resource.getSyntaxDiagnostics().asMap()
				.entrySet()) {
			for (Diagnostic diag : entry.getValue()) {
				if (entry.getKey().eResource() != null)
					error(diag.getMessage(), entry.getKey(), null, -1);
			}
		}
	}

}
