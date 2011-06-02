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
package org.yakindu.sct.statechart.core.resource.services;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.yakindu.model.sct.statechart.Declaration;
import org.yakindu.model.sct.statechart.Scope;
import org.yakindu.model.sct.statechart.State;
import org.yakindu.model.sct.statechart.StatechartFactory;
import org.yakindu.model.sct.statechart.StatechartPackage;
import org.yakindu.sct.statechart.expressions.SimpleScope;

import de.itemis.xtext.utils.gmf.resource.AbstractXtextMemberInjectionService;
import de.itemis.xtext.utils.gmf.resource.IMemberInjectionService;

/**
 * Implementation if {@link IMemberInjectionService} interface to inject the
 * members of the {@link State} from the textual expression.F
 * 
 * @author andreas muelder (andreas.muelder@itemis.de)
 * 
 */
public class StateInjectionService extends
		AbstractXtextMemberInjectionService<State, SimpleScope> {

	@Override
	public String getExpression(State object) {
		return object.getExpression();
	}

	@Override
	public String getParserRule() {
		return SimpleScope.class.getSimpleName();
	}

	@Override
	public void setFeatures(State original, SimpleScope rootAST) {
		Scope localScope = StatechartFactory.eINSTANCE.createScope();
		EList<Declaration> declarations = rootAST.getDeclarations();
		localScope.getDeclarations().addAll(declarations);
		original.getScopes().clear();
		original.getScopes().add(localScope);
	}

	public boolean isServiceFor(EObject object) {
		return object instanceof State;
	}

	public EStructuralFeature getSourceFeature() {
		return StatechartPackage.eINSTANCE.getExpressionElement_Expression();
	}

}
