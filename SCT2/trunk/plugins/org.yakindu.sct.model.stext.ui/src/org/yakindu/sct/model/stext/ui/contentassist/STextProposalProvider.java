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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.yakindu.base.expressions.expressions.ElementReferenceExpression;
import org.yakindu.base.expressions.expressions.FeatureCall;
import org.yakindu.base.types.Operation;
import org.yakindu.base.types.TypesPackage;
import org.yakindu.sct.model.stext.services.STextGrammarAccess;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;
import org.yakindu.sct.model.stext.stext.SimpleScope;
import org.yakindu.sct.model.stext.stext.StatechartSpecification;
import org.yakindu.sct.model.stext.stext.TransitionSpecification;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

import de.itemis.xtext.utils.jface.viewers.ContextElementAdapter;

/**
 * Several filters to make proposals more useful.
 * 
 * @author muehlbrandt
 */
public class STextProposalProvider extends AbstractSTextProposalProvider {

	@Inject
	private STextGrammarAccess grammarAccess;
	@Inject
	private IContainer.Manager containerManager;
	@Inject
	private ResourceDescriptionsProvider resourceDescriptionsProvider;

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
		// context Transition
		if (contentAssistContext.getRootModel() instanceof TransitionSpecification) {
			suppressKeywords.addAll(getKeywords(grammarAccess.getEntryEventAccess().getGroup().eContents()));
			suppressKeywords.addAll(getKeywords(grammarAccess.getExitEventAccess().getGroup().eContents()));
		}
		// context States
		else if (contentAssistContext.getRootModel() instanceof SimpleScope) {
			suppressKeywords.addAll(getKeywords(grammarAccess.getVariableDefinitionAccess().getGroup().eContents()));
			suppressKeywords.addAll(getKeywords(grammarAccess.getEventDefinitionAccess().getGroup().eContents()));
			// suppressKeywords.addAll(getKeywords(grammarAccess.getExitpointAccess()
			// .getGroup().eContents()));
			// suppressKeywords.addAll(getKeywords(grammarAccess.getEntrypointAccess()
			// .getGroup().eContents()));
			suppressKeywords.addAll(getKeywords(grammarAccess.getDirectionAccess().getAlternatives().eContents()));
			suppressKeywords.addAll(getKeywords(grammarAccess.getOperationDefinitionAccess().getGroup().eContents()));
		}
		// context Statechart
		else if (contentAssistContext.getRootModel() instanceof StatechartSpecification) {
			suppressKeywords.addAll(getKeywords(grammarAccess.getExitEventAccess().getGroup().eContents()));
			suppressKeywords.addAll(getKeywords(grammarAccess.getEntryEventAccess().getGroup().eContents()));
			
			if (!atLeastOnePackageExistsInIndex(getSctResource(contentAssistContext.getRootModel()))) {
				suppressKeywords.addAll(getKeywords(grammarAccess.getImportScopeAccess().getGroup().eContents()));
			}
		}

		EObject currentModel = contentAssistContext.getCurrentModel();
		if (currentModel instanceof InterfaceScope) {
			suppressKeywords.addAll(getKeywords(grammarAccess.getLocalReactionAccess().getGroup().eContents()));
			suppressKeywords.addAll(getKeywords(grammarAccess.getAlwaysEventAccess().getGroup().eContents()));
			// suppressKeywords.addAll(getKeywords(grammarAccess.getOnCycleEventAccess()
			// .getGroup().eContents()));
			suppressKeywords.addAll(getKeywords(grammarAccess.getTimeEventTypeAccess().getAlternatives().eContents()));
			suppressKeywords.add(grammarAccess.getDirectionAccess().getLOCALLocalKeyword_0_0());
		}

		if (currentModel instanceof FeatureCall) {
			FeatureCall featureCall = (FeatureCall) currentModel;
			if (!(featureCall.getFeature() instanceof Operation)) {
				suppressKeywords.add(grammarAccess.getFeatureCallAccess()
						.getOperationCallLeftParenthesisKeyword_1_3_0_0());
			}
		}
		if (currentModel instanceof ElementReferenceExpression) {
			ElementReferenceExpression referenceExpression = (ElementReferenceExpression) currentModel;
			if (!(referenceExpression.getReference() instanceof Operation)) {
				suppressKeywords.add(grammarAccess.getElementReferenceExpressionAccess()
						.getOperationCallLeftParenthesisKeyword_2_0_0());
			}
		}
		if (currentModel instanceof InternalScope) {
			suppressKeywords.add(grammarAccess.getDirectionAccess().getINInKeyword_1_0());
			suppressKeywords.add(grammarAccess.getDirectionAccess().getOUTOutKeyword_2_0());
		}

		if (!suppressKeywords.contains(keyword)) {
			super.completeKeyword(keyword, contentAssistContext, new AcceptorDelegate(acceptor));

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
	
	private boolean atLeastOnePackageExistsInIndex(Resource res) {
		IResourceDescriptions resourceDescriptions = resourceDescriptionsProvider.getResourceDescriptions(res);
		URI uri = res.getURI();
		IResourceDescription resourceDescription = resourceDescriptions.getResourceDescription(uri);
		for (IContainer container : containerManager.getVisibleContainers(resourceDescription, resourceDescriptions)) {
			final Iterable<IResourceDescription> currentDescriptions = container.getResourceDescriptions();
			for (IResourceDescription resDesc : currentDescriptions) {
				Iterable<IEObjectDescription> visisblePackages = resDesc
						.getExportedObjectsByType(TypesPackage.Literals.PACKAGE);
				if (!Iterables.isEmpty(visisblePackages)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private Resource getSctResource(EObject context) {
		final ContextElementAdapter provider = (ContextElementAdapter) EcoreUtil.getExistingAdapter(
				context.eResource(), ContextElementAdapter.class);
		if (provider == null) {
			return context.eResource();
		} else {
			return provider.getElement().eResource();
		}
	}

}
