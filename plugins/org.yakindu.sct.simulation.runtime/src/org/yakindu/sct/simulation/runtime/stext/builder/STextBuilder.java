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

import static org.yakindu.sct.simulation.runtime.stext.CoreFunction.BIT_AND;
import static org.yakindu.sct.simulation.runtime.stext.CoreFunction.BIT_OR;
import static org.yakindu.sct.simulation.runtime.stext.CoreFunction.BIT_XOR;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.Type;
import org.yakindu.sct.model.stext.stext.VariableDefinition;
import org.yakindu.sct.simulation.runtime.sgraph.RTSignalEvent;
import org.yakindu.sct.simulation.runtime.stext.Assign;
import org.yakindu.sct.simulation.runtime.stext.BinaryOperation;
import org.yakindu.sct.simulation.runtime.stext.Conditional;
import org.yakindu.sct.simulation.runtime.stext.Constant;
import org.yakindu.sct.simulation.runtime.stext.CoreFunction;
import org.yakindu.sct.simulation.runtime.stext.Function;
import org.yakindu.sct.simulation.runtime.stext.FunctionMethod;
import org.yakindu.sct.simulation.runtime.stext.ProcedureCall;
import org.yakindu.sct.simulation.runtime.stext.RTExpression;
import org.yakindu.sct.simulation.runtime.stext.RTStatement;
import org.yakindu.sct.simulation.runtime.stext.RTTrigger;
import org.yakindu.sct.simulation.runtime.stext.RTTriggerEvent;
import org.yakindu.sct.simulation.runtime.stext.RTVariable;
import org.yakindu.sct.simulation.runtime.stext.Raise;
import org.yakindu.sct.simulation.runtime.stext.StatementSequence;
import org.yakindu.sct.simulation.runtime.stext.UnaryOperation;
import org.yakindu.sct.simulation.runtime.stext.VariableRef;

/**
 * The ExpressionBuilder creates an executable structure from the textual
 * expression definition or the corresponding EMF based abstract syntax tree.
 * This AST is defined by the expression grammer of this plugin.<br>
 * <br>
 * Expression builder instances are state-less so a single instance can be used
 * to build expression runtime structures multiple times and in parallel.<br>
 * <br>
 * The current implementation mainly consist of a set of builder functions with
 * a name prefix 'build'. This class defines a build function for each grammar
 * rule. So when changing the grammer it will be necessary to change, add or
 * remove build methods for the affected grammar rules. The implementation
 * strongly relies on dynamic dispatch of build function calls and therefore
 * makes use of the 'pluggable adapter' pattern and Java reflection. <br>
 * <br>
 * 
 * @author terfloth@itemis.de
 * @author andreas muelder
 */
public class STextBuilder extends Function {

	/** Builder functions always */
	protected static Class<?>[] paramTypes = new Class[] { EObject.class };

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

	@FunctionMethod("build")
	public RTTrigger buildTrigger(EObject obj) {
		return (RTTrigger) build(getToOne(obj, "event"));
	}

	@FunctionMethod("build")
	public RTTriggerEvent buildSignalEvent(EObject obj) {
		return new RTTriggerEvent.SignalEvent(getString(obj, "identifier"));
	}

	@FunctionMethod("build")
	public RTTriggerEvent buildTimeEvent(EObject obj) {
		return new RTTriggerEvent.TimeEvent(buildRefExpression(obj, "duration"));
	}

	@FunctionMethod("build")
	public RTExpression buildTimeConstant(EObject obj) {
		int duration = getInteger(obj, "value");
		String unit = getLiteral(obj, "unit");

		if (unit != null) {
			if ("second".equals(unit))
				duration *= 1000;
			else if ("nanosecond".equals(unit))
				duration /= 1000;
		}

		return new Constant(duration);
	}

	@FunctionMethod("build")
	public RTExpression buildGuardExpression(EObject obj) {
		return buildRefExpression(obj, "expression");
	}

	@FunctionMethod("build")
	public RTStatement buildReactionEffect(EObject obj) {
		StatementSequence seq = new StatementSequence();
		for (EObject child : obj.eContents()) {
			RTStatement stmt = (RTStatement) build(child);
			if (stmt != null)
				seq.add(stmt);
		}
		return seq;
	}

