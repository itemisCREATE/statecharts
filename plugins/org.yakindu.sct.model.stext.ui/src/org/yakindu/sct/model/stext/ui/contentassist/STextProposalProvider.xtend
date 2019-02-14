/** 
 * Copyright (c) 2011 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * itemis AG - initial API and implementation
 */
package org.yakindu.sct.model.stext.ui.contentassist

import com.google.common.base.Function
import com.google.common.collect.ImmutableList
import com.google.inject.Inject
import java.util.ArrayList
import java.util.List
import java.util.Set
import org.eclipse.emf.common.util.BasicEList
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.edit.provider.ComposedAdapterFactory
import org.eclipse.emf.edit.provider.IItemLabelProvider
import org.eclipse.jface.resource.ImageRegistry
import org.eclipse.jface.text.contentassist.ICompletionProposal
import org.eclipse.jface.viewers.ILabelProvider
import org.eclipse.jface.viewers.StyledString
import org.eclipse.jface.viewers.StyledString.Styler
import org.eclipse.swt.SWT
import org.eclipse.swt.graphics.Image
import org.eclipse.swt.graphics.TextStyle
import org.eclipse.swt.widgets.Display
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.EnumLiteralDeclaration
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.XtextFactory
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.ui.editor.contentassist.AbstractJavaBasedContentProposalProvider.DefaultProposalCreator
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ui.editor.contentassist.ContentProposalLabelProvider
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor
import org.eclipse.xtext.ui.editor.hover.IEObjectHover
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.scoping.IPackageImport2URIMapper
import org.yakindu.base.expressions.scoping.IPackageImport2URIMapper.PackageImport
import org.yakindu.base.types.MetaComposite
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Type
import org.yakindu.sct.model.sgraph.Entry
import org.yakindu.sct.model.sgraph.Exit
import org.yakindu.sct.model.sgraph.Region
import org.yakindu.sct.model.sgraph.SpecificationElement
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Transition
import org.yakindu.sct.model.sgraph.Vertex
import org.yakindu.sct.model.stext.extensions.STextExtensions
import org.yakindu.sct.model.stext.services.STextGrammarAccess
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.stext.RegularEventSpec
import org.yakindu.sct.model.stext.stext.SimpleScope
import org.yakindu.sct.model.stext.stext.StatechartSpecification
import org.yakindu.sct.model.stext.stext.StextPackage
import org.yakindu.sct.model.stext.stext.TransitionReaction
import org.yakindu.sct.model.stext.stext.TransitionSpecification
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.sct.model.stext.ui.internal.StextActivator

/** 
 * Several filters to make proposals more useful.
 * @author muehlbrandt
 */
class STextProposalProvider extends AbstractSTextProposalProvider {
	protected static final String ICONS_INCLUDE = "icons/Package.png"
	
	@Inject 
	protected STextGrammarAccess grammarAccess
	ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory(
		ComposedAdapterFactory.Descriptor.Registry.INSTANCE)
	 
	@Inject 
	@ContentProposalLabelProvider 
	ILabelProvider labelProvider

	@Inject IPackageImport2URIMapper mapper
	@Inject STextExtensions utils

	static class StrikeThroughStyler extends Styler {
		override void applyStyles(TextStyle textStyle) {
			textStyle.strikeout = true
		} 
	}

	static class GreyoutStyler extends Styler {
		override void applyStyles(TextStyle textStyle) {
			textStyle.foreground = Display.getDefault().getSystemColor(SWT.COLOR_GRAY)
		}
	}

