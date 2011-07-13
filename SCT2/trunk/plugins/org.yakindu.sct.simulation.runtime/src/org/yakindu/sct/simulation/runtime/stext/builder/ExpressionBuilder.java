/**
 * Copyright (c) 2010-2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.runtime.stext.builder;

import static org.yakindu.sct.simulation.runtime.stext.CoreFunction.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.yakindu.sct.simulation.runtime.stext.*;

/**
 * The ExpressionBuilder creates an executable structure from the textual expression definition 
 * or the corresponding EMF based abstract syntax tree. This AST is defined by the expression grammer 
 * of this plugin.<br>
 * <br>
 * Expression builder instances are state-less so a single instance can be used to build 
 * expression runtime structures multiple times and in parallel.<br>
 * <br>
 * The current implementation mainly consist of a set of builder functions with a name prefix 'build'. 
 * This class defines a build function for each grammar rule. So when changing the grammer it will be necessary
 * to change, add or remove build methods for the affected grammar rules. The implementation strongly relies on dynamic dispatch of build function calls and therefore
 * makes use of the 'pluggable adapter' pattern and Java reflection. <br>
 * <br>
 * Example:
 * <code>
 * (new ExpressionBuilder()).build("a = 2*b; a <<= 2;");
 * </code>
 * 
 * @author terfloth@itemis.de
 *
 */
public class ExpressionBuilder extends Function {

	/** Builder functions always*/
	protected static Class<?>[] paramTypes = new Class[]{EObject.class};

	protected static Map<String, String> assignFunctionMap = new HashMap<String, String>();

	static {
		assignFunctionMap.put("multAssign", "*"); 
		assignFunctionMap.put("divAssign", "/"); 
		assignFunctionMap.put("modAssign", "%");
		assignFunctionMap.put("addAssign", "+"); 
		assignFunctionMap.put("subAssign", "-"); 
		assignFunctionMap.put("leftShiftAssign", "<<"); 
		assignFunctionMap.put("rightShiftAssign", ">>"); 
		assignFunctionMap.put("andAssign", "&"); 
		assignFunctionMap.put("xorAssign", "^"); 
		assignFunctionMap.put("orAssign", "|");
	}
	
	
	
	/**
	 * Static helper method that creates a executable expression structure from a expression string.
	 * 
	 * @param actionExpression
	 * @return an executable statement object.
	 */
	public static Statement buildAction(String actionExpression) {
		ExpressionBuilder builder = new ExpressionBuilder();
		return builder.buildActionExpression(actionExpression);
	}

	
	/**
	 * Static helper method that creates a executable expression structure from a expression string.
	 * 
	 * @param guardExpression
	 * @return an executable statement object.
	 */
	public static Expression buildGuard(String guardExpression) {
		ExpressionBuilder builder = new ExpressionBuilder();
		return builder.buildGuardExpression(guardExpression);
	}

	
	/**
	 * Static helper method that creates a executable expression structure from a expression string.
	 * 
	 * @param guardExpression
	 * @return an executable statement object.
	 */
	public static List<Trigger> buildTriggers(String guardExpression) {
		ExpressionBuilder builder = new ExpressionBuilder();
		return builder.buildTriggerExpression(guardExpression);
	}


	
	/**
	 * The primary builder method that creates a executable statement structure from a expression string.
	 * 
	 * @param actionExpression
	 * @return an executable statement object.
	 */
	public Statement buildActionExpression(String expr) {
		EObject root = JavaExtensions.parseActionExpressionObject(expr);
		return (Statement) build(root);		
	}
	
	
	
	
	/**
	 * The primary builder method that creates a executable guard expression structure from an expression string.
	 * 
	 * @param actionExpression
	 * @return an executable statement object.
	 */
	public Expression buildGuardExpression(String expr) {
		EObject root = JavaExtensions.parseGuardExpressionObject(expr);
		return (Expression) build(root);		
	}

	
	/**
	 * The primary builder method that creates a executable guard expression structure from an expression string.
	 * 
	 * @param actionExpression
	 * @return an executable statement object.
	 */
	public List<Trigger> buildTriggerExpression(String expr) {
		EObject root = JavaExtensions.parseTriggerExpressionObject(expr);
		return (List<Trigger>) build(root);		
	}
	
	
	@FunctionMethod("build")
	public List<Trigger> buildTriggerExpression(EObject obj) {
		List<Trigger> triggers = new ArrayList<Trigger>();

		for (EObject child : obj.eContents()) {
			Trigger trigger = (Trigger) build(child);
			if(trigger != null) triggers.add(trigger);
		}

		return triggers;
	}
	
	
	@FunctionMethod("build")
	public Trigger buildTrigger(EObject obj) {
		return (Trigger) build(getToOne(obj, "event"));
	}
	