	@FunctionMethod("build")
	public RTVariable buildVariableDefinition(EObject obj) {
		RTVariable variable = new RTVariable();
		VariableDefinition definition = (VariableDefinition) obj;


		//TODO: Default value
		variable.setName(definition.getName());
		Type type = definition.getType();

		if (type == Type.BOOLEAN) {
			variable.setType(Boolean.class);
			variable.setValue(false);
		} else if (type == Type.INTEGER) {
			variable.setType(Integer.class);
			variable.setValue(0);
		} else if (type == Type.REAL) {
			variable.setType(Float.class);
			variable.setValue(0.0f);
		}
		return variable;
	}

	
	@FunctionMethod("build")
	public RTSignalEvent buildEventDefinition(EObject obj) {
		RTSignalEvent event = new RTSignalEvent();
		EventDefinition definition = (EventDefinition) obj;


		//TODO: Default value
		event.setId(definition.getName());
		Type type = definition.getType();

		if (type == Type.BOOLEAN) {
			event.setType(Boolean.class);
			event.setValue(null);
		} else if (type == Type.INTEGER) {
			event.setType(Integer.class);
			event.setValue(null);
		} else if (type == Type.REAL) {
			event.setType(Float.class);
			event.setValue(null);
		}
		return event;
	}

	@FunctionMethod("build")
	public RTStatement buildEventRaising(EObject obj) {

		EObject event = getToOne(obj, "event");
		RTExpression value = buildRefExpression(obj, "value");

		return new Raise(getString(event, "name"), value);
	}

	@FunctionMethod("build")
	public RTStatement buildOperationCall(EObject obj) {
		EObject operation = getToOne(obj, "operation");
		return new ProcedureCall(getString(operation, "name"));
	}

	@FunctionMethod("build")
	public RTStatement buildAssignment(EObject obj) {
		EObject variable = getToOne(obj, "varRef");
		if (variable == null)
			throw new IllegalStateException("Unknown variable reference " + obj);
		RTExpression exp = (RTExpression) build(getToOne(obj, "expression"));
		String operator = getLiteral(obj, "operator");
		VariableRef var = new VariableRef(getString(variable, "name"));
		
		if (! "assign".equals(operator)) {
			String mappedOperator = assignFunctionMap.get(operator);
			if (mappedOperator == null) 
				throw new BuilderException("Assignment operator '" + operator + "' can not be resolved to a function.");
			
			exp = new BinaryOperation(mappedOperator, var, exp);
		}

		return new Assign(var, exp);
	}
	
	
	@FunctionMethod("build")
	public RTExpression buildConditionalExpression(EObject obj) {
		
		RTExpression condition = buildRefExpression(obj, "condition");
		RTExpression trueCase = buildRefExpression(obj, "trueCase");
		RTExpression falseCase = buildRefExpression(obj, "falseCase");

		if (condition != null && trueCase != null && falseCase != null)
			return new Conditional(condition, trueCase, falseCase);
		
		return condition;
	}


	@FunctionMethod("build")
	public RTExpression buildLogicalOrExpression(EObject obj) {

		RTExpression op1 = buildRefExpression(obj, "leftOperand");
		RTExpression op2 = buildRefExpression(obj, "rightOperand");

		if (op1 != null && op2 != null)
			return new BinaryOperation(BinaryOperation.OR, op1, op2);

		return op1;
	}

	@FunctionMethod("build")
	public RTExpression buildLogicalAndExpression(EObject obj) {

		RTExpression op1 = buildRefExpression(obj, "leftOperand");
		RTExpression op2 = buildRefExpression(obj, "rightOperand");

		if (op1 != null && op2 != null)
			return new BinaryOperation(BinaryOperation.AND, op1, op2);

		return op1;
	}

	@FunctionMethod("build")
	public RTExpression buildBitwiseXorExpression(EObject obj) {

		RTExpression op1 = buildRefExpression(obj, "leftOperand");
		RTExpression op2 = buildRefExpression(obj, "rightOperand");

		if (op1 != null && op2 != null)
			return new BinaryOperation(BIT_XOR, op1, op2);

		return op1;
	}

	@FunctionMethod("build")
	public RTExpression buildBitwiseOrExpression(EObject obj) {

		RTExpression op1 = buildRefExpression(obj, "leftOperand");
		RTExpression op2 = buildRefExpression(obj, "rightOperand");

		if (op1 != null && op2 != null)
			return new BinaryOperation(BIT_OR, op1, op2);

		return op1;
	}

	@FunctionMethod("build")
	public RTExpression buildBitwiseAndExpression(EObject obj) {

		RTExpression op1 = buildRefExpression(obj, "leftOperand");
		RTExpression op2 = buildRefExpression(obj, "rightOperand");

		if (op1 != null && op2 != null)
			return new BinaryOperation(BIT_AND, op1, op2);

		return op1;
	}

	public RTExpression buildBinaryOperation(EObject obj) {
		RTExpression op1 = buildRefExpression(obj, "leftOperand");
		RTExpression op2 = buildRefExpression(obj, "rightOperand");
		String operator = getLiteral(obj, "operator");

		if (op1 != null && op2 != null)
			return new BinaryOperation(operator, op1, op2);

		return op1;
	}

	@FunctionMethod("build")
	public RTExpression buildLogicalRelationExpression(EObject obj) {
		return buildBinaryOperation(obj);
	}