	/** 
	 * Validates if a keyword should be viewed by the proposal view.
	 * Builds dependent on the ContentAssistContext a list with keywords which
	 * shouldn't be displayed by the proposal view.
	 */
	override void completeKeyword(Keyword keyword, ContentAssistContext contentAssistContext,
		ICompletionProposalAcceptor acceptor) {
		var List<Keyword> suppressKeywords = new ArrayList()
		var EObject rootModel = contentAssistContext.getRootModel()
		if (rootModel instanceof TransitionSpecification) {
			suppressKeywords(suppressKeywords, rootModel)
		} else if (rootModel instanceof SimpleScope) {
			suppressKeywords(suppressKeywords, rootModel)
		} else if (rootModel instanceof StatechartSpecification) {
			suppressKeywords(suppressKeywords, rootModel)
		}
		var EObject currentModel = contentAssistContext.getCurrentModel()
		if (currentModel instanceof InterfaceScope) {
			suppressKeywords(suppressKeywords, currentModel)
		}
		if (currentModel instanceof FeatureCall) {
			suppressKeywords(suppressKeywords, currentModel)
		}
		if (currentModel instanceof ElementReferenceExpression) {
			suppressKeywords(suppressKeywords, currentModel)
		}
		if (currentModel instanceof InternalScope) {
			suppressKeywords(suppressKeywords, currentModel)
		}
		if (currentModel instanceof RegularEventSpec) {
			suppressMetaCallIfNotApplicable(suppressKeywords, currentModel);
		}
		
		
		if (!suppressKeywords.contains(keyword)) {
			super.completeKeyword(keyword, contentAssistContext, new AcceptorDelegate(acceptor, hover))
		}
	}

	def protected void suppressKeywords(List<Keyword> suppressKeywords, TransitionSpecification model) {
		suppressKeywords.addAll(getKeywords(grammarAccess.getEntryEventAccess().getGroup().eContents()))
		suppressKeywords.addAll(getKeywords(grammarAccess.getExitEventAccess().getGroup().eContents()))
		suppressKeywords.addAll(getKeywords(grammarAccess.getExitPointSpecAccess().getGroup().eContents()))
		suppressKeywords.addAll(getKeywords(grammarAccess.getExitEventAccess().getExitEventAction_0().eContents()))
		suppressKeywords.addAll(getKeywords(grammarAccess.getExitEventAccess().getExitKeyword_1().eContents()))
	}

	def protected void suppressKeywords(List<Keyword> suppressKeywords, SimpleScope model) {
		suppressKeywords.addAll(getKeywords(grammarAccess.getInternalScopeAccess().getGroup().eContents()))
		suppressKeywords.addAll(getKeywords(grammarAccess.getDirectionAccess().getAlternatives().eContents()))
	}

	def protected void suppressKeywords(List<Keyword> suppressKeywords, StatechartSpecification model) {
		var EList<EObject> importKeyWordList = new BasicEList()
		importKeyWordList.add(grammarAccess.getImportScopeAccess().getImportKeyword_1())
		suppressKeywords.addAll(getKeywords(importKeyWordList))
	}

	def protected void suppressKeywords(List<Keyword> suppressKeywords, InterfaceScope model) {
		suppressKeywords.addAll(getKeywords(grammarAccess.getLocalReactionAccess().getGroup().eContents()))
		suppressKeywords.addAll(getKeywords(grammarAccess.getAlwaysEventAccess().getGroup().eContents()))
		suppressKeywords.addAll(getKeywords(grammarAccess.getTimeEventTypeAccess().getAlternatives().eContents()))
	}

	def protected void suppressKeywords(List<Keyword> suppressKeywords, FeatureCall featureCall) {
		if (!(featureCall.getFeature() instanceof Operation)) {
			suppressKeywords.add(
				grammarAccess.getFeatureCallAccess().getOperationCallLeftParenthesisKeyword_1_2_0_0_0())
		}
		
		suppressMetaCallIfNotApplicable(suppressKeywords, featureCall.feature)
	}
 
	def protected void suppressKeywords(List<Keyword> suppressKeywords,
		ElementReferenceExpression referenceExpression) {
		if (!(referenceExpression.getReference() instanceof Operation)) {
			suppressKeywords.add(
				grammarAccess.getElementReferenceExpressionAccess().getOperationCallLeftParenthesisKeyword_2_0_0_0())
		}

		suppressMetaCallIfNotApplicable(suppressKeywords, referenceExpression.reference)
	}


