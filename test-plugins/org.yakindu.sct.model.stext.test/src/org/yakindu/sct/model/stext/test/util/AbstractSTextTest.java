/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.stext.test.util;

import static org.yakindu.sct.model.sgraph.test.util.SgraphTestFactory._createStatechart;

import java.io.StringReader;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.ListBasedDiagnosticConsumer;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.inject.Inject;
import com.google.inject.Provider;

import de.itemis.xtext.utils.jface.viewers.ContextElementAdapter;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractSTextTest {

	@Inject
	private IParser parser;
	@Inject
	private ILinker linker;
	@Inject
	private Provider<XtextResource> resourceProvider;

	protected XtextResource getResource() {
		final XtextResource resource = resourceProvider.get();
		resource.eAdapters().add(
				new ContextElementAdapter(
						new ContextElementAdapter.IContextElementProvider() {
							public EObject getContextObject() {
								return (EObject) EcoreUtil.getObjectByType(
										resource.getContents(),
										SGraphPackage.Literals.STATECHART);
							}
						}));
		return resource;
	}

	protected EObject parseExpression(String expression, Scope context,
			String ruleName) {
		XtextResource resource = getResource();
		Statechart sc = _createStatechart("myStatechart");
		resource.getContents().add(sc);
		sc.getScopes().add(context);
		resource.setURI(URI.createPlatformPluginURI("path", true));
		ParserRule parserRule = XtextFactory.eINSTANCE.createParserRule();
		parserRule.setName(ruleName);
		IParseResult result = parser.parse(parserRule, new StringReader(
				expression));
		EObject rootASTElement = result.getRootASTElement();
		resource.getContents().add(rootASTElement);
		ListBasedDiagnosticConsumer diagnosticsConsumer = new ListBasedDiagnosticConsumer();
		if (context != null) {
			resource.getContents().add(context);
			linker.linkModel(context, diagnosticsConsumer);
		}
		linker.linkModel(result.getRootASTElement(), diagnosticsConsumer);
		if (result.hasSyntaxErrors()) {
			StringBuilder errorMessages = new StringBuilder();
			Iterable<INode> syntaxErrors = result.getSyntaxErrors();
			for (INode iNode : syntaxErrors) {
				errorMessages.append(iNode.getSyntaxErrorMessage());
				errorMessages.append("\n");
			}
			throw new RuntimeException(
					"Could not parse expression, syntax errors: "
							+ errorMessages);
		}
		if (diagnosticsConsumer.hasConsumedDiagnostics(Severity.ERROR)) {
			throw new RuntimeException("Error during linking: "
					+ diagnosticsConsumer.getResult(Severity.ERROR));
		}
		return rootASTElement;
	}

	protected Scope createContextScope(String contextScope) {
		ParserRule parserRule = XtextFactory.eINSTANCE.createParserRule();
		parserRule.setName("InternalScope");
		IParseResult result = parser.parse(parserRule, new StringReader(
				contextScope));
		return (Scope) result.getRootASTElement();
	}

	protected Scope createDefaultScope() {
		return createContextScope("internal: in event abc : integer operation foo() var myInt : integer var myBool : boolean var myReal : real var myString : string");
	}
}
