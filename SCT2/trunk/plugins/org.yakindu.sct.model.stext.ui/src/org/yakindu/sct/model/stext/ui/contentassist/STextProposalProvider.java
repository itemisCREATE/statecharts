/**
 * Copyright (c) 2011 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.ui.contentassist;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.yakindu.sct.model.stext.services.STextGrammarAccess;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;
import org.yakindu.sct.model.stext.stext.SimpleScope;
import org.yakindu.sct.model.stext.stext.StatechartSpecification;
import org.yakindu.sct.model.stext.stext.TransitionReaction;

import com.google.inject.Inject;

/**
 * Several filters to make proposals more useful.
 * 
 * @author muehlbrandt
 */
public class STextProposalProvider extends AbstractSTextProposalProvider {

	@Inject
	private STextGrammarAccess grammarAccess;

	/**
	 * Validates if a keyword should be viewed by the proposal view.
	 * 
	 * Builds dependent on the ContentAssistContext a list with keywords which
	 * shouldn't be displayed by the proposal view.
	 */
	@Override
	public void completeKeyword(Keyword keyword,
			ContentAssistContext contentAssistContext,
			ICompletionProposalAcceptor acceptor) {
		List<Keyword> keywords = new ArrayList<Keyword>();
		// context Transition
		if (contentAssistContext.getRootModel() instanceof TransitionReaction) {
			keywords.addAll(getKeywords(grammarAccess.getEntryEventAccess()
					.getGroup().eContents()));
			keywords.addAll(getKeywords(grammarAccess.getExitEventAccess()
					.getGroup().eContents()));
			keywords.addAll(getKeywords(grammarAccess.getOnCycleEventAccess()
					.getGroup().eContents()));
			keywords.addAll(getKeywords(grammarAccess.getAlwaysEventAccess()
					.getGroup().eContents()));
		}
		// context States
		else if (contentAssistContext.getRootModel() instanceof SimpleScope) {
			keywords.addAll(getKeywords(grammarAccess
					.getVariableDefinitionAccess().getGroup().eContents()));
			keywords.addAll(getKeywords(grammarAccess
					.getEventDefinitionAccess().getGroup().eContents()));
			keywords.addAll(getKeywords(grammarAccess.getExitpointAccess()
					.getGroup().eContents()));
			keywords.addAll(getKeywords(grammarAccess.getEntrypointAccess()
					.getGroup().eContents()));
			keywords.addAll(getKeywords(grammarAccess.getDirectionAccess()
					.getAlternatives().eContents()));
			keywords.addAll(getKeywords(grammarAccess.getOperationDefinitionAccess()
					.getGroup().eContents()));
		}
		// context Statechart
		else if (contentAssistContext.getRootModel() instanceof StatechartSpecification) {
			keywords.addAll(getKeywords(grammarAccess.getExitEventAccess()
					.getGroup().eContents()));
			keywords.addAll(getKeywords(grammarAccess.getEntryEventAccess()
					.getGroup().eContents()));
		}

		if (contentAssistContext.getCurrentModel() instanceof InterfaceScope) {
			keywords.addAll(getKeywords(grammarAccess.getLocalReactionAccess()
					.getGroup().eContents()));
			keywords.addAll(getKeywords(grammarAccess.getAlwaysEventAccess()
					.getGroup().eContents()));
			keywords.addAll(getKeywords(grammarAccess.getOnCycleEventAccess()
					.getGroup().eContents()));
			keywords.addAll(getKeywords(grammarAccess.getTimeEventTypeAccess()
					.getAlternatives().eContents()));
			keywords.add(grammarAccess.getDirectionAccess().getLOCALLocalKeyword_0_0());
		}

		if (contentAssistContext.getCurrentModel() instanceof InternalScope) {
			keywords.add(grammarAccess.getDirectionAccess().getINInKeyword_1_0());
			keywords.add(grammarAccess.getDirectionAccess().getOUTOutKeyword_2_0());
		}

		if (!keywords.contains(keyword)) {
			super.completeKeyword(keyword, contentAssistContext, acceptor);
		}
	}

	private List<Keyword> getKeywords(EList<EObject> list) {
		final List<Keyword> keywords = new ArrayList<Keyword>();
		for (EObject eObject : list) {
			if (eObject instanceof Keyword) {
				keywords.add((Keyword) eObject);
			} else if (eObject instanceof EnumLiteralDeclaration) {
				keywords.add(((EnumLiteralDeclaration) eObject).getLiteral());
			}
		}
		return keywords;
	}
}
