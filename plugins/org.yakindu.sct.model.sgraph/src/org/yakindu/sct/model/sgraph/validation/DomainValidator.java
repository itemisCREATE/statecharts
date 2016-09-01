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
package org.yakindu.sct.model.sgraph.validation;

import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.EValidatorRegistrar;
import org.yakindu.base.base.BasePackage;
import org.yakindu.base.base.DomainElement;
import org.yakindu.sct.domain.extension.DomainRegistry;

import com.google.inject.Inject;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class DomainValidator extends AbstractDeclarativeValidator {

	public static final String MSG_DOMAIN_UNAVAILABLE = "Domain '%s' not found!";
	public static final String CODE_DOMAIN_UNAVAILABLE = "DomainUnavailable";

	@Check
	public void checkDomainAvailable(DomainElement element) {
		if (!DomainRegistry.domainExists(element.getDomainID())) {
			error(String.format(MSG_DOMAIN_UNAVAILABLE, element.getDomainID()), element,
					BasePackage.Literals.NAMED_ELEMENT__NAME, CODE_DOMAIN_UNAVAILABLE);
		}
	}

	@Override
	public boolean isLanguageSpecific() {
		return false;
	}

	@Inject
	public void register(EValidatorRegistrar registrar) {
		// Do not register because this validator is only a composite #398987
	}

}
