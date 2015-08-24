package org.yakindu.sct.model.stext.expressions;

import java.io.StringReader;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.resource.impl.ListBasedDiagnosticConsumer;
import org.eclipse.xtext.util.CancelIndicator;
import org.yakindu.base.xtext.utils.jface.viewers.ContextElementAdapter;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.SpecificationElement;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.stext.resource.StextResource;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;

import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class STextExpressionParser implements IExpressionParser {

	@Inject
	private IParser parser;
	@Inject
	private ILinker linker;

	@Inject
	private Injector injector;

	public StextResource getResource() {
		final StextResource resource = new StextResource();
		injector.injectMembers(resource);
		resource.eAdapters().add(new ContextElementAdapter(new ContextElementAdapter.IContextElementProvider() {
			public EObject getContextObject() {
				return (EObject) EcoreUtil.getObjectByType(resource.getContents(), SGraphPackage.Literals.STATECHART);
			}
		}));
		ResourceSet set = new ResourceSetImpl();
		set.getResources().add(resource);
		return resource;
	}

	public EObject parseExpression(String expression, String ruleName) {
		return parseExpression(expression, ruleName, (Scope) null);
	}

	public EObject parseExpression(String expression, String ruleName, Scope... context) {
		StextResource resource = getResource();
		resource.setURI(URI.createURI("path", true));
		ParserRule parserRule = XtextFactory.eINSTANCE.createParserRule();
		parserRule.setName(ruleName);
		IParseResult result = parser.parse(parserRule, new StringReader(expression));
		EObject rootASTElement = result.getRootASTElement();
		resource.getContents().add(rootASTElement);
		ListBasedDiagnosticConsumer diagnosticsConsumer = new ListBasedDiagnosticConsumer();
		if (context != null) {
			Statechart sc = SGraphFactory.eINSTANCE.createStatechart();
			sc.setName("sc");
			resource.getContents().add(sc);
			for (Scope scope : context) {
				if (scope != null) {
					sc.getScopes().add(scope);
					linker.linkModel(scope, diagnosticsConsumer);
				}

			}
		}
		linker.linkModel(result.getRootASTElement(), diagnosticsConsumer);
		resource.resolveLazyCrossReferences(CancelIndicator.NullImpl);
		resource.resolveLazyCrossReferences(CancelIndicator.NullImpl);
		Multimap<SpecificationElement, Diagnostic> diagnostics = resource.getLinkingDiagnostics();
		if (diagnostics.size() > 0) {
			throw new RuntimeException(diagnostics.toString());
		}
		if (result.hasSyntaxErrors()) {
			StringBuilder errorMessages = new StringBuilder();
			Iterable<INode> syntaxErrors = result.getSyntaxErrors();
			for (INode iNode : syntaxErrors) {
				errorMessages.append(iNode.getSyntaxErrorMessage());
				errorMessages.append("\n");
			}
			throw new RuntimeException("Could not parse expression, syntax errors: " + errorMessages);
		}
		if (diagnosticsConsumer.hasConsumedDiagnostics(Severity.ERROR)) {
			throw new RuntimeException("Error during linking: " + diagnosticsConsumer.getResult(Severity.ERROR));
		}
		return rootASTElement;
	}

	public Scope createInternalScope(String contextScope) {
		ParserRule parserRule = XtextFactory.eINSTANCE.createParserRule();
		parserRule.setName(InternalScope.class.getSimpleName());
		IParseResult result = parser.parse(parserRule, new StringReader(contextScope));
		return (Scope) result.getRootASTElement();
	}

	public Scope createInterfaceScope(String contextScope) {
		ParserRule parserRule = XtextFactory.eINSTANCE.createParserRule();
		parserRule.setName(InterfaceScope.class.getSimpleName());
		IParseResult result = parser.parse(parserRule, new StringReader(contextScope));
		return (Scope) result.getRootASTElement();
	}

}