	def protected void suppressMetaCallIfNotApplicable(List<Keyword> suppressKeywords, EObject obj) {
		
		if ( !(obj instanceof MetaComposite)
			|| (obj as MetaComposite).metaFeatures.empty ) {
			suppressKeywords.add(grammarAccess.featureCallAccess.getFullStopCommercialAtKeyword_1_0_1_1())
			suppressKeywords.add(grammarAccess.simpleFeatureCallAccess.getFullStopCommercialAtKeyword_1_0_1_1())
		}
	}


	def protected void suppressKeywords(List<Keyword> suppressKeywords, InternalScope model) {
		suppressKeywords.add(grammarAccess.getDirectionAccess().getINInKeyword_0_0())
		suppressKeywords.add(grammarAccess.getDirectionAccess().getOUTOutKeyword_1_0())
	}

	def protected List<Keyword> getKeywords(EList<EObject> list) {
		val List<Keyword> keywords = new ArrayList()
		for (EObject eObject : list) {
			if (eObject instanceof Keyword) {
				keywords.add(eObject)
			} else if (eObject instanceof EnumLiteralDeclaration) {
				keywords.add(eObject.getLiteral())
			}
		}
		return keywords
	}

	override protected Function<IEObjectDescription, ICompletionProposal> getProposalFactory(String ruleName,
		ContentAssistContext contentAssistContext) {
		return new DefaultProposalCreator(contentAssistContext, ruleName, getQualifiedNameConverter()) {
			override ICompletionProposal apply(IEObjectDescription candidate) {
				var ICompletionProposal proposal = super.apply(candidate)
				var EObject eObjectOrProxy = candidate.getEObjectOrProxy()
				if (eObjectOrProxy.eIsProxy()) {
					return proposal
				}
				if (eObjectOrProxy instanceof Operation) {
					var Operation operation = eObjectOrProxy
					if (operation.getParameters().size() > 0 && (proposal instanceof ConfigurableCompletionProposal)) {
						var ConfigurableCompletionProposal configurableProposal = (proposal as ConfigurableCompletionProposal)
						configurableProposal.setReplacementString('''«configurableProposal.getReplacementString()»()''')
						configurableProposal.setCursorPosition(configurableProposal.getCursorPosition() + 1)
					}
				}
				return proposal
			}
		}
	}

	override void completeElementReferenceExpression_Reference(EObject model, Assignment assignment,
		ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(((assignment.getTerminal() as CrossReference)), context, acceptor)
	}

	override void completeSimpleElementReferenceExpression_Reference(EObject model, Assignment assignment,
		ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(((assignment.getTerminal() as CrossReference)), context, acceptor)
	}

	override void completeTypeSpecifier_Type(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(((assignment.getTerminal() as CrossReference)), context, acceptor)
	}

	override void complete_BOOL(EObject model, RuleCall ruleCall, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		var ICompletionProposalAcceptor priorityOptimizer = getCustomAcceptor(model, "boolean", acceptor)
		for (String s : ImmutableList.of("true", "false", "yes", "no")) {
			var ICompletionProposal proposal = createCompletionProposal(s, '''«s» - «ruleCall.getRule().getName()»''',
				null, context)
			priorityOptimizer.accept(proposal)
		}
	}

	override void completeImportScope_Imports(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		var StringProposalDelegate stringProposalDelegate = new StringProposalDelegate(acceptor, context)
		var Set<PackageImport> allImports = mapper.getAllImports(model.eResource())
		for (PackageImport pkgImport : allImports) {
			var ICompletionProposal doCreateProposal = createCompletionProposal('''"«pkgImport.getName()»"''',
				computePackageStyledString(pkgImport), getIncludeImage(pkgImport),
				if(pkgImport.getUri().isPlatformResource()) 1 else -1, context.getPrefix(), context)
			stringProposalDelegate.accept(doCreateProposal)
		}
	}

