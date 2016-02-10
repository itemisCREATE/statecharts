/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.stext.test;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.test.util.AbstractSTextTest;
import org.yakindu.sct.model.stext.test.util.STextInjectorProvider;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
@RunWith(XtextRunner.class)
@InjectWith(STextInjectorProvider.class)
public class STextScopeProviderTest extends AbstractSTextTest {

	
	public static final String INTERNAL_SCOPE = "" + "internal: " + "	in event e1 : void" + "	in event e2 : void"
			+ "	var myInt : integer" + "	var myBool : boolean" + "	operation myOpp(param1 : integer) : void";

	public static final String INTERFACE_SCOPE = "" + "interface Interface1:" + "	in event e3 : void"
			+ "	in event e4 : void" + "	var myInt2 : integer" + "	var myBool2 : boolean"
			+ "	operation myOpp2(param1 : integer) : void";

	private Scope internalScope = null;
	private Scope interfaceScope = null;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	

	@Before
	public void setup() {
		internalScope = createInternalScope(INTERNAL_SCOPE);
		interfaceScope = createInterfaceScope(INTERFACE_SCOPE);
	}

	@Test
	public void testGuardScopingSuccess() throws Exception {
		parseExpression("[e1]", ReactionTrigger.class.getSimpleName(), internalScope);
		parseExpression("[Interface1.e3]", ReactionTrigger.class.getSimpleName(), interfaceScope);
		parseExpression("[e1 && e2]", ReactionTrigger.class.getSimpleName(), internalScope);
		parseExpression("[e1 && Interface1.e3]", ReactionTrigger.class.getSimpleName(), internalScope, interfaceScope);
		parseExpression("[Interface1.e4 && Interface1.e3]", ReactionTrigger.class.getSimpleName(), interfaceScope);
	}

	@Test
	public void testReactionTriggerSuccess() throws Exception {
		parseExpression("e1 / myInt = 0", LocalReaction.class.getSimpleName(), internalScope);
		parseExpression("always / myInt = 0", LocalReaction.class.getSimpleName(), internalScope);
		parseExpression("oncycle / myInt = 0", LocalReaction.class.getSimpleName(), internalScope);
	}

	@Test
	public void testReactionTriggerLinkingError() throws Exception {
		thrown.expect(RuntimeException.class);
		thrown.expectMessage("Couldn't resolve reference to EObject 'myOpp'");
		parseExpression("myOpp(4) / myInt = 10", LocalReaction.class.getSimpleName(), internalScope);
	}
}
