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

import org.eclipse.emf.ecore.EObject;
import org.yakindu.sct.model.stext.expressions.IExpressionParser;

import com.google.inject.Inject;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractSTextTest {

	@Inject
	private IExpressionParser expressionParser;

	protected EObject parseExpression(String expression, String ruleName) {
		return expressionParser.parseExpression(expression, ruleName);
	}

	protected EObject parseExpression(String expression, String ruleName, String scope) {
		return expressionParser.parseExpression(expression, ruleName, scope);
	}

	/**
	 * <pre>
	 * internal: 
	 * 	operation voidOp() 
	 * 	operation intOp():integer 
	 * 	var intVar : integer 
	 * 	var boolVar : boolean 
	 * 	var realVar : real 
	 * 	var stringVar : string 
	 * 	event intEvent : integer
	 *  event boolEvent : boolean
	 *  event realEvent : real 
	 *  event stringEvent : string 
	 *  event voidEvent : void"
	 * </pre>
	 */
	public String internalScope() {
		return "internal: operation voidOp() operation intOp():integer var intVar : integer var boolVar : boolean var realVar : real var stringVar : string event intEvent : integer  event boolEvent : boolean event realEvent : real event stringEvent : string event voidEvent : void";
	}

	/**
	 * <pre>
	 * interface ABC :
	 *  operation paramOp(param1 : integer, param2 : boolean ) : string 
	 *  operation stringOp() 
	 *  in event voidEvent  
	 *  in event intEvent : integer 
	 *  var intVar : integer 
	 *  var boolVar : boolean
	 * </pre>
	 */
	public String interfaceScope() {
		return "interface ABC : operation paramOp(param1 : integer, param2 : boolean ) : string operation stringOp() in event voidEvent  in event intEvent : integer var intVar : integer var boolVar : boolean";
	}

}