	override ICompletionProposal createCompletionProposal(String proposal, StyledString displayString, Image image,
		ContentAssistContext contentAssistContext) {
		return createCompletionProposal(proposal, displayString, image, getPriorityHelper().getDefaultPriority(),
			contentAssistContext.getPrefix(), contentAssistContext)
	}

	def protected Image getIncludeImage(PackageImport pkgImport) {
		val ImageRegistry imageRegistry = StextActivator.getInstance().getImageRegistry()
		return imageRegistry.get(ICONS_INCLUDE)
	}

	def protected StyledString computePackageStyledString(PackageImport pkgImport) {
		var StyledString firstPart = new StyledString(pkgImport.getName())
		var StyledString secondPart = getPackageImportStyleString(pkgImport.getUri())
		return firstPart.append(secondPart)
	}

	def protected StyledString getPackageImportStyleString(URI uri) {
		var String filePath = if(uri.isPlatform()) uri.toPlatformString(true) else uri.toFileString()
		var StyledString secondPart = new StyledString(''' - «filePath»''', new GreyoutStyler())
		return secondPart
	}

	def protected ICompletionProposalAcceptor getCustomAcceptor(EObject model, String typeName,
		ICompletionProposalAcceptor acceptor) {
		var ICompletionProposalAcceptor priorityOptimizer = acceptor
		if (model instanceof VariableDefinition) {
			var VariableDefinition vd = model
			if (vd.getType() !== null && typeName.equalsIgnoreCase(vd.getType().getName())) {
				priorityOptimizer = new ICompletionProposalAcceptor.Delegate(acceptor) {
					override void accept(ICompletionProposal proposal) {
						alterPriority(proposal, 1)
						super.accept(proposal)
					}
				}
			}
		}
		return priorityOptimizer
	}

	override protected String getDisplayString(EObject element, String qualifiedNameAsString_finalParam_,
		String shortName) {
		var qualifiedNameAsString = qualifiedNameAsString_finalParam_
		if (element instanceof Type) {
			return super.getDisplayString(element, qualifiedNameAsString, shortName)
		}
		if (element instanceof State) {
			qualifiedNameAsString = getQualifiedNameConverter().toString(
				getQualifiedNameConverter().toQualifiedName(qualifiedNameAsString).skipFirst(1))
			return super.getDisplayString(element, qualifiedNameAsString, shortName)
		}
		if (element === null || element.eIsProxy()) {
			return qualifiedNameAsString
		}
		var IItemLabelProvider adapter = (composedAdapterFactory.adapt(element,
			IItemLabelProvider) as IItemLabelProvider)
		if (adapter !== null) {
			return adapter.getText(element)
		}
		return super.getDisplayString(element, qualifiedNameAsString, shortName)
	}

	override void complete_STRING(EObject model, RuleCall ruleCall, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		super.complete_STRING(model, ruleCall, context, getCustomAcceptor(model, "string", acceptor))
	}

	override void complete_INT(EObject model, RuleCall ruleCall, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		super.complete_INT(model, ruleCall, context, getCustomAcceptor(model, "integer", acceptor))
	}

	def void complete_XID(EObject model, RuleCall ruleCall, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		complete_ID(model, ruleCall, context, acceptor)
	}

	override void complete_HEX(EObject model, RuleCall ruleCall, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		var ICompletionProposalAcceptor priorityOptimizer = getCustomAcceptor(model, "integer", acceptor)
		var String proposalText = "0x1"
		var ICompletionProposal proposal = createCompletionProposal(
			proposalText, '''«proposalText» - «ruleCall.getRule().getName()»''', null, context)
		if (proposal instanceof ConfigurableCompletionProposal) {
			var ConfigurableCompletionProposal configurable = proposal
			configurable.setSelectionStart(configurable.getReplacementOffset() + 2)
			configurable.setSelectionLength(proposalText.length() - 2)
			configurable.setAutoInsertable(false)
			configurable.setSimpleLinkedMode(context.getViewer(), Character.valueOf('\t').charValue,
				Character.valueOf(' ').charValue)
		}
		priorityOptimizer.accept(proposal)
	}

