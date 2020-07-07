package org.yakindu.sct.model.sexec.interpreter.test

import com.google.inject.AbstractModule
import com.google.inject.Guice
import com.google.inject.Inject
import org.junit.Before
import org.junit.Test
import org.yakindu.sct.model.sexec.extensions.SexecBuilder
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.model.sruntime.SRuntimeFactory
import org.yakindu.sct.simulation.core.sexec.interpreter.SexecInterpreter

import static org.junit.Assert.assertEquals
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.base.types.typesystem.GenericTypeSystem

class SexecExecutiontest {

	extension SRuntimeFactory sruntimeFactory = SRuntimeFactory.eINSTANCE
	@Inject extension ExpressionBuilder exprBuilder
	@Inject extension SexecBuilder sexecBuilder
	
	@Inject extension SexecInterpreter sexecInterpreter
	
	protected static class TestModule extends AbstractModule {
		
		override protected configure() {
			bind(ITypeSystem).to(GenericTypeSystem)
		}
		
	}
	
	@Before def void setUp() {
		val injector = Guice.createInjector(new TestModule)
		injector.injectMembers(this)
	} 
	
	@Test def void testAssign() {

		val x = _variable("x", "integer")
		executionContext.slots.add(createExecutionVariable => [name = x.name])	
		
		_sequence(
			x._declare,
			x._assign(_integer(42))
		).evaluate

		assertEquals(42L, executionContext.getSlot("x").value)		
	}
}