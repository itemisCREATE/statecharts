/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.resource.services;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.stext.stext.TransitionSpecification;

import de.itemis.xtext.utils.gmf.resource.AbstractXtextMemberInjectionService;

/**
 * 
 * @author andreas muelder (andreas.muelder@itemis.de)
 * 
 */
public class TransitionInjectionService
		extends
		AbstractXtextMemberInjectionService<Transition, TransitionSpecification> {

	@Override
	public String getParserRule() {
		return TransitionSpecification.class.getSimpleName();
	}

	@Override
	public void injectMembers(EObject object) {
		super.injectMembers(object);
	}

	@Override
	public void setFeatures(Transition original, TransitionSpecification rootAST) {
		original.setTrigger(rootAST.getReaction().getTrigger());
		original.setEffect(rootAST.getReaction().getEffect());

	}

	public boolean isServiceFor(EObject object) {
		return object instanceof Transition;
	}

	public EAttribute getSourceFeature() {
		return SGraphPackage.Literals.SPECIFICATION_ELEMENT__SPECIFICATION;
	}

}