	override void complete_DOUBLE(EObject model, RuleCall ruleCall, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		var ICompletionProposalAcceptor priorityOptimizer = getCustomAcceptor(model, "real", acceptor)
		var String proposalText = "0.1"
		var ICompletionProposal proposal = createCompletionProposal(
			proposalText, '''«proposalText» - «ruleCall.getRule().getName()»''', null, context)
		priorityOptimizer.accept(proposal)
	}

	override void complete_IDWithKeywords(EObject model, RuleCall ruleCall, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		if (model instanceof TransitionReaction) {
			var SpecificationElement contextElement = utils.getContextElement(model)
			if (contextElement instanceof Transition) {
				var Transition transition = contextElement
				var EObject eContainer = ruleCall.eContainer()
				var Vertex state = null
				var boolean entry = false
				if (eContainer instanceof Assignment) {
					var String feature = eContainer.getFeature()
					if (StextPackage.Literals.ENTRY_POINT_SPEC__ENTRYPOINT.getName().equals(feature)) {
						state = transition.getTarget()
						entry = true
					} else if (StextPackage.Literals.EXIT_POINT_SPEC__EXITPOINT.getName().equals(feature)) {
						entry = false
						state = transition.getSource()
					} else {
						super.complete_ID(model, ruleCall, context, acceptor)
					}
				}
				if (state instanceof State) {
					createContentAssistForEntryAndExit(state, entry, context, acceptor)
				}
			}
		}
		super.complete_ID(model, ruleCall, context, acceptor)
	}

	def private void createContentAssistForEntryAndExit(State state, boolean entry, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		for (Region region : state.getRegions()) {
			for (Vertex vertex : region.getVertices()) {
				if (entry) {
					if (vertex instanceof Entry) {
						var String assist = vertex.getName()
						if (assist.length() > 0) {
							acceptor.accept(createCompletionProposal(assist, context))
						}
					}
				} else {
					if (vertex instanceof Exit) {
						var String assist = vertex.getName()
						if (assist.length() > 0) {
							acceptor.accept(createCompletionProposal(assist, context))
						}
					}
				}
			}
		}
	}

	override void completeActiveStateReferenceExpression_Value(EObject model, Assignment assignment,
		ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(((assignment.getTerminal() as CrossReference)), context, acceptor)
	}

	def private void alterPriority(ICompletionProposal proposal, int delta) {
		if(proposal === null || !(proposal instanceof ConfigurableCompletionProposal)) return;
		var ConfigurableCompletionProposal castedProposal = (proposal as ConfigurableCompletionProposal)
		castedProposal.setPriority(castedProposal.getPriority() + delta)
	}

	/* FIXME Non-static inner classes are not supported.*/
	/** 
	 * The acceptor delegate creates a Dummy EObject of type Keyword for the User
	 * Help Hover integration
	 */
	static class AcceptorDelegate implements ICompletionProposalAcceptor {
		final ICompletionProposalAcceptor delegate
		final IEObjectHover hover;

		new(ICompletionProposalAcceptor delegate, IEObjectHover hover) {
			this.delegate = delegate
			this.hover = hover
		}

		override void accept(ICompletionProposal proposal) {
			if (proposal instanceof ConfigurableCompletionProposal) {
				var Keyword keyword = XtextFactory.eINSTANCE.createKeyword()
				keyword.setValue(proposal.getDisplayString())
				proposal.setAdditionalProposalInfo(keyword)
				proposal.setHover(hover)
			}
			delegate.accept(proposal)
		}

		override boolean canAcceptMoreProposals() {
			return delegate.canAcceptMoreProposals()
		}
	}
}
