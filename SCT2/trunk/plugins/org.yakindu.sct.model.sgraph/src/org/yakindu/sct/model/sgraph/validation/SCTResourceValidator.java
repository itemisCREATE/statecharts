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
package org.yakindu.sct.model.sgraph.validation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.yakindu.sct.model.sgraph.SpecificationElement;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.resource.AbstractSCTResource;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTResourceValidator extends AbstractDeclarativeValidator {

	@Check(CheckType.FAST)
	public void checkUnresolvableProxies(Statechart sc) {
		if (!(sc.eResource() instanceof AbstractSCTResource)) {
			return;
		}
		AbstractSCTResource resource = (AbstractSCTResource) sc.eResource();
		for (Map.Entry<SpecificationElement, Collection<Diagnostic>> entry : resource
				.getLinkingDiagnostics().asMap().entrySet()) {
			for (Diagnostic diag : entry.getValue()) {
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
		for (Map.Entry<SpecificationElement, Collection<Diagnostic>> entry : resource
				.getSyntaxDiagnostics().asMap().entrySet()) {
			for (Diagnostic diag : entry.getValue()) {
				error(diag.getMessage(), entry.getKey(), null, -1);
			}
		}
	}

	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = new ArrayList<EPackage>();
		result.add(EPackage.Registry.INSTANCE
				.getEPackage("http://www.yakindu.org/sct/sgraph/2.0.0"));
		return result;
	}

	@Override
	public boolean isLanguageSpecific() {
		return false;
	}

	@Override
	protected boolean isResponsible(Map<Object, Object> context, EObject eObject) {
		return true;
	}

}
