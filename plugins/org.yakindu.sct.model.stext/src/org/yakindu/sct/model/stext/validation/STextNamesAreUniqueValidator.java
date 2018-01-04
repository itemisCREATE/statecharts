/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.validation;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.INamesAreUniqueValidationHelper;
import org.eclipse.xtext.validation.NamesAreUniqueValidator;
import org.yakindu.base.base.NamedElement;
import org.yakindu.sct.model.stext.naming.StextNameProvider;

import com.google.inject.Inject;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class STextNamesAreUniqueValidator extends NamesAreUniqueValidator {

	@Inject
	private INamesAreUniqueValidationHelper helper;
	@Inject
	private StextNameProvider fqnProvider;

	/**
	 * The default implementation checks only for objects that are exported via description strategy.
	 * It should also check for uniqueness of internal elements. 
	 */
	@Override
	public void doCheckUniqueNames(Resource resource, CancelIndicator cancelIndicator) {
		Iterable<EObject> iterable = () -> EcoreUtil.getAllContents(resource, true);
		List<EObject> candiatates = StreamSupport.stream(iterable.spliterator(), false)
				.filter((it) -> it instanceof NamedElement).collect(Collectors.toList());
		helper.checkUniqueNames(Scopes.scopedElementsFor(candiatates, fqnProvider), cancelIndicator, this);
	}
}
