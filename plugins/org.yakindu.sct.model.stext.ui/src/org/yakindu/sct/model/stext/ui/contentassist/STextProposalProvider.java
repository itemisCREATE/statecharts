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

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ContentProposalLabelProvider;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.yakindu.base.expressions.expressions.ElementReferenceExpression;
import org.yakindu.base.expressions.expressions.FeatureCall;
import org.yakindu.base.types.Operation;
import org.yakindu.sct.model.stext.services.STextGrammarAccess;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;
import org.yakindu.sct.model.stext.stext.SimpleScope;
import org.yakindu.sct.model.stext.stext.StatechartSpecification;
import org.yakindu.sct.model.stext.stext.TransitionSpecification;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

import com.google.inject.Inject;

/**
 * Several filters to make proposals more useful.
 * 
 * @author muehlbrandt
 */
public class STextProposalProvider extends AbstractSTextProposalProvider {

	@Inject
	private STextGrammarAccess grammarAccess;
	private ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
	@Inject
	@ContentProposalLabelProvider
	private ILabelProvider labelProvider;

	/**
	 * Validates if a keyword should be viewed by the proposal view.
	 * 
	 * Builds dependent on the ContentAssistContext a list with keywords which
	 * shouldn't be displayed by the proposal view.
	 */
	@Override
	public void completeKeyword(Keyword keyword, ContentAssistContext contentAssistContext,
			ICompletionProposalAcceptor acceptor) {
		List<Keyword> suppressKeywords = new ArrayList<Keyword>();

		EObject rootModel = contentAssistContext.getRootModel();
		if (rootModel instanceof TransitionSpecification) {
			suppressKeywords(suppressKeywords, (TransitionSpecification) rootModel);
		} else if (rootModel instanceof SimpleScope) {
			suppressKeywords(suppressKeywords, (SimpleScope) rootModel);
		} else if (rootModel instanceof StatechartSpecification) {
			suppressKeywords(suppressKeywords, (StatechartSpecification) rootModel);
		}

		EObject currentModel = contentAssistContext.getCurrentModel();
		if (currentModel instanceof InterfaceScope) {
			suppressKeywords(suppressKeywords, (InterfaceScope) currentModel);
		}

		if (currentModel instanceof FeatureCall) {
			suppressKeywords(suppressKeywords, (FeatureCall) currentModel);
		}
		if (currentModel instanceof ElementReferenceExpression) {
			suppressKeywords(suppressKeywords, (ElementReferenceExpression) currentModel);
		}
		if (currentModel instanceof InternalScope) {
			suppressKeywords(suppressKeywords, (InternalScope) currentModel);
		}

		if (!suppressKeywords.contains(keyword)) {
			super.completeKeyword(keyword, contentAssistContext, new AcceptorDelegate(acceptor));

		}
	}

	// context Transition
	private void suppressKeywords(List<Keyword> suppressKeywords, TransitionSpecification model) {
		suppressKeywords.addAll(getKeywords(grammarAccess.getEntryEventAccess().getGroup().eContents()));
		suppressKeywords.addAll(getKeywords(grammarAccess.getExitEventAccess().getGroup().eContents()));
	}

	// context States
	private void suppressKeywords(List<Keyword> suppressKeywords, SimpleScope model) {
		suppressKeywords.addAll(getKeywords(grammarAccess.getVariableDefinitionAccess().getGroup().eContents()));
		suppressKeywords.addAll(getKeywords(grammarAccess.getEventDefinitionAccess().getGroup().eContents()));
		suppressKeywords.addAll(getKeywords(grammarAccess.getDirectionAccess().getAlternatives().eContents()));
		suppressKeywords.addAll(getKeywords(grammarAccess.getOperationDefinitionAccess().getGroup().eContents()));
	}

	// context Statechart
	private void suppressKeywords(List<Keyword> suppressKeywords, StatechartSpecification model) {
		suppressKeywords.addAll(getKeywords(grammarAccess.getExitEventAccess().getGroup().eContents()));
		suppressKeywords.addAll(getKeywords(grammarAccess.getEntryEventAccess().getGroup().eContents()));
		EList<EObject> importKeyWordList = new BasicEList<EObject>();
		importKeyWordList.add(grammarAccess.getImportScopeAccess().getImportKeyword_1());
		suppressKeywords.addAll(getKeywords(importKeyWordList));
	}

	private void suppressKeywords(List<Keyword> suppressKeywords, InterfaceScope model) {
		suppressKeywords.addAll(getKeywords(grammarAccess.getLocalReactionAccess().getGroup().eContents()));
		suppressKeywords.addAll(getKeywords(grammarAccess.getAlwaysEventAccess().getGroup().eContents()));
		suppressKeywords.addAll(getKeywords(grammarAccess.getTimeEventTypeAccess().getAlternatives().eContents()));
		suppressKeywords.add(grammarAccess.getDirectionAccess().getLOCALLocalKeyword_0_0());
	}

	private void suppressKeywords(List<Keyword> suppressKeywords, FeatureCall featureCall) {
		if (!(featureCall.getFeature() instanceof Operation)) {
			suppressKeywords.add(grammarAccess.getFeatureCallAccess().getOperationCallLeftParenthesisKeyword_1_3_0_0());
		}
	}

