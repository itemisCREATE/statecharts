/**
 * Copyright (c) 2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.stext.expressions;

import java.io.StringReader;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
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
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.SpecificationElement;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.util.ContextElementAdapter;
import org.yakindu.sct.model.stext.resource.StextResource;
import org.yakindu.sct.model.stext.scoping.STextLibraryGlobalScopeProvider;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;

import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;

public class STextExpressionParser implements IExpressionParser {

	public static class LinkingException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public LinkingException(String msg) {
			super(msg);
		}
	}

	public static class SyntaxException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public SyntaxException(String msg) {
			super(msg);
		}
	}

	@Inject
	private IParser parser;
	@Inject
	private ILinker linker;
	@Inject
	private Injector injector;

	@Inject
	@Named(DomainRegistry.DOMAIN_ID)
	private String domainId;

	public StextResource getResource() {
		final StextResource resource = new StextResource();
		injector.injectMembers(resource);
		resource.eAdapters().add(new ContextElementAdapter() {
			@Override
			public EObject getElement() {
				return (EObject) EcoreUtil.getObjectByType(resource.getContents(), SGraphPackage.Literals.STATECHART);
			}
		});
		ResourceSet set = new ResourceSetImpl();
		set.getResources().add(resource);
		return resource;
	}

	public EObject parseExpression(String expression, String ruleName) {
		return parseExpression(expression, ruleName, (String) null);
	}

	public EObject parseExpression(String expression, String ruleName, String specification) {
		StextResource resource = getResource();
		resource.setURI(URI.createPlatformResourceURI(getUri(), true));
		
		// add parsed expression
		ParserRule parserRule = XtextFactory.eINSTANCE.createParserRule();
		parserRule.setName(ruleName);
		IParseResult result = parser.parse(parserRule, new StringReader(expression));
		EObject rootASTElement = result.getRootASTElement();
		resource.getContents().add(rootASTElement);
		
		// add statechart
		Statechart sc = SGraphFactory.eINSTANCE.createStatechart();
		sc.setDomainID(domainId);
		sc.setName("sc");
		if (specification != null) {
			sc.setSpecification(specification);
		}
		resource.getContents().add(sc);
		
		// add stext library contents
		Resource stextLib = new ResourceSetImpl().getResource(STextLibraryGlobalScopeProvider.STEXT_LIB, true);
		resource.getContents().add(stextLib.getContents().get(0));
		
		resource.getLinkingDiagnostics().clear();
		ListBasedDiagnosticConsumer diagnosticsConsumer = new ListBasedDiagnosticConsumer();
		linker.linkModel(sc, diagnosticsConsumer);
		linker.linkModel(rootASTElement, diagnosticsConsumer);
		resource.resolveLazyCrossReferences(CancelIndicator.NullImpl);
		resource.resolveLazyCrossReferences(CancelIndicator.NullImpl);
		Multimap<SpecificationElement, Diagnostic> diagnostics = resource.getLinkingDiagnostics();
		if (diagnostics.size() > 0) {
			throw new LinkingException(diagnostics.toString());
		}
		if (result.hasSyntaxErrors()) {
			StringBuilder errorMessages = new StringBuilder();
			Iterable<INode> syntaxErrors = result.getSyntaxErrors();
			for (INode iNode : syntaxErrors) {
				errorMessages.append(iNode.getSyntaxErrorMessage());
				errorMessages.append("\n");
			}
			throw new SyntaxException("Could not parse expression, syntax errors: " + errorMessages);
		}
		if (diagnosticsConsumer.hasConsumedDiagnostics(Severity.ERROR)) {
			throw new LinkingException("Error during linking: " + diagnosticsConsumer.getResult(Severity.ERROR));
		}
		return rootASTElement;
	}

	protected String getUri() {
		return "path";
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