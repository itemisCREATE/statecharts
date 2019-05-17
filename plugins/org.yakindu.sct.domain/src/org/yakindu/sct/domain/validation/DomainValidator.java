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
package org.yakindu.sct.domain.validation;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.yakindu.base.base.DomainElement;
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.domain.extension.DomainStatus;
import org.yakindu.sct.domain.extension.DomainStatus.Severity;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class DomainValidator implements EValidator {

	public static final String MSG_DOMAIN_UNAVAILABLE = "Domain '%s' not found!";
	public static final String CODE_DOMAIN_UNAVAILABLE = "DomainUnavailable";

	@Override
	public boolean validate(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	@Override
	public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (eObject instanceof DomainElement) {
			DomainStatus status = DomainRegistry.getDomainStatus(((DomainElement) eObject).getDomainID());
			if (status.getSeverity() == Severity.ERROR) {
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, "DomainValidator", 0, status.getShortMessage(),
						new Object[] { eObject }));
			} else if (status.getSeverity() == Severity.WARNING) {
				diagnostics.add(new BasicDiagnostic(Diagnostic.WARNING, "DomainValidator", 0, status.getMessage(),
						new Object[] { eObject }));
			} else if (status.getSeverity() == Severity.INFO) {
				diagnostics.add(new BasicDiagnostic(Diagnostic.INFO, "DomainValidator", 0, status.getShortMessage(),
						new Object[] { eObject }));
			}
		}
		return true;
	}

	@Override
	public boolean validate(EDataType eDataType, Object value, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return true;
	}

}
