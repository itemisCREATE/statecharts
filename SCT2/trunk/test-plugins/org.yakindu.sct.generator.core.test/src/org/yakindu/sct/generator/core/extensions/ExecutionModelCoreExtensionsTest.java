package org.yakindu.sct.generator.core.extensions;

import static org.yakindu.sct.model.stext.test.util.StextTestFactory.*;

import static org.junit.Assert.*;
import org.eclipse.xtend.XtendFacade;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.ExecutionContextImpl;
import org.eclipse.xtend.expression.TypeSystemImpl;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;
import org.junit.Test;
import org.yakindu.base.base.BasePackage;
import org.yakindu.base.types.TypesPackage;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.stext.stext.Direction;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.StextPackage;

public class ExecutionModelCoreExtensionsTest {

	private Object call(String methodName, Object... params) {

		TypeSystemImpl ts = new TypeSystemImpl();
		ts.registerMetaModel(new EmfMetaModel(BasePackage.eINSTANCE));
		ts.registerMetaModel(new EmfMetaModel(TypesPackage.eINSTANCE));
		ts.registerMetaModel(new EmfMetaModel(SGraphPackage.eINSTANCE));
		ts.registerMetaModel(new EmfMetaModel(StextPackage.eINSTANCE));

		ExecutionContext ctx = new ExecutionContextImpl(ts);
		XtendFacade facade = XtendFacade
				.create(ctx,
						"org::yakindu::sct::generator::core::extensions::ExecutionModelCoreExtensions");
		Object result = facade.call(methodName, params);
		return result;
	}

	@Test
	public void testHasOutgoingVoidEvents() {
		InterfaceScope scope = _createInterfaceScope("if", null);

		Object result = call("hasOutgoingVoidEvents", scope);
		assertEquals(Boolean.FALSE, result);

		EventDefinition eventDefinition = _createEventDefinition("e1", scope);
		eventDefinition.setDirection(Direction.OUT);
		result = call("hasOutgoingVoidEvents", scope);
		assertEquals(Boolean.TRUE, result);

		eventDefinition.setType(_createStringType("string"));
		result = call("hasOutgoingVoidEvents", scope);
		assertEquals(Boolean.FALSE, result);
	}

	@Test
	public void testHasOutgoingValuedEvents() {
		InterfaceScope scope = _createInterfaceScope("if", null);

		Object result = call("hasOutgoingValuedEvents", scope);
		assertEquals(Boolean.FALSE, result);

		EventDefinition eventDefinition = _createEventDefinition("e1", scope);
		eventDefinition.setDirection(Direction.OUT);
		result = call("hasOutgoingValuedEvents", scope);
		assertEquals(Boolean.FALSE, result);

		eventDefinition.setType(_createStringType("string"));
		result = call("hasOutgoingValuedEvents", scope);
		assertEquals(Boolean.TRUE, result);
	}

}
