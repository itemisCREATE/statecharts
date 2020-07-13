package org.yakindu.sct.model.sexec.interpreter.test

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.interpreter.test.util.SExecInjectionProvider
import org.yakindu.sct.simulation.core.sexec.interpreter.SexecInterpreter
import org.yakindu.sct.test.models.SCTUnitTestModels

import static org.junit.Assert.assertTrue
import static org.junit.Assert.assertEquals

@SuppressWarnings("all")
@RunWith(XtextRunner)
@InjectWith(SExecInjectionProvider)
class StatechartInterpreterTest {
	
	@Inject protected SCTUnitTestModels models
	@Inject protected extension SexecInterpreter interpreter
	protected ExecutionFlow flow
	
	@Before
	def void setup() throws Exception{
		flow = models.loadExecutionFlowFromResource("AlwaysOncycle.sct");
	}
		
	@Test def void resolveMembers() throws Exception {
	
		val stateMachine = interpreter.newInstance(flow)
		
		assertTrue(interpreter.heap.slots.contains(stateMachine))
		assertEquals(0L, resolve(stateMachine, "default").resolve("x").value)
		assertEquals(0L, resolve(stateMachine, "default").resolve("y").value)
		
	}
	
	@Test def void resolveDefaultMembers() throws Exception {
	
		val stateMachine = interpreter.newInstance(flow)
		
		assertTrue(interpreter.heap.slots.contains(stateMachine))
		assertEquals(0L, resolve(stateMachine, "x").value)
		assertEquals(0L, resolve(stateMachine, "y").value)
				
	}


	@Test def void initMembers() throws Exception {
	
		val stateMachine = interpreter.newInstance(flow)
		
		stateMachine._invoke("init")
		
		assertTrue(interpreter.heap.slots.contains(stateMachine))
		assertEquals(42L, resolve(stateMachine, "value").value)
		assertEquals(3.14, resolve(stateMachine, "pi").value)				
	}

	@Test def void enter() throws Exception {
	
		val stateMachine = interpreter.newInstance(flow)
		
		stateMachine._invoke("init")
		stateMachine._invoke("enter")

		assertTrue(interpreter.heap.slots.contains(stateMachine))
		assertEquals(0L, resolve(stateMachine, "value").value)
		assertEquals(3.14, resolve(stateMachine, "pi").value)				
		
		stateMachine._invoke("runCycle")
		
	}

	@Test def void runCycle() throws Exception {
	
		val stateMachine = interpreter.newInstance(flow)
		
		stateMachine._invoke("init")
		stateMachine._invoke("enter")
		stateMachine._invoke("runCycle")

		assertTrue(interpreter.heap.slots.contains(stateMachine))
		assertEquals(0L, resolve(stateMachine, "value").value)
		assertEquals(3.14, resolve(stateMachine, "pi").value)				
				
	}

	
}