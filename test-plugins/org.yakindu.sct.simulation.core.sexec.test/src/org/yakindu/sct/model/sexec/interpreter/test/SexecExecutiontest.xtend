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
		executionContext.slots.add(createExecutionVariable => [
			fqName = x.name
			name = x.name
		])	
		
		x._assign(_integer(42)).evaluate

		assertEquals(42L, executionContext.getSlot("x").value)		
	}


	@Test def void testGetValue() {

		val x = _variable("x", "integer")
		executionContext.slots.add(createExecutionVariable => [
			fqName = x.name
			name = x.name
		])	
		executionContext.getSlot("x").value = 42
		
		assertEquals(42, x._ref.evaluate.value)		
	}


	@Test def void testDoWhileLoop() {

		val x = _variable("x", "integer")
		executionContext.slots.add(createExecutionVariable => [
			fqName = x.name
			name = x.name
		])	
		executionContext.getSlot("x").value = 0
			
		_do(
			x._assign(x._ref._plus(_integer(1)))
		)._while(x._ref._smaller(_integer(20))).evaluate

		assertEquals(20L, executionContext.getSlot("x").value)		
	}

}