	@FunctionMethod("build")
	public RTExpression buildLogicalNotExpression(EObject obj) {
		RTExpression operand = buildRefExpression(obj, "operand");

		if (operand != null)
			return new UnaryOperation(CoreFunction.NOT, operand);

		return operand;
	}

	@FunctionMethod("build")
	public RTExpression buildShiftExpression(EObject obj) {
		return buildBinaryOperation(obj);
	}

	@FunctionMethod("build")
	public RTExpression buildAdditiveExpression(EObject obj) {
		return buildBinaryOperation(obj);
	}

	@FunctionMethod("build")
	public RTExpression buildNumericalMultiplyDivideExpression(EObject obj) {
		return buildBinaryOperation(obj);
	}

	@FunctionMethod("build")
	public RTExpression buildNumericalAddSubtractExpression(EObject obj) {
		return buildBinaryOperation(obj);
	}

	@FunctionMethod("build")
	public RTExpression buildNumericalUnaryExpression(EObject obj) {

		RTExpression operand = buildRefExpression(obj, "operand");
		String operator = getLiteral(obj, "operator");

		if (operand != null && operator != null)
			return new UnaryOperation(operator, operand);

		return operand;
	}

	@FunctionMethod("build")
	public RTExpression buildNestedExpression(EObject obj) {
		return buildRefExpression(obj, "expression");
	}

	@FunctionMethod("build")
	public RTExpression buildPrimitiveValueExpression(EObject obj) {
		return buildRefExpression(obj, "value");
	}
	@FunctionMethod("build")
	public RTExpression buildIntLiteral(EObject object){
		return new Constant(getInteger(object, "value"));
	}
	@FunctionMethod("build")
	public RTExpression buildBoolLiteral(EObject object){
		return new Constant(getBoolean(object, "value"));
	}
	@FunctionMethod("build")
	public RTExpression buildRealLiteral(EObject object){
		return new Constant(getFloat(object, "value"));
	}

	@FunctionMethod("build")
	public RTExpression buildElementReferenceExpression(EObject obj) {
		// TODO: Do we really need an ElementReferenceExpression? Or is a
		// VariableReferenceExpression enough?
		EObject var = getToOne(obj, "value");
		return new VariableRef(getString(var, "name"));
	}

	/**
	 * build method that performs the dynamic dispatch to the appropriate
	 * (correctly named) builder function. The parameter is always a EObject and
	 * since we have use dynamic EMF we match by naming conventions.
	 * 
	 * @param obj
	 * @return
	 */
	public Object build(EObject obj) {
		if (obj == null)
			return null;

		Object[] params = new Object[] { obj };

		Function f = STextBuilder.lookup(this.getClass(), "build"
				+ obj.eClass().getName(), paramTypes);
		if (f != null)
			return f.execute(params);

		throw new BuilderException("No builder function for: "
				+ obj.eClass().getName());
	}

	protected RTExpression buildRefExpression(EObject obj, String refName) {
		return (RTExpression) build(getToOne(obj, refName));
	}

	protected EObject getToOne(EObject obj, String name) {
		EStructuralFeature feature = obj.eClass().getEStructuralFeature(name);
		if (feature instanceof EReference) {
			EReference ref = (EReference) feature;
			return (EObject) obj.eGet(ref);
		}
		throw new BuilderException();
	}

	protected String getString(EObject obj, String name) {
		EStructuralFeature feature = obj.eClass().getEStructuralFeature(name);
		if (feature instanceof EAttribute) {
			EAttribute attr = (EAttribute) feature;
			return (String) obj.eGet(attr);
		}
		throw new BuilderException();
	}

	protected Integer getInteger(EObject obj, String name) {
		EStructuralFeature feature = obj.eClass().getEStructuralFeature(name);
		if (feature instanceof EAttribute) {
			EAttribute attr = (EAttribute) feature;
			return (Integer) obj.eGet(attr);
		}
		throw new BuilderException();
	}
	protected Boolean getBoolean(EObject obj, String name) {
		EStructuralFeature feature = obj.eClass().getEStructuralFeature(name);
		if (feature instanceof EAttribute) {
			EAttribute attr = (EAttribute) feature;
			return (Boolean) obj.eGet(attr);
		}
		throw new BuilderException();
	}
	protected Float getFloat(EObject obj, String name) {
		EStructuralFeature feature = obj.eClass().getEStructuralFeature(name);
		if (feature instanceof EAttribute) {
			EAttribute attr = (EAttribute) feature;
			return (Float) obj.eGet(attr);
		}
		throw new BuilderException();
	}

	protected String getLiteral(EObject obj, String name) {
		EStructuralFeature feature = obj.eClass().getEStructuralFeature(name);
		if (feature instanceof EAttribute) {
			EAttribute attr = (EAttribute) feature;
			String literalValue = ((Enumerator) obj.eGet(attr)).getName();

			return ("NULL".equals(literalValue)) ? null : literalValue;
		}
		throw new BuilderException();
	}

}
