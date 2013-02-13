package org.yakindu.sct.model.stext.test;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.sct.model.sgraph.Scope;
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

	public static final String INTERNAL_SCOPE = "" + "internal: "
			+ "	in event e1 : void" + "	in event e2 : void"
			+ "	var myInt : integer" + "	var myBool : boolean"
			+ "	operation myOpp(param1 : integer) : void";

	public static final String INTERFACE_SCOPE = "" + "interface Interface1:"
			+ "	in event e3 : void" + "	in event e4 : void"
			+ "	var myInt2 : integer" + "	var myBool2 : boolean"
			+ "	operation myOpp2(param1 : integer) : void";

	private Scope internalScope = null;
	private Scope interfaceScope = null;

	@Before
	public void setup() {
		internalScope = createInternalScope(INTERNAL_SCOPE);
		interfaceScope = createInterfaceScope(INTERFACE_SCOPE);
	}

	@Test
	public void testGuardScopingSuccess() throws Exception {
		parseExpression("[e1]", ReactionTrigger.class.getSimpleName(),
				internalScope);
		parseExpression("[Interface1.e3]",
			ReactionTrigger.class.getSimpleName(), interfaceScope);
		parseExpression("[e1 && e2]", ReactionTrigger.class.getSimpleName(),
				internalScope);
		parseExpression("[e1 && Interface1.e3]",
				ReactionTrigger.class.getSimpleName(), internalScope,
				interfaceScope);
		parseExpression("[Interface1.e4 && Interface1.e3]",
				ReactionTrigger.class.getSimpleName(), interfaceScope);

	}

}
