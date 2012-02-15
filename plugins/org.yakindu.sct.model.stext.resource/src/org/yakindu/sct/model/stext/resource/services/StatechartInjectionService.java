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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.stext.stext.StatechartScope;
import org.yakindu.sct.model.stext.stext.StatechartSpecification;

import de.itemis.xtext.utils.gmf.resource.AbstractXtextMemberInjectionService;
import de.itemis.xtext.utils.gmf.resource.IMemberInjectionService;

/**
 * Implementation if {@link IMemberInjectionService} interface to inject the
 * members of the {@link State} from the textual expression.F
 * 
 * @author andreas muelder (andreas.muelder@itemis.de)
 * 
 */
public class StatechartInjectionService extends
		AbstractXtextMemberInjectionService<Statechart, StatechartSpecification> {

	public boolean isServiceFor(EObject object) {
		return object instanceof Statechart;
	}

	@Override
	public void setFeatures(Statechart original, StatechartSpecification rootAST) {
		EList<StatechartScope> definitionScopes = rootAST.getDefinitionScopes();
		original.getScopes().clear();
		original.setNamespace(rootAST.getNamespace());
		original.getScopes().addAll(definitionScopes);
	}

	public EStructuralFeature getSourceFeature() {
		return SGraphPackage.Literals.SPECIFICATION_ELEMENT__SPECIFICATION;
	}

	@Override
	public String getParserRule() {
		return StatechartSpecification.class.getSimpleName();
	}
	

}