	private void suppressKeywords(List<Keyword> suppressKeywords, ElementReferenceExpression referenceExpression) {
		if (!(referenceExpression.getReference() instanceof Operation)) {
			suppressKeywords.add(grammarAccess.getElementReferenceExpressionAccess()
					.getOperationCallLeftParenthesisKeyword_2_0_0());
		}
	}

	private void suppressKeywords(List<Keyword> suppressKeywords, InternalScope model) {
		suppressKeywords.add(grammarAccess.getDirectionAccess().getINInKeyword_1_0());
		suppressKeywords.add(grammarAccess.getDirectionAccess().getOUTOutKeyword_2_0());
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

	@Override
	public void complete_BOOL(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		ICompletionProposalAcceptor priorityOptimizer = getCustomAcceptor(model, "boolean", acceptor);

		for (String s : new String[] { "true", "false", "yes", "no" }) {
			ICompletionProposal proposal = createCompletionProposal(s, s + " - " + ruleCall.getRule().getName(), null,
					context);

			priorityOptimizer.accept(proposal);
		}
	}

	protected ICompletionProposalAcceptor getCustomAcceptor(EObject model, String typeName,
			ICompletionProposalAcceptor acceptor) {
		ICompletionProposalAcceptor priorityOptimizer = acceptor;
		if (model instanceof VariableDefinition) {
			VariableDefinition vd = (VariableDefinition) model;
			if (vd.getType() != null && typeName.equalsIgnoreCase(vd.getType().getName())) {
				priorityOptimizer = new ICompletionProposalAcceptor.Delegate(acceptor) {
					@Override
					public void accept(ICompletionProposal proposal) {
						alterPriority(proposal, 1);
						super.accept(proposal);
					}
				};
			}
		}
		return priorityOptimizer;
	}

	@Override
	protected String getDisplayString(EObject element, String qualifiedNameAsString, String shortName) {
		IItemLabelProvider adapter = (IItemLabelProvider) composedAdapterFactory.adapt(element,
				IItemLabelProvider.class);
		if (adapter != null) {
			return adapter.getText(element);
		}
		return super.getDisplayString(element, qualifiedNameAsString, shortName);
	}

	@Override
	public void complete_STRING(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {

		super.complete_STRING(model, ruleCall, context, getCustomAcceptor(model, "string", acceptor));
	}

	@Override
	public void complete_INT(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		super.complete_INT(model, ruleCall, context, getCustomAcceptor(model, "integer", acceptor));
	}

	public void complete_XID(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		complete_ID(model, ruleCall, context, acceptor);
	}

	@Override
	public void complete_HEX(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		ICompletionProposalAcceptor priorityOptimizer = getCustomAcceptor(model, "integer", acceptor);

		String proposalText = "0x1";
		ICompletionProposal proposal = createCompletionProposal(proposalText, proposalText + " - "
				+ ruleCall.getRule().getName(), null, context);

		if (proposal instanceof ConfigurableCompletionProposal) {
			ConfigurableCompletionProposal configurable = (ConfigurableCompletionProposal) proposal;
			configurable.setSelectionStart(configurable.getReplacementOffset() + 2);
			configurable.setSelectionLength(proposalText.length() - 2);
			configurable.setAutoInsertable(false);
			configurable.setSimpleLinkedMode(context.getViewer(), '\t', ' ');
		}

		priorityOptimizer.accept(proposal);
	}

	@Override
	public void complete_DOUBLE(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		ICompletionProposalAcceptor priorityOptimizer = getCustomAcceptor(model, "real", acceptor);

		String proposalText = "0.1";
		ICompletionProposal proposal = createCompletionProposal(proposalText, proposalText + " - "
				+ ruleCall.getRule().getName(), null, context);
		priorityOptimizer.accept(proposal);
	}

	private void alterPriority(ICompletionProposal proposal, int delta) {
		if (proposal == null || !(proposal instanceof ConfigurableCompletionProposal))
			return;
		ConfigurableCompletionProposal castedProposal = (ConfigurableCompletionProposal) proposal;
		castedProposal.setPriority(castedProposal.getPriority() + delta);
	}

	/**
	 * The acceptor delegate creates a Dummy EObject of type Keyword for the
	 * User Help Hover integration
	 * 
	 */
	public class AcceptorDelegate implements ICompletionProposalAcceptor {

		private final ICompletionProposalAcceptor delegate;

		public AcceptorDelegate(ICompletionProposalAcceptor delegate) {
			this.delegate = delegate;
		}

		public void accept(ICompletionProposal proposal) {
			if (proposal instanceof ConfigurableCompletionProposal) {
				Keyword keyword = XtextFactory.eINSTANCE.createKeyword();
				keyword.setValue(proposal.getDisplayString());
				((ConfigurableCompletionProposal) proposal).setAdditionalProposalInfo(keyword);
				((ConfigurableCompletionProposal) proposal).setHover(STextProposalProvider.this.getHover());
			}
			delegate.accept(proposal);
		}

		public boolean canAcceptMoreProposals() {
			return delegate.canAcceptMoreProposals();
		}
	}
}
