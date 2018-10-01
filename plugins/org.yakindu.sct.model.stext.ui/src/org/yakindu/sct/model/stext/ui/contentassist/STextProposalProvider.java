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
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ContentProposalLabelProvider;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.yakindu.base.expressions.expressions.ElementReferenceExpression;
import org.yakindu.base.expressions.expressions.FeatureCall;
import org.yakindu.base.types.Operation;
import org.yakindu.base.types.Type;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.Exit;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SpecificationElement;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.model.stext.extensions.STextExtensions;
import org.yakindu.sct.model.stext.scoping.IPackageImport2URIMapper;
import org.yakindu.sct.model.stext.scoping.IPackageImport2URIMapper.PackageImport;
import org.yakindu.sct.model.stext.services.STextGrammarAccess;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;
import org.yakindu.sct.model.stext.stext.SimpleScope;
import org.yakindu.sct.model.stext.stext.StatechartSpecification;
import org.yakindu.sct.model.stext.stext.StextPackage;
import org.yakindu.sct.model.stext.stext.TransitionReaction;
import org.yakindu.sct.model.stext.stext.TransitionSpecification;
import org.yakindu.sct.model.stext.stext.VariableDefinition;
import org.yakindu.sct.model.stext.ui.internal.STextActivator;

import com.google.common.base.Function;
import com.google.inject.Inject;

/**
 * Several filters to make proposals more useful.
 *
 * @author muehlbrandt
 */
public class STextProposalProvider extends AbstractSTextProposalProvider {

	protected static final String ICONS_INCLUDE = "icons/Package.png";

	@Inject
	protected STextGrammarAccess grammarAccess;
	private ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
	@Inject
	@ContentProposalLabelProvider
	private ILabelProvider labelProvider;
	@Inject
	private IPackageImport2URIMapper mapper;

	@Inject
	private STextExtensions utils;

	public static class StrikeThroughStyler extends Styler {

		@Override
		public void applyStyles(TextStyle textStyle) {
			textStyle.strikeout = true;
		}
	}

	public static class GreyoutStyler extends Styler {

		@Override
		public void applyStyles(TextStyle textStyle) {
			textStyle.foreground = Display.getDefault().getSystemColor(SWT.COLOR_GRAY);
		}
	}

