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
import org.yakindu.base.types.TypeBuilder
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.yakindu.sct.model.stext.naming.StextNameProvider
import org.yakindu.base.types.inferrer.ITypeSystemInferrer
import org.yakindu.sct.model.stext.inferrer.STextTypeInferrer

class SexecExecutionTest {

	extension SRuntimeFactory sruntimeFactory = SRuntimeFactory.eINSTANCE
	@Inject extension ExpressionBuilder exprBuilder
	@Inject extension SexecBuilder sexecBuilder
	
	@Inject protected extension TypeBuilder typeBuilder
	@Inject extension SexecInterpreter sexecInterpreter
	
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
	
	
	@Test def void testAssign() {

		val x = _variable("x", "integer")
		heap.slots.add(createExecutionVariable => [
			fqName = x.name
			name = x.name
		])	
		
		x._assign(_integer(42)).evaluate

		assertEquals(42L, heap.getSlot("x").value)		
	}


	@Test def void testGetValue() {

		val x = _variable("x", "integer")
		heap.slots.add(createExecutionVariable => [
			fqName = x.name
			name = x.name
		])	
		heap.getSlot("x").value = 42
		
		assertEquals(42, x._ref.evaluate.value)		
	}


	@Test def void testDoWhileLoop() {

		val x = _variable("x", "integer")
		heap.slots.add(createExecutionVariable => [
			fqName = x.name
			name = x.name
		])	
		heap.getSlot("x").value = 0
			
		_do(
			x._assign(x._ref._plus(_integer(1)))
		)._while(x._ref._smaller(_integer(20))).evaluate

		assertEquals(20L, heap.getSlot("x").value)		
	}


	@Test def void testSimpleMethodCall() {
		
		val method = _method("simple") => [
			_public
			_type(_integer)
			_body(
				_return ( _integer(42) )
			)			
		]	
		
		assertEquals(42L, method._call.evaluate);
	}

	@Test def void testParametrizedMethodCall() {
		
		val method = _method("timesTwo") => [
			_public
			_type(_integer)
			_param("p", _integer )
			_body(
				_return ( parameters.get(0)._ref._plus(parameters.get(0)._ref) )
			)			
		]	
		
		assertEquals(84L, method._call._with(_integer(42)).evaluate);
	}

	@Test def void testRecursiveMethodCall() {
		
		val method = _method("sumOneTo") 
		method => [
			_public
			_type(_integer)
			_param("p", _integer )
			_body(
				_if(parameters.get(0)._ref._equals(_integer(1)))._then(
					_return( _integer(1) )	
				)._else (
					_return ( parameters.get(0)._ref._plus(method._call._with(parameters.get(0)._ref._minus(_integer(1)))) )
				)
			)			
		]	
		
		assertEquals(6L, method._call._with(_integer(3)).evaluate);
	}


	@Test def void testRecursiveMethodCall2() {
		
		val method = _method("sumOneTo") 
		method => [
			_public
			_type(_integer)
			_param("p", _integer )
			_body(
				_if(parameters.get(0)._ref._equals(_integer(1)))._then(
					_return( _integer(1) )	
				),
				_return (
					parameters.get(0)._ref
					._plus(
						method._call._with(
							parameters.get(0)._ref
							._minus(_integer(1))
						)
					)
				)
			)			
		]	
		
		assertEquals(820L, method._call._with(_integer(40)).evaluate);
	}


}