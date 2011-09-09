import static org.fornax.utilities.xtendtools.xunit.XtendUnit.xtend;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtend.typesystem.emf.EmfRegistryMetaModel;
import org.fornax.utilities.xtendtools.xunit.XtendUnit;
import org.junit.Before;
import org.junit.Test;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.Variable;
import org.yakindu.sct.model.stext.stext.Assignment;
import org.yakindu.sct.model.stext.stext.AssignmentOperator;
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.stext.VariableDefinition;
import static org.junit.Assert.*;

public class ExpressionTest {

	@Before
	public void setUp() throws Exception {
		XtendUnit.initXtend(new EmfRegistryMetaModel());
	}

	@Test
	public void test() {
		List l = new ArrayList();
		
		VariableDefinition value = StextFactory.eINSTANCE.createVariableDefinition();
		value.setName("myVariable");
		PrimitiveValueExpression value2 = StextFactory.eINSTANCE.createPrimitiveValueExpression();
		value2.setValue("14");
		Assignment assignment = StextFactory.eINSTANCE.createAssignment();
		assignment.setOperator(AssignmentOperator.ADD_ASSIGN);
		assignment.setVarRef(value);
		assignment.setExpression(value2);
		l.add(assignment);
		l.add("myObject");

		assertEquals("myObject.myVariable += (14);", xtend("org::yakindu::sct::generator::cpp::templates::Expression", "toCppCode", l));
//		System.out.println();
	}

}