	@FunctionMethod("build")
	public Trigger buildSignalEvent(EObject obj) {
		return new Trigger.SignalEvent(getString(obj, "identifier"));
	}
	
	@FunctionMethod("build")
	public Trigger buildTimeEvent(EObject obj) {
		return new Trigger.TimeEvent(buildRefExpression(obj, "duration"));
	}
	
	@FunctionMethod("build")
	public Expression buildTimeConstant(EObject obj) {
		int duration = getInteger(obj, "value");
		String unit = getLiteral(obj, "unit");
		
		if (unit != null) {
			if ("second".equals(unit)) duration *= 1000;
			else if ("nanosecond".equals(unit)) duration /= 1000;
		}
		
		return new Constant(duration);
	}
	
	
	@FunctionMethod("build")
	public Expression buildGuardExpression(EObject obj) {
		return buildRefExpression(obj, "expression");
	}
	
	
	@FunctionMethod("build")
	public Statement buildActionExpression(EObject obj) {
		StatementSequence seq = new StatementSequence();
		
		for (EObject child : obj.eContents()) {
			Statement stmt = (Statement) build(child);
			if(stmt != null) seq.add(stmt);
		}
		
		return seq;
	}
	
	
	@FunctionMethod("build")
	public Statement buildEventRaising(EObject obj) {
		
		EObject event = getToOne(obj, "event");		
		return new Raise(getString(event, "identifier"));
	}
	

	@FunctionMethod("build")
	public Statement buildProcedureCall(EObject obj) {
		
		EObject event = getToOne(obj, "procedure");	
		return new ProcedureCall(getString(event, "identifier"));
	}
	

	@FunctionMethod("build")
	public Statement buildVariableAssignment(EObject obj) {
		
		VariableRef var = (VariableRef) build(getToOne(obj, "variableReference"));
		String operator = getLiteral(obj, "operator");
		Expression exp = (Expression) build(getToOne(obj, "value"));

		if (! "assign".equals(operator)) {
			String mappedOperator = assignFunctionMap.get(operator);
			if (mappedOperator == null) 
				throw new BuilderException("Assignment operator '" + operator + "' can not be resolved to a function.");
			
			exp = new BinaryOperation(mappedOperator, var, exp);
		}
		
		return new Assign(var, exp);
	}
	

	@FunctionMethod("build")
	public Expression buildConditionalExpression(EObject obj) {
		
		Expression op1 = buildRefExpression(obj, "operand1");
		Expression op2 = buildRefExpression(obj, "operand2");
		Expression op3 = buildRefExpression(obj, "operand3");

		if (op1 != null && op2 != null && op3 != null)
			return new Conditional(op1, op2, op3);
		
		return op1;
	}
	

	@FunctionMethod("build")
	public Expression buildBooleanOrExpression(EObject obj) {
		
		Expression op1 = buildRefExpression(obj, "operand1");
		Expression op2 = buildRefExpression(obj, "operand2");

		if (op1 != null && op2 != null)
			return new BinaryOperation(BinaryOperation.OR, op1, op2);
		
		return op1;
	}
	

	@FunctionMethod("build")
	public Expression buildBooleanAndExpression(EObject obj) {
		
		Expression op1 = buildRefExpression(obj, "operand1");
		Expression op2 = buildRefExpression(obj, "operand2");

		if (op1 != null && op2 != null)
			return new BinaryOperation(BinaryOperation.AND, op1, op2);
		
		return op1;
	}
	

	@FunctionMethod("build")
	public Expression buildBitwiseXorExpression(EObject obj) {
		
		Expression op1 = buildRefExpression(obj, "operand1");
		Expression op2 = buildRefExpression(obj, "operand2");

		if (op1 != null && op2 != null)
			return new BinaryOperation(BIT_XOR, op1, op2);
		
		return op1;
	}
	

	@FunctionMethod("build")
	public Expression buildBitwiseOrExpression(EObject obj) {
		
		Expression op1 = buildRefExpression(obj, "operand1");
		Expression op2 = buildRefExpression(obj, "operand2");

		if (op1 != null && op2 != null)
			return new BinaryOperation(BIT_OR, op1, op2);
		
		return op1;
	}
	
	
	@FunctionMethod("build")
	public Expression buildBitwiseAndExpression(EObject obj) {
		
		Expression op1 = buildRefExpression(obj, "operand1");
		Expression op2 = buildRefExpression(obj, "operand2");

		if (op1 != null && op2 != null)
			return new BinaryOperation(BIT_AND, op1, op2);
		
		return op1;
	}
	

	public Expression buildBinaryOperation(EObject obj) {
		
		Expression op1 = buildRefExpression(obj, "operand1");
		Expression op2 = buildRefExpression(obj, "operand2");
		String operator = getLiteral(obj, "operator");

		if (op1 != null && op2 != null)
			return new BinaryOperation(operator, op1, op2);
		
		return op1;
	}

	
	@FunctionMethod("build")
	public Expression buildEqualityExpression(EObject obj) {
		return buildBinaryOperation(obj);
	}
	
	
	@FunctionMethod("build")
	public Expression buildRelationalExpression(EObject obj) {
		return buildBinaryOperation(obj);
	}
	