	/**
	 * Validates if a keyword should be viewed by the proposal view.
	 *
	 * Builds dependent on the ContentAssistContext a list with keywords which
	 * shouldn't be displayed by the proposal view.
	 */
	@Override
	public void completeKeyword(Keyword keyword, ContentAssistContext contentAssistContext,
			ICompletionProposalAcceptor acceptor) {
		List<Keyword> suppressKeywords = new ArrayList<>();

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
	protected void suppressKeywords(List<Keyword> suppressKeywords, TransitionSpecification model) {
		suppressKeywords.addAll(getKeywords(grammarAccess.getEntryEventAccess().getGroup().eContents()));
		suppressKeywords.addAll(getKeywords(grammarAccess.getExitEventAccess().getGroup().eContents()));
		suppressKeywords.addAll(getKeywords(grammarAccess.getExitPointSpecAccess().getGroup().eContents()));
		suppressKeywords.addAll(getKeywords(grammarAccess.getExitEventAccess().getExitEventAction_0().eContents()));
		suppressKeywords.addAll(getKeywords(grammarAccess.getExitEventAccess().getExitKeyword_1().eContents()));
	}

	// context States
	protected void suppressKeywords(List<Keyword> suppressKeywords, SimpleScope model) {
		suppressKeywords.addAll(getKeywords(grammarAccess.getVariableDefinitionAccess().getGroup().eContents()));
		suppressKeywords.addAll(getKeywords(grammarAccess.getEventDefinitionAccess().getGroup().eContents()));
		suppressKeywords.addAll(getKeywords(grammarAccess.getDirectionAccess().getAlternatives().eContents()));
		suppressKeywords.addAll(getKeywords(grammarAccess.getOperationDefinitionAccess().getGroup().eContents()));
	}

	// context Statechart
	protected void suppressKeywords(List<Keyword> suppressKeywords, StatechartSpecification model) {
		suppressKeywords.addAll(getKeywords(grammarAccess.getExitEventAccess().getGroup().eContents()));
		suppressKeywords.addAll(getKeywords(grammarAccess.getEntryEventAccess().getGroup().eContents()));
		EList<EObject> importKeyWordList = new BasicEList<>();
		importKeyWordList.add(grammarAccess.getImportScopeAccess().getImportKeyword_1());
		suppressKeywords.addAll(getKeywords(importKeyWordList));
	}

	protected void suppressKeywords(List<Keyword> suppressKeywords, InterfaceScope model) {
		suppressKeywords.addAll(getKeywords(grammarAccess.getLocalReactionAccess().getGroup().eContents()));
		suppressKeywords.addAll(getKeywords(grammarAccess.getAlwaysEventAccess().getGroup().eContents()));
		suppressKeywords.addAll(getKeywords(grammarAccess.getTimeEventTypeAccess().getAlternatives().eContents()));
		suppressKeywords.add(grammarAccess.getDirectionAccess().getLOCALLocalKeyword_0_0());
	}

	protected void suppressKeywords(List<Keyword> suppressKeywords, FeatureCall featureCall) {
		if (!(featureCall.getFeature() instanceof Operation)) {
			suppressKeywords
			.add(grammarAccess.getFeatureCallAccess().getOperationCallLeftParenthesisKeyword_1_3_0_0_0());
		}
	}

	protected void suppressKeywords(List<Keyword> suppressKeywords, ElementReferenceExpression referenceExpression) {
		if (!(referenceExpression.getReference() instanceof Operation)) {
			suppressKeywords.add(grammarAccess.getElementReferenceExpressionAccess()
					.getOperationCallLeftParenthesisKeyword_2_0_0_0());
		}
	}

	protected void suppressKeywords(List<Keyword> suppressKeywords, InternalScope model) {
		suppressKeywords.add(grammarAccess.getDirectionAccess().getLOCALLocalKeyword_0_0());
		suppressKeywords.add(grammarAccess.getDirectionAccess().getINInKeyword_1_0());
		suppressKeywords.add(grammarAccess.getDirectionAccess().getOUTOutKeyword_2_0());
	}

	protected List<Keyword> getKeywords(EList<EObject> list) {
		final List<Keyword> keywords = new ArrayList<>();
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
	protected Function<IEObjectDescription, ICompletionProposal> getProposalFactory(String ruleName,
			ContentAssistContext contentAssistContext) {
		return new DefaultProposalCreator(contentAssistContext, ruleName, getQualifiedNameConverter()) {
			@Override
			public ICompletionProposal apply(IEObjectDescription candidate) {
				ICompletionProposal proposal = super.apply(candidate);
				EObject eObjectOrProxy = candidate.getEObjectOrProxy();
				if (eObjectOrProxy.eIsProxy()) {
					return proposal;
				}
				if (eObjectOrProxy instanceof Operation) {
					Operation operation = (Operation) eObjectOrProxy;
					if (operation.getParameters().size() > 0 && (proposal instanceof ConfigurableCompletionProposal)) {
						ConfigurableCompletionProposal configurableProposal = (ConfigurableCompletionProposal) proposal;
						configurableProposal.setReplacementString(configurableProposal.getReplacementString() + "()");
						configurableProposal.setCursorPosition(configurableProposal.getCursorPosition() + 1);
					}
				}

				return proposal;
			}
		};
	}

	@Override
	public void completeElementReferenceExpression_Reference(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(((CrossReference) assignment.getTerminal()), context, acceptor);
	}

	@Override
	public void completeSimpleElementReferenceExpression_Reference(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(((CrossReference) assignment.getTerminal()), context, acceptor);
	}

	@Override
	public void completeTypeSpecifier_Type(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(((CrossReference) assignment.getTerminal()), context, acceptor);
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

	@Override
	public void completeImportScope_Imports(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		StringProposalDelegate stringProposalDelegate = new StringProposalDelegate(acceptor, context);
		Set<PackageImport> allImports = mapper.getAllImports(model.eResource());
		for (PackageImport pkgImport : allImports) {

			ConfigurableCompletionProposal doCreateProposal = doCreateProposal("\"" + pkgImport.getName() + "\"",
					computePackageStyledString(pkgImport), getIncludeImage(pkgImport),
					pkgImport.getUri().isFile() ? -1 : 1,
							context);

			stringProposalDelegate.accept(doCreateProposal);
		}
	}

	protected Image getIncludeImage(PackageImport pkgImport) {
		final ImageRegistry imageRegistry = STextActivator.getInstance().getImageRegistry();
		return imageRegistry.get(ICONS_INCLUDE);
	}

	protected StyledString computePackageStyledString(PackageImport pkgImport) {
		StyledString firstPart = new StyledString(pkgImport.getName());
		StyledString secondPart = getPackageImportStyleString(pkgImport.getUri());
		return firstPart.append(secondPart);
	}

	protected StyledString getPackageImportStyleString(URI uri) {
		String headerFilePath = uri.isPlatform() ? uri.toPlatformString(true) : uri.toFileString();
		StyledString secondPart = new StyledString(" - " + headerFilePath, new GreyoutStyler());
		return secondPart;
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
		if (element instanceof Type) {
			return super.getDisplayString(element, qualifiedNameAsString, shortName);
		}
		if (element instanceof State) {
			qualifiedNameAsString = getQualifiedNameConverter()
					.toString(getQualifiedNameConverter().toQualifiedName(qualifiedNameAsString).skipFirst(1));
			return super.getDisplayString(element, qualifiedNameAsString, shortName);
		}

		if (element == null || element.eIsProxy()) {
			return qualifiedNameAsString;
		}
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
		ICompletionProposal proposal = createCompletionProposal(proposalText,
				proposalText + " - " + ruleCall.getRule().getName(), null, context);

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
		ICompletionProposal proposal = createCompletionProposal(proposalText,
				proposalText + " - " + ruleCall.getRule().getName(), null, context);
		priorityOptimizer.accept(proposal);
	}

	@Override
	public void complete_IDWithKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof TransitionReaction) {
			SpecificationElement contextElement = utils.getContextElement(model);
			if (contextElement instanceof Transition) {
				Transition transition = (Transition) contextElement;
				// check if outgoing or incoming transition
				EObject eContainer = ruleCall.eContainer();
				Vertex state = null;
				boolean entry = false;
				if (eContainer instanceof Assignment) {
					String feature = ((Assignment) eContainer).getFeature();
					if (StextPackage.Literals.ENTRY_POINT_SPEC__ENTRYPOINT.getName().equals(feature)) {
						state = transition.getTarget();
						entry = true;
					} else if (StextPackage.Literals.EXIT_POINT_SPEC__EXITPOINT.getName().equals(feature)) {
						entry = false;
						state = transition.getSource();
					} else {
						super.complete_ID(model, ruleCall, context, acceptor);
					}
				}
				if (state instanceof State) {
					createContentAssistForEntryAndExit((State) state, entry, context, acceptor);
				}
			}
		}
		super.complete_ID(model, ruleCall, context, acceptor);
	}

	private void createContentAssistForEntryAndExit(State state, boolean entry, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		for (Region region : state.getRegions()) {
			for (Vertex vertex : region.getVertices()) {
				if (entry) {
					if (vertex instanceof Entry) {
						String assist = vertex.getName();
						if (assist.length() > 0) {
							acceptor.accept(createCompletionProposal(assist, context));
						}
					}
				} else {
					if (vertex instanceof Exit) {
						String assist = vertex.getName();
						if (assist.length() > 0) {
							acceptor.accept(createCompletionProposal(assist, context));
						}
					}
				}
			}
		}
	}

	@Override
	public void completeActiveStateReferenceExpression_Value(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(((CrossReference) assignment.getTerminal()), context, acceptor);
	}

	private void alterPriority(ICompletionProposal proposal, int delta) {
		if (proposal == null || !(proposal instanceof ConfigurableCompletionProposal))
			return;
		ConfigurableCompletionProposal castedProposal = (ConfigurableCompletionProposal) proposal;
		castedProposal.setPriority(castedProposal.getPriority() + delta);
	}

	/**
	 * The acceptor delegate creates a Dummy EObject of type Keyword for the User
	 * Help Hover integration
	 *
	 */
	public class AcceptorDelegate implements ICompletionProposalAcceptor {

		private final ICompletionProposalAcceptor delegate;

		public AcceptorDelegate(ICompletionProposalAcceptor delegate) {
			this.delegate = delegate;
		}

		@Override
		public void accept(ICompletionProposal proposal) {
			if (proposal instanceof ConfigurableCompletionProposal) {
				Keyword keyword = XtextFactory.eINSTANCE.createKeyword();
				keyword.setValue(proposal.getDisplayString());
				((ConfigurableCompletionProposal) proposal).setAdditionalProposalInfo(keyword);
				((ConfigurableCompletionProposal) proposal).setHover(STextProposalProvider.this.getHover());
			}
			delegate.accept(proposal);
		}

		@Override
		public boolean canAcceptMoreProposals() {
			return delegate.canAcceptMoreProposals();
		}
	}
}
