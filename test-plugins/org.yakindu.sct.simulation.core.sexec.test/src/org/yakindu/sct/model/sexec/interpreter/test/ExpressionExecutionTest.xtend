package org.yakindu.sct.model.sexec.interpreter.test

import com.google.inject.AbstractModule
import com.google.inject.Guice
import com.google.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.junit.Before
import org.junit.Test
import org.yakindu.base.types.inferrer.ITypeSystemInferrer
import org.yakindu.base.types.typesystem.GenericTypeSystem
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.model.stext.inferrer.STextTypeInferrer
import org.yakindu.sct.model.stext.naming.StextNameProvider
import org.yakindu.sct.simulation.core.sexec.interpreter.SexecInterpreter

import static org.junit.Assert.assertEquals

class ExpressionExecutionTest {

	@Inject extension ExpressionBuilder exprBuilder
	@Inject extension SexecInterpreter exprInterpreter

	protected static class TestModule extends AbstractModule {
		
		override protected configure() {
			bind(ITypeSystem).to(GenericTypeSystem)
			bind(IQualifiedNameProvider).to(StextNameProvider);
			bind(ITypeSystemInferrer).to(STextTypeInferrer);
		}
	}
	
	@Before def void setUp() {
		val injector = Guice.createInjector(new TestModule)
		injector.injectMembers(this)
	} 
	
	
	@Test def void testPrimitiveIntegerValueExpression() {
		assertEquals(42L, _integer(42).evaluate());
	} 
			
	@Test def void testPrimitiveDoubleValueExpression() {
		assertEquals(4.2, _double(4.2).evaluate());
	} 	

	@Test def void testPrimitiveFloatValueExpression() {
		assertEquals(4.2f, _float(4.2f).evaluate());
	} 	

	@Test def void testTrue() {
		assertEquals(Boolean.TRUE, _true.evaluate());
	} 	

	@Test def void testFalse() {
		assertEquals(Boolean.FALSE, _false.evaluate());
	} 	

	@Test def void testParenthesisOfInteger() {
		assertEquals(42L, _parenthesis(_integer(42)).evaluate )
	}

	@Test def void testLogicalOr() {
		assertEquals(true, _or(_true, _false ).evaluate )
		assertEquals(true, _or(_false, _true ).evaluate )
		assertEquals(true, _or(_true, _true ).evaluate )
		assertEquals(false, _or(_false, _false ).evaluate )
	}

	@Test def void testLogicalAnd() {
		assertEquals(false, _and(_true, _false ).evaluate )
		assertEquals(false, _and(_false, _true ).evaluate )
		assertEquals(true, _and(_true, _true ).evaluate )
		assertEquals(false, _and(_false, _false ).evaluate )
	}

	@Test def void testPlusMinus() {
		assertEquals(30L, _integer(10)._plus(_integer(20)).evaluate )
		assertEquals(10l, _integer(30)._minus(_integer(20)).evaluate )
		assertEquals(17l, _integer(30)._plus(_integer(2))._minus(_integer(20)._minus(_integer(5))).evaluate )
	}

	@Test def void testMultiplicative() {
		assertEquals(200L, _integer(10)._multiply(_integer(20)).evaluate )
		assertEquals(3l, _integer(30)._divide(_integer(10)).evaluate )
		assertEquals(4l, _integer(10)._modulo(_integer(6)).evaluate )
	}

	@Test def void testBitwise() {
		assertEquals(4L, _integer(7)._bitwiseAnd(_integer(28)).evaluate )
		assertEquals(31l, _integer(7)._bitwiseOr(_integer(28)).evaluate )
		assertEquals(27l, _integer(7)._bitwiseXor(_integer(28)).evaluate )
	}

}