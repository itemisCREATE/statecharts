package org.yakindu.sct.generator.java.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.yakindu.src.operationcallbackimpl.InterfaceOCBImpl;
import org.yakindu.src.operationcallbackimpl.InternalOCBImpl;
import org.yakindu.src.operationcallbackimpl.NamedInterfaceOCBImpl;
import org.yakindu.src.operationcallbackimpl.OperationCallbackImplStatemachine;
import org.yakindu.src.operationcallbackimpl.OperationCallbackImplStatemachine.State;

public class UnimplementedOCBTest {

	private OperationCallbackImplStatemachine statemachine;

	@Rule
	public ExpectedException exceptions = ExpectedException.none();

	@Before
	public void setUp() {
		statemachine = new OperationCallbackImplStatemachine();
	}

	@Test
	public void testUnimplementedInternal() throws IllegalStateException {
		exceptions.expect(IllegalStateException.class);
		exceptions.expectMessage("Operation callback for internal must be set.");
		statemachine.init();

	}

	@Test
	public void testUnimplementedInterfacce() {
		statemachine.setInternalOperationCallback(new InternalOCBImpl());
		exceptions.expect(IllegalStateException.class);
		exceptions.expectMessage("Operation callback for interface sCInterface must be set.");
		statemachine.init();
	}

	@Test
	public void testUnimplementedNamedInterface() {
		statemachine.setInternalOperationCallback(new InternalOCBImpl());
		statemachine.getSCInterface().setSCInterfaceOperationCallback(new InterfaceOCBImpl());
		exceptions.expect(IllegalStateException.class);
		exceptions.expectMessage("Operation callback for interface sCINamed must be set.");
		statemachine.init();
	}

	@Test
	public void testImplementedOCBs() {
		statemachine.setInternalOperationCallback(new InternalOCBImpl());
		statemachine.getSCInterface().setSCInterfaceOperationCallback(new InterfaceOCBImpl());
		statemachine.getSCINamed().setSCINamedOperationCallback(new NamedInterfaceOCBImpl());
		statemachine.init();
		statemachine.enter();

		assertTrue(statemachine.isStateActive(State.main_region_StateA));
	}
}