	@FunctionMethod("build")
	public Expression buildShiftExpression(EObject obj) {
		return buildBinaryOperation(obj);
	}
	
	@FunctionMethod("build")
	public Expression buildAdditiveExpression(EObject obj) {
		return buildBinaryOperation(obj);
	}
	
	
	@FunctionMethod("build")
	public Expression buildMultiplicativeExpression(EObject obj) {
		return buildBinaryOperation(obj);
	}
	

	@FunctionMethod("build")
	public Expression buildUnaryExpression(EObject obj) {
		
		Expression operand = buildRefExpression(obj, "operand");
		String operator = getLiteral(obj, "operator");

		if (operand != null && operator != null)
			return new UnaryOperation(operator, operand);
		
		return operand;
	}
	
	
	@FunctionMethod("build")
	public Expression buildNestedExpression(EObject obj) {
		return buildRefExpression(obj, "expression");
	}
	

	@FunctionMethod("build")
	public Expression buildLiteralValue(EObject obj) {
		
		String value = getString(obj, "value");	
		
		// TODO: nur provisrisch - Grammatik muss noch ge�ndert werden,
		// um unterschiedliche Literaltypen unterscheiden zu koennen
		if (value != null) {
			
			if ("true".equals(value)) return new Constant(Boolean.TRUE);
			
			if ("false".equals(value)) return new Constant(Boolean.FALSE);

			try { // flaot
				if (value.contains("."))
					return new Constant(Float.parseFloat(value));
			} catch (NumberFormatException e1) { /* need to be quite */ }

			try { // hex int
				if (value.startsWith("0x"))
					return new Constant(new Integer(Integer.parseInt(value.substring(2), 16)));
			} catch (NumberFormatException e1) { /* need to be quite */ }
						
			try { // int
				return new Constant(new Integer(Integer.parseInt(value)));
			} catch (NumberFormatException e1) { /* need to be quite */ }
			
			if ((value.startsWith("'") && value.endsWith("'")) || (value.startsWith("\"") && value.endsWith("\"")) )
				return new Constant(value.substring(1, value.length()-1));
		}
		
		return new Constant(value);
	}
	

	
	@FunctionMethod("build")
	public Expression buildVariableReference(EObject obj) {
		
		EObject var = getToOne(obj, "variable");	
		return new VariableRef(getString(var, "identifier"));
	}
	

	/**
	 * Internal build method that performs the dynamic dispatch to the appropriate (correctly named) 
	 * builder function. The parameter is always a EObject and since we have use dynamic EMF we match by 
	 * naming conventions.
	 * 
	 * @param obj
	 * @return
	 */
	protected Object build(EObject obj) {
		if ( obj == null ) return null;
		
		Object[] params = new Object[]{obj};
		
		Function f = ExpressionBuilder.lookup(this.getClass(), "build" + obj.eClass().getName(), paramTypes);
		if (f != null) 
			return f.execute(params);
		
		throw new BuilderException("No builder function for: " + obj.eClass().getName());
	}
	
	
	protected Expression buildRefExpression(EObject obj, String refName) {
		return (Expression) build(getToOne(obj, refName));
	}
	

	
	protected EObject getToOne(EObject obj, String name) {
		EStructuralFeature feature = obj.eClass().getEStructuralFeature(name);
		if ( feature instanceof EReference ) {
			EReference ref = (EReference) feature;
			return (EObject) obj.eGet(ref);
		}
		throw new BuilderException();
	}
	
	
	protected String getString(EObject obj, String name) {
		EStructuralFeature feature = obj.eClass().getEStructuralFeature(name);
		if ( feature instanceof EAttribute ) {
			EAttribute attr = (EAttribute) feature;
			return (String) obj.eGet(attr);
		}
		throw new BuilderException();
	}


	protected Integer getInteger(EObject obj, String name) {
		EStructuralFeature feature = obj.eClass().getEStructuralFeature(name);
		if ( feature instanceof EAttribute ) {
			EAttribute attr = (EAttribute) feature;
			return (Integer) obj.eGet(attr);
		}
		throw new BuilderException();
	}

	
	protected String getLiteral(EObject obj, String name) {
		EStructuralFeature feature = obj.eClass().getEStructuralFeature(name);
		if ( feature instanceof EAttribute ) {
			EAttribute attr = (EAttribute) feature;
			String literalValue = ((Enumerator) obj.eGet(attr)).getName();
		
			return ("NULL".equals(literalValue)) ? null : literalValue;
		}
		throw new BuilderException();
	}
	
	

}

