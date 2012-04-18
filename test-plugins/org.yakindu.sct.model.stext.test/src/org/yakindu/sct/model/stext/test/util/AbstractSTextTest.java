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
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;

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

	protected EObject parseExpression(String expression, String ruleName) {
		return parseExpression(expression, null, ruleName);
	}

	protected EObject parseExpression(String expression, Scope context,
			String ruleName) {
		XtextResource resource = getResource();
		resource.setURI(URI.createPlatformPluginURI("path", true));
		ParserRule parserRule = XtextFactory.eINSTANCE.createParserRule();
		parserRule.setName(ruleName);
		IParseResult result = parser.parse(parserRule, new StringReader(
				expression));
		EObject rootASTElement = result.getRootASTElement();
		resource.getContents().add(rootASTElement);
		ListBasedDiagnosticConsumer diagnosticsConsumer = new ListBasedDiagnosticConsumer();
		if (context != null) {
			Statechart sc = _createStatechart("");
			resource.getContents().add(sc);
			sc.getScopes().add(context);
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

	protected Scope createInternalScope(String contextScope) {
		ParserRule parserRule = XtextFactory.eINSTANCE.createParserRule();
		parserRule.setName(InternalScope.class.getSimpleName());
		IParseResult result = parser.parse(parserRule, new StringReader(
				contextScope));
		return (Scope) result.getRootASTElement();
	}

	protected Scope createInterfaceScope(String contextScope) {
		ParserRule parserRule = XtextFactory.eINSTANCE.createParserRule();
		parserRule.setName(InterfaceScope.class.getSimpleName());
		IParseResult result = parser.parse(parserRule, new StringReader(
				contextScope));
		return (Scope) result.getRootASTElement();
	}

	/**
	 * <pre>
	 * internal: 
	 * 	 in event abc : integer 
	 *   in event event1
	 * 	 operation foo() 
	 *   operation myOpp1() :integer
	 * 	 var myInt : integer 
	 * 	 var myBool : boolean 
	 * 	 var myReal : real 
	 * 	 var myString : string
	 * </pre>
	 */
	protected Scope internalScope() {
		return createInternalScope("internal: in event abc : integer in event event1 operation foo() operation myOpp1() :integer var myInt : integer var myBool : boolean var myReal : real var myString : string");
	}

	/**
	 * <pre>
	 * "interface ABC:
	 *     operation myOpp2() 
	 *     myParamOpp(param1 : integer, param2 : boolean ) : string
	 *     in event event2
	 *     var myInt : integer
	 *     entrypoint EntryPoint 
	 *     exitpoint ExitPoint
	 * </pre>
	 */
	protected Scope interfaceScope() {
		return createInterfaceScope("interface ABC : operation myParamOpp(param1 : integer, param2 : boolean ) : string operation myOpp2() in event event2 in event event3 var myInt : integer entrypoint EntryPoint exitpoint ExitPoint");
	}
}
