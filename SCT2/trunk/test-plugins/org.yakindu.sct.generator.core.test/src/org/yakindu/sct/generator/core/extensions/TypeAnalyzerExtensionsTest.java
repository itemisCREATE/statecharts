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
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypesPackage;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.stext.stext.StextPackage;

public class TypeAnalyzerExtensionsTest {

	private Object call(String methodName, Object... params) {

		TypeSystemImpl ts = new TypeSystemImpl();
		ts.registerMetaModel(new EmfMetaModel(BasePackage.eINSTANCE));
		ts.registerMetaModel(new EmfMetaModel(TypesPackage.eINSTANCE));
		ts.registerMetaModel(new EmfMetaModel(SGraphPackage.eINSTANCE));
		ts.registerMetaModel(new EmfMetaModel(StextPackage.eINSTANCE));

		ExecutionContext ctx = new ExecutionContextImpl(ts);
		XtendFacade facade = XtendFacade
				.create(ctx,
						"org::yakindu::sct::generator::core::extensions::TypeAnalyzerExtensions");
		Object result = facade.call(methodName, params);
		return result;
	}

	@Test
	public void testIsVoid() {
		Object result = call("isVoid", new Object[] { null });
		assertEquals(Boolean.TRUE, result);

		Type type = _createVoidType("void");
		result = call("isVoid", type);
		assertEquals(Boolean.TRUE, result);

		type.setName("void");
		result = call("isVoid", type);
		assertEquals(Boolean.TRUE, result);

		type.setName("String");
		result = call("isVoid", type);
		assertEquals(Boolean.FALSE, result);
	}

}
