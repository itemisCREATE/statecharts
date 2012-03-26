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
package util;

import java.io.StringReader;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.ListBasedDiagnosticConsumer;
import org.junit.After;
import org.junit.Before;
import org.yakindu.sct.model.sexec.interpreter.stext.StextStatementInterpreter;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.stext.STextStandaloneSetup;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.simulation.core.runtime.IExecutionContext;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionContextImpl;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionEvent;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionVariable;

import com.google.inject.Inject;
import com.google.inject.Injector;

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
	private XtextResource resource;
	@Inject
	private ExecutionContextImpl context;
	@Inject
	private StextStatementInterpreter interpreter;

	protected static final class TestExecutionContext extends
			ExecutionContextImpl {

		public String lastProcedureId;

		@Override
		public void call(String procedureId) {
			super.call(procedureId);
			lastProcedureId = procedureId;
		}
	}

	@Before
	public void setup() {
		Injector injector = new STextStandaloneSetup()
				.createInjectorAndDoEMFRegistration();
		injector.injectMembers(this);
		initContext();
	}

	private void initContext() {
		// "event abc operation foo() var myInt : integer var MyBool : boolean
		// var myReal : real
		ExecutionVariable myInt = new ExecutionVariable("myInt", Integer.class,
				0);
		context.declareVariable(myInt);
		ExecutionVariable myBool = new ExecutionVariable("myBool",
				Boolean.class, false);
		context.declareVariable(myBool);
		ExecutionVariable myFloat = new ExecutionVariable("myFloat",
				Float.class, 0.0f);
		context.declareVariable(myFloat);
		ExecutionEvent event = new ExecutionEvent("abc", Integer.class);
		context.declareEvent(event);
	}

	protected Object getBoolValue() {
		return context.getVariable("myBool").getValue();
	}

	protected Object getIntValue() {
		return context.getVariable("myInt").getValue();
	}

	protected Object getFloatValue() {
		return context.getVariable("myFloat").getValue();
	}

	@After
	public void tearDown() {
		context = null;
	}

	protected EObject parseExpression(String expression, Scope context,
			String ruleName) {
		ParserRule parserRule = XtextFactory.eINSTANCE.createParserRule();
		parserRule.setName(ruleName);
		IParseResult result = parser.parse(parserRule, new StringReader(
				expression));
		EObject rootASTElement = result.getRootASTElement();
		resource.getContents().add(rootASTElement);
		if (context != null)
			resource.getContents().add(context);
		linker.linkModel(result.getRootASTElement(),
				new ListBasedDiagnosticConsumer());
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
		return rootASTElement;
	}

	protected Scope createContextScope(String contextScope) {
		ParserRule parserRule = XtextFactory.eINSTANCE.createParserRule();
		parserRule.setName("InternalScope");
		IParseResult result = parser.parse(parserRule, new StringReader(
				contextScope));
		return (Scope) result.getRootASTElement();
	}

	protected Object executeWithDefaultScope(String expression) {
		Scope defaultScope = createContextScope("internal: in event abc : integer operation foo() var myInt : integer var myBool : boolean var myFloat : real");
		Expression statement = (Expression) parseExpression(expression,
				defaultScope, Expression.class.getSimpleName());
		return interpreter.evaluateStatement(statement, context);
	}

	protected Object execute(String scope, String expression) {
		Scope defaultScope = createContextScope(scope);
		Expression statement = (Expression) parseExpression(expression,
				defaultScope, Expression.class.getSimpleName());
		return interpreter.evaluateStatement(statement, context);
	}

	protected Object executeExpression(String scope, String expression) {
		Scope defaultScope = createContextScope(scope);
		Statement statement = (Statement) parseExpression(expression,
				defaultScope, Expression.class.getSimpleName());
		return interpreter.evaluateStatement(statement, context);
	}

	public IExecutionContext getContext() {
		return context;
	}
}
