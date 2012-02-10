package org.yakindu.sct.runtime.java.test_expression;

import org.yakindu.sct.runtime.java.ValuedEvent;

public interface IDefaultIterfaceImpl extends DefaultInterface {

	public ValuedEvent<Events, Integer> getEventEvent1();
	
	public void raiseEvent2(double value);
}
