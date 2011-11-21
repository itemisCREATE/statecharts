package org.yakindu.sct.model.sexec.transformation.test;

import static org.junit.Assert.assertSame;

import org.yakindu.sct.model.sexec.Call;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.Step;


public class Assert {

	public static void assertCall(Sequence seq, int pos, Step target) {
		Call call = (Call) seq.getSteps().get(pos);
		assertSame(target, call.getStep());		
	}
	

}
